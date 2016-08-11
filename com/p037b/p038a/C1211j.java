package com.p037b.p038a;

import android.view.View;
import com.p037b.p062b.C1212c;
import com.p037b.p063c.p064a.C1236a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.b.a.j */
public final class C1211j extends C1210n {
    private static final Map f3695h;
    private Object f3696i;
    private String f3697j;
    private C1212c f3698k;

    public /* synthetic */ C1193a m5122a(long x0) {
        return m5129b(x0);
    }

    public /* synthetic */ C1210n m5130c(long x0) {
        return m5129b(x0);
    }

    public /* synthetic */ Object clone() {
        return m5133h();
    }

    public /* synthetic */ C1193a m5131f() {
        return m5133h();
    }

    public /* synthetic */ C1210n m5134i() {
        return m5133h();
    }

    static {
        f3695h = new HashMap();
        f3695h.put("alpha", C1224k.f3701a);
        f3695h.put("pivotX", C1224k.f3702b);
        f3695h.put("pivotY", C1224k.f3703c);
        f3695h.put("translationX", C1224k.f3704d);
        f3695h.put("translationY", C1224k.f3705e);
        f3695h.put("rotation", C1224k.f3706f);
        f3695h.put("rotationX", C1224k.f3707g);
        f3695h.put("rotationY", C1224k.f3708h);
        f3695h.put("scaleX", C1224k.f3709i);
        f3695h.put("scaleY", C1224k.f3710j);
        f3695h.put("scrollX", C1224k.f3711k);
        f3695h.put("scrollY", C1224k.f3712l);
        f3695h.put("x", C1224k.f3713m);
        f3695h.put("y", C1224k.f3714n);
    }

    public void m5126a(String propertyName) {
        if (this.f != null) {
            C1226l valuesHolder = this.f[0];
            String oldName = valuesHolder.m5218c();
            valuesHolder.m5213a(propertyName);
            this.g.remove(oldName);
            this.g.put(propertyName, valuesHolder);
        }
        this.f3697j = propertyName;
        this.e = false;
    }

    public void m5125a(C1212c property) {
        if (this.f != null) {
            C1226l valuesHolder = this.f[0];
            String oldName = valuesHolder.m5218c();
            valuesHolder.m5210a(property);
            this.g.remove(oldName);
            this.g.put(this.f3697j, valuesHolder);
        }
        if (this.f3698k != null) {
            this.f3697j = property.m5136a();
        }
        this.f3698k = property;
        this.e = false;
    }

    private C1211j(Object target, String propertyName) {
        this.f3696i = target;
        m5126a(propertyName);
    }

    public static C1211j m5120a(Object target, String propertyName, int... values) {
        C1211j anim = new C1211j(target, propertyName);
        anim.m5128a(values);
        return anim;
    }

    public static C1211j m5119a(Object target, String propertyName, float... values) {
        C1211j anim = new C1211j(target, propertyName);
        anim.m5127a(values);
        return anim;
    }

    public static C1211j m5121a(Object target, C1226l... values) {
        C1211j anim = new C1211j();
        anim.f3696i = target;
        anim.m5105a(values);
        return anim;
    }

    public void m5128a(int... values) {
        if (this.f != null && this.f.length != 0) {
            super.m5104a(values);
        } else if (this.f3698k != null) {
            m5105a(C1226l.m5201a(this.f3698k, values));
        } else {
            m5105a(C1226l.m5203a(this.f3697j, values));
        }
    }

    public void m5127a(float... values) {
        if (this.f != null && this.f.length != 0) {
            super.m5103a(values);
        } else if (this.f3698k != null) {
            m5105a(C1226l.m5200a(this.f3698k, values));
        } else {
            m5105a(C1226l.m5202a(this.f3697j, values));
        }
    }

    public void m5123a() {
        super.m5099a();
    }

    void m5132g() {
        if (!this.e) {
            if (this.f3698k == null && C1236a.f3738a && (this.f3696i instanceof View) && f3695h.containsKey(this.f3697j)) {
                m5125a((C1212c) f3695h.get(this.f3697j));
            }
            for (C1226l a : this.f) {
                a.m5212a(this.f3696i);
            }
            super.m5114g();
        }
    }

    public C1211j m5129b(long duration) {
        super.m5107c(duration);
        return this;
    }

    void m5124a(float fraction) {
        super.m5100a(fraction);
        for (C1226l b : this.f) {
            b.m5217b(this.f3696i);
        }
    }

    public C1211j m5133h() {
        return (C1211j) super.m5115i();
    }

    public String toString() {
        String returnVal = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f3696i;
        if (this.f != null) {
            for (C1226l c1226l : this.f) {
                returnVal = returnVal + "\n    " + c1226l.toString();
            }
        }
        return returnVal;
    }
}
