package com.millennialmedia.android;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.VideoView;
import com.google.android.gms.wallet.WalletConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class VideoPlayerActivity extends MMBaseActivity implements OnCompletionListener, OnErrorListener, OnPreparedListener {
    private static final int CONTROLS_ID = 83756563;
    private static final String END_VIDEO = "endVideo";
    protected static final int MESSAGE_CHECK_PLAYING_VIDEO = 4;
    protected static final int MESSAGE_DELAYED_BUTTON = 3;
    protected static final int MESSAGE_INACTIVITY_ANIMATION = 1;
    protected static final int MESSAGE_ONE_SECOND_CHECK = 2;
    protected static final int MESSAGE_SET_TRANSPARENCY = 5;
    private static final String RESTART_VIDEO = "restartVideo";
    AdProperties adProperties;
    View blackView;
    protected int currentVideoPosition;
    protected boolean hasBottomBar;
    private boolean hasFocus;
    boolean isPaused;
    boolean isUserPausing;
    protected boolean isVideoCompleted;
    private boolean isVideoCompletedOnce;
    String lastOverlayOrientation;
    protected VideoView mVideoView;
    Button pausePlay;
    ProgressBar progBar;
    RedirectionListenerImpl redirectListenerImpl;
    private boolean shouldSetUri;
    TransparentHandler transparentHandler;
    RelativeLayout videoLayout;

    /* renamed from: com.millennialmedia.android.VideoPlayerActivity.1 */
    class C25181 implements Runnable {
        final /* synthetic */ String val$action;

        C25181(String str) {
            this.val$action = str;
        }

        public void run() {
            if (this.val$action.equalsIgnoreCase(VideoPlayerActivity.RESTART_VIDEO)) {
                VideoPlayerActivity.this.restartVideo();
            } else if (this.val$action.equalsIgnoreCase(VideoPlayerActivity.END_VIDEO)) {
                VideoPlayerActivity.this.endVideo();
            }
        }
    }

    /* renamed from: com.millennialmedia.android.VideoPlayerActivity.2 */
    class C25192 implements OnClickListener {
        C25192() {
        }

        public void onClick(View view) {
            if (VideoPlayerActivity.this.mVideoView != null) {
                VideoPlayerActivity.this.mVideoView.seekTo(0);
            }
        }
    }

    /* renamed from: com.millennialmedia.android.VideoPlayerActivity.3 */
    class C25203 implements OnClickListener {
        C25203() {
        }

        public void onClick(View view) {
            if (VideoPlayerActivity.this.mVideoView == null) {
                return;
            }
            if (VideoPlayerActivity.this.mVideoView.isPlaying()) {
                VideoPlayerActivity.this.pauseVideoByUser();
                VideoPlayerActivity.this.pausePlay.setBackgroundResource(17301540);
                return;
            }
            if (VideoPlayerActivity.this.isVideoCompleted) {
                VideoPlayerActivity.this.playVideo(0);
            } else if (!VideoPlayerActivity.this.isUserPausing || VideoPlayerActivity.this.isVideoCompleted) {
                VideoPlayerActivity.this.playVideo(VideoPlayerActivity.this.currentVideoPosition);
            } else {
                VideoPlayerActivity.this.resumeVideo();
            }
            VideoPlayerActivity.this.pausePlay.setBackgroundResource(17301539);
        }
    }

    /* renamed from: com.millennialmedia.android.VideoPlayerActivity.4 */
    class C25214 implements OnClickListener {
        C25214() {
        }

        public void onClick(View view) {
            if (VideoPlayerActivity.this.mVideoView != null) {
                VideoPlayerActivity.this.shouldSetUri = true;
                VideoPlayerActivity.this.dismiss();
            }
        }
    }

    private static class TransparentHandler extends Handler {
        private WeakReference activityRef;

        public TransparentHandler(VideoPlayerActivity activity) {
            this.activityRef = new WeakReference(activity);
        }

        public void handleMessage(Message msg) {
            VideoPlayerActivity activity = (VideoPlayerActivity) this.activityRef.get();
            if (activity != null) {
                activity.handleTransparentMessage(msg);
            }
        }
    }

    static class VideoRedirectionListener extends RedirectionListenerImpl {
        WeakReference activityRef;

        /* renamed from: com.millennialmedia.android.VideoPlayerActivity.VideoRedirectionListener.1 */
        class C25221 implements Runnable {
            final /* synthetic */ VideoPlayerActivity val$activity;

            C25221(VideoPlayerActivity videoPlayerActivity) {
                this.val$activity = videoPlayerActivity;
            }

            public void run() {
                this.val$activity.enableButtons();
            }
        }

        public VideoRedirectionListener(VideoPlayerActivity activity) {
            if (activity != null) {
                this.activityRef = new WeakReference(activity);
                if (activity.activity != null) {
                    this.creatorAdImplInternalId = activity.activity.creatorAdImplInternalId;
                }
            }
        }

        public boolean isHandlingMMVideo(Uri uri) {
            VideoPlayerActivity activity = (VideoPlayerActivity) this.activityRef.get();
            if (activity != null) {
                activity.runOnUiThread(new C25221(activity));
                if (uri != null && activity.isActionable(uri)) {
                    activity.processVideoPlayerUri(uri.getHost());
                    return true;
                }
            }
            return false;
        }

        public OverlaySettings getOverlaySettings() {
            VideoPlayerActivity activity = (VideoPlayerActivity) this.activityRef.get();
            if (activity == null || activity.lastOverlayOrientation == null) {
                return null;
            }
            OverlaySettings settings = new OverlaySettings();
            settings.orientation = activity.lastOverlayOrientation;
            return settings;
        }

        public JSONObject getAdProperties() {
            VideoPlayerActivity activity = (VideoPlayerActivity) this.activityRef.get();
            if (activity == null || activity.adProperties == null) {
                return null;
            }
            return activity.adProperties.getAdProperties();
        }
    }

    VideoPlayerActivity() {
        this.shouldSetUri = true;
        this.hasBottomBar = true;
        this.currentVideoPosition = 0;
        this.transparentHandler = new TransparentHandler(this);
        this.isUserPausing = false;
    }

    public void onCreate(Bundle savedInstanceState) {
        setTheme(16973829);
        super.onCreate(savedInstanceState);
        Log.m9711d("Setting up the video player");
        initWindow();
        initSavedInstance(savedInstanceState);
        initRedirectListener();
        setContentView(initLayout());
    }

    private void initWindow() {
        requestWindowFeature(MESSAGE_INACTIVITY_ANIMATION);
        getWindow().clearFlags(2048);
        getWindow().addFlags(1024);
    }

    protected void initSavedInstance(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.isVideoCompleted = savedInstanceState.getBoolean("videoCompleted");
            this.isVideoCompletedOnce = savedInstanceState.getBoolean("videoCompletedOnce");
            this.currentVideoPosition = savedInstanceState.getInt("videoPosition");
            this.hasBottomBar = savedInstanceState.getBoolean("hasBottomBar");
            this.shouldSetUri = savedInstanceState.getBoolean("shouldSetUri");
        }
    }

    private void initRedirectListener() {
        this.redirectListenerImpl = new VideoRedirectionListener(this);
    }

    protected void enableButtons() {
    }

    private boolean isActionable(Uri actionUri) {
        if (actionUri.getScheme().equalsIgnoreCase("mmsdk")) {
            if (isActionSupported(actionUri.getHost())) {
                return true;
            }
            Object[] objArr = new Object[MESSAGE_INACTIVITY_ANIMATION];
            objArr[0] = actionUri;
            Log.m9724v("Unrecognized mmsdk:// URI %s.", objArr);
        }
        return false;
    }

    private boolean isActionSupported(String action) {
        return action != null && (action.equalsIgnoreCase(RESTART_VIDEO) || action.equalsIgnoreCase(END_VIDEO));
    }

    void processVideoPlayerUri(String action) {
        runOnUiThread(new C25181(action));
    }

    protected void restartVideo() {
        Log.m9711d("Restart Video.");
        if (this.mVideoView != null) {
            playVideo(0);
        }
    }

    protected void endVideo() {
        Log.m9711d("End Video.");
        if (this.mVideoView != null) {
            this.shouldSetUri = true;
            dismiss();
        }
    }

    private void initBottomBar(RelativeLayout parent) {
        RelativeLayout controlsLayout = new RelativeLayout(this.activity);
        controlsLayout.setId(CONTROLS_ID);
        controlsLayout.setBackgroundColor(-16777216);
        LayoutParams controlsLp = new LayoutParams(-1, -2);
        controlsLayout.setLayoutParams(controlsLp);
        controlsLp.addRule(12);
        Button mRewind = new Button(this.activity);
        this.pausePlay = new Button(this.activity);
        Button mStop = new Button(this.activity);
        mRewind.setBackgroundResource(17301541);
        if (this.mVideoView.isPlaying()) {
            this.pausePlay.setBackgroundResource(17301539);
        } else {
            this.pausePlay.setBackgroundResource(17301540);
        }
        mStop.setBackgroundResource(17301560);
        LayoutParams pauseLp = new LayoutParams(-2, -2);
        LayoutParams stopLp = new LayoutParams(-2, -2);
        LayoutParams rewindLp = new LayoutParams(-2, -2);
        pauseLp.addRule(14);
        controlsLayout.addView(this.pausePlay, pauseLp);
        rewindLp.addRule(0, this.pausePlay.getId());
        controlsLayout.addView(mRewind);
        stopLp.addRule(11);
        controlsLayout.addView(mStop, stopLp);
        mRewind.setOnClickListener(new C25192());
        this.pausePlay.setOnClickListener(new C25203());
        mStop.setOnClickListener(new C25214());
        parent.addView(controlsLayout, controlsLp);
    }

    protected RelativeLayout initLayout() {
        RelativeLayout parent = new RelativeLayout(this.activity);
        parent.setId(400);
        parent.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        parent.setBackgroundColor(-16777216);
        this.videoLayout = new RelativeLayout(this.activity);
        this.videoLayout.setBackgroundColor(-16777216);
        this.videoLayout.setId(WalletConstants.ERROR_CODE_INVALID_TRANSACTION);
        LayoutParams videoContainerLp = new LayoutParams(-1, -2);
        LayoutParams videoLp = new LayoutParams(-1, -1);
        videoLp.addRule(13);
        videoContainerLp.addRule(13);
        this.mVideoView = new VideoView(this.activity);
        this.mVideoView.setId(WalletConstants.ERROR_CODE_AUTHENTICATION_FAILURE);
        this.mVideoView.getHolder().setFormat(-2);
        this.mVideoView.setBackgroundColor(-16777216);
        initVideoListeners();
        this.videoLayout.addView(this.mVideoView, videoLp);
        this.blackView = new View(this.activity);
        this.blackView.setBackgroundColor(-16777216);
        LayoutParams blackViewParams = new LayoutParams(-1, -1);
        parent.addView(this.videoLayout, videoContainerLp);
        if (this.hasBottomBar) {
            blackViewParams.addRule(MESSAGE_ONE_SECOND_CHECK, CONTROLS_ID);
            initBottomBar(parent);
        }
        this.blackView.setLayoutParams(blackViewParams);
        parent.addView(this.blackView);
        this.progBar = new ProgressBar(this.activity);
        this.progBar.setIndeterminate(true);
        LayoutParams progParams = new LayoutParams(-2, -2);
        progParams.addRule(13);
        this.progBar.setLayoutParams(progParams);
        parent.addView(this.progBar);
        this.progBar.setVisibility(MESSAGE_CHECK_PLAYING_VIDEO);
        return parent;
    }

    protected boolean canFadeButtons() {
        return !this.isVideoCompleted;
    }

    protected void setButtonAlpha(ImageButton button, float alpha) {
        AlphaAnimation animation = new AlphaAnimation(alpha, alpha);
        animation.setDuration(0);
        animation.setFillEnabled(true);
        animation.setFillBefore(true);
        animation.setFillAfter(true);
        button.startAnimation(animation);
    }

    protected void logButtonEvent(VideoImage button) {
        Log.m9711d("Cached video button event logged");
        for (int i = 0; i < button.eventLoggingUrls.length; i += MESSAGE_INACTIVITY_ANIMATION) {
            Event.logEvent(button.eventLoggingUrls[i]);
        }
    }

    protected void playVideo(int position) {
        Object[] objArr;
        try {
            this.isUserPausing = false;
            String fullPath = getIntent().getData().toString();
            objArr = new Object[MESSAGE_INACTIVITY_ANIMATION];
            objArr[0] = fullPath;
            Log.m9712d("playVideo path: %s", objArr);
            if (fullPath == null || fullPath.length() == 0 || this.mVideoView == null) {
                errorPlayVideo("no name or null videoview");
                return;
            }
            this.isVideoCompleted = false;
            if (this.shouldSetUri && this.mVideoView != null) {
                this.mVideoView.setVideoURI(Uri.parse(fullPath));
            }
            startVideo(position);
        } catch (Exception e) {
            String str = "error: " + e.getMessage();
            objArr = new Object[MESSAGE_INACTIVITY_ANIMATION];
            objArr[0] = e;
            Log.m9715e(str, objArr);
            errorPlayVideo("error: " + e.getMessage());
        }
    }

    protected void errorPlayVideo(String error) {
        Toast.makeText(this.activity, "Sorry. There was a problem playing the video", MESSAGE_INACTIVITY_ANIMATION).show();
        if (this.mVideoView != null) {
            this.mVideoView.stopPlayback();
        }
    }

    private void startVideo(int position) {
        this.mVideoView.requestFocus();
        this.mVideoView.seekTo(position);
        if (((PowerManager) getSystemService("power")).isScreenOn()) {
            if (this.progBar != null) {
                this.progBar.bringToFront();
                this.progBar.setVisibility(0);
            }
            if (this.pausePlay != null) {
                this.pausePlay.setBackgroundResource(17301539);
            }
            this.mVideoView.start();
            makeTransparent();
        }
    }

    void handleTransparentMessage(Message msg) {
        switch (msg.what) {
            case MESSAGE_CHECK_PLAYING_VIDEO /*4*/:
                if (this.mVideoView == null || !this.mVideoView.isPlaying() || this.mVideoView.getCurrentPosition() <= 0) {
                    this.transparentHandler.sendEmptyMessageDelayed(MESSAGE_CHECK_PLAYING_VIDEO, 50);
                    return;
                }
                this.mVideoView.setBackgroundColor(0);
                this.transparentHandler.sendEmptyMessageDelayed(MESSAGE_SET_TRANSPARENCY, 100);
            case MESSAGE_SET_TRANSPARENCY /*5*/:
                if (this.mVideoView != null && this.mVideoView.isPlaying() && this.mVideoView.getCurrentPosition() > 0) {
                    this.blackView.setVisibility(MESSAGE_CHECK_PLAYING_VIDEO);
                    this.progBar.setVisibility(MESSAGE_CHECK_PLAYING_VIDEO);
                }
            default:
        }
    }

    private void makeTransparent() {
        if (!this.transparentHandler.hasMessages(MESSAGE_CHECK_PLAYING_VIDEO)) {
            this.transparentHandler.sendEmptyMessage(MESSAGE_CHECK_PLAYING_VIDEO);
        }
    }

    private void initVideoListeners() {
        this.mVideoView.setOnCompletionListener(this);
        this.mVideoView.setOnPreparedListener(this);
        this.mVideoView.setOnErrorListener(this);
    }

    public void onCompletion(MediaPlayer mp) {
        this.isVideoCompletedOnce = true;
        this.isVideoCompleted = true;
        if (!(this.pausePlay == null || this.mVideoView.isPlaying())) {
            this.pausePlay.setBackgroundResource(17301540);
        }
        Log.m9723v("Video player on complete");
    }

    public void onPrepared(MediaPlayer mp) {
        Log.m9711d("Video Prepared");
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    protected void onResume() {
        super.onResume();
        this.blackView.bringToFront();
        this.blackView.setVisibility(0);
        this.isPaused = false;
        Log.m9723v("VideoPlayer - onResume");
        if (this.hasFocus && !this.isUserPausing) {
            resumeVideo();
        }
    }

    protected void onPause() {
        super.onPause();
        this.isPaused = true;
        Log.m9723v("VideoPlayer - onPause");
        pauseVideo();
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        this.hasFocus = hasWindowFocus;
        if (!this.isPaused && hasWindowFocus && !this.isUserPausing) {
            resumeVideo();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == MESSAGE_CHECK_PLAYING_VIDEO && event.getRepeatCount() == 0 && !this.isVideoCompletedOnce) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void dismiss() {
        Log.m9711d("Video ad player closed");
        if (this.mVideoView != null) {
            if (this.mVideoView.isPlaying()) {
                this.mVideoView.stopPlayback();
            }
            this.mVideoView = null;
        }
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentVideoPosition", this.currentVideoPosition);
        outState.putBoolean("isVideoCompleted", this.isVideoCompleted);
        outState.putBoolean("isVideoCompletedOnce", this.isVideoCompletedOnce);
        outState.putBoolean("hasBottomBar", this.hasBottomBar);
        outState.putBoolean("shouldSetUri", this.shouldSetUri);
        outState.putBoolean("isUserPausing", this.isUserPausing);
        outState.putBoolean("isPaused", this.isPaused);
        super.onSaveInstanceState(outState);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        this.currentVideoPosition = savedInstanceState.getInt("currentVideoPosition");
        this.isVideoCompleted = savedInstanceState.getBoolean("isVideoCompleted");
        this.isVideoCompletedOnce = savedInstanceState.getBoolean("isVideoCompletedOnce");
        this.hasBottomBar = savedInstanceState.getBoolean("hasBottomBar", this.hasBottomBar);
        this.shouldSetUri = savedInstanceState.getBoolean("shouldSetUri", this.shouldSetUri);
        this.isUserPausing = savedInstanceState.getBoolean("isUserPausing", this.isUserPausing);
        this.isPaused = savedInstanceState.getBoolean("isPaused", this.isPaused);
        super.onRestoreInstanceState(savedInstanceState);
    }

    protected void pauseVideoByUser() {
        this.isUserPausing = true;
        pauseVideo();
    }

    protected void pauseVideo() {
        if (this.mVideoView != null && this.mVideoView.isPlaying()) {
            this.currentVideoPosition = this.mVideoView.getCurrentPosition();
            this.mVideoView.pause();
            Log.m9723v("Video paused");
        }
    }

    protected boolean isPlayable() {
        return (this.mVideoView == null || this.mVideoView.isPlaying() || this.isVideoCompleted) ? false : true;
    }

    protected void resumeVideo() {
        if (isPlayable()) {
            playVideo(this.currentVideoPosition);
        }
    }

    void dispatchButtonClick(String urlString) {
        if (urlString != null) {
            Object[] objArr = new Object[MESSAGE_INACTIVITY_ANIMATION];
            objArr[0] = urlString;
            Log.m9712d("Button Click with URL: %s", objArr);
            this.redirectListenerImpl.url = urlString;
            this.redirectListenerImpl.weakContext = new WeakReference(this.activity);
            if (!this.redirectListenerImpl.isHandlingMMVideo(Uri.parse(urlString))) {
                HttpRedirection.startActivityFromUri(this.redirectListenerImpl);
            }
        }
    }
}
