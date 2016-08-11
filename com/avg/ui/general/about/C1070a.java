package com.avg.ui.general.about;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.components.C0721h;
import com.avg.ui.general.components.DrawerActivity;
import com.avg.ui.general.components.DrawerActivity.C1094a;
import com.avg.ui.general.customviews.SocialPanelView;
import com.avg.ui.general.p043e.C0720a;
import com.avg.ui.general.p059d.C1161a;
import com.avg.ui.general.p060f.C1172b;

/* renamed from: com.avg.ui.general.about.a */
public class C1070a extends C0720a {
    private TextView f3264a;
    private TextView f3265d;
    private TextView f3266e;
    private TextView f3267f;

    /* renamed from: com.avg.ui.general.about.a.1 */
    class C10661 implements OnClickListener {
        final /* synthetic */ C1070a f3260a;

        C10661(C1070a c1070a) {
            this.f3260a = c1070a;
        }

        public void onClick(View v) {
            this.f3260a.m4626a();
        }
    }

    /* renamed from: com.avg.ui.general.about.a.2 */
    class C10672 implements OnClickListener {
        final /* synthetic */ C1070a f3261a;

        C10672(C1070a c1070a) {
            this.f3261a = c1070a;
        }

        public void onClick(View v) {
            GoogleAnalyticsWrapper.trackEvent(this.f3261a.getActivity(), "Drawer", "About_TOS", "Tap", 0);
        }
    }

    /* renamed from: com.avg.ui.general.about.a.3 */
    class C10683 implements OnClickListener {
        final /* synthetic */ C1070a f3262a;

        C10683(C1070a c1070a) {
            this.f3262a = c1070a;
        }

        public void onClick(View v) {
            GoogleAnalyticsWrapper.trackEvent(this.f3262a.getActivity(), "Drawer", "About_PP", "Tap", 0);
        }
    }

    /* renamed from: com.avg.ui.general.about.a.4 */
    class C10694 implements OnClickListener {
        final /* synthetic */ C1070a f3263a;

        C10694(C1070a c1070a) {
            this.f3263a = c1070a;
        }

        public void onClick(View v) {
            GoogleAnalyticsWrapper.trackEvent(this.f3263a.getActivity(), "Drawer", "About_SOURCE", "Tap", 0);
        }
    }

    public static C1070a m4623a(String shareSubjectID, String shareBodyID, int titleImageID) {
        C1070a fragment = new C1070a();
        Bundle bundle = new Bundle();
        bundle.putString("extra_data_share_subject", shareSubjectID);
        bundle.putString("extra_data_share_body", shareBodyID);
        bundle.putInt("extra_data_title_image", titleImageID);
        fragment.setArguments(bundle);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(C1084h.about_layout, container, false);
        this.f3264a = (TextView) view.findViewById(C1082f.textViewTermsHyperlink);
        this.f3265d = (TextView) view.findViewById(C1082f.textViewPrivacyHyperlink);
        this.f3266e = (TextView) view.findViewById(C1082f.textViewSourceLicHyperlink);
        ImageView imageViewAboutAppIcon = (ImageView) view.findViewById(C1082f.imageViewAboutAppIcon);
        this.f3267f = (TextView) view.findViewById(C1082f.textViewAboutVersion);
        SocialPanelView socialPanelView = (SocialPanelView) view.findViewById(C1082f.socialPanelView);
        ((Button) view.findViewById(C1082f.buttonAboutMoveApps)).setOnClickListener(new C10661(this));
        Bundle args = getArguments();
        if (args != null) {
            String shareSubject = args.getString("extra_data_share_subject");
            if (shareSubject == null) {
                shareSubject = "";
            }
            String shareBody = args.getString("extra_data_share_body");
            if (shareBody == null) {
                shareBody = "";
            }
            int appImage = args.getInt("extra_data_title_image", 0);
            socialPanelView.m4818a(shareSubject, shareBody);
            if (appImage != 0) {
                imageViewAboutAppIcon.setImageResource(appImage);
            }
        }
        m4624d();
        m4625u();
        return view;
    }

    protected void m4626a() {
        try {
            m3369h().m4596a(new C0721h());
        } catch (C1161a e) {
            C0970a.m4325b("Unable to navigate: AboutFragment");
            Intent intent = new Intent(getActivity(), DrawerActivity.class);
            intent.putExtra("fragment_type", C1094a.MORE_APPS);
            startActivity(intent);
        }
    }

    private void m4624d() {
        String versionNameAndCode = "";
        try {
            Context context = getActivity().getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionNameAndCode = packageInfo.versionName + "." + packageInfo.versionCode;
        } catch (Exception e) {
            C0970a.m4322a(e);
        }
        this.f3267f.setText(getString(C1085i.about_version) + " " + versionNameAndCode);
    }

    private void m4625u() {
        if (getActivity() != null && !getActivity().isFinishing() && C1019b.m4431a() != null) {
            String termsText = getString(C1085i.activation_terms);
            String agreeingText = getString(C1085i.activation_privacy);
            String openSource = getString(C1085i.activation_open_source);
            this.f3264a.setMovementMethod(LinkMovementMethod.getInstance());
            this.f3264a.setText(Html.fromHtml("<a href='" + C1172b.m4873a(C1019b.m4431a(), getActivity().getApplicationContext()) + "'>" + termsText + "</a>"));
            this.f3264a.setOnClickListener(new C10672(this));
            this.f3265d.setMovementMethod(LinkMovementMethod.getInstance());
            this.f3265d.setText(Html.fromHtml("<a href='" + C1172b.m4872a(getActivity().getApplicationContext()) + "'>" + agreeingText + "</a> "));
            this.f3265d.setOnClickListener(new C10683(this));
            this.f3266e.setMovementMethod(LinkMovementMethod.getInstance());
            this.f3266e.setText(Html.fromHtml("<a href='" + C1172b.m4877b(getActivity().getApplicationContext()) + "'>" + openSource + "</a> "));
            this.f3266e.setOnClickListener(new C10694(this));
        }
    }

    public String m4627b() {
        return "AboutFragment";
    }

    public int m4628c() {
        return C1085i.about_action_bar_title;
    }
}
