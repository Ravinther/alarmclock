package com.anglelabs.alarmclock.redesign.p026e.p027a;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.C0069f;
import android.widget.EditText;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0700b.C0699a;

/* renamed from: com.anglelabs.alarmclock.redesign.e.a.a */
public class C0698a extends C0069f {
    private EditText f1806a;
    private String f1807b;
    private long f1808c;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.a.a.1 */
    class C06961 implements OnClickListener {
        final /* synthetic */ C0698a f1804a;

        C06961(C0698a c0698a) {
            this.f1804a = c0698a;
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.a.a.2 */
    class C06972 implements OnClickListener {
        final /* synthetic */ C0698a f1805a;

        C06972(C0698a c0698a) {
            this.f1805a = c0698a;
        }

        public void onClick(DialogInterface dialog, int which) {
            if (!this.f1805a.f1806a.getText().toString().equals(this.f1805a.f1807b)) {
                C0699a listener = null;
                if (this.f1805a.getParentFragment() != null && (this.f1805a.getParentFragment() instanceof C0699a)) {
                    listener = (C0699a) this.f1805a.getParentFragment();
                } else if (this.f1805a.getActivity() instanceof C0699a) {
                    listener = (C0699a) this.f1805a.getActivity();
                }
                if (listener != null) {
                    listener.m3166a(this.f1805a.f1808c, this.f1805a.f1806a.getText().toString());
                }
            }
            dialog.dismiss();
        }
    }

    public static C0698a m3162a(boolean isPlaylist, long itemId, String currentName) {
        C0698a f = new C0698a();
        Bundle args = new Bundle();
        args.putString("current_name", currentName);
        args.putLong("item_id", itemId);
        args.putBoolean("is_item_playlist", isPlaylist);
        f.setArguments(args);
        return f;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        this.f1807b = getArguments().getString("current_name");
        this.f1808c = getArguments().getLong("item_id");
        boolean isPlaylist = getArguments().getBoolean("is_item_playlist");
        this.f1806a = new EditText(getActivity());
        this.f1806a.setText(this.f1807b);
        return new Builder(getActivity()).setTitle(isPlaylist ? R.string.edit_item_name_for_playlist : R.string.edit_item_name_for_song).setView(this.f1806a).setPositiveButton(R.string.general_save_button, new C06972(this)).setNegativeButton(R.string.general_cancel_button, new C06961(this)).create();
    }
}
