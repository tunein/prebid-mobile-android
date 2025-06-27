package org.prebid.mobile.microsoft.reflection;

import org.prebid.mobile.microsoft.AdUnit;
import org.prebid.mobile.microsoft.rendering.bidding.loader.BidLoader;

public class AdUnitReflection {

    public static void setBidLoader(AdUnit adUnit, BidLoader bidLoader) {
        Reflection.setVariableTo(adUnit, "bidLoader", bidLoader);
    }

}
