package com.anglelabs.alarmclock.redesign.p020a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.timer.TimerObject;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0829q;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.anglelabs.alarmclock.redesign.views.AnimationEditText;
import com.anglelabs.alarmclock.redesign.views.AnimationEditText.C0552a;
import com.anglelabs.alarmclock.redesign.views.TimeDisplayBar;

/* renamed from: com.anglelabs.alarmclock.redesign.a.e */
public class C0557e extends C0518a {
    private final OnClickListener f1497a;
    private final OnClickListener f1498b;
    private final OnClickListener f1499c;
    private final OnClickListener f1500d;
    private final OnClickListener f1501e;
    private final OnLongClickListener f1502j;
    private final C0552a f1503k;
    private final Context f1504l;
    private int f1505m;
    private AnimationEditText f1506n;
    private final C0554a f1507o;

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.1 */
    class C05461 implements OnClickListener {
        final /* synthetic */ C0557e f1472a;

        C05461(C0557e c0557e) {
            this.f1472a = c0557e;
        }

        public void onClick(View view) {
            this.f1472a.m2561a();
            TimerObject timer = (TimerObject) view.getTag(R.id.timeradapter_timer);
            if (timer.m3698h()) {
                this.f1472a.f1497a.onClick(view);
                return;
            }
            C0555b viewHolder = (C0555b) timer.m3696f().getTag();
            this.f1472a.f1507o.m2544c(timer);
            C0807e.m3813a(this.f1472a.f1504l, viewHolder.f1483e, (int) R.anim.from_middle, (int) R.anim.to_middle);
            this.f1472a.m2552a(viewHolder);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.2 */
    class C05472 implements OnClickListener {
        final /* synthetic */ C0557e f1473a;

        C05472(C0557e c0557e) {
            this.f1473a = c0557e;
        }

        public void onClick(View view) {
            this.f1473a.m2561a();
            TimerObject timer = (TimerObject) view.getTag(R.id.timeradapter_timer);
            if (timer.m3698h()) {
                C0555b viewHolder = (C0555b) timer.m3696f().getTag();
                this.f1473a.f1507o.m2545d(timer);
                C0807e.m3813a(this.f1473a.f1504l, viewHolder.f1483e, (int) R.anim.from_middle, (int) R.anim.to_middle);
                this.f1473a.m2556b(viewHolder);
                viewHolder.m2549a(false);
                return;
            }
            this.f1473a.f1497a.onClick(view);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.3 */
    class C05483 implements OnClickListener {
        final /* synthetic */ C0557e f1474a;

        C05483(C0557e c0557e) {
            this.f1474a = c0557e;
        }

        public void onClick(View view) {
            this.f1474a.m2561a();
            TimerObject timer = (TimerObject) view.getTag(R.id.timeradapter_timer);
            if (timer.m3698h()) {
                C0555b viewHolder = (C0555b) timer.m3696f().getTag();
                this.f1474a.f1507o.m2538a(timer);
                viewHolder.m2549a(false);
                return;
            }
            this.f1474a.f1497a.onClick(view);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.4 */
    class C05494 implements OnClickListener {
        final /* synthetic */ C0557e f1475a;

        C05494(C0557e c0557e) {
            this.f1475a = c0557e;
        }

        public void onClick(View view) {
            this.f1475a.m2561a();
            TimerObject timer = (TimerObject) view.getTag(R.id.timeradapter_timer);
            if (timer.m3698h()) {
                this.f1475a.f1497a.onClick(view);
                return;
            }
            C0555b viewHolder = (C0555b) timer.m3696f().getTag();
            this.f1475a.f1507o.m2543b(timer);
            viewHolder.f1481c.setTimerTime(timer.m3701k());
            viewHolder.f1481c.invalidate();
            viewHolder.m2549a(false);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.5 */
    class C05505 implements OnClickListener {
        final /* synthetic */ C0557e f1476a;

        C05505(C0557e c0557e) {
            this.f1476a = c0557e;
        }

        public void onClick(View view) {
            this.f1476a.m2561a();
            TimerObject timer = (TimerObject) view.getTag(R.id.timeradapter_timer);
            this.f1476a.f1507o.m2539a(timer, ((Integer) view.getTag(R.id.timeradapter_position)).intValue());
            ((C0555b) timer.m3696f().getTag()).m2549a(false);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.6 */
    class C05516 implements OnLongClickListener {
        final /* synthetic */ C0557e f1477a;

        C05516(C0557e c0557e) {
            this.f1477a = c0557e;
        }

        public boolean onLongClick(View v) {
            return true;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.7 */
    class C05537 implements C0552a {
        final /* synthetic */ C0557e f1478a;

        C05537(C0557e c0557e) {
            this.f1478a = c0557e;
        }

        public void m2533a(AnimationEditText editText) {
            this.f1478a.f1506n = editText;
            C0830k.m3896a(this.f1478a.m2463g(), C0829q.Label);
        }

        public void m2535b(AnimationEditText editText) {
            TimerObject timer = (TimerObject) editText.getTag();
            if (timer == null) {
                C0850q.m3987b("stopEditingLabel timer is null");
                return;
            }
            String newText = editText.getText().toString();
            if (timer.m3695e().compareTo(newText) != 0) {
                this.f1478a.f1507o.m2540a(timer, newText);
                this.f1478a.notifyDataSetChanged();
            }
            this.f1478a.f1506n = null;
        }

        public boolean m2536c(AnimationEditText editText) {
            return !this.f1478a.f1507o.m2541a();
        }

        public boolean m2534a(Object prev, Object curr) {
            return ((TimerObject) prev).m3683a() == ((TimerObject) curr).m3683a();
        }

        public AnimationEditText m2532a() {
            return this.f1478a.f1506n;
        }

        public void m2537d(AnimationEditText editText) {
            String newText = "";
            if (editText.getText() != null) {
                newText = editText.getText().toString();
            }
            editText.setHint(TextUtils.isEmpty(newText) ? this.f1478a.f1504l.getString(R.string.empty_timer_name_hint) : "");
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.a */
    public interface C0554a {
        void m2538a(TimerObject timerObject);

        void m2539a(TimerObject timerObject, int i);

        void m2540a(TimerObject timerObject, String str);

        boolean m2541a();

        boolean m2542a(int i);

        void m2543b(TimerObject timerObject);

        void m2544c(TimerObject timerObject);

        void m2545d(TimerObject timerObject);

        void m2546e(TimerObject timerObject);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.b */
    public class C0555b {
        public AnimationEditText f1479a;
        public ProgressBar f1480b;
        public TimeDisplayBar f1481c;
        public ImageView f1482d;
        public ViewSwitcher f1483e;
        public TextView f1484f;
        public TextView f1485g;
        public TextView f1486h;
        public TextView f1487i;
        public C0556c f1488j;
        final /* synthetic */ C0557e f1489k;

        public C0555b(C0557e c0557e) {
            this.f1489k = c0557e;
            this.f1488j = C0556c.UNINITIALIZED;
        }

        public void m2548a(TimerObject timer) {
            C0556c currentItemState;
            this.f1481c.setShowHundredths(false);
            long timeLeft = timer.m3684a(false);
            this.f1481c.setTimerTime(timeLeft);
            if (timeLeft > 0) {
                long timeLeftPercentage = 0;
                if (timer.m3694d() > 0) {
                    timeLeftPercentage = ((timer.m3694d() - timer.m3701k()) * 8000) / timer.m3694d();
                }
                this.f1480b.setProgress((int) timeLeftPercentage);
                this.f1480b.invalidate();
                currentItemState = C0556c.RUNNING;
            } else {
                this.f1480b.setProgress(8000);
                currentItemState = C0556c.TIME_IS_UP;
                if (currentItemState != this.f1488j) {
                    this.f1489k.f1507o.m2546e(timer);
                }
            }
            if (currentItemState != this.f1488j) {
                m2547a(currentItemState);
            }
        }

        public void m2547a(C0556c viewSetting) {
            if (this.f1489k.f1504l == null || this.f1489k.f1504l.getResources() == null) {
                C0850q.m3987b("resources are null");
            } else if (viewSetting.f1495e == 0) {
                C0850q.m3987b("resourcesId is set to 0");
            } else {
                try {
                    this.f1480b.setProgressDrawable(this.f1489k.f1504l.getResources().getDrawable(viewSetting.f1495e));
                    this.f1481c.setTextColor(this.f1489k.f1504l.getResources().getColor(viewSetting.f1494d));
                    int colorTextButtonId = this.f1489k.f1504l.getResources().getColor(viewSetting.f1496f);
                    this.f1484f.setTextColor(colorTextButtonId);
                    this.f1485g.setTextColor(colorTextButtonId);
                    this.f1487i.setTextColor(colorTextButtonId);
                    this.f1486h.setTextColor(colorTextButtonId);
                    this.f1488j = viewSetting;
                } catch (Exception e) {
                    C0850q.m3984a(e);
                }
            }
        }

        public void m2549a(boolean blinkVisible) {
            this.f1481c.setVisibility(blinkVisible ? 4 : 0);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.e.c */
    public enum C0556c {
        UNINITIALIZED(-1, -1, -1),
        RUNNING(R.color.timer_running_color, R.drawable.selector_button_text_color, R.drawable.timer_progress_bar_horizontal),
        TIME_IS_UP(R.color.warning_orange, R.color.warning_orange, R.drawable.timer_progress_bar_horizontal_time_is_up);
        
        final int f1494d;
        final int f1495e;
        final int f1496f;

        private C0556c(int colorId, int buttonTextColorId, int progressbarDrawableId) {
            this.f1494d = colorId;
            this.f1496f = buttonTextColorId;
            this.f1495e = progressbarDrawableId;
        }
    }

    public C0557e(Context context, C0554a callback) {
        super(context);
        this.f1497a = new C05461(this);
        this.f1498b = new C05472(this);
        this.f1499c = new C05483(this);
        this.f1500d = new C05494(this);
        this.f1501e = new C05505(this);
        this.f1502j = new C05516(this);
        this.f1503k = new C05537(this);
        this.f1505m = -1;
        this.f1504l = context;
        this.f1507o = callback;
    }

    public void m2561a() {
        if (this.f1506n != null) {
            this.f1506n.m4075a(true, true);
        }
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0555b viewHolder;
        int i;
        if (convertView == null) {
            viewHolder = new C0555b(this);
            convertView = LayoutInflater.from(this.f1504l).inflate(R.layout.redesign_list_item_timer_layout, parent, false);
            viewHolder.f1481c = (TimeDisplayBar) convertView.findViewById(R.id.timebar);
            viewHolder.f1482d = (ImageView) convertView.findViewById(R.id.delete_button);
            viewHolder.f1483e = (ViewSwitcher) convertView.findViewById(R.id.timer_switcher);
            viewHolder.f1484f = (TextView) convertView.findViewById(R.id.timer_button_reset);
            viewHolder.f1485g = (TextView) convertView.findViewById(R.id.timer_button_plus_1);
            viewHolder.f1486h = (TextView) convertView.findViewById(R.id.timer_button_play);
            viewHolder.f1487i = (TextView) convertView.findViewById(R.id.timer_button_stop);
            viewHolder.f1480b = (ProgressBar) convertView.findViewById(R.id.timer_progressbar);
            viewHolder.f1479a = (AnimationEditText) convertView.findViewById(R.id.alarmLabel);
        } else {
            viewHolder = (C0555b) convertView.getTag();
        }
        TimerObject timer = (TimerObject) getItem(position);
        viewHolder.f1480b.setMax(8000);
        viewHolder.m2548a(timer);
        if (this.f1505m == -1) {
            convertView.measure(MeasureSpec.makeMeasureSpec(-1, 1073741824), 0);
            this.f1505m = convertView.getMeasuredWidth();
        }
        m2554a(viewHolder.f1479a, timer);
        if (this.f1507o.m2542a(position)) {
            i = R.drawable.alarm_item_type_background_selected;
        } else {
            i = 0;
        }
        convertView.setBackgroundResource(i);
        viewHolder.f1483e.setInAnimation(null);
        viewHolder.f1483e.setOutAnimation(null);
        if (timer.m3698h()) {
            m2552a(viewHolder);
        } else {
            m2556b(viewHolder);
        }
        viewHolder.f1482d.setOnClickListener(this.f1501e);
        viewHolder.f1484f.setOnClickListener(this.f1500d);
        viewHolder.f1485g.setOnClickListener(this.f1499c);
        viewHolder.f1486h.setOnClickListener(this.f1497a);
        viewHolder.f1487i.setOnClickListener(this.f1498b);
        viewHolder.f1484f.setTag(R.id.timeradapter_timer, timer);
        viewHolder.f1485g.setTag(R.id.timeradapter_timer, timer);
        viewHolder.f1486h.setTag(R.id.timeradapter_timer, timer);
        viewHolder.f1487i.setTag(R.id.timeradapter_timer, timer);
        viewHolder.f1482d.setTag(R.id.timeradapter_timer, timer);
        viewHolder.f1482d.setTag(R.id.timeradapter_position, Integer.valueOf(position));
        viewHolder.m2549a(false);
        timer.m3690a(convertView);
        convertView.setTag(viewHolder);
        return convertView;
    }

    private void m2552a(C0555b viewHolder) {
        if (viewHolder.f1483e.getCurrentView().getId() != R.id.timer_buttons_stop) {
            viewHolder.f1483e.showNext();
        }
    }

    private void m2556b(C0555b viewHolder) {
        if (viewHolder.f1483e.getCurrentView().getId() != R.id.timer_buttons_play) {
            viewHolder.f1483e.showPrevious();
        }
    }

    private void m2554a(AnimationEditText editText, TimerObject timer) {
        editText.m4074a(this.f1503k, this.f1502j, this.f1505m);
        if (TextUtils.isEmpty(timer.m3695e())) {
            editText.setHint(R.string.empty_timer_name_hint);
        } else {
            editText.setText(timer.m3695e());
        }
        editText.setTag(timer);
    }
}
