package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1817d.C1816a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dh {
    private static final Object aaF;
    private static Long aaG;
    private static Double aaH;
    private static dg aaI;
    private static String aaJ;
    private static Boolean aaK;
    private static List aaL;
    private static Map aaM;
    private static C1816a aaN;

    static {
        aaF = null;
        aaG = new Long(0);
        aaH = new Double(0.0d);
        aaI = dg.m9518w(0);
        aaJ = new String("");
        aaK = new Boolean(false);
        aaL = new ArrayList(0);
        aaM = new HashMap();
        aaN = m9531r(aaJ);
    }

    public static C1816a bX(String str) {
        C1816a c1816a = new C1816a();
        c1816a.type = 5;
        c1816a.fS = str;
        return c1816a;
    }

    private static dg bY(String str) {
        try {
            return dg.bW(str);
        } catch (NumberFormatException e) {
            bh.m9373w("Failed to convert '" + str + "' to a number.");
            return aaI;
        }
    }

    private static Long bZ(String str) {
        dg bY = bY(str);
        return bY == aaI ? aaG : Long.valueOf(bY.longValue());
    }

    private static Double ca(String str) {
        dg bY = bY(str);
        return bY == aaI ? aaH : Double.valueOf(bY.doubleValue());
    }

    private static Boolean cb(String str) {
        return "true".equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : aaK;
    }

    private static double getDouble(Object o) {
        if (o instanceof Number) {
            return ((Number) o).doubleValue();
        }
        bh.m9373w("getDouble received non-Number");
        return 0.0d;
    }

    public static String m9520j(C1816a c1816a) {
        return m9524m(m9528o(c1816a));
    }

    public static dg m9521k(C1816a c1816a) {
        return m9525n(m9528o(c1816a));
    }

    public static Long m9522l(C1816a c1816a) {
        return m9527o(m9528o(c1816a));
    }

    public static Object lN() {
        return aaF;
    }

    public static Long lO() {
        return aaG;
    }

    public static Double lP() {
        return aaH;
    }

    public static Boolean lQ() {
        return aaK;
    }

    public static dg lR() {
        return aaI;
    }

    public static String lS() {
        return aaJ;
    }

    public static C1816a lT() {
        return aaN;
    }

    public static Double m9523m(C1816a c1816a) {
        return m9529p(m9528o(c1816a));
    }

    public static String m9524m(Object obj) {
        return obj == null ? aaJ : obj.toString();
    }

    public static dg m9525n(Object obj) {
        return obj instanceof dg ? (dg) obj : m9533t(obj) ? dg.m9518w(m9534u(obj)) : m9532s(obj) ? dg.m9517a(Double.valueOf(getDouble(obj))) : bY(m9524m(obj));
    }

    public static Boolean m9526n(C1816a c1816a) {
        return m9530q(m9528o(c1816a));
    }

    public static Long m9527o(Object obj) {
        return m9533t(obj) ? Long.valueOf(m9534u(obj)) : bZ(m9524m(obj));
    }

    public static Object m9528o(C1816a c1816a) {
        int i = 0;
        if (c1816a == null) {
            return aaF;
        }
        C1816a[] c1816aArr;
        int length;
        switch (c1816a.type) {
            case Base64.NO_PADDING /*1*/:
                return c1816a.fN;
            case Base64.NO_WRAP /*2*/:
                ArrayList arrayList = new ArrayList(c1816a.fO.length);
                c1816aArr = c1816a.fO;
                length = c1816aArr.length;
                while (i < length) {
                    Object o = m9528o(c1816aArr[i]);
                    if (o == aaF) {
                        return aaF;
                    }
                    arrayList.add(o);
                    i++;
                }
                return arrayList;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (c1816a.fP.length != c1816a.fQ.length) {
                    bh.m9373w("Converting an invalid value to object: " + c1816a.toString());
                    return aaF;
                }
                Map hashMap = new HashMap(c1816a.fQ.length);
                while (i < c1816a.fP.length) {
                    Object o2 = m9528o(c1816a.fP[i]);
                    Object o3 = m9528o(c1816a.fQ[i]);
                    if (o2 == aaF || o3 == aaF) {
                        return aaF;
                    }
                    hashMap.put(o2, o3);
                    i++;
                }
                return hashMap;
            case Base64.CRLF /*4*/:
                bh.m9373w("Trying to convert a macro reference to object");
                return aaF;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                bh.m9373w("Trying to convert a function id to object");
                return aaF;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return Long.valueOf(c1816a.fT);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                StringBuffer stringBuffer = new StringBuffer();
                c1816aArr = c1816a.fV;
                length = c1816aArr.length;
                while (i < length) {
                    String j = m9520j(c1816aArr[i]);
                    if (j == aaJ) {
                        return aaF;
                    }
                    stringBuffer.append(j);
                    i++;
                }
                return stringBuffer.toString();
            case Base64.URL_SAFE /*8*/:
                return Boolean.valueOf(c1816a.fU);
            default:
                bh.m9373w("Failed to convert a value of type: " + c1816a.type);
                return aaF;
        }
    }

    public static Double m9529p(Object obj) {
        return m9532s(obj) ? Double.valueOf(getDouble(obj)) : ca(m9524m(obj));
    }

    public static Boolean m9530q(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : cb(m9524m(obj));
    }

    public static C1816a m9531r(Object obj) {
        boolean z = false;
        C1816a c1816a = new C1816a();
        if (obj instanceof C1816a) {
            return (C1816a) obj;
        }
        if (obj instanceof String) {
            c1816a.type = 1;
            c1816a.fN = (String) obj;
        } else if (obj instanceof List) {
            c1816a.type = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object r : list) {
                C1816a r2 = m9531r(r);
                if (r2 == aaN) {
                    return aaN;
                }
                r0 = r1 || r2.fX;
                r5.add(r2);
                r1 = r0;
            }
            c1816a.fO = (C1816a[]) r5.toArray(new C1816a[0]);
            z = r1;
        } else if (obj instanceof Map) {
            c1816a.type = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                C1816a r3 = m9531r(entry.getKey());
                C1816a r4 = m9531r(entry.getValue());
                if (r3 == aaN || r4 == aaN) {
                    return aaN;
                }
                r0 = r1 || r3.fX || r4.fX;
                r5.add(r3);
                arrayList.add(r4);
                r1 = r0;
            }
            c1816a.fP = (C1816a[]) r5.toArray(new C1816a[0]);
            c1816a.fQ = (C1816a[]) arrayList.toArray(new C1816a[0]);
            z = r1;
        } else if (m9532s(obj)) {
            c1816a.type = 1;
            c1816a.fN = obj.toString();
        } else if (m9533t(obj)) {
            c1816a.type = 6;
            c1816a.fT = m9534u(obj);
        } else if (obj instanceof Boolean) {
            c1816a.type = 8;
            c1816a.fU = ((Boolean) obj).booleanValue();
        } else {
            bh.m9373w("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return aaN;
        }
        c1816a.fX = z;
        return c1816a;
    }

    private static boolean m9532s(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof dg) && ((dg) obj).lI());
    }

    private static boolean m9533t(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof dg) && ((dg) obj).lJ());
    }

    private static long m9534u(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        bh.m9373w("getInt64 received non-Number");
        return 0;
    }
}
