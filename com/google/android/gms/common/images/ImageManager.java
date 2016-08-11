package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.C1482a.C1481a;
import com.google.android.gms.common.images.C1482a.C1483b;
import com.google.android.gms.common.images.C1482a.C1484c;
import com.google.android.gms.internal.fa;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fu;
import com.google.android.gms.internal.gr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static final Object BY;
    private static HashSet BZ;
    private static ImageManager Ca;
    private static ImageManager Cb;
    private final ExecutorService Cc;
    private final C1476b Cd;
    private final fa Ce;
    private final Map Cf;
    private final Map Cg;
    private final Context mContext;
    private final Handler mHandler;

    private final class ImageReceiver extends ResultReceiver {
        private final ArrayList Ch;
        final /* synthetic */ ImageManager Ci;
        private final Uri mUri;

        ImageReceiver(ImageManager imageManager, Uri uri) {
            this.Ci = imageManager;
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
            this.Ch = new ArrayList();
        }

        public void m6280b(C1482a c1482a) {
            fb.aj("ImageReceiver.addImageRequest() must be called in the main thread");
            this.Ch.add(c1482a);
        }

        public void m6281c(C1482a c1482a) {
            fb.aj("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.Ch.remove(c1482a);
        }

        public void ey() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            this.Ci.mContext.sendBroadcast(intent);
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            this.Ci.Cc.execute(new C1477c(this.Ci, this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.a */
    private static final class C1475a {
        static int m6282a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.b */
    private static final class C1476b extends fu {
        public C1476b(Context context) {
            super(C1476b.m6284w(context));
        }

        private static int m6284w(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = (((context.getApplicationInfo().flags & 1048576) != 0 ? 1 : null) == null || !gr.fu()) ? activityManager.getMemoryClass() : C1475a.m6282a(activityManager);
            return (int) (((float) (memoryClass * 1048576)) * 0.33f);
        }

        protected int m6285a(C1481a c1481a, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void m6286a(boolean z, C1481a c1481a, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, c1481a, bitmap, bitmap2);
        }

        protected /* synthetic */ void entryRemoved(boolean x0, Object x1, Object x2, Object x3) {
            m6286a(x0, (C1481a) x1, (Bitmap) x2, (Bitmap) x3);
        }

        protected /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m6285a((C1481a) x0, (Bitmap) x1);
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.c */
    private final class C1477c implements Runnable {
        final /* synthetic */ ImageManager Ci;
        private final ParcelFileDescriptor Cj;
        private final Uri mUri;

        public C1477c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.Ci = imageManager;
            this.mUri = uri;
            this.Cj = parcelFileDescriptor;
        }

        public void run() {
            fb.ak("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.Cj != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.Cj.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.Cj.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            this.Ci.mHandler.post(new C1480f(this.Ci, this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.d */
    private final class C1478d implements Runnable {
        final /* synthetic */ ImageManager Ci;
        private final C1482a Ck;

        public C1478d(ImageManager imageManager, C1482a c1482a) {
            this.Ci = imageManager;
            this.Ck = c1482a;
        }

        public void run() {
            fb.aj("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) this.Ci.Cf.get(this.Ck);
            if (imageReceiver != null) {
                this.Ci.Cf.remove(this.Ck);
                imageReceiver.m6281c(this.Ck);
            }
            C1481a c1481a = this.Ck.Cm;
            if (c1481a.uri == null) {
                this.Ck.m6306a(this.Ci.mContext, this.Ci.Ce, true);
                return;
            }
            Bitmap a = this.Ci.m6289a(c1481a);
            if (a != null) {
                this.Ck.m6304a(this.Ci.mContext, a, true);
                return;
            }
            this.Ck.m6305a(this.Ci.mContext, this.Ci.Ce);
            imageReceiver = (ImageReceiver) this.Ci.Cg.get(c1481a.uri);
            if (imageReceiver == null) {
                imageReceiver = new ImageReceiver(this.Ci, c1481a.uri);
                this.Ci.Cg.put(c1481a.uri, imageReceiver);
            }
            imageReceiver.m6280b(this.Ck);
            if (!(this.Ck instanceof C1484c)) {
                this.Ci.Cf.put(this.Ck, imageReceiver);
            }
            synchronized (ImageManager.BY) {
                if (!ImageManager.BZ.contains(c1481a.uri)) {
                    ImageManager.BZ.add(c1481a.uri);
                    imageReceiver.ey();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.e */
    private static final class C1479e implements ComponentCallbacks2 {
        private final C1476b Cd;

        public C1479e(C1476b c1476b) {
            this.Cd = c1476b;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.Cd.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.Cd.evictAll();
            } else if (level >= 20) {
                this.Cd.trimToSize(this.Cd.size() / 2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.images.ImageManager.f */
    private final class C1480f implements Runnable {
        private final CountDownLatch AD;
        final /* synthetic */ ImageManager Ci;
        private boolean Cl;
        private final Bitmap mBitmap;
        private final Uri mUri;

        public C1480f(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.Ci = imageManager;
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.Cl = z;
            this.AD = countDownLatch;
        }

        private void m6287a(ImageReceiver imageReceiver, boolean z) {
            ArrayList a = imageReceiver.Ch;
            int size = a.size();
            for (int i = 0; i < size; i++) {
                C1482a c1482a = (C1482a) a.get(i);
                if (z) {
                    c1482a.m6304a(this.Ci.mContext, this.mBitmap, false);
                } else {
                    c1482a.m6306a(this.Ci.mContext, this.Ci.Ce, false);
                }
                if (!(c1482a instanceof C1484c)) {
                    this.Ci.Cf.remove(c1482a);
                }
            }
        }

        public void run() {
            fb.aj("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (this.Ci.Cd != null) {
                if (this.Cl) {
                    this.Ci.Cd.evictAll();
                    System.gc();
                    this.Cl = false;
                    this.Ci.mHandler.post(this);
                    return;
                } else if (z) {
                    this.Ci.Cd.put(new C1481a(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.Ci.Cg.remove(this.mUri);
            if (imageReceiver != null) {
                m6287a(imageReceiver, z);
            }
            this.AD.countDown();
            synchronized (ImageManager.BY) {
                ImageManager.BZ.remove(this.mUri);
            }
        }
    }

    static {
        BY = new Object();
        BZ = new HashSet();
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.Cc = Executors.newFixedThreadPool(4);
        if (withMemoryCache) {
            this.Cd = new C1476b(this.mContext);
            if (gr.fx()) {
                ev();
            }
        } else {
            this.Cd = null;
        }
        this.Ce = new fa();
        this.Cf = new HashMap();
        this.Cg = new HashMap();
    }

    private Bitmap m6289a(C1481a c1481a) {
        return this.Cd == null ? null : (Bitmap) this.Cd.get(c1481a);
    }

    public static ImageManager m6290a(Context context, boolean z) {
        if (z) {
            if (Cb == null) {
                Cb = new ImageManager(context, true);
            }
            return Cb;
        }
        if (Ca == null) {
            Ca = new ImageManager(context, false);
        }
        return Ca;
    }

    public static ImageManager create(Context context) {
        return m6290a(context, false);
    }

    private void ev() {
        this.mContext.registerComponentCallbacks(new C1479e(this.Cd));
    }

    public void m6298a(C1482a c1482a) {
        fb.aj("ImageManager.loadImage() must be called in the main thread");
        new C1478d(this, c1482a).run();
    }

    public void loadImage(ImageView imageView, int resId) {
        m6298a(new C1483b(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        m6298a(new C1483b(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        C1482a c1483b = new C1483b(imageView, uri);
        c1483b.m6301J(defaultResId);
        m6298a(c1483b);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        m6298a(new C1484c(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        C1482a c1484c = new C1484c(listener, uri);
        c1484c.m6301J(defaultResId);
        m6298a(c1484c);
    }
}
