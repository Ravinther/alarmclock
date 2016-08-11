package com.anglelabs.alarmclock.preference;

import android.content.Context;
import android.database.Cursor;
import android.preference.Preference;
import android.provider.MediaStore.Audio.Artists;
import android.util.AttributeSet;
import com.anglelabs.alarmclock.redesign.utils.C0850q;

public class ArtistPreference extends Preference {
    private String f1334a;
    private String f1335b;

    public ArtistPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1334a = "";
        this.f1335b = "";
    }

    public void m2398a(String artistKey, String artistName) {
        this.f1335b = artistName;
        this.f1334a = artistKey;
        setSummary(this.f1335b);
    }

    public void m2397a(Context context, String artistKey) {
        if (artistKey != null) {
            Cursor cursor = null;
            try {
                this.f1334a = artistKey;
                cursor = context.getContentResolver().query(Artists.EXTERNAL_CONTENT_URI, new String[]{"artist"}, "artist_key=?", new String[]{artistKey}, null);
                if (cursor != null) {
                    if (cursor.moveToFirst()) {
                        this.f1335b = cursor.getString(0);
                    }
                    cursor.close();
                }
                if (this.f1335b != null) {
                    setSummary(this.f1335b);
                    return;
                }
                return;
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
                C0850q.m3987b("Failed to access media artists");
                return;
            }
        }
        setSummary("");
    }

    public String m2396a() {
        return this.f1334a;
    }
}
