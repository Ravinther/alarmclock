package android.support.v7.internal.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.avg.toolkit.ads.AdsManager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: android.support.v7.internal.widget.b */
public class C0440b extends DataSetObservable {
    private static final String f1113a;
    private static final Object f1114b;
    private static final Map f1115c;
    private final Object f1116d;
    private final List f1117e;
    private final List f1118f;
    private final Context f1119g;
    private final String f1120h;
    private Intent f1121i;
    private C0435b f1122j;
    private int f1123k;
    private boolean f1124l;
    private boolean f1125m;
    private boolean f1126n;
    private boolean f1127o;
    private C0438e f1128p;

    /* renamed from: android.support.v7.internal.widget.b.a */
    public final class C0434a implements Comparable {
        public final ResolveInfo f1104a;
        public float f1105b;
        final /* synthetic */ C0440b f1106c;

        public /* synthetic */ int compareTo(Object x0) {
            return m2120a((C0434a) x0);
        }

        public C0434a(C0440b c0440b, ResolveInfo resolveInfo) {
            this.f1106c = c0440b;
            this.f1104a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1105b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.f1105b) != Float.floatToIntBits(((C0434a) obj).f1105b)) {
                return false;
            }
            return true;
        }

        public int m2120a(C0434a another) {
            return Float.floatToIntBits(another.f1105b) - Float.floatToIntBits(this.f1105b);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(this.f1104a.toString());
            builder.append("; weight:").append(new BigDecimal((double) this.f1105b));
            builder.append("]");
            return builder.toString();
        }
    }

    /* renamed from: android.support.v7.internal.widget.b.b */
    public interface C0435b {
        void m2121a(Intent intent, List list, List list2);
    }

    /* renamed from: android.support.v7.internal.widget.b.c */
    private final class C0436c implements C0435b {
        final /* synthetic */ C0440b f1107a;
        private final Map f1108b;

        private C0436c(C0440b c0440b) {
            this.f1107a = c0440b;
            this.f1108b = new HashMap();
        }

        public void m2122a(Intent intent, List activities, List historicalRecords) {
            int i;
            Map packageNameToActivityMap = this.f1108b;
            packageNameToActivityMap.clear();
            int activityCount = activities.size();
            for (i = 0; i < activityCount; i++) {
                C0434a activity = (C0434a) activities.get(i);
                activity.f1105b = 0.0f;
                packageNameToActivityMap.put(activity.f1104a.activityInfo.packageName, activity);
            }
            float nextRecordWeight = 1.0f;
            for (i = historicalRecords.size() - 1; i >= 0; i--) {
                C0437d historicalRecord = (C0437d) historicalRecords.get(i);
                activity = (C0434a) packageNameToActivityMap.get(historicalRecord.f1109a.getPackageName());
                if (activity != null) {
                    activity.f1105b += historicalRecord.f1111c * nextRecordWeight;
                    nextRecordWeight *= 0.95f;
                }
            }
            Collections.sort(activities);
        }
    }

    /* renamed from: android.support.v7.internal.widget.b.d */
    public static final class C0437d {
        public final ComponentName f1109a;
        public final long f1110b;
        public final float f1111c;

        public C0437d(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
        }

        public C0437d(ComponentName activityName, long time, float weight) {
            this.f1109a = activityName;
            this.f1110b = time;
            this.f1111c = weight;
        }

        public int hashCode() {
            return (((((this.f1109a == null ? 0 : this.f1109a.hashCode()) + 31) * 31) + ((int) (this.f1110b ^ (this.f1110b >>> 32)))) * 31) + Float.floatToIntBits(this.f1111c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0437d other = (C0437d) obj;
            if (this.f1109a == null) {
                if (other.f1109a != null) {
                    return false;
                }
            } else if (!this.f1109a.equals(other.f1109a)) {
                return false;
            }
            if (this.f1110b != other.f1110b) {
                return false;
            }
            if (Float.floatToIntBits(this.f1111c) != Float.floatToIntBits(other.f1111c)) {
                return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(this.f1109a);
            builder.append("; time:").append(this.f1110b);
            builder.append("; weight:").append(new BigDecimal((double) this.f1111c));
            builder.append("]");
            return builder.toString();
        }
    }

    /* renamed from: android.support.v7.internal.widget.b.e */
    public interface C0438e {
        boolean m2123a(C0440b c0440b, Intent intent);
    }

    /* renamed from: android.support.v7.internal.widget.b.f */
    private final class C0439f extends AsyncTask {
        final /* synthetic */ C0440b f1112a;

        private C0439f(C0440b c0440b) {
            this.f1112a = c0440b;
        }

        public /* synthetic */ Object doInBackground(Object[] x0) {
            return m2124a(x0);
        }

        public Void m2124a(Object... args) {
            List historicalRecords = args[0];
            String hostoryFileName = args[1];
            try {
                FileOutputStream fos = this.f1112a.f1119g.openFileOutput(hostoryFileName, 0);
                XmlSerializer serializer = Xml.newSerializer();
                try {
                    serializer.setOutput(fos, null);
                    serializer.startDocument("UTF-8", Boolean.valueOf(true));
                    serializer.startTag(null, "historical-records");
                    int recordCount = historicalRecords.size();
                    for (int i = 0; i < recordCount; i++) {
                        C0437d record = (C0437d) historicalRecords.remove(0);
                        serializer.startTag(null, "historical-record");
                        serializer.attribute(null, "activity", record.f1109a.flattenToString());
                        serializer.attribute(null, AdsManager.PREFS_KEY_TIME, String.valueOf(record.f1110b));
                        serializer.attribute(null, "weight", String.valueOf(record.f1111c));
                        serializer.endTag(null, "historical-record");
                    }
                    serializer.endTag(null, "historical-records");
                    serializer.endDocument();
                    this.f1112a.f1124l = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IllegalArgumentException iae) {
                    Log.e(C0440b.f1113a, "Error writing historical recrod file: " + this.f1112a.f1120h, iae);
                    this.f1112a.f1124l = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IllegalStateException ise) {
                    Log.e(C0440b.f1113a, "Error writing historical recrod file: " + this.f1112a.f1120h, ise);
                    this.f1112a.f1124l = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (IOException ioe) {
                    Log.e(C0440b.f1113a, "Error writing historical recrod file: " + this.f1112a.f1120h, ioe);
                    this.f1112a.f1124l = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    this.f1112a.f1124l = true;
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e5) {
                        }
                    }
                }
                return null;
            } catch (FileNotFoundException fnfe) {
                Log.e(C0440b.f1113a, "Error writing historical recrod file: " + hostoryFileName, fnfe);
                return null;
            }
        }
    }

    static {
        f1113a = C0440b.class.getSimpleName();
        f1114b = new Object();
        f1115c = new HashMap();
    }

    public static C0440b m2126a(Context context, String historyFileName) {
        C0440b dataModel;
        synchronized (f1114b) {
            dataModel = (C0440b) f1115c.get(historyFileName);
            if (dataModel == null) {
                dataModel = new C0440b(context, historyFileName);
                f1115c.put(historyFileName, dataModel);
            }
        }
        return dataModel;
    }

    private C0440b(Context context, String historyFileName) {
        this.f1116d = new Object();
        this.f1117e = new ArrayList();
        this.f1118f = new ArrayList();
        this.f1122j = new C0436c();
        this.f1123k = 50;
        this.f1124l = true;
        this.f1125m = false;
        this.f1126n = true;
        this.f1127o = false;
        this.f1119g = context.getApplicationContext();
        if (TextUtils.isEmpty(historyFileName) || historyFileName.endsWith(".xml")) {
            this.f1120h = historyFileName;
        } else {
            this.f1120h = historyFileName + ".xml";
        }
    }

    public void m2143a(Intent intent) {
        synchronized (this.f1116d) {
            if (this.f1121i == intent) {
                return;
            }
            this.f1121i = intent;
            this.f1127o = true;
            m2134h();
        }
    }

    public int m2140a() {
        int size;
        synchronized (this.f1116d) {
            m2134h();
            size = this.f1117e.size();
        }
        return size;
    }

    public ResolveInfo m2142a(int index) {
        ResolveInfo resolveInfo;
        synchronized (this.f1116d) {
            m2134h();
            resolveInfo = ((C0434a) this.f1117e.get(index)).f1104a;
        }
        return resolveInfo;
    }

    public int m2141a(ResolveInfo activity) {
        int i;
        synchronized (this.f1116d) {
            m2134h();
            List activities = this.f1117e;
            int activityCount = activities.size();
            i = 0;
            while (i < activityCount) {
                if (((C0434a) activities.get(i)).f1104a == activity) {
                    break;
                }
                i++;
            }
            i = -1;
        }
        return i;
    }

    public Intent m2145b(int index) {
        synchronized (this.f1116d) {
            if (this.f1121i == null) {
                return null;
            }
            m2134h();
            C0434a chosenActivity = (C0434a) this.f1117e.get(index);
            ComponentName chosenName = new ComponentName(chosenActivity.f1104a.activityInfo.packageName, chosenActivity.f1104a.activityInfo.name);
            Intent choiceIntent = new Intent(this.f1121i);
            choiceIntent.setComponent(chosenName);
            if (this.f1128p != null) {
                if (this.f1128p.m2123a(this, new Intent(choiceIntent))) {
                    return null;
                }
            }
            m2127a(new C0437d(chosenName, System.currentTimeMillis(), 1.0f));
            return choiceIntent;
        }
    }

    public void m2144a(C0438e listener) {
        synchronized (this.f1116d) {
            this.f1128p = listener;
        }
    }

    public ResolveInfo m2146b() {
        synchronized (this.f1116d) {
            m2134h();
            if (this.f1117e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0434a) this.f1117e.get(0)).f1104a;
            return resolveInfo;
        }
    }

    public void m2148c(int index) {
        synchronized (this.f1116d) {
            float weight;
            m2134h();
            C0434a newDefaultActivity = (C0434a) this.f1117e.get(index);
            C0434a oldDefaultActivity = (C0434a) this.f1117e.get(0);
            if (oldDefaultActivity != null) {
                weight = (oldDefaultActivity.f1105b - newDefaultActivity.f1105b) + 5.0f;
            } else {
                weight = 1.0f;
            }
            m2127a(new C0437d(new ComponentName(newDefaultActivity.f1104a.activityInfo.packageName, newDefaultActivity.f1104a.activityInfo.name), System.currentTimeMillis(), weight));
        }
    }

    private void m2131e() {
        if (!this.f1125m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1126n) {
            this.f1126n = false;
            if (!TextUtils.isEmpty(this.f1120h)) {
                if (VERSION.SDK_INT >= 11) {
                    m2133g();
                } else {
                    m2132f();
                }
            }
        }
    }

    private void m2132f() {
        new C0439f().execute(new Object[]{new ArrayList(this.f1118f), this.f1120h});
    }

    private void m2133g() {
        new C0439f().executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Object[]{new ArrayList(this.f1118f), this.f1120h});
    }

    public int m2147c() {
        int size;
        synchronized (this.f1116d) {
            m2134h();
            size = this.f1118f.size();
        }
        return size;
    }

    private void m2134h() {
        boolean stateChanged = m2136j() | m2137k();
        m2138l();
        if (stateChanged) {
            m2135i();
            notifyChanged();
        }
    }

    private boolean m2135i() {
        if (this.f1122j == null || this.f1121i == null || this.f1117e.isEmpty() || this.f1118f.isEmpty()) {
            return false;
        }
        this.f1122j.m2121a(this.f1121i, this.f1117e, Collections.unmodifiableList(this.f1118f));
        return true;
    }

    private boolean m2136j() {
        if (!this.f1127o || this.f1121i == null) {
            return false;
        }
        this.f1127o = false;
        this.f1117e.clear();
        List resolveInfos = this.f1119g.getPackageManager().queryIntentActivities(this.f1121i, 0);
        int resolveInfoCount = resolveInfos.size();
        for (int i = 0; i < resolveInfoCount; i++) {
            this.f1117e.add(new C0434a(this, (ResolveInfo) resolveInfos.get(i)));
        }
        return true;
    }

    private boolean m2137k() {
        if (!this.f1124l || !this.f1126n || TextUtils.isEmpty(this.f1120h)) {
            return false;
        }
        this.f1124l = false;
        this.f1125m = true;
        m2139m();
        return true;
    }

    private boolean m2127a(C0437d historicalRecord) {
        boolean added = this.f1118f.add(historicalRecord);
        if (added) {
            this.f1126n = true;
            m2138l();
            m2131e();
            m2135i();
            notifyChanged();
        }
        return added;
    }

    private void m2138l() {
        int pruneCount = this.f1118f.size() - this.f1123k;
        if (pruneCount > 0) {
            this.f1126n = true;
            for (int i = 0; i < pruneCount; i++) {
                C0437d c0437d = (C0437d) this.f1118f.remove(0);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2139m() {
        /*
        r18 = this;
        r3 = 0;
        r0 = r18;
        r15 = r0.f1119g;	 Catch:{ FileNotFoundException -> 0x0023 }
        r0 = r18;
        r0 = r0.f1120h;	 Catch:{ FileNotFoundException -> 0x0023 }
        r16 = r0;
        r3 = r15.openFileInput(r16);	 Catch:{ FileNotFoundException -> 0x0023 }
        r8 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = 0;
        r8.setInput(r3, r15);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r12 = 0;
    L_0x0018:
        r15 = 1;
        if (r12 == r15) goto L_0x0025;
    L_0x001b:
        r15 = 2;
        if (r12 == r15) goto L_0x0025;
    L_0x001e:
        r12 = r8.next();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        goto L_0x0018;
    L_0x0023:
        r4 = move-exception;
    L_0x0024:
        return;
    L_0x0025:
        r15 = "historical-records";
        r16 = r8.getName();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = r15.equals(r16);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        if (r15 != 0) goto L_0x0062;
    L_0x0031:
        r15 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r16 = "Share records file does not start with historical-records tag.";
        r15.<init>(r16);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        throw r15;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
    L_0x0039:
        r14 = move-exception;
        r15 = f1113a;	 Catch:{ all -> 0x00e9 }
        r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e9 }
        r16.<init>();	 Catch:{ all -> 0x00e9 }
        r17 = "Error reading historical recrod file: ";
        r16 = r16.append(r17);	 Catch:{ all -> 0x00e9 }
        r0 = r18;
        r0 = r0.f1120h;	 Catch:{ all -> 0x00e9 }
        r17 = r0;
        r16 = r16.append(r17);	 Catch:{ all -> 0x00e9 }
        r16 = r16.toString();	 Catch:{ all -> 0x00e9 }
        r0 = r16;
        android.util.Log.e(r15, r0, r14);	 Catch:{ all -> 0x00e9 }
        if (r3 == 0) goto L_0x0024;
    L_0x005c:
        r3.close();	 Catch:{ IOException -> 0x0060 }
        goto L_0x0024;
    L_0x0060:
        r15 = move-exception;
        goto L_0x0024;
    L_0x0062:
        r0 = r18;
        r5 = r0.f1118f;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r5.clear();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
    L_0x0069:
        r12 = r8.next();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = 1;
        if (r12 != r15) goto L_0x0078;
    L_0x0070:
        if (r3 == 0) goto L_0x0024;
    L_0x0072:
        r3.close();	 Catch:{ IOException -> 0x0076 }
        goto L_0x0024;
    L_0x0076:
        r15 = move-exception;
        goto L_0x0024;
    L_0x0078:
        r15 = 3;
        if (r12 == r15) goto L_0x0069;
    L_0x007b:
        r15 = 4;
        if (r12 == r15) goto L_0x0069;
    L_0x007e:
        r7 = r8.getName();	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = "historical-record";
        r15 = r15.equals(r7);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        if (r15 != 0) goto L_0x00bd;
    L_0x008a:
        r15 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r16 = "Share records file not well-formed.";
        r15.<init>(r16);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        throw r15;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
    L_0x0092:
        r6 = move-exception;
        r15 = f1113a;	 Catch:{ all -> 0x00e9 }
        r16 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e9 }
        r16.<init>();	 Catch:{ all -> 0x00e9 }
        r17 = "Error reading historical recrod file: ";
        r16 = r16.append(r17);	 Catch:{ all -> 0x00e9 }
        r0 = r18;
        r0 = r0.f1120h;	 Catch:{ all -> 0x00e9 }
        r17 = r0;
        r16 = r16.append(r17);	 Catch:{ all -> 0x00e9 }
        r16 = r16.toString();	 Catch:{ all -> 0x00e9 }
        r0 = r16;
        android.util.Log.e(r15, r0, r6);	 Catch:{ all -> 0x00e9 }
        if (r3 == 0) goto L_0x0024;
    L_0x00b5:
        r3.close();	 Catch:{ IOException -> 0x00ba }
        goto L_0x0024;
    L_0x00ba:
        r15 = move-exception;
        goto L_0x0024;
    L_0x00bd:
        r15 = 0;
        r16 = "activity";
        r0 = r16;
        r2 = r8.getAttributeValue(r15, r0);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = 0;
        r16 = "time";
        r0 = r16;
        r15 = r8.getAttributeValue(r15, r0);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r10 = java.lang.Long.parseLong(r15);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r15 = 0;
        r16 = "weight";
        r0 = r16;
        r15 = r8.getAttributeValue(r15, r0);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r13 = java.lang.Float.parseFloat(r15);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r9 = new android.support.v7.internal.widget.b$d;	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r9.<init>(r2, r10, r13);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        r5.add(r9);	 Catch:{ XmlPullParserException -> 0x0039, IOException -> 0x0092 }
        goto L_0x0069;
    L_0x00e9:
        r15 = move-exception;
        if (r3 == 0) goto L_0x00ef;
    L_0x00ec:
        r3.close();	 Catch:{ IOException -> 0x00f0 }
    L_0x00ef:
        throw r15;
    L_0x00f0:
        r16 = move-exception;
        goto L_0x00ef;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.internal.widget.b.m():void");
    }
}
