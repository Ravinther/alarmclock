package com.avg.ui.general.customviews;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.C0073g;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p034b.C0952b;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.zen.C1050e;
import com.avg.toolkit.zen.p054a.C1033a;
import com.avg.toolkit.zen.p054a.C1033a.C1032a;
import com.avg.toolkit.zen.p054a.C1038d;
import com.avg.toolkit.zen.p054a.C1038d.C1036a;
import com.avg.toolkit.zen.p054a.C1041g;
import com.avg.ui.general.C1091c.C1081e;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.components.C1099a;
import com.avg.ui.general.components.C1120i;
import com.avg.ui.general.components.DrawerActivity;
import com.avg.ui.general.components.DrawerActivity.C1094a;
import com.avg.ui.general.p055a.C1058a;
import java.util.List;

public class ZenDrawer extends DrawerLayout {
    private static final String f3479b;
    private Context f3480c;
    private C1144a f3481d;
    private Button f3482e;
    private Button f3483f;
    private ViewGroup f3484g;
    private TextView f3485h;
    private C1145b f3486i;
    private Button f3487j;
    private Button f3488k;
    private Button f3489l;
    private View f3490m;
    private boolean f3491n;
    private OnClickListener f3492o;

    /* renamed from: com.avg.ui.general.customviews.ZenDrawer.1 */
    class C11381 implements OnClickListener {
        final /* synthetic */ ZenDrawer f3462a;

        C11381(ZenDrawer zenDrawer) {
            this.f3462a = zenDrawer;
        }

        public void onClick(View v) {
            int id = v.getId();
            if (id == C1082f.buttonManageDevices) {
                String str;
                C1120i.m4751a(this.f3462a.f3480c, C1019b.m4431a(), "ZenDrawer");
                Context a = this.f3462a.f3480c;
                String str2 = "Zen";
                String str3 = "Zen_Network";
                if (C1120i.m4752a(this.f3462a.f3480c)) {
                    str = "Open_zen";
                } else {
                    str = "Download_page";
                }
                GoogleAnalyticsWrapper.trackEvent(a, str2, str3, str, 0);
            } else if (id == C1082f.buttonMoreApps) {
                if (C0952b.m4281a(this.f3462a.f3480c)) {
                    this.f3462a.m4832a(C1094a.MORE_APPS);
                    GoogleAnalyticsWrapper.trackEvent(this.f3462a.f3480c, "Drawer", "More_apps", "Tap", 0);
                    return;
                }
                Toast.makeText(this.f3462a.f3480c.getApplicationContext(), C1085i.ias_alert_dialog_message, 1).show();
            } else if (id == C1082f.buttonZenNetworkManage) {
                this.f3462a.m4832a(((Boolean) this.f3462a.f3483f.getTag()).booleanValue() ? C1094a.NETWORK : C1094a.JOIN);
                GoogleAnalyticsWrapper.trackEvent(this.f3462a.f3480c, "Zen", "Join_zen_link", C1050e.m4567q(this.f3462a.f3480c) ? "Joined_network" : "Enter_token", 0);
            } else if (id == C1082f.textViewStatus) {
                boolean z;
                ZenDrawer zenDrawer = this.f3462a;
                if (this.f3462a.f3491n) {
                    z = false;
                } else {
                    z = true;
                }
                zenDrawer.f3491n = z;
                this.f3462a.m4841a(true, true);
            } else if (id == C1082f.buttonDrawerLogin) {
                if (!C1050e.m4568r(this.f3462a.f3480c)) {
                    this.f3462a.m4832a(C1094a.LOGIN);
                    GoogleAnalyticsWrapper.trackEvent(this.f3462a.f3480c, "Drawer", "Login", "Tap", 0);
                }
            } else if (id == C1082f.buttonDrawerLogOut) {
                if (C1050e.m4568r(this.f3462a.f3480c)) {
                    if (this.f3462a.f3480c instanceof C0073g) {
                        C1088a dialog = new C1148c();
                        if (this.f3462a.f3480c instanceof C1058a) {
                            ((C1058a) this.f3462a.f3480c).m4605a(dialog, "LogoutDialog");
                        } else {
                            dialog.show(((C0073g) this.f3462a.f3480c).m258g(), "LogoutDialog");
                        }
                    } else {
                        C0970a.m4325b("Error: Activity must extends FragmentActivity in order to show dialog");
                    }
                    GoogleAnalyticsWrapper.trackEvent(this.f3462a.f3480c, "Drawer", "Logout", "Tap", 0);
                }
            } else if (id == C1082f.buttonDrawerMyAccount) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://myaccount.avg.com/my-account-login"));
                this.f3462a.f3480c.startActivity(intent);
            }
        }
    }

    /* renamed from: com.avg.ui.general.customviews.ZenDrawer.2 */
    static class C11392 extends Animation {
        final /* synthetic */ View f3463a;
        final /* synthetic */ int f3464b;

        C11392(View view, int i) {
            this.f3463a = view;
            this.f3464b = i;
        }

        protected void applyTransformation(float interpolatedTime, Transformation t) {
            this.f3463a.getLayoutParams().height = interpolatedTime == 1.0f ? -2 : (int) (((float) this.f3464b) * interpolatedTime);
            this.f3463a.requestLayout();
        }

        public boolean willChangeBounds() {
            return true;
        }
    }

    /* renamed from: com.avg.ui.general.customviews.ZenDrawer.3 */
    static class C11403 extends Animation {
        final /* synthetic */ View f3465a;
        final /* synthetic */ int f3466b;

        C11403(View view, int i) {
            this.f3465a = view;
            this.f3466b = i;
        }

        protected void applyTransformation(float interpolatedTime, Transformation t) {
            if (interpolatedTime == 1.0f) {
                this.f3465a.setVisibility(8);
                return;
            }
            this.f3465a.getLayoutParams().height = this.f3466b - ((int) (((float) this.f3466b) * interpolatedTime));
            this.f3465a.requestLayout();
        }

        public boolean willChangeBounds() {
            return true;
        }
    }

    /* renamed from: com.avg.ui.general.customviews.ZenDrawer.4 */
    class C11414 implements OnClickListener {
        final /* synthetic */ C1142a f3467a;
        final /* synthetic */ ZenDrawer f3468b;

        C11414(ZenDrawer zenDrawer, C1142a c1142a) {
            this.f3468b = zenDrawer;
            this.f3467a = c1142a;
        }

        public void onClick(View v) {
            this.f3467a.f3470b.m4819a();
            if (this.f3467a.f3471c != null) {
                GoogleAnalyticsWrapper.trackEvent(this.f3468b.f3480c, "Drawer", this.f3467a.f3471c, "Tap", 0);
            }
        }
    }

    /* renamed from: com.avg.ui.general.customviews.ZenDrawer.a */
    public static class C1144a {
        public List f3472a;
        public String f3473b;
        public String f3474c;

        /* renamed from: com.avg.ui.general.customviews.ZenDrawer.a.a */
        public static class C1142a {
            public String f3469a;
            public C1143b f3470b;
            public String f3471c;
        }

        /* renamed from: com.avg.ui.general.customviews.ZenDrawer.a.b */
        public interface C1143b {
            void m4819a();
        }
    }

    /* renamed from: com.avg.ui.general.customviews.ZenDrawer.b */
    private class C1145b extends BroadcastReceiver {
        final /* synthetic */ ZenDrawer f3475a;

        private C1145b(ZenDrawer zenDrawer) {
            this.f3475a = zenDrawer;
        }

        public void onReceive(Context context, Intent intent) {
            this.f3475a.m4842f();
        }
    }

    /* renamed from: com.avg.ui.general.customviews.ZenDrawer.c */
    public static class C1148c extends C1088a {

        /* renamed from: com.avg.ui.general.customviews.ZenDrawer.c.1 */
        class C11461 implements DialogInterface.OnClickListener {
            final /* synthetic */ C1148c f3476a;

            C11461(C1148c c1148c) {
                this.f3476a = c1148c;
            }

            @TargetApi(11)
            public void onClick(DialogInterface dialog, int which) {
                Context appContext = this.f3476a.getActivity().getApplicationContext();
                String avPackage = this.f3476a.m4824j(appContext);
                if ("".equals(avPackage)) {
                    this.f3476a.m4825k(this.f3476a.getActivity());
                } else {
                    Intent intent = appContext.getPackageManager().getLaunchIntentForPackage(avPackage);
                    intent.setFlags(268468224);
                    appContext.startActivity(intent);
                }
                this.f3476a.dismiss();
            }
        }

        /* renamed from: com.avg.ui.general.customviews.ZenDrawer.c.2 */
        class C11472 implements C1033a {
            final /* synthetic */ Context f3477a;
            final /* synthetic */ C1148c f3478b;

            C11472(C1148c c1148c, Context context) {
                this.f3478b = c1148c;
                this.f3477a = context;
            }

            public void m4821a(C1036a type) {
                C1038d.m4517a(this.f3477a);
            }

            public void m4820a(C1032a type, int responseCode, String JsonBody) {
            }
        }

        protected String m4826a(Context appContext) {
            return appContext.getString(C1085i.logout_dialog_title);
        }

        protected String m4827c(Context appContext) {
            return appContext.getString("".equals(m4824j(appContext)) ? C1085i.logout_dialog : C1085i.logout_from_av_dialog);
        }

        protected String m4828d(Context appContext) {
            return appContext.getString(C1085i.ok);
        }

        protected DialogInterface.OnClickListener m4830g(Context appContext) {
            return new C11461(this);
        }

        protected String m4829e(Context appContext) {
            return appContext.getString(C1085i.cancel);
        }

        private String m4824j(Context appContext) {
            String currentPackage = appContext.getPackageName();
            String[] packages = new String[]{"com.antivirus", "org.antivirus", "com.antivirus.tablet", "org.antivirus.tablet", "store.antivirus", "oem.antivirus", "com.s.antivirus", "dev.antivirus"};
            PackageManager packageManager = appContext.getPackageManager();
            String[] arr$ = packages;
            int len$ = arr$.length;
            int i$ = 0;
            while (i$ < len$) {
                String pack = arr$[i$];
                if (pack.equals(currentPackage)) {
                    return "";
                }
                try {
                    int versionInt = Integer.parseInt(packageManager.getPackageInfo(pack, 1).versionName.split("\\.")[0]);
                    if (versionInt >= 4 || versionInt == 0) {
                        return pack;
                    }
                    i$++;
                } catch (NameNotFoundException e) {
                } catch (NumberFormatException e2) {
                }
            }
            return "";
        }

        private void m4825k(Context context) {
            Context appContext = context.getApplicationContext();
            new C1041g(appContext, new C1099a(context), new C11472(this, appContext), "logoutFromDrawer").execute(new Void[0]);
        }
    }

    static {
        f3479b = null;
    }

    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("KEY_MY_ACCOUNT_OPEN", this.f3491n);
        bundle.putParcelable(f3479b, super.onSaveInstanceState());
        return bundle;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            this.f3491n = bundle.getBoolean("KEY_MY_ACCOUNT_OPEN", false);
            state = bundle.getParcelable(f3479b);
        }
        super.onRestoreInstanceState(state);
    }

    protected void m4841a(boolean animate, boolean isConnected) {
        if (this.f3491n && isConnected) {
            this.f3485h.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1081e.click_to_close, 0);
            if (animate) {
                m4839l(this.f3490m);
                return;
            } else {
                this.f3490m.setVisibility(0);
                return;
            }
        }
        this.f3491n = false;
        this.f3485h.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1081e.click_to_open, 0);
        if (animate) {
            m4840m(this.f3490m);
        } else {
            this.f3490m.setVisibility(8);
        }
    }

    public static void m4839l(View viewToExpand) {
        viewToExpand.measure(-1, -2);
        int targtetHeight = viewToExpand.getMeasuredHeight();
        viewToExpand.setVisibility(0);
        if (targtetHeight != 0) {
            viewToExpand.getLayoutParams().height = 0;
            Animation animation = new C11392(viewToExpand, targtetHeight);
            animation.setDuration((long) ((int) (((float) targtetHeight) / viewToExpand.getContext().getResources().getDisplayMetrics().density)));
            viewToExpand.startAnimation(animation);
        }
    }

    public static void m4840m(View viewToCollapse) {
        int initialHeight = viewToCollapse.getMeasuredHeight();
        Animation animation = new C11403(viewToCollapse, initialHeight);
        animation.setDuration((long) ((int) (((float) initialHeight) / viewToCollapse.getContext().getResources().getDisplayMetrics().density)));
        viewToCollapse.startAnimation(animation);
    }

    public ZenDrawer(Context context) {
        this(context, null);
    }

    public ZenDrawer(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZenDrawer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f3492o = new C11381(this);
        this.f3480c = context;
        this.f3486i = new C1145b();
        context.registerReceiver(this.f3486i, new IntentFilter("com.avg.zen.loginreceiver"));
    }

    protected void onDetachedFromWindow() {
        this.f3480c.unregisterReceiver(this.f3486i);
        super.onDetachedFromWindow();
    }

    public void setExternalData(C1144a externalData) {
        if (externalData == null) {
            C0970a.m4325b("Cannot accept null for ExternalData");
            return;
        }
        boolean firstData = this.f3481d == null;
        this.f3481d = externalData;
        if (firstData) {
            m4837g();
        }
        m4838h();
    }

    private void m4837g() {
        setFocusableInTouchMode(true);
        LayoutInflater.from(this.f3480c).inflate(C1084h.zen_menu_layout, this);
        this.f3485h = (TextView) findViewById(C1082f.textViewStatus);
        this.f3487j = (Button) findViewById(C1082f.buttonDrawerMyAccount);
        this.f3488k = (Button) findViewById(C1082f.buttonDrawerLogOut);
        this.f3489l = (Button) findViewById(C1082f.buttonDrawerLogin);
        this.f3490m = findViewById(C1082f.linearLayoutDrawerMyAccount);
        this.f3482e = (Button) findViewById(C1082f.buttonManageDevices);
        this.f3483f = (Button) findViewById(C1082f.buttonZenNetworkManage);
        Button buttonMoreApps = (Button) findViewById(C1082f.buttonMoreApps);
        this.f3484g = (ViewGroup) findViewById(C1082f.linearLayoutDrawerButtons);
        this.f3485h.setOnClickListener(this.f3492o);
        this.f3487j.setOnClickListener(this.f3492o);
        this.f3488k.setOnClickListener(this.f3492o);
        this.f3489l.setOnClickListener(this.f3492o);
        buttonMoreApps.setOnClickListener(this.f3492o);
        buttonMoreApps.setText(C1085i.more_apps);
        if (C1050e.m4570t(this.f3480c)) {
            this.f3482e.setVisibility(8);
            this.f3483f.setVisibility(8);
        } else {
            this.f3483f.setOnClickListener(this.f3492o);
            this.f3483f.setText(C1085i.manage_devices);
            this.f3482e.setOnClickListener(this.f3492o);
            this.f3482e.setText(C1085i.manage_devices);
        }
        m4842f();
    }

    public void m4842f() {
        int i = 8;
        boolean connected = C1050e.m4568r(this.f3480c);
        boolean joined = C1050e.m4567q(this.f3480c);
        if (connected) {
            this.f3485h.setText(Html.fromHtml(this.f3480c.getString(C1085i.connected_as) + "<small><font color=\"#bbbbbb\"><br/>" + C1050e.m4547d(this.f3480c) + "</font></small>"));
            this.f3489l.setVisibility(8);
            this.f3485h.setVisibility(0);
        } else {
            this.f3485h.setText(C1085i.zen_log_in);
            this.f3489l.setVisibility(0);
            this.f3485h.setVisibility(8);
        }
        m4841a(false, connected);
        if (!C1050e.m4570t(this.f3480c)) {
            Button button = this.f3482e;
            if (!joined) {
                i = 0;
            }
            button.setVisibility(i);
            this.f3483f.setText(joined ? C1085i.my_zen_network : C1085i.enter_invitation);
            this.f3483f.setTag(Boolean.valueOf(joined));
        }
    }

    private void m4838h() {
        ((SocialPanelView) findViewById(C1082f.socialPanel)).m4818a(this.f3481d.f3473b, this.f3481d.f3474c);
        if (this.f3481d.f3472a != null && this.f3481d.f3472a.size() != 0) {
            LayoutInflater inflater = LayoutInflater.from(this.f3480c);
            for (C1142a drawerItem : this.f3481d.f3472a) {
                Button button = (Button) inflater.inflate(C1084h.zen_menu_item_layout, null);
                button.setText(drawerItem.f3469a);
                button.setOnClickListener(new C11414(this, drawerItem));
                this.f3484g.addView(button);
            }
        }
    }

    private void m4832a(C1094a type) {
        C1058a.f3244o = true;
        Intent intent = new Intent(this.f3480c, DrawerActivity.class);
        intent.putExtra("fragment_type", type);
        this.f3480c.startActivity(intent);
    }
}
