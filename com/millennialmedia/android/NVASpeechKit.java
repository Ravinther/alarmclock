package com.millennialmedia.android;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import com.nuance.nmdp.speechkit.DataUploadCommand;
import com.nuance.nmdp.speechkit.DataUploadResult;
import com.nuance.nmdp.speechkit.GenericCommand;
import com.nuance.nmdp.speechkit.GenericResult;
import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognizer;
import com.nuance.nmdp.speechkit.SpeechError;
import com.nuance.nmdp.speechkit.SpeechKit;
import com.nuance.nmdp.speechkit.SpeechKit.CmdSetType;
import com.nuance.nmdp.speechkit.Vocalizer;
import com.nuance.nmdp.speechkit.recognitionresult.DetailedResult;
import com.nuance.nmdp.speechkit.util.dataupload.Action;
import com.nuance.nmdp.speechkit.util.dataupload.Action.ActionType;
import com.nuance.nmdp.speechkit.util.dataupload.Data;
import com.nuance.nmdp.speechkit.util.dataupload.Data.DataType;
import com.nuance.nmdp.speechkit.util.dataupload.DataBlock;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NVASpeechKit {
    static final float AUDIO_LEVEL_CHANGE_INTERVAL = 0.25f;
    static final float AUDIO_LEVEL_MAX = 90.0f;
    private static final int AUDIO_LEVEL_UPDATE_FREQUENCY = 50;
    private static final int AUDIO_SAMPLE_PERIOD = 2000;
    static final float SAMPLING_BG_INTERVAL = 0.1f;
    private static String nuanceIdCache;
    NuanceCredentials _credentials;
    public Result[] _results;
    private Runnable audioLevelCallback;
    private AudioLevelTracker audioLevelTracker;
    private Runnable audioSampleCallback;
    private com.nuance.nmdp.speechkit.GenericCommand.Listener commandListener;
    private com.nuance.nmdp.speechkit.DataUploadCommand.Listener dataUploadListener;
    private String nuance_transaction_session_id;
    private String packageName;
    private DataUploadCommand pendingDataUploadCommand;
    private CustomWordsOp pendingDataUploadCommandType;
    private SpeechKit sk;
    private Recognizer skCurrentRecognizer;
    private Vocalizer skCurrentVocalizer;
    private com.nuance.nmdp.speechkit.Recognizer.Listener skRecogListener;
    private com.nuance.nmdp.speechkit.Vocalizer.Listener skVocalListener;
    private Listener speechKitListener;
    private Handler speeckKitHandler;
    private State state;
    private WeakReference webViewRef;

    /* renamed from: com.millennialmedia.android.NVASpeechKit.1 */
    class C25031 implements Runnable {
        C25031() {
        }

        public void run() {
            NVASpeechKit.this.endRecording();
        }
    }

    /* renamed from: com.millennialmedia.android.NVASpeechKit.2 */
    class C25042 implements Runnable {
        C25042() {
        }

        public void run() {
            if (NVASpeechKit.this.skCurrentRecognizer != null) {
                double normalizedLevel = AudioLevelTracker.normalize((double) NVASpeechKit.this.skCurrentRecognizer.getAudioLevel());
                Log.m9711d("audiolevel changed: level=" + normalizedLevel);
                if (NVASpeechKit.this.audioLevelTracker.update(normalizedLevel) && NVASpeechKit.this.speechKitListener != null) {
                    NVASpeechKit.this.speechKitListener.onAudioLevelUpdate(normalizedLevel);
                }
                if (NVASpeechKit.this.state == State.RECORDING || NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample) {
                    NVASpeechKit.this.speeckKitHandler.postDelayed(NVASpeechKit.this.audioLevelCallback, 50);
                }
            }
        }
    }

    /* renamed from: com.millennialmedia.android.NVASpeechKit.3 */
    class C25053 implements com.nuance.nmdp.speechkit.GenericCommand.Listener {
        C25053() {
        }

        public void onComplete(GenericCommand command, GenericResult result, SpeechError error) {
            if (error != null) {
                Log.m9714e("GenericCommand listener. Error: " + error.getErrorDetail());
            } else {
                Log.m9711d("GenericCommand listener. Success: " + result.getQueryResult());
            }
            NVASpeechKit.this.notifySpeechResults();
        }
    }

    /* renamed from: com.millennialmedia.android.NVASpeechKit.4 */
    class C25064 implements com.nuance.nmdp.speechkit.DataUploadCommand.Listener {
        C25064() {
        }

        public void onResults(DataUploadCommand command, DataUploadResult results) {
            Log.m9711d("DataUploadCommand listener successful command:" + command.toString() + " isVocRegenerated:" + results.isVocRegenerated() + " results:" + results.toString());
            notifyListener(command);
        }

        public void onError(DataUploadCommand command, SpeechError error) {
            Log.m9714e("DataUploadCommand listener error. command:" + command.toString() + " Error:" + error.getErrorDetail());
            notifyListener(command);
        }

        private void notifyListener(DataUploadCommand command) {
            if (NVASpeechKit.this.speechKitListener != null && NVASpeechKit.this.pendingDataUploadCommand == command) {
                if (NVASpeechKit.this.pendingDataUploadCommandType == CustomWordsOp.Add) {
                    NVASpeechKit.this.speechKitListener.onCustomWordsAdded();
                } else {
                    NVASpeechKit.this.speechKitListener.onCustomWordsDeleted();
                }
            }
            NVASpeechKit.this.pendingDataUploadCommand = null;
        }
    }

    public interface Listener {
        void onAudioLevelUpdate(double d);

        void onAudioSampleUpdate(double d);

        void onCustomWordsAdded();

        void onCustomWordsDeleted();

        void onError();

        void onResults();

        void onStateChange(State state);
    }

    /* renamed from: com.millennialmedia.android.NVASpeechKit.5 */
    class C25075 implements Listener {
        C25075() {
        }

        public void onStateChange(State state) {
            switch (C25108.$SwitchMap$com$millennialmedia$android$NVASpeechKit$State[state.ordinal()]) {
                case Base64.NO_PADDING /*1*/:
                    NVASpeechKit.this.voiceStateChangeError();
                case Base64.NO_WRAP /*2*/:
                    NVASpeechKit.this.voiceStateChangeProcessing();
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    NVASpeechKit.this.voiceStateChangeReady();
                case Base64.CRLF /*4*/:
                    NVASpeechKit.this.voiceStateChangeRecording();
                case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                    NVASpeechKit.this.voiceStateChangeVocalizing();
                default:
            }
        }

        public void onResults() {
            NVASpeechKit.this.recognitionResult(NVASpeechKit.this.resultsToJSON(NVASpeechKit.this.getResults()).toString());
        }

        public void onError() {
        }

        public void onCustomWordsDeleted() {
        }

        public void onCustomWordsAdded() {
        }

        public void onAudioSampleUpdate(double averageAudioLevel) {
            NVASpeechKit.this.backgroundAudioLevel(averageAudioLevel);
        }

        public void onAudioLevelUpdate(double audioLevel) {
            NVASpeechKit.this.audioLevelChange(audioLevel);
        }
    }

    /* renamed from: com.millennialmedia.android.NVASpeechKit.6 */
    class C25086 implements com.nuance.nmdp.speechkit.Vocalizer.Listener {
        C25086() {
        }

        public void onSpeakingBegin(Vocalizer vocalizer, String text, Object context) {
            Log.m9711d("Vocalization begins. text=" + text);
            NVASpeechKit.this.setState(State.VOCALIZING);
        }

        public void onSpeakingDone(Vocalizer vocalizer, String text, SpeechError error, Object context) {
            Log.m9711d("Vocalization has ended.");
            if (error != null) {
                Log.m9714e("Vocalizer error: " + error.getErrorDetail());
                NVASpeechKit.this.handleSpeechError(error);
                return;
            }
            NVASpeechKit.this.setState(State.READY);
        }
    }

    /* renamed from: com.millennialmedia.android.NVASpeechKit.7 */
    class C25097 implements com.nuance.nmdp.speechkit.Recognizer.Listener {
        C25097() {
        }

        public void onRecordingBegin(Recognizer recognizer) {
            Log.m9711d("recording begins");
            NVASpeechKit.this._results = null;
            if (!NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample()) {
                NVASpeechKit.this.setState(State.RECORDING);
            }
            NVASpeechKit.this.startProgress(recognizer);
            if (NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample()) {
                NVASpeechKit.this.speeckKitHandler.removeCallbacks(NVASpeechKit.this.audioSampleCallback);
                NVASpeechKit.this.speeckKitHandler.postDelayed(NVASpeechKit.this.audioSampleCallback, 2000);
            }
        }

        public void onRecordingDone(Recognizer recognizer) {
            Log.m9711d("recording has ended");
            NVASpeechKit.this.cancelAudioLevelCallbacks();
            if (!NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample()) {
                NVASpeechKit.this.setState(State.PROCESSING);
            }
            if (NVASpeechKit.this.sk != null) {
                NVASpeechKit.this.nuance_transaction_session_id = NVASpeechKit.this.sk.getSessionId();
            }
        }

        public void onError(Recognizer recognizer, SpeechError error) {
            Log.m9711d("Speech Kit Error code:" + error.getErrorCode() + " detail:" + error.getErrorDetail() + " suggestions:" + error.getSuggestion());
            NVASpeechKit.this.cancelAudioLevelCallbacks();
            NVASpeechKit.this.handleSpeechError(error);
            NVASpeechKit.this.skCurrentRecognizer = null;
            if (NVASpeechKit.this.sk != null) {
                Log.m9711d("Recognizer.Listener.onError: session id [" + NVASpeechKit.this.sk.getSessionId() + "]");
            }
        }

        public void onResults(Recognizer recognizer, Recognition results) {
            Log.m9711d("recording results returned.");
            NVASpeechKit.this.cancelAudioLevelCallbacks();
            if (NVASpeechKit.this.audioLevelTracker.isTrackingAudioSample) {
                NVASpeechKit.this._results = new Result[0];
                NVASpeechKit.this.notifySpeechResults();
                return;
            }
            NVASpeechKit.this.processResults(results.getDetailedResults());
            if (NVASpeechKit.this.nuance_transaction_session_id != null) {
                Log.m9711d("Recognizer.Listener.onResults: session id [" + NVASpeechKit.this.nuance_transaction_session_id + "]");
            }
            NVASpeechKit.this.logEvent();
        }
    }

    /* renamed from: com.millennialmedia.android.NVASpeechKit.8 */
    static /* synthetic */ class C25108 {
        static final /* synthetic */ int[] $SwitchMap$com$millennialmedia$android$NVASpeechKit$State;

        static {
            $SwitchMap$com$millennialmedia$android$NVASpeechKit$State = new int[State.values().length];
            try {
                $SwitchMap$com$millennialmedia$android$NVASpeechKit$State[State.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$millennialmedia$android$NVASpeechKit$State[State.PROCESSING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$millennialmedia$android$NVASpeechKit$State[State.READY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$millennialmedia$android$NVASpeechKit$State[State.RECORDING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$millennialmedia$android$NVASpeechKit$State[State.VOCALIZING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static class AudioLevelTracker {
        private static final double MAX = 80.0d;
        private static final double MIN = 40.0d;
        private static final double NORMALIZE_FACTOR = 4.004004004004004d;
        private static final double SCALE = 9.99d;
        double audioLevel;
        int audioLevelCount;
        double averageLevel;
        boolean isTrackingAudioSample;

        public AudioLevelTracker() {
            reset();
        }

        public void reset() {
            this.averageLevel = 0.0d;
            this.audioLevelCount = 0;
            this.isTrackingAudioSample = false;
        }

        public void startTrackingAudioSample() {
            reset();
            this.isTrackingAudioSample = true;
        }

        public boolean isTrackingAudioSample() {
            return this.isTrackingAudioSample;
        }

        private static double normalize(double level) {
            return Math.min(SCALE, Math.max(Math.floor(level - MIN) / NORMALIZE_FACTOR, 0.0d));
        }

        public boolean update(double level) {
            double oldAverage = this.averageLevel;
            double oldLevel = this.audioLevel;
            this.audioLevel = level;
            this.audioLevelCount++;
            this.averageLevel = ((((double) (this.audioLevelCount - 1)) * oldAverage) + level) / ((double) this.audioLevelCount);
            if (this.isTrackingAudioSample || this.audioLevel == oldLevel) {
                return false;
            }
            return true;
        }
    }

    public enum CustomWordsOp {
        Add,
        Remove
    }

    public class Result {
        public final int resultScore;
        public final String resultString;

        public Result(String resultString, double resultScore) {
            this.resultString = resultString;
            this.resultScore = (int) resultScore;
        }

        public String getResultString() {
            return this.resultString;
        }

        public int getResultScore() {
            return this.resultScore;
        }
    }

    public enum State {
        ERROR("error"),
        VOCALIZING("vocalizing"),
        RECORDING("recording"),
        READY("ready"),
        PROCESSING("processing");
        
        private String name;

        private State(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    public NVASpeechKit(MMWebView webView) {
        this._results = null;
        this.audioLevelTracker = new AudioLevelTracker();
        this.audioSampleCallback = new C25031();
        this.audioLevelCallback = new C25042();
        this.commandListener = new C25053();
        this.dataUploadListener = new C25064();
        this.speechKitListener = new C25075();
        if (webView != null) {
            this.webViewRef = new WeakReference(webView);
            initInternalData(webView.getContext().getApplicationContext());
        }
        this.state = State.READY;
    }

    private MMWebView getMMWebView() {
        if (this.webViewRef != null) {
            return (MMWebView) this.webViewRef.get();
        }
        return null;
    }

    private void releaseWebView() {
        if (getMMWebView() != null) {
            this.webViewRef.clear();
        }
    }

    private JSONArray resultsToJSON(Result[] resultArray) {
        JSONArray list = new JSONArray();
        int i = 0;
        while (i < resultArray.length) {
            JSONObject object = new JSONObject();
            try {
                object.put("score", "" + resultArray[i].getResultScore());
                object.put("result", resultArray[i].getResultString());
                list.put(object);
                i++;
            } catch (JSONException e) {
                Log.m9711d("JSON creation error.");
                e.printStackTrace();
                return null;
            }
        }
        return list;
    }

    void voiceStateChangeReady() {
        MMWebView webView = getMMWebView();
        if (webView != null) {
            webView.loadUrl("javascript:MMJS.sdk.voiceStateChange('ready')");
        }
    }

    void voiceStateChangeRecording() {
        MMWebView webView = getMMWebView();
        if (webView != null) {
            webView.loadUrl("javascript:MMJS.sdk.voiceStateChange('recording')");
        }
    }

    void voiceStateChangeProcessing() {
        MMWebView webView = getMMWebView();
        if (webView != null) {
            webView.loadUrl("javascript:MMJS.sdk.voiceStateChange('processing')");
        }
    }

    void voiceStateChangeVocalizing() {
        MMWebView webView = getMMWebView();
        if (webView != null) {
            webView.loadUrl("javascript:MMJS.sdk.voiceStateChange('vocalizing')");
        }
    }

    void voiceStateChangeError() {
        MMWebView webView = getMMWebView();
        if (webView != null) {
            webView.loadUrl("javascript:MMJS.sdk.voiceStateChange('error')");
        }
    }

    void audioLevelChange(double audioLevel) {
        MMWebView webView = getMMWebView();
        if (webView != null) {
            webView.loadUrl("javascript:MMJS.sdk.audioLevelChange(" + audioLevel + ")");
        }
    }

    void recognitionResult(String jsonResults) {
        MMWebView webView = getMMWebView();
        if (webView != null) {
            webView.loadUrl("javascript:MMJS.sdk.recognitionResult(" + jsonResults + ")");
        }
    }

    void voiceError(String error) {
        MMWebView webView = getMMWebView();
        if (webView != null) {
            webView.loadUrl("javascript:MMJS.sdk.voiceError('" + error + "')");
        }
    }

    void backgroundAudioLevel(double audioLevel) {
        MMWebView webView = getMMWebView();
        if (webView != null) {
            webView.loadUrl("javascript:MMJS.sdk.backgroundAudioLevel(" + audioLevel + ")");
        }
    }

    public synchronized State getState() {
        return this.state;
    }

    public void setSpeechKitListener(Listener speechKitListener) {
        this.speechKitListener = speechKitListener;
    }

    public boolean startRecording(String languageCode) {
        Log.m9711d("RECORDING INVOKED.");
        if (this.state != State.READY || this.sk == null) {
            return false;
        }
        this.nuance_transaction_session_id = null;
        this.skCurrentRecognizer = this.sk.createRecognizer("dictation", 1, languageCode, this.skRecogListener, this.speeckKitHandler);
        Log.m9711d("START RECORDING");
        this.skCurrentRecognizer.start();
        return true;
    }

    public boolean endRecording() {
        if (this.skCurrentRecognizer == null) {
            return false;
        }
        Log.m9711d("end RECORDING");
        this.skCurrentRecognizer.stopRecording();
        this.skCurrentRecognizer = null;
        return true;
    }

    public void cancelRecording() {
        if (this.skCurrentRecognizer != null) {
            Log.m9711d("cancel RECORDING");
            this.skCurrentRecognizer.cancel();
            this.skCurrentRecognizer = null;
            setState(State.READY);
        }
    }

    public void startSampleRecording() {
        this.audioLevelTracker.startTrackingAudioSample();
        startRecording("en_US");
    }

    public Result[] getResults() {
        return this._results;
    }

    public void stopActions() {
        if (this.sk != null) {
            try {
                this.sk.cancelCurrent();
            } catch (Exception e) {
                Log.m9715e("No speech kit to disconnect.", e);
            }
        }
    }

    public boolean textToSpeech(String input, String languageCode) {
        Log.m9711d("TTS INVOKED.");
        if (this.state != State.READY || this.sk == null) {
            return false;
        }
        this.skCurrentVocalizer = this.sk.createVocalizerWithLanguage(languageCode, this.skVocalListener, this.speeckKitHandler);
        this.skCurrentVocalizer.speakString(input, this);
        return true;
    }

    public void release() {
        Log.m9711d("release called.");
        stopActions();
        cancelAudioLevelCallbacks();
        if (this.sk != null) {
            this.sk.release();
            setState(State.READY);
            this.sk = null;
        }
        this.pendingDataUploadCommand = null;
        releaseWebView();
    }

    public void logEvent() {
        if (this.sk != null) {
            Dictionary content = new Dictionary();
            content.put("nva_ad_network_id", "MillenialMedia");
            content.put("nva_device_id", getNuanceId());
            content.put("nva_ad_publisher_id", this.packageName);
            String mmSessionId = "";
            if (!(this._credentials == null || TextUtils.isEmpty(this._credentials.sessionID))) {
                mmSessionId = this._credentials.sessionID;
                content.put("nva_ad_session_id", this._credentials.sessionID);
            }
            String adId = getAdId();
            if (!TextUtils.isEmpty(adId)) {
                content.put("nva_ad_id", adId);
            }
            String session_id_for_logging;
            if (this.nuance_transaction_session_id != null) {
                content.put("nva_nvc_session_id", this.nuance_transaction_session_id);
                session_id_for_logging = this.nuance_transaction_session_id;
                this.nuance_transaction_session_id = null;
            } else {
                session_id_for_logging = this.sk.getSessionId();
            }
            Log.m9711d("Sending log revision command to server. sessionId[" + this.sk.getSessionId() + "] deviceId[" + getNuanceId() + "] adId[" + adId + "] mmSessionId[" + mmSessionId + "]");
            this.sk.createLogRevisionCmd("NVA_LOG_EVENT", content, this.sk.getSessionId(), this.commandListener, this.speeckKitHandler).start();
        }
    }

    private String getAdId() {
        if (this.webViewRef != null) {
            MMWebView webView = (MMWebView) this.webViewRef.get();
            if (webView != null) {
                return webView.getAdId();
            }
        }
        return "DEFAULT_AD_ID";
    }

    private String byte2Str(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        StringBuffer hexString = new StringBuffer();
        for (byte b : byteArray) {
            int v = b & 255;
            String hex = Integer.toHexString(v);
            if (v < 16) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private byte[] string2Byte(String string) {
        if (string == null) {
            return null;
        }
        byte[] bytes = new byte[(string.length() / 2)];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(string.substring(i * 2, (i * 2) + 2), 16);
        }
        return bytes;
    }

    public boolean initialize(NuanceCredentials credentials, Context context) {
        Log.m9711d("initialize called.");
        if (credentials == null || context == null) {
            return false;
        }
        this._credentials = credentials;
        if (this.sk != null) {
            try {
                this.sk.connect();
            } catch (IllegalStateException e) {
                this.sk = null;
            }
        }
        if (this.sk == null) {
            byte[] appKeyBytes = string2Byte(credentials.appKey);
            Log.m9711d(credentials.toString());
            this.sk = SpeechKit.initialize(context, "1.0", credentials.appID, credentials.server, credentials.port, false, appKeyBytes, CmdSetType.NVC);
            this.skVocalListener = createVocalizerListener();
            this.skRecogListener = createRecognizerListener();
            this.speeckKitHandler = new Handler(Looper.getMainLooper());
            this.sk.connect();
            setState(State.READY);
            return true;
        }
        Log.m9711d("Already initialized. Skipping.");
        return false;
    }

    String getSessionId() {
        if (this.sk != null) {
            return this.sk.getSessionId();
        }
        return "";
    }

    public void updateCustomWords(CustomWordsOp op, String[] words) {
        if (this.sk != null) {
            DataBlock datablock = new DataBlock();
            Log.m9711d("Creating dataupload command and " + (op == CustomWordsOp.Add ? "adding" : "deleting") + " words.");
            Data data = new Data("nva_custom_word_uploads", DataType.CUSTOMWORDS);
            Action addAction = new Action(op == CustomWordsOp.Add ? ActionType.ADD : ActionType.REMOVE);
            for (String word : words) {
                addAction.addWord(word);
                Log.m9711d("\tword: '" + word + "'");
            }
            data.addAction(addAction);
            datablock.addData(data);
            int checksum = datablock.getChecksum();
            this.pendingDataUploadCommandType = op;
            this.pendingDataUploadCommand = this.sk.createDataUploadCmd(datablock, checksum, checksum, this.dataUploadListener, this.speeckKitHandler);
            this.pendingDataUploadCommand.start();
        }
    }

    private void processResults(List inputResults) {
        Log.m9711d("processResults called.");
        this._results = new Result[inputResults.size()];
        int i = 0;
        for (DetailedResult r : inputResults) {
            int i2 = i + 1;
            this._results[i] = new Result(r.toString(), r.getConfidenceScore());
            i = i2;
        }
    }

    private com.nuance.nmdp.speechkit.Vocalizer.Listener createVocalizerListener() {
        return new C25086();
    }

    private String getSpeechError(SpeechError error) {
        if (error == null) {
            return "No Error given";
        }
        return "Speech Kit Error code:" + error.getErrorCode() + " detail:" + error.getErrorDetail() + " suggestions:" + error.getSuggestion();
    }

    private com.nuance.nmdp.speechkit.Recognizer.Listener createRecognizerListener() {
        return new C25097();
    }

    static {
        nuanceIdCache = null;
    }

    synchronized String getNuanceId() {
        String str = null;
        synchronized (this) {
            if (nuanceIdCache != null) {
                str = nuanceIdCache;
            } else {
                Context context = null;
                if (this.webViewRef != null) {
                    MMWebView webView = (MMWebView) this.webViewRef.get();
                    if (webView != null) {
                        context = webView.getContext();
                    }
                }
                if (context != null) {
                    String mmdid = Secure.getString(context.getContentResolver(), "android_id");
                    if (mmdid != null) {
                        try {
                            str = MMSDK.byteArrayToString(MessageDigest.getInstance("SHA1").digest(mmdid.getBytes()));
                            nuanceIdCache = str;
                        } catch (Exception e) {
                            Log.m9723v(e.getMessage());
                        }
                    }
                }
            }
        }
        return str;
    }

    private void initInternalData(Context context) {
        if (this.packageName == null) {
            this.packageName = context.getApplicationContext().getPackageName();
        }
    }

    private void handleSpeechError(SpeechError error) {
        switch (error.getErrorCode()) {
            case Base64.NO_WRAP /*2*/:
                if (!this.audioLevelTracker.isTrackingAudioSample) {
                    setState(State.PROCESSING);
                }
                this._results = new Result[0];
                notifySpeechResults();
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                setState(State.READY);
                this.skCurrentRecognizer = null;
            default:
                if (this.speechKitListener != null) {
                    this.speechKitListener.onError();
                    setState(State.ERROR);
                    voiceError(getSpeechError(error));
                }
        }
    }

    private void notifySpeechResults() {
        if (!(this.speechKitListener == null || this._results == null)) {
            if (this.audioLevelTracker.isTrackingAudioSample) {
                this.speechKitListener.onAudioSampleUpdate(this.audioLevelTracker.averageLevel);
                this.audioLevelTracker.reset();
            } else {
                this.speechKitListener.onResults();
            }
        }
        setState(State.READY);
        this.skCurrentRecognizer = null;
    }

    private void startProgress(Recognizer recognizer) {
        this.speeckKitHandler.removeCallbacks(this.audioLevelCallback);
        this.speeckKitHandler.postDelayed(this.audioLevelCallback, 50);
    }

    private synchronized void setState(State state) {
        Log.m9711d("recording results returned. state=" + state);
        State old_state = this.state;
        this.state = state;
        if (!(this.speechKitListener == null || this.state == old_state)) {
            this.speechKitListener.onStateChange(state);
        }
    }

    private void cancelAudioLevelCallbacks() {
        if (this.speeckKitHandler != null) {
            this.speeckKitHandler.removeCallbacks(this.audioSampleCallback);
            this.speeckKitHandler.removeCallbacks(this.audioLevelCallback);
        }
    }
}
