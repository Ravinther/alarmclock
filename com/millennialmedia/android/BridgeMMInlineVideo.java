package com.millennialmedia.android;

import java.util.HashMap;
import java.util.concurrent.Callable;

class BridgeMMInlineVideo extends MMJSObject {

    /* renamed from: com.millennialmedia.android.BridgeMMInlineVideo.1 */
    class C24471 implements Callable {
        final /* synthetic */ HashMap val$parameters;

        C24471(HashMap hashMap) {
            this.val$parameters = hashMap;
        }

        public MMJSResponse call() {
            MMWebView mmWebView = (MMWebView) BridgeMMInlineVideo.this.mmWebViewRef.get();
            if (mmWebView == null) {
                return MMJSResponse.responseWithError();
            }
            MMLayout mmLayout = mmWebView.getMMLayout();
            mmLayout.initInlineVideo(new InlineParams(this.val$parameters, mmWebView.getContext()));
            return MMJSResponse.responseWithSuccess("usingStreaming=" + mmLayout.isVideoPlayingStreaming());
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMInlineVideo.2 */
    class C24482 implements Callable {
        C24482() {
        }

        public MMJSResponse call() {
            MMWebView webView = (MMWebView) BridgeMMInlineVideo.this.mmWebViewRef.get();
            if (webView != null) {
                MMLayout mmLayout = webView.getMMLayout();
                if (mmLayout != null) {
                    mmLayout.removeVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMInlineVideo.3 */
    class C24493 implements Callable {
        C24493() {
        }

        public MMJSResponse call() {
            MMWebView webView = (MMWebView) BridgeMMInlineVideo.this.mmWebViewRef.get();
            if (webView != null) {
                MMLayout mmLayout = webView.getMMLayout();
                if (mmLayout != null) {
                    mmLayout.playVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMInlineVideo.4 */
    class C24504 implements Callable {
        final /* synthetic */ HashMap val$parameters;

        C24504(HashMap hashMap) {
            this.val$parameters = hashMap;
        }

        public MMJSResponse call() {
            MMWebView webView = (MMWebView) BridgeMMInlineVideo.this.mmWebViewRef.get();
            if (webView == null || webView == null || !webView.getMMLayout().adjustVideo(new InlineParams(this.val$parameters, webView.getContext()))) {
                return MMJSResponse.responseWithError();
            }
            return MMJSResponse.responseWithSuccess();
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMInlineVideo.5 */
    class C24515 implements Callable {
        C24515() {
        }

        public MMJSResponse call() {
            MMWebView webView = (MMWebView) BridgeMMInlineVideo.this.mmWebViewRef.get();
            if (webView != null) {
                MMLayout mmLayout = webView.getMMLayout();
                if (mmLayout != null) {
                    mmLayout.stopVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMInlineVideo.6 */
    class C24526 implements Callable {
        C24526() {
        }

        public MMJSResponse call() {
            MMWebView webView = (MMWebView) BridgeMMInlineVideo.this.mmWebViewRef.get();
            if (webView != null) {
                MMLayout mmLayout = webView.getMMLayout();
                if (mmLayout != null) {
                    mmLayout.pauseVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMInlineVideo.7 */
    class C24537 implements Callable {
        C24537() {
        }

        public MMJSResponse call() {
            MMWebView webView = (MMWebView) BridgeMMInlineVideo.this.mmWebViewRef.get();
            if (webView != null) {
                MMLayout mmLayout = webView.getMMLayout();
                if (mmLayout != null) {
                    mmLayout.resumeVideo();
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMInlineVideo.8 */
    class C24548 implements Callable {
        final /* synthetic */ HashMap val$parameters;

        C24548(HashMap hashMap) {
            this.val$parameters = hashMap;
        }

        public MMJSResponse call() {
            MMWebView webView = (MMWebView) BridgeMMInlineVideo.this.mmWebViewRef.get();
            if (webView != null) {
                MMLayout mmLayout = webView.getMMLayout();
                String streamVideoURI = (String) this.val$parameters.get("streamVideoURI");
                if (!(mmLayout == null || streamVideoURI == null)) {
                    mmLayout.setVideoSource(streamVideoURI);
                    return MMJSResponse.responseWithSuccess();
                }
            }
            return MMJSResponse.responseWithError();
        }
    }

    BridgeMMInlineVideo() {
    }

    public MMJSResponse insertVideo(HashMap parameters) {
        return runOnUiThreadFuture(new C24471(parameters));
    }

    public MMJSResponse removeVideo(HashMap parameters) {
        return runOnUiThreadFuture(new C24482());
    }

    public MMJSResponse playVideo(HashMap parameters) {
        return runOnUiThreadFuture(new C24493());
    }

    public MMJSResponse adjustVideo(HashMap parameters) {
        return runOnUiThreadFuture(new C24504(parameters));
    }

    public MMJSResponse stopVideo(HashMap parameters) {
        return runOnUiThreadFuture(new C24515());
    }

    public MMJSResponse pauseVideo(HashMap parameters) {
        return runOnUiThreadFuture(new C24526());
    }

    public MMJSResponse resumeVideo(HashMap parameters) {
        return runOnUiThreadFuture(new C24537());
    }

    public MMJSResponse setStreamVideoSource(HashMap parameters) {
        return runOnUiThreadFuture(new C24548(parameters));
    }
}
