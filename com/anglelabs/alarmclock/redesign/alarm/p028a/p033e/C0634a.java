package com.anglelabs.alarmclock.redesign.alarm.p028a.p033e;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.anglelabs.alarmclock.redesign.alarm.C0633e;
import com.anglelabs.alarmclock.redesign.alarm.p028a.C0613a;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.drive.DriveFile;
import com.mopub.mobileads.CustomEventBannerAdapter;
import java.lang.ref.WeakReference;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.e.a */
public final class C0634a extends C0633e {
    private final AudioManager f1711e;
    private C0632a f1712f;

    /* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.e.a.a */
    private static class C0632a extends Handler {
        WeakReference f1696a;

        public C0632a(Context context) {
            this.f1696a = new WeakReference(context);
        }

        public void handleMessage(Message msg) {
            if (this.f1696a.get() == null) {
                C0850q.m3987b("context is null, aborting");
                return;
            }
            switch (msg.what) {
                case CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY /*10000*/:
                    if (this.f1696a.get() != null) {
                        m2904a((Context) this.f1696a.get(), msg);
                    }
                default:
            }
        }

        private void m2904a(Context context, Message msg) {
            if (msg.obj == null || !(msg.obj instanceof RedesignAlarm)) {
                C0850q.m3987b("alarm instance was not provided in the message, aborting");
                return;
            }
            try {
                context.startActivity(C0832m.m3925d(context, (RedesignAlarm) msg.obj));
            } catch (Exception e) {
                C0850q.m3985a(e, "AlarmService failed to bring screen back to front");
            }
        }
    }

    public C0634a(Context context, RedesignAlarm alarm) {
        super(context, alarm);
        this.f1711e = (AudioManager) context.getSystemService("audio");
    }

    public void m2927a(Context context, boolean inCall) {
        this.c = 3;
        try {
            if (this.f1712f == null) {
                this.f1712f = new C0632a(context);
            }
            m2924f();
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(this.a.f2001b).addFlags(DriveFile.MODE_READ_ONLY));
            this.f1712f.sendMessageDelayed(this.f1712f.obtainMessage(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY, this.a), 5000);
        } catch (Exception e) {
            C0970a.m4322a(e);
            m2912a(context, this.a);
        }
    }

    private void m2924f() {
        if (this.a.f2016q) {
            C0613a.m2828a(this.d, null, this.f1711e, 3);
        }
        if (this.a.f2018s) {
            this.f1711e.setStreamVolume(3, 0, 0);
        } else {
            this.f1711e.setStreamVolume(3, m2923a(this.a, this.f1711e), 0);
        }
    }

    private int m2923a(RedesignAlarm a, AudioManager audioManager) {
        int volume = (a.f1997J * audioManager.getStreamMaxVolume(3)) / 100;
        if (volume == 0) {
            return 1;
        }
        return volume;
    }

    public void m2929e(Context context) {
        super.m2922e(context);
        this.f1711e.setStreamVolume(3, 0, 0);
    }

    public void m2928b(Context context, boolean isInCall) {
        super.m2916b(context, isInCall);
        if (isInCall) {
            this.f1711e.setStreamVolume(3, 0, 0);
        } else {
            m2924f();
        }
    }

    public Uri m2926a(Context context) {
        return null;
    }

    public OnCompletionListener m2925a() {
        return null;
    }
}
