package com.anglelabs.alarmclock.redesign.p026e.p027a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0069f;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.utils.C0834n;
import com.anglelabs.alarmclock.redesign.utils.C0834n.C0833a;
import com.avg.toolkit.p049e.C0970a;

/* renamed from: com.anglelabs.alarmclock.redesign.e.a.d */
public class C0707d extends C0069f {
    private C0565a f1818a;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.a.d.a */
    public interface C0565a {
        void m2575k();

        void m2576l();
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.a.d.1 */
    class C07051 implements OnClickListener {
        final /* synthetic */ C0707d f1816a;

        C07051(C0707d c0707d) {
            this.f1816a = c0707d;
        }

        public void onClick(DialogInterface dialog, int which) {
            if (this.f1816a.f1818a != null) {
                this.f1816a.f1818a.m2576l();
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.a.d.2 */
    class C07062 implements OnClickListener {
        final /* synthetic */ C0707d f1817a;

        C07062(C0707d c0707d) {
            this.f1817a = c0707d;
        }

        public void onClick(DialogInterface dialog, int which) {
            if (this.f1817a.f1818a != null) {
                this.f1817a.f1818a.m2575k();
            }
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof C0565a) {
            this.f1818a = (C0565a) activity;
        } else {
            C0970a.m4325b("Activity must implement TermsOfServiceReceiver");
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.redesign_tos_fragment_layout, null);
        TextView message = (TextView) view.findViewById(R.id.message);
        message.setMovementMethod(LinkMovementMethod.getInstance());
        message.setText(m3175a());
        Builder alertBuilder = new Builder(getActivity());
        alertBuilder.setTitle(R.string.tos_dialog_title).setView(view).setPositiveButton(R.string.ok, new C07062(this)).setNegativeButton(R.string.cancel, new C07051(this));
        if (VERSION.SDK_INT <= 13) {
            alertBuilder.setInverseBackgroundForced(true);
        }
        AlertDialog dialog = alertBuilder.create();
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    public void onCancel(DialogInterface dialog) {
        getActivity().finish();
    }

    private SpannableStringBuilder m3175a() {
        SpannableStringBuilder ssb = new SpannableStringBuilder(getString(R.string.tos_dialog_message, getString(R.string.about_term_of_service), getString(R.string.about_privacy_policy)));
        m3177a(ssb, tosLink, C0833a.TOS);
        m3177a(ssb, privacyLink, C0833a.PRIVACY);
        return ssb;
    }

    private void m3177a(SpannableStringBuilder ssb, String toLink, C0833a linkPathType) {
        int linkStartIndex = ssb.toString().indexOf(toLink);
        if (linkStartIndex != -1 && !TextUtils.isEmpty(toLink)) {
            ssb.setSpan(new URLSpan(C0834n.m3946a(getActivity(), linkPathType)), linkStartIndex, toLink.length() + linkStartIndex, 33);
        }
    }
}
