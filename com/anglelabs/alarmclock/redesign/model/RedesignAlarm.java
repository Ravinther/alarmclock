package com.anglelabs.alarmclock.redesign.model;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.C0646d;
import com.anglelabs.alarmclock.redesign.model.C0775b.C0774a;
import com.anglelabs.alarmclock.redesign.utils.C0796d;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.avg.toolkit.p049e.C0970a;
import java.util.Calendar;

public class RedesignAlarm implements Parcelable, Cloneable {
    public static final Creator CREATOR;
    public String f1988A;
    public int f1989B;
    public boolean f1990C;
    public int f1991D;
    public int f1992E;
    public int f1993F;
    public long f1994G;
    public Uri f1995H;
    public Uri f1996I;
    public int f1997J;
    public int f1998K;
    public boolean f1999L;
    public int f2000a;
    public String f2001b;
    public String f2002c;
    public int f2003d;
    public int f2004e;
    public C0773a f2005f;
    public int f2006g;
    public int f2007h;
    public int f2008i;
    public int f2009j;
    public int f2010k;
    public int f2011l;
    public boolean f2012m;
    public boolean f2013n;
    public boolean f2014o;
    public boolean f2015p;
    public boolean f2016q;
    public boolean f2017r;
    public boolean f2018s;
    public boolean f2019t;
    public String f2020u;
    public int f2021v;
    public int f2022w;
    public int f2023x;
    public int f2024y;
    public int f2025z;

    /* renamed from: com.anglelabs.alarmclock.redesign.model.RedesignAlarm.1 */
    static class C07701 implements Creator {
        C07701() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m3605a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m3606a(x0);
        }

        public RedesignAlarm m3605a(Parcel p) {
            return new RedesignAlarm(p);
        }

        public RedesignAlarm[] m3606a(int size) {
            return new RedesignAlarm[size];
        }
    }

    public RedesignAlarm(int alarmType) {
        this.f2001b = "";
        this.f2002c = "";
        this.f2003d = 0;
        this.f2004e = 0;
        this.f2006g = 0;
        this.f2007h = 1;
        this.f2008i = 25;
        this.f2011l = 3;
        this.f2012m = false;
        this.f2013n = false;
        this.f2014o = false;
        this.f2015p = true;
        this.f2016q = true;
        this.f2017r = false;
        this.f2018s = true;
        this.f2019t = false;
        this.f2020u = "";
        this.f2021v = 0;
        this.f2022w = 0;
        this.f2024y = 1;
        this.f2025z = 1;
        this.f1988A = "";
        this.f1989B = 1;
        this.f1991D = 10;
        this.f1992E = 1;
        this.f1993F = 1;
        this.f1995H = RingtoneManager.getDefaultUri(4);
        this.f1996I = RingtoneManager.getDefaultUri(4);
        this.f1997J = 100;
        this.f1998K = 60000;
        this.f1999L = true;
        this.f2000a = alarmType;
        this.f2005f = new C0773a(0);
    }

    public boolean m3614a(RedesignAlarm alarm) {
        Calendar now = Calendar.getInstance();
        int alarmHour = alarm.f2009j;
        int currHour = now.get(11);
        return alarmHour < currHour || (alarmHour == currHour && alarm.f2023x < now.get(12));
    }

    public boolean m3613a(Context context) {
        return C0646d.m2989h(context, this.f2010k);
    }

    public boolean m3616b(Context context) {
        return C0646d.m2987f(context, this.f2010k);
    }

    public void m3612a(int hour, int minute, C0773a days) {
        this.f2009j = hour;
        this.f2023x = minute;
        this.f2005f = days;
    }

    public static Intent m3608a(Context context, Class cls, long instanceId) {
        return new Intent(context, cls).setData(m3609a(instanceId));
    }

    public static long m3607a(Uri contentUri) {
        return ContentUris.parseId(contentUri);
    }

    public static Uri m3609a(long instanceId) {
        return ContentUris.withAppendedId(C0774a.f2036a, instanceId);
    }

    public Calendar m3617c(Context context) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());
        int nowHour = c.get(11);
        int nowMinute = c.get(12);
        if (this.f2009j < nowHour || (this.f2009j == nowHour && this.f2023x <= nowMinute)) {
            c.add(6, 1);
        }
        c.set(11, this.f2009j);
        c.set(12, this.f2023x);
        c.set(13, 0);
        c.set(14, 0);
        int addDays = this.f2005f.m3654a(c);
        if (addDays > 0) {
            c.add(7, addDays);
        }
        return c;
    }

    public void m3618d(Context context) {
        this.f1994G = m3617c(context).getTimeInMillis();
    }

    public RedesignAlarm(Cursor c) {
        boolean z;
        boolean z2 = true;
        this.f2001b = "";
        this.f2002c = "";
        this.f2003d = 0;
        this.f2004e = 0;
        this.f2006g = 0;
        this.f2007h = 1;
        this.f2008i = 25;
        this.f2011l = 3;
        this.f2012m = false;
        this.f2013n = false;
        this.f2014o = false;
        this.f2015p = true;
        this.f2016q = true;
        this.f2017r = false;
        this.f2018s = true;
        this.f2019t = false;
        this.f2020u = "";
        this.f2021v = 0;
        this.f2022w = 0;
        this.f2024y = 1;
        this.f2025z = 1;
        this.f1988A = "";
        this.f1989B = 1;
        this.f1991D = 10;
        this.f1992E = 1;
        this.f1993F = 1;
        this.f1995H = RingtoneManager.getDefaultUri(4);
        this.f1996I = RingtoneManager.getDefaultUri(4);
        this.f1997J = 100;
        this.f1998K = 60000;
        this.f1999L = true;
        this.f2000a = c.getInt(22);
        this.f2001b = c.getString(33);
        this.f2002c = c.getString(26);
        this.f2003d = c.getInt(15);
        this.f2004e = c.getInt(31);
        this.f2005f = new C0773a(c.getInt(3));
        this.f2006g = c.getInt(35);
        this.f2007h = c.getInt(10);
        this.f2008i = c.getInt(11);
        this.f2009j = c.getInt(1);
        this.f2010k = c.getInt(0);
        this.f2011l = c.getInt(21);
        if (c.getInt(5) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2012m = z;
        if (c.getInt(29) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2013n = z;
        if (c.getInt(17) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2014o = z;
        if (c.getInt(20) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2016q = z;
        if (c.getInt(6) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2017r = z;
        if (c.getInt(18) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2018s = z;
        this.f2020u = c.getString(7);
        this.f2021v = c.getInt(25);
        this.f2022w = c.getInt(23);
        this.f2023x = c.getInt(2);
        this.f2024y = c.getInt(27);
        this.f2025z = c.getInt(28);
        this.f1988A = c.getString(32);
        this.f1989B = c.getInt(9);
        if (c.getInt(34) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f1990C = z;
        this.f1991D = c.getInt(16);
        this.f1992E = c.getInt(8);
        this.f1993F = c.getInt(12);
        this.f1994G = c.getLong(4);
        this.f1997J = c.getInt(19);
        this.f1998K = c.getInt(30);
        if (c.getInt(36) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2015p = z;
        if (c.getInt(37) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2019t = z;
        if (c.getInt(c.getColumnIndex("allow_passing_questions")) != 1) {
            z2 = false;
        }
        this.f1999L = z2;
        String musicString = c.getString(13);
        if (!(musicString == null || musicString.length() == 0)) {
            this.f1996I = Uri.parse(musicString);
        }
        if (this.f1996I == null) {
            this.f1996I = RingtoneManager.getDefaultUri(4);
        }
        String alertString = c.getString(14);
        if (!(alertString == null || alertString.length() == 0)) {
            this.f1995H = Uri.parse(alertString);
        }
        if (this.f1995H == null) {
            this.f1995H = RingtoneManager.getDefaultUri(4);
        }
    }

    private RedesignAlarm() {
        this.f2001b = "";
        this.f2002c = "";
        this.f2003d = 0;
        this.f2004e = 0;
        this.f2006g = 0;
        this.f2007h = 1;
        this.f2008i = 25;
        this.f2011l = 3;
        this.f2012m = false;
        this.f2013n = false;
        this.f2014o = false;
        this.f2015p = true;
        this.f2016q = true;
        this.f2017r = false;
        this.f2018s = true;
        this.f2019t = false;
        this.f2020u = "";
        this.f2021v = 0;
        this.f2022w = 0;
        this.f2024y = 1;
        this.f2025z = 1;
        this.f1988A = "";
        this.f1989B = 1;
        this.f1991D = 10;
        this.f1992E = 1;
        this.f1993F = 1;
        this.f1995H = RingtoneManager.getDefaultUri(4);
        this.f1996I = RingtoneManager.getDefaultUri(4);
        this.f1997J = 100;
        this.f1998K = 60000;
        this.f1999L = true;
    }

    public static RedesignAlarm m3610b(RedesignAlarm originalAlarm) {
        RedesignAlarm alarm = new RedesignAlarm();
        alarm.f2000a = originalAlarm.f2000a;
        alarm.f2001b = originalAlarm.f2001b;
        alarm.f2002c = originalAlarm.f2002c;
        alarm.f2003d = originalAlarm.f2003d;
        alarm.f2004e = originalAlarm.f2004e;
        alarm.f2005f = originalAlarm.f2005f;
        alarm.f2006g = originalAlarm.f2006g;
        alarm.f2007h = originalAlarm.f2007h;
        alarm.f2008i = originalAlarm.f2008i;
        alarm.f2009j = originalAlarm.f2009j;
        alarm.f2010k = originalAlarm.f2010k;
        alarm.f2011l = originalAlarm.f2011l;
        alarm.f2012m = originalAlarm.f2012m;
        alarm.f2013n = originalAlarm.f2013n;
        alarm.f2014o = originalAlarm.f2014o;
        alarm.f2016q = originalAlarm.f2016q;
        alarm.f2017r = originalAlarm.f2017r;
        alarm.f2018s = originalAlarm.f2018s;
        alarm.f2020u = originalAlarm.f2020u;
        alarm.f2021v = originalAlarm.f2021v;
        alarm.f2022w = originalAlarm.f2022w;
        alarm.f2023x = originalAlarm.f2023x;
        alarm.f2024y = originalAlarm.f2024y;
        alarm.f2025z = originalAlarm.f2025z;
        alarm.f1988A = originalAlarm.f1988A;
        alarm.f1989B = originalAlarm.f1989B;
        alarm.f1990C = originalAlarm.f1990C;
        alarm.f1991D = originalAlarm.f1991D;
        alarm.f1992E = originalAlarm.f1992E;
        alarm.f1993F = originalAlarm.f1993F;
        alarm.f1994G = originalAlarm.f1994G;
        alarm.f1997J = originalAlarm.f1997J;
        alarm.f1998K = originalAlarm.f1998K;
        alarm.f2015p = originalAlarm.f2015p;
        alarm.f2019t = originalAlarm.f2019t;
        alarm.f1996I = originalAlarm.f1996I;
        alarm.f1995H = originalAlarm.f1995H;
        alarm.f1999L = originalAlarm.f1999L;
        return alarm;
    }

    public RedesignAlarm(Parcel p) {
        boolean z;
        boolean z2 = true;
        this.f2001b = "";
        this.f2002c = "";
        this.f2003d = 0;
        this.f2004e = 0;
        this.f2006g = 0;
        this.f2007h = 1;
        this.f2008i = 25;
        this.f2011l = 3;
        this.f2012m = false;
        this.f2013n = false;
        this.f2014o = false;
        this.f2015p = true;
        this.f2016q = true;
        this.f2017r = false;
        this.f2018s = true;
        this.f2019t = false;
        this.f2020u = "";
        this.f2021v = 0;
        this.f2022w = 0;
        this.f2024y = 1;
        this.f2025z = 1;
        this.f1988A = "";
        this.f1989B = 1;
        this.f1991D = 10;
        this.f1992E = 1;
        this.f1993F = 1;
        this.f1995H = RingtoneManager.getDefaultUri(4);
        this.f1996I = RingtoneManager.getDefaultUri(4);
        this.f1997J = 100;
        this.f1998K = 60000;
        this.f1999L = true;
        this.f2000a = p.readInt();
        this.f2001b = p.readString();
        this.f2002c = p.readString();
        this.f2003d = p.readInt();
        this.f2004e = p.readInt();
        this.f2005f = new C0773a(p.readInt());
        this.f2006g = p.readInt();
        this.f2007h = p.readInt();
        this.f2008i = p.readInt();
        this.f2009j = p.readInt();
        this.f2010k = p.readInt();
        this.f2011l = p.readInt();
        this.f2012m = p.readInt() == 1;
        if (p.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2013n = z;
        if (p.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2014o = z;
        if (p.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2016q = z;
        if (p.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2017r = z;
        if (p.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2018s = z;
        this.f2020u = p.readString();
        this.f2021v = p.readInt();
        this.f2022w = p.readInt();
        this.f2023x = p.readInt();
        this.f2024y = p.readInt();
        this.f2025z = p.readInt();
        this.f1988A = p.readString();
        this.f1989B = p.readInt();
        if (p.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f1990C = z;
        this.f1991D = p.readInt();
        this.f1992E = p.readInt();
        this.f1993F = p.readInt();
        this.f1994G = p.readLong();
        this.f1995H = (Uri) p.readParcelable(null);
        this.f1996I = (Uri) p.readParcelable(null);
        this.f1997J = p.readInt();
        this.f1998K = p.readInt();
        if (p.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2015p = z;
        if (p.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.f2019t = z;
        if (p.readInt() != 1) {
            z2 = false;
        }
        this.f1999L = z2;
    }

    public ContentValues m3611a() {
        int i;
        int i2 = 1;
        ContentValues values = new ContentValues();
        values.put("enabled", Integer.valueOf(this.f2012m ? 1 : 0));
        values.put("hour", Integer.valueOf(this.f2009j));
        values.put("minutes", Integer.valueOf(this.f2023x));
        values.put("alarmtime", Long.valueOf(this.f1994G));
        String str = "vibrate";
        if (this.f2017r) {
            i = 1;
        } else {
            i = 0;
        }
        values.put(str, Integer.valueOf(i));
        values.put("message", this.f2020u);
        values.put("snooze", Integer.valueOf(this.f1992E));
        values.put("shakeduration", Integer.valueOf(this.f1989B));
        values.put("dismiss", Integer.valueOf(this.f2007h));
        values.put("dismissspeed", Integer.valueOf(this.f2008i));
        values.put("playlistid", Integer.valueOf(this.f2021v));
        values.put("soundtype", Integer.valueOf(this.f1993F));
        values.put("music", this.f1996I.toString());
        values.put("alert", this.f1995H.toString());
        values.put("snoozeduration", Integer.valueOf(this.f1991D));
        values.put("autosnoozeduration", Integer.valueOf(this.f2004e));
        values.put("timeoutduration", Integer.valueOf(this.f2003d));
        values.put("silentmode", Integer.valueOf(this.f2016q ? 1 : 0));
        values.put("volume", Integer.valueOf(this.f1997J));
        str = "crescendo";
        if (this.f2018s) {
            i = 1;
        } else {
            i = 0;
        }
        values.put(str, Integer.valueOf(i));
        values.put("volumerampfreq", Integer.valueOf(this.f1998K));
        values.put("incall", Integer.valueOf(this.f2011l));
        str = "increaseshake";
        if (this.f2014o) {
            i = 1;
        } else {
            i = 0;
        }
        values.put(str, Integer.valueOf(i));
        values.put("timer", Integer.valueOf(this.f2000a));
        str = "daysofweek";
        if (this.f2005f != null) {
            i = this.f2005f.m3653a();
        } else {
            i = 0;
        }
        values.put(str, Integer.valueOf(i));
        values.put("maxsnoozes", Integer.valueOf(this.f2022w));
        values.put("dismisscode", this.f2002c);
        values.put("playlist", this.f1988A);
        values.put("restartmath", Boolean.valueOf(this.f1990C));
        values.put("application", this.f2001b);
        values.put("numbermathsnooze", Integer.valueOf(this.f2025z));
        values.put("numbermathdismiss", Integer.valueOf(this.f2024y));
        values.put("increasemath", Boolean.valueOf(this.f2013n));
        values.put("vibratedelay", Integer.valueOf(this.f2006g));
        str = "use_large_snooze";
        if (this.f2015p) {
            i = 1;
        } else {
            i = 0;
        }
        values.put(str, Integer.valueOf(i));
        str = "keep_screen_on";
        if (this.f2019t) {
            i = 1;
        } else {
            i = 0;
        }
        values.put(str, Integer.valueOf(i));
        String str2 = "allow_passing_questions";
        if (!this.f1999L) {
            i2 = 0;
        }
        values.put(str2, Integer.valueOf(i2));
        return values;
    }

    static {
        CREATOR = new C07701();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel p, int flags) {
        int i;
        int i2 = 1;
        p.writeInt(this.f2000a);
        p.writeString(this.f2001b);
        p.writeString(this.f2002c);
        p.writeInt(this.f2003d);
        p.writeInt(this.f2004e);
        p.writeInt(this.f2005f != null ? this.f2005f.m3653a() : 0);
        p.writeInt(this.f2006g);
        p.writeInt(this.f2007h);
        p.writeInt(this.f2008i);
        p.writeInt(this.f2009j);
        p.writeInt(this.f2010k);
        p.writeInt(this.f2011l);
        if (this.f2012m) {
            i = 1;
        } else {
            i = 0;
        }
        p.writeInt(i);
        if (this.f2013n) {
            i = 1;
        } else {
            i = 0;
        }
        p.writeInt(i);
        if (this.f2014o) {
            i = 1;
        } else {
            i = 0;
        }
        p.writeInt(i);
        if (this.f2016q) {
            i = 1;
        } else {
            i = 0;
        }
        p.writeInt(i);
        if (this.f2017r) {
            i = 1;
        } else {
            i = 0;
        }
        p.writeInt(i);
        if (this.f2018s) {
            i = 1;
        } else {
            i = 0;
        }
        p.writeInt(i);
        p.writeString(this.f2020u);
        p.writeInt(this.f2021v);
        p.writeInt(this.f2022w);
        p.writeInt(this.f2023x);
        p.writeInt(this.f2024y);
        p.writeInt(this.f2025z);
        p.writeString(this.f1988A);
        p.writeInt(this.f1989B);
        if (this.f1990C) {
            i = 1;
        } else {
            i = 0;
        }
        p.writeInt(i);
        p.writeInt(this.f1991D);
        p.writeInt(this.f1992E);
        p.writeInt(this.f1993F);
        p.writeLong(this.f1994G);
        p.writeParcelable(this.f1995H, flags);
        p.writeParcelable(this.f1996I, flags);
        p.writeInt(this.f1997J);
        p.writeInt(this.f1998K);
        if (this.f2015p) {
            i = 1;
        } else {
            i = 0;
        }
        p.writeInt(i);
        if (this.f2019t) {
            i = 1;
        } else {
            i = 0;
        }
        p.writeInt(i);
        if (!this.f1999L) {
            i2 = 0;
        }
        p.writeInt(i2);
    }

    public boolean equals(Object o) {
        if (o != null && (o instanceof RedesignAlarm)) {
            if (this.f2010k == ((RedesignAlarm) o).f2010k) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Long.valueOf((long) this.f2010k).hashCode();
    }

    public String toString() {
        return C0796d.m3791a(this);
    }

    public void m3615b() {
        try {
            Uri ringtoneUri = RingtoneManager.getDefaultUri(4);
            if (ringtoneUri != null) {
                this.f1995H = ringtoneUri;
            }
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
    }

    public long m3619e(Context context) {
        if (context != null) {
            return C0646d.m2975a(context, this.f2010k) > 0 ? C0646d.m2988g(context, this.f2010k) : m3617c(context).getTimeInMillis();
        } else {
            return 0;
        }
    }

    public Calendar m3620f(Context context) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(m3619e(context));
        return c;
    }

    public boolean m3621g(Context context) {
        return this.f2022w > 0 && C0646d.m2975a(context, this.f2010k) >= this.f2022w;
    }

    public String m3622h(Context context) {
        return "Alarm_id: " + this.f2010k + " at time: " + C0870z.m4061a(context, m3620f(context));
    }

    public String m3623i(Context context) {
        if (this.f2000a == 2) {
            return context.getString(R.string.default_alarm_settings_title);
        }
        if (this.f2000a == 3) {
            return context.getString(R.string.preview_alarm_label);
        }
        if (!TextUtils.isEmpty(this.f2020u)) {
            return this.f2020u;
        }
        if (this.f2000a == 1) {
            return context.getString(R.string.timer);
        }
        return context.getString(R.string.default_label);
    }
}
