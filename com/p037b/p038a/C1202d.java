package com.p037b.p038a;

/* renamed from: com.b.a.d */
public class C1202d implements C1201m {
    public Float m5043a(float fraction, Number startValue, Number endValue) {
        float startFloat = startValue.floatValue();
        return Float.valueOf(((endValue.floatValue() - startFloat) * fraction) + startFloat);
    }
}
