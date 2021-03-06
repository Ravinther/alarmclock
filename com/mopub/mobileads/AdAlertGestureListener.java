package com.mopub.mobileads;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.mopub.mobileads.util.Base64;

public class AdAlertGestureListener extends SimpleOnGestureListener {
    private static final float MAXIMUM_THRESHOLD_X_IN_DIPS = 100.0f;
    private static final float MAXIMUM_THRESHOLD_Y_IN_DIPS = 50.0f;
    private static final int MINIMUM_NUMBER_OF_ZIGZAGS_TO_FLAG = 4;
    private AdAlertReporter mAdAlertReporter;
    private AdConfiguration mAdConfiguration;
    private float mCurrentThresholdInDips;
    private ZigZagState mCurrentZigZagState;
    private boolean mHasCrossedLeftThreshold;
    private boolean mHasCrossedRightThreshold;
    private int mNumberOfZigZags;
    private float mPivotPositionX;
    private float mPreviousPositionX;
    private View mView;

    /* renamed from: com.mopub.mobileads.AdAlertGestureListener.1 */
    static /* synthetic */ class C25871 {
        static final /* synthetic */ int[] f4305xc1b07c2b;

        static {
            f4305xc1b07c2b = new int[ZigZagState.values().length];
            try {
                f4305xc1b07c2b[ZigZagState.UNSET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4305xc1b07c2b[ZigZagState.GOING_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4305xc1b07c2b[ZigZagState.GOING_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4305xc1b07c2b[ZigZagState.FAILED.ordinal()] = AdAlertGestureListener.MINIMUM_NUMBER_OF_ZIGZAGS_TO_FLAG;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    enum ZigZagState {
        UNSET,
        GOING_RIGHT,
        GOING_LEFT,
        FINISHED,
        FAILED
    }

    AdAlertGestureListener(View view, AdConfiguration adConfiguration) {
        this.mCurrentThresholdInDips = MAXIMUM_THRESHOLD_X_IN_DIPS;
        this.mCurrentZigZagState = ZigZagState.UNSET;
        if (view != null && view.getWidth() > 0) {
            this.mCurrentThresholdInDips = Math.min(MAXIMUM_THRESHOLD_X_IN_DIPS, ((float) view.getWidth()) / 3.0f);
        }
        this.mView = view;
        this.mAdConfiguration = adConfiguration;
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (this.mCurrentZigZagState == ZigZagState.FINISHED) {
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        if (isTouchOutOfBoundsOnYAxis(e1.getY(), e2.getY())) {
            this.mCurrentZigZagState = ZigZagState.FAILED;
            return super.onScroll(e1, e2, distanceX, distanceY);
        }
        switch (C25871.f4305xc1b07c2b[this.mCurrentZigZagState.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                this.mPivotPositionX = e1.getX();
                updateInitialState(e2.getX());
                break;
            case Base64.NO_WRAP /*2*/:
                updateZig(e2.getX());
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                updateZag(e2.getX());
                break;
        }
        this.mPreviousPositionX = e2.getX();
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    void finishGestureDetection() {
        ZigZagState zigZagState = this.mCurrentZigZagState;
        ZigZagState zigZagState2 = this.mCurrentZigZagState;
        if (zigZagState == ZigZagState.FINISHED) {
            this.mAdAlertReporter = new AdAlertReporter(this.mView.getContext(), this.mView, this.mAdConfiguration);
            this.mAdAlertReporter.send();
        }
        reset();
    }

    void reset() {
        this.mNumberOfZigZags = 0;
        this.mCurrentZigZagState = ZigZagState.UNSET;
    }

    private boolean isTouchOutOfBoundsOnYAxis(float initialY, float currentY) {
        return Math.abs(currentY - initialY) > MAXIMUM_THRESHOLD_Y_IN_DIPS;
    }

    private void updateInitialState(float currentPositionX) {
        if (currentPositionX > this.mPivotPositionX) {
            this.mCurrentZigZagState = ZigZagState.GOING_RIGHT;
        }
    }

    private void updateZig(float currentPositionX) {
        if (rightThresholdReached(currentPositionX) && isMovingLeft(currentPositionX)) {
            this.mCurrentZigZagState = ZigZagState.GOING_LEFT;
            this.mPivotPositionX = currentPositionX;
        }
    }

    private void updateZag(float currentPositionX) {
        if (leftThresholdReached(currentPositionX) && isMovingRight(currentPositionX)) {
            this.mCurrentZigZagState = ZigZagState.GOING_RIGHT;
            this.mPivotPositionX = currentPositionX;
        }
    }

    private void incrementNumberOfZigZags() {
        this.mNumberOfZigZags++;
        if (this.mNumberOfZigZags >= MINIMUM_NUMBER_OF_ZIGZAGS_TO_FLAG) {
            this.mCurrentZigZagState = ZigZagState.FINISHED;
        }
    }

    private boolean rightThresholdReached(float currentPosition) {
        if (this.mHasCrossedRightThreshold) {
            return true;
        }
        if (currentPosition < this.mPivotPositionX + this.mCurrentThresholdInDips) {
            return false;
        }
        this.mHasCrossedLeftThreshold = false;
        this.mHasCrossedRightThreshold = true;
        return true;
    }

    private boolean leftThresholdReached(float currentPosition) {
        if (this.mHasCrossedLeftThreshold) {
            return true;
        }
        if (currentPosition > this.mPivotPositionX - this.mCurrentThresholdInDips) {
            return false;
        }
        this.mHasCrossedRightThreshold = false;
        this.mHasCrossedLeftThreshold = true;
        incrementNumberOfZigZags();
        return true;
    }

    private boolean isMovingRight(float currentPositionX) {
        return currentPositionX > this.mPreviousPositionX;
    }

    private boolean isMovingLeft(float currentPositionX) {
        return currentPositionX < this.mPreviousPositionX;
    }

    @Deprecated
    int getNumberOfZigzags() {
        return this.mNumberOfZigZags;
    }

    @Deprecated
    float getMinimumDipsInZigZag() {
        return this.mCurrentThresholdInDips;
    }

    @Deprecated
    ZigZagState getCurrentZigZagState() {
        return this.mCurrentZigZagState;
    }

    @Deprecated
    AdAlertReporter getAdAlertReporter() {
        return this.mAdAlertReporter;
    }
}
