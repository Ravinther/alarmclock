package com.avg.ui.general.components;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.ProgressBar;

/* renamed from: com.avg.ui.general.components.a */
public class C1099a extends Dialog {
    public C1099a(Context context) {
        this(context, 0);
    }

    public C1099a(Context context, int theme) {
        super(context, theme);
        m4690a(true);
    }

    private void m4690a(boolean cancelable) {
        ProgressBar progbar = new ProgressBar(getContext());
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(progbar);
        setCancelable(cancelable);
        setCanceledOnTouchOutside(false);
    }
}
