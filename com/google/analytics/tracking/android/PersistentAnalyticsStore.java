package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentAnalyticsStore implements AnalyticsStore {
    private static final String f4219a;
    private final AnalyticsDatabaseHelper f4220b;
    private volatile Dispatcher f4221c;
    private final AnalyticsStoreStateListener f4222d;
    private final Context f4223e;
    private final String f4224f;
    private long f4225g;
    private Clock f4226h;

    /* renamed from: com.google.analytics.tracking.android.PersistentAnalyticsStore.1 */
    class C13301 implements Clock {
        final /* synthetic */ PersistentAnalyticsStore f4214a;

        C13301(PersistentAnalyticsStore persistentAnalyticsStore) {
            this.f4214a = persistentAnalyticsStore;
        }

        public long m5772a() {
            return System.currentTimeMillis();
        }
    }

    /* renamed from: com.google.analytics.tracking.android.PersistentAnalyticsStore.2 */
    class C13312 implements HttpClientFactory {
        final /* synthetic */ PersistentAnalyticsStore f4215a;

        C13312(PersistentAnalyticsStore persistentAnalyticsStore) {
            this.f4215a = persistentAnalyticsStore;
        }

        public HttpClient m5773a() {
            return new DefaultHttpClient();
        }
    }

    @VisibleForTesting
    class AnalyticsDatabaseHelper extends SQLiteOpenHelper {
        final /* synthetic */ PersistentAnalyticsStore f4216a;
        private boolean f4217b;
        private long f4218c;

        AnalyticsDatabaseHelper(PersistentAnalyticsStore persistentAnalyticsStore, Context context, String databaseName) {
            this.f4216a = persistentAnalyticsStore;
            super(context, databaseName, null, 1);
            this.f4218c = 0;
        }

        private boolean m5775a(String table, SQLiteDatabase db) {
            Cursor cursor = null;
            try {
                SQLiteDatabase sQLiteDatabase = db;
                cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{table}, null, null, null);
                boolean moveToFirst = cursor.moveToFirst();
                if (cursor == null) {
                    return moveToFirst;
                }
                cursor.close();
                return moveToFirst;
            } catch (SQLiteException e) {
                Log.m5758h("error querying for table " + table);
                return false;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        public SQLiteDatabase getWritableDatabase() {
            if (!this.f4217b || this.f4218c + 3600000 <= this.f4216a.f4226h.m5593a()) {
                SQLiteDatabase db = null;
                this.f4217b = true;
                this.f4218c = this.f4216a.f4226h.m5593a();
                try {
                    db = super.getWritableDatabase();
                } catch (SQLiteException e) {
                    this.f4216a.f4223e.getDatabasePath(this.f4216a.f4224f).delete();
                }
                if (db == null) {
                    db = super.getWritableDatabase();
                }
                this.f4217b = false;
                return db;
            }
            throw new SQLiteException("Database creation failed");
        }

        public void onOpen(SQLiteDatabase db) {
            if (VERSION.SDK_INT < 15) {
                Cursor cursor = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    cursor.moveToFirst();
                } finally {
                    cursor.close();
                }
            }
            if (m5775a("hits2", db)) {
                m5774a(db);
            } else {
                db.execSQL(PersistentAnalyticsStore.f4219a);
            }
        }

        private void m5774a(SQLiteDatabase db) {
            Cursor c = db.rawQuery("SELECT * FROM hits2 WHERE 0", null);
            Set columns = new HashSet();
            try {
                String[] columnNames = c.getColumnNames();
                for (Object add : columnNames) {
                    columns.add(add);
                }
                if (columns.remove("hit_id") && columns.remove("hit_url") && columns.remove("hit_string") && columns.remove("hit_time")) {
                    boolean needsAppId = !columns.remove("hit_app_id");
                    if (!columns.isEmpty()) {
                        throw new SQLiteException("Database has extra columns");
                    } else if (needsAppId) {
                        db.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
                        return;
                    } else {
                        return;
                    }
                }
                throw new SQLiteException("Database column missing");
            } finally {
                c.close();
            }
        }

        public void onCreate(SQLiteDatabase db) {
            FutureApis.m5639a(db.getPath());
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    static {
        f4219a = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[]{"hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id"});
    }

    PersistentAnalyticsStore(AnalyticsStoreStateListener listener, Context ctx) {
        this(listener, ctx, "google_analytics_v2.db");
    }

    @VisibleForTesting
    PersistentAnalyticsStore(AnalyticsStoreStateListener listener, Context ctx, String databaseName) {
        this.f4223e = ctx.getApplicationContext();
        this.f4224f = databaseName;
        this.f4222d = listener;
        this.f4226h = new C13301(this);
        this.f4220b = new AnalyticsDatabaseHelper(this, this.f4223e, this.f4224f);
        this.f4221c = new SimpleNetworkDispatcher(this, m5785e(), this.f4223e);
        this.f4225g = 0;
    }

    private HttpClientFactory m5785e() {
        return new C13312(this);
    }

    public void m5789a(long appId) {
        boolean z = true;
        SQLiteDatabase db = m5776a("Error opening database for clearHits");
        if (db != null) {
            if (appId == 0) {
                db.delete("hits2", null, null);
            } else {
                db.delete("hits2", "hit_app_id = ?", new String[]{Long.valueOf(appId).toString()});
            }
            AnalyticsStoreStateListener analyticsStoreStateListener = this.f4222d;
            if (m5793c() != 0) {
                z = false;
            }
            analyticsStoreStateListener.m5585a(z);
        }
    }

    public void m5791a(Map wireFormatParams, long hitTimeInMilliseconds, String path, Collection commands) {
        m5792b();
        m5781a(wireFormatParams, commands);
        m5786f();
        m5779a(wireFormatParams, hitTimeInMilliseconds, path);
    }

    private void m5781a(Map wireFormatParams, Collection commands) {
        for (Command command : commands) {
            if (command.getId().equals(Command.APPEND_VERSION)) {
                m5780a(wireFormatParams, command.getUrlParam(), command.getValue());
                return;
            }
        }
    }

    private void m5780a(Map wireFormatParams, String versionUrlParam, String clientVersion) {
        String version = clientVersion;
        if (clientVersion == null) {
            version = "";
        } else {
            version = clientVersion + "";
        }
        if (versionUrlParam != null) {
            wireFormatParams.put(versionUrlParam, version);
        }
    }

    private void m5786f() {
        int hitsOverLimit = (m5793c() - 2000) + 1;
        if (hitsOverLimit > 0) {
            Collection hitsToDelete = m5787a(hitsOverLimit);
            Log.m5759i("Store full, deleting " + hitsToDelete.size() + " hits to make room");
            m5790a(hitsToDelete);
        }
    }

    private void m5779a(Map hit, long hitTimeInMilliseconds, String path) {
        SQLiteDatabase db = m5776a("Error opening database for putHit");
        if (db != null) {
            ContentValues content = new ContentValues();
            content.put("hit_string", m5778a(hit));
            content.put("hit_time", Long.valueOf(hitTimeInMilliseconds));
            long appSystemId = 0;
            if (hit.containsKey("AppUID")) {
                try {
                    appSystemId = Long.parseLong((String) hit.get("AppUID"));
                } catch (NumberFormatException e) {
                }
            }
            content.put("hit_app_id", Long.valueOf(appSystemId));
            if (path == null) {
                path = "http://www.google-analytics.com/collect";
            }
            if (path.length() == 0) {
                Log.m5758h("empty path: not sending hit");
                return;
            }
            content.put("hit_url", path);
            try {
                db.insert("hits2", null, content);
                this.f4222d.m5585a(false);
            } catch (SQLiteException e2) {
                Log.m5758h("Error storing hit");
            }
        }
    }

    public static String m5778a(Map urlParams) {
        List keyAndValues = new ArrayList(urlParams.size());
        for (Entry entry : urlParams.entrySet()) {
            keyAndValues.add(((String) entry.getKey()) + "=" + HitBuilder.m5747a((String) entry.getValue()));
        }
        return TextUtils.join("&", keyAndValues);
    }

    public List m5787a(int maxHits) {
        Hit hit;
        SQLiteException e;
        List arrayList;
        Throwable th;
        SQLiteDatabase db = m5776a("Error opening database for peekHits");
        if (db == null) {
            return new ArrayList();
        }
        Cursor cursor = null;
        List hits = new ArrayList();
        try {
            cursor = db.query("hits2", new String[]{"hit_id", "hit_time", "hit_url"}, null, null, null, null, String.format("%s ASC, %s ASC", new Object[]{"hit_url", "hit_id"}), Integer.toString(maxHits));
            List<Hit> hits2 = new ArrayList();
            try {
                if (cursor.moveToFirst()) {
                    do {
                        hit = new Hit(null, cursor.getLong(0), cursor.getLong(1));
                        hit.m5743b(cursor.getString(2));
                        hits2.add(hit);
                    } while (cursor.moveToNext());
                }
                if (cursor != null) {
                    cursor.close();
                }
                int count = 0;
                SQLiteDatabase sQLiteDatabase = db;
                cursor = sQLiteDatabase.query("hits2", new String[]{"hit_id", "hit_string"}, null, null, null, null, String.format("%s ASC", new Object[]{"hit_id"}), Integer.toString(maxHits));
                if (cursor.moveToFirst()) {
                    do {
                        if (cursor instanceof SQLiteCursor) {
                            if (((SQLiteCursor) cursor).getWindow().getNumRows() > 0) {
                                ((Hit) hits2.get(count)).m5741a(cursor.getString(1));
                            } else {
                                try {
                                    Log.m5758h("hitString for hitId " + ((Hit) hits2.get(count)).m5742b() + " too large.  Hit will be deleted.");
                                } catch (SQLiteException e2) {
                                    Log.m5758h("error in peekHits fetching hitString: " + e2.getMessage());
                                    List partialHits = new ArrayList();
                                    boolean foundOneBadHit = false;
                                    for (Hit hit2 : hits2) {
                                        if (TextUtils.isEmpty(hit2.m5740a())) {
                                            if (foundOneBadHit) {
                                                break;
                                            }
                                            foundOneBadHit = true;
                                        }
                                        partialHits.add(hit2);
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return partialHits;
                                } catch (Throwable th2) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                }
                            }
                        } else {
                            ((Hit) hits2.get(count)).m5741a(cursor.getString(1));
                        }
                        count++;
                    } while (cursor.moveToNext());
                }
                if (cursor == null) {
                    return hits2;
                }
                cursor.close();
                return hits2;
            } catch (SQLiteException e3) {
                e2 = e3;
                hits = hits2;
                try {
                    Log.m5758h("error in peekHits fetching hitIds: " + e2.getMessage());
                    arrayList = new ArrayList();
                    if (cursor != null) {
                        return arrayList;
                    }
                    cursor.close();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                hits = hits2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e4) {
            e2 = e4;
            Log.m5758h("error in peekHits fetching hitIds: " + e2.getMessage());
            arrayList = new ArrayList();
            if (cursor != null) {
                return arrayList;
            }
            cursor.close();
            return arrayList;
        }
    }

    int m5792b() {
        boolean z = true;
        long now = this.f4226h.m5593a();
        if (now <= this.f4225g + 86400000) {
            return 0;
        }
        this.f4225g = now;
        SQLiteDatabase db = m5776a("Error opening database for deleteStaleHits");
        if (db == null) {
            return 0;
        }
        long lastGoodTime = this.f4226h.m5593a() - 2592000000L;
        int rslt = db.delete("hits2", "HIT_TIME < ?", new String[]{Long.toString(lastGoodTime)});
        AnalyticsStoreStateListener analyticsStoreStateListener = this.f4222d;
        if (m5793c() != 0) {
            z = false;
        }
        analyticsStoreStateListener.m5585a(z);
        return rslt;
    }

    public void m5790a(Collection hits) {
        if (hits == null) {
            throw new NullPointerException("hits cannot be null");
        } else if (!hits.isEmpty()) {
            SQLiteDatabase db = m5776a("Error opening database for deleteHit");
            if (db != null) {
                String[] ids = new String[hits.size()];
                String whereClause = String.format("HIT_ID in (%s)", new Object[]{TextUtils.join(",", Collections.nCopies(ids.length, "?"))});
                int i = 0;
                for (Hit hit : hits) {
                    int i2 = i + 1;
                    ids[i] = Long.toString(hit.m5742b());
                    i = i2;
                }
                try {
                    db.delete("hits2", whereClause, ids);
                    this.f4222d.m5585a(m5793c() == 0);
                } catch (SQLiteException e) {
                    Log.m5758h("Error deleting hit " + hits);
                }
            }
        }
    }

    int m5793c() {
        int numStoredHits = 0;
        SQLiteDatabase db = m5776a("Error opening database for requestNumHitsPending");
        if (db == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            cursor = db.rawQuery("SELECT COUNT(*) from hits2", null);
            if (cursor.moveToFirst()) {
                numStoredHits = (int) cursor.getLong(0);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteException e) {
            Log.m5758h("Error getting numStoredHits");
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return numStoredHits;
    }

    public void m5788a() {
        Log.m5757g("dispatch running...");
        if (this.f4221c.m5595a()) {
            List hits = m5787a(40);
            if (hits.isEmpty()) {
                Log.m5757g("...nothing to dispatch");
                this.f4222d.m5585a(true);
                return;
            }
            int hitsDispatched = this.f4221c.m5594a(hits);
            Log.m5757g("sent " + hitsDispatched + " of " + hits.size() + " hits");
            m5790a(hits.subList(0, Math.min(hitsDispatched, hits.size())));
            if (hitsDispatched == hits.size() && m5793c() > 0) {
                GAServiceManager.m5643a().m5656c();
            }
        }
    }

    private SQLiteDatabase m5776a(String errorMessage) {
        try {
            return this.f4220b.getWritableDatabase();
        } catch (SQLiteException e) {
            Log.m5758h(errorMessage);
            return null;
        }
    }
}
