package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.C1356k.C1354a;

/* renamed from: com.google.android.gms.analytics.v */
class C1393v extends C1356k {

    /* renamed from: com.google.android.gms.analytics.v.a */
    private static class C1392a implements C1354a {
        private final C1394w uU;

        public C1392a() {
            this.uU = new C1394w();
        }

        public void m6037a(String str, int i) {
            if ("ga_dispatchPeriod".equals(str)) {
                this.uU.uW = i;
            } else {
                aa.m5916z("int configuration name not recognized:  " + str);
            }
        }

        public void m6038a(String str, String str2) {
        }

        public void m6039b(String str, String str2) {
            if ("ga_appName".equals(str)) {
                this.uU.so = str2;
            } else if ("ga_appVersion".equals(str)) {
                this.uU.sp = str2;
            } else if ("ga_logLevel".equals(str)) {
                this.uU.uV = str2;
            } else {
                aa.m5916z("string configuration name not recognized:  " + str);
            }
        }

        public void m6040c(String str, boolean z) {
            if ("ga_dryRun".equals(str)) {
                this.uU.uX = z ? 1 : 0;
                return;
            }
            aa.m5916z("bool configuration name not recognized:  " + str);
        }

        public C1394w cB() {
            return this.uU;
        }

        public /* synthetic */ C1357j cg() {
            return cB();
        }
    }

    public C1393v(Context context) {
        super(context, new C1392a());
    }
}
