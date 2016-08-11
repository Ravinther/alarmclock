package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ad.C1733a;
import com.google.android.gms.internal.ea.C1739a;
import org.json.JSONObject;

public class ae implements ad {
    private final dz lC;

    /* renamed from: com.google.android.gms.internal.ae.1 */
    class C17401 implements C1739a {
        final /* synthetic */ C1733a lD;
        final /* synthetic */ ae lE;

        C17401(ae aeVar, C1733a c1733a) {
            this.lE = aeVar;
            this.lD = c1733a;
        }

        public void m7813a(dz dzVar) {
            this.lD.ay();
        }
    }

    public ae(Context context, dx dxVar) {
        this.lC = dz.m8225a(context, new ak(), false, false, null, dxVar);
    }

    public void m7814a(C1733a c1733a) {
        this.lC.bI().m8242a(new C17401(this, c1733a));
    }

    public void m7815a(String str, bb bbVar) {
        this.lC.bI().m8244a(str, bbVar);
    }

    public void m7816a(String str, JSONObject jSONObject) {
        this.lC.m8231a(str, jSONObject);
    }

    public void m7817d(String str) {
        this.lC.loadUrl(str);
    }

    public void m7818e(String str) {
        this.lC.bI().m8244a(str, null);
    }
}
