package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1788c.C1786i;
import com.google.android.gms.internal.C1817d.C1816a;
import com.google.android.gms.tagmanager.C2311l.C2288a;
import com.google.android.gms.tagmanager.C2326s.C2240a;
import com.google.android.gms.tagmanager.cq.C2281a;
import com.google.android.gms.tagmanager.cq.C2283c;
import com.google.android.gms.tagmanager.cq.C2285e;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cs {
    private static final by ZE;
    private final DataLayer WK;
    private final C2283c ZF;
    private final ag ZG;
    private final Map ZH;
    private final Map ZI;
    private final Map ZJ;
    private final C2263k ZK;
    private final C2263k ZL;
    private final Set ZM;
    private final Map ZN;
    private volatile String ZO;
    private int ZP;

    /* renamed from: com.google.android.gms.tagmanager.cs.1 */
    class C22891 implements C2288a {
        final /* synthetic */ cs ZQ;

        C22891(cs csVar) {
            this.ZQ = csVar;
        }

        public int m9463a(C2281a c2281a, by byVar) {
            return ((C1816a) byVar.getObject()).mF();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m9463a((C2281a) x0, (by) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.2 */
    class C22902 implements C2288a {
        final /* synthetic */ cs ZQ;

        C22902(cs csVar) {
            this.ZQ = csVar;
        }

        public int m9464a(String str, C2294b c2294b) {
            return str.length() + c2294b.getSize();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m9464a((String) x0, (C2294b) x1);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.a */
    interface C2291a {
        void m9465a(C2285e c2285e, Set set, Set set2, cm cmVar);
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.3 */
    class C22923 implements C2291a {
        final /* synthetic */ cs ZQ;
        final /* synthetic */ Map ZR;
        final /* synthetic */ Map ZS;
        final /* synthetic */ Map ZT;
        final /* synthetic */ Map ZU;

        C22923(cs csVar, Map map, Map map2, Map map3, Map map4) {
            this.ZQ = csVar;
            this.ZR = map;
            this.ZS = map2;
            this.ZT = map3;
            this.ZU = map4;
        }

        public void m9466a(C2285e c2285e, Set set, Set set2, cm cmVar) {
            List list = (List) this.ZR.get(c2285e);
            List list2 = (List) this.ZS.get(c2285e);
            if (list != null) {
                set.addAll(list);
                cmVar.kK().m9392b(list, list2);
            }
            list = (List) this.ZT.get(c2285e);
            list2 = (List) this.ZU.get(c2285e);
            if (list != null) {
                set2.addAll(list);
                cmVar.kL().m9392b(list, list2);
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.4 */
    class C22934 implements C2291a {
        final /* synthetic */ cs ZQ;

        C22934(cs csVar) {
            this.ZQ = csVar;
        }

        public void m9467a(C2285e c2285e, Set set, Set set2, cm cmVar) {
            set.addAll(c2285e.lo());
            set2.addAll(c2285e.lp());
            cmVar.kM().m9392b(c2285e.lo(), c2285e.lt());
            cmVar.kN().m9392b(c2285e.lp(), c2285e.lu());
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.b */
    private static class C2294b {
        private by ZV;
        private C1816a Zq;

        public C2294b(by byVar, C1816a c1816a) {
            this.ZV = byVar;
            this.Zq = c1816a;
        }

        public int getSize() {
            return (this.Zq == null ? 0 : this.Zq.mF()) + ((C1816a) this.ZV.getObject()).mF();
        }

        public C1816a lf() {
            return this.Zq;
        }

        public by lz() {
            return this.ZV;
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.cs.c */
    private static class C2295c {
        private final Set ZM;
        private final Map ZW;
        private final Map ZX;
        private final Map ZY;
        private final Map ZZ;
        private C2281a aaa;

        public C2295c() {
            this.ZM = new HashSet();
            this.ZW = new HashMap();
            this.ZY = new HashMap();
            this.ZX = new HashMap();
            this.ZZ = new HashMap();
        }

        public void m9468a(C2285e c2285e, C2281a c2281a) {
            List list = (List) this.ZW.get(c2285e);
            if (list == null) {
                list = new ArrayList();
                this.ZW.put(c2285e, list);
            }
            list.add(c2281a);
        }

        public void m9469a(C2285e c2285e, String str) {
            List list = (List) this.ZY.get(c2285e);
            if (list == null) {
                list = new ArrayList();
                this.ZY.put(c2285e, list);
            }
            list.add(str);
        }

        public void m9470b(C2285e c2285e) {
            this.ZM.add(c2285e);
        }

        public void m9471b(C2285e c2285e, C2281a c2281a) {
            List list = (List) this.ZX.get(c2285e);
            if (list == null) {
                list = new ArrayList();
                this.ZX.put(c2285e, list);
            }
            list.add(c2281a);
        }

        public void m9472b(C2285e c2285e, String str) {
            List list = (List) this.ZZ.get(c2285e);
            if (list == null) {
                list = new ArrayList();
                this.ZZ.put(c2285e, list);
            }
            list.add(str);
        }

        public void m9473i(C2281a c2281a) {
            this.aaa = c2281a;
        }

        public Set lA() {
            return this.ZM;
        }

        public Map lB() {
            return this.ZW;
        }

        public Map lC() {
            return this.ZY;
        }

        public Map lD() {
            return this.ZZ;
        }

        public Map lE() {
            return this.ZX;
        }

        public C2281a lF() {
            return this.aaa;
        }
    }

    static {
        ZE = new by(dh.lT(), true);
    }

    public cs(Context context, C2283c c2283c, DataLayer dataLayer, C2240a c2240a, C2240a c2240a2, ag agVar) {
        if (c2283c == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.ZF = c2283c;
        this.ZM = new HashSet(c2283c.li());
        this.WK = dataLayer;
        this.ZG = agVar;
        this.ZK = new C2311l().m9553a(1048576, new C22891(this));
        this.ZL = new C2311l().m9553a(1048576, new C22902(this));
        this.ZH = new HashMap();
        m9488b(new C2308i(context));
        m9488b(new C2326s(c2240a2));
        m9488b(new C2334w(dataLayer));
        m9488b(new di(context, dataLayer));
        this.ZI = new HashMap();
        m9489c(new C2324q());
        m9489c(new ad());
        m9489c(new ae());
        m9489c(new al());
        m9489c(new am());
        m9489c(new bd());
        m9489c(new be());
        m9489c(new ch());
        m9489c(new db());
        this.ZJ = new HashMap();
        m9487a(new C2261b(context));
        m9487a(new C2267c(context));
        m9487a(new C2302e(context));
        m9487a(new C2303f(context));
        m9487a(new C2304g(context));
        m9487a(new C2305h(context));
        m9487a(new C2312m());
        m9487a(new C2323p(this.ZF.getVersion()));
        m9487a(new C2326s(c2240a));
        m9487a(new C2327u(dataLayer));
        m9487a(new C2337z(context));
        m9487a(new aa());
        m9487a(new ac());
        m9487a(new ah(this));
        m9487a(new an());
        m9487a(new ao());
        m9487a(new ax(context));
        m9487a(new az());
        m9487a(new bc());
        m9487a(new bk(context));
        m9487a(new bz());
        m9487a(new cb());
        m9487a(new ce());
        m9487a(new cg());
        m9487a(new ci(context));
        m9487a(new ct());
        m9487a(new cu());
        m9487a(new dd());
        this.ZN = new HashMap();
        for (C2285e c2285e : this.ZM) {
            if (agVar.kA()) {
                m9479a(c2285e.lq(), c2285e.lr(), "add macro");
                m9479a(c2285e.lv(), c2285e.ls(), "remove macro");
                m9479a(c2285e.lo(), c2285e.lt(), "add tag");
                m9479a(c2285e.lp(), c2285e.lu(), "remove tag");
            }
            int i = 0;
            while (i < c2285e.lq().size()) {
                C2281a c2281a = (C2281a) c2285e.lq().get(i);
                String str = "Unknown";
                if (agVar.kA() && i < c2285e.lr().size()) {
                    str = (String) c2285e.lr().get(i);
                }
                C2295c d = m9481d(this.ZN, m9482h(c2281a));
                d.m9470b(c2285e);
                d.m9468a(c2285e, c2281a);
                d.m9469a(c2285e, str);
                i++;
            }
            i = 0;
            while (i < c2285e.lv().size()) {
                c2281a = (C2281a) c2285e.lv().get(i);
                str = "Unknown";
                if (agVar.kA() && i < c2285e.ls().size()) {
                    str = (String) c2285e.ls().get(i);
                }
                d = m9481d(this.ZN, m9482h(c2281a));
                d.m9470b(c2285e);
                d.m9471b(c2285e, c2281a);
                d.m9472b(c2285e, str);
                i++;
            }
        }
        for (Entry entry : this.ZF.lj().entrySet()) {
            for (C2281a c2281a2 : (List) entry.getValue()) {
                if (!dh.m9526n((C1816a) c2281a2.le().get(C1750b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m9481d(this.ZN, (String) entry.getKey()).m9473i(c2281a2);
                }
            }
        }
    }

    private by m9474a(C1816a c1816a, Set set, dj djVar) {
        if (!c1816a.fX) {
            return new by(c1816a, true);
        }
        C1816a g;
        int i;
        by a;
        switch (c1816a.type) {
            case Base64.NO_WRAP /*2*/:
                g = cq.m9461g(c1816a);
                g.fO = new C1816a[c1816a.fO.length];
                for (i = 0; i < c1816a.fO.length; i++) {
                    a = m9474a(c1816a.fO[i], set, djVar.cd(i));
                    if (a == ZE) {
                        return ZE;
                    }
                    g.fO[i] = (C1816a) a.getObject();
                }
                return new by(g, false);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                g = cq.m9461g(c1816a);
                if (c1816a.fP.length != c1816a.fQ.length) {
                    bh.m9373w("Invalid serving value: " + c1816a.toString());
                    return ZE;
                }
                g.fP = new C1816a[c1816a.fP.length];
                g.fQ = new C1816a[c1816a.fP.length];
                for (i = 0; i < c1816a.fP.length; i++) {
                    a = m9474a(c1816a.fP[i], set, djVar.ce(i));
                    by a2 = m9474a(c1816a.fQ[i], set, djVar.cf(i));
                    if (a == ZE || a2 == ZE) {
                        return ZE;
                    }
                    g.fP[i] = (C1816a) a.getObject();
                    g.fQ[i] = (C1816a) a2.getObject();
                }
                return new by(g, false);
            case Base64.CRLF /*4*/:
                if (set.contains(c1816a.fR)) {
                    bh.m9373w("Macro cycle detected.  Current macro reference: " + c1816a.fR + "." + "  Previous macro references: " + set.toString() + ".");
                    return ZE;
                }
                set.add(c1816a.fR);
                a = dk.m9545a(m9475a(c1816a.fR, set, djVar.kP()), c1816a.fW);
                set.remove(c1816a.fR);
                return a;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                g = cq.m9461g(c1816a);
                g.fV = new C1816a[c1816a.fV.length];
                for (i = 0; i < c1816a.fV.length; i++) {
                    a = m9474a(c1816a.fV[i], set, djVar.cg(i));
                    if (a == ZE) {
                        return ZE;
                    }
                    g.fV[i] = (C1816a) a.getObject();
                }
                return new by(g, false);
            default:
                bh.m9373w("Unknown type: " + c1816a.type);
                return ZE;
        }
    }

    private by m9475a(String str, Set set, bj bjVar) {
        this.ZP++;
        C2294b c2294b = (C2294b) this.ZL.get(str);
        if (c2294b == null || this.ZG.kA()) {
            C2295c c2295c = (C2295c) this.ZN.get(str);
            if (c2295c == null) {
                bh.m9373w(ly() + "Invalid macro: " + str);
                this.ZP--;
                return ZE;
            }
            C2281a lF;
            by a = m9485a(str, c2295c.lA(), c2295c.lB(), c2295c.lC(), c2295c.lE(), c2295c.lD(), set, bjVar.kr());
            if (((Set) a.getObject()).isEmpty()) {
                lF = c2295c.lF();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.m9376z(ly() + "Multiple macros active for macroName " + str);
                }
                lF = (C2281a) ((Set) a.getObject()).iterator().next();
            }
            if (lF == null) {
                this.ZP--;
                return ZE;
            }
            by a2 = m9476a(this.ZJ, lF, set, bjVar.kG());
            boolean z = a.kQ() && a2.kQ();
            by byVar = a2 == ZE ? ZE : new by(a2.getObject(), z);
            C1816a lf = lF.lf();
            if (byVar.kQ()) {
                this.ZL.m9363e(str, new C2294b(byVar, lf));
            }
            m9478a(lf, set);
            this.ZP--;
            return byVar;
        }
        m9478a(c2294b.lf(), set);
        this.ZP--;
        return c2294b.lz();
    }

    private by m9476a(Map map, C2281a c2281a, Set set, cj cjVar) {
        boolean z = true;
        C1816a c1816a = (C1816a) c2281a.le().get(C1750b.FUNCTION.toString());
        if (c1816a == null) {
            bh.m9373w("No function id in properties");
            return ZE;
        }
        String str = c1816a.fS;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.m9373w(str + " has no backing implementation.");
            return ZE;
        }
        by byVar = (by) this.ZK.get(c2281a);
        if (byVar != null && !this.ZG.kA()) {
            return byVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : c2281a.le().entrySet()) {
            by a = m9474a((C1816a) entry.getValue(), set, cjVar.bH((String) entry.getKey()).m9390e((C1816a) entry.getValue()));
            if (a == ZE) {
                return ZE;
            }
            boolean z3;
            if (a.kQ()) {
                c2281a.m9444a((String) entry.getKey(), (C1816a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.m9310a(hashMap.keySet())) {
            if (!(z2 && ajVar.jX())) {
                z = false;
            }
            byVar = new by(ajVar.m9311x(hashMap), z);
            if (z) {
                this.ZK.m9363e(c2281a, byVar);
            }
            cjVar.m9388d((C1816a) byVar.getObject());
            return byVar;
        }
        bh.m9373w("Incorrect keys for function " + str + " required " + ajVar.kC() + " had " + hashMap.keySet());
        return ZE;
    }

    private by m9477a(Set set, Set set2, C2291a c2291a, cr crVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (C2285e c2285e : set) {
            cm kO = crVar.kO();
            by a = m9484a(c2285e, set2, kO);
            if (((Boolean) a.getObject()).booleanValue()) {
                c2291a.m9465a(c2285e, hashSet, hashSet2, kO);
            }
            boolean z2 = z && a.kQ();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        crVar.m9396b(hashSet);
        return new by(hashSet, z);
    }

    private void m9478a(C1816a c1816a, Set set) {
        if (c1816a != null) {
            by a = m9474a(c1816a, set, new bw());
            if (a != ZE) {
                Object o = dh.m9528o((C1816a) a.getObject());
                if (o instanceof Map) {
                    this.WK.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.WK.push((Map) o2);
                        } else {
                            bh.m9376z("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.m9376z("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void m9479a(List list, List list2, String str) {
        if (list.size() != list2.size()) {
            bh.m9374x("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void m9480a(Map map, aj ajVar) {
        if (map.containsKey(ajVar.kB())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.kB());
        }
        map.put(ajVar.kB(), ajVar);
    }

    private static C2295c m9481d(Map map, String str) {
        C2295c c2295c = (C2295c) map.get(str);
        if (c2295c != null) {
            return c2295c;
        }
        c2295c = new C2295c();
        map.put(str, c2295c);
        return c2295c;
    }

    private static String m9482h(C2281a c2281a) {
        return dh.m9520j((C1816a) c2281a.le().get(C1750b.INSTANCE_NAME.toString()));
    }

    private String ly() {
        if (this.ZP <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.ZP));
        for (int i = 2; i < this.ZP; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    by m9483a(C2281a c2281a, Set set, cj cjVar) {
        by a = m9476a(this.ZI, c2281a, set, cjVar);
        Boolean n = dh.m9526n((C1816a) a.getObject());
        cjVar.m9388d(dh.m9531r(n));
        return new by(n, a.kQ());
    }

    by m9484a(C2285e c2285e, Set set, cm cmVar) {
        boolean z = true;
        for (C2281a a : c2285e.ln()) {
            by a2 = m9483a(a, set, cmVar.kI());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cmVar.m9394f(dh.m9531r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.kQ());
            }
            boolean z2 = z && a2.kQ();
            z = z2;
        }
        for (C2281a a3 : c2285e.lm()) {
            a2 = m9483a(a3, set, cmVar.kJ());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.kQ();
            } else {
                cmVar.m9394f(dh.m9531r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.kQ());
            }
        }
        cmVar.m9394f(dh.m9531r(Boolean.valueOf(true)));
        return new by(Boolean.valueOf(true), z);
    }

    by m9485a(String str, Set set, Map map, Map map2, Map map3, Map map4, Set set2, cr crVar) {
        return m9477a(set, set2, new C22923(this, map, map2, map3, map4), crVar);
    }

    by m9486a(Set set, cr crVar) {
        return m9477a(set, new HashSet(), new C22934(this), crVar);
    }

    void m9487a(aj ajVar) {
        m9480a(this.ZJ, ajVar);
    }

    void m9488b(aj ajVar) {
        m9480a(this.ZH, ajVar);
    }

    public by bR(String str) {
        this.ZP = 0;
        af bA = this.ZG.bA(str);
        by a = m9475a(str, new HashSet(), bA.kx());
        bA.kz();
        return a;
    }

    synchronized void bS(String str) {
        this.ZO = str;
    }

    public synchronized void bp(String str) {
        bS(str);
        af bB = this.ZG.bB(str);
        C2265t ky = bB.ky();
        for (C2281a a : (Set) m9486a(this.ZM, ky.kr()).getObject()) {
            m9476a(this.ZH, a, new HashSet(), ky.kq());
        }
        bB.kz();
        bS(null);
    }

    void m9489c(aj ajVar) {
        m9480a(this.ZI, ajVar);
    }

    public synchronized void m9490e(List list) {
        for (C1786i c1786i : list) {
            if (c1786i.name == null || !c1786i.name.startsWith("gaExperiment:")) {
                bh.m9375y("Ignored supplemental: " + c1786i);
            } else {
                ai.m9323a(this.WK, c1786i);
            }
        }
    }

    synchronized String lx() {
        return this.ZO;
    }
}
