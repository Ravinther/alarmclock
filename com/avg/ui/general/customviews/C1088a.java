package com.avg.ui.general.customviews;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.C0069f;
import android.support.v4.app.C0075i;

/* renamed from: com.avg.ui.general.customviews.a */
public abstract class C1088a extends C0069f {
    protected Boolean f3294a;
    private OnClickListener f3295b;

    /* renamed from: com.avg.ui.general.customviews.a.1 */
    class C11491 implements OnClickListener {
        final /* synthetic */ C1088a f3493a;

        C11491(C1088a c1088a) {
            this.f3493a = c1088a;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.f3493a.dismiss();
        }
    }

    public C1088a() {
        this.f3294a = Boolean.valueOf(false);
        this.f3295b = new C11491(this);
    }

    public void onCancel(DialogInterface dialog) {
        dismiss();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        Builder dialogBuilder = new Builder(context);
        m4636a(dialogBuilder, context.getApplicationContext());
        m4637b(dialogBuilder, context.getApplicationContext());
        m4638c(dialogBuilder, context.getApplicationContext());
        return dialogBuilder.create();
    }

    public void show(C0075i manager, String tag) {
        try {
            synchronized (this.f3294a) {
                if (!this.f3294a.booleanValue()) {
                    this.f3294a = Boolean.valueOf(true);
                    super.show(manager, tag);
                }
            }
        } catch (Exception e) {
        }
    }

    public void onDismiss(DialogInterface dialog) {
        synchronized (this.f3294a) {
            if (this.f3294a.booleanValue()) {
                super.onDismiss(dialog);
                this.f3294a = Boolean.valueOf(false);
            }
        }
    }

    protected String m4639a(Context context) {
        return "";
    }

    protected int m4640b(Context context) {
        return 0;
    }

    protected String m4641c(Context context) {
        return "";
    }

    protected String m4642d(Context appContext) {
        return "";
    }

    protected String m4643e(Context appContext) {
        return "";
    }

    protected String m4644f(Context appContext) {
        return "";
    }

    protected OnClickListener m4645g(Context appContext) {
        return null;
    }

    protected OnClickListener m4646h(Context appContext) {
        return null;
    }

    protected OnClickListener m4647i(Context appContext) {
        return null;
    }

    private void m4636a(Builder dialogBuilder, Context appContext) {
        String title = m4639a(appContext);
        if (title != null) {
            dialogBuilder.setTitle(title);
        }
        int imageID = m4640b(appContext);
        if (imageID != 0) {
            dialogBuilder.setIcon(imageID);
        }
    }

    private void m4637b(Builder dialogBuilder, Context context) {
        String message = m4641c(context);
        if (message != null) {
            dialogBuilder.setMessage(message);
        }
    }

    private void m4638c(Builder dialogBuilder, Context appContext) {
        String positiveText = m4642d(appContext);
        if (positiveText != null) {
            OnClickListener positiveListener = m4645g(appContext);
            if (positiveListener == null) {
                positiveListener = this.f3295b;
            }
            dialogBuilder.setPositiveButton(positiveText, positiveListener);
        }
        String negativeText = m4643e(appContext);
        if (negativeText != null) {
            OnClickListener negativeListener = m4646h(appContext);
            if (negativeListener == null) {
                negativeListener = this.f3295b;
            }
            dialogBuilder.setNegativeButton(negativeText, negativeListener);
        }
        String neutralText = m4644f(appContext);
        if (neutralText != null) {
            OnClickListener neutralListener = m4647i(appContext);
            if (neutralListener == null) {
                neutralListener = this.f3295b;
            }
            dialogBuilder.setNeutralButton(neutralText, neutralListener);
        }
    }
}
