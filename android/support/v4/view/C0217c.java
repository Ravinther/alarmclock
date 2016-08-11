package android.support.v4.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* renamed from: android.support.v4.view.c */
class C0217c {

    /* renamed from: android.support.v4.view.c.a */
    public interface C0174a {
        Object m693a(View view);

        void m694a(View view, int i);

        void m695a(View view, Object obj);

        boolean m696a(View view, int i, Bundle bundle);

        boolean m697a(View view, AccessibilityEvent accessibilityEvent);

        boolean m698a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m699b(View view, AccessibilityEvent accessibilityEvent);

        void m700c(View view, AccessibilityEvent accessibilityEvent);

        void m701d(View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.c.1 */
    static class C02161 extends AccessibilityDelegate {
        final /* synthetic */ C0174a f477a;

        C02161(C0174a c0174a) {
            this.f477a = c0174a;
        }

        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            return this.f477a.m697a(host, event);
        }

        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            this.f477a.m699b(host, event);
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            this.f477a.m695a(host, (Object) info);
        }

        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            this.f477a.m700c(host, event);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
            return this.f477a.m698a(host, child, event);
        }

        public void sendAccessibilityEvent(View host, int eventType) {
            this.f477a.m694a(host, eventType);
        }

        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            this.f477a.m701d(host, event);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
            return (AccessibilityNodeProvider) this.f477a.m693a(host);
        }

        public boolean performAccessibilityAction(View host, int action, Bundle args) {
            return this.f477a.m696a(host, action, args);
        }
    }

    public static Object m981a(C0174a bridge) {
        return new C02161(bridge);
    }

    public static Object m982a(Object delegate, View host) {
        return ((AccessibilityDelegate) delegate).getAccessibilityNodeProvider(host);
    }

    public static boolean m983a(Object delegate, View host, int action, Bundle args) {
        return ((AccessibilityDelegate) delegate).performAccessibilityAction(host, action, args);
    }
}
