package com.anglelabs.alarmclock.redesign.views;

import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import android.provider.Settings.System;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock extends RelativeLayout {
    private static Typeface f2531d;
    Calendar f2532a;
    boolean f2533b;
    final Handler f2534c;
    private String f2535e;
    private TextView f2536f;
    private C0879a f2537g;
    private ContentObserver f2538h;
    private boolean f2539i;
    private TimePickerDialog f2540j;
    private int f2541k;
    private int f2542l;
    private final BroadcastReceiver f2543m;

    /* renamed from: com.anglelabs.alarmclock.redesign.views.DigitalClock.1 */
    class C08771 extends BroadcastReceiver {
        final /* synthetic */ DigitalClock f2522a;

        /* renamed from: com.anglelabs.alarmclock.redesign.views.DigitalClock.1.1 */
        class C08761 implements Runnable {
            final /* synthetic */ C08771 f2521a;

            C08761(C08771 c08771) {
                this.f2521a = c08771;
            }

            public void run() {
                this.f2521a.f2522a.m4092a();
            }
        }

        C08771(DigitalClock digitalClock) {
            this.f2522a = digitalClock;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f2522a.f2533b && intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
                this.f2522a.f2532a = Calendar.getInstance();
            }
            this.f2522a.f2534c.post(new C08761(this));
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.DigitalClock.2 */
    class C08782 implements OnClickListener {
        final /* synthetic */ Context f2523a;
        final /* synthetic */ OnTimeSetListener f2524b;
        final /* synthetic */ DigitalClock f2525c;

        C08782(DigitalClock digitalClock, Context context, OnTimeSetListener onTimeSetListener) {
            this.f2525c = digitalClock;
            this.f2523a = context;
            this.f2524b = onTimeSetListener;
        }

        public void onClick(View v) {
            this.f2525c.f2540j = new TimePickerDialog(this.f2523a, this.f2524b, this.f2525c.f2541k, this.f2525c.f2542l, C0860w.m4038b(this.f2525c.getContext()));
            SpannableString spannedShit = new SpannableString(this.f2523a.getString(R.string.time_picker_dialog_title));
            spannedShit.setSpan(new ForegroundColorSpan(this.f2523a.getResources().getColor(R.color.dialog_holo_default_title_color)), 0, spannedShit.length(), 0);
            this.f2525c.f2540j.setTitle(spannedShit);
            this.f2525c.f2540j.show();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.DigitalClock.a */
    static class C0879a {
        private final TextView f2526a;
        private final String f2527b;
        private final String f2528c;
        private final View f2529d;

        C0879a(View parent) {
            this.f2529d = parent;
            this.f2526a = (TextView) parent.findViewById(R.id.am_pm);
            String[] ampm = new DateFormatSymbols().getAmPmStrings();
            this.f2527b = ampm[0];
            this.f2528c = ampm[1];
        }

        void m4085a(boolean show) {
            if (!this.f2529d.isInEditMode()) {
                this.f2526a.setVisibility(show ? 0 : 8);
            }
        }

        void m4086b(boolean isMorning) {
            if (!this.f2529d.isInEditMode()) {
                this.f2526a.setText(isMorning ? this.f2527b : this.f2528c);
            }
        }

        TextView m4084a() {
            return this.f2526a;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.DigitalClock.b */
    private class C0880b extends ContentObserver {
        final /* synthetic */ DigitalClock f2530a;

        public C0880b(DigitalClock digitalClock) {
            this.f2530a = digitalClock;
            super(new Handler());
        }

        public void onChange(boolean selfChange) {
            this.f2530a.m4095b();
            this.f2530a.m4092a();
        }
    }

    public static String m4089a(Context context) {
        return C0860w.m4038b(context) ? "HH:mm" : "h:mm aa";
    }

    public void setTextColor(int color) {
        this.f2536f.setTextColor(color);
        this.f2537g.m4084a().setTextColor(color);
    }

    public DigitalClock(Context context) {
        this(context, null);
    }

    public DigitalClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2533b = true;
        this.f2534c = new Handler();
        this.f2543m = new C08771(this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f2536f = (TextView) findViewById(R.id.time_display);
        if (f2531d != null) {
            this.f2536f.setTypeface(f2531d);
        }
        this.f2537g = new C0879a(this);
        this.f2532a = Calendar.getInstance();
        m4095b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.f2539i) {
            this.f2539i = true;
            if (this.f2533b) {
                IntentFilter filter = new IntentFilter();
                filter.addAction("android.intent.action.TIME_TICK");
                filter.addAction("android.intent.action.TIME_SET");
                filter.addAction("android.intent.action.TIMEZONE_CHANGED");
                getContext().registerReceiver(this.f2543m, filter);
            }
            this.f2538h = new C0880b(this);
            getContext().getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.f2538h);
            m4092a();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2539i) {
            this.f2539i = false;
            try {
                getContext().unregisterReceiver(this.f2543m);
            } catch (Exception e) {
            }
            getContext().getContentResolver().unregisterContentObserver(this.f2538h);
            if (this.f2540j != null) {
                this.f2540j.dismiss();
            }
        }
    }

    public void m4094a(Context context, OnTimeSetListener listener) {
        setOnClickListener(new C08782(this, context, listener));
    }

    public void m4093a(int hours, int minute) {
        this.f2541k = hours;
        this.f2542l = minute;
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, hours);
        calendar.set(12, minute);
        calendar.set(13, 0);
        setStaticTime(calendar);
    }

    public Calendar getClockCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, this.f2541k);
        calendar.set(12, this.f2542l);
        return calendar;
    }

    public void setStaticTime(Calendar c) {
        this.f2532a = c;
        this.f2533b = false;
        m4092a();
    }

    public void setStaticTime(RedesignAlarm alarm) {
        Calendar c = Calendar.getInstance();
        this.f2541k = alarm.f2009j;
        this.f2542l = alarm.f2023x;
        c.set(11, alarm.f2009j);
        c.set(12, alarm.f2023x);
        setStaticTime(c);
    }

    void m4092a() {
        if (this.f2533b) {
            this.f2532a.setTimeInMillis(System.currentTimeMillis());
        }
        this.f2541k = this.f2532a.get(11);
        this.f2542l = this.f2532a.get(12);
        CharSequence newTime = new SimpleDateFormat(this.f2535e).format(this.f2532a.getTime());
        TextView textView = this.f2536f;
        if (isInEditMode()) {
            newTime = "08:00";
        }
        textView.setText(newTime);
        this.f2537g.m4086b(this.f2532a.get(9) == 0);
    }

    void m4095b() {
        this.f2535e = C0860w.m4038b(getContext()) ? "HH:mm" : "h:mm";
        this.f2537g.m4085a(this.f2535e.equals("h:mm"));
    }

    public void setLive(boolean live) {
        this.f2533b = live;
    }

    public void setTypeface(Typeface tf) {
        this.f2536f.setTypeface(tf);
    }
}
