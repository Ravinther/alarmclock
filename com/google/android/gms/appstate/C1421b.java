package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C1420b;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: com.google.android.gms.appstate.b */
public final class C1421b extends C1420b implements AppState {
    C1421b(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public AppState dt() {
        return new C1419a(this);
    }

    public boolean equals(Object obj) {
        return C1419a.m6093a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return dt();
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !ai("conflict_version");
    }

    public int hashCode() {
        return C1419a.m6092a(this);
    }

    public String toString() {
        return C1419a.m6094b(this);
    }
}
