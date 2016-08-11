package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.CountdownDrawable;
import com.mopub.mobileads.resource.LearnMoreDrawable;

class VastVideoToolbar extends LinearLayout {
    private static final int THRESHOLD_FOR_HIDING_VIDEO_DURATION = 200;
    private static final int TOOLBAR_HEIGHT_DIPS = 44;
    private final ToolbarWidget mCloseButtonWidget;
    private final ToolbarWidget mCountdownWidget;
    private final ToolbarWidget mDurationWidget;
    private final ToolbarWidget mLearnMoreWidget;

    /* renamed from: com.mopub.mobileads.VastVideoToolbar.1 */
    class C26271 implements OnTouchListener {
        C26271() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public VastVideoToolbar(Context context) {
        super(context);
        setId((int) Utils.generateUniqueId());
        setOnTouchListener(new C26271());
        setLayoutParams(new LayoutParams(-1, Dips.dipsToIntPixels(44.0f, getContext())));
        setBackgroundColor(-16777216);
        getBackground().setAlpha(180);
        this.mDurationWidget = createDurationWidget();
        this.mLearnMoreWidget = createLearnMoreWidget();
        this.mCountdownWidget = createCountdownWidget();
        this.mCloseButtonWidget = createCloseButtonWidget();
        addView(this.mDurationWidget);
        addView(this.mLearnMoreWidget);
        addView(this.mCountdownWidget);
        addView(this.mCloseButtonWidget);
    }

    String getDisplaySeconds(long millisecondsRemaining) {
        return String.valueOf(Math.round(Math.ceil((double) (((float) millisecondsRemaining) / 1000.0f))));
    }

    void updateDurationWidget(int remainingTime) {
        if (remainingTime >= THRESHOLD_FOR_HIDING_VIDEO_DURATION) {
            this.mDurationWidget.updateText("Ends in " + getDisplaySeconds((long) remainingTime) + " seconds");
        } else if (remainingTime >= 0) {
            this.mDurationWidget.updateText("Thanks for watching");
        }
    }

    void updateCountdownWidget(int remainingTime) {
        if (remainingTime >= 0 && this.mCountdownWidget.getVisibility() == 4) {
            this.mCloseButtonWidget.setVisibility(8);
            this.mCountdownWidget.setVisibility(0);
        }
        this.mCountdownWidget.updateImageText(getDisplaySeconds((long) remainingTime));
    }

    void makeInteractable() {
        this.mCountdownWidget.setVisibility(8);
        this.mLearnMoreWidget.setVisibility(0);
        this.mCloseButtonWidget.setVisibility(0);
    }

    void setCloseButtonOnTouchListener(OnTouchListener onTouchListener) {
        this.mCloseButtonWidget.setOnTouchListener(onTouchListener);
    }

    void setLearnMoreButtonOnTouchListener(OnTouchListener onTouchListener) {
        this.mLearnMoreWidget.setOnTouchListener(onTouchListener);
    }

    private ToolbarWidget createDurationWidget() {
        return new Builder(getContext()).weight(2.0f).widgetGravity(19).hasText().textAlign(9).build();
    }

    private ToolbarWidget createLearnMoreWidget() {
        return new Builder(getContext()).weight(1.0f).widgetGravity(21).defaultText("Learn More").drawable(new LearnMoreDrawable()).visibility(4).build();
    }

    private ToolbarWidget createCountdownWidget() {
        return new Builder(getContext()).weight(1.0f).widgetGravity(21).defaultText("Skip in").drawable(new CountdownDrawable(getContext())).visibility(4).build();
    }

    private ToolbarWidget createCloseButtonWidget() {
        return new Builder(getContext()).weight(1.0f).widgetGravity(21).defaultText("Close").drawable(new CloseButtonDrawable()).visibility(8).build();
    }

    @Deprecated
    ToolbarWidget getDurationWidget() {
        return this.mDurationWidget;
    }

    @Deprecated
    ToolbarWidget getLearnMoreWidget() {
        return this.mLearnMoreWidget;
    }

    @Deprecated
    ToolbarWidget getCountdownWidget() {
        return this.mCountdownWidget;
    }

    @Deprecated
    ToolbarWidget getCloseButtonWidget() {
        return this.mCloseButtonWidget;
    }
}
