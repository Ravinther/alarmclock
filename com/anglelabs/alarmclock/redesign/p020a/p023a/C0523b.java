package com.anglelabs.alarmclock.redesign.p020a.p023a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0683a.C0681a;

/* renamed from: com.anglelabs.alarmclock.redesign.a.a.b */
public class C0523b extends C0520a {
    private boolean f1403e;

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.b.1 */
    class C05211 implements OnClickListener {
        final /* synthetic */ C0522a f1395a;
        final /* synthetic */ int f1396b;
        final /* synthetic */ C0523b f1397c;

        C05211(C0523b c0523b, C0522a c0522a, int i) {
            this.f1397c = c0523b;
            this.f1395a = c0522a;
            this.f1396b = i;
        }

        public void onClick(View v) {
            if (this.f1397c.f1403e) {
                this.f1397c.m2473a("");
                this.f1395a.f1398a.setChecked(false);
                this.f1397c.f1403e = false;
            } else {
                this.f1395a.f1398a.setChecked(!this.f1395a.f1398a.isChecked());
            }
            this.f1397c.m2478c().clear();
            this.f1397c.m2475a(this.f1396b);
            this.f1397c.notifyDataSetChanged();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.b.a */
    static class C0522a {
        CompoundButton f1398a;
        TextView f1399b;
        ImageView f1400c;
        ViewGroup f1401d;
        View f1402e;

        C0522a() {
        }
    }

    public C0523b(Context context) {
        super(context);
    }

    boolean m2482b() {
        return false;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0522a holder;
        boolean isChecked;
        if (convertView == null || convertView.getTag() == null) {
            holder = new C0522a();
            convertView = this.c.inflate(R.layout.redesign_list_item_ringtone_layout, parent, false);
            holder.f1398a = (CompoundButton) convertView.findViewById(R.id.playlist_checked_item);
            holder.f1399b = (TextView) convertView.findViewById(R.id.playlist_name);
            holder.f1400c = (ImageView) convertView.findViewById(R.id.item_icon);
            holder.f1401d = (ViewGroup) convertView.findViewById(R.id.checkbox_container);
            holder.f1402e = convertView.findViewById(R.id.vertical_divider);
            convertView.setTag(holder);
        } else {
            holder = (C0522a) convertView.getTag();
        }
        C0681a item = (C0681a) getItem(position);
        holder.f1400c.setImageDrawable(item.m3109d());
        holder.f1400c.setVisibility(0);
        holder.f1399b.setText(item.m3107b());
        if (this.a == null || !this.a.contains(item)) {
            isChecked = false;
        } else {
            isChecked = true;
        }
        if (isChecked) {
            holder.f1398a.setChecked(true);
        } else if (m2477b(item.m3107b())) {
            this.f1403e = true;
            holder.f1398a.setChecked(true);
            this.a.clear();
            m2475a(position);
        } else {
            holder.f1398a.setChecked(false);
        }
        holder.f1401d.setOnClickListener(new C05211(this, holder, position));
        return convertView;
    }
}
