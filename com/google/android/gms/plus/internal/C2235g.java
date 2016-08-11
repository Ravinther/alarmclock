package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.internal.fq;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.C2218c.C2220a;

/* renamed from: com.google.android.gms.plus.internal.g */
public final class C2235g {
    private static Context Sz;
    private static C2218c Uj;

    /* renamed from: com.google.android.gms.plus.internal.g.a */
    public static class C2234a extends Exception {
        public C2234a(String str) {
            super(str);
        }
    }

    private static C2218c m9265D(Context context) {
        fq.m8520f(context);
        if (Uj == null) {
            if (Sz == null) {
                Sz = GooglePlayServicesUtil.getRemoteContext(context);
                if (Sz == null) {
                    throw new C2234a("Could not get remote context.");
                }
            }
            try {
                Uj = C2220a.aP((IBinder) Sz.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new C2234a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C2234a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C2234a("Could not access creator.");
            }
        }
        return Uj;
    }

    public static View m9266a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C1618e.m6733d(C2235g.m9265D(context).m9208a(C1618e.m6734h(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }
}
