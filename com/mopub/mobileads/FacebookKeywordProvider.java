package com.mopub.mobileads;

import android.net.Uri;

public class FacebookKeywordProvider {
    private static final String ID_COLUMN_NAME = "aid";
    private static final String ID_PREFIX = "FBATTRID:";
    private static final Uri ID_URL;

    public static java.lang.String getKeyword(android.content.Context r10) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x007a in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r9 = 0;
        r7 = 0;
        r0 = 1;
        r2 = new java.lang.String[r0];	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r0 = 0;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r1 = "aid";	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r2[r0] = r1;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r0 = r10.getContentResolver();	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r1 = ID_URL;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r3 = 0;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r4 = 0;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r5 = 0;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r7 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        if (r7 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
    L_0x0019:
        r0 = r7.moveToFirst();	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        if (r0 != 0) goto L_0x0026;
    L_0x001f:
        if (r7 == 0) goto L_0x0024;
    L_0x0021:
        r7.close();
    L_0x0024:
        r0 = r9;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = "aid";	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r0 = r7.getColumnIndex(r0);	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r6 = r7.getString(r0);	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        if (r6 == 0) goto L_0x0038;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
    L_0x0032:
        r0 = r6.length();	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        if (r0 != 0) goto L_0x003f;
    L_0x0038:
        if (r7 == 0) goto L_0x003d;
    L_0x003a:
        r7.close();
    L_0x003d:
        r0 = r9;
        goto L_0x0025;
    L_0x003f:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r0.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r1 = "FBATTRID:";	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r0 = r0.append(r1);	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r0 = r0.append(r6);	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        if (r7 == 0) goto L_0x0025;
    L_0x0054:
        r7.close();
        goto L_0x0025;
    L_0x0058:
        r8 = move-exception;
        r0 = "MoPub";	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r1.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r3 = "Unable to retrieve FBATTRID: ";	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r3 = r8.toString();	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r1 = r1.append(r3);	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        android.util.Log.d(r0, r1);	 Catch:{ Exception -> 0x0058, all -> 0x007c }
        if (r7 == 0) goto L_0x007a;
    L_0x0077:
        r7.close();
    L_0x007a:
        r0 = r9;
        goto L_0x0025;
    L_0x007c:
        r0 = move-exception;
        if (r7 == 0) goto L_0x0082;
    L_0x007f:
        r7.close();
    L_0x0082:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.FacebookKeywordProvider.getKeyword(android.content.Context):java.lang.String");
    }

    static {
        ID_URL = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    }
}
