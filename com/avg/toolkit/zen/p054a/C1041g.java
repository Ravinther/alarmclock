package com.avg.toolkit.zen.p054a;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.avg.toolkit.zen.p054a.C1038d.C1036a;
import java.lang.ref.WeakReference;

/* renamed from: com.avg.toolkit.zen.a.g */
public class C1041g extends AsyncTask {
    private C1033a f3215a;
    private WeakReference f3216b;
    private Context f3217c;
    private String f3218d;

    public C1041g(Context context, Dialog dialog, C1033a onFinish, String trigger) {
        this.f3217c = context.getApplicationContext();
        this.f3215a = onFinish;
        this.f3216b = new WeakReference(dialog);
        this.f3218d = trigger;
    }

    protected void onPreExecute() {
        Dialog dialog = (Dialog) this.f3216b.get();
        if (dialog != null) {
            dialog.show();
        }
    }

    protected C1036a doInBackground(Void... params) {
        return C1038d.m4523b(this.f3217c, this.f3218d);
    }

    protected void onPostExecute(C1036a result) {
        m4530a();
        if (this.f3215a != null) {
            this.f3215a.m4510a(result);
        }
    }

    protected void onCancelled() {
        super.onCancelled();
        m4530a();
    }

    private void m4530a() {
        Dialog dialog = (Dialog) this.f3216b.get();
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
