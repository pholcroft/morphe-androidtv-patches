# Patch BBC iPlayer for Android TV 1.0.1

The patch **Make iPlayer 1.0.1 work on more TVs** targets the Android TV build `1.0.1` (version code `101`) of `bbc.iplayer.android`. It lets the app start on Android TV devices missing the BBC TV feature flag and uses the Google TV Streamer profile in the app's browser. The target device needs Android 12 or later. This is an unofficial compatibility patch for use in the UK. BBC sign-in, geographic checks and DRM still apply.

## Download the Android TV bundle

1. Install [Aurora Store](https://auroraoss.com/) on your Android phone and save the [Google TV Streamer device profile](google-tv-streamer-kirkwood.properties) as a `.properties` file.
2. In Aurora Store, open **Spoof manager** or **Spoofing**. Use the import button to select the file, then select **Google TV Streamer (kirkwood) - experimental**. If the app list stays the same after switching, sign out of Aurora and sign back in so it refreshes the device profile.
3. Search for **BBC iPlayer**. Check that the version is **1.0.1**. The phone app has the same package name, so the version matters. The profile was used successfully to obtain this version in the UK. Google Play controls availability and may offer a different build.
4. Tap **Install** in Aurora to start the download. When the Android installation prompt opens, cancel it. Go back to Aurora's **Downloads** screen. Long-press the completed download, choose **Export app bundle**, and save it. The [Aurora Store FAQ](https://auroraoss.com/wiki) documents bundle export.
5. Copy the export to your computer. The tested archive contained `base.apk`, `config.en.apk` and `config.xhdpi.apk`. Keep the APKs together. If Aurora saved an ordinary `.zip` containing the APKs at its top level, rename the file extension to `.apks` for Morphe Desktop.

## Patch and install

1. In [Morphe Desktop](https://github.com/MorpheApp/morphe-desktop), add the patch source or load the local `.mpp` bundle containing this patch. Select your `.apks` file. Morphe Desktop merges the splits before patching. See the [Morphe Desktop documentation](https://github.com/MorpheApp/morphe-desktop/blob/main/docs/documentation.md).
2. Enable **Make iPlayer 1.0.1 work on more TVs**. For a side-by-side install with another iPlayer build, also add the [official Morphe patch bundle](https://github.com/MorpheApp/morphe-patches/releases/tag/v2.3.0), enable **Clone app**, and set its **Package name** to `bbc.iplayer.android.tvtest`.
3. Run Morphe and install the resulting APK on your TV. Open the app and use the normal BBC sign-in flow. For an initial test, try an on-demand episode and a live channel.

The equivalent command in Morphe Desktop 2.3.0 is below. Put the JAR, both patch bundles and the exported APK bundle in the same folder. Use the local `bbc-iplayer-1.0.1.mpp` or substitute the name of a patch bundle containing **Make iPlayer 1.0.1 work on more TVs**.

```text
java -jar morphe-desktop-2.3.0.jar patch --exclusive --patches bbc-iplayer-1.0.1.mpp --enable "Make iPlayer 1.0.1 work on more TVs" --patches patches-2.3.0.mpp --options packageName=bbc.iplayer.android.tvtest --enable "Clone app" --out iplayer-tvtest.apk iplayer-stock.apks
```

Version 1.0.1 launched, signed in and started video playback on a Thomson Streaming Box Plus 270 alongside the legacy build. The Thomson catalogue showed UHD badges. Actual UHD stream resolution and live TV playback are still unverified.
