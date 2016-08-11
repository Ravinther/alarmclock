package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.mopub.mobileads.CustomEventInterstitialAdapter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

final class AdCache {
    private static final String CACHED_AD_FILE = "ad.dat";
    private static final String CACHE_INCOMPLETE_PREFIX = "incompleteDownload_";
    private static final String CACHE_PREFIX = "nextCachedAd_";
    private static final String CACHE_PREFIX_APID = "nextCachedAd_apids";
    private static final String LOCK_FILE = "ad.lock";
    static final int PRIORITY_FETCH = 3;
    static final int PRIORITY_PRECACHE = 1;
    static final int PRIORITY_REFRESH = 2;
    static final String PRIVATE_CACHE_DIR = ".mmsyscache";
    private static Set apidListSet;
    private static String cachedVideoList;
    private static boolean cachedVideoListLoaded;
    private static Set cachedVideoSet;
    private static Map incompleteDownloadHashMap;
    private static boolean incompleteDownloadHashMapLoaded;
    static boolean isExternalEnabled;
    private static Map nextCachedAdHashMap;
    private static boolean nextCachedAdHashMapLoaded;

    static class Iterator {
        static final int ITERATE_ID = 0;
        static final int ITERATE_INFO = 1;
        static final int ITERATE_OBJECT = 2;

        Iterator() {
        }

        boolean callback(String id) {
            return false;
        }

        boolean callback(String id, int type, Date expiration, String acid, long deferredViewStart, ObjectInputStream objectInputStream) {
            return false;
        }

        boolean callback(CachedAd ad) {
            return false;
        }

        void done() {
        }
    }

    /* renamed from: com.millennialmedia.android.AdCache.1 */
    static class C24341 extends Iterator {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Set val$hashSet;

        C24341(Context context, Set set) {
            this.val$context = context;
            this.val$hashSet = set;
        }

        boolean callback(CachedAd cachedAd) {
            if (cachedAd.acid != null && cachedAd.getType() == AdCache.PRIORITY_PRECACHE && cachedAd.isOnDisk(this.val$context)) {
                this.val$hashSet.add(cachedAd.acid);
            }
            return true;
        }
    }

    /* renamed from: com.millennialmedia.android.AdCache.2 */
    static class C24352 implements FileFilter {
        C24352() {
        }

        public boolean accept(File file) {
            return !file.isDirectory() && file.getName().endsWith(AdCache.CACHED_AD_FILE);
        }
    }

    /* renamed from: com.millennialmedia.android.AdCache.3 */
    static class C24363 implements Runnable {
        final /* synthetic */ Context val$context;

        C24363(Context context) {
            this.val$context = context;
        }

        public void run() {
            Log.m9711d("AdCache");
            AdCache.cleanUpExpiredAds(this.val$context);
            AdCache.cleanupCache(this.val$context);
        }
    }

    /* renamed from: com.millennialmedia.android.AdCache.4 */
    static class C24374 extends Iterator {
        final /* synthetic */ Context val$context;

        C24374(Context context) {
            this.val$context = context;
        }

        boolean callback(String id, int type, Date expiration, String acid, long deferredViewStart, ObjectInputStream objectInputStream) {
            if (expiration != null && expiration.getTime() <= System.currentTimeMillis()) {
                Object[] objArr;
                try {
                    CachedAd ad = (CachedAd) objectInputStream.readObject();
                    objArr = new Object[AdCache.PRIORITY_PRECACHE];
                    objArr[0] = ad.getId();
                    Log.m9712d("Deleting expired ad %s.", objArr);
                    ad.delete(this.val$context);
                } catch (Throwable e) {
                    objArr = new Object[AdCache.PRIORITY_PRECACHE];
                    objArr[0] = id;
                    Log.m9712d("There was a problem reading the cached ad %s.", objArr);
                    Log.m9713d(e);
                }
            }
            return true;
        }
    }

    /* renamed from: com.millennialmedia.android.AdCache.5 */
    static class C24385 extends Iterator {
        final /* synthetic */ Context val$context;

        C24385(Context context) {
            this.val$context = context;
        }

        boolean callback(CachedAd ad) {
            Object[] objArr = new Object[AdCache.PRIORITY_PRECACHE];
            objArr[0] = ad.getId();
            Log.m9712d("Deleting ad %s.", objArr);
            ad.delete(this.val$context);
            return true;
        }
    }

    interface AdCacheTaskListener {
        void downloadCompleted(CachedAd cachedAd, boolean z);

        void downloadStart(CachedAd cachedAd);
    }

    private AdCache() {
    }

    static boolean startDownloadTask(Context context, String adName, CachedAd ad, AdCacheTaskListener listener) {
        return AdCacheThreadPool.sharedThreadPool().startDownloadTask(context, adName, ad, listener);
    }

    static synchronized void cachedVideoWasAdded(Context context, String acid) {
        synchronized (AdCache.class) {
            if (acid != null) {
                if (!cachedVideoListLoaded) {
                    getCachedVideoList(context);
                }
                if (cachedVideoSet == null) {
                    cachedVideoSet = new HashSet();
                }
                cachedVideoSet.add(acid);
                cachedVideoList = null;
            }
        }
    }

    static synchronized void cachedVideoWasRemoved(Context context, String acid) {
        synchronized (AdCache.class) {
            if (acid != null) {
                if (!cachedVideoListLoaded) {
                    getCachedVideoList(context);
                }
                if (cachedVideoSet != null) {
                    cachedVideoSet.remove(acid);
                    cachedVideoList = null;
                }
            }
        }
    }

    static synchronized String getCachedVideoList(Context context) {
        String str;
        synchronized (AdCache.class) {
            if (cachedVideoList == null) {
                if (!cachedVideoListLoaded) {
                    Set hashSet = new HashSet();
                    iterateCachedAds(context, PRIORITY_REFRESH, new C24341(context, hashSet));
                    cachedVideoSet = hashSet;
                    cachedVideoListLoaded = true;
                }
                if (cachedVideoSet != null && cachedVideoSet.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String acid : cachedVideoSet) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append("," + acid);
                        } else {
                            stringBuilder.append(acid);
                        }
                    }
                    cachedVideoList = stringBuilder.toString();
                }
            }
            str = cachedVideoList;
        }
        return str;
    }

    private static void loadNextCachedAdHashMap(Context context) {
        SharedPreferences settings = context.getSharedPreferences("MillennialMediaSettings", 0);
        nextCachedAdHashMap = new ConcurrentHashMap();
        if (apidListSet == null) {
            loadApidListSet(settings);
        }
        for (String apid : apidListSet) {
            String[] arr$ = MMAdImpl.getAdTypes();
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; i$ += PRIORITY_PRECACHE) {
                String adType = arr$[i$];
                String result = settings.getString(CACHE_PREFIX + adType + '_' + apid, null);
                if (result != null) {
                    nextCachedAdHashMap.put(adType + '_' + apid, result);
                }
            }
        }
        nextCachedAdHashMapLoaded = true;
    }

    private static void saveNextCachedAdHashMapValue(Context context, String adName) {
        if (adName != null) {
            Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            saveApidListSet(editor, adName);
            editor.putString(CACHE_PREFIX + adName, (String) nextCachedAdHashMap.get(adName));
            editor.commit();
        }
    }

    static synchronized String getNextCachedAd(Context context, String adName) {
        String str;
        synchronized (AdCache.class) {
            if (!nextCachedAdHashMapLoaded) {
                loadNextCachedAdHashMap(context);
            }
            str = adName == null ? null : (String) nextCachedAdHashMap.get(adName);
        }
        return str;
    }

    static CachedAd loadNextCachedAd(Context context, String adName) {
        String nextAd = getNextCachedAd(context, adName);
        return (nextAd == null || nextAd.equals("")) ? null : load(context, nextAd);
    }

    static synchronized void setNextCachedAd(Context context, String adName, String id) {
        synchronized (AdCache.class) {
            if (!nextCachedAdHashMapLoaded) {
                loadNextCachedAdHashMap(context);
            }
            if (adName != null) {
                Map map = nextCachedAdHashMap;
                if (id == null) {
                    id = "";
                }
                map.put(adName, id);
                saveNextCachedAdHashMapValue(context, adName);
            }
        }
    }

    private static void loadIncompleteDownloadHashMap(Context context) {
        SharedPreferences settings = context.getSharedPreferences("MillennialMediaSettings", 0);
        incompleteDownloadHashMap = new ConcurrentHashMap();
        if (apidListSet == null) {
            loadApidListSet(settings);
        }
        for (String apid : apidListSet) {
            String[] arr$ = MMAdImpl.getAdTypes();
            int len$ = arr$.length;
            for (int i$ = 0; i$ < len$; i$ += PRIORITY_PRECACHE) {
                String adType = arr$[i$];
                String result = settings.getString(CACHE_INCOMPLETE_PREFIX + adType + '_' + apid, null);
                if (result != null) {
                    incompleteDownloadHashMap.put(adType + '_' + apid, result);
                }
            }
        }
        incompleteDownloadHashMapLoaded = true;
    }

    private static void saveIncompleteDownloadHashMap(Context context, String adName) {
        if (adName != null) {
            Editor editor = context.getSharedPreferences("MillennialMediaSettings", 0).edit();
            saveApidListSet(editor, adName);
            editor.putString(CACHE_INCOMPLETE_PREFIX + adName, (String) incompleteDownloadHashMap.get(adName));
            editor.commit();
        }
    }

    static synchronized String getIncompleteDownload(Context context, String adName) {
        String str;
        synchronized (AdCache.class) {
            if (!incompleteDownloadHashMapLoaded) {
                loadIncompleteDownloadHashMap(context);
            }
            str = adName == null ? null : (String) incompleteDownloadHashMap.get(adName);
        }
        return str;
    }

    static CachedAd loadIncompleteDownload(Context context, String adName) {
        String nextIncompleteAd = getIncompleteDownload(context, adName);
        return nextIncompleteAd == null ? null : load(context, nextIncompleteAd);
    }

    static synchronized void setIncompleteDownload(Context context, String adName, String id) {
        synchronized (AdCache.class) {
            if (!incompleteDownloadHashMapLoaded) {
                loadIncompleteDownloadHashMap(context);
            }
            if (adName != null) {
                Map map = incompleteDownloadHashMap;
                if (id == null) {
                    id = "";
                }
                map.put(adName, id);
                saveIncompleteDownloadHashMap(context, adName);
            }
        }
    }

    private static void loadApidListSet(SharedPreferences settings) {
        apidListSet = new HashSet();
        String apids = settings.getString(CACHE_PREFIX_APID, null);
        if (apids != null) {
            String[] apidArray = apids.split(MMSDK.COMMA);
            if (apidArray != null && apidArray.length > 0) {
                String[] arr$ = apidArray;
                int len$ = arr$.length;
                for (int i$ = 0; i$ < len$; i$ += PRIORITY_PRECACHE) {
                    apidListSet.add(arr$[i$]);
                }
            }
        }
    }

    private static void saveApidListSet(Editor editor, String adName) {
        int start = adName.indexOf(95);
        if (start >= 0 && start < adName.length()) {
            String apid = adName.substring(start + PRIORITY_PRECACHE);
            if (apid != null && !apidListSet.contains(apid)) {
                StringBuilder builder = null;
                if (!apidListSet.isEmpty()) {
                    builder = new StringBuilder();
                    for (String str : apidListSet) {
                        builder.append(str + MMSDK.COMMA);
                    }
                }
                editor.putString(CACHE_PREFIX_APID, (builder == null ? "" : builder.toString()) + apid);
                apidListSet.add(apid);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void iterateCachedAds(android.content.Context r21, int r22, com.millennialmedia.android.AdCache.Iterator r23) {
        /*
        r14 = getCacheDirectory(r21);
        r10 = 0;
        r2 = 0;
        if (r14 == 0) goto L_0x004e;
    L_0x0008:
        r3 = new com.millennialmedia.android.AdCache$2;
        r3.<init>();
        r12 = r14.listFiles(r3);
        if (r12 == 0) goto L_0x004e;
    L_0x0013:
        r13 = r12;
        r0 = r13.length;
        r17 = r0;
        r16 = 0;
        r18 = r10;
    L_0x001b:
        r0 = r16;
        r1 = r17;
        if (r0 >= r1) goto L_0x00fc;
    L_0x0021:
        r11 = r13[r16];
        if (r11 == 0) goto L_0x002b;
    L_0x0025:
        r3 = r11.exists();	 Catch:{ Exception -> 0x00be, all -> 0x00dc }
        if (r3 != 0) goto L_0x003a;
    L_0x002b:
        if (r18 == 0) goto L_0x00f8;
    L_0x002d:
        r18.close();	 Catch:{ IOException -> 0x0036 }
        r10 = 0;
    L_0x0031:
        r16 = r16 + 1;
        r18 = r10;
        goto L_0x001b;
    L_0x0036:
        r3 = move-exception;
        r10 = r18;
        goto L_0x0031;
    L_0x003a:
        if (r22 != 0) goto L_0x0061;
    L_0x003c:
        r3 = r11.getName();	 Catch:{ Exception -> 0x00be, all -> 0x00dc }
        r0 = r23;
        r3 = r0.callback(r3);	 Catch:{ Exception -> 0x00be, all -> 0x00dc }
        if (r3 != 0) goto L_0x0056;
    L_0x0048:
        if (r18 == 0) goto L_0x00fc;
    L_0x004a:
        r18.close();	 Catch:{ IOException -> 0x0052 }
        r10 = 0;
    L_0x004e:
        r23.done();
        return;
    L_0x0052:
        r3 = move-exception;
        r10 = r18;
        goto L_0x004e;
    L_0x0056:
        if (r18 == 0) goto L_0x00f8;
    L_0x0058:
        r18.close();	 Catch:{ IOException -> 0x005d }
        r10 = 0;
        goto L_0x0031;
    L_0x005d:
        r3 = move-exception;
        r10 = r18;
        goto L_0x0031;
    L_0x0061:
        r10 = new java.io.ObjectInputStream;	 Catch:{ Exception -> 0x00be, all -> 0x00dc }
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00be, all -> 0x00dc }
        r3.<init>(r11);	 Catch:{ Exception -> 0x00be, all -> 0x00dc }
        r10.<init>(r3);	 Catch:{ Exception -> 0x00be, all -> 0x00dc }
        r5 = r10.readInt();	 Catch:{ Exception -> 0x00f6 }
        r6 = r10.readObject();	 Catch:{ Exception -> 0x00f6 }
        r6 = (java.util.Date) r6;	 Catch:{ Exception -> 0x00f6 }
        r7 = r10.readObject();	 Catch:{ Exception -> 0x00f6 }
        r7 = (java.lang.String) r7;	 Catch:{ Exception -> 0x00f6 }
        r8 = r10.readLong();	 Catch:{ Exception -> 0x00f6 }
        r3 = 1;
        r0 = r22;
        if (r0 != r3) goto L_0x009b;
    L_0x0084:
        r4 = r11.getName();	 Catch:{ Exception -> 0x00f6 }
        r3 = r23;
        r3 = r3.callback(r4, r5, r6, r7, r8, r10);	 Catch:{ Exception -> 0x00f6 }
        if (r3 != 0) goto L_0x00b6;
    L_0x0090:
        r10.close();	 Catch:{ Exception -> 0x00f6 }
        r10 = 0;
        if (r10 == 0) goto L_0x004e;
    L_0x0096:
        r10.close();	 Catch:{ IOException -> 0x00e6 }
        r10 = 0;
        goto L_0x004e;
    L_0x009b:
        r3 = r10.readObject();	 Catch:{ Exception -> 0x00f6 }
        r0 = r3;
        r0 = (com.millennialmedia.android.CachedAd) r0;	 Catch:{ Exception -> 0x00f6 }
        r2 = r0;
        r0 = r23;
        r3 = r0.callback(r2);	 Catch:{ Exception -> 0x00f6 }
        if (r3 != 0) goto L_0x00b6;
    L_0x00ab:
        r10.close();	 Catch:{ Exception -> 0x00f6 }
        r10 = 0;
        if (r10 == 0) goto L_0x004e;
    L_0x00b1:
        r10.close();	 Catch:{ IOException -> 0x00e9 }
        r10 = 0;
        goto L_0x004e;
    L_0x00b6:
        if (r10 == 0) goto L_0x0031;
    L_0x00b8:
        r10.close();	 Catch:{ IOException -> 0x00ec }
        r10 = 0;
        goto L_0x0031;
    L_0x00be:
        r15 = move-exception;
        r10 = r18;
    L_0x00c1:
        r3 = "There was a problem reading the cached ad %s.";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00f4 }
        r19 = 0;
        r20 = r11.getName();	 Catch:{ all -> 0x00f4 }
        r4[r19] = r20;	 Catch:{ all -> 0x00f4 }
        com.millennialmedia.android.MMSDK.Log.m9712d(r3, r4);	 Catch:{ all -> 0x00f4 }
        com.millennialmedia.android.MMSDK.Log.m9713d(r15);	 Catch:{ all -> 0x00f4 }
        if (r10 == 0) goto L_0x0031;
    L_0x00d6:
        r10.close();	 Catch:{ IOException -> 0x00ef }
        r10 = 0;
        goto L_0x0031;
    L_0x00dc:
        r3 = move-exception;
        r10 = r18;
    L_0x00df:
        if (r10 == 0) goto L_0x00e5;
    L_0x00e1:
        r10.close();	 Catch:{ IOException -> 0x00f2 }
        r10 = 0;
    L_0x00e5:
        throw r3;
    L_0x00e6:
        r3 = move-exception;
        goto L_0x004e;
    L_0x00e9:
        r3 = move-exception;
        goto L_0x004e;
    L_0x00ec:
        r3 = move-exception;
        goto L_0x0031;
    L_0x00ef:
        r3 = move-exception;
        goto L_0x0031;
    L_0x00f2:
        r4 = move-exception;
        goto L_0x00e5;
    L_0x00f4:
        r3 = move-exception;
        goto L_0x00df;
    L_0x00f6:
        r15 = move-exception;
        goto L_0x00c1;
    L_0x00f8:
        r10 = r18;
        goto L_0x0031;
    L_0x00fc:
        r10 = r18;
        goto L_0x004e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.millennialmedia.android.AdCache.iterateCachedAds(android.content.Context, int, com.millennialmedia.android.AdCache$Iterator):void");
    }

    static void cleanCache(Context context) {
        ThreadUtils.execute(new C24363(context));
    }

    static void cleanUpExpiredAds(Context context) {
        iterateCachedAds(context, PRIORITY_PRECACHE, new C24374(context));
    }

    static void cleanupCache(Context context) {
        cleanupInternalCache(context);
        if (isExternalStorageAvailable(context)) {
            cleanupExternalCache(context);
        }
    }

    private static void cleanupInternalCache(Context context) {
        File internalCacheDir = getInternalCacheDirectory(context);
        if (internalCacheDir != null && internalCacheDir.exists() && internalCacheDir.isDirectory()) {
            cleanupDirectory(internalCacheDir, HandShake.sharedHandShake(context).creativeCacheTimeout);
        }
    }

    private static void cleanupExternalCache(Context context) {
        File externalCacheDir = getExternalCacheDirectory(context);
        if (externalCacheDir != null && externalCacheDir.exists() && externalCacheDir.isDirectory()) {
            cleanupDirectory(externalCacheDir, HandShake.sharedHandShake(context).creativeCacheTimeout);
        }
    }

    static void cleanupDirectory(File file, long timeout) {
        File[] arr$ = file.listFiles();
        int len$ = arr$.length;
        for (int i$ = 0; i$ < len$; i$ += PRIORITY_PRECACHE) {
            File entry = arr$[i$];
            if (entry.isFile()) {
                if (System.currentTimeMillis() - entry.lastModified() > timeout) {
                    entry.delete();
                }
            } else if (entry.isDirectory()) {
                try {
                    cleanupDirectory(entry, timeout);
                    if (entry.list().length == 0) {
                        entry.delete();
                    }
                } catch (SecurityException e) {
                }
            }
        }
    }

    static void resetCache(Context context) {
        iterateCachedAds(context, PRIORITY_REFRESH, new C24385(context));
        cachedVideoSet = null;
        cachedVideoList = null;
        cachedVideoListLoaded = false;
        if (nextCachedAdHashMap != null) {
            for (String key : nextCachedAdHashMap.keySet()) {
                setNextCachedAd(context, key, null);
            }
        }
        if (incompleteDownloadHashMap != null) {
            for (String key2 : incompleteDownloadHashMap.keySet()) {
                setIncompleteDownload(context, key2, null);
            }
        }
    }

    static File getDownloadFile(Context context, String name) {
        File dir = getCacheDirectory(context);
        if (dir != null) {
            return new File(dir, name);
        }
        return null;
    }

    static boolean hasDownloadFile(Context context, String name) {
        File file = getDownloadFile(context, name);
        return file != null && file.exists();
    }

    static File getCacheDirectory(Context context) {
        if (isExternalStorageAvailable(context)) {
            return getExternalCacheDirectory(context);
        }
        return getInternalCacheDirectory(context);
    }

    private static File getExternalCacheDirectory(Context context) {
        File externalStorageDir = Environment.getExternalStorageDirectory();
        if (externalStorageDir == null) {
            return null;
        }
        File extCacheDir = new File(externalStorageDir, PRIVATE_CACHE_DIR);
        if (extCacheDir.exists() || extCacheDir.mkdirs()) {
            return extCacheDir;
        }
        return null;
    }

    static File getInternalCacheDirectory(Context context) {
        if (context == null) {
            return null;
        }
        File cacheDir = new File(context.getFilesDir(), PRIVATE_CACHE_DIR);
        if (cacheDir == null || cacheDir.exists() || cacheDir.mkdirs()) {
            return cacheDir;
        }
        return null;
    }

    private static File getCachedAdFile(Context context, String id) {
        String fileName = id + CACHED_AD_FILE;
        boolean isExternalStateMounted = isExternalStorageAvailable(context);
        File cacheDir = getCacheDirectory(context);
        File adFile = null;
        if (cacheDir != null) {
            try {
                if (cacheDir.isDirectory()) {
                    adFile = new File(cacheDir, fileName);
                }
            } catch (Throwable e) {
                Log.m9716e(e);
                return null;
            }
        }
        if ((adFile == null || !adFile.exists()) && !isExternalStateMounted) {
            File internalCacheDir = context.getFilesDir();
            if (internalCacheDir != null) {
                File internalFile = new File(internalCacheDir, PRIVATE_CACHE_DIR + File.separator + fileName);
                if (internalFile.exists() && internalFile.isFile()) {
                    return internalFile;
                }
            }
        }
        return adFile;
    }

    static boolean downloadComponentToCache(String urlString, String name, Context context) {
        return downloadComponent(urlString, name, getCacheDirectory(context), context);
    }

    static boolean downloadComponent(String urlString, String name, File path, Context context) {
        if (TextUtils.isEmpty(urlString)) {
            Log.m9711d("No Url ...");
            return false;
        }
        File file = new File(path, name);
        Object[] objArr = new Object[PRIORITY_REFRESH];
        objArr[0] = name;
        objArr[PRIORITY_PRECACHE] = urlString;
        Log.m9724v("Downloading Component: %s from %s", objArr);
        if (!file.exists() || file.length() <= 0) {
            InputStream inStream = null;
            FileOutputStream out = null;
            long contentLength = -1;
            try {
                URL connectURL = new URL(urlString);
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection conn = (HttpURLConnection) connectURL.openConnection();
                conn.setConnectTimeout(CustomEventInterstitialAdapter.DEFAULT_INTERSTITIAL_TIMEOUT_DELAY);
                conn.setRequestMethod("GET");
                conn.connect();
                inStream = conn.getInputStream();
                String temp = conn.getHeaderField("Content-Length");
                if (temp != null) {
                    contentLength = Long.parseLong(temp);
                }
                if (inStream == null) {
                    objArr = new Object[PRIORITY_PRECACHE];
                    objArr[0] = name;
                    Log.m9715e("Connection stream is null downloading %s.", objArr);
                    if (inStream != null) {
                        try {
                            inStream.close();
                        } catch (IOException ex) {
                            objArr = new Object[PRIORITY_PRECACHE];
                            objArr[0] = ex.getMessage();
                            Log.m9715e("Content caching error: %s", objArr);
                            if (file != null) {
                                file.delete();
                            }
                            return false;
                        }
                    }
                    if (out == null) {
                        return false;
                    }
                    out.close();
                    return false;
                }
                if (isInternalDir(context, getCacheDirectory(context))) {
                    out = context.openFileOutput(file.getName(), PRIORITY_PRECACHE);
                } else {
                    out = new FileOutputStream(file);
                }
                byte[] buf = new byte[4096];
                while (true) {
                    int numread = inStream.read(buf);
                    if (numread <= 0) {
                        break;
                    }
                    out.write(buf, 0, numread);
                }
                if (file != null) {
                    try {
                        if (file.length() == contentLength || contentLength == -1) {
                            if (inStream != null) {
                                try {
                                    inStream.close();
                                } catch (IOException ex2) {
                                    objArr = new Object[PRIORITY_PRECACHE];
                                    objArr[0] = ex2.getMessage();
                                    Log.m9715e("Content caching error: %s", objArr);
                                    if (file != null) {
                                        file.delete();
                                    }
                                    return false;
                                }
                            }
                            if (out == null) {
                                return true;
                            }
                            out.close();
                            return true;
                        }
                        Log.m9714e("Content-Length does not match actual length.");
                    } catch (Exception e) {
                        objArr = new Object[PRIORITY_REFRESH];
                        objArr[0] = name;
                        objArr[PRIORITY_PRECACHE] = e.getMessage();
                        Log.m9715e("Exception downloading component %s: %s", objArr);
                    }
                }
                if (inStream != null) {
                    try {
                        inStream.close();
                    } catch (IOException ex22) {
                        objArr = new Object[PRIORITY_PRECACHE];
                        objArr[0] = ex22.getMessage();
                        Log.m9715e("Content caching error: %s", objArr);
                        if (file != null) {
                            file.delete();
                        }
                        return false;
                    }
                }
                if (out != null) {
                    out.close();
                }
                if (file != null) {
                    file.delete();
                }
                return false;
            } catch (Exception e2) {
                objArr = new Object[PRIORITY_REFRESH];
                objArr[0] = name;
                objArr[PRIORITY_PRECACHE] = e2.getMessage();
                Log.m9715e("Exception downloading component %s: %s", objArr);
                if (inStream != null) {
                    try {
                        inStream.close();
                    } catch (IOException ex222) {
                        objArr = new Object[PRIORITY_PRECACHE];
                        objArr[0] = ex222.getMessage();
                        Log.m9715e("Content caching error: %s", objArr);
                        if (file != null) {
                            file.delete();
                        }
                        return false;
                    }
                }
                if (out != null) {
                    out.close();
                }
            } catch (Throwable th) {
                if (inStream != null) {
                    try {
                        inStream.close();
                    } catch (IOException ex2222) {
                        objArr = new Object[PRIORITY_PRECACHE];
                        objArr[0] = ex2222.getMessage();
                        Log.m9715e("Content caching error: %s", objArr);
                        if (file != null) {
                            file.delete();
                        }
                        return false;
                    }
                }
                if (out != null) {
                    out.close();
                }
            }
        } else {
            Log.m9723v(name + " already exists, skipping...");
            return true;
        }
    }

    static CachedAd load(Context context, String id) {
        Object[] objArr;
        Throwable th;
        Throwable e;
        if (id == null || id.equals("")) {
            return null;
        }
        ObjectInputStream objectInputStream = null;
        CachedAd ad = null;
        File cachedAdFile = getCachedAdFile(context, id);
        if (cachedAdFile == null) {
            return null;
        }
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(cachedAdFile));
            try {
                objectInputStream2.readInt();
                Date expiration = (Date) objectInputStream2.readObject();
                objectInputStream2.readObject();
                long deferredViewStart = objectInputStream2.readLong();
                ad = (CachedAd) objectInputStream2.readObject();
                if (objectInputStream2 != null) {
                    try {
                        objectInputStream2.close();
                    } catch (IOException e2) {
                        objectInputStream = objectInputStream2;
                        return ad;
                    }
                }
                objectInputStream = objectInputStream2;
                return ad;
            } catch (FileNotFoundException e3) {
                objectInputStream = objectInputStream2;
                try {
                    objArr = new Object[PRIORITY_PRECACHE];
                    objArr[0] = id;
                    Log.m9715e("There was a problem loading up the cached ad %s. Ad is not on disk.", objArr);
                    if (objectInputStream != null) {
                        return ad;
                    }
                    try {
                        objectInputStream.close();
                        return ad;
                    } catch (IOException e4) {
                        return ad;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                objectInputStream = objectInputStream2;
                objArr = new Object[PRIORITY_PRECACHE];
                objArr[0] = id;
                Log.m9715e("There was a problem loading up the cached ad %s.", objArr);
                Log.m9711d(e.getMessage());
                Log.m9713d(e);
                if (objectInputStream != null) {
                    return ad;
                }
                try {
                    objectInputStream.close();
                    return ad;
                } catch (IOException e7) {
                    return ad;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = objectInputStream2;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
            objArr = new Object[PRIORITY_PRECACHE];
            objArr[0] = id;
            Log.m9715e("There was a problem loading up the cached ad %s. Ad is not on disk.", objArr);
            if (objectInputStream != null) {
                return ad;
            }
            objectInputStream.close();
            return ad;
        } catch (Exception e9) {
            e = e9;
            objArr = new Object[PRIORITY_PRECACHE];
            objArr[0] = id;
            Log.m9715e("There was a problem loading up the cached ad %s.", objArr);
            Log.m9711d(e.getMessage());
            Log.m9713d(e);
            if (objectInputStream != null) {
                return ad;
            }
            objectInputStream.close();
            return ad;
        }
    }

    static boolean save(Context context, CachedAd ad) {
        Throwable e;
        Throwable th;
        File lockFile = null;
        ObjectOutputStream objectOutputStream = null;
        if (ad == null) {
            return false;
        }
        File cachedAdFile = getCachedAdFile(context, ad.getId());
        if (cachedAdFile == null) {
            return false;
        }
        Object[] objArr = new Object[PRIORITY_REFRESH];
        objArr[0] = ad.getId();
        objArr[PRIORITY_PRECACHE] = cachedAdFile;
        Log.m9724v("Saving CachedAd %s to %s", objArr);
        Object[] objArr2;
        try {
            File lockFile2 = new File(cachedAdFile.getParent(), ad.getId() + LOCK_FILE);
            try {
                if (lockFile2.createNewFile()) {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(cachedAdFile));
                    try {
                        objectOutputStream2.writeInt(ad.getType());
                        objectOutputStream2.writeObject(ad.expiration);
                        objectOutputStream2.writeObject(ad.acid);
                        objectOutputStream2.writeLong(ad.deferredViewStart);
                        objectOutputStream2.writeObject(ad);
                        try {
                            lockFile2.delete();
                            if (objectOutputStream2 != null) {
                                objectOutputStream2.close();
                            }
                        } catch (IOException e2) {
                        }
                        if (ad.saveAssets(context)) {
                            lockFile = lockFile2;
                            return true;
                        }
                        ad.delete(context);
                        objectOutputStream = objectOutputStream2;
                        lockFile = lockFile2;
                        return false;
                    } catch (Exception e3) {
                        e = e3;
                        objectOutputStream = objectOutputStream2;
                        lockFile = lockFile2;
                        try {
                            objArr2 = new Object[PRIORITY_PRECACHE];
                            objArr2[0] = ad.getId();
                            Log.m9715e("There was a problem saving the cached ad %s.", objArr2);
                            Log.m9711d(e.getMessage());
                            Log.m9713d(e);
                            try {
                                lockFile.delete();
                                if (objectOutputStream != null) {
                                    return false;
                                }
                                objectOutputStream.close();
                                return false;
                            } catch (IOException e4) {
                                return false;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                lockFile.delete();
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                            } catch (IOException e5) {
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        objectOutputStream = objectOutputStream2;
                        lockFile = lockFile2;
                        lockFile.delete();
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        throw th;
                    }
                }
                objArr2 = new Object[PRIORITY_PRECACHE];
                objArr2[0] = ad.getId();
                Log.m9724v("Could not save the cached ad %s. Ad was locked.", objArr2);
                try {
                    lockFile2.delete();
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                } catch (IOException e6) {
                }
                lockFile = lockFile2;
                return false;
            } catch (Exception e7) {
                e = e7;
                lockFile = lockFile2;
                objArr2 = new Object[PRIORITY_PRECACHE];
                objArr2[0] = ad.getId();
                Log.m9715e("There was a problem saving the cached ad %s.", objArr2);
                Log.m9711d(e.getMessage());
                Log.m9713d(e);
                lockFile.delete();
                if (objectOutputStream != null) {
                    return false;
                }
                objectOutputStream.close();
                return false;
            } catch (Throwable th4) {
                th = th4;
                lockFile = lockFile2;
                lockFile.delete();
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e8) {
            e = e8;
            objArr2 = new Object[PRIORITY_PRECACHE];
            objArr2[0] = ad.getId();
            Log.m9715e("There was a problem saving the cached ad %s.", objArr2);
            Log.m9711d(e.getMessage());
            Log.m9713d(e);
            lockFile.delete();
            if (objectOutputStream != null) {
                return false;
            }
            objectOutputStream.close();
            return false;
        }
    }

    static boolean deleteFile(Context context, String fileName) {
        File deleteFile = getCachedAdFile(context, fileName);
        if (deleteFile != null) {
            return deleteFile.delete();
        }
        return false;
    }

    static boolean isInternalDir(Context context, File dir) {
        File internalDir = getInternalCacheDirectory(context);
        return internalDir != null && internalDir.equals(dir);
    }

    static boolean isExternalStorageAvailable(Context context) {
        if (context == null) {
            return false;
        }
        String storageState = Environment.getExternalStorageState();
        if (context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0 && !TextUtils.isEmpty(storageState) && storageState.equals("mounted") && isExternalEnabled) {
            return true;
        }
        return false;
    }

    static boolean isExternalMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    static {
        isExternalEnabled = true;
    }

    static void setEnableExternalStorage(boolean on) {
        isExternalEnabled = on;
    }
}
