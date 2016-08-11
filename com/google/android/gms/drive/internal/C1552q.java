package com.google.android.gms.drive.internal;

import com.google.android.gms.common.api.C1461a.C1401d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

/* renamed from: com.google.android.gms.drive.internal.q */
public class C1552q extends C1542r implements DriveFolder {

    /* renamed from: com.google.android.gms.drive.internal.q.1 */
    class C15451 extends C1513m {
        final /* synthetic */ Contents Fd;
        final /* synthetic */ MetadataChangeSet Fs;
        final /* synthetic */ C1552q Fu;

        C15451(C1552q c1552q, Contents contents, MetadataChangeSet metadataChangeSet) {
            this.Fu = c1552q;
            this.Fd = contents;
            this.Fs = metadataChangeSet;
        }

        protected void m6531a(C1534n c1534n) {
            this.Fd.close();
            c1534n.fE().m6571a(new CreateFileRequest(this.Fu.getDriveId(), this.Fs.fD(), this.Fd), new C1548a(this));
        }

        public /* synthetic */ Result m6532d(Status status) {
            return m6533q(status);
        }

        public DriveFileResult m6533q(Status status) {
            return new C1550d(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.c */
    private abstract class C1546c extends C1513m {
        final /* synthetic */ C1552q Fu;

        private C1546c(C1552q c1552q) {
            this.Fu = c1552q;
        }

        public /* synthetic */ Result m6534d(Status status) {
            return m6535r(status);
        }

        public DriveFolderResult m6535r(Status status) {
            return new C1551e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.2 */
    class C15472 extends C1546c {
        final /* synthetic */ MetadataChangeSet Fs;
        final /* synthetic */ C1552q Fu;

        C15472(C1552q c1552q, MetadataChangeSet metadataChangeSet) {
            this.Fu = c1552q;
            this.Fs = metadataChangeSet;
            super(null);
        }

        protected void m6537a(C1534n c1534n) {
            c1534n.fE().m6572a(new CreateFolderRequest(this.Fu.getDriveId(), this.Fs.fD()), new C1549b(this));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.a */
    private static class C1548a extends C1503c {
        private final C1401d wH;

        public C1548a(C1401d c1401d) {
            this.wH = c1401d;
        }

        public void m6538a(OnDriveIdResponse onDriveIdResponse) {
            this.wH.m6049b(new C1550d(Status.Bv, new C1543o(onDriveIdResponse.getDriveId())));
        }

        public void m6539m(Status status) {
            this.wH.m6049b(new C1550d(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.b */
    private static class C1549b extends C1503c {
        private final C1401d wH;

        public C1549b(C1401d c1401d) {
            this.wH = c1401d;
        }

        public void m6540a(OnDriveIdResponse onDriveIdResponse) {
            this.wH.m6049b(new C1551e(Status.Bv, new C1552q(onDriveIdResponse.getDriveId())));
        }

        public void m6541m(Status status) {
            this.wH.m6049b(new C1551e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.d */
    private static class C1550d implements DriveFileResult {
        private final DriveFile Fv;
        private final Status wJ;

        public C1550d(Status status, DriveFile driveFile) {
            this.wJ = status;
            this.Fv = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.Fv;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q.e */
    private static class C1551e implements DriveFolderResult {
        private final DriveFolder Fw;
        private final Status wJ;

        public C1551e(Status status, DriveFolder driveFolder) {
            this.wJ = status;
            this.Fw = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.Fw;
        }

        public Status getStatus() {
            return this.wJ;
        }
    }

    public C1552q(DriveId driveId) {
        super(driveId);
    }

    public PendingResult createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, Contents contents) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(changeSet.getMimeType())) {
            return apiClient.m6239b(new C15451(this, contents, changeSet));
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult createFolder(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.m6239b(new C15472(this, changeSet));
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult queryChildren(GoogleApiClient apiClient, Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.m6694a(query.fV());
        }
        return new C1531l().query(apiClient, addFilter.build());
    }
}
