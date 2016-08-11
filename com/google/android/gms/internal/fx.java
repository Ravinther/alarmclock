package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C1910b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class fx implements SafeParcelable, C1910b {
    public static final fy CREATOR;
    private final HashMap DT;
    private final HashMap DU;
    private final ArrayList DV;
    private final int xH;

    /* renamed from: com.google.android.gms.internal.fx.a */
    public static final class C1909a implements SafeParcelable {
        public static final fz CREATOR;
        final String DW;
        final int DX;
        final int versionCode;

        static {
            CREATOR = new fz();
        }

        C1909a(int i, String str, int i2) {
            this.versionCode = i;
            this.DW = str;
            this.DX = i2;
        }

        C1909a(String str, int i) {
            this.versionCode = 1;
            this.DW = str;
            this.DX = i;
        }

        public int describeContents() {
            fz fzVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            fz fzVar = CREATOR;
            fz.m8545a(this, out, flags);
        }
    }

    static {
        CREATOR = new fy();
    }

    public fx() {
        this.xH = 1;
        this.DT = new HashMap();
        this.DU = new HashMap();
        this.DV = null;
    }

    fx(int i, ArrayList arrayList) {
        this.xH = i;
        this.DT = new HashMap();
        this.DU = new HashMap();
        this.DV = null;
        m8538a(arrayList);
    }

    private void m8538a(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1909a c1909a = (C1909a) it.next();
            m8540f(c1909a.DW, c1909a.DX);
        }
    }

    public String m8539a(Integer num) {
        String str = (String) this.DU.get(num);
        return (str == null && this.DT.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public int describeContents() {
        fy fyVar = CREATOR;
        return 0;
    }

    ArrayList eV() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.DT.keySet()) {
            arrayList.add(new C1909a(str, ((Integer) this.DT.get(str)).intValue()));
        }
        return arrayList;
    }

    public int eW() {
        return 7;
    }

    public int eX() {
        return 0;
    }

    public fx m8540f(String str, int i) {
        this.DT.put(str, Integer.valueOf(i));
        this.DU.put(Integer.valueOf(i), str);
        return this;
    }

    public /* synthetic */ Object m8541g(Object obj) {
        return m8539a((Integer) obj);
    }

    int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel out, int flags) {
        fy fyVar = CREATOR;
        fy.m8542a(this, out, flags);
    }
}
