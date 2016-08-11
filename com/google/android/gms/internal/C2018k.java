package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.k */
public class C2018k extends C1996j {

    /* renamed from: com.google.android.gms.internal.k.a */
    class C2017a {
        private String ka;
        private boolean kb;
        final /* synthetic */ C2018k kc;

        public C2017a(C2018k c2018k, String str, boolean z) {
            this.kc = c2018k;
            this.ka = str;
            this.kb = z;
        }

        public String getId() {
            return this.ka;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.kb;
        }
    }

    private C2018k(Context context, C1833n c1833n, C2028o c2028o) {
        super(context, c1833n, c2028o);
    }

    public static C2018k m8891a(String str, Context context) {
        C1833n c1834e = new C1834e();
        C1996j.m8810a(str, context, c1834e);
        return new C2018k(context, c1834e, new C2031q(239));
    }

    protected void m8892b(Context context) {
        long j = 1;
        super.m8818b(context);
        try {
            C2017a f = m8893f(context);
            try {
                if (!f.isLimitAdTrackingEnabled()) {
                    j = 0;
                }
                m8732a(28, j);
                String id = f.getId();
                if (id != null) {
                    m8733a(30, id);
                }
            } catch (IOException e) {
            }
        } catch (GooglePlayServicesNotAvailableException e2) {
        } catch (IOException e3) {
            m8732a(28, 1);
        }
    }

    C2017a m8893f(Context context) {
        int i = 0;
        try {
            String str;
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            String id = advertisingIdInfo.getId();
            if (id == null || !id.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                str = id;
            } else {
                byte[] bArr = new byte[16];
                int i2 = 0;
                while (i < id.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        i++;
                    }
                    bArr[i2] = (byte) ((Character.digit(id.charAt(i), 16) << 4) + Character.digit(id.charAt(i + 1), 16));
                    i2++;
                    i += 2;
                }
                str = this.jP.m8234a(bArr, true);
            }
            return new C2017a(this, str, advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (Throwable e) {
            throw new IOException(e);
        }
    }
}
