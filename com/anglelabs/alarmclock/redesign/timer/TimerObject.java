package com.anglelabs.alarmclock.redesign.timer;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.view.View;

public final class TimerObject implements Parcelable {
    public static final Creator CREATOR;
    private StringBuffer f2065a;
    private int f2066b;
    private long f2067c;
    private long f2068d;
    private long f2069e;
    private long f2070f;
    private int f2071g;
    private int f2072h;
    private int f2073i;
    private String f2074j;
    private View f2075k;

    /* renamed from: com.anglelabs.alarmclock.redesign.timer.TimerObject.1 */
    static class C07771 implements Creator {
        C07771() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m3674a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m3675a(x0);
        }

        public TimerObject m3674a(Parcel parcel) {
            return new TimerObject(null);
        }

        public TimerObject[] m3675a(int size) {
            return new TimerObject[size];
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.timer.TimerObject.a */
    public enum C0778a {
        TIMER_ID("timer_id_"),
        LABEL("timer_label_"),
        START_TIME("timer_start_time_"),
        TIME_LEFT("timer_time_left_"),
        TIME_LENGTH("timer_length_"),
        SETUP_TIME("timer_setup_timer_"),
        RUNNING_STATE("timer_running_state_"),
        TIME_STATE("timer_time_state_"),
        RINGING_STATE("timer_ringing_state_"),
        TIMER_LIST("timers_list");
        
        private final String f2054k;

        private C0778a(String strDef) {
            this.f2054k = strDef;
        }

        public String m3676a() {
            return this.f2054k;
        }

        public String m3677a(String id) {
            return this.f2054k + id;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.timer.TimerObject.b */
    public enum C0779b {
        Create(1),
        Update(2),
        Play(3),
        Stop(4),
        Restart(5),
        Delete(6),
        TimeOver(7),
        AddMinutes(8);
        
        private final int f2064i;

        private C0779b(int id) {
            this.f2064i = id;
        }

        public int m3678a() {
            return this.f2064i;
        }
    }

    static {
        CREATOR = new C07771();
    }

    public TimerObject() {
        this(0);
    }

    private TimerObject(long timerLength) {
        this.f2065a = null;
        m3679a(timerLength, "");
    }

    public TimerObject(long timerLength, String label) {
        this.f2065a = null;
        m3679a(timerLength, label);
    }

    private TimerObject(Parcel parcel) {
        this.f2065a = null;
        this.f2066b = parcel.readInt();
        this.f2067c = parcel.readLong();
        this.f2068d = parcel.readLong();
        this.f2069e = parcel.readLong();
        this.f2070f = parcel.readLong();
        this.f2072h = parcel.readInt();
        this.f2071g = parcel.readInt();
        this.f2073i = parcel.readInt();
        this.f2074j = parcel.readString();
    }

    private void m3679a(long timerLength, String timerLabel) {
        this.f2066b = (int) m3681m();
        m3685a(timerLength);
        this.f2074j = timerLabel;
    }

    public void m3685a(long timerLength) {
        this.f2067c = m3681m();
        if (359999000 < timerLength) {
            timerLength = 359999000;
        }
        this.f2070f = timerLength;
        this.f2069e = timerLength;
        this.f2068d = timerLength;
        m3682n();
    }

    private void m3680b(long time) {
        this.f2068d = this.f2069e - (m3681m() - this.f2067c);
        if (this.f2068d < 359999000 - time) {
            this.f2069e += time;
        }
    }

    public void m3689a(SharedPreferences prefs, boolean isNew) {
        String id = Integer.toString(this.f2066b);
        Editor editor = prefs.edit();
        editor.putInt(C0778a.TIMER_ID.m3677a(id), this.f2066b);
        editor.putLong(C0778a.START_TIME.m3677a(id), this.f2067c);
        editor.putLong(C0778a.TIME_LEFT.m3677a(id), this.f2068d);
        editor.putLong(C0778a.TIME_LENGTH.m3677a(id), this.f2069e);
        editor.putLong(C0778a.SETUP_TIME.m3677a(id), this.f2070f);
        editor.putInt(C0778a.RUNNING_STATE.m3677a(id), this.f2072h);
        editor.putInt(C0778a.TIME_STATE.m3677a(id), this.f2071g);
        editor.putInt(C0778a.RINGING_STATE.m3677a(id), this.f2073i);
        editor.putString(C0778a.LABEL.m3677a(id), this.f2074j);
        if (isNew) {
            C0783a.m3716a(prefs, editor, id);
        }
        editor.apply();
    }

    public void m3687a(SharedPreferences prefs, int id) {
        String idStr = Integer.toString(id);
        this.f2066b = id;
        this.f2067c = prefs.getLong(C0778a.START_TIME.m3677a(idStr), 0);
        this.f2068d = prefs.getLong(C0778a.TIME_LEFT.m3677a(idStr), 0);
        this.f2069e = prefs.getLong(C0778a.TIME_LENGTH.m3677a(idStr), 0);
        this.f2070f = prefs.getLong(C0778a.SETUP_TIME.m3677a(idStr), 0);
        this.f2072h = prefs.getInt(C0778a.RUNNING_STATE.m3677a(idStr), 0);
        this.f2071g = prefs.getInt(C0778a.TIME_STATE.m3677a(idStr), 0);
        this.f2073i = prefs.getInt(C0778a.RINGING_STATE.m3677a(idStr), 0);
        this.f2074j = prefs.getString(C0778a.LABEL.m3677a(idStr), "");
    }

    @SuppressLint({"CommitPrefEdits"})
    void m3686a(SharedPreferences prefs) {
        Editor editor = prefs.edit();
        String id = Integer.toString(this.f2066b);
        editor.remove(C0778a.TIMER_ID.m3677a(id));
        editor.remove(C0778a.START_TIME.m3677a(id));
        editor.remove(C0778a.TIME_LEFT.m3677a(id));
        editor.remove(C0778a.TIME_LENGTH.m3677a(id));
        editor.remove(C0778a.SETUP_TIME.m3677a(id));
        editor.remove(C0778a.RUNNING_STATE.m3677a(id));
        editor.remove(C0778a.TIME_STATE.m3677a(id));
        editor.remove(C0778a.RINGING_STATE.m3677a(id));
        editor.remove(C0778a.LABEL.m3677a(id));
        C0783a.m3718b(prefs, editor, id);
        editor.commit();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f2066b);
        dest.writeLong(this.f2067c);
        dest.writeLong(this.f2068d);
        dest.writeLong(this.f2069e);
        dest.writeLong(this.f2070f);
        dest.writeInt(this.f2072h);
        dest.writeInt(this.f2071g);
        dest.writeInt(this.f2073i);
        dest.writeString(this.f2074j);
    }

    public int m3683a() {
        return this.f2066b;
    }

    public int m3692b() {
        return this.f2072h;
    }

    public int m3693c() {
        return this.f2073i;
    }

    public long m3694d() {
        return this.f2070f;
    }

    public void m3688a(SharedPreferences prefs, String timerLabel) {
        this.f2074j = timerLabel;
        Editor editor = prefs.edit();
        editor.putString(C0778a.LABEL.m3677a(Integer.toString(this.f2066b)), this.f2074j);
        editor.apply();
        m3682n();
    }

    public String m3695e() {
        return this.f2074j;
    }

    public View m3696f() {
        return this.f2075k;
    }

    public void m3690a(View view) {
        this.f2075k = view;
    }

    public long m3697g() {
        return this.f2067c + this.f2069e;
    }

    public boolean m3698h() {
        return this.f2072h == 1;
    }

    public boolean m3699i() {
        return this.f2073i == 11;
    }

    public boolean m3700j() {
        return this.f2071g == 10 && m3698h();
    }

    public long m3684a(boolean forceUpdate) {
        if (m3698h() || forceUpdate) {
            this.f2068d = this.f2069e - (m3681m() - this.f2067c);
        }
        return this.f2068d;
    }

    public long m3701k() {
        return this.f2068d;
    }

    private void m3682n() {
        this.f2065a = null;
    }

    public String toString() {
        if (this.f2065a == null) {
            this.f2065a = new StringBuffer("Timer Id :");
            this.f2065a.append(this.f2066b);
            this.f2065a.append(" Label: ");
            this.f2065a.append(this.f2074j);
            this.f2065a.append(" setupLength: ");
            this.f2065a.append(this.f2070f);
            this.f2065a.append(" ringingState: ");
            this.f2065a.append(this.f2073i);
            this.f2065a.append(" runningState: ");
            this.f2065a.append(this.f2072h);
            this.f2065a.append(" timeState: ");
            this.f2065a.append(this.f2071g);
        }
        return this.f2065a.toString();
    }

    public void m3691a(C0779b action, SharedPreferences prefs) {
        this.f2073i = 10;
        boolean isNew = false;
        if (action == C0779b.Delete) {
            m3686a(prefs);
            return;
        }
        if (action == C0779b.Play) {
            this.f2072h = 1;
            this.f2067c = m3681m();
            this.f2069e = m3684a(true);
        } else if (action == C0779b.Stop) {
            this.f2072h = 2;
            this.f2069e = m3684a(true);
        } else if (action == C0779b.Restart) {
            m3702l();
        } else if (action == C0779b.Create) {
            this.f2072h = 1;
            this.f2071g = 10;
            isNew = true;
        } else if (action == C0779b.Update) {
            this.f2072h = 1;
            this.f2071g = 10;
        } else if (action == C0779b.TimeOver) {
            this.f2071g = 11;
            this.f2073i = 11;
        } else if (action == C0779b.AddMinutes) {
            if (this.f2071g == 11) {
                this.f2071g = 10;
                m3685a(60000);
            } else {
                m3680b(60000);
            }
            m3684a(true);
        }
        m3689a(prefs, isNew);
    }

    public void m3702l() {
        long j = this.f2070f;
        this.f2069e = j;
        this.f2068d = j;
        this.f2072h = 2;
        this.f2071g = 10;
    }

    public static long m3681m() {
        return SystemClock.elapsedRealtime();
    }
}
