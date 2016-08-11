package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class dz extends WebView implements DownloadListener {
    private final Object li;
    private final WindowManager ls;
    private ak nq;
    private final dx nr;
    private final C2026l oJ;
    private final ea ru;
    private final C1832a rv;
    private cc rw;
    private boolean rx;
    private boolean ry;

    /* renamed from: com.google.android.gms.internal.dz.a */
    private static class C1832a extends MutableContextWrapper {
        private Context lp;
        private Activity rz;

        public C1832a(Context context) {
            super(context);
            setBaseContext(context);
        }

        public void setBaseContext(Context base) {
            this.lp = base.getApplicationContext();
            this.rz = base instanceof Activity ? (Activity) base : null;
            super.setBaseContext(this.lp);
        }

        public void startActivity(Intent intent) {
            if (this.rz != null) {
                this.rz.startActivity(intent);
                return;
            }
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            this.lp.startActivity(intent);
        }
    }

    private dz(C1832a c1832a, ak akVar, boolean z, boolean z2, C2026l c2026l, dx dxVar) {
        super(c1832a);
        this.li = new Object();
        this.rv = c1832a;
        this.nq = akVar;
        this.rx = z;
        this.oJ = c2026l;
        this.nr = dxVar;
        this.ls = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        dq.m8176a((Context) c1832a, dxVar.rq, settings);
        if (VERSION.SDK_INT >= 17) {
            dt.m8205a(getContext(), settings);
        } else if (VERSION.SDK_INT >= 11) {
            ds.m8199a(getContext(), settings);
        }
        setDownloadListener(this);
        if (VERSION.SDK_INT >= 11) {
            this.ru = new ec(this, z2);
        } else {
            this.ru = new ea(this, z2);
        }
        setWebViewClient(this.ru);
        if (VERSION.SDK_INT >= 14) {
            setWebChromeClient(new ed(this));
        } else if (VERSION.SDK_INT >= 11) {
            setWebChromeClient(new eb(this));
        }
        bM();
    }

    public static dz m8225a(Context context, ak akVar, boolean z, boolean z2, C2026l c2026l, dx dxVar) {
        return new dz(new C1832a(context), akVar, z, z2, c2026l, dxVar);
    }

    private void bM() {
        synchronized (this.li) {
            if (this.rx || this.nq.lT) {
                if (VERSION.SDK_INT < 14) {
                    dw.m8217v("Disabling hardware acceleration on an overlay.");
                    bN();
                } else {
                    dw.m8217v("Enabling hardware acceleration on an overlay.");
                    bO();
                }
            } else if (VERSION.SDK_INT < 18) {
                dw.m8217v("Disabling hardware acceleration on an AdView.");
                bN();
            } else {
                dw.m8217v("Enabling hardware acceleration on an AdView.");
                bO();
            }
        }
    }

    private void bN() {
        synchronized (this.li) {
            if (!this.ry && VERSION.SDK_INT >= 11) {
                ds.m8203d(this);
            }
            this.ry = true;
        }
    }

    private void bO() {
        synchronized (this.li) {
            if (this.ry && VERSION.SDK_INT >= 11) {
                ds.m8204e(this);
            }
            this.ry = false;
        }
    }

    public ak m8226R() {
        ak akVar;
        synchronized (this.li) {
            akVar = this.nq;
        }
        return akVar;
    }

    public void m8227a(Context context, ak akVar) {
        synchronized (this.li) {
            this.rv.setBaseContext(context);
            this.rw = null;
            this.nq = akVar;
            this.rx = false;
            dq.m8186b((WebView) this);
            loadUrl("about:blank");
            this.ru.reset();
        }
    }

    public void m8228a(ak akVar) {
        synchronized (this.li) {
            this.nq = akVar;
            requestLayout();
        }
    }

    public void m8229a(cc ccVar) {
        synchronized (this.li) {
            this.rw = ccVar;
        }
    }

    public void m8230a(String str, Map map) {
        try {
            m8232b(str, dq.m8192p(map));
        } catch (JSONException e) {
            dw.m8221z("Could not convert parameters to JSON.");
        }
    }

    public void m8231a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:" + str + "(");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        loadUrl(stringBuilder.toString());
    }

    public void m8232b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        dw.m8220y("Dispatching AFMA event: " + stringBuilder);
        loadUrl(stringBuilder.toString());
    }

    public void bE() {
        if (bI().bP()) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = this.ls.getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            try {
                m8232b("onScreenInfoChanged", new JSONObject().put(MMLayout.KEY_WIDTH, displayMetrics.widthPixels).put(MMLayout.KEY_HEIGHT, displayMetrics.heightPixels).put("density", (double) displayMetrics.density).put("rotation", defaultDisplay.getRotation()));
            } catch (Throwable e) {
                dw.m8214b("Error occured while obtaining screen information.", e);
            }
        }
    }

    public void bF() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.nr.rq);
        m8230a("onhide", hashMap);
    }

    public void bG() {
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.nr.rq);
        m8230a("onshow", hashMap);
    }

    public cc bH() {
        cc ccVar;
        synchronized (this.li) {
            ccVar = this.rw;
        }
        return ccVar;
    }

    public ea bI() {
        return this.ru;
    }

    public C2026l bJ() {
        return this.oJ;
    }

    public dx bK() {
        return this.nr;
    }

    public boolean bL() {
        boolean z;
        synchronized (this.li) {
            z = this.rx;
        }
        return z;
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            dw.m8217v("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = Integer.MAX_VALUE;
        synchronized (this.li) {
            if (isInEditMode() || this.rx) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                return;
            }
            int mode = MeasureSpec.getMode(widthMeasureSpec);
            int size = MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = MeasureSpec.getMode(heightMeasureSpec);
            int size2 = MeasureSpec.getSize(heightMeasureSpec);
            mode = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i = size2;
            }
            if (this.nq.widthPixels > mode || this.nq.heightPixels > r0) {
                dw.m8221z("Not enough space to show ad. Needs " + this.nq.widthPixels + "x" + this.nq.heightPixels + " pixels, but only has " + size + "x" + size2 + " pixels.");
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.nq.widthPixels, this.nq.heightPixels);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.oJ != null) {
            this.oJ.m8952a(event);
        }
        return super.onTouchEvent(event);
    }

    public void m8233p(boolean z) {
        synchronized (this.li) {
            this.rx = z;
            bM();
        }
    }

    public void setContext(Context context) {
        this.rv.setBaseContext(context);
    }
}
