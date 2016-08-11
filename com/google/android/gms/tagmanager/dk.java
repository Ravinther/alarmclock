package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1817d.C1816a;
import com.mopub.mobileads.C2625R;
import java.net.URLEncoder;

class dk {
    private static by m9543a(by byVar) {
        try {
            return new by(dh.m9531r(cd(dh.m9520j((C1816a) byVar.getObject()))), byVar.kQ());
        } catch (Throwable e) {
            bh.m9370b("Escape URI: unsupported encoding", e);
            return byVar;
        }
    }

    private static by m9544a(by byVar, int i) {
        if (m9546q((C1816a) byVar.getObject())) {
            switch (i) {
                case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                    return m9543a(byVar);
                default:
                    bh.m9373w("Unsupported Value Escaping: " + i);
                    return byVar;
            }
        }
        bh.m9373w("Escaping can only be applied to strings.");
        return byVar;
    }

    static by m9545a(by byVar, int... iArr) {
        for (int a : iArr) {
            byVar = m9544a(byVar, a);
        }
        return byVar;
    }

    static String cd(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean m9546q(C1816a c1816a) {
        return dh.m9528o(c1816a) instanceof String;
    }
}
