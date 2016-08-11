package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class fo {

    /* renamed from: com.google.android.gms.internal.fo.a */
    public static final class C1908a {
        private final List DI;
        private final Object DJ;

        private C1908a(Object obj) {
            this.DJ = fq.m8520f(obj);
            this.DI = new ArrayList();
        }

        public C1908a m8510a(String str, Object obj) {
            this.DI.add(((String) fq.m8520f(str)) + "=" + String.valueOf(obj));
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.DJ.getClass().getSimpleName()).append('{');
            int size = this.DI.size();
            for (int i = 0; i < size; i++) {
                append.append((String) this.DI.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public static C1908a m8511e(Object obj) {
        return new C1908a(null);
    }

    public static boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    public static int hashCode(Object... objects) {
        return Arrays.hashCode(objects);
    }
}
