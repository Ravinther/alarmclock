package com.millennialmedia.android;

import android.content.Context;
import android.media.MediaRecorder;
import android.text.TextUtils;
import com.google.android.gms.location.LocationStatusCodes;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class BridgeMMMicrophone extends MMJSObject {

    /* renamed from: com.millennialmedia.android.BridgeMMMicrophone.1 */
    class C24591 implements Runnable {
        C24591() {
        }

        public void run() {
            BridgeMMMicrophone.this.stopRecording(null);
        }
    }

    static class Recorder {
        State _state;
        AudioRunnable audioRunnable;
        private MediaRecorder mRecorder;
        private WeakReference webViewRef;

        private class AudioRunnable implements Runnable {
            private int _callbackRate;
            boolean shouldCancel;

            public AudioRunnable(int callbackRate) {
                this._callbackRate = callbackRate;
            }

            void cancel() {
                this.shouldCancel = true;
            }

            public void run() {
                if (Recorder.this._state.equals(State.RECORDING) && !this.shouldCancel) {
                    MMWebView webView = (MMWebView) Recorder.this.webViewRef.get();
                    if (webView != null) {
                        webView.setmicrophoneAudioLevelChange(Recorder.this.getAudioLevel());
                    }
                    webView.postDelayed(this, (long) this._callbackRate);
                }
            }
        }

        private static class SingletonHolder {
            public static final Recorder INSTANCE;

            private SingletonHolder() {
            }

            static {
                INSTANCE = new Recorder();
            }
        }

        enum State {
            RECORDING("recording"),
            READY("ready");
            
            private String _state;

            private State(String state) {
                this._state = state;
            }

            public String getState() {
                return this._state;
            }
        }

        private Recorder() {
            this.mRecorder = null;
            this._state = State.READY;
        }

        synchronized void addCallBack(MMWebView webView) {
            this.webViewRef = new WeakReference(webView);
        }

        public static Recorder getInstance() {
            return SingletonHolder.INSTANCE;
        }

        private synchronized void startRecording(String path, int callbackRate) {
            if (this.mRecorder == null) {
                this.mRecorder = new MediaRecorder();
            }
            stopRecording();
            this.mRecorder.setAudioSource(1);
            this.mRecorder.setOutputFormat(1);
            if (!TextUtils.isEmpty(path)) {
                this.mRecorder.setOutputFile(path);
            }
            this.mRecorder.setAudioEncoder(1);
            try {
                this.mRecorder.prepare();
            } catch (IOException e) {
                Log.m9714e("prepare() failed");
            }
            this.mRecorder.start();
            this.mRecorder.getMaxAmplitude();
            if (this.webViewRef != null) {
                MMWebView webView = (MMWebView) this.webViewRef.get();
                if (webView != null) {
                    this._state = State.RECORDING;
                    webView.setmicrophoneStateChange(State.RECORDING.getState());
                    if (callbackRate > 0) {
                        if (this.audioRunnable != null) {
                            this.audioRunnable.cancel();
                        }
                        this.audioRunnable = new AudioRunnable(callbackRate);
                        webView.postDelayed(this.audioRunnable, (long) callbackRate);
                    }
                }
            }
        }

        private double getAudioLevel() {
            if (this.mRecorder != null) {
                return ((double) (this.mRecorder.getMaxAmplitude() * 9)) / 32767.0d;
            }
            return 0.0d;
        }

        synchronized void stopRecording() {
            if (this.mRecorder != null) {
                try {
                    this.mRecorder.stop();
                    this.mRecorder.reset();
                } catch (Exception e) {
                    Log.m9726w("Exception: " + e.getMessage());
                }
            }
            if (this.audioRunnable != null) {
                this.audioRunnable.cancel();
            }
            if (this.webViewRef != null) {
                MMWebView webView = (MMWebView) this.webViewRef.get();
                if (webView != null) {
                    this._state = State.READY;
                    webView.setmicrophoneStateChange(State.READY.getState());
                }
            }
        }
    }

    BridgeMMMicrophone() {
    }

    public MMJSResponse startRecording(HashMap arguments) {
        Recorder recorder = initRecorder();
        if (recorder == null) {
            return MMJSResponse.responseWithError("Unable to create Microphone Recorder");
        }
        String path = (String) arguments.get("path");
        if (!(TextUtils.isEmpty(path) || this.contextRef == null)) {
            File dir = AdCache.getCacheDirectory((Context) this.contextRef.get());
            if (dir != null) {
                File filePath = new File(dir, path);
                if (filePath != null) {
                    path = filePath.getPath();
                }
            }
        }
        if (!TextUtils.isEmpty((String) arguments.get("duration"))) {
            delayedEnd("9");
        }
        String callbackRate = (String) arguments.get("callbackRate");
        int intCallbackRate = 100;
        if (!TextUtils.isEmpty(callbackRate)) {
            try {
                intCallbackRate = (int) (Float.parseFloat(callbackRate) * 1000.0f);
            } catch (Exception e) {
            }
        }
        recorder.startRecording(path, intCallbackRate);
        return MMJSResponse.responseWithSuccess("recording");
    }

    private void delayedEnd(String duration) {
        try {
            MMSDK.runOnUiThreadDelayed(new C24591(), (long) (Integer.parseInt(duration) * LocationStatusCodes.GEOFENCE_NOT_AVAILABLE));
        } catch (NumberFormatException e) {
        }
    }

    private Recorder initRecorder() {
        if (this.mmWebViewRef == null) {
            return null;
        }
        MMWebView webView = (MMWebView) this.mmWebViewRef.get();
        if (webView == null || !webView.allowMicrophoneCreationCommands()) {
            return null;
        }
        Recorder recorder = Recorder.getInstance();
        recorder.addCallBack(webView);
        return recorder;
    }

    public MMJSResponse stopRecording(HashMap arguments) {
        Recorder recorder = initRecorder();
        if (recorder == null) {
            return MMJSResponse.responseWithError("Unable to create Microphone Recorder");
        }
        recorder.stopRecording();
        return MMJSResponse.responseWithSuccess("stopped recording");
    }

    public MMJSResponse isRecordingAllowed(HashMap arguments) {
        Context context = null;
        if (this.contextRef != null) {
            context = (Context) this.contextRef.get();
        }
        if (MMSDK.hasVoiceAbility(context).equals("true")) {
            return MMJSResponse.responseWithSuccess("Has Microphone / Ready to use");
        }
        return MMJSResponse.responseWithError("No voice ability");
    }
}
