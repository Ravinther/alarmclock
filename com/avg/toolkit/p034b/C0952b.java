package com.avg.toolkit.p034b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.recurringTasks.C1031b;
import com.avg.toolkit.uid.UUID;
import java.util.List;
import java.util.Properties;
import junit.framework.Assert;

/* renamed from: com.avg.toolkit.b.b */
public class C0952b implements C0647c {
    HandlerThread f2879a;
    public C0950a f2880b;
    HandlerThread f2881c;
    C0957g f2882d;
    private C1031b f2883e;
    private Context f2884f;

    /* renamed from: com.avg.toolkit.b.b.1 */
    class C09511 implements Runnable {
        final /* synthetic */ C0952b f2878a;

        C09511(C0952b c0952b) {
            this.f2878a = c0952b;
        }

        public void run() {
            if (this.f2878a.f2883e != null) {
                this.f2878a.f2883e.m4479a(this.f2878a.f2884f);
            }
        }
    }

    public C0952b(Context context, C1017a avgFeatures, UUID uuid, Properties properties) {
        String pidStr = properties.getProperty("productID");
        Assert.assertNotNull("productID not found in Cloud Services properties file", pidStr);
        int productId = Integer.parseInt(pidStr);
        C0955e.m4287a(productId);
        this.f2879a = new HandlerThread("CM");
        this.f2879a.start();
        this.f2880b = new C0950a(context, avgFeatures, productId, this.f2879a.getLooper(), uuid, new C09511(this));
        this.f2881c = new HandlerThread(C0952b.class.getName() + "UI");
        this.f2881c.start();
        this.f2882d = new C0957g(context, avgFeatures, productId, this.f2881c.getLooper(), uuid);
        this.f2884f = context;
    }

    public void m4283a(List commClients) {
        this.f2880b.m4278a(commClients);
        this.f2882d.m4301a(commClients);
    }

    public void onStart(boolean firstTime) {
        this.f2880b.m4279b();
        this.f2883e = new C1031b(this.f2884f, "CMM", 86400000, true, true, 4000, true);
    }

    public void onDestroy() {
        try {
            if (this.f2879a != null) {
                this.f2879a.getLooper().quit();
            }
            if (this.f2881c != null) {
                this.f2881c.getLooper().quit();
            }
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
        this.f2879a = null;
        this.f2881c = null;
        if (this.f2883e != null) {
            this.f2883e.m4481b(this.f2884f);
        }
    }

    public static boolean m4281a(Context context) {
        boolean b = true;
        try {
            String androidID = Build.PRODUCT;
            if (androidID == null || androidID.equalsIgnoreCase("9774D56D682E549C") || androidID.equalsIgnoreCase("google_sdk")) {
                return true;
            }
            NetworkInfo netinfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(netinfo != null && netinfo.isAvailable() && netinfo.isConnected())) {
                b = false;
            }
            return b;
        } catch (Exception e) {
            C0970a.m4322a(e);
            return false;
        }
    }

    public void onMessage(Bundle arguments) {
        try {
            Message msg = Message.obtain();
            int what = 0;
            boolean isUI = false;
            if (arguments != null) {
                what = arguments.getInt(ITKSvc.c_actionSubAction, -1);
                msg.obj = arguments;
                isUI = ((Bundle) msg.obj).getBoolean("isUI");
            }
            msg.what = what;
            if (isUI) {
                msg.setTarget(this.f2882d);
                this.f2882d.sendMessage(msg);
                return;
            }
            msg.setTarget(this.f2880b);
            this.f2880b.sendMessage(msg);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public int getID() {
        return 4000;
    }

    public void onAlarm(Bundle arguments) {
        if (this.f2883e.m4480a(this.f2884f, arguments)) {
            try {
                this.f2880b.sendMessage(Message.obtain(this.f2880b, 101, null));
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
    }

    public void onNewLicense(C1017a avgFeatures) {
        this.f2880b.m4277a(avgFeatures);
        this.f2882d.m4300a(avgFeatures);
    }

    public void setComm(List commClients) {
    }
}
