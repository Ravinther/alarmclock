package com.anglelabs.alarmclock.redesign.p026e;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.p020a.C0539b;
import com.anglelabs.alarmclock.redesign.p020a.C0539b.C0537a;
import com.anglelabs.alarmclock.redesign.p021b.p025a.C0564a;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0700b;
import com.anglelabs.alarmclock.redesign.p026e.p027a.C0700b.C0699a;
import com.anglelabs.alarmclock.redesign.utils.C0794b;
import com.anglelabs.alarmclock.redesign.utils.C0830k;
import com.anglelabs.alarmclock.redesign.utils.C0830k.C0820h;
import com.anglelabs.alarmclock.redesign.utils.C0850q;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p035c.C0650a;
import com.avg.toolkit.p035c.C0740b;
import com.avg.toolkit.p047a.C0905a;
import com.avg.toolkit.p047a.C0905a.C0903b;
import com.avg.toolkit.uid.UUID;
import com.google.android.gms.games.GamesStatusCodes;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.anglelabs.alarmclock.redesign.e.f */
public class C0745f extends Fragment implements OnItemClickListener, C0699a {
    private C0539b f1907a;
    private boolean f1908b;
    private Runnable f1909c;
    private final IntentFilter f1910d;
    private final BroadcastReceiver f1911e;
    private Handler f1912f;
    private AlertDialog f1913g;
    private C0700b f1914h;

    /* renamed from: com.anglelabs.alarmclock.redesign.e.f.1 */
    class C07411 extends C0740b {
        final /* synthetic */ C0745f f1903a;

        C07411(C0745f c0745f) {
            this.f1903a = c0745f;
        }

        protected void m3468a(Context context) {
            this.f1903a.m3474c();
        }

        protected void m3469b(Context context) {
            this.f1903a.m3476e();
            this.f1903a.m3477a();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.f.2 */
    class C07422 implements Runnable {
        final /* synthetic */ C0745f f1904a;

        C07422(C0745f c0745f) {
            this.f1904a = c0745f;
        }

        public void run() {
            this.f1904a.m3476e();
            this.f1904a.m3477a();
            this.f1904a.m3474c();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.f.3 */
    class C07433 implements OnClickListener {
        final /* synthetic */ C0745f f1905a;

        C07433(C0745f c0745f) {
            this.f1905a = c0745f;
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.e.f.4 */
    static /* synthetic */ class C07444 {
        static final /* synthetic */ int[] f1906a;

        static {
            f1906a = new int[C0537a.values().length];
            try {
                f1906a[C0537a.CONTACT_US.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1906a[C0537a.ONLINE_HELP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public C0745f() {
        this.f1909c = null;
        this.f1910d = new IntentFilter("inAppIntentFilterScreen");
        this.f1911e = new C07411(this);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof C0564a) {
            ((C0564a) getActivity()).m2573n().m3754b(getString(R.string.acx_main_menu_help));
        }
        C0794b.m3778a(getActivity());
        C0794b.m3787d(getActivity());
    }

    public void onDetach() {
        super.onDetach();
        C0794b.m3785b(getActivity());
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.redesign_simple_list_view_layout, container, false);
        ListView list = (ListView) v.findViewById(R.id.list);
        this.f1907a = new C0539b(getActivity());
        list.setAdapter(this.f1907a);
        list.setOnItemClickListener(this);
        C0830k.m3896a(getActivity(), C0820h.Screen);
        return v;
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
        switch (C07444.f1906a[((C0537a) this.f1907a.getItem(position)).ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                m3479a(getActivity());
                C0830k.m3896a(getActivity(), C0820h.ContactUs);
            case Base64.NO_WRAP /*2*/:
                m3472b();
                C0830k.m3896a(getActivity(), C0820h.Online);
            default:
        }
    }

    public void onPause() {
        if (this.f1913g != null && this.f1913g.isShowing()) {
            this.f1913g.dismiss();
        }
        super.onPause();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isInAppRequestInProgress", this.f1908b);
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.getBoolean("isInAppRequestInProgress", false)) {
            m3479a(getActivity());
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f1908b = false;
    }

    void m3479a(Context context) {
        this.f1908b = true;
        getActivity().registerReceiver(this.f1911e, this.f1910d);
        C0650a.m2994a(context);
        m3475d();
        if (this.f1912f == null) {
            this.f1912f = new Handler();
        }
        if (this.f1909c == null) {
            this.f1909c = new C07422(this);
        }
        this.f1912f.postDelayed(this.f1909c, 15000);
    }

    private void m3472b() {
        Bundle bundle = new Bundle();
        bundle.putString(ITKSvc.c_actionData, C0745f.m3470a("/help.html", getActivity()));
        ITKSvc.Do(getActivity(), GamesStatusCodes.STATUS_REAL_TIME_CONNECTION_FAILED, GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, bundle);
    }

    private static String m3470a(String baseUrl, Context context) {
        if (C1019b.m4431a() == null) {
            return baseUrl;
        }
        String deviceId = new UUID(context).getUUID();
        if (deviceId == null) {
            deviceId = "";
        }
        C0903b productIDAndServer = C0905a.m4154a();
        String prodId = productIDAndServer != null ? String.valueOf(productIDAndServer.m4151a()) : "";
        return String.format("%s?device_sn=%s&varCode=%s&pid=%s", new Object[]{baseUrl, deviceId, Integer.valueOf(C1019b.m4431a().f3120f), prodId});
    }

    public void onStop() {
        super.onStop();
        m3476e();
        m3477a();
    }

    private void m3474c() {
        Builder dialogFragmentBuilder = new Builder(getActivity());
        dialogFragmentBuilder.setTitle(R.string.connection_error_title);
        dialogFragmentBuilder.setIcon(R.drawable.ic_stat_notify_error);
        dialogFragmentBuilder.setMessage(R.string.connection_error_message);
        dialogFragmentBuilder.setPositiveButton(R.string.ok, new C07433(this));
        this.f1913g = dialogFragmentBuilder.create();
        this.f1913g.show();
    }

    private void m3475d() {
        if (getChildFragmentManager().m261a("HelpProgressDialogFragment") == null) {
            this.f1914h = new C0700b();
            try {
                this.f1914h.show(getChildFragmentManager(), "HelpProgressDialogFragment");
            } catch (Exception e) {
                C0850q.m3984a(e);
            }
        }
    }

    void m3477a() {
        this.f1908b = false;
        if (this.f1909c != null) {
            this.f1912f.removeCallbacks(this.f1909c);
            m3476e();
        }
        try {
            getActivity().unregisterReceiver(this.f1911e);
        } catch (Exception e) {
        }
    }

    private void m3476e() {
        if (this.f1914h != null && this.f1914h.isAdded()) {
            this.f1914h.dismissAllowingStateLoss();
            this.f1914h = null;
        }
    }

    public void m3480a(String tag) {
        if (tag.equals("HelpProgressDialogFragment")) {
            m3477a();
        }
    }

    public void m3478a(long itemId, String tag) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
        if (menu != null) {
            menu.clear();
        }
        super.onPrepareOptionsMenu(menu);
    }
}
