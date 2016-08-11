package com.anglelabs.alarmclock.redesign.p020a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;

/* renamed from: com.anglelabs.alarmclock.redesign.a.c */
public class C0542c extends ArrayAdapter {
    private final int f1466a;
    private final LayoutInflater f1467b;

    /* renamed from: com.anglelabs.alarmclock.redesign.a.c.a */
    public enum C0540a {
        GeneralSetting(R.string.settings_general),
        AlarmDefaultSettings(R.string.settings_alarm),
        TimerDefaultSettings(R.string.settings_timer),
        StopwatchDefaultSettings(R.string.settings_stopwatch);
        
        final int f1464e;

        private C0540a(int stringResId) {
            this.f1464e = stringResId;
        }

        public int m2525a() {
            return this.f1464e;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.c.b */
    static class C0541b {
        TextView f1465a;

        C0541b() {
        }
    }

    public C0542c(Context context) {
        super(context, R.layout.redesign_list_item_title_and_summary, C0540a.values());
        this.f1466a = R.layout.redesign_list_item_title_and_summary;
        this.f1467b = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0541b holder;
        if (convertView == null) {
            convertView = this.f1467b.inflate(this.f1466a, parent, false);
            holder = new C0541b();
            holder.f1465a = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
            convertView.findViewById(R.id.summary).setVisibility(8);
        } else {
            holder = (C0541b) convertView.getTag();
        }
        holder.f1465a.setText(((C0540a) getItem(position)).f1464e);
        return convertView;
    }
}
