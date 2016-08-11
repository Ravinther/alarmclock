package com.anglelabs.alarmclock.redesign.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.view.View;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.l */
public class C0831l {
    private static final C0861x f2382a;

    static {
        f2382a = new C0861x();
    }

    public static BitmapDrawable m3902a(Resources res, int resId, Activity activity) {
        return C0831l.m3903a(res, resId, activity.getWindowManager().getDefaultDisplay());
    }

    @SuppressLint({"NewApi"})
    public static BitmapDrawable m3903a(Resources res, int resId, Display display) {
        int width;
        int height;
        Point size = new Point();
        if (C0810h.f2128b) {
            display.getSize(size);
            width = size.x;
            height = size.y;
        } else {
            width = display.getWidth();
            height = display.getHeight();
        }
        return new BitmapDrawable(res, C0831l.m3901a(res, resId, width, height));
    }

    public static Bitmap m3901a(Resources res, int resId, int reqWidth, int reqHeight) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = C0831l.m3900a(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    private static int m3900a(Options options, int reqWidth, int reqHeight) {
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while (halfHeight / inSampleSize > reqHeight && halfWidth / inSampleSize > reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

    public static void m3905a(Activity activity, int resId) {
        try {
            activity.getWindow().setBackgroundDrawable(f2382a.m4045a(activity, resId));
        } catch (OutOfMemoryError e) {
            C0850q.m3987b("out of memory when trying to set background, calling GC and retrying");
            System.gc();
            throw new Exception();
        }
    }

    public static void m3904a() {
        f2382a.m4046a();
    }

    @SuppressLint({"NewApi"})
    public static void m3906a(View view, BitmapDrawable drawable) {
        try {
            if (C0810h.f2131e) {
                view.setBackground(drawable);
            } else {
                view.setBackgroundDrawable(drawable);
            }
        } catch (OutOfMemoryError e) {
            C0850q.m3987b("out of memory when trying to set background, calling GC and retrying");
            System.gc();
            throw new Exception();
        }
    }
}
