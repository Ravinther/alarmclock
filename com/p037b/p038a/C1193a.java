package com.p037b.p038a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* renamed from: com.b.a.a */
public abstract class C1193a implements Cloneable {
    ArrayList f3616a;

    /* renamed from: com.b.a.a.a */
    public interface C0672a {
        void m3043a(C1193a c1193a);

        void m3044b(C1193a c1193a);

        void m3045c(C1193a c1193a);

        void m3046d(C1193a c1193a);
    }

    public abstract C1193a m4998a(long j);

    public abstract void m5000a(Interpolator interpolator);

    public abstract boolean m5004c();

    public C1193a() {
        this.f3616a = null;
    }

    public /* synthetic */ Object clone() {
        return m5007f();
    }

    public void m4999a() {
    }

    public void m5002b() {
    }

    public boolean m5005d() {
        return m5004c();
    }

    public void m5001a(C0672a listener) {
        if (this.f3616a == null) {
            this.f3616a = new ArrayList();
        }
        this.f3616a.add(listener);
    }

    public void m5003b(C0672a listener) {
        if (this.f3616a != null) {
            this.f3616a.remove(listener);
            if (this.f3616a.size() == 0) {
                this.f3616a = null;
            }
        }
    }

    public ArrayList m5006e() {
        return this.f3616a;
    }

    public C1193a m5007f() {
        try {
            C1193a anim = (C1193a) super.clone();
            if (this.f3616a != null) {
                ArrayList oldListeners = this.f3616a;
                anim.f3616a = new ArrayList();
                int numListeners = oldListeners.size();
                for (int i = 0; i < numListeners; i++) {
                    anim.f3616a.add(oldListeners.get(i));
                }
            }
            return anim;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
