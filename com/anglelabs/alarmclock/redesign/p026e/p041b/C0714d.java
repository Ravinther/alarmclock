package com.anglelabs.alarmclock.redesign.p026e.p041b;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Playlists;
import android.support.v4.app.C0092n.C0091a;
import android.support.v4.p006a.C0006h;
import android.support.v7.p013c.C0342a;
import android.support.v7.widget.SearchView.C0479c;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.RedesignSetSoundTypeActivity.C0590a;
import com.anglelabs.alarmclock.redesign.p020a.p023a.C0529d;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0698a;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0700b.C0699a;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0704c;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0687c;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0687c.C0686a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0818e;
import com.anglelabs.alarmclock.redesign.utils.C0858u;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.e.b.d */
public class C0714d extends C0710a implements C0091a, C0479c, C0590a, C0699a {
    private C0529d f1834e;
    private String f1835f;
    private C0698a f1836g;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.b.d.1 */
    class C07131 implements OnClickListener {
        final /* synthetic */ C0714d f1833a;

        C07131(C0714d c0714d) {
            this.f1833a = c0714d;
        }

        public void onClick(View v) {
            this.f1833a.f1836g = C0698a.m3162a(true, -1, "");
            this.f1833a.f1836g.show(this.f1833a.getChildFragmentManager(), "EditNameDialogFragment");
        }
    }

    /* synthetic */ CharSequence m3265w() {
        return m3247G();
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().m395a(0, null, this);
    }

    public void onDetach() {
        super.onDetach();
    }

    public C0006h m3249a(int id, Bundle bundle) {
        return new C0687c(getActivity(), this.f1835f);
    }

    public View m3250a(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f1834e = new C0529d(getActivity());
        Intent intent = getActivity().getIntent();
        if (intent != null && intent.hasExtra("selected_item_name")) {
            this.f1834e.m2473a(intent.getStringExtra("selected_item_name"));
            intent.removeExtra("selected_item_name");
        }
        C0794b.m3780a(getActivity(), "choose_playlist");
        C0830k.m3896a(getActivity(), C0818e.PLAYLIST);
        return super.m3188a(inflater, container, savedInstanceState);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        m3190a(true);
        super.onViewCreated(view, savedInstanceState);
    }

    public void m3254a(C0006h loader, ArrayList data) {
        m3190a(false);
        this.c.setEmptyView(getView().findViewById(16908292));
        this.f1834e.m2468b(data);
        m3183B();
        this.f1834e.notifyDataSetChanged();
    }

    public void m3252a(C0006h loader) {
    }

    public boolean m3258b(String newText) {
        if (TextUtils.isEmpty(newText)) {
            newText = null;
        }
        this.f1835f = newText;
        getLoaderManager().m397b(0, null, this);
        return true;
    }

    public C0518a m3262n() {
        return this.f1834e;
    }

    String m3247G() {
        return getString(R.string.music_type_select_playlist);
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
        C0686a item = (C0686a) this.f1834e.getItem(position);
        getFragmentManager().m262a().m183a((int) R.id.fragments_container, C0718g.m3313a(item.f1784a, item.f1785b, false)).m187a(null).m188b();
    }

    public void m3263p() {
        getActivity().m256e();
        getLoaderManager().m397b(0, null, this);
    }

    CharSequence m3267y() {
        return getString(R.string.add_playlist_button);
    }

    String m3268z() {
        return "deleted_playlists";
    }

    String m3246A() {
        return getString(R.string.no_playlists_found);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Base64.NO_PADDING /*1*/:
                C0704c.m3169a(m3268z()).show(getChildFragmentManager(), "ignored");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public String m3259h() {
        String undoText = "";
        SparseArray undoList = m3077i();
        if (undoList.size() == 1) {
            return getString(R.string.undo_single, ((C0686a) undoList.get(undoList.keyAt(0))).f1785b);
        } else if (undoList.size() <= 1) {
            return undoText;
        } else {
            return getString(R.string.undo_multiple, Integer.valueOf(undoList.size()), getString(R.string.undo_multiple_format_playlist));
        }
    }

    public void m3261k() {
        SparseArray undoList = m3077i();
        if (undoList.size() != 0) {
            int i;
            ArrayList playlistsToIgnore = new ArrayList();
            for (i = 0; i < undoList.size(); i++) {
                C0686a curObject = (C0686a) undoList.get(undoList.keyAt(i));
                if (!playlistsToIgnore.contains(curObject)) {
                    playlistsToIgnore.add(curObject);
                }
            }
            if (playlistsToIgnore.size() != 0) {
                long[] idsToDelete = new long[playlistsToIgnore.size()];
                for (i = 0; i < playlistsToIgnore.size(); i++) {
                    C0686a curItem = (C0686a) playlistsToIgnore.get(i);
                    if (curItem != null) {
                        idsToDelete[i] = curItem.f1784a;
                    } else {
                        idsToDelete[i] = -1;
                    }
                }
                m3191a(idsToDelete);
                m3077i().clear();
            }
        }
    }

    protected void m3255a(C0342a mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.multi_selection_edit:
                m3245a((C0686a) m3262n().getItem(((Integer) m3086r().get(0)).intValue()));
            default:
        }
    }

    private void m3245a(C0686a item) {
        this.f1836g = C0698a.m3162a(true, item.f1784a, item.f1785b);
        this.f1836g.show(getChildFragmentManager(), "EditNameDialogFragment");
    }

    public void m3251a(long itemId, String name) {
        if (this.f1836g != null) {
            if (this.f1836g.isAdded()) {
                this.f1836g.dismissAllowingStateLoss();
            }
            this.f1836g = null;
        }
        if (itemId > 0) {
            ContentValues values = new ContentValues();
            values.put("name", name);
            getActivity().getContentResolver().update(Playlists.EXTERNAL_CONTENT_URI, values, "_id =?", new String[]{String.valueOf(itemId)});
            m3263p();
            return;
        }
        boolean validName = true;
        for (C0686a playlist : this.f1834e.m2464h()) {
            if (playlist.f1785b.equals(name)) {
                validName = false;
                break;
            }
        }
        if (validName) {
            getFragmentManager().m262a().m183a((int) R.id.fragments_container, C0716f.m3289a(itemId, name, true)).m187a(null).m188b();
        } else {
            C0858u.m4026a(getActivity(), getString(R.string.edit_item_name_already_taken));
        }
    }

    public void m3264v() {
        List<Integer> checkedItemsPositions = m3086r();
        List checkedItems = new ArrayList();
        for (Integer intValue : checkedItemsPositions) {
            int positions = intValue.intValue();
            C0686a playListDataItem = (C0686a) this.f1834e.getItem(positions);
            checkedItems.add(playListDataItem);
            m3077i().put(positions, playListDataItem);
        }
        this.f1834e.m2462c(checkedItems);
        this.f1834e.notifyDataSetChanged();
        m3087s();
    }

    CharSequence m3266x() {
        return null;
    }

    void m3256a(View footerView) {
        footerView.setOnClickListener(new C07131(this));
    }

    public void m3257a(String tag) {
    }

    public boolean m3260j() {
        return true;
    }

    public Intent m3248a() {
        ArrayList playlistItem = this.f1834e.m2478c();
        if (playlistItem == null || playlistItem.size() <= 0) {
            return null;
        }
        C0686a item = (C0686a) playlistItem.get(0);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("playlist_key", String.valueOf(item.f1784a));
        resultIntent.putExtra("item_display_text", item.f1785b);
        return resultIntent;
    }
}
