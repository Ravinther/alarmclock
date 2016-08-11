package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.C1473c;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.ih;
import com.google.android.gms.internal.is;

public final class PersonBuffer extends DataBuffer {
    private final C1473c Wr;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.getMetadata() == null || !dataHolder.getMetadata().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.Wr = null;
        } else {
            this.Wr = new C1473c(dataHolder, ih.CREATOR);
        }
    }

    public Person get(int position) {
        return this.Wr != null ? (Person) this.Wr.m6275F(position) : new is(this.BB, position);
    }
}
