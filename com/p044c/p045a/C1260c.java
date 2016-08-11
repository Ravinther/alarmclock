package com.p044c.p045a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.p044c.p045a.C1295r.C1292d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* renamed from: com.c.a.c */
abstract class C1260c implements Runnable {
    private static final Object f3814o;
    private static final ThreadLocal f3815p;
    final C1295r f3816a;
    final C1276i f3817b;
    final C1266d f3818c;
    final C1307x f3819d;
    final String f3820e;
    final C1300u f3821f;
    final boolean f3822g;
    C1252a f3823h;
    List f3824i;
    Bitmap f3825j;
    Future f3826k;
    C1292d f3827l;
    Exception f3828m;
    int f3829n;

    /* renamed from: com.c.a.c.1 */
    static class C12621 extends ThreadLocal {
        C12621() {
        }

        protected /* synthetic */ Object initialValue() {
            return m5427a();
        }

        protected StringBuilder m5427a() {
            return new StringBuilder("Picasso-");
        }
    }

    /* renamed from: com.c.a.c.2 */
    static class C12632 implements Runnable {
        final /* synthetic */ StringBuilder f3832a;

        C12632(StringBuilder stringBuilder) {
            this.f3832a = stringBuilder;
        }

        public void run() {
            throw new NullPointerException(this.f3832a.toString());
        }
    }

    /* renamed from: com.c.a.c.3 */
    static class C12643 implements Runnable {
        final /* synthetic */ C1309z f3833a;

        C12643(C1309z c1309z) {
            this.f3833a = c1309z;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f3833a.m5549a() + " returned input Bitmap but recycled it.");
        }
    }

    /* renamed from: com.c.a.c.4 */
    static class C12654 implements Runnable {
        final /* synthetic */ C1309z f3834a;

        C12654(C1309z c1309z) {
            this.f3834a = c1309z;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f3834a.m5549a() + " mutated input Bitmap but failed to recycle the original.");
        }
    }

    abstract Bitmap m5406a(C1300u c1300u);

    static {
        f3814o = new Object();
        f3815p = new C12621();
    }

    C1260c(C1295r picasso, C1276i dispatcher, C1266d cache, C1307x stats, C1252a action) {
        this.f3816a = picasso;
        this.f3817b = dispatcher;
        this.f3818c = cache;
        this.f3819d = stats;
        this.f3820e = action.m5364e();
        this.f3821f = action.m5362c();
        this.f3822g = action.f3803d;
        this.f3823h = action;
    }

    protected void m5408a(int exifRotation) {
        this.f3829n = exifRotation;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r5 = this;
        r2 = r5.f3821f;	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        com.p044c.p045a.C1260c.m5404b(r2);	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r2 = r5.f3816a;	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r2 = r2.f3916k;	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        if (r2 == 0) goto L_0x0016;
    L_0x000b:
        r2 = "Hunter";
        r3 = "executing";
        r4 = com.p044c.p045a.ab.m5382a(r5);	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        com.p044c.p045a.ab.m5388a(r2, r3, r4);	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
    L_0x0016:
        r2 = r5.m5411b();	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r5.f3825j = r2;	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r2 = r5.f3825j;	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        if (r2 != 0) goto L_0x002f;
    L_0x0020:
        r2 = r5.f3817b;	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r2.m5462c(r5);	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
    L_0x0025:
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
    L_0x002e:
        return;
    L_0x002f:
        r2 = r5.f3817b;	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        r2.m5454a(r5);	 Catch:{ b -> 0x0035, IOException -> 0x0047, OutOfMemoryError -> 0x0059, Exception -> 0x0087 }
        goto L_0x0025;
    L_0x0035:
        r0 = move-exception;
        r5.f3828m = r0;	 Catch:{ all -> 0x0099 }
        r2 = r5.f3817b;	 Catch:{ all -> 0x0099 }
        r2.m5462c(r5);	 Catch:{ all -> 0x0099 }
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
        goto L_0x002e;
    L_0x0047:
        r0 = move-exception;
        r5.f3828m = r0;	 Catch:{ all -> 0x0099 }
        r2 = r5.f3817b;	 Catch:{ all -> 0x0099 }
        r2.m5459b(r5);	 Catch:{ all -> 0x0099 }
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
        goto L_0x002e;
    L_0x0059:
        r0 = move-exception;
        r1 = new java.io.StringWriter;	 Catch:{ all -> 0x0099 }
        r1.<init>();	 Catch:{ all -> 0x0099 }
        r2 = r5.f3819d;	 Catch:{ all -> 0x0099 }
        r2 = r2.m5546e();	 Catch:{ all -> 0x0099 }
        r3 = new java.io.PrintWriter;	 Catch:{ all -> 0x0099 }
        r3.<init>(r1);	 Catch:{ all -> 0x0099 }
        r2.m5547a(r3);	 Catch:{ all -> 0x0099 }
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0099 }
        r3 = r1.toString();	 Catch:{ all -> 0x0099 }
        r2.<init>(r3, r0);	 Catch:{ all -> 0x0099 }
        r5.f3828m = r2;	 Catch:{ all -> 0x0099 }
        r2 = r5.f3817b;	 Catch:{ all -> 0x0099 }
        r2.m5462c(r5);	 Catch:{ all -> 0x0099 }
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
        goto L_0x002e;
    L_0x0087:
        r0 = move-exception;
        r5.f3828m = r0;	 Catch:{ all -> 0x0099 }
        r2 = r5.f3817b;	 Catch:{ all -> 0x0099 }
        r2.m5462c(r5);	 Catch:{ all -> 0x0099 }
        r2 = java.lang.Thread.currentThread();
        r3 = "Picasso-Idle";
        r2.setName(r3);
        goto L_0x002e;
    L_0x0099:
        r2 = move-exception;
        r3 = java.lang.Thread.currentThread();
        r4 = "Picasso-Idle";
        r3.setName(r4);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.run():void");
    }

    Bitmap m5411b() {
        Bitmap bitmap;
        if (!this.f3822g) {
            bitmap = this.f3818c.m5429a(this.f3820e);
            if (bitmap != null) {
                this.f3819d.m5536a();
                this.f3827l = C1292d.MEMORY;
                if (this.f3816a.f3916k) {
                    ab.m5389a("Hunter", "decoded", this.f3821f.m5518a(), "from cache");
                }
                return bitmap;
            }
        }
        bitmap = m5406a(this.f3821f);
        if (bitmap != null) {
            if (this.f3816a.f3916k) {
                ab.m5388a("Hunter", "decoded", this.f3821f.m5518a());
            }
            this.f3819d.m5538a(bitmap);
            if (this.f3821f.m5522e() || this.f3829n != 0) {
                synchronized (f3814o) {
                    if (this.f3821f.m5523f() || this.f3829n != 0) {
                        bitmap = C1260c.m5398a(this.f3821f, bitmap, this.f3829n);
                        if (this.f3816a.f3916k) {
                            ab.m5388a("Hunter", "transformed", this.f3821f.m5518a());
                        }
                    }
                    if (this.f3821f.m5524g()) {
                        bitmap = C1260c.m5399a(this.f3821f.f3946e, bitmap);
                        if (this.f3816a.f3916k) {
                            ab.m5389a("Hunter", "transformed", this.f3821f.m5518a(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f3819d.m5542b(bitmap);
                }
            }
        }
        return bitmap;
    }

    void m5409a(C1252a action) {
        boolean loggingEnabled = this.f3816a.f3916k;
        C1300u request = action.f3801b;
        if (this.f3823h == null) {
            this.f3823h = action;
            if (!loggingEnabled) {
                return;
            }
            if (this.f3824i == null || this.f3824i.isEmpty()) {
                ab.m5389a("Hunter", "joined", request.m5518a(), "to empty hunter");
                return;
            } else {
                ab.m5389a("Hunter", "joined", request.m5518a(), ab.m5383a(this, "to "));
                return;
            }
        }
        if (this.f3824i == null) {
            this.f3824i = new ArrayList(3);
        }
        this.f3824i.add(action);
        if (loggingEnabled) {
            ab.m5389a("Hunter", "joined", request.m5518a(), ab.m5383a(this, "to "));
        }
    }

    void m5412b(C1252a action) {
        if (this.f3823h == action) {
            this.f3823h = null;
        } else if (this.f3824i != null) {
            this.f3824i.remove(action);
        }
        if (this.f3816a.f3916k) {
            ab.m5389a("Hunter", "removed", action.f3801b.m5518a(), ab.m5383a(this, "from "));
        }
    }

    boolean m5413c() {
        if (this.f3823h != null) {
            return false;
        }
        if ((this.f3824i == null || this.f3824i.isEmpty()) && this.f3826k != null && this.f3826k.cancel(false)) {
            return true;
        }
        return false;
    }

    boolean m5414d() {
        return this.f3826k != null && this.f3826k.isCancelled();
    }

    boolean m5415e() {
        return this.f3822g;
    }

    boolean m5410a(boolean airplaneMode, NetworkInfo info) {
        return false;
    }

    boolean m5416f() {
        return false;
    }

    Bitmap m5417g() {
        return this.f3825j;
    }

    String m5418h() {
        return this.f3820e;
    }

    C1300u m5419i() {
        return this.f3821f;
    }

    C1252a m5420j() {
        return this.f3823h;
    }

    C1295r m5421k() {
        return this.f3816a;
    }

    List m5422l() {
        return this.f3824i;
    }

    Exception m5423m() {
        return this.f3828m;
    }

    C1292d m5407a() {
        return this.f3827l;
    }

    static void m5404b(C1300u data) {
        String name = data.m5520c();
        StringBuilder builder = (StringBuilder) f3815p.get();
        builder.ensureCapacity("Picasso-".length() + name.length());
        builder.replace("Picasso-".length(), builder.length(), name);
        Thread.currentThread().setName(builder.toString());
    }

    static C1260c m5400a(Context context, C1295r picasso, C1276i dispatcher, C1266d cache, C1307x stats, C1252a action, C1254j downloader) {
        if (action.m5362c().f3945d != 0) {
            return new C1304w(context, picasso, dispatcher, cache, stats, action);
        }
        Uri uri = action.m5362c().f3944c;
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            if (Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && !uri.getPathSegments().contains("photo")) {
                return new C1269f(context, picasso, dispatcher, cache, stats, action);
            }
            if ("media".equals(uri.getAuthority())) {
                return new C1284o(context, picasso, dispatcher, cache, stats, action);
            }
            return new C1270g(context, picasso, dispatcher, cache, stats, action);
        } else if ("file".equals(scheme)) {
            if (uri.getPathSegments().isEmpty() || !"android_asset".equals(uri.getPathSegments().get(0))) {
                return new C1279k(context, picasso, dispatcher, cache, stats, action);
            }
            return new C1261b(context, picasso, dispatcher, cache, stats, action);
        } else if ("android.resource".equals(scheme)) {
            return new C1304w(context, picasso, dispatcher, cache, stats, action);
        } else {
            return new C1285p(picasso, dispatcher, cache, stats, action, downloader);
        }
    }

    static Options m5405c(C1300u data) {
        boolean justBounds = data.m5521d();
        boolean hasConfig = data.f3955n != null;
        Options options = null;
        if (justBounds || hasConfig) {
            options = new Options();
            options.inJustDecodeBounds = justBounds;
            if (hasConfig) {
                options.inPreferredConfig = data.f3955n;
            }
        }
        return options;
    }

    static boolean m5403a(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static void m5402a(int reqWidth, int reqHeight, Options options) {
        C1260c.m5401a(reqWidth, reqHeight, options.outWidth, options.outHeight, options);
    }

    static void m5401a(int reqWidth, int reqHeight, int width, int height, Options options) {
        int sampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int heightRatio = (int) Math.floor((double) (((float) height) / ((float) reqHeight)));
            int widthRatio = (int) Math.floor((double) (((float) width) / ((float) reqWidth)));
            if (heightRatio < widthRatio) {
                sampleSize = heightRatio;
            } else {
                sampleSize = widthRatio;
            }
        }
        options.inSampleSize = sampleSize;
        options.inJustDecodeBounds = false;
    }

    static Bitmap m5399a(List transformations, Bitmap result) {
        int i = 0;
        int count = transformations.size();
        while (i < count) {
            C1309z transformation = (C1309z) transformations.get(i);
            Bitmap newResult = transformation.m5548a(result);
            if (newResult == null) {
                StringBuilder builder = new StringBuilder().append("Transformation ").append(transformation.m5549a()).append(" returned null after ").append(i).append(" previous transformation(s).\n\nTransformation list:\n");
                for (C1309z t : transformations) {
                    builder.append(t.m5549a()).append('\n');
                }
                C1295r.f3906a.post(new C12632(builder));
                return null;
            } else if (newResult == result && result.isRecycled()) {
                C1295r.f3906a.post(new C12643(transformation));
                return null;
            } else if (newResult == result || result.isRecycled()) {
                result = newResult;
                i++;
            } else {
                C1295r.f3906a.post(new C12654(transformation));
                return null;
            }
        }
        return result;
    }

    static Bitmap m5398a(C1300u data, Bitmap result, int exifRotation) {
        int inWidth = result.getWidth();
        int inHeight = result.getHeight();
        int drawX = 0;
        int drawY = 0;
        int drawWidth = inWidth;
        int drawHeight = inHeight;
        Matrix matrix = new Matrix();
        if (data.m5523f()) {
            int targetWidth = data.f3947f;
            int targetHeight = data.f3948g;
            float targetRotation = data.f3951j;
            if (targetRotation != 0.0f) {
                if (data.f3954m) {
                    matrix.setRotate(targetRotation, data.f3952k, data.f3953l);
                } else {
                    matrix.setRotate(targetRotation);
                }
            }
            float widthRatio;
            float heightRatio;
            float scale;
            if (data.f3949h) {
                widthRatio = ((float) targetWidth) / ((float) inWidth);
                heightRatio = ((float) targetHeight) / ((float) inHeight);
                int newSize;
                if (widthRatio > heightRatio) {
                    scale = widthRatio;
                    newSize = (int) Math.ceil((double) (((float) inHeight) * (heightRatio / widthRatio)));
                    drawY = (inHeight - newSize) / 2;
                    drawHeight = newSize;
                } else {
                    scale = heightRatio;
                    newSize = (int) Math.ceil((double) (((float) inWidth) * (widthRatio / heightRatio)));
                    drawX = (inWidth - newSize) / 2;
                    drawWidth = newSize;
                }
                matrix.preScale(scale, scale);
            } else if (data.f3950i) {
                widthRatio = ((float) targetWidth) / ((float) inWidth);
                heightRatio = ((float) targetHeight) / ((float) inHeight);
                if (widthRatio < heightRatio) {
                    scale = widthRatio;
                } else {
                    scale = heightRatio;
                }
                matrix.preScale(scale, scale);
            } else if (!(targetWidth == 0 || targetHeight == 0 || (targetWidth == inWidth && targetHeight == inHeight))) {
                matrix.preScale(((float) targetWidth) / ((float) inWidth), ((float) targetHeight) / ((float) inHeight));
            }
        }
        if (exifRotation != 0) {
            matrix.preRotate((float) exifRotation);
        }
        Bitmap newResult = Bitmap.createBitmap(result, drawX, drawY, drawWidth, drawHeight, matrix, true);
        if (newResult == result) {
            return result;
        }
        result.recycle();
        return newResult;
    }
}
