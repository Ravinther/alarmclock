package com.avg.toolkit.p034b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.avg.toolkit.crashReport.CrashReport;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p047a.C0905a;
import com.avg.toolkit.p047a.C0905a.C0903b;
import com.avg.toolkit.uid.UUID;
import com.avg.toolkit.zen.p054a.C1038d.C1037b;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.util.Base64;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

/* renamed from: com.avg.toolkit.b.c */
public class C0954c {

    /* renamed from: com.avg.toolkit.b.c.1 */
    static /* synthetic */ class C09531 {
        static final /* synthetic */ int[] f2885a;

        static {
            f2885a = new int[C1037b.values().length];
            try {
                f2885a[C1037b.POST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2885a[C1037b.PUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2885a[C1037b.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2885a[C1037b.GET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static HttpResponse m4285a(Context appContext, String url, C1037b method, AbstractHttpEntity entity, Header[] headers, String trigger) {
        HttpParams httpParameters = new BasicHttpParams();
        HttpProtocolParams.setUseExpectContinue(httpParameters, false);
        HttpConnectionParams.setConnectionTimeout(httpParameters, CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY);
        HttpConnectionParams.setSoTimeout(httpParameters, CrashReport.FEATURE_ID);
        HttpClient client = new DefaultHttpClient(httpParameters);
        HttpRequestBase httpRequest = null;
        switch (C09531.f2885a[method.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                httpRequest = new HttpPost(url);
                if (entity != null) {
                    ((HttpPost) httpRequest).setEntity(entity);
                    break;
                }
                break;
            case Base64.NO_WRAP /*2*/:
                httpRequest = new HttpPut(url);
                if (entity != null) {
                    ((HttpPut) httpRequest).setEntity(entity);
                    break;
                }
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                httpRequest = new HttpDelete(url);
                break;
            case Base64.CRLF /*4*/:
                httpRequest = new HttpGet(url);
                break;
        }
        if (headers != null) {
            String userAgent = C0954c.m4284a(appContext, trigger);
            if (userAgent != null) {
                Header[] tmpHeaders = new Header[(headers.length + 1)];
                for (int i = 0; i < headers.length; i++) {
                    tmpHeaders[i] = headers[i];
                }
                tmpHeaders[tmpHeaders.length - 1] = new BasicHeader("User-Agent", userAgent);
                headers = tmpHeaders;
            }
            httpRequest.setHeaders(headers);
        }
        httpRequest.setHeader("Connection", "close");
        try {
            return client.execute(httpRequest);
        } catch (Exception e) {
            return null;
        }
    }

    private static String m4284a(Context context, String trigger) {
        try {
            context.getPackageName();
            PackageInfo pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String appVersion = pi.versionName;
            String appVersionRevision = "" + pi.versionCode;
            C1017a features = C1019b.m4431a();
            C0903b productIDAndServer = C0905a.m4154a();
            String productId = productIDAndServer != null ? String.valueOf(productIDAndServer.m4151a()) : "";
            String vendorId = "" + features.f3120f;
            String uuid = new UUID(context).getUUID();
            if (uuid == null) {
                uuid = "NA";
            }
            return String.format("Mozilla/5.0 (Linux; U; Android %s; en-us; %s) pid/%s vc/%s (KHTML, like Gecko) Version/%s.%s UUID %s trigger %s", new Object[]{VERSION.RELEASE, Build.DEVICE, productId, vendorId, appVersion, appVersionRevision, uuid, trigger});
        } catch (Exception e) {
            return null;
        }
    }
}
