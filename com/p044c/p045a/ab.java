package com.p044c.p045a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.System;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/* renamed from: com.c.a.ab */
final class ab {
    static final StringBuilder f3813a;

    @TargetApi(11)
    /* renamed from: com.c.a.ab.a */
    private static class C1255a {
        static int m5373a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    @TargetApi(12)
    /* renamed from: com.c.a.ab.b */
    private static class C1256b {
        static int m5374a(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* renamed from: com.c.a.ab.c */
    private static class C1257c {
        static C1254j m5375a(Context context) {
            return new C1286q(context);
        }
    }

    /* renamed from: com.c.a.ab.d */
    private static class C1258d extends Thread {
        public C1258d(Runnable r) {
            super(r);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* renamed from: com.c.a.ab.e */
    static class C1259e implements ThreadFactory {
        C1259e() {
        }

        public Thread newThread(Runnable r) {
            return new C1258d(r);
        }
    }

    static {
        f3813a = new StringBuilder();
    }

    static int m5377a(Bitmap bitmap) {
        int result;
        if (VERSION.SDK_INT >= 12) {
            result = C1256b.m5374a(bitmap);
        } else {
            result = bitmap.getRowBytes() * bitmap.getHeight();
        }
        if (result >= 0) {
            return result;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static void m5386a() {
        if (!ab.m5392b()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static boolean m5392b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    static String m5382a(C1260c hunter) {
        return ab.m5383a(hunter, "");
    }

    static String m5383a(C1260c hunter, String prefix) {
        StringBuilder builder = new StringBuilder(prefix);
        C1252a action = hunter.m5420j();
        if (action != null) {
            builder.append(action.f3801b.m5518a());
        }
        List actions = hunter.m5422l();
        if (actions != null) {
            int count = actions.size();
            for (int i = 0; i < count; i++) {
                if (i > 0 || action != null) {
                    builder.append(", ");
                }
                builder.append(((C1252a) actions.get(i)).f3801b.m5518a());
            }
        }
        return builder.toString();
    }

    static void m5388a(String owner, String verb, String logId) {
        ab.m5389a(owner, verb, logId, "");
    }

    static void m5389a(String owner, String verb, String logId, String extras) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{owner, verb, logId, extras}));
    }

    static String m5384a(C1300u data) {
        String result = ab.m5385a(data, f3813a);
        f3813a.setLength(0);
        return result;
    }

    static String m5385a(C1300u data, StringBuilder builder) {
        if (data.f3944c != null) {
            String path = data.f3944c.toString();
            builder.ensureCapacity(path.length() + 50);
            builder.append(path);
        } else {
            builder.ensureCapacity(50);
            builder.append(data.f3945d);
        }
        builder.append('\n');
        if (data.f3951j != 0.0f) {
            builder.append("rotation:").append(data.f3951j);
            if (data.f3954m) {
                builder.append('@').append(data.f3952k).append('x').append(data.f3953l);
            }
            builder.append('\n');
        }
        if (data.f3947f != 0) {
            builder.append("resize:").append(data.f3947f).append('x').append(data.f3948g);
            builder.append('\n');
        }
        if (data.f3949h) {
            builder.append("centerCrop\n");
        } else if (data.f3950i) {
            builder.append("centerInside\n");
        }
        if (data.f3946e != null) {
            int count = data.f3946e.size();
            for (int i = 0; i < count; i++) {
                builder.append(((C1309z) data.f3946e.get(i)).m5549a());
                builder.append('\n');
            }
        }
        return builder.toString();
    }

    static void m5387a(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    static boolean m5390a(String header) {
        boolean z = true;
        if (header == null) {
            return false;
        }
        String[] parts = header.split(" ", 2);
        if ("CACHE".equals(parts[0])) {
            return true;
        }
        if (parts.length == 1) {
            return false;
        }
        try {
            if (!("CONDITIONAL_CACHE".equals(parts[0]) && Integer.parseInt(parts[1]) == 304)) {
                z = false;
            }
            return z;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static C1254j m5380a(Context context) {
        boolean okUrlFactory = false;
        try {
            Class.forName("com.squareup.okhttp.OkUrlFactory");
            okUrlFactory = true;
        } catch (ClassNotFoundException e) {
        }
        boolean okHttpClient = false;
        try {
            Class.forName("com.squareup.okhttp.OkHttpClient");
            okHttpClient = true;
        } catch (ClassNotFoundException e2) {
        }
        if (okHttpClient != okUrlFactory) {
            throw new RuntimeException("Picasso detected an unsupported OkHttp on the classpath.\nTo use OkHttp with this version of Picasso, you'll need:\n1. com.squareup.okhttp:okhttp:1.6.0 (or newer)\n2. com.squareup.okhttp:okhttp-urlconnection:1.6.0 (or newer)\nNote that OkHttp 2.0.0+ is supported!");
        } else if (okHttpClient) {
            return C1257c.m5375a(context);
        } else {
            return new aa(context);
        }
    }

    static File m5391b(Context context) {
        File cache = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!cache.exists()) {
            cache.mkdirs();
        }
        return cache;
    }

    static long m5378a(File dir) {
        long size = 5242880;
        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            size = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException e) {
        }
        return Math.max(Math.min(size, 52428800), 5242880);
    }

    static int m5395c(Context context) {
        ActivityManager am = (ActivityManager) ab.m5381a(context, "activity");
        boolean largeHeap = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = am.getMemoryClass();
        if (largeHeap && VERSION.SDK_INT >= 11) {
            memoryClass = C1255a.m5373a(am);
        }
        return (1048576 * memoryClass) / 7;
    }

    static boolean m5397d(Context context) {
        if (System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
            return true;
        }
        return false;
    }

    static Object m5381a(Context context, String service) {
        return context.getSystemService(service);
    }

    static boolean m5393b(Context context, String permission) {
        return context.checkCallingOrSelfPermission(permission) == 0;
    }

    static byte[] m5394b(InputStream input) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        while (true) {
            int n = input.read(buffer);
            if (-1 == n) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(buffer, 0, n);
        }
    }

    static boolean m5396c(InputStream stream) {
        byte[] fileHeaderBytes = new byte[12];
        if (stream.read(fileHeaderBytes, 0, 12) != 12) {
            return false;
        }
        if ("RIFF".equals(new String(fileHeaderBytes, 0, 4, "US-ASCII")) && "WEBP".equals(new String(fileHeaderBytes, 8, 4, "US-ASCII"))) {
            return true;
        }
        return false;
    }

    static int m5376a(Resources resources, C1300u data) {
        if (data.f3945d != 0 || data.f3944c == null) {
            return data.f3945d;
        }
        String pkg = data.f3944c.getAuthority();
        if (pkg == null) {
            throw new FileNotFoundException("No package provided: " + data.f3944c);
        }
        List segments = data.f3944c.getPathSegments();
        if (segments == null || segments.isEmpty()) {
            throw new FileNotFoundException("No path segments: " + data.f3944c);
        } else if (segments.size() == 1) {
            try {
                return Integer.parseInt((String) segments.get(0));
            } catch (NumberFormatException e) {
                throw new FileNotFoundException("Last path segment is not a resource ID: " + data.f3944c);
            }
        } else if (segments.size() == 2) {
            return resources.getIdentifier((String) segments.get(1), (String) segments.get(0), pkg);
        } else {
            throw new FileNotFoundException("More than two path segments: " + data.f3944c);
        }
    }

    static Resources m5379a(Context context, C1300u data) {
        if (data.f3945d != 0 || data.f3944c == null) {
            return context.getResources();
        }
        String pkg = data.f3944c.getAuthority();
        if (pkg == null) {
            throw new FileNotFoundException("No package provided: " + data.f3944c);
        }
        try {
            return context.getPackageManager().getResourcesForApplication(pkg);
        } catch (NameNotFoundException e) {
            throw new FileNotFoundException("Unable to obtain resources for package: " + data.f3944c);
        }
    }
}
