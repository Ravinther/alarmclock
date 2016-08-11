package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class es extends em {
    private static final String NAMESPACE;
    private static final long zG;
    private static final long zH;
    private static final long zI;
    private static final long zJ;
    private final Handler mHandler;
    private long zK;
    private MediaStatus zL;
    private final ev zM;
    private final ev zN;
    private final ev zO;
    private final ev zP;
    private final ev zQ;
    private final ev zR;
    private final ev zS;
    private final ev zT;
    private final Runnable zU;
    private boolean zV;

    /* renamed from: com.google.android.gms.internal.es.a */
    private class C1868a implements Runnable {
        final /* synthetic */ es zW;

        private C1868a(es esVar) {
            this.zW = esVar;
        }

        public void run() {
            boolean z = false;
            this.zW.zV = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zW.zM.m8394d(elapsedRealtime, 3);
            this.zW.zN.m8394d(elapsedRealtime, 3);
            this.zW.zO.m8394d(elapsedRealtime, 3);
            this.zW.zP.m8394d(elapsedRealtime, 3);
            this.zW.zQ.m8394d(elapsedRealtime, 3);
            this.zW.zR.m8394d(elapsedRealtime, 3);
            this.zW.zS.m8394d(elapsedRealtime, 3);
            this.zW.zT.m8394d(elapsedRealtime, 3);
            synchronized (ev.Ab) {
                if (this.zW.zM.dU() || this.zW.zQ.dU() || this.zW.zR.dU() || this.zW.zS.dU() || this.zW.zT.dU()) {
                    z = true;
                }
            }
            this.zW.m6158w(z);
        }
    }

    static {
        NAMESPACE = eo.m8364X("com.google.cast.media");
        zG = TimeUnit.HOURS.toMillis(24);
        zH = TimeUnit.HOURS.toMillis(24);
        zI = TimeUnit.HOURS.toMillis(24);
        zJ = TimeUnit.SECONDS.toMillis(1);
    }

    public es() {
        this(null);
    }

    public es(String str) {
        super(NAMESPACE, "MediaControlChannel", str);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zU = new C1868a();
        this.zM = new ev(zH);
        this.zN = new ev(zG);
        this.zO = new ev(zG);
        this.zP = new ev(zG);
        this.zQ = new ev(zI);
        this.zR = new ev(zG);
        this.zS = new ev(zG);
        this.zT = new ev(zG);
        dS();
    }

    private void m6148a(long j, JSONObject jSONObject) {
        int i = 1;
        boolean n = this.zM.m8395n(j);
        int i2 = (!this.zQ.dU() || this.zQ.m8395n(j)) ? 0 : 1;
        if ((!this.zR.dU() || this.zR.m8395n(j)) && (!this.zS.dU() || this.zS.m8395n(j))) {
            i = 0;
        }
        i2 = i2 != 0 ? 2 : 0;
        if (i != 0) {
            i2 |= 1;
        }
        if (n || this.zL == null) {
            this.zL = new MediaStatus(jSONObject);
            this.zK = SystemClock.elapsedRealtime();
            i2 = 7;
        } else {
            i2 = this.zL.m6142a(jSONObject, i2);
        }
        if ((i2 & 1) != 0) {
            this.zK = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 2) != 0) {
            this.zK = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i2 & 4) != 0) {
            onMetadataUpdated();
        }
        this.zM.m8393c(j, 0);
        this.zN.m8393c(j, 0);
        this.zO.m8393c(j, 0);
        this.zP.m8393c(j, 0);
        this.zQ.m8393c(j, 0);
        this.zR.m8393c(j, 0);
        this.zS.m8393c(j, 0);
        this.zT.m8393c(j, 0);
    }

    private void dS() {
        m6158w(false);
        this.zK = 0;
        this.zL = null;
        this.zM.clear();
        this.zQ.clear();
        this.zR.clear();
    }

    private void m6158w(boolean z) {
        if (this.zV != z) {
            this.zV = z;
            if (z) {
                this.mHandler.postDelayed(this.zU, zJ);
            } else {
                this.mHandler.removeCallbacks(this.zU);
            }
        }
    }

    public final void m6159U(String str) {
        this.yY.m8388b("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    m6148a(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.zL = null;
                onStatusUpdated();
                onMetadataUpdated();
                this.zT.m8393c(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.yY.m8390d("received unexpected error: Invalid Player State.", new Object[0]);
                jSONObject = jSONObject.optJSONObject("customData");
                this.zM.m8392b(optLong, 1, jSONObject);
                this.zN.m8392b(optLong, 1, jSONObject);
                this.zO.m8392b(optLong, 1, jSONObject);
                this.zP.m8392b(optLong, 1, jSONObject);
                this.zQ.m8392b(optLong, 1, jSONObject);
                this.zR.m8392b(optLong, 1, jSONObject);
                this.zS.m8392b(optLong, 1, jSONObject);
                this.zT.m8392b(optLong, 1, jSONObject);
            } else if (string.equals("LOAD_FAILED")) {
                this.zM.m8392b(optLong, 1, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.zM.m8392b(optLong, 2, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.yY.m8390d("received unexpected error: Invalid Request.", new Object[0]);
                jSONObject = jSONObject.optJSONObject("customData");
                this.zM.m8392b(optLong, 1, jSONObject);
                this.zN.m8392b(optLong, 1, jSONObject);
                this.zO.m8392b(optLong, 1, jSONObject);
                this.zP.m8392b(optLong, 1, jSONObject);
                this.zQ.m8392b(optLong, 1, jSONObject);
                this.zR.m8392b(optLong, 1, jSONObject);
                this.zS.m8392b(optLong, 1, jSONObject);
                this.zT.m8392b(optLong, 1, jSONObject);
            }
        } catch (JSONException e) {
            this.yY.m8390d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long m6160a(eu euVar) {
        JSONObject jSONObject = new JSONObject();
        long dE = dE();
        this.zT.m8391a(dE, euVar);
        m6158w(true);
        try {
            jSONObject.put("requestId", dE);
            jSONObject.put("type", "GET_STATUS");
            if (this.zL != null) {
                jSONObject.put("mediaSessionId", this.zL.dC());
            }
        } catch (JSONException e) {
        }
        m6146a(jSONObject.toString(), dE, null);
        return dE;
    }

    public long m6161a(eu euVar, double d, JSONObject jSONObject) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zR.m8391a(dE, euVar);
        m6158w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", dC());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m6146a(jSONObject2.toString(), dE, null);
        return dE;
    }

    public long m6162a(eu euVar, long j, int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zQ.m8391a(dE, euVar);
        m6158w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", dC());
            jSONObject2.put("currentTime", eo.m8367m(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m6146a(jSONObject2.toString(), dE, null);
        return dE;
    }

    public long m6163a(eu euVar, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zM.m8391a(dE, euVar);
        m6158w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.dB());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", eo.m8367m(j));
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m6146a(jSONObject2.toString(), dE, null);
        return dE;
    }

    public long m6164a(eu euVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zN.m8391a(dE, euVar);
        m6158w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", dC());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m6146a(jSONObject2.toString(), dE, null);
        return dE;
    }

    public long m6165a(eu euVar, boolean z, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zS.m8391a(dE, euVar);
        m6158w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", dC());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m6146a(jSONObject2.toString(), dE, null);
        return dE;
    }

    public void m6166a(long j, int i) {
        this.zM.m8393c(j, i);
        this.zN.m8393c(j, i);
        this.zO.m8393c(j, i);
        this.zP.m8393c(j, i);
        this.zQ.m8393c(j, i);
        this.zR.m8393c(j, i);
        this.zS.m8393c(j, i);
        this.zT.m8393c(j, i);
    }

    public long m6167b(eu euVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zP.m8391a(dE, euVar);
        m6158w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", dC());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m6146a(jSONObject2.toString(), dE, null);
        return dE;
    }

    public long m6168c(eu euVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long dE = dE();
        this.zO.m8391a(dE, euVar);
        m6158w(true);
        try {
            jSONObject2.put("requestId", dE);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", dC());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        m6146a(jSONObject2.toString(), dE, null);
        return dE;
    }

    public long dC() {
        if (this.zL != null) {
            return this.zL.dC();
        }
        throw new IllegalStateException("No current media session");
    }

    public void dF() {
        dS();
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zK == 0) {
            return 0;
        }
        double playbackRate = this.zL.getPlaybackRate();
        long streamPosition = this.zL.getStreamPosition();
        int playerState = this.zL.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zK;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        elapsedRealtime = mediaInfo.getStreamDuration();
        streamPosition += (long) (((double) j) * playbackRate);
        if (streamPosition <= elapsedRealtime) {
            elapsedRealtime = streamPosition < 0 ? 0 : streamPosition;
        }
        return elapsedRealtime;
    }

    public MediaInfo getMediaInfo() {
        return this.zL == null ? null : this.zL.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zL;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        return mediaInfo != null ? mediaInfo.getStreamDuration() : 0;
    }

    protected void onMetadataUpdated() {
    }

    protected void onStatusUpdated() {
    }
}
