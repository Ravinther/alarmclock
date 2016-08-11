package com.google.android.gms.panorama;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public interface PanoramaApi {

    public interface PanoramaResult extends Result {
        Intent getViewerIntent();
    }

    /* renamed from: com.google.android.gms.panorama.PanoramaApi.a */
    public interface C1957a extends PanoramaResult {
    }

    PendingResult loadPanoramaInfo(GoogleApiClient googleApiClient, Uri uri);

    PendingResult loadPanoramaInfoAndGrantAccess(GoogleApiClient googleApiClient, Uri uri);
}
