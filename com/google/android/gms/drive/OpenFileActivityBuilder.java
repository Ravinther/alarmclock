package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C1534n;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.internal.fq;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String EB;
    private DriveId EC;
    private String[] EQ;

    public IntentSender build(GoogleApiClient apiClient) {
        fq.m8517b(this.EQ, (Object) "setMimeType(String[]) must be called on this builder before calling build()");
        fq.m8515a(apiClient.isConnected(), "Client must be connected");
        try {
            return ((C1534n) apiClient.m6237a(Drive.wx)).fE().m6565a(new OpenFileIntentSenderRequest(this.EB, this.EQ, this.EC));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.EC = (DriveId) fq.m8520f(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.EB = (String) fq.m8520f(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        boolean z = mimeTypes != null && mimeTypes.length > 0;
        fq.m8519b(z, (Object) "mimeTypes may not be null and must contain at least one value");
        this.EQ = mimeTypes;
        return this;
    }
}
