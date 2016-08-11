package com.anglelabs.alarmclock.redesign.p020a.p023a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0689d.C0688a;
import java.util.ArrayList;

/* renamed from: com.anglelabs.alarmclock.redesign.a.a.e */
public class C0532e extends C0520a {
    ArrayList f1427e;
    private long f1428j;
    private boolean f1429k;

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.e.1 */
    class C05301 implements OnClickListener {
        final /* synthetic */ C0531a f1420a;
        final /* synthetic */ int f1421b;
        final /* synthetic */ C0532e f1422c;

        C05301(C0532e c0532e, C0531a c0531a, int i) {
            this.f1422c = c0532e;
            this.f1420a = c0531a;
            this.f1421b = i;
        }

        public void onClick(View v) {
            if (this.f1422c.f1429k) {
                this.f1422c.m2473a("");
                this.f1420a.f1423a.setChecked(false);
                this.f1422c.f1429k = false;
            } else {
                this.f1420a.f1423a.setChecked(!this.f1420a.f1423a.isChecked());
            }
            this.f1422c.a.clear();
            this.f1422c.m2475a(this.f1421b);
            this.f1422c.notifyDataSetChanged();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.e.a */
    static class C0531a {
        CompoundButton f1423a;
        TextView f1424b;
        ViewGroup f1425c;
        View f1426d;

        C0531a() {
        }
    }

    public C0532e(Context context) {
        super(context);
        this.f1427e = new ArrayList();
    }

    boolean m2492b() {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0531a holder;
        boolean isChecked;
        if (convertView == null) {
            convertView = this.c.inflate(R.layout.redesign_list_item_ringtone_layout, parent, false);
            holder = new C0531a();
            holder.f1423a = (CompoundButton) convertView.findViewById(R.id.playlist_checked_item);
            holder.f1424b = (TextView) convertView.findViewById(R.id.playlist_name);
            holder.f1425c = (ViewGroup) convertView.findViewById(R.id.checkbox_container);
            holder.f1426d = convertView.findViewById(R.id.vertical_divider);
            convertView.setTag(holder);
        } else {
            holder = (C0531a) convertView.getTag();
        }
        C0688a item = (C0688a) getItem(position);
        holder.f1424b.setText(item.f1788a);
        if (item.f1789b == this.f1428j) {
            convertView.setBackgroundResource(R.color.half_transpernt_button_color);
        } else {
            convertView.setBackgroundColor(0);
        }
        holder.f1423a.setTag(item);
        if (this.a == null || !this.a.contains(item)) {
            isChecked = false;
        } else {
            isChecked = true;
        }
        if (isChecked) {
            holder.f1423a.setChecked(true);
        } else if (m2477b(item.f1788a)) {
            holder.f1423a.setChecked(true);
            this.a.clear();
            this.f1429k = true;
            m2475a(position);
        } else {
            holder.f1423a.setChecked(false);
        }
        holder.f1425c.setOnClickListener(new C05301(this, holder, position));
        return convertView;
    }

    public void m2491a(long playedSongId) {
        this.f1428j = playedSongId;
        notifyDataSetChanged();
    }
}
