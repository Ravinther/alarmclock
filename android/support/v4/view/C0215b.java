package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.b */
class C0215b {

    /* renamed from: android.support.v4.view.b.a */
    public interface C0169a {
        void m648a(View view, int i);

        void m649a(View view, Object obj);

        boolean m650a(View view, AccessibilityEvent accessibilityEvent);

        boolean m651a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m652b(View view, AccessibilityEvent accessibilityEvent);

        void m653c(View view, AccessibilityEvent accessibilityEvent);

        void m654d(View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.view.b.1 */
    static class C02141 extends AccessibilityDelegate {
        final /* synthetic */ C0169a f476a;

        C02141(C0169a c0169a) {
            this.f476a = c0169a;
        }

        public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            return this.f476a.m650a(host, event);
        }

        public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
            this.f476a.m652b(host, event);
        }

        public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
            this.f476a.m649a(host, (Object) info);
        }

        public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
            this.f476a.m653c(host, event);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
            return this.f476a.m651a(host, child, event);
        }

        public void sendAccessibilityEvent(View host, int eventType) {
            this.f476a.m648a(host, eventType);
        }

        public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
            this.f476a.m654d(host, event);
        }
    }

    public static Object m972a() {
        return new AccessibilityDelegate();
    }

    public static Object m973a(C0169a bridge) {
        return new C02141(bridge);
    }

    public static boolean m976a(Object delegate, View host, AccessibilityEvent event) {
        return ((AccessibilityDelegate) delegate).dispatchPopulateAccessibilityEvent(host, event);
    }

    public static void m978b(Object delegate, View host, AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).onInitializeAccessibilityEvent(host, event);
    }

    public static void m975a(Object delegate, View host, Object info) {
        ((AccessibilityDelegate) delegate).onInitializeAccessibilityNodeInfo(host, (AccessibilityNodeInfo) info);
    }

    public static void m979c(Object delegate, View host, AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).onPopulateAccessibilityEvent(host, event);
    }

    public static boolean m977a(Object delegate, ViewGroup host, View child, AccessibilityEvent event) {
        return ((AccessibilityDelegate) delegate).onRequestSendAccessibilityEvent(host, child, event);
    }

    public static void m974a(Object delegate, View host, int eventType) {
        ((AccessibilityDelegate) delegate).sendAccessibilityEvent(host, eventType);
    }

    public static void m980d(Object delegate, View host, AccessibilityEvent event) {
        ((AccessibilityDelegate) delegate).sendAccessibilityEventUnchecked(host, event);
    }
}
