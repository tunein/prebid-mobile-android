package org.prebid.mobile.microsoft.api.original;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;
import org.prebid.mobile.microsoft.OnCompleteListener;
import org.prebid.mobile.microsoft.ResultCode;
import org.prebid.mobile.microsoft.Util;
import org.prebid.mobile.microsoft.api.data.BidInfo;

/**
 * Listener implementation for multiformat PrebidAdUnit.
 */
class OnCompleteListenerImpl implements OnCompleteListener, OnFetchDemandResult {

    @Nullable
    private final Object adObject;
    @NonNull
    private final MultiformatAdUnitFacade adUnit;
    @NonNull
    private final OnFetchDemandResult listener;

    OnCompleteListenerImpl(
            @NonNull MultiformatAdUnitFacade adUnit,
            @Nullable Object adObject,
            @NonNull OnFetchDemandResult listener
    ) {
        this.adObject = adObject;
        this.adUnit = adUnit;
        this.listener = listener;
    }

    @Override
    public void onComplete(ResultCode resultCode) {
        notifyListener(resultCode);
    }

    @Override
    public void onComplete(@NonNull @NotNull BidInfo bidInfo) {
        notifyListener(bidInfo.getResultCode());
    }


    private void notifyListener(ResultCode resultCode) {
        BidInfo bidInfo = BidInfo.create(resultCode, adUnit.getBidResponse(), adUnit.getConfiguration());
        Util.saveCacheId(bidInfo.getNativeCacheId(), adObject);
        listener.onComplete(bidInfo);
    }
}
