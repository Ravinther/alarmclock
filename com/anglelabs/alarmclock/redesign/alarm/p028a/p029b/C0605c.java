package com.anglelabs.alarmclock.redesign.alarm.p028a.p029b;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.b.c */
public abstract class C0605c {
    private final Context f1666a;
    private final C0567a f1667b;
    private final RedesignAlarm f1668c;
    private final int f1669d;

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.b.c.a */
    public interface C0567a {
        C0605c m2588a(TextView textView);

        void m2589a(RedesignAlarm redesignAlarm);

        C0605c m2590b(TextView textView);

        void m2591b(boolean z);

        void m2592d(RedesignAlarm redesignAlarm);

        void m2593k();

        Handler m2594l();

        int m2595m();
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.b.c.b */
    public interface C0609b {
        void m2813d();

        void m2814e();
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.b.c.c */
    public interface C0610c {
        void m2815c();
    }

    public abstract void m2798a();

    public abstract void m2799a(TextView textView);

    public C0605c(Context context, TextView view, RedesignAlarm alarm, C0567a callback, int id) {
        this.f1666a = context;
        this.f1667b = callback;
        this.f1668c = alarm;
        this.f1669d = id;
        m2799a(view);
    }

    public CharSequence m2801f() {
        return "";
    }

    public boolean m2800b() {
        return true;
    }

    protected Context m2802g() {
        return this.f1666a;
    }

    protected C0567a m2803h() {
        return this.f1667b;
    }

    protected void m2804i() {
        this.f1667b.m2589a(this.f1668c);
        this.f1667b.m2593k();
    }

    protected RedesignAlarm m2805j() {
        return this.f1668c;
    }

    protected void m2806k() {
        this.f1667b.m2592d(this.f1668c);
    }
}
