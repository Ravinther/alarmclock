package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C1912a;
import java.util.ArrayList;
import java.util.HashMap;

public class gd implements SafeParcelable {
    public static final ge CREATOR;
    private final HashMap Ei;
    private final ArrayList Ej;
    private final String Ek;
    private final int xH;

    /* renamed from: com.google.android.gms.internal.gd.a */
    public static class C1913a implements SafeParcelable {
        public static final gf CREATOR;
        final ArrayList El;
        final String className;
        final int versionCode;

        static {
            CREATOR = new gf();
        }

        C1913a(int i, String str, ArrayList arrayList) {
            this.versionCode = i;
            this.className = str;
            this.El = arrayList;
        }

        C1913a(String str, HashMap hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.El = C1913a.m8570b(hashMap);
        }

        private static ArrayList m8570b(HashMap hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new C1914b(str, (C1912a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            gf gfVar = CREATOR;
            return 0;
        }

        HashMap fp() {
            HashMap hashMap = new HashMap();
            int size = this.El.size();
            for (int i = 0; i < size; i++) {
                C1914b c1914b = (C1914b) this.El.get(i);
                hashMap.put(c1914b.eM, c1914b.Em);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            gf gfVar = CREATOR;
            gf.m8577a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.gd.b */
    public static class C1914b implements SafeParcelable {
        public static final gc CREATOR;
        final C1912a Em;
        final String eM;
        final int versionCode;

        static {
            CREATOR = new gc();
        }

        C1914b(int i, String str, C1912a c1912a) {
            this.versionCode = i;
            this.eM = str;
            this.Em = c1912a;
        }

        C1914b(String str, C1912a c1912a) {
            this.versionCode = 1;
            this.eM = str;
            this.Em = c1912a;
        }

        public int describeContents() {
            gc gcVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            gc gcVar = CREATOR;
            gc.m8567a(this, out, flags);
        }
    }

    static {
        CREATOR = new ge();
    }

    gd(int i, ArrayList arrayList, String str) {
        this.xH = i;
        this.Ej = null;
        this.Ei = m8571b(arrayList);
        this.Ek = (String) fq.m8520f(str);
        fl();
    }

    public gd(Class cls) {
        this.xH = 1;
        this.Ej = null;
        this.Ei = new HashMap();
        this.Ek = cls.getCanonicalName();
    }

    private static HashMap m8571b(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C1913a c1913a = (C1913a) arrayList.get(i);
            hashMap.put(c1913a.className, c1913a.fp());
        }
        return hashMap;
    }

    public void m8572a(Class cls, HashMap hashMap) {
        this.Ei.put(cls.getCanonicalName(), hashMap);
    }

    public HashMap au(String str) {
        return (HashMap) this.Ei.get(str);
    }

    public boolean m8573b(Class cls) {
        return this.Ei.containsKey(cls.getCanonicalName());
    }

    public int describeContents() {
        ge geVar = CREATOR;
        return 0;
    }

    public void fl() {
        for (String str : this.Ei.keySet()) {
            HashMap hashMap = (HashMap) this.Ei.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C1912a) hashMap.get(str2)).m8557a(this);
            }
        }
    }

    public void fm() {
        for (String str : this.Ei.keySet()) {
            HashMap hashMap = (HashMap) this.Ei.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((C1912a) hashMap.get(str2)).fb());
            }
            this.Ei.put(str, hashMap2);
        }
    }

    ArrayList fn() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.Ei.keySet()) {
            arrayList.add(new C1913a(str, (HashMap) this.Ei.get(str)));
        }
        return arrayList;
    }

    public String fo() {
        return this.Ek;
    }

    int getVersionCode() {
        return this.xH;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.Ei.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.Ei.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ge geVar = CREATOR;
        ge.m8574a(this, out, flags);
    }
}
