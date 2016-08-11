package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.kh.C2022a;
import com.google.android.gms.internal.ki;
import com.google.android.gms.internal.kk;

public abstract class WearableListenerService extends Service {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private IBinder DB;
    private volatile int adu;
    private String adv;
    private Handler adw;

    /* renamed from: com.google.android.gms.wearable.WearableListenerService.a */
    private class C2377a extends C2022a {
        final /* synthetic */ WearableListenerService adx;

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.1 */
        class C23731 implements Runnable {
            final /* synthetic */ DataHolder ady;
            final /* synthetic */ C2377a adz;

            C23731(C2377a c2377a, DataHolder dataHolder) {
                this.adz = c2377a;
                this.ady = dataHolder;
            }

            public void run() {
                C2378b c2378b = new C2378b(this.ady);
                try {
                    this.adz.adx.onDataChanged(c2378b);
                } finally {
                    c2378b.close();
                }
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.2 */
        class C23742 implements Runnable {
            final /* synthetic */ ki adA;
            final /* synthetic */ C2377a adz;

            C23742(C2377a c2377a, ki kiVar) {
                this.adz = c2377a;
                this.adA = kiVar;
            }

            public void run() {
                this.adz.adx.onMessageReceived(this.adA);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.3 */
        class C23753 implements Runnable {
            final /* synthetic */ kk adB;
            final /* synthetic */ C2377a adz;

            C23753(C2377a c2377a, kk kkVar) {
                this.adz = c2377a;
                this.adB = kkVar;
            }

            public void run() {
                this.adz.adx.onPeerConnected(this.adB);
            }
        }

        /* renamed from: com.google.android.gms.wearable.WearableListenerService.a.4 */
        class C23764 implements Runnable {
            final /* synthetic */ kk adB;
            final /* synthetic */ C2377a adz;

            C23764(C2377a c2377a, kk kkVar) {
                this.adz = c2377a;
                this.adB = kkVar;
            }

            public void run() {
                this.adz.adx.onPeerDisconnected(this.adB);
            }
        }

        private C2377a(WearableListenerService wearableListenerService) {
            this.adx = wearableListenerService;
        }

        public void m9702M(DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + this.adx.adv + ": " + dataHolder);
            }
            this.adx.md();
            this.adx.adw.post(new C23731(this, dataHolder));
        }

        public void m9703a(ki kiVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + kiVar);
            }
            this.adx.md();
            this.adx.adw.post(new C23742(this, kiVar));
        }

        public void m9704a(kk kkVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + this.adx.adv + ": " + kkVar);
            }
            this.adx.md();
            this.adx.adw.post(new C23753(this, kkVar));
        }

        public void m9705b(kk kkVar) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + this.adx.adv + ": " + kkVar);
            }
            this.adx.md();
            this.adx.adw.post(new C23764(this, kkVar));
        }
    }

    public WearableListenerService() {
        this.adu = -1;
    }

    private boolean cM(int i) {
        String str = GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE;
        String[] packagesForUid = getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private void md() {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.adu) {
            if (GooglePlayServicesUtil.m6214b(getPackageManager(), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE) && cM(callingUid)) {
                this.adu = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.DB : null;
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.adv = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.adw = new Handler(handlerThread.getLooper());
        this.DB = new C2377a();
    }

    public void onDataChanged(C2378b dataEvents) {
    }

    public void onDestroy() {
        this.adw.getLooper().quit();
        super.onDestroy();
    }

    public void onMessageReceived(C2023e messageEvent) {
    }

    public void onPeerConnected(C2024f peer) {
    }

    public void onPeerDisconnected(C2024f peer) {
    }
}
