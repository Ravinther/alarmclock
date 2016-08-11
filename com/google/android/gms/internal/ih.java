package com.google.android.gms.internal;

import android.os.Parcel;
import com.avg.ui.general.C1091c.C1087k;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C1912a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.Person.AgeRange;
import com.google.android.gms.plus.model.people.Person.Cover;
import com.google.android.gms.plus.model.people.Person.Cover.CoverInfo;
import com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto;
import com.google.android.gms.plus.model.people.Person.Image;
import com.google.android.gms.plus.model.people.Person.Name;
import com.google.android.gms.plus.model.people.Person.Organizations;
import com.google.android.gms.plus.model.people.Person.PlacesLived;
import com.google.android.gms.plus.model.people.Person.Urls;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMRequest;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ih extends ga implements SafeParcelable, Person {
    public static final ii CREATOR;
    private static final HashMap UI;
    private String HA;
    private final Set UJ;
    private String VH;
    private C1982a VI;
    private String VJ;
    private String VK;
    private int VL;
    private C1985b VM;
    private String VN;
    private C1986c VO;
    private boolean VP;
    private String VQ;
    private C1987d VR;
    private String VS;
    private int VT;
    private List VU;
    private List VV;
    private int VW;
    private int VX;
    private String VY;
    private List VZ;
    private boolean Wa;
    private int lZ;
    private String ro;
    private String wp;
    private final int xH;

    /* renamed from: com.google.android.gms.internal.ih.a */
    public static final class C1982a extends ga implements SafeParcelable, AgeRange {
        public static final ij CREATOR;
        private static final HashMap UI;
        private final Set UJ;
        private int Wb;
        private int Wc;
        private final int xH;

        static {
            CREATOR = new ij();
            UI = new HashMap();
            UI.put("max", C1912a.m8552g("max", 2));
            UI.put("min", C1912a.m8552g("min", 3));
        }

        public C1982a() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C1982a(Set set, int i, int i2, int i3) {
            this.UJ = set;
            this.xH = i;
            this.Wb = i2;
            this.Wc = i3;
        }

        protected boolean m8768a(C1912a c1912a) {
            return this.UJ.contains(Integer.valueOf(c1912a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        protected Object m8769b(C1912a c1912a) {
            switch (c1912a.ff()) {
                case Base64.NO_WRAP /*2*/:
                    return Integer.valueOf(this.Wb);
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    return Integer.valueOf(this.Wc);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
            }
        }

        public int describeContents() {
            ij ijVar = CREATOR;
            return 0;
        }

        public HashMap eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1982a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1982a c1982a = (C1982a) obj;
            for (C1912a c1912a : UI.values()) {
                if (m8768a(c1912a)) {
                    if (!c1982a.m8768a(c1912a)) {
                        return false;
                    }
                    if (!m8769b(c1912a).equals(c1982a.m8769b(c1912a))) {
                        return false;
                    }
                } else if (c1982a.m8768a(c1912a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jD();
        }

        public int getMax() {
            return this.Wb;
        }

        public int getMin() {
            return this.Wc;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasMax() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasMin() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C1912a c1912a : UI.values()) {
                int hashCode;
                if (m8768a(c1912a)) {
                    hashCode = m8769b(c1912a).hashCode() + (i + c1912a.ff());
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

        public C1982a jD() {
            return this;
        }

        Set ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            ij ijVar = CREATOR;
            ij.m8790a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.b */
    public static final class C1985b extends ga implements SafeParcelable, Cover {
        public static final ik CREATOR;
        private static final HashMap UI;
        private final Set UJ;
        private C1983a Wd;
        private C1984b We;
        private int Wf;
        private final int xH;

        /* renamed from: com.google.android.gms.internal.ih.b.a */
        public static final class C1983a extends ga implements SafeParcelable, CoverInfo {
            public static final il CREATOR;
            private static final HashMap UI;
            private final Set UJ;
            private int Wg;
            private int Wh;
            private final int xH;

            static {
                CREATOR = new il();
                UI = new HashMap();
                UI.put("leftImageOffset", C1912a.m8552g("leftImageOffset", 2));
                UI.put("topImageOffset", C1912a.m8552g("topImageOffset", 3));
            }

            public C1983a() {
                this.xH = 1;
                this.UJ = new HashSet();
            }

            C1983a(Set set, int i, int i2, int i3) {
                this.UJ = set;
                this.xH = i;
                this.Wg = i2;
                this.Wh = i3;
            }

            protected boolean m8770a(C1912a c1912a) {
                return this.UJ.contains(Integer.valueOf(c1912a.ff()));
            }

            protected Object aq(String str) {
                return null;
            }

            protected boolean ar(String str) {
                return false;
            }

            protected Object m8771b(C1912a c1912a) {
                switch (c1912a.ff()) {
                    case Base64.NO_WRAP /*2*/:
                        return Integer.valueOf(this.Wg);
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        return Integer.valueOf(this.Wh);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
                }
            }

            public int describeContents() {
                il ilVar = CREATOR;
                return 0;
            }

            public HashMap eY() {
                return UI;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1983a)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1983a c1983a = (C1983a) obj;
                for (C1912a c1912a : UI.values()) {
                    if (m8770a(c1912a)) {
                        if (!c1983a.m8770a(c1912a)) {
                            return false;
                        }
                        if (!m8771b(c1912a).equals(c1983a.m8771b(c1912a))) {
                            return false;
                        }
                    } else if (c1983a.m8770a(c1912a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return jH();
            }

            public int getLeftImageOffset() {
                return this.Wg;
            }

            public int getTopImageOffset() {
                return this.Wh;
            }

            int getVersionCode() {
                return this.xH;
            }

            public boolean hasLeftImageOffset() {
                return this.UJ.contains(Integer.valueOf(2));
            }

            public boolean hasTopImageOffset() {
                return this.UJ.contains(Integer.valueOf(3));
            }

            public int hashCode() {
                int i = 0;
                for (C1912a c1912a : UI.values()) {
                    int hashCode;
                    if (m8770a(c1912a)) {
                        hashCode = m8771b(c1912a).hashCode() + (i + c1912a.ff());
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

            public C1983a jH() {
                return this;
            }

            Set ja() {
                return this.UJ;
            }

            public void writeToParcel(Parcel out, int flags) {
                il ilVar = CREATOR;
                il.m8792a(this, out, flags);
            }
        }

        /* renamed from: com.google.android.gms.internal.ih.b.b */
        public static final class C1984b extends ga implements SafeParcelable, CoverPhoto {
            public static final im CREATOR;
            private static final HashMap UI;
            private final Set UJ;
            private int kr;
            private int ks;
            private String ro;
            private final int xH;

            static {
                CREATOR = new im();
                UI = new HashMap();
                UI.put(MMLayout.KEY_HEIGHT, C1912a.m8552g(MMLayout.KEY_HEIGHT, 2));
                UI.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1912a.m8555j(PlusShare.KEY_CALL_TO_ACTION_URL, 3));
                UI.put(MMLayout.KEY_WIDTH, C1912a.m8552g(MMLayout.KEY_WIDTH, 4));
            }

            public C1984b() {
                this.xH = 1;
                this.UJ = new HashSet();
            }

            C1984b(Set set, int i, int i2, String str, int i3) {
                this.UJ = set;
                this.xH = i;
                this.ks = i2;
                this.ro = str;
                this.kr = i3;
            }

            protected boolean m8772a(C1912a c1912a) {
                return this.UJ.contains(Integer.valueOf(c1912a.ff()));
            }

            protected Object aq(String str) {
                return null;
            }

            protected boolean ar(String str) {
                return false;
            }

            protected Object m8773b(C1912a c1912a) {
                switch (c1912a.ff()) {
                    case Base64.NO_WRAP /*2*/:
                        return Integer.valueOf(this.ks);
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        return this.ro;
                    case Base64.CRLF /*4*/:
                        return Integer.valueOf(this.kr);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
                }
            }

            public int describeContents() {
                im imVar = CREATOR;
                return 0;
            }

            public HashMap eY() {
                return UI;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof C1984b)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C1984b c1984b = (C1984b) obj;
                for (C1912a c1912a : UI.values()) {
                    if (m8772a(c1912a)) {
                        if (!c1984b.m8772a(c1912a)) {
                            return false;
                        }
                        if (!m8773b(c1912a).equals(c1984b.m8773b(c1912a))) {
                            return false;
                        }
                    } else if (c1984b.m8772a(c1912a)) {
                        return false;
                    }
                }
                return true;
            }

            public /* synthetic */ Object freeze() {
                return jI();
            }

            public int getHeight() {
                return this.ks;
            }

            public String getUrl() {
                return this.ro;
            }

            int getVersionCode() {
                return this.xH;
            }

            public int getWidth() {
                return this.kr;
            }

            public boolean hasHeight() {
                return this.UJ.contains(Integer.valueOf(2));
            }

            public boolean hasUrl() {
                return this.UJ.contains(Integer.valueOf(3));
            }

            public boolean hasWidth() {
                return this.UJ.contains(Integer.valueOf(4));
            }

            public int hashCode() {
                int i = 0;
                for (C1912a c1912a : UI.values()) {
                    int hashCode;
                    if (m8772a(c1912a)) {
                        hashCode = m8773b(c1912a).hashCode() + (i + c1912a.ff());
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

            public C1984b jI() {
                return this;
            }

            Set ja() {
                return this.UJ;
            }

            public void writeToParcel(Parcel out, int flags) {
                im imVar = CREATOR;
                im.m8793a(this, out, flags);
            }
        }

        static {
            CREATOR = new ik();
            UI = new HashMap();
            UI.put("coverInfo", C1912a.m8549a("coverInfo", 2, C1983a.class));
            UI.put("coverPhoto", C1912a.m8549a("coverPhoto", 3, C1984b.class));
            UI.put("layout", C1912a.m8548a("layout", 4, new fx().m8540f("banner", 0), false));
        }

        public C1985b() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C1985b(Set set, int i, C1983a c1983a, C1984b c1984b, int i2) {
            this.UJ = set;
            this.xH = i;
            this.Wd = c1983a;
            this.We = c1984b;
            this.Wf = i2;
        }

        protected boolean m8774a(C1912a c1912a) {
            return this.UJ.contains(Integer.valueOf(c1912a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        protected Object m8775b(C1912a c1912a) {
            switch (c1912a.ff()) {
                case Base64.NO_WRAP /*2*/:
                    return this.Wd;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    return this.We;
                case Base64.CRLF /*4*/:
                    return Integer.valueOf(this.Wf);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
            }
        }

        public int describeContents() {
            ik ikVar = CREATOR;
            return 0;
        }

        public HashMap eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1985b)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1985b c1985b = (C1985b) obj;
            for (C1912a c1912a : UI.values()) {
                if (m8774a(c1912a)) {
                    if (!c1985b.m8774a(c1912a)) {
                        return false;
                    }
                    if (!m8775b(c1912a).equals(c1985b.m8775b(c1912a))) {
                        return false;
                    }
                } else if (c1985b.m8774a(c1912a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jG();
        }

        public CoverInfo getCoverInfo() {
            return this.Wd;
        }

        public CoverPhoto getCoverPhoto() {
            return this.We;
        }

        public int getLayout() {
            return this.Wf;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasCoverInfo() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasCoverPhoto() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public boolean hasLayout() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C1912a c1912a : UI.values()) {
                int hashCode;
                if (m8774a(c1912a)) {
                    hashCode = m8775b(c1912a).hashCode() + (i + c1912a.ff());
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

        C1983a jE() {
            return this.Wd;
        }

        C1984b jF() {
            return this.We;
        }

        public C1985b jG() {
            return this;
        }

        Set ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            ik ikVar = CREATOR;
            ik.m8791a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.c */
    public static final class C1986c extends ga implements SafeParcelable, Image {
        public static final in CREATOR;
        private static final HashMap UI;
        private final Set UJ;
        private String ro;
        private final int xH;

        static {
            CREATOR = new in();
            UI = new HashMap();
            UI.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1912a.m8555j(PlusShare.KEY_CALL_TO_ACTION_URL, 2));
        }

        public C1986c() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        public C1986c(String str) {
            this.UJ = new HashSet();
            this.xH = 1;
            this.ro = str;
            this.UJ.add(Integer.valueOf(2));
        }

        C1986c(Set set, int i, String str) {
            this.UJ = set;
            this.xH = i;
            this.ro = str;
        }

        protected boolean m8776a(C1912a c1912a) {
            return this.UJ.contains(Integer.valueOf(c1912a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        protected Object m8777b(C1912a c1912a) {
            switch (c1912a.ff()) {
                case Base64.NO_WRAP /*2*/:
                    return this.ro;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
            }
        }

        public int describeContents() {
            in inVar = CREATOR;
            return 0;
        }

        public HashMap eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1986c)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1986c c1986c = (C1986c) obj;
            for (C1912a c1912a : UI.values()) {
                if (m8776a(c1912a)) {
                    if (!c1986c.m8776a(c1912a)) {
                        return false;
                    }
                    if (!m8777b(c1912a).equals(c1986c.m8777b(c1912a))) {
                        return false;
                    }
                } else if (c1986c.m8776a(c1912a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jJ();
        }

        public String getUrl() {
            return this.ro;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasUrl() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public int hashCode() {
            int i = 0;
            for (C1912a c1912a : UI.values()) {
                int hashCode;
                if (m8776a(c1912a)) {
                    hashCode = m8777b(c1912a).hashCode() + (i + c1912a.ff());
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

        public C1986c jJ() {
            return this;
        }

        Set ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            in inVar = CREATOR;
            in.m8794a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.d */
    public static final class C1987d extends ga implements SafeParcelable, Name {
        public static final io CREATOR;
        private static final HashMap UI;
        private final Set UJ;
        private String Vh;
        private String Vk;
        private String Wi;
        private String Wj;
        private String Wk;
        private String Wl;
        private final int xH;

        static {
            CREATOR = new io();
            UI = new HashMap();
            UI.put("familyName", C1912a.m8555j("familyName", 2));
            UI.put("formatted", C1912a.m8555j("formatted", 3));
            UI.put("givenName", C1912a.m8555j("givenName", 4));
            UI.put("honorificPrefix", C1912a.m8555j("honorificPrefix", 5));
            UI.put("honorificSuffix", C1912a.m8555j("honorificSuffix", 6));
            UI.put("middleName", C1912a.m8555j("middleName", 7));
        }

        public C1987d() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C1987d(Set set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.UJ = set;
            this.xH = i;
            this.Vh = str;
            this.Wi = str2;
            this.Vk = str3;
            this.Wj = str4;
            this.Wk = str5;
            this.Wl = str6;
        }

        protected boolean m8778a(C1912a c1912a) {
            return this.UJ.contains(Integer.valueOf(c1912a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        protected Object m8779b(C1912a c1912a) {
            switch (c1912a.ff()) {
                case Base64.NO_WRAP /*2*/:
                    return this.Vh;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    return this.Wi;
                case Base64.CRLF /*4*/:
                    return this.Vk;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    return this.Wj;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    return this.Wk;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    return this.Wl;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
            }
        }

        public int describeContents() {
            io ioVar = CREATOR;
            return 0;
        }

        public HashMap eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1987d)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1987d c1987d = (C1987d) obj;
            for (C1912a c1912a : UI.values()) {
                if (m8778a(c1912a)) {
                    if (!c1987d.m8778a(c1912a)) {
                        return false;
                    }
                    if (!m8779b(c1912a).equals(c1987d.m8779b(c1912a))) {
                        return false;
                    }
                } else if (c1987d.m8778a(c1912a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jK();
        }

        public String getFamilyName() {
            return this.Vh;
        }

        public String getFormatted() {
            return this.Wi;
        }

        public String getGivenName() {
            return this.Vk;
        }

        public String getHonorificPrefix() {
            return this.Wj;
        }

        public String getHonorificSuffix() {
            return this.Wk;
        }

        public String getMiddleName() {
            return this.Wl;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasFamilyName() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasFormatted() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public boolean hasGivenName() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public boolean hasHonorificPrefix() {
            return this.UJ.contains(Integer.valueOf(5));
        }

        public boolean hasHonorificSuffix() {
            return this.UJ.contains(Integer.valueOf(6));
        }

        public boolean hasMiddleName() {
            return this.UJ.contains(Integer.valueOf(7));
        }

        public int hashCode() {
            int i = 0;
            for (C1912a c1912a : UI.values()) {
                int hashCode;
                if (m8778a(c1912a)) {
                    hashCode = m8779b(c1912a).hashCode() + (i + c1912a.ff());
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

        public C1987d jK() {
            return this;
        }

        Set ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            io ioVar = CREATOR;
            io.m8795a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.e */
    public static class C1988e {
        public static int bi(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.f */
    public static final class C1989f extends ga implements SafeParcelable, Organizations {
        public static final ip CREATOR;
        private static final HashMap UI;
        private String EB;
        private String HD;
        private int LF;
        private final Set UJ;
        private String Vg;
        private String Vw;
        private String Wm;
        private String Wn;
        private boolean Wo;
        private String mName;
        private final int xH;

        static {
            CREATOR = new ip();
            UI = new HashMap();
            UI.put("department", C1912a.m8555j("department", 2));
            UI.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C1912a.m8555j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 3));
            UI.put("endDate", C1912a.m8555j("endDate", 4));
            UI.put("location", C1912a.m8555j("location", 5));
            UI.put("name", C1912a.m8555j("name", 6));
            UI.put("primary", C1912a.m8554i("primary", 7));
            UI.put("startDate", C1912a.m8555j("startDate", 8));
            UI.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, C1912a.m8555j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 9));
            UI.put("type", C1912a.m8548a("type", 10, new fx().m8540f("work", 0).m8540f("school", 1), false));
        }

        public C1989f() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C1989f(Set set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.UJ = set;
            this.xH = i;
            this.Wm = str;
            this.HD = str2;
            this.Vg = str3;
            this.Wn = str4;
            this.mName = str5;
            this.Wo = z;
            this.Vw = str6;
            this.EB = str7;
            this.LF = i2;
        }

        protected boolean m8780a(C1912a c1912a) {
            return this.UJ.contains(Integer.valueOf(c1912a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        protected Object m8781b(C1912a c1912a) {
            switch (c1912a.ff()) {
                case Base64.NO_WRAP /*2*/:
                    return this.Wm;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    return this.HD;
                case Base64.CRLF /*4*/:
                    return this.Vg;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    return this.Wn;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    return this.mName;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                    return Boolean.valueOf(this.Wo);
                case Base64.URL_SAFE /*8*/:
                    return this.Vw;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                    return this.EB;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                    return Integer.valueOf(this.LF);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
            }
        }

        public int describeContents() {
            ip ipVar = CREATOR;
            return 0;
        }

        public HashMap eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1989f)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1989f c1989f = (C1989f) obj;
            for (C1912a c1912a : UI.values()) {
                if (m8780a(c1912a)) {
                    if (!c1989f.m8780a(c1912a)) {
                        return false;
                    }
                    if (!m8781b(c1912a).equals(c1989f.m8781b(c1912a))) {
                        return false;
                    }
                } else if (c1989f.m8780a(c1912a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jL();
        }

        public String getDepartment() {
            return this.Wm;
        }

        public String getDescription() {
            return this.HD;
        }

        public String getEndDate() {
            return this.Vg;
        }

        public String getLocation() {
            return this.Wn;
        }

        public String getName() {
            return this.mName;
        }

        public String getStartDate() {
            return this.Vw;
        }

        public String getTitle() {
            return this.EB;
        }

        public int getType() {
            return this.LF;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasDepartment() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasDescription() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public boolean hasEndDate() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public boolean hasLocation() {
            return this.UJ.contains(Integer.valueOf(5));
        }

        public boolean hasName() {
            return this.UJ.contains(Integer.valueOf(6));
        }

        public boolean hasPrimary() {
            return this.UJ.contains(Integer.valueOf(7));
        }

        public boolean hasStartDate() {
            return this.UJ.contains(Integer.valueOf(8));
        }

        public boolean hasTitle() {
            return this.UJ.contains(Integer.valueOf(9));
        }

        public boolean hasType() {
            return this.UJ.contains(Integer.valueOf(10));
        }

        public int hashCode() {
            int i = 0;
            for (C1912a c1912a : UI.values()) {
                int hashCode;
                if (m8780a(c1912a)) {
                    hashCode = m8781b(c1912a).hashCode() + (i + c1912a.ff());
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

        public boolean isPrimary() {
            return this.Wo;
        }

        public C1989f jL() {
            return this;
        }

        Set ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            ip ipVar = CREATOR;
            ip.m8796a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.g */
    public static final class C1990g extends ga implements SafeParcelable, PlacesLived {
        public static final iq CREATOR;
        private static final HashMap UI;
        private final Set UJ;
        private boolean Wo;
        private String mValue;
        private final int xH;

        static {
            CREATOR = new iq();
            UI = new HashMap();
            UI.put("primary", C1912a.m8554i("primary", 2));
            UI.put("value", C1912a.m8555j("value", 3));
        }

        public C1990g() {
            this.xH = 1;
            this.UJ = new HashSet();
        }

        C1990g(Set set, int i, boolean z, String str) {
            this.UJ = set;
            this.xH = i;
            this.Wo = z;
            this.mValue = str;
        }

        protected boolean m8782a(C1912a c1912a) {
            return this.UJ.contains(Integer.valueOf(c1912a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        protected Object m8783b(C1912a c1912a) {
            switch (c1912a.ff()) {
                case Base64.NO_WRAP /*2*/:
                    return Boolean.valueOf(this.Wo);
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    return this.mValue;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
            }
        }

        public int describeContents() {
            iq iqVar = CREATOR;
            return 0;
        }

        public HashMap eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1990g)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1990g c1990g = (C1990g) obj;
            for (C1912a c1912a : UI.values()) {
                if (m8782a(c1912a)) {
                    if (!c1990g.m8782a(c1912a)) {
                        return false;
                    }
                    if (!m8783b(c1912a).equals(c1990g.m8783b(c1912a))) {
                        return false;
                    }
                } else if (c1990g.m8782a(c1912a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jM();
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasPrimary() {
            return this.UJ.contains(Integer.valueOf(2));
        }

        public boolean hasValue() {
            return this.UJ.contains(Integer.valueOf(3));
        }

        public int hashCode() {
            int i = 0;
            for (C1912a c1912a : UI.values()) {
                int hashCode;
                if (m8782a(c1912a)) {
                    hashCode = m8783b(c1912a).hashCode() + (i + c1912a.ff());
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

        public boolean isPrimary() {
            return this.Wo;
        }

        public C1990g jM() {
            return this;
        }

        Set ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            iq iqVar = CREATOR;
            iq.m8797a(this, out, flags);
        }
    }

    /* renamed from: com.google.android.gms.internal.ih.h */
    public static final class C1991h extends ga implements SafeParcelable, Urls {
        public static final ir CREATOR;
        private static final HashMap UI;
        private int LF;
        private final Set UJ;
        private String Wp;
        private final int Wq;
        private String mValue;
        private final int xH;

        static {
            CREATOR = new ir();
            UI = new HashMap();
            UI.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, C1912a.m8555j(PlusShare.KEY_CALL_TO_ACTION_LABEL, 5));
            UI.put("type", C1912a.m8548a("type", 6, new fx().m8540f("home", 0).m8540f("work", 1).m8540f("blog", 2).m8540f(Scopes.PROFILE, 3).m8540f(MMRequest.ORIENTATION_OTHER, 4).m8540f("otherProfile", 5).m8540f("contributor", 6).m8540f("website", 7), false));
            UI.put("value", C1912a.m8555j("value", 4));
        }

        public C1991h() {
            this.Wq = 4;
            this.xH = 2;
            this.UJ = new HashSet();
        }

        C1991h(Set set, int i, String str, int i2, String str2, int i3) {
            this.Wq = 4;
            this.UJ = set;
            this.xH = i;
            this.Wp = str;
            this.LF = i2;
            this.mValue = str2;
        }

        protected boolean m8784a(C1912a c1912a) {
            return this.UJ.contains(Integer.valueOf(c1912a.ff()));
        }

        protected Object aq(String str) {
            return null;
        }

        protected boolean ar(String str) {
            return false;
        }

        protected Object m8785b(C1912a c1912a) {
            switch (c1912a.ff()) {
                case Base64.CRLF /*4*/:
                    return this.mValue;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    return this.Wp;
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                    return Integer.valueOf(this.LF);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
            }
        }

        public int describeContents() {
            ir irVar = CREATOR;
            return 0;
        }

        public HashMap eY() {
            return UI;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1991h)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C1991h c1991h = (C1991h) obj;
            for (C1912a c1912a : UI.values()) {
                if (m8784a(c1912a)) {
                    if (!c1991h.m8784a(c1912a)) {
                        return false;
                    }
                    if (!m8785b(c1912a).equals(c1991h.m8785b(c1912a))) {
                        return false;
                    }
                } else if (c1991h.m8784a(c1912a)) {
                    return false;
                }
            }
            return true;
        }

        public /* synthetic */ Object freeze() {
            return jO();
        }

        public String getLabel() {
            return this.Wp;
        }

        public int getType() {
            return this.LF;
        }

        public String getValue() {
            return this.mValue;
        }

        int getVersionCode() {
            return this.xH;
        }

        public boolean hasLabel() {
            return this.UJ.contains(Integer.valueOf(5));
        }

        public boolean hasType() {
            return this.UJ.contains(Integer.valueOf(6));
        }

        public boolean hasValue() {
            return this.UJ.contains(Integer.valueOf(4));
        }

        public int hashCode() {
            int i = 0;
            for (C1912a c1912a : UI.values()) {
                int hashCode;
                if (m8784a(c1912a)) {
                    hashCode = m8785b(c1912a).hashCode() + (i + c1912a.ff());
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

        @Deprecated
        public int jN() {
            return 4;
        }

        public C1991h jO() {
            return this;
        }

        Set ja() {
            return this.UJ;
        }

        public void writeToParcel(Parcel out, int flags) {
            ir irVar = CREATOR;
            ir.m8798a(this, out, flags);
        }
    }

    static {
        CREATOR = new ii();
        UI = new HashMap();
        UI.put("aboutMe", C1912a.m8555j("aboutMe", 2));
        UI.put("ageRange", C1912a.m8549a("ageRange", 3, C1982a.class));
        UI.put("birthday", C1912a.m8555j("birthday", 4));
        UI.put("braggingRights", C1912a.m8555j("braggingRights", 5));
        UI.put("circledByCount", C1912a.m8552g("circledByCount", 6));
        UI.put("cover", C1912a.m8549a("cover", 7, C1985b.class));
        UI.put("currentLocation", C1912a.m8555j("currentLocation", 8));
        UI.put("displayName", C1912a.m8555j("displayName", 9));
        UI.put(MMRequest.KEY_GENDER, C1912a.m8548a(MMRequest.KEY_GENDER, 12, new fx().m8540f(MMRequest.GENDER_MALE, 0).m8540f(MMRequest.GENDER_FEMALE, 1).m8540f(MMRequest.ORIENTATION_OTHER, 2), false));
        UI.put("id", C1912a.m8555j("id", 14));
        UI.put("image", C1912a.m8549a("image", 15, C1986c.class));
        UI.put("isPlusUser", C1912a.m8554i("isPlusUser", 16));
        UI.put("language", C1912a.m8555j("language", 18));
        UI.put("name", C1912a.m8549a("name", 19, C1987d.class));
        UI.put("nickname", C1912a.m8555j("nickname", 20));
        UI.put("objectType", C1912a.m8548a("objectType", 21, new fx().m8540f("person", 0).m8540f("page", 1), false));
        UI.put("organizations", C1912a.m8550b("organizations", 22, C1989f.class));
        UI.put("placesLived", C1912a.m8550b("placesLived", 23, C1990g.class));
        UI.put("plusOneCount", C1912a.m8552g("plusOneCount", 24));
        UI.put("relationshipStatus", C1912a.m8548a("relationshipStatus", 25, new fx().m8540f(MMRequest.MARITAL_SINGLE, 0).m8540f("in_a_relationship", 1).m8540f(MMRequest.MARITAL_ENGAGED, 2).m8540f(MMRequest.MARITAL_MARRIED, 3).m8540f("its_complicated", 4).m8540f("open_relationship", 5).m8540f("widowed", 6).m8540f("in_domestic_partnership", 7).m8540f("in_civil_union", 8), false));
        UI.put("tagline", C1912a.m8555j("tagline", 26));
        UI.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1912a.m8555j(PlusShare.KEY_CALL_TO_ACTION_URL, 27));
        UI.put("urls", C1912a.m8550b("urls", 28, C1991h.class));
        UI.put("verified", C1912a.m8554i("verified", 29));
    }

    public ih() {
        this.xH = 2;
        this.UJ = new HashSet();
    }

    public ih(String str, String str2, C1986c c1986c, int i, String str3) {
        this.xH = 2;
        this.UJ = new HashSet();
        this.HA = str;
        this.UJ.add(Integer.valueOf(9));
        this.wp = str2;
        this.UJ.add(Integer.valueOf(14));
        this.VO = c1986c;
        this.UJ.add(Integer.valueOf(15));
        this.VT = i;
        this.UJ.add(Integer.valueOf(21));
        this.ro = str3;
        this.UJ.add(Integer.valueOf(27));
    }

    ih(Set set, int i, String str, C1982a c1982a, String str2, String str3, int i2, C1985b c1985b, String str4, String str5, int i3, String str6, C1986c c1986c, boolean z, String str7, C1987d c1987d, String str8, int i4, List list, List list2, int i5, int i6, String str9, String str10, List list3, boolean z2) {
        this.UJ = set;
        this.xH = i;
        this.VH = str;
        this.VI = c1982a;
        this.VJ = str2;
        this.VK = str3;
        this.VL = i2;
        this.VM = c1985b;
        this.VN = str4;
        this.HA = str5;
        this.lZ = i3;
        this.wp = str6;
        this.VO = c1986c;
        this.VP = z;
        this.VQ = str7;
        this.VR = c1987d;
        this.VS = str8;
        this.VT = i4;
        this.VU = list;
        this.VV = list2;
        this.VW = i5;
        this.VX = i6;
        this.VY = str9;
        this.ro = str10;
        this.VZ = list3;
        this.Wa = z2;
    }

    public static ih m8786i(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ih aN = CREATOR.aN(obtain);
        obtain.recycle();
        return aN;
    }

    protected boolean m8787a(C1912a c1912a) {
        return this.UJ.contains(Integer.valueOf(c1912a.ff()));
    }

    protected Object aq(String str) {
        return null;
    }

    protected boolean ar(String str) {
        return false;
    }

    protected Object m8788b(C1912a c1912a) {
        switch (c1912a.ff()) {
            case Base64.NO_WRAP /*2*/:
                return this.VH;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return this.VI;
            case Base64.CRLF /*4*/:
                return this.VJ;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return this.VK;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return Integer.valueOf(this.VL);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return this.VM;
            case Base64.URL_SAFE /*8*/:
                return this.VN;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                return this.HA;
            case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                return Integer.valueOf(this.lZ);
            case C2513R.styleable.MMAdView_height /*14*/:
                return this.wp;
            case C2513R.styleable.MMAdView_width /*15*/:
                return this.VO;
            case Base64.NO_CLOSE /*16*/:
                return Boolean.valueOf(this.VP);
            case C1087k.ActionBar_itemPadding /*18*/:
                return this.VQ;
            case Encoder.LINE_GROUPS /*19*/:
                return this.VR;
            case MMException.DISPLAY_AD_NOT_READY /*20*/:
                return this.VS;
            case MMException.DISPLAY_AD_EXPIRED /*21*/:
                return Integer.valueOf(this.VT);
            case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                return this.VU;
            case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                return this.VV;
            case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                return Integer.valueOf(this.VW);
            case MMException.AD_BROKEN_REFERENCE /*25*/:
                return Integer.valueOf(this.VX);
            case MMException.AD_NO_ACTIVITY /*26*/:
                return this.VY;
            case 27:
                return this.ro;
            case 28:
                return this.VZ;
            case 29:
                return Boolean.valueOf(this.Wa);
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
        }
    }

    public int describeContents() {
        ii iiVar = CREATOR;
        return 0;
    }

    public HashMap eY() {
        return UI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ih)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ih ihVar = (ih) obj;
        for (C1912a c1912a : UI.values()) {
            if (m8787a(c1912a)) {
                if (!ihVar.m8787a(c1912a)) {
                    return false;
                }
                if (!m8788b(c1912a).equals(ihVar.m8788b(c1912a))) {
                    return false;
                }
            } else if (ihVar.m8787a(c1912a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return jC();
    }

    public String getAboutMe() {
        return this.VH;
    }

    public AgeRange getAgeRange() {
        return this.VI;
    }

    public String getBirthday() {
        return this.VJ;
    }

    public String getBraggingRights() {
        return this.VK;
    }

    public int getCircledByCount() {
        return this.VL;
    }

    public Cover getCover() {
        return this.VM;
    }

    public String getCurrentLocation() {
        return this.VN;
    }

    public String getDisplayName() {
        return this.HA;
    }

    public int getGender() {
        return this.lZ;
    }

    public String getId() {
        return this.wp;
    }

    public Image getImage() {
        return this.VO;
    }

    public String getLanguage() {
        return this.VQ;
    }

    public Name getName() {
        return this.VR;
    }

    public String getNickname() {
        return this.VS;
    }

    public int getObjectType() {
        return this.VT;
    }

    public List getOrganizations() {
        return (ArrayList) this.VU;
    }

    public List getPlacesLived() {
        return (ArrayList) this.VV;
    }

    public int getPlusOneCount() {
        return this.VW;
    }

    public int getRelationshipStatus() {
        return this.VX;
    }

    public String getTagline() {
        return this.VY;
    }

    public String getUrl() {
        return this.ro;
    }

    public List getUrls() {
        return (ArrayList) this.VZ;
    }

    int getVersionCode() {
        return this.xH;
    }

    public boolean hasAboutMe() {
        return this.UJ.contains(Integer.valueOf(2));
    }

    public boolean hasAgeRange() {
        return this.UJ.contains(Integer.valueOf(3));
    }

    public boolean hasBirthday() {
        return this.UJ.contains(Integer.valueOf(4));
    }

    public boolean hasBraggingRights() {
        return this.UJ.contains(Integer.valueOf(5));
    }

    public boolean hasCircledByCount() {
        return this.UJ.contains(Integer.valueOf(6));
    }

    public boolean hasCover() {
        return this.UJ.contains(Integer.valueOf(7));
    }

    public boolean hasCurrentLocation() {
        return this.UJ.contains(Integer.valueOf(8));
    }

    public boolean hasDisplayName() {
        return this.UJ.contains(Integer.valueOf(9));
    }

    public boolean hasGender() {
        return this.UJ.contains(Integer.valueOf(12));
    }

    public boolean hasId() {
        return this.UJ.contains(Integer.valueOf(14));
    }

    public boolean hasImage() {
        return this.UJ.contains(Integer.valueOf(15));
    }

    public boolean hasIsPlusUser() {
        return this.UJ.contains(Integer.valueOf(16));
    }

    public boolean hasLanguage() {
        return this.UJ.contains(Integer.valueOf(18));
    }

    public boolean hasName() {
        return this.UJ.contains(Integer.valueOf(19));
    }

    public boolean hasNickname() {
        return this.UJ.contains(Integer.valueOf(20));
    }

    public boolean hasObjectType() {
        return this.UJ.contains(Integer.valueOf(21));
    }

    public boolean hasOrganizations() {
        return this.UJ.contains(Integer.valueOf(22));
    }

    public boolean hasPlacesLived() {
        return this.UJ.contains(Integer.valueOf(23));
    }

    public boolean hasPlusOneCount() {
        return this.UJ.contains(Integer.valueOf(24));
    }

    public boolean hasRelationshipStatus() {
        return this.UJ.contains(Integer.valueOf(25));
    }

    public boolean hasTagline() {
        return this.UJ.contains(Integer.valueOf(26));
    }

    public boolean hasUrl() {
        return this.UJ.contains(Integer.valueOf(27));
    }

    public boolean hasUrls() {
        return this.UJ.contains(Integer.valueOf(28));
    }

    public boolean hasVerified() {
        return this.UJ.contains(Integer.valueOf(29));
    }

    public int hashCode() {
        int i = 0;
        for (C1912a c1912a : UI.values()) {
            int hashCode;
            if (m8787a(c1912a)) {
                hashCode = m8788b(c1912a).hashCode() + (i + c1912a.ff());
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

    public boolean isPlusUser() {
        return this.VP;
    }

    public boolean isVerified() {
        return this.Wa;
    }

    List jA() {
        return this.VV;
    }

    List jB() {
        return this.VZ;
    }

    public ih jC() {
        return this;
    }

    Set ja() {
        return this.UJ;
    }

    C1982a jv() {
        return this.VI;
    }

    C1985b jw() {
        return this.VM;
    }

    C1986c jx() {
        return this.VO;
    }

    C1987d jy() {
        return this.VR;
    }

    List jz() {
        return this.VU;
    }

    public void writeToParcel(Parcel out, int flags) {
        ii iiVar = CREATOR;
        ii.m8789a(this, out, flags);
    }
}
