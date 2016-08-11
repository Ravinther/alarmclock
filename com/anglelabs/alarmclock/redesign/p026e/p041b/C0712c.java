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
import com.anglelabs.alarmclock.redesign.p020a.p023a.C0526c;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0685b;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0685b.C0684a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import java.util.ArrayList;

/* renamed from: com.anglelabs.alarmclock.redesign.e.b.c */
public class C0712c extends C0710a implements C0091a, C0590a {
    private C0526c f1831e;
    private String f1832f;

    /* synthetic */ CharSequence m3239w() {
        return m3224G();
    }

    protected boolean m3237q() {
        return false;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().m395a(1, null, this);
    }

    public C0006h m3226a(int id, Bundle bundle) {
        return new C0685b(getActivity(), this.f1832f);
    }

    public View m3227a(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f1831e = new C0526c(getActivity());
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("selected_item_name")) {
            this.f1831e.m2473a(intent.getStringExtra("selected_item_name"));
            intent.removeExtra("selected_item_name");
        }
        m3184C();
        C0794b.m3780a(getActivity(), "choose_artist");
        return super.m3188a(inflater, container, savedInstanceState);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.c.setOnTouchListener(null);
        m3190a(true);
        super.onViewCreated(view, savedInstanceState);
    }

    public void m3230a(C0006h loader, ArrayList data) {
        m3190a(false);
        this.c.setEmptyView(getView().findViewById(16908292));
        this.f1831e.m2468b(data);
        m3183B();
        this.f1831e.notifyDataSetChanged();
    }

    public void m3228a(C0006h loader) {
    }

    public C0518a m3235n() {
        return this.f1831e;
    }

    String m3224G() {
        return getString(R.string.music_type_select_artist);
    }

    public void m3236p() {
        getActivity().m256e();
        getLoaderManager().m397b(1, null, this);
    }

    public boolean m3232b(String text) {
        this.f1832f = text;
        getLoaderManager().m397b(1, null, this);
        return false;
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
        this.f1831e.m2475a(position);
    }

    public Intent m3225a() {
        ArrayList checkedItem = this.f1831e.m2478c();
        if (checkedItem == null || checkedItem.size() <= 0) {
            return null;
        }
        C0684a item = (C0684a) checkedItem.get(0);
        Intent result = new Intent();
        result.putExtra("artist_id", item.f1780b);
        result.putExtra("item_display_text", item.f1779a);
        return result;
    }

    CharSequence m3240x() {
        return null;
    }

    CharSequence m3241y() {
        return null;
    }

    String m3242z() {
        return null;
    }

    String m3223A() {
        return getString(R.string.no_artists_found);
    }

    void m3231a(View footerView) {
    }

    public boolean m3233j() {
        return false;
    }

    public void m3234k() {
    }

    public void m3238v() {
    }
}
