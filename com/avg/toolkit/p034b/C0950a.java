package com.avg.toolkit.p034b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.uid.UUID;
import com.mopub.common.AdUrlGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.avg.toolkit.b.a */
public class C0950a extends Handler {
    boolean f2865a;
    private boolean f2866b;
    private boolean f2867c;
    private C1017a f2868d;
    private UUID f2869e;
    private C0948b f2870f;
    private boolean f2871g;
    private ArrayList f2872h;
    private Map f2873i;
    private Context f2874j;
    private boolean f2875k;
    private Runnable f2876l;
    private int f2877m;

    /* renamed from: com.avg.toolkit.b.a.a */
    private class C0947a {
        public C0649d f2853a;
        public boolean f2854b;
        public int f2855c;
        public C0949c f2856d;
        final /* synthetic */ C0950a f2857e;

        public C0947a(C0950a c0950a, C0649d c) {
            this.f2857e = c0950a;
            this.f2853a = c;
            this.f2854b = false;
            this.f2855c = 0;
            this.f2856d = C0949c.REGULAR;
        }
    }

    /* renamed from: com.avg.toolkit.b.a.b */
    private class C0948b extends BroadcastReceiver {
        final /* synthetic */ C0950a f2858a;

        private C0948b(C0950a c0950a) {
            this.f2858a = c0950a;
        }

        public void onReceive(Context ctx, Intent intent) {
            if (C0952b.m4281a(ctx) && this.f2858a.f2871g) {
                this.f2858a.f2871g = false;
                try {
                    ctx.unregisterReceiver(this);
                } catch (Exception e) {
                    C0970a.m4322a(e);
                }
                this.f2858a.m4275a();
            }
        }
    }

    /* renamed from: com.avg.toolkit.b.a.c */
    public enum C0949c {
        IDLE(1),
        REGULAR(2),
        ASAP(3),
        ELEVATED(4);
        
        private final int f2864e;

        private C0949c(int index) {
            this.f2864e = index;
        }

        public int m4269a() {
            return this.f2864e;
        }
    }

    private boolean m4271a(com.avg.toolkit.p034b.C0950a.C0949c r22, android.util.SparseArray r23, java.lang.String r24) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:84:? in {5, 9, 36, 41, 50, 51, 53, 55, 56, 58, 65, 66, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 80, 81, 82, 83, 85} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r21 = this;
        r9 = 1;
        r4 = new org.json.JSONArray;
        r4.<init>();
        r3 = new org.json.JSONObject;
        r3.<init>();
        r5 = new org.json.JSONObject;
        r5.<init>();
        r15 = 0;
        r16 = r23.size();
        r12 = 0;
    L_0x0016:
        r0 = r16;
        if (r12 >= r0) goto L_0x008a;
    L_0x001a:
        r0 = r23;
        r8 = r0.valueAt(r12);
        r8 = (com.avg.toolkit.p034b.C0950a.C0947a) r8;
        r7 = r8.f2853a;
        r20 = r3.names();
        r0 = r21;
        r2 = r0.f2874j;
        if (r20 != 0) goto L_0x0033;
    L_0x002e:
        r20 = new org.json.JSONArray;
        r20.<init>();
    L_0x0033:
        r0 = r20;
        r2 = r7.prepareJson(r2, r0);
        if (r2 != 0) goto L_0x0048;
    L_0x003b:
        r9 = 0;
        r2 = r8.f2855c;
        r2 = r2 + 1;
        r8.f2855c = r2;
        r7.resetPreparedData();
    L_0x0045:
        r12 = r12 + 1;
        goto L_0x0016;
    L_0x0048:
        r15 = 1;
        r2 = r7.getJsonConfKey();
        r4.put(r2);
        r2 = r7.jsonRequestParameters;
        if (r2 == 0) goto L_0x0075;
    L_0x0054:
        r2 = r7.jsonRequestParameters;
        r13 = r2.keys();
    L_0x005a:
        r2 = r13.hasNext();
        if (r2 == 0) goto L_0x0075;
    L_0x0060:
        r14 = r13.next();
        r14 = (java.lang.String) r14;
        r2 = r7.jsonRequestParameters;	 Catch:{ JSONException -> 0x0070 }
        r2 = r2.get(r14);	 Catch:{ JSONException -> 0x0070 }
        r3.put(r14, r2);	 Catch:{ JSONException -> 0x0070 }
        goto L_0x005a;
    L_0x0070:
        r10 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r10);
        goto L_0x005a;
    L_0x0075:
        r11 = r7.jsonRequestFeatureParameters;
        if (r11 == 0) goto L_0x0045;
    L_0x0079:
        r2 = r7.getJsonConfKey();	 Catch:{ JSONException -> 0x0085 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ JSONException -> 0x0085 }
        r5.put(r2, r11);	 Catch:{ JSONException -> 0x0085 }
        goto L_0x0045;
    L_0x0085:
        r10 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r10);
        goto L_0x0045;
    L_0x008a:
        if (r15 != 0) goto L_0x008e;
    L_0x008c:
        r2 = 0;
    L_0x008d:
        return r2;
    L_0x008e:
        r1 = new com.avg.toolkit.b.e;
        r1.<init>();
        r0 = r21;
        r2 = r0.f2874j;
        r6 = r24;
        r18 = r1.m4290a(r2, r3, r4, r5, r6);
        r19 = r1.m4291a();
        r12 = 0;
    L_0x00a2:
        r0 = r16;
        if (r12 >= r0) goto L_0x0119;
    L_0x00a6:
        r0 = r23;
        r8 = r0.valueAt(r12);
        r8 = (com.avg.toolkit.p034b.C0950a.C0947a) r8;
        r7 = r8.f2853a;
        switch(r18) {
            case 0: goto L_0x00b9;
            case 1: goto L_0x0103;
            case 2: goto L_0x0103;
            case 3: goto L_0x010b;
            default: goto L_0x00b3;
        };
    L_0x00b3:
        r7.resetPreparedData();
    L_0x00b6:
        r12 = r12 + 1;
        goto L_0x00a2;
    L_0x00b9:
        r2 = r7.getJsonConfKey();	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r0 = r19;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r17 = r0.opt(r2);	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        if (r17 != 0) goto L_0x00e3;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
    L_0x00c9:
        r0 = r21;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = r0.f2874j;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r7.callFinishedNoChange(r2);	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = 0;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r8.f2854b = r2;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = 0;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r8.f2855c = r2;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        goto L_0x00b3;
    L_0x00d7:
        r10 = move-exception;
        r2 = r8.f2855c;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r8.f2855c = r2;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r9 = 0;
        r7.resetPreparedData();
        goto L_0x00b6;
    L_0x00e3:
        r0 = r21;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = r0.f2874j;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r0 = r17;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = r7.callFinished(r2, r0);	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        if (r2 == 0) goto L_0x00fb;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
    L_0x00ef:
        r2 = 0;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r8.f2854b = r2;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = 0;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r8.f2855c = r2;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        goto L_0x00b3;
    L_0x00f6:
        r2 = move-exception;
        r7.resetPreparedData();
        throw r2;
    L_0x00fb:
        r2 = r8.f2855c;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r8.f2855c = r2;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r9 = 0;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        goto L_0x00b3;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
    L_0x0103:
        r2 = r8.f2855c;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r8.f2855c = r2;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r9 = 0;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        goto L_0x00b3;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
    L_0x010b:
        r0 = r21;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = r0.f2874j;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r7.callFinishedNoChange(r2);	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = 0;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r8.f2854b = r2;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r2 = 0;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        r8.f2855c = r2;	 Catch:{ Exception -> 0x00d7, all -> 0x00f6 }
        goto L_0x00b3;
    L_0x0119:
        if (r18 == 0) goto L_0x0128;
    L_0x011b:
        r2 = 3;
        r0 = r18;
        if (r0 == r2) goto L_0x0128;
    L_0x0120:
        r2 = 2;
        r0 = r18;
        if (r0 != r2) goto L_0x012d;
    L_0x0125:
        r2 = 1;
        if (r9 != r2) goto L_0x012d;
    L_0x0128:
        r2 = 1;
        r0 = r21;
        r0.f2875k = r2;
    L_0x012d:
        r2 = r9;
        goto L_0x008d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avg.toolkit.b.a.a(com.avg.toolkit.b.a$c, android.util.SparseArray, java.lang.String):boolean");
    }

    private boolean m4274b(com.avg.toolkit.p034b.C0950a.C0949c r23) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Incorrect nodes count for selectOther: B:15:0x0046 in [B:14:0x0044, B:15:0x0046, B:16:0x0047]
	at jadx.core.utils.BlockUtils.selectOther(BlockUtils.java:53)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:62)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r22 = this;
        r0 = r22;
        r4 = r0.f2869e;
        r20 = r4.getUUID();
        if (r20 != 0) goto L_0x0011;
    L_0x000a:
        r4 = "no uid";
        com.avg.toolkit.p049e.C0970a.m4325b(r4);
        r14 = 0;
    L_0x0010:
        return r14;
    L_0x0011:
        r3 = 0;
        r21 = new com.avg.toolkit.b.f;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r0 = r22;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r4 = r0.f2874j;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r0 = r21;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r0.<init>(r4);	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r0 = r22;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r4 = r0.f2868d;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r0 = r22;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r5 = r0.f2877m;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r0 = r21;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r1 = r20;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        r3 = r0.m4296a(r4, r5, r1);	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        if (r3 != 0) goto L_0x0047;
    L_0x002f:
        r14 = 0;
        goto L_0x0010;
    L_0x0031:
        r15 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r15);	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        if (r3 != 0) goto L_0x0047;
    L_0x0037:
        r14 = 0;
        goto L_0x0010;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
    L_0x0039:
        r15 = move-exception;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        com.avg.toolkit.p049e.C0970a.m4322a(r15);	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0039, all -> 0x0041 }
        if (r3 != 0) goto L_0x0047;
    L_0x003f:
        r14 = 0;
        goto L_0x0010;
    L_0x0041:
        r4 = move-exception;
        if (r3 != 0) goto L_0x0046;
    L_0x0044:
        r14 = 0;
        goto L_0x0010;
    L_0x0046:
        throw r4;
    L_0x0047:
        r0 = r22;
        r4 = r0.f2874j;
        r4 = com.avg.toolkit.p034b.C0952b.m4281a(r4);
        if (r4 != 0) goto L_0x0070;
    L_0x0051:
        r0 = r22;
        r4 = r0.f2871g;
        if (r4 != 0) goto L_0x006e;
    L_0x0057:
        r4 = 1;
        r0 = r22;
        r0.f2871g = r4;
        r0 = r22;
        r4 = r0.f2874j;
        r0 = r22;
        r5 = r0.f2870f;
        r6 = new android.content.IntentFilter;
        r7 = "android.net.conn.CONNECTIVITY_CHANGE";
        r6.<init>(r7);
        r4.registerReceiver(r5, r6);
    L_0x006e:
        r14 = 0;
        goto L_0x0010;
    L_0x0070:
        r14 = 1;
        r11 = new android.util.SparseArray;
        r11.<init>();
        r0 = r22;
        r4 = r0.f2872h;
        r16 = r4.iterator();
    L_0x007e:
        r4 = r16.hasNext();
        if (r4 == 0) goto L_0x015d;
    L_0x0084:
        r13 = r16.next();
        r13 = (com.avg.toolkit.p034b.C0950a.C0947a) r13;
        r12 = r13.f2853a;
        r4 = r13.f2854b;
        if (r4 == 0) goto L_0x007e;
    L_0x0090:
        r4 = r13.f2856d;
        r0 = r23;
        if (r4 != r0) goto L_0x007e;
    L_0x0096:
        r17 = r12.getJsonConfKey();
        r4 = -1;
        r0 = r17;
        if (r0 == r4) goto L_0x00a5;
    L_0x009f:
        r0 = r17;
        r11.put(r0, r13);
        goto L_0x007e;
    L_0x00a5:
        r0 = r22;
        r4 = r0.f2874j;
        r4 = r12.prepare(r4);
        if (r4 != 0) goto L_0x00ba;
    L_0x00af:
        r14 = 0;
        r4 = r13.f2855c;
        r4 = r4 + 1;
        r13.f2855c = r4;
    L_0x00b6:
        r12.resetPreparedData();
        goto L_0x007e;
    L_0x00ba:
        r19 = 0;
        r4 = r12.getXmlRpcMethod();	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        if (r4 != 0) goto L_0x00d2;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
    L_0x00c2:
        r4 = 0;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r13.f2854b = r4;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r4 = 0;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r13.f2855c = r4;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        goto L_0x007e;
    L_0x00c9:
        r15 = move-exception;
        r4 = r13.f2855c;
        r4 = r4 + 1;
        r13.f2855c = r4;
        r14 = 0;
        goto L_0x00b6;
    L_0x00d2:
        r0 = r22;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r4 = r0.f2874j;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r5 = r12.getProgressNotification();	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r6 = r12.getXmlRpcMethod();	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r7 = r12.mParams;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r8 = r12.mCookies;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r9 = r12.isAnonymous();	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        if (r9 == 0) goto L_0x00fa;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
    L_0x00e8:
        r9 = "unknown";	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
    L_0x00ea:
        r10 = r12.mResultTargetFile;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r19 = r3.m4302a(r4, r5, r6, r7, r8, r9, r10);	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        if (r19 != 0) goto L_0x00fd;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
    L_0x00f2:
        r4 = r13.f2855c;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r4 = r4 + 1;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r13.f2855c = r4;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r14 = 0;
        goto L_0x00b6;
    L_0x00fa:
        r9 = r20;
        goto L_0x00ea;
    L_0x00fd:
        r4 = r19.getClass();	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r5 = java.lang.String.class;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        if (r4 == 0) goto L_0x0136;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
    L_0x0109:
        r0 = r19;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r18 = r0;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r4 = android.text.TextUtils.isEmpty(r18);	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        if (r4 != 0) goto L_0x0136;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
    L_0x0115:
        r4 = "re-register";	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r0 = r18;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r4 = r0.equalsIgnoreCase(r4);	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        if (r4 == 0) goto L_0x0136;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
    L_0x011f:
        r4 = r13.f2855c;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r4 = r4 + 1;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r13.f2855c = r4;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r0 = r22;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r4 = r0.f2869e;	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r4.m4504b();	 Catch:{ Exception -> 0x012f, a -> 0x00c9 }
        r14 = 0;
        goto L_0x0010;
    L_0x012f:
        r15 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r15);	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r14 = 0;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        goto L_0x0010;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
    L_0x0136:
        r0 = r22;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r4 = r0.f2874j;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r0 = r19;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r4 = r12.callFinished(r4, r0);	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        if (r4 == 0) goto L_0x0154;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
    L_0x0142:
        r4 = 0;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r13.f2854b = r4;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r4 = 0;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r13.f2855c = r4;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        goto L_0x00b6;
    L_0x014a:
        r15 = move-exception;
        r4 = r13.f2855c;
        r4 = r4 + 1;
        r13.f2855c = r4;
        r14 = 0;
        goto L_0x00b6;
    L_0x0154:
        r4 = r13.f2855c;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r4 = r4 + 1;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r13.f2855c = r4;	 Catch:{ a -> 0x00c9, Exception -> 0x014a }
        r14 = 0;
        goto L_0x00b6;
    L_0x015d:
        r4 = r11.size();
        if (r4 <= 0) goto L_0x0010;
    L_0x0163:
        r0 = r22;
        r1 = r23;
        r2 = r20;
        r4 = r0.m4271a(r1, r11, r2);
        if (r4 != 0) goto L_0x0010;
    L_0x016f:
        r14 = 0;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avg.toolkit.b.a.b(com.avg.toolkit.b.a$c):boolean");
    }

    public void m4277a(C1017a avgFeatures) {
        this.f2868d = avgFeatures;
        Iterator i$ = this.f2872h.iterator();
        while (i$.hasNext()) {
            ((C0947a) i$.next()).f2853a.setAvgFeatures(avgFeatures);
        }
    }

    public C0950a(Context context, C1017a avgFeatures, int productId, Looper looper, UUID uuid, Runnable dailyRunSucceeded) {
        super(looper);
        this.f2866b = false;
        this.f2867c = false;
        this.f2868d = null;
        this.f2871g = false;
        this.f2865a = false;
        this.f2874j = context;
        this.f2868d = avgFeatures;
        this.f2869e = uuid;
        this.f2865a = false;
        this.f2876l = dailyRunSucceeded;
        this.f2877m = productId;
        this.f2872h = new ArrayList();
        this.f2873i = new HashMap();
        this.f2870f = new C0948b();
    }

    public void m4278a(List commClients) {
        for (Class c : commClients) {
            try {
                m4270a((C0649d) c.newInstance());
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
    }

    private void m4270a(C0649d c) {
        C0947a cln = (C0947a) this.f2873i.get(Integer.valueOf(c.getMessageId()));
        if (cln != null) {
            C0970a.m4325b("client " + cln.f2853a.getClass().getName() + " not added. message id " + c.getMessageId() + " already exists");
            return;
        }
        c.setAvgFeatures(this.f2868d);
        cln = new C0947a(this, c);
        this.f2872h.add(cln);
        this.f2873i.put(Integer.valueOf(c.getMessageId()), cln);
        cln.f2856d = c.getPriority();
        if (c.load(this.f2874j)) {
            cln.f2854b = true;
            m4276a(cln.f2856d);
        }
    }

    void m4276a(C0949c w) {
        if ((w == C0949c.ASAP && !this.f2867c) || (w == C0949c.REGULAR && !this.f2866b)) {
            long delayMillis;
            Bundle bundle = new Bundle();
            bundle.putInt(AdUrlGenerator.DEVICE_ORIENTATION_PORTRAIT, w.m4269a());
            Message msg = Message.obtain(this, 100, bundle);
            msg.setTarget(this);
            if (w.m4269a() >= C0949c.ASAP.m4269a()) {
                delayMillis = 500;
                this.f2867c = true;
            } else {
                delayMillis = 600000;
                this.f2866b = true;
            }
            sendMessageDelayed(msg, delayMillis);
        }
    }

    void m4275a() {
        if (!this.f2871g) {
            Iterator i$ = this.f2872h.iterator();
            while (i$.hasNext()) {
                C0947a cln = (C0947a) i$.next();
                if (cln.f2854b) {
                    if (cln.f2855c < 3) {
                        m4276a(cln.f2856d);
                    } else {
                        cln.f2854b = false;
                    }
                }
            }
        }
    }

    public void m4279b() {
        this.f2865a = true;
        Bundle bundle = new Bundle();
        bundle.putInt(AdUrlGenerator.DEVICE_ORIENTATION_PORTRAIT, C0949c.ELEVATED.m4269a());
        Message msg = Message.obtain(this, 100, bundle);
        msg.setTarget(this);
        sendMessage(msg);
    }

    public void handleMessage(Message msg) {
        int priority = 0;
        int whoCalled = 0;
        try {
            int what = msg.what;
            if (msg.obj != null) {
                priority = ((Bundle) msg.obj).getInt(AdUrlGenerator.DEVICE_ORIENTATION_PORTRAIT);
                whoCalled = ((Bundle) msg.obj).getInt("wc");
            }
            C0947a cln;
            boolean bSuccess;
            if (what == 100) {
                if (this.f2865a) {
                    if (priority == C0949c.ASAP.m4269a()) {
                        this.f2867c = false;
                    }
                    if (priority == C0949c.REGULAR.m4269a()) {
                        this.f2866b = false;
                    }
                    if (priority == C0949c.ELEVATED.m4269a()) {
                        if (whoCalled != 0) {
                            cln = (C0947a) this.f2873i.get(Integer.valueOf(whoCalled));
                            if (cln != null) {
                                cln.f2856d = C0949c.ELEVATED;
                                bSuccess = m4274b(C0949c.ELEVATED);
                                cln.f2856d = cln.f2853a.getPriority();
                            } else {
                                C0970a.m4325b("invalid client " + whoCalled);
                            }
                        } else {
                            bSuccess = m4274b(C0949c.ASAP);
                            bSuccess = m4274b(C0949c.REGULAR);
                        }
                    } else if (priority == C0949c.ASAP.m4269a()) {
                        this.f2867c = false;
                        bSuccess = m4274b(C0949c.ASAP);
                    } else if (priority == C0949c.REGULAR.m4269a()) {
                        this.f2866b = false;
                        bSuccess = m4274b(C0949c.REGULAR);
                    } else {
                        C0970a.m4325b("invalid action");
                    }
                    m4275a();
                    return;
                }
                this.f2867c = false;
                this.f2866b = false;
            } else if (what == 101) {
                for (Integer key : this.f2873i.keySet()) {
                    cln = (C0947a) this.f2873i.get(key);
                    if (cln != null && cln.f2853a.getPriority() == C0949c.REGULAR && cln.f2853a.useDailyRun()) {
                        try {
                            if (cln.f2853a.handleDailyRun(this.f2874j)) {
                                if (cln.f2854b) {
                                    cln.f2855c = 0;
                                } else {
                                    cln.f2854b = true;
                                }
                            }
                        } catch (Exception e) {
                            C0970a.m4322a(e);
                        }
                    }
                }
                this.f2875k = false;
                this.f2866b = false;
                bSuccess = m4274b(C0949c.REGULAR);
                if (this.f2875k) {
                    this.f2876l.run();
                }
                m4275a();
            } else {
                cln = (C0947a) this.f2873i.get(Integer.valueOf(what));
                if (cln == null) {
                    C0970a.m4325b("invalid client " + what);
                    return;
                }
                try {
                    if (!cln.f2853a.handleMessage(this.f2874j, msg)) {
                        return;
                    }
                    if (cln.f2854b) {
                        cln.f2855c = 0;
                        return;
                    }
                    cln.f2854b = true;
                    m4276a(cln.f2856d);
                } catch (Exception e2) {
                    C0970a.m4322a(e2);
                }
            }
        } catch (Exception e22) {
            this.f2867c = false;
            this.f2866b = false;
            C0970a.m4322a(e22);
        }
    }
}
