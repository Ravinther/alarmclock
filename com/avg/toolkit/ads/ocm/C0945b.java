package com.avg.toolkit.ads.ocm;

/* renamed from: com.avg.toolkit.ads.ocm.b */
public class C0945b {

    /* renamed from: com.avg.toolkit.ads.ocm.b.a */
    public enum C0943a {
        GENERAL_PARSING_ERROR("TEGEC", 0),
        LANDSCAPE_MODE("TEGEC", 1),
        NO_NETWORK("TEGEC", 2),
        OVL_ALREADY_DISPLAYED("TEGEC", 3),
        INVALID_PAGE_TITLE("TEGEC", 4),
        WV_ERROR_AUTHENTICATION("TEGEC", 5),
        WV_ERROR_BAD_URL("TEGEC", 6),
        WV_ERROR_CONNECT("TEGEC", 7),
        WV_ERROR_FAILED_SSL_HANDSHAKE("TEGEC", 8),
        WV_ERROR_FILE("TEGEC", 9),
        WV_ERROR_FILE_NOT_FOUND("TEGEC", 10),
        WV_ERROR_HOST_LOOKUP("TEGEC", 11),
        WV_ERROR_IO("TEGEC", 12),
        WV_ERROR_PROXY_AUTHENTICATION("TEGEC", 13),
        WV_ERROR_REDIRECT_LOOP("TEGEC", 14),
        WV_ERROR_TIMEOUT("TEGEC", 15),
        WV_ERROR_TOO_MANY_REQUESTS("TEGEC", 16),
        WV_ERROR_UNKNOWN("TEGEC", 17),
        WV_ERROR_UNSUPPORTED_AUTH_SCHEME("TEGEC", 18),
        WV_ERROR_UNSUPPORTED_SCHEME("TEGEC", 19),
        CAMPAIGN_INACTIVE("TERDA", 0),
        BAD_BUILD_NUMBER_RANGE("TERDA", 1),
        BAD_CAMPAIGN_PERIOD("TERDA", 2),
        BAD_DAYS_TO_EXPIRATION("TERDA", 3),
        BAD_DAYS_AFTER_INSTALLATION("TERDA", 4),
        WRONG_LICENSE_TYPE("TERDA", 5),
        WRONG_PRODUCT_TYPE("TERDA", 6),
        WRONG_VENDOR_ID("TERDA", 7),
        CYC_ERROR("TERDA", 8),
        PER_NOT_ENOUGH_TIME_BETWEEN_DISPLAYS("TERDA", 9),
        CDTD_COUNTDOWN_NOT_FINISHED("TERDA", 10),
        GEN_TM_BTW_OVRLYS_ACTIVE("TERDA", 11),
        APP_ALREADY_INSTALLED("TERDA", 12),
        REGISTERED_TO_ANTITHEFT("TERDA", 13),
        CAMERA_TRAP_ON("TERDA", 14),
        SIM_LOCK_ON("TERDA", 15),
        APP_LOCKER_PWD_SET("TERDA", 16),
        DATA_USAGE_COUNT_ON("TERDA", 17),
        CMB_BW_LIST_NOT_EMPTY("TERDA", 18),
        OPEN_ZEN_LOGIN("TERDA", 19),
        NOTIFICATION_RAISED("TEGNT", 0),
        NOTIFICATION_TAPPED("TEGNT", 1);
        
        private String f2844Q;
        private int f2845R;

        private C0943a(String category, int errorCode) {
            this.f2845R = -1;
            this.f2844Q = category;
            this.f2845R = errorCode;
        }

        public String m4266a() {
            return this.f2844Q;
        }

        public int m4267b() {
            return this.f2845R;
        }
    }

    /* renamed from: com.avg.toolkit.ads.ocm.b.b */
    public enum C0944b {
        UNDEFINED(-1),
        PRELOAD(0),
        DISPLAY(1),
        PARSING(2),
        NOTIFICATION(3);
        
        private int f2852f;

        private C0944b(int value) {
            this.f2852f = value;
        }

        public int m4268a() {
            return this.f2852f;
        }
    }
}
