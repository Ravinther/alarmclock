package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.internal.C2157v;

public final class LatLngBounds implements SafeParcelable {
    public static final LatLngBoundsCreator CREATOR;
    public final LatLng northeast;
    public final LatLng southwest;
    private final int xH;

    public static final class Builder {
        private double Ta;
        private double Tb;
        private double Tc;
        private double Td;

        public Builder() {
            this.Ta = Double.POSITIVE_INFINITY;
            this.Tb = Double.NEGATIVE_INFINITY;
            this.Tc = Double.NaN;
            this.Td = Double.NaN;
        }

        private boolean m9103d(double d) {
            boolean z = false;
            if (this.Tc <= this.Td) {
                return this.Tc <= d && d <= this.Td;
            } else {
                if (this.Tc <= d || d <= this.Td) {
                    z = true;
                }
                return z;
            }
        }

        public LatLngBounds build() {
            fq.m8515a(!Double.isNaN(this.Tc), "no included points");
            return new LatLngBounds(new LatLng(this.Ta, this.Tc), new LatLng(this.Tb, this.Td));
        }

        public Builder include(LatLng point) {
            this.Ta = Math.min(this.Ta, point.latitude);
            this.Tb = Math.max(this.Tb, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.Tc)) {
                this.Tc = d;
                this.Td = d;
            } else if (!m9103d(d)) {
                if (LatLngBounds.m9104b(this.Tc, d) < LatLngBounds.m9105c(this.Td, d)) {
                    this.Tc = d;
                } else {
                    this.Td = d;
                }
            }
            return this;
        }
    }

    static {
        CREATOR = new LatLngBoundsCreator();
    }

    LatLngBounds(int versionCode, LatLng southwest, LatLng northeast) {
        fq.m8517b((Object) southwest, (Object) "null southwest");
        fq.m8517b((Object) northeast, (Object) "null northeast");
        fq.m8516a(northeast.latitude >= southwest.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest.latitude), Double.valueOf(northeast.latitude));
        this.xH = versionCode;
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this(1, southwest, northeast);
    }

    private static double m9104b(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double m9105c(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean m9106c(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean m9108d(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        } else {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
    }

    public boolean contains(LatLng point) {
        return m9106c(point.latitude) && m9108d(point.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    int getVersionCode() {
        return this.xH;
    }

    public int hashCode() {
        return fo.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = point.longitude;
        if (m9108d(d3)) {
            d3 = d2;
            d2 = d;
        } else if (m9104b(d2, d3) < m9105c(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public String toString() {
        return fo.m8511e(this).m8510a("southwest", this.southwest).m8510a("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C2157v.iB()) {
            C2165d.m9128a(this, out, flags);
        } else {
            LatLngBoundsCreator.m9110a(this, out, flags);
        }
    }
}
