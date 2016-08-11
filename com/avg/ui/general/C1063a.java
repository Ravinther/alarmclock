package com.avg.ui.general;

import android.os.AsyncTask;
import com.avg.ui.general.p042g.C0719b;
import java.lang.ref.WeakReference;

/* renamed from: com.avg.ui.general.a */
public abstract class C1063a extends AsyncTask {
    protected WeakReference f3258a;

    public void m4618a() {
        this.f3258a = null;
    }

    public void m4619a(C0719b callerFragment) {
        this.f3258a = new WeakReference(callerFragment);
    }
}
