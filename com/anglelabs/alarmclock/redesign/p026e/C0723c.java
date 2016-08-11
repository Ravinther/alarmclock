package com.anglelabs.alarmclock.redesign.p026e;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.NewMainActivity;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0814a;
import com.anglelabs.alarmclock.redesign.utils.C0834n;
import com.anglelabs.alarmclock.redesign.utils.C0834n.C0833a;
import com.avg.ui.general.rateus.C1186c;

/* renamed from: com.anglelabs.alarmclock.redesign.e.c */
public class C0723c extends Fragment implements OnClickListener {
    public final String f1858a;
    private TextView f1859b;
    private TextView f1860c;

    public C0723c() {
        this.f1858a = "RedesignAboutFragment";
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof C0564a) {
            ((C0564a) getActivity()).m2573n().m3754b(getString(R.string.acx_main_menu_about));
        }
        C0794b.m3778a(getActivity());
        C0794b.m3787d(getActivity());
        C0830k.m3896a(getActivity(), C0814a.Screen);
    }

    public void onDetach() {
        super.onDetach();
        C0794b.m3785b(getActivity());
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.redesign_fragment_about, container, false);
        TextView versionTextView = (TextView) view.findViewById(R.id.about_version);
        this.f1859b = (TextView) view.findViewById(R.id.about_tos_link);
        this.f1860c = (TextView) view.findViewById(R.id.about_privacy_link);
        versionTextView.setText(getString(R.string.about_app_version, "4.0.1", Integer.valueOf(198109)));
        m3388a(view);
        m3387a();
        return view;
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (getActivity() instanceof C0564a) {
            ((C0564a) getActivity()).m2573n().m3754b(getString(R.string.acx_main_menu_about));
        }
    }

    private void m3388a(View root) {
        root.findViewById(R.id.rate_app_button).setOnClickListener(this);
        root.findViewById(R.id.share_app_button).setOnClickListener(this);
        root.findViewById(R.id.about_more_apps).setOnClickListener(this);
    }

    private void m3387a() {
        this.f1859b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f1860c.setMovementMethod(LinkMovementMethod.getInstance());
        C0834n.m3947a(getActivity(), this.f1859b, C0833a.TOS);
        C0834n.m3947a(getActivity(), this.f1860c, C0833a.PRIVACY);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.about_more_apps:
                m3391d();
            case R.id.share_app_button:
                m3390c();
            case R.id.rate_app_button:
                m3389b();
            default:
        }
    }

    private void m3389b() {
        C1186c.m4956a(getActivity()).m4984a();
        C0830k.m3896a(getActivity(), C0814a.RateUs);
    }

    private void m3390c() {
        C1186c.m4956a(getActivity()).m4987b();
        C0830k.m3896a(getActivity(), C0814a.ShareApp);
    }

    private void m3391d() {
        ((NewMainActivity) getActivity()).m2585a(new C0722b(), true);
        C0830k.m3896a(getActivity(), C0814a.MoreAvgApps);
    }

    public void onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            menu.clear();
        }
        super.onPrepareOptionsMenu(menu);
    }
}
