package com.p015a.p016a.p017a;

import com.p015a.p016a.p017a.p018a.C0491a;
import com.p015a.p016a.p017a.p018a.C0492b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.a.a.a.a */
public class C0494a implements C0493d {
    private static final byte[] f1314a;
    private Cipher f1315b;
    private Cipher f1316c;

    static {
        f1314a = new byte[]{(byte) 16, (byte) 74, (byte) 71, (byte) -80, (byte) 32, (byte) 101, (byte) -47, (byte) 72, (byte) 117, (byte) -14, (byte) 0, (byte) -29, (byte) 70, (byte) 65, (byte) -12, (byte) 74};
    }

    public C0494a(byte[] salt, String applicationId, String deviceId) {
        try {
            SecretKey secret = new SecretKeySpec(SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC").generateSecret(new PBEKeySpec((applicationId + deviceId).toCharArray(), salt, 1024, 256)).getEncoded(), "AES");
            this.f1315b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f1315b.init(1, secret, new IvParameterSpec(f1314a));
            this.f1316c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f1316c.init(2, secret, new IvParameterSpec(f1314a));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Invalid environment", e);
        }
    }

    public String m2355a(String original) {
        if (original == null) {
            return null;
        }
        try {
            return C0491a.m2346a(this.f1315b.doFinal(("com.android.vending.licensing.AESObfuscator-1|" + original).getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Invalid environment", e);
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException("Invalid environment", e2);
        }
    }

    public String m2356b(String obfuscated) {
        if (obfuscated == null) {
            return null;
        }
        try {
            String result = new String(this.f1316c.doFinal(C0491a.m2348a(obfuscated)), "UTF-8");
            if (result.indexOf("com.android.vending.licensing.AESObfuscator-1|") == 0) {
                return result.substring("com.android.vending.licensing.AESObfuscator-1|".length(), result.length());
            }
            throw new C0497e("Header not found (invalid data or key):" + obfuscated);
        } catch (C0492b e) {
            throw new C0497e(e.getMessage() + ":" + obfuscated);
        } catch (IllegalBlockSizeException e2) {
            throw new C0497e(e2.getMessage() + ":" + obfuscated);
        } catch (BadPaddingException e3) {
            throw new C0497e(e3.getMessage() + ":" + obfuscated);
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("Invalid environment", e4);
        }
    }
}
