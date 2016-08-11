package com.anglelabs.alarmclock.preference;

import android.content.Context;
import android.database.Cursor;
import android.preference.Preference;
import android.provider.MediaStore.Audio.Playlists;
import android.util.AttributeSet;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.avg.toolkit.ITKSvc;

public class PlaylistPreference extends Preference {
    private String f1342a;
    private String f1343b;

    public PlaylistPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1342a = "";
        this.f1343b = "";
    }

    public void m2419a(String playlistName, String playlistId) {
        this.f1342a = playlistId;
        this.f1343b = playlistName;
    }

    public void m2418a(Context context, String playlistId) {
        if (playlistId == null || playlistId.equals(ITKSvc.CODEREVISION) || playlistId.trim().length() <= 0) {
            setSummary("");
            return;
        }
        cursor = null;
        try {
            this.f1342a = playlistId;
            cursor = context.getContentResolver().query(Playlists.EXTERNAL_CONTENT_URI, new String[]{"name"}, "_id=?", new String[]{playlistId}, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    this.f1343b = cursor.getString(cursor.getColumnIndex("name"));
                }
                cursor.close();
            }
            if (this.f1343b != null) {
                setSummary(this.f1343b);
            } else {
                this.f1342a = null;
            }
        } catch (Exception e) {
            Cursor cursor;
            if (cursor != null) {
                cursor.close();
            }
            C0850q.m3987b("Failed to access media playlists");
            e.printStackTrace();
        }
    }

    public String m2417a() {
        return this.f1342a;
    }
}
