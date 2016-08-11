package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.C1391u.C1390a;
import com.google.android.gms.tagmanager.DataLayer;
import java.util.HashMap;
import java.util.Map;

public class HitBuilders {

    protected static class HitBuilder {
        private Map vl;

        protected HitBuilder() {
            this.vl = new HashMap();
        }

        public Map build() {
            return this.vl;
        }

        protected String get(String paramName) {
            return (String) this.vl.get(paramName);
        }

        public final HitBuilder set(String paramName, String paramValue) {
            C1391u.cy().m6035a(C1390a.MAP_BUILDER_SET);
            if (paramName != null) {
                this.vl.put(paramName, paramValue);
            } else {
                aa.m5916z(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final HitBuilder setAll(Map params) {
            C1391u.cy().m6035a(C1390a.MAP_BUILDER_SET_ALL);
            if (params != null) {
                this.vl.putAll(new HashMap(params));
            }
            return this;
        }

        public HitBuilder setCampaignParamsFromUrl(String utmParams) {
            C1391u.cy().m6035a(C1390a.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
            Object O = ak.m5962O(utmParams);
            if (!TextUtils.isEmpty(O)) {
                Map N = ak.m5961N(O);
                set("&cc", (String) N.get("utm_content"));
                set("&cm", (String) N.get("utm_medium"));
                set("&cn", (String) N.get("utm_campaign"));
                set("&cs", (String) N.get("utm_source"));
                set("&ck", (String) N.get("utm_term"));
                set("&ci", (String) N.get("utm_id"));
                set("&gclid", (String) N.get("gclid"));
                set("&dclid", (String) N.get("dclid"));
                set("&gmob_t", (String) N.get("gmob_t"));
            }
            return this;
        }

        public HitBuilder setCustomDimension(int index, String dimension) {
            set(C1370o.m5989q(index), dimension);
            return this;
        }

        public HitBuilder setCustomMetric(int index, float metric) {
            set(C1370o.m5990r(index), Float.toString(metric));
            return this;
        }

        protected HitBuilder setHitType(String hitType) {
            set("&t", hitType);
            return this;
        }

        public HitBuilder setNewSession() {
            set("&sc", "start");
            return this;
        }

        public HitBuilder setNonInteraction(boolean nonInteraction) {
            set("&ni", ak.m5967u(nonInteraction));
            return this;
        }
    }

    @Deprecated
    public static class AppViewBuilder extends HitBuilder {
        public AppViewBuilder() {
            C1391u.cy().m6035a(C1390a.CONSTRUCT_APP_VIEW);
            set("&t", "appview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class EventBuilder extends HitBuilder {
        public EventBuilder() {
            C1391u.cy().m6035a(C1390a.CONSTRUCT_EVENT);
            set("&t", DataLayer.EVENT_KEY);
        }

        public EventBuilder(String category, String action) {
            this();
            setCategory(category);
            setAction(action);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public EventBuilder setAction(String action) {
            set("&ea", action);
            return this;
        }

        public EventBuilder setCategory(String category) {
            set("&ec", category);
            return this;
        }

        public EventBuilder setLabel(String label) {
            set("&el", label);
            return this;
        }

        public EventBuilder setValue(long value) {
            set("&ev", Long.toString(value));
            return this;
        }
    }

    public static class ExceptionBuilder extends HitBuilder {
        public ExceptionBuilder() {
            C1391u.cy().m6035a(C1390a.CONSTRUCT_EXCEPTION);
            set("&t", "exception");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ExceptionBuilder setDescription(String description) {
            set("&exd", description);
            return this;
        }

        public ExceptionBuilder setFatal(boolean fatal) {
            set("&exf", ak.m5967u(fatal));
            return this;
        }
    }

    public static class ItemBuilder extends HitBuilder {
        public ItemBuilder() {
            C1391u.cy().m6035a(C1390a.CONSTRUCT_ITEM);
            set("&t", "item");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public ItemBuilder setCategory(String category) {
            set("&iv", category);
            return this;
        }

        public ItemBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public ItemBuilder setName(String name) {
            set("&in", name);
            return this;
        }

        public ItemBuilder setPrice(double price) {
            set("&ip", Double.toString(price));
            return this;
        }

        public ItemBuilder setQuantity(long quantity) {
            set("&iq", Long.toString(quantity));
            return this;
        }

        public ItemBuilder setSku(String sku) {
            set("&ic", sku);
            return this;
        }

        public ItemBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }

    public static class ScreenViewBuilder extends HitBuilder {
        public ScreenViewBuilder() {
            C1391u.cy().m6035a(C1390a.CONSTRUCT_APP_VIEW);
            set("&t", "appview");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }
    }

    public static class SocialBuilder extends HitBuilder {
        public SocialBuilder() {
            C1391u.cy().m6035a(C1390a.CONSTRUCT_SOCIAL);
            set("&t", "social");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public SocialBuilder setAction(String action) {
            set("&sa", action);
            return this;
        }

        public SocialBuilder setNetwork(String network) {
            set("&sn", network);
            return this;
        }

        public SocialBuilder setTarget(String target) {
            set("&st", target);
            return this;
        }
    }

    public static class TimingBuilder extends HitBuilder {
        public TimingBuilder() {
            C1391u.cy().m6035a(C1390a.CONSTRUCT_TIMING);
            set("&t", "timing");
        }

        public TimingBuilder(String category, String variable, long value) {
            this();
            setVariable(variable);
            setValue(value);
            setCategory(category);
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TimingBuilder setCategory(String category) {
            set("&utc", category);
            return this;
        }

        public TimingBuilder setLabel(String label) {
            set("&utl", label);
            return this;
        }

        public TimingBuilder setValue(long value) {
            set("&utt", Long.toString(value));
            return this;
        }

        public TimingBuilder setVariable(String variable) {
            set("&utv", variable);
            return this;
        }
    }

    public static class TransactionBuilder extends HitBuilder {
        public TransactionBuilder() {
            C1391u.cy().m6035a(C1390a.CONSTRUCT_TRANSACTION);
            set("&t", "transaction");
        }

        public /* bridge */ /* synthetic */ Map build() {
            return super.build();
        }

        public TransactionBuilder setAffiliation(String affiliation) {
            set("&ta", affiliation);
            return this;
        }

        public TransactionBuilder setCurrencyCode(String currencyCode) {
            set("&cu", currencyCode);
            return this;
        }

        public TransactionBuilder setRevenue(double revenue) {
            set("&tr", Double.toString(revenue));
            return this;
        }

        public TransactionBuilder setShipping(double shipping) {
            set("&ts", Double.toString(shipping));
            return this;
        }

        public TransactionBuilder setTax(double tax) {
            set("&tt", Double.toString(tax));
            return this;
        }

        public TransactionBuilder setTransactionId(String transactionid) {
            set("&ti", transactionid);
            return this;
        }
    }
}
