package com.alarmclock.xtreme.free;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import com.anglelabs.alarmclock.redesign.utils.C0832m;

public class AnalogAppWidgetProvider extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        int N = appWidgetIds.length;
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.analog_appwidget);
            views.setOnClickPendingIntent(R.id.analog_appwidget, C0832m.m3942q(context));
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
