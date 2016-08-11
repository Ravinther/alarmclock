package com.p044c.p045a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.p044c.p045a.C1295r.C1292d;

/* renamed from: com.c.a.w */
class C1304w extends C1260c {
    private final Context f3969o;

    C1304w(Context context, C1295r picasso, C1276i dispatcher, C1266d cache, C1307x stats, C1252a action) {
        super(picasso, dispatcher, cache, stats, action);
        this.f3969o = context;
    }

    Bitmap m5532a(C1300u data) {
        Resources res = ab.m5379a(this.f3969o, data);
        return m5531a(res, ab.m5376a(res, data), data);
    }

    C1292d m5533a() {
        return C1292d.DISK;
    }

    private Bitmap m5531a(Resources resources, int id, C1300u data) {
        Options options = C1260c.m5405c(data);
        if (C1260c.m5403a(options)) {
            BitmapFactory.decodeResource(resources, id, options);
            C1260c.m5402a(data.f3947f, data.f3948g, options);
        }
        return BitmapFactory.decodeResource(resources, id, options);
    }
}
