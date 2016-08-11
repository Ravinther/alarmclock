package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C1531l.C1524a;

/* renamed from: com.google.android.gms.drive.internal.o */
public class C1543o extends C1542r implements DriveFile {

    /* renamed from: com.google.android.gms.drive.internal.o.d */
    private abstract class C1535d extends C1513m {
        final /* synthetic */ C1543o Fr;

        private C1535d(C1543o c1543o) {
            this.Fr = c1543o;
        }

        public /* synthetic */ Result m6515d(Status status) {
            return m6516o(status);
        }

        public ContentsResult m6516o(Status status) {
            return new C1524a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.1 */
    class C15361 extends C1535d {
        final /* synthetic */ int Fp;
        final /* synthetic */ DownloadProgressListener Fq;
        final /* synthetic */ C1543o Fr;

        C15361(C1543o c1543o, int i, DownloadProgressListener downloadProgressListener) {
            this.Fr = c1543o;
            this.Fp = i;
            this.Fq = downloadProgressListener;
            super(null);
        }

        protected void m6518a(C1534n c1534n) {
            c1534n.fE().m6576a(new OpenContentsRequest(this.Fr.getDriveId(), this.Fp), new C1541c(this, this.Fq));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.b */
    private abstract class C1537b extends C1513m {
        final /* synthetic */ C1543o Fr;

        private C1537b(C1543o c1543o) {
            this.Fr = c1543o;
        }

        public /* synthetic */ Result m6519d(Status status) {
            return m6520f(status);
        }

        public Status m6520f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.2 */
    class C15382 extends C1537b {
        final /* synthetic */ Contents Fd;
        final /* synthetic */ C1543o Fr;

        C15382(C1543o c1543o, Contents contents) {
            this.Fr = c1543o;
            this.Fd = contents;
            super(null);
        }

        protected void m6522a(C1534n c1534n) {
            this.Fd.close();
            c1534n.fE().m6569a(new CloseContentsRequest(this.Fd, true), new al(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.a */
    private abstract class C1539a extends C1513m {
        final /* synthetic */ C1543o Fr;

        private C1539a(C1543o c1543o) {
            this.Fr = c1543o;
        }

        public /* synthetic */ Result m6523d(Status status) {
            return m6524f(status);
        }

        public Status m6524f(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.3 */
    class C15403 extends C1539a {
        final /* synthetic */ Contents Fd;
        final /* synthetic */ C1543o Fr;
        final /* synthetic */ MetadataChangeSet Fs;

        C15403(C1543o c1543o, Contents contents, MetadataChangeSet metadataChangeSet) {
            this.Fr = c1543o;
            this.Fd = contents;
            this.Fs = metadataChangeSet;
            super(null);
        }

        protected void m6526a(C1534n c1534n) {
            this.Fd.close();
            c1534n.fE().m6568a(new CloseContentsAndUpdateMetadataRequest(this.Fr.Ew, this.Fs.fD(), this.Fd), new al(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o.c */
    private static class C1541c extends C1503c {
        private final DownloadProgressListener Ft;
        private final C1401d wH;

        public C1541c(C1401d c1401d, DownloadProgressListener downloadProgressListener) {
            this.wH = c1401d;
            this.Ft = downloadProgressListener;
        }

        public void m6527a(OnContentsResponse onContentsResponse) {
            this.wH.m6049b(new C1524a(Status.Bv, onContentsResponse.fI()));
        }

        public void m6528a(OnDownloadProgressResponse onDownloadProgressResponse) {
            if (this.Ft != null) {
                this.Ft.onProgress(onDownloadProgressResponse.fJ(), onDownloadProgressResponse.fK());
            }
        }

        public void m6529m(Status status) {
            this.wH.m6049b(new C1524a(status, null));
        }
    }

    public C1543o(DriveId driveId) {
        super(driveId);
    }

    public PendingResult commitAndCloseContents(GoogleApiClient apiClient, Contents contents) {
        if (contents != null) {
            return apiClient.m6239b(new C15382(this, contents));
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult commitAndCloseContents(GoogleApiClient apiClient, Contents contents, MetadataChangeSet changeSet) {
        if (contents != null) {
            return apiClient.m6239b(new C15403(this, contents, changeSet));
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult discardContents(GoogleApiClient apiClient, Contents contents) {
        return Drive.DriveApi.discardContents(apiClient, contents);
    }

    public PendingResult openContents(GoogleApiClient apiClient, int mode, DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            return apiClient.m6238a(new C15361(this, mode, listener));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
