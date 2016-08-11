package com.anglelabs.alarmclock.redesign.p020a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;

/* renamed from: com.anglelabs.alarmclock.redesign.a.b */
public class C0539b extends ArrayAdapter {
    private final int f1457a;
    private final LayoutInflater f1458b;

    /* renamed from: com.anglelabs.alarmclock.redesign.a.b.a */
    public enum C0537a {
        ONLINE_HELP(R.string.help_online_help_title, R.string.help_online_help_summary),
        CONTACT_US(R.string.help_contact_us_title, R.string.help_contact_us_summary);
        
        private final int f1453c;
        private final int f1454d;

        private C0537a(int titleStringResId, int summaryStringResId) {
            this.f1453c = titleStringResId;
            this.f1454d = summaryStringResId;
        }

        public int m2523a() {
            return this.f1453c;
        }

        public int m2524b() {
            return this.f1454d;
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.b.b */
    static class C0538b {
        TextView f1455a;
        TextView f1456b;

        C0538b() {
        }
    }

    public C0539b(Context context) {
        super(context, R.layout.redesign_list_item_title_and_summary, C0537a.values());
        this.f1457a = R.layout.redesign_list_item_title_and_summary;
        this.f1458b = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0538b holder;
        if (convertView == null) {
            convertView = this.f1458b.inflate(this.f1457a, parent, false);
            holder = new C0538b();
            holder.f1455a = (TextView) convertView.findViewById(R.id.title);
            holder.f1456b = (TextView) convertView.findViewById(R.id.summary);
            convertView.setTag(holder);
        } else {
            holder = (C0538b) convertView.getTag();
        }
        C0537a item = (C0537a) getItem(position);
        holder.f1455a.setText(item.m2523a());
        holder.f1456b.setText(item.m2524b());
        holder.f1456b.setVisibility(0);
        return convertView;
    }
}
