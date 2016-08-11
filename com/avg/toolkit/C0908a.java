package com.avg.toolkit;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* renamed from: com.avg.toolkit.a */
public final class C0908a {

    /* renamed from: com.avg.toolkit.a.1 */
    static class C09001 implements Callable {
        final /* synthetic */ ClassLoader f2662a;
        final /* synthetic */ String f2663b;
        final /* synthetic */ String f2664c;

        C09001(ClassLoader classLoader, String str, String str2) {
            this.f2662a = classLoader;
            this.f2663b = str;
            this.f2664c = str2;
        }

        public /* synthetic */ Object call() {
            return m4147a();
        }

        public InputStream m4147a() {
            InputStream in = this.f2662a.getResourceAsStream(this.f2663b);
            if (in != null) {
                return in;
            }
            throw new NotFoundException(this.f2664c);
        }
    }

    /* renamed from: com.avg.toolkit.a.2 */
    static class C09012 implements Callable {
        final /* synthetic */ Context f2665a;
        final /* synthetic */ int f2666b;

        C09012(Context context, int i) {
            this.f2665a = context;
            this.f2666b = i;
        }

        public /* synthetic */ Object call() {
            return m4148a();
        }

        public InputStream m4148a() {
            return this.f2665a.getApplicationContext().getResources().openRawResource(this.f2666b);
        }
    }

    private C0908a() {
    }

    public static Callable m4169a(String path) {
        if (path.startsWith("res/raw/")) {
            String fullPath = "com/avg/toolkit/" + path;
            ClassLoader loader = C0908a.class.getClassLoader();
            if (loader.getResourceAsStream(fullPath) != null) {
                return new C09001(loader, fullPath, path);
            }
            throw new NotFoundException(path);
        }
        throw new IllegalArgumentException();
    }

    public static Callable m4168a(Context context, int resId) {
        try {
            context.getApplicationContext().getResources().openRawResource(resId).close();
            return new C09012(context, resId);
        } catch (IOException e) {
            throw new NotFoundException();
        }
    }
}
