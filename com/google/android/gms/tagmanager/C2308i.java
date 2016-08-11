package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.google.android.gms.tagmanager.i */
class C2308i extends df {
    private static final String ID;
    private static final String URL;
    private static final String WC;
    private static final String WD;
    static final String WE;
    private static final Set WF;
    private final C2306a WG;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.i.a */
    public interface C2306a {
        aq jY();
    }

    /* renamed from: com.google.android.gms.tagmanager.i.1 */
    class C23071 implements C2306a {
        final /* synthetic */ Context pB;

        C23071(Context context) {
            this.pB = context;
        }

        public aq jY() {
            return C2336y.m9610F(this.pB);
        }
    }

    static {
        ID = C1732a.ARBITRARY_PIXEL.toString();
        URL = C1750b.URL.toString();
        WC = C1750b.ADDITIONAL_PARAMS.toString();
        WD = C1750b.UNREPEATABLE.toString();
        WE = "gtm_" + ID + "_unrepeatable";
        WF = new HashSet();
    }

    public C2308i(Context context) {
        this(context, new C23071(context));
    }

    C2308i(Context context, C2306a c2306a) {
        super(ID, URL);
        this.WG = c2306a;
        this.mContext = context;
    }

    private synchronized boolean bj(String str) {
        boolean z = true;
        synchronized (this) {
            if (!bl(str)) {
                if (bk(str)) {
                    WF.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    boolean bk(String str) {
        return this.mContext.getSharedPreferences(WE, 0).contains(str);
    }

    boolean bl(String str) {
        return WF.contains(str);
    }

    public void m9551z(Map map) {
        String j = map.get(WD) != null ? dh.m9520j((C1816a) map.get(WD)) : null;
        if (j == null || !bj(j)) {
            Builder buildUpon = Uri.parse(dh.m9520j((C1816a) map.get(URL))).buildUpon();
            C1816a c1816a = (C1816a) map.get(WC);
            if (c1816a != null) {
                Object o = dh.m9528o(c1816a);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.m9373w("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.m9373w("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.WG.jY().bz(uri);
            bh.m9375y("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (C2308i.class) {
                    WF.add(j);
                    cy.m9503a(this.mContext, WE, j, "true");
                }
            }
        }
    }
}
