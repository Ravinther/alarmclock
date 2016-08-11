package com.anglelabs.alarmclock.redesign.p039d.p040a;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Audio.Playlists.Members;
import android.text.TextUtils;
import com.anglelabs.alarmclock.redesign.p021b.C0660a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a.C0679b;
import com.anglelabs.alarmclock.redesign.p039d.C0692a.C0680c;
import com.anglelabs.alarmclock.redesign.p039d.C0695c;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.avg.toolkit.ITKSvc;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.anglelabs.alarmclock.redesign.d.a.e */
public class C0691e extends C0660a {
    private CharSequence f1797n;
    private long f1798o;
    private boolean f1799p;

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.e.a */
    public static class C0690a implements C0679b {
        public long f1792a;
        public String f1793b;
        public String f1794c;
        public int f1795d;
        public int f1796e;

        public C0690a(long id, String name, int length, int audioId, String streamData) {
            this.f1792a = id;
            this.f1793b = name;
            this.f1795d = length;
            this.f1796e = audioId;
            this.f1794c = streamData;
        }

        public int hashCode() {
            return this.f1793b.hashCode() ^ this.f1795d;
        }

        public boolean equals(Object o) {
            return hashCode() == o.hashCode();
        }

        public String m3125a() {
            return this.f1793b;
        }
    }

    public /* synthetic */ Object m3126d() {
        return m3127y();
    }

    public C0691e(Context context, CharSequence filter, long playListId, boolean showAllSongs) {
        super(context);
        this.f1797n = filter;
        this.f1798o = playListId;
        this.f1799p = showAllSongs;
    }

    public ArrayList m3127y() {
        Uri uri;
        String deletedIds;
        String[] selectionArgs;
        ArrayList results = new ArrayList();
        SharedPreferences prefs = ac.m3774b(m70f());
        String sort = "title ASC";
        if (this.f1798o <= 0 || this.f1799p) {
            uri = Media.EXTERNAL_CONTENT_URI;
            deletedIds = prefs.getString("deleted_ids_for_all_songs", "");
        } else {
            uri = Members.getContentUri("external", this.f1798o);
            deletedIds = prefs.getString("deleted_ids_for_id_" + this.f1798o, "");
        }
        boolean filterByName = !TextUtils.isEmpty(this.f1797n);
        StringBuilder selectionBuilder = new StringBuilder();
        selectionBuilder.append("duration > ? ");
        selectionBuilder.append(" AND ").append("is_music !=0");
        if (filterByName) {
            selectionBuilder.append(" AND ").append("title LIKE ?");
            selectionArgs = new String[]{ITKSvc.CODEREVISION, "%" + this.f1797n + "%"};
        } else {
            selectionArgs = new String[]{ITKSvc.CODEREVISION};
        }
        Cursor cursor = m70f().getContentResolver().query(uri, C0680c.f1767a, selectionBuilder.toString(), selectionArgs, sort);
        try {
            results.addAll(C0695c.m3161a(m70f(), cursor, deletedIds));
            Collections.sort(results, C0692a.f1800a);
            return results;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
