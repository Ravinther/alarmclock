package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.android.gms.internal.i */
public abstract class C1965i implements C1935h {
    protected MotionEvent jN;
    protected DisplayMetrics jO;
    protected C1833n jP;
    private C2028o jQ;

    protected C1965i(Context context, C1833n c1833n, C2028o c2028o) {
        this.jP = c1833n;
        this.jQ = c2028o;
        try {
            this.jO = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.jO = new DisplayMetrics();
            this.jO.density = 1.0f;
        }
    }

    private String m8725a(Context context, String str, boolean z) {
        try {
            byte[] u;
            synchronized (this) {
                m8726t();
                if (z) {
                    m8737c(context);
                } else {
                    m8736b(context);
                }
                u = m8727u();
            }
            return u.length == 0 ? Integer.toString(5) : m8730a(u, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    private void m8726t() {
        this.jQ.reset();
    }

    private byte[] m8727u() {
        return this.jQ.m8957z();
    }

    public String m8728a(Context context) {
        return m8725a(context, null, false);
    }

    public String m8729a(Context context, String str) {
        return m8725a(context, str, true);
    }

    String m8730a(byte[] bArr, String str) {
        byte[] bArr2;
        if (bArr.length > 239) {
            m8726t();
            m8732a(20, 1);
            bArr = m8727u();
        }
        if (bArr.length < 239) {
            bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            bArr2 = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(bArr2);
        bArr2 = ByteBuffer.allocate(256).put(instance.digest()).put(bArr2).array();
        byte[] bArr3 = new byte[256];
        new C1887f().m8417a(bArr2, bArr3);
        if (str != null && str.length() > 0) {
            m8735a(str, bArr3);
        }
        return this.jP.m8234a(bArr3, true);
    }

    public void m8731a(int i, int i2, int i3) {
        if (this.jN != null) {
            this.jN.recycle();
        }
        this.jN = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.jO.density, ((float) i2) * this.jO.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    protected void m8732a(int i, long j) {
        this.jQ.m8955b(i, j);
    }

    protected void m8733a(int i, String str) {
        this.jQ.m8956b(i, str);
    }

    public void m8734a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.jN != null) {
                this.jN.recycle();
            }
            this.jN = MotionEvent.obtain(motionEvent);
        }
    }

    void m8735a(String str, byte[] bArr) {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new km(str.getBytes("UTF-8")).m8900m(bArr);
    }

    protected abstract void m8736b(Context context);

    protected abstract void m8737c(Context context);
}
