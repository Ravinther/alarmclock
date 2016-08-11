package com.anglelabs.alarmclock.redesign.alarm.p028a.p033e;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import com.anglelabs.alarmclock.redesign.alarm.C0633e;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.utils.C0812j;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.e.b */
public final class C0635b extends C0633e implements OnCompletionListener {
    private int f1713e;
    private final C0812j f1714f;

    public C0635b(Context context, RedesignAlarm alarm) {
        super(context, alarm);
        this.f1714f = new C0812j();
    }

    public Uri m2931a(Context context) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "artist_key=?", new String[]{m2917c().f2002c}, null);
            if (cursor == null || cursor.getCount() <= 0) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            this.f1713e = cursor.getCount();
            cursor.moveToPosition(this.f1714f.m3847a(cursor.getCount()));
            Uri withAppendedId = ContentUris.withAppendedId(Media.EXTERNAL_CONTENT_URI, (long) cursor.getInt(cursor.getColumnIndex("_id")));
            if (cursor == null) {
                return withAppendedId;
            }
            cursor.close();
            return withAppendedId;
        } catch (Exception e) {
            C0970a.m4322a(e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public void m2932a(Context context, RedesignAlarm mAlarm2) {
        if (this.f1714f == null) {
            C0850q.m3988c("playlist fallback called with randomNumber null, playing ringtone");
            super.m2912a(context, mAlarm2);
        } else if (this.f1714f.m3846a() == this.f1713e) {
            C0850q.m3986a("playlist fallback called - we tried to iterate through all of the playlist, fallback to ringtone");
            super.m2912a(context, mAlarm2);
        } else {
            C0850q.m3986a("playlist fallback called - playlist - trying next song as fallback");
            m2915b(context);
        }
    }

    public OnCompletionListener m2930a() {
        return this;
    }

    public void onCompletion(MediaPlayer mp) {
        m2915b(this.d);
    }
}
