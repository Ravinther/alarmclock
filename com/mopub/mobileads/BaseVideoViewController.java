package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;

abstract class BaseVideoViewController {
    private final BaseVideoViewControllerListener mBaseVideoViewControllerListener;
    private long mBroadcastIdentifier;
    private final Context mContext;
    private final RelativeLayout mLayout;

    interface BaseVideoViewControllerListener {
        void onFinish();

        void onSetContentView(View view);

        void onSetRequestedOrientation(int i);

        void onStartActivityForResult(Class cls, int i, Bundle bundle);
    }

    abstract VideoView getVideoView();

    abstract void onDestroy();

    abstract void onPause();

    abstract void onResume();

    BaseVideoViewController(Context context, long broadcastIdentifier, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        this.mContext = context.getApplicationContext();
        this.mBroadcastIdentifier = broadcastIdentifier;
        this.mBaseVideoViewControllerListener = baseVideoViewControllerListener;
        this.mLayout = new RelativeLayout(this.mContext);
    }

    void onCreate() {
        LayoutParams adViewLayout = new LayoutParams(-1, -2);
        adViewLayout.addRule(13);
        this.mLayout.addView(getVideoView(), 0, adViewLayout);
        this.mBaseVideoViewControllerListener.onSetContentView(this.mLayout);
    }

    boolean backButtonEnabled() {
        return true;
    }

    void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    BaseVideoViewControllerListener getBaseVideoViewControllerListener() {
        return this.mBaseVideoViewControllerListener;
    }

    Context getContext() {
        return this.mContext;
    }

    ViewGroup getLayout() {
        return this.mLayout;
    }

    void videoError(boolean shouldFinish) {
        Log.d("MoPub", "Error: video can not be played.");
        broadcastAction("com.mopub.action.interstitial.fail");
        if (shouldFinish) {
            this.mBaseVideoViewControllerListener.onFinish();
        }
    }

    void videoCompleted(boolean shouldFinish) {
        if (shouldFinish) {
            this.mBaseVideoViewControllerListener.onFinish();
        }
    }

    void videoClicked() {
        broadcastAction("com.mopub.action.interstitial.click");
    }

    void broadcastAction(String action) {
        EventForwardingBroadcastReceiver.broadcastAction(this.mContext, this.mBroadcastIdentifier, action);
    }
}
