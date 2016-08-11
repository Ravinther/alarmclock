package com.avg.toolkit.zen.p054a;

import android.content.Context;
import android.os.AsyncTask;
import com.avg.toolkit.zen.C1050e;
import com.avg.toolkit.zen.p054a.C1038d.C1036a;

/* renamed from: com.avg.toolkit.zen.a.c */
public class C1035c extends AsyncTask {
    private Context f3185a;
    private String f3186b;
    private String f3187c;

    public C1035c(Context appContext, String gcmToken, String appId) {
        this.f3185a = appContext.getApplicationContext();
        this.f3186b = gcmToken;
        this.f3187c = appId;
    }

    protected C1036a doInBackground(Void... params) {
        return C1038d.m4524b(this.f3185a, this.f3187c, this.f3186b);
    }

    protected void onPostExecute(C1036a result) {
        if (result == C1036a.SUCCESS) {
            C1050e.m4544b(this.f3185a, false);
        }
    }
}
