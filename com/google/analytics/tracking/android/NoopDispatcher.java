package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.mopub.mobileads.factories.HttpClientFactory;
import java.util.List;

class NoopDispatcher implements Dispatcher {
    NoopDispatcher() {
    }

    public boolean m5771a() {
        return true;
    }

    public int m5770a(List hits) {
        if (hits == null) {
            return 0;
        }
        Log.m5755e("Hits not actually being sent as dispatch is false...");
        int maxHits = Math.min(hits.size(), 40);
        for (int i = 0; i < maxHits; i++) {
            if (Log.m5751a()) {
                String logMessage;
                String modifiedHit = TextUtils.isEmpty(((Hit) hits.get(i)).m5740a()) ? "" : HitBuilder.m5746a((Hit) hits.get(i), System.currentTimeMillis());
                if (TextUtils.isEmpty(modifiedHit)) {
                    logMessage = "Hit couldn't be read, wouldn't be sent:";
                } else if (modifiedHit.length() <= 2036) {
                    logMessage = "GET would be sent:";
                } else if (modifiedHit.length() > HttpClientFactory.SOCKET_SIZE) {
                    logMessage = "Would be too big:";
                } else {
                    logMessage = "POST would be sent:";
                }
                Log.m5755e(logMessage + modifiedHit);
            }
        }
        return maxHits;
    }
}
