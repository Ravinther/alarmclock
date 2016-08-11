package com.avg.toolkit.p035c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.plus.PlusShare;

/* renamed from: com.avg.toolkit.c.b */
public abstract class C0740b extends BroadcastReceiver {
    protected abstract void m3465a(Context context);

    protected abstract void m3467b(Context context);

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("inAppIntentFilterScreen")) {
            m3467b(context);
            if (intent.getBooleanExtra("result", false)) {
                m3466a(context, intent.getStringExtra(PlusShare.KEY_CALL_TO_ACTION_URL));
            } else {
                m3465a(context);
            }
        }
    }

    protected void m3466a(Context context, String url) {
        Uri uri = Uri.parse(url);
        Intent browserIntent = new Intent("android.intent.action.VIEW");
        browserIntent.setData(uri);
        browserIntent.setAction("android.intent.action.VIEW");
        context.startActivity(browserIntent);
    }
}
