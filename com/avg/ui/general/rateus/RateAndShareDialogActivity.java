package com.avg.ui.general.rateus;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.C0073g;
import android.support.v4.p006a.C0022i;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.wallet.fragment.Dimension;
import com.mopub.mobileads.util.Base64;

public class RateAndShareDialogActivity extends C0073g implements OnClickListener, OnDismissListener {
    private C1182a f3576n;
    private Dialog f3577o;
    private String f3578p;

    /* renamed from: com.avg.ui.general.rateus.RateAndShareDialogActivity.1 */
    class C11801 implements View.OnClickListener {
        final /* synthetic */ RateAndShareDialogActivity f3571a;

        C11801(RateAndShareDialogActivity rateAndShareDialogActivity) {
            this.f3571a = rateAndShareDialogActivity;
        }

        public void onClick(View v) {
            switch (C11812.f3572a[this.f3571a.f3576n.ordinal()]) {
                case Base64.NO_PADDING /*1*/:
                    C1186c.m4956a(this.f3571a.getApplicationContext()).m4988b(100);
                    this.f3571a.m4953k();
                case Base64.NO_WRAP /*2*/:
                    C1186c.m4956a(this.f3571a.getApplicationContext()).m4990c(103);
                    this.f3571a.m4954l();
                default:
            }
        }
    }

    /* renamed from: com.avg.ui.general.rateus.RateAndShareDialogActivity.2 */
    static /* synthetic */ class C11812 {
        static final /* synthetic */ int[] f3572a;

        static {
            f3572a = new int[C1182a.values().length];
            try {
                f3572a[C1182a.RATE_US.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3572a[C1182a.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* renamed from: com.avg.ui.general.rateus.RateAndShareDialogActivity.a */
    public enum C1182a {
        RATE_US,
        SHARE
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        this.f3578p = getIntent().getStringExtra("EXTRA_ON_DISMISS_ACTION");
        this.f3576n = (C1182a) getIntent().getSerializableExtra("EXTRA_DIALOG_MODE");
        this.f3577o = new Builder(this).setView(m4950h()).setPositiveButton(C1085i.rate_us_dialog_later, this).setNegativeButton(C1085i.rate_us_dialog_no_thanks, this).create();
        this.f3577o.setOnDismissListener(this);
        this.f3577o.show();
    }

    private View m4950h() {
        View view = null;
        String message = "";
        switch (C11812.f3572a[this.f3576n.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                view = View.inflate(this, C1084h.rate_us_dialog_activity, null);
                message = getString(C1085i.rate_us_dialog_body, new Object[]{getString(C1085i.app_name)});
                break;
            case Base64.NO_WRAP /*2*/:
                view = View.inflate(this, C1084h.share_dialog_activity, null);
                message = getString(C1085i.share_dialog_body, new Object[]{getString(C1085i.app_name)});
                break;
        }
        ((TextView) view.findViewById(C1082f.textViewDialogBody)).setText(message);
        view.findViewById(C1082f.buttonRate).setOnClickListener(new C11801(this));
        return view;
    }

    public void onDismiss(DialogInterface dialog) {
        if (!TextUtils.isEmpty(this.f3578p)) {
            C0022i.m108a((Context) this).m113a(new Intent(this.f3578p));
        }
        finish();
    }

    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case Dimension.WRAP_CONTENT /*-2*/:
                m4952j();
            case Dimension.MATCH_PARENT /*-1*/:
                m4951i();
            default:
        }
    }

    private void m4951i() {
        switch (C11812.f3572a[this.f3576n.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                C1186c.m4956a(getApplicationContext()).m4988b(101);
            case Base64.NO_WRAP /*2*/:
                C1186c.m4956a(getApplicationContext()).m4990c(101);
            default:
        }
    }

    private void m4952j() {
        switch (C11812.f3572a[this.f3576n.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                C1186c.m4956a(getApplicationContext()).m4988b((int) LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
            case Base64.NO_WRAP /*2*/:
                C1186c.m4956a(getApplicationContext()).m4990c((int) LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
            default:
        }
    }

    private void m4953k() {
        C1186c.m4956a((Context) this).m4984a();
        this.f3577o.dismiss();
        finish();
    }

    private void m4954l() {
        C1186c.m4956a((Context) this).m4987b();
    }
}
