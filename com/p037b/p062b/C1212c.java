package com.p037b.p062b;

/* renamed from: com.b.b.c */
public abstract class C1212c {
    private final String f3699a;
    private final Class f3700b;

    public abstract Object m5135a(Object obj);

    public C1212c(Class type, String name) {
        this.f3699a = name;
        this.f3700b = type;
    }

    public void m5137a(Object object, Object value) {
        throw new UnsupportedOperationException("Property " + m5136a() + " is read-only");
    }

    public String m5136a() {
        return this.f3699a;
    }
}
