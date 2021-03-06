package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.C2311l.C2288a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class cz implements C2263k {
    private final Map aap;
    private final int aaq;
    private final C2288a aar;
    private int aas;

    cz(int i, C2288a c2288a) {
        this.aap = new HashMap();
        this.aaq = i;
        this.aar = c2288a;
    }

    public synchronized void m9505e(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.aas += this.aar.sizeOf(obj, obj2);
        if (this.aas > this.aaq) {
            Iterator it = this.aap.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.aas -= this.aar.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.aas <= this.aaq) {
                    break;
                }
            }
        }
        this.aap.put(obj, obj2);
    }

    public synchronized Object get(Object key) {
        return this.aap.get(key);
    }
}
