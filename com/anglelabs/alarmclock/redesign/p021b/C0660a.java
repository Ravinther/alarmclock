package com.anglelabs.alarmclock.redesign.p021b;

import android.content.Context;
import android.support.v4.p006a.C0007a;

/* renamed from: com.anglelabs.alarmclock.redesign.b.a */
public abstract class C0660a extends C0007a {
    private Object f1738n;

    public C0660a(Context context) {
        super(context);
    }

    public void m3010w() {
    }

    public void m3011x() {
    }

    public void m3005b(Object data) {
        if (m73i() && data != null) {
            m3006d(data);
        }
        Object oldData = this.f1738n;
        this.f1738n = data;
        if (m71g()) {
            super.m68b(data);
        }
        if (oldData != null) {
            m3006d(oldData);
        }
    }

    protected void m3007k() {
        if (this.f1738n != null) {
            m3005b(this.f1738n);
        }
        m3010w();
        if (m83s() || this.f1738n == null) {
            m76l();
        }
    }

    protected void m3008n() {
        m92b();
    }

    protected void m3009r() {
        super.m82r();
        m3008n();
        if (this.f1738n != null) {
            m3006d(this.f1738n);
            this.f1738n = null;
        }
        m3011x();
    }

    public void m3004a(Object data) {
        super.m89a(data);
        m3006d(data);
    }

    protected void m3006d(Object data) {
    }
}
