package com.avg.ui.general.customviews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;

public class SocialPanelView extends FrameLayout {
    private ImageButton f3456a;
    private ImageButton f3457b;
    private ImageButton f3458c;
    private Context f3459d;
    private String f3460e;
    private String f3461f;

    /* renamed from: com.avg.ui.general.customviews.SocialPanelView.1 */
    class C11371 implements OnClickListener {
        final /* synthetic */ SocialPanelView f3455a;

        C11371(SocialPanelView socialPanelView) {
            this.f3455a = socialPanelView;
        }

        public void onClick(View v) {
            int id = v.getId();
            if (id == C1082f.buttonLike) {
                this.f3455a.m4813b();
                GoogleAnalyticsWrapper.trackEvent(this.f3455a.f3459d, "Drawer", "Plus_one", "Tap", 0);
            } else if (id == C1082f.buttonShare) {
                this.f3455a.m4814c();
                GoogleAnalyticsWrapper.trackEvent(this.f3455a.f3459d, "Drawer", "Share", "Tap", 0);
            } else if (id == C1082f.buttonRate) {
                this.f3455a.m4816d();
                GoogleAnalyticsWrapper.trackEvent(this.f3455a.f3459d, "Drawer", "Rate", "Tap", 0);
            }
        }
    }

    public SocialPanelView(Context context) {
        this(context, null);
    }

    public SocialPanelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SocialPanelView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f3459d = context;
        m4810a();
    }

    public void m4818a(String shareSubject, String shareBody) {
        this.f3460e = shareSubject;
        this.f3461f = shareBody;
    }

    private void m4810a() {
        LayoutInflater.from(this.f3459d).inflate(C1084h.social_panel_layout, this);
        this.f3456a = (ImageButton) findViewById(C1082f.buttonLike);
        this.f3457b = (ImageButton) findViewById(C1082f.buttonShare);
        this.f3458c = (ImageButton) findViewById(C1082f.buttonRate);
        OnClickListener clickListener = new C11371(this);
        this.f3456a.setOnClickListener(clickListener);
        this.f3457b.setOnClickListener(clickListener);
        this.f3458c.setOnClickListener(clickListener);
    }

    private void m4813b() {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setPackage("com.google.android.apps.plus");
            intent.putExtra("+AVG", "FAN_PAGE_ID");
            this.f3459d.startActivity(intent);
        } catch (Exception e) {
            intent.setPackage(null);
            intent.setData(Uri.parse("https://plus.google.com/+AVG/posts"));
            this.f3459d.startActivity(intent);
        }
    }

    private void m4814c() {
        if (this.f3460e == null || this.f3461f == null) {
            C0970a.m4325b("No sharing data set! must set sharing data before call");
            return;
        }
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra("android.intent.extra.SUBJECT", this.f3460e);
        sharingIntent.putExtra("android.intent.extra.TEXT", this.f3461f);
        this.f3459d.startActivity(Intent.createChooser(sharingIntent, this.f3459d.getString(C1085i.share_using)));
    }

    private void m4816d() {
        String packageName = this.f3459d.getPackageName();
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse("market://details?id=" + packageName));
            this.f3459d.startActivity(intent);
        } catch (Exception e) {
            intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=" + packageName));
            this.f3459d.startActivity(intent);
        }
    }
}
