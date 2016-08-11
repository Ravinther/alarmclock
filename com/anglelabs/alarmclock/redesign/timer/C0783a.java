package com.anglelabs.alarmclock.redesign.timer;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.anglelabs.alarmclock.redesign.timer.TimerObject.C0778a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.anglelabs.alarmclock.redesign.timer.a */
public class C0783a {

    /* renamed from: com.anglelabs.alarmclock.redesign.timer.a.1 */
    static class C07821 implements Comparator {
        C07821() {
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return m3713a((TimerObject) x0, (TimerObject) x1);
        }

        public int m3713a(TimerObject timer1, TimerObject timer2) {
            return timer1.m3683a() - timer2.m3683a();
        }
    }

    public static ArrayList m3714a(SharedPreferences prefs) {
        ArrayList timerStringList = C0783a.m3720d(prefs);
        ArrayList timerList = new ArrayList(timerStringList.size());
        if (timerStringList.size() > 0) {
            Iterator i$ = timerStringList.iterator();
            while (i$.hasNext()) {
                String aTimerStringList = (String) i$.next();
                TimerObject timer = new TimerObject();
                timer.m3687a(prefs, Integer.parseInt(aTimerStringList));
                timerList.add(timer);
            }
            Collections.sort(timerList, new C07821());
        }
        return timerList;
    }

    public static void m3717b(SharedPreferences prefs) {
        Iterator i$ = C0783a.m3714a(prefs).iterator();
        while (i$.hasNext()) {
            TimerObject timer = (TimerObject) i$.next();
            timer.m3702l();
            timer.m3689a(prefs, false);
        }
    }

    public static void m3716a(SharedPreferences prefs, Editor editor, String timerId) {
        ArrayList timerStringList = C0783a.m3720d(prefs);
        timerStringList.add(timerId);
        C0783a.m3715a(editor, timerStringList);
    }

    public static void m3718b(SharedPreferences prefs, Editor editor, String timerId) {
        ArrayList timerStringList = C0783a.m3720d(prefs);
        timerStringList.remove(timerId);
        C0783a.m3715a(editor, timerStringList);
    }

    public static int m3719c(SharedPreferences prefs) {
        return C0783a.m3720d(prefs).size();
    }

    private static void m3715a(Editor editor, ArrayList timerList) {
        editor.putString(C0778a.TIMER_LIST.m3676a(), TextUtils.join("\u201a\u2017\u201a", (String[]) timerList.toArray(new String[timerList.size()])));
    }

    private static ArrayList m3720d(SharedPreferences prefs) {
        return new ArrayList(Arrays.asList(TextUtils.split(prefs.getString(C0778a.TIMER_LIST.m3676a(), ""), "\u201a\u2017\u201a")));
    }
}
