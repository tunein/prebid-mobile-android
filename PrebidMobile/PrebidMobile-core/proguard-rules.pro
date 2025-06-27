# Save names for all Prebid classes
-keepnames class org.prebid.mobile.microsoft.**
-keepnames interface org.prebid.mobile.microsoft.**
-keepnames enum org.prebid.mobile.microsoft.**

# Google Ad Manager and AdMob
-keep class org.prebid.mobile.microsoft.PrebidNativeAd { *; }
-keep class com.google.android.gms.ads.admanager.AdManagerAdView { *; }
-keep class com.google.android.gms.ads.admanager.AdManagerAdRequest { *; }
-keep class com.google.android.gms.ads.admanager.AdManagerAdRequest$Builder { *; }
-keep interface com.google.android.gms.ads.nativead.NativeCustomFormatAd { *; }
-keep interface com.google.android.gms.ads.formats.NativeCustomTemplateAd { *; }
