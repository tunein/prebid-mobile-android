package org.prebid.mobile.xandr.rendering.listeners;

import org.jetbrains.annotations.NotNull;
import org.prebid.mobile.xandr.api.data.InitializationStatus;

public interface SdkInitializationListener {

    void onInitializationComplete(@NotNull InitializationStatus status);

}
