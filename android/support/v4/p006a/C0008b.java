package android.support.v4.p006a;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;

/* renamed from: android.support.v4.a.b */
public class C0008b {
    public static boolean m97a(Context context, Intent[] intents) {
        return C0008b.m98a(context, intents, null);
    }

    public static boolean m98a(Context context, Intent[] intents, Bundle options) {
        int version = VERSION.SDK_INT;
        if (version >= 16) {
            C0011e.m101a(context, intents, options);
            return true;
        } else if (version < 11) {
            return false;
        } else {
            C0010d.m100a(context, intents);
            return true;
        }
    }

    public static final Drawable m96a(Context context, int id) {
        if (VERSION.SDK_INT >= 21) {
            return C0009c.m99a(context, id);
        }
        return context.getResources().getDrawable(id);
    }
}
