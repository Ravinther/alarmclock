package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.j */
public abstract class C1996j extends C1965i {
    private static Method jR;
    private static Method jS;
    private static Method jT;
    private static Method jU;
    private static Method jV;
    private static Method jW;
    private static String jX;
    private static C2030p jY;
    static boolean jZ;
    private static long startTime;

    /* renamed from: com.google.android.gms.internal.j.a */
    static class C1995a extends Exception {
        public C1995a(Throwable th) {
            super(th);
        }
    }

    static {
        startTime = 0;
        jZ = false;
    }

    protected C1996j(Context context, C1833n c1833n, C2028o c2028o) {
        super(context, c1833n, c2028o);
    }

    static String m8808a(Context context, C1833n c1833n) {
        if (jT == null) {
            throw new C1995a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) jT.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c1833n.m8234a(byteBuffer.array(), true);
            }
            throw new C1995a();
        } catch (Throwable e) {
            throw new C1995a(e);
        } catch (Throwable e2) {
            throw new C1995a(e2);
        }
    }

    static ArrayList m8809a(MotionEvent motionEvent, DisplayMetrics displayMetrics) {
        if (jU == null || motionEvent == null) {
            throw new C1995a();
        }
        try {
            return (ArrayList) jU.invoke(null, new Object[]{motionEvent, displayMetrics});
        } catch (Throwable e) {
            throw new C1995a(e);
        } catch (Throwable e2) {
            throw new C1995a(e2);
        }
    }

    protected static synchronized void m8810a(String str, Context context, C1833n c1833n) {
        synchronized (C1996j.class) {
            if (!jZ) {
                try {
                    jY = new C2030p(c1833n, null);
                    jX = str;
                    C1996j.m8814e(context);
                    startTime = C1996j.m8816w().longValue();
                    jZ = true;
                } catch (C1995a e) {
                } catch (UnsupportedOperationException e2) {
                }
            }
        }
    }

    static String m8811b(Context context, C1833n c1833n) {
        if (jW == null) {
            throw new C1995a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) jW.invoke(null, new Object[]{context});
            if (byteBuffer != null) {
                return c1833n.m8234a(byteBuffer.array(), true);
            }
            throw new C1995a();
        } catch (Throwable e) {
            throw new C1995a(e);
        } catch (Throwable e2) {
            throw new C1995a(e2);
        }
    }

    private static String m8812b(byte[] bArr, String str) {
        try {
            return new String(jY.m8960c(bArr, str), "UTF-8");
        } catch (Throwable e) {
            throw new C1995a(e);
        } catch (Throwable e2) {
            throw new C1995a(e2);
        }
    }

    static String m8813d(Context context) {
        if (jV == null) {
            throw new C1995a();
        }
        try {
            String str = (String) jV.invoke(null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C1995a();
        } catch (Throwable e) {
            throw new C1995a(e);
        } catch (Throwable e2) {
            throw new C1995a(e2);
        }
    }

    private static void m8814e(Context context) {
        try {
            byte[] b = jY.m8959b(C2032r.getKey());
            byte[] c = jY.m8960c(b, C2032r.m8964A());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                cacheDir = context.getDir("dex", 0);
                if (cacheDir == null) {
                    throw new C1995a();
                }
            }
            File createTempFile = File.createTempFile("ads", ".jar", cacheDir);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(c, 0, c.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(C1996j.m8812b(b, C2032r.m8965B()));
            Class loadClass2 = dexClassLoader.loadClass(C1996j.m8812b(b, C2032r.m8971H()));
            Class loadClass3 = dexClassLoader.loadClass(C1996j.m8812b(b, C2032r.m8969F()));
            Class loadClass4 = dexClassLoader.loadClass(C1996j.m8812b(b, C2032r.m8975L()));
            Class loadClass5 = dexClassLoader.loadClass(C1996j.m8812b(b, C2032r.m8967D()));
            Class loadClass6 = dexClassLoader.loadClass(C1996j.m8812b(b, C2032r.m8973J()));
            jR = loadClass.getMethod(C1996j.m8812b(b, C2032r.m8966C()), new Class[0]);
            jS = loadClass2.getMethod(C1996j.m8812b(b, C2032r.m8972I()), new Class[0]);
            jT = loadClass3.getMethod(C1996j.m8812b(b, C2032r.m8970G()), new Class[]{Context.class});
            jU = loadClass4.getMethod(C1996j.m8812b(b, C2032r.m8976M()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            jV = loadClass5.getMethod(C1996j.m8812b(b, C2032r.m8968E()), new Class[]{Context.class});
            jW = loadClass6.getMethod(C1996j.m8812b(b, C2032r.m8974K()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(cacheDir, name.replace(".jar", ".dex")).delete();
        } catch (Throwable e) {
            throw new C1995a(e);
        } catch (Throwable e2) {
            throw new C1995a(e2);
        } catch (Throwable e22) {
            throw new C1995a(e22);
        } catch (Throwable e222) {
            throw new C1995a(e222);
        } catch (Throwable e2222) {
            throw new C1995a(e2222);
        } catch (Throwable e22222) {
            throw new C1995a(e22222);
        }
    }

    static String m8815v() {
        if (jX != null) {
            return jX;
        }
        throw new C1995a();
    }

    static Long m8816w() {
        if (jR == null) {
            throw new C1995a();
        }
        try {
            return (Long) jR.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C1995a(e);
        } catch (Throwable e2) {
            throw new C1995a(e2);
        }
    }

    static String m8817x() {
        if (jS == null) {
            throw new C1995a();
        }
        try {
            return (String) jS.invoke(null, new Object[0]);
        } catch (Throwable e) {
            throw new C1995a(e);
        } catch (Throwable e2) {
            throw new C1995a(e2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m8818b(android.content.Context r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = com.google.android.gms.internal.C1996j.m8817x();	 Catch:{ a -> 0x002f, IOException -> 0x0027 }
        r4.m8733a(r0, r1);	 Catch:{ a -> 0x002f, IOException -> 0x0027 }
    L_0x0008:
        r0 = 2;
        r1 = com.google.android.gms.internal.C1996j.m8815v();	 Catch:{ a -> 0x002d, IOException -> 0x0027 }
        r4.m8733a(r0, r1);	 Catch:{ a -> 0x002d, IOException -> 0x0027 }
    L_0x0010:
        r0 = 25;
        r1 = com.google.android.gms.internal.C1996j.m8816w();	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
        r2 = r1.longValue();	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
        r4.m8732a(r0, r2);	 Catch:{ a -> 0x002b, IOException -> 0x0027 }
    L_0x001d:
        r0 = 24;
        r1 = com.google.android.gms.internal.C1996j.m8813d(r5);	 Catch:{ a -> 0x0029, IOException -> 0x0027 }
        r4.m8733a(r0, r1);	 Catch:{ a -> 0x0029, IOException -> 0x0027 }
    L_0x0026:
        return;
    L_0x0027:
        r0 = move-exception;
        goto L_0x0026;
    L_0x0029:
        r0 = move-exception;
        goto L_0x0026;
    L_0x002b:
        r0 = move-exception;
        goto L_0x001d;
    L_0x002d:
        r0 = move-exception;
        goto L_0x0010;
    L_0x002f:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.b(android.content.Context):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m8819c(android.content.Context r7) {
        /*
        r6 = this;
        r0 = 2;
        r1 = com.google.android.gms.internal.C1996j.m8815v();	 Catch:{ a -> 0x0097, IOException -> 0x008a }
        r6.m8733a(r0, r1);	 Catch:{ a -> 0x0097, IOException -> 0x008a }
    L_0x0008:
        r0 = 1;
        r1 = com.google.android.gms.internal.C1996j.m8817x();	 Catch:{ a -> 0x0094, IOException -> 0x008a }
        r6.m8733a(r0, r1);	 Catch:{ a -> 0x0094, IOException -> 0x008a }
    L_0x0010:
        r0 = com.google.android.gms.internal.C1996j.m8816w();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = 25;
        r6.m8732a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r2 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0034;
    L_0x0025:
        r2 = 17;
        r4 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = r0 - r4;
        r6.m8732a(r2, r0);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r0 = 23;
        r2 = startTime;	 Catch:{ a -> 0x0092, IOException -> 0x008a }
        r6.m8732a(r0, r2);	 Catch:{ a -> 0x0092, IOException -> 0x008a }
    L_0x0034:
        r0 = r6.jN;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = r6.jO;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C1996j.m8809a(r0, r1);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 14;
        r0 = 0;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r4 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m8732a(r2, r4);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 15;
        r0 = 1;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r4 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m8732a(r2, r4);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r1.size();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r2 = 3;
        if (r0 < r2) goto L_0x0073;
    L_0x0063:
        r2 = 16;
        r0 = 2;
        r0 = r1.get(r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = (java.lang.Long) r0;	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r0 = r0.longValue();	 Catch:{ a -> 0x0090, IOException -> 0x008a }
        r6.m8732a(r2, r0);	 Catch:{ a -> 0x0090, IOException -> 0x008a }
    L_0x0073:
        r0 = 27;
        r1 = r6.jP;	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C1996j.m8808a(r7, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
        r6.m8733a(r0, r1);	 Catch:{ a -> 0x008e, IOException -> 0x008a }
    L_0x007e:
        r0 = 29;
        r1 = r6.jP;	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r1 = com.google.android.gms.internal.C1996j.m8811b(r7, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
        r6.m8733a(r0, r1);	 Catch:{ a -> 0x008c, IOException -> 0x008a }
    L_0x0089:
        return;
    L_0x008a:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008c:
        r0 = move-exception;
        goto L_0x0089;
    L_0x008e:
        r0 = move-exception;
        goto L_0x007e;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0073;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0034;
    L_0x0094:
        r0 = move-exception;
        goto L_0x0010;
    L_0x0097:
        r0 = move-exception;
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.j.c(android.content.Context):void");
    }
}
