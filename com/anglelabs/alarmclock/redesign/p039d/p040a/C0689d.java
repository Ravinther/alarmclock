package com.anglelabs.alarmclock.redesign.p039d.p040a;

import android.content.Context;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import com.anglelabs.alarmclock.redesign.p021b.C0660a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a;
import com.anglelabs.alarmclock.redesign.p039d.C0692a.C0679b;
import com.anglelabs.alarmclock.redesign.utils.C0854s;
import com.avg.toolkit.p049e.C0970a;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.anglelabs.alarmclock.redesign.d.a.d */
public class C0689d extends C0660a {

    /* renamed from: com.anglelabs.alarmclock.redesign.d.a.d.a */
    public static final class C0688a implements C0679b {
        public final String f1788a;
        public final long f1789b;
        public final String f1790c;
        public final Uri f1791d;

        public C0688a(long id, String title, String content) {
            this.f1789b = id;
            this.f1788a = title;
            this.f1790c = content;
            this.f1791d = Uri.withAppendedPath(Uri.parse(content), "" + id);
        }

        public String m3121a() {
            return this.f1788a;
        }
    }

    public /* synthetic */ Object m3123d() {
        return m3124y();
    }

    public C0689d(Context context) {
        super(context);
    }

    public ArrayList m3124y() {
        ArrayList resultList = new ArrayList();
        RingtoneManager ringtoneManager = new RingtoneManager(m70f());
        ringtoneManager.setType(1);
        m3122a(ringtoneManager, resultList);
        ringtoneManager = new RingtoneManager(m70f());
        ringtoneManager.setType(4);
        m3122a(ringtoneManager, resultList);
        Collections.sort(resultList, C0692a.f1800a);
        return resultList;
    }

    private ArrayList m3122a(RingtoneManager ringtoneManager, ArrayList resultList) {
        Cursor cursor = ringtoneManager.getCursor();
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    do {
                        String songUri = cursor.getString(2);
                        if (C0854s.m4007a(m70f(), Uri.parse(songUri))) {
                            resultList.add(new C0688a(cursor.getLong(0), cursor.getString(1), songUri));
                        } else {
                            C0970a.m4325b(songUri + " was not considers as an audio type");
                        }
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
        return resultList;
    }
}
