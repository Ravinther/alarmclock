package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.C1580b;

public class gt {
    public static final C1923a Gs;
    public static final C1924b Gt;
    public static final C1926d Gu;
    public static final C1925c Gv;
    public static final C1927e Gw;

    /* renamed from: com.google.android.gms.internal.gt.a */
    public static class C1923a extends C1580b implements SortableMetadataField {
        public C1923a(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gt.b */
    public static class C1924b extends C1580b implements SearchableOrderedMetadataField, SortableMetadataField {
        public C1924b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gt.c */
    public static class C1925c extends C1580b implements SortableMetadataField {
        public C1925c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gt.d */
    public static class C1926d extends C1580b implements SearchableOrderedMetadataField, SortableMetadataField {
        public C1926d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gt.e */
    public static class C1927e extends C1580b implements SearchableOrderedMetadataField, SortableMetadataField {
        public C1927e(String str, int i) {
            super(str, i);
        }
    }

    static {
        Gs = new C1923a("created", 4100000);
        Gt = new C1924b("lastOpenedTime", 4300000);
        Gu = new C1926d("modified", 4100000);
        Gv = new C1925c("modifiedByMe", 4100000);
        Gw = new C1927e("sharedWithMe", 4100000);
    }
}
