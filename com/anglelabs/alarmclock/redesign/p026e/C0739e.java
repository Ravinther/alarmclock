package com.anglelabs.alarmclock.redesign.p026e;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.AlarmStateManager;
import com.anglelabs.alarmclock.redesign.alarm.C0645c;
import com.anglelabs.alarmclock.redesign.alarm.C0646d;
import com.anglelabs.alarmclock.redesign.alarm.p028a.C0631d;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p032d.C0628c;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0816c;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.C0858u;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.C0870z.C0869a;
import com.anglelabs.alarmclock.redesign.views.DigitalClock;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.anglelabs.alarmclock.redesign.e.e */
public class C0739e extends Fragment {
    private AnimationDrawable f1890a;
    private RedesignAlarm f1891b;
    private TextView f1892c;
    private TextView f1893d;
    private C0567a f1894e;
    private ViewSwitcher f1895f;
    private ViewGroup f1896g;
    private ImageView f1897h;
    private TextView f1898i;
    private TextView f1899j;
    private DigitalClock f1900k;
    private TextView f1901l;
    private Runnable f1902m;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.e.1 */
    class C07361 implements OnClickListener {
        final /* synthetic */ C0605c f1885a;
        final /* synthetic */ C0739e f1886b;

        C07361(C0739e c0739e, C0605c c0605c) {
            this.f1886b = c0739e;
            this.f1885a = c0605c;
        }

        public void onClick(View v) {
            this.f1886b.f1892c.setOnClickListener(null);
            if (!this.f1885a.m2800b()) {
                CharSequence errorMessage = this.f1885a.m2801f();
                if (!TextUtils.isEmpty(errorMessage)) {
                    C0858u.m4026a(this.f1886b.getActivity(), errorMessage.toString());
                }
            } else if (this.f1885a instanceof C0628c) {
                this.f1885a.m2798a();
            } else {
                this.f1885a.m2798a();
                this.f1886b.m3463c();
                this.f1886b.m3459f();
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.e.2 */
    class C07372 implements OnClickListener {
        final /* synthetic */ C0605c f1887a;
        final /* synthetic */ C0739e f1888b;

        C07372(C0739e c0739e, C0605c c0605c) {
            this.f1888b = c0739e;
            this.f1887a = c0605c;
        }

        public void onClick(View v) {
            this.f1887a.m2798a();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.e.a */
    private final class C0738a implements Runnable {
        final /* synthetic */ C0739e f1889a;

        private C0738a(C0739e c0739e) {
            this.f1889a = c0739e;
        }

        public void run() {
            if (this.f1889a.getActivity() != null) {
                C0869a timeUnits = C0870z.m4057a(this.f1889a.f1891b.m3619e(this.f1889a.getActivity()) - System.currentTimeMillis());
                this.f1889a.f1898i.setText(C0870z.m4063a(timeUnits));
                if ((timeUnits.f2505d > 0 || timeUnits.f2504c > 0 || timeUnits.f2503b > 0) && this.f1889a.f1902m != null) {
                    this.f1889a.f1898i.postDelayed(this, 1000);
                }
            }
        }
    }

    public static C0739e m3452a() {
        return new C0739e();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C0567a) {
            this.f1894e = (C0567a) activity;
            return;
        }
        C0970a.m4325b("activity must implement IAlertCallbacks, exiting");
        getActivity().finish();
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("alarm", this.f1891b);
        super.onSaveInstanceState(outState);
    }

    public boolean m3461a(Intent intent) {
        if (this.f1891b == null) {
            return false;
        }
        if (this.f1891b.m3616b(getActivity())) {
            m3463c();
        } else {
            m3462b();
        }
        return true;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.redesign_fragment_alarm_alert_layout, container, false);
        this.f1902m = new C0738a();
        this.f1895f = (ViewSwitcher) view.findViewById(R.id.alarm_snooze_switcher);
        this.f1896g = (ViewGroup) view.findViewById(R.id.alarm_snoozed_display);
        this.f1897h = (ImageView) view.findViewById(R.id.alarm_snooze_animation);
        this.f1892c = (TextView) view.findViewById(R.id.alarm_snooze_button);
        this.f1893d = (TextView) view.findViewById(R.id.alarm_dismiss_button);
        this.f1898i = (TextView) view.findViewById(R.id.alarm_snoozed_text);
        this.f1899j = (TextView) view.findViewById(R.id.alarm_label);
        this.f1900k = (DigitalClock) view.findViewById(R.id.clock_layout);
        this.f1901l = (TextView) view.findViewById(R.id.alarm_times_snoozed);
        m3453a(savedInstanceState);
        m3464d();
        C0807e.m3812a(getActivity(), this.f1895f);
        C0794b.m3780a(getActivity(), "alarm_on");
        C0830k.m3896a(getActivity(), C0816c.Screen);
        return view;
    }

    public void onResume() {
        super.onResume();
        if (this.f1891b.m3616b(getActivity()) && this.f1902m != null) {
            this.f1892c.post(this.f1902m);
        }
    }

    public void onPause() {
        this.f1892c.removeCallbacks(this.f1902m);
        super.onPause();
    }

    public void onDestroyView() {
        this.f1892c.removeCallbacks(this.f1902m);
        this.f1902m = null;
        if (this.f1890a != null) {
            this.f1890a.stop();
            this.f1890a = null;
        }
        super.onDestroyView();
    }

    void m3462b() {
        if (this.f1895f.getCurrentView().getId() != this.f1892c.getId()) {
            this.f1895f.showPrevious();
        }
        m3464d();
    }

    public void m3463c() {
        m3458e();
        if (this.f1895f.getCurrentView().getId() == this.f1892c.getId()) {
            this.f1895f.showNext();
            this.f1896g.setBackgroundColor(0);
        }
        if (this.f1891b.m3616b(getActivity()) || !this.f1891b.m3621g(getActivity())) {
            if (this.f1902m != null) {
                this.f1892c.post(this.f1902m);
            }
            this.f1890a = (AnimationDrawable) this.f1897h.getBackground();
            if (this.f1890a != null) {
                this.f1890a.start();
                return;
            }
            return;
        }
        C0631d.m2903a(this.f1892c);
    }

    private void m3453a(Bundle state) {
        if (state != null) {
            this.f1891b = (RedesignAlarm) state.getParcelable("alarm");
        } else {
            this.f1891b = (RedesignAlarm) getActivity().getIntent().getParcelableExtra("intent.extra.alarm");
        }
    }

    private void m3458e() {
        int timeSnoozed = this.f1894e.m2595m();
        if (timeSnoozed > 0) {
            CharSequence string;
            TextView textView = this.f1901l;
            if (timeSnoozed == 1) {
                string = getString(R.string.alarm_times_snoozed_single);
            } else {
                string = getString(R.string.alarm_times_snoozed_multiple, Integer.valueOf(timeSnoozed));
            }
            textView.setText(string);
            return;
        }
        this.f1901l.setText("");
    }

    void m3464d() {
        if (TextUtils.isEmpty(this.f1891b.f2020u)) {
            this.f1899j.setVisibility(8);
        } else {
            this.f1899j.setText(this.f1891b.f2020u);
        }
        if (this.f1891b.f2015p) {
            m3460g();
        }
        m3458e();
        C0605c snoozeController = this.f1894e.m2590b(this.f1892c);
        if (!this.f1891b.m3616b(getActivity())) {
            this.f1892c.setOnClickListener(new C07361(this, snoozeController));
        }
        this.f1893d.setOnClickListener(new C07372(this, this.f1894e.m2588a(this.f1893d)));
        if (this.f1891b.m3616b(getActivity())) {
            m3463c();
            m3459f();
        } else if (this.f1891b.m3621g(getActivity())) {
            C0631d.m2903a(this.f1892c);
        }
    }

    private void m3459f() {
        if (getActivity() != null) {
            boolean hasSnoozes;
            if (C0646d.m2975a(getActivity(), this.f1891b.f2010k) > 0) {
                hasSnoozes = true;
            } else {
                hasSnoozes = false;
            }
            long alarmTime = this.f1891b.m3619e(getActivity());
            if (1000 + alarmTime < System.currentTimeMillis()) {
                C0850q.m3987b("CountdownActivity Snooze time is before the current time. Finishing activity. Snooze time = " + alarmTime + " System time = " + System.currentTimeMillis());
                if (hasSnoozes) {
                    C0645c.m2972d(getActivity(), this.f1891b);
                    AlarmStateManager.m2789a(getActivity(), false);
                }
                getActivity().finish();
            } else if (this.f1902m != null) {
                this.f1892c.post(this.f1902m);
            }
        }
    }

    private void m3460g() {
        LayoutParams params = (LayoutParams) this.f1895f.getLayoutParams();
        params.addRule(3, R.id.alert_scroll_view);
        params.height = 0;
        this.f1895f.setLayoutParams(params);
    }
}
