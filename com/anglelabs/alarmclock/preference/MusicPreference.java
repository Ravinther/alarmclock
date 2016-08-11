package com.anglelabs.alarmclock.preference;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.preference.Preference;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0854s;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.plus.PlusShare;

public class MusicPreference extends Preference {
    private Uri f1341a;

    public MusicPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (shouldPersist()) {
            m2414a(Uri.parse(getPersistedString("")));
        }
    }

    public void m2415a(Uri music, String displayName) {
        this.f1341a = music;
        setSummary(displayName);
    }

    public void m2414a(Uri music) {
        this.f1341a = music;
        if (music != null) {
            try {
                String summary;
                if (C0854s.m4013b(this.f1341a) && C0810h.f2127a) {
                    summary = m2412c(this.f1341a);
                } else {
                    summary = m2411b(this.f1341a);
                }
                if (TextUtils.isEmpty(summary) && music.getPathSegments() != null && music.getPathSegments().size() > 0) {
                    summary = (String) music.getPathSegments().get(music.getPathSegments().size() - 1);
                }
                setSummary(summary);
            } catch (Exception e) {
                setSummary("");
            }
        }
        if (shouldPersist()) {
            persistString(this.f1341a.toString());
        }
    }

    private String m2411b(Uri uri) {
        String songName = "";
        Cursor cursor = getContext().getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE}, "_data =?", new String[]{uri.toString()}, null);
        if (cursor != null && cursor.moveToNext()) {
            songName = cursor.getString(0);
        }
        if (cursor != null) {
            cursor.close();
        }
        return songName;
    }

    @TargetApi(19)
    private String m2412c(Uri uri) {
        Cursor cursor = null;
        String songName = "";
        try {
            String[] column = new String[]{PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE};
            String id = DocumentsContract.getDocumentId(uri).split(":")[1];
            cursor = getContext().getContentResolver().query(Media.EXTERNAL_CONTENT_URI, column, "_id =?", new String[]{id}, null);
            if (cursor != null && cursor.moveToNext()) {
                songName = cursor.getString(0);
            }
            if (cursor != null) {
                cursor.close();
            }
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
        return songName;
    }

    public String m2413a() {
        if (this.f1341a != null) {
            return this.f1341a.toString();
        }
        return "silent";
    }

    public String m2416b() {
        String songName = getSummary().toString();
        if (TextUtils.isEmpty(songName) || !songName.contains(".")) {
            return songName;
        }
        return songName.substring(0, songName.indexOf("."));
    }
}
