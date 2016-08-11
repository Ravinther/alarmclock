package com.millennialmedia.android;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.plus.PlusShare;
import com.millennialmedia.android.NVASpeechKit.CustomWordsOp;
import java.util.HashMap;

public class BridgeMMSpeechkit extends MMJSObject implements OnCompletionListener, PeriodicListener {

    private static class SingletonHolder {
        public static final SpeechKitHolder INSTANCE;

        private SingletonHolder() {
        }

        static {
            INSTANCE = new SpeechKitHolder();
        }
    }

    private static class SpeechKitHolder {
        private NVASpeechKit _speechKit;

        /* renamed from: com.millennialmedia.android.BridgeMMSpeechkit.SpeechKitHolder.1 */
        class C24641 implements Runnable {
            C24641() {
            }

            public void run() {
                synchronized (SpeechKitHolder.this) {
                    if (SpeechKitHolder.this._speechKit != null) {
                        SpeechKitHolder.this._speechKit.cancelRecording();
                        SpeechKitHolder.this._speechKit.release();
                        SpeechKitHolder.this._speechKit = null;
                    }
                }
            }
        }

        private SpeechKitHolder() {
        }

        public boolean release() {
            if (this._speechKit == null) {
                return false;
            }
            ThreadUtils.execute(new C24641());
            return true;
        }

        public NVASpeechKit getSpeechKit() {
            return this._speechKit;
        }

        public void setSpeechKit(NVASpeechKit speechKit) {
            this._speechKit = speechKit;
        }
    }

    BridgeMMSpeechkit() {
    }

    private NVASpeechKit getCreateSpeechKit() {
        NVASpeechKit speechKit = null;
        MMWebView webView = (MMWebView) this.mmWebViewRef.get();
        if (webView != null && webView.allowSpeechCreationCommands()) {
            if (getSpeechKitInternal() != null) {
                return getSpeechKitInternal();
            }
            Context context = webView.getContext();
            if (context != null) {
                speechKit = new NVASpeechKit(webView);
                setSpeechKit(speechKit);
                NuanceCredentials credentials = HandShake.sharedHandShake(context).nuanceCredentials;
                if (credentials != null) {
                    speechKit.initialize(credentials, context.getApplicationContext());
                }
            }
        }
        return speechKit;
    }

    private NVASpeechKit getSpeechKit() {
        MMWebView webView = (MMWebView) this.mmWebViewRef.get();
        if (webView == null || !webView.allowRecordingCommands()) {
            return null;
        }
        return getSpeechKitInternal();
    }

    private NVASpeechKit getSpeechKitRelease() {
        return getSpeechKitInternal();
    }

    public MMJSResponse startRecording(HashMap arguments) {
        NVASpeechKit speechKit = getCreateSpeechKit();
        if (speechKit == null) {
            return MMJSResponse.responseWithError("Unable to create speech kit");
        }
        String language = (String) arguments.get("language");
        if (TextUtils.isEmpty(language)) {
            language = "en_GB";
        }
        if (speechKit.startRecording(language)) {
            return MMJSResponse.responseWithSuccess();
        }
        return MMJSResponse.responseWithError("Failed in speechKit");
    }

    public MMJSResponse endRecording(HashMap arguments) {
        NVASpeechKit speechKit = getSpeechKit();
        if (speechKit == null) {
            return MMJSResponse.responseWithError("Unable to get speech kit");
        }
        synchronized (speechKit) {
            if (speechKit.endRecording()) {
                MMJSResponse responseWithSuccess = MMJSResponse.responseWithSuccess();
                return responseWithSuccess;
            }
            return MMJSResponse.responseWithError("Failed in speechKit");
        }
    }

    public MMJSResponse cacheAudio(HashMap arguments) {
        String url = (String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (!URLUtil.isValidUrl(url)) {
            return MMJSResponse.responseWithError("Invalid url");
        }
        if (this.contextRef != null) {
            Context context = (Context) this.contextRef.get();
            if (context != null && AdCache.downloadComponentToCache(url, url.substring(url.lastIndexOf("/") + 1), context)) {
                injectJavascript("javascript:MMJS.sdk.audioCached()");
                return MMJSResponse.responseWithSuccess("Successfully cached audio at " + url);
            }
        }
        return MMJSResponse.responseWithError("Failed to cache audio at" + url);
    }

    public MMJSResponse getSessionId(HashMap arguments) {
        NVASpeechKit speechKit = getSpeechKit();
        if (speechKit == null) {
            return MMJSResponse.responseWithError("No SpeechKit session open.");
        }
        String sessionId = speechKit.getSessionId();
        if (TextUtils.isEmpty(sessionId)) {
            return MMJSResponse.responseWithError("No SpeechKit session open.");
        }
        return MMJSResponse.responseWithSuccess(sessionId);
    }

    public MMJSResponse playAudio(HashMap arguments) {
        if (getCreateSpeechKit() == null) {
            return MMJSResponse.responseWithError("Unable to create speech kit");
        }
        if (!URLUtil.isValidUrl((String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL))) {
            return MMJSResponse.responseWithError("Invalid url");
        }
        BridgeMMMedia media = new BridgeMMMedia();
        if (this.contextRef != null) {
            media.setContext((Context) this.contextRef.get());
            String path = (String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL);
            if (!TextUtils.isEmpty(path)) {
                Context context = (Context) this.contextRef.get();
                if (context != null) {
                    Audio audio = Audio.sharedAudio(context);
                    if (audio != null) {
                        audio.addCompletionListener(this);
                        audio.addPeriodicListener(this);
                    }
                    arguments.put("path", path);
                    MMJSResponse response = media.playAudio(arguments);
                    if (response == null || response.result != 1) {
                        return response;
                    }
                    injectJavascript("javascript:MMJS.sdk.audioStarted()");
                    return response;
                }
            }
        }
        return null;
    }

    public void onCompletion(MediaPlayer mp) {
        injectJavascript("javascript:MMJS.sdk.audioCompleted()");
        Context context = (Context) this.contextRef.get();
        if (context != null) {
            Audio audio = Audio.sharedAudio(context);
            if (audio != null) {
                audio.removeCompletionListener(this);
                audio.removePeriodicListener(this);
            }
        }
    }

    public void onUpdate(int currentPositionMillis) {
        injectJavascript("javascript:MMJS.sdk.audioPositionChange(" + currentPositionMillis + ")");
    }

    void injectJavascript(String javascript) {
        MMWebView webView = (MMWebView) this.mmWebViewRef.get();
        if (webView != null) {
            webView.loadUrl(javascript);
        }
    }

    public MMJSResponse textToSpeech(HashMap arguments) {
        Log.m9711d("@@-Calling textToSpeech");
        NVASpeechKit speechKit = getCreateSpeechKit();
        if (speechKit == null) {
            return MMJSResponse.responseWithError("Unable to create speech kit");
        }
        String language = (String) arguments.get("language");
        String text = (String) arguments.get("text");
        if (TextUtils.isEmpty(language)) {
            language = "en_GB";
        }
        speechKit.stopActions();
        if (speechKit.textToSpeech(text, language)) {
            return MMJSResponse.responseWithSuccess();
        }
        return MMJSResponse.responseWithError("Failed in speechKit");
    }

    public MMJSResponse stopAudio(HashMap arguments) {
        NVASpeechKit speechKit = getSpeechKit();
        if (speechKit == null) {
            return MMJSResponse.responseWithError("Unable to get speech kit");
        }
        speechKit.stopActions();
        BridgeMMMedia media = new BridgeMMMedia();
        if (this.contextRef == null) {
            return MMJSResponse.responseWithSuccess();
        }
        media.setContext((Context) this.contextRef.get());
        return media.stopAudio(arguments);
    }

    public MMJSResponse sampleBackgroundAudioLevel(HashMap arguments) {
        NVASpeechKit speechKit = getCreateSpeechKit();
        if (speechKit == null) {
            return MMJSResponse.responseWithError("Unable to create speech kit");
        }
        speechKit.startSampleRecording();
        return null;
    }

    public MMJSResponse releaseVoice(HashMap arguments) {
        if (releaseSpeechKit()) {
            return MMJSResponse.responseWithError("Unable to get speech kit");
        }
        return MMJSResponse.responseWithSuccess("released speechkit");
    }

    static boolean releaseSpeechKit() {
        return getInstance().release();
    }

    public MMJSResponse addCustomVoiceWords(HashMap arguments) {
        NVASpeechKit speechKit = getCreateSpeechKit();
        if (speechKit == null) {
            return MMJSResponse.responseWithError("Unable to create speech kit");
        }
        String words = (String) arguments.get("words");
        if (TextUtils.isEmpty(words)) {
            return null;
        }
        speechKit.updateCustomWords(CustomWordsOp.Add, words.split(","));
        injectJavascript("javascript:MMJS.sdk.customVoiceWordsAdded()");
        return MMJSResponse.responseWithSuccess("Added " + words);
    }

    public MMJSResponse deleteCustomVoiceWords(HashMap arguments) {
        NVASpeechKit speechKit = getCreateSpeechKit();
        if (speechKit == null) {
            return MMJSResponse.responseWithError("Unable to create speech kit");
        }
        String words = (String) arguments.get("words");
        if (TextUtils.isEmpty(words)) {
            return null;
        }
        speechKit.updateCustomWords(CustomWordsOp.Remove, words.split(","));
        injectJavascript("javascript:MMJS.sdk.customVoiceWordsDeleted()");
        return MMJSResponse.responseWithSuccess("Deleted " + words);
    }

    static SpeechKitHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    static NVASpeechKit getSpeechKitInternal() {
        return getInstance().getSpeechKit();
    }

    static void setSpeechKit(NVASpeechKit speechKit) {
        getInstance().release();
        getInstance().setSpeechKit(speechKit);
    }
}
