package com.google.android.gms.internal;

import com.mopub.mobileads.C2625R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class kq {
    protected final Class adV;
    protected final boolean adW;
    protected final int tag;
    protected final int type;

    private kq(int i, Class cls, int i2, boolean z) {
        this.type = i;
        this.adV = cls;
        this.tag = i2;
        this.adW = z;
    }

    public static kq m8940a(int i, Class cls, int i2) {
        return new kq(i, cls, i2, false);
    }

    protected void m8941a(kv kvVar, List list) {
        list.add(m8943o(kn.m8902n(kvVar.adZ)));
    }

    protected boolean dd(int i) {
        return i == this.tag;
    }

    final Object m8942f(List list) {
        int i = 0;
        if (list == null) {
            return null;
        }
        kv kvVar;
        if (this.adW) {
            int i2;
            List arrayList = new ArrayList();
            for (i2 = 0; i2 < list.size(); i2++) {
                kvVar = (kv) list.get(i2);
                if (dd(kvVar.tag) && kvVar.adZ.length != 0) {
                    m8941a(kvVar, arrayList);
                }
            }
            i2 = arrayList.size();
            if (i2 == 0) {
                return null;
            }
            Object cast = this.adV.cast(Array.newInstance(this.adV.getComponentType(), i2));
            while (i < i2) {
                Array.set(cast, i, arrayList.get(i));
                i++;
            }
            return cast;
        }
        i = list.size() - 1;
        kv kvVar2 = null;
        while (kvVar2 == null && i >= 0) {
            kvVar = (kv) list.get(i);
            if (!dd(kvVar.tag) || kvVar.adZ.length == 0) {
                kvVar = kvVar2;
            }
            i--;
            kvVar2 = kvVar;
        }
        return kvVar2 == null ? null : this.adV.cast(m8943o(kn.m8902n(kvVar2.adZ)));
    }

    protected Object m8943o(kn knVar) {
        Class componentType = this.adW ? this.adV.getComponentType() : this.adV;
        try {
            kt ktVar;
            switch (this.type) {
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    ktVar = (kt) componentType.newInstance();
                    knVar.m8905a(ktVar, kw.df(this.tag));
                    return ktVar;
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    ktVar = (kt) componentType.newInstance();
                    knVar.m8904a(ktVar);
                    return ktVar;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }
}
