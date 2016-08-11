package com.anglelabs.alarmclock.redesign.p039d.p040a;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Audio.Artists;
import android.text.TextUtils;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p021b.C0660a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a.C0678a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a.C0679b;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.anglelabs.alarmclock.redesign.d.a.b */
public class C0685b extends C0660a {
    private final String f1783n;

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.b.a */
    public static final class C0684a implements C0679b {
        public String f1779a;
        public String f1780b;
        public long f1781c;
        public int f1782d;

        public C0684a(Cursor cursor) {
            try {
                this.f1781c = cursor.getLong(0);
                this.f1779a = cursor.getString(1);
                this.f1780b = cursor.getString(2);
                this.f1782d = cursor.getInt(3);
            } catch (Exception e) {
                C0850q.m3984a(e);
            }
        }

        public String m3115a(Context context) {
            if (this.f1782d == 1) {
                return context.getString(R.string.song);
            }
            return context.getString(R.string.songs, new Object[]{Integer.valueOf(this.f1782d)});
        }

        public String m3114a() {
            return this.f1779a;
        }
    }

    public /* synthetic */ Object m3116d() {
        return m3117y();
    }

    public C0685b(Context context, String filter) {
        super(context);
        this.f1783n = filter;
    }

    public ArrayList m3117y() {
        ArrayList results = new ArrayList();
        StringBuilder selectionBuilder = new StringBuilder();
        String[] selectionArgs = null;
        selectionBuilder.append("number_of_tracks> 0");
        if (!TextUtils.isEmpty(this.f1783n)) {
            selectionBuilder.append(" AND ").append("artist LIKE ?");
            selectionArgs = new String[]{"% + " + this.f1783n + "%"};
        }
        Cursor cursor = m70f().getContentResolver().query(Artists.EXTERNAL_CONTENT_URI, C0678a.f1766a, selectionBuilder.toString(), selectionArgs, null);
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        results.add(new C0684a(cursor));
                    } while (cursor.moveToNext());
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        Collections.sort(results, C0692a.f1800a);
        return results;
    }
}
