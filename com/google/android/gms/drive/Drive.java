package com.google.android.gms.drive;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C1398b;
import com.google.android.gms.common.api.Api.C1456a;
import com.google.android.gms.common.api.Api.C1457c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.C1531l;
import com.google.android.gms.drive.internal.C1534n;
import com.google.android.gms.drive.internal.C1544p;
import com.google.android.gms.internal.fc;
import java.util.List;

public final class Drive {
    public static final Api API;
    public static final DriveApi DriveApi;
    public static final Scope EE;
    public static final Scope EF;
    public static final C1495c EG;
    public static final Scope SCOPE_APPFOLDER;
    public static final Scope SCOPE_FILE;
    public static final C1457c wx;
    public static final C1398b wy;

    /* renamed from: com.google.android.gms.drive.Drive.1 */
    static class C14901 implements C1398b {
        C14901() {
        }

        public /* synthetic */ C1456a m6382a(Context context, Looper looper, fc fcVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m6383b(context, looper, fcVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public C1534n m6383b(Context context, Looper looper, fc fcVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List eE = fcVar.eE();
            return new C1534n(context, looper, fcVar, connectionCallbacks, onConnectionFailedListener, (String[]) eE.toArray(new String[eE.size()]));
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    static {
        wx = new C1457c();
        wy = new C14901();
        SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
        SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
        EE = new Scope(Scopes.DRIVE_FULL);
        EF = new Scope(Scopes.DRIVE_APPS);
        API = new Api(wy, wx, new Scope[0]);
        DriveApi = new C1531l();
        EG = new C1544p();
    }

    private Drive() {
    }
}
