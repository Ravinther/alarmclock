package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.mopub.common.AdUrlGenerator;
import java.util.HashMap;
import java.util.Map;

public final class ba {
    public static final bb mG;
    public static final bb mH;
    public static final bb mI;
    public static final bb mJ;
    public static final bb mK;
    public static final bb mL;
    public static final bb mM;
    public static final bb mN;
    public static final bb mO;

    /* renamed from: com.google.android.gms.internal.ba.1 */
    static class C17511 implements bb {
        C17511() {
        }

        public void m7886b(dz dzVar, Map map) {
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.2 */
    static class C17522 implements bb {
        C17522() {
        }

        public void m7887b(dz dzVar, Map map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                dw.m8221z("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = dzVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), Cast.MAX_MESSAGE_LENGTH) != null));
            }
            dzVar.m8230a("openableURLs", hashMap);
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.3 */
    static class C17533 implements bb {
        C17533() {
        }

        public void m7888b(dz dzVar, Map map) {
            String str = (String) map.get(AdUrlGenerator.DEVICE_ORIENTATION_UNKNOWN);
            if (str == null) {
                dw.m8221z("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C2026l bJ = dzVar.bJ();
                if (bJ != null && bJ.m8953a(parse)) {
                    a = bJ.m8951a(parse, dzVar.getContext());
                    new du(dzVar.getContext(), dzVar.bK().rq, a.toString()).start();
                }
            } catch (C2027m e) {
                dw.m8221z("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new du(dzVar.getContext(), dzVar.bK().rq, a.toString()).start();
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.4 */
    static class C17544 implements bb {
        C17544() {
        }

        public void m7889b(dz dzVar, Map map) {
            cc bH = dzVar.bH();
            if (bH == null) {
                dw.m8221z("A GMSG tried to close something that wasn't an overlay.");
            } else {
                bH.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.5 */
    static class C17555 implements bb {
        C17555() {
        }

        public void m7890b(dz dzVar, Map map) {
            cc bH = dzVar.bH();
            if (bH == null) {
                dw.m8221z("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                bH.m8030i("1".equals(map.get("custom_close")));
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.6 */
    static class C17566 implements bb {
        C17566() {
        }

        public void m7891b(dz dzVar, Map map) {
            String str = (String) map.get(AdUrlGenerator.DEVICE_ORIENTATION_UNKNOWN);
            if (str == null) {
                dw.m8221z("URL missing from httpTrack GMSG.");
            } else {
                new du(dzVar.getContext(), dzVar.bK().rq, str).start();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.7 */
    static class C17577 implements bb {
        C17577() {
        }

        public void m7892b(dz dzVar, Map map) {
            dw.m8219x("Received log message: " + ((String) map.get("string")));
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.8 */
    static class C17588 implements bb {
        C17588() {
        }

        public void m7893b(dz dzVar, Map map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C2026l bJ = dzVar.bJ();
                if (bJ != null) {
                    bJ.m8954y().m8629a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                dw.m8221z("Could not parse touch parameters from gmsg.");
            }
        }
    }

    static {
        mG = new C17511();
        mH = new C17522();
        mI = new C17533();
        mJ = new C17544();
        mK = new C17555();
        mL = new C17566();
        mM = new C17577();
        mN = new C17588();
        mO = new be();
    }
}
