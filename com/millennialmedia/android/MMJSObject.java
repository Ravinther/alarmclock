package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;

class MMJSObject {
    protected WeakReference contextRef;
    protected WeakReference mmWebViewRef;

    MMJSObject() {
    }

    void setContext(Context context) {
        this.contextRef = new WeakReference(context);
    }

    void setMMWebView(MMWebView webView) {
        this.mmWebViewRef = new WeakReference(webView);
    }

    AdViewOverlayActivity getBaseActivity() {
        MMWebView mmWebView = (MMWebView) this.mmWebViewRef.get();
        if (mmWebView != null) {
            Activity activity = mmWebView.getActivity();
            if (activity instanceof MMActivity) {
                MMBaseActivity baseActivity = ((MMActivity) activity).getWrappedActivity();
                if (baseActivity instanceof AdViewOverlayActivity) {
                    return (AdViewOverlayActivity) baseActivity;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.millennialmedia.android.MMJSResponse runOnUiThreadFuture(java.util.concurrent.Callable r4) {
        /*
        r3 = this;
        r1 = new java.util.concurrent.FutureTask;
        r1.<init>(r4);
        com.millennialmedia.android.MMSDK.runOnUiThread(r1);
        r2 = r1.get();	 Catch:{ InterruptedException -> 0x000f, ExecutionException -> 0x0015 }
        r2 = (com.millennialmedia.android.MMJSResponse) r2;	 Catch:{ InterruptedException -> 0x000f, ExecutionException -> 0x0015 }
    L_0x000e:
        return r2;
    L_0x000f:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0013:
        r2 = 0;
        goto L_0x000e;
    L_0x0015:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.android.MMJSObject.runOnUiThreadFuture(java.util.concurrent.Callable):com.millennialmedia.android.MMJSResponse");
    }

    long getAdImplId(String creatorAdImplId) {
        if (creatorAdImplId != null) {
            return (long) Float.parseFloat(creatorAdImplId);
        }
        return -4;
    }
}
