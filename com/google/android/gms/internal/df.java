package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class df {
    private int mOrientation;
    private String pN;
    private String pO;
    private String pP;
    private List pQ;
    private String pR;
    private String pS;
    private List pT;
    private long pU;
    private boolean pV;
    private final long pW;
    private List pX;
    private long pY;

    public df() {
        this.pU = -1;
        this.pV = false;
        this.pW = -1;
        this.pY = -1;
        this.mOrientation = -1;
    }

    private static String m8136a(Map map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    private static long m8137b(Map map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                dw.m8221z("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    private static List m8138c(Map map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void m8139f(Map map) {
        this.pN = m8136a(map, "X-Afma-Ad-Size");
    }

    private void m8140g(Map map) {
        List c = m8138c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.pQ = c;
        }
    }

    private void m8141h(Map map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.pR = (String) list.get(0);
        }
    }

    private void m8142i(Map map) {
        List c = m8138c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.pT = c;
        }
    }

    private void m8143j(Map map) {
        long b = m8137b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.pU = b;
        }
    }

    private void m8144k(Map map) {
        this.pS = m8136a(map, "X-Afma-ActiveView");
    }

    private void m8145l(Map map) {
        List list = (List) map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.pV = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m8146m(Map map) {
        List c = m8138c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.pX = c;
        }
    }

    private void m8147n(Map map) {
        long b = m8137b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.pY = b;
        }
    }

    private void m8148o(Map map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = dq.bA();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = dq.bz();
            }
        }
    }

    public void m8149a(String str, Map map, String str2) {
        this.pO = str;
        this.pP = str2;
        m8150e(map);
    }

    public void m8150e(Map map) {
        m8139f(map);
        m8140g(map);
        m8141h(map);
        m8142i(map);
        m8143j(map);
        m8145l(map);
        m8146m(map);
        m8147n(map);
        m8148o(map);
        m8144k(map);
    }

    public cz m8151g(long j) {
        return new cz(this.pO, this.pP, this.pQ, this.pT, this.pU, this.pV, -1, this.pX, this.pY, this.mOrientation, this.pN, j, this.pR, this.pS);
    }
}
