package com.anglelabs.alarmclock.redesign.p026e.p027a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Audio.Playlists;
import android.provider.MediaStore.Audio.Playlists.Members;
import android.support.v4.app.C0069f;
import android.text.TextUtils;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p039d.C0695c;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.e.a.c */
public class C0704c extends C0069f {
    private SharedPreferences f1811a;
    private final HashMap f1812b;
    private ArrayList f1813c;
    private String f1814d;
    private String[] f1815e;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.a.c.1 */
    class C07011 implements OnClickListener {
        final /* synthetic */ C0704c f1809a;

        C07011(C0704c c0704c) {
            this.f1809a = c0704c;
        }

        public void onClick(DialogInterface dialog, int which) {
            List ids = new LinkedList(Arrays.asList(this.f1809a.f1815e));
            boolean changed = false;
            Iterator i$ = this.f1809a.f1813c.iterator();
            while (i$.hasNext()) {
                CharSequence selectedSongId = (CharSequence) i$.next();
                if (ids.contains(selectedSongId.toString())) {
                    ids.remove(selectedSongId.toString());
                    changed = true;
                }
            }
            if (changed) {
                this.f1809a.f1811a.edit().putString(this.f1809a.f1814d, TextUtils.join(",", ids)).apply();
                if (this.f1809a.getParentFragment() instanceof C0703a) {
                    ((C0703a) this.f1809a.getParentFragment()).b_();
                }
            }
            this.f1809a.dismiss();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.a.c.2 */
    class C07022 implements OnMultiChoiceClickListener {
        final /* synthetic */ C0704c f1810a;

        C07022(C0704c c0704c) {
            this.f1810a = c0704c;
        }

        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            if (isChecked) {
                this.f1810a.f1813c.add(this.f1810a.f1815e[which]);
            } else if (this.f1810a.f1813c.contains(this.f1810a.f1815e[which])) {
                this.f1810a.f1813c.remove(this.f1810a.f1815e[which]);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.a.c.a */
    public interface C0703a {
        void b_();
    }

    public C0704c() {
        this.f1812b = new HashMap();
    }

    public static C0704c m3169a(String ignoredSongsPrefsKey) {
        C0704c f = new C0704c();
        Bundle args = new Bundle();
        args.putString("extra_ignored_songs", ignoredSongsPrefsKey);
        args.putBoolean("is_restoring_playlist", true);
        f.setArguments(args);
        return f;
    }

    public static C0704c m3168a(long playlistId, String ignoredSongsPrefsKey) {
        C0704c f = new C0704c();
        Bundle args = new Bundle();
        args.putString("extra_ignored_songs", ignoredSongsPrefsKey);
        args.putLong("extra_playlist_id", playlistId);
        f.setArguments(args);
        return f;
    }

    public static C0704c m3171b(String ignoredSongsPrefsKey) {
        C0704c f = new C0704c();
        Bundle args = new Bundle();
        args.putString("extra_ignored_songs", ignoredSongsPrefsKey);
        f.setArguments(args);
        return f;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (getArguments() == null || !getArguments().containsKey("extra_ignored_songs")) {
            C0970a.m4325b("ignore dialog called without ignore items, aborting!");
            return super.onCreateDialog(savedInstanceState);
        }
        Uri uri;
        String[] columns;
        String selection;
        this.f1811a = ac.m3774b(getActivity());
        this.f1814d = getArguments().getString("extra_ignored_songs");
        this.f1815e = this.f1811a.getString(this.f1814d, "").split(",");
        boolean isRestoringPlaylists = getArguments().getBoolean("is_restoring_playlist", false);
        long playlistId = getArguments().getLong("extra_playlist_id", -1);
        boolean isEditingPlaylist = playlistId >= 0;
        if (isRestoringPlaylists) {
            uri = Playlists.EXTERNAL_CONTENT_URI;
            columns = new String[]{"name", "_id"};
            selection = C0695c.m3158a("_id", this.f1815e);
        } else if (isEditingPlaylist) {
            columns = new String[]{PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "audio_id"};
            uri = Members.getContentUri("external", playlistId);
            selection = C0695c.m3158a("audio_id", this.f1815e);
        } else {
            columns = new String[]{PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, "_id"};
            uri = Media.EXTERNAL_CONTENT_URI;
            selection = C0695c.m3158a("_id", this.f1815e);
        }
        Cursor cursor = getActivity().getContentResolver().query(uri, columns, selection, this.f1815e, null);
        if (cursor == null) {
            C0850q.m3987b("cursor returned null, aborting!");
            return super.onCreateDialog(savedInstanceState);
        }
        while (cursor.moveToNext()) {
            try {
                this.f1812b.put(cursor.getString(0), cursor.getString(1));
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        int oldArraySize = this.f1815e.length;
        this.f1815e = (String[]) this.f1812b.values().toArray(new String[this.f1812b.values().size()]);
        if (oldArraySize > this.f1815e.length) {
            this.f1811a.edit().putString(this.f1814d, TextUtils.join(",", this.f1815e)).apply();
        }
        this.f1813c = new ArrayList();
        Builder alertBuilder = new Builder(getActivity());
        alertBuilder.setTitle(R.string.media_ignored_items_title).setMultiChoiceItems((CharSequence[]) this.f1812b.keySet().toArray(new String[this.f1812b.keySet().size()]), new boolean[this.f1815e.length], new C07022(this)).setPositiveButton(getString(R.string.ignored_songs_dialog_positive_button), new C07011(this));
        return alertBuilder.create();
    }
}
