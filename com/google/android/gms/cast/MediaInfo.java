package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.eo;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.gp;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    private final String yi;
    private int yj;
    private String yk;
    private MediaMetadata yl;
    private long ym;
    private JSONObject yn;

    public static class Builder {
        private final MediaInfo yo;

        public Builder(String contentId) {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.yo = new MediaInfo(contentId);
        }

        public MediaInfo build() {
            this.yo.dA();
            return this.yo;
        }

        public Builder setContentType(String contentType) {
            this.yo.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.yo.m6131b(customData);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.yo.m6130a(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) {
            this.yo.m6132k(duration);
            return this;
        }

        public Builder setStreamType(int streamType) {
            this.yo.setStreamType(streamType);
            return this;
        }
    }

    MediaInfo(String contentId) {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.yi = contentId;
        this.yj = STREAM_TYPE_INVALID;
    }

    MediaInfo(JSONObject json) {
        this.yi = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.yj = 0;
        } else if ("BUFFERED".equals(string)) {
            this.yj = STREAM_TYPE_BUFFERED;
        } else if ("LIVE".equals(string)) {
            this.yj = STREAM_TYPE_LIVE;
        } else {
            this.yj = STREAM_TYPE_INVALID;
        }
        this.yk = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.yl = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.yl.m6141c(jSONObject);
        }
        this.ym = eo.m8366b(json.optDouble("duration", 0.0d));
        this.yn = json.optJSONObject("customData");
    }

    void m6130a(MediaMetadata mediaMetadata) {
        this.yl = mediaMetadata;
    }

    void m6131b(JSONObject jSONObject) {
        this.yn = jSONObject;
    }

    void dA() {
        if (TextUtils.isEmpty(this.yi)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.yk)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.yj == STREAM_TYPE_INVALID) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    public JSONObject dB() {
        JSONObject jSONObject = new JSONObject();
        try {
            Object obj;
            jSONObject.put("contentId", this.yi);
            switch (this.yj) {
                case STREAM_TYPE_BUFFERED /*1*/:
                    obj = "BUFFERED";
                    break;
                case STREAM_TYPE_LIVE /*2*/:
                    obj = "LIVE";
                    break;
                default:
                    obj = "NONE";
                    break;
            }
            jSONObject.put("streamType", obj);
            if (this.yk != null) {
                jSONObject.put("contentType", this.yk);
            }
            if (this.yl != null) {
                jSONObject.put("metadata", this.yl.dB());
            }
            jSONObject.put("duration", eo.m8367m(this.ym));
            if (this.yn != null) {
                jSONObject.put("customData", this.yn);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.yn == null ? STREAM_TYPE_BUFFERED : false) != (mediaInfo.yn == null ? STREAM_TYPE_BUFFERED : false)) {
            return false;
        }
        if (this.yn != null && mediaInfo.yn != null && !gp.m8606d(this.yn, mediaInfo.yn)) {
            return false;
        }
        if (!(eo.m8365a(this.yi, mediaInfo.yi) && this.yj == mediaInfo.yj && eo.m8365a(this.yk, mediaInfo.yk) && eo.m8365a(this.yl, mediaInfo.yl) && this.ym == mediaInfo.ym)) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.yi;
    }

    public String getContentType() {
        return this.yk;
    }

    public JSONObject getCustomData() {
        return this.yn;
    }

    public MediaMetadata getMetadata() {
        return this.yl;
    }

    public long getStreamDuration() {
        return this.ym;
    }

    public int getStreamType() {
        return this.yj;
    }

    public int hashCode() {
        return fo.hashCode(this.yi, Integer.valueOf(this.yj), this.yk, this.yl, Long.valueOf(this.ym), String.valueOf(this.yn));
    }

    void m6132k(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        }
        this.ym = j;
    }

    void setContentType(String contentType) {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.yk = contentType;
    }

    void setStreamType(int streamType) {
        if (streamType < STREAM_TYPE_INVALID || streamType > STREAM_TYPE_LIVE) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.yj = streamType;
    }
}
