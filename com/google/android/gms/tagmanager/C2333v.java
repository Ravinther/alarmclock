package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.gl;
import com.google.android.gms.internal.gn;
import com.google.android.gms.tagmanager.DataLayer.C2243c;
import com.google.android.gms.tagmanager.DataLayer.C2243c.C2245a;
import com.google.android.gms.tagmanager.DataLayer.C2247a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: com.google.android.gms.tagmanager.v */
class C2333v implements C2243c {
    private static final String XB;
    private gl Wv;
    private final Executor XC;
    private C2331a XD;
    private int XE;
    private final Context mContext;

    /* renamed from: com.google.android.gms.tagmanager.v.1 */
    class C23281 implements Runnable {
        final /* synthetic */ List XF;
        final /* synthetic */ long XG;
        final /* synthetic */ C2333v XH;

        C23281(C2333v c2333v, List list, long j) {
            this.XH = c2333v;
            this.XF = list;
            this.XG = j;
        }

        public void run() {
            this.XH.m9591b(this.XF, this.XG);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.2 */
    class C23292 implements Runnable {
        final /* synthetic */ C2333v XH;
        final /* synthetic */ C2245a XI;

        C23292(C2333v c2333v, C2245a c2245a) {
            this.XH = c2333v;
            this.XI = c2245a;
        }

        public void run() {
            this.XI.m9281a(this.XH.ks());
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.3 */
    class C23303 implements Runnable {
        final /* synthetic */ C2333v XH;
        final /* synthetic */ String XJ;

        C23303(C2333v c2333v, String str) {
            this.XH = c2333v;
            this.XJ = str;
        }

        public void run() {
            this.XH.by(this.XJ);
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.a */
    class C2331a extends SQLiteOpenHelper {
        final /* synthetic */ C2333v XH;

        C2331a(C2333v c2333v, Context context, String str) {
            this.XH = c2333v;
            super(context, str, null, 1);
        }

        private void m9583a(SQLiteDatabase sQLiteDatabase) {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            Set hashSet = new HashSet();
            try {
                String[] columnNames = rawQuery.getColumnNames();
                for (Object add : columnNames) {
                    hashSet.add(add);
                }
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
                    throw new SQLiteException("Database column missing");
                } else if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } finally {
                rawQuery.close();
            }
        }

        private boolean m9584a(String str, SQLiteDatabase sQLiteDatabase) {
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
                        bh.m9376z("Error querying for table " + str);
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
                bh.m9376z("Error querying for table " + str);
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
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                this.XH.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return sQLiteDatabase == null ? super.getWritableDatabase() : sQLiteDatabase;
        }

        public void onCreate(SQLiteDatabase db) {
            ak.m9327G(db.getPath());
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
            if (m9584a("datalayer", db)) {
                m9583a(db);
            } else {
                db.execSQL(C2333v.XB);
            }
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /* renamed from: com.google.android.gms.tagmanager.v.b */
    private static class C2332b {
        final byte[] XK;
        final String Xy;

        C2332b(String str, byte[] bArr) {
            this.Xy = str;
            this.XK = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.Xy + " serialized hash = " + Arrays.hashCode(this.XK);
        }
    }

    static {
        XB = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
    }

    public C2333v(Context context) {
        this(context, gn.ft(), "google_tagmanager.db", GamesStatusCodes.STATUS_REQUEST_UPDATE_PARTIAL_SUCCESS, Executors.newSingleThreadExecutor());
    }

    C2333v(Context context, gl glVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.Wv = glVar;
        this.XE = i;
        this.XC = executor;
        this.XD = new C2331a(this, this.mContext, str);
    }

    private SQLiteDatabase m9585L(String str) {
        try {
            return this.XD.getWritableDatabase();
        } catch (SQLiteException e) {
            bh.m9376z(str);
            return null;
        }
    }

    private List m9590b(List list) {
        List arrayList = new ArrayList();
        for (C2332b c2332b : list) {
            arrayList.add(new C2247a(c2332b.Xy, m9595j(c2332b.XK)));
        }
        return arrayList;
    }

    private synchronized void m9591b(List list, long j) {
        try {
            long currentTimeMillis = this.Wv.currentTimeMillis();
            m9597u(currentTimeMillis);
            cb(list.size());
            m9593c(list, currentTimeMillis + j);
            kv();
        } catch (Throwable th) {
            kv();
        }
    }

    private void by(String str) {
        SQLiteDatabase L = m9585L("Error opening database for clearKeysWithPrefix.");
        if (L != null) {
            try {
                bh.m9375y("Cleared " + L.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
            } catch (SQLiteException e) {
                bh.m9376z("Error deleting entries with key prefix: " + str + " (" + e + ").");
            } finally {
                kv();
            }
        }
    }

    private List m9592c(List list) {
        List arrayList = new ArrayList();
        for (C2247a c2247a : list) {
            arrayList.add(new C2332b(c2247a.Xy, m9596j(c2247a.Xz)));
        }
        return arrayList;
    }

    private void m9593c(List list, long j) {
        SQLiteDatabase L = m9585L("Error opening database for writeEntryToDatabase.");
        if (L != null) {
            for (C2332b c2332b : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("expires", Long.valueOf(j));
                contentValues.put("key", c2332b.Xy);
                contentValues.put("value", c2332b.XK);
                L.insert("datalayer", null, contentValues);
            }
        }
    }

    private void cb(int i) {
        int ku = (ku() - this.XE) + i;
        if (ku > 0) {
            List cc = cc(ku);
            bh.m9374x("DataLayer store full, deleting " + cc.size() + " entries to make room.");
            m9594g((String[]) cc.toArray(new String[0]));
        }
    }

    private List cc(int i) {
        SQLiteException e;
        Throwable th;
        List arrayList = new ArrayList();
        if (i <= 0) {
            bh.m9376z("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase L = m9585L("Error opening database for peekEntryIds.");
        if (L == null) {
            return arrayList;
        }
        Cursor query;
        try {
            query = L.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", new Object[]{"ID"}), Integer.toString(i));
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
                    bh.m9376z("Error in peekEntries fetching entryIds: " + e.getMessage());
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
            bh.m9376z("Error in peekEntries fetching entryIds: " + e.getMessage());
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

    private void m9594g(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase L = m9585L("Error opening database for deleteEntries.");
            if (L != null) {
                try {
                    L.delete("datalayer", String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))}), strArr);
                } catch (SQLiteException e) {
                    bh.m9376z("Error deleting entries " + Arrays.toString(strArr));
                }
            }
        }
    }

    private Object m9595j(byte[] bArr) {
        Object readObject;
        Throwable th;
        ObjectInputStream objectInputStream = null;
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2;
        try {
            objectInputStream2 = new ObjectInputStream(byteArrayInputStream);
            try {
                readObject = objectInputStream2.readObject();
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (ClassNotFoundException e4) {
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
                return readObject;
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (ClassNotFoundException e8) {
            objectInputStream2 = objectInputStream;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            return readObject;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectInputStream2 = objectInputStream;
            th = th4;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            byteArrayInputStream.close();
            throw th;
        }
        return readObject;
    }

    private byte[] m9596j(Object obj) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] bArr = null;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                bArr = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = bArr;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            return bArr;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            objectOutputStream = bArr;
            th = th4;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
        return bArr;
    }

    private List ks() {
        try {
            m9597u(this.Wv.currentTimeMillis());
            List b = m9590b(kt());
            return b;
        } finally {
            kv();
        }
    }

    private List kt() {
        SQLiteDatabase L = m9585L("Error opening database for loadSerialized.");
        List arrayList = new ArrayList();
        if (L == null) {
            return arrayList;
        }
        Cursor query = L.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (query.moveToNext()) {
            try {
                arrayList.add(new C2332b(query.getString(0), query.getBlob(1)));
            } finally {
                query.close();
            }
        }
        return arrayList;
    }

    private int ku() {
        Cursor cursor = null;
        int i = 0;
        SQLiteDatabase L = m9585L("Error opening database for getNumStoredEntries.");
        if (L != null) {
            try {
                cursor = L.rawQuery("SELECT COUNT(*) from datalayer", null);
                if (cursor.moveToFirst()) {
                    i = (int) cursor.getLong(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (SQLiteException e) {
                bh.m9376z("Error getting numStoredEntries");
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

    private void kv() {
        try {
            this.XD.close();
        } catch (SQLiteException e) {
        }
    }

    private void m9597u(long j) {
        SQLiteDatabase L = m9585L("Error opening database for deleteOlderThan.");
        if (L != null) {
            try {
                bh.m9375y("Deleted " + L.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
            } catch (SQLiteException e) {
                bh.m9376z("Error deleting old entries.");
            }
        }
    }

    public void m9598a(C2245a c2245a) {
        this.XC.execute(new C23292(this, c2245a));
    }

    public void m9599a(List list, long j) {
        this.XC.execute(new C23281(this, m9592c(list), j));
    }

    public void bx(String str) {
        this.XC.execute(new C23303(this, str));
    }
}
