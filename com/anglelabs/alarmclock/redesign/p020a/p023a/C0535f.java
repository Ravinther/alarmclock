package com.anglelabs.alarmclock.redesign.p020a.p023a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0691e.C0690a;
import com.anglelabs.alarmclock.redesign.utils.C0854s;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.a.a.f */
public class C0535f extends C0520a {
    private boolean f1438e;
    private boolean f1439j;
    private long f1440k;
    private boolean f1441l;
    private boolean f1442m;

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.f.1 */
    class C05331 implements OnClickListener {
        final /* synthetic */ C0534a f1430a;
        final /* synthetic */ int f1431b;
        final /* synthetic */ C0535f f1432c;

        C05331(C0535f c0535f, C0534a c0534a, int i) {
            this.f1432c = c0535f;
            this.f1430a = c0534a;
            this.f1431b = i;
        }

        public void onClick(View v) {
            if (this.f1432c.f1442m) {
                this.f1432c.m2473a("");
                this.f1430a.f1433a.setChecked(false);
                this.f1432c.f1442m = false;
            } else {
                this.f1430a.f1433a.setChecked(!this.f1430a.f1433a.isChecked());
            }
            if (!this.f1432c.f1441l) {
                this.f1432c.a.clear();
            }
            this.f1432c.m2475a(this.f1431b);
            this.f1432c.notifyDataSetChanged();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.a.a.f.a */
    static class C0534a {
        CompoundButton f1433a;
        TextView f1434b;
        TextView f1435c;
        ViewGroup f1436d;
        View f1437e;

        C0534a() {
        }
    }

    public C0535f(Context context, int mode, boolean selectAllItem) {
        boolean z = true;
        super(context);
        this.f1438e = selectAllItem;
        boolean z2;
        if (mode == 1 || mode == 2 || mode != 0) {
            if (mode != 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f1441l = z2;
            if (mode == 0) {
                z = false;
            }
            this.f1439j = z;
        }
        if (mode != 2) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f1441l = z2;
        if (mode == 0) {
            z = false;
        }
        this.f1439j = z;
    }

    public void m2497b(List items) {
        super.m2468b(items);
        if (this.f1438e) {
            this.a = new ArrayList(m2464h());
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0534a holder;
        if (convertView == null) {
            convertView = this.c.inflate(R.layout.redesign_list_item_choose_playlist, parent, false);
            holder = new C0534a();
            holder.f1433a = (CompoundButton) convertView.findViewById(R.id.playlist_checked_item);
            holder.f1434b = (TextView) convertView.findViewById(R.id.playlist_name);
            holder.f1435c = (TextView) convertView.findViewById(R.id.playlist_songs_count);
            holder.f1436d = (ViewGroup) convertView.findViewById(R.id.checkbox_container);
            holder.f1437e = convertView.findViewById(R.id.vertical_divider);
            convertView.setTag(holder);
        } else {
            holder = (C0534a) convertView.getTag();
        }
        C0690a item = (C0690a) getItem(position);
        holder.f1434b.setText(item.f1793b);
        holder.f1435c.setText("Length: " + C0854s.m4005a(item.f1795d));
        if (item.f1792a == this.f1440k) {
            convertView.setBackgroundResource(R.color.half_transpernt_button_color);
        } else {
            convertView.setBackgroundColor(0);
        }
        if (this.f1439j) {
            boolean isChecked;
            holder.f1437e.setVisibility(0);
            holder.f1433a.setVisibility(0);
            holder.f1433a.setTag(item);
            if (this.a == null || !this.a.contains(item)) {
                isChecked = false;
            } else {
                isChecked = true;
            }
            if (isChecked) {
                holder.f1433a.setChecked(true);
            } else if (m2477b(item.f1793b)) {
                holder.f1433a.setChecked(true);
                this.f1442m = true;
                if (!this.f1441l) {
                    this.a.clear();
                }
                m2475a(position);
            } else {
                holder.f1433a.setChecked(false);
            }
            holder.f1436d.setOnClickListener(new C05331(this, holder, position));
        } else {
            holder.f1433a.setVisibility(8);
            holder.f1437e.setVisibility(8);
        }
        return convertView;
    }

    public void m2496a(long playedSongId) {
        this.f1440k = playedSongId;
        notifyDataSetChanged();
    }

    public long m2499e() {
        return this.f1440k;
    }

    boolean m2498b() {
        return this.f1441l;
    }
}
