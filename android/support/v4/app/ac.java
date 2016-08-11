package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.C0124x.C0103a;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.google.android.gms.cast.Cast;
import java.util.ArrayList;
import java.util.List;

class ac {

    /* renamed from: android.support.v4.app.ac.a */
    public static class C0045a implements C0042s, C0043t {
        private Builder f116a;
        private Bundle f117b;
        private List f118c;

        public C0045a(Context context, Notification n, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, RemoteViews tickerView, int number, PendingIntent contentIntent, PendingIntent fullScreenIntent, Bitmap largeIcon, int progressMax, int progress, boolean progressIndeterminate, boolean showWhen, boolean useChronometer, int priority, CharSequence subText, boolean localOnly, ArrayList people, Bundle extras, String groupKey, boolean groupSummary, String sortKey) {
            boolean z;
            this.f118c = new ArrayList();
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
            this.f116a = lights.setFullScreenIntent(fullScreenIntent, z).setLargeIcon(largeIcon).setNumber(number).setUsesChronometer(useChronometer).setPriority(priority).setProgress(progressMax, progress, progressIndeterminate);
            this.f117b = new Bundle();
            if (extras != null) {
                this.f117b.putAll(extras);
            }
            if (!(people == null || people.isEmpty())) {
                this.f117b.putStringArray("android.people", (String[]) people.toArray(new String[people.size()]));
            }
            if (localOnly) {
                this.f117b.putBoolean("android.support.localOnly", true);
            }
            if (groupKey != null) {
                this.f117b.putString("android.support.groupKey", groupKey);
                if (groupSummary) {
                    this.f117b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f117b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (sortKey != null) {
                this.f117b.putString("android.support.sortKey", sortKey);
            }
        }

        public void m151a(C0103a action) {
            this.f118c.add(ab.m144a(this.f116a, action));
        }

        public Builder m150a() {
            return this.f116a;
        }

        public Notification m152b() {
            SparseArray actionExtrasMap = ab.m146a(this.f118c);
            if (actionExtrasMap != null) {
                this.f117b.putSparseParcelableArray("android.support.actionExtras", actionExtrasMap);
            }
            this.f116a.setExtras(this.f117b);
            return this.f116a.build();
        }
    }
}
