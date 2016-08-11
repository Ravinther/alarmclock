package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.internal.ad.C1733a;
import com.mopub.common.AdUrlGenerator;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ab implements OnGlobalLayoutListener, OnScrollChangedListener {
    private static final long lw;
    private HashSet lA;
    private final Object li;
    private final WeakReference ll;
    private WeakReference lm;
    private final WeakReference ln;
    private final C2049z lo;
    private final Context lp;
    private final ad lq;
    private boolean lr;
    private final WindowManager ls;
    private final PowerManager lt;
    private final KeyguardManager lu;
    private ac lv;
    private long lx;
    private boolean ly;
    private BroadcastReceiver lz;

    /* renamed from: com.google.android.gms.internal.ab.1 */
    class C17341 implements C1733a {
        final /* synthetic */ ab lB;

        C17341(ab abVar) {
            this.lB = abVar;
        }

        public void ay() {
            this.lB.lr = true;
            this.lB.m7806d(false);
            this.lB.ap();
        }
    }

    /* renamed from: com.google.android.gms.internal.ab.2 */
    class C17352 extends BroadcastReceiver {
        final /* synthetic */ ab lB;

        C17352(ab abVar) {
            this.lB = abVar;
        }

        public void onReceive(Context context, Intent intent) {
            this.lB.m7806d(false);
        }
    }

    /* renamed from: com.google.android.gms.internal.ab.3 */
    class C17363 implements bb {
        final /* synthetic */ ab lB;

        C17363(ab abVar) {
            this.lB = abVar;
        }

        public void m7789b(dz dzVar, Map map) {
            this.lB.m7798a(dzVar, map);
        }
    }

    /* renamed from: com.google.android.gms.internal.ab.4 */
    class C17374 implements bb {
        final /* synthetic */ ab lB;

        C17374(ab abVar) {
            this.lB = abVar;
        }

        public void m7790b(dz dzVar, Map map) {
            if (map.containsKey("pingType") && "unloadPing".equals(map.get("pingType"))) {
                this.lB.m7804c(this.lB.lq);
                dw.m8219x("Unregistered GMSG handlers for: " + this.lB.lo.ao());
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ab.5 */
    class C17385 implements bb {
        final /* synthetic */ ab lB;

        C17385(ab abVar) {
            this.lB = abVar;
        }

        public void m7791b(dz dzVar, Map map) {
            if (map.containsKey("isVisible")) {
                boolean z = "1".equals(map.get("isVisible")) || "true".equals(map.get("isVisible"));
                this.lB.m7805c(Boolean.valueOf(z).booleanValue());
            }
        }
    }

    static {
        lw = TimeUnit.MILLISECONDS.toNanos(100);
    }

    public ab(ak akVar, dh dhVar) {
        this(akVar, dhVar, dhVar.oj.bK(), dhVar.oj, new ae(dhVar.oj.getContext(), dhVar.oj.bK()));
    }

    public ab(ak akVar, dh dhVar, dx dxVar, View view, ad adVar) {
        this.li = new Object();
        this.lx = Long.MIN_VALUE;
        this.lA = new HashSet();
        this.ll = new WeakReference(dhVar);
        this.ln = new WeakReference(view);
        this.lm = new WeakReference(null);
        this.ly = true;
        this.lo = new C2049z(Integer.toString(dhVar.hashCode()), dxVar, akVar.lS, dhVar.qs);
        this.lq = adVar;
        this.ls = (WindowManager) view.getContext().getSystemService("window");
        this.lt = (PowerManager) view.getContext().getApplicationContext().getSystemService("power");
        this.lu = (KeyguardManager) view.getContext().getSystemService("keyguard");
        this.lp = view.getContext().getApplicationContext();
        m7797a(adVar);
        this.lq.m7807a(new C17341(this));
        m7802b(this.lq);
        dw.m8219x("Tracking ad unit: " + this.lo.ao());
    }

    protected int m7795a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    public void m7796a(ac acVar) {
        synchronized (this.li) {
            this.lv = acVar;
        }
    }

    protected void m7797a(ad adVar) {
        adVar.m7810d("http://googleads.g.doubleclick.net/mads/static/sdk/native/sdk-core-v40.html");
    }

    protected void m7798a(dz dzVar, Map map) {
        m7806d(false);
    }

    public void m7799a(C2044y c2044y) {
        this.lA.add(c2044y);
    }

    protected void m7800a(JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        this.lq.m7809a("AFMA_updateActiveView", jSONObject2);
    }

    protected boolean m7801a(View view, boolean z) {
        return view.getVisibility() == 0 && z && view.isShown() && this.lt.isScreenOn() && !this.lu.inKeyguardRestrictedInputMode();
    }

    protected void ap() {
        synchronized (this.li) {
            if (this.lz != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.lz = new C17352(this);
            this.lp.registerReceiver(this.lz, intentFilter);
        }
    }

    protected void aq() {
        synchronized (this.li) {
            if (this.lz != null) {
                this.lp.unregisterReceiver(this.lz);
                this.lz = null;
            }
        }
    }

    public void ar() {
        synchronized (this.li) {
            if (this.ly) {
                av();
                aq();
                try {
                    m7800a(ax());
                } catch (Throwable e) {
                    dw.m8214b("JSON Failure while processing active view data.", e);
                }
                this.ly = false;
                as();
                dw.m8219x("Untracked ad unit: " + this.lo.ao());
            }
        }
    }

    protected void as() {
        if (this.lv != null) {
            this.lv.m7783a(this);
        }
    }

    public boolean at() {
        boolean z;
        synchronized (this.li) {
            z = this.ly;
        }
        return z;
    }

    protected void au() {
        View view = (View) this.ln.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.lm.get();
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2 != viewTreeObserver) {
                this.lm = new WeakReference(viewTreeObserver2);
                viewTreeObserver2.addOnScrollChangedListener(this);
                viewTreeObserver2.addOnGlobalLayoutListener(this);
            }
        }
    }

    protected void av() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.lm.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    protected JSONObject aw() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("afmaVersion", this.lo.am()).put("activeViewJSON", this.lo.an()).put("timestamp", TimeUnit.NANOSECONDS.toMillis(System.nanoTime())).put("adFormat", this.lo.al()).put("hashCode", this.lo.ao());
        return jSONObject;
    }

    protected JSONObject ax() {
        JSONObject aw = aw();
        aw.put("doneReasonCode", AdUrlGenerator.DEVICE_ORIENTATION_UNKNOWN);
        return aw;
    }

    protected void m7802b(ad adVar) {
        adVar.m7808a("/updateActiveView", new C17363(this));
        adVar.m7808a("/activeViewPingSent", new C17374(this));
        adVar.m7808a("/visibilityChanged", new C17385(this));
        adVar.m7808a("/viewabilityChanged", ba.mG);
    }

    protected JSONObject m7803c(View view) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr);
        view.getLocationInWindow(iArr2);
        JSONObject aw = aw();
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        rect2.right = this.ls.getDefaultDisplay().getWidth();
        rect2.bottom = this.ls.getDefaultDisplay().getHeight();
        Rect rect3 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect3, null);
        Rect rect4 = new Rect();
        view.getLocalVisibleRect(rect4);
        aw.put("viewBox", new JSONObject().put("top", m7795a(rect2.top, displayMetrics)).put("bottom", m7795a(rect2.bottom, displayMetrics)).put("left", m7795a(rect2.left, displayMetrics)).put("right", m7795a(rect2.right, displayMetrics))).put("adBox", new JSONObject().put("top", m7795a(rect.top, displayMetrics)).put("bottom", m7795a(rect.bottom, displayMetrics)).put("left", m7795a(rect.left, displayMetrics)).put("right", m7795a(rect.right, displayMetrics))).put("globalVisibleBox", new JSONObject().put("top", m7795a(rect3.top, displayMetrics)).put("bottom", m7795a(rect3.bottom, displayMetrics)).put("left", m7795a(rect3.left, displayMetrics)).put("right", m7795a(rect3.right, displayMetrics))).put("localVisibleBox", new JSONObject().put("top", m7795a(rect4.top, displayMetrics)).put("bottom", m7795a(rect4.bottom, displayMetrics)).put("left", m7795a(rect4.left, displayMetrics)).put("right", m7795a(rect4.right, displayMetrics))).put("screenDensity", (double) displayMetrics.density).put("isVisible", m7801a(view, globalVisibleRect));
        return aw;
    }

    protected void m7804c(ad adVar) {
        adVar.m7811e("/viewabilityChanged");
        adVar.m7811e("/visibilityChanged");
        adVar.m7811e("/activeViewPingSent");
        adVar.m7811e("/updateActiveView");
    }

    protected void m7805c(boolean z) {
        Iterator it = this.lA.iterator();
        while (it.hasNext()) {
            ((C2044y) it.next()).m9018a(this, z);
        }
    }

    protected void m7806d(boolean z) {
        synchronized (this.li) {
            if (this.lr && this.ly) {
                long nanoTime = System.nanoTime();
                if (!z || this.lx + lw <= nanoTime) {
                    this.lx = nanoTime;
                    View view = (View) this.ln.get();
                    Object obj = (view == null || ((dh) this.ll.get()) == null) ? 1 : null;
                    if (obj != null) {
                        ar();
                        return;
                    }
                    try {
                        m7800a(m7803c(view));
                    } catch (Throwable e) {
                        dw.m8214b("Active view update failed.", e);
                    }
                    au();
                    as();
                    return;
                }
                return;
            }
        }
    }

    public void onGlobalLayout() {
        m7806d(false);
    }

    public void onScrollChanged() {
        m7806d(true);
    }
}
