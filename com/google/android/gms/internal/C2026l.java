package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;

/* renamed from: com.google.android.gms.internal.l */
public class C2026l {
    private String kd;
    private String ke;
    private String[] kf;
    private C1935h kg;
    private final C1911g kh;

    public C2026l(C1935h c1935h) {
        this.kd = "googleads.g.doubleclick.net";
        this.ke = "/pagead/ads";
        this.kf = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
        this.kh = new C1911g();
        this.kg = c1935h;
    }

    private Uri m8949a(Uri uri, Context context, String str, boolean z) {
        try {
            if (uri.getQueryParameter("ms") != null) {
                throw new C2027m("Query parameter already exists: ms");
            }
            return m8950a(uri, "ms", z ? this.kg.m8628a(context, str) : this.kg.m8627a(context));
        } catch (UnsupportedOperationException e) {
            throw new C2027m("Provided Uri is not in a valid state");
        }
    }

    private Uri m8950a(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(new StringBuilder(uri2.substring(0, indexOf + 1)).append(str).append("=").append(str2).append("&").append(uri2.substring(indexOf + 1)).toString()) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    public Uri m8951a(Uri uri, Context context) {
        try {
            return m8949a(uri, context, uri.getQueryParameter("ai"), true);
        } catch (UnsupportedOperationException e) {
            throw new C2027m("Provided Uri is not in a valid state");
        }
    }

    public void m8952a(MotionEvent motionEvent) {
        this.kg.m8630a(motionEvent);
    }

    public boolean m8953a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.kf) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public C1935h m8954y() {
        return this.kg;
    }
}
