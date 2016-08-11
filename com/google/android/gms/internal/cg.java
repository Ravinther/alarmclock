package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.avg.toolkit.ads.AdsManager;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class cg extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private final dz lC;
    private final MediaController os;
    private final C1795a ot;
    private final VideoView ou;
    private long ov;
    private String ow;

    /* renamed from: com.google.android.gms.internal.cg.a */
    private static final class C1795a {
        private final Runnable kW;
        private volatile boolean ox;

        /* renamed from: com.google.android.gms.internal.cg.a.1 */
        class C17941 implements Runnable {
            final /* synthetic */ C1795a oA;
            private final WeakReference oy;
            final /* synthetic */ cg oz;

            C17941(C1795a c1795a, cg cgVar) {
                this.oA = c1795a;
                this.oz = cgVar;
                this.oy = new WeakReference(this.oz);
            }

            public void run() {
                cg cgVar = (cg) this.oy.get();
                if (!this.oA.ox && cgVar != null) {
                    cgVar.aV();
                    this.oA.aW();
                }
            }
        }

        public C1795a(cg cgVar) {
            this.ox = false;
            this.kW = new C17941(this, cgVar);
        }

        public void aW() {
            dv.rp.postDelayed(this.kW, 250);
        }

        public void cancel() {
            this.ox = true;
            dv.rp.removeCallbacks(this.kW);
        }
    }

    public cg(Context context, dz dzVar) {
        super(context);
        this.lC = dzVar;
        this.ou = new VideoView(context);
        addView(this.ou, new LayoutParams(-1, -1, 17));
        this.os = new MediaController(context);
        this.ot = new C1795a(this);
        this.ot.aW();
        this.ou.setOnCompletionListener(this);
        this.ou.setOnPreparedListener(this);
        this.ou.setOnErrorListener(this);
    }

    private static void m8039a(dz dzVar, String str) {
        m8042a(dzVar, str, new HashMap(1));
    }

    public static void m8040a(dz dzVar, String str, String str2) {
        Object obj = str2 == null ? 1 : null;
        Map hashMap = new HashMap(obj != null ? 2 : 3);
        hashMap.put("what", str);
        if (obj == null) {
            hashMap.put("extra", str2);
        }
        m8042a(dzVar, "error", hashMap);
    }

    private static void m8041a(dz dzVar, String str, String str2, String str3) {
        Map hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        m8042a(dzVar, str, hashMap);
    }

    private static void m8042a(dz dzVar, String str, Map map) {
        map.put(DataLayer.EVENT_KEY, str);
        dzVar.m8230a("onVideoEvent", map);
    }

    public void aU() {
        if (TextUtils.isEmpty(this.ow)) {
            m8040a(this.lC, "no_src", null);
        } else {
            this.ou.setVideoPath(this.ow);
        }
    }

    public void aV() {
        long currentPosition = (long) this.ou.getCurrentPosition();
        if (this.ov != currentPosition) {
            m8041a(this.lC, "timeupdate", AdsManager.PREFS_KEY_TIME, String.valueOf(((float) currentPosition) / 1000.0f));
            this.ov = currentPosition;
        }
    }

    public void m8043b(MotionEvent motionEvent) {
        this.ou.dispatchTouchEvent(motionEvent);
    }

    public void destroy() {
        this.ot.cancel();
        this.ou.stopPlayback();
    }

    public void m8044k(boolean z) {
        if (z) {
            this.ou.setMediaController(this.os);
            return;
        }
        this.os.hide();
        this.ou.setMediaController(null);
    }

    public void m8045o(String str) {
        this.ow = str;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m8039a(this.lC, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        m8040a(this.lC, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m8041a(this.lC, "canplaythrough", "duration", String.valueOf(((float) this.ou.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.ou.pause();
    }

    public void play() {
        this.ou.start();
    }

    public void seekTo(int timeInMilliseconds) {
        this.ou.seekTo(timeInMilliseconds);
    }
}
