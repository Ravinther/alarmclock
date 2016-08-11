package com.anglelabs.alarmclock.redesign.alarm;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.C0613a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.C0613a.C0604a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0615a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0615a.C0614a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p033e.C0634a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0854s;
import java.io.IOException;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.e */
public abstract class C0633e implements OnErrorListener, OnPreparedListener, C0604a, C0615a, C0614a {
    protected final RedesignAlarm f1697a;
    protected int f1698b;
    protected int f1699c;
    protected final Context f1700d;
    private MediaPlayer f1701e;
    private boolean f1702f;
    private final AudioManager f1703g;
    private boolean f1704h;
    private boolean f1705i;
    private int f1706j;
    private int f1707k;
    private int f1708l;
    private int f1709m;
    private int f1710n;

    public abstract OnCompletionListener m2910a();

    public abstract Uri m2911a(Context context);

    public C0633e(Context context, RedesignAlarm alarm) {
        this.f1706j = -1;
        this.f1707k = -1;
        this.f1708l = -1;
        this.f1709m = -1;
        this.f1710n = -1;
        this.f1697a = alarm;
        if (!(this instanceof C0634a)) {
            this.f1701e = m2914b();
        }
        this.f1703g = (AudioManager) context.getSystemService("audio");
        this.f1700d = context;
        m2907a(this.f1703g, context);
    }

    MediaPlayer m2914b() {
        if (this.f1701e == null) {
            this.f1701e = new MediaPlayer();
        } else {
            this.f1701e.reset();
        }
        this.f1701e.setOnErrorListener(this);
        return this.f1701e;
    }

    protected RedesignAlarm m2917c() {
        return this.f1697a;
    }

    private void m2907a(AudioManager audioManager, Context context) {
        this.f1706j = audioManager.getStreamVolume(3);
        this.f1707k = audioManager.getStreamVolume(4);
        this.f1708l = audioManager.getStreamVolume(0);
        this.f1709m = audioManager.getRingerMode();
        this.f1710n = System.getInt(context.getContentResolver(), "mode_ringer_streams_affected", 4);
    }

    public void m2913a(Context context, boolean inCall) {
        this.f1699c = C0613a.m2826a(context, (C0604a) this, this.f1701e, this.f1697a, inCall);
        Uri soundUri = null;
        try {
            if (m2910a() != null) {
                this.f1701e.setOnCompletionListener(m2910a());
            } else {
                this.f1701e.setLooping(true);
            }
            soundUri = m2911a(context);
            if (soundUri == null || !C0854s.m4007a(context, soundUri)) {
                if (soundUri == null) {
                    C0850q.m3988c("SoundController didn't find set ringtone. using fallback");
                } else {
                    C0850q.m3988c("SoundController selected song: " + soundUri.toString() + "isn't a valid audio type");
                }
                m2912a(context, this.f1697a);
                return;
            }
            this.f1701e.setDataSource(context, soundUri);
            this.f1701e.setOnPreparedListener(this);
            this.f1701e.prepareAsync();
        } catch (IOException e) {
            try {
                m2905a(context, Uri.parse(C0854s.m4014c(context, soundUri)));
            } catch (Exception e2) {
                C0850q.m3984a(e2);
                m2912a(context, this.f1697a);
            }
        } catch (Exception ex) {
            C0850q.m3984a(ex);
            m2912a(context, this.f1697a);
        }
    }

    private void m2905a(Context context, Uri soundUri) {
        if (TextUtils.isEmpty(soundUri.toString())) {
            C0850q.m3987b("sound type returned empty, using fallback");
            m2912a(context, this.f1697a);
        }
        C0694b.m3142a(context, this.f1697a, soundUri);
        try {
            this.f1701e.setDataSource(context, soundUri);
            this.f1701e.setOnPreparedListener(this);
            this.f1701e.prepareAsync();
        } catch (Exception e) {
            C0850q.m3984a(e);
            m2912a(context, this.f1697a);
        }
    }

    public void m2915b(Context context) {
        try {
            this.f1701e = m2914b();
            this.f1701e.setAudioStreamType(this.f1699c);
            this.f1701e.setOnCompletionListener(m2910a());
            this.f1703g.setMode(0);
            Uri soundUri = m2911a(context);
            if (soundUri == null) {
                C0850q.m3988c("SoundController didn't find set ringtone.  Using fallback");
                m2912a(context, this.f1697a);
            }
            this.f1701e.setDataSource(context, soundUri);
            this.f1701e.setOnPreparedListener(this);
            this.f1701e.prepareAsync();
        } catch (Exception ex) {
            C0850q.m3985a(ex, "Using fallback");
            m2912a(context, this.f1697a);
        }
    }

    public void m2918c(Context context) {
        this.f1698b = 0;
        if (this.f1701e != null) {
            this.f1701e.stop();
            this.f1701e.release();
            this.f1701e = null;
        }
        if (this.f1703g != null) {
            this.f1703g.abandonAudioFocus(null);
            this.f1703g.setStreamVolume(this.f1699c, 0, 0);
        }
    }

    public void onPrepared(MediaPlayer mp) {
        if (this.f1699c != 0 || this.f1697a.f2016q) {
            if (!this.f1697a.f2018s || this.f1698b >= this.f1697a.f1997J) {
                C0613a.m2829a(this.f1701e, this.f1697a.f1997J);
                this.f1698b = this.f1697a.f1997J;
            } else if (this.f1698b < this.f1697a.f1997J) {
                C0613a.m2829a(this.f1701e, this.f1698b);
            } else {
                C0613a.m2829a(this.f1701e, this.f1697a.f1997J);
                this.f1698b = this.f1697a.f1997J;
            }
        }
        mp.seekTo(0);
        mp.start();
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        C0850q.m3987b("AlarmService Error occurred while playing audio: what = " + what + " extra = " + extra);
        m2912a(this.f1700d, this.f1697a);
        return true;
    }

    public int m2919d() {
        if (m2917c() == null) {
            C0850q.m3987b("getAlarm() returned null, volume set to zero!");
            return 0;
        } else if (this.f1701e != null) {
            if (this.f1698b < m2917c().f1997J && !this.f1702f) {
                this.f1698b++;
                C0613a.m2829a(this.f1701e, this.f1698b);
            }
            return m2917c().f1997J - 1;
        } else {
            int maxVolume = m2908f();
            if (this.f1698b < maxVolume && !this.f1702f) {
                this.f1698b++;
                this.f1703g.adjustStreamVolume(3, 1, 0);
            }
            return maxVolume - 1;
        }
    }

    public void m2920d(Context context) {
        if (this.f1697a.f1993F == 6) {
            this.f1703g.setStreamVolume(3, 0, 0);
        } else {
            this.f1703g.setStreamVolume(3, this.f1706j, 0);
        }
        this.f1703g.setStreamVolume(4, this.f1707k, 0);
        this.f1703g.setStreamVolume(0, this.f1708l, 0);
        if (this.f1704h) {
            this.f1704h = false;
            System.putInt(context.getContentResolver(), "mode_ringer_streams_affected", this.f1710n | 4);
        }
        if (this.f1705i) {
            this.f1705i = false;
            this.f1703g.setRingerMode(this.f1709m);
        }
    }

    public void m2916b(Context context, boolean isInCall) {
        if (this.f1697a != null) {
            this.f1702f = false;
            if (isInCall) {
                C0613a.m2829a(this.f1701e, 0);
                this.f1698b = 0;
            } else if (this.f1697a.f2018s) {
                C0613a.m2829a(this.f1701e, 0);
                this.f1698b = 0;
            } else {
                C0613a.m2829a(this.f1701e, 0);
                this.f1698b = this.f1697a.f1997J;
            }
        }
    }

    public void m2922e(Context context) {
        this.f1702f = true;
        this.f1698b = 0;
        C0613a.m2829a(this.f1701e, 0);
    }

    public void m2921e() {
        this.f1705i = true;
    }

    private int m2908f() {
        int volume = (this.f1697a.f1997J * this.f1703g.getStreamMaxVolume(3)) / 100;
        if (volume == 0) {
            return 1;
        }
        return volume;
    }

    private void m2909g() {
        if (this.f1701e != null) {
            this.f1701e.reset();
        }
    }

    public void m2912a(Context context, RedesignAlarm mAlarm2) {
        try {
            C0850q.m3986a("Attempting to play default ringtone");
            this.f1703g.setMode(0);
            this.f1703g.setStreamVolume(this.f1699c, this.f1703g.getStreamMaxVolume(this.f1699c), 0);
            m2914b();
            Uri ringtoneUri = RingtoneManager.getDefaultUri(4);
            if (ringtoneUri == null || ringtoneUri.equals(Uri.EMPTY)) {
                m2906a(context.getResources(), (int) R.raw.in_call_alarm);
            } else {
                this.f1701e.setDataSource(context, ringtoneUri);
            }
            this.f1701e.setAudioStreamType(this.f1699c);
            this.f1701e.setLooping(true);
            this.f1701e.setOnPreparedListener(this);
            this.f1701e.prepareAsync();
        } catch (Exception ex) {
            try {
                C0850q.m3985a(ex, "exception while falling back to ringtone. using in_call_alarm");
                m2914b();
                m2906a(context.getResources(), (int) R.raw.in_call_alarm);
                this.f1701e.setAudioStreamType(this.f1699c);
                this.f1701e.setLooping(true);
                this.f1701e.setOnPreparedListener(this);
                this.f1701e.prepareAsync();
            } catch (Exception ex2) {
                C0850q.m3985a(ex2, "error while playing in_call_alarm, quiting...");
                m2909g();
            }
        }
    }

    private void m2906a(Resources resources, int res) {
        if (this.f1701e != null) {
            AssetFileDescriptor afd = resources.openRawResourceFd(res);
            if (afd != null) {
                this.f1701e.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
            }
        }
    }
}
