package org.prebid.mobile.xandr;

import org.json.JSONObject;

public interface PrebidEventDelegate {

    void onBidResponse(JSONObject request, JSONObject response);

}
