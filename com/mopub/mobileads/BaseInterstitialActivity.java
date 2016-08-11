package com.mopub.mobileads;

import android.app.Activity;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;

abstract class BaseInterstitialActivity extends Activity {
    private static final float CLOSE_BUTTON_PADDING = 8.0f;
    private static final float CLOSE_BUTTON_SIZE = 50.0f;
    private long mBroadcastIdentifier;
    private int mButtonPadding;
    private int mButtonSize;
    private ImageView mCloseButton;
    private RelativeLayout mLayout;

    /* renamed from: com.mopub.mobileads.BaseInterstitialActivity.1 */
    class C25941 implements OnClickListener {
        C25941() {
        }

        public void onClick(View v) {
            BaseInterstitialActivity.this.finish();
        }
    }

    enum JavaScriptWebViewCallbacks {
        WEB_VIEW_DID_APPEAR("javascript:webviewDidAppear();"),
        WEB_VIEW_DID_CLOSE("javascript:webviewDidClose();");
        
        private String mUrl;

        private JavaScriptWebViewCallbacks(String url) {
            this.mUrl = url;
        }

        protected String getUrl() {
            return this.mUrl;
        }
    }

    public abstract View getAdView();

    BaseInterstitialActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        this.mButtonSize = Dips.asIntPixels(CLOSE_BUTTON_SIZE, this);
        this.mButtonPadding = Dips.asIntPixels(CLOSE_BUTTON_PADDING, this);
        this.mLayout = new RelativeLayout(this);
        LayoutParams adViewLayout = new LayoutParams(-1, -2);
        adViewLayout.addRule(13);
        this.mLayout.addView(getAdView(), adViewLayout);
        setContentView(this.mLayout);
        AdConfiguration adConfiguration = getAdConfiguration();
        if (adConfiguration != null) {
            this.mBroadcastIdentifier = adConfiguration.getBroadcastIdentifier();
        }
        createInterstitialCloseButton();
    }

    protected void onDestroy() {
        this.mLayout.removeAllViews();
        super.onDestroy();
    }

    long getBroadcastIdentifier() {
        return this.mBroadcastIdentifier;
    }

    protected void showInterstitialCloseButton() {
        this.mCloseButton.setVisibility(0);
    }

    protected void hideInterstitialCloseButton() {
        this.mCloseButton.setVisibility(4);
    }

    protected AdConfiguration getAdConfiguration() {
        try {
            return (AdConfiguration) getIntent().getSerializableExtra(AdFetcher.AD_CONFIGURATION_KEY);
        } catch (ClassCastException e) {
            return null;
        }
    }

    private void createInterstitialCloseButton() {
        this.mCloseButton = new ImageButton(this);
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{-16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(this));
        states.addState(new int[]{16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(this));
        this.mCloseButton.setImageDrawable(states);
        this.mCloseButton.setBackgroundDrawable(null);
        this.mCloseButton.setOnClickListener(new C25941());
        LayoutParams buttonLayout = new LayoutParams(this.mButtonSize, this.mButtonSize);
        buttonLayout.addRule(11);
        buttonLayout.setMargins(this.mButtonPadding, 0, this.mButtonPadding, 0);
        this.mLayout.addView(this.mCloseButton, buttonLayout);
    }
}
