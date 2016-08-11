package com.avg.ui.general.components;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.C0066l;
import android.support.v4.app.C0075i;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.avg.toolkit.C0961d;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.zen.C1044a;
import com.avg.toolkit.zen.C1045b;
import com.avg.toolkit.zen.C1051f;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.components.C1104e.C1097a;
import com.avg.ui.general.p042g.C0719b;
import com.avg.ui.general.p055a.C1059b;
import com.avg.ui.general.p056h.C1064a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

public class DrawerActivity extends C1059b implements OnClickListener, C1096c, C1095d, C1097a {
    private C1045b f3313o;
    private C1044a f3314p;

    /* renamed from: com.avg.ui.general.components.DrawerActivity.1 */
    class C10921 implements C1064a {
        final /* synthetic */ DrawerActivity f3306a;

        C10921(DrawerActivity drawerActivity) {
            this.f3306a = drawerActivity;
        }

        public void m4672a(IBinder binder) {
            C1094a type = (C1094a) this.f3306a.getIntent().getExtras().getSerializable("fragment_type");
            if (type == null) {
                type = C1094a.LOGIN;
            }
            C1051f zenFeature = (C1051f) ((C0961d) binder).m4305a(23000);
            this.f3306a.f3313o = zenFeature.m4578b();
            this.f3306a.f3314p = zenFeature.m4579c();
            this.f3306a.m4679a(type);
        }
    }

    /* renamed from: com.avg.ui.general.components.DrawerActivity.2 */
    static /* synthetic */ class C10932 {
        static final /* synthetic */ int[] f3307a;

        static {
            f3307a = new int[C1094a.values().length];
            try {
                f3307a[C1094a.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3307a[C1094a.LOGIN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3307a[C1094a.JOIN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3307a[C1094a.MORE_APPS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.avg.ui.general.components.DrawerActivity.a */
    public enum C1094a {
        MORE_APPS,
        LOGIN,
        JOIN,
        NETWORK
    }

    public void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        setContentView(C1084h.drawer_activity_layout);
        m4617a("", false);
        m4586a(new C10921(this));
    }

    private void m4679a(C1094a type) {
        C0719b fragment = null;
        switch (C10932.f3307a[type.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                fragment = new C1117g();
                break;
            case Base64.NO_WRAP /*2*/:
                fragment = C1113f.m4721a(false, this.f3314p.m4535d(getApplicationContext()), false);
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                fragment = new C1104e();
                break;
            case Base64.CRLF /*4*/:
                fragment = new C0721h();
                break;
        }
        Fragment loadedFragment = m258g().m260a(C1082f.fragmentContainer);
        if (loadedFragment == null || !((C0719b) loadedFragment).m3336b().equals(fragment.m3336b())) {
            C0066l transaction = m258g().m262a();
            transaction.m189b(C1082f.fragmentContainer, (Fragment) fragment, type.name());
            transaction.m188b();
        }
        ((TextView) m1486h().m1449a().findViewById(C1082f.actionBarUpButton)).setText(fragment.m3337c());
    }

    public C1045b m4681k() {
        return this.f3313o;
    }

    public void onClick(View v) {
        onBackPressed();
    }

    public void onBackPressed() {
        C0075i manager = m258g();
        int count = manager.m272e();
        if (count > 0) {
            ((TextView) m1486h().m1449a().findViewById(C1082f.actionBarUpButton)).setText(((C0719b) manager.m273f().get(count - 1)).m3337c());
            View currentFocus = getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
            }
        }
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            C0970a.m4325b(e.getMessage());
        }
    }

    public void m4682l() {
        m4679a(C1094a.NETWORK);
    }

    public void m4683m() {
        onBackPressed();
    }

    public void m4684n() {
    }

    protected void onDestroy() {
        m4588t();
        super.onDestroy();
    }
}
