package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class ga {

    /* renamed from: com.google.android.gms.internal.ga.b */
    public interface C1910b {
        int eW();

        int eX();

        Object m8537g(Object obj);
    }

    /* renamed from: com.google.android.gms.internal.ga.a */
    public static class C1912a implements SafeParcelable {
        public static final gb CREATOR;
        protected final int DY;
        protected final boolean DZ;
        protected final int Ea;
        protected final boolean Eb;
        protected final String Ec;
        protected final int Ed;
        protected final Class Ee;
        protected final String Ef;
        private gd Eg;
        private C1910b Eh;
        private final int xH;

        static {
            CREATOR = new gb();
        }

        C1912a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, fv fvVar) {
            this.xH = i;
            this.DY = i2;
            this.DZ = z;
            this.Ea = i3;
            this.Eb = z2;
            this.Ec = str;
            this.Ed = i4;
            if (str2 == null) {
                this.Ee = null;
                this.Ef = null;
            } else {
                this.Ee = gg.class;
                this.Ef = str2;
            }
            if (fvVar == null) {
                this.Eh = null;
            } else {
                this.Eh = fvVar.eU();
            }
        }

        protected C1912a(int i, boolean z, int i2, boolean z2, String str, int i3, Class cls, C1910b c1910b) {
            this.xH = 1;
            this.DY = i;
            this.DZ = z;
            this.Ea = i2;
            this.Eb = z2;
            this.Ec = str;
            this.Ed = i3;
            this.Ee = cls;
            if (cls == null) {
                this.Ef = null;
            } else {
                this.Ef = cls.getCanonicalName();
            }
            this.Eh = c1910b;
        }

        public static C1912a m8548a(String str, int i, C1910b c1910b, boolean z) {
            return new C1912a(c1910b.eW(), z, c1910b.eX(), false, str, i, null, c1910b);
        }

        public static C1912a m8549a(String str, int i, Class cls) {
            return new C1912a(11, false, 11, false, str, i, cls, null);
        }

        public static C1912a m8550b(String str, int i, Class cls) {
            return new C1912a(11, true, 11, true, str, i, cls, null);
        }

        public static C1912a m8552g(String str, int i) {
            return new C1912a(0, false, 0, false, str, i, null, null);
        }

        public static C1912a m8553h(String str, int i) {
            return new C1912a(4, false, 4, false, str, i, null, null);
        }

        public static C1912a m8554i(String str, int i) {
            return new C1912a(6, false, 6, false, str, i, null, null);
        }

        public static C1912a m8555j(String str, int i) {
            return new C1912a(7, false, 7, false, str, i, null, null);
        }

        public static C1912a m8556k(String str, int i) {
            return new C1912a(7, true, 7, true, str, i, null, null);
        }

        public void m8557a(gd gdVar) {
            this.Eg = gdVar;
        }

        public int describeContents() {
            gb gbVar = CREATOR;
            return 0;
        }

        public int eW() {
            return this.DY;
        }

        public int eX() {
            return this.Ea;
        }

        public C1912a fb() {
            return new C1912a(this.xH, this.DY, this.DZ, this.Ea, this.Eb, this.Ec, this.Ed, this.Ef, fj());
        }

        public boolean fc() {
            return this.DZ;
        }

        public boolean fd() {
            return this.Eb;
        }

        public String fe() {
            return this.Ec;
        }

        public int ff() {
            return this.Ed;
        }

        public Class fg() {
            return this.Ee;
        }

        String fh() {
            return this.Ef == null ? null : this.Ef;
        }

        public boolean fi() {
            return this.Eh != null;
        }

        fv fj() {
            return this.Eh == null ? null : fv.m8533a(this.Eh);
        }

        public HashMap fk() {
            fq.m8520f(this.Ef);
            fq.m8520f(this.Eg);
            return this.Eg.au(this.Ef);
        }

        public Object m8558g(Object obj) {
            return this.Eh.m8537g(obj);
        }

        public int getVersionCode() {
            return this.xH;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.xH).append('\n');
            stringBuilder.append("                 typeIn=").append(this.DY).append('\n');
            stringBuilder.append("            typeInArray=").append(this.DZ).append('\n');
            stringBuilder.append("                typeOut=").append(this.Ea).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.Eb).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.Ec).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.Ed).append('\n');
            stringBuilder.append("       concreteTypeName=").append(fh()).append('\n');
            if (fg() != null) {
                stringBuilder.append("     concreteType.class=").append(fg().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.Eh == null ? "null" : this.Eh.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            gb gbVar = CREATOR;
            gb.m8564a(this, out, flags);
        }
    }

    private void m8559a(StringBuilder stringBuilder, C1912a c1912a, Object obj) {
        if (c1912a.eW() == 11) {
            stringBuilder.append(((ga) c1912a.fg().cast(obj)).toString());
        } else if (c1912a.eW() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(gp.av((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void m8560a(StringBuilder stringBuilder, C1912a c1912a, ArrayList arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m8559a(stringBuilder, c1912a, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected Object m8561a(C1912a c1912a, Object obj) {
        return c1912a.Eh != null ? c1912a.m8558g(obj) : obj;
    }

    protected boolean m8562a(C1912a c1912a) {
        return c1912a.eX() == 11 ? c1912a.fd() ? at(c1912a.fe()) : as(c1912a.fe()) : ar(c1912a.fe());
    }

    protected abstract Object aq(String str);

    protected abstract boolean ar(String str);

    protected boolean as(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean at(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected Object m8563b(C1912a c1912a) {
        boolean z = true;
        String fe = c1912a.fe();
        if (c1912a.fg() == null) {
            return aq(c1912a.fe());
        }
        if (aq(c1912a.fe()) != null) {
            z = false;
        }
        fq.m8515a(z, "Concrete field shouldn't be value object: " + c1912a.fe());
        Map fa = c1912a.fd() ? fa() : eZ();
        if (fa != null) {
            return fa.get(fe);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(fe.charAt(0)) + fe.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public abstract HashMap eY();

    public HashMap eZ() {
        return null;
    }

    public HashMap fa() {
        return null;
    }

    public String toString() {
        HashMap eY = eY();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : eY.keySet()) {
            C1912a c1912a = (C1912a) eY.get(str);
            if (m8562a(c1912a)) {
                Object a = m8561a(c1912a, m8563b(c1912a));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (c1912a.eX()) {
                        case Base64.URL_SAFE /*8*/:
                            stringBuilder.append("\"").append(gj.m8602d((byte[]) a)).append("\"");
                            break;
                        case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                            stringBuilder.append("\"").append(gj.m8603e((byte[]) a)).append("\"");
                            break;
                        case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                            gq.m8607a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!c1912a.fc()) {
                                m8559a(stringBuilder, c1912a, a);
                                break;
                            }
                            m8560a(stringBuilder, c1912a, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
