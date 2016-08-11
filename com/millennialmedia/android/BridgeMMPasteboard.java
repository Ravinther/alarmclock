package com.millennialmedia.android;

import android.content.Context;
import android.text.ClipboardManager;
import java.util.HashMap;
import java.util.concurrent.Callable;

class BridgeMMPasteboard extends MMJSObject {

    /* renamed from: com.millennialmedia.android.BridgeMMPasteboard.1 */
    class C24611 implements Callable {
        final /* synthetic */ Context val$context;

        C24611(Context context) {
            this.val$context = context;
        }

        public MMJSResponse call() {
            try {
                CharSequence chars = ((ClipboardManager) this.val$context.getSystemService("clipboard")).getText();
                String message = null;
                if (chars != null) {
                    message = chars.toString();
                }
                if (message != null) {
                    return MMJSResponse.responseWithSuccess(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: com.millennialmedia.android.BridgeMMPasteboard.2 */
    class C24622 implements Callable {
        final /* synthetic */ HashMap val$arguments;
        final /* synthetic */ Context val$context;

        C24622(Context context, HashMap hashMap) {
            this.val$context = context;
            this.val$arguments = hashMap;
        }

        public MMJSResponse call() {
            try {
                ((ClipboardManager) this.val$context.getSystemService("clipboard")).setText((String) this.val$arguments.get("data"));
                return MMJSResponse.responseWithSuccess();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    BridgeMMPasteboard() {
    }

    public MMJSResponse getPasteboardContents(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        return context != null ? runOnUiThreadFuture(new C24611(context)) : null;
    }

    public MMJSResponse writeToPasteboard(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        return context != null ? runOnUiThreadFuture(new C24622(context, arguments)) : null;
    }
}
