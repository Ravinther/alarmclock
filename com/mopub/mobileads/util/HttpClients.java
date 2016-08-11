package com.mopub.mobileads.util;

import org.apache.http.client.HttpClient;

public class HttpClients {

    /* renamed from: com.mopub.mobileads.util.HttpClients.1 */
    static class C26351 implements Runnable {
        final /* synthetic */ HttpClient val$httpClient;

        C26351(HttpClient httpClient) {
            this.val$httpClient = httpClient;
        }

        public void run() {
            if (this.val$httpClient != null && this.val$httpClient.getConnectionManager() != null) {
                this.val$httpClient.getConnectionManager().shutdown();
            }
        }
    }

    public static void safeShutdown(HttpClient httpClient) {
        new Thread(new C26351(httpClient)).start();
    }
}
