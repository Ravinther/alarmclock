package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mopub.mobileads.CustomEventBannerAdapter;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.json.JSONObject;

final class HttpRedirection {
    private static final String HEADER_LOCATION = "Location";
    private static final String HTTPS = "https";
    private static final String LOG_URL_FORMAT = "Redirecting to: %s";
    private static final String METHOD_GET = "GET";

    private interface Listener {
        boolean canOpenOverlay();

        OverlaySettings getOverlaySettings();

        boolean isActivityStartable(Uri uri);

        boolean isExpandingToUrl();

        boolean isHandlingMMVideo(Uri uri);

        void startingActivity(Uri uri);

        void startingVideo();

        void updateLastVideoViewedTime();
    }

    static class RedirectionListenerImpl implements Listener {
        long creatorAdImplInternalId;
        Uri destinationUri;
        String orientation;
        String url;
        WeakReference weakContext;

        public OverlaySettings getOverlaySettings() {
            return null;
        }

        public boolean isHandlingMMVideo(Uri uri) {
            return false;
        }

        public void updateLastVideoViewedTime() {
        }

        public void startingActivity(Uri destinationUri) {
            Log.m9712d("Starting activity for %s", destinationUri);
        }

        public boolean isActivityStartable(Uri uri) {
            return true;
        }

        public void startingVideo() {
        }

        public boolean canOpenOverlay() {
            return false;
        }

        public boolean isExpandingToUrl() {
            return false;
        }

        public JSONObject getAdProperties() {
            return null;
        }
    }

    /* renamed from: com.millennialmedia.android.HttpRedirection.1 */
    static class C24731 implements Runnable {
        final /* synthetic */ WeakReference val$listenerReference;

        C24731(WeakReference weakReference) {
            this.val$listenerReference = weakReference;
        }

        public void run() {
            RedirectionListenerImpl listener = (RedirectionListenerImpl) this.val$listenerReference.get();
            if (listener != null) {
                String destination = HttpRedirection.navigateRedirects(listener.url);
                if (destination != null) {
                    listener.destinationUri = Uri.parse(destination);
                    if (listener.destinationUri != null) {
                        handleDestinationUri(listener);
                        return;
                    }
                    Log.m9724v("Could not start activity for %s", destination);
                }
            }
        }

        private void handleDestinationUri(RedirectionListenerImpl listener) {
            Intent intent = null;
            Context context = (Context) listener.weakContext.get();
            if (context != null) {
                String scheme = listener.destinationUri.getScheme();
                if (scheme != null) {
                    if (!scheme.equalsIgnoreCase("mmvideo")) {
                        intent = IntentUtils.getIntentForUri(listener);
                    } else if (!listener.isHandlingMMVideo(listener.destinationUri)) {
                        VideoAd.playAd(context, listener.destinationUri.getHost(), listener);
                    }
                }
                if (intent != null) {
                    OverlaySettings settings = listener.getOverlaySettings();
                    if (!(intent == null || settings == null)) {
                        if (listener.orientation != null) {
                            settings.orientation = listener.orientation;
                        }
                        intent.putExtra("settings", settings);
                    }
                    String clazz = intent.getStringExtra("class");
                    if (clazz == null || !clazz.equals(AdViewOverlayActivity.class.getCanonicalName())) {
                        try {
                            if (listener.isActivityStartable(listener.destinationUri)) {
                                IntentUtils.startActivity(context, intent);
                                listener.startingActivity(listener.destinationUri);
                            }
                        } catch (ActivityNotFoundException e) {
                            Log.m9715e("No activity found for %s", listener.destinationUri);
                        }
                    }
                }
            }
        }
    }

    HttpRedirection() {
    }

    static final String navigateRedirects(String urlString) {
        if (urlString == null) {
            return null;
        }
        HttpURLConnection.setFollowRedirects(false);
        while (!urlString.startsWith(HTTPS)) {
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
                conn.setRequestMethod(METHOD_GET);
                conn.connect();
                int rc = conn.getResponseCode();
                if (rc < 300 || rc >= 400) {
                    return urlString;
                }
                String locationUrl = conn.getHeaderField(HEADER_LOCATION);
                URI locationUri = new URI(locationUrl);
                if (!locationUri.isAbsolute()) {
                    urlString = url.toURI().resolve(locationUri).toString();
                } else if (locationUrl != null) {
                    urlString = locationUrl;
                }
                Log.m9724v(LOG_URL_FORMAT, urlString);
            } catch (MalformedURLException e) {
                return urlString;
            } catch (SocketTimeoutException e2) {
                Log.m9711d("Connection timeout.");
                return urlString;
            } catch (IOException e3) {
                return urlString;
            } catch (URISyntaxException e4) {
                Log.m9711d("URI Syntax incorrect.");
                return urlString;
            }
        }
        return urlString;
    }

    static void startActivityFromUri(RedirectionListenerImpl listener) {
        if (listener != null && listener.url != null && listener.weakContext != null) {
            ThreadUtils.execute(new C24731(new WeakReference(listener)));
        }
    }
}
