package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.p */
public class C2030p {
    private final C1833n jP;
    private final SecureRandom ki;

    /* renamed from: com.google.android.gms.internal.p.a */
    public class C2029a extends Exception {
        final /* synthetic */ C2030p kj;

        public C2029a(C2030p c2030p) {
            this.kj = c2030p;
        }

        public C2029a(C2030p c2030p, Throwable th) {
            this.kj = c2030p;
            super(th);
        }
    }

    public C2030p(C1833n c1833n, SecureRandom secureRandom) {
        this.jP = c1833n;
        this.ki = secureRandom;
    }

    static void m8958c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    public byte[] m8959b(String str) {
        try {
            byte[] a = this.jP.m8235a(str, false);
            if (a.length != 32) {
                throw new C2029a(this);
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            C2030p.m8958c(bArr);
            return bArr;
        } catch (Throwable e) {
            throw new C2029a(this, e);
        }
    }

    public byte[] m8960c(byte[] bArr, String str) {
        if (bArr.length != 16) {
            throw new C2029a(this);
        }
        try {
            byte[] a = this.jP.m8235a(str, false);
            if (a.length <= 16) {
                throw new C2029a(this);
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            a = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(a);
            Key secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(a);
        } catch (Throwable e) {
            throw new C2029a(this, e);
        } catch (Throwable e2) {
            throw new C2029a(this, e2);
        } catch (Throwable e22) {
            throw new C2029a(this, e22);
        } catch (Throwable e222) {
            throw new C2029a(this, e222);
        } catch (Throwable e2222) {
            throw new C2029a(this, e2222);
        } catch (Throwable e22222) {
            throw new C2029a(this, e22222);
        } catch (Throwable e222222) {
            throw new C2029a(this, e222222);
        }
    }
}
