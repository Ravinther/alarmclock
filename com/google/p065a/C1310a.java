package com.google.p065a;

/* renamed from: com.google.a.a */
public class C1310a {
    private final float f4001a;
    private final float f4002b;

    public final float m5550a() {
        return this.f4001a;
    }

    public final float m5551b() {
        return this.f4002b;
    }

    public boolean equals(Object other) {
        if (!(other instanceof C1310a)) {
            return false;
        }
        C1310a otherPoint = (C1310a) other;
        if (this.f4001a == otherPoint.f4001a && this.f4002b == otherPoint.f4002b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f4001a) * 31) + Float.floatToIntBits(this.f4002b);
    }

    public String toString() {
        StringBuilder result = new StringBuilder(25);
        result.append('(');
        result.append(this.f4001a);
        result.append(',');
        result.append(this.f4002b);
        result.append(')');
        return result.toString();
    }
}
