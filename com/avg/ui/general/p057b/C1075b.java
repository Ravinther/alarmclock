package com.avg.ui.general.p057b;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;

/* renamed from: com.avg.ui.general.b.b */
public class C1075b extends ArrayAdapter {
    boolean f3288a;
    boolean f3289b;
    private String[] f3290c;
    private LayoutInflater f3291d;
    private int f3292e;

    /* renamed from: com.avg.ui.general.b.b.a */
    class C1074a {
        TextView f3284a;
        RadioButton f3285b;
        View f3286c;
        final /* synthetic */ C1075b f3287d;

        C1074a(C1075b c1075b) {
            this.f3287d = c1075b;
        }
    }

    public /* synthetic */ Object getItem(int x0) {
        return m4634a(x0);
    }

    public C1075b(Context context, int selectedIdx, String[] items) {
        super(context, 17367055, 16908308, items);
        this.f3290c = items;
        this.f3291d = LayoutInflater.from(context);
        this.f3292e = selectedIdx;
        this.f3288a = true;
        this.f3289b = true;
    }

    public C1075b(Context context, int selectedIdx, boolean showRadioButton, String[] items) {
        this(context, selectedIdx, items);
        this.f3288a = showRadioButton;
        this.f3289b = true;
    }

    public int getCount() {
        if (this.f3290c != null) {
            return this.f3290c.length;
        }
        return 0;
    }

    public String m4634a(int idx) {
        if (this.f3290c != null) {
            return this.f3290c[idx];
        }
        return null;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public int getItemViewType(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (VERSION.SDK_INT >= 11) {
            return super.getView(position, convertView, parent);
        }
        C1074a holder;
        if (convertView == null) {
            convertView = this.f3291d.inflate(C1084h.dialog_list_item, null);
            holder = new C1074a(this);
            holder.f3284a = (TextView) convertView.findViewById(C1082f.textView);
            holder.f3285b = (RadioButton) convertView.findViewById(C1082f.radioButton);
            holder.f3286c = convertView.findViewById(C1082f.separator);
            convertView.setTag(holder);
        } else {
            holder = (C1074a) convertView.getTag();
        }
        holder.f3284a.setText(this.f3290c[position]);
        holder.f3286c.setVisibility(8);
        if (this.f3288a) {
            holder.f3285b.setVisibility(0);
            if (position == this.f3292e) {
                holder.f3285b.setChecked(true);
            }
        } else {
            holder.f3285b.setVisibility(8);
        }
        if (this.f3289b && position == 0 && VERSION.SDK_INT < 11) {
            holder.f3286c.setVisibility(0);
        }
        return convertView;
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public void registerDataSetObserver(DataSetObserver observer) {
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
    }

    public boolean areAllItemsEnabled() {
        return true;
    }

    public boolean isEnabled(int position) {
        return true;
    }
}
