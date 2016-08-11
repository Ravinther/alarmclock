package com.google.android.gms.analytics;

import android.content.Context;
import com.avg.toolkit.ITKSvc;
import com.google.android.gms.cast.Cast;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/* renamed from: com.google.android.gms.analytics.h */
class C1367h implements C1348m {
    private static final Object sf;
    private static C1367h st;
    private final Context mContext;
    private String su;
    private boolean sv;
    private final Object sw;

    /* renamed from: com.google.android.gms.analytics.h.1 */
    class C13661 extends Thread {
        final /* synthetic */ C1367h sx;

        C13661(C1367h c1367h, String str) {
            this.sx = c1367h;
            super(str);
        }

        public void run() {
            synchronized (this.sx.sw) {
                this.sx.su = this.sx.cf();
                this.sx.sv = true;
                this.sx.sw.notifyAll();
            }
        }
    }

    static {
        sf = new Object();
    }

    protected C1367h(Context context) {
        this.sv = false;
        this.sw = new Object();
        this.mContext = context;
        ce();
    }

    private boolean m5981D(String str) {
        try {
            aa.m5915y("Storing clientId.");
            FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(str.getBytes());
            openFileOutput.close();
            return true;
        } catch (FileNotFoundException e) {
            aa.m5913w("Error creating clientId file.");
            return false;
        } catch (IOException e2) {
            aa.m5913w("Error writing to clientId file.");
            return false;
        }
    }

    public static C1367h cb() {
        C1367h c1367h;
        synchronized (sf) {
            c1367h = st;
        }
        return c1367h;
    }

    private String cc() {
        if (!this.sv) {
            synchronized (this.sw) {
                if (!this.sv) {
                    aa.m5915y("Waiting for clientId to load");
                    do {
                        try {
                            this.sw.wait();
                        } catch (InterruptedException e) {
                            aa.m5913w("Exception while waiting for clientId: " + e);
                        }
                    } while (!this.sv);
                }
            }
        }
        aa.m5915y("Loaded clientId");
        return this.su;
    }

    private void ce() {
        new C13661(this, "client_id_fetcher").start();
    }

    public static void m5985n(Context context) {
        synchronized (sf) {
            if (st == null) {
                st = new C1367h(context);
            }
        }
    }

    public boolean m5986C(String str) {
        return "&cid".equals(str);
    }

    protected String cd() {
        String toLowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !m5981D(toLowerCase) ? ITKSvc.CODEREVISION : toLowerCase;
        } catch (Exception e) {
            return null;
        }
    }

    String cf() {
        String str = null;
        try {
            FileInputStream openFileInput = this.mContext.openFileInput("gaClientId");
            byte[] bArr = new byte[Cast.MAX_NAMESPACE_LENGTH];
            int read = openFileInput.read(bArr, 0, Cast.MAX_NAMESPACE_LENGTH);
            if (openFileInput.available() > 0) {
                aa.m5913w("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else if (read <= 0) {
                aa.m5913w("clientId file seems empty, deleting it.");
                openFileInput.close();
                this.mContext.deleteFile("gaClientId");
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    str = str2;
                } catch (FileNotFoundException e) {
                    str = str2;
                } catch (IOException e2) {
                    str = str2;
                    aa.m5913w("Error reading clientId file, deleting it.");
                    this.mContext.deleteFile("gaClientId");
                }
            }
        } catch (FileNotFoundException e3) {
        } catch (IOException e4) {
            aa.m5913w("Error reading clientId file, deleting it.");
            this.mContext.deleteFile("gaClientId");
        }
        return str == null ? cd() : str;
    }

    public String getValue(String field) {
        return "&cid".equals(field) ? cc() : null;
    }
}
