package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.db.C1819a;
import com.google.android.gms.internal.ff.C1893e;

public class cw extends ff {
    final int pe;

    public cw(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.pe = i;
    }

    protected void m8096a(fm fmVar, C1893e c1893e) {
        fmVar.m8468g(c1893e, this.pe, getContext().getPackageName(), new Bundle());
    }

    protected String bg() {
        return "com.google.android.gms.ads.service.START";
    }

    protected String bh() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public db bi() {
        return (db) super.eM();
    }

    protected db m8097q(IBinder iBinder) {
        return C1819a.m8113s(iBinder);
    }

    protected /* synthetic */ IInterface m8098r(IBinder iBinder) {
        return m8097q(iBinder);
    }
}
