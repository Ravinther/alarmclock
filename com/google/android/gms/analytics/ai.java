package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C1356k.C1354a;

class ai extends C1356k {

    /* renamed from: com.google.android.gms.analytics.ai.a */
    private static class C1355a implements C1354a {
        private final aj wg;

        public C1355a() {
            this.wg = new aj();
        }

        public void m5952a(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.wg.wj = i;
            } else {
                aa.m5916z("int configuration name not recognized:  " + str);
            }
        }

        public void m5953a(String str, String str2) {
            this.wg.wn.put(str, str2);
        }

        public void m5954b(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.wg.wh = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.wg.wi = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    aa.m5913w("Error parsing ga_sampleFrequency value: " + str2);
                }
            } else {
                aa.m5916z("string configuration name not recognized:  " + str);
            }
        }

        public void m5955c(String str, boolean z) {
            int i = 1;
            aj ajVar;
            if ("ga_autoActivityTracking".equals(str)) {
                ajVar = this.wg;
                if (!z) {
                    i = 0;
                }
                ajVar.wk = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                ajVar = this.wg;
                if (!z) {
                    i = 0;
                }
                ajVar.wl = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                ajVar = this.wg;
                if (!z) {
                    i = 0;
                }
                ajVar.wm = i;
            } else {
                aa.m5916z("bool configuration name not recognized:  " + str);
            }
        }

        public /* synthetic */ C1357j cg() {
            return di();
        }

        public aj di() {
            return this.wg;
        }
    }

    public ai(Context context) {
        super(context, new C1355a());
    }
}
