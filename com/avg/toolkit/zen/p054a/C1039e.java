package com.avg.toolkit.zen.p054a;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.avg.toolkit.zen.C1045b;
import com.avg.toolkit.zen.p054a.C1033a.C1032a;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

/* renamed from: com.avg.toolkit.zen.a.e */
public class C1039e extends AsyncTask {
    private C1033a f3201a;
    private WeakReference f3202b;
    private Context f3203c;
    private String f3204d;
    private String f3205e;
    private C1045b f3206f;

    public C1039e(Context context, String pin, C1045b reportBuilder, C1033a onFinish, String trigger) {
        this(context, null, pin, reportBuilder, onFinish, trigger);
    }

    public C1039e(Context context, Dialog dialog, String pin, C1045b reportBuilder, C1033a onFinish, String trigger) {
        this.f3203c = context.getApplicationContext();
        this.f3201a = onFinish;
        this.f3202b = new WeakReference(dialog);
        this.f3204d = trigger;
        this.f3205e = pin;
        this.f3206f = reportBuilder;
    }

    protected void onPreExecute() {
        Dialog dialog = (Dialog) this.f3202b.get();
        if (dialog != null) {
            dialog.show();
        }
    }

    protected C1043i doInBackground(Void... params) {
        HttpResponse commResponse = C1038d.m4515a(this.f3203c, this.f3206f, this.f3205e, this.f3204d);
        C1043i response = new C1043i();
        if (commResponse != null) {
            try {
                response.f3224a = EntityUtils.toString(commResponse.getEntity(), "UTF-8");
                response.f3225b = commResponse.getStatusLine().getStatusCode();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    protected void onPostExecute(C1043i result) {
        m4528a();
        if (this.f3201a != null) {
            this.f3201a.m4509a(C1032a.ZEN, result.f3225b, result.f3224a);
        }
    }

    protected void onCancelled() {
        super.onCancelled();
        m4528a();
    }

    private void m4528a() {
        Dialog dialog = (Dialog) this.f3202b.get();
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
