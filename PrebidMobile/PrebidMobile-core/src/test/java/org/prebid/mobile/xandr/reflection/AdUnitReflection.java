package org.prebid.mobile.xandr.reflection;

import org.prebid.mobile.xandr.AdUnit;
import org.prebid.mobile.xandr.rendering.bidding.loader.BidLoader;

public class AdUnitReflection {

    public static void setBidLoader(AdUnit adUnit, BidLoader bidLoader) {
        Reflection.setVariableTo(adUnit, "bidLoader", bidLoader);
    }

}
