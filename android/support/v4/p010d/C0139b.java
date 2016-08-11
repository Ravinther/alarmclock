package android.support.v4.p010d;

/* renamed from: android.support.v4.d.b */
class C0139b {
    static final int[] f348a;
    static final long[] f349b;
    static final Object[] f350c;

    static {
        f348a = new int[0];
        f349b = new long[0];
        f350c = new Object[0];
    }

    public static int m542a(int need) {
        return C0139b.m547c(need * 4) / 4;
    }

    public static int m546b(int need) {
        return C0139b.m547c(need * 8) / 8;
    }

    public static int m547c(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    public static boolean m545a(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    static int m543a(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int i = (lo + hi) >>> 1;
            int midVal = array[i];
            if (midVal < value) {
                lo = i + 1;
            } else if (midVal <= value) {
                return i;
            } else {
                hi = i - 1;
            }
        }
        return lo ^ -1;
    }

    static int m544a(long[] array, int size, long value) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int i = (lo + hi) >>> 1;
            long midVal = array[i];
            if (midVal < value) {
                lo = i + 1;
            } else if (midVal <= value) {
                return i;
            } else {
                hi = i - 1;
            }
        }
        return lo ^ -1;
    }
}
