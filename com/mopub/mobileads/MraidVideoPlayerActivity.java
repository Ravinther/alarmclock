package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.mopub.common.util.IntentUtils;

public class MraidVideoPlayerActivity extends BaseVideoPlayerActivity implements BaseVideoViewControllerListener {
    private BaseVideoViewController mBaseVideoController;
    private long mBroadcastIdentifier;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        AdConfiguration adConfiguration = getAdConfiguration();
        if (adConfiguration != null) {
            this.mBroadcastIdentifier = adConfiguration.getBroadcastIdentifier();
        } else {
            Log.d("MoPub", "Unable to obtain broadcast identifier. Video interactions cannot be tracked.");
        }
        try {
            this.mBaseVideoController = createVideoViewController();
            this.mBaseVideoController.onCreate();
        } catch (IllegalStateException e) {
            EventForwardingBroadcastReceiver.broadcastAction(this, this.mBroadcastIdentifier, "com.mopub.action.interstitial.fail");
            finish();
        }
    }

    protected void onPause() {
        this.mBaseVideoController.onPause();
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        this.mBaseVideoController.onResume();
    }

    protected void onDestroy() {
        this.mBaseVideoController.onDestroy();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.mBaseVideoController.backButtonEnabled()) {
            super.onBackPressed();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        this.mBaseVideoController.onActivityResult(requestCode, resultCode, data);
    }

    private AdConfiguration getAdConfiguration() {
        try {
            return (AdConfiguration) getIntent().getSerializableExtra(AdFetcher.AD_CONFIGURATION_KEY);
        } catch (ClassCastException e) {
            return null;
        }
    }

    private BaseVideoViewController createVideoViewController() {
        String clazz = getIntent().getStringExtra("video_view_class_name");
        if ("vast".equals(clazz)) {
            return new VastVideoViewController(this, getIntent().getExtras(), this.mBroadcastIdentifier, this);
        }
        if ("mraid".equals(clazz)) {
            return new MraidVideoViewController(this, getIntent().getExtras(), this.mBroadcastIdentifier, this);
        }
        throw new IllegalStateException("Unsupported video type: " + clazz);
    }

    public void onSetContentView(View view) {
        setContentView(view);
    }

    public void onSetRequestedOrientation(int requestedOrientation) {
        setRequestedOrientation(requestedOrientation);
    }

    public void onFinish() {
        finish();
    }

    public void onStartActivityForResult(Class clazz, int requestCode, Bundle extras) {
        if (clazz != null) {
            try {
                startActivityForResult(IntentUtils.getStartActivityIntent(this, clazz, extras), requestCode);
            } catch (ActivityNotFoundException e) {
                Log.d("MoPub", "Activity " + clazz.getName() + " not found. Did you declare it in your AndroidManifest.xml?");
            }
        }
    }

    @Deprecated
    BaseVideoViewController getBaseVideoViewController() {
        return this.mBaseVideoController;
    }

    @Deprecated
    void setBaseVideoViewController(BaseVideoViewController baseVideoViewController) {
        this.mBaseVideoController = baseVideoViewController;
    }
}
