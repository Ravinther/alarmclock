package com.anglelabs.alarmclock.redesign.views;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.timer.TimerObject;
import com.anglelabs.alarmclock.redesign.utils.C0870z;
import com.anglelabs.alarmclock.redesign.utils.C0870z.C0869a;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;

public class TimerView extends RelativeLayout {
    private static String f2603a;
    private TimerObject f2604b;
    private int f2605c;
    private final ArrayList f2606d;
    private OnTouchListener f2607e;

    /* renamed from: com.anglelabs.alarmclock.redesign.views.TimerView.1 */
    class C08861 implements OnTouchListener {
        final /* synthetic */ TimerView f2594a;

        C08861(TimerView timerView) {
            this.f2594a = timerView;
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (v.getParent() != null) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.TimerView.a */
    private enum C0887a {
        HOURS(0, R.id.item1, R.id.item1_title, R.string.hours_no_number),
        MINUTES(1, R.id.item2, R.id.item2_title, R.string.minutes_no_number),
        SECONDS(2, R.id.item3, R.id.item3_title, R.string.seconds_no_number);
        
        public final int f2599d;
        private final int f2600e;
        private final int f2601f;
        private final int f2602g;

        private C0887a(int id, int resourceId, int titleResourceId, int titleStringId) {
            this.f2599d = id;
            this.f2600e = resourceId;
            this.f2601f = titleResourceId;
            this.f2602g = titleStringId;
        }

        public int m4115a() {
            return this.f2600e;
        }

        public int m4116b() {
            return R.layout.redesign_set_timer_list_item_layout;
        }

        public int m4117c() {
            return R.id.set_timer_item_list;
        }

        public int m4118d() {
            return this.f2601f;
        }

        public int m4119e() {
            return this.f2602g;
        }

        public int m4120f() {
            return 1;
        }
    }

    public TimerView(Context context) {
        this(context, null);
    }

    public TimerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2606d = new ArrayList();
        this.f2607e = new C08861(this);
        m4122a(context);
    }

    private void m4122a(Context context) {
        inflate(context, R.layout.redesign_date_view_layout, this);
        f2603a = context.getString(R.string.timer_default_name);
        ArrayList hoursItems = new ArrayList();
        ArrayList minutesItems = new ArrayList();
        for (int i = 0; i < 100; i++) {
            hoursItems.add(String.format("%02d", new Object[]{Integer.valueOf(i)}));
            if (i < 60) {
                minutesItems.add(String.format("%02d", new Object[]{Integer.valueOf(i)}));
            }
        }
        for (C0887a timeValue : C0887a.values()) {
            ArrayList items;
            if (timeValue == C0887a.HOURS) {
                items = hoursItems;
            } else {
                items = minutesItems;
            }
            DateListView dateListView = (DateListView) findViewById(timeValue.m4115a());
            dateListView.m4079a(items, timeValue.m4116b(), timeValue.m4117c());
            dateListView.setItemSelectedIndex(timeValue.m4120f());
            this.f2606d.add(dateListView);
            dateListView.setOnTouchListener(this.f2607e);
            ((TextView) findViewById(timeValue.m4118d())).setText(timeValue.m4119e());
        }
    }

    public TimerObject m4123a() {
        int hours = Integer.valueOf(((DateListView) this.f2606d.get(C0887a.HOURS.f2599d)).getCurrentItem()).intValue();
        int minutes = Integer.valueOf(((DateListView) this.f2606d.get(C0887a.MINUTES.f2599d)).getCurrentItem()).intValue();
        long totalTime = (long) ((((hours * 3600) + (minutes * 60)) + Integer.valueOf(((DateListView) this.f2606d.get(C0887a.SECONDS.f2599d)).getCurrentItem()).intValue()) * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE);
        if (this.f2604b == null) {
            StringBuilder append = new StringBuilder().append(f2603a);
            int i = this.f2605c + 1;
            this.f2605c = i;
            this.f2604b = new TimerObject(totalTime, append.append(i).toString());
        } else {
            this.f2604b.m3685a(totalTime);
        }
        return this.f2604b;
    }

    public void m4125a(TimerObject timer, int listSize) {
        this.f2604b = timer;
        this.f2605c = listSize;
        int hours = 0;
        int minutes = 5;
        int seconds = 0;
        if (timer != null) {
            C0869a time = C0870z.m4057a(timer.m3694d());
            hours = (int) time.f2505d;
            minutes = (int) time.f2504c;
            seconds = (int) time.f2503b;
        }
        m4121a(hours, minutes, seconds);
    }

    private void m4121a(int hours, int minutes, int seconds) {
        ((DateListView) this.f2606d.get(C0887a.HOURS.f2599d)).setInitialSelection(hours);
        ((DateListView) this.f2606d.get(C0887a.MINUTES.f2599d)).setInitialSelection(minutes);
        ((DateListView) this.f2606d.get(C0887a.SECONDS.f2599d)).setInitialSelection(seconds);
    }

    public void m4124a(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            m4121a(savedInstanceState.getInt("EXTRA_HOUR"), savedInstanceState.getInt("EXTRA_MINUTES"), savedInstanceState.getInt("EXTRA_SECONDS"));
        }
    }

    public void m4126b(Bundle outState) {
        String intAsStr = ((DateListView) this.f2606d.get(C0887a.HOURS.f2599d)).getCurrentItem();
        if (intAsStr != null) {
            outState.putInt("EXTRA_HOUR", Integer.valueOf(intAsStr).intValue());
        }
        intAsStr = ((DateListView) this.f2606d.get(C0887a.MINUTES.f2599d)).getCurrentItem();
        if (intAsStr != null) {
            outState.putInt("EXTRA_MINUTES", Integer.valueOf(intAsStr).intValue());
        }
        intAsStr = ((DateListView) this.f2606d.get(C0887a.SECONDS.f2599d)).getCurrentItem();
        if (intAsStr != null) {
            outState.putInt("EXTRA_SECONDS", Integer.valueOf(intAsStr).intValue());
        }
    }

    public TimerObject getTimer() {
        return this.f2604b;
    }
}
