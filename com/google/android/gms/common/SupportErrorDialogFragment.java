package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.C0069f;
import android.support.v4.app.C0075i;
import com.google.android.gms.internal.fq;

public class SupportErrorDialogFragment extends C0069f {
    private OnCancelListener Ai;
    private Dialog mDialog;

    public SupportErrorDialogFragment() {
        this.mDialog = null;
        this.Ai = null;
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, OnCancelListener cancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) fq.m8517b((Object) dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.mDialog = dialog2;
        if (cancelListener != null) {
            supportErrorDialogFragment.Ai = cancelListener;
        }
        return supportErrorDialogFragment;
    }

    public void onCancel(DialogInterface dialog) {
        if (this.Ai != null) {
            this.Ai.onCancel(dialog);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return this.mDialog;
    }

    public void show(C0075i manager, String tag) {
        super.show(manager, tag);
    }
}
