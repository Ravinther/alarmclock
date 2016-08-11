package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1817d.C1816a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj {
    private final Set XU;
    private final String XV;

    public aj(String str, String... strArr) {
        this.XV = str;
        this.XU = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.XU.add(add);
        }
    }

    boolean m9310a(Set set) {
        return set.containsAll(this.XU);
    }

    public abstract boolean jX();

    public String kB() {
        return this.XV;
    }

    public Set kC() {
        return this.XU;
    }

    public abstract C1816a m9311x(Map map);
}
