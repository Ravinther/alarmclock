package com.p044c.p045a;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.c.a.j */
public interface C1254j {

    /* renamed from: com.c.a.j.a */
    public static class C1277a {
        final InputStream f3860a;
        final Bitmap f3861b;
        final boolean f3862c;
        final long f3863d;

        public C1277a(InputStream stream, boolean loadedFromCache, long contentLength) {
            if (stream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f3860a = stream;
            this.f3861b = null;
            this.f3862c = loadedFromCache;
            this.f3863d = contentLength;
        }

        public InputStream m5466a() {
            return this.f3860a;
        }

        public Bitmap m5467b() {
            return this.f3861b;
        }

        public long m5468c() {
            return this.f3863d;
        }
    }

    /* renamed from: com.c.a.j.b */
    public static class C1278b extends IOException {
        public C1278b(String message) {
            super(message);
        }
    }

    C1277a m5369a(Uri uri, boolean z);
}
