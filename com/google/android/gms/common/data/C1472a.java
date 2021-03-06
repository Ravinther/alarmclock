package com.google.android.gms.common.data;

import com.google.android.gms.internal.fq;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.common.data.a */
public final class C1472a implements Iterator {
    private int BC;
    private final DataBuffer mDataBuffer;

    public C1472a(DataBuffer dataBuffer) {
        this.mDataBuffer = (DataBuffer) fq.m8520f(dataBuffer);
        this.BC = -1;
    }

    public boolean hasNext() {
        return this.BC < this.mDataBuffer.getCount() + -1;
    }

    public Object next() {
        if (hasNext()) {
            DataBuffer dataBuffer = this.mDataBuffer;
            int i = this.BC + 1;
            this.BC = i;
            return dataBuffer.get(i);
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.BC);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
