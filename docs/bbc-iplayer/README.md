# Patch BBC iPlayer for Android TV 1.0.1

The patch **Make iPlayer 1.0.1 work on more TVs** targets the Android TV build `1.0.1` (version code `101`) of `bbc.iplayer.android`. It lets the app start on Android TV devices missing the BBC TV feature flag and uses the Google TV Streamer profile in the app's browser. The target device needs Android 12 or later. This is an unofficial compatibility patch for use in the UK. BBC sign-in, geographic checks and DRM still apply.

## Phone walkthrough

[Add UK TV Patches to Morphe](https://morphe.software/add-source?github=pholcroft/uk-tv-morphe-patches&name=UK%20TV%20Patches) on an Android phone with Morphe Manager installed.

[Download, patch and save the APK on your phone](walkthroughs/README.md).

For Morphe Desktop, follow the [Aurora Store steps](walkthroughs/README.md#download-the-apk-with-aurora-store) and copy the resulting `.apks` file to your computer.

## Patch and install

1. In [Morphe Desktop](https://github.com/MorpheApp/morphe-desktop), add the patch source or load the local `.mpp` patch file. Select your `.apks` file. Morphe Desktop merges the APKs before patching. See the [Morphe Desktop documentation](https://github.com/MorpheApp/morphe-desktop/blob/main/docs/documentation.md).
2. Enable **Make iPlayer 1.0.1 work on more TVs**.
3. Run Morphe and install the resulting APK on your TV. Open the app and use the normal BBC sign-in flow. For an initial test, try an on-demand episode and a live channel.

The equivalent command in Morphe Desktop 2.3.0 is below. Put the JAR, [preview patch file](preview/bbc-iplayer-1.0.1.mpp) and downloaded `.apks` file in the same folder.

```text
java -jar morphe-desktop-2.3.0.jar patch --exclusive --patches bbc-iplayer-1.0.1.mpp --enable "Make iPlayer 1.0.1 work on more TVs" --out iplayer-patched.apk bbc.iplayer.android.apks
```

Version 1.0.1 launched, signed in and started video playback on a Thomson Streaming Box Plus 270 alongside the legacy build. The Thomson catalogue showed UHD badges. Actual UHD stream resolution and live TV playback are still unverified.
