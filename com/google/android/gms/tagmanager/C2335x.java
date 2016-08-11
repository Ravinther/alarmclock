package com.google.android.gms.tagmanager;

import android.util.Log;

/* renamed from: com.google.android.gms.tagmanager.x */
class C2335x implements bi {
    private int sz;

    C2335x() {
        this.sz = 5;
    }

    public void m9603b(String str, Throwable th) {
        if (this.sz <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    public void m9604c(String str, Throwable th) {
        if (this.sz <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }

    public void setLogLevel(int logLevel) {
        this.sz = logLevel;
    }

    public void m9605v(String str) {
        if (this.sz <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    public void m9606w(String str) {
        if (this.sz <= 6) {
            Log.e("GoogleTagManager", str);
        }
    }

    public void m9607x(String str) {
        if (this.sz <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    public void m9608y(String str) {
        if (this.sz <= 2) {
            Log.v("GoogleTagManager", str);
        }
    }

    public void m9609z(String str) {
        if (this.sz <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }
}
