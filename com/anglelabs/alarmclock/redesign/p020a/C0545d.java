package com.anglelabs.alarmclock.redesign.p020a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.model.StopwatchRow;
import com.anglelabs.alarmclock.redesign.p021b.p022b.C0517b;
import com.avg.toolkit.ITKSvc;
import java.util.List;

/* renamed from: com.anglelabs.alarmclock.redesign.a.d */
public class C0545d extends C0517b {

    /* renamed from: com.anglelabs.alarmclock.redesign.a.d.a */
    private static class C0544a {
        ViewGroup f1468a;
        TextView f1469b;
        TextView f1470c;
        TextView f1471d;

        private C0544a() {
        }
    }

    public C0545d(Context context, List data) {
        super(context, data);
    }

    public boolean isEnabled(int position) {
        return false;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        C0544a holder;
        View row = convertView;
        if (row == null) {
            row = this.g.inflate(R.layout.redesign_list_item_stopwatch_layout, parent, false);
            holder = new C0544a();
            holder.f1468a = (ViewGroup) row.findViewById(R.id.stopwatch_item_row);
            holder.f1469b = (TextView) row.findViewById(R.id.stopwatch_item_row_number);
            holder.f1470c = (TextView) row.findViewById(R.id.stopwatch_item_lap_time);
            holder.f1471d = (TextView) row.findViewById(R.id.stopwatch_item_total_time);
            row.setTag(holder);
        } else {
            holder = (C0544a) row.getTag();
        }
        int positionFromLast = getCount() - position;
        if (positionFromLast % 2 == 0) {
            holder.f1468a.setBackgroundColor(0);
        } else {
            holder.f1468a.setBackgroundResource(R.color.half_transpernt_button_color);
        }
        StopwatchRow stopwatchRow = (StopwatchRow) getItem(position);
        if (positionFromLast < 10) {
            holder.f1469b.setText(ITKSvc.CODEREVISION + positionFromLast);
        } else {
            holder.f1469b.setText(Integer.toString(positionFromLast));
        }
        holder.f1470c.setText(stopwatchRow.f2033a);
        holder.f1471d.setText(stopwatchRow.f2034b);
        return row;
    }
}
