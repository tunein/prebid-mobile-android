package org.prebid.mobile.admob;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdView;

import org.prebid.mobile.microsoft.LogUtil;
import org.prebid.mobile.microsoft.rendering.bidding.data.bid.BidResponse;
import org.prebid.mobile.microsoft.rendering.bidding.display.PrebidMediationDelegate;
import org.prebid.mobile.microsoft.rendering.models.internal.VisibilityTrackerOption;
import org.prebid.mobile.microsoft.rendering.models.ntv.NativeEventTracker;
import org.prebid.mobile.microsoft.rendering.utils.helpers.VisibilityChecker;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Banner mediation delegate.
 */
public class AdMobMediationBannerUtils implements PrebidMediationDelegate {

    private static final String TAG = "BannerMediationUtils";

    private final Bundle extras;
    private final WeakReference<AdView> adView;

    public AdMobMediationBannerUtils(
        Bundle adMobExtrasBundle,
        AdView adView
    ) {
        this.extras = adMobExtrasBundle;
        this.adView = new WeakReference<>(adView);
    }

    @Override
    public void setResponseToLocalExtras(@Nullable BidResponse response) {
        if (response != null) {
            extras.putString(PrebidBannerAdapter.EXTRA_RESPONSE_ID, response.getId());
        }
    }

    @Override
    public boolean canPerformRefresh() {
        AdView view = adView.get();
        if (view == null) {
            LogUtil.error(TAG, "AdView is null, it can be destroyed as WeakReference");
            return false;
        }

        final VisibilityTrackerOption visibilityTrackerOption = new VisibilityTrackerOption(NativeEventTracker.EventType.IMPRESSION);
        final VisibilityChecker checker = new VisibilityChecker(visibilityTrackerOption);

        boolean isVisible = checker.isVisibleForRefresh(view);
        if (isVisible) {
            Log.d(TAG, "Visibility checker result: " + true);
        } else {
            Log.e(TAG, "Can't perform refresh. Ad view is not visible.");
        }

        return isVisible;
    }

    @Override
    public void handleKeywordsUpdate(@Nullable HashMap<String, String> keywords) {

    }

}
