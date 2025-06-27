package org.prebid.mobile.microsoft.api.original;

import androidx.annotation.NonNull;

import org.prebid.mobile.microsoft.api.data.BidInfo;

/**
 * Fetch demand listener for original API {@link PrebidAdUnit}.
 */
public interface OnFetchDemandResult {

    void onComplete(@NonNull BidInfo bidInfo);

}
