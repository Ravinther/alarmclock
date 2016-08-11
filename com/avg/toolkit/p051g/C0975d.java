package com.avg.toolkit.p051g;

import android.content.Context;
import com.avg.toolkit.license.C1017a;
import com.avg.toolkit.license.C1019b;
import com.avg.toolkit.p034b.C0954c;
import com.avg.toolkit.zen.C1050e;
import com.avg.toolkit.zen.p054a.C1038d.C1037b;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

/* renamed from: com.avg.toolkit.g.d */
public class C0975d {
    private String f2931a;
    private String f2932b;
    private Context f2933c;

    public C0975d(Context appContext, String encodedT, String sourceID) {
        this.f2933c = appContext.getApplicationContext();
        this.f2931a = encodedT;
        this.f2932b = sourceID;
    }

    public HttpResponse m4340a(String transactionId, String sellableId, String purchaseToken) {
        String url = C0975d.m4338c() + C1050e.m4559j(this.f2933c) + "/google-order";
        StringEntity entity = null;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("transactionId", transactionId);
            jsonObject.put("productId", sellableId);
            jsonObject.put("packageName", this.f2933c.getPackageName());
            jsonObject.put("purchaseToken", purchaseToken);
            entity = new StringEntity(jsonObject.toString(), "UTF-8");
        } catch (Exception e) {
        }
        return C0954c.m4285a(this.f2933c, url, C1037b.POST, entity, m4336a(), "newInAppBillingPurchase");
    }

    public HttpResponse m4341a(String userName, String password, boolean register) {
        String url = C0975d.m4338c() + (register ? "create" : "auth");
        StringEntity entity = null;
        try {
            String lang = Locale.getDefault().getLanguage();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("login", userName);
            jsonObject.put("password", password);
            if (register) {
                jsonObject.put("sourceId", this.f2932b);
                jsonObject.put("lang", lang);
            }
            entity = new StringEntity(jsonObject.toString(), "UTF-8");
        } catch (Exception e) {
        }
        return C0954c.m4285a(this.f2933c, url, C1037b.POST, entity, m4336a(), "UACreateRequest");
    }

    public HttpResponse m4339a(String authToken) {
        String url = C0975d.m4338c() + "auth";
        StringEntity entity = null;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("authToken", authToken);
            entity = new StringEntity(jsonObject.toString(), "UTF-8");
        } catch (Exception e) {
        }
        return C0954c.m4285a(this.f2933c, url, C1037b.POST, entity, m4336a(), "UAAuthRequest");
    }

    private Header[] m4336a() {
        return new Header[]{new BasicHeader(MraidCommandStorePicture.MIME_TYPE_HEADER, "application/json"), new BasicHeader("X-AVG-Authorization", "token=\"" + this.f2931a + "\" version=\"1.0\"")};
    }

    private static String m4337b() {
        C1017a avgFeatures = C1019b.m4431a();
        if (avgFeatures == null || !avgFeatures.m4429d()) {
            return "ua-cloud.avg.com/";
        }
        return "ua-cloud-beta.avg.com/";
    }

    private static String m4338c() {
        return "https://" + C0975d.m4337b() + "v1/account/";
    }
}
