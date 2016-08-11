package com.anglelabs.alarmclock.redesign.p026e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C0075i.C0074b;
import android.support.v4.app.C0084k;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.C0165f;
import android.support.v7.p012a.C0328a;
import android.support.v7.p012a.C0328a.C0326e;
import android.support.v7.p012a.C0329b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.NewMainActivity.C0562b;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0822j;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.avg.toolkit.p049e.C0970a;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

/* renamed from: com.anglelabs.alarmclock.redesign.e.g */
public class C0750g extends Fragment implements C0562b {
    public int f1924a;
    private RadioGroup f1925b;
    private C0329b f1926c;
    private C0326e f1927d;
    private C0326e f1928e;
    private C0326e f1929f;
    private C0749a f1930g;
    private ViewPager f1931h;
    private final C0074b f1932i;
    private final OnCheckedChangeListener f1933j;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.g.1 */
    class C07461 implements C0074b {
        final /* synthetic */ C0750g f1915a;

        C07461(C0750g c0750g) {
            this.f1915a = c0750g;
        }

        public void m3481a() {
            if (this.f1915a.getFragmentManager().m272e() == 0) {
                C0794b.m3779a(this.f1915a.getActivity(), (int) R.string.ads_category_main_screen, true);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.g.2 */
    class C07472 implements OnCheckedChangeListener {
        final /* synthetic */ C0750g f1916a;

        C07472(C0750g c0750g) {
            this.f1916a = c0750g;
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.ab_tab_alarm:
                    this.f1916a.m3494a((C0748a) this.f1916a.f1927d.m1443e());
                case R.id.ab_tab_timer:
                    this.f1916a.m3494a((C0748a) this.f1916a.f1929f.m1443e());
                case R.id.ab_tab_stopwatch:
                    this.f1916a.m3494a((C0748a) this.f1916a.f1928e.m1443e());
                default:
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.g.a */
    private class C0749a extends C0084k implements C0165f {
        final /* synthetic */ C0750g f1920a;
        private final ArrayList f1921b;
        private final Context f1922c;
        private final ViewPager f1923d;

        /* renamed from: com.anglelabs.alarmclock.redesign.e.g.a.a */
        final class C0748a {
            final /* synthetic */ C0749a f1917a;
            private final Class f1918b;
            private final Bundle f1919c;

            C0748a(C0749a c0749a, Class _class, int position) {
                this.f1917a = c0749a;
                this.f1918b = _class;
                this.f1919c = new Bundle();
                this.f1919c.putInt("tab_position", position);
            }

            public int m3484a() {
                return this.f1919c.getInt("tab_position", 0);
            }
        }

        public C0749a(C0750g c0750g, C0329b activity, ViewPager pager) {
            this.f1920a = c0750g;
            super(c0750g.getChildFragmentManager());
            this.f1921b = new ArrayList();
            this.f1922c = activity;
            this.f1923d = pager;
            this.f1923d.setAdapter(this);
            this.f1923d.setOnPageChangeListener(this);
        }

        public Fragment m3487a(int position) {
            C0748a info = (C0748a) this.f1921b.get(position);
            return Fragment.instantiate(this.f1922c, info.f1918b.getName(), info.f1919c);
        }

        public int m3490b() {
            return this.f1921b.size();
        }

        public void m3488a(int i, float v, int i2) {
        }

        public void a_(int position) {
            for (int i = 0; i < m3490b(); i++) {
                Fragment fragment = m3486e(i);
                if (fragment instanceof C0661a) {
                    ((C0661a) fragment).m3012a(position);
                }
            }
            if (position != -1) {
                this.f1923d.m636a(position, true);
                this.f1920a.m3498b((C0748a) this.f1921b.get(position));
                this.f1920a.f1924a = position;
            }
        }

        public void m3491d() {
            if (this.f1920a.f1924a != -1) {
                Fragment fragment = m3486e(this.f1920a.f1924a);
                if (fragment instanceof C0661a) {
                    ((C0661a) fragment).m3012a(this.f1920a.f1924a);
                }
            }
        }

        public void m3489a(C0326e tab, Class clss, int position) {
            Object info = new C0748a(this, clss, position);
            tab.m1439a(info);
            this.f1921b.add(info);
            m363c();
        }

        public void b_(int arg0) {
        }

        private Fragment m3486e(int position) {
            return this.f1920a.getChildFragmentManager().m261a(String.format("android:switcher:%d:%d", new Object[]{Integer.valueOf(this.f1920a.f1931h.getId()), Integer.valueOf(position)}));
        }
    }

    public C0750g() {
        this.f1932i = new C07461(this);
        this.f1933j = new C07472(this);
    }

    public void m3504b() {
        if (getActivity() != null) {
            this.f1930g.a_(-1);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C0329b) {
            this.f1926c = (C0329b) activity;
            getFragmentManager().m264a(this.f1932i);
            return;
        }
        throw new UnsupportedOperationException("activity must be ActionBarActivity");
    }

    public void onDetach() {
        getFragmentManager().m267b(this.f1932i);
        super.onDetach();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.redesign_main_fragment_layout, container, false);
        m3505c();
        this.f1931h = (ViewPager) view.findViewById(R.id.main_view_pager);
        this.f1931h.setOffscreenPageLimit(2);
        this.f1930g = new C0749a(this, (C0329b) getActivity(), this.f1931h);
        m3493a(this.f1924a);
        this.f1924a = 0;
        if (savedInstanceState != null) {
            this.f1924a = savedInstanceState.getInt("selected_tab", 0);
        }
        Intent i = getActivity().getIntent();
        if (i != null) {
            int tab = i.getIntExtra("alarmclock.select.tab", -1);
            if (tab != -1) {
                this.f1924a = tab;
            }
        }
        m3497b(this.f1924a);
        return view;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selected_tab", this.f1924a);
    }

    public void onResume() {
        super.onResume();
        if (this.f1930g != null) {
            this.f1930g.m3491d();
        }
    }

    private void m3493a(int selectedIndex) {
        C0328a actionBar = this.f1926c.m1486h();
        if (actionBar != null) {
            this.f1927d = actionBar.m1459c();
            this.f1927d.m1438a((int) R.drawable.ab_tab_alarm_unselected);
            this.f1930g.m3489a(this.f1927d, C0735d.class, 0);
            this.f1929f = actionBar.m1459c();
            this.f1929f.m1438a((int) R.drawable.ab_tab_timer_unselected);
            this.f1930g.m3489a(this.f1929f, C0769j.class, 1);
            this.f1928e = actionBar.m1459c();
            this.f1928e.m1438a((int) R.drawable.ab_tab_stopwatch_unselected);
            this.f1930g.m3489a(this.f1928e, C0762i.class, 2);
            m3497b(selectedIndex);
        }
    }

    void m3505c() {
        C0328a actionBar = this.f1926c.m1486h();
        actionBar.m1453a(false);
        actionBar.m1463d(false);
        actionBar.m1458b(false);
        actionBar.m1461c(false);
        actionBar.m1450a((int) R.layout.redesign_action_bar_layout);
        actionBar.m1465e(true);
        this.f1925b = (RadioGroup) actionBar.m1449a().findViewById(R.id.ab_tabs_container);
        this.f1925b.setOnCheckedChangeListener(this.f1933j);
    }

    public void m3506d() {
        int tab = -1;
        if (getActivity() == null) {
            C0850q.m3987b("getActivity() returned null, aborting!");
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            tab = intent.getIntExtra("alarmclock.select.tab", -1);
            if (intent.getBooleanExtra("alarmclock.select.notification", false)) {
                if (tab == 0) {
                    C0830k.m3896a(getActivity(), C0822j.Alarm);
                } else if (tab == 1) {
                    C0830k.m3896a(getActivity(), C0822j.Timer);
                } else if (tab == 2) {
                    C0830k.m3896a(getActivity(), C0822j.Stopwatch);
                }
                intent.putExtra("alarmclock.select.notification", false);
            }
        }
        if (tab != -1 && getView() != null) {
            m3497b(tab);
        }
    }

    private void m3494a(C0748a selectedTab) {
        this.f1924a = selectedTab.m3484a();
        this.f1930g.a_(this.f1924a);
    }

    private void m3498b(C0748a selectedTab) {
        String clazzName = selectedTab.f1918b.getSimpleName();
        this.f1925b.setOnCheckedChangeListener(null);
        if (clazzName.equals(C0735d.class.getSimpleName())) {
            this.f1925b.check(R.id.ab_tab_alarm);
        } else if (clazzName.equals(C0762i.class.getSimpleName())) {
            this.f1925b.check(R.id.ab_tab_stopwatch);
        } else if (clazzName.equals(C0769j.class.getSimpleName())) {
            this.f1925b.check(R.id.ab_tab_timer);
        }
        this.f1925b.setOnCheckedChangeListener(this.f1933j);
    }

    private void m3497b(int tabIndex) {
        this.f1924a = tabIndex;
        C0326e currentTab = m3500c(tabIndex);
        if (currentTab != null) {
            C0748a tab = (C0748a) currentTab.m1443e();
            if (tab != null) {
                m3498b(tab);
                m3494a(tab);
            }
        }
    }

    private C0326e m3500c(int index) {
        switch (index) {
            case Base64.DEFAULT /*0*/:
                return this.f1927d;
            case Base64.NO_PADDING /*1*/:
                return this.f1929f;
            case Base64.NO_WRAP /*2*/:
                return this.f1928e;
            default:
                C0970a.m4325b("unknown tab index: " + index);
                return this.f1927d;
        }
    }

    public Fragment m3503a() {
        return this.f1930g.m3486e(this.f1924a);
    }
}
