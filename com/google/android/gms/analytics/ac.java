package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.ef;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ac implements C1352d {
    private static final String vx;
    private final Context mContext;
    private final C1363e sO;
    private C1344i tg;
    private final String vA;
    private ab vB;
    private long vC;
    private final int vD;
    private final C1351a vy;
    private volatile C1353n vz;

    /* renamed from: com.google.android.gms.analytics.ac.1 */
    class C13501 implements C1344i {
        final /* synthetic */ ac vE;

        C13501(ac acVar) {
            this.vE = acVar;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    /* renamed from: com.google.android.gms.analytics.ac.a */
    class C1351a extends SQLiteOpenHelper {
        final /* synthetic */ ac vE;
        private boolean vF;
        private long vG;

        C1351a(ac acVar, Context context, String str) {
            this.vE = acVar;
            super(context, str, null, 1);
            this.vG = 0;
        }

        private void m5918a(SQLiteDatabase sQLiteDatabase) {
            Object obj = null;
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (hashSet.remove("hit_id") && hashSet.remove("hit_url") && hashSet.remove("hit_string") && hashSet.remove("hit_time")) {
                    if (!hashSet.remove("hit_app_id")) {
                        obj = 1;
                    }
                    if (!hashSet.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    } else if (obj != null) {
                        sQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                        return;
                    } else {
                        return;
                    }
                }
                throw new SQLiteException("Database column missing");
            } finally {
                rawQuery.close();
            }
        }

        private boolean m5919a(String str, SQLiteDatabase sQLiteDatabase) {
            Cursor cursor;
            Throwable th;
            Cursor cursor2 = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean moveToFirst = query.moveToFirst();
                    if (query == null) {
                        return moveToFirst;
                    }
                    query.close();
                    return moveToFirst;
                } catch (SQLiteException e) {
                    cursor = query;
                    try {
                        aa.m5916z("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        cursor2 = cursor;
                        th = th2;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
                aa.m5916z("Error querying for table " + str);
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.vF || this.vG + 3600000 <= this.vE.tg.currentTimeMillis()) {
                SQLiteDatabase sQLiteDatabase = null;
                this.vF = true;
                this.vG = this.vE.tg.currentTimeMillis();
                try {
                    sQLiteDatabase = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.vE.mContext.getDatabasePath(this.vE.vA).delete();
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase = super.getWritableDatabase();
                }
                this.vF = false;
                return sQLiteDatabase;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onCreate(SQLiteDatabase db) {
            C1371p.m5991G(db.getPath());
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor rawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            if (m5919a("hits2", db)) {
                m5918a(db);
            } else {
                db.execSQL(ac.vx);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    static {
        vx = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    }

    ac(C1363e c1363e, Context context) {
        this(c1363e, context, "google_analytics_v4.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS);
    }

    ac(C1363e c1363e, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.vA = str;
        this.sO = c1363e;
        this.tg = new C13501(this);
        this.vy = new C1351a(this, this.mContext, this.vA);
        this.vz = new ah(new DefaultHttpClient(), this.mContext);
        this.vC = 0;
        this.vD = i;
    }

    private SQLiteDatabase m5922L(String str) {
        try {
            return this.vy.getWritableDatabase();
        } catch (SQLiteException e) {
            aa.m5916z(str);
            return null;
        }
    }

    private void m5924a(Map map, long j, String str) {
        SQLiteDatabase L = m5922L("Error opening database for putHit");
        if (L != null) {
            long parseLong;
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_string", m5928w(map));
            contentValues.put("hit_time", Long.valueOf(j));
            if (map.containsKey("AppUID")) {
                try {
                    parseLong = Long.parseLong((String) map.get("AppUID"));
                } catch (NumberFormatException e) {
                    parseLong = 0;
                }
            } else {
                parseLong = 0;
            }
            contentValues.put("hit_app_id", Long.valueOf(parseLong));
            if (str == null) {
                str = "http://www.google-analytics.com/collect";
            }
            if (str.length() == 0) {
                aa.m5916z("Empty path: not sending hit");
                return;
            }
            contentValues.put("hit_url", str);
            try {
                L.insert("hits2", null, contentValues);
                this.sO.m5977r(false);
            } catch (SQLiteException e2) {
                aa.m5916z("Error storing hit");
            }
        }
    }

    private void m5925a(Map map, Collection collection) {
        String substring = "&_v".substring(1);
        if (collection != null) {
            for (ef efVar : collection) {
                if (Command.APPEND_VERSION.equals(efVar.getId())) {
                    map.put(substring, efVar.getValue());
                    return;
                }
            }
        }
    }

    private void cV() {
        int cX = (cX() - this.vD) + 1;
        if (cX > 0) {
            List s = m5933s(cX);
            aa.m5915y("Store full, deleting " + s.size() + " hits to make room.");
            m5930a((String[]) s.toArray(new String[0]));
        }
    }

    static String m5928w(Map map) {
        Iterable arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(C1396y.encode((String) entry.getKey()) + "=" + C1396y.encode((String) entry.getValue()));
        }
        return TextUtils.join("&", arrayList);
    }

    public void m5929a(Map map, long j, String str, Collection collection) {
        cW();
        cV();
        m5925a(map, collection);
        m5924a(map, j, str);
    }

    void m5930a(String[] strArr) {
        boolean z = true;
        if (strArr == null || strArr.length == 0) {
            aa.m5916z("Empty hitIds passed to deleteHits.");
            return;
        }
        SQLiteDatabase L = m5922L("Error opening database for deleteHits.");
        if (L != null) {
            try {
                L.delete("hits2", String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                C1363e c1363e = this.sO;
                if (cX() != 0) {
                    z = false;
                }
                c1363e.m5977r(z);
            } catch (SQLiteException e) {
                aa.m5916z("Error deleting hits " + strArr);
            }
        }
    }

    @Deprecated
    void m5931b(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            aa.m5916z("Empty/Null collection passed to deleteHits.");
            return;
        }
        String[] strArr = new String[collection.size()];
        int i = 0;
        for (C1395x cP : collection) {
            int i2 = i + 1;
            strArr[i] = String.valueOf(cP.cP());
            i = i2;
        }
        m5930a(strArr);
    }

    public void bW() {
        boolean z = true;
        aa.m5915y("Dispatch running...");
        if (this.vz.ch()) {
            List t = m5934t(40);
            if (t.isEmpty()) {
                aa.m5915y("...nothing to dispatch");
                this.sO.m5977r(true);
                return;
            }
            if (this.vB == null) {
                this.vB = new ab("_t=dispatch&_v=ma4.0.1", true);
            }
            if (cX() > t.size()) {
                z = false;
            }
            int a = this.vz.m5940a(t, this.vB, z);
            aa.m5915y("sent " + a + " of " + t.size() + " hits");
            m5931b(t.subList(0, Math.min(a, t.size())));
            if (a != t.size() || cX() <= 0) {
                this.vB = null;
            } else {
                GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
            }
        }
    }

    public C1353n bX() {
        return this.vz;
    }

    int cW() {
        boolean z = true;
        long currentTimeMillis = this.tg.currentTimeMillis();
        if (currentTimeMillis <= this.vC + 86400000) {
            return 0;
        }
        this.vC = currentTimeMillis;
        SQLiteDatabase L = m5922L("Error opening database for deleteStaleHits.");
        if (L == null) {
            return 0;
        }
        int delete = L.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(this.tg.currentTimeMillis() - 2592000000L)});
        C1363e c1363e = this.sO;
        if (cX() != 0) {
            z = false;
        }
        c1363e.m5977r(z);
        return delete;
    }

    int cX() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase L = m5922L("Error opening database for getNumStoredHits.");
        if (L != null) {
            try {
                cursor = L.rawQuery("SELECT COUNT(*) from hits2", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                aa.m5916z("Error getting numStoredHits");
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return i;
    }

    public void m5932j(long j) {
        boolean z = true;
        SQLiteDatabase L = m5922L("Error opening database for clearHits");
        if (L != null) {
            if (j == 0) {
                L.delete("hits2", null, null);
            } else {
                L.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(j).toString()});
            }
            C1363e c1363e = this.sO;
            if (cX() != 0) {
                z = false;
            }
            c1363e.m5977r(z);
        }
    }

    List m5933s(int i) {
        Cursor query;
        SQLiteException e;
        Throwable th;
        List arrayList = new ArrayList();
        if (i <= 0) {
            aa.m5916z("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase L = m5922L("Error opening database for peekHitIds.");
        if (L == null) {
            return arrayList;
        }
        try {
            query = L.query("hits2", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(i));
            try {
                if (query.moveToFirst()) {
                    do {
                        arrayList.add(String.valueOf(query.getLong(0)));
                    } while (query.moveToNext());
                }
                if (query != null) {
                    query.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    aa.m5916z("Error in peekHits fetching hitIds: " + e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            query = null;
            aa.m5916z("Error in peekHits fetching hitIds: " + e.getMessage());
            if (query != null) {
                query.close();
            }
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List m5934t(int r17) {
        /*
        r16 = this;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r2 = "Error opening database for peekHits";
        r0 = r16;
        r2 = r0.m5922L(r2);
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        r2 = r11;
    L_0x0010:
        return r2;
    L_0x0011:
        r12 = 0;
        r3 = "hits2";
        r4 = 2;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r5 = 1;
        r6 = "hit_time";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r13 = 0;
        r14 = "hit_id";
        r10[r13] = r14;	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r13 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x00d4, all -> 0x00f9 }
        r12 = new java.util.ArrayList;	 Catch:{ SQLiteException -> 0x017b, all -> 0x0175 }
        r12.<init>();	 Catch:{ SQLiteException -> 0x017b, all -> 0x0175 }
        r3 = r13.moveToFirst();	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        if (r3 == 0) goto L_0x005f;
    L_0x0046:
        r4 = new com.google.android.gms.analytics.x;	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r5 = 0;
        r3 = 0;
        r6 = r13.getLong(r3);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r3 = 1;
        r8 = r13.getLong(r3);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r4.<init>(r5, r6, r8);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r12.add(r4);	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        r3 = r13.moveToNext();	 Catch:{ SQLiteException -> 0x0181, all -> 0x0175 }
        if (r3 != 0) goto L_0x0046;
    L_0x005f:
        if (r13 == 0) goto L_0x0064;
    L_0x0061:
        r13.close();
    L_0x0064:
        r11 = 0;
        r3 = "hits2";
        r4 = 3;
        r4 = new java.lang.String[r4];	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 0;
        r6 = "hit_id";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 1;
        r6 = "hit_string";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 2;
        r6 = "hit_url";
        r4[r5] = r6;	 Catch:{ SQLiteException -> 0x0173 }
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = "%s ASC";
        r10 = 1;
        r10 = new java.lang.Object[r10];	 Catch:{ SQLiteException -> 0x0173 }
        r14 = 0;
        r15 = "hit_id";
        r10[r14] = r15;	 Catch:{ SQLiteException -> 0x0173 }
        r9 = java.lang.String.format(r9, r10);	 Catch:{ SQLiteException -> 0x0173 }
        r10 = java.lang.Integer.toString(r17);	 Catch:{ SQLiteException -> 0x0173 }
        r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ SQLiteException -> 0x0173 }
        r2 = r3.moveToFirst();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        if (r2 == 0) goto L_0x00cc;
    L_0x0099:
        r4 = r11;
    L_0x009a:
        r0 = r3;
        r0 = (android.database.sqlite.SQLiteCursor) r0;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = r0;
        r2 = r2.getWindow();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = r2.getNumRows();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        if (r2 <= 0) goto L_0x0100;
    L_0x00a8:
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = (com.google.android.gms.analytics.C1395x) r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r5 = 1;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2.m6041J(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = (com.google.android.gms.analytics.C1395x) r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r5 = 2;
        r5 = r3.getString(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2.m6042K(r5);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
    L_0x00c4:
        r2 = r4 + 1;
        r4 = r3.moveToNext();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        if (r4 != 0) goto L_0x0187;
    L_0x00cc:
        if (r3 == 0) goto L_0x00d1;
    L_0x00ce:
        r3.close();
    L_0x00d1:
        r2 = r12;
        goto L_0x0010;
    L_0x00d4:
        r2 = move-exception;
        r3 = r2;
        r4 = r12;
        r2 = r11;
    L_0x00d8:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r5.<init>();	 Catch:{ all -> 0x0178 }
        r6 = "Error in peekHits fetching hitIds: ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0178 }
        r3 = r3.getMessage();	 Catch:{ all -> 0x0178 }
        r3 = r5.append(r3);	 Catch:{ all -> 0x0178 }
        r3 = r3.toString();	 Catch:{ all -> 0x0178 }
        com.google.android.gms.analytics.aa.m5916z(r3);	 Catch:{ all -> 0x0178 }
        if (r4 == 0) goto L_0x0010;
    L_0x00f4:
        r4.close();
        goto L_0x0010;
    L_0x00f9:
        r2 = move-exception;
    L_0x00fa:
        if (r12 == 0) goto L_0x00ff;
    L_0x00fc:
        r12.close();
    L_0x00ff:
        throw r2;
    L_0x0100:
        r5 = "HitString for hitId %d too large.  Hit will be deleted.";
        r2 = 1;
        r6 = new java.lang.Object[r2];	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r7 = 0;
        r2 = r12.get(r4);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = (com.google.android.gms.analytics.C1395x) r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r8 = r2.cP();	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = java.lang.Long.valueOf(r8);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r6[r7] = r2;	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        r2 = java.lang.String.format(r5, r6);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        com.google.android.gms.analytics.aa.m5916z(r2);	 Catch:{ SQLiteException -> 0x011e, all -> 0x0170 }
        goto L_0x00c4;
    L_0x011e:
        r2 = move-exception;
        r13 = r3;
    L_0x0120:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0169 }
        r3.<init>();	 Catch:{ all -> 0x0169 }
        r4 = "Error in peekHits fetching hitString: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x0169 }
        r2 = r2.getMessage();	 Catch:{ all -> 0x0169 }
        r2 = r3.append(r2);	 Catch:{ all -> 0x0169 }
        r2 = r2.toString();	 Catch:{ all -> 0x0169 }
        com.google.android.gms.analytics.aa.m5916z(r2);	 Catch:{ all -> 0x0169 }
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x0169 }
        r3.<init>();	 Catch:{ all -> 0x0169 }
        r4 = 0;
        r5 = r12.iterator();	 Catch:{ all -> 0x0169 }
    L_0x0144:
        r2 = r5.hasNext();	 Catch:{ all -> 0x0169 }
        if (r2 == 0) goto L_0x015c;
    L_0x014a:
        r2 = r5.next();	 Catch:{ all -> 0x0169 }
        r2 = (com.google.android.gms.analytics.C1395x) r2;	 Catch:{ all -> 0x0169 }
        r6 = r2.cO();	 Catch:{ all -> 0x0169 }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x0169 }
        if (r6 == 0) goto L_0x0165;
    L_0x015a:
        if (r4 == 0) goto L_0x0164;
    L_0x015c:
        if (r13 == 0) goto L_0x0161;
    L_0x015e:
        r13.close();
    L_0x0161:
        r2 = r3;
        goto L_0x0010;
    L_0x0164:
        r4 = 1;
    L_0x0165:
        r3.add(r2);	 Catch:{ all -> 0x0169 }
        goto L_0x0144;
    L_0x0169:
        r2 = move-exception;
    L_0x016a:
        if (r13 == 0) goto L_0x016f;
    L_0x016c:
        r13.close();
    L_0x016f:
        throw r2;
    L_0x0170:
        r2 = move-exception;
        r13 = r3;
        goto L_0x016a;
    L_0x0173:
        r2 = move-exception;
        goto L_0x0120;
    L_0x0175:
        r2 = move-exception;
        r12 = r13;
        goto L_0x00fa;
    L_0x0178:
        r2 = move-exception;
        r12 = r4;
        goto L_0x00fa;
    L_0x017b:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r11;
        goto L_0x00d8;
    L_0x0181:
        r2 = move-exception;
        r3 = r2;
        r4 = r13;
        r2 = r12;
        goto L_0x00d8;
    L_0x0187:
        r4 = r2;
        goto L_0x009a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.ac.t(int):java.util.List");
    }
}
