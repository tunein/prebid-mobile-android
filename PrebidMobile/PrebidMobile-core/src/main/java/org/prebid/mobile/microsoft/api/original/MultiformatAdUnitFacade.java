package org.prebid.mobile.microsoft.api.original;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;
import org.prebid.mobile.microsoft.AdSize;
import org.prebid.mobile.microsoft.AdUnit;
import org.prebid.mobile.microsoft.BannerParameters;
import org.prebid.mobile.microsoft.NativeParameters;
import org.prebid.mobile.microsoft.OnCompleteListener;
import org.prebid.mobile.microsoft.ResultCode;
import org.prebid.mobile.microsoft.Util;
import org.prebid.mobile.microsoft.VideoParameters;
import org.prebid.mobile.microsoft.api.data.AdFormat;
import org.prebid.mobile.microsoft.api.exceptions.AdException;
import org.prebid.mobile.microsoft.configuration.AdUnitConfiguration;
import org.prebid.mobile.microsoft.configuration.NativeAdUnitConfiguration;
import org.prebid.mobile.microsoft.rendering.bidding.data.bid.BidResponse;
import org.prebid.mobile.microsoft.rendering.bidding.listeners.BidRequesterListener;
import org.prebid.mobile.microsoft.rendering.models.AdPosition;
import org.prebid.mobile.microsoft.rendering.models.PlacementType;

import java.util.HashMap;

/**
 * Internal AdUnit implementation that is used for PrebidAdUnit
 * with multi-format configuration. It separates logic for multi-format ad unit.
 */
class MultiformatAdUnitFacade extends AdUnit {

    @Nullable
    private BidResponse bidResponse;

    public MultiformatAdUnitFacade(@NotNull String configId, @NonNull PrebidRequest request) {
        super(configId);
        allowNullableAdObject = true;
        setConfigurationBasedOnRequest(request);
    }

    /**
     * Applies the interstitial native visibility tracker for tracking `burl` url.
     */
    public void activateInterstitialPrebidImpressionTracker() {
        this.activateInterstitialPrebidImpressionTracker = true;
    }

    @Override
    protected BidRequesterListener createBidListener(OnCompleteListener originalListener) {
        return new BidRequesterListener() {
            @Override
            public void onFetchCompleted(BidResponse response) {
                bidResponse = response;

                HashMap<String, String> keywords = response.getTargeting();
                Util.apply(keywords, adObject);

                originalListener.onComplete(ResultCode.SUCCESS);
            }

            @Override
            public void onError(AdException exception) {
                bidResponse = null;

                Util.apply(null, adObject);

                originalListener.onComplete(convertToResultCode(exception));
            }
        };
    }

    private void setConfigurationBasedOnRequest(
            @NonNull PrebidRequest request
    ) {
        if (request.isInterstitial()) {
            configuration.setAdPosition(AdPosition.FULLSCREEN);
        }

        BannerParameters bannerParameters = request.getBannerParameters();
        if (bannerParameters != null) {
            if (request.isInterstitial()) {
                configuration.addAdFormat(AdFormat.INTERSTITIAL);

                Integer minWidth = bannerParameters.getInterstitialMinWidthPercentage();
                Integer minHeight = bannerParameters.getInterstitialMinHeightPercentage();
                if (minWidth != null && minHeight != null) {
                    configuration.setMinSizePercentage(new AdSize(minWidth, minHeight));
                }
            } else {
                configuration.addAdFormat(AdFormat.BANNER);
            }

            configuration.setBannerParameters(bannerParameters);
            configuration.addSizes(bannerParameters.getAdSizes());
        }

        VideoParameters videoParameters = request.getVideoParameters();
        if (videoParameters != null) {
            configuration.addAdFormat(AdFormat.VAST);

            if (request.isInterstitial()) {
                configuration.setPlacementType(PlacementType.INTERSTITIAL);
            }
            if (request.isRewarded()) {
                configuration.setRewarded(true);
            }

            configuration.setVideoParameters(videoParameters);
            configuration.addSize(videoParameters.getAdSize());
        }

        NativeParameters nativeParameters = request.getNativeParameters();
        if (nativeParameters != null) {
            configuration.addAdFormat(AdFormat.NATIVE);

            NativeAdUnitConfiguration nativeConfig = nativeParameters.getNativeConfiguration();
            configuration.setNativeConfiguration(nativeConfig);
        }

        String gpid = request.getGpid();
        configuration.setGpid(gpid);
    }

    @Nullable
    public BidResponse getBidResponse() {
        return bidResponse;
    }

    @SuppressLint("VisibleForTests")
    @Override
    public AdUnitConfiguration getConfiguration() {
        return super.getConfiguration();
    }

}
