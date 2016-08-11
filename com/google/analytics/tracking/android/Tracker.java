package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.google.analytics.tracking.android.GAUsage.Field;
import com.google.analytics.tracking.android.Transaction.Item;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.tagmanager.DataLayer;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Tracker {
    private static final DecimalFormat f4042a;
    private final TrackerHandler f4043b;
    private final SimpleModel f4044c;
    private volatile boolean f4045d;
    private volatile boolean f4046e;
    private long f4047f;
    private long f4048g;
    private boolean f4049h;

    private static class SimpleModel {
        private Map f4231a;
        private Map f4232b;

        private SimpleModel() {
            this.f4231a = new HashMap();
            this.f4232b = new HashMap();
        }

        public synchronized void m5806a(String key, String value) {
            this.f4231a.put(key, value);
        }

        public synchronized void m5809b(String key, String value) {
            this.f4232b.put(key, value);
        }

        public synchronized void m5805a() {
            this.f4231a.clear();
        }

        public synchronized void m5807a(Map keysAndValues, Boolean isForNextHit) {
            if (isForNextHit.booleanValue()) {
                this.f4231a.putAll(keysAndValues);
            } else {
                this.f4232b.putAll(keysAndValues);
            }
        }

        public synchronized Map m5808b() {
            Map result;
            result = new HashMap(this.f4232b);
            result.putAll(this.f4231a);
            return result;
        }
    }

    static {
        f4042a = new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US));
    }

    Tracker() {
        this.f4045d = false;
        this.f4046e = false;
        this.f4047f = 120000;
        this.f4049h = true;
        this.f4043b = null;
        this.f4044c = null;
    }

    Tracker(String trackingId, TrackerHandler handler) {
        this.f4045d = false;
        this.f4046e = false;
        this.f4047f = 120000;
        this.f4049h = true;
        if (trackingId == null) {
            throw new IllegalArgumentException("trackingId cannot be null");
        }
        this.f4043b = handler;
        this.f4044c = new SimpleModel();
        this.f4044c.m5809b("trackingId", trackingId);
        this.f4044c.m5809b(GoogleAnalyticsWrapper.PROPERTY_SAMPLE_RATE, "100");
        this.f4044c.m5806a("sessionControl", "start");
        this.f4044c.m5809b("useSecure", Boolean.toString(true));
    }

    private void m5600b() {
        if (this.f4045d) {
            throw new IllegalStateException("Tracker closed");
        }
    }

    public void m5605a(String appName) {
        if (this.f4046e) {
            Log.m5759i("Tracking already started, setAppName call ignored");
        } else if (TextUtils.isEmpty(appName)) {
            Log.m5759i("setting appName to empty value not allowed, call ignored");
        } else {
            GAUsage.m5726a().m5727a(Field.SET_APP_NAME);
            this.f4044c.m5809b("appName", appName);
        }
    }

    public void m5615b(String appVersion) {
        if (this.f4046e) {
            Log.m5759i("Tracking already started, setAppVersion call ignored");
            return;
        }
        GAUsage.m5726a().m5727a(Field.SET_APP_VERSION);
        this.f4044c.m5809b("appVersion", appVersion);
    }

    public void m5616c(String appScreen) {
        m5600b();
        if (TextUtils.isEmpty(appScreen)) {
            throw new IllegalStateException("trackView requires a appScreen to be set");
        }
        GAUsage.m5726a().m5727a(Field.TRACK_VIEW_WITH_APPSCREEN);
        this.f4044c.m5809b(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, appScreen);
        m5599a("appview", null);
    }

    public void m5607a(String category, String action, String label, Long value) {
        m5600b();
        GAUsage.m5726a().m5727a(Field.TRACK_EVENT);
        GAUsage.m5726a().m5728a(true);
        m5599a(DataLayer.EVENT_KEY, m5613b(category, action, label, value));
        GAUsage.m5726a().m5728a(false);
    }

    public void m5604a(Transaction transaction) {
        m5600b();
        GAUsage.m5726a().m5727a(Field.TRACK_TRANSACTION);
        GAUsage.m5726a().m5728a(true);
        m5599a("tran", m5611b(transaction));
        for (Item item : transaction.m5840g()) {
            m5599a("item", m5598a(item, transaction));
        }
        GAUsage.m5726a().m5728a(false);
    }

    public void m5608a(String description, boolean fatal) {
        m5600b();
        GAUsage.m5726a().m5727a(Field.TRACK_EXCEPTION_WITH_DESCRIPTION);
        GAUsage.m5726a().m5728a(true);
        m5599a("exception", m5614b(description, fatal));
        GAUsage.m5726a().m5728a(false);
    }

    public void m5606a(String category, long intervalInMilliseconds, String name, String label) {
        m5600b();
        GAUsage.m5726a().m5727a(Field.TRACK_TIMING);
        GAUsage.m5726a().m5728a(true);
        m5599a("timing", m5612b(category, intervalInMilliseconds, name, label));
        GAUsage.m5726a().m5728a(false);
    }

    private void m5599a(String hitType, Map params) {
        this.f4046e = true;
        if (params == null) {
            params = new HashMap();
        }
        params.put("hitType", hitType);
        this.f4044c.m5807a(params, Boolean.valueOf(true));
        if (m5610a()) {
            this.f4043b.m5734a(this.f4044c.m5808b());
        } else {
            Log.m5759i("Too many hits sent too quickly, throttling invoked.");
        }
        this.f4044c.m5805a();
    }

    public void m5601a(double sampleRate) {
        GAUsage.m5726a().m5727a(Field.SET_SAMPLE_RATE);
        this.f4044c.m5809b(GoogleAnalyticsWrapper.PROPERTY_SAMPLE_RATE, Double.toString(sampleRate));
    }

    public void m5617d(String referrer) {
        GAUsage.m5726a().m5727a(Field.SET_REFERRER);
        this.f4044c.m5806a("referrer", referrer);
    }

    public void m5618e(String campaign) {
        GAUsage.m5726a().m5727a(Field.SET_CAMPAIGN);
        this.f4044c.m5806a("campaign", campaign);
    }

    public void m5603a(int index, String value) {
        if (index < 1) {
            Log.m5758h("index must be > 0, ignoring setCustomDimension call for " + index + ", " + value);
        } else {
            this.f4044c.m5806a(Utils.m5842a("customDimension", index), value);
        }
    }

    public void m5602a(int index, Long value) {
        if (index < 1) {
            Log.m5758h("index must be > 0, ignoring setCustomMetric call for " + index + ", " + value);
            return;
        }
        String tmpValue = null;
        if (value != null) {
            tmpValue = Long.toString(value.longValue());
        }
        this.f4044c.m5806a(Utils.m5842a("customMetric", index), tmpValue);
    }

    public void m5609a(Map dimensions, Map metrics) {
        if (dimensions != null) {
            for (Integer key : dimensions.keySet()) {
                m5603a(key.intValue(), (String) dimensions.get(key));
            }
        }
        if (metrics != null) {
            for (Integer key2 : metrics.keySet()) {
                m5602a(key2.intValue(), (Long) metrics.get(key2));
            }
        }
    }

    public Map m5613b(String category, String action, String label, Long value) {
        Map params = new HashMap();
        params.put("eventCategory", category);
        params.put("eventAction", action);
        params.put("eventLabel", label);
        if (value != null) {
            params.put("eventValue", Long.toString(value.longValue()));
        }
        GAUsage.m5726a().m5727a(Field.CONSTRUCT_EVENT);
        return params;
    }

    private static String m5597a(long currencyInMicros) {
        return f4042a.format(((double) currencyInMicros) / 1000000.0d);
    }

    public Map m5611b(Transaction trans) {
        Map params = new HashMap();
        params.put("transactionId", trans.m5833a());
        params.put("transactionAffiliation", trans.m5835b());
        params.put("transactionShipping", m5597a(trans.m5838e()));
        params.put("transactionTax", m5597a(trans.m5837d()));
        params.put("transactionTotal", m5597a(trans.m5836c()));
        params.put("currencyCode", trans.m5839f());
        GAUsage.m5726a().m5727a(Field.CONSTRUCT_TRANSACTION);
        return params;
    }

    private Map m5598a(Item item, Transaction trans) {
        Map params = new HashMap();
        params.put("transactionId", trans.m5833a());
        params.put("currencyCode", trans.m5839f());
        params.put("itemCode", item.m5828a());
        params.put("itemName", item.m5829b());
        params.put("itemCategory", item.m5830c());
        params.put("itemPrice", m5597a(item.m5831d()));
        params.put("itemQuantity", Long.toString(item.m5832e()));
        GAUsage.m5726a().m5727a(Field.CONSTRUCT_ITEM);
        return params;
    }

    public Map m5614b(String exceptionDescription, boolean fatal) {
        Map params = new HashMap();
        params.put("exDescription", exceptionDescription);
        params.put("exFatal", Boolean.toString(fatal));
        GAUsage.m5726a().m5727a(Field.CONSTRUCT_EXCEPTION);
        return params;
    }

    public Map m5612b(String category, long intervalInMilliseconds, String name, String label) {
        Map params = new HashMap();
        params.put("timingCategory", category);
        params.put("timingValue", Long.toString(intervalInMilliseconds));
        params.put("timingVar", name);
        params.put("timingLabel", label);
        GAUsage.m5726a().m5727a(Field.CONSTRUCT_TIMING);
        return params;
    }

    @VisibleForTesting
    synchronized boolean m5610a() {
        boolean z = true;
        synchronized (this) {
            if (this.f4049h) {
                long timeNow = System.currentTimeMillis();
                if (this.f4047f < 120000) {
                    long timeElapsed = timeNow - this.f4048g;
                    if (timeElapsed > 0) {
                        this.f4047f = Math.min(120000, this.f4047f + timeElapsed);
                    }
                }
                this.f4048g = timeNow;
                if (this.f4047f >= 2000) {
                    this.f4047f -= 2000;
                } else {
                    Log.m5759i("Excessive tracking detected.  Tracking call ignored.");
                    z = false;
                }
            }
        }
        return z;
    }
}
