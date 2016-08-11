package android.support.v4.view.p011a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.view.a.f */
class C0198f {

    /* renamed from: android.support.v4.view.a.f.a */
    interface C0189a {
        Object m918a(int i);

        List m919a(String str, int i);

        boolean m920a(int i, int i2, Bundle bundle);
    }

    /* renamed from: android.support.v4.view.a.f.1 */
    static class C01971 extends AccessibilityNodeProvider {
        final /* synthetic */ C0189a f471a;

        C01971(C0189a c0189a) {
            this.f471a = c0189a;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int virtualViewId) {
            return (AccessibilityNodeInfo) this.f471a.m918a(virtualViewId);
        }

        public List findAccessibilityNodeInfosByText(String text, int virtualViewId) {
            return this.f471a.m919a(text, virtualViewId);
        }

        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return this.f471a.m920a(virtualViewId, action, arguments);
        }
    }

    public static Object m940a(C0189a bridge) {
        return new C01971(bridge);
    }
}
