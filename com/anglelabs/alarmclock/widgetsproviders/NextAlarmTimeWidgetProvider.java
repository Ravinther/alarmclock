package com.anglelabs.alarmclock.widgetsproviders;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.RemoteViews;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.utils.C0832m;
import com.anglelabs.alarmclock.redesign.utils.ac;

public class NextAlarmTimeWidgetProvider extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.next_alarm_time_widget);
            views.setOnClickPendingIntent(R.id.next_alarm_time_widget, C0832m.m3941p(context));
            SharedPreferences prefs = ac.m3774b(context);
            String nextAlarmTime = prefs.getString("next_alarm_time", "");
            if ("".equals(nextAlarmTime)) {
                views.setImageViewResource(R.id.next_alarm_time_pic, R.drawable.stat_notify_alarm_set_smaller_strike);
                views.setTextViewText(R.id.next_alarm_time_text, "");
            } else {
                if (prefs.getBoolean("skip_next", false)) {
                    views.setImageViewResource(R.id.next_alarm_time_pic, R.drawable.stat_notify_alarm_set_smaller_strike);
                } else {
                    views.setImageViewResource(R.id.next_alarm_time_pic, R.drawable.stat_notify_alarm_set_smaller);
                }
                views.setTextViewText(R.id.next_alarm_time_text, nextAlarmTime);
            }
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
