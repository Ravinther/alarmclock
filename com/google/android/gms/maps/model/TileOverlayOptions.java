package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C2157v;
import com.google.android.gms.maps.model.internal.C2159i;
import com.google.android.gms.maps.model.internal.C2159i.C2160a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR;
    private float SN;
    private boolean SO;
    private C2159i Tt;
    private TileProvider Tu;
    private boolean Tv;
    private final int xH;

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.1 */
    class C21581 implements TileProvider {
        private final C2159i Tw;
        final /* synthetic */ TileOverlayOptions Tx;

        C21581(TileOverlayOptions tileOverlayOptions) {
            this.Tx = tileOverlayOptions;
            this.Tw = this.Tx.Tt;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.Tw.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    /* renamed from: com.google.android.gms.maps.model.TileOverlayOptions.2 */
    class C21612 extends C2160a {
        final /* synthetic */ TileOverlayOptions Tx;
        final /* synthetic */ TileProvider Ty;

        C21612(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
            this.Tx = tileOverlayOptions;
            this.Ty = tileProvider;
        }

        public Tile getTile(int x, int y, int zoom) {
            return this.Ty.getTile(x, y, zoom);
        }
    }

    static {
        CREATOR = new TileOverlayOptionsCreator();
    }

    public TileOverlayOptions() {
        this.SO = true;
        this.Tv = true;
        this.xH = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.SO = true;
        this.Tv = true;
        this.xH = versionCode;
        this.Tt = C2160a.aK(delegate);
        this.Tu = this.Tt == null ? null : new C21581(this);
        this.SO = visible;
        this.SN = zIndex;
        this.Tv = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.Tv = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.Tv;
    }

    public TileProvider getTileProvider() {
        return this.Tu;
    }

    int getVersionCode() {
        return this.xH;
    }

    public float getZIndex() {
        return this.SN;
    }

    IBinder iG() {
        return this.Tt.asBinder();
    }

    public boolean isVisible() {
        return this.SO;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.Tu = tileProvider;
        this.Tt = this.Tu == null ? null : new C21612(this, tileProvider);
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.SO = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C2157v.iB()) {
            C2198j.m9158a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.m9121a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.SN = zIndex;
        return this;
    }
}
