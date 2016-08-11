package com.avg.toolkit.ganalytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p049e.C0970a;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.google.analytics.tracking.android.Transaction;
import com.google.analytics.tracking.android.Transaction.Builder;
import com.google.analytics.tracking.android.Transaction.Item;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.mopub.mobileads.factories.HttpClientFactory;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class GoogleAnalyticsWrapper implements C0647c {
    public static final int FEATURE_ID = 10000;
    public static final String GA_PREFS_FILENAME = "tkgaprefs";
    public static final String PREFS_KEY_CVER = "cver";
    public static final String PREFS_KEY_DISPATCH_PERIOD = "dispPeriod";
    public static final String PREFS_KEY_LAST_PVER = "lpvr";
    public static final String PREFS_KEY_LAST_REQUEST = "lreq";
    public static final String PREFS_KEY_SAMPLE_RATE = "sampleRate";
    public static final String PROPERTY_DISPATCH_PERIOD = "dispatchPeriod";
    public static final String PROPERTY_GANALYTICS_ACCOUNT = "ganalytics";
    public static final String PROPERTY_SAMPLE_RATE = "sampleRate";
    C1017a f2950a;
    private GoogleAnalytics f2951b;
    private String f2952c;
    private Context f2953d;
    private OnSharedPreferenceChangeListener f2954e;

    /* renamed from: com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper.1 */
    class C09811 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ GoogleAnalyticsWrapper f2944a;

        C09811(GoogleAnalyticsWrapper googleAnalyticsWrapper) {
            this.f2944a = googleAnalyticsWrapper;
        }

        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (GoogleAnalyticsWrapper.PROPERTY_SAMPLE_RATE.equals(key)) {
                try {
                    this.f2944a.f2951b.m5738a(this.f2944a.f2952c).m5601a((double) sharedPreferences.getFloat(key, 100.0f));
                } catch (Exception e) {
                    C0970a.m4322a(e);
                }
            } else if (GoogleAnalyticsWrapper.PREFS_KEY_DISPATCH_PERIOD.equals(key)) {
                try {
                    GAServiceManager.m5643a().m5651a(sharedPreferences.getInt(key, 600));
                } catch (Exception e2) {
                    C0970a.m4322a(e2);
                }
            }
        }
    }

    /* renamed from: com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper.a */
    public static class C0982a implements Serializable {
        private static final long serialVersionUID = 1;
        String f2945a;
        String f2946b;
        long f2947c;
        long f2948d;
        String f2949e;
    }

    public static void trackPageView(Context context, String str) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("page", str);
            ITKSvc.Do(context, FEATURE_ID, GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED, bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public static void trackReferrer(Context context, String referrer) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("referrer", referrer);
            ITKSvc.Do(context, FEATURE_ID, GamesActivityResultCodes.RESULT_LICENSE_FAILED, bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public static void trackEvent(Context context, String category, String action, String label, int value) {
        trackEvent(context, category, action, label, Long.valueOf((long) value));
    }

    public static void trackEvent(Context context, String category, String action, String label, Long value) {
        trackEvent(context, category, action, label, value, null, null);
    }

    public static void trackEvent(Context context, String arg0, String arg1, String arg2, Long arg3, Map dimensions, Map metrics) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("arg0", arg0);
            bundle.putString("arg1", arg1);
            bundle.putString("arg2", arg2);
            if (arg3 != null) {
                bundle.putLong("arg3", arg3.longValue());
            }
            bundle.putSerializable("dimensions", (Serializable) dimensions);
            bundle.putSerializable("metrics", (Serializable) metrics);
            ITKSvc.Do(context, FEATURE_ID, GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public static void sendTiming(Context context, String category, String name, String label, Long timing, Map dimensions, Map metrics) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("arg0", category);
            bundle.putString("arg1", name);
            bundle.putString("arg2", label);
            if (timing != null) {
                bundle.putLong("arg3", timing.longValue());
            }
            bundle.putSerializable("dimensions", (Serializable) dimensions);
            bundle.putSerializable("metrics", (Serializable) metrics);
            ITKSvc.Do(context, FEATURE_ID, GamesActivityResultCodes.RESULT_LEFT_ROOM, bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public static void sendTransaction(Context context, String transactionId, long orderTotal, String affiliation, long totalTax, long totalShippingCost, String currencyCode, C0982a... items) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("transaction_id", transactionId);
            bundle.putLong("order_total", orderTotal);
            bundle.putString("affiliation", affiliation);
            bundle.putLong("total_tax", totalTax);
            bundle.putLong("total_shipping_cost", totalShippingCost);
            bundle.putString("currency_code", currencyCode);
            bundle.putSerializable("transaction_items_array", new ArrayList(Arrays.asList(items)));
            ITKSvc.Do(context, FEATURE_ID, GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, bundle);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public void sendTransaction(Bundle arguments) {
        try {
            Builder transBuilder = new Builder(arguments.getString("transaction_id"), arguments.getLong("order_total"));
            if (arguments.containsKey("affiliation")) {
                transBuilder.m5817a(arguments.getString("affiliation"));
            }
            if (arguments.containsKey("total_tax")) {
                transBuilder.m5816a(arguments.getLong("total_tax"));
            }
            if (arguments.containsKey("total_shipping_cost")) {
                transBuilder.m5819b(arguments.getLong("total_shipping_cost"));
            }
            if (arguments.containsKey("currency_code")) {
                transBuilder.m5820b(arguments.getString("currency_code"));
            }
            Transaction transaction = transBuilder.m5818a();
            if (arguments.containsKey("transaction_items_array")) {
                ArrayList transactionWrappers = (ArrayList) arguments.getSerializable("transaction_items_array");
                if (transactionWrappers != null) {
                    Iterator i$ = transactionWrappers.iterator();
                    while (i$.hasNext()) {
                        C0982a transactionWrapper = (C0982a) i$.next();
                        Item.Builder builderItem = new Item.Builder(transactionWrapper.f2945a, transactionWrapper.f2946b, transactionWrapper.f2947c, transactionWrapper.f2948d);
                        if (transactionWrapper.f2949e != null) {
                            builderItem.m5826a(transactionWrapper.f2949e);
                        }
                        transaction.m5834a(builderItem.m5827a());
                    }
                }
            }
            this.f2951b.m5738a(this.f2952c).m5604a(transaction);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public void onMessage(Bundle arguments) {
        int action = -1;
        if (arguments != null) {
            try {
                action = arguments.getInt(ITKSvc.c_actionSubAction, -1);
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
        switch (action) {
            case GamesActivityResultCodes.RESULT_RECONNECT_REQUIRED /*10001*/:
                m4361b(arguments);
            case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /*10002*/:
                m4362c(arguments);
            case GamesActivityResultCodes.RESULT_LICENSE_FAILED /*10003*/:
                m4359a(arguments);
            case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /*10004*/:
                sendTransaction(arguments);
            case GamesActivityResultCodes.RESULT_LEFT_ROOM /*10005*/:
                m4363d(arguments);
            default:
                C0970a.m4321a();
        }
    }

    public GoogleAnalyticsWrapper(Context context, C1017a avgFeatures, Properties properties) {
        this.f2954e = new C09811(this);
        this.f2950a = avgFeatures;
        this.f2953d = context.getApplicationContext();
        PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        this.f2951b = GoogleAnalytics.m5735a(context.getApplicationContext());
        this.f2952c = properties.getProperty(PROPERTY_GANALYTICS_ACCOUNT);
        Tracker gaTracker = this.f2951b.m5738a(this.f2952c);
        gaTracker.m5605a("android_" + context.getPackageName());
        gaTracker.m5615b(pi.versionName + "." + pi.versionCode);
        GAServiceManager.m5643a().m5651a(-1);
        SharedPreferences prefs = context.getSharedPreferences(GA_PREFS_FILENAME, 0);
        if (!prefs.contains(PREFS_KEY_DISPATCH_PERIOD)) {
            String dispPeriod = properties.getProperty(PROPERTY_DISPATCH_PERIOD);
            int dp = 0;
            if (dispPeriod != null) {
                try {
                    dp = Integer.parseInt(dispPeriod);
                } catch (Exception e) {
                    C0970a.m4322a(e);
                }
            }
            try {
                Editor edit = prefs.edit();
                String str = PREFS_KEY_DISPATCH_PERIOD;
                if (dp <= 0) {
                    dp = 600;
                }
                edit.putInt(str, dp).commit();
            } catch (Exception e2) {
                C0970a.m4322a(e2);
                return;
            }
        }
        if (!prefs.contains(PROPERTY_SAMPLE_RATE)) {
            String sampleRate = properties.getProperty(PROPERTY_SAMPLE_RATE);
            float sr = GroundOverlayOptions.NO_DIMENSION;
            if (sampleRate != null) {
                try {
                    sr = Float.parseFloat(sampleRate);
                } catch (Exception e22) {
                    C0970a.m4322a(e22);
                }
            }
            edit = prefs.edit();
            str = PROPERTY_SAMPLE_RATE;
            if (sr < 0.0f || sr > 100.0f) {
                sr = 100.0f;
            }
            edit.putFloat(str, sr).commit();
        }
        this.f2951b.m5738a(this.f2952c).m5601a((double) prefs.getFloat(PROPERTY_SAMPLE_RATE, 100.0f));
        prefs.registerOnSharedPreferenceChangeListener(this.f2954e);
    }

    public void setSampleRate(double rate) {
        if (rate > 0.0d && rate < 100.0d) {
            try {
                this.f2951b.m5738a(this.f2952c).m5601a(rate);
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
    }

    protected String parseThrowableToString(Throwable e) {
        ByteArrayOutputStream stackTrace = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(stackTrace));
        String traceStrModified = new String(stackTrace.toByteArray());
        Throwable cause = e;
        while (cause != null) {
            if (!(cause.getMessage() == null || cause.getMessage().equals(""))) {
                traceStrModified = traceStrModified.replaceFirst(cause.getMessage(), "");
            }
            cause = cause.getCause();
        }
        BufferedReader reader = new BufferedReader(new StringReader(traceStrModified), HttpClientFactory.SOCKET_SIZE);
        StringBuilder traceBuilder = new StringBuilder(traceStrModified.length());
        while (true) {
            try {
                String tmpStr = reader.readLine();
                if (tmpStr == null) {
                    break;
                } else if (tmpStr.startsWith("\tat ") && !tmpStr.startsWith("\tat " + this.f2953d.getPackageName())) {
                    traceBuilder.append('\n').append(tmpStr.replaceFirst("java:[0-9]*\\)", "java)"));
                } else if (traceBuilder.length() == 0) {
                    traceBuilder.append(tmpStr);
                } else {
                    traceBuilder.append('\n').append(tmpStr);
                }
            } catch (IOException e2) {
            }
        }
        return traceBuilder.toString();
    }

    private void m4359a(Bundle arguments) {
        try {
            String referrer = arguments.getString("referrer");
            if (Uri.parse("http://a.stub/?" + referrer).getQueryParameter("utm_source") != null) {
                this.f2951b.m5738a(this.f2952c).m5618e(referrer);
            } else {
                this.f2951b.m5738a(this.f2952c).m5617d(referrer);
            }
            this.f2951b.m5738a(this.f2952c).m5607a("referrer", "sent", referrer, null);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    private void m4361b(Bundle arguments) {
        try {
            this.f2951b.m5738a(this.f2952c).m5616c(arguments.getString("page"));
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    private void m4362c(Bundle arguments) {
        try {
            String arg0 = arguments.getString("arg0");
            String arg1 = arguments.getString("arg1");
            String arg2 = arguments.getString("arg2");
            arg0 = arg0.replaceAll("[^0-9a-zA-Z\\.\\_/\\%]", "");
            arg1 = arg1.replaceAll("[^0-9a-zA-Z\\.\\_/\\%]", "");
            if (arg2 != null) {
                arg2 = arg2.replaceAll("[^0-9a-zA-Z\\.\\_/\\%]", "");
            }
            Long arg3 = null;
            if (arguments.getSerializable("arg3") != null) {
                arg3 = (Long) arguments.getSerializable("arg3");
            }
            Map metrics = null;
            Map dimensions = null;
            if (arguments.getSerializable("dimensions") != null) {
                dimensions = (Map) arguments.getSerializable("dimensions");
            }
            if (arguments.getSerializable("metrics") != null) {
                metrics = (Map) arguments.getSerializable("metrics");
            }
            this.f2951b.m5738a(this.f2952c).m5609a(dimensions, metrics);
            this.f2951b.m5738a(this.f2952c).m5607a(arg0, arg1, arg2, arg3);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    private void m4363d(Bundle arguments) {
        try {
            String arg0 = arguments.getString("arg0");
            String arg1 = arguments.getString("arg1");
            String arg2 = arguments.getString("arg2");
            arg0 = arg0.replaceAll("[^0-9a-zA-Z\\.\\_/\\%]", "");
            arg1 = arg1.replaceAll("[^0-9a-zA-Z\\.\\_/\\%]", "");
            arg2 = arg2.replaceAll("[^0-9a-zA-Z\\.\\_/\\%]", "");
            if (arguments.get("arg3") == null) {
                C0970a.m4325b("no timing was set. aborting report");
                return;
            }
            long arg3 = arguments.getLong("arg3");
            Map metrics = null;
            Map dimensions = null;
            if (arguments.getSerializable("dimensions") != null) {
                dimensions = (Map) arguments.getSerializable("dimensions");
            }
            if (arguments.getSerializable("metrics") != null) {
                metrics = (Map) arguments.getSerializable("metrics");
            }
            this.f2951b.m5738a(this.f2952c).m5609a(dimensions, metrics);
            this.f2951b.m5738a(this.f2952c).m5606a(arg0, arg3, arg1, arg2);
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public int getID() {
        return FEATURE_ID;
    }

    public void onAlarm(Bundle arguments) {
    }

    public void onNewLicense(C1017a avgFeatures) {
    }

    public void onDestroy() {
        this.f2953d.getSharedPreferences(GA_PREFS_FILENAME, 0).unregisterOnSharedPreferenceChangeListener(this.f2954e);
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public void onStart(boolean firstTime) {
        try {
            GAServiceManager.m5643a().m5651a(this.f2953d.getSharedPreferences(GA_PREFS_FILENAME, 0).getInt(PREFS_KEY_DISPATCH_PERIOD, 600));
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public void setComm(List commClients) {
        commClients.add(C0983a.class);
    }
}
