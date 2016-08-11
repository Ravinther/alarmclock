package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1788c.C1779b;
import com.google.android.gms.internal.C1788c.C1782e;
import com.google.android.gms.internal.C1788c.C1783f;
import com.google.android.gms.internal.C1788c.C1784g;
import com.google.android.gms.internal.C1788c.C1785h;
import com.google.android.gms.internal.C1817d.C1816a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cq {

    /* renamed from: com.google.android.gms.tagmanager.cq.a */
    public static class C2281a {
        private final Map Zp;
        private final C1816a Zq;

        private C2281a(Map map, C1816a c1816a) {
            this.Zp = map;
            this.Zq = c1816a;
        }

        public static C2282b ld() {
            return new C2282b();
        }

        public void m9444a(String str, C1816a c1816a) {
            this.Zp.put(str, c1816a);
        }

        public Map le() {
            return Collections.unmodifiableMap(this.Zp);
        }

        public C1816a lf() {
            return this.Zq;
        }

        public String toString() {
            return "Properties: " + le() + " pushAfterEvaluate: " + this.Zq;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.b */
    public static class C2282b {
        private final Map Zp;
        private C1816a Zq;

        private C2282b() {
            this.Zp = new HashMap();
        }

        public C2282b m9445b(String str, C1816a c1816a) {
            this.Zp.put(str, c1816a);
            return this;
        }

        public C2282b m9446i(C1816a c1816a) {
            this.Zq = c1816a;
            return this;
        }

        public C2281a lg() {
            return new C2281a(this.Zq, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.c */
    public static class C2283c {
        private final String Xl;
        private final List Zr;
        private final Map Zs;
        private final int Zt;

        private C2283c(List list, Map map, String str, int i) {
            this.Zr = Collections.unmodifiableList(list);
            this.Zs = Collections.unmodifiableMap(map);
            this.Xl = str;
            this.Zt = i;
        }

        public static C2284d lh() {
            return new C2284d();
        }

        public String getVersion() {
            return this.Xl;
        }

        public List li() {
            return this.Zr;
        }

        public Map lj() {
            return this.Zs;
        }

        public String toString() {
            return "Rules: " + li() + "  Macros: " + this.Zs;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.d */
    public static class C2284d {
        private String Xl;
        private final List Zr;
        private final Map Zs;
        private int Zt;

        private C2284d() {
            this.Zr = new ArrayList();
            this.Zs = new HashMap();
            this.Xl = "";
            this.Zt = 0;
        }

        public C2284d m9447a(C2281a c2281a) {
            String j = dh.m9520j((C1816a) c2281a.le().get(C1750b.INSTANCE_NAME.toString()));
            List list = (List) this.Zs.get(j);
            if (list == null) {
                list = new ArrayList();
                this.Zs.put(j, list);
            }
            list.add(c2281a);
            return this;
        }

        public C2284d m9448a(C2285e c2285e) {
            this.Zr.add(c2285e);
            return this;
        }

        public C2284d bM(String str) {
            this.Xl = str;
            return this;
        }

        public C2284d ch(int i) {
            this.Zt = i;
            return this;
        }

        public C2283c lk() {
            return new C2283c(this.Zs, this.Xl, this.Zt, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.e */
    public static class C2285e {
        private final List ZA;
        private final List ZB;
        private final List ZC;
        private final List ZD;
        private final List Zu;
        private final List Zv;
        private final List Zw;
        private final List Zx;
        private final List Zy;
        private final List Zz;

        private C2285e(List list, List list2, List list3, List list4, List list5, List list6, List list7, List list8, List list9, List list10) {
            this.Zu = Collections.unmodifiableList(list);
            this.Zv = Collections.unmodifiableList(list2);
            this.Zw = Collections.unmodifiableList(list3);
            this.Zx = Collections.unmodifiableList(list4);
            this.Zy = Collections.unmodifiableList(list5);
            this.Zz = Collections.unmodifiableList(list6);
            this.ZA = Collections.unmodifiableList(list7);
            this.ZB = Collections.unmodifiableList(list8);
            this.ZC = Collections.unmodifiableList(list9);
            this.ZD = Collections.unmodifiableList(list10);
        }

        public static C2286f ll() {
            return new C2286f();
        }

        public List lm() {
            return this.Zu;
        }

        public List ln() {
            return this.Zv;
        }

        public List lo() {
            return this.Zw;
        }

        public List lp() {
            return this.Zx;
        }

        public List lq() {
            return this.Zy;
        }

        public List lr() {
            return this.ZA;
        }

        public List ls() {
            return this.ZB;
        }

        public List lt() {
            return this.ZC;
        }

        public List lu() {
            return this.ZD;
        }

        public List lv() {
            return this.Zz;
        }

        public String toString() {
            return "Positive predicates: " + lm() + "  Negative predicates: " + ln() + "  Add tags: " + lo() + "  Remove tags: " + lp() + "  Add macros: " + lq() + "  Remove macros: " + lv();
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.f */
    public static class C2286f {
        private final List ZA;
        private final List ZB;
        private final List ZC;
        private final List ZD;
        private final List Zu;
        private final List Zv;
        private final List Zw;
        private final List Zx;
        private final List Zy;
        private final List Zz;

        private C2286f() {
            this.Zu = new ArrayList();
            this.Zv = new ArrayList();
            this.Zw = new ArrayList();
            this.Zx = new ArrayList();
            this.Zy = new ArrayList();
            this.Zz = new ArrayList();
            this.ZA = new ArrayList();
            this.ZB = new ArrayList();
            this.ZC = new ArrayList();
            this.ZD = new ArrayList();
        }

        public C2286f m9449b(C2281a c2281a) {
            this.Zu.add(c2281a);
            return this;
        }

        public C2286f bN(String str) {
            this.ZC.add(str);
            return this;
        }

        public C2286f bO(String str) {
            this.ZD.add(str);
            return this;
        }

        public C2286f bP(String str) {
            this.ZA.add(str);
            return this;
        }

        public C2286f bQ(String str) {
            this.ZB.add(str);
            return this;
        }

        public C2286f m9450c(C2281a c2281a) {
            this.Zv.add(c2281a);
            return this;
        }

        public C2286f m9451d(C2281a c2281a) {
            this.Zw.add(c2281a);
            return this;
        }

        public C2286f m9452e(C2281a c2281a) {
            this.Zx.add(c2281a);
            return this;
        }

        public C2286f m9453f(C2281a c2281a) {
            this.Zy.add(c2281a);
            return this;
        }

        public C2286f m9454g(C2281a c2281a) {
            this.Zz.add(c2281a);
            return this;
        }

        public C2285e lw() {
            return new C2285e(this.Zv, this.Zw, this.Zx, this.Zy, this.Zz, this.ZA, this.ZB, this.ZC, this.ZD, null);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cq.g */
    public static class C2287g extends Exception {
        public C2287g(String str) {
            super(str);
        }
    }

    private static C1816a m9455a(int i, C1783f c1783f, C1816a[] c1816aArr, Set set) {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            bL("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        C1816a c1816a = (C1816a) m9458a(c1783f.eX, i, "values");
        if (c1816aArr[i] != null) {
            return c1816aArr[i];
        }
        C1816a c1816a2 = null;
        set.add(Integer.valueOf(i));
        C1785h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (c1816a.type) {
            case Base64.NO_PADDING /*1*/:
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
            case Base64.URL_SAFE /*8*/:
                c1816a2 = c1816a;
                break;
            case Base64.NO_WRAP /*2*/:
                h = m9462h(c1816a);
                c1816a2 = m9461g(c1816a);
                c1816a2.fO = new C1816a[h.fz.length];
                iArr = h.fz;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1816a2.fO[i3] = m9455a(iArr[i2], c1783f, c1816aArr, set);
                    i2++;
                    i3 = i4;
                }
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                c1816a2 = m9461g(c1816a);
                C1785h h2 = m9462h(c1816a);
                if (h2.fA.length != h2.fB.length) {
                    bL("Uneven map keys (" + h2.fA.length + ") and map values (" + h2.fB.length + ")");
                }
                c1816a2.fP = new C1816a[h2.fA.length];
                c1816a2.fQ = new C1816a[h2.fA.length];
                int[] iArr2 = h2.fA;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    c1816a2.fP[i4] = m9455a(iArr2[i3], c1783f, c1816aArr, set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.fB;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1816a2.fQ[i3] = m9455a(iArr[i2], c1783f, c1816aArr, set);
                    i2++;
                    i3 = i4;
                }
                break;
            case Base64.CRLF /*4*/:
                c1816a2 = m9461g(c1816a);
                c1816a2.fR = dh.m9520j(m9455a(m9462h(c1816a).fE, c1783f, c1816aArr, set));
                break;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                c1816a2 = m9461g(c1816a);
                h = m9462h(c1816a);
                c1816a2.fV = new C1816a[h.fD.length];
                iArr = h.fD;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1816a2.fV[i3] = m9455a(iArr[i2], c1783f, c1816aArr, set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (c1816a2 == null) {
            bL("Invalid value: " + c1816a);
        }
        c1816aArr[i] = c1816a2;
        set.remove(Integer.valueOf(i));
        return c1816a2;
    }

    private static C2281a m9456a(C1779b c1779b, C1783f c1783f, C1816a[] c1816aArr, int i) {
        C2282b ld = C2281a.ld();
        for (int valueOf : c1779b.eH) {
            C1782e c1782e = (C1782e) m9458a(c1783f.eY, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m9458a(c1783f.eW, c1782e.key, "keys");
            C1816a c1816a = (C1816a) m9458a(c1816aArr, c1782e.value, "values");
            if (C1750b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                ld.m9446i(c1816a);
            } else {
                ld.m9445b(str, c1816a);
            }
        }
        return ld.lg();
    }

    private static C2285e m9457a(C1784g c1784g, List list, List list2, List list3, C1783f c1783f) {
        C2286f ll = C2285e.ll();
        for (int valueOf : c1784g.fn) {
            ll.m9449b((C2281a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : c1784g.fo) {
            ll.m9450c((C2281a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : c1784g.fp) {
            ll.m9451d((C2281a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : c1784g.fr) {
            ll.bN(c1783f.eX[Integer.valueOf(valueOf3).intValue()].fN);
        }
        for (int valueOf222 : c1784g.fq) {
            ll.m9452e((C2281a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : c1784g.fs) {
            ll.bO(c1783f.eX[Integer.valueOf(valueOf32).intValue()].fN);
        }
        for (int valueOf2222 : c1784g.ft) {
            ll.m9453f((C2281a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : c1784g.fv) {
            ll.bP(c1783f.eX[Integer.valueOf(valueOf322).intValue()].fN);
        }
        for (int valueOf22222 : c1784g.fu) {
            ll.m9454g((C2281a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : c1784g.fw) {
            ll.bQ(c1783f.eX[Integer.valueOf(valueOf4).intValue()].fN);
        }
        return ll.lw();
    }

    private static Object m9458a(Object[] objArr, int i, String str) {
        if (i < 0 || i >= objArr.length) {
            bL("Index out of bounds detected: " + i + " in " + str);
        }
        return objArr[i];
    }

    public static C2283c m9459b(C1783f c1783f) {
        int i;
        int i2 = 0;
        C1816a[] c1816aArr = new C1816a[c1783f.eX.length];
        for (i = 0; i < c1783f.eX.length; i++) {
            m9455a(i, c1783f, c1816aArr, new HashSet(0));
        }
        C2284d lh = C2283c.lh();
        List arrayList = new ArrayList();
        for (i = 0; i < c1783f.fa.length; i++) {
            arrayList.add(m9456a(c1783f.fa[i], c1783f, c1816aArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < c1783f.fb.length; i++) {
            arrayList2.add(m9456a(c1783f.fb[i], c1783f, c1816aArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < c1783f.eZ.length; i++) {
            C2281a a = m9456a(c1783f.eZ[i], c1783f, c1816aArr, i);
            lh.m9447a(a);
            arrayList3.add(a);
        }
        C1784g[] c1784gArr = c1783f.fc;
        int length = c1784gArr.length;
        while (i2 < length) {
            lh.m9448a(m9457a(c1784gArr[i2], arrayList, arrayList3, arrayList2, c1783f));
            i2++;
        }
        lh.bM(c1783f.fg);
        lh.ch(c1783f.fl);
        return lh.lk();
    }

    public static void m9460b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void bL(String str) {
        bh.m9373w(str);
        throw new C2287g(str);
    }

    public static C1816a m9461g(C1816a c1816a) {
        C1816a c1816a2 = new C1816a();
        c1816a2.type = c1816a.type;
        c1816a2.fW = (int[]) c1816a.fW.clone();
        if (c1816a.fX) {
            c1816a2.fX = c1816a.fX;
        }
        return c1816a2;
    }

    private static C1785h m9462h(C1816a c1816a) {
        if (((C1785h) c1816a.m6621a(C1785h.fx)) == null) {
            bL("Expected a ServingValue and didn't get one. Value is: " + c1816a);
        }
        return (C1785h) c1816a.m6621a(C1785h.fx);
    }
}
