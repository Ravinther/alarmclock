package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.Notification.InboxStyle;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.C0124x.C0103a;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.google.android.gms.cast.Cast;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ab {
    private static final Object f112a;
    private static Field f113b;
    private static boolean f114c;
    private static final Object f115d;

    /* renamed from: android.support.v4.app.ab.a */
    public static class C0044a implements C0042s, C0043t {
        private Builder f109a;
        private final Bundle f110b;
        private List f111c;

        public C0044a(Context context, Notification n, CharSequence contentTitle, CharSequence contentText, CharSequence contentInfo, RemoteViews tickerView, int number, PendingIntent contentIntent, PendingIntent fullScreenIntent, Bitmap largeIcon, int progressMax, int progress, boolean progressIndeterminate, boolean useChronometer, int priority, CharSequence subText, boolean localOnly, Bundle extras, String groupKey, boolean groupSummary, String sortKey) {
            boolean z;
            this.f111c = new ArrayList();
            Builder lights = new Builder(context).setWhen(n.when).setSmallIcon(n.icon, n.iconLevel).setContent(n.contentView).setTicker(n.tickerText, tickerView).setSound(n.sound, n.audioStreamType).setVibrate(n.vibrate).setLights(n.ledARGB, n.ledOnMS, n.ledOffMS);
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
            this.f109a = lights.setFullScreenIntent(fullScreenIntent, z).setLargeIcon(largeIcon).setNumber(number).setUsesChronometer(useChronometer).setPriority(priority).setProgress(progressMax, progress, progressIndeterminate);
            this.f110b = new Bundle();
            if (extras != null) {
                this.f110b.putAll(extras);
            }
            if (localOnly) {
                this.f110b.putBoolean("android.support.localOnly", true);
            }
            if (groupKey != null) {
                this.f110b.putString("android.support.groupKey", groupKey);
                if (groupSummary) {
                    this.f110b.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f110b.putBoolean("android.support.useSideChannel", true);
                }
            }
            if (sortKey != null) {
                this.f110b.putString("android.support.sortKey", sortKey);
            }
        }

        public void m142a(C0103a action) {
            this.f111c.add(ab.m144a(this.f109a, action));
        }

        public Builder m141a() {
            return this.f109a;
        }

        public Notification m143b() {
            Notification notif = this.f109a.build();
            Bundle extras = ab.m145a(notif);
            Bundle mergeBundle = new Bundle(this.f110b);
            for (String key : this.f110b.keySet()) {
                if (extras.containsKey(key)) {
                    mergeBundle.remove(key);
                }
            }
            extras.putAll(mergeBundle);
            SparseArray actionExtrasMap = ab.m146a(this.f111c);
            if (actionExtrasMap != null) {
                ab.m145a(notif).putSparseParcelableArray("android.support.actionExtras", actionExtrasMap);
            }
            return notif;
        }
    }

    static {
        f112a = new Object();
        f115d = new Object();
    }

    public static void m148a(C0043t b, CharSequence bigContentTitle, boolean useSummary, CharSequence summaryText, CharSequence bigText) {
        BigTextStyle style = new BigTextStyle(b.m140a()).setBigContentTitle(bigContentTitle).bigText(bigText);
        if (useSummary) {
            style.setSummaryText(summaryText);
        }
    }

    public static void m147a(C0043t b, CharSequence bigContentTitle, boolean useSummary, CharSequence summaryText, Bitmap bigPicture, Bitmap bigLargeIcon, boolean bigLargeIconSet) {
        BigPictureStyle style = new BigPictureStyle(b.m140a()).setBigContentTitle(bigContentTitle).bigPicture(bigPicture);
        if (bigLargeIconSet) {
            style.bigLargeIcon(bigLargeIcon);
        }
        if (useSummary) {
            style.setSummaryText(summaryText);
        }
    }

    public static void m149a(C0043t b, CharSequence bigContentTitle, boolean useSummary, CharSequence summaryText, ArrayList texts) {
        InboxStyle style = new InboxStyle(b.m140a()).setBigContentTitle(bigContentTitle);
        if (useSummary) {
            style.setSummaryText(summaryText);
        }
        Iterator i$ = texts.iterator();
        while (i$.hasNext()) {
            style.addLine((CharSequence) i$.next());
        }
    }

    public static SparseArray m146a(List actionExtrasList) {
        SparseArray actionExtrasMap = null;
        int count = actionExtrasList.size();
        for (int i = 0; i < count; i++) {
            Bundle actionExtras = (Bundle) actionExtrasList.get(i);
            if (actionExtras != null) {
                if (actionExtrasMap == null) {
                    actionExtrasMap = new SparseArray();
                }
                actionExtrasMap.put(i, actionExtras);
            }
        }
        return actionExtrasMap;
    }

    public static Bundle m145a(Notification notif) {
        synchronized (f112a) {
            if (f114c) {
                return null;
            }
            try {
                if (f113b == null) {
                    Field extrasField = Notification.class.getDeclaredField("extras");
                    if (Bundle.class.isAssignableFrom(extrasField.getType())) {
                        extrasField.setAccessible(true);
                        f113b = extrasField;
                    } else {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f114c = true;
                        return null;
                    }
                }
                Bundle bundle = (Bundle) f113b.get(notif);
                if (bundle == null) {
                    bundle = new Bundle();
                    f113b.set(notif, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                Log.e("NotificationCompat", "Unable to access notification extras", e);
                f114c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f114c = true;
                return null;
            }
        }
    }

    public static Bundle m144a(Builder builder, C0103a action) {
        builder.addAction(action.m446a(), action.m447b(), action.m448c());
        Bundle actionExtras = new Bundle(action.m449d());
        if (action.m450f() != null) {
            actionExtras.putParcelableArray("android.support.remoteInputs", ag.m165a(action.m450f()));
        }
        return actionExtras;
    }
}
