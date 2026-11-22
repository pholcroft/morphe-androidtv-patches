# Patch BBC iPlayer for Android TV 1.0.1

The patch **Make iPlayer 1.0.1 work on more TVs** targets the Android TV build `1.0.1` (version code `101`) of `bbc.iplayer.android`. It lets the app start on Android TV devices missing the BBC TV feature flag and uses the Google TV Streamer profile in the app's browser. The target device needs Android 12 or later. This is an unofficial compatibility patch for use in the UK. BBC sign-in, geographic checks and DRM still apply.

## Phone walkthroughs

1. [Download the APK with Aurora Store](walkthroughs/README.md)
2. [Patch and save the APK with Morphe Manager](walkthroughs/morphe-phone/README.md)

## Download the Android TV APK

1. Install [Aurora Store](https://auroraoss.com/) on your Android phone and save the [Google TV Streamer device profile](google-tv-streamer-kirkwood.properties) as a `.properties` file.
2. In Aurora Store, open **Spoof manager** or **Spoofing**. Use the import button to select the file, then select **Google TV Streamer (kirkwood) - experimental**. If the app list stays the same after switching, sign out of Aurora and sign back in so it refreshes the device profile.
3. Search for **BBC iPlayer**. Check that the version is **1.0.1**. The phone app has the same package name, so the version matters. The profile was used successfully to obtain this version in the UK. Google Play controls availability and may offer a different build.
4. Tap **Install** in Aurora to start the download. When the Android installation prompt opens, cancel it. Go back to Aurora's **Downloads** screen, press and hold the completed download, then choose **Export**.
5. Follow [Part 1](walkthroughs/README.md) to rename Aurora's ZIP to `.apks`. Copy the `.apks` file to your computer for Morphe Desktop.

## Patch and install

1. In [Morphe Desktop](https://github.com/MorpheApp/morphe-desktop), add the patch source or load the local `.mpp` patch file. Select your `.apks` file. Morphe Desktop merges the APKs before patching. See the [Morphe Desktop documentation](https://github.com/MorpheApp/morphe-desktop/blob/main/docs/documentation.md).
2. Enable **Make iPlayer 1.0.1 work on more TVs**.
3. Run Morphe and install the resulting APK on your TV. Open the app and use the normal BBC sign-in flow. For an initial test, try an on-demand episode and a live channel.

The equivalent command in Morphe Desktop 2.3.0 is below. Put the JAR, [preview patch file](preview/bbc-iplayer-1.0.1.mpp) and downloaded `.apks` file in the same folder.

```text
java -jar morphe-desktop-2.3.0.jar patch --exclusive --patches bbc-iplayer-1.0.1.mpp --enable "Make iPlayer 1.0.1 work on more TVs" --out iplayer-patched.apk bbc.iplayer.android.apks
```

Version 1.0.1 launched, signed in and started video playback on a Thomson Streaming Box Plus 270 alongside the legacy build. The Thomson catalogue showed UHD badges. Actual UHD stream resolution and live TV playback are still unverified.
