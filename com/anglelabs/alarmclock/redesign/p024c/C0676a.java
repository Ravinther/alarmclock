package com.anglelabs.alarmclock.redesign.p024c;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import java.lang.ref.WeakReference;

/* renamed from: com.anglelabs.alarmclock.redesign.c.a */
public class C0676a extends BroadcastReceiver {
    final WeakReference f1760a;
    final WeakReference f1761b;
    boolean f1762c;
    boolean f1763d;
    boolean f1764e;

    /* renamed from: com.anglelabs.alarmclock.redesign.c.a.a */
    public interface C0563a {
        void m2570o();
    }

    public C0676a(Activity activity, C0563a changesReceiver) {
        this.f1762c = true;
        this.f1763d = false;
        this.f1764e = false;
        this.f1760a = new WeakReference(activity);
        this.f1761b = new WeakReference(changesReceiver);
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f1760a.get() != null) {
            boolean isTimeDisplayChanges;
            Activity act = (Activity) this.f1760a.get();
            String action = intent.getAction();
            if (this.f1762c && (action.equals("FIRST_DAY_OF_WEEK_CHANGED") || action.equals("CLOCK_HOURS_MODE_CHANGED"))) {
                isTimeDisplayChanges = true;
            } else {
                isTimeDisplayChanges = false;
            }
            boolean isKeepScreenOnChanges;
            if (this.f1763d && action.equals("KEEP_SCREEN_ON")) {
                isKeepScreenOnChanges = true;
            } else {
                isKeepScreenOnChanges = false;
            }
            boolean isUseVolume;
            if (this.f1764e && action.equals("USE_VOLUME")) {
                isUseVolume = true;
            } else {
                isUseVolume = false;
            }
            boolean languageChanged = action.equals("LANGUAGE_CHANGED");
            if (action.equals("BACKGROUND_CHANGED")) {
                C0810h.m3832a(act);
            } else if ((isTimeDisplayChanges || isKeepScreenOnChanges || isUseVolume || languageChanged) && this.f1761b.get() != null) {
                ((C0563a) this.f1761b.get()).m2570o();
            }
        }
    }

    public void m3099a() {
        this.f1762c = false;
    }

    public void m3101a(boolean monitor) {
        this.f1763d = monitor;
    }

    public void m3102b(boolean monitor) {
        this.f1764e = monitor;
    }

    public void m3100a(Activity activity) {
        activity.registerReceiver(this, C0676a.m3093b());
    }

    private static IntentFilter m3093b() {
        IntentFilter filter = new IntentFilter("BACKGROUND_CHANGED");
        filter.addAction("FIRST_DAY_OF_WEEK_CHANGED");
        filter.addAction("CLOCK_HOURS_MODE_CHANGED");
        filter.addAction("KEEP_SCREEN_ON");
        filter.addAction("USE_VOLUME");
        filter.addAction("LANGUAGE_CHANGED");
        return filter;
    }

    public static C0676a m3091a(Activity activity, C0563a callback) {
        C0676a rec = new C0676a(activity, callback);
        activity.registerReceiver(rec, C0676a.m3093b());
        return rec;
    }

    public static void m3092a(Context context) {
        context.sendBroadcast(new Intent("BACKGROUND_CHANGED"));
    }

    public static void m3094b(Context context) {
        context.sendBroadcast(new Intent("FIRST_DAY_OF_WEEK_CHANGED"));
    }

    public static void m3095c(Context context) {
        context.sendBroadcast(new Intent("CLOCK_HOURS_MODE_CHANGED"));
    }

    public static void m3096d(Context context) {
        context.sendBroadcast(new Intent("KEEP_SCREEN_ON"));
    }

    public static void m3097e(Context context) {
        context.sendBroadcast(new Intent("USE_VOLUME"));
    }

    public static void m3098f(Context context) {
        context.sendBroadcast(new Intent("LANGUAGE_CHANGED"));
    }
}
