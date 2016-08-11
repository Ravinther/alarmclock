package com.millennialmedia.android;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.plus.PlusShare;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

class BridgeMMMedia extends MMJSObject {
    private static final String PATH = "path";
    private static final String PICTURES = "Pictures";
    private static Object pickerActivityObject;
    MediaScannerConnection mediaScanner;

    /* renamed from: com.millennialmedia.android.BridgeMMMedia.1 */
    class C24551 implements MediaScannerConnectionClient {
        final /* synthetic */ String val$path;

        C24551(String str) {
            this.val$path = str;
        }

        public void onScanCompleted(String path, Uri uri) {
            if (uri == null) {
                Log.m9711d("Failed to scan " + path);
            }
        }

        public void onMediaScannerConnected() {
            if (BridgeMMMedia.this.mediaScanner != null) {
                BridgeMMMedia.this.mediaScanner.scanFile(this.val$path, null);
            }
        }
    }

    static class Audio implements OnCompletionListener {
        private static final int MAX_SOUNDS = 4;
        private static Audio sharedInstance;
        private OnLoadCompleteListener completionListener;
        CopyOnWriteArrayList completionListeners;
        private WeakReference contextRef;
        private MediaPlayer mediaPlayer;
        CopyOnWriteArrayList periodicListeners;
        Runnable periodicUpdater;
        private SoundPool soundPool;

        /* renamed from: com.millennialmedia.android.BridgeMMMedia.Audio.1 */
        class C24561 implements Runnable {
            C24561() {
            }

            public void run() {
                if (Audio.this.mediaPlayer != null) {
                    if (Audio.this.mediaPlayer.isPlaying()) {
                        int currentPositionMillis = Audio.this.mediaPlayer.getCurrentPosition();
                        if (Audio.this.periodicListeners != null) {
                            Iterator i$ = Audio.this.periodicListeners.iterator();
                            while (i$.hasNext()) {
                                ((PeriodicListener) i$.next()).onUpdate(currentPositionMillis);
                            }
                        }
                    }
                    MMSDK.runOnUiThreadDelayed(this, 500);
                }
            }
        }

        private abstract class OnLoadCompleteListener {
            private static final int TEST_PERIOD_MS = 100;
            private ArrayList sampleIds;
            private SoundPool soundPool;
            private Timer timer;

            /* renamed from: com.millennialmedia.android.BridgeMMMedia.Audio.OnLoadCompleteListener.1 */
            class C24581 extends TimerTask {
                C24581() {
                }

                public void run() {
                    ArrayList completedOnes = new ArrayList();
                    Iterator i$ = OnLoadCompleteListener.this.sampleIds.iterator();
                    while (i$.hasNext()) {
                        Integer sampleId = (Integer) i$.next();
                        int streamId = OnLoadCompleteListener.this.soundPool.play(sampleId.intValue(), 0.0f, 0.0f, 0, 0, 1.0f);
                        if (streamId != 0) {
                            OnLoadCompleteListener.this.soundPool.stop(streamId);
                            OnLoadCompleteListener.this.onLoadComplete(OnLoadCompleteListener.this.soundPool, sampleId.intValue(), 0);
                            completedOnes.add(sampleId);
                        }
                    }
                    OnLoadCompleteListener.this.sampleIds.removeAll(completedOnes);
                    if (OnLoadCompleteListener.this.sampleIds.size() == 0) {
                        OnLoadCompleteListener.this.timer.cancel();
                        OnLoadCompleteListener.this.timer.purge();
                    }
                }
            }

            abstract void onLoadComplete(SoundPool soundPool, int i, int i2);

            public OnLoadCompleteListener(SoundPool soundPool) {
                this.sampleIds = new ArrayList();
                this.soundPool = soundPool;
            }

            synchronized void testSample(int sampleId) {
                this.sampleIds.add(Integer.valueOf(sampleId));
                if (this.sampleIds.size() == 1) {
                    this.timer = new Timer();
                    this.timer.scheduleAtFixedRate(new C24581(), 0, 100);
                }
            }

            synchronized void release() {
                if (this.timer != null) {
                    this.timer.cancel();
                    this.timer.purge();
                }
            }
        }

        /* renamed from: com.millennialmedia.android.BridgeMMMedia.Audio.2 */
        class C24572 extends OnLoadCompleteListener {
            C24572(SoundPool x0) {
                super(x0);
            }

            public synchronized void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (soundPool != null) {
                    Context context = (Context) Audio.this.contextRef.get();
                    if (context != null) {
                        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                        float streamVolume = (((float) audioManager.getStreamVolume(3)) + 0.0f) / ((float) audioManager.getStreamMaxVolume(3));
                        soundPool.play(sampleId, streamVolume, streamVolume, 1, 0, 1.0f);
                    }
                }
            }
        }

        interface PeriodicListener {
            void onUpdate(int i);
        }

        private Audio() {
            this.periodicUpdater = new C24561();
        }

        private Audio(Context context) {
            this.periodicUpdater = new C24561();
            this.contextRef = new WeakReference(context.getApplicationContext());
        }

        boolean addCompletionListener(OnCompletionListener listener) {
            if (this.completionListeners == null) {
                this.completionListeners = new CopyOnWriteArrayList();
            }
            if (this.completionListeners.contains(listener)) {
                return false;
            }
            return this.completionListeners.add(listener);
        }

        boolean removeCompletionListener(OnCompletionListener listener) {
            if (this.completionListeners != null) {
                return this.completionListeners.remove(listener);
            }
            return false;
        }

        boolean addPeriodicListener(PeriodicListener listener) {
            if (this.periodicListeners == null) {
                this.periodicListeners = new CopyOnWriteArrayList();
            }
            if (this.periodicListeners.contains(listener)) {
                return false;
            }
            return this.periodicListeners.add(listener);
        }

        boolean removePeriodicListener(PeriodicListener listener) {
            if (this.periodicListeners != null) {
                return this.periodicListeners.remove(listener);
            }
            return false;
        }

        static synchronized Audio sharedAudio(Context context) {
            Audio audio;
            synchronized (Audio.class) {
                if (sharedInstance == null) {
                    sharedInstance = new Audio(context);
                }
                audio = sharedInstance;
            }
            return audio;
        }

        synchronized boolean isPlaying() {
            boolean z;
            z = this.mediaPlayer != null && this.mediaPlayer.isPlaying();
            return z;
        }

        public synchronized void onCompletion(MediaPlayer mp) {
            if (this.completionListeners != null) {
                Iterator i$ = this.completionListeners.iterator();
                while (i$.hasNext()) {
                    ((OnCompletionListener) i$.next()).onCompletion(this.mediaPlayer);
                }
            }
            if (this.mediaPlayer != null) {
                this.mediaPlayer.release();
                this.mediaPlayer = null;
            }
        }

        synchronized MMJSResponse playAudio(Uri uri, boolean loop) {
            try {
                if (this.mediaPlayer != null) {
                    this.mediaPlayer.release();
                    this.mediaPlayer = null;
                }
                this.mediaPlayer = MediaPlayer.create((Context) this.contextRef.get(), uri);
                this.mediaPlayer.setLooping(loop);
                this.mediaPlayer.start();
                this.mediaPlayer.setOnCompletionListener(this);
                MMSDK.runOnUiThread(this.periodicUpdater);
            } catch (Exception e) {
                Log.m9716e(e.getCause());
            }
            return MMJSResponse.responseWithSuccess("Audio playback started");
        }

        synchronized MMJSResponse playSound(File file) {
            try {
                if (this.soundPool == null) {
                    this.soundPool = new SoundPool(MAX_SOUNDS, 3, 0);
                    this.completionListener = new C24572(this.soundPool);
                }
                this.completionListener.testSample(this.soundPool.load(file.getAbsolutePath(), 1));
            } catch (Exception e) {
            }
            return MMJSResponse.responseWithSuccess("Sound playback started");
        }

        synchronized MMJSResponse stop() {
            if (this.mediaPlayer != null) {
                onCompletion(this.mediaPlayer);
            }
            if (this.soundPool != null) {
                this.soundPool.release();
                this.soundPool = null;
            }
            if (this.completionListener != null) {
                this.completionListener.release();
                this.completionListener = null;
            }
            return MMJSResponse.responseWithSuccess("Audio stopped");
        }
    }

    static class PickerActivity extends MMBaseActivity {
        private Uri fileUri;
        boolean hasRequestedPic;

        PickerActivity() {
            this.hasRequestedPic = false;
        }

        public Object onRetainNonConfigurationInstance() {
            super.onRetainNonConfigurationInstance();
            Bundle outState = new Bundle();
            outState.putBoolean("hasRequestedPic", this.hasRequestedPic);
            return outState;
        }

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getLastNonConfigurationInstance() != null) {
                this.hasRequestedPic = ((Bundle) getLastNonConfigurationInstance()).getBoolean("hasRequestedPic");
            }
            if (!this.hasRequestedPic) {
                Intent intent;
                if (getIntent().getStringExtra("type").equalsIgnoreCase("Camera")) {
                    intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    this.fileUri = getIntent().getData();
                    intent.putExtra("return-data", true);
                    this.hasRequestedPic = true;
                    startActivityForResult(intent, 0);
                    return;
                }
                intent = new Intent();
                intent.setType("image/*");
                intent.setAction("android.intent.action.GET_CONTENT");
                this.hasRequestedPic = true;
                startActivityForResult(intent, 0);
            }
        }

        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            OutputStream fileOutputStream;
            Throwable th;
            super.onActivityResult(requestCode, resultCode, data);
            if (data != null) {
                InputStream in = null;
                OutputStream out = null;
                try {
                    Uri contentUri = data.getData();
                    File file;
                    byte[] buf;
                    int len;
                    if (contentUri == null) {
                        if (data.getExtras() != null) {
                            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                            try {
                                file = new File(getIntent().getData().getPath());
                                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                                bitmap.compress(CompressFormat.PNG, 0, bos);
                                ByteArrayInputStream bs = new ByteArrayInputStream(bos.toByteArray());
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    buf = new byte[1024];
                                    while (true) {
                                        len = bs.read(buf);
                                        if (len <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(buf, 0, len);
                                    }
                                    if (in != null) {
                                        try {
                                            in.close();
                                        } catch (Exception e) {
                                            out = fileOutputStream;
                                        }
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    out = fileOutputStream;
                                } catch (Exception e2) {
                                    out = fileOutputStream;
                                    if (in != null) {
                                        try {
                                            in.close();
                                        } catch (Exception e3) {
                                        }
                                    }
                                    if (out != null) {
                                        out.close();
                                    }
                                    synchronized (BridgeMMMedia.pickerActivityObject) {
                                        BridgeMMMedia.pickerActivityObject.notify();
                                    }
                                    finish();
                                } catch (Throwable th2) {
                                    th = th2;
                                    out = fileOutputStream;
                                    if (in != null) {
                                        try {
                                            in.close();
                                        } catch (Exception e4) {
                                            throw th;
                                        }
                                    }
                                    if (out != null) {
                                        out.close();
                                    }
                                    throw th;
                                }
                            } catch (Exception e5) {
                                if (in != null) {
                                    in.close();
                                }
                                if (out != null) {
                                    out.close();
                                }
                                synchronized (BridgeMMMedia.pickerActivityObject) {
                                    BridgeMMMedia.pickerActivityObject.notify();
                                }
                                finish();
                            } catch (Throwable th3) {
                                th = th3;
                                if (in != null) {
                                    in.close();
                                }
                                if (out != null) {
                                    out.close();
                                }
                                throw th;
                            }
                        }
                    } else if (contentUri != null) {
                        String[] proj = new String[]{"_data"};
                        ContentResolver resolver = getContentResolver();
                        if (resolver != null) {
                            Cursor cursor = resolver.query(contentUri, proj, null, null, null);
                            if (cursor != null) {
                                int index = cursor.getColumnIndex("_data");
                                if (index != -1) {
                                    cursor.moveToFirst();
                                    File chosenFile = new File(cursor.getString(index));
                                    cursor.close();
                                    try {
                                        file = new File(getIntent().getData().getPath());
                                        InputStream fileInputStream = new FileInputStream(chosenFile);
                                        try {
                                            fileOutputStream = new FileOutputStream(file);
                                        } catch (Exception e6) {
                                            in = fileInputStream;
                                            if (in != null) {
                                                try {
                                                    in.close();
                                                } catch (Exception e7) {
                                                }
                                            }
                                            if (out != null) {
                                                out.close();
                                            }
                                            synchronized (BridgeMMMedia.pickerActivityObject) {
                                                BridgeMMMedia.pickerActivityObject.notify();
                                            }
                                            finish();
                                        } catch (Throwable th4) {
                                            th = th4;
                                            in = fileInputStream;
                                            if (in != null) {
                                                try {
                                                    in.close();
                                                } catch (Exception e8) {
                                                    throw th;
                                                }
                                            }
                                            if (out != null) {
                                                out.close();
                                            }
                                            throw th;
                                        }
                                        try {
                                            buf = new byte[1024];
                                            while (true) {
                                                len = fileInputStream.read(buf);
                                                if (len <= 0) {
                                                    break;
                                                }
                                                fileOutputStream.write(buf, 0, len);
                                            }
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (Exception e9) {
                                                    out = fileOutputStream;
                                                    in = fileInputStream;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            out = fileOutputStream;
                                            in = fileInputStream;
                                        } catch (Exception e10) {
                                            out = fileOutputStream;
                                            in = fileInputStream;
                                            if (in != null) {
                                                in.close();
                                            }
                                            if (out != null) {
                                                out.close();
                                            }
                                            synchronized (BridgeMMMedia.pickerActivityObject) {
                                                BridgeMMMedia.pickerActivityObject.notify();
                                            }
                                            finish();
                                        } catch (Throwable th5) {
                                            th = th5;
                                            out = fileOutputStream;
                                            in = fileInputStream;
                                            if (in != null) {
                                                in.close();
                                            }
                                            if (out != null) {
                                                out.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e11) {
                                        if (in != null) {
                                            in.close();
                                        }
                                        if (out != null) {
                                            out.close();
                                        }
                                        synchronized (BridgeMMMedia.pickerActivityObject) {
                                            BridgeMMMedia.pickerActivityObject.notify();
                                        }
                                        finish();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        if (in != null) {
                                            in.close();
                                        }
                                        if (out != null) {
                                            out.close();
                                        }
                                        throw th;
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e12) {
                    Log.m9714e("Error with picture: " + e12.getMessage());
                }
            }
            synchronized (BridgeMMMedia.pickerActivityObject) {
                BridgeMMMedia.pickerActivityObject.notify();
            }
            finish();
        }
    }

    BridgeMMMedia() {
    }

    private boolean isCameraAvailable() {
        Context context = (Context) this.contextRef.get();
        if (context == null || context.getPackageManager().checkPermission("android.permission.CAMERA", context.getPackageName()) != 0) {
            return false;
        }
        if (context.getPackageManager().queryIntentActivities(new Intent("android.media.action.IMAGE_CAPTURE"), Cast.MAX_MESSAGE_LENGTH).size() > 0) {
            return true;
        }
        return false;
    }

    private boolean isPictureChooserAvailable() {
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        if (context.getPackageManager().queryIntentActivities(intent, Cast.MAX_MESSAGE_LENGTH).size() > 0) {
            return true;
        }
        return false;
    }

    public MMJSResponse isSourceTypeAvailable(HashMap arguments) {
        String type = (String) arguments.get("sourceType");
        if (type != null) {
            if (type.equalsIgnoreCase("Camera") && isCameraAvailable()) {
                return MMJSResponse.responseWithSuccess("true");
            }
            if (type.equalsIgnoreCase("Photo Library") && isPictureChooserAvailable()) {
                return MMJSResponse.responseWithSuccess("true");
            }
        }
        return MMJSResponse.responseWithError("false");
    }

    public MMJSResponse availableSourceTypes(HashMap arguments) {
        JSONArray jsonArray = new JSONArray();
        if (isCameraAvailable()) {
            jsonArray.put("Camera");
        }
        if (isPictureChooserAvailable()) {
            jsonArray.put("Photo Library");
        }
        MMJSResponse response = new MMJSResponse();
        response.result = 1;
        response.response = jsonArray;
        return response;
    }

    static Bitmap resizeImage(Bitmap image, String contentMode, int toW, int toH, int quality) {
        float horizontalRatio = ((float) toW) / ((float) image.getWidth());
        float verticalRatio = ((float) toH) / ((float) image.getHeight());
        if (contentMode.equals("Center")) {
            return centerOfImage(image, toW, toH);
        }
        float ratio;
        if (contentMode.equals("ScaleToAspectFit")) {
            ratio = Math.min(horizontalRatio, verticalRatio);
            return resizeImage(image, (int) (((float) image.getWidth()) * ratio), (int) (((float) image.getHeight()) * ratio), quality);
        } else if (!contentMode.equals("ScaleToAspectFill")) {
            return resizeImage(image, toW, toH, quality);
        } else {
            ratio = Math.max(horizontalRatio, verticalRatio);
            return cropImage(resizeImage(image, (int) (((float) image.getWidth()) * ratio), (int) (((float) image.getHeight()) * ratio), quality), 0, 0, toW, toH);
        }
    }

    private static Bitmap resizeImage(Bitmap image, int newW, int newH, int quality) {
        return Bitmap.createScaledBitmap(image, newW, newH, true);
    }

    private static Bitmap centerOfImage(Bitmap image, int width, int height) {
        return cropImage(image, (int) ((float) ((image.getWidth() - width) / 2)), (int) ((float) ((image.getHeight() - height) / 2)), width, height);
    }

    private static Bitmap cropImage(Bitmap bitmap, int left, int top, int width, int height) {
        return Bitmap.createBitmap(bitmap, left, top, width, height);
    }

    private static final byte[] scaleBitmapToBytes(File file, int w, int h, String contentMode) {
        FileInputStream fis2;
        byte[] contents;
        Bitmap finalBitmap;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream baos;
        Exception e;
        Throwable th;
        FileInputStream fis = null;
        FileInputStream fis22 = null;
        Bitmap scaledBitmap = null;
        try {
            Options options;
            int inSampleSize;
            FileInputStream fis3 = new FileInputStream(file);
            try {
                options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(fis3, null, options);
                int height = options.outHeight;
                int width = options.outWidth;
                inSampleSize = 1;
                if (height > h || width > w) {
                    if (width > height) {
                        inSampleSize = Math.round(((float) height) / ((float) h));
                    } else {
                        inSampleSize = Math.round(((float) width) / ((float) w));
                    }
                }
                fis2 = new FileInputStream(file);
            } catch (FileNotFoundException e2) {
                fis = fis3;
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e3) {
                    }
                }
                if (fis22 != null) {
                    fis22.close();
                }
                contents = null;
                if (scaledBitmap != null) {
                    finalBitmap = resizeImage(scaledBitmap, contentMode, w, h, 1);
                    byteArrayOutputStream = null;
                    try {
                        baos = new ByteArrayOutputStream();
                        try {
                            if (contentMode.equals("")) {
                                finalBitmap.compress(CompressFormat.JPEG, 100, baos);
                            } else {
                                scaledBitmap.compress(CompressFormat.JPEG, 100, baos);
                            }
                            contents = baos.toByteArray();
                            if (scaledBitmap != null) {
                                try {
                                    scaledBitmap.recycle();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (finalBitmap != null) {
                                finalBitmap.recycle();
                            }
                            if (baos != null) {
                                baos.close();
                            }
                        } catch (Exception e5) {
                            e4 = e5;
                            byteArrayOutputStream = baos;
                            contents = null;
                            try {
                                e4.printStackTrace();
                                if (scaledBitmap != null) {
                                    try {
                                        scaledBitmap.recycle();
                                    } catch (Exception e42) {
                                        e42.printStackTrace();
                                    }
                                }
                                if (finalBitmap != null) {
                                    finalBitmap.recycle();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                return contents;
                            } catch (Throwable th2) {
                                th = th2;
                                if (scaledBitmap != null) {
                                    try {
                                        scaledBitmap.recycle();
                                    } catch (Exception e422) {
                                        e422.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (finalBitmap != null) {
                                    finalBitmap.recycle();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream = baos;
                            if (scaledBitmap != null) {
                                scaledBitmap.recycle();
                            }
                            if (finalBitmap != null) {
                                finalBitmap.recycle();
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        e422 = e6;
                        contents = null;
                        e422.printStackTrace();
                        if (scaledBitmap != null) {
                            scaledBitmap.recycle();
                        }
                        if (finalBitmap != null) {
                            finalBitmap.recycle();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return contents;
                    }
                }
                return contents;
            } catch (Throwable th4) {
                th = th4;
                fis = fis3;
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e7) {
                        throw th;
                    }
                }
                if (fis22 != null) {
                    fis22.close();
                }
                throw th;
            }
            try {
                options.inJustDecodeBounds = false;
                options.inSampleSize = inSampleSize;
                scaledBitmap = BitmapFactory.decodeStream(fis2, null, options);
                if (fis3 != null) {
                    try {
                        fis3.close();
                    } catch (IOException e8) {
                        fis22 = fis2;
                        fis = fis3;
                    }
                }
                if (fis2 != null) {
                    fis2.close();
                }
                fis22 = fis2;
                fis = fis3;
            } catch (FileNotFoundException e9) {
                fis22 = fis2;
                fis = fis3;
                if (fis != null) {
                    fis.close();
                }
                if (fis22 != null) {
                    fis22.close();
                }
                contents = null;
                if (scaledBitmap != null) {
                    finalBitmap = resizeImage(scaledBitmap, contentMode, w, h, 1);
                    byteArrayOutputStream = null;
                    baos = new ByteArrayOutputStream();
                    if (contentMode.equals("")) {
                        finalBitmap.compress(CompressFormat.JPEG, 100, baos);
                    } else {
                        scaledBitmap.compress(CompressFormat.JPEG, 100, baos);
                    }
                    contents = baos.toByteArray();
                    if (scaledBitmap != null) {
                        scaledBitmap.recycle();
                    }
                    if (finalBitmap != null) {
                        finalBitmap.recycle();
                    }
                    if (baos != null) {
                        baos.close();
                    }
                }
                return contents;
            } catch (Throwable th5) {
                th = th5;
                fis22 = fis2;
                fis = fis3;
                if (fis != null) {
                    fis.close();
                }
                if (fis22 != null) {
                    fis22.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e10) {
            if (fis != null) {
                fis.close();
            }
            if (fis22 != null) {
                fis22.close();
            }
            contents = null;
            if (scaledBitmap != null) {
                finalBitmap = resizeImage(scaledBitmap, contentMode, w, h, 1);
                byteArrayOutputStream = null;
                baos = new ByteArrayOutputStream();
                if (contentMode.equals("")) {
                    finalBitmap.compress(CompressFormat.JPEG, 100, baos);
                } else {
                    scaledBitmap.compress(CompressFormat.JPEG, 100, baos);
                }
                contents = baos.toByteArray();
                if (scaledBitmap != null) {
                    scaledBitmap.recycle();
                }
                if (finalBitmap != null) {
                    finalBitmap.recycle();
                }
                if (baos != null) {
                    baos.close();
                }
            }
            return contents;
        } catch (Throwable th6) {
            th = th6;
            if (fis != null) {
                fis.close();
            }
            if (fis22 != null) {
                fis22.close();
            }
            throw th;
        }
        contents = null;
        if (scaledBitmap != null) {
            finalBitmap = resizeImage(scaledBitmap, contentMode, w, h, 1);
            byteArrayOutputStream = null;
            baos = new ByteArrayOutputStream();
            if (contentMode.equals("")) {
                scaledBitmap.compress(CompressFormat.JPEG, 100, baos);
            } else {
                finalBitmap.compress(CompressFormat.JPEG, 100, baos);
            }
            contents = baos.toByteArray();
            if (scaledBitmap != null) {
                scaledBitmap.recycle();
            }
            if (finalBitmap != null) {
                finalBitmap.recycle();
            }
            if (baos != null) {
                baos.close();
            }
        }
        return contents;
    }

    public synchronized MMJSResponse getPicture(HashMap arguments) {
        MMJSResponse responseWithError;
        Context context = (Context) this.contextRef.get();
        String type = (String) arguments.get("sourceType");
        String height = (String) arguments.get("constrainHeight");
        String width = (String) arguments.get("constrainWidth");
        String contentMode = (String) arguments.get("contentMode");
        if (contentMode == null) {
            contentMode = "";
        }
        if (height == null || width == null) {
            responseWithError = MMJSResponse.responseWithError("Missing constrainHeight and/or constrainWidth");
        } else {
            int h = (int) Float.parseFloat(height);
            int w = (int) Float.parseFloat(width);
            if (h * w > 360000) {
                responseWithError = MMJSResponse.responseWithError("constrainHeight * constrainWidth > 360000");
            } else {
                if (!(context == null || type == null)) {
                    File file = new File(AdCache.getCacheDirectory(context), "tmp_mm_" + String.valueOf(System.currentTimeMillis()) + ".jpg");
                    if ((type.equalsIgnoreCase("Camera") && isCameraAvailable()) || ((type.equalsIgnoreCase("Photo Library") || type.equalsIgnoreCase("PhotoLibrary")) && isPictureChooserAvailable())) {
                        try {
                            pickerActivityObject = new Object();
                            synchronized (pickerActivityObject) {
                                IntentUtils.startPickerActivity(context, file, type);
                                pickerActivityObject.wait();
                            }
                            pickerActivityObject = null;
                        } catch (Exception e) {
                            try {
                                e.printStackTrace();
                                pickerActivityObject = null;
                            } catch (Throwable th) {
                                pickerActivityObject = null;
                            }
                        }
                        if (file != null && file.exists() && file.length() > 0) {
                            byte[] contents = scaleBitmapToBytes(file, w, h, contentMode);
                            file.delete();
                            if (contents != null) {
                                responseWithError = new MMJSResponse();
                                responseWithError.result = 1;
                                responseWithError.dataResponse = contents;
                            }
                        }
                    }
                }
                responseWithError = null;
            }
        }
        return responseWithError;
    }

    public synchronized MMJSResponse writeToPhotoLibrary(HashMap arguments) {
        MMJSResponse responseWithError;
        Context context = (Context) this.contextRef.get();
        Uri path = Uri.parse((String) arguments.get(PATH));
        File dest = new File(AdCache.getCacheDirectory(context).getAbsolutePath() + File.separator + PICTURES + File.separator + path.getLastPathSegment());
        String scheme = path.getScheme();
        if (scheme != null && scheme.equals("http")) {
            arguments.put(PlusShare.KEY_CALL_TO_ACTION_URL, path.toString());
            arguments.put(PATH, path.getLastPathSegment());
            BridgeMMFileManager fileManager = new BridgeMMFileManager();
            fileManager.setContext(context);
            if (fileManager.downloadFile(arguments) == null) {
                responseWithError = MMJSResponse.responseWithError("Failed to download");
            }
        }
        File source = AdCache.getDownloadFile(context, path.getLastPathSegment());
        if (source.exists()) {
            scanMedia(moveFile(source, dest) ? dest.getAbsolutePath() : source.getAbsolutePath());
            if (AdCache.isExternalMounted()) {
                responseWithError = MMJSResponse.responseWithSuccess("Image saved to photo library");
            } else {
                responseWithError = MMJSResponse.responseWithError("Storage not mounted, cannot add image to photo library photo library");
            }
        } else {
            responseWithError = MMJSResponse.responseWithError("No file at " + source.getAbsolutePath());
        }
        return responseWithError;
    }

    private boolean moveFile(File source, File dest) {
        try {
            FileChannel inChannel = new FileInputStream(source).getChannel();
            File dir = dest.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            dest.createNewFile();
            inChannel.transferTo(0, inChannel.size(), new FileOutputStream(dest).getChannel());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void scanMedia(String path) {
        Context context = (Context) this.contextRef.get();
        if (context != null) {
            this.mediaScanner = new MediaScannerConnection(context.getApplicationContext(), new C24551(path));
            if (this.mediaScanner != null) {
                this.mediaScanner.connect();
            }
        }
    }

    public MMJSResponse playVideo(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String path = (String) arguments.get(PATH);
        if (!(context == null || path == null)) {
            if (path.startsWith("http")) {
                IntentUtils.startVideoPlayerActivityWithData(context, path);
                return MMJSResponse.responseWithSuccess(path);
            }
            File file = AdCache.getDownloadFile(context, path);
            if (file.exists()) {
                IntentUtils.startVideoPlayerActivityWithData(context, file);
                return MMJSResponse.responseWithSuccess(file.getName());
            }
        }
        return null;
    }

    public MMJSResponse playAudio(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String path = (String) arguments.get(PATH);
        if (context == null || path == null) {
            return null;
        }
        Audio audio = Audio.sharedAudio(context);
        if (audio == null) {
            return null;
        }
        if (audio.isPlaying()) {
            return MMJSResponse.responseWithError("Audio already playing.");
        }
        if (path.startsWith("http")) {
            return audio.playAudio(Uri.parse(path), Boolean.parseBoolean((String) arguments.get("repeat")));
        }
        File file = AdCache.getDownloadFile(context, path);
        if (file.exists()) {
            return audio.playAudio(Uri.fromFile(file), Boolean.parseBoolean((String) arguments.get("repeat")));
        }
        return null;
    }

    public MMJSResponse playSound(HashMap arguments) {
        if (this.contextRef == null) {
            return null;
        }
        Context context = (Context) this.contextRef.get();
        String path = (String) arguments.get(PATH);
        if (!(context == null || path == null)) {
            File file = AdCache.getDownloadFile(context, path);
            if (file.exists()) {
                Audio audio = Audio.sharedAudio((Context) this.contextRef.get());
                if (audio != null) {
                    return audio.playSound(file);
                }
            }
        }
        return null;
    }

    public MMJSResponse stopAudio(HashMap arguments) {
        if (this.contextRef != null) {
            Audio audio = Audio.sharedAudio((Context) this.contextRef.get());
            if (audio != null) {
                return audio.stop();
            }
        }
        return null;
    }

    public MMJSResponse getDeviceVolume(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return MMJSResponse.responseWithError("no volume available");
        }
        int volume = MMSDK.getMediaVolume(context);
        MMJSResponse response = MMJSResponse.responseWithSuccess();
        response.response = Integer.valueOf(volume);
        return response;
    }
}
