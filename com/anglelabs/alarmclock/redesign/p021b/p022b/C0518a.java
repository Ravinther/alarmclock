package com.anglelabs.alarmclock.redesign.p021b.p022b;

import android.content.Context;
import android.util.SparseArray;
import com.anglelabs.alarmclock.redesign.utils.C0853r.C0852a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.b.b.a */
public abstract class C0518a extends C0517b {
    private final SparseArray f1389a;
    protected C0852a f1390f;

    /* renamed from: com.anglelabs.alarmclock.redesign.b.b.a.a */
    public interface C0519a {
        void m2470a(List list);

        ArrayList m2471d();
    }

    public C0518a(Context context) {
        super(context);
        this.f1389a = new SparseArray();
    }

    public void m2467a(C0852a multiSelectionController) {
        this.f1390f = multiSelectionController;
    }

    public long m2466a(int position) {
        if (position < 0 || position >= this.h.size()) {
            return -1;
        }
        long indexOfValue;
        synchronized (this.i) {
            indexOfValue = (long) this.f1389a.indexOfValue(this.h.get(position));
        }
        return indexOfValue;
    }

    public boolean hasStableIds() {
        return true;
    }

    public void m2469f() {
        synchronized (this.i) {
            this.f1389a.clear();
            for (int i = 0; i < this.h.size(); i++) {
                this.f1389a.put(i, this.h.get(i));
            }
        }
    }

    public void m2468b(List items) {
        synchronized (this.i) {
            m2465i();
            this.h.addAll(items);
            m2469f();
            notifyDataSetChanged();
        }
    }
}
