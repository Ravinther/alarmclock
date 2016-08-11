package com.avg.toolkit.zen.p054a;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.avg.toolkit.zen.p054a.C1038d.C1036a;
import java.lang.ref.WeakReference;

/* renamed from: com.avg.toolkit.zen.a.b */
public class C1034b extends AsyncTask {
    private C1033a f3180a;
    private WeakReference f3181b;
    private Context f3182c;
    private String f3183d;
    private String f3184e;

    public C1034b(Context context, C1033a onFinish, String appID, String trigger) {
        this(context, null, onFinish, appID, trigger);
    }

    public C1034b(Context context, Dialog dialog, C1033a onFinish, String appID, String trigger) {
        this.f3182c = context.getApplicationContext();
        this.f3180a = onFinish;
        this.f3181b = new WeakReference(dialog);
        this.f3184e = appID;
        this.f3183d = trigger;
    }

    protected void onPreExecute() {
        Dialog dialog = (Dialog) this.f3181b.get();
        if (dialog != null) {
            dialog.show();
        }
    }

    protected C1036a doInBackground(Void... params) {
        return C1038d.m4512a(this.f3182c, this.f3184e, this.f3183d);
    }

    protected void onPostExecute(C1036a result) {
        m4511a();
        if (this.f3180a != null) {
            this.f3180a.m4510a(result);
        }
    }

    protected void onCancelled() {
        super.onCancelled();
        m4511a();
    }

    private void m4511a() {
        Dialog dialog = (Dialog) this.f3181b.get();
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
