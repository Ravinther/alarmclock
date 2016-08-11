package com.google.android.gms.analytics;

public class aa {
    private static GoogleAnalytics vs;

    public static boolean cT() {
        return getLogger() != null && getLogger().getLogLevel() == 0;
    }

    private static Logger getLogger() {
        if (vs == null) {
            vs = GoogleAnalytics.cM();
        }
        return vs != null ? vs.getLogger() : null;
    }

    public static void m5913w(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void m5914x(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(str);
        }
    }

    public static void m5915y(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void m5916z(String str) {
        Logger logger = getLogger();
        if (logger != null) {
            logger.warn(str);
        }
    }
}
