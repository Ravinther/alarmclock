package com.anglelabs.alarmclock.redesign.p026e;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.p006a.C0022i;
import android.support.v7.p012a.C0329b;
import android.support.v7.p013c.C0342a;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager;
import com.anglelabs.alarmclock.redesign.alarm.C0645c;
import com.anglelabs.alarmclock.redesign.alarm.C0646d;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p020a.C0536a;
import com.anglelabs.alarmclock.redesign.p020a.C0536a.C0514b;
import com.anglelabs.alarmclock.redesign.p020a.C0536a.C0515c;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.p021b.p036c.C0675b;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0807e.C0730b;
import com.anglelabs.alarmclock.redesign.utils.C0808f;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0815b;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0825m;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0858u;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import com.p037b.p038a.C1193a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* renamed from: com.anglelabs.alarmclock.redesign.e.d */
public class C0735d extends C0675b {
    private ListView f1875c;
    private C0536a f1876d;
    private TextView f1877e;
    private TextView f1878f;
    private final C0515c f1879g;
    private LinearLayout f1880h;
    private SharedPreferences f1881i;
    private final C0514b f1882j;
    private final BroadcastReceiver f1883k;
    private final BroadcastReceiver f1884l;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.d.1 */
    class C07241 implements C0514b {
        final /* synthetic */ C0735d f1861a;

        C07241(C0735d c0735d) {
            this.f1861a = c0735d;
        }

        public void m3392a(RedesignAlarm alarm, boolean isNeedShowingToast) {
            this.f1861a.m3408A();
            if (isNeedShowingToast && ac.m3773a(this.f1861a.f1881i, alarm)) {
                C0870z.m4065a(this.f1861a.getActivity(), alarm);
            }
        }

        public boolean m3393a() {
            return this.f1861a.f1880h.getVisibility() == 0;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.d.2 */
    class C07252 extends BroadcastReceiver {
        final /* synthetic */ C0735d f1862a;

        C07252(C0735d c0735d) {
            this.f1862a = c0735d;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f1862a.getActivity() != null && intent.getAction().equals("RedesignViewAlarmsFragment.refreshAlarms")) {
                this.f1862a.m3448p();
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.d.3 */
    class C07263 extends BroadcastReceiver {
        final /* synthetic */ C0735d f1863a;

        C07263(C0735d c0735d) {
            this.f1863a = c0735d;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f1863a.getActivity() != null && intent.getAction().equals("android.intent.action.TIME_TICK")) {
                this.f1863a.m3412a();
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.d.4 */
    class C07274 implements OnClickListener {
        final /* synthetic */ C0735d f1864a;

        C07274(C0735d c0735d) {
            this.f1864a = c0735d;
        }

        public void onClick(View v) {
            this.f1864a.startActivity(C0832m.m3909a(this.f1864a.getActivity()));
            C0830k.m3896a(this.f1864a.getActivity(), C0815b.Add);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.d.5 */
    class C07285 implements OnClickListener {
        final /* synthetic */ C0735d f1865a;

        C07285(C0735d c0735d) {
            this.f1865a = c0735d;
        }

        public void onClick(View v) {
            ac.m3772a(this.f1865a.getActivity(), false);
            this.f1865a.f1880h.setVisibility(8);
            this.f1865a.f1876d.notifyDataSetChanged();
            this.f1865a.m3408A();
            C0830k.m3896a(this.f1865a.getActivity(), C0825m.GeneralSettingsVacationModeOffAlarmsFragment);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.d.6 */
    class C07296 implements OnItemClickListener {
        final /* synthetic */ C0735d f1866a;

        C07296(C0735d c0735d) {
            this.f1866a = c0735d;
        }

        public void onItemClick(AdapterView parent, View view, int position, long id) {
            RedesignAlarm alarm = (RedesignAlarm) this.f1866a.f1876d.getItem(position);
            if (C0646d.m2987f(this.f1866a.getActivity(), alarm.f2010k)) {
                this.f1866a.startActivity(C0832m.m3928e(this.f1866a.getActivity(), alarm));
                C0830k.m3896a(this.f1866a.getActivity(), C0815b.Snoozed);
                return;
            }
            C0830k.m3896a(this.f1866a.getActivity(), C0815b.Edit);
            this.f1866a.f1879g.m2449a(alarm);
            this.f1866a.f1875c.clearFocus();
            this.f1866a.m3447o();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.d.a */
    private class C0734a implements C0515c {
        final /* synthetic */ C0735d f1874a;

        /* renamed from: com.anglelabs.alarmclock.redesign.e.d.a.1 */
        class C07311 extends C0730b {
            final /* synthetic */ RedesignAlarm f1867a;
            final /* synthetic */ C0734a f1868b;

            C07311(C0734a c0734a, RedesignAlarm redesignAlarm) {
                this.f1868b = c0734a;
                this.f1867a = redesignAlarm;
            }

            public void m3398a(C1193a animation) {
                this.f1868b.f1874a.m3437c(this.f1867a);
            }
        }

        /* renamed from: com.anglelabs.alarmclock.redesign.e.d.a.2 */
        class C07322 extends C0730b {
            final /* synthetic */ View f1869a;
            final /* synthetic */ int f1870b;
            final /* synthetic */ C0734a f1871c;

            C07322(C0734a c0734a, View view, int i) {
                this.f1871c = c0734a;
                this.f1869a = view;
                this.f1870b = i;
            }

            public void m3399a(C1193a animation) {
                this.f1871c.f1874a.a.m3970a(this.f1869a, this.f1870b);
            }
        }

        /* renamed from: com.anglelabs.alarmclock.redesign.e.d.a.3 */
        class C07333 implements Runnable {
            final /* synthetic */ RedesignAlarm f1872a;
            final /* synthetic */ C0734a f1873b;

            C07333(C0734a c0734a, RedesignAlarm redesignAlarm) {
                this.f1873b = c0734a;
                this.f1872a = redesignAlarm;
            }

            public void run() {
                C0694b.m3141a(this.f1873b.f1874a.getActivity(), this.f1873b.f1874a.getActivity().getContentResolver(), this.f1872a, this.f1872a.f2010k);
            }
        }

        private C0734a(C0735d c0735d) {
            this.f1874a = c0735d;
        }

        public void m3400a(int position) {
            if (position < this.f1874a.f1876d.getCount()) {
                RedesignAlarm alarm = (RedesignAlarm) this.f1874a.f1876d.getItem(position);
                try {
                    int animationTime = this.f1874a.getResources().getInteger(17694721);
                    if (alarm.m3613a(this.f1874a.getActivity()) || alarm.m3616b(this.f1874a.getActivity())) {
                        C0807e.m3817b(this.f1874a.f1875c.getChildAt(position), true, (long) animationTime, new C07311(this, alarm)).m5289a();
                        return;
                    }
                    View view = this.f1874a.f1875c.getChildAt(position - this.f1874a.f1875c.getFirstVisiblePosition());
                    C0807e.m3811a(view, true, (long) animationTime, new C07322(this, view, position)).m5289a();
                } catch (Exception e) {
                    C0850q.m3984a(e);
                }
            }
        }

        public void m3401a(RedesignAlarm alarm) {
            this.f1874a.startActivity(C0832m.m3911a(this.f1874a.getActivity(), alarm));
        }

        public void m3404b(RedesignAlarm alarm) {
            boolean z;
            if (alarm.f1990C) {
                z = false;
            } else {
                z = true;
            }
            alarm.f1990C = z;
            ContentValues values = new ContentValues(1);
            values.put("restartmath", alarm.f1990C ? "1" : ITKSvc.CODEREVISION);
            C0694b.m3138a(this.f1874a.getActivity(), alarm.f2010k, values, false);
            this.f1874a.f1876d.notifyDataSetChanged();
            this.f1874a.m3408A();
        }

        public void m3405c(RedesignAlarm alarm) {
            ac.m3770a(this.f1874a.getActivity(), alarm, alarm.f2009j, alarm.f2023x);
        }

        public void m3406d(RedesignAlarm alarm) {
            C0808f.m3825a(new C07333(this, alarm));
            C0858u.m4026a(this.f1874a.getActivity(), this.f1874a.getString(R.string.default_alarm_set));
        }

        public void m3407e(RedesignAlarm alarm) {
            Intent editAlarmIntent = C0832m.m3911a(this.f1874a.getActivity(), RedesignAlarm.m3610b(alarm));
            editAlarmIntent.putExtra("add_if_saved", true);
            this.f1874a.startActivity(editAlarmIntent);
        }

        public void m3402a(RedesignAlarm alarm, boolean enable) {
            alarm.f2012m = enable;
            C0694b.m3140a(this.f1874a.getActivity(), alarm.f2010k, enable);
            this.f1874a.f1882j.m2446a(alarm, enable);
            C0830k.m3896a(this.f1874a.getActivity(), enable ? C0815b.SwitchOn : C0815b.SwitchOff);
            this.f1874a.f1876d.notifyDataSetChanged();
        }

        public void m3403b(int position) {
            if (this.f1874a.m3444l() != null) {
                this.f1874a.m3444l().smoothScrollToPosition(position);
            }
        }
    }

    public C0735d() {
        this.f1879g = new C0734a();
        this.f1882j = new C07241(this);
        this.f1883k = new C07252(this);
        this.f1884l = new C07263(this);
    }

    public /* synthetic */ void m3434b(Object x0) {
        m3437c((RedesignAlarm) x0);
    }

    public /* synthetic */ void m3438c(Object x0) {
        m3433b((RedesignAlarm) x0);
    }

    private void m3412a() {
        if (getActivity() != null) {
            RedesignAlarm nextAlarm = C0694b.m3130a(getActivity());
            if (nextAlarm == null) {
                m3425y();
                m3409B();
            } else if (nextAlarm.f1990C) {
                this.f1878f.setText(getString(R.string.will_be_skipped));
                m3425y();
            } else if (nextAlarm.f1994G > 0) {
                String timeRemaining = C0870z.m4060a(getActivity(), nextAlarm.f1994G);
                this.f1878f.setText(ac.m3766a(getString(R.string.upcoming_alarms_time_remaining, timeRemaining), timeRemaining, getResources().getColor(R.color.white)));
            }
        }
    }

    protected int m3431b() {
        return 0;
    }

    public void onResume() {
        super.onResume();
        Intent intent = getActivity().getIntent();
        if (intent.hasExtra("=com.alarmclock.xtreme.create.new")) {
            boolean createNewAlarm = intent.getBooleanExtra("=com.alarmclock.xtreme.create.new", false);
            intent.removeExtra("=com.alarmclock.xtreme.create.new");
            if (createNewAlarm) {
                startActivity(C0832m.m3909a(getActivity()));
                return;
            }
        }
        m3423w();
        m3424x();
        m3412a();
    }

    private void m3423w() {
        if (this.f1880h != null) {
            if (C0860w.m4036a(ac.m3774b(getActivity()))) {
                this.f1880h.setVisibility(0);
            } else {
                this.f1880h.setVisibility(8);
            }
        }
        this.f1876d.notifyDataSetChanged();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        C0022i.m108a((Context) activity).m112a(this.f1883k, new IntentFilter("RedesignViewAlarmsFragment.refreshAlarms"));
    }

    public void onPause() {
        m3425y();
        super.onPause();
    }

    private void m3424x() {
        getActivity().registerReceiver(this.f1884l, new IntentFilter("android.intent.action.TIME_TICK"));
    }

    private void m3425y() {
        try {
            getActivity().unregisterReceiver(this.f1884l);
        } catch (Exception e) {
        }
    }

    public void onDetach() {
        C0022i.m108a(getActivity()).m111a(this.f1883k);
        super.onDetach();
    }

    public View m3427a(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.redesign_fragment_view_alarm_list, container, false);
        this.f1875c = (ListView) view.findViewById(R.id.list);
        this.f1875c.setEmptyView(view.findViewById(R.id.alarm_empty_view));
        View addAlarmButton = view.findViewById(R.id.footer);
        this.f1877e = (TextView) view.findViewById(R.id.nextAlarmTextView);
        this.f1878f = (TextView) view.findViewById(R.id.timeRemainingText);
        addAlarmButton.setOnClickListener(new C07274(this));
        this.f1880h = (LinearLayout) view.findViewById(R.id.vacationModeLayout);
        view.findViewById(R.id.vacationModeButton).setOnClickListener(new C07285(this));
        m3426z();
        m3408A();
        this.f1881i = ac.m3774b(getActivity());
        return view;
    }

    private void m3426z() {
        this.f1876d = new C0536a(getActivity(), m3444l(), this.f1882j, this.f1879g);
        this.f1875c.setAdapter(this.f1876d);
        this.f1875c.setItemsCanFocus(true);
        m3410C();
        this.f1875c.setOnItemClickListener(new C07296(this));
    }

    private void m3408A() {
        if (getActivity() != null) {
            AlarmStateManager.m2789a(getActivity(), false);
            RedesignAlarm nextAlarm = C0694b.m3130a(getActivity());
            if (nextAlarm == null || nextAlarm.f1994G <= 0) {
                m3409B();
            } else {
                this.f1877e.setVisibility(0);
                this.f1878f.setVisibility(0);
                Calendar c = Calendar.getInstance(Locale.getDefault());
                c.setTimeInMillis(nextAlarm.f1994G);
                String nextAlarmTime = C0870z.m4062a(getActivity(), c, false);
                this.f1877e.setText(ac.m3766a(getString(R.string.upcoming_alarms_text, nextAlarmTime), nextAlarmTime, getResources().getColor(R.color.white)));
                if (nextAlarm.f1990C) {
                    this.f1878f.setText(getString(R.string.will_be_skipped));
                } else {
                    String timeRemaining = C0870z.m4060a(getActivity(), nextAlarm.f1994G);
                    this.f1878f.setText(ac.m3766a(getString(R.string.upcoming_alarms_time_remaining, timeRemaining), timeRemaining, getResources().getColor(R.color.white)));
                    m3424x();
                }
            }
            C0645c.m2968a(getActivity());
        }
    }

    private void m3409B() {
        m3425y();
        this.f1878f.setVisibility(8);
        if (this.f1876d.getCount() == 0) {
            this.f1877e.setVisibility(4);
            return;
        }
        this.f1877e.setVisibility(0);
        this.f1877e.setText(getString(R.string.no_upcoming_alarms_text));
    }

    private void m3410C() {
        ArrayList alarms = new ArrayList();
        Cursor c = C0694b.m3152c(getActivity().getContentResolver());
        if (c != null) {
            while (c.moveToNext()) {
                try {
                    alarms.add(new RedesignAlarm(c));
                } finally {
                    c.close();
                }
            }
        }
        this.f1876d.m2468b(alarms);
        this.f1876d.notifyDataSetChanged();
    }

    public ListView m3444l() {
        return this.f1875c;
    }

    public void m3432b(int position) {
        m3411D();
        m3416d(position);
        m3408A();
        C0830k.m3896a(getActivity(), C0815b.DeleteSwipe);
    }

    private void m3411D() {
        List idsToDelete = new ArrayList();
        for (int i = 0; i < m3077i().size(); i++) {
            idsToDelete.add(Integer.valueOf(((RedesignAlarm) m3077i().get(m3077i().keyAt(i))).f2010k));
        }
        if (idsToDelete.size() > 0) {
            C0694b.m3144a(getActivity(), idsToDelete);
        }
        m3077i().clear();
    }

    public String m3441h() {
        int lastAvailableIndex = m3077i().size() - 1;
        if (lastAvailableIndex < 0) {
            return "";
        }
        if (m3077i().keyAt(lastAvailableIndex) < 0) {
            C0970a.m4325b("unable to retrieve undo list! avoid crash");
            return "";
        } else if (m3077i().size() > 1) {
            return getString(R.string.undo_multiple, Integer.valueOf(m3077i().size()), getString(R.string.undo_multiple_format_alarm));
        } else {
            return getString(R.string.undo_single, ((RedesignAlarm) m3077i().get(index)).m3623i(getActivity()));
        }
    }

    public void m3443k() {
        m3411D();
    }

    public C0329b m3445m() {
        return (C0329b) getActivity();
    }

    public C0518a m3446n() {
        return this.f1876d;
    }

    public void m3436c(int position) {
        RedesignAlarm alarm = (RedesignAlarm) m3077i().get(position);
        if (alarm != null) {
            C0694b.m3140a(getActivity(), alarm.f2010k, alarm.f2012m);
        }
        m3408A();
        C0830k.m3896a(getActivity(), C0815b.Undo);
    }

    public void m3448p() {
        if (getView() != null) {
            m3408A();
            m3410C();
        }
    }

    private void m3416d(int position) {
        this.f1876d.m2521a();
        RedesignAlarm alarm = (RedesignAlarm) this.f1876d.getItem(position);
        m3077i().put(position, alarm);
        C0694b.m3140a(getActivity(), alarm.f2010k, false);
        this.b.m3994a(position, false);
        this.f1876d.m2460b((Object) alarm);
        this.f1876d.notifyDataSetChanged();
    }

    protected void m3428a(C0342a mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.multi_selection_edit:
                C0830k.m3896a(getActivity(), C0815b.MultiSelectionEdit);
                this.f1879g.m2449a((RedesignAlarm) this.f1876d.getItem(((Integer) m3086r().get(0)).intValue()));
            default:
        }
    }

    public void m3440f() {
        C0830k.m3896a(getActivity(), C0815b.MultiSelection);
    }

    public boolean m3429a(RedesignAlarm alarm) {
        return alarm.m3613a(getActivity()) || alarm.m3616b(getActivity());
    }

    public void m3450u() {
        m3408A();
        C0830k.m3896a(getActivity(), C0815b.MultiSelectionDelete);
    }

    public void m3433b(RedesignAlarm alarm) {
        C0694b.m3140a(getActivity(), alarm.f2010k, false);
    }

    public void m3449t() {
        C0858u.m4026a(getActivity(), getActivity().getString(R.string.delete_disabled_snoozed));
    }

    public void m3437c(RedesignAlarm alarm) {
        C0858u.m4026a(getActivity(), getActivity().getString(alarm.m3616b(getActivity()) ? R.string.delete_disabled_snoozed : R.string.delete_disabled_active));
    }

    protected void m3435c() {
        super.m3015c();
        if (getView() != null) {
            C0794b.m3780a(getActivity(), "Alarms");
            C0830k.m3896a(getActivity(), C0815b.Screen);
        }
    }

    protected void m3439d() {
        super.m3072d();
        if (this.f1876d != null) {
            m3447o();
        }
    }

    public void m3447o() {
        this.f1876d.m2521a();
    }

    public boolean m3442j() {
        return true;
    }
}
