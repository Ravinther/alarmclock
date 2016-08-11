package com.anglelabs.alarmclock.redesign.alarm.p028a.p033e;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Audio.Playlists.Members;
import com.anglelabs.alarmclock.redesign.alarm.C0633e;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0692a.C0680c;
import com.anglelabs.alarmclock.redesign.p039d.C0695c;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0691e.C0690a;
import com.anglelabs.alarmclock.redesign.utils.C0812j;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import java.util.ArrayList;

/* renamed from: com.anglelabs.alarmclock.redesign.alarm.a.e.d */
public final class C0637d extends C0633e implements OnCompletionListener {
    private final C0812j f1715e;
    private int f1716f;

    public C0637d(Context context, RedesignAlarm alarm) {
        super(context, alarm);
        this.f1715e = new C0812j();
    }

    public Uri m2937a(Context context) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(Members.getContentUri("external", Long.parseLong(m2917c().f1988A)), C0680c.f1767a, null, null, null);
            if (cursor != null) {
                ArrayList songs = new ArrayList(C0695c.m3160a(context, cursor, Long.parseLong(m2917c().f1988A)));
                this.f1716f = songs.size();
                if (songs.size() > 0) {
                    int randomSong = this.f1715e.m3847a(songs.size());
                    C0690a playedSong = (C0690a) songs.get(randomSong);
                    Uri uri = ContentUris.withAppendedId(Media.EXTERNAL_CONTENT_URI, (long) playedSong.f1796e);
                    if (uri == null) {
                        C0850q.m3987b("song with name: " + playedSong.f1793b + " returned null Uri");
                        m2935a(randomSong);
                    }
                    if (cursor == null) {
                        return uri;
                    }
                    cursor.close();
                    return uri;
                }
                C0850q.m3987b("SoundPlaylist No songs found in the given playlist.");
            } else {
                C0850q.m3987b("SoundPlaylist cursor for given playlist was null.");
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            C0850q.m3985a(e, "error while trying play playlist song");
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    private void m2935a(int songLocation) {
        this.f1715e.m3848b(songLocation);
    }

    public void m2938a(Context context, RedesignAlarm mAlarm2) {
        C0850q.m3986a("playlist fallback called");
        if (this.f1715e == null) {
            C0850q.m3988c("playlist fallback called with randomNumber null, playing ringtone");
            super.m2912a(context, mAlarm2);
        } else if (this.f1715e.m3846a() == this.f1716f) {
            C0850q.m3986a("we tried to iterate through all of the playlist, fallback to ringtone");
            super.m2912a(context, mAlarm2);
        } else {
            C0850q.m3986a("playlist - trying next song as fallback");
            m2915b(context);
        }
    }

    public OnCompletionListener m2936a() {
        return this;
    }

    public void onCompletion(MediaPlayer mp) {
        m2915b(this.d);
    }
}
