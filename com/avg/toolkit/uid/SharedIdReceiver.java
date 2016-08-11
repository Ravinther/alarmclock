package com.avg.toolkit.uid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avg.toolkit.ITKSvc;

public class SharedIdReceiver extends BroadcastReceiver {
    public static final String ACTION_SEND_YOUR_ID = "com.avg.action.send_your_id";
    public static final String ACTION_TAKE_ID = "com.avg.action.take_id";
    public static final String EXTRA_IS_FROM_ALARM = "com.avg.extra.is_from_alarm";
    public static final String EXTRA_KEY_MY_ID = "com.avg.extra.key.myid";
    public static final String EXTRA_KEY_WHOAMI = "com.avg.extra.key.whoami";

    public void onReceive(Context context, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString(ITKSvc.c_actionData, intent.getAction());
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            if (intentExtras.containsKey(EXTRA_IS_FROM_ALARM)) {
                bundle.putBoolean(EXTRA_IS_FROM_ALARM, intentExtras.getBoolean(EXTRA_IS_FROM_ALARM));
            }
            bundle.putString(EXTRA_KEY_WHOAMI, intentExtras.getString(EXTRA_KEY_WHOAMI));
            bundle.putString(EXTRA_KEY_MY_ID, intentExtras.getString(EXTRA_KEY_MY_ID));
        }
        ITKSvc.Do(context, 19000, 19001, bundle);
    }
}
