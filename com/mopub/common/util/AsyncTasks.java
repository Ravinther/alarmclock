package com.mopub.common.util;

import android.os.AsyncTask;
import android.os.Looper;
import com.mopub.common.util.Reflection.MethodBuilder;
import java.util.concurrent.Executor;

public class AsyncTasks {
    public static void safeExecuteOnExecutor(AsyncTask asyncTask, Object... params) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("Unable to execute null AsyncTask.");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("AsyncTask must be executed on the main thread");
        } else if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
            try {
                new MethodBuilder(asyncTask, "executeOnExecutor").addParam(Executor.class, (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(AsyncTask.class)).addParam(Object[].class, params).execute();
            } catch (Exception e) {
                asyncTask.execute(params);
            }
        } else {
            asyncTask.execute(params);
        }
    }
}
