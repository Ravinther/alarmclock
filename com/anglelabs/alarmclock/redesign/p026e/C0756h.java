package com.anglelabs.alarmclock.redesign.p026e;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.p028a.C0625c;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0605c.C0567a;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0616b;
import com.anglelabs.alarmclock.redesign.alarm.p028a.p029b.C0617d;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0823k;
import com.anglelabs.alarmclock.redesign.utils.ab;
import com.avg.toolkit.p049e.C0970a;
import com.p037b.p038a.C0673b;
import com.p037b.p038a.C1193a;
import com.p037b.p038a.C1200c;
import com.p037b.p038a.C1211j;

/* renamed from: com.anglelabs.alarmclock.redesign.e.h */
public class C0756h extends Fragment implements C0617d {
    private C0753a f1941a;
    private RedesignAlarm f1942b;
    private boolean f1943c;
    private boolean f1944d;
    private View f1945e;
    private C0616b f1946f;
    private C0567a f1947g;
    private boolean f1948h;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.h.1 */
    class C07511 implements OnClickListener {
        final /* synthetic */ C0756h f1934a;

        C07511(C0756h c0756h) {
            this.f1934a = c0756h;
        }

        public void onClick(View v) {
            if (!this.f1934a.f1944d) {
                this.f1934a.f1944d = true;
                this.f1934a.getActivity().sendBroadcast(new Intent("com.anglelabs.alarmclock.MUTE"));
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.h.2 */
    class C07522 extends C0673b {
        final /* synthetic */ C0756h f1935a;

        C07522(C0756h c0756h) {
            this.f1935a = c0756h;
        }

        public void m3507a(C1193a animation) {
            super.m3047a(animation);
            this.f1935a.f1946f.m2840b();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.h.a */
    private class C0753a extends BroadcastReceiver {
        final /* synthetic */ C0756h f1936a;

        private C0753a(C0756h c0756h) {
            this.f1936a = c0756h;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.f1936a.getActivity() != null) {
                this.f1936a.f1944d = intent.getAction().equals("com.anglelabs.alarmclock.MUTE");
                this.f1936a.m3518b(this.f1936a.f1944d);
            }
        }

        public IntentFilter m3508a() {
            IntentFilter filter = new IntentFilter();
            filter.addAction("com.anglelabs.alarmclock.UNMUTE");
            filter.addAction("com.anglelabs.alarmclock.MUTE");
            return filter;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.h.b */
    private class C0755b implements TextWatcher {
        final /* synthetic */ C0756h f1938a;
        private final TextView f1939b;
        private final EditText f1940c;

        /* renamed from: com.anglelabs.alarmclock.redesign.e.h.b.1 */
        class C07541 extends C0673b {
            final /* synthetic */ C0755b f1937a;

            C07541(C0755b c0755b) {
                this.f1937a = c0755b;
            }

            public void m3509a(C1193a animation) {
                super.m3047a(animation);
                this.f1937a.f1939b.setVisibility(8);
            }
        }

        public C0755b(C0756h c0756h, EditText editText, TextView errorText) {
            this.f1938a = c0756h;
            this.f1939b = errorText;
            this.f1940c = editText;
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (this.f1938a.f1948h) {
                this.f1940c.setBackgroundResource(R.drawable.math_edittext_background);
                C1193a animation = C0807e.m3822e(this.f1939b);
                animation.m5001a(new C07541(this));
                animation.m4999a();
                this.f1938a.f1948h = false;
            }
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
        }
    }

    public static C0756h m3511a(RedesignAlarm alarm, boolean isForDismiss) {
        C0756h fragment = new C0756h();
        Bundle extras = new Bundle();
        extras.putParcelable("alarm", alarm);
        extras.putBoolean("dismiss", isForDismiss);
        fragment.setArguments(extras);
        return fragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C0567a) {
            this.f1947g = (C0567a) activity;
            return;
        }
        C0970a.m4325b("activity must implement IAlertCallbacks, existing");
        getActivity().finish();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        this.f1942b = (RedesignAlarm) args.getParcelable("alarm");
        this.f1943c = args.getBoolean("dismiss");
    }

    public void onResume() {
        super.onResume();
        this.f1941a = new C0753a();
        getActivity().registerReceiver(this.f1941a, this.f1941a.m3508a());
        this.f1946f.m2842c();
    }

    public void onPause() {
        if (this.f1941a != null) {
            getActivity().unregisterReceiver(this.f1941a);
            this.f1941a = null;
        }
        super.onPause();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        this.f1946f.m2839a(outState);
        outState.putBoolean("is_in_mute", this.f1944d);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m3512a(savedInstanceState);
        View view = this.f1946f.m2837a(inflater, container);
        this.f1945e = view.findViewById(R.id.mute);
        if (this.f1942b.m3616b(getActivity())) {
            this.f1945e.setVisibility(4);
        }
        if (savedInstanceState != null) {
            this.f1944d = savedInstanceState.getBoolean("is_in_mute", false);
        }
        m3518b(this.f1944d);
        this.f1945e.setOnClickListener(new C07511(this));
        C0794b.m3780a(getActivity(), "Answer_" + this.f1946f.m2838a());
        C0830k.m3896a(getActivity(), C0823k.Screen);
        return view;
    }

    private void m3512a(Bundle savedInstanceState) {
        this.f1946f = C0625c.m2883a(this.f1942b, this, this.f1943c);
        this.f1946f.m2841b(savedInstanceState);
    }

    public void m3524a(boolean isStartedForDismiss) {
        if (this.f1943c) {
            this.f1947g.m2592d(this.f1942b);
            return;
        }
        this.f1947g.m2589a(this.f1942b);
        getFragmentManager().m262a().m189b(R.id.fragments_container, C0739e.m3452a(), "alert_fragment_tag").m188b();
    }

    public void m3523a(TextView errorText, EditText editText) {
        if (getView() == null) {
            C0970a.m4325b("no view when trying to animate, aborting");
            return;
        }
        this.f1948h = true;
        editText.setBackgroundResource(R.drawable.math_edittext_background_error);
        ((Vibrator) getActivity().getSystemService("vibrator")).vibrate(100);
        m3513a(errorText);
    }

    public void m3522a() {
        getActivity().onBackPressed();
    }

    public TextWatcher m3521a(EditText editText, TextView errorTextView) {
        return new C0755b(this, editText, errorTextView);
    }

    public Context m3525b() {
        return getActivity();
    }

    private void m3513a(TextView errorText) {
        if (getView() == null) {
            C0970a.m4325b("view is null, aborting");
            return;
        }
        C0807e.m3808a(getView().findViewById(R.id.screen_view), ab.m3760b(15, getResources())).m5031a();
        C1200c set = new C1200c();
        C1193a fadeInAnim = C0807e.m3806a((View) errorText, 150);
        C1211j expandAnimation = C0807e.m3819c(errorText);
        set.m5001a(new C07522(this));
        set.m5035b(150);
        set.m5034a(fadeInAnim, expandAnimation);
        set.m5031a();
    }

    private void m3518b(boolean isInMute) {
        if (isInMute || this.f1942b.m3616b(getActivity())) {
            this.f1945e.setVisibility(4);
        } else {
            this.f1945e.setVisibility(0);
        }
    }
}
