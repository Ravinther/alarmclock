package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class ApplicationMetadata implements SafeParcelable {
    public static final Creator CREATOR;
    String mName;
    private final int xH;
    String xI;
    List xJ;
    List xK;
    String xL;
    Uri xM;

    static {
        CREATOR = new C1453a();
    }

    private ApplicationMetadata() {
        this.xH = 1;
        this.xJ = new ArrayList();
        this.xK = new ArrayList();
    }

    ApplicationMetadata(int versionCode, String applicationId, String name, List images, List namespaces, String senderAppIdentifier, Uri senderAppLaunchUrl) {
        this.xH = versionCode;
        this.xI = applicationId;
        this.mName = name;
        this.xJ = images;
        this.xK = namespaces;
        this.xL = senderAppIdentifier;
        this.xM = senderAppLaunchUrl;
    }

    public boolean areNamespacesSupported(List namespaces) {
        return this.xK != null && this.xK.containsAll(namespaces);
    }

    public int describeContents() {
        return 0;
    }

    public Uri dz() {
        return this.xM;
    }

    public String getApplicationId() {
        return this.xI;
    }

    public List getImages() {
        return this.xJ;
    }

    public String getName() {
        return this.mName;
    }

    public String getSenderAppIdentifier() {
        return this.xL;
    }

    int getVersionCode() {
        return this.xH;
    }

    public boolean isNamespaceSupported(String namespace) {
        return this.xK != null && this.xK.contains(namespace);
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1453a.m6200a(this, out, flags);
    }
}
