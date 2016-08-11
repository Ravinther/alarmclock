package com.anglelabs.alarmclock.redesign.p026e;

import android.app.Activity;
import android.os.Bundle;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.components.C0721h;

/* renamed from: com.anglelabs.alarmclock.redesign.e.b */
public class C0722b extends C0721h {
    public final String f1857a;

    public C0722b() {
        this.f1857a = "LegacyMoreAVGAppsFragment";
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof C0564a) {
            ((C0564a) getActivity()).m2573n().m3754b(getString(R.string.more_apps_action_bar_title));
        }
        C0794b.m3778a(getActivity());
        C0794b.m3787d(getActivity());
    }

    public void onDetach() {
        super.onDetach();
        C0794b.m3785b(getActivity());
    }

    protected void m3386a(Activity activity) {
        try {
            getFragmentManager().m270c();
        } catch (Exception e) {
            C0970a.m4322a(e);
            startActivity(C0832m.m3927e(getActivity()));
        }
    }
}
