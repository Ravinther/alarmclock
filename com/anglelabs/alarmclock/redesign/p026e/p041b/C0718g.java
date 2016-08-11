package com.anglelabs.alarmclock.redesign.p026e.p041b;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.C0092n.C0091a;
import android.support.v4.p006a.C0006h;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p020a.p023a.C0535f;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0704c;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0691e;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0691e.C0690a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0818e;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.e.b.g */
public class C0718g extends C0710a implements C0091a {
    private CharSequence f1844e;
    private long f1845f;
    private String f1846g;
    private C0535f f1847h;
    private AlertDialog f1848i;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.b.g.1 */
    class C07171 implements OnClickListener {
        final /* synthetic */ C0718g f1843a;

        C07171(C0718g c0718g) {
            this.f1843a = c0718g;
        }

        public void onClick(View v) {
            this.f1843a.getFragmentManager().m262a().m183a((int) R.id.fragments_container, C0716f.m3289a(this.f1843a.f1845f, this.f1843a.f1846g, true)).m187a(null).m188b();
        }
    }

    public static C0718g m3313a(long playlistId, String playlistName, boolean isAddingToPlaylist) {
        C0718g f = new C0718g();
        Bundle args = new Bundle();
        args.putLong("playlist_id", playlistId);
        args.putString("playlist_name", playlistName);
        f.setArguments(args);
        return f;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().m395a(2, null, this);
    }

    public View m3317a(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments() != null) {
            this.f1845f = getArguments().getLong("playlist_id", -1);
            if (getArguments().containsKey("playlist_name")) {
                this.f1846g = getArguments().getString("playlist_name");
            }
        }
        m3186E();
        this.f1847h = new C0535f(getActivity(), 0, false);
        if (getActivity().getIntent() != null && getActivity().getIntent().hasExtra("selected_item_name")) {
            this.f1847h.m2473a(getActivity().getIntent().getStringExtra("selected_item_name"));
            getActivity().getIntent().removeExtra("selected_item_name");
        }
        C0794b.m3780a(getActivity(), "edit_playlist");
        C0830k.m3896a(getActivity(), C0818e.EDIT_PLAYLIST);
        return super.m3188a(inflater, container, savedInstanceState);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Base64.NO_PADDING /*1*/:
                C0704c.m3168a(this.f1845f, m3332z()).show(getChildFragmentManager(), "ignored");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onPause() {
        if (this.f1848i != null && this.f1848i.isShowing()) {
            this.f1848i.dismiss();
        }
        super.onPause();
    }

    public C0006h m3316a(int id, Bundle bundle) {
        return new C0691e(getActivity(), this.f1844e, this.f1845f, false);
    }

    public void m3320a(C0006h loader, ArrayList data) {
        this.c.setEmptyView(getView().findViewById(16908292));
        this.f1847h.m2497b((List) data);
        this.f1847h.notifyDataSetChanged();
    }

    public void m3318a(C0006h loader) {
    }

    public boolean m3322b(String text) {
        if (!(TextUtils.isEmpty(this.f1844e) && TextUtils.isEmpty(text))) {
            this.f1844e = text;
            getLoaderManager().m397b(2, null, this);
        }
        return true;
    }

    public String m3323h() {
        String undoText = "";
        SparseArray undoList = m3077i();
        if (undoList.size() == 1) {
            return getString(R.string.undo_single, ((C0690a) undoList.get(undoList.keyAt(0))).f1793b);
        } else if (undoList.size() <= 1) {
            return undoText;
        } else {
            return getString(R.string.undo_multiple, Integer.valueOf(undoList.size()), getString(R.string.undo_multiple_format_song));
        }
    }

    public void m3325k() {
        SparseArray undoList = m3077i();
        if (undoList.size() != 0) {
            int i;
            ArrayList songsToIgnore = new ArrayList();
            for (i = 0; i < undoList.size(); i++) {
                C0690a curObject = (C0690a) undoList.get(undoList.keyAt(i));
                if (!songsToIgnore.contains(curObject)) {
                    songsToIgnore.add(curObject);
                }
            }
            if (songsToIgnore.size() != 0) {
                long[] idsToDelete = new long[songsToIgnore.size()];
                for (i = 0; i < songsToIgnore.size(); i++) {
                    C0690a curItem = (C0690a) songsToIgnore.get(i);
                    if (curItem != null) {
                        idsToDelete[i] = (long) curItem.f1796e;
                    } else {
                        idsToDelete[i] = -1;
                    }
                }
                m3191a(idsToDelete);
                m3077i().clear();
            }
        }
    }

    CharSequence m3331y() {
        return getString(R.string.add_song_button);
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
        C0690a item = (C0690a) this.f1847h.getItem(position);
        this.f1847h.m2496a(m3196c(item.f1794c) ? item.f1792a : -1);
    }

    String m3332z() {
        return "deleted_ids_for_id_" + this.f1845f;
    }

    String m3315A() {
        return getString(R.string.no_songs_in_playlist);
    }

    CharSequence m3329w() {
        return getString(R.string.edit_playlist_title);
    }

    CharSequence m3330x() {
        return this.f1846g;
    }

    public C0518a m3326n() {
        return this.f1847h;
    }

    void m3321a(View footerView) {
        footerView.setOnClickListener(new C07171(this));
    }

    public void m3327p() {
        getActivity().m256e();
        getLoaderManager().m397b(2, null, this);
    }

    public void m3328v() {
        List<Integer> checkedItemsPositions = m3086r();
        List checkedItems = new ArrayList();
        for (Integer intValue : checkedItemsPositions) {
            int positions = intValue.intValue();
            C0690a songListDataItem = (C0690a) this.f1847h.getItem(positions);
            checkedItems.add(songListDataItem);
            m3077i().put(positions, songListDataItem);
        }
        this.f1847h.m2462c(checkedItems);
        this.f1847h.notifyDataSetChanged();
        m3087s();
    }

    public boolean m3324j() {
        return false;
    }
}
