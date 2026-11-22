# Part 1. Download the BBC iPlayer Android TV bundle with Aurora

Start at Aurora Store’s **Apps** screen with Aurora already installed and set up. Save the [Google TV Streamer profile](https://github.com/pholcroft/morphe-androidtv-patches/blob/feat/bbc-iplayer-1.0.1-preview/docs/bbc-iplayer/google-tv-streamer-kirkwood.properties) to your phone’s Downloads folder before starting.

![Aurora Store 4.8.4 on Android showing profile import, the BBC iPlayer 1.0.1 listing and export of its three APKs to a ZIP](aurora-iplayer-walkthrough.png)

1. In Aurora, open the top-right menu, then **Spoof manager → Device → ⋮ → Import**. In the file picker, open **Downloads** and select the `.properties` file.
2. Select **Google TV Streamer (kirkwood) - experimental** in the device list. Tap **Restart** when prompted, then sign in again.
3. **Method 1. Search in Aurora.** Sign in to Aurora with your UK Google account and search for **BBC iPlayer**. A UK account may help because Aurora’s anonymous accounts can have different Play Store regions. [Aurora Store FAQ](https://auroraoss.com/wiki)

   **Method 2. Open the listing directly.** If search misses iPlayer, open the [exact Play listing](https://play.google.com/store/apps/details?id=bbc.iplayer.android) with Aurora Store. If Android keeps opening Play Store, check **Settings → Apps → Aurora Store → Open by default** for supported links. The animation shows this route with an anonymous session.
4. Tap **Install** to download. If Aurora prompts for installer permission, grant it to Aurora and return to the listing. When Android asks whether to install BBC iPlayer, tap **Cancel**. Dismiss Aurora’s follow-up message if it appears.
5. Return to Aurora’s **Apps** screen. Tap **Downloads**, long-press the completed iPlayer row and tap **Export**. Save `bbc.iplayer.android.zip`.
6. Confirm the ZIP includes `base.apk`, `config.en.apk` and `config.xhdpi.apk`. Continue with [Part 2. Patch the bundle on your phone](morphe-phone/README.md), or copy the ZIP to your computer and rename it to `.apks` for Morphe Desktop. [Morphe Desktop split bundle documentation](https://github.com/MorpheApp/morphe-desktop/blob/main/docs/documentation.md)

## Check the version before downloading

Aurora shows the version directly under **British Broadcasting Corporation** on the listing. In **v1.0.1 (101)**, `1.0.1` is the version name and `101` is Android’s version code. For a later build, read the new code beside its version name and check the patch’s supported versions in Morphe or the patch README. Use a bundle that your chosen patch explicitly supports.

The animation uses real Android emulator captures with a simulated touch marker. The successful export contained the same three APKs as the bundle used to test the Morphe patch.
