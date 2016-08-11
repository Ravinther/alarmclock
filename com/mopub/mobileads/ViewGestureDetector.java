package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.mobileads.util.Base64;

public class ViewGestureDetector extends GestureDetector {
    private AdAlertGestureListener mAdAlertGestureListener;
    private UserClickListener mUserClickListener;
    private final View mView;

    interface UserClickListener {
        void onResetUserClick();

        void onUserClick();

        boolean wasClicked();
    }

    public ViewGestureDetector(Context context, View view, AdConfiguration adConfiguration) {
        this(context, view, new AdAlertGestureListener(view, adConfiguration));
    }

    private ViewGestureDetector(Context context, View view, AdAlertGestureListener adAlertGestureListener) {
        super(context, adAlertGestureListener);
        this.mAdAlertGestureListener = adAlertGestureListener;
        this.mView = view;
        setIsLongpressEnabled(false);
    }

    void sendTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case Base64.DEFAULT /*0*/:
                onTouchEvent(motionEvent);
            case Base64.NO_PADDING /*1*/:
                if (this.mUserClickListener != null) {
                    this.mUserClickListener.onUserClick();
                } else {
                    Log.d("MoPub", "View's onUserClick() is not registered.");
                }
                this.mAdAlertGestureListener.finishGestureDetection();
            case Base64.NO_WRAP /*2*/:
                if (isMotionEventInView(motionEvent, this.mView)) {
                    onTouchEvent(motionEvent);
                } else {
                    resetAdFlaggingGesture();
                }
            default:
        }
    }

    void setUserClickListener(UserClickListener listener) {
        this.mUserClickListener = listener;
    }

    void resetAdFlaggingGesture() {
        this.mAdAlertGestureListener.reset();
    }

    private boolean isMotionEventInView(MotionEvent motionEvent, View view) {
        if (motionEvent == null || view == null) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (x < 0.0f || x > ((float) view.getWidth()) || y < 0.0f || y > ((float) view.getHeight())) {
            return false;
        }
        return true;
    }

    @Deprecated
    void setAdAlertGestureListener(AdAlertGestureListener adAlertGestureListener) {
        this.mAdAlertGestureListener = adAlertGestureListener;
    }
}
