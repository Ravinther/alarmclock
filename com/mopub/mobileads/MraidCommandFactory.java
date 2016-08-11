package com.mopub.mobileads;

import com.millennialmedia.android.C2513R;
import com.mopub.mobileads.util.Base64;
import java.util.Map;

class MraidCommandFactory {
    protected static MraidCommandFactory instance;

    /* renamed from: com.mopub.mobileads.MraidCommandFactory.1 */
    static /* synthetic */ class C26121 {
        static final /* synthetic */ int[] f4307x57bbb4d7;

        static {
            f4307x57bbb4d7 = new int[MraidJavascriptCommand.values().length];
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.EXPAND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.USECUSTOMCLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.OPEN.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.RESIZE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.GET_RESIZE_PROPERTIES.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.SET_RESIZE_PROPERTIES.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.PLAY_VIDEO.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.STORE_PICTURE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.GET_CURRENT_POSITION.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.GET_DEFAULT_POSITION.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.GET_MAX_SIZE.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.GET_SCREEN_SIZE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.CREATE_CALENDAR_EVENT.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f4307x57bbb4d7[MraidJavascriptCommand.UNSPECIFIED.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    enum MraidJavascriptCommand {
        CLOSE("close"),
        EXPAND("expand"),
        USECUSTOMCLOSE("usecustomclose"),
        OPEN("open"),
        RESIZE("resize"),
        GET_RESIZE_PROPERTIES("getResizeProperties"),
        SET_RESIZE_PROPERTIES("setResizeProperties"),
        PLAY_VIDEO("playVideo"),
        STORE_PICTURE("storePicture"),
        GET_CURRENT_POSITION("getCurrentPosition"),
        GET_DEFAULT_POSITION("getDefaultPosition"),
        GET_MAX_SIZE("getMaxSize"),
        GET_SCREEN_SIZE("getScreenSize"),
        CREATE_CALENDAR_EVENT("createCalendarEvent"),
        UNSPECIFIED("");
        
        private String mCommand;

        private MraidJavascriptCommand(String command) {
            this.mCommand = command;
        }

        private static MraidJavascriptCommand fromString(String string) {
            for (MraidJavascriptCommand command : values()) {
                if (command.mCommand.equals(string)) {
                    return command;
                }
            }
            return UNSPECIFIED;
        }

        String getCommand() {
            return this.mCommand;
        }
    }

    MraidCommandFactory() {
    }

    static {
        instance = new MraidCommandFactory();
    }

    @Deprecated
    public static void setInstance(MraidCommandFactory factory) {
        instance = factory;
    }

    public static MraidCommand create(String command, Map params, MraidView view) {
        return instance.internalCreate(command, params, view);
    }

    protected MraidCommand internalCreate(String command, Map params, MraidView view) {
        switch (C26121.f4307x57bbb4d7[MraidJavascriptCommand.fromString(command).ordinal()]) {
            case Base64.NO_PADDING /*1*/:
                return new MraidCommandClose(params, view);
            case Base64.NO_WRAP /*2*/:
                return new MraidCommandExpand(params, view);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return new MraidCommandUseCustomClose(params, view);
            case Base64.CRLF /*4*/:
                return new MraidCommandOpen(params, view);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return new MraidCommandResize(params, view);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return new MraidCommandGetResizeProperties(params, view);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return new MraidCommandSetResizeProperties(params, view);
            case Base64.URL_SAFE /*8*/:
                return new MraidCommandPlayVideo(params, view);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                return new MraidCommandStorePicture(params, view);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                return new MraidCommandGetCurrentPosition(params, view);
            case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                return new MraidCommandGetDefaultPosition(params, view);
            case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                return new MraidCommandGetMaxSize(params, view);
            case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                return new MraidCommandGetScreenSize(params, view);
            case C2513R.styleable.MMAdView_height /*14*/:
                return new MraidCommandCreateCalendarEvent(params, view);
            default:
                return null;
        }
    }
}
