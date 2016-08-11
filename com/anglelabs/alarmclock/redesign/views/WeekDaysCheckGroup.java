package com.anglelabs.alarmclock.redesign.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import com.alarmclock.xtreme.free.C0499a.C0498a;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.C0773a;
import com.anglelabs.alarmclock.redesign.utils.C0809g;

public class WeekDaysCheckGroup extends FrameLayout {
    private CheckBox[] f2609a;
    private C0773a f2610b;
    private int[] f2611c;
    private C0501a f2612d;
    private int f2613e;
    private OnCheckedChangeListener f2614f;

    /* renamed from: com.anglelabs.alarmclock.redesign.views.WeekDaysCheckGroup.a */
    public interface C0501a {
        void m2383a(C0773a c0773a);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.views.WeekDaysCheckGroup.1 */
    class C08881 implements OnCheckedChangeListener {
        final /* synthetic */ WeekDaysCheckGroup f2608a;

        C08881(WeekDaysCheckGroup weekDaysCheckGroup) {
            this.f2608a = weekDaysCheckGroup;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            this.f2608a.f2610b.m3656a(C0809g.m3827a(this.f2608a.getContext(), compoundButton.getId()), b);
            if (this.f2608a.f2612d != null) {
                this.f2608a.f2612d.m2383a(this.f2608a.f2610b);
            }
        }
    }

    public void setOnDaysChangedListener(C0501a listener) {
        this.f2612d = listener;
    }

    public WeekDaysCheckGroup(Context context) {
        super(context);
        this.f2609a = new CheckBox[7];
        this.f2610b = new C0773a(0);
        this.f2611c = new int[]{R.id.days0, R.id.days1, R.id.days2, R.id.days3, R.id.days4, R.id.days5, R.id.days6};
        this.f2613e = -1;
        this.f2614f = new C08881(this);
        m4128a(context);
    }

    public WeekDaysCheckGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f2609a = new CheckBox[7];
        this.f2610b = new C0773a(0);
        this.f2611c = new int[]{R.id.days0, R.id.days1, R.id.days2, R.id.days3, R.id.days4, R.id.days5, R.id.days6};
        this.f2613e = -1;
        this.f2614f = new C08881(this);
        m4129a(context, attrs);
        m4128a(context);
    }

    @TargetApi(11)
    public WeekDaysCheckGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f2609a = new CheckBox[7];
        this.f2610b = new C0773a(0);
        this.f2611c = new int[]{R.id.days0, R.id.days1, R.id.days2, R.id.days3, R.id.days4, R.id.days5, R.id.days6};
        this.f2613e = -1;
        this.f2614f = new C08881(this);
        m4129a(context, attrs);
        m4128a(context);
    }

    private void m4129a(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, C0498a.DaysCheckGroup, 0, 0);
        if (a != null) {
            try {
                this.f2613e = a.getResourceId(0, -1);
            } finally {
                a.recycle();
            }
        }
    }

    public void setEnabledDays(C0773a days) {
        this.f2610b = days;
        boolean[] boolArray = days.m3659b();
        for (int i = 0; i < 7; i++) {
            this.f2609a[C0809g.m3829b(getContext(), i)].setChecked(boolArray[i]);
        }
    }

    private void m4128a(Context context) {
        String[] daysOfWeek = !isInEditMode() ? C0809g.m3830c(context) : new String[]{"1", "2", "3", "4", "5", "6", "7"};
        if (this.f2613e == -1) {
            this.f2613e = R.layout.redesign_view_days_of_week_layout;
        }
        View.inflate(getContext(), this.f2613e, this);
        int i = 0;
        for (int id : this.f2611c) {
            CheckBox check = (CheckBox) findViewById(id);
            String day = daysOfWeek[i];
            if (day.length() > 3) {
                day = day.substring(0, 2);
            }
            check.setMaxLines(1);
            check.setText(day);
            check.setOnCheckedChangeListener(this.f2614f);
            check.setId(i);
            this.f2609a[i] = check;
            i++;
        }
    }

    public C0773a getDaysOfWeek() {
        return this.f2610b;
    }
}
