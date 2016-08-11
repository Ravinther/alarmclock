package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.analytics.y */
class C1396y {
    static String m6043a(C1395x c1395x, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c1395x.cO());
        if (c1395x.cQ() > 0) {
            long cQ = j - c1395x.cQ();
            if (cQ >= 0) {
                stringBuilder.append("&qt").append("=").append(cQ);
            }
        }
        stringBuilder.append("&z").append("=").append(c1395x.cP());
        return stringBuilder.toString();
    }

    static String encode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }

    static Map m6044v(Map map) {
        Map hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                CharSequence substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }
}
