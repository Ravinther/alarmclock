package com.mopub.mobileads.util.vast;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import com.mopub.common.util.Strings;
import java.lang.ref.WeakReference;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;

public class VastXmlManagerAggregator extends AsyncTask {
    static final int MAX_TIMES_TO_FOLLOW_VAST_REDIRECT = 20;
    private int mTimesFollowedVastRedirect;
    private final WeakReference mVastXmlManagerAggregatorListener;

    interface VastXmlManagerAggregatorListener {
        void onAggregationComplete(List list);
    }

    VastXmlManagerAggregator(VastXmlManagerAggregatorListener vastXmlManagerAggregatorListener) {
        this.mVastXmlManagerAggregatorListener = new WeakReference(vastXmlManagerAggregatorListener);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.util.List doInBackground(java.lang.String... r8) {
        /*
        r7 = this;
        r3 = 0;
        r1 = 0;
        r1 = com.mopub.common.HttpClient.getHttpClient();	 Catch:{ Exception -> 0x003c }
        if (r8 == 0) goto L_0x0036;
    L_0x0008:
        r6 = r8.length;	 Catch:{ Exception -> 0x003c }
        if (r6 <= 0) goto L_0x0036;
    L_0x000b:
        r6 = 0;
        r2 = r8[r6];	 Catch:{ Exception -> 0x003c }
        r4 = new java.util.ArrayList;	 Catch:{ Exception -> 0x003c }
        r4.<init>();	 Catch:{ Exception -> 0x003c }
    L_0x0013:
        if (r2 == 0) goto L_0x0035;
    L_0x0015:
        r6 = r2.length();	 Catch:{ Exception -> 0x0052, all -> 0x004f }
        if (r6 <= 0) goto L_0x0035;
    L_0x001b:
        r6 = r7.isCancelled();	 Catch:{ Exception -> 0x0052, all -> 0x004f }
        if (r6 != 0) goto L_0x0035;
    L_0x0021:
        r5 = new com.mopub.mobileads.util.vast.VastXmlManager;	 Catch:{ Exception -> 0x0052, all -> 0x004f }
        r5.<init>();	 Catch:{ Exception -> 0x0052, all -> 0x004f }
        r5.parseVastXml(r2);	 Catch:{ Exception -> 0x0052, all -> 0x004f }
        r4.add(r5);	 Catch:{ Exception -> 0x0052, all -> 0x004f }
        r6 = r5.getVastAdTagURI();	 Catch:{ Exception -> 0x0052, all -> 0x004f }
        r2 = r7.followVastRedirect(r1, r6);	 Catch:{ Exception -> 0x0052, all -> 0x004f }
        goto L_0x0013;
    L_0x0035:
        r3 = r4;
    L_0x0036:
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();
    L_0x003b:
        return r3;
    L_0x003c:
        r0 = move-exception;
    L_0x003d:
        r6 = "Failed to parse VAST XML";
        com.mopub.common.util.MoPubLog.m9730d(r6, r0);	 Catch:{ all -> 0x0048 }
        if (r1 == 0) goto L_0x003b;
    L_0x0044:
        r1.close();
        goto L_0x003b;
    L_0x0048:
        r6 = move-exception;
    L_0x0049:
        if (r1 == 0) goto L_0x004e;
    L_0x004b:
        r1.close();
    L_0x004e:
        throw r6;
    L_0x004f:
        r6 = move-exception;
        r3 = r4;
        goto L_0x0049;
    L_0x0052:
        r0 = move-exception;
        r3 = r4;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.util.vast.VastXmlManagerAggregator.doInBackground(java.lang.String[]):java.util.List");
    }

    protected void onPostExecute(List vastXmlManagers) {
        VastXmlManagerAggregatorListener listener = (VastXmlManagerAggregatorListener) this.mVastXmlManagerAggregatorListener.get();
        if (listener != null) {
            listener.onAggregationComplete(vastXmlManagers);
        }
    }

    protected void onCancelled() {
        VastXmlManagerAggregatorListener listener = (VastXmlManagerAggregatorListener) this.mVastXmlManagerAggregatorListener.get();
        if (listener != null) {
            listener.onAggregationComplete(null);
        }
    }

    String followVastRedirect(AndroidHttpClient httpClient, String redirectUrl) {
        if (redirectUrl == null || this.mTimesFollowedVastRedirect >= MAX_TIMES_TO_FOLLOW_VAST_REDIRECT) {
            return null;
        }
        this.mTimesFollowedVastRedirect++;
        HttpEntity entity = httpClient.execute(new HttpGet(redirectUrl)).getEntity();
        if (entity != null) {
            return Strings.fromStream(entity.getContent());
        }
        return null;
    }

    @Deprecated
    void setTimesFollowedVastRedirect(int timesFollowedVastRedirect) {
        this.mTimesFollowedVastRedirect = timesFollowedVastRedirect;
    }
}
