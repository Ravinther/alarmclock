package com.p044c.p045a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.google.android.gms.cast.Cast;
import com.p044c.p045a.C1254j.C1277a;
import com.p044c.p045a.C1295r.C1292d;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.c.a.p */
class C1285p extends C1260c {
    int f3885o;
    private final C1254j f3886p;

    public C1285p(C1295r picasso, C1276i dispatcher, C1266d cache, C1307x stats, C1252a action, C1254j downloader) {
        super(picasso, dispatcher, cache, stats, action);
        this.f3886p = downloader;
        this.f3885o = 2;
    }

    Bitmap m5487a(C1300u data) {
        C1277a response = this.f3886p.m5369a(data.f3944c, this.f3885o == 0);
        if (response == null) {
            return null;
        }
        this.l = response.f3862c ? C1292d.DISK : C1292d.NETWORK;
        Bitmap b = response.m5467b();
        if (b != null) {
            return b;
        }
        InputStream is = response.m5466a();
        if (is == null) {
            return null;
        }
        if (response.m5468c() == 0) {
            ab.m5387a(is);
            throw new IOException("Received response with 0 content-length header.");
        }
        if (this.l == C1292d.NETWORK && response.m5468c() > 0) {
            this.d.m5537a(response.m5468c());
        }
        try {
            b = m5486a(is, data);
            return b;
        } finally {
            ab.m5387a(is);
        }
    }

    boolean m5488a(boolean airplaneMode, NetworkInfo info) {
        boolean hasRetries;
        if (this.f3885o > 0) {
            hasRetries = true;
        } else {
            hasRetries = false;
        }
        if (!hasRetries) {
            return false;
        }
        this.f3885o--;
        if (info == null || info.isConnected()) {
            return true;
        }
        return false;
    }

    boolean m5489f() {
        return true;
    }

    private Bitmap m5486a(InputStream stream, C1300u data) {
        InputStream markStream = new C1282n(stream);
        stream = markStream;
        long mark = markStream.m5481a((int) Cast.MAX_MESSAGE_LENGTH);
        Options options = C1260c.m5405c(data);
        boolean calculateSize = C1260c.m5403a(options);
        boolean isWebPFile = ab.m5396c(stream);
        markStream.m5482a(mark);
        if (isWebPFile) {
            byte[] bytes = ab.m5394b(stream);
            if (calculateSize) {
                BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
                C1260c.m5402a(data.f3947f, data.f3948g, options);
            }
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        }
        if (calculateSize) {
            BitmapFactory.decodeStream(stream, null, options);
            C1260c.m5402a(data.f3947f, data.f3948g, options);
            markStream.m5482a(mark);
        }
        Bitmap bitmap = BitmapFactory.decodeStream(stream, null, options);
        if (bitmap != null) {
            return bitmap;
        }
        throw new IOException("Failed to decode stream.");
    }
}
