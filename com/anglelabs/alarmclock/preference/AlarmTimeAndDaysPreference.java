package com.anglelabs.alarmclock.preference;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.activities.p019a.C0503b;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import com.anglelabs.alarmclock.redesign.utils.C0860w;
import com.anglelabs.alarmclock.redesign.views.WeekDaysCheckGroup;
import com.anglelabs.alarmclock.redesign.views.WeekDaysCheckGroup.C0501a;
import java.util.Calendar;

public class AlarmTimeAndDaysPreference extends Preference implements C0503b {
    private WeekDaysCheckGroup f1327a;
    private TimePicker f1328b;
    private C0773a f1329c;
    private int f1330d;
    private int f1331e;
    private View f1332f;

    /* renamed from: com.anglelabs.alarmclock.preference.AlarmTimeAndDaysPreference.1 */
    class C05021 implements C0501a {
        final /* synthetic */ AlarmTimeAndDaysPreference f1326a;

        C05021(AlarmTimeAndDaysPreference alarmTimeAndDaysPreference) {
            this.f1326a = alarmTimeAndDaysPreference;
        }

        public void m2384a(C0773a mDaysOfWeek) {
            this.f1326a.f1329c = mDaysOfWeek;
        }
    }

    public AlarmTimeAndDaysPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f1330d = -1;
        this.f1331e = -1;
    }

    public AlarmTimeAndDaysPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1330d = -1;
        this.f1331e = -1;
    }

    public AlarmTimeAndDaysPreference(Context context) {
        super(context);
        this.f1330d = -1;
        this.f1331e = -1;
    }

    protected View onCreateView(ViewGroup parent) {
        if (this.f1332f == null) {
            this.f1332f = LayoutInflater.from(getContext()).inflate(R.layout.redesign_pref_digital_clock_layout, parent, false);
            this.f1327a = (WeekDaysCheckGroup) this.f1332f.findViewById(R.id.daysGroup);
            this.f1328b = (TimePicker) this.f1332f.findViewById(R.id.timePicker);
            m2390c();
            if (this.f1329c != null) {
                this.f1327a.setEnabledDays(this.f1329c);
                this.f1327a.setOnDaysChangedListener(new C05021(this));
            }
        }
        return this.f1332f;
    }

    public void m2393a(C0773a days) {
        this.f1329c = days;
        if (this.f1327a != null) {
            this.f1327a.setEnabledDays(this.f1329c);
        }
    }

    public void m2392a(int hours, int minute) {
        this.f1330d = hours;
        this.f1331e = minute;
        m2390c();
    }

    public Calendar m2391a() {
        Calendar calendar = Calendar.getInstance();
        if (this.f1328b != null) {
            this.f1328b.clearFocus();
            calendar.set(11, this.f1328b.getCurrentHour().intValue());
            calendar.set(12, this.f1328b.getCurrentMinute().intValue());
        } else {
            calendar.set(11, this.f1330d);
            calendar.set(12, this.f1331e);
        }
        return calendar;
    }

    public C0773a m2394b() {
        return this.f1329c;
    }

    private void m2390c() {
        if (this.f1328b != null) {
            this.f1328b.setIs24HourView(Boolean.valueOf(C0860w.m4038b(getContext())));
            this.f1328b.setCurrentHour(Integer.valueOf(this.f1330d != -1 ? this.f1330d : 8));
            this.f1328b.setCurrentMinute(Integer.valueOf(this.f1331e != -1 ? this.f1331e : 0));
        }
    }
}
