package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public abstract class kp extends kt {
    protected List adU;

    public final Object m6621a(kq kqVar) {
        return kqVar.m8942f(this.adU);
    }

    public void m6622a(ko koVar) {
        int size = this.adU == null ? 0 : this.adU.size();
        for (int i = 0; i < size; i++) {
            kv kvVar = (kv) this.adU.get(i);
            koVar.da(kvVar.tag);
            koVar.m8937p(kvVar.adZ);
        }
    }

    protected final boolean m6623a(kn knVar, int i) {
        int position = knVar.getPosition();
        if (!knVar.cQ(i)) {
            return false;
        }
        if (this.adU == null) {
            this.adU = new ArrayList();
        }
        this.adU.add(new kv(i, knVar.m8906h(position, knVar.getPosition() - position)));
        return true;
    }

    protected int mx() {
        int i = 0;
        for (int i2 = 0; i2 < (this.adU == null ? 0 : this.adU.size()); i2++) {
            kv kvVar = (kv) this.adU.get(i2);
            i = (i + ko.db(kvVar.tag)) + kvVar.adZ.length;
        }
        return i;
    }
}
