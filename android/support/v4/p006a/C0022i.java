package android.support.v4.p006a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.cast.Cast;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: android.support.v4.a.i */
public class C0022i {
    private static final Object f52f;
    private static C0022i f53g;
    private final Context f54a;
    private final HashMap f55b;
    private final HashMap f56c;
    private final ArrayList f57d;
    private final Handler f58e;

    /* renamed from: android.support.v4.a.i.1 */
    class C00191 extends Handler {
        final /* synthetic */ C0022i f46a;

        C00191(C0022i c0022i, Looper x0) {
            this.f46a = c0022i;
            super(x0);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Base64.NO_PADDING /*1*/:
                    this.f46a.m109a();
                default:
                    super.handleMessage(msg);
            }
        }
    }

    /* renamed from: android.support.v4.a.i.a */
    private static class C0020a {
        final Intent f47a;
        final ArrayList f48b;

        C0020a(Intent _intent, ArrayList _receivers) {
            this.f47a = _intent;
            this.f48b = _receivers;
        }
    }

    /* renamed from: android.support.v4.a.i.b */
    private static class C0021b {
        final IntentFilter f49a;
        final BroadcastReceiver f50b;
        boolean f51c;

        C0021b(IntentFilter _filter, BroadcastReceiver _receiver) {
            this.f49a = _filter;
            this.f50b = _receiver;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder(Cast.MAX_NAMESPACE_LENGTH);
            builder.append("Receiver{");
            builder.append(this.f50b);
            builder.append(" filter=");
            builder.append(this.f49a);
            builder.append("}");
            return builder.toString();
        }
    }

    static {
        f52f = new Object();
    }

    public static C0022i m108a(Context context) {
        C0022i c0022i;
        synchronized (f52f) {
            if (f53g == null) {
                f53g = new C0022i(context.getApplicationContext());
            }
            c0022i = f53g;
        }
        return c0022i;
    }

    private C0022i(Context context) {
        this.f55b = new HashMap();
        this.f56c = new HashMap();
        this.f57d = new ArrayList();
        this.f54a = context;
        this.f58e = new C00191(this, context.getMainLooper());
    }

    public void m112a(BroadcastReceiver receiver, IntentFilter filter) {
        synchronized (this.f55b) {
            C0021b entry = new C0021b(filter, receiver);
            ArrayList filters = (ArrayList) this.f55b.get(receiver);
            if (filters == null) {
                filters = new ArrayList(1);
                this.f55b.put(receiver, filters);
            }
            filters.add(filter);
            for (int i = 0; i < filter.countActions(); i++) {
                String action = filter.getAction(i);
                ArrayList entries = (ArrayList) this.f56c.get(action);
                if (entries == null) {
                    entries = new ArrayList(1);
                    this.f56c.put(action, entries);
                }
                entries.add(entry);
            }
        }
    }

    public void m111a(BroadcastReceiver receiver) {
        synchronized (this.f55b) {
            ArrayList filters = (ArrayList) this.f55b.remove(receiver);
            if (filters == null) {
                return;
            }
            for (int i = 0; i < filters.size(); i++) {
                IntentFilter filter = (IntentFilter) filters.get(i);
                for (int j = 0; j < filter.countActions(); j++) {
                    String action = filter.getAction(j);
                    ArrayList receivers = (ArrayList) this.f56c.get(action);
                    if (receivers != null) {
                        int k = 0;
                        while (k < receivers.size()) {
                            if (((C0021b) receivers.get(k)).f50b == receiver) {
                                receivers.remove(k);
                                k--;
                            }
                            k++;
                        }
                        if (receivers.size() <= 0) {
                            this.f56c.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m113a(android.content.Intent r18) {
        /*
        r17 = this;
        r0 = r17;
        r15 = r0.f55b;
        monitor-enter(r15);
        r2 = r18.getAction();	 Catch:{ all -> 0x010b }
        r0 = r17;
        r1 = r0.f54a;	 Catch:{ all -> 0x010b }
        r1 = r1.getContentResolver();	 Catch:{ all -> 0x010b }
        r0 = r18;
        r3 = r0.resolveTypeIfNeeded(r1);	 Catch:{ all -> 0x010b }
        r5 = r18.getData();	 Catch:{ all -> 0x010b }
        r4 = r18.getScheme();	 Catch:{ all -> 0x010b }
        r6 = r18.getCategories();	 Catch:{ all -> 0x010b }
        r1 = r18.getFlags();	 Catch:{ all -> 0x010b }
        r1 = r1 & 8;
        if (r1 == 0) goto L_0x00ce;
    L_0x002b:
        r8 = 1;
    L_0x002c:
        if (r8 == 0) goto L_0x0062;
    L_0x002e:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "Resolving type ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.append(r3);	 Catch:{ all -> 0x010b }
        r16 = " scheme ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.append(r4);	 Catch:{ all -> 0x010b }
        r16 = " of intent ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r0 = r18;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x0062:
        r0 = r17;
        r1 = r0.f56c;	 Catch:{ all -> 0x010b }
        r7 = r18.getAction();	 Catch:{ all -> 0x010b }
        r9 = r1.get(r7);	 Catch:{ all -> 0x010b }
        r9 = (java.util.ArrayList) r9;	 Catch:{ all -> 0x010b }
        if (r9 == 0) goto L_0x0175;
    L_0x0072:
        if (r8 == 0) goto L_0x008e;
    L_0x0074:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "Action list: ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.append(r9);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x008e:
        r14 = 0;
        r10 = 0;
    L_0x0090:
        r1 = r9.size();	 Catch:{ all -> 0x010b }
        if (r10 >= r1) goto L_0x013c;
    L_0x0096:
        r13 = r9.get(r10);	 Catch:{ all -> 0x010b }
        r13 = (android.support.v4.p006a.C0022i.C0021b) r13;	 Catch:{ all -> 0x010b }
        if (r8 == 0) goto L_0x00be;
    L_0x009e:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "Matching against filter ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r0 = r13.f49a;	 Catch:{ all -> 0x010b }
        r16 = r0;
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x00be:
        r1 = r13.f51c;	 Catch:{ all -> 0x010b }
        if (r1 == 0) goto L_0x00d1;
    L_0x00c2:
        if (r8 == 0) goto L_0x00cb;
    L_0x00c4:
        r1 = "LocalBroadcastManager";
        r7 = "  Filter's target already added";
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x00cb:
        r10 = r10 + 1;
        goto L_0x0090;
    L_0x00ce:
        r8 = 0;
        goto L_0x002c;
    L_0x00d1:
        r1 = r13.f49a;	 Catch:{ all -> 0x010b }
        r7 = "LocalBroadcastManager";
        r11 = r1.match(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x010b }
        if (r11 < 0) goto L_0x010e;
    L_0x00db:
        if (r8 == 0) goto L_0x00fd;
    L_0x00dd:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "  Filter matched!  match=0x";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r16 = java.lang.Integer.toHexString(r11);	 Catch:{ all -> 0x010b }
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
    L_0x00fd:
        if (r14 != 0) goto L_0x0104;
    L_0x00ff:
        r14 = new java.util.ArrayList;	 Catch:{ all -> 0x010b }
        r14.<init>();	 Catch:{ all -> 0x010b }
    L_0x0104:
        r14.add(r13);	 Catch:{ all -> 0x010b }
        r1 = 1;
        r13.f51c = r1;	 Catch:{ all -> 0x010b }
        goto L_0x00cb;
    L_0x010b:
        r1 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x010b }
        throw r1;
    L_0x010e:
        if (r8 == 0) goto L_0x00cb;
    L_0x0110:
        switch(r11) {
            case -4: goto L_0x0133;
            case -3: goto L_0x0130;
            case -2: goto L_0x0136;
            case -1: goto L_0x0139;
            default: goto L_0x0113;
        };
    L_0x0113:
        r12 = "unknown reason";
    L_0x0115:
        r1 = "LocalBroadcastManager";
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x010b }
        r7.<init>();	 Catch:{ all -> 0x010b }
        r16 = "  Filter did not match: ";
        r0 = r16;
        r7 = r7.append(r0);	 Catch:{ all -> 0x010b }
        r7 = r7.append(r12);	 Catch:{ all -> 0x010b }
        r7 = r7.toString();	 Catch:{ all -> 0x010b }
        android.util.Log.v(r1, r7);	 Catch:{ all -> 0x010b }
        goto L_0x00cb;
    L_0x0130:
        r12 = "action";
        goto L_0x0115;
    L_0x0133:
        r12 = "category";
        goto L_0x0115;
    L_0x0136:
        r12 = "data";
        goto L_0x0115;
    L_0x0139:
        r12 = "type";
        goto L_0x0115;
    L_0x013c:
        if (r14 == 0) goto L_0x0175;
    L_0x013e:
        r10 = 0;
    L_0x013f:
        r1 = r14.size();	 Catch:{ all -> 0x010b }
        if (r10 >= r1) goto L_0x0151;
    L_0x0145:
        r1 = r14.get(r10);	 Catch:{ all -> 0x010b }
        r1 = (android.support.v4.p006a.C0022i.C0021b) r1;	 Catch:{ all -> 0x010b }
        r7 = 0;
        r1.f51c = r7;	 Catch:{ all -> 0x010b }
        r10 = r10 + 1;
        goto L_0x013f;
    L_0x0151:
        r0 = r17;
        r1 = r0.f57d;	 Catch:{ all -> 0x010b }
        r7 = new android.support.v4.a.i$a;	 Catch:{ all -> 0x010b }
        r0 = r18;
        r7.<init>(r0, r14);	 Catch:{ all -> 0x010b }
        r1.add(r7);	 Catch:{ all -> 0x010b }
        r0 = r17;
        r1 = r0.f58e;	 Catch:{ all -> 0x010b }
        r7 = 1;
        r1 = r1.hasMessages(r7);	 Catch:{ all -> 0x010b }
        if (r1 != 0) goto L_0x0172;
    L_0x016a:
        r0 = r17;
        r1 = r0.f58e;	 Catch:{ all -> 0x010b }
        r7 = 1;
        r1.sendEmptyMessage(r7);	 Catch:{ all -> 0x010b }
    L_0x0172:
        r1 = 1;
        monitor-exit(r15);	 Catch:{ all -> 0x010b }
    L_0x0174:
        return r1;
    L_0x0175:
        monitor-exit(r15);	 Catch:{ all -> 0x010b }
        r1 = 0;
        goto L_0x0174;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.i.a(android.content.Intent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m109a() {
        /*
        r8 = this;
    L_0x0000:
        r2 = 0;
        r6 = r8.f55b;
        monitor-enter(r6);
        r5 = r8.f57d;	 Catch:{ all -> 0x003e }
        r0 = r5.size();	 Catch:{ all -> 0x003e }
        if (r0 > 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r6);	 Catch:{ all -> 0x003e }
        return;
    L_0x000e:
        r2 = new android.support.v4.p006a.C0022i.C0020a[r0];	 Catch:{ all -> 0x003e }
        r5 = r8.f57d;	 Catch:{ all -> 0x003e }
        r5.toArray(r2);	 Catch:{ all -> 0x003e }
        r5 = r8.f57d;	 Catch:{ all -> 0x003e }
        r5.clear();	 Catch:{ all -> 0x003e }
        monitor-exit(r6);	 Catch:{ all -> 0x003e }
        r3 = 0;
    L_0x001c:
        r5 = r2.length;
        if (r3 >= r5) goto L_0x0000;
    L_0x001f:
        r1 = r2[r3];
        r4 = 0;
    L_0x0022:
        r5 = r1.f48b;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x0041;
    L_0x002a:
        r5 = r1.f48b;
        r5 = r5.get(r4);
        r5 = (android.support.v4.p006a.C0022i.C0021b) r5;
        r5 = r5.f50b;
        r6 = r8.f54a;
        r7 = r1.f47a;
        r5.onReceive(r6, r7);
        r4 = r4 + 1;
        goto L_0x0022;
    L_0x003e:
        r5 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x003e }
        throw r5;
    L_0x0041:
        r3 = r3 + 1;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.a.i.a():void");
    }
}
