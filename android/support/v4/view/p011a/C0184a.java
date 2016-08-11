package android.support.v4.view.p011a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.google.ads.AdSize;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.cast.Cast;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.mobileads.util.Base64;

/* renamed from: android.support.v4.view.a.a */
public class C0184a {
    private static final C0177c f463a;
    private final Object f464b;

    /* renamed from: android.support.v4.view.a.a.c */
    interface C0177c {
        Object m714a(Object obj);

        void m715a(Object obj, int i);

        void m716a(Object obj, Rect rect);

        void m717a(Object obj, View view);

        void m718a(Object obj, CharSequence charSequence);

        void m719a(Object obj, boolean z);

        int m720b(Object obj);

        void m721b(Object obj, Rect rect);

        void m722b(Object obj, View view);

        void m723b(Object obj, CharSequence charSequence);

        void m724b(Object obj, boolean z);

        CharSequence m725c(Object obj);

        void m726c(Object obj, Rect rect);

        void m727c(Object obj, View view);

        void m728c(Object obj, CharSequence charSequence);

        void m729c(Object obj, boolean z);

        CharSequence m730d(Object obj);

        void m731d(Object obj, Rect rect);

        void m732d(Object obj, boolean z);

        CharSequence m733e(Object obj);

        void m734e(Object obj, boolean z);

        CharSequence m735f(Object obj);

        void m736f(Object obj, boolean z);

        void m737g(Object obj, boolean z);

        boolean m738g(Object obj);

        void m739h(Object obj, boolean z);

        boolean m740h(Object obj);

        void m741i(Object obj, boolean z);

        boolean m742i(Object obj);

        boolean m743j(Object obj);

        boolean m744k(Object obj);

        boolean m745l(Object obj);

        boolean m746m(Object obj);

        boolean m747n(Object obj);

        boolean m748o(Object obj);

        boolean m749p(Object obj);

        void m750q(Object obj);

        boolean m751r(Object obj);

        boolean m752s(Object obj);

        String m753t(Object obj);
    }

    /* renamed from: android.support.v4.view.a.a.g */
    static class C0178g implements C0177c {
        C0178g() {
        }

        public Object m754a(Object info) {
            return null;
        }

        public void m755a(Object info, int action) {
        }

        public void m757a(Object info, View child) {
        }

        public int m760b(Object info) {
            return 0;
        }

        public void m756a(Object info, Rect outBounds) {
        }

        public void m761b(Object info, Rect outBounds) {
        }

        public CharSequence m765c(Object info) {
            return null;
        }

        public CharSequence m770d(Object info) {
            return null;
        }

        public CharSequence m773e(Object info) {
            return null;
        }

        public CharSequence m775f(Object info) {
            return null;
        }

        public boolean m778g(Object info) {
            return false;
        }

        public boolean m780h(Object info) {
            return false;
        }

        public boolean m782i(Object info) {
            return false;
        }

        public boolean m783j(Object info) {
            return false;
        }

        public boolean m784k(Object info) {
            return false;
        }

        public boolean m785l(Object info) {
            return false;
        }

        public boolean m791r(Object info) {
            return false;
        }

        public boolean m792s(Object info) {
            return false;
        }

        public boolean m786m(Object info) {
            return false;
        }

        public boolean m787n(Object info) {
            return false;
        }

        public boolean m788o(Object info) {
            return false;
        }

        public boolean m789p(Object info) {
            return false;
        }

        public void m766c(Object info, Rect bounds) {
        }

        public void m771d(Object info, Rect bounds) {
        }

        public void m758a(Object info, CharSequence className) {
        }

        public void m759a(Object info, boolean clickable) {
        }

        public void m763b(Object info, CharSequence contentDescription) {
        }

        public void m764b(Object info, boolean enabled) {
        }

        public void m769c(Object info, boolean focusable) {
        }

        public void m772d(Object info, boolean focused) {
        }

        public void m779h(Object info, boolean visibleToUser) {
        }

        public void m781i(Object info, boolean focused) {
        }

        public void m774e(Object info, boolean longClickable) {
        }

        public void m768c(Object info, CharSequence packageName) {
        }

        public void m762b(Object info, View parent) {
        }

        public void m776f(Object info, boolean scrollable) {
        }

        public void m777g(Object info, boolean selected) {
        }

        public void m767c(Object info, View source) {
        }

        public void m790q(Object info) {
        }

        public String m793t(Object info) {
            return null;
        }
    }

    /* renamed from: android.support.v4.view.a.a.b */
    static class C0179b extends C0178g {
        C0179b() {
        }

        public Object m794a(Object info) {
            return C0185b.m877a(info);
        }

        public void m795a(Object info, int action) {
            C0185b.m878a(info, action);
        }

        public void m797a(Object info, View child) {
            C0185b.m880a(info, child);
        }

        public int m800b(Object info) {
            return C0185b.m883b(info);
        }

        public void m796a(Object info, Rect outBounds) {
            C0185b.m879a(info, outBounds);
        }

        public void m801b(Object info, Rect outBounds) {
            C0185b.m884b(info, outBounds);
        }

        public CharSequence m805c(Object info) {
            return C0185b.m888c(info);
        }

        public CharSequence m810d(Object info) {
            return C0185b.m893d(info);
        }

        public CharSequence m813e(Object info) {
            return C0185b.m896e(info);
        }

        public CharSequence m815f(Object info) {
            return C0185b.m898f(info);
        }

        public boolean m818g(Object info) {
            return C0185b.m901g(info);
        }

        public boolean m819h(Object info) {
            return C0185b.m902h(info);
        }

        public boolean m820i(Object info) {
            return C0185b.m903i(info);
        }

        public boolean m821j(Object info) {
            return C0185b.m904j(info);
        }

        public boolean m822k(Object info) {
            return C0185b.m905k(info);
        }

        public boolean m823l(Object info) {
            return C0185b.m906l(info);
        }

        public boolean m824m(Object info) {
            return C0185b.m907m(info);
        }

        public boolean m825n(Object info) {
            return C0185b.m908n(info);
        }

        public boolean m826o(Object info) {
            return C0185b.m909o(info);
        }

        public boolean m827p(Object info) {
            return C0185b.m910p(info);
        }

        public void m806c(Object info, Rect bounds) {
            C0185b.m889c(info, bounds);
        }

        public void m811d(Object info, Rect bounds) {
            C0185b.m894d(info, bounds);
        }

        public void m798a(Object info, CharSequence className) {
            C0185b.m881a(info, className);
        }

        public void m799a(Object info, boolean clickable) {
            C0185b.m882a(info, clickable);
        }

        public void m803b(Object info, CharSequence contentDescription) {
            C0185b.m886b(info, contentDescription);
        }

        public void m804b(Object info, boolean enabled) {
            C0185b.m887b(info, enabled);
        }

        public void m809c(Object info, boolean focusable) {
            C0185b.m892c(info, focusable);
        }

        public void m812d(Object info, boolean focused) {
            C0185b.m895d(info, focused);
        }

        public void m814e(Object info, boolean longClickable) {
            C0185b.m897e(info, longClickable);
        }

        public void m808c(Object info, CharSequence packageName) {
            C0185b.m891c(info, packageName);
        }

        public void m802b(Object info, View parent) {
            C0185b.m885b(info, parent);
        }

        public void m816f(Object info, boolean scrollable) {
            C0185b.m899f(info, scrollable);
        }

        public void m817g(Object info, boolean selected) {
            C0185b.m900g(info, selected);
        }

        public void m807c(Object info, View source) {
            C0185b.m890c(info, source);
        }

        public void m828q(Object info) {
            C0185b.m911q(info);
        }
    }

    /* renamed from: android.support.v4.view.a.a.d */
    static class C0180d extends C0179b {
        C0180d() {
        }

        public boolean m831r(Object info) {
            return C0186c.m913a(info);
        }

        public void m829h(Object info, boolean visibleToUser) {
            C0186c.m912a(info, visibleToUser);
        }

        public boolean m832s(Object info) {
            return C0186c.m915b(info);
        }

        public void m830i(Object info, boolean focused) {
            C0186c.m914b(info, focused);
        }
    }

    /* renamed from: android.support.v4.view.a.a.e */
    static class C0181e extends C0180d {
        C0181e() {
        }

        public String m833t(Object info) {
            return C0187d.m916a(info);
        }
    }

    /* renamed from: android.support.v4.view.a.a.f */
    static class C0182f extends C0181e {
        C0182f() {
        }
    }

    /* renamed from: android.support.v4.view.a.a.a */
    static class C0183a extends C0182f {
        C0183a() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            f463a = new C0183a();
        } else if (VERSION.SDK_INT >= 19) {
            f463a = new C0182f();
        } else if (VERSION.SDK_INT >= 18) {
            f463a = new C0181e();
        } else if (VERSION.SDK_INT >= 16) {
            f463a = new C0180d();
        } else if (VERSION.SDK_INT >= 14) {
            f463a = new C0179b();
        } else {
            f463a = new C0178g();
        }
    }

    static C0184a m835a(Object object) {
        if (object != null) {
            return new C0184a(object);
        }
        return null;
    }

    public C0184a(Object info) {
        this.f464b = info;
    }

    public Object m837a() {
        return this.f464b;
    }

    public static C0184a m834a(C0184a info) {
        return C0184a.m835a(f463a.m714a(info.f464b));
    }

    public void m840a(View source) {
        f463a.m727c(this.f464b, source);
    }

    public void m845b(View child) {
        f463a.m717a(this.f464b, child);
    }

    public int m843b() {
        return f463a.m720b(this.f464b);
    }

    public void m838a(int action) {
        f463a.m715a(this.f464b, action);
    }

    public void m849c(View parent) {
        f463a.m722b(this.f464b, parent);
    }

    public void m839a(Rect outBounds) {
        f463a.m716a(this.f464b, outBounds);
    }

    public void m844b(Rect bounds) {
        f463a.m726c(this.f464b, bounds);
    }

    public void m848c(Rect outBounds) {
        f463a.m721b(this.f464b, outBounds);
    }

    public void m853d(Rect bounds) {
        f463a.m731d(this.f464b, bounds);
    }

    public boolean m852c() {
        return f463a.m738g(this.f464b);
    }

    public boolean m855d() {
        return f463a.m740h(this.f464b);
    }

    public boolean m857e() {
        return f463a.m744k(this.f464b);
    }

    public void m842a(boolean focusable) {
        f463a.m729c(this.f464b, focusable);
    }

    public boolean m859f() {
        return f463a.m745l(this.f464b);
    }

    public void m847b(boolean focused) {
        f463a.m732d(this.f464b, focused);
    }

    public boolean m861g() {
        return f463a.m751r(this.f464b);
    }

    public void m851c(boolean visibleToUser) {
        f463a.m739h(this.f464b, visibleToUser);
    }

    public boolean m863h() {
        return f463a.m752s(this.f464b);
    }

    public void m854d(boolean focused) {
        f463a.m741i(this.f464b, focused);
    }

    public boolean m865i() {
        return f463a.m749p(this.f464b);
    }

    public void m856e(boolean selected) {
        f463a.m737g(this.f464b, selected);
    }

    public boolean m866j() {
        return f463a.m742i(this.f464b);
    }

    public void m858f(boolean clickable) {
        f463a.m719a(this.f464b, clickable);
    }

    public boolean m867k() {
        return f463a.m746m(this.f464b);
    }

    public void m860g(boolean longClickable) {
        f463a.m734e(this.f464b, longClickable);
    }

    public boolean m868l() {
        return f463a.m743j(this.f464b);
    }

    public void m862h(boolean enabled) {
        f463a.m724b(this.f464b, enabled);
    }

    public boolean m869m() {
        return f463a.m747n(this.f464b);
    }

    public boolean m870n() {
        return f463a.m748o(this.f464b);
    }

    public void m864i(boolean scrollable) {
        f463a.m736f(this.f464b, scrollable);
    }

    public CharSequence m871o() {
        return f463a.m733e(this.f464b);
    }

    public void m841a(CharSequence packageName) {
        f463a.m728c(this.f464b, packageName);
    }

    public CharSequence m872p() {
        return f463a.m725c(this.f464b);
    }

    public void m846b(CharSequence className) {
        f463a.m718a(this.f464b, className);
    }

    public CharSequence m873q() {
        return f463a.m735f(this.f464b);
    }

    public CharSequence m874r() {
        return f463a.m730d(this.f464b);
    }

    public void m850c(CharSequence contentDescription) {
        f463a.m723b(this.f464b, contentDescription);
    }

    public void m875s() {
        f463a.m750q(this.f464b);
    }

    public String m876t() {
        return f463a.m753t(this.f464b);
    }

    public int hashCode() {
        return this.f464b == null ? 0 : this.f464b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0184a other = (C0184a) obj;
        if (this.f464b == null) {
            if (other.f464b != null) {
                return false;
            }
            return true;
        } else if (this.f464b.equals(other.f464b)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        Rect bounds = new Rect();
        m839a(bounds);
        builder.append("; boundsInParent: " + bounds);
        m848c(bounds);
        builder.append("; boundsInScreen: " + bounds);
        builder.append("; packageName: ").append(m871o());
        builder.append("; className: ").append(m872p());
        builder.append("; text: ").append(m873q());
        builder.append("; contentDescription: ").append(m874r());
        builder.append("; viewId: ").append(m876t());
        builder.append("; checkable: ").append(m852c());
        builder.append("; checked: ").append(m855d());
        builder.append("; focusable: ").append(m857e());
        builder.append("; focused: ").append(m859f());
        builder.append("; selected: ").append(m865i());
        builder.append("; clickable: ").append(m866j());
        builder.append("; longClickable: ").append(m867k());
        builder.append("; enabled: ").append(m868l());
        builder.append("; password: ").append(m869m());
        builder.append("; scrollable: " + m870n());
        builder.append("; [");
        int actionBits = m843b();
        while (actionBits != 0) {
            int action = 1 << Integer.numberOfTrailingZeros(actionBits);
            actionBits &= action ^ -1;
            builder.append(C0184a.m836b(action));
            if (actionBits != 0) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    private static String m836b(int action) {
        switch (action) {
            case Base64.NO_PADDING /*1*/:
                return "ACTION_FOCUS";
            case Base64.NO_WRAP /*2*/:
                return "ACTION_CLEAR_FOCUS";
            case Base64.CRLF /*4*/:
                return "ACTION_SELECT";
            case Base64.URL_SAFE /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case Base64.NO_CLOSE /*16*/:
                return "ACTION_CLICK";
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case Cast.MAX_NAMESPACE_LENGTH /*128*/:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case AdRequest.MAX_CONTENT_URL_LENGTH /*512*/:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case HttpClientFactory.SOCKET_SIZE /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case Cast.MAX_MESSAGE_LENGTH /*65536*/:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
