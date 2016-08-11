package com.mopub.mobileads.factories;

import com.mopub.mobileads.VastVideoDownloadTask;
import com.mopub.mobileads.VastVideoDownloadTask.VastVideoDownloadTaskListener;

public class VastVideoDownloadTaskFactory {
    private static VastVideoDownloadTaskFactory instance;

    static {
        instance = new VastVideoDownloadTaskFactory();
    }

    @Deprecated
    public static void setInstance(VastVideoDownloadTaskFactory factory) {
        instance = factory;
    }

    public static VastVideoDownloadTask create(VastVideoDownloadTaskListener vastVideoDownloadTaskListener) {
        return instance.internalCreate(vastVideoDownloadTaskListener);
    }

    protected VastVideoDownloadTask internalCreate(VastVideoDownloadTaskListener vastVideoDownloadTaskListener) {
        return new VastVideoDownloadTask(vastVideoDownloadTaskListener);
    }
}
