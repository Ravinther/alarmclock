package com.google.android.gms.internal;

import com.google.android.gms.internal.bn.C1762a;
import com.google.android.gms.internal.bs.C1760a;

public final class bl extends C1760a {
    private final Object li;
    private C1762a nl;
    private bk nm;

    public bl() {
        this.li = new Object();
    }

    public void m7909P() {
        synchronized (this.li) {
            if (this.nm != null) {
                this.nm.m7904X();
            }
        }
    }

    public void m7910a(bk bkVar) {
        synchronized (this.li) {
            this.nm = bkVar;
        }
    }

    public void m7911a(C1762a c1762a) {
        synchronized (this.li) {
            this.nl = c1762a;
        }
    }

    public void onAdClosed() {
        synchronized (this.li) {
            if (this.nm != null) {
                this.nm.m7905Y();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.li) {
            if (this.nl != null) {
                this.nl.m7912f(error == 3 ? 1 : 2);
                this.nl = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.li) {
            if (this.nm != null) {
                this.nm.m7906Z();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.li) {
            if (this.nl != null) {
                this.nl.m7912f(0);
                this.nl = null;
                return;
            }
            if (this.nm != null) {
                this.nm.ab();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.li) {
            if (this.nm != null) {
                this.nm.aa();
            }
        }
    }
}
