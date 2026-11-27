package ajstrick81.morphe.patches.bbciplayer.compatibility

import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility
import app.morphe.patcher.patch.bytecodePatch
import com.android.tools.smali.dexlib2.Opcode
import com.android.tools.smali.dexlib2.builder.instruction.BuilderInstruction11n
import com.android.tools.smali.dexlib2.builder.instruction.BuilderInstruction21c
import com.android.tools.smali.dexlib2.iface.instruction.FiveRegisterInstruction
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction
import com.android.tools.smali.dexlib2.iface.instruction.ReferenceInstruction
import com.android.tools.smali.dexlib2.iface.reference.MethodReference
import com.android.tools.smali.dexlib2.immutable.reference.ImmutableStringReference

// Google TV Streamer (X3) profile tested on the Thomson Streaming Box Plus 270.
// Keep the Chrome/83 token used by the stock 1.0.1 wrapper.
private const val STREAMER_USER_AGENT =
    "Mozilla/5.0 (Linux; Android 14; X3 Build/UTTK.260317.003; wv-atv; mse) Google/1.0.1 " +
        "AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/83.0.4103.106 Mobile Safari/537.36"

@Suppress("unused")
val bbcIPlayerStreamerCompatibilityPatch = bytecodePatch(
    name = "Make iPlayer 1.0.1 work on more TVs",
    description = "Lets iPlayer 1.0.1 (build 101) start on TVs without the BBC TV feature flag " +
        "and uses the Google TV Streamer profile in its WebView. Use a complete stock export of the Android TV build. " +
        "For use in the UK. Geographic checks and DRM still apply.",
    default = false,
) {
    compatibleWith(
        Compatibility(
            name = "BBC iPlayer (Android TV)",
            packageName = "bbc.iplayer.android",
            targets = listOf(AppTarget("1.0.1", isExperimental = true, minSdk = 31)),
        ),
    )

    execute {
        val requirements = mutableClassDefBy("Lexternal/androidtv/features/hardwarerequirements/HwRequirement;")
        val check = requirements.methods.single { it.name == "checkBbcFeature" && it.returnType == "Z" }
        val checkBody = check.implementation!!
        val featureCalls = checkBody.instructions.count { instruction ->
            val call = (instruction as? ReferenceInstruction)?.reference as? MethodReference
            call?.definingClass == "Landroid/content/pm/PackageManager;" && call.name == "hasSystemFeature"
        }
        val result = checkBody.instructions.last()
        check(featureCalls == 1 && result.opcode == Opcode.RETURN && result is OneRegisterInstruction) {
            "The iPlayer 1.0.1 BBC TV feature check did not match"
        }

        val activity = mutableClassDefBy("Lexternal/androidtv/psbwrapper/MainActivity;")
        val activityBody = activity.methods.single { it.name == "onCreate" }.implementation!!
        val userAgentSetters = activityBody.instructions.mapIndexedNotNull { index, instruction ->
            val call = (instruction as? ReferenceInstruction)?.reference as? MethodReference
            val registers = instruction as? FiveRegisterInstruction
            if (call?.definingClass == "Landroid/webkit/WebSettings;" && call.name == "setUserAgentString" &&
                registers?.registerCount == 2
            ) index to registers.registerD else null
        }
        check(userAgentSetters.size == 4) { "The iPlayer 1.0.1 WebView user-agent setters did not match" }

        checkBody.addInstruction(
            checkBody.instructions.lastIndex,
            BuilderInstruction11n(Opcode.CONST_4, result.registerA, 1),
        )
        for ((index, register) in userAgentSetters.asReversed()) {
            activityBody.addInstruction(
                index,
                BuilderInstruction21c(Opcode.CONST_STRING, register, ImmutableStringReference(STREAMER_USER_AGENT)),
            )
        }
    }
}
