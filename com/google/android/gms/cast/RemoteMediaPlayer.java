package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.C1423a;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.es;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.eu;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_REPLACED = 4;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 3;
    private final Object li;
    private final es yE;
    private final C1449a yF;
    private OnMetadataUpdatedListener yG;
    private OnStatusUpdatedListener yH;

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.1 */
    class C14381 extends es {
        final /* synthetic */ RemoteMediaPlayer yI;

        C14381(RemoteMediaPlayer remoteMediaPlayer) {
            this.yI = remoteMediaPlayer;
        }

        protected void onMetadataUpdated() {
            this.yI.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.yI.onStatusUpdated();
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b */
    private static abstract class C1439b extends C1423a {
        eu yW;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.1 */
        class C14501 implements eu {
            final /* synthetic */ C1439b yX;

            C14501(C1439b c1439b) {
                this.yX = c1439b;
            }

            public void m6193a(long j, int i, JSONObject jSONObject) {
                this.yX.m6054a(new C1452c(new Status(i), jSONObject));
            }

            public void m6194l(long j) {
                this.yX.m6054a(this.yX.m6170j(new Status(RemoteMediaPlayer.STATUS_REPLACED)));
            }
        }

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.b.2 */
        class C14512 implements MediaChannelResult {
            final /* synthetic */ Status wz;
            final /* synthetic */ C1439b yX;

            C14512(C1439b c1439b, Status status) {
                this.yX = c1439b;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }
        }

        C1439b() {
            this.yW = new C14501(this);
        }

        public /* synthetic */ Result m6169d(Status status) {
            return m6170j(status);
        }

        public MediaChannelResult m6170j(Status status) {
            return new C14512(this, status);
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.2 */
    class C14402 extends C1439b {
        final /* synthetic */ RemoteMediaPlayer yI;
        final /* synthetic */ GoogleApiClient yJ;
        final /* synthetic */ MediaInfo yK;
        final /* synthetic */ boolean yL;
        final /* synthetic */ long yM;
        final /* synthetic */ JSONObject yN;

        C14402(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) {
            this.yI = remoteMediaPlayer;
            this.yJ = googleApiClient;
            this.yK = mediaInfo;
            this.yL = z;
            this.yM = j;
            this.yN = jSONObject;
        }

        protected void m6172a(en enVar) {
            synchronized (this.yI.li) {
                this.yI.yF.m6190b(this.yJ);
                try {
                    this.yI.yE.m6163a(this.yW, this.yK, this.yL, this.yM, this.yN);
                    this.yI.yF.m6190b(null);
                } catch (IOException e) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (Throwable th) {
                    this.yI.yF.m6190b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.3 */
    class C14413 extends C1439b {
        final /* synthetic */ RemoteMediaPlayer yI;
        final /* synthetic */ GoogleApiClient yJ;
        final /* synthetic */ JSONObject yN;

        C14413(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.yI = remoteMediaPlayer;
            this.yJ = googleApiClient;
            this.yN = jSONObject;
        }

        protected void m6174a(en enVar) {
            synchronized (this.yI.li) {
                this.yI.yF.m6190b(this.yJ);
                try {
                    this.yI.yE.m6164a(this.yW, this.yN);
                    this.yI.yF.m6190b(null);
                } catch (IOException e) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (Throwable th) {
                    this.yI.yF.m6190b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.4 */
    class C14424 extends C1439b {
        final /* synthetic */ RemoteMediaPlayer yI;
        final /* synthetic */ GoogleApiClient yJ;
        final /* synthetic */ JSONObject yN;

        C14424(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.yI = remoteMediaPlayer;
            this.yJ = googleApiClient;
            this.yN = jSONObject;
        }

        protected void m6176a(en enVar) {
            synchronized (this.yI.li) {
                this.yI.yF.m6190b(this.yJ);
                try {
                    this.yI.yE.m6167b(this.yW, this.yN);
                    this.yI.yF.m6190b(null);
                } catch (IOException e) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (Throwable th) {
                    this.yI.yF.m6190b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.5 */
    class C14435 extends C1439b {
        final /* synthetic */ RemoteMediaPlayer yI;
        final /* synthetic */ GoogleApiClient yJ;
        final /* synthetic */ JSONObject yN;

        C14435(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
            this.yI = remoteMediaPlayer;
            this.yJ = googleApiClient;
            this.yN = jSONObject;
        }

        protected void m6178a(en enVar) {
            synchronized (this.yI.li) {
                this.yI.yF.m6190b(this.yJ);
                try {
                    this.yI.yE.m6168c(this.yW, this.yN);
                    this.yI.yF.m6190b(null);
                } catch (IOException e) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (Throwable th) {
                    this.yI.yF.m6190b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.6 */
    class C14446 extends C1439b {
        final /* synthetic */ RemoteMediaPlayer yI;
        final /* synthetic */ GoogleApiClient yJ;
        final /* synthetic */ JSONObject yN;
        final /* synthetic */ long yO;
        final /* synthetic */ int yP;

        C14446(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, long j, int i, JSONObject jSONObject) {
            this.yI = remoteMediaPlayer;
            this.yJ = googleApiClient;
            this.yO = j;
            this.yP = i;
            this.yN = jSONObject;
        }

        protected void m6180a(en enVar) {
            synchronized (this.yI.li) {
                this.yI.yF.m6190b(this.yJ);
                try {
                    this.yI.yE.m6162a(this.yW, this.yO, this.yP, this.yN);
                    this.yI.yF.m6190b(null);
                } catch (IOException e) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (Throwable th) {
                    this.yI.yF.m6190b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.7 */
    class C14457 extends C1439b {
        final /* synthetic */ RemoteMediaPlayer yI;
        final /* synthetic */ GoogleApiClient yJ;
        final /* synthetic */ JSONObject yN;
        final /* synthetic */ double yQ;

        C14457(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, double d, JSONObject jSONObject) {
            this.yI = remoteMediaPlayer;
            this.yJ = googleApiClient;
            this.yQ = d;
            this.yN = jSONObject;
        }

        protected void m6182a(en enVar) {
            synchronized (this.yI.li) {
                this.yI.yF.m6190b(this.yJ);
                try {
                    this.yI.yE.m6161a(this.yW, this.yQ, this.yN);
                    this.yI.yF.m6190b(null);
                } catch (IllegalStateException e) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (IllegalArgumentException e2) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (IOException e3) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (Throwable th) {
                    this.yI.yF.m6190b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.8 */
    class C14468 extends C1439b {
        final /* synthetic */ RemoteMediaPlayer yI;
        final /* synthetic */ GoogleApiClient yJ;
        final /* synthetic */ JSONObject yN;
        final /* synthetic */ boolean yR;

        C14468(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, boolean z, JSONObject jSONObject) {
            this.yI = remoteMediaPlayer;
            this.yJ = googleApiClient;
            this.yR = z;
            this.yN = jSONObject;
        }

        protected void m6184a(en enVar) {
            synchronized (this.yI.li) {
                this.yI.yF.m6190b(this.yJ);
                try {
                    this.yI.yE.m6165a(this.yW, this.yR, this.yN);
                    this.yI.yF.m6190b(null);
                } catch (IllegalStateException e) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (IOException e2) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (Throwable th) {
                    this.yI.yF.m6190b(null);
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.9 */
    class C14479 extends C1439b {
        final /* synthetic */ RemoteMediaPlayer yI;
        final /* synthetic */ GoogleApiClient yJ;

        C14479(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
            this.yI = remoteMediaPlayer;
            this.yJ = googleApiClient;
        }

        protected void m6186a(en enVar) {
            synchronized (this.yI.li) {
                this.yI.yF.m6190b(this.yJ);
                try {
                    this.yI.yE.m6160a(this.yW);
                    this.yI.yF.m6190b(null);
                } catch (IOException e) {
                    m6054a(m6170j(new Status(RemoteMediaPlayer.STATUS_FAILED)));
                    this.yI.yF.m6190b(null);
                } catch (Throwable th) {
                    this.yI.yF.m6190b(null);
                }
            }
        }
    }

    public interface MediaChannelResult extends Result {
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a */
    private class C1449a implements et {
        final /* synthetic */ RemoteMediaPlayer yI;
        private GoogleApiClient yS;
        private long yT;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.a.a */
        private final class C1448a implements ResultCallback {
            private final long yU;
            final /* synthetic */ C1449a yV;

            C1448a(C1449a c1449a, long j) {
                this.yV = c1449a;
                this.yU = j;
            }

            public void m6187i(Status status) {
                if (!status.isSuccess()) {
                    this.yV.yI.yE.m6166a(this.yU, status.getStatusCode());
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                m6187i((Status) x0);
            }
        }

        public C1449a(RemoteMediaPlayer remoteMediaPlayer) {
            this.yI = remoteMediaPlayer;
            this.yT = 0;
        }

        public void m6189a(String str, String str2, long j, String str3) {
            if (this.yS == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.yS, str, str2).setResultCallback(new C1448a(this, j));
        }

        public void m6190b(GoogleApiClient googleApiClient) {
            this.yS = googleApiClient;
        }

        public long dD() {
            long j = this.yT + 1;
            this.yT = j;
            return j;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer.c */
    private static final class C1452c implements MediaChannelResult {
        private final Status wJ;
        private final JSONObject yn;

        C1452c(Status status, JSONObject jSONObject) {
            this.wJ = status;
            this.yn = jSONObject;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    public RemoteMediaPlayer() {
        this.li = new Object();
        this.yF = new C1449a(this);
        this.yE = new C14381(this);
        this.yE.m6145a(this.yF);
    }

    private void onMetadataUpdated() {
        if (this.yG != null) {
            this.yG.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.yH != null) {
            this.yH.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.li) {
            approximateStreamPosition = this.yE.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.li) {
            mediaInfo = this.yE.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.li) {
            mediaStatus = this.yE.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.yE.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.li) {
            streamDuration = this.yE.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null);
    }

    public PendingResult load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null);
    }

    public PendingResult load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null);
    }

    public PendingResult load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return apiClient.m6239b(new C14402(this, apiClient, mediaInfo, autoplay, playPosition, customData));
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.yE.m6159U(message);
    }

    public PendingResult pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult pause(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m6239b(new C14413(this, apiClient, customData));
    }

    public PendingResult play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult play(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m6239b(new C14435(this, apiClient, customData));
    }

    public PendingResult requestStatus(GoogleApiClient apiClient) {
        return apiClient.m6239b(new C14479(this, apiClient));
    }

    public PendingResult seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, STATUS_SUCCEEDED, null);
    }

    public PendingResult seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        return apiClient.m6239b(new C14446(this, apiClient, position, resumeState, customData));
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.yG = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.yH = listener;
    }

    public PendingResult setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        return apiClient.m6239b(new C14468(this, apiClient, muteState, customData));
    }

    public PendingResult setStreamVolume(GoogleApiClient apiClient, double volume) {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) {
        if (!Double.isInfinite(volume) && !Double.isNaN(volume)) {
            return apiClient.m6239b(new C14457(this, apiClient, volume, customData));
        }
        throw new IllegalArgumentException("Volume cannot be " + volume);
    }

    public PendingResult stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult stop(GoogleApiClient apiClient, JSONObject customData) {
        return apiClient.m6239b(new C14424(this, apiClient, customData));
    }
}
