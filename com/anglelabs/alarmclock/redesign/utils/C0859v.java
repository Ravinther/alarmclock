package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.SystemClock;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0610c;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.v */
public class C0859v implements SensorEventListener {
    private final float[] f2459a;
    private SensorManager f2460b;
    private boolean f2461c;
    private long f2462d;
    private long f2463e;
    private final double f2464f;
    private final C0610c f2465g;
    private final long f2466h;
    private final Handler f2467i;
    private final Context f2468j;

    public C0859v(Context context, C0610c callback, Handler handler, long shakeDuration) {
        this.f2465g = callback;
        this.f2466h = shakeDuration;
        this.f2468j = context;
        this.f2467i = handler;
        this.f2459a = new float[3];
        this.f2464f = 10.0d;
        m4027a();
    }

    public void m4027a() {
        try {
            if (this.f2460b == null) {
                this.f2460b = (SensorManager) this.f2468j.getSystemService("sensor");
                this.f2460b.registerListener(this, this.f2460b.getDefaultSensor(1), 1, this.f2467i);
            }
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public void onSensorChanged(SensorEvent event) {
        try {
            if (event.sensor.getType() != 1) {
                return;
            }
            if (this.f2461c) {
                long currentTime = SystemClock.uptimeMillis();
                if (currentTime - this.f2463e > 333) {
                    this.f2461c = false;
                    return;
                } else if (Math.sqrt((Math.pow((double) (event.values[0] - this.f2459a[0]), 2.0d) + Math.pow((double) (event.values[1] - this.f2459a[1]), 2.0d)) + Math.pow((double) (event.values[2] - this.f2459a[2]), 2.0d)) <= this.f2464f) {
                    return;
                } else {
                    if (currentTime - this.f2462d >= this.f2466h) {
                        m4028b();
                        this.f2465g.m2815c();
                        return;
                    }
                    this.f2459a[0] = event.values[0];
                    this.f2459a[1] = event.values[1];
                    this.f2459a[2] = event.values[2];
                    this.f2463e = currentTime;
                    return;
                }
            }
            this.f2461c = true;
            this.f2459a[0] = event.values[0];
            this.f2459a[1] = event.values[1];
            this.f2459a[2] = event.values[2];
            this.f2462d = SystemClock.uptimeMillis();
            this.f2463e = this.f2462d;
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public void m4028b() {
        if (this.f2460b != null) {
            this.f2460b.unregisterListener(this);
            this.f2460b = null;
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
