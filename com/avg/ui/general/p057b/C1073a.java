package com.avg.ui.general.p057b;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.avg.ui.general.C1091c.C1081e;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import java.util.ArrayList;

/* renamed from: com.avg.ui.general.b.a */
public class C1073a extends BaseAdapter {
    private LayoutInflater f3282a;
    private ArrayList f3283b;

    /* renamed from: com.avg.ui.general.b.a.a */
    public static class C1071a {
        public String f3268a;
        public String f3269b;
        public boolean f3270c;
        public boolean f3271d;
        public int f3272e;
        private boolean f3273f;
        private int f3274g;

        public C1071a(String title, String summary, int id) {
            this.f3268a = title;
            this.f3269b = summary;
            this.f3274g = id;
            this.f3272e = -1;
            this.f3271d = false;
        }
    }

    /* renamed from: com.avg.ui.general.b.a.b */
    public class C1072b {
        public TextView f3275a;
        public TextView f3276b;
        public ImageView f3277c;
        public ImageView f3278d;
        public LinearLayout f3279e;
        public ImageView f3280f;
        final /* synthetic */ C1073a f3281g;

        public C1072b(C1073a c1073a) {
            this.f3281g = c1073a;
        }
    }

    public C1073a(Context context, ArrayList items) {
        this.f3282a = LayoutInflater.from(context);
        this.f3283b = items;
    }

    protected void m4632a(int position, C1071a item, C1072b holder) {
        holder.f3275a.setText(item.f3268a);
        if (item.f3269b == null) {
            holder.f3276b.setVisibility(8);
        } else if (item.f3271d) {
            holder.f3276b.setText(Html.fromHtml(item.f3269b), BufferType.SPANNABLE);
        } else {
            holder.f3276b.setText(item.f3269b);
        }
        holder.f3276b.setVisibility(0);
        if (item.f3269b == null || item.f3269b.equals("")) {
            holder.f3276b.setVisibility(8);
        }
        if (item.f3272e != -1) {
            holder.f3276b.setTextColor(item.f3272e);
        }
        holder.f3277c.setVisibility(0);
        if (item.f3273f) {
            holder.f3277c.setTag(Boolean.valueOf(item.f3270c));
            if (item.f3270c) {
                holder.f3277c.setImageResource(C1081e.btn_check_on);
                return;
            } else {
                holder.f3277c.setImageResource(C1081e.btn_check_off);
                return;
            }
        }
        holder.f3277c.setVisibility(8);
    }

    public int getCount() {
        return this.f3283b == null ? 0 : this.f3283b.size();
    }

    public Object getItem(int position) {
        return this.f3283b == null ? null : (C1071a) this.f3283b.get(position);
    }

    public long getItemId(int position) {
        if (((C1071a) this.f3283b.get(position)).f3274g == -1) {
            return (long) position;
        }
        return (long) ((C1071a) this.f3283b.get(position)).f3274g;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C1072b holder;
        if (convertView == null) {
            convertView = this.f3282a.inflate(C1084h.settings_list_item, null);
            holder = m4631a();
            m4633a(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (C1072b) convertView.getTag();
        }
        m4632a(position, (C1071a) this.f3283b.get(position), holder);
        return convertView;
    }

    protected void m4633a(C1072b holder, View convertView) {
        holder.f3275a = (TextView) convertView.findViewById(C1082f.title);
        holder.f3276b = (TextView) convertView.findViewById(C1082f.summary);
        holder.f3277c = (ImageView) convertView.findViewById(C1082f.check);
        holder.f3278d = (ImageView) convertView.findViewById(C1082f.ll_selection);
        holder.f3279e = (LinearLayout) convertView.findViewById(C1082f.ll_header);
        holder.f3280f = (ImageView) convertView.findViewById(C1082f.list_seperator);
    }

    protected C1072b m4631a() {
        return new C1072b(this);
    }
}
