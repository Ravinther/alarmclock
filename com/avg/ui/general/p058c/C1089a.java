package com.avg.ui.general.p058c;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListAdapter;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.customviews.C1088a;
import com.avg.ui.general.p057b.C1075b;

/* renamed from: com.avg.ui.general.c.a */
public abstract class C1089a extends C1088a implements OnCancelListener, OnDismissListener, OnClickListener {
    protected String f3296b;
    private String f3297c;
    private View f3298d;
    private int f3299e;
    private String f3300f;
    private String f3301g;
    private int f3302h;
    private int f3303i;
    private int f3304j;
    private int f3305k;

    public C1089a() {
        this.f3303i = 0;
        this.f3304j = 0;
        this.f3305k = 0;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.f3297c = savedInstanceState.getString("name");
            this.f3296b = savedInstanceState.getString("tag");
            this.f3302h = savedInstanceState.getInt("dialogIcon");
            this.f3299e = savedInstanceState.getInt("dialogTitle");
            this.f3300f = savedInstanceState.getString("dialogTitleString");
            this.f3301g = savedInstanceState.getString("dialogBody");
            this.f3303i = savedInstanceState.getInt("positiveButtonText");
            this.f3304j = savedInstanceState.getInt("negativeButtonText");
            this.f3305k = savedInstanceState.getInt("neutralButtonText");
            this.a = Boolean.valueOf(savedInstanceState.getBoolean("is_dialog_shown"));
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog instanceof AlertDialog) {
            AlertDialog alertDialog = (AlertDialog) dialog;
            alertDialog.getButton(-1).setOnClickListener(this);
            alertDialog.getButton(-2).setOnClickListener(this);
            alertDialog.getButton(-3).setOnClickListener(this);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            this.f3297c = savedInstanceState.getString("name");
            this.f3296b = savedInstanceState.getString("tag");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = m4659e();
        Builder builder = new Builder(getActivity());
        if (m4660f() > 0) {
            builder.setTitle(m4660f());
        } else {
            builder.setTitle(m4661g());
        }
        String dialogBodyText = m4662h();
        ListAdapter singleChoiceAdapter = m4648r();
        int defaultSingleChoiceItems = m4652b();
        DialogInterface.OnClickListener singleChoiceListener = m4649a();
        if (dialogBodyText != null) {
            builder.setMessage(dialogBodyText);
        } else if (singleChoiceAdapter == null || defaultSingleChoiceItems < 0 || singleChoiceListener == null) {
            builder.setView(view);
        } else if (m4657c() || VERSION.SDK_INT < 11) {
            builder.setSingleChoiceItems(singleChoiceAdapter, defaultSingleChoiceItems, singleChoiceListener);
        } else {
            builder.setItems(m4658d(), singleChoiceListener);
        }
        int dialogIcon = m4663i();
        if (dialogIcon > 0) {
            builder.setIcon(dialogIcon);
        }
        int positiveText = m4664j();
        if (positiveText > 0) {
            builder.setPositiveButton(positiveText, null);
        }
        int negativeText = m4665k();
        if (negativeText > 0) {
            builder.setNegativeButton(negativeText, null);
        }
        int neutralText = m4666l();
        if (neutralText > 0) {
            builder.setNeutralButton(neutralText, null);
        }
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnDismissListener(this);
        return dialog;
    }

    protected DialogInterface.OnClickListener m4649a() {
        return null;
    }

    protected int m4652b() {
        return -1;
    }

    private ListAdapter m4648r() {
        if (m4652b() < 0 || m4658d() == null) {
            return null;
        }
        return new C1075b(getActivity(), m4652b(), m4657c(), m4658d());
    }

    protected boolean m4657c() {
        return true;
    }

    protected String[] m4658d() {
        return null;
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle outState) {
        outState.putString("name", this.f3297c);
        outState.putString("tag", this.f3296b);
        outState.putString("dialogBody", this.f3301g);
        outState.putInt("dialogIcon", this.f3302h);
        outState.putInt("dialogTitle", this.f3299e);
        outState.putString("dialogTitleString", this.f3300f);
        outState.putInt("positiveButtonText", this.f3303i);
        outState.putInt("negativeButtonText", this.f3304j);
        outState.putInt("neutralButtonText", this.f3305k);
        outState.putBoolean("is_dialog_shown", this.a.booleanValue());
        super.onSaveInstanceState(outState);
    }

    public void m4651a(String name) {
        this.f3297c = name;
    }

    public void m4654b(String callerFragmentTag) {
        this.f3296b = callerFragmentTag;
    }

    public View m4659e() {
        return this.f3298d;
    }

    public int m4660f() {
        return this.f3299e;
    }

    public String m4661g() {
        return this.f3300f;
    }

    public String m4662h() {
        return this.f3301g;
    }

    public int m4663i() {
        return this.f3302h;
    }

    public int m4664j() {
        return this.f3303i;
    }

    public int m4665k() {
        return this.f3304j;
    }

    public int m4666l() {
        return this.f3305k;
    }

    public void m4650a(int dialogTitle) {
        this.f3299e = dialogTitle;
    }

    public void m4656c(String dialogBody) {
        this.f3301g = dialogBody;
    }

    public void m4653b(int dialogIcon) {
        this.f3302h = dialogIcon;
    }

    public void m4655c(int positiveButtonText) {
        this.f3303i = positiveButtonText;
    }

    public void onClick(View v) {
        boolean allowedToDismiss;
        if (v.getId() == 16908313) {
            allowedToDismiss = m4669o();
        } else if (v.getId() == 16908314) {
            allowedToDismiss = m4668n();
        } else {
            allowedToDismiss = m4667m();
        }
        if (allowedToDismiss) {
            dismiss();
        }
    }

    protected boolean m4667m() {
        return true;
    }

    protected boolean m4668n() {
        return true;
    }

    protected boolean m4669o() {
        return true;
    }

    public String m4670p() {
        return this.f3297c;
    }

    public Fragment m4671q() {
        Fragment fragment = null;
        if (this.f3296b.contains("|")) {
            try {
                String[] splitTag = this.f3296b.split("|");
                String tabFragmentTag = splitTag[0];
                fragment = getActivity().m258g().m261a(tabFragmentTag).getChildFragmentManager().m261a(splitTag[1]);
            } catch (Exception e) {
                C0970a.m4325b("Fragment not showing");
            }
        } else {
            try {
                fragment = getActivity().m258g().m261a(this.f3296b);
            } catch (Exception e2) {
                C0970a.m4325b("Fragment not showing");
            }
        }
        return fragment;
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        dismiss();
    }
}
