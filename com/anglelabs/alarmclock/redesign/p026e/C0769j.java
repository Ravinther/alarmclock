package com.anglelabs.alarmclock.redesign.p026e;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.p012a.C0329b;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.NewMainActivity.C0561a;
import com.anglelabs.alarmclock.redesign.p020a.C0557e;
import com.anglelabs.alarmclock.redesign.p020a.C0557e.C0554a;
import com.anglelabs.alarmclock.redesign.p020a.C0557e.C0555b;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.p021b.p036c.C0675b;
import com.anglelabs.alarmclock.redesign.timer.C0783a;
import com.anglelabs.alarmclock.redesign.timer.C0785c;
import com.anglelabs.alarmclock.redesign.timer.TimerObject;
import com.anglelabs.alarmclock.redesign.timer.TimerObject.C0779b;
import com.anglelabs.alarmclock.redesign.timer.TimerReceiver;
import com.anglelabs.alarmclock.redesign.utils.C0790a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0807e.C0730b;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0829q;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.anglelabs.alarmclock.redesign.views.TimerView;
import com.avg.toolkit.p049e.C0970a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import com.p037b.p038a.C1193a;

/* renamed from: com.anglelabs.alarmclock.redesign.e.j */
public class C0769j extends C0675b implements C0561a {
    private final int f1976c;
    private SharedPreferences f1977d;
    private ListView f1978e;
    private C0557e f1979f;
    private C0554a f1980g;
    private boolean f1981h;
    private TimerObject f1982i;
    private ViewSwitcher f1983j;
    private TimerView f1984k;
    private Boolean f1985l;
    private C0790a f1986m;
    private C0768a f1987n;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.j.1 */
    class C07631 implements OnClickListener {
        final /* synthetic */ C0769j f1967a;

        C07631(C0769j c0769j) {
            this.f1967a = c0769j;
        }

        public void onClick(View v) {
            this.f1967a.m3570b(null);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.j.2 */
    class C07642 implements OnClickListener {
        final /* synthetic */ C0769j f1968a;

        C07642(C0769j c0769j) {
            this.f1968a = c0769j;
        }

        public void onClick(View v) {
            C0779b action;
            TimerObject timer = this.f1968a.f1984k.m4123a();
            if (this.f1968a.m3573d(timer.m3683a())) {
                action = C0779b.Update;
            } else {
                action = C0779b.Create;
            }
            timer.m3691a(action, this.f1968a.f1977d);
            TimerReceiver.m3704a(this.f1968a.getActivity(), timer.m3683a(), action);
            if (action == C0779b.Create) {
                this.f1968a.f1979f.m2457a((Object) timer);
                this.f1968a.f1978e.setSelection(this.f1968a.f1979f.getCount());
            } else {
                this.f1968a.f1979f.notifyDataSetChanged();
            }
            C0830k.m3896a(this.f1968a.getActivity(), C0829q.Start);
            this.f1968a.m3565a(true);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.j.3 */
    class C07663 implements C0554a {
        final /* synthetic */ C0769j f1972a;

        /* renamed from: com.anglelabs.alarmclock.redesign.e.j.3.1 */
        class C07651 extends C0730b {
            final /* synthetic */ View f1969a;
            final /* synthetic */ int f1970b;
            final /* synthetic */ C07663 f1971c;

            C07651(C07663 c07663, View view, int i) {
                this.f1971c = c07663;
                this.f1969a = view;
                this.f1970b = i;
            }

            public void m3549a(C1193a animation) {
                this.f1971c.f1972a.a.m3970a(this.f1969a, this.f1970b);
            }
        }

        C07663(C0769j c0769j) {
            this.f1972a = c0769j;
        }

        public void m3555b(TimerObject timer) {
            int ringingState = timer.m3693c();
            timer.m3691a(C0779b.Restart, this.f1972a.f1977d);
            TimerReceiver.m3704a(this.f1972a.getActivity(), timer.m3683a(), C0779b.Restart);
            this.f1972a.f1979f.notifyDataSetChanged();
            if (ringingState == 11) {
                this.f1972a.m3584x();
            }
            this.f1972a.m3559A();
            C0830k.m3896a(this.f1972a.getActivity(), C0829q.Reset);
        }

        public void m3550a(TimerObject timer) {
            timer.m3691a(C0779b.AddMinutes, this.f1972a.f1977d);
            TimerReceiver.m3704a(this.f1972a.getActivity(), timer.m3683a(), C0779b.AddMinutes);
            this.f1972a.f1979f.notifyDataSetChanged();
            C0830k.m3896a(this.f1972a.getActivity(), C0829q.Plus1);
        }

        public void m3556c(TimerObject timer) {
            timer.m3691a(C0779b.Play, this.f1972a.f1977d);
            TimerReceiver.m3704a(this.f1972a.getActivity(), timer.m3683a(), C0779b.Play);
            this.f1972a.f1979f.notifyDataSetChanged();
            this.f1972a.m3585y();
            C0830k.m3896a(this.f1972a.getActivity(), C0829q.Play);
        }

        public void m3557d(TimerObject timer) {
            int ringingState = timer.m3693c();
            timer.m3691a(C0779b.Stop, this.f1972a.f1977d);
            TimerReceiver.m3704a(this.f1972a.getActivity(), timer.m3683a(), C0779b.Stop);
            this.f1972a.f1979f.notifyDataSetChanged();
            if (ringingState == 11) {
                this.f1972a.m3584x();
            }
            this.f1972a.m3559A();
            C0830k.m3896a(this.f1972a.getActivity(), C0829q.Stop);
        }

        public void m3551a(TimerObject timer, int position) {
            View view = this.f1972a.m3600l().getChildAt(position - this.f1972a.m3600l().getFirstVisiblePosition());
            C0807e.m3811a(view, true, (long) this.f1972a.getResources().getInteger(17694721), new C07651(this, view, position)).m5289a();
        }

        public boolean m3554a(int position) {
            return this.f1972a.f1978e.isItemChecked(position);
        }

        public boolean m3553a() {
            return this.f1972a.m3073e();
        }

        public void m3552a(TimerObject timer, String newText) {
            if (newText != null && !newText.equals(timer.m3695e())) {
                timer.m3688a(this.f1972a.f1977d, newText);
            }
        }

        public void m3558e(TimerObject timer) {
            TimerReceiver.m3704a(this.f1972a.getActivity(), timer.m3683a(), C0779b.TimeOver);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.j.4 */
    class C07674 implements OnItemClickListener {
        final /* synthetic */ C0769j f1973a;

        C07674(C0769j c0769j) {
            this.f1973a = c0769j;
        }

        public void onItemClick(AdapterView parent, View view, int position, long id) {
            this.f1973a.f1982i = (TimerObject) this.f1973a.f1979f.getItem(position);
            if (this.f1973a.f1982i.m3699i()) {
                this.f1973a.f1980g.m2545d(this.f1973a.f1982i);
            }
            this.f1973a.m3570b(this.f1973a.f1982i);
            C0830k.m3896a(this.f1973a.getActivity(), C0829q.Edit);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.j.a */
    private class C0768a implements Runnable {
        boolean f1974a;
        final /* synthetic */ C0769j f1975b;

        private C0768a(C0769j c0769j) {
            this.f1975b = c0769j;
            this.f1974a = true;
        }

        public void run() {
            boolean visible = TimerObject.m3681m() % 1000 < 500;
            boolean toggle = this.f1974a != visible;
            this.f1974a = visible;
            int start = this.f1975b.f1978e.getFirstVisiblePosition();
            int end = this.f1975b.f1978e.getLastVisiblePosition();
            if (this.f1975b.f1979f.getCount() <= end) {
                end = this.f1975b.f1979f.getCount() - 1;
            }
            if (start < 0) {
                start = 0;
            }
            for (int i = start; i <= end; i++) {
                TimerObject timer = (TimerObject) this.f1975b.f1979f.getItem(i);
                switch (timer.m3692b()) {
                    case Base64.NO_PADDING /*1*/:
                        View view = this.f1975b.f1978e.getChildAt(i - start);
                        if (view == null) {
                            break;
                        }
                        C0555b tvh = (C0555b) view.getTag();
                        tvh.m2548a(timer);
                        if (toggle) {
                            if (timer.m3699i()) {
                                tvh.m2549a(this.f1974a);
                            } else {
                                tvh.m2549a(false);
                            }
                        }
                        Rect rect = new Rect();
                        view.getDrawingRect(rect);
                        view.invalidate(rect);
                        break;
                    default:
                        break;
                }
            }
            if (this.f1975b.f1981h) {
                this.f1975b.f1978e.postDelayed(this.f1975b.f1987n, 350);
            }
        }
    }

    public C0769j() {
        this.f1976c = 350;
        this.f1981h = false;
        this.f1985l = null;
    }

    public /* synthetic */ void m3594c(Object x0) {
        m3588a((TimerObject) x0);
    }

    public boolean m3589a() {
        boolean takeOverBackPress = this.f1986m != null && this.f1986m.m3752a();
        if (takeOverBackPress) {
            m3565a(true);
        }
        return takeOverBackPress;
    }

    protected int m3590b() {
        return 1;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C0564a) {
            this.f1986m = ((C0564a) activity).m2573n();
        }
    }

    public void onResume() {
        super.onResume();
        Intent intent = getActivity().getIntent();
        if (intent.getBooleanExtra("extra_timer_setup", false)) {
            m3570b(null);
            return;
        }
        int timerId = intent.getIntExtra("extra_timer_id", -1);
        if (timerId != -1) {
            m3583w();
            m3565a(true);
            TimerObject timerIntent = C0785c.m3732a(this.f1977d, timerId);
            if (timerIntent != null) {
                switch (timerIntent.m3693c()) {
                    case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                        if (C0785c.m3734a(this.f1979f.m2464h()) == null) {
                            m3573d(timerId);
                            break;
                        }
                        break;
                }
            }
            intent.putExtra("extra_timer_id", -1);
        }
    }

    public void onPause() {
        super.onPause();
        m3586z();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.f1978e != null) {
            outState.putBoolean("isTimerListShown", this.f1985l.booleanValue());
            if (this.f1985l == null) {
                return;
            }
            if (this.f1985l.booleanValue()) {
                outState.putInt("timer_position", this.f1978e.getFirstVisiblePosition());
            } else if (!this.f1985l.booleanValue() && this.f1984k != null) {
                outState.putParcelable("timer_edit_id", this.f1984k.getTimer());
                this.f1984k.m4126b(outState);
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        m3586z();
        this.f1987n = null;
    }

    public View m3587a(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f1977d = ac.m3774b(getActivity());
        View view = inflater.inflate(R.layout.redesign_fragment_view_timer_list, container, false);
        this.f1987n = new C0768a();
        ((TextView) view.findViewById(R.id.footer_textview)).setText(R.string.add_timer);
        view.findViewById(R.id.footer).setOnClickListener(new C07631(this));
        this.f1984k = (TimerView) view.findViewById(R.id.timer_view);
        view.findViewById(R.id.start_timer_button).setOnClickListener(new C07642(this));
        m3569b((ListView) view.findViewById(R.id.list));
        this.f1983j = (ViewSwitcher) view.findViewById(R.id.timer_switcher);
        m3562a(savedInstanceState);
        view.setKeepScreenOn(this.f1977d.getBoolean("keep_screen_on", false));
        return view;
    }

    private void m3562a(Bundle savedInstanceState) {
        if (this.f1985l == null && savedInstanceState != null && savedInstanceState.containsKey("isTimerListShown")) {
            this.f1985l = Boolean.valueOf(savedInstanceState.getBoolean("isTimerListShown"));
        }
        if (this.f1985l != null) {
            if (this.f1985l.booleanValue()) {
                m3565a(false);
                if (savedInstanceState != null) {
                    this.f1978e.smoothScrollToPosition(savedInstanceState.getInt("timer_position", 0));
                    return;
                }
                return;
            }
            if (!(this.f1982i == null || savedInstanceState == null || !savedInstanceState.containsKey("timer_edit_id"))) {
                this.f1982i = (TimerObject) savedInstanceState.getParcelable("timer_edit_id");
            }
            m3570b(this.f1982i);
            this.f1984k.m4124a(savedInstanceState);
        } else if (this.f1979f.getCount() > 0) {
            m3565a(false);
        } else {
            m3570b(null);
        }
    }

    private void m3570b(TimerObject timer) {
        CharSequence charSequence = null;
        m3586z();
        this.f1984k.m4125a(timer, this.f1979f.getCount());
        if (this.f1983j.getCurrentView().getId() != R.id.timer_layout) {
            this.f1983j.showPrevious();
        }
        this.f1985l = Boolean.valueOf(false);
        this.f1983j.setInAnimation(null);
        this.f1983j.setOutAnimation(null);
        if (this.f1979f.getCount() != 0) {
            C0790a c0790a = this.f1986m;
            CharSequence string = getString(R.string.set_timer_title);
            if (timer != null) {
                charSequence = timer.m3695e();
            }
            c0790a.m3755b(string, charSequence);
        }
        m3603o();
    }

    private void m3565a(boolean startTicking) {
        if (this.f1983j.getCurrentView().getId() != R.id.list_layout) {
            this.f1983j.showNext();
        }
        this.f1982i = null;
        C0807e.m3813a(getActivity(), this.f1983j, (int) R.anim.from_middle, (int) R.anim.to_middle);
        m3584x();
        this.f1985l = Boolean.valueOf(true);
        this.f1986m.m3753b();
        if (startTicking) {
            m3559A();
        }
    }

    private void m3569b(ListView listView) {
        this.f1978e = listView;
        this.f1980g = new C07663(this);
        this.f1979f = new C0557e(getActivity(), this.f1980g);
        this.f1978e.setAdapter(this.f1979f);
        this.f1978e.setItemsCanFocus(true);
        m3583w();
        this.f1978e.setOnItemClickListener(new C07674(this));
    }

    private void m3583w() {
        this.f1979f.m2468b(C0783a.m3714a(this.f1977d));
        m3559A();
    }

    public String m3597h() {
        SparseArray undoList = m3077i();
        int lastAvailableIndex = undoList.size() - 1;
        if (lastAvailableIndex < 0) {
            return null;
        }
        if (undoList.keyAt(lastAvailableIndex) < 0) {
            C0970a.m4325b("unable to retrieve undo list! avoid crash");
            return null;
        } else if (m3077i().size() > 1) {
            return getString(R.string.undo_multiple, Integer.valueOf(m3077i().size()), getString(R.string.undo_multiple_format_timer));
        } else {
            return getString(R.string.undo_single, ((TimerObject) undoList.get(index)).m3695e());
        }
    }

    public void m3591b(int position) {
        TimerObject timer = (TimerObject) this.f1979f.getItem(position);
        m3077i().clear();
        m3077i().put(position, timer);
        this.b.m3994a(position, false);
        m3588a(timer);
        this.f1979f.m2561a();
        this.f1979f.m2460b((Object) timer);
        m3559A();
        C0830k.m3896a(getActivity(), C0829q.Delete);
    }

    public void m3596f() {
        C0830k.m3896a(getActivity(), C0829q.MultiSelection);
    }

    public void m3604u() {
        m3559A();
        C0830k.m3896a(getActivity(), C0829q.MultiSelectionDelete);
    }

    public void m3588a(TimerObject timer) {
        timer.m3691a(C0779b.Delete, this.f1977d);
        TimerReceiver.m3704a(getActivity(), timer.m3683a(), C0779b.Delete);
    }

    public void m3593c(int position) {
        TimerObject timer = (TimerObject) m3077i().get(position);
        if (timer != null) {
            timer.m3689a(this.f1977d, true);
            TimerReceiver.m3704a(getActivity(), timer.m3683a(), C0779b.Create);
            m3559A();
            C0830k.m3896a(getActivity(), C0829q.Undo);
        }
    }

    public void m3599k() {
        m3077i().clear();
        if (this.f1979f.getCount() == 0) {
            m3570b(null);
        }
    }

    public void m3603o() {
        this.f1979f.m2561a();
    }

    public ListView m3600l() {
        return this.f1978e;
    }

    public C0329b m3601m() {
        return (C0329b) getActivity();
    }

    public C0518a m3602n() {
        return this.f1979f;
    }

    private void m3584x() {
        int size = this.f1979f.getCount();
        for (int position = 0; position < size; position++) {
            if (((TimerObject) this.f1979f.getItem(position)).m3693c() == 11) {
                this.f1978e.smoothScrollToPosition(position);
                return;
            }
        }
    }

    private boolean m3573d(int timerId) {
        int size = this.f1979f.getCount();
        for (int position = 0; position < size; position++) {
            if (((TimerObject) this.f1979f.getItem(position)).m3683a() == timerId) {
                this.f1978e.smoothScrollToPosition(position);
                return true;
            }
        }
        return false;
    }

    private void m3585y() {
        if (!this.f1981h) {
            this.f1978e.postDelayed(this.f1987n, 350);
            this.f1981h = true;
        }
    }

    private void m3586z() {
        if (this.f1981h) {
            this.f1978e.removeCallbacks(this.f1987n);
            this.f1981h = false;
        }
    }

    private void m3559A() {
        if (C0785c.m3735a(C0783a.m3714a(this.f1977d)) && m3560B()) {
            m3585y();
        } else {
            m3586z();
        }
    }

    public boolean m3598j() {
        return false;
    }

    protected void m3592c() {
        boolean isUserEditingExistingTimer = false;
        if (getView() != null) {
            if (this.f1978e != null) {
                m3559A();
            }
            C0794b.m3780a(getActivity(), "Timer");
            getView().setKeepScreenOn(this.f1977d.getBoolean("keep_screen_on", false));
            C0830k.m3896a(getActivity(), C0829q.Screen);
            if (!m3560B() && ((this.f1985l != null || this.f1979f.getCount() <= 0) && this.f1979f.getCount() != 0)) {
                isUserEditingExistingTimer = true;
            }
            if (isUserEditingExistingTimer) {
                this.f1986m.m3755b(getString(R.string.set_timer_title), this.f1982i != null ? this.f1982i.m3695e() : null);
            } else {
                this.f1986m.m3753b();
            }
        }
    }

    private boolean m3560B() {
        return this.f1985l != null && this.f1985l.booleanValue();
    }

    protected void m3595d() {
        super.m3072d();
        if (this.f1979f != null) {
            m3603o();
        }
        if (this.f1978e != null) {
            m3586z();
        }
        this.f1981h = false;
        if (getView() != null) {
            getView().setKeepScreenOn(false);
        }
        if (getActivity() != null) {
            this.f1986m.m3753b();
        }
    }
}
