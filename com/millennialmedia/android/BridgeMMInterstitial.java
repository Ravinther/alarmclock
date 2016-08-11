package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;

class BridgeMMInterstitial extends MMJSObject {
    BridgeMMInterstitial() {
    }

    public MMJSResponse show(HashMap arguments) {
        String url = (String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        Context context = (Context) this.contextRef.get();
        if (url == null || context == null) {
            return null;
        }
        IntentUtils.startAdViewOverlayActivityWithData(context, url);
        return MMJSResponse.responseWithSuccess();
    }

    public MMJSResponse close(HashMap arguments) {
        MMWebView mmWebView = (MMWebView) this.mmWebViewRef.get();
        if (mmWebView == null) {
            return null;
        }
        mmWebView.getMMLayout().closeAreaTouched();
        return MMJSResponse.responseWithSuccess();
    }

    public MMJSResponse open(HashMap arguments) {
        String url = (String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        Context context = (Context) this.contextRef.get();
        if (url == null || context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        Event.intentStarted(context, Event.INTENT_EXTERNAL_BROWSER, getAdImplId((String) arguments.get("PROPERTY_EXPANDING")));
        IntentUtils.startActivity(context, intent);
        return MMJSResponse.responseWithSuccess();
    }

    public MMJSResponse expandToExternalBrowser(HashMap arguments) {
        return open(arguments);
    }

    public MMJSResponse expandWithProperties(HashMap arguments) {
        String isBanner = (String) arguments.get("PROPERTY_BANNER_TYPE");
        if (isBanner != null && !Boolean.parseBoolean(isBanner)) {
            return MMJSResponse.responseWithError("Cannot expand a non banner ad");
        }
        String url = (String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        String transparent = (String) arguments.get("transparent");
        String useCustomClose = (String) arguments.get("useCustomClose");
        String transition = (String) arguments.get("transition");
        String orientation = (String) arguments.get(MMRequest.KEY_ORIENTATION);
        String transitionDuration = (String) arguments.get("transitionDuration");
        String height = (String) arguments.get(MMLayout.KEY_HEIGHT);
        String width = (String) arguments.get(MMLayout.KEY_WIDTH);
        String modal = (String) arguments.get("modal");
        String creatorAdImplId = (String) arguments.get("PROPERTY_EXPANDING");
        String allowOrientationChange = (String) arguments.get("allowOrientationChange");
        Context context = (Context) this.contextRef.get();
        if (context == null) {
            return null;
        }
        OverlaySettings settings = new OverlaySettings();
        if (url != null) {
            settings.urlToLoad = url;
        }
        if (creatorAdImplId != null) {
            settings.creatorAdImplId = (long) ((int) Float.parseFloat(creatorAdImplId));
        }
        if (transparent != null) {
            settings.setIsTransparent(Boolean.parseBoolean(transparent));
        }
        if (useCustomClose != null) {
            settings.setUseCustomClose(Boolean.parseBoolean(useCustomClose));
        }
        if (transition != null) {
            settings.setTransition(transition);
        }
        if (allowOrientationChange != null) {
            settings.allowOrientationChange = Boolean.parseBoolean(allowOrientationChange);
        }
        if (orientation == null) {
            orientation = (String) arguments.get("forceOrientation");
        }
        if (orientation != null) {
            settings.orientation = orientation;
        }
        if (height != null) {
            settings.height = (int) Float.parseFloat(height);
        }
        if (width != null) {
            settings.width = (int) Float.parseFloat(width);
        }
        if (modal != null) {
            settings.modal = Boolean.parseBoolean(modal);
        }
        if (transitionDuration != null) {
            try {
                settings.setTransitionDurationInMillis(Long.parseLong(transitionDuration) * 1000);
            } catch (Exception e) {
            }
        }
        IntentUtils.startAdViewOverlayActivity(context, getExpandExtrasIntent(url, settings));
        Event.overlayOpenedBroadCast(context, getAdImplId((String) arguments.get("PROPERTY_EXPANDING")));
        return MMJSResponse.responseWithSuccess();
    }

    private Intent getExpandExtrasIntent(String url, OverlaySettings settings) {
        Intent intent = new Intent();
        if (url != null) {
            intent.setData(Uri.parse(url));
        }
        intent.putExtra("settings", settings);
        intent.putExtra("internalId", settings.creatorAdImplId);
        return intent;
    }

    public MMJSResponse useCustomClose(HashMap arguments) {
        MMWebView mmWebView = (MMWebView) this.mmWebViewRef.get();
        String useCustomClose = (String) arguments.get("useCustomClose");
        if (!(useCustomClose == null || mmWebView == null)) {
            AdViewOverlayView overlayView = mmWebView.getAdViewOverlayView();
            if (overlayView != null) {
                overlayView.setUseCustomClose(Boolean.parseBoolean(useCustomClose));
                return MMJSResponse.responseWithSuccess();
            }
        }
        return null;
    }

    public MMJSResponse setOrientation(HashMap arguments) {
        MMJSResponse response = setForceOrientation(arguments);
        if (response == null || !isForcingOrientation(response)) {
            return setAllowOrientationChange(arguments);
        }
        return response;
    }

    private boolean isForcingOrientation(MMJSResponse response) {
        if (response.result != 1 || !(response.response instanceof String)) {
            return false;
        }
        String result = response.response;
        if (result.contains("portrait") || result.contains("landscape")) {
            return true;
        }
        return false;
    }

    private MMJSResponse setAllowOrientationChange(HashMap arguments) {
        String allowOrientationChange = (String) arguments.get("allowOrientationChange");
        if (allowOrientationChange != null) {
            AdViewOverlayActivity overlayActivity = getBaseActivity();
            if (overlayActivity != null) {
                overlayActivity.setAllowOrientationChange(Boolean.parseBoolean(allowOrientationChange));
                return MMJSResponse.responseWithSuccess();
            }
        }
        return null;
    }

    private MMJSResponse setForceOrientation(HashMap arguments) {
        String forceOrientation = (String) arguments.get("forceOrientation");
        if (!"none".equals(forceOrientation)) {
            AdViewOverlayActivity overlayActivity = getBaseActivity();
            if (overlayActivity != null) {
                if ("portrait".equals(forceOrientation)) {
                    overlayActivity.setRequestedOrientationPortrait();
                    return MMJSResponse.responseWithSuccess("portrait");
                } else if ("landscape".equals(forceOrientation)) {
                    overlayActivity.setRequestedOrientationLandscape();
                    return MMJSResponse.responseWithSuccess("landscape");
                }
            }
        }
        return null;
    }
}
