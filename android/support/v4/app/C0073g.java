package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.p010d.C0137h;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.games.request.GameRequest;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.g */
public class C0073g extends Activity {
    final Handler f186a;
    final C0082j f187b;
    final C0032h f188c;
    boolean f189d;
    boolean f190e;
    boolean f191f;
    boolean f192g;
    boolean f193h;
    boolean f194i;
    boolean f195j;
    boolean f196k;
    C0137h f197l;
    C0094o f198m;

    /* renamed from: android.support.v4.app.g.1 */
    class C00701 extends Handler {
        final /* synthetic */ C0073g f179a;

        C00701(C0073g c0073g) {
            this.f179a = c0073g;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Base64.NO_PADDING /*1*/:
                    if (this.f179a.f191f) {
                        this.f179a.m251a(false);
                    }
                case Base64.NO_WRAP /*2*/:
                    this.f179a.m253b();
                    this.f179a.f187b.m329h();
                default:
                    super.handleMessage(msg);
            }
        }
    }

    /* renamed from: android.support.v4.app.g.2 */
    class C00712 implements C0032h {
        final /* synthetic */ C0073g f180a;

        C00712(C0073g c0073g) {
            this.f180a = c0073g;
        }

        public View m243a(int id) {
            return this.f180a.findViewById(id);
        }

        public boolean m244a() {
            Window window = this.f180a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    /* renamed from: android.support.v4.app.g.a */
    static final class C0072a {
        Object f181a;
        Object f182b;
        C0137h f183c;
        ArrayList f184d;
        C0137h f185e;

        C0072a() {
        }
    }

    public C0073g() {
        this.f186a = new C00701(this);
        this.f187b = new C0082j();
        this.f188c = new C00712(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.f187b.m333l();
        int index = requestCode >> 16;
        if (index != 0) {
            index--;
            if (this.f187b.f219f == null || index < 0 || index >= this.f187b.f219f.size()) {
                Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(requestCode));
                return;
            }
            Fragment frag = (Fragment) this.f187b.f219f.get(index);
            if (frag == null) {
                Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(requestCode));
                return;
            } else {
                frag.onActivityResult(GameRequest.TYPE_ALL & requestCode, resultCode, data);
                return;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onBackPressed() {
        if (!this.f187b.m322d()) {
            a_();
        }
    }

    public void a_() {
        C0041a.m137b(this);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.f187b.m290a(newConfig);
    }

    protected void onCreate(Bundle savedInstanceState) {
        ArrayList arrayList = null;
        this.f187b.m297a(this, this.f188c, null);
        if (getLayoutInflater().getFactory() == null) {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(savedInstanceState);
        C0072a nc = (C0072a) getLastNonConfigurationInstance();
        if (nc != null) {
            this.f197l = nc.f185e;
        }
        if (savedInstanceState != null) {
            Parcelable p = savedInstanceState.getParcelable("android:support:fragments");
            C0082j c0082j = this.f187b;
            if (nc != null) {
                arrayList = nc.f184d;
            }
            c0082j.m292a(p, arrayList);
        }
        this.f187b.m334m();
    }

    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        if (featureId != 0) {
            return super.onCreatePanelMenu(featureId, menu);
        }
        boolean show = super.onCreatePanelMenu(featureId, menu) | this.f187b.m304a(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return show;
        }
        return true;
    }

    public View onCreateView(String name, Context context, AttributeSet attrs) {
        if (!"fragment".equals(name)) {
            return super.onCreateView(name, context, attrs);
        }
        View v = this.f187b.onCreateView(name, context, attrs);
        if (v == null) {
            return super.onCreateView(name, context, attrs);
        }
        return v;
    }

    protected void onDestroy() {
        super.onDestroy();
        m251a(false);
        this.f187b.m342u();
        if (this.f198m != null) {
            this.f198m.m421h();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (VERSION.SDK_INT >= 5 || keyCode != 4 || event.getRepeatCount() != 0) {
            return super.onKeyDown(keyCode, event);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f187b.m343v();
    }

    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        if (super.onMenuItemSelected(featureId, item)) {
            return true;
        }
        switch (featureId) {
            case Base64.DEFAULT /*0*/:
                return this.f187b.m305a(item);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return this.f187b.m314b(item);
            default:
                return false;
        }
    }

    public void onPanelClosed(int featureId, Menu menu) {
        switch (featureId) {
            case Base64.DEFAULT /*0*/:
                this.f187b.m312b(menu);
                break;
        }
        super.onPanelClosed(featureId, menu);
    }

    protected void onPause() {
        super.onPause();
        this.f190e = false;
        if (this.f186a.hasMessages(2)) {
            this.f186a.removeMessages(2);
            m253b();
        }
        this.f187b.m338q();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f187b.m333l();
    }

    protected void onResume() {
        super.onResume();
        this.f186a.sendEmptyMessage(2);
        this.f190e = true;
        this.f187b.m329h();
    }

    protected void onPostResume() {
        super.onPostResume();
        this.f186a.removeMessages(2);
        m253b();
        this.f187b.m329h();
    }

    protected void m253b() {
        this.f187b.m337p();
    }

    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        if (featureId != 0 || menu == null) {
            return super.onPreparePanel(featureId, view, menu);
        }
        if (this.f194i) {
            this.f194i = false;
            menu.clear();
            onCreatePanelMenu(featureId, menu);
        }
        return m252a(view, menu) | this.f187b.m303a(menu);
    }

    protected boolean m252a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.f191f) {
            m251a(true);
        }
        Object custom = m254c();
        ArrayList fragments = this.f187b.m331j();
        boolean retainLoaders = false;
        if (this.f197l != null) {
            int i;
            int N = this.f197l.size();
            C0094o[] loaders = new C0094o[N];
            for (i = N - 1; i >= 0; i--) {
                loaders[i] = (C0094o) this.f197l.m538c(i);
            }
            for (i = 0; i < N; i++) {
                C0094o lm = loaders[i];
                if (lm.f284g) {
                    retainLoaders = true;
                } else {
                    lm.m421h();
                    this.f197l.remove(lm.f281d);
                }
            }
        }
        if (fragments == null && !retainLoaders && custom == null) {
            return null;
        }
        Object nci = new C0072a();
        nci.f181a = null;
        nci.f182b = custom;
        nci.f183c = null;
        nci.f184d = fragments;
        nci.f185e = this.f197l;
        return nci;
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Parcelable p = this.f187b.m332k();
        if (p != null) {
            outState.putParcelable("android:support:fragments", p);
        }
    }

    protected void onStart() {
        super.onStart();
        this.f191f = false;
        this.f192g = false;
        this.f186a.removeMessages(1);
        if (!this.f189d) {
            this.f189d = true;
            this.f187b.m335n();
        }
        this.f187b.m333l();
        this.f187b.m329h();
        if (!this.f196k) {
            this.f196k = true;
            if (this.f198m != null) {
                this.f198m.m415b();
            } else if (!this.f195j) {
                this.f198m = m247a("(root)", this.f196k, false);
                if (!(this.f198m == null || this.f198m.f283f)) {
                    this.f198m.m415b();
                }
            }
            this.f195j = true;
        }
        this.f187b.m336o();
        if (this.f197l != null) {
            int i;
            int N = this.f197l.size();
            C0094o[] loaders = new C0094o[N];
            for (i = N - 1; i >= 0; i--) {
                loaders[i] = (C0094o) this.f197l.m538c(i);
            }
            for (i = 0; i < N; i++) {
                C0094o lm = loaders[i];
                lm.m418e();
                lm.m420g();
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.f191f = true;
        this.f186a.sendEmptyMessage(1);
        this.f187b.m339r();
    }

    public Object m254c() {
        return null;
    }

    public Object m255d() {
        C0072a nc = (C0072a) getLastNonConfigurationInstance();
        return nc != null ? nc.f182b : null;
    }

    public void m256e() {
        if (VERSION.SDK_INT >= 11) {
            C0058c.m177a(this);
        } else {
            this.f194i = true;
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String innerPrefix;
        if (VERSION.SDK_INT >= 11) {
            writer.print(prefix);
            writer.print("Local FragmentActivity ");
            writer.print(Integer.toHexString(System.identityHashCode(this)));
            writer.println(" State:");
            innerPrefix = prefix + "  ";
            writer.print(innerPrefix);
            writer.print("mCreated=");
            writer.print(this.f189d);
            writer.print("mResumed=");
            writer.print(this.f190e);
            writer.print(" mStopped=");
            writer.print(this.f191f);
            writer.print(" mReallyStopped=");
            writer.println(this.f192g);
            writer.print(innerPrefix);
            writer.print("mLoadersStarted=");
            writer.println(this.f196k);
        } else {
            writer.print(prefix);
            writer.print("Local FragmentActivity ");
            writer.print(Integer.toHexString(System.identityHashCode(this)));
            writer.println(" State:");
            innerPrefix = prefix + "  ";
            writer.print(innerPrefix);
            writer.print("mCreated=");
            writer.print(this.f189d);
            writer.print("mResumed=");
            writer.print(this.f190e);
            writer.print(" mStopped=");
            writer.print(this.f191f);
            writer.print(" mReallyStopped=");
            writer.println(this.f192g);
            writer.print(innerPrefix);
            writer.print("mLoadersStarted=");
            writer.println(this.f196k);
        }
        if (this.f198m != null) {
            writer.print(prefix);
            writer.print("Loader Manager ");
            writer.print(Integer.toHexString(System.identityHashCode(this.f198m)));
            writer.println(":");
            this.f198m.m412a(prefix + "  ", fd, writer, args);
        }
        this.f187b.m301a(prefix, fd, writer, args);
        writer.print(prefix);
        writer.println("View Hierarchy:");
        m246a(prefix + "  ", writer, getWindow().getDecorView());
    }

    private static String m245a(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder out = new StringBuilder(Cast.MAX_NAMESPACE_LENGTH);
        out.append(view.getClass().getName());
        out.append('{');
        out.append(Integer.toHexString(System.identityHashCode(view)));
        out.append(' ');
        switch (view.getVisibility()) {
            case Base64.DEFAULT /*0*/:
                out.append('V');
                break;
            case Base64.CRLF /*4*/:
                out.append('I');
                break;
            case Base64.URL_SAFE /*8*/:
                out.append('G');
                break;
            default:
                out.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        out.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        out.append(c);
        out.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        out.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        out.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        out.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        out.append(c);
        out.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        out.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        out.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        out.append(c3);
        out.append(' ');
        out.append(view.getLeft());
        out.append(',');
        out.append(view.getTop());
        out.append('-');
        out.append(view.getRight());
        out.append(',');
        out.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            out.append(" #");
            out.append(Integer.toHexString(id));
            Resources r = view.getResources();
            if (!(id == 0 || r == null)) {
                String pkgname;
                switch (-16777216 & id) {
                    case 16777216:
                        pkgname = "android";
                        break;
                    case 2130706432:
                        pkgname = "app";
                        break;
                    default:
                        try {
                            pkgname = r.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String typename = r.getResourceTypeName(id);
                String entryname = r.getResourceEntryName(id);
                out.append(" ");
                out.append(pkgname);
                out.append(":");
                out.append(typename);
                out.append("/");
                out.append(entryname);
            }
        }
        out.append("}");
        return out.toString();
    }

    private void m246a(String prefix, PrintWriter writer, View view) {
        writer.print(prefix);
        if (view == null) {
            writer.println("null");
            return;
        }
        writer.println(C0073g.m245a(view));
        if (view instanceof ViewGroup) {
            ViewGroup grp = (ViewGroup) view;
            int N = grp.getChildCount();
            if (N > 0) {
                prefix = prefix + "  ";
                for (int i = 0; i < N; i++) {
                    m246a(prefix, writer, grp.getChildAt(i));
                }
            }
        }
    }

    void m251a(boolean retaining) {
        if (!this.f192g) {
            this.f192g = true;
            this.f193h = retaining;
            this.f186a.removeMessages(1);
            m257f();
        }
    }

    void m257f() {
        if (this.f196k) {
            this.f196k = false;
            if (this.f198m != null) {
                if (this.f193h) {
                    this.f198m.m417d();
                } else {
                    this.f198m.m416c();
                }
            }
        }
        this.f187b.m340s();
    }

    public void m248a(Fragment fragment) {
    }

    public C0075i m258g() {
        return this.f187b;
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        if (requestCode == -1 || (-65536 & requestCode) == 0) {
            super.startActivityForResult(intent, requestCode);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public void m249a(Fragment fragment, Intent intent, int requestCode) {
        if (requestCode == -1) {
            super.startActivityForResult(intent, -1);
        } else if ((-65536 & requestCode) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            super.startActivityForResult(intent, ((fragment.mIndex + 1) << 16) + (GameRequest.TYPE_ALL & requestCode));
        }
    }

    void m250a(String who) {
        if (this.f197l != null) {
            C0094o lm = (C0094o) this.f197l.get(who);
            if (lm != null && !lm.f284g) {
                lm.m421h();
                this.f197l.remove(who);
            }
        }
    }

    C0094o m247a(String who, boolean started, boolean create) {
        if (this.f197l == null) {
            this.f197l = new C0137h();
        }
        C0094o lm = (C0094o) this.f197l.get(who);
        if (lm != null) {
            lm.m410a(this);
            return lm;
        } else if (!create) {
            return lm;
        } else {
            lm = new C0094o(who, this, started);
            this.f197l.put(who, lm);
            return lm;
        }
    }
}
