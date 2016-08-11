package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C1487a;
import com.google.android.gms.common.internal.safeparcel.C1487a.C1486a;
import com.google.android.gms.common.internal.safeparcel.C1488b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C1912a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class gg extends ga implements SafeParcelable {
    public static final gh CREATOR;
    private final gd Eg;
    private final Parcel En;
    private final int Eo;
    private int Ep;
    private int Eq;
    private final String mClassName;
    private final int xH;

    static {
        CREATOR = new gh();
    }

    gg(int i, Parcel parcel, gd gdVar) {
        this.xH = i;
        this.En = (Parcel) fq.m8520f(parcel);
        this.Eo = 2;
        this.Eg = gdVar;
        if (this.Eg == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.Eg.fo();
        }
        this.Ep = 2;
    }

    private gg(SafeParcelable safeParcelable, gd gdVar, String str) {
        this.xH = 1;
        this.En = Parcel.obtain();
        safeParcelable.writeToParcel(this.En, 0);
        this.Eo = 1;
        this.Eg = (gd) fq.m8520f(gdVar);
        this.mClassName = (String) fq.m8520f(str);
        this.Ep = 2;
    }

    public static gg m8580a(ga gaVar) {
        String canonicalName = gaVar.getClass().getCanonicalName();
        return new gg((SafeParcelable) gaVar, m8586b(gaVar), canonicalName);
    }

    private static void m8581a(gd gdVar, ga gaVar) {
        Class cls = gaVar.getClass();
        if (!gdVar.m8573b(cls)) {
            HashMap eY = gaVar.eY();
            gdVar.m8572a(cls, gaVar.eY());
            for (String str : eY.keySet()) {
                C1912a c1912a = (C1912a) eY.get(str);
                Class fg = c1912a.fg();
                if (fg != null) {
                    try {
                        m8581a(gdVar, (ga) fg.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + c1912a.fg().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + c1912a.fg().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void m8582a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case Base64.DEFAULT /*0*/:
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
            case Base64.CRLF /*4*/:
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                stringBuilder.append(obj);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                stringBuilder.append("\"").append(gp.av(obj.toString())).append("\"");
            case Base64.URL_SAFE /*8*/:
                stringBuilder.append("\"").append(gj.m8602d((byte[]) obj)).append("\"");
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                stringBuilder.append("\"").append(gj.m8603e((byte[]) obj));
                stringBuilder.append("\"");
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                gq.m8607a(stringBuilder, (HashMap) obj);
            case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m8583a(StringBuilder stringBuilder, C1912a c1912a, Parcel parcel, int i) {
        switch (c1912a.eX()) {
            case Base64.DEFAULT /*0*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, Integer.valueOf(C1487a.m6331g(parcel, i))));
            case Base64.NO_PADDING /*1*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, C1487a.m6334j(parcel, i)));
            case Base64.NO_WRAP /*2*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, Long.valueOf(C1487a.m6333i(parcel, i))));
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, Float.valueOf(C1487a.m6335k(parcel, i))));
            case Base64.CRLF /*4*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, Double.valueOf(C1487a.m6336l(parcel, i))));
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, C1487a.m6337m(parcel, i)));
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, Boolean.valueOf(C1487a.m6327c(parcel, i))));
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, C1487a.m6339n(parcel, i)));
            case Base64.URL_SAFE /*8*/:
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, C1487a.m6343q(parcel, i)));
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                m8588b(stringBuilder, c1912a, m8561a(c1912a, m8590c(C1487a.m6342p(parcel, i))));
            case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + c1912a.eX());
        }
    }

    private void m8584a(StringBuilder stringBuilder, String str, C1912a c1912a, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (c1912a.fi()) {
            m8583a(stringBuilder, c1912a, parcel, i);
        } else {
            m8587b(stringBuilder, c1912a, parcel, i);
        }
    }

    private void m8585a(StringBuilder stringBuilder, HashMap hashMap, Parcel parcel) {
        HashMap c = m8591c(hashMap);
        stringBuilder.append('{');
        int o = C1487a.m6340o(parcel);
        Object obj = null;
        while (parcel.dataPosition() < o) {
            int n = C1487a.m6338n(parcel);
            Entry entry = (Entry) c.get(Integer.valueOf(C1487a.m6318R(n)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m8584a(stringBuilder, (String) entry.getKey(), (C1912a) entry.getValue(), parcel, n);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != o) {
            throw new C1486a("Overread allowed size end=" + o, parcel);
        }
        stringBuilder.append('}');
    }

    private static gd m8586b(ga gaVar) {
        gd gdVar = new gd(gaVar.getClass());
        m8581a(gdVar, gaVar);
        gdVar.fm();
        gdVar.fl();
        return gdVar;
    }

    private void m8587b(StringBuilder stringBuilder, C1912a c1912a, Parcel parcel, int i) {
        if (c1912a.fd()) {
            stringBuilder.append("[");
            switch (c1912a.eX()) {
                case Base64.DEFAULT /*0*/:
                    gi.m8597a(stringBuilder, C1487a.m6346t(parcel, i));
                    break;
                case Base64.NO_PADDING /*1*/:
                    gi.m8599a(stringBuilder, C1487a.m6348v(parcel, i));
                    break;
                case Base64.NO_WRAP /*2*/:
                    gi.m8598a(stringBuilder, C1487a.m6347u(parcel, i));
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    gi.m8596a(stringBuilder, C1487a.m6349w(parcel, i));
                    break;
                case Base64.CRLF /*4*/:
                    gi.m8595a(stringBuilder, C1487a.m6350x(parcel, i));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    gi.m8599a(stringBuilder, C1487a.m6351y(parcel, i));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    gi.m8601a(stringBuilder, C1487a.m6345s(parcel, i));
                    break;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    gi.m8600a(stringBuilder, C1487a.m6352z(parcel, i));
                    break;
                case Base64.URL_SAFE /*8*/:
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                    Parcel[] C = C1487a.m6317C(parcel, i);
                    int length = C.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        C[i2].setDataPosition(0);
                        m8585a(stringBuilder, c1912a.fk(), C[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (c1912a.eX()) {
            case Base64.DEFAULT /*0*/:
                stringBuilder.append(C1487a.m6331g(parcel, i));
            case Base64.NO_PADDING /*1*/:
                stringBuilder.append(C1487a.m6334j(parcel, i));
            case Base64.NO_WRAP /*2*/:
                stringBuilder.append(C1487a.m6333i(parcel, i));
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                stringBuilder.append(C1487a.m6335k(parcel, i));
            case Base64.CRLF /*4*/:
                stringBuilder.append(C1487a.m6336l(parcel, i));
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                stringBuilder.append(C1487a.m6337m(parcel, i));
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                stringBuilder.append(C1487a.m6327c(parcel, i));
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                stringBuilder.append("\"").append(gp.av(C1487a.m6339n(parcel, i))).append("\"");
            case Base64.URL_SAFE /*8*/:
                stringBuilder.append("\"").append(gj.m8602d(C1487a.m6343q(parcel, i))).append("\"");
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                stringBuilder.append("\"").append(gj.m8603e(C1487a.m6343q(parcel, i)));
                stringBuilder.append("\"");
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                Bundle p = C1487a.m6342p(parcel, i);
                Set<String> keySet = p.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(gp.av(p.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
            case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                Parcel B = C1487a.m6316B(parcel, i);
                B.setDataPosition(0);
                m8585a(stringBuilder, c1912a.fk(), B);
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void m8588b(StringBuilder stringBuilder, C1912a c1912a, Object obj) {
        if (c1912a.fc()) {
            m8589b(stringBuilder, c1912a, (ArrayList) obj);
        } else {
            m8582a(stringBuilder, c1912a.eW(), obj);
        }
    }

    private void m8589b(StringBuilder stringBuilder, C1912a c1912a, ArrayList arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m8582a(stringBuilder, c1912a.eW(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap m8590c(Bundle bundle) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    private static HashMap m8591c(HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C1912a) entry.getValue()).ff()), entry);
        }
        return hashMap2;
    }

    protected Object aq(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean ar(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        gh ghVar = CREATOR;
        return 0;
    }

    public HashMap eY() {
        return this.Eg == null ? null : this.Eg.au(this.mClassName);
    }

    public Parcel fq() {
        switch (this.Ep) {
            case Base64.DEFAULT /*0*/:
                this.Eq = C1488b.m6380p(this.En);
                C1488b.m6355F(this.En, this.Eq);
                this.Ep = 2;
                break;
            case Base64.NO_PADDING /*1*/:
                C1488b.m6355F(this.En, this.Eq);
                this.Ep = 2;
                break;
        }
        return this.En;
    }

    gd fr() {
        switch (this.Eo) {
            case Base64.DEFAULT /*0*/:
                return null;
            case Base64.NO_PADDING /*1*/:
                return this.Eg;
            case Base64.NO_WRAP /*2*/:
                return this.Eg;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.Eo);
        }
    }

    public int getVersionCode() {
        return this.xH;
    }

    public String toString() {
        fq.m8517b(this.Eg, (Object) "Cannot convert to JSON on client side.");
        Parcel fq = fq();
        fq.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m8585a(stringBuilder, this.Eg.au(this.mClassName), fq);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        gh ghVar = CREATOR;
        gh.m8592a(this, out, flags);
    }
}
