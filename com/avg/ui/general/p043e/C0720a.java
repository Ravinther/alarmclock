package com.avg.ui.general.p043e;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.C0073g;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.C1063a;
import com.avg.ui.general.C1091c.C1077a;
import com.avg.ui.general.customviews.C1088a;
import com.avg.ui.general.p042g.C0719b;
import com.avg.ui.general.p042g.C1178c.C1057a;
import com.avg.ui.general.p058c.C1089a;
import com.avg.ui.general.p059d.C1161a;

/* renamed from: com.avg.ui.general.e.a */
public abstract class C0720a extends Fragment implements C0719b {
    private boolean f1849a;
    protected int f1850b;
    protected int f1851c;
    private boolean f1852d;
    private String f1853e;
    private String f1854f;
    private Menu f1855g;

    /* renamed from: com.avg.ui.general.e.a.1 */
    class C11651 implements Runnable {
        final /* synthetic */ int f3537a;
        final /* synthetic */ C0720a f3538b;

        C11651(C0720a c0720a, int i) {
            this.f3538b = c0720a;
            this.f3537a = i;
        }

        public void run() {
            this.f3538b.f1855g.performIdentifierAction(this.f3537a, 0);
        }
    }

    public int m3360c() {
        return 0;
    }

    public int m3363e() {
        return 0;
    }

    public C0720a() {
        this.f1849a = true;
        this.f1852d = false;
        this.f1853e = null;
        this.f1850b = 0;
        this.f1851c = 0;
        this.f1854f = null;
        setArguments(new Bundle());
    }

    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        nextAnim = enter ? this.f1850b : this.f1851c;
        if (this.f1849a && !this.f1852d && nextAnim != 0) {
            return AnimationUtils.loadAnimation(getActivity(), nextAnim);
        }
        this.f1852d = false;
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.f1853e = savedInstanceState.getString("key_ocm_after_event_str");
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        m3359b(true);
    }

    public void onResume() {
        super.onResume();
        this.f1852d = false;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("key_ocm_after_event_str", this.f1853e);
    }

    public int m3365f() {
        return 8;
    }

    protected void m3359b(boolean start) {
        try {
            m3369h().m4597a(m3367g(), start);
        } catch (C1161a e) {
        }
    }

    protected String m3367g() {
        return null;
    }

    protected C1057a m3369h() {
        C0073g activity = getActivity();
        if (activity == null) {
            throw new C1161a();
        }
        try {
            return (C1057a) activity;
        } catch (Throwable e) {
            throw new C1161a(e);
        }
    }

    protected void m3357a(String eventStr) {
        this.f1853e = eventStr;
    }

    protected String m3370i() {
        return this.f1853e;
    }

    public void m3361c(boolean layoutChange) {
        if (layoutChange && m3376o()) {
            this.f1850b = C1077a.fragment_content_from_left;
            this.f1851c = C1077a.fragment_content_to_left;
            return;
        }
        this.f1850b = C1077a.fragment_fullscreen_from_left;
        this.f1851c = C1077a.fragment_fullscreen_to_left;
    }

    public void m3362d(boolean layoutChange) {
        if (layoutChange && m3376o()) {
            this.f1851c = C1077a.fragment_content_to_right;
        } else {
            this.f1851c = C1077a.fragment_fullscreen_to_right;
        }
        try {
            m3369h().m4598b(this.f1853e, false);
            this.f1853e = null;
        } catch (C1161a e) {
            C0970a.m4325b("Failed to start OCM 'after' Overlay...");
        }
    }

    public void m3364e(boolean layoutChange) {
        if (layoutChange && m3376o()) {
            this.f1850b = C1077a.fragment_content_from_right;
        } else {
            this.f1850b = C1077a.fragment_fullscreen_from_right;
        }
    }

    public void m3366f(boolean isTop) {
        m3361c(false);
        if (isTop) {
            this.f1852d = true;
        }
    }

    public void m3353a(Bundle arguments) {
    }

    public C1063a m3371j() {
        return null;
    }

    public void m3354a(C1063a task) {
    }

    public void m3372k() {
        m3369h().a_(true);
        if (!m3369h().m4598b(this.f1853e, true)) {
            m3369h().m4599n();
        }
        this.f1853e = null;
    }

    protected void m3355a(C1089a dialogFragment) {
        m3356a(dialogFragment, dialogFragment.m4670p());
    }

    protected void m3356a(C1088a dialogFragment, String tag) {
        try {
            m3369h().m4595a(dialogFragment, tag);
        } catch (C1161a e) {
            C0970a.m4325b("Couldn't process showDialog command. Fragment is no longer visible?");
        }
    }

    public void m3358a(boolean isHardwareBack) {
        try {
            m3372k();
        } catch (C1161a e) {
            C0970a.m4325b("Couldn't process onBack command. Fragment is no longer visible?");
        }
    }

    public boolean m3373l() {
        return false;
    }

    public void m3374m() {
        boolean canExit = true;
        try {
            if (m3369h().m4598b(m3370i(), true)) {
                canExit = false;
            }
            m3357a(null);
        } catch (C1161a e) {
            C0970a.m4325b("Failed to start OCM After event...");
        }
        if (canExit) {
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public Class m3375n() {
        return null;
    }

    public boolean m3376o() {
        return m3375n() != null;
    }

    public void m3368g(boolean animate) {
        this.f1849a = animate;
    }

    public final String m3377p() {
        if (TextUtils.isEmpty(this.f1854f)) {
            return m3378q();
        }
        return this.f1854f;
    }

    protected String m3378q() {
        return null;
    }

    public void m3379r() {
        if (this.f1855g != null) {
            int menuId = m3380s();
            if (menuId > 0 && getView() != null) {
                getView().post(new C11651(this, menuId));
            }
        }
    }

    protected int m3380s() {
        return 0;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        this.f1855g = menu;
    }

    public void onPause() {
        super.onPause();
        m3359b(false);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean m3381t() {
        return false;
    }
}
