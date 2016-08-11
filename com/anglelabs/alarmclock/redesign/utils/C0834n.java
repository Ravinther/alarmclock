package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p047a.C0905a;
import com.avg.toolkit.p047a.C0905a.C0903b;
import com.avg.toolkit.uid.UUID;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.n */
public class C0834n {

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.n.a */
    public enum C0833a {
        TOS("tos.html"),
        PRIVACY("privacy.html"),
        HELP("help.html");
        
        private final String f2387d;

        private C0833a(String path) {
            this.f2387d = path;
        }
    }

    public static void m3947a(Context context, TextView textView, C0833a path) {
        C0834n.m3948a(textView, C0834n.m3946a(context, path));
    }

    public static String m3946a(Context context, C0833a path) {
        return C0834n.m3945a(context, path.f2387d).toString();
    }

    private static Uri m3945a(Context context, String path) {
        Builder builder = new Builder();
        builder.scheme("https").authority("avg-hrd.appspot.com").path(path);
        return C0834n.m3944a(context, builder).build();
    }

    private static void m3948a(TextView tv, String url) {
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        ssb.append(tv.getText());
        ssb.setSpan(new URLSpan(url), 0, ssb.length(), 33);
        tv.setText(ssb, BufferType.SPANNABLE);
    }

    private static Builder m3944a(Context context, Builder builder) {
        C1017a features = C1019b.m4431a();
        if (features != null) {
            UUID uuid = new UUID(context);
            C0903b productIDAndServer = C0905a.m4154a();
            builder.appendQueryParameter("device_sn", uuid.getUUID() != null ? uuid.getUUID() : "").appendQueryParameter("vc", String.valueOf(features.f3120f)).appendQueryParameter("pid", productIDAndServer != null ? String.valueOf(productIDAndServer.m4151a()) : "");
        }
        return builder;
    }
}
