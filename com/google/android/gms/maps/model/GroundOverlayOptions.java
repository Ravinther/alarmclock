package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C1615d.C1617a;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C2157v;

public final class GroundOverlayOptions implements SafeParcelable {
    public static final GroundOverlayOptionsCreator CREATOR;
    public static final float NO_DIMENSION = -1.0f;
    private float SG;
    private float SN;
    private boolean SO;
    private BitmapDescriptor SQ;
    private LatLng SR;
    private float SS;
    private float ST;
    private LatLngBounds SU;
    private float SV;
    private float SW;
    private float SX;
    private final int xH;

    static {
        CREATOR = new GroundOverlayOptionsCreator();
    }

    public GroundOverlayOptions() {
        this.SO = true;
        this.SV = 0.0f;
        this.SW = 0.5f;
        this.SX = 0.5f;
        this.xH = 1;
    }

    GroundOverlayOptions(int versionCode, IBinder wrappedImage, LatLng location, float width, float height, LatLngBounds bounds, float bearing, float zIndex, boolean visible, float transparency, float anchorU, float anchorV) {
        this.SO = true;
        this.SV = 0.0f;
        this.SW = 0.5f;
        this.SX = 0.5f;
        this.xH = versionCode;
        this.SQ = new BitmapDescriptor(C1617a.m6732K(wrappedImage));
        this.SR = location;
        this.SS = width;
        this.ST = height;
        this.SU = bounds;
        this.SG = bearing;
        this.SN = zIndex;
        this.SO = visible;
        this.SV = transparency;
        this.SW = anchorU;
        this.SX = anchorV;
    }

    private GroundOverlayOptions m9101a(LatLng latLng, float f, float f2) {
        this.SR = latLng;
        this.SS = f;
        this.ST = f2;
        return this;
    }

    public GroundOverlayOptions anchor(float u, float v) {
        this.SW = u;
        this.SX = v;
        return this;
    }

    public GroundOverlayOptions bearing(float bearing) {
        this.SG = ((bearing % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.SW;
    }

    public float getAnchorV() {
        return this.SX;
    }

    public float getBearing() {
        return this.SG;
    }

    public LatLngBounds getBounds() {
        return this.SU;
    }

    public float getHeight() {
        return this.ST;
    }

    public BitmapDescriptor getImage() {
        return this.SQ;
    }

    public LatLng getLocation() {
        return this.SR;
    }

    public float getTransparency() {
        return this.SV;
    }

    int getVersionCode() {
        return this.xH;
    }

    public float getWidth() {
        return this.SS;
    }

    public float getZIndex() {
        return this.SN;
    }

    IBinder iD() {
        return this.SQ.id().asBinder();
    }

    public GroundOverlayOptions image(BitmapDescriptor image) {
        this.SQ = image;
        return this;
    }

    public boolean isVisible() {
        return this.SO;
    }

    public GroundOverlayOptions position(LatLng location, float width) {
        boolean z = true;
        fq.m8515a(this.SU == null, "Position has already been set using positionFromBounds");
        fq.m8519b(location != null, (Object) "Location must be specified");
        if (width < 0.0f) {
            z = false;
        }
        fq.m8519b(z, (Object) "Width must be non-negative");
        return m9101a(location, width, NO_DIMENSION);
    }

    public GroundOverlayOptions position(LatLng location, float width, float height) {
        boolean z = true;
        fq.m8515a(this.SU == null, "Position has already been set using positionFromBounds");
        fq.m8519b(location != null, (Object) "Location must be specified");
        fq.m8519b(width >= 0.0f, (Object) "Width must be non-negative");
        if (height < 0.0f) {
            z = false;
        }
        fq.m8519b(z, (Object) "Height must be non-negative");
        return m9101a(location, width, height);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds bounds) {
        fq.m8515a(this.SR == null, "Position has already been set using position: " + this.SR);
        this.SU = bounds;
        return this;
    }

    public GroundOverlayOptions transparency(float transparency) {
        boolean z = transparency >= 0.0f && transparency <= 1.0f;
        fq.m8519b(z, (Object) "Transparency must be in the range [0..1]");
        this.SV = transparency;
        return this;
    }

    public GroundOverlayOptions visible(boolean visible) {
        this.SO = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C2157v.iB()) {
            C2164c.m9127a(this, out, flags);
        } else {
            GroundOverlayOptionsCreator.m9102a(this, out, flags);
        }
    }

    public GroundOverlayOptions zIndex(float zIndex) {
        this.SN = zIndex;
        return this;
    }
}
