package com.anglelabs.alarmclock.redesign.p020a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.C0483a.C0482b;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.alarm.C0646d;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0518a;
import com.anglelabs.alarmclock.redesign.utils.C0810h;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0815b;
import com.anglelabs.alarmclock.redesign.utils.C0858u;
import com.anglelabs.alarmclock.redesign.utils.C0858u.C0512a;
import com.anglelabs.alarmclock.redesign.utils.ab;
import com.anglelabs.alarmclock.redesign.views.DigitalClock;
import java.util.Calendar;

/* renamed from: com.anglelabs.alarmclock.redesign.a.a */
public class C0536a extends C0518a {
    int f1443a;
    int f1444b;
    private final C0515c f1445c;
    private final Resources f1446d;
    private C0513a f1447e;
    private final ListView f1448j;
    private final C0514b f1449k;

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.1 */
    class C05091 implements OnClickListener {
        final /* synthetic */ RedesignAlarm f1370a;
        final /* synthetic */ C0536a f1371b;

        C05091(C0536a c0536a, RedesignAlarm redesignAlarm) {
            this.f1371b = c0536a;
            this.f1370a = redesignAlarm;
        }

        public void onClick(View v) {
            this.f1371b.f1445c.m2450a(this.f1370a, !this.f1370a.f2012m);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.2 */
    class C05112 implements OnClickListener {
        final /* synthetic */ int f1373a;
        final /* synthetic */ RedesignAlarm f1374b;
        final /* synthetic */ C0536a f1375c;

        /* renamed from: com.anglelabs.alarmclock.redesign.a.a.2.1 */
        class C05101 implements C0482b {
            final /* synthetic */ C05112 f1372a;

            C05101(C05112 c05112) {
                this.f1372a = c05112;
            }

            public boolean m2440a(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.alarm_popup_menu_active:
                        this.f1372a.f1375c.f1445c.m2450a(this.f1372a.f1374b, !this.f1372a.f1374b.f2012m);
                        break;
                    case R.id.alarm_popup_menu_edit:
                        C0830k.m3896a(this.f1372a.f1375c.m2463g(), C0815b.Edit);
                        this.f1372a.f1375c.f1445c.m2449a(this.f1372a.f1374b);
                        break;
                    case R.id.alarm_popup_menu_duplicate:
                        this.f1372a.f1375c.f1445c.m2455e(this.f1372a.f1374b);
                        break;
                    case R.id.alarm_popup_menu_set_default:
                        this.f1372a.f1375c.f1445c.m2454d(this.f1372a.f1374b);
                        break;
                    case R.id.alarm_popup_menu_preview:
                        this.f1372a.f1375c.f1445c.m2453c(this.f1372a.f1374b);
                        break;
                    case R.id.alarm_popup_menu_skip_next:
                        this.f1372a.f1375c.f1445c.m2452b(this.f1372a.f1374b);
                        break;
                    case R.id.alarm_popup_menu_delete:
                        this.f1372a.f1375c.f1445c.m2448a(this.f1372a.f1373a);
                        break;
                }
                return true;
            }
        }

        C05112(C0536a c0536a, int i, RedesignAlarm redesignAlarm) {
            this.f1375c = c0536a;
            this.f1373a = i;
            this.f1374b = redesignAlarm;
        }

        public void onClick(View v) {
            if (!this.f1375c.f1448j.isItemChecked(this.f1373a)) {
                if (v instanceof ImageView) {
                    ((ImageView) v).setImageResource(R.drawable.ic_3menu_active);
                }
                if (this.f1375c.f1447e == null) {
                    this.f1375c.f1447e = new C0513a(this.f1375c);
                }
                this.f1375c.f1443a = this.f1373a;
                this.f1375c.f1447e.m2443a((Object) this.f1374b);
                C0858u.m4025a(this.f1375c.m2463g(), v, R.menu.popup_menu, this.f1375c.f1447e, new C05101(this));
            } else if (this.f1375c.f != null) {
                this.f1375c.f.m3994a(this.f1373a, false);
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.a */
    class C0513a extends C0512a {
        final /* synthetic */ C0536a f1377a;

        C0513a(C0536a c0536a) {
            this.f1377a = c0536a;
        }

        public void m2445a(View v) {
            this.f1377a.f1443a = -1;
            if (v instanceof ImageView) {
                ((ImageView) v).setImageResource(R.drawable.ic_3menu_default);
            }
        }

        public void m2444a(Context context, Menu menu) {
            if (this.b != null) {
                if (((RedesignAlarm) this.b).m3616b(this.f1377a.m2463g()) || ((RedesignAlarm) this.b).m3613a(this.f1377a.m2463g())) {
                    menu.findItem(R.id.alarm_popup_menu_active).setEnabled(false);
                    menu.findItem(R.id.alarm_popup_menu_edit).setEnabled(false);
                    menu.findItem(R.id.alarm_popup_menu_preview).setEnabled(false);
                    menu.findItem(R.id.alarm_popup_menu_skip_next).setEnabled(false);
                    menu.findItem(R.id.alarm_popup_menu_delete).setEnabled(false);
                    return;
                }
                menu.findItem(R.id.alarm_popup_menu_active).setTitle(this.f1377a.m2463g().getString(((RedesignAlarm) this.b).f2012m ? R.string.alarm_popup_disable : R.string.alarm_popup_enable));
                if (!(((RedesignAlarm) this.b).f2005f.m3661c() && ((RedesignAlarm) this.b).f2012m)) {
                    menu.findItem(R.id.alarm_popup_menu_skip_next).setEnabled(false);
                }
                menu.findItem(R.id.alarm_popup_menu_skip_next).setTitle(this.f1377a.m2463g().getString(((RedesignAlarm) this.b).f1990C ? R.string.alarm_popup_unskip_next : R.string.alarm_popup_skip_next));
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.b */
    public interface C0514b {
        void m2446a(RedesignAlarm redesignAlarm, boolean z);

        boolean m2447a();
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.c */
    public interface C0515c {
        void m2448a(int i);

        void m2449a(RedesignAlarm redesignAlarm);

        void m2450a(RedesignAlarm redesignAlarm, boolean z);

        void m2451b(int i);

        void m2452b(RedesignAlarm redesignAlarm);

        void m2453c(RedesignAlarm redesignAlarm);

        void m2454d(RedesignAlarm redesignAlarm);

        void m2455e(RedesignAlarm redesignAlarm);
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.d */
    static class C0516d {
        TextView f1378a;
        View f1379b;
        TextView f1380c;
        TextView f1381d;
        DigitalClock f1382e;
        ViewSwitcher f1383f;
        ImageView f1384g;

        C0516d() {
        }
    }

    public Bundle m2520a(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("open_item_position", this.f1443a);
        return bundle;
    }

    public void m2522b(Bundle bundle) {
        if (bundle != null) {
            this.f1444b = bundle.getInt("open_item_position", -1);
            if (this.f1444b != -1 && this.f1444b > 0 && getCount() > this.f1444b) {
                this.f1445c.m2451b(this.f1444b);
            }
        }
    }

    public C0536a(Context context, ListView list, C0514b callback, C0515c popupController) {
        super(context);
        this.f1443a = -1;
        this.f1444b = -1;
        this.f1448j = list;
        this.f1449k = callback;
        this.f1445c = popupController;
        this.f1446d = context.getResources();
    }

    public void m2521a() {
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0516d holder;
        if (convertView == null) {
            holder = new C0516d();
            convertView = this.g.inflate(R.layout.redesign_list_item_alarm_layout, parent, false);
            holder.f1382e = (DigitalClock) convertView.findViewById(R.id.clock_layout);
            holder.f1379b = convertView.findViewById(R.id.alarmSwitch);
            holder.f1380c = (TextView) convertView.findViewById(R.id.days_of_week);
            holder.f1378a = (TextView) convertView.findViewById(R.id.alarm_label);
            holder.f1384g = (ImageView) convertView.findViewById(R.id.menu_item);
            holder.f1383f = (ViewSwitcher) convertView.findViewById(R.id.snooze_indication_switcher);
            holder.f1381d = (TextView) convertView.findViewById(R.id.snooze_indication);
            convertView.setTag(holder);
        } else {
            holder = (C0516d) convertView.getTag();
        }
        RedesignAlarm alarm = (RedesignAlarm) getItem(position);
        m2504a(convertView, position, alarm);
        m2509c(holder, alarm);
        m2505a(holder, alarm);
        m2513e(holder, alarm);
        m2511d(holder, alarm);
        m2507b(holder, alarm);
        m2503a(position, holder, alarm);
        if (this.f1444b == position) {
            holder.f1384g.performClick();
            this.f1444b = -1;
        }
        return convertView;
    }

    private void m2505a(C0516d holder, RedesignAlarm alarm) {
        switch (holder.f1383f.getCurrentView().getId()) {
            case R.id.alarmSwitch:
                if (alarm.m3616b(m2463g())) {
                    holder.f1381d.setText(m2502a(alarm));
                    holder.f1383f.showNext();
                }
            case R.id.snooze_indication:
                if (!alarm.m3616b(m2463g())) {
                    holder.f1383f.showPrevious();
                    holder.f1381d.setText("");
                }
            default:
        }
    }

    private String m2502a(RedesignAlarm alarm) {
        int timesSnoozed = C0646d.m2975a(m2463g(), alarm.f2010k);
        if (timesSnoozed <= 0) {
            return "";
        }
        if (timesSnoozed == 1) {
            return m2463g().getString(R.string.alarm_times_snoozed_single_with_line_break);
        }
        return m2463g().getString(R.string.alarm_times_snoozed_multiple_with_line_break, new Object[]{Integer.valueOf(timesSnoozed)});
    }

    @SuppressLint({"NewApi"})
    private void m2507b(C0516d holder, RedesignAlarm alarm) {
        holder.f1379b.setBackgroundResource(alarm.f2012m ? R.drawable.ic_alarm_btn_on : R.drawable.ic_alarm_btn_off);
        if (C0810h.f2129c) {
            if (alarm.f1990C) {
                holder.f1379b.setAlpha(0.5f);
            } else if (holder.f1379b.getAlpha() != 1.0f) {
                holder.f1379b.setAlpha(1.0f);
            }
        }
        holder.f1379b.setOnClickListener(new C05091(this, alarm));
    }

    private void m2509c(C0516d holder, RedesignAlarm alarm) {
        TextView textView = holder.f1378a;
        Resources resources = this.f1446d;
        int i = (!alarm.f2012m || alarm.f1990C) ? R.color.white_thirty_alpha : R.color.white_fifty_alpha;
        textView.setTextColor(resources.getColor(i));
        holder.f1378a.setText(!TextUtils.isEmpty(alarm.f2020u) ? alarm.f2020u.toUpperCase(C0810h.m3837b(m2463g())) : "");
    }

    private void m2511d(C0516d holder, RedesignAlarm alarm) {
        int i = R.color.white_seventy_alpha;
        if (alarm.f2005f.m3661c()) {
            boolean isAlarmSkipped;
            if (this.f1449k.m2447a() || alarm.f1990C) {
                isAlarmSkipped = true;
            } else {
                isAlarmSkipped = false;
            }
            holder.f1380c.setText(alarm.f2005f.m3655a(m2463g()));
            holder.f1380c.setCompoundDrawablePadding(ab.m3759a(8, this.f1446d));
            TextView textView = holder.f1380c;
            int i2 = (isAlarmSkipped || !alarm.f2012m) ? R.drawable.ic_alarm_repeat_on_inactive : R.drawable.ic_alarm_repeat_on;
            textView.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
            if (isAlarmSkipped) {
                holder.f1380c.setPaintFlags(holder.f1380c.getPaintFlags() | 16);
                holder.f1380c.setTextColor(this.f1446d.getColor(alarm.f2012m ? R.color.warning_orange_seventy_alpha : R.color.warning_orange_thirty_alpha));
                return;
            }
            TextView textView2 = holder.f1380c;
            Resources resources = this.f1446d;
            if (!alarm.f2012m) {
                i = R.color.white_twenty_alpha;
            }
            textView2.setTextColor(resources.getColor(i));
            holder.f1380c.setPaintFlags(holder.f1380c.getPaintFlags() & -17);
            return;
        }
        String labelText = alarm.m3614a(alarm) ? this.f1446d.getString(R.string.alarm_tomorrow) : this.f1446d.getString(R.string.alarm_today);
        holder.f1380c.setPaintFlags(holder.f1380c.getPaintFlags() & -17);
        TextView textView3 = holder.f1380c;
        Resources resources2 = this.f1446d;
        if (!alarm.f2012m) {
            i = R.color.white_twenty_alpha;
        }
        textView3.setTextColor(resources2.getColor(i));
        holder.f1380c.setCompoundDrawablePadding(0);
        holder.f1380c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        holder.f1380c.setText(labelText);
    }

    private void m2504a(View view, int position, RedesignAlarm alarm) {
        int backgroundResId;
        if (this.f1448j.isItemChecked(position)) {
            backgroundResId = R.drawable.alarm_item_type_background_selected;
        } else {
            backgroundResId = alarm.f2012m ? R.drawable.selector_alarm_list_item : R.drawable.selector_disabled_alarm_list_item;
        }
        view.setBackgroundResource(backgroundResId);
    }

    private void m2513e(C0516d holder, RedesignAlarm alarm) {
        Calendar c = Calendar.getInstance();
        c.set(11, alarm.f2009j);
        c.set(12, alarm.f2023x);
        holder.f1382e.setStaticTime(c);
        DigitalClock digitalClock = holder.f1382e;
        Resources resources = this.f1446d;
        int i = (!alarm.f2012m || alarm.f1990C) ? R.color.white_thirty_alpha : R.color.white;
        digitalClock.setTextColor(resources.getColor(i));
    }

    private void m2503a(int position, C0516d holder, RedesignAlarm alarm) {
        holder.f1384g.setOnClickListener(new C05112(this, position, alarm));
    }
}
