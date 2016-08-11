package com.p044c.p045a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Thumbnails;
import com.google.android.gms.ads.AdRequest;
import com.millennialmedia.android.MMRequest;

/* renamed from: com.c.a.o */
class C1284o extends C1270g {
    private static final String[] f3884p;

    /* renamed from: com.c.a.o.a */
    enum C1283a {
        MICRO(3, 96, 96),
        MINI(1, AdRequest.MAX_CONTENT_URL_LENGTH, 384),
        FULL(2, -1, -1);
        
        final int f3881d;
        final int f3882e;
        final int f3883f;

        private C1283a(int androidKind, int width, int height) {
            this.f3881d = androidKind;
            this.f3882e = width;
            this.f3883f = height;
        }
    }

    static int m5483a(android.content.ContentResolver r9, android.net.Uri r10) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x002d in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r8 = 0;
        r6 = 0;
        r2 = f3884p;	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
        r3 = 0;	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
        r4 = 0;	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
        r5 = 0;	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
        r0 = r9;	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
        r1 = r10;	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
        r6 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
        if (r6 == 0) goto L_0x0015;	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
    L_0x000f:
        r0 = r6.moveToFirst();	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
        if (r0 != 0) goto L_0x001c;
    L_0x0015:
        if (r6 == 0) goto L_0x001a;
    L_0x0017:
        r6.close();
    L_0x001a:
        r0 = r8;
    L_0x001b:
        return r0;
    L_0x001c:
        r0 = 0;
        r0 = r6.getInt(r0);	 Catch:{ RuntimeException -> 0x0027, all -> 0x002f }
        if (r6 == 0) goto L_0x001b;
    L_0x0023:
        r6.close();
        goto L_0x001b;
    L_0x0027:
        r7 = move-exception;
        if (r6 == 0) goto L_0x002d;
    L_0x002a:
        r6.close();
    L_0x002d:
        r0 = r8;
        goto L_0x001b;
    L_0x002f:
        r0 = move-exception;
        if (r6 == 0) goto L_0x0035;
    L_0x0032:
        r6.close();
    L_0x0035:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.o.a(android.content.ContentResolver, android.net.Uri):int");
    }

    static {
        f3884p = new String[]{MMRequest.KEY_ORIENTATION};
    }

    C1284o(Context context, C1295r picasso, C1276i dispatcher, C1266d cache, C1307x stats, C1252a action) {
        super(context, picasso, dispatcher, cache, stats, action);
    }

    Bitmap m5485a(C1300u data) {
        ContentResolver contentResolver = this.o.getContentResolver();
        m5408a(C1284o.m5483a(contentResolver, data.f3944c));
        String mimeType = contentResolver.getType(data.f3944c);
        boolean isVideo = mimeType != null && mimeType.startsWith("video/");
        if (data.m5521d()) {
            C1283a picassoKind = C1284o.m5484a(data.f3947f, data.f3948g);
            if (!isVideo && picassoKind == C1283a.FULL) {
                return super.m5441a(data);
            }
            Bitmap result;
            long id = ContentUris.parseId(data.f3944c);
            Options options = C1260c.m5405c(data);
            options.inJustDecodeBounds = true;
            C1260c.m5401a(data.f3947f, data.f3948g, picassoKind.f3882e, picassoKind.f3883f, options);
            if (isVideo) {
                result = Thumbnails.getThumbnail(contentResolver, id, picassoKind == C1283a.FULL ? 1 : picassoKind.f3881d, options);
            } else {
                result = Images.Thumbnails.getThumbnail(contentResolver, id, picassoKind.f3881d, options);
            }
            if (result != null) {
                return result;
            }
        }
        return super.m5441a(data);
    }

    static C1283a m5484a(int targetWidth, int targetHeight) {
        if (targetWidth <= C1283a.MICRO.f3882e && targetHeight <= C1283a.MICRO.f3883f) {
            return C1283a.MICRO;
        }
        if (targetWidth > C1283a.MINI.f3882e || targetHeight > C1283a.MINI.f3883f) {
            return C1283a.FULL;
        }
        return C1283a.MINI;
    }
}
