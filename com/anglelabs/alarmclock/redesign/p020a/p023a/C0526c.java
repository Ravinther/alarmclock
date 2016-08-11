package com.anglelabs.alarmclock.redesign.p020a.p023a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0685b.C0684a;

/* renamed from: com.anglelabs.alarmclock.redesign.a.a.c */
public class C0526c extends C0520a {
    private boolean f1411e;

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.c.1 */
    class C05241 implements OnClickListener {
        final /* synthetic */ C0525a f1404a;
        final /* synthetic */ int f1405b;
        final /* synthetic */ C0526c f1406c;

        C05241(C0526c c0526c, C0525a c0525a, int i) {
            this.f1406c = c0526c;
            this.f1404a = c0525a;
            this.f1405b = i;
        }

        public void onClick(View v) {
            if (this.f1406c.f1411e) {
                this.f1406c.m2473a("");
                this.f1404a.f1407a.setChecked(false);
                this.f1406c.f1411e = false;
            } else {
                this.f1404a.f1407a.setChecked(!this.f1404a.f1407a.isChecked());
            }
            this.f1406c.m2478c().clear();
            this.f1406c.m2475a(this.f1405b);
            this.f1406c.notifyDataSetChanged();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.c.a */
    static class C0525a {
        CompoundButton f1407a;
        TextView f1408b;
        TextView f1409c;
        ViewGroup f1410d;

        C0525a() {
        }
    }

    public C0526c(Context context) {
        super(context);
    }

    boolean m2485b() {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0525a holder;
        boolean isChecked;
        if (convertView == null) {
            convertView = this.c.inflate(R.layout.redesign_list_item_choose_playlist, parent, false);
            holder = new C0525a();
            holder.f1407a = (CompoundButton) convertView.findViewById(R.id.playlist_checked_item);
            holder.f1408b = (TextView) convertView.findViewById(R.id.playlist_name);
            holder.f1409c = (TextView) convertView.findViewById(R.id.playlist_songs_count);
            holder.f1410d = (ViewGroup) convertView.findViewById(R.id.checkbox_container);
            convertView.setTag(holder);
        } else {
            holder = (C0525a) convertView.getTag();
        }
        C0684a item = (C0684a) getItem(position);
        holder.f1408b.setText(item.f1779a);
        holder.f1409c.setText(item.m3115a(m2463g()));
        holder.f1407a.setTag(item);
        if (this.a == null || !this.a.contains(item)) {
            isChecked = false;
        } else {
            isChecked = true;
        }
        if (isChecked) {
            holder.f1407a.setChecked(true);
        } else if (m2477b(item.f1779a)) {
            holder.f1407a.setChecked(true);
            this.a.clear();
            this.f1411e = true;
            m2475a(position);
        } else {
            holder.f1407a.setChecked(false);
        }
        holder.f1410d.setOnClickListener(new C05241(this, holder, position));
        return convertView;
    }
}
