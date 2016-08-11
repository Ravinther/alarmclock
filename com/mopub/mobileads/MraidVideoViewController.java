package com.mopub.mobileads;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;

public class MraidVideoViewController extends BaseVideoViewController {
    private static final float CLOSE_BUTTON_PADDING = 8.0f;
    private static final float CLOSE_BUTTON_SIZE = 50.0f;
    private int mButtonPadding;
    private int mButtonSize;
    private ImageButton mCloseButton;
    private final VideoView mVideoView;

    /* renamed from: com.mopub.mobileads.MraidVideoViewController.1 */
    class C26211 implements OnCompletionListener {
        C26211() {
        }

        public void onCompletion(MediaPlayer mp) {
            MraidVideoViewController.this.mCloseButton.setVisibility(0);
            MraidVideoViewController.this.videoCompleted(true);
        }
    }

    /* renamed from: com.mopub.mobileads.MraidVideoViewController.2 */
    class C26222 implements OnErrorListener {
        C26222() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
            MraidVideoViewController.this.mCloseButton.setVisibility(0);
            MraidVideoViewController.this.videoError(false);
            return false;
        }
    }

    /* renamed from: com.mopub.mobileads.MraidVideoViewController.3 */
    class C26233 implements OnClickListener {
        C26233() {
        }

        public void onClick(View v) {
            MraidVideoViewController.this.getBaseVideoViewControllerListener().onFinish();
        }
    }

    MraidVideoViewController(Context context, Bundle bundle, long broadcastIdentifier, BaseVideoViewControllerListener baseVideoViewControllerListener) {
        super(context, broadcastIdentifier, baseVideoViewControllerListener);
        this.mVideoView = new VideoView(context);
        this.mVideoView.setOnCompletionListener(new C26211());
        this.mVideoView.setOnErrorListener(new C26222());
        this.mVideoView.setVideoPath(bundle.getString("video_url"));
    }

    void onCreate() {
        super.onCreate();
        this.mButtonSize = Dips.asIntPixels(CLOSE_BUTTON_SIZE, getContext());
        this.mButtonPadding = Dips.asIntPixels(CLOSE_BUTTON_PADDING, getContext());
        createInterstitialCloseButton();
        this.mCloseButton.setVisibility(8);
        this.mVideoView.start();
    }

    VideoView getVideoView() {
        return this.mVideoView;
    }

    void onDestroy() {
    }

    void onPause() {
    }

    void onResume() {
    }

    private void createInterstitialCloseButton() {
        this.mCloseButton = new ImageButton(getContext());
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{-16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(getContext()));
        states.addState(new int[]{16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(getContext()));
        this.mCloseButton.setImageDrawable(states);
        this.mCloseButton.setBackgroundDrawable(null);
        this.mCloseButton.setOnClickListener(new C26233());
        LayoutParams buttonLayout = new LayoutParams(this.mButtonSize, this.mButtonSize);
        buttonLayout.addRule(11);
        buttonLayout.setMargins(this.mButtonPadding, 0, this.mButtonPadding, 0);
        getLayout().addView(this.mCloseButton, buttonLayout);
    }
}
