package com.google.android.gms.internal;

import java.util.LinkedHashMap;

public class fu {
    private final LinkedHashMap DL;
    private int DM;
    private int DN;
    private int DO;
    private int DP;
    private int DQ;
    private int DR;
    private int size;

    public fu(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.DM = i;
        this.DL = new LinkedHashMap(0, 0.75f, true);
    }

    private int m6283c(Object obj, Object obj2) {
        int sizeOf = sizeOf(obj, obj2);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    protected Object create(Object key) {
        return null;
    }

    protected void entryRemoved(boolean evicted, Object key, Object oldValue, Object newValue) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final Object get(Object key) {
        if (key == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Object obj = this.DL.get(key);
            if (obj != null) {
                this.DQ++;
                return obj;
            }
            this.DR++;
            Object create = create(key);
            if (create == null) {
                return null;
            }
            synchronized (this) {
                this.DO++;
                obj = this.DL.put(key, create);
                if (obj != null) {
                    this.DL.put(key, obj);
                } else {
                    this.size += m6283c(key, create);
                }
            }
            if (obj != null) {
                entryRemoved(false, key, create, obj);
                return obj;
            }
            trimToSize(this.DM);
            return create;
        }
    }

    public final Object put(Object key, Object value) {
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        Object put;
        synchronized (this) {
            this.DN++;
            this.size += m6283c(key, value);
            put = this.DL.put(key, value);
            if (put != null) {
                this.size -= m6283c(key, put);
            }
        }
        if (put != null) {
            entryRemoved(false, key, put, value);
        }
        trimToSize(this.DM);
        return put;
    }

    public final synchronized int size() {
        return this.size;
    }

    protected int sizeOf(Object key, Object value) {
        return 1;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.DQ + this.DR;
            if (i2 != 0) {
                i = (this.DQ * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.DM), Integer.valueOf(this.DQ), Integer.valueOf(this.DR), Integer.valueOf(i)});
        }
        return format;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.size;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r4.DL;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r4.size;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r4.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r4.size;	 Catch:{ all -> 0x0032 }
        if (r0 <= r5) goto L_0x0041;
    L_0x0039:
        r0 = r4.DL;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r4.DL;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r2 = r4.DL;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r2 = r4.size;	 Catch:{ all -> 0x0032 }
        r3 = r4.m6283c(r1, r0);	 Catch:{ all -> 0x0032 }
        r2 = r2 - r3;
        r4.size = r2;	 Catch:{ all -> 0x0032 }
        r2 = r4.DP;	 Catch:{ all -> 0x0032 }
        r2 = r2 + 1;
        r4.DP = r2;	 Catch:{ all -> 0x0032 }
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        r2 = 1;
        r3 = 0;
        r4.entryRemoved(r2, r1, r0, r3);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.fu.trimToSize(int):void");
    }
}
