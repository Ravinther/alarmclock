package com.anglelabs.alarmclock.redesign.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.ac;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import java.util.ArrayList;
import java.util.Arrays;

public class Stopwatch implements Parcelable {
    public static final Creator CREATOR;
    private Context f2026a;
    private long f2027b;
    private long f2028c;
    private long f2029d;
    private long f2030e;
    private int f2031f;
    private ArrayList f2032g;

    /* renamed from: com.anglelabs.alarmclock.redesign.model.Stopwatch.1 */
    static class C07711 implements Creator {
        C07711() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m3624a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m3625a(x0);
        }

        public Stopwatch m3624a(Parcel p) {
            return new Stopwatch(p);
        }

        public Stopwatch[] m3625a(int size) {
            return new Stopwatch[size];
        }
    }

    public Stopwatch(Parcel p) {
        this.f2031f = 0;
        this.f2032g = new ArrayList();
        m3627a(p);
    }

    public static boolean m3628a(Context context) {
        if (ac.m3774b(context.getApplicationContext()).getInt("state", 0) == 1) {
            return true;
        }
        return false;
    }

    public static boolean m3629b(Context context) {
        if (ac.m3774b(context.getApplicationContext()).getInt("state", 0) == 2) {
            return true;
        }
        return false;
    }

    static {
        CREATOR = new C07711();
    }

    public int describeContents() {
        return 0;
    }

    private void m3627a(Parcel p) {
        this.f2027b = p.readLong();
        this.f2028c = p.readLong();
        this.f2029d = p.readLong();
        this.f2030e = p.readLong();
        this.f2031f = p.readInt();
        this.f2032g = m3626a(p.readString());
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.f2027b);
        dest.writeLong(this.f2028c);
        dest.writeLong(this.f2029d);
        dest.writeLong(this.f2030e);
        dest.writeInt(this.f2031f);
        dest.writeString(this.f2032g.toString());
    }

    public Stopwatch(Context context) {
        this.f2031f = 0;
        this.f2032g = new ArrayList();
        this.f2026a = context.getApplicationContext();
        m3635c(context);
    }

    public void m3631a() {
        this.f2027b = System.currentTimeMillis();
        this.f2028c = this.f2027b;
        this.f2031f = 1;
        m3630e(this.f2026a);
    }

    public void m3633b() {
        this.f2032g.add(0, new StopwatchRow(C0870z.m4058a((long) ((int) m3641h()), true), C0870z.m4058a((long) ((int) m3640g()), true)));
        this.f2028c = System.currentTimeMillis();
        m3630e(this.f2026a);
    }

    public void m3634c() {
        this.f2029d = System.currentTimeMillis();
        this.f2030e = System.currentTimeMillis();
        this.f2031f = 2;
        m3630e(this.f2026a);
    }

    public void m3637d() {
        if (this.f2031f == 0) {
            m3631a();
        } else if (this.f2031f == 2) {
            if (this.f2029d > 0) {
                this.f2027b += System.currentTimeMillis() - this.f2029d;
            }
            if (this.f2030e > 0) {
                this.f2028c += System.currentTimeMillis() - this.f2030e;
            }
            this.f2031f = 1;
            m3630e(this.f2026a);
        }
    }

    public void m3638e() {
        this.f2027b = 0;
        this.f2028c = 0;
        this.f2029d = 0;
        this.f2030e = 0;
        this.f2032g.clear();
        this.f2031f = 0;
        m3630e(this.f2026a);
    }

    private void m3630e(Context context) {
        Editor editor = ac.m3774b(context.getApplicationContext()).edit();
        editor.putLong("startTime", m3642i());
        editor.putLong("startLapTime", m3643j());
        editor.putLong("pauseTime", m3644k());
        editor.putString("laps_time", this.f2032g.toString());
        editor.putInt("state", this.f2031f);
        editor.commit();
    }

    public void m3635c(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            C0970a.m4325b("can't read stopwatch context is null");
            return;
        }
        SharedPreferences prefs = ac.m3774b(context.getApplicationContext());
        this.f2027b = prefs.getLong("startTime", 0);
        this.f2028c = prefs.getLong("startLapTime", 0);
        this.f2029d = prefs.getLong("pauseTime", 0);
        this.f2030e = prefs.getLong("pauseTime", 0);
        this.f2031f = prefs.getInt("state", 0);
        m3626a(prefs.getString("laps_time", ""));
    }

    public void m3632a(SharedPreferences prefs) {
        prefs.edit().remove("state").remove("startTime").remove("startLapTime").remove("pauseTime").remove("laps_time").commit();
    }

    private ArrayList m3626a(String lapTime) {
        this.f2032g = new ArrayList();
        if (!TextUtils.isEmpty(lapTime)) {
            lapTime = lapTime.replace("[", "").replace("]", "");
            if (!TextUtils.isEmpty(lapTime)) {
                for (String s : Arrays.asList(lapTime.split(", "))) {
                    this.f2032g.add(new StopwatchRow(s.split(";")[0], s.split(";")[1]));
                }
            }
        }
        return this.f2032g;
    }

    public boolean m3639f() {
        return this.f2031f == 1;
    }

    public long m3640g() {
        if (m3639f()) {
            return System.currentTimeMillis() - this.f2027b;
        }
        return this.f2029d - this.f2027b;
    }

    public long m3641h() {
        if (m3639f()) {
            return System.currentTimeMillis() - this.f2028c;
        }
        return this.f2030e - this.f2028c;
    }

    public long m3642i() {
        return this.f2027b;
    }

    public long m3643j() {
        return this.f2028c;
    }

    public long m3644k() {
        return this.f2029d;
    }

    public int m3645l() {
        return this.f2032g.size() + 1;
    }

    public ArrayList m3646m() {
        return this.f2032g;
    }

    public String m3636d(Context context) {
        StringBuilder builder = new StringBuilder();
        int counter = 1;
        if (this.f2032g.size() > 0) {
            for (int i = this.f2032g.size() - 1; i >= 0; i--) {
                builder.append(context.getString(R.string.stopwatch_lap));
                builder.append(" ");
                builder.append(counter < 10 ? ITKSvc.CODEREVISION + counter : Integer.valueOf(counter));
                builder.append(" ").append(((StopwatchRow) this.f2032g.get(i)).f2033a);
                builder.append(" : ").append(((StopwatchRow) this.f2032g.get(i)).f2034b);
                builder.append("\n");
                counter++;
            }
        }
        return builder.toString();
    }
}
