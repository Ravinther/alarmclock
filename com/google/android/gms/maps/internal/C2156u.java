package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C2134c.C2136a;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.google.android.gms.maps.internal.u */
public class C2156u {
    private static C2134c SA;
    private static Context Sz;

    public static C2134c m9093A(Context context) {
        fq.m8520f(context);
        if (SA != null) {
            return SA;
        }
        C2156u.m9094B(context);
        SA = C2156u.m9095C(context);
        try {
            SA.m9070a(C1618e.m6734h(C2156u.getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return SA;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static void m9094B(Context context) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case Base64.DEFAULT /*0*/:
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static C2134c m9095C(Context context) {
        if (C2156u.iz()) {
            Log.i(C2156u.class.getSimpleName(), "Making Creator statically");
            return (C2134c) C2156u.m9097c(C2156u.iA());
        }
        Log.i(C2156u.class.getSimpleName(), "Making Creator dynamically");
        return C2136a.ab((IBinder) C2156u.m9096a(C2156u.getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static Object m9096a(ClassLoader classLoader, String str) {
        try {
            return C2156u.m9097c(((ClassLoader) fq.m8520f(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    private static Object m9097c(Class cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (Sz == null) {
            if (C2156u.iz()) {
                Sz = context.getApplicationContext();
            } else {
                Sz = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return Sz;
    }

    private static Class iA() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean iz() {
        return false;
    }
}
