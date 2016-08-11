package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

/* renamed from: android.support.v4.app.y */
class C0125y {
    public static Notification m494a(Notification notification, Context context, CharSequence contentTitle, CharSequence contentText, PendingIntent contentIntent, PendingIntent fullScreenIntent) {
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        notification.fullScreenIntent = fullScreenIntent;
        return notification;
    }
}
