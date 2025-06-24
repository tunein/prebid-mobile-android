package org.prebid.mobile.xandr.reflection.sdk;

import android.content.Context;

import org.mockito.Mockito;
import org.prebid.mobile.xandr.Host;
import org.prebid.mobile.xandr.PrebidMobile;
import org.prebid.mobile.xandr.reflection.Reflection;
import org.prebid.mobile.xandr.rendering.sdk.InitializationNotifier;
import org.prebid.mobile.xandr.rendering.sdk.PrebidContextHolder;

public class PrebidMobileReflection {

    public static void setHost(String host) {
        Reflection.setStaticVariableTo(PrebidMobile.class, "host", Host.createCustomHost(host));
    }

    public static void setCustomStatusEndpoint(String url) {
        Reflection.setStaticVariableTo(PrebidMobile.class, "customStatusEndpoint", url);
    }

    public static String getCustomStatusEndpoint() {
        return Reflection.getStaticFieldOf(PrebidMobile.class, "customStatusEndpoint");
    }

    public static void setFlagsThatSdkIsInitialized() {
        Reflection.setStaticVariableTo(InitializationNotifier.class, "tasksCompletedSuccessfully", true);
        Reflection.setStaticVariableTo(InitializationNotifier.class, "initializationInProgress", false);
        PrebidContextHolder.setContext(Mockito.mock(Context.class));
    }

    public static void setFlagsThatSdkIsNotInitialized() {
        Reflection.setStaticVariableTo(InitializationNotifier.class, "tasksCompletedSuccessfully", false);
        Reflection.setStaticVariableTo(InitializationNotifier.class, "initializationInProgress", false);
        PrebidContextHolder.clearContext();
    }

    public static void setDisableStatusCheckToTrue() {
        Reflection.setStaticVariableTo(PrebidMobile.class, "disableStatusCheck", true);
    }
}
