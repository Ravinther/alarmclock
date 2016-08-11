package com.avg.toolkit.license.p053a;

import java.util.Locale;

/* renamed from: com.avg.toolkit.license.a.j */
public class C1012j {
    public long f3098a;
    public long f3099b;
    public long f3100c;
    private final long f3101d;
    private final long f3102e;
    private final long f3103f;
    private final long f3104g;

    public C1012j() {
        this.f3101d = 10000000;
        this.f3102e = 86400;
        this.f3103f = 146097;
        this.f3104g = 1461;
    }

    public String m4423a(long liTime) {
        long Days = (liTime / 10000000) / 86400;
        Days += 28188 + (((3 * (((4 * Days) + 1227) / 146097)) + 3) / 4);
        long years = ((20 * Days) - 2442) / 7305;
        long yearday = Days - ((1461 * years) / 4);
        long months = (64 * yearday) / 1959;
        if (months < 14) {
            this.f3099b = months - 1;
            this.f3098a = 1524 + years;
        } else {
            this.f3099b = months - 13;
            this.f3098a = 1525 + years;
        }
        this.f3100c = yearday - ((1959 * months) / 64);
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(this.f3100c);
        objArr[1] = Long.valueOf(this.f3099b);
        objArr[2] = Long.valueOf(this.f3098a);
        return String.format(Locale.ENGLISH, "%d.%d.%d", objArr);
    }
}
