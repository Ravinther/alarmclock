package com.p037b.p063c;

import android.view.View;
import com.p037b.p063c.p064a.C1236a;

/* renamed from: com.b.c.a */
public final class C1237a {

    /* renamed from: com.b.c.a.a */
    private static final class C1235a {
        static void m5239a(View view, float alpha) {
            view.setAlpha(alpha);
        }

        static void m5240b(View view, float rotation) {
            view.setRotation(rotation);
        }

        static void m5241c(View view, float scaleX) {
            view.setScaleX(scaleX);
        }

        static void m5242d(View view, float scaleY) {
            view.setScaleY(scaleY);
        }

        static void m5243e(View view, float translationX) {
            view.setTranslationX(translationX);
        }

        static void m5244f(View view, float translationY) {
            view.setTranslationY(translationY);
        }
    }

    public static void m5278a(View view, float alpha) {
        if (C1236a.f3738a) {
            C1236a.m5245a(view).m5251a(alpha);
        } else {
            C1235a.m5239a(view, alpha);
        }
    }

    public static void m5279b(View view, float rotation) {
        if (C1236a.f3738a) {
            C1236a.m5245a(view).m5259d(rotation);
        } else {
            C1235a.m5240b(view, rotation);
        }
    }

    public static void m5280c(View view, float scaleX) {
        if (C1236a.f3738a) {
            C1236a.m5245a(view).m5265g(scaleX);
        } else {
            C1235a.m5241c(view, scaleX);
        }
    }

    public static void m5281d(View view, float scaleY) {
        if (C1236a.f3738a) {
            C1236a.m5245a(view).m5267h(scaleY);
        } else {
            C1235a.m5242d(view, scaleY);
        }
    }

    public static void m5282e(View view, float translationX) {
        if (C1236a.f3738a) {
            C1236a.m5245a(view).m5269i(translationX);
        } else {
            C1235a.m5243e(view, translationX);
        }
    }

    public static void m5283f(View view, float translationY) {
        if (C1236a.f3738a) {
            C1236a.m5245a(view).m5271j(translationY);
        } else {
            C1235a.m5244f(view, translationY);
        }
    }
}
