package com.avg.toolkit.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p034b.C0649d;
import com.avg.toolkit.p034b.C0950a.C0949c;
import com.avg.toolkit.p034b.C0955e;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.recurringTasks.C1031b;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import p000a.p001a.p002a.p003a.p005b.C0003a;

/* renamed from: com.avg.toolkit.ads.c */
public class C0931c implements C0647c {
    private Context f2772a;
    private C1031b f2773b;

    /* renamed from: com.avg.toolkit.ads.c.a */
    public static class C0930a extends C0649d {
        private String f2771b;

        public C0930a() {
            this.f2771b = "";
        }

        public boolean load(Context context) {
            return false;
        }

        public C0949c getPriority() {
            return C0949c.REGULAR;
        }

        public int getMessageId() {
            return 20001;
        }

        public String getXmlRpcMethod() {
            return null;
        }

        public boolean handleMessage(Context context, Message msg) {
            if (msg == null || msg.obj == null) {
                return false;
            }
            if (msg.obj.getInt("adma") != 1) {
                return true;
            }
            context.getSharedPreferences(AdsManager.PREFS_FILE_NAME, 0).edit().putString(AdsManager.PREFS_KEY_CONF, "").commit();
            return true;
        }

        public boolean handleDailyRun(Context context) {
            return true;
        }

        public boolean prepare(Context context) {
            return false;
        }

        public boolean callFinished(Context context, Object result) {
            if (!(result instanceof JSONObject)) {
                return false;
            }
            JSONObject configuration = (JSONObject) result;
            if (!"ERROR".equals(configuration.optString("status"))) {
                try {
                    long cver = configuration.getLong(GoogleAnalyticsWrapper.PREFS_KEY_CVER);
                    Editor editor = context.getSharedPreferences(AdsManager.PREFS_FILE_NAME, 0).edit();
                    editor.putString(AdsManager.PREFS_KEY_CONF, configuration.toString());
                    editor.putLong(GoogleAnalyticsWrapper.PREFS_KEY_CVER, cver);
                    editor.putString(GoogleAnalyticsWrapper.PREFS_KEY_LAST_REQUEST, this.f2771b);
                    editor.putInt(GoogleAnalyticsWrapper.PREFS_KEY_LAST_PVER, 3);
                    editor.putLong(AdsManager.PREFS_KEY_TIME, System.currentTimeMillis());
                    editor.commit();
                    return true;
                } catch (Exception e) {
                    C0970a.m4322a(e);
                    return false;
                }
            } else if (configuration.optBoolean("retry")) {
                return false;
            } else {
                return true;
            }
        }

        public int getJsonConfKey() {
            return 1;
        }

        public boolean prepareJson(Context context, JSONArray setParameters) {
            JSONObject tempReqParams = new JSONObject();
            if (!C0955e.m4288a(context, tempReqParams)) {
                return false;
            }
            try {
                JSONObject tempReqFeatureParams = new JSONObject();
                SharedPreferences prefs = context.getSharedPreferences(AdsManager.PREFS_FILE_NAME, 0);
                if (prefs.contains(GoogleAnalyticsWrapper.PREFS_KEY_CVER)) {
                    tempReqFeatureParams.put(GoogleAnalyticsWrapper.PREFS_KEY_CVER, prefs.getLong(GoogleAnalyticsWrapper.PREFS_KEY_CVER, 0));
                }
                tempReqFeatureParams.put("pver", 3);
                this.f2771b = C0003a.m39d(tempReqParams.toString().getBytes());
                if (!(prefs.getInt(GoogleAnalyticsWrapper.PREFS_KEY_LAST_PVER, -1) == 3 && this.f2771b.equals(prefs.getString(GoogleAnalyticsWrapper.PREFS_KEY_LAST_REQUEST, "")))) {
                    tempReqFeatureParams.put("mod", true);
                }
                this.jsonRequestFeatureParameters = tempReqFeatureParams;
                this.jsonRequestParameters = tempReqParams;
                return true;
            } catch (Exception e) {
                C0970a.m4322a(e);
                return false;
            }
        }

        public void callFinishedNoChange(Context context) {
        }

        public boolean useDailyRun() {
            return true;
        }
    }

    public C0931c(Context context) {
        this.f2772a = context;
    }

    public int getID() {
        return 20000;
    }

    public void onStart(boolean firstTime) {
        this.f2773b = new C1031b(this.f2772a, "AdsMan", 86400000, false, false, 20000, false);
    }

    static void m4240a(Context context, String adType, String adId) {
        Bundle bundle = new Bundle();
        bundle.putString("adType", adType);
        bundle.putString("adId", adId);
        ITKSvc.Do(context, 20000, 20001, bundle);
    }

    public void onMessage(Bundle arguments) {
        if (arguments.getInt(ITKSvc.c_actionSubAction, -1) == 20001) {
            String adType = arguments.getString("adType");
            String adId = arguments.getString("adId");
            if (adType != null && adId != null) {
                SharedPreferences prefs = this.f2772a.getSharedPreferences(AdsManager.PREFS_FILE_NAME, 0);
                String imprKey = AdsManager.PREFS_KEY_IMPRESSIONS_COUNT + adType + '_' + adId;
                prefs.edit().putLong(imprKey, 1 + prefs.getLong(imprKey, 0)).commit();
                return;
            }
            return;
        }
        C0970a.m4321a();
    }

    public void onAlarm(Bundle arguments) {
        if (this.f2773b.m4480a(this.f2772a, arguments)) {
            SharedPreferences prefs = this.f2772a.getSharedPreferences(AdsManager.PREFS_FILE_NAME, 0);
            Set<String> keys = prefs.getAll().keySet();
            Editor prefsEdit = prefs.edit();
            for (String key : keys) {
                if (key.startsWith(AdsManager.PREFS_KEY_IMPRESSIONS_COUNT)) {
                    String countLabel;
                    String typeAndId = key.substring(AdsManager.PREFS_KEY_IMPRESSIONS_COUNT.length());
                    long count = -1;
                    try {
                        count = prefs.getLong(key, -1);
                    } catch (Exception e) {
                        C0970a.m4322a(e);
                    }
                    if (count < 1) {
                        countLabel = null;
                    } else if (count <= 5) {
                        countLabel = AdsManager.ANALYTICS_LABEL_BUCKET_1_5;
                    } else if (count <= 10) {
                        countLabel = AdsManager.ANALYTICS_LABEL_BUCKET_5_10;
                    } else if (count <= 20) {
                        countLabel = AdsManager.ANALYTICS_LABEL_BUCKET_10_20;
                    } else if (count <= 40) {
                        countLabel = AdsManager.ANALYTICS_LABEL_BUCKET_20_40;
                    } else if (count <= 100) {
                        countLabel = AdsManager.ANALYTICS_LABEL_BUCKET_40_100;
                    } else if (count <= 200) {
                        countLabel = AdsManager.ANALYTICS_LABEL_BUCKET_100_200;
                    } else if (count <= 500) {
                        countLabel = AdsManager.ANALYTICS_LABEL_BUCKET_200_500;
                    } else if (count <= 1000) {
                        countLabel = AdsManager.ANALYTICS_LABEL_BUCKET_500_1000;
                    } else {
                        countLabel = AdsManager.ANALYTICS_LABEL_BUCKET_ABOVE_1000;
                    }
                    if (countLabel != null) {
                        GoogleAnalyticsWrapper.trackEvent(this.f2772a, AdsManager.ANALYTICS_CATEGORY_IMPRESSIONS, typeAndId, countLabel, 0);
                    }
                    prefsEdit.remove(key);
                }
            }
            prefsEdit.commit();
            this.f2773b.m4479a(this.f2772a);
        }
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public void onNewLicense(C1017a avgFeatures) {
        Bundle bundle = new Bundle();
        bundle.putInt("adma", 1);
        ITKSvc.Do(this.f2772a, 4000, 20001, bundle);
    }

    public void onDestroy() {
        if (this.f2773b != null) {
            this.f2773b.m4481b(this.f2772a);
        }
    }

    public void setComm(List commClients) {
        commClients.add(C0930a.class);
    }
}
