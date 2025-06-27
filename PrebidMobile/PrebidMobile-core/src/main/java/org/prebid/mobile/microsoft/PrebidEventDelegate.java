package org.prebid.mobile.microsoft;

import org.json.JSONObject;

public interface PrebidEventDelegate {

    void onBidResponse(JSONObject request, JSONObject response);

}
