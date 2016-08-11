package com.avg.toolkit.zen.p054a;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.avg.toolkit.zen.C1045b;
import com.avg.toolkit.zen.C1050e;
import com.avg.toolkit.zen.p054a.C1038d.C1036a;
import java.lang.ref.WeakReference;

/* renamed from: com.avg.toolkit.zen.a.h */
class C1042h extends AsyncTask {
    private C1033a f3219a;
    private WeakReference f3220b;
    private Context f3221c;
    private String f3222d;
    private C1045b f3223e;

    public C1042h(Context context, C1045b reportBuilder, C1033a onFinish, String trigger) {
        this(context, null, reportBuilder, onFinish, trigger);
    }

    public C1042h(Context context, Dialog dialog, C1045b reportBuilder, C1033a onFinish, String trigger) {
        this.f3221c = context.getApplicationContext();
        this.f3219a = onFinish;
        this.f3220b = new WeakReference(dialog);
        this.f3223e = reportBuilder;
        this.f3222d = trigger;
    }

    protected void onPreExecute() {
        Dialog dialog = (Dialog) this.f3220b.get();
        if (dialog != null) {
            dialog.show();
        }
    }

    protected C1036a doInBackground(Void... params) {
        return C1038d.m4522b(this.f3221c, this.f3223e, this.f3222d);
    }

    protected void onPostExecute(C1036a result) {
        boolean success;
        m4531a();
        if (result == C1036a.SUCCESS) {
            success = true;
        } else {
            success = false;
        }
        if (success) {
            C1050e.m4544b(this.f3221c, false);
        }
        if (this.f3219a != null) {
            this.f3219a.m4510a(result);
        }
    }

    protected void onCancelled() {
        super.onCancelled();
        m4531a();
    }

    private void m4531a() {
        Dialog dialog = (Dialog) this.f3220b.get();
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (IllegalArgumentException e) {
            }
        }
    }
}
