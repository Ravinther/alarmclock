package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.C1788c.C1787j;
import com.google.android.gms.tagmanager.bg.C2264a;
import com.google.android.gms.tagmanager.cd.C2271a;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

class cn implements Runnable {
    private final String WJ;
    private volatile String Xg;
    private final bm Zd;
    private final String Ze;
    private bg Zf;
    private volatile C2325r Zg;
    private volatile String Zh;
    private final Context mContext;

    cn(Context context, String str, bm bmVar, C2325r c2325r) {
        this.mContext = context;
        this.Zd = bmVar;
        this.WJ = str;
        this.Zg = c2325r;
        this.Ze = "/r?id=" + str;
        this.Xg = this.Ze;
        this.Zh = null;
    }

    public cn(Context context, String str, C2325r c2325r) {
        this(context, str, new bm(), c2325r);
    }

    private boolean kW() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        bh.m9375y("...no network connectivity");
        return false;
    }

    private void kX() {
        if (kW()) {
            bh.m9375y("Start loading resource from network ...");
            String kY = kY();
            bl kH = this.Zd.kH();
            try {
                InputStream bD = kH.bD(kY);
                try {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    cq.m9460b(bD, byteArrayOutputStream);
                    C1787j b = C1787j.m8010b(byteArrayOutputStream.toByteArray());
                    bh.m9375y("Successfully loaded supplemented resource: " + b);
                    if (b.fK == null && b.fJ.length == 0) {
                        bh.m9375y("No change for container: " + this.WJ);
                    }
                    this.Zf.m9369i(b);
                    bh.m9375y("Load resource from network finished.");
                } catch (Throwable e) {
                    bh.m9371c("Error when parsing downloaded resources from url: " + kY + " " + e.getMessage(), e);
                    this.Zf.m9368a(C2264a.SERVER_ERROR);
                    kH.close();
                }
            } catch (FileNotFoundException e2) {
                bh.m9376z("No data is retrieved from the given url: " + kY + ". Make sure container_id: " + this.WJ + " is correct.");
                this.Zf.m9368a(C2264a.SERVER_ERROR);
            } catch (Throwable e3) {
                bh.m9371c("Error when loading resources from url: " + kY + " " + e3.getMessage(), e3);
                this.Zf.m9368a(C2264a.IO_ERROR);
            } finally {
                kH.close();
            }
        } else {
            this.Zf.m9368a(C2264a.NOT_AVAILABLE);
        }
    }

    void m9428a(bg bgVar) {
        this.Zf = bgVar;
    }

    void bJ(String str) {
        bh.m9372v("Setting previous container version: " + str);
        this.Zh = str;
    }

    void bu(String str) {
        if (str == null) {
            this.Xg = this.Ze;
            return;
        }
        bh.m9372v("Setting CTFE URL path: " + str);
        this.Xg = str;
    }

    String kY() {
        String str = this.Zg.kn() + this.Xg + "&v=a65833898";
        if (!(this.Zh == null || this.Zh.trim().equals(""))) {
            str = str + "&pv=" + this.Zh;
        }
        return cd.kT().kU().equals(C2271a.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    public void run() {
        if (this.Zf == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.Zf.kl();
        kX();
    }
}
