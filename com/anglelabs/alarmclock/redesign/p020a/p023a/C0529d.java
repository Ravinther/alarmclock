package com.anglelabs.alarmclock.redesign.p020a.p023a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0687c.C0686a;

/* renamed from: com.anglelabs.alarmclock.redesign.a.a.d */
public class C0529d extends C0520a {
    private boolean f1419e;

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.d.1 */
    class C05271 implements OnClickListener {
        final /* synthetic */ C0528a f1412a;
        final /* synthetic */ int f1413b;
        final /* synthetic */ C0529d f1414c;

        C05271(C0529d c0529d, C0528a c0528a, int i) {
            this.f1414c = c0529d;
            this.f1412a = c0528a;
            this.f1413b = i;
        }

        public void onClick(View v) {
            if (this.f1414c.f1419e) {
                this.f1414c.m2473a("");
                this.f1412a.f1415a.setChecked(false);
                this.f1414c.f1419e = false;
            } else {
                this.f1412a.f1415a.setChecked(!this.f1412a.f1415a.isChecked());
            }
            this.f1414c.m2478c().clear();
            this.f1414c.m2475a(this.f1413b);
            this.f1414c.notifyDataSetChanged();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.d.a */
    static class C0528a {
        CompoundButton f1415a;
        TextView f1416b;
        TextView f1417c;
        ViewGroup f1418d;

        C0528a() {
        }
    }

    public C0529d(Context context) {
        super(context);
    }

    boolean m2488b() {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0528a holder;
        boolean isChecked;
        if (convertView == null) {
            convertView = this.c.inflate(R.layout.redesign_list_item_choose_playlist, parent, false);
            holder = new C0528a();
            holder.f1415a = (CompoundButton) convertView.findViewById(R.id.playlist_checked_item);
            holder.f1416b = (TextView) convertView.findViewById(R.id.playlist_name);
            holder.f1417c = (TextView) convertView.findViewById(R.id.playlist_songs_count);
            holder.f1418d = (ViewGroup) convertView.findViewById(R.id.checkbox_container);
            convertView.setTag(holder);
        } else {
            holder = (C0528a) convertView.getTag();
        }
        C0686a item = (C0686a) getItem(position);
        holder.f1416b.setText(item.f1785b);
        holder.f1417c.setText(m2463g().getString(R.string.choose_playlist_item_songs, new Object[]{Integer.valueOf(item.f1786c)}));
        holder.f1415a.setTag(item);
        if (this.a == null || !this.a.contains(item)) {
            isChecked = false;
        } else {
            isChecked = true;
        }
        if (isChecked) {
            holder.f1415a.setChecked(true);
        } else if (m2477b(item.f1785b)) {
            holder.f1415a.setChecked(true);
            this.a.clear();
            this.f1419e = true;
            m2475a(position);
        } else {
            holder.f1415a.setChecked(false);
        }
        holder.f1418d.setOnClickListener(new C05271(this, holder, position));
        return convertView;
    }
}
