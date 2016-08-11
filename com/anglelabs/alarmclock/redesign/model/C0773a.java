package com.anglelabs.alarmclock.redesign.model;

import android.content.Context;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.utils.C0809g;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.anglelabs.alarmclock.redesign.model.a */
public final class C0773a {
    public int f2035a;

    public C0773a(int days) {
        this.f2035a = days;
    }

    public CharSequence m3655a(Context context) {
        StringBuilder ret = new StringBuilder();
        Locale appLocale = C0810h.m3837b(context);
        if (this.f2035a == 127) {
            return context.getString(R.string.every_day);
        }
        if (m3652e(context)) {
            return context.getString(R.string.weekend);
        }
        if (m3651d(context)) {
            return context.getString(R.string.week_days);
        }
        String[] dayList;
        int dayCount = 0;
        for (int days = this.f2035a; days > 0; days >>= 1) {
            if ((days & 1) == 1) {
                dayCount++;
            }
        }
        if (dayCount > 1) {
            dayList = context.getResources().getStringArray(R.array.days_of_week_abbreviated);
        } else {
            dayList = context.getResources().getStringArray(R.array.days_of_week);
        }
        int loopEnd = 7;
        int firstDayOfWeek = C0809g.m3828b(context);
        if (firstDayOfWeek == 1) {
            if ((this.f2035a & 64) != 0) {
                ret.append(dayList[6].toUpperCase(appLocale)).append(" ");
            }
            loopEnd = 7 - 1;
        } else if (firstDayOfWeek == 7) {
            if ((this.f2035a & 32) != 0) {
                ret.append(dayList[5].toUpperCase(appLocale)).append(" ");
            }
            if ((this.f2035a & 64) != 0) {
                ret.append(dayList[6].toUpperCase(appLocale)).append(" ");
            }
            loopEnd = 7 - 2;
        }
        for (int i = 0; i < loopEnd; i++) {
            if ((this.f2035a & (1 << i)) != 0) {
                ret.append(dayList[i].toUpperCase(appLocale));
                dayCount--;
                if (dayCount > 0) {
                    ret.append(" ");
                }
            }
        }
        return ret.toString();
    }

    public void m3658b(Context context) {
        int first = C0809g.m3828b(context);
        this.f2035a = 127;
        if (first == 1) {
            m3656a(4, false);
            m3656a(5, false);
        } else if (first == 2) {
            m3656a(5, false);
            m3656a(6, false);
        }
    }

    public void m3660c(Context context) {
        int first = C0809g.m3828b(context);
        this.f2035a = 0;
        if (first == 1) {
            m3656a(4, true);
            m3656a(5, true);
        } else if (first == 2) {
            m3656a(5, true);
            m3656a(6, true);
        }
    }

    private boolean m3651d(Context context) {
        boolean z = true;
        int first = C0809g.m3828b(context);
        if (first == 7) {
            return false;
        }
        int weekend = -1;
        if (first == 1) {
            weekend = 79;
        } else if (first == 2) {
            weekend = 31;
        }
        if (this.f2035a != weekend) {
            z = false;
        }
        return z;
    }

    private boolean m3652e(Context context) {
        boolean z = true;
        int first = C0809g.m3828b(context);
        if (first == 7) {
            return false;
        }
        int weekend = -1;
        if (first == 1) {
            weekend = 48;
        } else if (first == 2) {
            weekend = 96;
        }
        if (this.f2035a != weekend) {
            z = false;
        }
        return z;
    }

    private boolean m3649a(int day) {
        return (this.f2035a & (1 << day)) > 0;
    }

    public void m3656a(int day, boolean set) {
        if (set) {
            this.f2035a |= 1 << day;
        } else {
            this.f2035a &= (1 << day) ^ -1;
        }
    }

    public int m3653a() {
        return this.f2035a;
    }

    public boolean[] m3659b() {
        boolean[] ret = new boolean[7];
        for (int i = 0; i < 7; i++) {
            ret[i] = m3649a(i);
        }
        return ret;
    }

    public void m3657a(boolean[] b) {
        for (int i = 0; i < 7; i++) {
            m3656a(i, b[i]);
        }
    }

    public boolean m3661c() {
        return this.f2035a != 0;
    }

    private int m3650b(Calendar c) {
        return (c.get(7) + 5) % 7;
    }

    public int m3654a(Calendar c) {
        if (this.f2035a == 0) {
            return -1;
        }
        int today = m3650b(c);
        int dayCount = 0;
        while (dayCount < 7 && !m3649a((today + dayCount) % 7)) {
            dayCount++;
        }
        return dayCount;
    }
}
