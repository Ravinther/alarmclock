package com.avg.ui.general.customviews;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.customviews.Dashboard.C1122a;
import com.avg.ui.general.customviews.Dashboard.C1122a.C1121a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.avg.ui.general.customviews.b */
public class C1153b extends LinearLayout {
    private C1151a f3501a;
    private TextView f3502b;
    private TextView f3503c;
    private Button f3504d;
    private LinearLayout f3505e;

    /* renamed from: com.avg.ui.general.customviews.b.1 */
    static /* synthetic */ class C11501 {
        static final /* synthetic */ int[] f3494a;

        static {
            f3494a = new int[C1152b.values().length];
            try {
                f3494a[C1152b.eOnlyButton.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3494a[C1152b.eButtonAndTitle.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3494a[C1152b.eTitleAndSubTitle.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3494a[C1152b.eOnlyTitle.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3494a[C1152b.eAllItems.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.avg.ui.general.customviews.b.a */
    public interface C1151a extends C1122a {
        void m4843b();

        String m4844c();

        OnClickListener m4845d();

        String m4846e();

        C1121a m4847f();

        String m4848g();

        boolean m4849h();
    }

    /* renamed from: com.avg.ui.general.customviews.b.b */
    private enum C1152b {
        eOnlyButton,
        eButtonAndTitle,
        eAllItems,
        eOnlyTitle,
        eTitleAndSubTitle
    }

    public void setConfiguration(C1151a iDashboardButtonConfiguration) {
        this.f3501a = iDashboardButtonConfiguration;
        m4850a();
    }

    public void m4850a() {
        if (this.f3501a != null) {
            this.f3501a.m4843b();
            boolean buttonVisible = this.f3501a.m4849h();
            if (buttonVisible) {
                this.f3504d.setOnClickListener(this.f3501a.m4845d());
                this.f3504d.setText(this.f3501a.m4844c());
            }
            String titleText = this.f3501a.m4846e();
            if (titleText == null || titleText.length() == 0) {
                setupTextWeight(C1152b.eOnlyButton);
                return;
            }
            this.f3502b.setText(this.f3501a.m4846e());
            if (this.f3501a.m4847f() != null) {
                this.f3502b.setTextColor(getResources().getColor(this.f3501a.m4847f().m4756a()));
            }
            String subtitleText = this.f3501a.m4848g();
            if (subtitleText == null || subtitleText.length() == 0) {
                this.f3503c.setText("");
                setupTextWeight(buttonVisible ? C1152b.eButtonAndTitle : C1152b.eOnlyTitle);
                return;
            }
            this.f3503c.setText(subtitleText);
            setupTextWeight(buttonVisible ? C1152b.eAllItems : C1152b.eTitleAndSubTitle);
        }
    }

    private void setupUi(Context context) {
        View.inflate(context, C1084h.dashboard_button_view, this);
        this.f3505e = (LinearLayout) findViewById(C1082f.root_layout);
        this.f3502b = (TextView) findViewById(C1082f.title);
        this.f3503c = (TextView) findViewById(C1082f.subtitle);
        this.f3504d = (Button) findViewById(C1082f.dashboardButton);
    }

    private void setupTextWeight(C1152b eDashboardTextSetup) {
        if (this.f3501a.m4757a()) {
            this.f3505e.setGravity(0);
        } else {
            this.f3505e.setGravity(17);
        }
        switch (C11501.f3494a[eDashboardTextSetup.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                this.f3504d.setVisibility(0);
                this.f3504d.setVisibility(0);
                this.f3502b.setVisibility(8);
                this.f3503c.setVisibility(8);
            case Base64.NO_WRAP /*2*/:
                this.f3504d.setVisibility(0);
                this.f3502b.setVisibility(0);
                this.f3503c.setVisibility(8);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                this.f3504d.setVisibility(8);
                this.f3502b.setVisibility(0);
                this.f3503c.setVisibility(0);
            case Base64.CRLF /*4*/:
                this.f3504d.setVisibility(8);
                this.f3502b.setVisibility(0);
                this.f3503c.setVisibility(8);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                this.f3504d.setVisibility(0);
                this.f3502b.setVisibility(0);
                this.f3503c.setVisibility(0);
            default:
                this.f3502b.setVisibility(0);
                this.f3503c.setVisibility(0);
        }
    }
}
