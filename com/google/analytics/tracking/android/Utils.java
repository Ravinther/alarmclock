package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class Utils {
    private static final char[] f4256a;

    Utils() {
    }

    static {
        f4256a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static Map m5844a(String parameterString) {
        Map parameters = new HashMap();
        for (String s : parameterString.split("&")) {
            String[] ss = s.split("=");
            if (ss.length > 1) {
                parameters.put(ss[0], ss[1]);
            } else if (ss.length == 1 && ss[0].length() != 0) {
                parameters.put(ss[0], null);
            }
        }
        return parameters;
    }

    public static double m5845b(String s) {
        double d = 0.0d;
        if (s != null) {
            try {
                d = Double.parseDouble(s);
            } catch (NumberFormatException e) {
            }
        }
        return d;
    }

    public static boolean m5846c(String s) {
        return Boolean.parseBoolean(s);
    }

    public static String m5847d(String campaign) {
        if (TextUtils.isEmpty(campaign)) {
            return null;
        }
        String urlParameters = campaign;
        if (campaign.contains("?")) {
            urlParameters = campaign.split("[\\?]")[1];
        }
        if (urlParameters.contains("%3D")) {
            try {
                urlParameters = URLDecoder.decode(urlParameters, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else if (!urlParameters.contains("=")) {
            return null;
        }
        Map paramsMap = m5844a(urlParameters);
        String[] validParameters = new String[]{"dclid", "utm_source", "gclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "gmob_t"};
        StringBuilder params = new StringBuilder();
        for (int i = 0; i < validParameters.length; i++) {
            if (!TextUtils.isEmpty((CharSequence) paramsMap.get(validParameters[i]))) {
                if (params.length() > 0) {
                    params.append("&");
                }
                params.append(validParameters[i]).append("=").append((String) paramsMap.get(validParameters[i]));
            }
        }
        return params.toString();
    }

    static String m5843a(Locale locale) {
        if (locale == null || TextUtils.isEmpty(locale.getLanguage())) {
            return null;
        }
        StringBuilder lang = new StringBuilder();
        lang.append(locale.getLanguage().toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            lang.append("-").append(locale.getCountry().toLowerCase());
        }
        return lang.toString();
    }

    static int m5841a(char hexDigit) {
        int value = hexDigit - 48;
        if (value > 9) {
            return value - 7;
        }
        return value;
    }

    static byte[] m5848e(String s) {
        byte[] bytes = new byte[(s.length() / 2)];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ((m5841a(s.charAt(i * 2)) << 4) | m5841a(s.charAt((i * 2) + 1)));
        }
        return bytes;
    }

    static String m5842a(String field, int slot) {
        return field + "*" + slot;
    }
}
