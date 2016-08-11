package com.anglelabs.alarmclock.redesign.p039d.p040a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Audio.Playlists;
import android.provider.MediaStore.Audio.Playlists.Members;
import android.text.TextUtils;
import com.anglelabs.alarmclock.redesign.p021b.C0660a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a.C0679b;
import com.anglelabs.alarmclock.redesign.p039d.C0692a.C0680c;
import com.anglelabs.alarmclock.redesign.p039d.C0695c;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.utils.ac;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.anglelabs.alarmclock.redesign.d.a.c */
public class C0687c extends C0660a {
    private final String f1787n;

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.c.a */
    public static class C0686a implements C0679b {
        public final long f1784a;
        public final String f1785b;
        public final int f1786c;

        public C0686a(long id, String name, int count) {
            this.f1784a = id;
            this.f1785b = name;
            this.f1786c = count;
        }

        public String m3118a() {
            return this.f1785b;
        }
    }

    public /* synthetic */ Object m3119d() {
        return m3120y();
    }

    public C0687c(Context context, String curFilter) {
        super(context);
        this.f1787n = curFilter;
    }

    public ArrayList m3120y() {
        ArrayList result = new ArrayList();
        ContentResolver resolver = m70f().getContentResolver();
        String[] columns = new String[]{"_id", "name"};
        StringBuilder selectionBuilder = new StringBuilder();
        String[] selectionArguments = null;
        String deletedIds = ac.m3774b(m70f()).getString("deleted_playlists", "");
        boolean filterText = !TextUtils.isEmpty(this.f1787n);
        boolean ignoreDeletedItems = !TextUtils.isEmpty(deletedIds);
        if (filterText) {
            selectionBuilder.append("name LIKE ?");
            selectionArguments = new String[]{this.f1787n};
        }
        Cursor playlistCursor = resolver.query(Playlists.EXTERNAL_CONTENT_URI, columns, selectionBuilder.toString(), selectionArguments, "name ASC");
        if (playlistCursor != null) {
            try {
                if (playlistCursor.moveToFirst()) {
                    int indexID = playlistCursor.getColumnIndex("_id");
                    int indexName = playlistCursor.getColumnIndex("name");
                    do {
                        long id = playlistCursor.getLong(indexID);
                        boolean ignoreItem = false;
                        if (ignoreDeletedItems) {
                            for (String deletedId : deletedIds.split(",")) {
                                if (String.valueOf(id).equals(deletedId)) {
                                    ignoreItem = true;
                                    break;
                                }
                            }
                        }
                        if (!ignoreItem) {
                            String name = playlistCursor.getString(indexName);
                            Cursor playlistSongsCounter = resolver.query(Members.getContentUri("external", id), C0680c.f1767a, null, null, null);
                            int numberSongs = C0695c.m3160a(m70f(), playlistSongsCounter, id).size();
                            if (playlistSongsCounter != null) {
                                playlistSongsCounter.close();
                            }
                            if (numberSongs > 0) {
                                result.add(new C0686a(id, name, numberSongs));
                            }
                        }
                    } while (playlistCursor.moveToNext());
                }
            } catch (Exception e) {
                C0850q.m3984a(e);
                if (playlistCursor != null) {
                    playlistCursor.close();
                }
            } catch (Throwable th) {
                if (playlistCursor != null) {
                    playlistCursor.close();
                }
            }
        }
        if (playlistCursor != null) {
            playlistCursor.close();
        }
        Collections.sort(result, C0692a.f1800a);
        return result;
    }
}
