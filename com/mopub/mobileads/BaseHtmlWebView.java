package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.common.util.VersionCode;

public class BaseHtmlWebView extends BaseWebView implements UserClickListener {
    private boolean mClicked;
    private final ViewGestureDetector mViewGestureDetector;

    /* renamed from: com.mopub.mobileads.BaseHtmlWebView.1 */
    class C25931 implements OnTouchListener {
        final /* synthetic */ boolean val$isScrollable;

        C25931(boolean z) {
            this.val$isScrollable = z;
        }

        public boolean onTouch(View v, MotionEvent event) {
            BaseHtmlWebView.this.mViewGestureDetector.sendTouchEvent(event);
            return event.getAction() == 2 && !this.val$isScrollable;
        }
    }

    public BaseHtmlWebView(Context context, AdConfiguration adConfiguration) {
        super(context);
        disableScrollingAndZoom();
        getSettings().setJavaScriptEnabled(true);
        this.mViewGestureDetector = new ViewGestureDetector(context, (View) this, adConfiguration);
        this.mViewGestureDetector.setUserClickListener(this);
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
            enablePlugins(true);
        }
        setBackgroundColor(0);
    }

    public void init(boolean isScrollable) {
        initializeOnTouchListener(isScrollable);
    }

    public void loadUrl(String url) {
        if (url != null) {
            Log.d("MoPub", "Loading url: " + url);
            if (url.startsWith("javascript:")) {
                super.loadUrl(url);
            }
        }
    }

    private void disableScrollingAndZoom() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
    }

    void loadHtmlResponse(String htmlResponse) {
        loadDataWithBaseURL("http://ads.mopub.com/", htmlResponse, "text/html", "utf-8", null);
    }

    void initializeOnTouchListener(boolean isScrollable) {
        setOnTouchListener(new C25931(isScrollable));
    }

    public void onUserClick() {
        this.mClicked = true;
    }

    public void onResetUserClick() {
        this.mClicked = false;
    }

    public boolean wasClicked() {
        return this.mClicked;
    }
}
