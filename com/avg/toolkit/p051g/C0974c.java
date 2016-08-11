package com.avg.toolkit.p051g;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p034b.C0950a.C0949c;
import org.apache.http.HttpResponse;

/* renamed from: com.avg.toolkit.g.c */
public class C0974c extends C0972a {
    public int getMessageId() {
        return 35001;
    }

    public C0949c getPriority() {
        return C0949c.REGULAR;
    }

    public boolean useDailyRun() {
        return true;
    }

    public boolean handleDailyRun(Context context) {
        return load(context);
    }

    public boolean load(Context context) {
        if (!C0979g.m4355h(context)) {
            return false;
        }
        String productId = C0979g.m4349c(context);
        String transactionId = C0979g.m4347b(context);
        String purchaseToken = C0979g.m4351d(context);
        if (!C0974c.m4335a(transactionId, productId, purchaseToken)) {
            return false;
        }
        this.b = new Bundle();
        this.b.putString("product_id", productId);
        this.b.putString("transaction_id", transactionId);
        this.b.putString("purchase_token", purchaseToken);
        return true;
    }

    public boolean prepare(Context context) {
        C0975d commManager = new C0975d(context, C0977e.f2939a, C0977e.f2940b);
        String productId = this.b.getString("product_id");
        String transactionId = this.b.getString("transaction_id");
        String purchaseToken = this.b.getString("purchase_token");
        if (!C0974c.m4335a(transactionId, productId, purchaseToken)) {
            return true;
        }
        HttpResponse response = commManager.m4340a(transactionId, productId, purchaseToken);
        if (response == null || response.getStatusLine().getStatusCode() != 200) {
            return false;
        }
        C0979g.m4352e(context);
        return true;
    }

    public static void m4333a(Context appContext) {
        if (C0979g.m4355h(appContext)) {
            String productId = C0979g.m4349c(appContext);
            String transactionId = C0979g.m4347b(appContext);
            String purchaseToken = C0979g.m4351d(appContext);
            if (C0974c.m4335a(transactionId, productId, purchaseToken)) {
                C0974c.m4334a(appContext, null, transactionId, productId, purchaseToken);
            }
        }
    }

    private static void m4334a(Context appContext, Handler callbackHandler, String transactionID, String productID, String purchaseToken) {
        Bundle bundle = new Bundle();
        bundle.putString("transaction_id", transactionID);
        bundle.putString("product_id", productID);
        bundle.putString("purchase_token", purchaseToken);
        if (callbackHandler != null) {
            bundle.putParcelable("messenger", new Messenger(callbackHandler));
        }
        ITKSvc.Do(appContext, 4000, 35001, bundle);
    }

    private static boolean m4335a(String transactionID, String productID, String purchaseToken) {
        if ("".equals(transactionID) || "".equals(productID) || "".equals(purchaseToken)) {
            return false;
        }
        return true;
    }
}
