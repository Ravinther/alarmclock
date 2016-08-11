package com.anglelabs.alarmclock.redesign.p021b.p022b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.b.b.b */
public abstract class C0517b extends BaseAdapter {
    private final Context f1385a;
    protected final LayoutInflater f1386g;
    protected List f1387h;
    protected final Object f1388i;

    public C0517b(Context context) {
        this.f1387h = new ArrayList();
        this.f1388i = new Object();
        this.f1385a = context;
        this.f1386g = LayoutInflater.from(context);
    }

    public C0517b(Context context, List data) {
        this.f1387h = new ArrayList();
        this.f1388i = new Object();
        this.f1385a = context;
        this.f1386g = LayoutInflater.from(context);
        this.f1387h = data;
    }

    public Bundle m2456a(Bundle bundle) {
        return bundle;
    }

    public void m2459b(Bundle bundle) {
    }

    protected Context m2463g() {
        return this.f1385a;
    }

    public int getCount() {
        int size;
        synchronized (this.f1388i) {
            size = this.f1387h.size();
        }
        return size;
    }

    public List m2464h() {
        List list;
        synchronized (this.f1388i) {
            list = this.f1387h;
        }
        return list;
    }

    public Object getItem(int position) {
        Object obj;
        synchronized (this.f1388i) {
            obj = this.f1387h.get(position);
        }
        return obj;
    }

    public void m2465i() {
        synchronized (this.f1388i) {
            this.f1387h.clear();
            notifyDataSetChanged();
        }
    }

    public void m2457a(Object item) {
        synchronized (this.f1388i) {
            this.f1387h.add(item);
            notifyDataSetChanged();
        }
    }

    public void m2461b(List items) {
        synchronized (this.f1388i) {
            m2465i();
            this.f1387h.addAll(items);
            notifyDataSetChanged();
        }
    }

    public void m2460b(Object object) {
        synchronized (this.f1388i) {
            this.f1387h.remove(object);
            notifyDataSetChanged();
        }
    }

    public void m2462c(List objects) {
        synchronized (this.f1388i) {
            this.f1387h.removeAll(objects);
            notifyDataSetChanged();
        }
    }

    public void m2458a(Object object, int index) {
        synchronized (this.f1388i) {
            this.f1387h.add(index, object);
            notifyDataSetChanged();
        }
    }
}
