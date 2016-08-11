package com.google.android.gms.internal;

public final class fa extends fu {

    /* renamed from: com.google.android.gms.internal.fa.a */
    public static final class C1888a {
        public final int CR;
        public final int CS;

        public C1888a(int i, int i2) {
            this.CR = i;
            this.CS = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1888a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1888a c1888a = (C1888a) obj;
            return c1888a.CR == this.CR && c1888a.CS == this.CS;
        }

        public int hashCode() {
            return fo.hashCode(Integer.valueOf(this.CR), Integer.valueOf(this.CS));
        }
    }

    public fa() {
        super(10);
    }
}
