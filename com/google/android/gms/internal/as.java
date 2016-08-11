package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class as {
    public static final String DEVICE_ID_EMULATOR;
    private final Date f4295d;
    private final Set f4296f;
    private final Location f4297h;
    private final String lY;
    private final int lZ;
    private final boolean ma;
    private final Map mb;
    private final Map mc;
    private final String md;
    private final SearchAdRequest me;
    private final int mf;
    private final Set mg;

    /* renamed from: com.google.android.gms.internal.as.a */
    public static final class C1749a {
        private Date f4293d;
        private Location f4294h;
        private String lY;
        private int lZ;
        private boolean ma;
        private String md;
        private int mf;
        private final HashSet mh;
        private final HashMap mi;
        private final HashMap mj;
        private final HashSet mk;

        public C1749a() {
            this.mh = new HashSet();
            this.mi = new HashMap();
            this.mj = new HashMap();
            this.mk = new HashSet();
            this.lZ = -1;
            this.ma = false;
            this.mf = -1;
        }

        public void m7866a(Location location) {
            this.f4294h = location;
        }

        @Deprecated
        public void m7867a(NetworkExtras networkExtras) {
            if (networkExtras instanceof AdMobExtras) {
                m7868a(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
            } else {
                this.mj.put(networkExtras.getClass(), networkExtras);
            }
        }

        public void m7868a(Class cls, Bundle bundle) {
            this.mi.put(cls, bundle);
        }

        public void m7869a(Date date) {
            this.f4293d = date;
        }

        public void m7870d(int i) {
            this.lZ = i;
        }

        public void m7871f(boolean z) {
            this.ma = z;
        }

        public void m7872g(String str) {
            this.mh.add(str);
        }

        public void m7873g(boolean z) {
            this.mf = z ? 1 : 0;
        }

        public void m7874h(String str) {
            this.mk.add(str);
        }

        public void m7875i(String str) {
            this.lY = str;
        }

        public void m7876j(String str) {
            this.md = str;
        }
    }

    static {
        DEVICE_ID_EMULATOR = dv.m8212u("emulator");
    }

    public as(C1749a c1749a) {
        this(c1749a, null);
    }

    public as(C1749a c1749a, SearchAdRequest searchAdRequest) {
        this.f4295d = c1749a.f4293d;
        this.lY = c1749a.lY;
        this.lZ = c1749a.lZ;
        this.f4296f = Collections.unmodifiableSet(c1749a.mh);
        this.f4297h = c1749a.f4294h;
        this.ma = c1749a.ma;
        this.mb = Collections.unmodifiableMap(c1749a.mi);
        this.mc = Collections.unmodifiableMap(c1749a.mj);
        this.md = c1749a.md;
        this.me = searchAdRequest;
        this.mf = c1749a.mf;
        this.mg = Collections.unmodifiableSet(c1749a.mk);
    }

    public SearchAdRequest aB() {
        return this.me;
    }

    public Map aC() {
        return this.mc;
    }

    public Map aD() {
        return this.mb;
    }

    public int aE() {
        return this.mf;
    }

    public Date getBirthday() {
        return this.f4295d;
    }

    public String getContentUrl() {
        return this.lY;
    }

    public int getGender() {
        return this.lZ;
    }

    public Set getKeywords() {
        return this.f4296f;
    }

    public Location getLocation() {
        return this.f4297h;
    }

    public boolean getManualImpressionsEnabled() {
        return this.ma;
    }

    @Deprecated
    public NetworkExtras getNetworkExtras(Class networkExtrasClass) {
        return (NetworkExtras) this.mc.get(networkExtrasClass);
    }

    public Bundle getNetworkExtrasBundle(Class adapterClass) {
        return (Bundle) this.mb.get(adapterClass);
    }

    public String getPublisherProvidedId() {
        return this.md;
    }

    public boolean isTestDevice(Context context) {
        return this.mg.contains(dv.m8211l(context));
    }
}
