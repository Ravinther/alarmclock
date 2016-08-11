package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Action;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.C0124x.C0103a;
import android.widget.RemoteViews;
import com.google.android.gms.cast.Cast;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.v */
class C0121v {

    /* renamed from: android.support.v4.app.v.a */
    public static class C0120a implements C0042s, C0043t {
        private Builder f331a;
        private Bundle f332b;

        public C0120a(Context context, Notification n, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, RemoteViews tickerView, int number, PendingIntent contentIntent, PendingIntent fullScreenIntent, Bitmap largeIcon, int progressMax, int progress, boolean progressIndeterminate, boolean showWhen, boolean useChronometer, int priority, CharSequence subText, boolean localOnly, ArrayList people, Bundle extras, String groupKey, boolean groupSummary, String sortKey) {
            boolean z;
            Builder lights = new Builder(context).setWhen(n.when).setShowWhen(showWhen).setSmallIcon(n.icon, n.iconLevel).setContent(n.contentView).setTicker(n.tickerText, tickerView).setSound(n.sound, n.audioStreamType).setVibrate(n.vibrate).setLights(n.ledARGB, n.ledOnMS, n.ledOffMS);
            if ((n.flags & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            lights = lights.setOngoing(z);
            if ((n.flags & 8) != 0) {
                z = true;
            } else {
                z = false;
            }
            lights = lights.setOnlyAlertOnce(z);
            if ((n.flags & 16) != 0) {
                z = true;
            } else {
                z = false;
            }
            lights = lights.setAutoCancel(z).setDefaults(n.defaults).setContentTitle(contentTitle).setContentText(contentText).setSubText(subText).setContentInfo(contentInfo).setContentIntent(contentIntent).setDeleteIntent(n.deleteIntent);
            if ((n.flags & Cast.MAX_NAMESPACE_LENGTH) != 0) {
                z = true;
            } else {
                z = false;
            }
            this.f331a = lights.setFullScreenIntent(fullScreenIntent, z).setLargeIcon(largeIcon).setNumber(number).setUsesChronometer(useChronometer).setPriority(priority).setProgress(progressMax, progress, progressIndeterminate).setLocalOnly(localOnly).setGroup(groupKey).setGroupSummary(groupSummary).setSortKey(sortKey);
            this.f332b = new Bundle();
            if (extras != null) {
                this.f332b.putAll(extras);
            }
            if (people != null && !people.isEmpty()) {
                this.f332b.putStringArray("android.people", (String[]) people.toArray(new String[people.size()]));
            }
        }

        public void m488a(C0103a action) {
            C0121v.m490a(this.f331a, action);
        }

        public Builder m487a() {
            return this.f331a;
        }

        public Notification m489b() {
            this.f331a.setExtras(this.f332b);
            return this.f331a.build();
        }
    }

    public static void m490a(Builder b, C0103a action) {
        Action.Builder actionBuilder = new Action.Builder(action.m446a(), action.m447b(), action.m448c());
        if (action.m450f() != null) {
            for (RemoteInput remoteInput : ae.m163a(action.m450f())) {
                actionBuilder.addRemoteInput(remoteInput);
            }
        }
        if (action.m449d() != null) {
            actionBuilder.addExtras(action.m449d());
        }
        b.addAction(actionBuilder.build());
    }
}
