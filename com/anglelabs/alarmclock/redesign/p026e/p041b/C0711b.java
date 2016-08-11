package com.anglelabs.alarmclock.redesign.p026e.p041b;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C0092n.C0091a;
import android.support.v4.p006a.C0006h;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.RedesignSetSoundTypeActivity.C0590a;
import com.anglelabs.alarmclock.redesign.p020a.p023a.C0523b;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0683a;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0683a.C0681a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.anglelabs.alarmclock.redesign.e.b.b */
public class C0711b extends C0710a implements C0091a, C0590a {
    private C0523b f1829e;
    private ArrayList f1830f;

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().m395a(4, null, this);
    }

    public boolean m3213b(String text) {
        if (TextUtils.isEmpty(text)) {
            if (this.f1830f != null && this.f1830f.size() > 0) {
                this.f1829e.m2468b(this.f1830f);
                this.f1829e.notifyDataSetChanged();
            }
        } else if (this.f1830f != null) {
            ArrayList copyList = new ArrayList(this.f1830f);
            ArrayList removeList = new ArrayList();
            Iterator i$ = copyList.iterator();
            while (i$.hasNext()) {
                C0681a applicationInfo = (C0681a) i$.next();
                if (!applicationInfo.m3107b().toLowerCase(Locale.getDefault()).contains(text.toLowerCase(Locale.getDefault()))) {
                    removeList.add(applicationInfo);
                }
            }
            copyList.removeAll(removeList);
            this.f1829e.m2468b(copyList);
            this.f1829e.notifyDataSetChanged();
        }
        return true;
    }

    public C0006h m3207a(int id, Bundle bundle) {
        return new C0683a(getActivity());
    }

    public View m3208a(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f1829e = new C0523b(getActivity());
        if (getActivity().getIntent() != null && getActivity().getIntent().hasExtra("selected_item_name")) {
            this.f1829e.m2473a(getActivity().getIntent().getStringExtra("selected_item_name"));
            getActivity().getIntent().removeExtra("selected_item_name");
        }
        m3184C();
        C0794b.m3780a(getActivity(), "choose_application");
        return super.m3188a(inflater, container, savedInstanceState);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        this.c.setOnTouchListener(null);
        m3190a(true);
        super.onViewCreated(view, savedInstanceState);
    }

    public void m3211a(C0006h loader, ArrayList data) {
        m3190a(false);
        this.c.setEmptyView(getView().findViewById(16908292));
        this.f1830f = data;
        this.f1829e.m2468b(data);
        m3183B();
        this.f1829e.notifyDataSetChanged();
    }

    CharSequence m3219w() {
        return getString(R.string.music_type_select_application);
    }

    public Intent m3206a() {
        ArrayList item = this.f1829e.m2478c();
        if (item == null || item.size() <= 0) {
            return null;
        }
        Intent results = new Intent().putExtra("extra_selected_application", ((C0681a) item.get(0)).m3108c());
        results.putExtra("item_display_text", ((C0681a) item.get(0)).m3107b());
        return results;
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
    }

    CharSequence m3220x() {
        return null;
    }

    CharSequence m3221y() {
        return null;
    }

    String m3222z() {
        return null;
    }

    String m3205A() {
        return "";
    }

    void m3212a(View footerView) {
    }

    public boolean m3214j() {
        return false;
    }

    public void m3215k() {
    }

    public C0518a m3216n() {
        return this.f1829e;
    }

    public void m3218v() {
    }

    public void m3217p() {
    }

    public void m3209a(C0006h arg0) {
    }
}
