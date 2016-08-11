package p000a.p001a.p002a.p003a.p004a;

/* renamed from: a.a.a.a.a.b */
public class C0001b {
    private static final char[] f16a;
    private static final char[] f17b;
    private final String f18c;

    static {
        f16a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        f17b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static char[] m21a(byte[] data) {
        return C0001b.m22a(data, true);
    }

    public static char[] m22a(byte[] data, boolean toLowerCase) {
        return C0001b.m23a(data, toLowerCase ? f16a : f17b);
    }

    protected static char[] m23a(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[(l << 1)];
        int j = 0;
        for (int i = 0; i < l; i++) {
            int i2 = j + 1;
            out[j] = toDigits[(data[i] & 240) >>> 4];
            j = i2 + 1;
            out[i2] = toDigits[data[i] & 15];
        }
        return out;
    }

    public static String m24b(byte[] data) {
        return new String(C0001b.m21a(data));
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.f18c + "]";
    }
}
