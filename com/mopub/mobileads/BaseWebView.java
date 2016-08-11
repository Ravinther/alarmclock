package com.mopub.mobileads;

import android.content.Context;
import android.util.Log;
import android.webkit.WebView;
import com.mopub.common.util.VersionCode;
import com.mopub.common.util.Views;
import com.mopub.mobileads.util.WebViews;
import java.lang.reflect.Method;

public class BaseWebView extends WebView {
    protected boolean mIsDestroyed;

    public BaseWebView(Context context) {
        super(context.getApplicationContext());
        enablePlugins(false);
        WebViews.setDisableJSChromeClient(this);
    }

    protected void enablePlugins(boolean enabled) {
        if (!VersionCode.currentApiLevel().isAtLeast(VersionCode.JELLY_BEAN_MR2)) {
            if (VersionCode.currentApiLevel().isBelow(VersionCode.FROYO)) {
                try {
                    Class.forName("android.webkit.WebSettings").getDeclaredMethod("setPluginsEnabled", new Class[]{Boolean.TYPE}).invoke(getSettings(), new Object[]{Boolean.valueOf(enabled)});
                    return;
                } catch (Exception e) {
                    Log.d("MoPub", "Unable to " + (enabled ? "enable" : "disable") + "WebSettings plugins for BaseWebView.");
                    return;
                }
            }
            try {
                Method method = getSettings().getClass().getDeclaredMethod("setPluginState", new Class[]{Class.forName("android.webkit.WebSettings$PluginState")});
                Enum pluginState = Enum.valueOf(Class.forName("android.webkit.WebSettings$PluginState"), enabled ? "ON" : "OFF");
                method.invoke(getSettings(), new Object[]{pluginState});
            } catch (Exception e2) {
                Log.d("MoPub", "Unable to modify WebView plugin state.");
            }
        }
    }

    public void destroy() {
        this.mIsDestroyed = true;
        Views.removeFromParent(this);
        super.destroy();
    }

    @Deprecated
    void setIsDestroyed(boolean isDestroyed) {
        this.mIsDestroyed = isDestroyed;
    }
}
