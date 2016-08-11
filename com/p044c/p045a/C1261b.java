package com.p044c.p045a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.p044c.p045a.C1295r.C1292d;
import java.io.InputStream;

/* renamed from: com.c.a.b */
class C1261b extends C1260c {
    private static final int f3830o;
    private final AssetManager f3831p;

    static {
        f3830o = "file:///android_asset/".length();
    }

    public C1261b(Context context, C1295r picasso, C1276i dispatcher, C1266d cache, C1307x stats, C1252a action) {
        super(picasso, dispatcher, cache, stats, action);
        this.f3831p = context.getAssets();
    }

    Bitmap m5424a(C1300u data) {
        return m5425a(data.f3944c.toString().substring(f3830o));
    }

    C1292d m5426a() {
        return C1292d.DISK;
    }

    Bitmap m5425a(String filePath) {
        InputStream inputStream;
        Options options = C1260c.m5405c(this.f);
        if (C1260c.m5403a(options)) {
            inputStream = null;
            try {
                inputStream = this.f3831p.open(filePath);
                BitmapFactory.decodeStream(inputStream, null, options);
                C1260c.m5402a(this.f.f3947f, this.f.f3948g, options);
            } finally {
                ab.m5387a(inputStream);
            }
        }
        inputStream = this.f3831p.open(filePath);
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            return decodeStream;
        } finally {
            ab.m5387a(inputStream);
        }
    }
}
