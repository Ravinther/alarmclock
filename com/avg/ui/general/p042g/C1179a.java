package com.avg.ui.general.p042g;

import android.os.Bundle;
import android.support.v4.app.C0066l;
import android.support.v4.app.C0069f;
import android.support.v4.app.C0075i;
import android.support.v4.app.C0075i.C0074b;
import android.support.v4.app.Fragment;
import android.support.v7.p012a.C0328a;
import android.support.v7.p012a.C0329b;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.C1063a;
import com.avg.ui.general.C1091c.C1080d;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1162d;
import com.avg.ui.general.p043e.C0720a;
import com.avg.ui.general.p059d.C1161a;
import com.avg.utils.C1192b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.avg.ui.general.g.a */
public class C1179a implements C0074b, OnClickListener, C1178c {
    protected C0075i f3563a;
    protected C0328a f3564b;
    protected View f3565c;
    private boolean f3566d;
    private ViewGroup f3567e;
    private final Object f3568f;
    private boolean f3569g;
    private String f3570h;

    /* renamed from: com.avg.ui.general.g.a.1 */
    class C11731 implements Runnable {
        final /* synthetic */ ArrayList f3553a;
        final /* synthetic */ Bundle f3554b;
        final /* synthetic */ boolean f3555c;
        final /* synthetic */ C1179a f3556d;

        C11731(C1179a c1179a, ArrayList arrayList, Bundle bundle, boolean z) {
            this.f3556d = c1179a;
            this.f3553a = arrayList;
            this.f3554b = bundle;
            this.f3555c = z;
        }

        public void run() {
            this.f3556d.m4918b(this.f3553a, this.f3554b, !this.f3555c);
        }
    }

    /* renamed from: com.avg.ui.general.g.a.2 */
    class C11742 implements Runnable {
        final /* synthetic */ ArrayList f3557a;
        final /* synthetic */ C1179a f3558b;

        C11742(C1179a c1179a, ArrayList arrayList) {
            this.f3558b = c1179a;
            this.f3557a = arrayList;
        }

        public void run() {
            Iterator i$ = this.f3557a.iterator();
            while (i$.hasNext()) {
                ((C0719b) i$.next()).m3344g(true);
            }
            if (this.f3558b.f3563a != null) {
                C0719b dashboard = (C0719b) this.f3558b.f3563a.m260a(C1082f.dashboardPlaceHolder);
                if (dashboard != null) {
                    dashboard.m3344g(true);
                }
            }
        }
    }

    /* renamed from: com.avg.ui.general.g.a.3 */
    class C11753 implements Runnable {
        final /* synthetic */ C1179a f3559a;

        C11753(C1179a c1179a) {
            this.f3559a = c1179a;
        }

        public void run() {
            synchronized (this.f3559a.f3568f) {
                this.f3559a.f3569g = true;
            }
        }
    }

    /* renamed from: com.avg.ui.general.g.a.4 */
    class C11764 implements Runnable {
        final /* synthetic */ boolean f3560a;
        final /* synthetic */ C1179a f3561b;

        C11764(C1179a c1179a, boolean z) {
            this.f3561b = c1179a;
            this.f3560a = z;
        }

        public void run() {
            boolean parentExists = false;
            try {
                if (this.f3561b.m4938b() && this.f3561b.f3563a != null) {
                    boolean layoutChange = this.f3561b.m4923g(null);
                    this.f3561b.m4919b(layoutChange);
                    C0719b topStackFragment = this.f3561b.m4927l();
                    topStackFragment.m3339d(layoutChange);
                    String parentTag = topStackFragment.m3350p();
                    if (!TextUtils.isEmpty(parentTag)) {
                        if (this.f3561b.f3563a.m261a(parentTag) != null) {
                            parentExists = true;
                        }
                        if (parentExists) {
                            this.f3561b.f3563a.m269b(parentTag, 0);
                            return;
                        }
                    }
                    if (topStackFragment.m3349o()) {
                        C0719b dashboardFragment = (C0719b) this.f3561b.f3563a.m260a(C1082f.dashboardPlaceHolder);
                        if (dashboardFragment != null) {
                            dashboardFragment.m3339d(layoutChange);
                        }
                    }
                    topStackFragment.m3335a(this.f3560a);
                }
            } catch (C1161a e) {
                C0970a.m4325b("Odd. No top fragment found when back button clicked. What user sees then?");
            }
        }
    }

    /* renamed from: com.avg.ui.general.g.a.5 */
    class C11775 implements Runnable {
        final /* synthetic */ C1179a f3562a;

        C11775(C1179a c1179a) {
            this.f3562a = c1179a;
        }

        public void run() {
            try {
                if (this.f3562a.f3563a != null) {
                    this.f3562a.m4927l().m3347m();
                }
            } catch (C1161a e) {
                C0970a.m4325b("Failed to get top fragment...");
            }
        }
    }

    public C1179a(C0329b actionBarActivity, String mainFragmentName) {
        this.f3566d = false;
        this.f3568f = new Object();
        this.f3569g = true;
        this.f3563a = actionBarActivity.m258g();
        this.f3564b = actionBarActivity.m1486h();
        this.f3564b.m1462d();
        this.f3564b.m1465e(true);
        this.f3564b.m1461c(false);
        this.f3564b.m1467f(false);
        this.f3564b.m1455b(17170445);
        this.f3564b.m1450a(C1084h.custom_action_bar_title);
        this.f3564b.m1449a().findViewById(C1082f.actionBarUpButton).setOnClickListener(this);
        this.f3563a.m264a((C0074b) this);
        this.f3565c = actionBarActivity.findViewById(C1082f.navigationPlaceHolder);
        m4934a(mainFragmentName);
    }

    public void m4934a(String mainFragmentName) {
        new C1162d(this.f3565c.getContext()).m4867a(mainFragmentName);
    }

    public void m4932a(C0719b navigableFragment) {
        m4910a(navigableFragment, true, false);
    }

    public void m4930a(C0069f dialogFragment, String tag) {
        if (this.f3563a != null) {
            m4924i();
            this.f3570h = tag;
            dialogFragment.show(this.f3563a, tag);
        }
    }

    private void m4924i() {
        if (this.f3563a != null) {
            C0069f lastDialog = (C0069f) this.f3563a.m261a(this.f3570h);
            if (lastDialog != null) {
                lastDialog.dismiss();
            }
            this.f3570h = null;
        }
    }

    public void m4937b(C0719b fragmentToGoTo) {
        if (this.f3563a != null) {
            try {
                if (!this.f3563a.m268b() && !m4921e(fragmentToGoTo)) {
                    Fragment potentialFragment = this.f3563a.m261a(fragmentToGoTo.m3336b());
                    if (potentialFragment != null) {
                        Bundle arguments = potentialFragment.getArguments();
                        if (arguments != null) {
                            arguments.clear();
                            arguments.putAll(((Fragment) fragmentToGoTo).getArguments());
                        }
                        this.f3563a.m269b(fragmentToGoTo.m3336b(), 0);
                        return;
                    }
                    synchronized (this.f3568f) {
                        if (this.f3569g) {
                            this.f3569g = false;
                            m4924i();
                            m4910a(fragmentToGoTo, true, true);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void m4933a(Object lastCustomNonConfigurationInstance, Bundle savedInstanceState) {
        if (this.f3563a != null) {
            try {
                C0719b topStackFragment = m4927l();
                if (lastCustomNonConfigurationInstance != null && (lastCustomNonConfigurationInstance instanceof C1063a)) {
                    C1063a task = (C1063a) lastCustomNonConfigurationInstance;
                    topStackFragment.m3334a(task);
                    task.m4619a(topStackFragment);
                }
                m4942d(topStackFragment);
                for (int i = 0; i < this.f3563a.m272e() - 1; i++) {
                    m4906a(i, false);
                }
                m4906a(this.f3563a.m272e() - 1, true);
            } catch (C1161a e) {
                C0970a.m4325b("Odd. The back stack is empty despite the fact that restored from saved instance. Aborting restore than");
            }
        }
    }

    private void m4906a(int fragmentNumberInBackStack, boolean isTopFragment) {
        if (this.f3563a != null) {
            C0719b fragment = (C0719b) this.f3563a.m261a(this.f3563a.m266b(fragmentNumberInBackStack).m194d());
            fragment.m3343f(isTopFragment);
            if (fragment.m3349o()) {
                C0719b dashboardFragment = (C0719b) this.f3563a.m260a(C1082f.dashboardPlaceHolder);
                if (dashboardFragment != null) {
                    dashboardFragment.m3343f(isTopFragment);
                }
            }
        }
    }

    public void m4935a(List fragmentNames, Bundle lastFragmentArguments, boolean clearStackFirst) {
        m4924i();
        if (!m4920b((String) fragmentNames.get(fragmentNames.size() - 1))) {
            ArrayList fragments = m4905a(fragmentNames);
            C0719b lastFragment = (C0719b) fragments.get(fragments.size() - 1);
            if (m4922f(lastFragment)) {
                ((Fragment) lastFragment).setArguments(lastFragmentArguments);
                m4937b(lastFragment);
                return;
            }
            m4911a(fragments, lastFragmentArguments, clearStackFirst);
        }
    }

    private void m4911a(ArrayList fragments, Bundle lastFragmentArguments, boolean clearStackFirst) {
        if (clearStackFirst && this.f3563a != null) {
            this.f3563a.m265a(null, 1);
            this.f3563a.m268b();
        }
        this.f3565c.post(new C11731(this, fragments, lastFragmentArguments, clearStackFirst));
    }

    private boolean m4920b(String targetFragment) {
        try {
            return m4927l().getClass().getName().equals(targetFragment);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean m4921e(C0719b fragment) {
        return m4920b(fragment.getClass().getName());
    }

    private boolean m4922f(C0719b fragment) {
        return (this.f3563a == null || this.f3563a.m261a(fragment.m3350p()) == null) ? false : true;
    }

    private ArrayList m4905a(List fragmentNames) {
        ArrayList fragments = new ArrayList();
        for (String fragmentToNavigateToName : fragmentNames) {
            String fragmentToNavigateToName2;
            try {
                if ("MAIN_FRAGMENT_PLACEHOLDER".equals(fragmentToNavigateToName2)) {
                    fragmentToNavigateToName2 = new C1162d(this.f3565c.getContext()).m4866a();
                    if (TextUtils.isEmpty(fragmentToNavigateToName2)) {
                    }
                }
                C0719b fragment = (C0719b) Class.forName(fragmentToNavigateToName2).newInstance();
                if (fragment != null) {
                    fragments.add(fragment);
                }
            } catch (Exception e) {
                C0970a.m4325b("Couldn't navigate to " + fragmentToNavigateToName2 + " fragment. " + e.getMessage());
            }
        }
        return fragments;
    }

    private void m4918b(ArrayList fragments, Bundle lastFragmentArguments, boolean animate) {
        int size = fragments.size();
        int last = size - 1;
        for (int i = 0; i < size; i++) {
            boolean animated = animate;
            if (i == last && lastFragmentArguments != null) {
                animated = false;
                ((Fragment) fragments.get(last)).setArguments(lastFragmentArguments);
            }
            m4910a((C0719b) fragments.get(i), true, animated);
            if (this.f3563a != null) {
                this.f3563a.m268b();
            }
        }
        this.f3565c.post(new C11742(this, fragments));
    }

    private void m4907a(C0066l ft, C0719b fragment, int layout, boolean toBackStack, boolean animate) {
        fragment.m3344g(animate);
        try {
            boolean layoutChange = m4923g(fragment);
            m4919b(layoutChange);
            C0719b topStackFragment = m4927l();
            if (topStackFragment != null) {
                topStackFragment.m3344g(animate);
                topStackFragment.m3338c(layoutChange);
                if (topStackFragment.m3349o()) {
                    C0719b dashboardFragment = (C0719b) this.f3563a.m260a(C1082f.dashboardPlaceHolder);
                    if (dashboardFragment != null) {
                        dashboardFragment.m3344g(animate);
                        dashboardFragment.m3338c(layoutChange);
                    }
                }
            }
            fragment.m3341e(layoutChange);
        } catch (C1161a e) {
        }
        if (toBackStack) {
            ft.m187a(fragment.m3336b());
        }
        ft.m184a(layout, (Fragment) fragment, fragment.m3336b());
    }

    private void m4919b(boolean layoutChange) {
        if (this.f3567e == null) {
            this.f3567e = (ViewGroup) this.f3565c.findViewById(C1082f.dualPaneLayout);
        }
        this.f3567e.setClipChildren(!layoutChange);
    }

    private void m4910a(C0719b fragment, boolean toBackStack, boolean animate) {
        if (this.f3563a != null) {
            int layout = m4939c(fragment);
            C0066l ft = this.f3563a.m262a().m182a(0);
            m4903a(ft);
            m4908a(ft, fragment, animate);
            m4907a(ft, fragment, layout, toBackStack, animate);
            ft.m191c();
            this.f3563a.m268b();
            this.f3565c.post(new C11753(this));
        }
    }

    private C0719b m4903a(C0066l ft) {
        try {
            C0719b topStackFragment = m4927l();
            if (this.f3563a == null) {
                return null;
            }
            if (topStackFragment == null) {
                return topStackFragment;
            }
            if (topStackFragment.m3351t()) {
                this.f3563a.m271d();
                return m4903a(ft);
            }
            ft.m185a((Fragment) topStackFragment);
            if (!topStackFragment.m3349o() || !m4925j()) {
                return topStackFragment;
            }
            Fragment dashBoardFragment = this.f3563a.m260a(C1082f.dashboardPlaceHolder);
            if (dashBoardFragment == null) {
                return topStackFragment;
            }
            ft.m185a(dashBoardFragment);
            return topStackFragment;
        } catch (Exception e) {
            return null;
        }
    }

    private boolean m4925j() {
        return !C1192b.m4997a(this.f3565c.getContext().getApplicationContext());
    }

    private void m4908a(C0066l ft, C0719b fragment, boolean animate) {
        try {
            if (fragment.m3348n() != null) {
                C0719b dashboard = (C0719b) fragment.m3348n().newInstance();
                if (dashboard != null) {
                    m4907a(ft, dashboard, C1082f.dashboardPlaceHolder, false, animate);
                }
            }
        } catch (Exception e) {
        }
    }

    protected int m4939c(C0719b currentFragment) {
        return C1192b.m4997a(this.f3565c.getContext().getApplicationContext()) ? (currentFragment.m3349o() || m4926k()) ? C1082f.contentPlaceHolder : C1082f.fullScreenLayout : currentFragment.m3349o() ? C1082f.contentPlaceHolder : C1082f.fullScreenLayout;
    }

    private boolean m4926k() {
        return m4912a(0);
    }

    private boolean m4912a(int offsetFromEnd) {
        if (this.f3563a == null) {
            return false;
        }
        int stackCount = this.f3563a.m272e();
        for (int i = 0; i < stackCount - offsetFromEnd; i++) {
            if (((C0719b) this.f3563a.m261a(this.f3563a.m266b(i).m194d())).m3349o()) {
                return true;
            }
        }
        return false;
    }

    public void m4931a(MenuItem item) {
        m4936a(false);
    }

    protected void m4942d(C0719b fragment) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        int titleId = fragment.m3337c();
        int iconId = fragment.m3340e();
        C0328a c0328a = this.f3564b;
        if (iconId > 0) {
            z = true;
        } else {
            z = false;
        }
        c0328a.m1458b(z);
        c0328a = this.f3564b;
        if (iconId > 0) {
            z = true;
        } else {
            z = false;
        }
        c0328a.m1461c(z);
        C0328a c0328a2 = this.f3564b;
        if (iconId <= 0) {
            z2 = false;
        }
        c0328a2.m1453a(z2);
        TextView actionBarUpButtonTextView = (TextView) this.f3564b.m1449a().findViewById(C1082f.actionBarUpButton);
        if (actionBarUpButtonTextView != null) {
            if (iconId > 0) {
                i = 8;
            }
            actionBarUpButtonTextView.setVisibility(i);
            if (titleId > 0) {
                actionBarUpButtonTextView.setText(titleId);
            }
        }
        c0328a2 = this.f3564b;
        if (iconId <= 0) {
            iconId = C1080d.transparent;
        }
        c0328a2.m1460c(iconId);
        this.f3564b.m1449a().findViewById(C1082f.upgradeButton).setVisibility(fragment.m3342f());
    }

    public void m4928a() {
        C0719b fragment = null;
        try {
            fragment = m4927l();
        } catch (C1161a e) {
        }
        if (fragment == null) {
            return;
        }
        if (this.f3566d) {
            this.f3566d = false;
        } else {
            m4942d(fragment);
        }
    }

    public boolean m4938b() {
        boolean z = true;
        if (this.f3563a == null) {
            return false;
        }
        boolean stackEmpty;
        if (this.f3563a.m272e() <= 1) {
            stackEmpty = true;
        } else {
            stackEmpty = false;
        }
        boolean isExitFragment = false;
        try {
            isExitFragment = "I am the root!".equals(m4927l().m3350p());
        } catch (Exception e) {
        }
        if (stackEmpty || isExitFragment) {
            z = false;
        }
        return z;
    }

    public boolean m4940c() {
        try {
            return m4927l().m3346l();
        } catch (Exception e) {
            return false;
        }
    }

    public synchronized void m4936a(boolean isHardwareBack) {
        this.f3565c.post(new C11764(this, isHardwareBack));
    }

    public void m4941d() {
        this.f3565c.post(new C11775(this));
    }

    private boolean m4923g(C0719b nextFragment) {
        try {
            int next;
            int current = ((Fragment) m4915b(1)).getId();
            if (nextFragment == null) {
                next = ((Fragment) m4915b(2)).getId();
            } else {
                next = m4939c(nextFragment);
            }
            return current != next;
        } catch (Exception e) {
            return true;
        }
    }

    public void m4943e() {
        if (this.f3563a != null) {
            this.f3563a.m271d();
        }
    }

    public void m4929a(Bundle bundle) {
        try {
            C0719b topStackFragment = m4927l();
            Fragment topFrag = (Fragment) topStackFragment;
            if (!(bundle == null || topFrag.getArguments() == null)) {
                topFrag.getArguments().putAll(bundle);
            }
            topStackFragment.m3333a(bundle);
        } catch (C1161a e) {
            C0970a.m4325b("Couldn't fetch top stack fragment. Something is terribly wrong!");
        }
    }

    public C1063a m4944f() {
        try {
            C1063a currentRunningTask = m4927l().m3345j();
            if (currentRunningTask == null) {
                return currentRunningTask;
            }
            currentRunningTask.m4618a();
            return currentRunningTask;
        } catch (C1161a e) {
            C0970a.m4325b("No top stack running");
            return null;
        }
    }

    private C0719b m4927l() {
        return m4915b(1);
    }

    private C0719b m4915b(int positionFromEnd) {
        if (this.f3563a == null) {
            throw new C1161a("FragmentManager is null, can't access stack!");
        }
        int backStackEntryCount = this.f3563a.m272e();
        if (backStackEntryCount == 0) {
            throw new C1161a("Can't get top stack fragment. BackStack is empty");
        }
        return (C0719b) this.f3563a.m261a(this.f3563a.m266b(backStackEntryCount - positionFromEnd).m194d());
    }

    public void m4945g() {
        this.f3563a = null;
        this.f3564b = null;
    }

    public void onClick(View v) {
        m4936a(false);
    }

    public void m4946h() {
        try {
            ((C0720a) m4927l()).m3379r();
        } catch (C1161a e) {
        }
    }
}
