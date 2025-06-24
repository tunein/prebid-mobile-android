package org.prebid.mobile.xandr.rendering.sdk.scripts;

import org.prebid.mobile.xandr.rendering.loading.FileDownloadListener;

public interface DownloadListenerCreator {

    FileDownloadListener create(String filePath);

}
