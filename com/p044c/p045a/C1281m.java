package com.p044c.p045a;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.LinkedHashMap;

/* renamed from: com.c.a.m */
public class C1281m implements C1266d {
    final LinkedHashMap f3865b;
    private final int f3866c;
    private int f3867d;
    private int f3868e;
    private int f3869f;
    private int f3870g;
    private int f3871h;

    public C1281m(Context context) {
        this(ab.m5395c(context));
    }

    public C1281m(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.f3866c = maxSize;
        this.f3865b = new LinkedHashMap(0, 0.75f, true);
    }

    public Bitmap m5476a(String key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap mapValue = (Bitmap) this.f3865b.get(key);
            if (mapValue != null) {
                this.f3870g++;
                return mapValue;
            }
            this.f3871h++;
            return null;
        }
    }

    public void m5477a(String key, Bitmap bitmap) {
        if (key == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        synchronized (this) {
            this.f3868e++;
            this.f3867d += ab.m5377a(bitmap);
            Bitmap previous = (Bitmap) this.f3865b.put(key, bitmap);
            if (previous != null) {
                this.f3867d -= ab.m5377a(previous);
            }
        }
        m5474a(this.f3866c);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5474a(int r7) {
        /*
        r6 = this;
    L_0x0000:
        monitor-enter(r6);
        r3 = r6.f3867d;	 Catch:{ all -> 0x0032 }
        if (r3 < 0) goto L_0x0011;
    L_0x0005:
        r3 = r6.f3865b;	 Catch:{ all -> 0x0032 }
        r3 = r3.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r3 == 0) goto L_0x0035;
    L_0x000d:
        r3 = r6.f3867d;	 Catch:{ all -> 0x0032 }
        if (r3 == 0) goto L_0x0035;
    L_0x0011:
        r3 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r4.<init>();	 Catch:{ all -> 0x0032 }
        r5 = r6.getClass();	 Catch:{ all -> 0x0032 }
        r5 = r5.getName();	 Catch:{ all -> 0x0032 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0032 }
        r5 = ".sizeOf() is reporting inconsistent results!";
        r4 = r4.append(r5);	 Catch:{ all -> 0x0032 }
        r4 = r4.toString();	 Catch:{ all -> 0x0032 }
        r3.<init>(r4);	 Catch:{ all -> 0x0032 }
        throw r3;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r3 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0032 }
        throw r3;
    L_0x0035:
        r3 = r6.f3867d;	 Catch:{ all -> 0x0032 }
        if (r3 <= r7) goto L_0x0041;
    L_0x0039:
        r3 = r6.f3865b;	 Catch:{ all -> 0x0032 }
        r3 = r3.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r3 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r6);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r3 = r6.f3865b;	 Catch:{ all -> 0x0032 }
        r3 = r3.entrySet();	 Catch:{ all -> 0x0032 }
        r3 = r3.iterator();	 Catch:{ all -> 0x0032 }
        r1 = r3.next();	 Catch:{ all -> 0x0032 }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ all -> 0x0032 }
        r0 = r1.getKey();	 Catch:{ all -> 0x0032 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0032 }
        r2 = r1.getValue();	 Catch:{ all -> 0x0032 }
        r2 = (android.graphics.Bitmap) r2;	 Catch:{ all -> 0x0032 }
        r3 = r6.f3865b;	 Catch:{ all -> 0x0032 }
        r3.remove(r0);	 Catch:{ all -> 0x0032 }
        r3 = r6.f3867d;	 Catch:{ all -> 0x0032 }
        r4 = com.p044c.p045a.ab.m5377a(r2);	 Catch:{ all -> 0x0032 }
        r3 = r3 - r4;
        r6.f3867d = r3;	 Catch:{ all -> 0x0032 }
        r3 = r6.f3869f;	 Catch:{ all -> 0x0032 }
        r3 = r3 + 1;
        r6.f3869f = r3;	 Catch:{ all -> 0x0032 }
        monitor-exit(r6);	 Catch:{ all -> 0x0032 }
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.m.a(int):void");
    }

    public final synchronized int m5475a() {
        return this.f3867d;
    }

    public final synchronized int m5478b() {
        return this.f3866c;
    }
}
