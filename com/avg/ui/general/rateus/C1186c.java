package com.avg.ui.general.rateus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.p006a.C0008b;
import android.text.TextUtils;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p034b.C0952b;
import com.avg.toolkit.p047a.C0905a;
import com.avg.toolkit.p047a.C0905a.C0903b;
import com.avg.ui.general.C1091c.C1078b;
import com.avg.ui.general.C1091c.C1079c;
import com.avg.ui.general.C1091c.C1083g;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.rateus.RateAndShareDialogActivity.C1182a;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.location.LocationRequest;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: com.avg.ui.general.rateus.c */
public class C1186c {
    private static C1186c f3583a;
    private Context f3584b;
    private SharedPreferences f3585c;
    private HashMap f3586d;
    private final boolean f3587e;

    /* renamed from: com.avg.ui.general.rateus.c.a */
    private static class C1185a {
        Intent f3580a;
        Intent f3581b;
        String f3582c;

        public C1185a(Intent beforeIntent, Intent afterIntent, String onDismissAction) {
            this.f3580a = beforeIntent;
            this.f3581b = afterIntent;
            this.f3582c = onDismissAction;
        }
    }

    public static C1186c m4956a(Context context) {
        if (f3583a == null) {
            f3583a = new C1186c(context);
        }
        return f3583a;
    }

    private C1186c(Context context) {
        this.f3584b = context.getApplicationContext();
        this.f3585c = context.getSharedPreferences("RateUsSharedPrefs", 0);
        this.f3586d = new HashMap();
        this.f3587e = context.getResources().getBoolean(C1079c.rate_us_master_kill_switch);
    }

    public boolean m4986a(int triggerKey) {
        if (!this.f3587e) {
            return false;
        }
        m4960b(this.f3584b.getString(triggerKey));
        if (m4967f()) {
            m4963d(triggerKey);
            return true;
        } else if (!m4968g()) {
            return false;
        } else {
            m4978p();
            return true;
        }
    }

    public void m4988b(int action) {
        if (this.f3587e) {
            GoogleAnalyticsWrapper.trackEvent(this.f3584b, "rate", m4980r(), m4964e(action), 0);
            this.f3585c.edit().putInt("LAST_SELECTED_ACTION_RATE_US", action).apply();
        }
    }

    public void m4990c(int action) {
        if (this.f3587e) {
            GoogleAnalyticsWrapper.trackEvent(this.f3584b, "share", m4980r(), m4966f(action), 0);
            this.f3585c.edit().putInt("LAST_SELECTED_ACTION_SHARE", action).apply();
        }
    }

    public void m4985a(String key) {
        if (this.f3587e) {
            this.f3585c.edit().putInt(key, this.f3585c.getInt(key, 0) + 1).commit();
        }
    }

    public C1186c m4983a(int trigger, Intent beforeIntent, Intent afterIntent, String onDismissAction) {
        if (this.f3587e) {
            this.f3586d.put(Integer.valueOf(trigger), new C1185a(beforeIntent, afterIntent, onDismissAction));
        }
        return this;
    }

    public void m4984a() {
        Intent intent;
        try {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(m4981s()));
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.f3584b.startActivity(intent);
        } catch (Exception e) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(m4982t()));
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.f3584b.startActivity(intent);
        }
        this.f3585c.edit().putInt("LAST_SELECTED_ACTION_RATE_US", 100).apply();
    }

    public void m4987b() {
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra("android.intent.extra.TITLE", this.f3584b.getString(C1085i.rate_us_manager_share_title));
        sharingIntent.putExtra("android.intent.extra.SUBJECT", this.f3584b.getString(C1085i.rate_us_manager_share_subject));
        sharingIntent.putExtra("android.intent.extra.TEXT", m4962d());
        Intent intent = Intent.createChooser(sharingIntent, this.f3584b.getString(C1085i.share_using));
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        this.f3584b.startActivity(intent);
        this.f3585c.edit().putInt("LAST_SELECTED_ACTION_SHARE", 103).apply();
    }

    private String m4962d() {
        String body = "";
        if (m4965e()) {
            try {
                body = this.f3584b.getString(C1085i.rate_us_manager_share_body, new Object[]{m4989c()});
            } catch (Exception e) {
            }
        }
        if (TextUtils.isEmpty(body)) {
            return this.f3584b.getString(C1085i.rate_us_manager_share_body);
        }
        return body;
    }

    private boolean m4965e() {
        return this.f3584b.getResources().getBoolean(C1079c.rate_us_format_share_body_by_server_url);
    }

    protected String m4989c() {
        C1017a features = C1019b.m4431a();
        C0903b productIDAndServer = C0905a.m4154a();
        String productId = productIDAndServer != null ? String.valueOf(productIDAndServer.m4151a()) : "";
        String vendorID = "" + features.f3120f;
        String lang = Locale.getDefault().getLanguage();
        return String.format("https://avg-hrd.appspot.com/purchase/share-link?lang=%1$s&pid=%2$s&varCode=%3$s", new Object[]{lang, productId, vendorID});
    }

    private boolean m4967f() {
        return m4975m() && m4976n() && m4977o() && m4979q();
    }

    private boolean m4968g() {
        return m4970h() && m4975m() && !m4971i() && m4972j() && m4973k() && m4974l();
    }

    private boolean m4970h() {
        return this.f3584b.getResources().getBoolean(C1079c.share_master_kill_switch);
    }

    private boolean m4971i() {
        int lastShareAction = this.f3585c.getInt("LAST_SELECTED_ACTION_SHARE", 0);
        if (lastShareAction == LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY || lastShareAction == 103) {
            return true;
        }
        return false;
    }

    private boolean m4972j() {
        if (this.f3585c.getInt("LAST_SELECTED_ACTION_RATE_US", 0) == 100) {
            return true;
        }
        return false;
    }

    private boolean m4973k() {
        return m4958a(this.f3585c.getLong("LAST_TIME_SHOWN_RATE_US", System.currentTimeMillis()), this.f3585c.getInt("YYYY", 14));
    }

    private boolean m4974l() {
        if (this.f3585c.getLong("LAST_TIME_SHOWN_SHARE", 0) == 0) {
            return true;
        }
        int cooldown = Integer.MAX_VALUE;
        if (this.f3585c.getInt("LAST_SELECTED_ACTION_SHARE", 0) == 101) {
            cooldown = this.f3585c.getInt("XXXX", 7);
        }
        return m4958a(this.f3585c.getLong("LAST_TIME_SHOWN_SHARE", System.currentTimeMillis()), cooldown);
    }

    private void m4960b(String key) {
        this.f3585c.edit().putInt(key, this.f3585c.getInt(key, 0) + 1).putString("LastSelectedAction", key).commit();
    }

    private boolean m4975m() {
        return C0952b.m4281a(this.f3584b);
    }

    private boolean m4976n() {
        int threshold = this.f3585c.getInt("launch", this.f3584b.getResources().getInteger(C1083g.rate_us_min_launches));
        if (threshold != -1 && this.f3585c.getInt("app_launch", 0) >= threshold) {
            return true;
        }
        return false;
    }

    private boolean m4977o() {
        if (this.f3585c.getLong("LAST_TIME_SHOWN_RATE_US", 0) == 0) {
            return true;
        }
        int cooldown = 1;
        switch (this.f3585c.getInt("LAST_SELECTED_ACTION_RATE_US", 0)) {
            case Base64.DEFAULT /*0*/:
            case 101:
                cooldown = this.f3585c.getInt("daysLTR", 1);
                break;
            case MMException.UNKNOWN_ERROR /*100*/:
                cooldown = Integer.MAX_VALUE;
                break;
            case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                cooldown = this.f3585c.getInt("daysNT", 60);
                break;
        }
        return m4958a(this.f3585c.getLong("LAST_TIME_SHOWN_RATE_US", 0), cooldown);
    }

    private boolean m4958a(long from, int cooldownInDays) {
        return TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - from) > ((long) cooldownInDays);
    }

    private void m4957a(Intent[] intents) {
        if (!C0008b.m97a(this.f3584b, intents)) {
            for (Intent intent : intents) {
                this.f3584b.startActivity(intent);
            }
        }
    }

    private Intent m4955a(C1185a config) {
        Intent intent = new Intent(this.f3584b, RateAndShareDialogActivity.class);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        intent.addFlags(8388608);
        intent.putExtra("EXTRA_DIALOG_MODE", C1182a.RATE_US);
        if (!(config == null || TextUtils.isEmpty(config.f3582c))) {
            intent.putExtra("EXTRA_ON_DISMISS_ACTION", config.f3582c);
        }
        return intent;
    }

    private void m4963d(int triggerKey) {
        this.f3585c.edit().putLong("LAST_TIME_SHOWN_RATE_US", System.currentTimeMillis()).putInt("LAST_SELECTED_ACTION_RATE_US", 101).apply();
        GoogleAnalyticsWrapper.trackEvent(this.f3584b, "rate", m4980r(), "open", 0);
        m4957a(m4969g(triggerKey));
    }

    private void m4978p() {
        this.f3585c.edit().putLong("LAST_TIME_SHOWN_SHARE", System.currentTimeMillis()).putInt("LAST_SELECTED_ACTION_SHARE", 101).apply();
        GoogleAnalyticsWrapper.trackEvent(this.f3584b, "share", m4980r(), "open", 0);
        Intent intent = new Intent(this.f3584b, RateAndShareDialogActivity.class);
        intent.addFlags(DriveFile.MODE_READ_ONLY);
        intent.putExtra("EXTRA_DIALOG_MODE", C1182a.SHARE);
        this.f3584b.startActivity(intent);
    }

    private boolean m4979q() {
        String[] keys = this.f3584b.getResources().getStringArray(C1078b.rate_us_keys);
        int[] values = this.f3584b.getResources().getIntArray(C1078b.rate_us_values);
        if (keys == null || values == null || keys.length != values.length) {
            return false;
        }
        for (int i = 0; i < keys.length; i++) {
            if (this.f3585c.getInt(keys[i], 0) >= values[i]) {
                return true;
            }
        }
        return false;
    }

    private String m4980r() {
        String trigger = this.f3585c.getString("LastSelectedAction", "");
        if (TextUtils.isEmpty(trigger)) {
            return trigger;
        }
        return trigger + "_trigger";
    }

    private String m4964e(int action) {
        switch (action) {
            case MMException.UNKNOWN_ERROR /*100*/:
                return "rate_now";
            case 101:
                return "rate_later";
            case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                return "no_rate";
            default:
                return "";
        }
    }

    private String m4966f(int action) {
        switch (action) {
            case 101:
                return "share_later";
            case LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY /*102*/:
                return "no_share";
            case 103:
                return "share_now";
            default:
                return "";
        }
    }

    private Intent[] m4969g(int trigger) {
        C1185a config = (C1185a) this.f3586d.get(Integer.valueOf(trigger));
        ArrayList intents = new ArrayList();
        Intent intent = m4959b(config);
        if (intent != null) {
            intents.add(intent);
        }
        intents.add(m4955a(config));
        intent = m4961c(config);
        if (intent != null) {
            intents.add(intent);
        }
        return (Intent[]) intents.toArray(new Intent[intents.size()]);
    }

    private Intent m4959b(C1185a config) {
        if (config != null) {
            return config.f3580a;
        }
        return null;
    }

    private Intent m4961c(C1185a config) {
        if (config != null) {
            return config.f3581b;
        }
        return null;
    }

    private String m4981s() {
        if (C1019b.m4431a().f3120f == 302) {
            return "amzn://apps/android?p=" + this.f3584b.getPackageName();
        }
        return "market://details?id=" + this.f3584b.getPackageName();
    }

    private String m4982t() {
        return m4989c();
    }
}
