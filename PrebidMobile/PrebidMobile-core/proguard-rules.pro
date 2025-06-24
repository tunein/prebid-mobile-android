# Save names for all Prebid classes
-keepnames class org.prebid.mobile.xandr.**
-keepnames interface org.prebid.mobile.xandr.**
-keepnames enum org.prebid.mobile.xandr.**

# Google Ad Manager and AdMob
-keep class org.prebid.mobile.xandr.PrebidNativeAd { *; }
-keep class com.google.android.gms.ads.admanager.AdManagerAdView { *; }
-keep class com.google.android.gms.ads.admanager.AdManagerAdRequest { *; }
-keep class com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder { *; }
-keep interface com.google.android.gms.ads.nativead.NativeCustomFormatAd { *; }
-keep interface com.google.android.gms.ads.formats.NativeCustomTemplateAd { *; }
