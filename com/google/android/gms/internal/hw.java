package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.C1461a.C1404b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class hw implements PanoramaApi {

    /* renamed from: com.google.android.gms.internal.hw.a */
    private static abstract class C1953a extends C1404b {

        /* renamed from: com.google.android.gms.internal.hw.a.1 */
        class C19561 implements PanoramaResult {
            final /* synthetic */ C1953a TB;
            final /* synthetic */ Status wz;

            C19561(C1953a c1953a, Status status) {
                this.TB = c1953a;
                this.wz = status;
            }

            public Status getStatus() {
                return this.wz;
            }

            public Intent getViewerIntent() {
                return null;
            }
        }

        public C1953a() {
            super(Panorama.wx);
        }

        public PanoramaResult m8705X(Status status) {
            return new C19561(this, status);
        }

        public /* synthetic */ Result m8706d(Status status) {
            return m8705X(status);
        }
    }

    /* renamed from: com.google.android.gms.internal.hw.1 */
    class C19541 extends C1953a {
        final /* synthetic */ hw TA;
        final /* synthetic */ Uri Tz;

        C19541(hw hwVar, Uri uri) {
            this.TA = hwVar;
            this.Tz = uri;
        }

        protected void m8708a(hx hxVar) {
            hxVar.m8716a(this, this.Tz, false);
        }
    }

    /* renamed from: com.google.android.gms.internal.hw.2 */
    class C19552 extends C1953a {
        final /* synthetic */ hw TA;
        final /* synthetic */ Uri Tz;

        C19552(hw hwVar, Uri uri) {
            this.TA = hwVar;
            this.Tz = uri;
        }

        protected void m8710a(hx hxVar) {
            hxVar.m8716a(this, this.Tz, true);
        }
    }

    public PendingResult loadPanoramaInfo(GoogleApiClient client, Uri uri) {
        return client.m6238a(new C19541(this, uri));
    }

    public PendingResult loadPanoramaInfoAndGrantAccess(GoogleApiClient client, Uri uri) {
        return client.m6238a(new C19552(this, uri));
    }
}
