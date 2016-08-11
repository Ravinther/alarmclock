package com.avg.ui.general.components;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p034b.C0956f;
import com.avg.toolkit.p047a.C0905a;
import com.avg.toolkit.p047a.C0905a.C0903b;
import com.avg.toolkit.uid.UUID;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.customviews.MoreAVGAppsWebView;
import com.avg.ui.general.customviews.MoreAVGAppsWebView.C1118a;
import com.avg.ui.general.p043e.C0720a;
import com.avg.ui.general.p059d.C1161a;
import com.avg.utils.C1192b;
import java.util.Locale;

/* renamed from: com.avg.ui.general.components.h */
public class C0721h extends C0720a {
    private C1100b f1856a;

    /* renamed from: com.avg.ui.general.components.h.1 */
    class C11191 implements C1118a {
        final /* synthetic */ C0721h f3378a;

        C11191(C0721h c0721h) {
            this.f3378a = c0721h;
        }

        public void m4749a(int offerID) {
        }

        public void m4750a(boolean error) {
            if (this.f3378a.f1856a != null && this.f3378a.f1856a.isAdded()) {
                this.f3378a.f1856a.dismissAllowingStateLoss();
            }
            if (error) {
                Activity activity = this.f3378a.getActivity();
                if (activity != null) {
                    Toast.makeText(activity.getApplicationContext(), C1085i.ias_alert_dialog_message, 1).show();
                    this.f3378a.m3383a(activity);
                }
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View content = inflater.inflate(C1084h.more_avg_apps, container, false);
        MoreAVGAppsWebView webContent = (MoreAVGAppsWebView) content.findViewById(C1082f.moreAppsWebView);
        webContent.setRequestLoginCallback(new C11191(this));
        C0956f serverBrowser = new C0956f(getActivity());
        String language = Locale.getDefault().getLanguage();
        C1017a myFeat = C1019b.m4431a();
        if (myFeat == null) {
            getActivity().finish();
        } else {
            C0903b productIDAndServer = C0905a.m4154a();
            String productIdNum = productIDAndServer != null ? String.valueOf(productIDAndServer.m4151a()) : "";
            int vendorId = myFeat.f3120f;
            String uri = serverBrowser.m4297a() + "/mobile/moreApps.jsp" + "?lang=" + language + "&pid=" + productIdNum + "&vend=" + vendorId + "&deviceId=" + new UUID(getActivity()).getUUID() + "&isTablet=" + C1192b.m4997a(getActivity());
            this.f1856a = new C1100b();
            this.f1856a.show(getFragmentManager(), "CustomWaitDialogFragment");
            webContent.m4790a(uri, false);
        }
        return content;
    }

    public String m3384b() {
        return "MoreAVGAppsFragment";
    }

    public int m3385c() {
        return C1085i.more_apps;
    }

    protected void m3383a(Activity activity) {
        try {
            m3369h().m4599n();
        } catch (C1161a e) {
            activity.finish();
        }
    }
}
