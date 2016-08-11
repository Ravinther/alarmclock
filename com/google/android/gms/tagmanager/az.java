package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C1732a;
import com.google.android.gms.internal.C1750b;
import com.google.android.gms.internal.C1817d.C1816a;
import com.google.android.gms.plus.PlusShare;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID;
    private static final String XQ;
    private static final String Ym;
    private static final String Yn;
    private static final String Yo;

    /* renamed from: com.google.android.gms.tagmanager.az.1 */
    static /* synthetic */ class C22591 {
        static final /* synthetic */ int[] Yp;

        static {
            Yp = new int[C2260a.values().length];
            try {
                Yp[C2260a.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                Yp[C2260a.BACKSLASH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                Yp[C2260a.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.az.a */
    private enum C2260a {
        NONE,
        URL,
        BACKSLASH
    }

    static {
        ID = C1732a.JOINER.toString();
        XQ = C1750b.ARG0.toString();
        Ym = C1750b.ITEM_SEPARATOR.toString();
        Yn = C1750b.KEY_VALUE_SEPARATOR.toString();
        Yo = C1750b.ESCAPE.toString();
    }

    public az() {
        super(ID, XQ);
    }

    private String m9356a(String str, C2260a c2260a, Set set) {
        switch (C22591.Yp[c2260a.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                try {
                    return dk.cd(str);
                } catch (Throwable e) {
                    bh.m9370b("Joiner: unsupported encoding", e);
                    return str;
                }
            case Base64.NO_WRAP /*2*/:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void m9357a(StringBuilder stringBuilder, String str, C2260a c2260a, Set set) {
        stringBuilder.append(m9356a(str, c2260a, set));
    }

    private void m9358a(Set set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public boolean jX() {
        return true;
    }

    public C1816a m9359x(Map map) {
        C1816a c1816a = (C1816a) map.get(XQ);
        if (c1816a == null) {
            return dh.lT();
        }
        C2260a c2260a;
        Set set;
        C1816a c1816a2 = (C1816a) map.get(Ym);
        String j = c1816a2 != null ? dh.m9520j(c1816a2) : "";
        c1816a2 = (C1816a) map.get(Yn);
        String j2 = c1816a2 != null ? dh.m9520j(c1816a2) : "=";
        C2260a c2260a2 = C2260a.NONE;
        c1816a2 = (C1816a) map.get(Yo);
        if (c1816a2 != null) {
            String j3 = dh.m9520j(c1816a2);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                c2260a = C2260a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                c2260a = C2260a.BACKSLASH;
                set = new HashSet();
                m9358a(set, j);
                m9358a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.m9373w("Joiner: unsupported escape type: " + j3);
                return dh.lT();
            }
        }
        set = null;
        c2260a = c2260a2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (c1816a.type) {
            case Base64.NO_WRAP /*2*/:
                Object obj = 1;
                C1816a[] c1816aArr = c1816a.fO;
                int length = c1816aArr.length;
                int i = 0;
                while (i < length) {
                    C1816a c1816a3 = c1816aArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    m9357a(stringBuilder, dh.m9520j(c1816a3), c2260a, set);
                    i++;
                    obj = null;
                }
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                for (int i2 = 0; i2 < c1816a.fP.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = dh.m9520j(c1816a.fP[i2]);
                    String j5 = dh.m9520j(c1816a.fQ[i2]);
                    m9357a(stringBuilder, j4, c2260a, set);
                    stringBuilder.append(j2);
                    m9357a(stringBuilder, j5, c2260a, set);
                }
                break;
            default:
                m9357a(stringBuilder, dh.m9520j(c1816a), c2260a, set);
                break;
        }
        return dh.m9531r(stringBuilder.toString());
    }
}
