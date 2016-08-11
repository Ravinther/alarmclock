package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C1398b;
import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.C1461a.C1404b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fq;
import java.io.IOException;

public final class Cast {
    public static final Api API;
    public static final CastApi CastApi;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    static final C1457c wx;
    private static final C1398b wy;

    /* renamed from: com.google.android.gms.cast.Cast.1 */
    static class C14221 implements C1398b {
        C14221() {
        }

        public en m6102a(Context context, Looper looper, fc fcVar, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            fq.m8517b((Object) castOptions, (Object) "Setting the API options is required.");
            return new en(context, looper, castOptions.xT, (long) castOptions.xV, castOptions.xU, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    /* renamed from: com.google.android.gms.cast.Cast.a */
    protected static abstract class C1423a extends C1404b {
        public C1423a() {
            super(Cast.wx);
        }

        public void m6103c(int i, String str) {
            m6054a(m6058d(new Status(i, str, null)));
        }

        public void m6104x(int i) {
            m6054a(m6058d(new Status(i)));
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.b */
    private static abstract class C1424b extends C1423a {
        private C1424b() {
        }

        public /* synthetic */ Result m6105d(Status status) {
            return m6106f(status);
        }

        public Status m6106f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast.c */
    private static abstract class C1426c extends C1423a {

        /* renamed from: com.google.android.gms.cast.Cast.c.1 */
        class C14361 implements ApplicationConnectionResult {
            final /* synthetic */ Status wz;
            final /* synthetic */ C1426c xZ;

            C14361(C1426c c1426c, Status status) {
                this.xZ = c1426c;
                this.wz = status;
            }

            public ApplicationMetadata getApplicationMetadata() {
                return null;
            }

            public String getApplicationStatus() {
                return null;
            }

            public String getSessionId() {
                return null;
            }

            public Status getStatus() {
                return this.wz;
            }

            public boolean getWasLaunched() {
                return false;
            }
        }

        private C1426c() {
        }

        public /* synthetic */ Result m6109d(Status status) {
            return m6110h(status);
        }

        public ApplicationConnectionResult m6110h(Status status) {
            return new C14361(this, status);
        }
    }

    public interface CastApi {

        /* renamed from: com.google.android.gms.cast.Cast.CastApi.a */
        public static final class C1435a implements CastApi {

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.1 */
            class C14251 extends C1424b {
                final /* synthetic */ String xN;
                final /* synthetic */ String xO;
                final /* synthetic */ C1435a xP;

                C14251(C1435a c1435a, String str, String str2) {
                    this.xP = c1435a;
                    this.xN = str;
                    this.xO = str2;
                    super();
                }

                protected void m6108a(en enVar) {
                    try {
                        enVar.m8356a(this.xN, this.xO, (C1401d) this);
                    } catch (IllegalArgumentException e) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    } catch (IllegalStateException e2) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.2 */
            class C14272 extends C1426c {
                final /* synthetic */ C1435a xP;
                final /* synthetic */ String xQ;

                C14272(C1435a c1435a, String str) {
                    this.xP = c1435a;
                    this.xQ = str;
                    super();
                }

                protected void m6112a(en enVar) {
                    try {
                        enVar.m8357a(this.xQ, false, (C1401d) this);
                    } catch (IllegalStateException e) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.3 */
            class C14283 extends C1426c {
                final /* synthetic */ C1435a xP;
                final /* synthetic */ String xQ;
                final /* synthetic */ boolean xR;

                C14283(C1435a c1435a, String str, boolean z) {
                    this.xP = c1435a;
                    this.xQ = str;
                    this.xR = z;
                    super();
                }

                protected void m6114a(en enVar) {
                    try {
                        enVar.m8357a(this.xQ, this.xR, (C1401d) this);
                    } catch (IllegalStateException e) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.4 */
            class C14294 extends C1426c {
                final /* synthetic */ C1435a xP;
                final /* synthetic */ String xQ;
                final /* synthetic */ String xS;

                C14294(C1435a c1435a, String str, String str2) {
                    this.xP = c1435a;
                    this.xQ = str;
                    this.xS = str2;
                    super();
                }

                protected void m6116a(en enVar) {
                    try {
                        enVar.m8358b(this.xQ, this.xS, this);
                    } catch (IllegalStateException e) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.5 */
            class C14305 extends C1426c {
                final /* synthetic */ C1435a xP;
                final /* synthetic */ String xQ;

                C14305(C1435a c1435a, String str) {
                    this.xP = c1435a;
                    this.xQ = str;
                    super();
                }

                protected void m6118a(en enVar) {
                    try {
                        enVar.m8358b(this.xQ, null, this);
                    } catch (IllegalStateException e) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.6 */
            class C14316 extends C1426c {
                final /* synthetic */ C1435a xP;

                C14316(C1435a c1435a) {
                    this.xP = c1435a;
                    super();
                }

                protected void m6120a(en enVar) {
                    try {
                        enVar.m8358b(null, null, this);
                    } catch (IllegalStateException e) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.7 */
            class C14327 extends C1424b {
                final /* synthetic */ C1435a xP;

                C14327(C1435a c1435a) {
                    this.xP = c1435a;
                    super();
                }

                protected void m6122a(en enVar) {
                    try {
                        enVar.m8359e((C1401d) this);
                    } catch (IllegalStateException e) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.8 */
            class C14338 extends C1424b {
                final /* synthetic */ C1435a xP;

                C14338(C1435a c1435a) {
                    this.xP = c1435a;
                    super();
                }

                protected void m6124a(en enVar) {
                    try {
                        enVar.m8355a("", (C1401d) this);
                    } catch (IllegalStateException e) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            /* renamed from: com.google.android.gms.cast.Cast.CastApi.a.9 */
            class C14349 extends C1424b {
                final /* synthetic */ C1435a xP;
                final /* synthetic */ String xS;

                C14349(C1435a c1435a, String str) {
                    this.xP = c1435a;
                    this.xS = str;
                    super();
                }

                protected void m6126a(en enVar) {
                    if (TextUtils.isEmpty(this.xS)) {
                        m6103c(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE, "IllegalArgument: sessionId cannot be null or empty");
                        return;
                    }
                    try {
                        enVar.m8355a(this.xS, (C1401d) this);
                    } catch (IllegalStateException e) {
                        m6104x(GamesStatusCodes.STATUS_REQUEST_UPDATE_TOTAL_FAILURE);
                    }
                }
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) {
                return ((en) client.m6237a(Cast.wx)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) {
                return ((en) client.m6237a(Cast.wx)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) {
                return ((en) client.m6237a(Cast.wx)).dI();
            }

            public boolean isMute(GoogleApiClient client) {
                return ((en) client.m6237a(Cast.wx)).isMute();
            }

            public PendingResult joinApplication(GoogleApiClient client) {
                return client.m6239b(new C14316(this));
            }

            public PendingResult joinApplication(GoogleApiClient client, String applicationId) {
                return client.m6239b(new C14305(this, applicationId));
            }

            public PendingResult joinApplication(GoogleApiClient client, String applicationId, String sessionId) {
                return client.m6239b(new C14294(this, applicationId, sessionId));
            }

            public PendingResult launchApplication(GoogleApiClient client, String applicationId) {
                return client.m6239b(new C14272(this, applicationId));
            }

            public PendingResult launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return client.m6239b(new C14283(this, applicationId, relaunchIfRunning));
            }

            public PendingResult leaveApplication(GoogleApiClient client) {
                return client.m6239b(new C14327(this));
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) {
                try {
                    ((en) client.m6237a(Cast.wx)).m8350V(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) {
                try {
                    ((en) client.m6237a(Cast.wx)).dH();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult sendMessage(GoogleApiClient client, String namespace, String message) {
                return client.m6239b(new C14251(this, namespace, message));
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) {
                try {
                    ((en) client.m6237a(Cast.wx)).m8354a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) {
                try {
                    ((en) client.m6237a(Cast.wx)).m8361v(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) {
                try {
                    ((en) client.m6237a(Cast.wx)).m8351a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult stopApplication(GoogleApiClient client) {
                return client.m6239b(new C14338(this));
            }

            public PendingResult stopApplication(GoogleApiClient client, String sessionId) {
                return client.m6239b(new C14349(this, sessionId));
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient);

        String getApplicationStatus(GoogleApiClient googleApiClient);

        double getVolume(GoogleApiClient googleApiClient);

        boolean isMute(GoogleApiClient googleApiClient);

        PendingResult joinApplication(GoogleApiClient googleApiClient);

        PendingResult joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str);

        void requestStatus(GoogleApiClient googleApiClient);

        PendingResult sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback);

        void setMute(GoogleApiClient googleApiClient, boolean z);

        void setVolume(GoogleApiClient googleApiClient, double d);

        PendingResult stopApplication(GoogleApiClient googleApiClient);

        PendingResult stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice xT;
        final Listener xU;
        private final int xV;

        public static final class Builder {
            CastDevice xW;
            Listener xX;
            private int xY;

            private Builder(CastDevice castDevice, Listener castListener) {
                fq.m8517b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                fq.m8517b((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.xW = castDevice;
                this.xX = castListener;
                this.xY = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.xY |= 1;
                } else {
                    this.xY &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.xT = builder.xW;
            this.xU = builder.xX;
            this.xV = builder.xY;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castListener, null);
        }
    }

    public static abstract class Listener {
        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    static {
        wx = new C1457c();
        wy = new C14221();
        API = new Api(wy, wx, new Scope[0]);
        CastApi = new C1435a();
    }

    private Cast() {
    }
}
