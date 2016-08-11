package com.google.analytics.tracking.android;

import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.google.analytics.tracking.android.MetaModel.Formatter;
import com.google.android.gms.plus.PlusShare;
import java.text.DecimalFormat;

class MetaModelInitializer {
    private static final Formatter f4212a;
    private static final Formatter f4213b;

    /* renamed from: com.google.analytics.tracking.android.MetaModelInitializer.1 */
    static class C13281 implements Formatter {
        C13281() {
        }

        public String m5767a(String rawValue) {
            return Utils.m5846c(rawValue) ? "1" : ITKSvc.CODEREVISION;
        }
    }

    /* renamed from: com.google.analytics.tracking.android.MetaModelInitializer.2 */
    static class C13292 implements Formatter {
        private final DecimalFormat f4211a;

        C13292() {
            this.f4211a = new DecimalFormat("0.##");
        }

        public String m5768a(String rawValue) {
            return this.f4211a.format(Utils.m5845b(rawValue));
        }
    }

    static {
        f4212a = new C13281();
        f4213b = new C13292();
    }

    private MetaModelInitializer() {
    }

    public static void m5769a(MetaModel m) {
        m.m5766a("apiVersion", "v", null, null);
        m.m5766a("libraryVersion", "_v", null, null);
        m.m5766a("anonymizeIp", "aip", ITKSvc.CODEREVISION, f4212a);
        m.m5766a("trackingId", "tid", null, null);
        m.m5766a("hitType", "t", null, null);
        m.m5766a("sessionControl", "sc", null, null);
        m.m5766a("adSenseAdMobHitId", "a", null, null);
        m.m5766a("usage", "_u", null, null);
        m.m5766a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "dt", null, null);
        m.m5766a("referrer", "dr", null, null);
        m.m5766a("language", "ul", null, null);
        m.m5766a("encoding", "de", null, null);
        m.m5766a("page", "dp", null, null);
        m.m5766a("screenColors", "sd", null, null);
        m.m5766a("screenResolution", "sr", null, null);
        m.m5766a("viewportSize", "vp", null, null);
        m.m5766a("javaEnabled", "je", "1", f4212a);
        m.m5766a("flashVersion", "fl", null, null);
        m.m5766a("clientId", "cid", null, null);
        m.m5766a("campaignName", "cn", null, null);
        m.m5766a("campaignSource", "cs", null, null);
        m.m5766a("campaignMedium", "cm", null, null);
        m.m5766a("campaignKeyword", "ck", null, null);
        m.m5766a("campaignContent", "cc", null, null);
        m.m5766a("campaignId", "ci", null, null);
        m.m5766a("gclid", "gclid", null, null);
        m.m5766a("dclid", "dclid", null, null);
        m.m5766a("gmob_t", "gmob_t", null, null);
        m.m5766a("eventCategory", "ec", null, null);
        m.m5766a("eventAction", "ea", null, null);
        m.m5766a("eventLabel", "el", null, null);
        m.m5766a("eventValue", "ev", null, null);
        m.m5766a("nonInteraction", "ni", ITKSvc.CODEREVISION, f4212a);
        m.m5766a("socialNetwork", "sn", null, null);
        m.m5766a("socialAction", "sa", null, null);
        m.m5766a("socialTarget", "st", null, null);
        m.m5766a("appName", "an", null, null);
        m.m5766a("appVersion", "av", null, null);
        m.m5766a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, "cd", null, null);
        m.m5766a("appId", "aid", null, null);
        m.m5766a("appInstallerId", "aiid", null, null);
        m.m5766a("transactionId", "ti", null, null);
        m.m5766a("transactionAffiliation", "ta", null, null);
        m.m5766a("transactionShipping", "ts", null, null);
        m.m5766a("transactionTotal", "tr", null, null);
        m.m5766a("transactionTax", "tt", null, null);
        m.m5766a("currencyCode", "cu", null, null);
        m.m5766a("itemPrice", "ip", null, null);
        m.m5766a("itemCode", "ic", null, null);
        m.m5766a("itemName", "in", null, null);
        m.m5766a("itemCategory", "iv", null, null);
        m.m5766a("itemQuantity", "iq", null, null);
        m.m5766a("exDescription", "exd", null, null);
        m.m5766a("exFatal", "exf", "1", f4212a);
        m.m5766a("timingVar", "utv", null, null);
        m.m5766a("timingValue", "utt", null, null);
        m.m5766a("timingCategory", "utc", null, null);
        m.m5766a("timingLabel", "utl", null, null);
        m.m5766a(GoogleAnalyticsWrapper.PROPERTY_SAMPLE_RATE, "sf", "100", f4213b);
        m.m5766a("hitTime", "ht", null, null);
        m.m5766a("customDimension", "cd", null, null);
        m.m5766a("customMetric", "cm", null, null);
        m.m5766a("contentGrouping", "cg", null, null);
    }
}
