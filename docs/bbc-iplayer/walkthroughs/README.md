# Download and patch BBC iPlayer for Android TV on your phone

Have Aurora Store and [Morphe Manager](https://github.com/MorpheApp/morphe-manager) installed. Save the [Google TV Streamer profile](../google-tv-streamer-kirkwood.properties) to your phone’s Downloads folder before starting.

On your phone, press and hold the [BBC iPlayer Play listing](https://play.google.com/store/apps/details?id=bbc.iplayer.android), then choose **Share link → Aurora Store** when you reach step 3.

[Add UK TV Patches to Morphe](https://morphe.software/add-source?github=pholcroft/uk-tv-morphe-patches&name=UK%20TV%20Patches) when you reach step 8.

![Download the BBC iPlayer Android TV APK in Aurora Store and patch and save it in Morphe Manager](aurora-iplayer-walkthrough.png)

## Download the APK with Aurora Store

1. In Aurora, open the top-right menu, then **Spoof manager → Device → ⋮ → Import**. In the file picker, open **Downloads** and select the `.properties` file.
2. Select **Google TV Streamer (kirkwood) - experimental** in the device list, tap **Restart**, then choose **Anonymous** when Aurora asks you to sign in.
3. Open this guide in your phone’s browser. Press and hold the [BBC iPlayer Play listing](https://play.google.com/store/apps/details?id=bbc.iplayer.android), tap **Share link** or **Share**, then choose **Aurora Store**. You can keep Google Play as your default.
4. Check that Aurora offers **v1.0.1 (101)** directly under **British Broadcasting Corporation**. This is the Android TV version the patch supports. If you see a different version, check that the Kirkwood profile is selected.
5. Tap **Install** to download. When Android asks whether to install BBC iPlayer, tap **Cancel**. Dismiss Aurora’s follow-up message if it appears.
6. Return to Aurora’s **Apps** screen. Tap **Downloads**, press and hold the completed iPlayer row, and tap **Export**. Save `bbc.iplayer.android.zip` in **Downloads**.
7. Open **Downloads** in your file manager and rename the saved file to `bbc.iplayer.android.apks`. Android appends `.zip` when exporting on the tested setup. [Material Files, used in the animation](https://github.com/zhanghai/MaterialFiles)

## Patch and save the APK with Morphe Manager

8. Return to this guide in your phone’s browser and tap [Add UK TV Patches to Morphe](https://morphe.software/add-source?github=pholcroft/uk-tv-morphe-patches&name=UK%20TV%20Patches). If the link page opens first, tap **Open in Morphe**. In Morphe tap **Add** to confirm.
9. Go to **Settings → Expert mode** and tap **Enable** to confirm.
10. Return to **Apps** and select **BBC iPlayer (Android TV)**. Check that Morphe recommends **1.0.1, Build 101**. Tap **No, I already have it**, then select `bbc.iplayer.android.apks` in Downloads. [Morphe Expert mode documentation](https://github.com/MorpheApp/morphe-manager/blob/main/docs/patching-expert-mode.md)
11. Enable **Make iPlayer 1.0.1 work on more TVs** and tap **Patch**.
12. When patching finishes, tap the **Save** icon and save the signed APK in **Downloads**. Transfer that APK to your Android TV device.

The walkthrough uses real Android emulator captures from Aurora Store 4.8.4 and Morphe Manager 2.7.0. Aurora’s export contained `base.apk`, `config.en.apk` and `config.xhdpi.apk`. Morphe saved a signed APK with version name `1.0.1` and version code `101`.
