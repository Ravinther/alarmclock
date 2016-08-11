package p000a.p001a.p002a.p003a.p004a;

import java.io.UnsupportedEncodingException;

/* renamed from: a.a.a.a.a.c */
public class C0002c {
    public static byte[] m28a(String string) {
        return C0002c.m29a(string, "UTF-8");
    }

    public static byte[] m29a(String string, String charsetName) {
        if (string == null) {
            return null;
        }
        try {
            return string.getBytes(charsetName);
        } catch (UnsupportedEncodingException e) {
            throw C0002c.m25a(charsetName, e);
        }
    }

    private static IllegalStateException m25a(String charsetName, UnsupportedEncodingException e) {
        return new IllegalStateException(new StringBuilder(String.valueOf(charsetName)).append(": ").append(e).toString());
    }

    public static String m27a(byte[] bytes, String charsetName) {
        if (bytes == null) {
            return null;
        }
        try {
            return new String(bytes, charsetName);
        } catch (UnsupportedEncodingException e) {
            throw C0002c.m25a(charsetName, e);
        }
    }

    public static String m26a(byte[] bytes) {
        return C0002c.m27a(bytes, "UTF-8");
    }
}
