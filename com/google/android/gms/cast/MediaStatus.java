package com.google.android.gms.cast;

import com.google.android.gms.internal.eo;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    private long yA;
    private long yB;
    private double yC;
    private boolean yD;
    private JSONObject yn;
    private MediaInfo yo;
    private long yw;
    private double yx;
    private int yy;
    private int yz;

    public MediaStatus(JSONObject json) {
        m6142a(json, IDLE_REASON_NONE);
    }

    public int m6142a(JSONObject jSONObject, int i) {
        int i2;
        double d;
        long b;
        int i3 = PLAYER_STATE_PLAYING;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.yw) {
            this.yw = j;
            i2 = PLAYER_STATE_IDLE;
        } else {
            i2 = IDLE_REASON_NONE;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i4 = string.equals("IDLE") ? PLAYER_STATE_IDLE : string.equals("PLAYING") ? PLAYER_STATE_PLAYING : string.equals("PAUSED") ? PLAYER_STATE_PAUSED : string.equals("BUFFERING") ? PLAYER_STATE_BUFFERING : IDLE_REASON_NONE;
            if (i4 != this.yy) {
                this.yy = i4;
                i2 |= PLAYER_STATE_PLAYING;
            }
            if (i4 == PLAYER_STATE_IDLE && jSONObject.has("idleReason")) {
                string = jSONObject.getString("idleReason");
                if (!string.equals("CANCELLED")) {
                    i3 = string.equals("INTERRUPTED") ? PLAYER_STATE_PAUSED : string.equals("FINISHED") ? PLAYER_STATE_IDLE : string.equals("ERROR") ? PLAYER_STATE_BUFFERING : IDLE_REASON_NONE;
                }
                if (i3 != this.yz) {
                    this.yz = i3;
                    i2 |= PLAYER_STATE_PLAYING;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            d = jSONObject.getDouble("playbackRate");
            if (this.yx != d) {
                this.yx = d;
                i2 |= PLAYER_STATE_PLAYING;
            }
        }
        if (jSONObject.has("currentTime") && (i & PLAYER_STATE_PLAYING) == 0) {
            b = eo.m8366b(jSONObject.getDouble("currentTime"));
            if (b != this.yA) {
                this.yA = b;
                i2 |= PLAYER_STATE_PLAYING;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            b = jSONObject.getLong("supportedMediaCommands");
            if (b != this.yB) {
                this.yB = b;
                i2 |= PLAYER_STATE_PLAYING;
            }
        }
        if (jSONObject.has("volume") && (i & PLAYER_STATE_IDLE) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            d = jSONObject2.getDouble("level");
            if (d != this.yC) {
                this.yC = d;
                i2 |= PLAYER_STATE_PLAYING;
            }
            boolean z = jSONObject2.getBoolean("muted");
            if (z != this.yD) {
                this.yD = z;
                i2 |= PLAYER_STATE_PLAYING;
            }
        }
        if (jSONObject.has("customData")) {
            this.yn = jSONObject.getJSONObject("customData");
            i2 |= PLAYER_STATE_PLAYING;
        }
        if (!jSONObject.has("media")) {
            return i2;
        }
        jSONObject2 = jSONObject.getJSONObject("media");
        this.yo = new MediaInfo(jSONObject2);
        i2 |= PLAYER_STATE_PLAYING;
        return jSONObject2.has("metadata") ? i2 | PLAYER_STATE_BUFFERING : i2;
    }

    public long dC() {
        return this.yw;
    }

    public JSONObject getCustomData() {
        return this.yn;
    }

    public int getIdleReason() {
        return this.yz;
    }

    public MediaInfo getMediaInfo() {
        return this.yo;
    }

    public double getPlaybackRate() {
        return this.yx;
    }

    public int getPlayerState() {
        return this.yy;
    }

    public long getStreamPosition() {
        return this.yA;
    }

    public double getStreamVolume() {
        return this.yC;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.yB & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.yD;
    }
}
