package org.prebid.mobile.xandr.reflection.sdk;

import org.prebid.mobile.xandr.reflection.Reflection;
import org.prebid.mobile.xandr.rendering.sdk.ManagersResolver;

public class ManagersResolverReflection {

    public static void resetManagers(ManagersResolver resolver) {
        Reflection.setVariableTo(resolver, "deviceManager", null);
        Reflection.setVariableTo(resolver, "locationManager", null);
        Reflection.setVariableTo(resolver, "connectionManager", null);
        Reflection.setVariableTo(resolver, "userConsentManager", null);
    }

}
