package com.avg.ui.general.components;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.avg.ui.general.customviews.C1088a;

/* renamed from: com.avg.ui.general.components.b */
public class C1100b extends C1088a {
    private boolean f3320b;
    private boolean f3321c;

    public C1100b() {
        this.f3320b = false;
        this.f3321c = false;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setOnDismissListener(null);
        }
        super.onDestroyView();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new Dialog(getActivity(), getTheme());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProgressBar progbar = new ProgressBar(getActivity());
        Dialog dialog = getDialog();
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return progbar;
    }

    public void onStart() {
        super.onStart();
        if (this.f3321c) {
            dismiss();
        } else if (this.f3320b) {
            dismissAllowingStateLoss();
        }
    }

    @Deprecated
    public void dismiss() {
        if (getActivity() != null) {
            super.dismiss();
            this.f3321c = false;
            return;
        }
        this.f3321c = true;
    }

    public void dismissAllowingStateLoss() {
        if (getActivity() != null) {
            super.dismissAllowingStateLoss();
            this.f3320b = false;
            return;
        }
        this.f3320b = true;
    }
}
