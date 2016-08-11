package com.google.android.gms.appstate;

import com.google.android.gms.internal.fo;

/* renamed from: com.google.android.gms.appstate.a */
public final class C1419a implements AppState {
    private final int wr;
    private final String ws;
    private final byte[] wt;
    private final boolean wu;
    private final String wv;
    private final byte[] ww;

    public C1419a(AppState appState) {
        this.wr = appState.getKey();
        this.ws = appState.getLocalVersion();
        this.wt = appState.getLocalData();
        this.wu = appState.hasConflict();
        this.wv = appState.getConflictVersion();
        this.ww = appState.getConflictData();
    }

    static int m6092a(AppState appState) {
        return fo.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    static boolean m6093a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return fo.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && fo.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && fo.equal(appState2.getLocalData(), appState.getLocalData()) && fo.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && fo.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && fo.equal(appState2.getConflictData(), appState.getConflictData());
    }

    static String m6094b(AppState appState) {
        return fo.m8511e(appState).m8510a("Key", Integer.valueOf(appState.getKey())).m8510a("LocalVersion", appState.getLocalVersion()).m8510a("LocalData", appState.getLocalData()).m8510a("HasConflict", Boolean.valueOf(appState.hasConflict())).m8510a("ConflictVersion", appState.getConflictVersion()).m8510a("ConflictData", appState.getConflictData()).toString();
    }

    public AppState dt() {
        return this;
    }

    public boolean equals(Object obj) {
        return C1419a.m6093a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return dt();
    }

    public byte[] getConflictData() {
        return this.ww;
    }

    public String getConflictVersion() {
        return this.wv;
    }

    public int getKey() {
        return this.wr;
    }

    public byte[] getLocalData() {
        return this.wt;
    }

    public String getLocalVersion() {
        return this.ws;
    }

    public boolean hasConflict() {
        return this.wu;
    }

    public int hashCode() {
        return C1419a.m6092a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return C1419a.m6094b(this);
    }
}
