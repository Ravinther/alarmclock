package com.millennialmedia.android;

import android.text.TextUtils;
import com.mopub.mobileads.CustomEventBannerAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class HttpGetRequest {
    private HttpClient client;
    private HttpGet getRequest;

    /* renamed from: com.millennialmedia.android.HttpGetRequest.1 */
    static class C24711 implements Runnable {
        final /* synthetic */ String[] val$urls;

        C24711(String[] strArr) {
            this.val$urls = strArr;
        }

        public void run() {
            for (String url : this.val$urls) {
                Log.m9724v("Logging event to: %s", url);
                try {
                    new HttpGetRequest().get(arr$[i$]);
                } catch (Exception e) {
                    Log.m9723v(e.getMessage());
                }
            }
        }
    }

    HttpGetRequest() {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(params, CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
        this.client = new DefaultHttpClient(params);
        this.getRequest = new HttpGet();
    }

    HttpGetRequest(int timeout) {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(params, CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
        HttpConnectionParams.setSoTimeout(params, timeout);
        this.client = new DefaultHttpClient(params);
        this.getRequest = new HttpGet();
    }

    HttpResponse get(String url) {
        HttpResponse response = null;
        if (!TextUtils.isEmpty(url)) {
            try {
                this.getRequest.setURI(new URI(url));
                response = this.client.execute(this.getRequest);
            } catch (OutOfMemoryError e) {
                Log.m9714e("Out of memory!");
                return null;
            } catch (Exception ex) {
                if (ex == null) {
                    return null;
                }
                Log.m9714e("Error connecting:" + ex.getMessage());
                return null;
            }
        }
        return response;
    }

    void trackConversion(String goalId, boolean isFirstLaunch, long installTime, TreeMap extraParams) {
        try {
            StringBuilder urlBuilder = new StringBuilder("http://cvt.mydas.mobi/handleConversion?firstlaunch=" + (isFirstLaunch ? 1 : 0));
            if (goalId != null) {
                urlBuilder.append("&goalId=" + goalId);
            }
            if (installTime > 0) {
                urlBuilder.append("&installtime=" + (installTime / 1000));
            }
            if (extraParams != null) {
                for (Entry entry : extraParams.entrySet()) {
                    urlBuilder.append(String.format("&%s=%s", new Object[]{entry.getKey(), URLEncoder.encode((String) entry.getValue(), "UTF-8")}));
                }
            }
            Log.m9712d("Sending conversion tracker report: %s", urlBuilder.toString());
            this.getRequest.setURI(new URI(url));
            if (this.client.execute(this.getRequest).getStatusLine().getStatusCode() == 200) {
                Log.m9724v("Successful conversion tracking event: %d", Integer.valueOf(this.client.execute(this.getRequest).getStatusLine().getStatusCode()));
            } else {
                Log.m9715e("Conversion tracking error: %d", Integer.valueOf(this.client.execute(this.getRequest).getStatusLine().getStatusCode()));
            }
        } catch (IOException e) {
            Log.m9715e("Conversion tracking error: %s", e.getMessage());
        }
    }

    static String convertStreamToString(InputStream is) {
        Throwable e;
        Throwable th;
        BufferedReader bufferedReader = null;
        if (is == null) {
            throw new IOException("Stream is null.");
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is), 4096);
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line + "\n");
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Throwable e2) {
                        Log.m9713d(e2);
                    }
                }
                return sb.toString();
            } catch (OutOfMemoryError e3) {
                e2 = e3;
                bufferedReader = reader;
                try {
                    Log.m9713d(e2);
                    throw new IOException("Out of memory.");
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e22) {
                            Log.m9713d(e22);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = reader;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (OutOfMemoryError e4) {
            e22 = e4;
            Log.m9713d(e22);
            throw new IOException("Out of memory.");
        }
    }

    static void log(String[] urls) {
        if (urls != null && urls.length > 0) {
            ThreadUtils.execute(new C24711(urls));
        }
    }
}
