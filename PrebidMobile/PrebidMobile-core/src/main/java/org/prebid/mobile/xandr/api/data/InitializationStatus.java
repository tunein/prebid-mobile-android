package org.prebid.mobile.xandr.api.data;

import android.content.Context;

import androidx.annotation.Nullable;

import org.prebid.mobile.xandr.PrebidMobile;
import org.prebid.mobile.xandr.rendering.listeners.SdkInitializationListener;

/**
 * Initialization status for {@link PrebidMobile#initializeSdk(Context, SdkInitializationListener)}.
 */
public enum InitializationStatus {

    SUCCEEDED,
    SERVER_STATUS_WARNING,
    FAILED;

    @Nullable
    private String description;

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }

}
