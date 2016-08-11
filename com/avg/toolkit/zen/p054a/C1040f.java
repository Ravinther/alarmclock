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

/* renamed from: com.avg.toolkit.zen.a.f */
public class C1040f extends AsyncTask {
    private C1033a f3207a;
    private WeakReference f3208b;
    private Context f3209c;
    private String f3210d;
    private String f3211e;
    private boolean f3212f;
    private C1045b f3213g;
    private String f3214h;

    public C1040f(Context context, String email, String pwd, C1045b reportBuilder, boolean register, C1033a onFinish, String trigger) {
        this(context, null, email, pwd, reportBuilder, register, onFinish, trigger);
    }

    public C1040f(Context context, Dialog dialog, String email, String pwd, C1045b reportBuilder, boolean register, C1033a onFinish, String trigger) {
        this.f3209c = context.getApplicationContext();
        this.f3207a = onFinish;
        this.f3208b = new WeakReference(dialog);
        this.f3214h = trigger;
        this.f3210d = email;
        this.f3211e = pwd;
        this.f3212f = register;
        this.f3213g = reportBuilder;
    }

    protected void onPreExecute() {
        Dialog dialog = (Dialog) this.f3208b.get();
        if (dialog != null) {
            dialog.show();
        }
    }

    protected C1043i doInBackground(Void... params) {
        HttpResponse commResponse = C1038d.m4516a(this.f3209c, this.f3210d, this.f3211e, this.f3212f, this.f3213g, this.f3214h);
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
        m4529a();
        if (this.f3207a != null) {
            this.f3207a.m4509a(C1032a.ZEN, result.f3225b, result.f3224a);
        }
    }

    protected void onCancelled() {
        super.onCancelled();
        m4529a();
    }

    private void m4529a() {
        Dialog dialog = (Dialog) this.f3208b.get();
        if (dialog != null) {
            try {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
