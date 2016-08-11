package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.internal.fb;

public abstract class FilteredDataBuffer extends DataBuffer {
    protected final DataBuffer mDataBuffer;

    public FilteredDataBuffer(DataBuffer dataBuffer) {
        super(null);
        fb.m8419d(dataBuffer);
        fb.m8418a(!(dataBuffer instanceof FilteredDataBuffer), "Not possible to have nested FilteredDataBuffers.");
        this.mDataBuffer = dataBuffer;
    }

    public void close() {
        this.mDataBuffer.close();
    }

    protected abstract int computeRealPosition(int i);

    public Object get(int position) {
        return this.mDataBuffer.get(computeRealPosition(position));
    }

    public Bundle getMetadata() {
        return this.mDataBuffer.getMetadata();
    }

    public boolean isClosed() {
        return this.mDataBuffer.isClosed();
    }
}
