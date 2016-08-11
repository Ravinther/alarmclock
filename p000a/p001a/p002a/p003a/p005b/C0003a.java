package p000a.p001a.p002a.p003a.p005b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p000a.p001a.p002a.p003a.p004a.C0001b;
import p000a.p001a.p002a.p003a.p004a.C0002c;

/* renamed from: a.a.a.a.b.a */
public class C0003a {
    private static byte[] m43f(String data) {
        return C0002c.m28a(data);
    }

    static MessageDigest m31a(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static MessageDigest m30a() {
        return C0003a.m31a("MD5");
    }

    private static MessageDigest m33b() {
        return C0003a.m31a("SHA-256");
    }

    private static MessageDigest m37c() {
        return C0003a.m31a("SHA");
    }

    public static byte[] m32a(byte[] data) {
        return C0003a.m30a().digest(data);
    }

    public static byte[] m34b(String data) {
        return C0003a.m32a(C0003a.m43f(data));
    }

    public static String m36c(String data) {
        return C0001b.m24b(C0003a.m34b(data));
    }

    public static byte[] m35b(byte[] data) {
        return C0003a.m37c().digest(data);
    }

    public static byte[] m40d(String data) {
        return C0003a.m35b(C0003a.m43f(data));
    }

    public static byte[] m38c(byte[] data) {
        return C0003a.m33b().digest(data);
    }

    public static String m39d(byte[] data) {
        return C0001b.m24b(C0003a.m38c(data));
    }

    public static String m42e(byte[] data) {
        return C0001b.m24b(C0003a.m35b(data));
    }

    public static String m41e(String data) {
        return C0001b.m24b(C0003a.m40d(data));
    }
}
