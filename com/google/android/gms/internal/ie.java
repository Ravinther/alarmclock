package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C1912a;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class ie extends ga implements SafeParcelable, Moment {
    public static final C1981if CREATOR;
    private static final HashMap UI;
    private String Rd;
    private final Set UJ;
    private ic VE;
    private ic VF;
    private String Vw;
    private String wp;
    private final int xH;

    static {
        CREATOR = new C1981if();
        UI = new HashMap();
        UI.put("id", C1912a.m8555j("id", 2));
        UI.put("result", C1912a.m8549a("result", 4, ic.class));
        UI.put("startDate", C1912a.m8555j("startDate", 5));
        UI.put("target", C1912a.m8549a("target", 6, ic.class));
        UI.put("type", C1912a.m8555j("type", 7));
    }

    public ie() {
        this.xH = 1;
        this.UJ = new HashSet();
    }

    ie(Set set, int i, String str, ic icVar, String str2, ic icVar2, String str3) {
        this.UJ = set;
        this.xH = i;
        this.wp = str;
        this.VE = icVar;
        this.Vw = str2;
        this.VF = icVar2;
        this.Rd = str3;
    }

    public ie(Set set, String str, ic icVar, String str2, ic icVar2, String str3) {
        this.UJ = set;
        this.xH = 1;
        this.wp = str;
        this.VE = icVar;
        this.Vw = str2;
        this.VF = icVar2;
        this.Rd = str3;
    }

    protected boolean m8765a(C1912a c1912a) {
        return this.UJ.contains(Integer.valueOf(c1912a.ff()));
    }

    protected Object aq(String str) {
        return null;
    }

    protected boolean ar(String str) {
        return false;
    }

    protected Object m8766b(C1912a c1912a) {
        switch (c1912a.ff()) {
            case Base64.NO_WRAP /*2*/:
                return this.wp;
            case Base64.CRLF /*4*/:
                return this.VE;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return this.Vw;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return this.VF;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return this.Rd;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
        }
    }

    public int describeContents() {
        C1981if c1981if = CREATOR;
        return 0;
    }

    public HashMap eY() {
        return UI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ie)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ie ieVar = (ie) obj;
        for (C1912a c1912a : UI.values()) {
            if (m8765a(c1912a)) {
                if (!ieVar.m8765a(c1912a)) {
                    return false;
                }
                if (!m8766b(c1912a).equals(ieVar.m8766b(c1912a))) {
                    return false;
                }
            } else if (ieVar.m8765a(c1912a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return jt();
    }

    public String getId() {
        return this.wp;
    }

    public ItemScope getResult() {
        return this.VE;
    }

    public String getStartDate() {
        return this.Vw;
    }

    public ItemScope getTarget() {
        return this.VF;
    }

    public String getType() {
        return this.Rd;
    }

    int getVersionCode() {
        return this.xH;
    }

    public boolean hasId() {
        return this.UJ.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.UJ.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.UJ.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.UJ.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.UJ.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (C1912a c1912a : UI.values()) {
            int hashCode;
            if (m8765a(c1912a)) {
                hashCode = m8766b(c1912a).hashCode() + (i + c1912a.ff());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    Set ja() {
        return this.UJ;
    }

    ic jr() {
        return this.VE;
    }

    ic js() {
        return this.VF;
    }

    public ie jt() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        C1981if c1981if = CREATOR;
        C1981if.m8767a(this, out, flags);
    }
}
