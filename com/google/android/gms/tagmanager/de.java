package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

class de {
    private GoogleAnalytics aaB;
    private Context mContext;
    private Tracker sB;

    /* renamed from: com.google.android.gms.tagmanager.de.a */
    static class C2301a implements Logger {
        C2301a() {
        }

        private static int ci(int i) {
            switch (i) {
                case Base64.NO_WRAP /*2*/:
                    return 0;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                case Base64.CRLF /*4*/:
                    return 1;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    return 2;
                default:
                    return 3;
            }
        }

        public void error(Exception exception) {
            bh.m9370b("", exception);
        }

        public void error(String message) {
            bh.m9373w(message);
        }

        public int getLogLevel() {
            return C2301a.ci(bh.getLogLevel());
        }

        public void info(String message) {
            bh.m9374x(message);
        }

        public void setLogLevel(int logLevel) {
            bh.m9376z("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
        }

        public void verbose(String message) {
            bh.m9375y(message);
        }

        public void warn(String message) {
            bh.m9376z(message);
        }
    }

    de(Context context) {
        this.mContext = context;
    }

    private synchronized void bV(String str) {
        if (this.aaB == null) {
            this.aaB = GoogleAnalytics.getInstance(this.mContext);
            this.aaB.setLogger(new C2301a());
            this.sB = this.aaB.newTracker(str);
        }
    }

    public Tracker bU(String str) {
        bV(str);
        return this.sB;
    }
}
