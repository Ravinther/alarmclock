package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C1531l.C1527e;

/* renamed from: com.google.android.gms.drive.internal.r */
public class C1542r implements DriveResource {
    protected final DriveId Ew;

    /* renamed from: com.google.android.gms.drive.internal.r.a */
    private abstract class C1553a extends C1513m {
        final /* synthetic */ C1542r Fx;

        private C1553a(C1542r c1542r) {
            this.Fx = c1542r;
        }

        public /* synthetic */ Result m6542d(Status status) {
            return m6543s(status);
        }

        public MetadataResult m6543s(Status status) {
            return new C1561e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.1 */
    class C15541 extends C1553a {
        final /* synthetic */ C1542r Fx;

        C15541(C1542r c1542r) {
            this.Fx = c1542r;
            super(null);
        }

        protected void m6545a(C1534n c1534n) {
            c1534n.fE().m6574a(new GetMetadataRequest(this.Fx.Ew), new C1560d(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.c */
    private abstract class C1555c extends C1513m {
        final /* synthetic */ C1542r Fx;

        private C1555c(C1542r c1542r) {
            this.Fx = c1542r;
        }

        public /* synthetic */ Result m6546d(Status status) {
            return m6547p(status);
        }

        public MetadataBufferResult m6547p(Status status) {
            return new C1527e(status, null, false);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.2 */
    class C15562 extends C1555c {
        final /* synthetic */ C1542r Fx;

        C15562(C1542r c1542r) {
            this.Fx = c1542r;
            super(null);
        }

        protected void m6549a(C1534n c1534n) {
            c1534n.fE().m6575a(new ListParentsRequest(this.Fx.Ew), new C1559b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.f */
    private abstract class C1557f extends C1513m {
        final /* synthetic */ C1542r Fx;

        private C1557f(C1542r c1542r) {
            this.Fx = c1542r;
        }

        public /* synthetic */ Result m6550d(Status status) {
            return m6551s(status);
        }

        public MetadataResult m6551s(Status status) {
            return new C1561e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.3 */
    class C15583 extends C1557f {
        final /* synthetic */ MetadataChangeSet Fs;
        final /* synthetic */ C1542r Fx;

        C15583(C1542r c1542r, MetadataChangeSet metadataChangeSet) {
            this.Fx = c1542r;
            this.Fs = metadataChangeSet;
            super(null);
        }

        protected void m6553a(C1534n c1534n) {
            c1534n.fE().m6580a(new UpdateMetadataRequest(this.Fx.Ew, this.Fs.fD()), new C1560d(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.b */
    private static class C1559b extends C1503c {
        private final C1401d wH;

        public C1559b(C1401d c1401d) {
            this.wH = c1401d;
        }

        public void m6554a(OnListParentsResponse onListParentsResponse) {
            this.wH.m6049b(new C1527e(Status.Bv, new MetadataBuffer(onListParentsResponse.fP(), null), false));
        }

        public void m6555m(Status status) {
            this.wH.m6049b(new C1527e(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.d */
    private static class C1560d extends C1503c {
        private final C1401d wH;

        public C1560d(C1401d c1401d) {
            this.wH = c1401d;
        }

        public void m6556a(OnMetadataResponse onMetadataResponse) {
            this.wH.m6049b(new C1561e(Status.Bv, new C1511j(onMetadataResponse.fQ())));
        }

        public void m6557m(Status status) {
            this.wH.m6049b(new C1561e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r.e */
    private static class C1561e implements MetadataResult {
        private final Metadata Fy;
        private final Status wJ;

        public C1561e(Status status, Metadata metadata) {
            this.wJ = status;
            this.Fy = metadata;
        }

        public Metadata getMetadata() {
            return this.Fy;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    protected C1542r(DriveId driveId) {
        this.Ew = driveId;
    }

    public PendingResult addChangeListener(GoogleApiClient apiClient, Listener listener) {
        return ((C1534n) apiClient.m6237a(Drive.wx)).m6510a(apiClient, this.Ew, 1, listener);
    }

    public DriveId getDriveId() {
        return this.Ew;
    }

    public PendingResult getMetadata(GoogleApiClient apiClient) {
        return apiClient.m6238a(new C15541(this));
    }

    public PendingResult listParents(GoogleApiClient apiClient) {
        return apiClient.m6238a(new C15562(this));
    }

    public PendingResult removeChangeListener(GoogleApiClient apiClient, Listener listener) {
        return ((C1534n) apiClient.m6237a(Drive.wx)).m6513b(apiClient, this.Ew, 1, listener);
    }

    public PendingResult updateMetadata(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.m6239b(new C15583(this, changeSet));
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
