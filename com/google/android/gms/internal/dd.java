package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.text.TextUtils;
import com.avg.toolkit.ads.AdsManager;
import com.google.android.gms.plus.PlusShare;
import com.millennialmedia.android.MMRequest;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class dd {
    private static final SimpleDateFormat pH;

    static {
        pH = new SimpleDateFormat("yyyyMMdd");
    }

    public static cz m8121a(Context context, cx cxVar, String str) {
        try {
            cz czVar;
            int i;
            List list;
            List list2;
            List list3;
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("ad_base_url", null);
            String optString2 = jSONObject.optString("ad_url", null);
            String optString3 = jSONObject.optString("ad_size", null);
            String optString4 = jSONObject.optString("ad_html", null);
            long j = -1;
            String optString5 = jSONObject.optString("debug_dialog", null);
            long j2 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString6 = jSONObject.optString(MMRequest.KEY_ORIENTATION, null);
            int i2 = -1;
            if ("portrait".equals(optString6)) {
                i2 = dq.bA();
            } else if ("landscape".equals(optString6)) {
                i2 = dq.bz();
            }
            if (TextUtils.isEmpty(optString4)) {
                if (TextUtils.isEmpty(optString2)) {
                    dw.m8221z("Could not parse the mediation config: Missing required ad_html or ad_url field.");
                    return new cz(0);
                }
                cz a = dc.m8116a(context, cxVar.kK.rq, optString2);
                optString = a.ol;
                optString4 = a.pm;
                j = a.ps;
                czVar = a;
            } else if (TextUtils.isEmpty(optString)) {
                dw.m8221z("Could not parse the mediation config: Missing required ad_base_url field");
                return new cz(0);
            } else {
                czVar = null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = czVar == null ? null : czVar.ne;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray.length(); i++) {
                    list4.add(optJSONArray.getString(i));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = czVar == null ? null : czVar.nf;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray2.length(); i++) {
                    list4.add(optJSONArray2.getString(i));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = czVar == null ? null : czVar.pq;
            if (optJSONArray3 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray3.length(); i++) {
                    list4.add(optJSONArray3.getString(i));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (czVar != null) {
                if (czVar.orientation != -1) {
                    i2 = czVar.orientation;
                }
                if (czVar.pn > 0) {
                    j2 = czVar.pn;
                }
            }
            String optString7 = jSONObject.optString("active_view");
            String str2 = null;
            boolean optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str2 = jSONObject.optString("ad_passback_url", null);
            }
            return new cz(optString, optString4, list, list2, j2, false, -1, list3, -1, i2, optString3, j, optString5, optBoolean, str2, optString7);
        } catch (JSONException e) {
            dw.m8221z("Could not parse the mediation config: " + e.getMessage());
            return new cz(0);
        }
    }

    public static String m8122a(cx cxVar, dg dgVar, Location location, String str) {
        try {
            HashMap hashMap = new HashMap();
            if (!(str == null || str.trim() == "")) {
                hashMap.put("eid", str);
            }
            if (cxVar.pf != null) {
                hashMap.put("ad_pos", cxVar.pf);
            }
            m8124a(hashMap, cxVar.pg);
            hashMap.put("format", cxVar.kN.lS);
            if (cxVar.kN.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (cxVar.kN.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (cxVar.kN.lU != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (ak akVar : cxVar.kN.lU) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(akVar.width == -1 ? (int) (((float) akVar.widthPixels) / dgVar.qp) : akVar.width);
                    stringBuilder.append("x");
                    stringBuilder.append(akVar.height == -2 ? (int) (((float) akVar.heightPixels) / dgVar.qp) : akVar.height);
                }
                hashMap.put("sz", stringBuilder);
            }
            hashMap.put("slotname", cxVar.kH);
            hashMap.put("pn", cxVar.applicationInfo.packageName);
            if (cxVar.ph != null) {
                hashMap.put("vc", Integer.valueOf(cxVar.ph.versionCode));
            }
            hashMap.put("ms", cxVar.pi);
            hashMap.put("seq_num", cxVar.pj);
            hashMap.put("session_id", cxVar.pk);
            hashMap.put("js", cxVar.kK.rq);
            m8126a(hashMap, dgVar);
            if (cxVar.pg.versionCode >= 2 && cxVar.pg.lP != null) {
                m8123a(hashMap, cxVar.pg.lP);
            }
            if (cxVar.versionCode >= 2) {
                hashMap.put("quality_signals", cxVar.pl);
            }
            if (dw.m8216n(2)) {
                dw.m8220y("Ad Request JSON: " + dq.m8192p(hashMap).toString(2));
            }
            return dq.m8192p(hashMap).toString();
        } catch (JSONException e) {
            dw.m8221z("Problem serializing ad request to JSON: " + e.getMessage());
            return null;
        }
    }

    private static void m8123a(HashMap hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put(AdsManager.PREFS_KEY_TIME, valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void m8124a(HashMap hashMap, ah ahVar) {
        String bx = dn.bx();
        if (bx != null) {
            hashMap.put("abf", bx);
        }
        if (ahVar.lH != -1) {
            hashMap.put("cust_age", pH.format(new Date(ahVar.lH)));
        }
        if (ahVar.extras != null) {
            hashMap.put("extras", ahVar.extras);
        }
        if (ahVar.lI != -1) {
            hashMap.put("cust_gender", Integer.valueOf(ahVar.lI));
        }
        if (ahVar.lJ != null) {
            hashMap.put("kw", ahVar.lJ);
        }
        if (ahVar.lL != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(ahVar.lL));
        }
        if (ahVar.lK) {
            hashMap.put("adtest", "on");
        }
        if (ahVar.versionCode >= 2) {
            if (ahVar.lM) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(ahVar.lN)) {
                hashMap.put("ppid", ahVar.lN);
            }
            if (ahVar.lO != null) {
                m8125a(hashMap, ahVar.lO);
            }
        }
        if (ahVar.versionCode >= 3 && ahVar.lQ != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, ahVar.lQ);
        }
    }

    private static void m8125a(HashMap hashMap, av avVar) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(avVar.mq) != 0) {
            hashMap.put("acolor", m8128m(avVar.mq));
        }
        if (Color.alpha(avVar.backgroundColor) != 0) {
            hashMap.put("bgcolor", m8128m(avVar.backgroundColor));
        }
        if (!(Color.alpha(avVar.mr) == 0 || Color.alpha(avVar.ms) == 0)) {
            hashMap.put("gradientto", m8128m(avVar.mr));
            hashMap.put("gradientfrom", m8128m(avVar.ms));
        }
        if (Color.alpha(avVar.mt) != 0) {
            hashMap.put("bcolor", m8128m(avVar.mt));
        }
        hashMap.put("bthick", Integer.toString(avVar.mu));
        switch (avVar.mv) {
            case Base64.DEFAULT /*0*/:
                obj = "none";
                break;
            case Base64.NO_PADDING /*1*/:
                obj = "dashed";
                break;
            case Base64.NO_WRAP /*2*/:
                obj = "dotted";
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (avVar.mw) {
            case Base64.DEFAULT /*0*/:
                obj2 = "light";
                break;
            case Base64.NO_PADDING /*1*/:
                obj2 = "medium";
                break;
            case Base64.NO_WRAP /*2*/:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (avVar.mx != null) {
            hashMap.put("channel", avVar.mx);
        }
        if (Color.alpha(avVar.my) != 0) {
            hashMap.put("dcolor", m8128m(avVar.my));
        }
        if (avVar.mz != null) {
            hashMap.put("font", avVar.mz);
        }
        if (Color.alpha(avVar.mA) != 0) {
            hashMap.put("hcolor", m8128m(avVar.mA));
        }
        hashMap.put("headersize", Integer.toString(avVar.mB));
        if (avVar.mC != null) {
            hashMap.put("q", avVar.mC);
        }
    }

    private static void m8126a(HashMap hashMap, dg dgVar) {
        hashMap.put("am", Integer.valueOf(dgVar.pZ));
        hashMap.put("cog", m8127l(dgVar.qa));
        hashMap.put("coh", m8127l(dgVar.qb));
        if (!TextUtils.isEmpty(dgVar.qc)) {
            hashMap.put("carrier", dgVar.qc);
        }
        hashMap.put("gl", dgVar.qd);
        if (dgVar.qe) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        hashMap.put("ma", m8127l(dgVar.qf));
        hashMap.put("sp", m8127l(dgVar.qg));
        hashMap.put("hl", dgVar.qh);
        if (!TextUtils.isEmpty(dgVar.qi)) {
            hashMap.put("mv", dgVar.qi);
        }
        hashMap.put("muv", Integer.valueOf(dgVar.qj));
        if (dgVar.qk != -2) {
            hashMap.put("cnt", Integer.valueOf(dgVar.qk));
        }
        hashMap.put("gnt", Integer.valueOf(dgVar.ql));
        hashMap.put("pt", Integer.valueOf(dgVar.qm));
        hashMap.put("rm", Integer.valueOf(dgVar.qn));
        hashMap.put("riv", Integer.valueOf(dgVar.qo));
        hashMap.put("u_sd", Float.valueOf(dgVar.qp));
        hashMap.put("sh", Integer.valueOf(dgVar.qr));
        hashMap.put("sw", Integer.valueOf(dgVar.qq));
    }

    private static Integer m8127l(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    private static String m8128m(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }
}
