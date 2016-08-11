package com.google.android.p052a;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.a.a */
public abstract class C0984a extends IntentService {
    private static WakeLock f2956a;
    private static final Object f2957b;
    private static int f2958d;
    private static final Random f2959e;
    private static final int f2960f;
    private static final String f2961g;
    private final String[] f2962c;

    protected abstract void m4369a(Context context, Intent intent);

    protected abstract void m4370a(Context context, String str);

    protected abstract void m4372b(Context context, String str);

    protected abstract void m4373c(Context context, String str);

    static {
        f2957b = C0984a.class;
        f2958d = 0;
        f2959e = new Random();
        f2960f = (int) TimeUnit.SECONDS.toMillis(3600);
        f2961g = Long.toBinaryString(f2959e.nextLong());
    }

    protected C0984a() {
        this(C0984a.m4364a("DynamicSenderIds"), null);
    }

    protected C0984a(String... senderIds) {
        this(C0984a.m4365a(senderIds), senderIds);
    }

    private C0984a(String name, String[] senderIds) {
        super(name);
        this.f2962c = senderIds;
    }

    private static String m4364a(String senderId) {
        StringBuilder append = new StringBuilder().append("GCMIntentService-").append(senderId).append("-");
        int i = f2958d + 1;
        f2958d = i;
        String name = append.append(i).toString();
        Log.v("GCMBaseIntentService", "Intent service name: " + name);
        return name;
    }

    private static String m4365a(String[] senderIds) {
        return C0984a.m4364a(C1335c.m5852a(senderIds));
    }

    protected String[] m4371a(Context context) {
        if (this.f2962c != null) {
            return this.f2962c;
        }
        throw new IllegalStateException("sender id not set on constructor");
    }

    protected void m4368a(Context context, int total) {
    }

    protected boolean m4374d(Context context, String errorId) {
        return true;
    }

    public final void onHandleIntent(Intent intent) {
        String sTotal;
        try {
            Context context = getApplicationContext();
            String action = intent.getAction();
            if (action.equals("com.google.android.c2dm.intent.REGISTRATION")) {
                C1335c.m5861d(context);
                m4367b(context, intent);
            } else if (action.equals("com.google.android.c2dm.intent.RECEIVE")) {
                String messageType = intent.getStringExtra("message_type");
                if (messageType == null) {
                    m4369a(context, intent);
                } else if (messageType.equals(GoogleCloudMessaging.MESSAGE_TYPE_DELETED)) {
                    sTotal = intent.getStringExtra("total_deleted");
                    if (sTotal != null) {
                        int total = Integer.parseInt(sTotal);
                        Log.v("GCMBaseIntentService", "Received deleted messages notification: " + total);
                        m4368a(context, total);
                    }
                } else {
                    Log.e("GCMBaseIntentService", "Received unknown special message: " + messageType);
                }
            } else if (action.equals("com.google.android.gcm.intent.RETRY")) {
                String token = intent.getStringExtra("token");
                if (!f2961g.equals(token)) {
                    Log.e("GCMBaseIntentService", "Received invalid token: " + token);
                    synchronized (f2957b) {
                        if (f2956a != null) {
                            Log.v("GCMBaseIntentService", "Releasing wakelock");
                            f2956a.release();
                        } else {
                            Log.e("GCMBaseIntentService", "Wakelock reference is null");
                        }
                    }
                    return;
                } else if (C1335c.m5863f(context)) {
                    C1335c.m5860c(context);
                } else {
                    C1335c.m5859b(context, m4371a(context));
                }
            }
        } catch (NumberFormatException e) {
            Log.e("GCMBaseIntentService", "GCM returned invalid number of deleted messages: " + sTotal);
        } catch (Throwable th) {
            synchronized (f2957b) {
            }
            if (f2956a != null) {
                Log.v("GCMBaseIntentService", "Releasing wakelock");
                f2956a.release();
            } else {
                Log.e("GCMBaseIntentService", "Wakelock reference is null");
            }
        }
        synchronized (f2957b) {
            if (f2956a != null) {
                Log.v("GCMBaseIntentService", "Releasing wakelock");
                f2956a.release();
            } else {
                Log.e("GCMBaseIntentService", "Wakelock reference is null");
            }
        }
    }

    static void m4366a(Context context, Intent intent, String className) {
        synchronized (f2957b) {
            if (f2956a == null) {
                f2956a = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
        }
        Log.v("GCMBaseIntentService", "Acquiring wakelock");
        f2956a.acquire();
        intent.setClassName(context, className);
        context.startService(intent);
    }

    private void m4367b(Context context, Intent intent) {
        String registrationId = intent.getStringExtra("registration_id");
        String error = intent.getStringExtra("error");
        String unregistered = intent.getStringExtra("unregistered");
        Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + registrationId + ", error = " + error + ", unregistered = " + unregistered);
        if (registrationId != null) {
            C1335c.m5865h(context);
            C1335c.m5851a(context, registrationId);
            m4372b(context, registrationId);
        } else if (unregistered != null) {
            C1335c.m5865h(context);
            m4373c(context, C1335c.m5864g(context));
        } else {
            Log.d("GCMBaseIntentService", "Registration error: " + error);
            if (!GoogleCloudMessaging.ERROR_SERVICE_NOT_AVAILABLE.equals(error)) {
                m4370a(context, error);
            } else if (m4374d(context, error)) {
                int backoffTimeMs = C1335c.m5866i(context);
                int nextAttempt = (backoffTimeMs / 2) + f2959e.nextInt(backoffTimeMs);
                Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + nextAttempt + " (" + backoffTimeMs + ")");
                Intent retryIntent = new Intent("com.google.android.gcm.intent.RETRY");
                retryIntent.putExtra("token", f2961g);
                ((AlarmManager) context.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) nextAttempt), PendingIntent.getBroadcast(context, 0, retryIntent, 0));
                if (backoffTimeMs < f2960f) {
                    C1335c.m5854a(context, backoffTimeMs * 2);
                }
            } else {
                Log.d("GCMBaseIntentService", "Not retrying failed operation");
            }
        }
    }
}
