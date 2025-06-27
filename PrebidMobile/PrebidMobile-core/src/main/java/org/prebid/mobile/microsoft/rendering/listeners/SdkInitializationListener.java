package org.prebid.mobile.microsoft.rendering.listeners;

import org.jetbrains.annotations.NotNull;
import org.prebid.mobile.microsoft.api.data.InitializationStatus;

public interface SdkInitializationListener {

    void onInitializationComplete(@NotNull InitializationStatus status);

}
