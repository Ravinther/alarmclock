package com.avg.toolkit.p034b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.uid.UUID;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.avg.toolkit.b.g */
public class C0957g extends Handler {
    private C1017a f2890a;
    private Map f2891b;
    private Context f2892c;
    private UUID f2893d;
    private int f2894e;

    private void m4298a(com.avg.toolkit.p034b.C0649d r16) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Incorrect nodes count for selectOther: B:16:0x005b in [B:15:0x0052, B:16:0x005b, B:17:0x005c]
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
        r15 = this;
        r2 = r15.f2893d;
        r13 = r2.getUUID();
        if (r13 != 0) goto L_0x0016;
    L_0x0008:
        r2 = "no id";
        com.avg.toolkit.p049e.C0970a.m4325b(r2);
        r2 = r15.f2892c;
        r3 = 0;
        r0 = r16;
        r0.callFinished(r2, r3);
    L_0x0015:
        return;
    L_0x0016:
        r1 = 0;
        r14 = new com.avg.toolkit.b.f;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0040, all -> 0x004f }
        r2 = r15.f2892c;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0040, all -> 0x004f }
        r14.<init>(r2);	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0040, all -> 0x004f }
        r2 = r15.f2890a;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0040, all -> 0x004f }
        r3 = r15.f2894e;	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0040, all -> 0x004f }
        r1 = r14.m4296a(r2, r3, r13);	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0040, all -> 0x004f }
        if (r1 != 0) goto L_0x005c;
    L_0x0028:
        r2 = r15.f2892c;
        r3 = 0;
        r0 = r16;
        r0.callFinished(r2, r3);
        goto L_0x0015;
    L_0x0031:
        r9 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r9);	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0040, all -> 0x004f }
        if (r1 != 0) goto L_0x005c;
    L_0x0037:
        r2 = r15.f2892c;
        r3 = 0;
        r0 = r16;
        r0.callFinished(r2, r3);
        goto L_0x0015;
    L_0x0040:
        r9 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r9);	 Catch:{ URISyntaxException -> 0x0031, Exception -> 0x0040, all -> 0x004f }
        if (r1 != 0) goto L_0x005c;
    L_0x0046:
        r2 = r15.f2892c;
        r3 = 0;
        r0 = r16;
        r0.callFinished(r2, r3);
        goto L_0x0015;
    L_0x004f:
        r2 = move-exception;
        if (r1 != 0) goto L_0x005b;
    L_0x0052:
        r2 = r15.f2892c;
        r3 = 0;
        r0 = r16;
        r0.callFinished(r2, r3);
        goto L_0x0015;
    L_0x005b:
        throw r2;
    L_0x005c:
        r2 = r15.f2892c;
        r2 = com.avg.toolkit.p034b.C0952b.m4281a(r2);
        if (r2 != 0) goto L_0x006d;
    L_0x0064:
        r2 = r15.f2892c;
        r3 = 0;
        r0 = r16;
        r0.callFinished(r2, r3);
        goto L_0x0015;
    L_0x006d:
        r10 = r16.getJsonConfKey();
        r2 = -1;
        if (r10 == r2) goto L_0x007a;
    L_0x0074:
        r0 = r16;
        r15.m4299a(r0, r13);
        goto L_0x0015;
    L_0x007a:
        r2 = r15.f2892c;
        r0 = r16;
        r2 = r0.prepare(r2);
        if (r2 == 0) goto L_0x0015;
    L_0x0084:
        r12 = 0;
        r2 = r16.getXmlRpcMethod();	 Catch:{ Exception -> 0x00e1 }
        if (r2 == 0) goto L_0x0015;	 Catch:{ Exception -> 0x00e1 }
    L_0x008b:
        r2 = r15.f2892c;	 Catch:{ Exception -> 0x00e1 }
        r3 = r16.getProgressNotification();	 Catch:{ Exception -> 0x00e1 }
        r4 = r16.getXmlRpcMethod();	 Catch:{ Exception -> 0x00e1 }
        r0 = r16;	 Catch:{ Exception -> 0x00e1 }
        r5 = r0.mParams;	 Catch:{ Exception -> 0x00e1 }
        r0 = r16;	 Catch:{ Exception -> 0x00e1 }
        r6 = r0.mCookies;	 Catch:{ Exception -> 0x00e1 }
        r7 = r16.isAnonymous();	 Catch:{ Exception -> 0x00e1 }
        if (r7 == 0) goto L_0x00ec;	 Catch:{ Exception -> 0x00e1 }
    L_0x00a3:
        r7 = "anon";	 Catch:{ Exception -> 0x00e1 }
    L_0x00a5:
        r0 = r16;	 Catch:{ Exception -> 0x00e1 }
        r8 = r0.mResultTargetFile;	 Catch:{ Exception -> 0x00e1 }
        r12 = r1.m4302a(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x00e1 }
        if (r12 == 0) goto L_0x00ee;
    L_0x00af:
        r2 = r12.getClass();	 Catch:{ Exception -> 0x00d4 }
        r3 = java.lang.String.class;	 Catch:{ Exception -> 0x00d4 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x00d4 }
        if (r2 == 0) goto L_0x00d8;	 Catch:{ Exception -> 0x00d4 }
    L_0x00bb:
        r0 = r12;	 Catch:{ Exception -> 0x00d4 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x00d4 }
        r11 = r0;	 Catch:{ Exception -> 0x00d4 }
        r2 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Exception -> 0x00d4 }
        if (r2 != 0) goto L_0x00d8;	 Catch:{ Exception -> 0x00d4 }
    L_0x00c5:
        r2 = "re-register";	 Catch:{ Exception -> 0x00d4 }
        r2 = r11.equalsIgnoreCase(r2);	 Catch:{ Exception -> 0x00d4 }
        if (r2 == 0) goto L_0x00d8;	 Catch:{ Exception -> 0x00d4 }
    L_0x00cd:
        r2 = r15.f2893d;	 Catch:{ Exception -> 0x00d4 }
        r2.m4504b();	 Catch:{ Exception -> 0x00d4 }
        goto L_0x0015;
    L_0x00d4:
        r9 = move-exception;
        com.avg.toolkit.p049e.C0970a.m4322a(r9);	 Catch:{ Exception -> 0x00e1 }
    L_0x00d8:
        r2 = r15.f2892c;	 Catch:{ Exception -> 0x00e1 }
        r0 = r16;	 Catch:{ Exception -> 0x00e1 }
        r0.callFinished(r2, r12);	 Catch:{ Exception -> 0x00e1 }
        goto L_0x0015;
    L_0x00e1:
        r9 = move-exception;
        r2 = r15.f2892c;
        r3 = 0;
        r0 = r16;
        r0.callFinished(r2, r3);
        goto L_0x0015;
    L_0x00ec:
        r7 = r13;
        goto L_0x00a5;
    L_0x00ee:
        r2 = r15.f2892c;	 Catch:{ Exception -> 0x00e1 }
        r3 = 0;	 Catch:{ Exception -> 0x00e1 }
        r0 = r16;	 Catch:{ Exception -> 0x00e1 }
        r0.callFinished(r2, r3);	 Catch:{ Exception -> 0x00e1 }
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avg.toolkit.b.g.a(com.avg.toolkit.b.d):void");
    }

    public void m4300a(C1017a avgFeatures) {
        this.f2890a = avgFeatures;
    }

    public C0957g(Context context, C1017a avgFeatures, int productId, Looper looper, UUID uuid) {
        super(looper);
        this.f2890a = null;
        this.f2892c = context;
        this.f2890a = avgFeatures;
        this.f2893d = uuid;
        this.f2894e = productId;
        this.f2891b = new HashMap();
    }

    public void m4301a(List commClients) {
        for (Class c : commClients) {
            try {
                this.f2891b.put(Integer.valueOf(((C0649d) c.newInstance()).getMessageId()), c);
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        }
    }

    public void handleMessage(Message msg) {
        try {
            try {
                C0649d newClass = (C0649d) ((Class) this.f2891b.get(Integer.valueOf(msg.what))).newInstance();
                newClass.setAvgFeatures(this.f2890a);
                newClass.handleMessage(this.f2892c, msg);
                m4298a(newClass);
            } catch (Exception e) {
                C0970a.m4322a(e);
            }
        } catch (Exception e2) {
            C0970a.m4322a(e2);
        }
    }

    private void m4299a(C0649d c, String serialNum) {
        JSONArray requestFeatures = new JSONArray();
        JSONObject requestParams = new JSONObject();
        JSONObject requestFeatureParams = new JSONObject();
        boolean needComm = false;
        if (c.prepareJson(this.f2892c, new JSONArray())) {
            needComm = true;
            requestFeatures.put(c.getJsonConfKey());
            if (c.jsonRequestParameters != null) {
                Iterator iter = c.jsonRequestParameters.keys();
                while (iter.hasNext()) {
                    String key = (String) iter.next();
                    try {
                        requestParams.put(key, c.jsonRequestParameters.get(key));
                    } catch (Exception e) {
                        C0970a.m4322a(e);
                    }
                }
            }
            JSONObject fparam = c.jsonRequestFeatureParameters;
            if (fparam != null) {
                try {
                    requestFeatureParams.put(String.valueOf(c.getJsonConfKey()), fparam);
                } catch (Exception e2) {
                    C0970a.m4322a(e2);
                }
            }
        } else {
            c.resetPreparedData();
        }
        if (needComm) {
            C0955e jsonClient = new C0955e();
            int res = jsonClient.m4290a(this.f2892c, requestParams, requestFeatures, requestFeatureParams, serialNum);
            JSONObject response = jsonClient.m4291a();
            switch (res) {
                case Base64.DEFAULT /*0*/:
                    try {
                        Object obj = response.opt(String.valueOf(c.getJsonConfKey()));
                        if (obj == null) {
                            c.callFinishedNoChange(this.f2892c);
                        }
                        c.callFinished(this.f2892c, obj);
                        break;
                    } catch (Exception e3) {
                        c.callFinished(this.f2892c, null);
                        return;
                    } finally {
                        c.resetPreparedData();
                    }
                case Base64.NO_PADDING /*1*/:
                case Base64.NO_WRAP /*2*/:
                    c.callFinished(this.f2892c, null);
                    break;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    c.callFinishedNoChange(this.f2892c);
                    break;
            }
            c.resetPreparedData();
        }
    }
}
