package com.avg.ui.general.p060f;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.p058c.C1089a;

/* renamed from: com.avg.ui.general.f.a */
public class C1168a extends C1089a {
    public C1168a() {
        m4651a("HelpProgressDialogFragment");
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle("");
        dialog.setMessage(getString(C1085i.ias_progress_dialog_title));
        dialog.setOnCancelListener(this);
        dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        return dialog;
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Fragment caller = m4671q();
        if (caller != null && (caller instanceof C1172b)) {
            ((C1172b) caller).m4888u();
        }
    }
}
