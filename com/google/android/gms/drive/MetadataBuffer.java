package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C1581c;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;
import java.util.List;

public final class MetadataBuffer extends DataBuffer {
    private static final String[] EL;
    private final String EM;
    private C1491a EN;

    /* renamed from: com.google.android.gms.drive.MetadataBuffer.a */
    private static class C1491a extends Metadata {
        private final DataHolder BB;
        private final int BE;
        private final int EO;

        public C1491a(DataHolder dataHolder, int i) {
            this.BB = dataHolder;
            this.EO = i;
            this.BE = dataHolder.m6272G(i);
        }

        protected Object m6387a(MetadataField metadataField) {
            return metadataField.m6631a(this.BB, this.EO, this.BE);
        }

        public Metadata fB() {
            MetadataBundle fT = MetadataBundle.fT();
            for (MetadataField a : C1581c.fS()) {
                a.m6632a(this.BB, fT, this.EO, this.BE);
            }
            return new C1494b(fT);
        }

        public /* synthetic */ Object freeze() {
            return fB();
        }

        public boolean isDataValid() {
            return !this.BB.isClosed();
        }
    }

    static {
        List arrayList = new ArrayList();
        for (MetadataField fR : C1581c.fS()) {
            arrayList.addAll(fR.fR());
        }
        EL = (String[]) arrayList.toArray(new String[0]);
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.EM = nextPageToken;
    }

    public Metadata get(int row) {
        C1491a c1491a = this.EN;
        if (c1491a != null && c1491a.EO == row) {
            return c1491a;
        }
        Metadata c1491a2 = new C1491a(this.BB, row);
        this.EN = c1491a2;
        return c1491a2;
    }

    public String getNextPageToken() {
        return this.EM;
    }
}
