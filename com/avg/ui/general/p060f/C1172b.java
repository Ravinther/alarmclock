package com.avg.ui.general.p060f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0069f;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p034b.C0952b;
import com.avg.toolkit.p034b.C0956f;
import com.avg.toolkit.p035c.C0650a;
import com.avg.toolkit.p035c.C0740b;
import com.avg.toolkit.p047a.C0905a;
import com.avg.toolkit.p047a.C0905a.C0903b;
import com.avg.toolkit.uid.UUID;
import com.avg.ui.general.C1091c.C1080d;
import com.avg.ui.general.C1091c.C1081e;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.C1167e;
import com.avg.ui.general.p043e.C1166b;
import com.avg.ui.general.p057b.C1073a;
import com.avg.ui.general.p057b.C1073a.C1071a;
import com.avg.ui.general.p057b.C1073a.C1072b;
import com.avg.ui.general.p058c.C1089a;
import com.avg.ui.general.p058c.C1090b;
import com.google.android.gms.games.GamesStatusCodes;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;

/* renamed from: com.avg.ui.general.f.b */
public class C1172b extends C1166b implements OnItemClickListener {
    private C1171a f3547a;
    private Runnable f3548d;
    private Handler f3549e;
    private IntentFilter f3550f;
    private boolean f3551g;
    private BroadcastReceiver f3552h;

    /* renamed from: com.avg.ui.general.f.b.1 */
    class C11691 extends C0740b {
        final /* synthetic */ C1172b f3543a;

        C11691(C1172b c1172b) {
            this.f3543a = c1172b;
        }

        protected void m4869a(Context context) {
            this.f3543a.m4880v();
        }

        protected void m4870b(Context context) {
            this.f3543a.m4882x();
            this.f3543a.m4888u();
        }
    }

    /* renamed from: com.avg.ui.general.f.b.2 */
    class C11702 implements Runnable {
        final /* synthetic */ C1172b f3544a;

        C11702(C1172b c1172b) {
            this.f3544a = c1172b;
        }

        public void run() {
            this.f3544a.m4882x();
            this.f3544a.m4888u();
            this.f3544a.m4880v();
        }
    }

    /* renamed from: com.avg.ui.general.f.b.a */
    public class C1171a extends C1073a {
        final /* synthetic */ C1172b f3545a;
        private int f3546b;

        public C1171a(C1172b c1172b, Context context, ArrayList items) {
            this.f3545a = c1172b;
            super(context, items);
            this.f3546b = -1;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);
            C1072b holder = new C1072b(this);
            holder.f3278d = (ImageView) view.findViewById(C1082f.ll_selection);
            holder.f3276b = (TextView) view.findViewById(C1082f.summary);
            holder.f3275a = (TextView) view.findViewById(C1082f.title);
            if (C1167e.m4868a()) {
                if (position == this.f3546b) {
                    view.setBackgroundResource(C1080d.selected_list_item_bg);
                    holder.f3278d.setVisibility(0);
                } else {
                    view.setBackgroundResource(C1080d.transparent);
                    holder.f3278d.setVisibility(4);
                }
                holder.f3276b.setVisibility(8);
            }
            return view;
        }

        public void m4871a(int index) {
            this.f3546b = index;
        }
    }

    public C1172b() {
        this.f3548d = null;
        this.f3550f = new IntentFilter("inAppIntentFilterScreen");
        this.f3552h = new C11691(this);
    }

    public String m4884b() {
        return "UIHelpFragment";
    }

    public int m4885c() {
        return C1085i.help;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C1084h.listview_fragment, container, false);
        m4875a(view);
        return view;
    }

    public void onResume() {
        super.onResume();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f3551g = false;
    }

    public void onDestroy() {
        m4882x();
        m4888u();
        super.onDestroy();
    }

    private void m4875a(View view) {
        this.f3547a = new C1171a(this, getActivity(), m4886c(view.getContext()));
        ListView mList = (ListView) view.findViewById(C1082f.list);
        mList.setOnItemClickListener(this);
        mList.setAdapter(this.f3547a);
    }

    public void onItemClick(AdapterView parent, View view, int position, long id) {
        boolean isNetOk = C0952b.m4281a(getActivity());
        this.f3547a.m4871a(position);
        this.f3547a.notifyDataSetChanged();
        switch ((int) id) {
            case Base64.DEFAULT /*0*/:
                if (isNetOk) {
                    Bundle bundle = new Bundle();
                    bundle.putString(ITKSvc.c_actionData, C1172b.m4874a("/help.html", getActivity()));
                    ITKSvc.Do(getActivity(), GamesStatusCodes.STATUS_REAL_TIME_CONNECTION_FAILED, GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, bundle);
                    GoogleAnalyticsWrapper.trackEvent(getActivity(), "Drawer", "Help_FAQ", "Tap", 0);
                    return;
                }
                Toast.makeText(getActivity().getApplicationContext(), getActivity().getString(C1085i.ias_alert_dialog_message), 1).show();
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (isNetOk) {
                    m4883a();
                    GoogleAnalyticsWrapper.trackEvent(getActivity(), "Drawer", "Help_contactUs", "Tap", 0);
                    return;
                }
                Toast.makeText(getActivity().getApplicationContext(), getActivity().getString(C1085i.ias_alert_dialog_message), 1).show();
            default:
        }
    }

    public static String m4873a(C1017a avgFeatures, Context context) {
        return new C0956f(context).m4297a() + C1172b.m4878b(avgFeatures, context);
    }

    private static String m4878b(C1017a avgFeatures, Context context) {
        return avgFeatures.m4426a() ? C1172b.m4874a("/tospro.html", context) : C1172b.m4874a("/tos.html", context);
    }

    public static String m4872a(Context context) {
        return new C0956f(context).m4297a() + C1172b.m4874a("/privacy.html", context);
    }

    public static String m4877b(Context context) {
        return new C0956f(context).m4297a() + C1172b.m4874a("/oss.html", context);
    }

    public static String m4874a(String baseUrl, Context context) {
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

    protected ArrayList m4886c(Context context) {
        ArrayList items = new ArrayList();
        items.add(new C1071a(getActivity().getString(C1085i.title_help_preference), "", 0));
        items.add(new C1071a(getActivity().getString(C1085i.ias_help_contact_header), getActivity().getString(C1085i.ias_help_contact_body), 3));
        return items;
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("isInAppRequestInProgress", this.f3551g);
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.getBoolean("isInAppRequestInProgress", false)) {
            m4883a();
        }
    }

    public void m4883a() {
        this.f3551g = true;
        getActivity().registerReceiver(this.f3552h, this.f3550f);
        m4887d();
        m4881w();
        if (this.f3549e == null) {
            this.f3549e = new Handler();
        }
        if (this.f3548d == null) {
            this.f3548d = new C11702(this);
        }
        this.f3549e.postDelayed(this.f3548d, 15000);
    }

    protected void m4887d() {
        C0650a.m2994a(getActivity());
    }

    public void m4888u() {
        this.f3551g = false;
        if (!(this.f3549e == null || this.f3548d == null)) {
            this.f3549e.removeCallbacks(this.f3548d);
        }
        try {
            if (this.f3552h != null) {
                getActivity().unregisterReceiver(this.f3552h);
            }
        } catch (Exception e) {
        }
    }

    private void m4880v() {
        C1090b dialogFragment = new C1090b();
        dialogFragment.m4651a("InAppSupportCommFailDialog");
        dialogFragment.m4654b("UIHelpFragment");
        dialogFragment.m4650a(C1085i.ias_alert_dialog_title);
        dialogFragment.m4653b(C1081e.dialog_icon_error);
        dialogFragment.m4656c(getString(C1085i.ias_alert_dialog_message));
        dialogFragment.m4655c(C1085i.ok);
        m3355a((C1089a) dialogFragment);
    }

    private void m4881w() {
        if (getActivity().m258g().m261a("HelpProgressDialogFragment") == null) {
            C1168a progressDialogFragment = new C1168a();
            progressDialogFragment.m4654b(getTag());
            m3355a((C1089a) progressDialogFragment);
        }
    }

    private boolean m4882x() {
        C0069f dialogFragment = (C0069f) getActivity().m258g().m261a("HelpProgressDialogFragment");
        if (dialogFragment == null || !dialogFragment.isResumed()) {
            return false;
        }
        dialogFragment.dismissAllowingStateLoss();
        return true;
    }
}
