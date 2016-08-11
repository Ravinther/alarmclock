package com.p044c.p045a;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.p044c.p045a.C1295r.C1292d;
import java.io.InputStream;

/* renamed from: com.c.a.g */
class C1270g extends C1260c {
    final Context f3838o;

    C1270g(Context context, C1295r picasso, C1276i dispatcher, C1266d cache, C1307x stats, C1252a action) {
        super(picasso, dispatcher, cache, stats, action);
        this.f3838o = context;
    }

    Bitmap m5441a(C1300u data) {
        return m5443d(data);
    }

    C1292d m5442a() {
        return C1292d.DISK;
    }

    protected Bitmap m5443d(C1300u data) {
        InputStream inputStream;
        ContentResolver contentResolver = this.f3838o.getContentResolver();
        Options options = C1260c.m5405c(data);
        if (C1260c.m5403a(options)) {
            inputStream = null;
            try {
                inputStream = contentResolver.openInputStream(data.f3944c);
                BitmapFactory.decodeStream(inputStream, null, options);
                C1260c.m5402a(data.f3947f, data.f3948g, options);
            } finally {
                ab.m5387a(inputStream);
            }
        }
        inputStream = contentResolver.openInputStream(data.f3944c);
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            return decodeStream;
        } finally {
            ab.m5387a(inputStream);
        }
    }
}
