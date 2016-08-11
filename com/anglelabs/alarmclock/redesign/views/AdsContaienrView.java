package com.anglelabs.alarmclock.redesign.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ViewSwitcher;
import com.alarmclock.xtreme.free.R;
import com.anglelabs.alarmclock.redesign.utils.C0807e;
import com.avg.toolkit.ads.AdsManager;

public class AdsContaienrView extends FrameLayout {
    private ViewSwitcher f2507a;
    private AdsManager f2508b;
    private View f2509c;

    /* renamed from: com.anglelabs.alarmclock.redesign.views.AdsContaienrView.1 */
    class C08711 implements OnClickListener {
        final /* synthetic */ AdsContaienrView f2506a;

        C08711(AdsContaienrView adsContaienrView) {
            this.f2506a = adsContaienrView;
        }

        public void onClick(View v) {
        }
    }

    public AdsContaienrView(Context context) {
        super(context);
        m4069a(context);
    }

    public AdsContaienrView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m4069a(context);
    }

    public AdsContaienrView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        m4069a(context);
    }

    private void m4069a(Context context) {
        View.inflate(getContext(), R.layout.ads_container_view_layout, this);
        this.f2507a = (ViewSwitcher) findViewById(R.id.adsContainerViewSwitcher);
        this.f2509c = findViewById(R.id.adsContainerPlaceHolderAd);
        this.f2508b = (AdsManager) findViewById(R.id.adsContainerBanner);
        this.f2509c.setOnClickListener(new C08711(this));
        C0807e.m3813a(context, this.f2507a, 17432576, 17432577);
    }

    public void m4070a() {
        if (this.f2507a.getCurrentView().getId() == R.id.adsContainerPlaceHolderAd) {
            this.f2507a.showNext();
            this.f2509c.getLayoutParams().height = 0;
            this.f2509c.requestLayout();
            this.f2507a.requestLayout();
        }
    }

    public void m4071b() {
        if (this.f2507a.getCurrentView().getId() == R.id.adsContainerBanner) {
            this.f2507a.showPrevious();
        }
    }

    public AdsManager getAdsManager() {
        return this.f2508b;
    }
}
