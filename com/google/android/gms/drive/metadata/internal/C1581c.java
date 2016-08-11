package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gv;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.drive.metadata.internal.c */
public final class C1581c {
    private static Map FP;

    static {
        FP = new HashMap();
        C1581c.m6660b(gs.FR);
        C1581c.m6660b(gs.Go);
        C1581c.m6660b(gs.Gh);
        C1581c.m6660b(gs.Gm);
        C1581c.m6660b(gs.Gp);
        C1581c.m6660b(gs.Gb);
        C1581c.m6660b(gs.Gc);
        C1581c.m6660b(gs.FZ);
        C1581c.m6660b(gs.Ge);
        C1581c.m6660b(gs.Gk);
        C1581c.m6660b(gs.FS);
        C1581c.m6660b(gs.Gj);
        C1581c.m6660b(gs.FT);
        C1581c.m6660b(gs.Ga);
        C1581c.m6660b(gs.FU);
        C1581c.m6660b(gs.FV);
        C1581c.m6660b(gs.FW);
        C1581c.m6660b(gs.Gg);
        C1581c.m6660b(gs.Gd);
        C1581c.m6660b(gs.Gi);
        C1581c.m6660b(gs.Gl);
        C1581c.m6660b(gs.Gq);
        C1581c.m6660b(gs.Gr);
        C1581c.m6660b(gs.FY);
        C1581c.m6660b(gs.FX);
        C1581c.m6660b(gs.Gn);
        C1581c.m6660b(gs.Gf);
        C1581c.m6660b(gt.Gs);
        C1581c.m6660b(gt.Gu);
        C1581c.m6660b(gt.Gv);
        C1581c.m6660b(gt.Gw);
        C1581c.m6660b(gt.Gt);
        C1581c.m6660b(gv.Gy);
        C1581c.m6660b(gv.Gz);
    }

    public static MetadataField ax(String str) {
        return (MetadataField) FP.get(str);
    }

    private static void m6660b(MetadataField metadataField) {
        if (FP.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        FP.put(metadataField.getName(), metadataField);
    }

    public static Collection fS() {
        return Collections.unmodifiableCollection(FP.values());
    }
}
