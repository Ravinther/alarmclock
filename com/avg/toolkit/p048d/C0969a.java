package com.avg.toolkit.p048d;

import android.app.Service;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.widget.Toast;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.avg.toolkit.d.a */
public class C0969a {

    /* renamed from: com.avg.toolkit.d.a.a */
    private static abstract class C0967a implements Runnable {
        protected Service f2922a;

        public C0967a(Service service) {
            this.f2922a = service;
        }
    }

    /* renamed from: com.avg.toolkit.d.a.1 */
    static class C09681 extends C0967a {
        C09681(Service x0) {
            super(x0);
        }

        public void run() {
            C0969a.m4320c(this.a);
        }
    }

    public static boolean m4318a(Context ctx) {
        boolean isChina = false;
        try {
            String country = ((TelephonyManager) ctx.getSystemService("phone")).getNetworkCountryIso().toLowerCase();
            if (!TextUtils.isEmpty(country)) {
                isChina = "cn".equals(country);
            }
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
        return isChina;
    }

    public static void m4317a(Service service) {
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new C09681(service), 5000);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    private static void m4320c(Service service) {
        String[] BLOCKED_COUNTRIES = new String[]{"cu", "kp", "sy", "sd"};
        String country = "";
        try {
            country = ((TelephonyManager) service.getSystemService("phone")).getNetworkCountryIso().toLowerCase();
        } catch (Exception e) {
            C0970a.m4325b("Fail on starting TelephonyManager. Error: " + e.getMessage());
            country = null;
        }
        if (!TextUtils.isEmpty(country)) {
            for (int i = 0; i < BLOCKED_COUNTRIES.length && true; i++) {
                if (country.equals(BLOCKED_COUNTRIES[i])) {
                    Toast.makeText(service.getApplicationContext(), "AVG Mobilation AntiVirus is not supported in the following countries:\nCuba, Iran, North Korea, Sudan, and Syria.", 1).show();
                    try {
                        Thread.sleep(1000);
                        service.stopSelf();
                        Process.killProcess(Process.myPid());
                        return;
                    } catch (Exception e2) {
                        C0970a.m4322a(e2);
                        return;
                    }
                }
            }
        }
    }
}
