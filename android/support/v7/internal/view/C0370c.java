package android.support.v7.internal.view;

import android.content.Context;
import android.support.v7.internal.view.C0368b.C0367a;
import android.support.v7.p013c.C0342a.C0332a;
import android.view.ActionMode;

/* renamed from: android.support.v7.internal.view.c */
public class C0370c extends C0368b {

    /* renamed from: android.support.v7.internal.view.c.a */
    public static class C0369a extends C0367a {
        public C0369a(Context context, C0332a supportCallback) {
            super(context, supportCallback);
        }

        protected C0368b m1722a(Context context, ActionMode mode) {
            return new C0370c(context, mode);
        }
    }

    public C0370c(Context context, ActionMode frameworkActionMode) {
        super(context, frameworkActionMode);
    }
}
