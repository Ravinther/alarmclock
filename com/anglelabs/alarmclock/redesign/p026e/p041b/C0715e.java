package com.anglelabs.alarmclock.redesign.p026e.p041b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C0092n.C0091a;
import android.support.v4.p006a.C0006h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.RedesignSetSoundTypeActivity.C0590a;
import com.anglelabs.alarmclock.redesign.p020a.p023a.C0532e;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0689d;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0689d.C0688a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0818e;
import java.util.ArrayList;

/* renamed from: com.anglelabs.alarmclock.redesign.e.b.e */
public class C0715e extends C0710a implements C0091a, C0590a {
    private C0532e f1837e;

    protected boolean m3281q() {
        return false;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().m395a(3, null, this);
    }

    public C0006h m3271a(int id, Bundle bundle) {
        return new C0689d(getActivity());
    }

    public View m3272a(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f1837e = new C0532e(getActivity());
        if (getActivity().getIntent() != null && getActivity().getIntent().hasExtra("selected_item_name")) {
            this.f1837e.m2473a(getActivity().getIntent().getStringExtra("selected_item_name"));
            getActivity().getIntent().removeExtra("selected_item_name");
        }
        m3184C();
        m3185D();
        C0794b.m3780a(getActivity(), "choose_ringtone");
        C0830k.m3896a(getActivity(), C0818e.RINGTONE);
        return super.m3188a(inflater, container, savedInstanceState);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.c.setOnTouchListener(null);
        m3190a(true);
        super.onViewCreated(view, savedInstanceState);
    }

    public void m3275a(C0006h loader, ArrayList data) {
        m3190a(false);
        this.c.setEmptyView(getView().findViewById(16908292));
        this.f1837e.m2468b(data);
        m3183B();
        this.f1837e.notifyDataSetChanged();
    }

    public void m3273a(C0006h loader) {
    }

    public C0518a m3280n() {
        return this.f1837e;
    }

    public boolean m3277b(String arg0) {
        return false;
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
        C0688a item = (C0688a) this.f1837e.getItem(position);
        this.f1837e.m2491a(m3196c(item.f1791d.toString()) ? item.f1789b : -1);
    }

    CharSequence m3283w() {
        return getString(R.string.music_type_select_ringtone);
    }

    CharSequence m3284x() {
        return null;
    }

    CharSequence m3285y() {
        return null;
    }

    String m3286z() {
        return null;
    }

    String m3269A() {
        return "";
    }

    void m3276a(View footerView) {
    }

    public boolean m3278j() {
        return false;
    }

    public void m3279k() {
    }

    public void m3282v() {
    }

    public Intent m3270a() {
        if (this.f1837e.m2478c() == null || this.f1837e.m2478c().size() <= 0) {
            return null;
        }
        C0688a selectedRingtone = (C0688a) this.f1837e.m2478c().get(0);
        if (selectedRingtone == null) {
            return null;
        }
        Intent result = new Intent().setData(selectedRingtone.f1791d);
        result.putExtra("item_display_text", selectedRingtone.f1788a);
        return result;
    }
}
