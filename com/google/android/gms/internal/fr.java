package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.dynamic.C1620g;
import com.google.android.gms.dynamic.C1620g.C1619a;
import com.google.android.gms.internal.fn.C1906a;

public final class fr extends C1620g {
    private static final fr DK;

    static {
        DK = new fr();
    }

    private fr() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m8523b(Context context, int i, int i2) {
        return DK.m8524c(context, i, i2);
    }

    private View m8524c(Context context, int i, int i2) {
        try {
            return (View) C1618e.m6733d(((fn) m6736z(context)).m8507a(C1618e.m6734h(context), i, i2));
        } catch (Throwable e) {
            throw new C1619a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public fn m8525E(IBinder iBinder) {
        return C1906a.m8509D(iBinder);
    }

    public /* synthetic */ Object m8526d(IBinder iBinder) {
        return m8525E(iBinder);
    }
}
