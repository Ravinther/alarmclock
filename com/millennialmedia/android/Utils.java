package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.drive.DriveFile;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

class Utils {

    static class HttpUtils {

        /* renamed from: com.millennialmedia.android.Utils.HttpUtils.1 */
        static class C25141 implements Runnable {
            final /* synthetic */ String val$url;

            C25141(String str) {
                this.val$url = str;
            }

            public void run() {
                try {
                    HttpResponse request = new DefaultHttpClient().execute(new HttpGet(this.val$url));
                    Log.m9711d("Executed Url :\"" + this.val$url + "\"");
                } catch (Throwable e) {
                    Log.m9716e(e);
                }
            }
        }

        HttpUtils() {
        }

        static void executeUrl(String url) {
            ThreadUtils.execute(new C25141(url));
        }
    }

    static class IntentUtils {
        IntentUtils() {
        }

        static void startVideoPlayerActivityWithData(Context context, String data) {
            startVideoPlayerActivityWithData(context, Uri.parse(data));
        }

        static void startVideoPlayerActivityWithData(Context context, File file) {
            startVideoPlayerActivityWithData(context, Uri.fromFile(file));
        }

        static void startVideoPlayerActivityWithData(Context context, Uri dataUri) {
            Intent intent = new Intent(context, MMActivity.class);
            intent.setData(dataUri);
            intent.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
            startActivity(context, intent);
        }

        static void startPickerActivity(Context context, File file, String type) {
            Intent intent = new Intent(context, MMActivity.class);
            intent.setData(Uri.fromFile(file));
            intent.putExtra("type", type);
            intent.putExtra("class", "com.millennialmedia.android.BridgeMMMedia$PickerActivity");
            startActivity(context, intent);
        }

        static void startAdViewOverlayActivityWithData(Context context, String url) {
            Intent intent = new Intent(context, MMActivity.class);
            intent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
            intent.setData(Uri.parse(url));
            startActivity(context, intent);
        }

        static void startAdViewOverlayActivity(Context context, Intent extrasAddedIntent) {
            extrasAddedIntent.setClass(context, MMActivity.class);
            extrasAddedIntent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
            startActivity(context, extrasAddedIntent);
        }

        static void startAdViewOverlayActivity(Context context) {
            Intent intent = new Intent(context, MMActivity.class);
            intent.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
            startActivity(context, intent);
        }

        static void startCachedVideoPlayerActivity(Context context, Intent extrasAddedIntent) {
            extrasAddedIntent.setClass(context, MMActivity.class);
            extrasAddedIntent.putExtra("class", "com.millennialmedia.android.CachedVideoPlayerActivity");
            startActivity(context, extrasAddedIntent);
        }

        static void startActionView(Context context, String nextUrl) {
            startActivity(context, new Intent("android.intent.action.VIEW", Uri.parse(nextUrl)));
        }

        static void startActivity(Context context, Intent intent) {
            if (!(context instanceof Activity)) {
                intent.addFlags(DriveFile.MODE_READ_ONLY);
            }
            fixDataAndTypeForVideo(context, intent);
            context.startActivity(intent);
        }

        private static void fixDataAndTypeForVideo(Context context, Intent intent) {
            Uri data = intent.getData();
            if (data != null) {
                String lastPathSegment = data.getLastPathSegment();
                if (TextUtils.isEmpty(intent.getStringExtra("class")) && !TextUtils.isEmpty(lastPathSegment)) {
                    if (lastPathSegment.endsWith(".mp4") || lastPathSegment.endsWith(".3gp") || lastPathSegment.endsWith(".mkv") || lastPathSegment.endsWith("content.once")) {
                        intent.setDataAndType(intent.getData(), "video/*");
                    }
                }
            }
        }

        static Intent getIntentForUri(RedirectionListenerImpl listener) {
            if (listener == null) {
                return null;
            }
            Intent intent = null;
            Uri destinationUri = listener.destinationUri;
            Context context = (Context) listener.weakContext.get();
            if (context == null) {
                return null;
            }
            if (destinationUri != null) {
                String scheme = destinationUri.getScheme();
                if (scheme != null) {
                    if (scheme.equalsIgnoreCase(Event.INTENT_MARKET)) {
                        Log.m9723v("Creating Android Market intent.");
                        intent = new Intent("android.intent.action.VIEW", destinationUri);
                        Event.intentStarted(context, Event.INTENT_MARKET, listener.creatorAdImplInternalId);
                    } else if (scheme.equalsIgnoreCase("rtsp")) {
                        Log.m9723v("Creating streaming video player intent.");
                        intent = new Intent(context, MMActivity.class);
                        intent.setData(destinationUri);
                        intent.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
                    } else if (scheme.equalsIgnoreCase(Event.INTENT_PHONE_CALL)) {
                        Log.m9723v("Creating telephone intent.");
                        intent = new Intent("android.intent.action.DIAL", destinationUri);
                        Event.intentStarted(context, Event.INTENT_PHONE_CALL, listener.creatorAdImplInternalId);
                    } else if (scheme.equalsIgnoreCase(Event.INTENT_TXT_MESSAGE)) {
                        Log.m9723v("Creating txt message intent.");
                        intent = new Intent("android.intent.action.VIEW");
                        String address = destinationUri.getSchemeSpecificPart();
                        int bodyIndex = address.indexOf("?body=");
                        if (bodyIndex != -1) {
                            address = address.substring(0, bodyIndex);
                        }
                        intent.putExtra("address", address.replace(',', ';'));
                        if (bodyIndex != -1) {
                            intent.putExtra("sms_body", destinationUri.getSchemeSpecificPart().substring(bodyIndex + 6));
                        }
                        intent.setType("vnd.android-dir/mms-sms");
                        Event.intentStarted(context, Event.INTENT_TXT_MESSAGE, listener.creatorAdImplInternalId);
                    } else if (scheme.equalsIgnoreCase("mailto")) {
                        intent = new Intent("android.intent.action.VIEW", destinationUri);
                        Event.intentStarted(context, Event.INTENT_EMAIL, listener.creatorAdImplInternalId);
                    } else if (scheme.equalsIgnoreCase(Event.INTENT_MAPS)) {
                        Log.m9723v("Creating Google Maps intent.");
                        intent = new Intent("android.intent.action.VIEW", destinationUri);
                        Event.intentStarted(context, Event.INTENT_MAPS, listener.creatorAdImplInternalId);
                    } else if (scheme.equalsIgnoreCase("https")) {
                        Log.m9723v("Creating launch browser intent.");
                        intent = new Intent("android.intent.action.VIEW", destinationUri);
                        Event.intentStarted(context, Event.INTENT_EXTERNAL_BROWSER, listener.creatorAdImplInternalId);
                    } else if (scheme.equalsIgnoreCase("mmbrowser")) {
                        String mmBrowserUrl = destinationUri.toString().substring(12);
                        if (!(mmBrowserUrl == null || mmBrowserUrl.contains("://"))) {
                            mmBrowserUrl = mmBrowserUrl.replaceFirst("//", "://");
                        }
                        Log.m9723v("MMBrowser - Creating launch browser intent.");
                        intent = new Intent("android.intent.action.VIEW", Uri.parse(mmBrowserUrl));
                        Event.intentStarted(context, Event.INTENT_EXTERNAL_BROWSER, listener.creatorAdImplInternalId);
                    } else if (!scheme.equalsIgnoreCase("http")) {
                        Log.m9724v("Creating intent for unrecognized URI. %s", destinationUri);
                        intent = new Intent("android.intent.action.VIEW", destinationUri);
                    } else if (destinationUri.getLastPathSegment() != null && (destinationUri.getLastPathSegment().endsWith(".mp4") || destinationUri.getLastPathSegment().endsWith(".3gp"))) {
                        Log.m9723v("Creating video player intent.");
                        intent = new Intent(context, MMActivity.class);
                        intent.setData(destinationUri);
                        intent.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
                        Event.intentStarted(context, Event.INTENT_STREAMING_VIDEO, listener.creatorAdImplInternalId);
                    } else if (listener.canOpenOverlay()) {
                        Log.m9723v("Creating launch overlay intent.");
                        intent = new Intent(context, MMActivity.class);
                        intent.putExtra("class", AdViewOverlayActivity.class.getCanonicalName());
                        intent.setData(destinationUri);
                        return intent;
                    } else {
                        Log.m9723v("Creating launch browser intent.");
                        Event.intentStarted(context, Event.INTENT_EXTERNAL_BROWSER, listener.creatorAdImplInternalId);
                        intent = new Intent("android.intent.action.VIEW", destinationUri);
                    }
                }
            }
            if (intent != null) {
                Log.m9724v("%s resolved to Intent: %s", destinationUri, intent);
                return intent;
            }
            Log.m9724v("%s", destinationUri);
            return intent;
        }
    }

    static class ThreadUtils {
        private static final ExecutorService cachedThreadExecutor;

        ThreadUtils() {
        }

        static {
            cachedThreadExecutor = Executors.newCachedThreadPool();
        }

        static void execute(Runnable runnable) {
            cachedThreadExecutor.execute(runnable);
        }
    }

    Utils() {
    }
}
