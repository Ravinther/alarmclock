package com.google.analytics.tracking.android;

import com.google.analytics.tracking.android.MetaModel.MetaInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class HitBuilder {
    HitBuilder() {
    }

    static Map m5748a(MetaModel metaModel, Map hit) {
        Map params = new HashMap();
        for (Entry entry : hit.entrySet()) {
            MetaInfo metaInfo = metaModel.m5765a((String) entry.getKey());
            if (metaInfo != null) {
                String urlParam = metaInfo.m5763a((String) entry.getKey());
                if (urlParam != null) {
                    String value = (String) entry.getValue();
                    if (metaInfo.m5764b() != null) {
                        value = metaInfo.m5764b().m5761a(value);
                    }
                    if (!(value == null || value.equals(metaInfo.m5762a()))) {
                        params.put(urlParam, value);
                    }
                }
            }
        }
        return params;
    }

    static String m5746a(Hit hit, long currentTimeMillis) {
        StringBuilder builder = new StringBuilder();
        builder.append(hit.m5740a());
        if (hit.m5744c() > 0) {
            long queueTime = currentTimeMillis - hit.m5744c();
            if (queueTime >= 0) {
                builder.append("&").append("qt").append("=").append(queueTime);
            }
        }
        builder.append("&").append("z").append("=").append(hit.m5742b());
        return builder.toString();
    }

    static String m5747a(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }
}
