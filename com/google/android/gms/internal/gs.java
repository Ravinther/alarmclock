package com.google.android.gms.internal;

import android.graphics.Bitmap;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1577b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.C1579a;
import com.google.android.gms.drive.metadata.internal.C1583e;
import com.google.android.gms.drive.metadata.internal.C1585g;
import com.google.android.gms.drive.metadata.internal.C1586h;
import com.google.android.gms.drive.metadata.internal.C1587i;
import com.google.android.gms.drive.metadata.internal.C1588j;
import com.google.android.gms.plus.PlusShare;

public class gs {
    public static final MetadataField FR;
    public static final MetadataField FS;
    public static final MetadataField FT;
    public static final MetadataField FU;
    public static final MetadataField FV;
    public static final MetadataField FW;
    public static final MetadataField FX;
    public static final MetadataField FY;
    public static final MetadataField FZ;
    public static final MetadataField Ga;
    public static final MetadataField Gb;
    public static final C1916a Gc;
    public static final MetadataField Gd;
    public static final MetadataField Ge;
    public static final MetadataField Gf;
    public static final MetadataField Gg;
    public static final C1917b Gh;
    public static final MetadataField Gi;
    public static final C1577b Gj;
    public static final C1918c Gk;
    public static final C1919d Gl;
    public static final C1920e Gm;
    public static final MetadataField Gn;
    public static final C1921f Go;
    public static final C1922g Gp;
    public static final MetadataField Gq;
    public static final MetadataField Gr;

    /* renamed from: com.google.android.gms.internal.gs.1 */
    static class C19151 extends C1586h {
        C19151(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object m8608b(DataHolder dataHolder, int i, int i2) {
            return m8609i(dataHolder, i, i2);
        }

        protected Bitmap m8609i(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    }

    /* renamed from: com.google.android.gms.internal.gs.a */
    public static class C1916a extends C1579a implements SearchableMetadataField {
        public C1916a(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs.b */
    public static class C1917b extends C1588j implements SearchableMetadataField {
        public C1917b(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs.c */
    public static class C1918c extends C1585g implements SearchableCollectionMetadataField {
        public C1918c(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs.d */
    public static class C1919d extends C1583e implements SortableMetadataField {
        public C1919d(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs.e */
    public static class C1920e extends C1579a implements SearchableMetadataField {
        public C1920e(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs.f */
    public static class C1921f extends C1588j implements SearchableMetadataField, SortableMetadataField {
        public C1921f(String str, int i) {
            super(str, i);
        }
    }

    /* renamed from: com.google.android.gms.internal.gs.g */
    public static class C1922g extends C1579a implements SearchableMetadataField {
        public C1922g(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object m8610b(DataHolder dataHolder, int i, int i2) {
            return m8611d(dataHolder, i, i2);
        }

        protected Boolean m8611d(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.getInteger(getName(), i, i2) != 0);
        }
    }

    static {
        FR = gu.Gx;
        FS = new C1588j("alternateLink", 4300000);
        FT = new C1588j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
        FU = new C1588j("embedLink", 4300000);
        FV = new C1588j("fileExtension", 4300000);
        FW = new C1583e("fileSize", 4300000);
        FX = new C1579a("hasThumbnail", 4300000);
        FY = new C1588j("indexableText", 4300000);
        FZ = new C1579a("isAppData", 4300000);
        Ga = new C1579a("isCopyable", 4300000);
        Gb = new C1579a("isEditable", 4100000);
        Gc = new C1916a("isPinned", 4100000);
        Gd = new C1579a("isRestricted", 4300000);
        Ge = new C1579a("isShared", 4300000);
        Gf = new C1579a("isTrashable", 4400000);
        Gg = new C1579a("isViewed", 4300000);
        Gh = new C1917b("mimeType", 4100000);
        Gi = new C1588j("originalFilename", 4300000);
        Gj = new C1587i("ownerNames", 4300000);
        Gk = new C1918c("parents", 4100000);
        Gl = new C1919d("quotaBytesUsed", 4300000);
        Gm = new C1920e("starred", 4100000);
        Gn = new C19151("thumbnail", 4400000);
        Go = new C1921f(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
        Gp = new C1922g("trashed", 4100000);
        Gq = new C1588j("webContentLink", 4300000);
        Gr = new C1588j("webViewLink", 4300000);
    }
}
