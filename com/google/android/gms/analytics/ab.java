package com.google.android.gms.analytics;

import java.util.HashMap;
import java.util.Map;

class ab {
    private final Map vt;
    private final Map vu;
    private final boolean vv;
    private final String vw;

    ab(String str, boolean z) {
        this.vt = new HashMap();
        this.vu = new HashMap();
        this.vv = z;
        this.vw = str;
    }

    void m5917c(String str, int i) {
        if (this.vv) {
            Integer num = (Integer) this.vt.get(str);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.vt.put(str, Integer.valueOf(num.intValue() + i));
        }
    }

    String cU() {
        if (!this.vv) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.vw);
        for (String str : this.vt.keySet()) {
            stringBuilder.append("&").append(str).append("=").append(this.vt.get(str));
        }
        for (String str2 : this.vu.keySet()) {
            stringBuilder.append("&").append(str2).append("=").append((String) this.vu.get(str2));
        }
        return stringBuilder.toString();
    }
}
