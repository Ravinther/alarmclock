package com.anglelabs.alarmclock.redesign.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.C0870z.C0869a;
import com.avg.toolkit.ITKSvc;

public class TimeDisplayBar extends LinearLayout {
    private TextView f2578a;
    private TextView f2579b;
    private TextView f2580c;
    private TextView f2581d;
    private TextView f2582e;
    private TextView f2583f;
    private TextView f2584g;
    private TextView f2585h;
    private TextView f2586i;
    private long f2587j;
    private long f2588k;
    private long f2589l;
    private long f2590m;
    private C0869a f2591n;
    private boolean f2592o;
    private float f2593p;

    @SuppressLint({"NewApi"})
    public TimeDisplayBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f2590m = 0;
        this.f2592o = true;
        this.f2593p = 0.0f;
        m4113b();
    }

    public TimeDisplayBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2590m = 0;
        this.f2592o = true;
        this.f2593p = 0.0f;
        m4113b();
    }

    public TimeDisplayBar(Context context) {
        super(context);
        this.f2590m = 0;
        this.f2592o = true;
        this.f2593p = 0.0f;
        m4113b();
    }

    public void setTextColor(int color) {
        this.f2586i.setTextColor(color);
        this.f2578a.setTextColor(color);
        this.f2582e.setTextColor(color);
        this.f2579b.setTextColor(color);
        this.f2583f.setTextColor(color);
        this.f2580c.setTextColor(color);
        this.f2584g.setTextColor(color);
        this.f2581d.setTextColor(color);
        this.f2585h.setTextColor(color);
    }

    private void m4113b() {
        setOrientation(0);
        inflate(getContext(), R.layout.redesign_time_bar_layout, this);
        this.f2586i = (TextView) findViewById(R.id.time_bar_minus_time_digit);
        this.f2578a = (TextView) findViewById(R.id.time_bar_hours_number);
        this.f2582e = (TextView) findViewById(R.id.time_bar_hours_digit);
        this.f2579b = (TextView) findViewById(R.id.time_bar_minutes_number);
        this.f2583f = (TextView) findViewById(R.id.time_bar_minutes_digit);
        this.f2580c = (TextView) findViewById(R.id.time_bar_seconds_number);
        this.f2584g = (TextView) findViewById(R.id.time_bar_seconds_digit);
        this.f2581d = (TextView) findViewById(R.id.time_bar_millis_number);
        this.f2585h = (TextView) findViewById(R.id.time_bar_millis_digit);
        this.f2586i.setText("-");
        this.f2582e.setText("H");
        this.f2583f.setText("M");
        this.f2584g.setText("S");
        this.f2585h.setText(".");
        this.f2579b.setText(ITKSvc.CODEREVISION);
        this.f2580c.setText(ITKSvc.CODEREVISION);
        this.f2581d.setText("00");
        this.f2593p = this.f2578a.getTextSize() / getResources().getDisplayMetrics().density;
    }

    public boolean m4114a() {
        long j = this.f2590m;
        this.f2589l = j;
        this.f2588k = j;
        this.f2587j = j;
        return j == 0;
    }

    public void setStopWatchTime(long timeInMillis) {
        this.f2591n = C0870z.m4057a(timeInMillis);
        if (this.f2591n.f2505d > 0 && this.f2591n.f2505d != this.f2587j) {
            this.f2578a.setText(String.valueOf(this.f2591n.f2505d));
            this.f2587j = this.f2591n.f2505d;
        } else if (this.f2591n.f2505d == 0) {
            this.f2578a.setVisibility(8);
            this.f2582e.setVisibility(8);
        }
        if (this.f2591n.f2504c != this.f2588k) {
            this.f2579b.setText(String.valueOf(this.f2591n.f2504c));
            this.f2588k = this.f2591n.f2504c;
        }
        if (this.f2591n.f2503b != this.f2589l) {
            this.f2580c.setText(String.valueOf(this.f2591n.f2503b));
            this.f2589l = this.f2591n.f2503b;
        }
        this.f2581d.setText(this.f2591n.f2502a < 10 ? ITKSvc.CODEREVISION + this.f2591n.f2502a : String.valueOf(this.f2591n.f2502a));
        this.f2590m = this.f2591n.f2502a;
    }

    public void setShowHundredths(boolean show) {
        this.f2592o = show;
        if (this.f2592o) {
            this.f2581d.setVisibility(0);
            this.f2585h.setVisibility(0);
            return;
        }
        this.f2581d.setVisibility(8);
        this.f2585h.setVisibility(8);
    }

    public void setTimerTime(long timeInMillis) {
        boolean negTime = false;
        boolean showNegTime = false;
        if (timeInMillis < 0) {
            timeInMillis = -timeInMillis;
            showNegTime = true;
            negTime = true;
        }
        this.f2591n = C0870z.m4057a(timeInMillis);
        if (this.f2591n.f2505d > 99) {
            this.f2591n.f2505d = 0;
        }
        if (this.f2591n.f2505d == 0 && this.f2591n.f2504c == 0 && this.f2591n.f2503b == 0) {
            showNegTime = false;
        }
        if (!(this.f2592o || r1 || this.f2591n.f2502a == 0)) {
            C0869a c0869a = this.f2591n;
            c0869a.f2503b++;
            if (this.f2591n.f2503b == 60) {
                this.f2591n.f2503b = 0;
                c0869a = this.f2591n;
                c0869a.f2504c++;
                if (this.f2591n.f2504c == 60) {
                    this.f2591n.f2504c = 0;
                    c0869a = this.f2591n;
                    c0869a.f2505d++;
                }
            }
        }
        if (this.f2591n.f2505d > 0) {
            this.f2582e.setVisibility(0);
            this.f2578a.setVisibility(0);
            this.f2578a.setText(String.format(showNegTime ? "-%01d" : "%01d", new Object[]{Long.valueOf(this.f2591n.f2505d)}));
        } else {
            this.f2578a.setVisibility(8);
            this.f2582e.setVisibility(8);
        }
        String format;
        if (this.f2591n.f2504c >= 10 || this.f2591n.f2505d > 0) {
            format = (showNegTime && this.f2591n.f2505d == 0) ? "-%02d" : "%02d";
            this.f2579b.setText(String.format(format, new Object[]{Long.valueOf(this.f2591n.f2504c)}));
        } else {
            format = (showNegTime && this.f2591n.f2505d == 0) ? "-%01d" : "%01d";
            this.f2579b.setText(String.format(format, new Object[]{Long.valueOf(this.f2591n.f2504c)}));
        }
        this.f2580c.setText(String.format("%02d", new Object[]{Long.valueOf(this.f2591n.f2503b)}));
        if (this.f2592o) {
            this.f2581d.setText(String.format("%02d", new Object[]{Long.valueOf(this.f2591n.f2502a)}));
        }
    }

    public void setTextSize(float size) {
        this.f2578a.setTextSize(size);
        this.f2579b.setTextSize(size);
        this.f2580c.setTextSize(size);
        this.f2581d.setTextSize(size);
    }

    public void setBold(boolean isBold) {
        int typeface = isBold ? 1 : 0;
        this.f2578a.setTypeface(null, typeface);
        this.f2579b.setTypeface(null, typeface);
        this.f2580c.setTypeface(null, typeface);
        this.f2581d.setTypeface(null, typeface);
    }

    public float getDefaultTextSize() {
        return this.f2593p;
    }

    public float getTextSize() {
        return this.f2578a.getTextSize() / getResources().getDisplayMetrics().density;
    }
}
