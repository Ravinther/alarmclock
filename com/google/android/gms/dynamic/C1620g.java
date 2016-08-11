package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.fq;

/* renamed from: com.google.android.gms.dynamic.g */
public abstract class C1620g {
    private final String Hx;
    private Object Hy;

    /* renamed from: com.google.android.gms.dynamic.g.a */
    public static class C1619a extends Exception {
        public C1619a(String str) {
            super(str);
        }

        public C1619a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C1620g(String str) {
        this.Hx = str;
    }

    protected abstract Object m6735d(IBinder iBinder);

    protected final Object m6736z(Context context) {
        if (this.Hy == null) {
            fq.m8520f(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C1619a("Could not get remote context.");
            }
            try {
                this.Hy = m6735d((IBinder) remoteContext.getClassLoader().loadClass(this.Hx).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C1619a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C1619a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C1619a("Could not access creator.");
            }
        }
        return this.Hy;
    }
}
