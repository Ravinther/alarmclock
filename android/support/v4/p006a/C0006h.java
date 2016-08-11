package android.support.v4.p006a;

import android.content.Context;
import android.support.v4.p010d.C0140c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.a.h */
public class C0006h {
    int f32f;
    C0018a f33g;
    Context f34h;
    boolean f35i;
    boolean f36j;
    boolean f37k;
    boolean f38l;
    boolean f39m;

    /* renamed from: android.support.v4.a.h.a */
    public interface C0018a {
        void m107a(C0006h c0006h, Object obj);
    }

    public C0006h(Context context) {
        this.f35i = false;
        this.f36j = false;
        this.f37k = true;
        this.f38l = false;
        this.f39m = false;
        this.f34h = context.getApplicationContext();
    }

    public void m68b(Object data) {
        if (this.f33g != null) {
            this.f33g.m107a(this, data);
        }
    }

    public Context m70f() {
        return this.f34h;
    }

    public void m65a(int id, C0018a listener) {
        if (this.f33g != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f33g = listener;
        this.f32f = id;
    }

    public void m66a(C0018a listener) {
        if (this.f33g == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f33g != listener) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f33g = null;
        }
    }

    public boolean m71g() {
        return this.f35i;
    }

    public boolean m72h() {
        return this.f36j;
    }

    public boolean m73i() {
        return this.f37k;
    }

    public final void m74j() {
        this.f35i = true;
        this.f37k = false;
        this.f36j = false;
        m75k();
    }

    protected void m75k() {
    }

    public void m76l() {
        m64a();
    }

    protected void m64a() {
    }

    public void m77m() {
        this.f35i = false;
        m78n();
    }

    protected void m78n() {
    }

    public void m79o() {
        this.f36j = true;
        m80p();
    }

    protected void m80p() {
    }

    public void m81q() {
        m82r();
        this.f37k = true;
        this.f35i = false;
        this.f36j = false;
        this.f38l = false;
        this.f39m = false;
    }

    protected void m82r() {
    }

    public boolean m83s() {
        boolean res = this.f38l;
        this.f38l = false;
        this.f39m |= res;
        return res;
    }

    public void m84t() {
        this.f39m = false;
    }

    public void m85u() {
        if (this.f39m) {
            this.f38l = true;
        }
    }

    public void m86v() {
        if (this.f35i) {
            m76l();
        } else {
            this.f38l = true;
        }
    }

    public String m69c(Object data) {
        StringBuilder sb = new StringBuilder(64);
        C0140c.m548a(data, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        C0140c.m548a(this, sb);
        sb.append(" id=");
        sb.append(this.f32f);
        sb.append("}");
        return sb.toString();
    }

    public void m67a(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix);
        writer.print("mId=");
        writer.print(this.f32f);
        writer.print(" mListener=");
        writer.println(this.f33g);
        if (this.f35i || this.f38l || this.f39m) {
            writer.print(prefix);
            writer.print("mStarted=");
            writer.print(this.f35i);
            writer.print(" mContentChanged=");
            writer.print(this.f38l);
            writer.print(" mProcessingChange=");
            writer.println(this.f39m);
        }
        if (this.f36j || this.f37k) {
            writer.print(prefix);
            writer.print("mAbandoned=");
            writer.print(this.f36j);
            writer.print(" mReset=");
            writer.println(this.f37k);
        }
    }
}
