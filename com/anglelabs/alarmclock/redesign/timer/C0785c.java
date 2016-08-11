package com.anglelabs.alarmclock.redesign.timer;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.timer.c */
public class C0785c {
    public static boolean m3735a(ArrayList timerList) {
        Iterator i$ = timerList.iterator();
        while (i$.hasNext()) {
            if (((TimerObject) i$.next()).m3698h()) {
                return true;
            }
        }
        return false;
    }

    public static TimerObject m3734a(List timerList) {
        for (TimerObject timer : timerList) {
            if (timer.m3699i()) {
                return timer;
            }
        }
        return null;
    }

    public static ArrayList m3736b(ArrayList timerList) {
        ArrayList result = new ArrayList();
        Iterator i$ = timerList.iterator();
        while (i$.hasNext()) {
            TimerObject timer = (TimerObject) i$.next();
            if (timer.m3700j()) {
                result.add(timer);
            }
        }
        return result;
    }

    public static TimerObject m3732a(SharedPreferences prefs, int id) {
        Iterator i$ = C0783a.m3714a(prefs).iterator();
        while (i$.hasNext()) {
            TimerObject timerObject = (TimerObject) i$.next();
            if (timerObject.m3683a() == id) {
                return timerObject;
            }
        }
        return null;
    }

    public static TimerObject m3733a(ArrayList timerList, boolean requireNextUpdate) {
        TimerObject tmpTimer = null;
        long now = TimerObject.m3681m();
        long nextTimesUp = Long.MAX_VALUE;
        Iterator i$ = timerList.iterator();
        while (i$.hasNext()) {
            TimerObject timer = (TimerObject) i$.next();
            if (timer.m3700j()) {
                long timesUpTime = timer.m3697g();
                long timeLeft = timesUpTime - now;
                if (timesUpTime < nextTimesUp && (!requireNextUpdate || timeLeft > 60)) {
                    nextTimesUp = timesUpTime;
                    tmpTimer = timer;
                }
            }
        }
        return tmpTimer;
    }
}
