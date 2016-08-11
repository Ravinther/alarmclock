package com.avg.toolkit.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.FrameLayout;
import com.avg.toolkit.ads.C0924a.C0910a;
import com.avg.toolkit.p034b.C0952b;
import com.avg.toolkit.p049e.C0970a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdsManager extends FrameLayout {
    public static final String ANALYTICS_ACTION_CLICK = "click";
    public static final String ANALYTICS_ACTION_IMPRESSION = "impression";
    public static final String ANALYTICS_CATEGORY = "AdsManager";
    public static final String ANALYTICS_CATEGORY_IMPRESSIONS = "AdsImpressions";
    public static final String ANALYTICS_LABEL_BUCKET_100_200 = "bucket_100_200";
    public static final String ANALYTICS_LABEL_BUCKET_10_20 = "bucket_10_20";
    public static final String ANALYTICS_LABEL_BUCKET_1_5 = "bucket_1_5";
    public static final String ANALYTICS_LABEL_BUCKET_200_500 = "bucket_200_500";
    public static final String ANALYTICS_LABEL_BUCKET_20_40 = "bucket_20_40";
    public static final String ANALYTICS_LABEL_BUCKET_40_100 = "bucket_40_100";
    public static final String ANALYTICS_LABEL_BUCKET_500_1000 = "bucket_500_1000";
    public static final String ANALYTICS_LABEL_BUCKET_5_10 = "bucket_5_10";
    public static final String ANALYTICS_LABEL_BUCKET_ABOVE_1000 = "bucket_above_1000";
    public static final String PREFS_FILE_NAME = "admsp";
    public static final String PREFS_KEY_CONF = "conf";
    public static final String PREFS_KEY_CVER = "cver";
    public static final String PREFS_KEY_IMPRESSIONS_COUNT = "imprCount_";
    public static final String PREFS_KEY_LAST_PVER = "lpvr";
    public static final String PREFS_KEY_LAST_REQUEST = "lreq";
    public static final String PREFS_KEY_TIME = "time";
    C0913b f2704a;
    private final HashMap f2705b;
    private Context f2706c;
    private Activity f2707d;
    private JSONObject f2708e;
    private String f2709f;
    private boolean f2710g;
    private C0924a f2711h;
    private boolean f2712i;
    private C0792a f2713j;
    private boolean f2714k;
    private boolean f2715l;
    private String f2716m;

    /* renamed from: com.avg.toolkit.ads.AdsManager.a */
    public interface C0792a {
        void m3776a(boolean z);
    }

    /* renamed from: com.avg.toolkit.ads.AdsManager.1 */
    class C09091 implements Runnable {
        final /* synthetic */ AdsManager f2693a;

        C09091(AdsManager adsManager) {
            this.f2693a = adsManager;
        }

        public void run() {
            this.f2693a.setBackgroundColor(0);
            if (this.f2693a.f2704a != null) {
                this.f2693a.f2704a.f2699b = false;
            }
            if (this.f2693a.f2711h != null) {
                this.f2693a.f2711h.m4229d();
                this.f2693a.removeAllViews();
                this.f2693a.m4175a();
            }
            if (!this.f2693a.m4183d() || this.f2693a.f2710g) {
                this.f2693a.m4178b();
            } else {
                this.f2693a.f2712i = true;
            }
        }
    }

    /* renamed from: com.avg.toolkit.ads.AdsManager.b */
    private abstract class C0913b implements Runnable {
        boolean f2699b;
        final /* synthetic */ AdsManager f2700c;

        private C0913b(AdsManager adsManager) {
            this.f2700c = adsManager;
            this.f2699b = true;
        }
    }

    /* renamed from: com.avg.toolkit.ads.AdsManager.2 */
    class C09142 extends C0913b {
        final /* synthetic */ AdsManager f2701a;

        /* renamed from: com.avg.toolkit.ads.AdsManager.2.1 */
        class C09121 implements Runnable {
            final /* synthetic */ Class f2695a;
            final /* synthetic */ String f2696b;
            final /* synthetic */ String f2697c;
            final /* synthetic */ C09142 f2698d;

            /* renamed from: com.avg.toolkit.ads.AdsManager.2.1.1 */
            class C09111 implements C0910a {
                final /* synthetic */ C09121 f2694a;

                C09111(C09121 c09121) {
                    this.f2694a = c09121;
                }

                public void m4171a(boolean adAvailable) {
                    if (this.f2694a.f2698d.f2701a.f2714k != adAvailable) {
                        if (this.f2694a.f2698d.f2701a.f2713j != null && this.f2694a.f2698d.f2701a.f2715l) {
                            this.f2694a.f2698d.f2701a.f2713j.m3776a(adAvailable);
                        }
                        this.f2694a.f2698d.f2701a.f2714k = adAvailable;
                    }
                }
            }

            C09121(C09142 c09142, Class cls, String str, String str2) {
                this.f2698d = c09142;
                this.f2695a = cls;
                this.f2696b = str;
                this.f2697c = str2;
            }

            public void run() {
                if (this.f2698d.b) {
                    try {
                        this.f2698d.f2701a.f2711h = (C0924a) this.f2695a.newInstance();
                        this.f2698d.f2701a.f2711h.m4224a(new C09111(this));
                        this.f2698d.f2701a.f2711h.m4225a(this.f2698d.f2701a.f2716m);
                        this.f2698d.f2701a.f2711h.m4220a(this.f2698d.f2701a.f2707d, this.f2698d.f2701a, this.f2696b, this.f2697c, Locale.getDefault().toString(), this.f2698d.f2701a.f2710g);
                    } catch (Exception e) {
                        C0970a.m4322a(e);
                        this.f2698d.f2701a.f2711h = null;
                    }
                }
            }
        }

        C09142(AdsManager adsManager) {
            this.f2701a = adsManager;
            super(null);
        }

        public void run() {
            this.f2701a.m4181c();
            if (this.f2701a.f2708e != null) {
                try {
                    JSONArray pages = this.f2701a.f2708e.getJSONArray("pages");
                    JSONObject page = null;
                    int i = 0;
                    while (i < pages.length()) {
                        page = pages.getJSONObject(i);
                        if (this.f2701a.f2709f.equals(page.getString("name"))) {
                            break;
                        }
                        i++;
                    }
                    if (i < pages.length()) {
                        String pageId = null;
                        if (page != null) {
                            pageId = page.getString("id");
                        }
                        if (pageId != null) {
                            JSONObject catToProvs = this.f2701a.f2708e.getJSONObject("dist").getJSONObject(pageId);
                            if (catToProvs != null) {
                                double random = Math.random();
                                double maxChoice = 0.0d;
                                Iterator it = catToProvs.keys();
                                while (it.hasNext()) {
                                    String key = (String) it.next();
                                    maxChoice += ((double) catToProvs.getInt(key)) / 100.0d;
                                    if (random < maxChoice) {
                                        JSONArray providers = this.f2701a.f2708e.getJSONArray("providers");
                                        JSONObject provider = null;
                                        i = 0;
                                        while (i < providers.length()) {
                                            provider = providers.getJSONObject(i);
                                            if (key.equals(provider.getString("id"))) {
                                                break;
                                            }
                                            i++;
                                        }
                                        if (i < providers.length()) {
                                            String providerName = null;
                                            if (provider != null) {
                                                providerName = provider.getString("name");
                                            }
                                            if (providerName != null) {
                                                Class foundProvider = (Class) this.f2701a.f2705b.get(providerName);
                                                if (foundProvider != null) {
                                                    String provIdVal = null;
                                                    if (provider != null) {
                                                        provIdVal = provider.optString("account");
                                                    }
                                                    String providerId = provIdVal != null ? provIdVal : "";
                                                    String adIdVal = null;
                                                    if (page != null) {
                                                        adIdVal = page.getJSONObject("data").getString(key);
                                                    }
                                                    this.f2701a.f2707d.runOnUiThread(new C09121(this, foundProvider, providerId, adIdVal != null ? adIdVal : ""));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                }
                            }
                        }
                    }
                } catch (JSONException e) {
                } catch (NumberFormatException e2) {
                }
            }
        }
    }

    /* renamed from: com.avg.toolkit.ads.AdsManager.3 */
    class C09153 implements Runnable {
        final /* synthetic */ String f2702a;
        final /* synthetic */ AdsManager f2703b;

        C09153(AdsManager adsManager, String str) {
            this.f2703b = adsManager;
            this.f2702a = str;
        }

        public void run() {
            this.f2703b.f2716m = this.f2702a;
            if (this.f2703b.f2711h != null) {
                this.f2703b.f2711h.m4225a(this.f2702a);
            }
        }
    }

    public boolean isAdDisplayed() {
        return this.f2714k && this.f2715l;
    }

    private void m4175a() {
        if (this.f2713j != null) {
            this.f2713j.m3776a(false);
        }
        this.f2714k = false;
    }

    public AdsManager(Context context) {
        super(context);
        this.f2705b = new HashMap();
        this.f2705b.put("NONE", C0939f.class);
        this.f2705b.put("AVG", C0935d.class);
        this.f2705b.put("ADMOB", C0929b.class);
        this.f2705b.put("MOPUB", C0938e.class);
        this.f2714k = false;
        this.f2715l = true;
        this.f2706c = context;
        setBackgroundColor(0);
    }

    public AdsManager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2705b = new HashMap();
        this.f2705b.put("NONE", C0939f.class);
        this.f2705b.put("AVG", C0935d.class);
        this.f2705b.put("ADMOB", C0929b.class);
        this.f2705b.put("MOPUB", C0938e.class);
        this.f2714k = false;
        this.f2715l = true;
        this.f2706c = context;
        setBackgroundColor(0);
    }

    public AdsManager(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f2705b = new HashMap();
        this.f2705b.put("NONE", C0939f.class);
        this.f2705b.put("AVG", C0935d.class);
        this.f2705b.put("ADMOB", C0929b.class);
        this.f2705b.put("MOPUB", C0938e.class);
        this.f2714k = false;
        this.f2715l = true;
        this.f2706c = context;
        setBackgroundColor(0);
    }

    public void init(Activity activity, String category, boolean showAdsInLandscape, C0792a adChangeListener) {
        this.f2713j = adChangeListener;
        init(activity, category, showAdsInLandscape);
    }

    public void init(Activity activity, String category, boolean showAdsInLandscape) {
        this.f2709f = category;
        this.f2707d = activity;
        this.f2710g = showAdsInLandscape;
        if (activity == null || category == null) {
            C0970a.m4321a();
        } else {
            activity.runOnUiThread(new C09091(this));
        }
    }

    private void m4178b() {
        if (C0952b.m4281a(this.f2706c)) {
            this.f2704a = new C09142(this);
            new Thread(this.f2704a).start();
        }
    }

    private void m4181c() {
        String conf = this.f2706c.getSharedPreferences(PREFS_FILE_NAME, 0).getString(PREFS_KEY_CONF, "");
        if (!conf.equals("")) {
            try {
                this.f2708e = new JSONObject(conf);
            } catch (Exception e) {
            }
        }
        if (this.f2708e != null) {
        }
    }

    private boolean m4183d() {
        Display display = this.f2707d.getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        double widthInch = (double) (((float) metrics.widthPixels) / metrics.xdpi);
        double heightInch = (double) (((float) metrics.heightPixels) / metrics.ydpi);
        double screenSize = Math.sqrt(Math.pow(widthInch, 2.0d) + Math.pow(heightInch, 2.0d));
        if (widthInch > heightInch) {
            return true;
        }
        return false;
    }

    private void m4176a(boolean visible) {
        if (this.f2714k && this.f2713j != null) {
            this.f2713j.m3776a(visible);
        }
    }

    public void onConfigurationChanged(Context context, Configuration newConfig) {
        if (this.f2707d != null) {
            if (this.f2711h != null) {
                this.f2711h.m4221a(context, newConfig);
            }
            if (this.f2710g) {
                setVisibility(0);
                this.f2715l = true;
                m4176a(true);
            } else if (m4183d()) {
                setVisibility(8);
                this.f2715l = false;
                m4176a(false);
            } else {
                setVisibility(0);
                this.f2715l = true;
                m4176a(true);
                if (this.f2712i) {
                    this.f2712i = false;
                    m4178b();
                }
            }
        }
    }

    public void stop() {
        if (this.f2711h != null) {
            this.f2712i = false;
            this.f2711h.m4229d();
            m4175a();
        }
        removeAllViews();
    }

    public void pause() {
        if (this.f2711h != null) {
            this.f2711h.m4227b();
        }
    }

    public void resume() {
        if (this.f2711h != null) {
            this.f2711h.m4228c();
        }
    }

    public void setOwnerScreen(String screen) {
        if (this.f2707d != null) {
            this.f2707d.runOnUiThread(new C09153(this, screen));
        }
    }
}
