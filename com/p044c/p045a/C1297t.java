package com.p044c.p045a;

import android.net.NetworkInfo;
import com.millennialmedia.android.C2513R;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import com.p044c.p045a.ab.C1259e;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.c.a.t */
class C1297t extends ThreadPoolExecutor {
    C1297t() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new C1259e());
    }

    void m5513a(NetworkInfo info) {
        if (info == null || !info.isConnectedOrConnecting()) {
            m5512a(3);
            return;
        }
        switch (info.getType()) {
            case Base64.DEFAULT /*0*/:
                switch (info.getSubtype()) {
                    case Base64.NO_PADDING /*1*/:
                    case Base64.NO_WRAP /*2*/:
                        m5512a(1);
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    case Base64.CRLF /*4*/:
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                        m5512a(2);
                    case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                    case C2513R.styleable.MMAdView_height /*14*/:
                    case C2513R.styleable.MMAdView_width /*15*/:
                        m5512a(3);
                    default:
                        m5512a(3);
                }
            case Base64.NO_PADDING /*1*/:
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                m5512a(4);
            default:
                m5512a(3);
        }
    }

    private void m5512a(int threadCount) {
        setCorePoolSize(threadCount);
        setMaximumPoolSize(threadCount);
    }
}
