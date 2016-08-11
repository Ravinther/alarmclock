package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C1615d;
import com.google.android.gms.dynamic.C1618e;
import com.google.android.gms.internal.fq;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C2053l.C2054a;
import com.google.android.gms.maps.internal.C2055m.C2056a;
import com.google.android.gms.maps.internal.C2057g.C2058a;
import com.google.android.gms.maps.internal.C2059d.C2060a;
import com.google.android.gms.maps.internal.C2061f.C2062a;
import com.google.android.gms.maps.internal.C2064o.C2065a;
import com.google.android.gms.maps.internal.C2067n.C2068a;
import com.google.android.gms.maps.internal.C2070j.C2071a;
import com.google.android.gms.maps.internal.C2073s.C2074a;
import com.google.android.gms.maps.internal.C2079e.C2080a;
import com.google.android.gms.maps.internal.C2082i.C2083a;
import com.google.android.gms.maps.internal.C2085k.C2086a;
import com.google.android.gms.maps.internal.C2088b.C2089a;
import com.google.android.gms.maps.internal.C2141h;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C2077a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C2179c;
import com.google.android.gms.maps.model.internal.C2182d;
import com.google.android.gms.maps.model.internal.C2188f;
import com.google.android.gms.maps.model.internal.C2194h;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate Rp;
    private UiSettings Rq;

    /* renamed from: com.google.android.gms.maps.GoogleMap.10 */
    class AnonymousClass10 extends C2054a {
        final /* synthetic */ OnMarkerClickListener RD;
        final /* synthetic */ GoogleMap Rs;

        AnonymousClass10(GoogleMap googleMap, OnMarkerClickListener onMarkerClickListener) {
            this.Rs = googleMap;
            this.RD = onMarkerClickListener;
        }

        public boolean m9032a(C2188f c2188f) {
            return this.RD.onMarkerClick(new Marker(c2188f));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.11 */
    class AnonymousClass11 extends C2056a {
        final /* synthetic */ OnMarkerDragListener RE;
        final /* synthetic */ GoogleMap Rs;

        AnonymousClass11(GoogleMap googleMap, OnMarkerDragListener onMarkerDragListener) {
            this.Rs = googleMap;
            this.RE = onMarkerDragListener;
        }

        public void m9036b(C2188f c2188f) {
            this.RE.onMarkerDragStart(new Marker(c2188f));
        }

        public void m9037c(C2188f c2188f) {
            this.RE.onMarkerDragEnd(new Marker(c2188f));
        }

        public void m9038d(C2188f c2188f) {
            this.RE.onMarkerDrag(new Marker(c2188f));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.12 */
    class AnonymousClass12 extends C2058a {
        final /* synthetic */ OnInfoWindowClickListener RF;
        final /* synthetic */ GoogleMap Rs;

        AnonymousClass12(GoogleMap googleMap, OnInfoWindowClickListener onInfoWindowClickListener) {
            this.Rs = googleMap;
            this.RF = onInfoWindowClickListener;
        }

        public void m9040e(C2188f c2188f) {
            this.RF.onInfoWindowClick(new Marker(c2188f));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.13 */
    class AnonymousClass13 extends C2060a {
        final /* synthetic */ InfoWindowAdapter RG;
        final /* synthetic */ GoogleMap Rs;

        AnonymousClass13(GoogleMap googleMap, InfoWindowAdapter infoWindowAdapter) {
            this.Rs = googleMap;
            this.RG = infoWindowAdapter;
        }

        public C1615d m9043f(C2188f c2188f) {
            return C1618e.m6734h(this.RG.getInfoWindow(new Marker(c2188f)));
        }

        public C1615d m9044g(C2188f c2188f) {
            return C1618e.m6734h(this.RG.getInfoContents(new Marker(c2188f)));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.1 */
    class C20631 extends C2062a {
        final /* synthetic */ OnIndoorStateChangeListener Rr;
        final /* synthetic */ GoogleMap Rs;

        C20631(GoogleMap googleMap, OnIndoorStateChangeListener onIndoorStateChangeListener) {
            this.Rs = googleMap;
            this.Rr = onIndoorStateChangeListener;
        }

        public void m9046a(C2182d c2182d) {
            this.Rr.onIndoorLevelActivated(new IndoorBuilding(c2182d));
        }

        public void onIndoorBuildingFocused() {
            this.Rr.onIndoorBuildingFocused();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.2 */
    class C20662 extends C2065a {
        final /* synthetic */ GoogleMap Rs;
        final /* synthetic */ OnMyLocationChangeListener Rt;

        C20662(GoogleMap googleMap, OnMyLocationChangeListener onMyLocationChangeListener) {
            this.Rs = googleMap;
            this.Rt = onMyLocationChangeListener;
        }

        public void m9048e(C1615d c1615d) {
            this.Rt.onMyLocationChange((Location) C1618e.m6733d(c1615d));
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.3 */
    class C20693 extends C2068a {
        final /* synthetic */ GoogleMap Rs;
        final /* synthetic */ OnMyLocationButtonClickListener Ru;

        C20693(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
            this.Rs = googleMap;
            this.Ru = onMyLocationButtonClickListener;
        }

        public boolean onMyLocationButtonClick() {
            return this.Ru.onMyLocationButtonClick();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.4 */
    class C20724 extends C2071a {
        final /* synthetic */ GoogleMap Rs;
        final /* synthetic */ OnMapLoadedCallback Rv;

        C20724(GoogleMap googleMap, OnMapLoadedCallback onMapLoadedCallback) {
            this.Rs = googleMap;
            this.Rv = onMapLoadedCallback;
        }

        public void onMapLoaded() {
            this.Rv.onMapLoaded();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.5 */
    class C20755 extends C2074a {
        final /* synthetic */ GoogleMap Rs;
        final /* synthetic */ SnapshotReadyCallback Rw;

        C20755(GoogleMap googleMap, SnapshotReadyCallback snapshotReadyCallback) {
            this.Rs = googleMap;
            this.Rw = snapshotReadyCallback;
        }

        public void m9050f(C1615d c1615d) {
            this.Rw.onSnapshotReady((Bitmap) C1618e.m6733d(c1615d));
        }

        public void onSnapshotReady(Bitmap snapshot) {
            this.Rw.onSnapshotReady(snapshot);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.6 */
    class C20786 extends C2077a {
        final /* synthetic */ GoogleMap Rs;
        final /* synthetic */ LocationSource Rx;

        /* renamed from: com.google.android.gms.maps.GoogleMap.6.1 */
        class C20761 implements OnLocationChangedListener {
            final /* synthetic */ C2141h Ry;
            final /* synthetic */ C20786 Rz;

            C20761(C20786 c20786, C2141h c2141h) {
                this.Rz = c20786;
                this.Ry = c2141h;
            }

            public void onLocationChanged(Location location) {
                try {
                    this.Ry.m9084j(C1618e.m6734h(location));
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
        }

        C20786(GoogleMap googleMap, LocationSource locationSource) {
            this.Rs = googleMap;
            this.Rx = locationSource;
        }

        public void activate(C2141h listener) {
            this.Rx.activate(new C20761(this, listener));
        }

        public void deactivate() {
            this.Rx.deactivate();
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.7 */
    class C20817 extends C2080a {
        final /* synthetic */ OnCameraChangeListener RA;
        final /* synthetic */ GoogleMap Rs;

        C20817(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
            this.Rs = googleMap;
            this.RA = onCameraChangeListener;
        }

        public void onCameraChange(CameraPosition position) {
            this.RA.onCameraChange(position);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.8 */
    class C20848 extends C2083a {
        final /* synthetic */ OnMapClickListener RB;
        final /* synthetic */ GoogleMap Rs;

        C20848(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
            this.Rs = googleMap;
            this.RB = onMapClickListener;
        }

        public void onMapClick(LatLng point) {
            this.RB.onMapClick(point);
        }
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.9 */
    class C20879 extends C2086a {
        final /* synthetic */ OnMapLongClickListener RC;
        final /* synthetic */ GoogleMap Rs;

        C20879(GoogleMap googleMap, OnMapLongClickListener onMapLongClickListener) {
            this.Rs = googleMap;
            this.RC = onMapLongClickListener;
        }

        public void onMapLongClick(LatLng point) {
            this.RC.onMapLongClick(point);
        }
    }

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    /* renamed from: com.google.android.gms.maps.GoogleMap.a */
    private static final class C2090a extends C2089a {
        private final CancelableCallback RH;

        C2090a(CancelableCallback cancelableCallback) {
            this.RH = cancelableCallback;
        }

        public void onCancel() {
            this.RH.onCancel();
        }

        public void onFinish() {
            this.RH.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.Rp = (IGoogleMapDelegate) fq.m8520f(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.Rp.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            C2179c addGroundOverlay = this.Rp.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            C2188f addMarker = this.Rp.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.Rp.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.Rp.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            C2194h addTileOverlay = this.Rp.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.Rp.animateCamera(update.id());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.Rp.animateCameraWithDurationAndCallback(update.id(), durationMs, callback == null ? null : new C2090a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.Rp.animateCameraWithCallback(update.id(), callback == null ? null : new C2090a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.Rp.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.Rp.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            C2182d focusedBuilding = this.Rp.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.Rp.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.Rp.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.Rp.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.Rp.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.Rp.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.Rq == null) {
                this.Rq = new UiSettings(this.Rp.getUiSettings());
            }
            return this.Rq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate m9051if() {
        return this.Rp;
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.Rp.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.Rp.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.Rp.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.Rp.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.Rp.moveCamera(update.id());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.Rp.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.Rp.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.Rp.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setInfoWindowAdapter(new AnonymousClass13(this, adapter));
    }

    public final void setLocationSource(LocationSource source) {
        if (source == null) {
            try {
                this.Rp.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setLocationSource(new C20786(this, source));
    }

    public final void setMapType(int type) {
        try {
            this.Rp.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.Rp.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnCameraChangeListener(new C20817(this, listener));
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnIndoorStateChangeListener(new C20631(this, listener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnInfoWindowClickListener(new AnonymousClass12(this, listener));
    }

    public final void setOnMapClickListener(OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMapClickListener(new C20848(this, listener));
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.Rp.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMapLoadedCallback(new C20724(this, callback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMapLongClickListener(new C20879(this, listener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMarkerClickListener(new AnonymousClass10(this, listener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMarkerDragListener(new AnonymousClass11(this, listener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMyLocationButtonClickListener(new C20693(this, listener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.Rp.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.Rp.setOnMyLocationChangeListener(new C20662(this, listener));
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.Rp.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.Rp.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.Rp.snapshot(new C20755(this, callback), (C1618e) (bitmap != null ? C1618e.m6734h(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.Rp.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
