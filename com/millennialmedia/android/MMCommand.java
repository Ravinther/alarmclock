package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MMCommand implements Runnable {
    private Map arguments;
    private String callback;
    private Class cls;
    private Method method;
    private WeakReference webViewRef;

    /* renamed from: com.millennialmedia.android.MMCommand.1 */
    class C24781 implements Runnable {
        final /* synthetic */ String val$call;
        final /* synthetic */ MMWebView val$webViewCallback;

        C24781(MMWebView mMWebView, String str) {
            this.val$webViewCallback = mMWebView;
            this.val$call = str;
        }

        public void run() {
            if (MMCommand.this.method.getName().equals("expandWithProperties")) {
                this.val$webViewCallback.isExpanding = true;
            }
            this.val$webViewCallback.loadUrl(this.val$call);
        }
    }

    /* renamed from: com.millennialmedia.android.MMCommand.2 */
    class C24792 implements Runnable {
        final /* synthetic */ String val$call;
        final /* synthetic */ MMWebView val$webViewCallback;

        C24792(MMWebView mMWebView, String str) {
            this.val$webViewCallback = mMWebView;
            this.val$call = str;
        }

        public void run() {
            this.val$webViewCallback.loadUrl(this.val$call);
        }
    }

    boolean isResizeCommand() {
        if (this.method != null) {
            return "resize".equals(this.method.getName());
        }
        return false;
    }

    MMCommand(MMWebView webView, String uriString) {
        this.webViewRef = new WeakReference(webView);
        try {
            String[] components = Uri.parse(uriString).getHost().split("\\.");
            if (components.length >= 2) {
                String className = components[components.length - 2];
                String methodName = components[components.length - 1];
                this.arguments = new HashMap();
                for (String param : uriString.substring(uriString.indexOf(63) + 1).split("&")) {
                    String[] subComponents = param.split("=");
                    if (subComponents.length >= 2) {
                        this.arguments.put(Uri.decode(subComponents[0]), Uri.decode(subComponents[1]));
                        if (subComponents[0].equalsIgnoreCase("callback")) {
                            this.callback = Uri.decode(subComponents[1]);
                        }
                    }
                }
                this.cls = Class.forName("com.millennialmedia.android.Bridge" + className);
                this.method = this.cls.getMethod(methodName, new Class[]{this.arguments.getClass()});
            }
        } catch (Exception e) {
            Log.m9715e("Exception while executing javascript call %s %s", uriString, e.getMessage());
            e.printStackTrace();
        }
    }

    public void run() {
        String call;
        if (this.cls != null && this.method != null) {
            try {
                MMWebView webView = (MMWebView) this.webViewRef.get();
                if (webView != null) {
                    MMJSResponse response;
                    MMJSObject receiver = (MMJSObject) this.cls.newInstance();
                    receiver.setContext(webView.getContext());
                    receiver.setMMWebView(webView);
                    webView.updateArgumentsWithSettings(this.arguments);
                    try {
                        response = (MMJSResponse) this.method.invoke(receiver, new Object[]{this.arguments});
                    } catch (InvocationTargetException ite) {
                        Throwable t = ite.getCause();
                        if (t == null || t.getClass() != ActivityNotFoundException.class) {
                            response = MMJSResponse.responseWithError();
                        } else {
                            response = MMJSResponse.responseWithError("Activity not found");
                        }
                    }
                    if (this.callback != null && this.callback.length() > 0) {
                        MMWebView webViewCallback = (MMWebView) this.webViewRef.get();
                        if (webViewCallback != null) {
                            if (response == null) {
                                response = MMJSResponse.responseWithError(this.method.getName());
                            }
                            if (response.methodName == null) {
                                response.methodName = this.method.getName();
                            }
                            if (response.className == null) {
                                response.className = getBridgeStrippedClassName();
                            }
                            call = String.format("javascript:%s(%s);", new Object[]{this.callback, response.toJSONString()});
                            Log.m9723v("Executing JS bridge callback: " + call);
                            MMSDK.runOnUiThread(new C24781(webViewCallback, call));
                        }
                    }
                }
            } catch (Exception e) {
                Log.m9715e("Exception while executing javascript call %s %s", this.method.toString(), e.getMessage());
                e.printStackTrace();
            }
        } else if (!TextUtils.isEmpty(this.callback)) {
            MMJSResponse failedResponse = MMJSResponse.responseWithError("No class or method found");
            call = String.format("javascript:%s(%s);", new Object[]{this.callback, failedResponse.toJSONString()});
            Log.m9723v("Executing JS bridge failed callback: " + call);
            MMSDK.runOnUiThread(new C24792((MMWebView) this.webViewRef.get(), call));
        }
    }

    private String getBridgeStrippedClassName() {
        return this.cls.getSimpleName().replaceFirst("Bridge", "");
    }
}
