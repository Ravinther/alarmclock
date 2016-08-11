package com.anglelabs.alarmclock.preference;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.RingtonePreference;
import android.util.AttributeSet;
import com.alarmclock.xtreme.free.R;
import com.avg.toolkit.p049e.C0970a;

public class SelectRingtonePreference extends RingtonePreference {
    private Uri f1355a;

    public SelectRingtonePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (shouldPersist()) {
            try {
                m2429a(Uri.parse(getPersistedString("")));
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
    }

    protected void onSaveRingtone(Uri ringtoneUri) {
        m2429a(ringtoneUri);
    }

    protected void onClick() {
    }

    protected Uri onRestoreRingtone() {
        return this.f1355a;
    }

    public void m2430a(Uri alert, String ringtoneName) {
        this.f1355a = alert;
        setSummary(ringtoneName);
    }

    public void m2429a(Uri alert) {
        this.f1355a = alert;
        if (alert != null) {
            Ringtone r = RingtoneManager.getRingtone(getContext(), alert);
            if (r != null) {
                setSummary(r.getTitle(getContext()));
            }
        } else {
            setSummary(R.string.silent_alarm_summary);
        }
        if (shouldPersist()) {
            persistString(this.f1355a.toString());
        }
    }

    public String m2428a() {
        String name = getSummary().toString();
        int trimIndex = name.indexOf(getTitle().toString());
        if (trimIndex != -1) {
            return name.substring((trimIndex + getTitle().length()) + 1);
        }
        return name;
    }
}
