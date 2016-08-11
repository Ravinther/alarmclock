package com.millennialmedia.android;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

class AdViewOverlayActivity extends MMBaseActivity {
    private AdViewOverlayView adViewOverlayView;
    boolean hasFocus;
    boolean isPaused;
    private OverlaySettings settings;

    AdViewOverlayActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        setTheme(16973840);
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().clearFlags(1024);
        getWindow().addFlags(2048);
        getWindow().addFlags(16777216);
        Intent intent = getIntent();
        this.settings = (OverlaySettings) intent.getParcelableExtra("settings");
        if (this.settings == null) {
            this.settings = new OverlaySettings();
        }
        this.settings.log();
        if (this.settings.orientation != null) {
            setRequestedOrientation(this.settings.orientation);
        }
        if (this.settings.allowOrientationChange) {
            unlockScreenOrientation();
        } else {
            lockOrientation();
        }
        if (!(intent == null || intent.getData() == null)) {
            Log.m9724v("Path: %s", intent.getData().getLastPathSegment());
        }
        RelativeLayout allowForCenteringModalsLayout = new RelativeLayout(this.activity);
        LayoutParams params = new LayoutParams(-2, -2);
        params.addRule(13);
        allowForCenteringModalsLayout.setId(885394873);
        allowForCenteringModalsLayout.setLayoutParams(params);
        this.adViewOverlayView = new AdViewOverlayView(this, this.settings);
        allowForCenteringModalsLayout.addView(this.adViewOverlayView);
        setContentView(allowForCenteringModalsLayout);
        if (getLastNonConfigurationInstance() == null) {
            if (this.settings.isExpanded()) {
                if (!(this.adViewOverlayView.adImpl == null || this.adViewOverlayView.adImpl.controller == null || this.adViewOverlayView.adImpl.controller.webView == null)) {
                    this.adViewOverlayView.adImpl.controller.webView.setMraidExpanded();
                }
                if (this.settings.hasExpandUrl()) {
                    this.adViewOverlayView.getWebContent(this.settings.urlToLoad);
                }
            } else if (!this.settings.isExpanded()) {
                this.adViewOverlayView.loadWebContent(this.settings.content, this.settings.adUrl);
            }
        }
        this.settings.orientation = null;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (this.adViewOverlayView != null) {
            this.adViewOverlayView.inlineConfigChange();
        }
        super.onConfigurationChanged(newConfig);
    }

    private void setRequestedOrientation(String orientation) {
        if ("landscape".equalsIgnoreCase(orientation)) {
            setRequestedOrientation(0);
        } else if ("portrait".equalsIgnoreCase(orientation)) {
            setRequestedOrientation(1);
        }
    }

    void unlockScreenOrientation() {
        setRequestedOrientation(-1);
    }

    void setAllowOrientationChange(boolean allowOrientationChange) {
        this.settings.allowOrientationChange = allowOrientationChange;
        if (allowOrientationChange) {
            unlockScreenOrientation();
        } else {
            lockOrientation();
        }
    }

    private void lockOrientation() {
        if (this.activity.getRequestedOrientation() == 0) {
            setRequestedOrientation(0);
        } else if (this.activity.getRequestedOrientation() == 8) {
            setRequestedOrientation(8);
        } else if (this.activity.getRequestedOrientation() == 9) {
            setRequestedOrientation(9);
        } else {
            setRequestedOrientation(1);
        }
    }

    void setRequestedOrientationPortrait() {
        this.settings.orientation = "portrait";
        this.settings.allowOrientationChange = false;
        setRequestedOrientation(1);
    }

    void setRequestedOrientationLandscape() {
        this.settings.orientation = "landscape";
        this.settings.allowOrientationChange = false;
        setRequestedOrientation(0);
    }

    public void finish() {
        if (this.adViewOverlayView != null) {
            if (!this.adViewOverlayView.attachWebViewToLink()) {
                this.adViewOverlayView.killWebView();
            }
            this.adViewOverlayView.removeSelfAndAll();
        }
        this.adViewOverlayView = null;
        super.finish();
    }

    protected void onResume() {
        this.isPaused = false;
        Log.m9711d("Overlay onResume");
        if (this.adViewOverlayView != null) {
            if (this.hasFocus) {
                this.adViewOverlayView.resumeVideo();
            }
            this.adViewOverlayView.addBlackView();
            if (!(this.adViewOverlayView.adImpl == null || this.adViewOverlayView.adImpl.controller == null || this.adViewOverlayView.adImpl.controller.webView == null)) {
                this.adViewOverlayView.adImpl.controller.webView.onResumeWebView();
            }
        }
        super.onResume();
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        this.hasFocus = hasWindowFocus;
        if (!this.isPaused && hasWindowFocus) {
            this.adViewOverlayView.resumeVideo();
        }
    }

    protected void onPause() {
        this.isPaused = true;
        Log.m9711d("Overlay onPause");
        Audio audio = Audio.sharedAudio(this.activity);
        if (audio != null) {
            synchronized (this) {
                audio.stop();
            }
        }
        Recorder.getInstance().stopRecording();
        if (this.adViewOverlayView != null) {
            this.adViewOverlayView.pauseVideo();
            if (!(this.adViewOverlayView.adImpl == null || this.adViewOverlayView.adImpl.controller == null || this.adViewOverlayView.adImpl.controller.webView == null)) {
                this.adViewOverlayView.adImpl.controller.webView.onPauseWebView();
            }
        }
        setResult(0);
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.m9711d("Overlay onDestroy");
    }

    protected void onStop() {
        super.onStop();
    }

    public Object onRetainNonConfigurationInstance() {
        return this.adViewOverlayView.getNonConfigurationInstance();
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("adViewId", this.adViewOverlayView.getId());
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || event.getRepeatCount() != 0) {
            return super.onKeyDown(keyCode, event);
        }
        this.adViewOverlayView.finishOverlayWithAnimation();
        return true;
    }
}
