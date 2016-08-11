package com.anglelabs.alarmclock.redesign.p026e;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.C0488b;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.Stopwatch;
import com.anglelabs.alarmclock.redesign.p020a.C0545d;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.p021b.p036c.C0662a;
import com.anglelabs.alarmclock.redesign.utils.C0790a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0826n;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.ab;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.anglelabs.alarmclock.redesign.views.TimeDisplayBar;
import com.avg.toolkit.p049e.C0970a;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.anglelabs.alarmclock.redesign.e.i */
public class C0762i extends C0662a implements OnKeyListener {
    private static final int f1954k;
    private ViewSwitcher f1955a;
    private TextView f1956b;
    private TextView f1957c;
    private TextView f1958d;
    private TextView f1959e;
    private Stopwatch f1960f;
    private TimeDisplayBar f1961g;
    private ListView f1962h;
    private SharedPreferences f1963i;
    private C0488b f1964j;
    private TextView f1965l;
    private Runnable f1966m;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.i.1 */
    class C07571 implements OnClickListener {
        final /* synthetic */ C0762i f1949a;

        C07571(C0762i c0762i) {
            this.f1949a = c0762i;
        }

        public void onClick(View v) {
            if (this.f1949a.f1960f.m3639f()) {
                this.f1949a.m3541j();
                C0830k.m3896a(this.f1949a.getActivity(), C0826n.Lap);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.i.2 */
    class C07582 implements OnClickListener {
        final /* synthetic */ C0762i f1950a;

        C07582(C0762i c0762i) {
            this.f1950a = c0762i;
        }

        public void onClick(View v) {
            if (this.f1950a.f1960f.m3639f()) {
                this.f1950a.m3543l();
                this.f1950a.m3535g();
                C0830k.m3896a(this.f1950a.getActivity(), C0826n.Stop);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.i.3 */
    class C07593 implements OnClickListener {
        final /* synthetic */ C0762i f1951a;

        C07593(C0762i c0762i) {
            this.f1951a = c0762i;
        }

        public void onClick(View v) {
            if (!this.f1951a.f1960f.m3639f()) {
                this.f1951a.m3542k();
                this.f1951a.m3537h();
                C0830k.m3896a(this.f1951a.getActivity(), C0826n.Start);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.i.4 */
    class C07604 implements OnClickListener {
        final /* synthetic */ C0762i f1952a;

        C07604(C0762i c0762i) {
            this.f1952a = c0762i;
        }

        public void onClick(View v) {
            if (!this.f1952a.f1960f.m3639f()) {
                this.f1952a.m3544m();
                C0830k.m3896a(this.f1952a.getActivity(), C0826n.Reset);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.i.a */
    private class C0761a implements Runnable {
        final /* synthetic */ C0762i f1953a;

        private C0761a(C0762i c0762i) {
            this.f1953a = c0762i;
        }

        public void run() {
            if (this.f1953a.f1961g != null) {
                this.f1953a.f1961g.setStopWatchTime(this.f1953a.f1960f.m3640g());
                if (this.f1953a.f1960f.m3639f()) {
                    this.f1953a.f1961g.postDelayed(this.f1953a.f1966m, (long) C0762i.f1954k);
                    return;
                } else {
                    this.f1953a.f1961g.removeCallbacks(this.f1953a.f1966m);
                    return;
                }
            }
            C0970a.m4325b("time bar is null");
        }
    }

    static {
        int i = C0810h.f2127a ? 30 : C0810h.f2131e ? 45 : C0810h.f2129c ? 60 : 120;
        f1954k = i;
    }

    protected int m3546b() {
        return 2;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f1963i = ac.m3774b(getActivity().getApplicationContext());
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof C0564a) {
            ((C0564a) getActivity()).m2571c(true);
            ((C0564a) getActivity()).m2572d(true);
        }
    }

    public void onDetach() {
        super.onDetach();
        if (getActivity() instanceof C0564a) {
            ((C0564a) getActivity()).m2571c(false);
            ((C0564a) getActivity()).m2572d(false);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if (getActivity() != null) {
            MenuItem share = C0790a.m3748a(menu);
            if (C0810h.f2130d) {
                this.f1964j = C0790a.m3746a(getActivity(), share);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Base64.NO_WRAP /*2*/:
                if (this.f1964j == null) {
                    startActivity(C0832m.m3940o(getActivity()));
                    break;
                }
                this.f1964j.m2317a(C0832m.m3939n(getActivity()));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);
        View v = inflater.inflate(R.layout.redesign_stopwatch_layout, container, false);
        this.f1955a = (ViewSwitcher) v.findViewById(R.id.stopwatch_button_layout_switcher);
        this.f1961g = (TimeDisplayBar) v.findViewById(R.id.timeBar);
        this.f1956b = (TextView) v.findViewById(R.id.stopwatch_lap);
        this.f1958d = (TextView) v.findViewById(R.id.stopwatch_play);
        this.f1957c = (TextView) v.findViewById(R.id.stopwatch_stop);
        this.f1959e = (TextView) v.findViewById(R.id.stopwatch_reset);
        this.f1962h = (ListView) v.findViewById(R.id.stopwatch_list);
        LinearLayout header = (LinearLayout) inflater.inflate(R.layout.redesign_list_item_stopwatch_layout, this.f1962h, false);
        this.f1965l = (TextView) header.findViewById(R.id.stopwatch_item_total_time);
        this.f1965l.setText(R.string.stopwatch_total_label);
        this.f1965l.setVisibility(4);
        this.f1962h.addHeaderView(header, null, false);
        m3533f();
        this.f1966m = new C0761a();
        this.f1961g.setBold(false);
        this.f1961g.setTextSize(ab.m3761c(R.dimen.clock, getResources()));
        C0807e.m3813a(getActivity(), this.f1955a, (int) R.anim.from_middle, (int) R.anim.to_middle);
        m3531e();
        if (this.f1963i.getBoolean("control_with_volume", false)) {
            v.setFocusableInTouchMode(true);
            v.requestFocus();
            v.setOnKeyListener(this);
        }
        return v;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == 0) {
            switch (event.getKeyCode()) {
                case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                    if (this.f1960f.m3639f()) {
                        this.f1957c.performClick();
                        return true;
                    }
                    this.f1958d.performClick();
                    return true;
                case MMException.AD_BROKEN_REFERENCE /*25*/:
                    this.f1956b.performClick();
                    return true;
            }
        }
        return false;
    }

    private void m3531e() {
        this.f1960f = new Stopwatch(getActivity());
        m3545n();
        m3539i();
        if (this.f1960f.m3639f()) {
            m3537h();
        } else {
            m3535g();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f1961g.removeCallbacks(this.f1966m);
        this.f1961g.removeAllViews();
        this.f1966m = null;
        this.f1961g = null;
    }

    protected void m3547c() {
        super.m3015c();
        if (getView() != null) {
            C0794b.m3780a(getActivity(), "Stopwatch");
            getView().setKeepScreenOn(this.f1963i.getBoolean("keep_screen_on", true));
            C0830k.m3896a(getActivity(), C0826n.Screen);
            m3531e();
        }
    }

    protected void m3548d() {
        if (getView() != null) {
            getView().setKeepScreenOn(false);
            if (this.f1961g != null) {
                this.f1961g.removeCallbacks(this.f1966m);
            }
        }
    }

    private void m3533f() {
        this.f1956b.setOnClickListener(new C07571(this));
        this.f1957c.setOnClickListener(new C07582(this));
        this.f1958d.setOnClickListener(new C07593(this));
        this.f1959e.setOnClickListener(new C07604(this));
    }

    private void m3535g() {
        if (this.f1955a.getCurrentView().getId() != R.id.stopwatch_play_buttons_layout) {
            this.f1955a.showNext();
        }
    }

    private void m3537h() {
        if (this.f1955a.getCurrentView().getId() != R.id.stopwatch_stop_buttons_layout) {
            this.f1955a.showPrevious();
        }
    }

    private void m3539i() {
        C0545d mLapTimesAdapter = new C0545d(getActivity(), this.f1960f.m3646m());
        this.f1962h.setAdapter(mLapTimesAdapter);
        if (this.f1960f.m3646m().size() > 1) {
            this.f1962h.setSelectionFromTop(0, 0);
        }
        if (mLapTimesAdapter.isEmpty()) {
            this.f1965l.setVisibility(4);
        } else {
            this.f1965l.setVisibility(0);
        }
    }

    private void m3541j() {
        if (this.f1960f.m3639f()) {
            this.f1960f.m3633b();
            m3539i();
        }
    }

    private void m3542k() {
        if (!this.f1960f.m3639f()) {
            if (this.f1961g.m4114a()) {
                this.f1960f.m3631a();
            } else {
                this.f1960f.m3637d();
            }
            m3545n();
        }
    }

    private void m3543l() {
        if (this.f1960f.m3639f()) {
            this.f1960f.m3634c();
            this.f1961g.removeCallbacks(this.f1966m);
        }
    }

    private void m3544m() {
        this.f1960f.m3632a(this.f1963i);
        this.f1960f.m3638e();
        m3539i();
        m3545n();
    }

    private void m3545n() {
        this.f1961g.post(this.f1966m);
    }
}
