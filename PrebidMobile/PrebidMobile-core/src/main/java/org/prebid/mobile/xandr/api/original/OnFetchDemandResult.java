package org.prebid.mobile.xandr.api.original;

import androidx.annotation.NonNull;

import org.prebid.mobile.xandr.api.data.BidInfo;

/**
 * Fetch demand listener for original API {@link PrebidAdUnit}.
 */
public interface OnFetchDemandResult {

    void onComplete(@NonNull BidInfo bidInfo);

}
