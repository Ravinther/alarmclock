package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.C1461a.C1460c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

/* renamed from: com.google.android.gms.drive.internal.l */
public class C1531l implements DriveApi {

    /* renamed from: com.google.android.gms.drive.internal.l.i */
    abstract class C1514i extends C1513m {
        final /* synthetic */ C1531l Fc;

        C1514i(C1531l c1531l) {
            this.Fc = c1531l;
        }

        public /* synthetic */ Result m6461d(Status status) {
            return m6462p(status);
        }

        public MetadataBufferResult m6462p(Status status) {
            return new C1527e(status, null, false);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.1 */
    class C15151 extends C1514i {
        final /* synthetic */ Query Fb;
        final /* synthetic */ C1531l Fc;

        C15151(C1531l c1531l, Query query) {
            this.Fc = c1531l;
            this.Fb = query;
            super(c1531l);
        }

        protected void m6464a(C1534n c1534n) {
            c1534n.fE().m6577a(new QueryRequest(this.Fb), new C1529h(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.g */
    abstract class C1516g extends C1513m {
        final /* synthetic */ C1531l Fc;

        C1516g(C1531l c1531l) {
            this.Fc = c1531l;
        }

        public /* synthetic */ Result m6465d(Status status) {
            return m6466o(status);
        }

        public ContentsResult m6466o(Status status) {
            return new C1524a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.2 */
    class C15172 extends C1516g {
        final /* synthetic */ C1531l Fc;

        C15172(C1531l c1531l) {
            this.Fc = c1531l;
            super(c1531l);
        }

        protected void m6468a(C1534n c1534n) {
            c1534n.fE().m6570a(new CreateContentsRequest(), new C1528f(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.j */
    static abstract class C1518j extends C1513m {
        C1518j() {
        }

        public /* synthetic */ Result m6469d(Status status) {
            return m6470f(status);
        }

        public Status m6470f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.3 */
    class C15193 extends C1518j {
        final /* synthetic */ C1531l Fc;
        final /* synthetic */ Contents Fd;

        C15193(C1531l c1531l, Contents contents) {
            this.Fc = c1531l;
            this.Fd = contents;
        }

        protected void m6472a(C1534n c1534n) {
            c1534n.fE().m6569a(new CloseContentsRequest(this.Fd, false), new al(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.d */
    abstract class C1520d extends C1513m {
        final /* synthetic */ C1531l Fc;

        C1520d(C1531l c1531l) {
            this.Fc = c1531l;
        }

        public /* synthetic */ Result m6473d(Status status) {
            return m6474n(status);
        }

        public DriveIdResult m6474n(Status status) {
            return new C1526c(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.4 */
    class C15214 extends C1520d {
        final /* synthetic */ C1531l Fc;
        final /* synthetic */ String Fe;

        C15214(C1531l c1531l, String str) {
            this.Fc = c1531l;
            this.Fe = str;
            super(c1531l);
        }

        protected void m6476a(C1534n c1534n) {
            c1534n.fE().m6574a(new GetMetadataRequest(DriveId.aw(this.Fe)), new C1525b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.l */
    abstract class C1522l extends C1513m {
        final /* synthetic */ C1531l Fc;

        C1522l(C1531l c1531l) {
            this.Fc = c1531l;
        }

        public /* synthetic */ Result m6477d(Status status) {
            return m6478f(status);
        }

        public Status m6478f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.5 */
    class C15235 extends C1522l {
        final /* synthetic */ C1531l Fc;

        C15235(C1531l c1531l) {
            this.Fc = c1531l;
            super(c1531l);
        }

        protected void m6480a(C1534n c1534n) {
            c1534n.fE().m6581a(new al(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.a */
    static class C1524a implements ContentsResult {
        private final Contents EA;
        private final Status wJ;

        public C1524a(Status status, Contents contents) {
            this.wJ = status;
            this.EA = contents;
        }

        public Contents getContents() {
            return this.EA;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.b */
    private static class C1525b extends C1503c {
        private final C1401d wH;

        public C1525b(C1401d c1401d) {
            this.wH = c1401d;
        }

        public void m6481a(OnMetadataResponse onMetadataResponse) {
            this.wH.m6049b(new C1526c(Status.Bv, new C1511j(onMetadataResponse.fQ()).getDriveId()));
        }

        public void m6482m(Status status) {
            this.wH.m6049b(new C1526c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.c */
    static class C1526c implements DriveIdResult {
        private final DriveId Ew;
        private final Status wJ;

        public C1526c(Status status, DriveId driveId) {
            this.wJ = status;
            this.Ew = driveId;
        }

        public DriveId getDriveId() {
            return this.Ew;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.e */
    static class C1527e implements MetadataBufferResult {
        private final MetadataBuffer Ff;
        private final boolean Fg;
        private final Status wJ;

        public C1527e(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.wJ = status;
            this.Ff = metadataBuffer;
            this.Fg = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.Ff;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.f */
    private static class C1528f extends C1503c {
        private final C1401d wH;

        public C1528f(C1401d c1401d) {
            this.wH = c1401d;
        }

        public void m6483a(OnContentsResponse onContentsResponse) {
            this.wH.m6049b(new C1524a(Status.Bv, onContentsResponse.fI()));
        }

        public void m6484m(Status status) {
            this.wH.m6049b(new C1524a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.h */
    static class C1529h extends C1503c {
        private final C1401d wH;

        public C1529h(C1401d c1401d) {
            this.wH = c1401d;
        }

        public void m6485a(OnListEntriesResponse onListEntriesResponse) {
            this.wH.m6049b(new C1527e(Status.Bv, new MetadataBuffer(onListEntriesResponse.fN(), null), onListEntriesResponse.fO()));
        }

        public void m6486m(Status status) {
            this.wH.m6049b(new C1527e(status, null, false));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l.k */
    static class C1530k extends C1518j {
        C1530k(GoogleApiClient googleApiClient, Status status) {
            m6055a(new C1460c(((C1534n) googleApiClient.m6237a(Drive.wx)).getLooper()));
            m6054a((Result) status);
        }

        protected void m6488a(C1534n c1534n) {
        }
    }

    public PendingResult discardContents(GoogleApiClient apiClient, Contents contents) {
        return apiClient.m6239b(new C15193(this, contents));
    }

    public PendingResult fetchDriveId(GoogleApiClient apiClient, String resourceId) {
        return apiClient.m6238a(new C15214(this, resourceId));
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId fG = ((C1534n) apiClient.m6237a(Drive.wx)).fG();
            return fG != null ? new C1552q(fG) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C1543o(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C1552q(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new C1552q(((C1534n) apiClient.m6237a(Drive.wx)).fF());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult newContents(GoogleApiClient apiClient) {
        return apiClient.m6238a(new C15172(this));
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult query(GoogleApiClient apiClient, Query query) {
        if (query != null) {
            return apiClient.m6238a(new C15151(this, query));
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult requestSync(GoogleApiClient client) {
        return client.m6239b(new C15235(this));
    }
}
