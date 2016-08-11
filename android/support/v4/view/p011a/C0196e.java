package android.support.v4.view.p011a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.p011a.C0198f.C0189a;
import android.support.v4.view.p011a.C0200g.C0193a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.view.a.e */
public class C0196e {
    private static final C0188a f469a;
    private final Object f470b;

    /* renamed from: android.support.v4.view.a.e.a */
    interface C0188a {
        Object m917a(C0196e c0196e);
    }

    /* renamed from: android.support.v4.view.a.e.d */
    static class C0191d implements C0188a {
        C0191d() {
        }

        public Object m924a(C0196e compat) {
            return null;
        }
    }

    /* renamed from: android.support.v4.view.a.e.b */
    static class C0192b extends C0191d {

        /* renamed from: android.support.v4.view.a.e.b.1 */
        class C01901 implements C0189a {
            final /* synthetic */ C0196e f465a;
            final /* synthetic */ C0192b f466b;

            C01901(C0192b c0192b, C0196e c0196e) {
                this.f466b = c0192b;
                this.f465a = c0196e;
            }

            public boolean m923a(int virtualViewId, int action, Bundle arguments) {
                return this.f465a.m938a(virtualViewId, action, arguments);
            }

            public List m922a(String text, int virtualViewId) {
                List compatInfos = this.f465a.m937a(text, virtualViewId);
                List infos = new ArrayList();
                int infoCount = compatInfos.size();
                for (int i = 0; i < infoCount; i++) {
                    infos.add(((C0184a) compatInfos.get(i)).m837a());
                }
                return infos;
            }

            public Object m921a(int virtualViewId) {
                C0184a compatInfo = this.f465a.m935a(virtualViewId);
                if (compatInfo == null) {
                    return null;
                }
                return compatInfo.m837a();
            }
        }

        C0192b() {
        }

        public Object m925a(C0196e compat) {
            return C0198f.m940a(new C01901(this, compat));
        }
    }

    /* renamed from: android.support.v4.view.a.e.c */
    static class C0195c extends C0191d {

        /* renamed from: android.support.v4.view.a.e.c.1 */
        class C01941 implements C0193a {
            final /* synthetic */ C0196e f467a;
            final /* synthetic */ C0195c f468b;

            C01941(C0195c c0195c, C0196e c0196e) {
                this.f468b = c0195c;
                this.f467a = c0196e;
            }

            public boolean m932a(int virtualViewId, int action, Bundle arguments) {
                return this.f467a.m938a(virtualViewId, action, arguments);
            }

            public List m931a(String text, int virtualViewId) {
                List compatInfos = this.f467a.m937a(text, virtualViewId);
                List infos = new ArrayList();
                int infoCount = compatInfos.size();
                for (int i = 0; i < infoCount; i++) {
                    infos.add(((C0184a) compatInfos.get(i)).m837a());
                }
                return infos;
            }

            public Object m930a(int virtualViewId) {
                C0184a compatInfo = this.f467a.m935a(virtualViewId);
                if (compatInfo == null) {
                    return null;
                }
                return compatInfo.m837a();
            }

            public Object m933b(int focus) {
                C0184a compatInfo = this.f467a.m939b(focus);
                if (compatInfo == null) {
                    return null;
                }
                return compatInfo.m837a();
            }
        }

        C0195c() {
        }

        public Object m934a(C0196e compat) {
            return C0200g.m941a(new C01941(this, compat));
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f469a = new C0195c();
        } else if (VERSION.SDK_INT >= 16) {
            f469a = new C0192b();
        } else {
            f469a = new C0191d();
        }
    }

    public C0196e() {
        this.f470b = f469a.m917a(this);
    }

    public C0196e(Object provider) {
        this.f470b = provider;
    }

    public Object m936a() {
        return this.f470b;
    }

    public C0184a m935a(int virtualViewId) {
        return null;
    }

    public boolean m938a(int virtualViewId, int action, Bundle arguments) {
        return false;
    }

    public List m937a(String text, int virtualViewId) {
        return null;
    }

    public C0184a m939b(int focus) {
        return null;
    }
}
