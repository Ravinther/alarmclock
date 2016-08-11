package com.avg.toolkit.marketing;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p034b.C0956f;
import com.avg.toolkit.p047a.C0905a.C0902a;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.games.GamesStatusCodes;
import java.util.List;

/* renamed from: com.avg.toolkit.marketing.a */
public class C1027a implements C0647c {
    protected Context f3160a;
    protected C1017a f3161b;

    public C1027a(Context context, C1017a avgFeatures) {
        this.f3160a = context;
        this.f3161b = avgFeatures;
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
            case GamesStatusCodes.STATUS_REAL_TIME_MESSAGE_SEND_FAILED /*7001*/:
                m4475a(arguments);
            case GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID /*7002*/:
                m4476a(arguments.getString(ITKSvc.c_actionData), arguments.getString("browser_package_name"), false);
            case GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED /*7003*/:
                m4476a(arguments.getString(ITKSvc.c_actionData), arguments.getString("browser_package_name"), true);
            default:
                C0970a.m4321a();
        }
    }

    public void m4476a(String url, String browserPackageNameToOpen, boolean useDefBrowserTab) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setFlags(335544320);
        StringBuilder append = new StringBuilder().append(new C0956f(this.f3160a).m4297a());
        if (url == null) {
            url = "";
        }
        intent.setData(Uri.parse(append.append(url).toString()));
        String browserToLaunch = null;
        if (browserPackageNameToOpen != null) {
            browserToLaunch = browserPackageNameToOpen;
        } else {
            ResolveInfo resolveInfo = this.f3160a.getPackageManager().resolveActivity(intent, 0);
            if (!"android".equals(resolveInfo.activityInfo.packageName)) {
                browserToLaunch = resolveInfo.activityInfo.packageName;
            }
        }
        if (useDefBrowserTab && browserToLaunch != null) {
            intent.setPackage(browserToLaunch);
            intent.putExtra("com.android.browser.application_id", browserToLaunch);
        }
        this.f3160a.startActivity(intent);
    }

    protected void m4475a(Bundle arguments) {
        String referrer = arguments.getString(ITKSvc.c_actionData);
        if (!TextUtils.isEmpty(referrer)) {
            SharedPreferences pref = this.f3160a.getApplicationContext().getSharedPreferences("av", 0);
            if (pref.getString("install_ref", "").equals("") && !pref.getBoolean("referrer_received", false)) {
                pref.edit().putString("install_ref", referrer).commit();
                pref.edit().putBoolean("referrer_received", true).commit();
            }
        }
    }

    public void onStart(boolean firstTime) {
        SharedPreferences pref = this.f3160a.getApplicationContext().getSharedPreferences("av", 0);
        String referrer = pref.getString("install_ref", "");
        if (!referrer.equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString(ITKSvc.c_actionData, referrer);
            ITKSvc.Do(this.f3160a, 8000, C0902a.INSTALLATION_SUCCESS.m4150a(), bundle);
            GoogleAnalyticsWrapper.trackReferrer(this.f3160a, referrer);
            pref.edit().putString("install_ref", "").commit();
        }
    }

    public int getID() {
        return GamesStatusCodes.STATUS_REAL_TIME_CONNECTION_FAILED;
    }

    public void onAlarm(Bundle arguments) {
    }

    public void onNewLicense(C1017a avgFeatures) {
    }

    public void onDestroy() {
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public void setComm(List commClients) {
    }
}
