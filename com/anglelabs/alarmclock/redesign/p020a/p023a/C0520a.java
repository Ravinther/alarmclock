package com.anglelabs.alarmclock.redesign.p020a.p023a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a.C0519a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.a.a.a */
public abstract class C0520a extends C0518a implements C0519a {
    ArrayList f1391a;
    final ArrayList f1392b;
    protected final LayoutInflater f1393c;
    String f1394d;

    abstract boolean m2476b();

    public C0520a(Context context) {
        super(context);
        this.f1391a = new ArrayList();
        this.f1392b = new ArrayList();
        this.f1393c = LayoutInflater.from(context);
    }

    public void m2473a(String selectedItemName) {
        this.f1394d = selectedItemName;
    }

    protected String m2472a() {
        return this.f1394d;
    }

    protected boolean m2477b(String string) {
        return !TextUtils.isEmpty(string) && string.equals(m2472a());
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public void m2474a(List selectedPositions) {
        if (selectedPositions != null) {
            for (Integer position : selectedPositions) {
                if (getCount() > position.intValue()) {
                    this.f1391a.add(getItem(position.intValue()));
                    this.f1392b.add(position);
                }
            }
        }
    }

    public void m2475a(int... positions) {
        for (int i : positions) {
            Object item = getItem(i);
            if (item == null || this.f1391a == null || !this.f1391a.contains(item)) {
                if (!m2476b()) {
                    this.f1391a.clear();
                    this.f1392b.clear();
                }
                this.f1391a.add(item);
                this.f1392b.add(Integer.valueOf(i));
            } else {
                this.f1391a.remove(item);
                if (this.f1392b.size() > i && this.f1392b.contains(Integer.valueOf(i))) {
                    this.f1392b.remove(i);
                }
            }
        }
    }

    public ArrayList m2478c() {
        return this.f1391a;
    }

    public ArrayList m2479d() {
        return this.f1392b;
    }
}
