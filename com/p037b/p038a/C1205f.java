package com.p037b.p038a;

/* renamed from: com.b.a.f */
public class C1205f implements C1201m {
    public Integer m5054a(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue.intValue();
        return Integer.valueOf((int) (((float) startInt) + (((float) (endValue.intValue() - startInt)) * fraction)));
    }
}
