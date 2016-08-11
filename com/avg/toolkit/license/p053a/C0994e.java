package com.avg.toolkit.license.p053a;

import com.avg.toolkit.license.p053a.C1010h.C1003c;
import com.avg.toolkit.license.p053a.C1010h.C1005e;

/* renamed from: com.avg.toolkit.license.a.e */
public class C0994e {
    static final C0994e[] f2980d;
    static final int f2981e;
    public final C1005e f2982a;
    public final C1003c f2983b;
    public final boolean f2984c;

    public C0994e(C1005e alicenseType, C1003c alicenseEndType, boolean anotActivated) {
        this.f2982a = alicenseType;
        this.f2983b = alicenseEndType;
        this.f2984c = anotActivated;
    }

    static {
        f2980d = new C0994e[]{new C0994e(C1005e.LIC_LT_TRIAL, C1003c.LIC_ET_UNDEFINED, false), new C0994e(C1005e.LIC_LT_SALES, C1003c.LIC_ET_UNDEFINED, false), new C0994e(C1005e.LIC_LT_FULL, C1003c.LIC_ET_SOFT, false), new C0994e(C1005e.LIC_LT_FULL, C1003c.LIC_ET_HARD, false), new C0994e(C1005e.LIC_LT_FULL, C1003c.LIC_ET_VIP, false), new C0994e(C1005e.LIC_LT_FREE, C1003c.LIC_ET_UNDEFINED, false), new C0994e(C1005e.LIC_LT_FULL, C1003c.LIC_ET_HARD, true)};
        f2981e = f2980d.length;
    }
}
