package com.millennialmedia.google.gson.internal;

/* renamed from: com.millennialmedia.google.gson.internal.$Gson$Preconditions */
public final class C$Gson$Preconditions {
    public static Object checkNotNull(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException();
    }

    public static void checkArgument(boolean condition) {
        if (!condition) {
            throw new IllegalArgumentException();
        }
    }
}
