package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.location.C1939a;
import com.google.android.gms.location.C1939a.C1940a;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.mopub.mobileads.util.Base64;
import java.util.HashMap;

public class hb {
    private final hf Ok;
    private ContentProviderClient Ol;
    private boolean Om;
    private HashMap On;
    private final Context mContext;

    /* renamed from: com.google.android.gms.internal.hb.a */
    private static class C1938a extends Handler {
        private final LocationListener Oo;

        public C1938a(LocationListener locationListener) {
            this.Oo = locationListener;
        }

        public C1938a(LocationListener locationListener, Looper looper) {
            super(looper);
            this.Oo = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Base64.NO_PADDING /*1*/:
                    this.Oo.onLocationChanged(new Location((Location) msg.obj));
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.hb.b */
    private static class C1941b extends C1940a {
        private Handler Op;

        C1941b(LocationListener locationListener, Looper looper) {
            this.Op = looper == null ? new C1938a(locationListener) : new C1938a(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.Op == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.Op.sendMessage(obtain);
        }

        public void release() {
            this.Op = null;
        }
    }

    public hb(Context context, hf hfVar) {
        this.Ol = null;
        this.Om = false;
        this.On = new HashMap();
        this.mContext = context;
        this.Ok = hfVar;
    }

    public Location getLastLocation() {
        this.Ok.bT();
        try {
            return ((ha) this.Ok.eM()).aW(this.mContext.getPackageName());
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void hQ() {
        if (this.Om) {
            setMockMode(false);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.On) {
                for (C1939a c1939a : this.On.values()) {
                    if (c1939a != null) {
                        ((ha) this.Ok.eM()).m8644a(c1939a);
                    }
                }
                this.On.clear();
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(PendingIntent callbackIntent) {
        this.Ok.bT();
        try {
            ((ha) this.Ok.eM()).m8632a(callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeLocationUpdates(LocationListener listener) {
        this.Ok.bT();
        fq.m8517b((Object) listener, (Object) "Invalid null listener");
        synchronized (this.On) {
            C1939a c1939a = (C1941b) this.On.remove(listener);
            if (this.Ol != null && this.On.isEmpty()) {
                this.Ol.release();
                this.Ol = null;
            }
            if (c1939a != null) {
                c1939a.release();
                try {
                    ((ha) this.Ok.eM()).m8644a(c1939a);
                } catch (Throwable e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

    public void requestLocationUpdates(LocationRequest request, PendingIntent callbackIntent) {
        this.Ok.bT();
        try {
            ((ha) this.Ok.eM()).m8641a(request, callbackIntent);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void requestLocationUpdates(LocationRequest request, LocationListener listener, Looper looper) {
        this.Ok.bT();
        if (looper == null) {
            fq.m8517b(Looper.myLooper(), (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        }
        synchronized (this.On) {
            C1939a c1941b;
            C1941b c1941b2 = (C1941b) this.On.get(listener);
            if (c1941b2 == null) {
                c1941b = new C1941b(listener, looper);
            } else {
                Object obj = c1941b2;
            }
            this.On.put(listener, c1941b);
            try {
                ((ha) this.Ok.eM()).m8643a(request, c1941b, this.mContext.getPackageName());
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void setMockLocation(Location mockLocation) {
        this.Ok.bT();
        try {
            ((ha) this.Ok.eM()).setMockLocation(mockLocation);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void setMockMode(boolean isMockMode) {
        this.Ok.bT();
        try {
            ((ha) this.Ok.eM()).setMockMode(isMockMode);
            this.Om = isMockMode;
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }
}
