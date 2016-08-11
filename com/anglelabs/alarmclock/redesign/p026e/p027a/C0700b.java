package com.anglelabs.alarmclock.redesign.p026e.p027a;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.C0069f;
import com.alarmclock.xtreme.free.R;

/* renamed from: com.anglelabs.alarmclock.redesign.e.a.b */
public class C0700b extends C0069f {

    /* renamed from: com.anglelabs.alarmclock.redesign.e.a.b.a */
    public interface C0699a {
        void m3166a(long j, String str);

        void m3167a(String str);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle("");
        dialog.setMessage(getString(R.string.progress_dialog_connecting_title));
        dialog.setOnCancelListener(this);
        dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (getParentFragment() != null && (getParentFragment() instanceof C0699a)) {
            ((C0699a) getParentFragment()).m3167a("HelpProgressDialogFragment");
        } else if (getActivity() instanceof C0699a) {
            ((C0699a) getActivity()).m3167a("HelpProgressDialogFragment");
        }
    }
}
