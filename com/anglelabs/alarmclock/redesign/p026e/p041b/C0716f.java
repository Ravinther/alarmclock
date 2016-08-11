package com.anglelabs.alarmclock.redesign.p026e.p041b;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Playlists;
import android.provider.MediaStore.Audio.Playlists.Members;
import android.support.v4.app.C0092n.C0091a;
import android.support.v4.p006a.C0006h;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.RedesignSetSoundTypeActivity.C0590a;
import com.anglelabs.alarmclock.redesign.p020a.p023a.C0535f;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0704c;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0691e;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0691e.C0690a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0818e;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.e.b.f */
public class C0716f extends C0710a implements C0091a, C0590a {
    private C0535f f1838e;
    private String f1839f;
    private long f1840g;
    private boolean f1841h;
    private String f1842i;

    public C0716f() {
        this.f1840g = -1;
    }

    public static C0716f m3289a(long playlistId, String playlistName, boolean isAddingToPlaylist) {
        C0716f f = new C0716f();
        Bundle args = new Bundle();
        args.putLong("playlist_id", playlistId);
        args.putString("playlist_name", playlistName);
        args.putBoolean("is_adding_to_playlist", isAddingToPlaylist);
        f.setArguments(args);
        return f;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().m395a(2, null, this);
    }

    public boolean m3300b(String text) {
        if (!(TextUtils.isEmpty(this.f1839f) && TextUtils.isEmpty(text))) {
            this.f1839f = text;
            getLoaderManager().m397b(2, null, this);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Base64.NO_PADDING /*1*/:
                C0704c.m3171b(m3311z()).show(getChildFragmentManager(), "ignored");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean m3291G() {
        if (!this.f1841h) {
            return false;
        }
        if (this.f1840g >= 0) {
            m3288I();
        } else if (m3287H()) {
            m3288I();
        }
        getFragmentManager().m270c();
        return true;
    }

    public View m3294a(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.d = ac.m3774b(getActivity());
        Bundle args = getArguments();
        if (args != null) {
            this.f1840g = args.getLong("playlist_id", -1);
            this.f1841h = args.getBoolean("is_adding_to_playlist", false);
            this.f1842i = args.getString("playlist_name");
        }
        m3184C();
        this.f1838e = new C0535f(getActivity(), this.f1841h ? 2 : 1, false);
        if (getActivity().getIntent() != null && getActivity().getIntent().hasExtra("selected_item_name")) {
            this.f1838e.m2473a(getActivity().getIntent().getStringExtra("selected_item_name"));
            getActivity().getIntent().removeExtra("selected_item_name");
        }
        C0794b.m3780a(getActivity(), "choose_songs");
        C0830k.m3896a(getActivity(), C0818e.SONG);
        return super.m3188a(inflater, container, savedInstanceState);
    }

    public C0006h m3293a(int id, Bundle bundle) {
        return new C0691e(getActivity(), this.f1839f, this.f1840g, this.f1841h);
    }

    public void m3297a(C0006h loader, ArrayList data) {
        this.c.setEmptyView(getView().findViewById(16908292));
        this.f1838e.m2497b((List) data);
        m3183B();
        this.f1838e.notifyDataSetChanged();
        m3190a(false);
    }

    public void m3295a(C0006h loader) {
    }

    public String m3302h() {
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

    public void onViewCreated(View view, Bundle savedInstanceState) {
        m3190a(true);
        super.onViewCreated(view, savedInstanceState);
    }

    public void m3304k() {
        SparseArray undoList = m3077i();
        if (undoList.size() != 0) {
            int i;
            HashSet songsToIgnore = new HashSet();
            for (i = 0; i < undoList.size(); i++) {
                C0690a curObject = (C0690a) undoList.get(undoList.keyAt(i));
                if (!songsToIgnore.contains(curObject)) {
                    songsToIgnore.add(curObject);
                }
            }
            if (songsToIgnore.size() != 0) {
                long[] idsToDelete = new long[songsToIgnore.size()];
                i = 0;
                Iterator i$ = songsToIgnore.iterator();
                while (i$.hasNext()) {
                    C0690a curItem = (C0690a) i$.next();
                    if (curItem != null) {
                        idsToDelete[i] = (long) curItem.f1796e;
                    } else {
                        idsToDelete[i] = -1;
                    }
                    i++;
                }
                m3191a(idsToDelete);
                m3077i().clear();
            }
        }
    }

    public void m3299b(int position) {
        C0690a item = (C0690a) this.f1838e.getItem(position);
        if (item != null && item.f1792a == this.f1838e.m2499e()) {
            m3187F();
        }
        super.m3193b(position);
    }

    public C0518a m3305n() {
        return this.f1838e;
    }

    public void m3307v() {
        List<Integer> checkedItemsPositions = m3086r();
        List checkedItems = new ArrayList();
        for (Integer intValue : checkedItemsPositions) {
            int positions = intValue.intValue();
            C0690a songListDataItem = (C0690a) this.f1838e.getItem(positions);
            checkedItems.add(songListDataItem);
            m3077i().put(positions, songListDataItem);
        }
        this.f1838e.m2462c(checkedItems);
        this.f1838e.notifyDataSetChanged();
        m3087s();
    }

    public void m3301c(int position) {
    }

    public void m3306p() {
        getActivity().m256e();
        getLoaderManager().m397b(2, null, this);
    }

    CharSequence m3308w() {
        return getString(R.string.music_type_select_music);
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
        C0690a item = (C0690a) this.f1838e.getItem(position);
        this.f1838e.m2496a(m3196c(item.f1794c) ? item.f1792a : -1);
    }

    CharSequence m3309x() {
        return null;
    }

    CharSequence m3310y() {
        return null;
    }

    private boolean m3287H() {
        ArrayList checkedList = this.f1838e.m2478c();
        if (checkedList == null || checkedList.size() <= 0) {
            return false;
        }
        ContentValues values = new ContentValues();
        values.put("name", this.f1842i);
        this.f1840g = (long) Integer.parseInt(getActivity().getContentResolver().insert(Playlists.EXTERNAL_CONTENT_URI, values).getLastPathSegment());
        return true;
    }

    private void m3288I() {
        List<C0690a> itemToAddList = this.f1838e.m2478c();
        String[] cols = new String[]{"count(*)"};
        Uri uri = Members.getContentUri("external", this.f1840g);
        Cursor cur = getActivity().getContentResolver().query(uri, cols, null, null, null);
        cur.moveToFirst();
        int base = cur.getInt(0);
        cur.close();
        if (base > 0) {
            base++;
        }
        for (C0690a songToAdd : itemToAddList) {
            ContentValues values = new ContentValues();
            values.put("play_order", Integer.valueOf(base));
            values.put("audio_id", Integer.valueOf(songToAdd.f1796e));
            getActivity().getContentResolver().insert(uri, values);
            base++;
        }
    }

    String m3311z() {
        return "deleted_ids_for_all_songs";
    }

    String m3290A() {
        return getString(R.string.no_songs_found);
    }

    void m3298a(View footerView) {
    }

    public boolean m3303j() {
        return false;
    }

    public Intent m3292a() {
        ArrayList items = this.f1838e.m2478c();
        if (items == null || items.size() <= 0) {
            return null;
        }
        C0690a selectedSong = (C0690a) items.get(0);
        Intent resultIntent = new Intent().setData(Uri.parse(selectedSong.f1794c));
        resultIntent.putExtra("item_display_text", selectedSong.f1793b);
        return resultIntent;
    }
}
