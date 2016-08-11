package android.support.v4.view.p011a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.a.g */
class C0200g {

    /* renamed from: android.support.v4.view.a.g.a */
    interface C0193a {
        Object m926a(int i);

        List m927a(String str, int i);

        boolean m928a(int i, int i2, Bundle bundle);

        Object m929b(int i);
    }

    /* renamed from: android.support.v4.view.a.g.1 */
    static class C01991 extends AccessibilityNodeProvider {
        final /* synthetic */ C0193a f472a;

        C01991(C0193a c0193a) {
            this.f472a = c0193a;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            return (AccessibilityNodeInfo) this.f472a.m926a(virtualViewId);
        }

        public List findAccessibilityNodeInfosByText(String text, int virtualViewId) {
            return this.f472a.m927a(text, virtualViewId);
        }

        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return this.f472a.m928a(virtualViewId, action, arguments);
        }

        public AccessibilityNodeInfo findFocus(int focus) {
            return (AccessibilityNodeInfo) this.f472a.m929b(focus);
        }
    }

    public static Object m941a(C0193a bridge) {
        return new C01991(bridge);
    }
}
