package com.google.android.gms.internal;

import android.content.Context;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class du extends C1810do {
    private final String lh;
    private final Context mContext;
    private final String ro;

    public du(Context context, String str, String str2) {
        this.mContext = context;
        this.lh = str;
        this.ro = str2;
    }

    public void aY() {
        HttpURLConnection httpURLConnection;
        try {
            dw.m8220y("Pinging URL: " + this.ro);
            httpURLConnection = (HttpURLConnection) new URL(this.ro).openConnection();
            dq.m8178a(this.mContext, this.lh, true, httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 200 || responseCode >= 300) {
                dw.m8221z("Received non-success response code " + responseCode + " from pinging URL: " + this.ro);
            }
            httpURLConnection.disconnect();
        } catch (IndexOutOfBoundsException e) {
            dw.m8221z("Error while parsing ping URL: " + this.ro + ". " + e.getMessage());
        } catch (IOException e2) {
            dw.m8221z("Error while pinging URL: " + this.ro + ". " + e2.getMessage());
        } catch (Throwable th) {
            httpURLConnection.disconnect();
        }
    }

    public void onStop() {
    }
}
