package com.avg.toolkit.license.p053a;

import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.avg.toolkit.license.a.h */
public class C1010h {

    /* renamed from: com.avg.toolkit.license.a.h.1 */
    static /* synthetic */ class C10001 {
        static final /* synthetic */ int[] f2995a;

        static {
            f2995a = new int[C1001a.values().length];
            try {
                f2995a[C1001a.LIC_AVG_70.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2995a[C1001a.LIC_AVG_75.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2995a[C1001a.LIC_AVG_8.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2995a[C1001a.LIC_AVG_9.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2995a[C1001a.LIC_AVG_10.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.avg.toolkit.license.a.h.a */
    public enum C1001a {
        LIC_AVG_UNKNOWN(0),
        LIC_AVG_70(1),
        LIC_AVG_75(2),
        LIC_AVG_8(3),
        LIC_AVG_9(4),
        LIC_AVG_10(5);
        
        private final int f3003g;

        private C1001a(int index) {
            this.f3003g = index;
        }
    }

    /* renamed from: com.avg.toolkit.license.a.h.b */
    public enum C1002b {
        LIC_DTD_NONE(0),
        LIC_DTD_TEN(1),
        LIC_DTD_THIRTY(2),
        LIC_DTD_SIXTY(3);
        
        private final int f3009e;

        private C1002b(int index) {
            this.f3009e = index;
        }
    }

    /* renamed from: com.avg.toolkit.license.a.h.c */
    public enum C1003c {
        LIC_ET_UNDEFINED(0),
        LIC_ET_HARD(1),
        LIC_ET_SOFT(2),
        LIC_ET_VIP(3);
        
        private final int f3015e;

        private C1003c(int index) {
            this.f3015e = index;
        }
    }

    /* renamed from: com.avg.toolkit.license.a.h.d */
    public enum C1004d {
        LIC_EX_UNDEFINED(0),
        LIC_EX_VALIDITY_PERIOD(1),
        LIC_EX_FIXED_DATE(2);
        
        private final int f3020d;

        private C1004d(int index) {
            this.f3020d = index;
        }
    }

    /* renamed from: com.avg.toolkit.license.a.h.e */
    public enum C1005e {
        LIC_LT_INVALID(0),
        LIC_LT_FREE(1),
        LIC_LT_TRIAL(2),
        LIC_LT_SALES(3),
        LIC_LT_FULL(4),
        LIC_LT_RESERVED(5);
        
        private final int f3028g;

        private C1005e(int index) {
            this.f3028g = index;
        }
    }

    /* renamed from: com.avg.toolkit.license.a.h.f */
    enum C1006f {
        LIC_FV_UNKNOWN,
        LIC_FV_0,
        LIC_FV_1,
        LIC_FV_2,
        LIC_FV_3,
        LIC_FV_4
    }

    /* renamed from: com.avg.toolkit.license.a.h.g */
    public enum C1007g {
        LIC_PREP_CUSTOM(0),
        LIC_PREP_GMS_PROTECTION(200),
        LIC_PREP_GMS_PERFORMANCE(201),
        LIC_PREP_MOBILATION_BASIC_ANDROID(251),
        LIC_PREP_MOBILATION_ADVANCED_ANDROID(256),
        LIC_PREP_MOBILATION_FULL_ANDROID(261),
        LIC_PREP_MOBILATION_BASIC_ANDROID_TABLET(301),
        LIC_PREP_MOBILATION_ADVANCED_ANDROID_TABLET(302),
        LIC_PREP_MOBILATION_FULL_ANDROID_TABLET(303),
        LIC_PREP_MOBILATION_LINK_SCANNER_ANDROID(276),
        LIC_PREP_MOBILATION_VAULT_ANDROID(305),
        LIC_PREP_MOBILATION_CLEANER_ANDROID(308),
        LIC_PREP_MOBILATION_IMAGE_SHRINKER_ANDROID(309),
        LIC_PREP_MOBILATION_CONNECT_ANDROID(311),
        LIC_PREP_MOBILATION_TUNEUP_MINIAPP_ANDROID(312),
        LIC_PREP_MOBILATION_CALLMSG_BLOCKER_ANDROID(313),
        LIC_PREP_MOBILATION_ANTITHEFT_MINIAPP_ANDROID(314),
        LIC_PREP_MOBILATION_ANTIVIRUS_LIGHT_MINIAPP_ANDROID(315),
        LIC_PREP_MOBILATION_ALARMCLOCK_ANDROID(316),
        LIC_PREP_MOBILATION_UNINSTALLER_ANDROID(323),
        LIC_PREP_MOBILATION_TOOLKIT_DEMO_APP(325),
        LIC_PREP_MOBILATION_PREMIUM_BASIC_ANDROID(327),
        LIC_PREP_MOBILATION_PREMIUM_ADVANCED_ANDROID(328),
        LIC_PREP_MOBILATION_PREMIUM_FULL_ANDROID(329),
        LIC_PREP_MOBILATION_PREMIUM_BASIC_ANDROID_TABLET(330),
        LIC_PREP_MOBILATION_PREMIUM_ADVANCED_ANDROID_TABLET(331),
        LIC_PREP_MOBILATION_PREMIUM_FULL_ANDROID_TABLET(332),
        LIC_PREP_FAMILY_CENTER(333);
        
        private final int f3065C;

        private C1007g(int index) {
            this.f3065C = index;
        }

        public int m4418a() {
            return this.f3065C;
        }
    }

    /* renamed from: com.avg.toolkit.license.a.h.h */
    enum C1008h {
        LIC_RT_VALID(0),
        LIC_RT_REFUSED_SOFT(1),
        LIC_RT_REFUSED_HARD(2),
        LIC_RT_COULD_NOT_VERIFY(3);
        
        private final int f3071e;

        private C1008h(int index) {
            this.f3071e = index;
        }
    }

    /* renamed from: com.avg.toolkit.license.a.h.i */
    public enum C1009i {
        LACV_NOT_GIVEN,
        LACV_VALID,
        LACV_INVALID,
        LACV_GENERATED
    }

    static C1006f m4419a(C1001a licAvgVersion, byte internalVersionValue) {
        switch (C10001.f2995a[licAvgVersion.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                return C1006f.LIC_FV_0;
            case Base64.NO_WRAP /*2*/:
                return C1006f.LIC_FV_1;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                switch (internalVersionValue) {
                    case Base64.DEFAULT /*0*/:
                    case Base64.NO_PADDING /*1*/:
                        return C1006f.LIC_FV_2;
                    default:
                        break;
                }
            case Base64.CRLF /*4*/:
                switch (internalVersionValue) {
                    case Base64.DEFAULT /*0*/:
                    case Base64.NO_PADDING /*1*/:
                        return C1006f.LIC_FV_3;
                    default:
                        break;
                }
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                switch (internalVersionValue) {
                    case Base64.DEFAULT /*0*/:
                    case Base64.NO_PADDING /*1*/:
                        return C1006f.LIC_FV_4;
                    default:
                        break;
                }
        }
        return C1006f.LIC_FV_UNKNOWN;
    }
}
