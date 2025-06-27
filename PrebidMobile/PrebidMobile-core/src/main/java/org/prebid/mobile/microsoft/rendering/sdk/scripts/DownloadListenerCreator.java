package org.prebid.mobile.microsoft.rendering.sdk.scripts;

import org.prebid.mobile.microsoft.rendering.loading.FileDownloadListener;

public interface DownloadListenerCreator {

    FileDownloadListener create(String filePath);

}
