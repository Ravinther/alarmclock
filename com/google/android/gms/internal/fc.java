package com.google.android.gms.internal;

import android.os.Parcel;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class fc {
    private final View AV;
    private final C1889a CT;

    /* renamed from: com.google.android.gms.internal.fc.a */
    public static final class C1889a implements SafeParcelable {
        public static final fp CREATOR;
        private final int AU;
        private final String AW;
        private final List CU;
        private final String wG;
        private final int xH;

        static {
            CREATOR = new fp();
        }

        C1889a(int i, String str, List list, int i2, String str2) {
            this.CU = new ArrayList();
            this.xH = i;
            this.wG = str;
            this.CU.addAll(list);
            this.AU = i2;
            this.AW = str2;
        }

        public C1889a(String str, Collection collection, int i, String str2) {
            this(3, str, new ArrayList(collection), i, str2);
        }

        public int describeContents() {
            return 0;
        }

        public String eC() {
            return this.wG != null ? this.wG : "<<default account>>";
        }

        public int eD() {
            return this.AU;
        }

        public List eE() {
            return new ArrayList(this.CU);
        }

        public String eG() {
            return this.AW;
        }

        public String getAccountName() {
            return this.wG;
        }

        public int getVersionCode() {
            return this.xH;
        }

        public void writeToParcel(Parcel out, int flags) {
            fp.m8512a(this, out, flags);
        }
    }

    public fc(String str, Collection collection, int i, View view, String str2) {
        this.CT = new C1889a(str, collection, i, str2);
        this.AV = view;
    }

    public String eC() {
        return this.CT.eC();
    }

    public int eD() {
        return this.CT.eD();
    }

    public List eE() {
        return this.CT.eE();
    }

    public String[] eF() {
        return (String[]) this.CT.eE().toArray(new String[0]);
    }

    public String eG() {
        return this.CT.eG();
    }

    public View eH() {
        return this.AV;
    }

    public String getAccountName() {
        return this.CT.getAccountName();
    }
}
