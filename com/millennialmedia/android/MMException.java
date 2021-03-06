package com.millennialmedia.android;

public final class MMException extends RuntimeException {
    public static final int AD_BROKEN_REFERENCE = 25;
    public static final int AD_NO_ACTIVITY = 26;
    public static final int CACHE_NOT_EMPTY = 17;
    public static final int DISPLAY_AD_ALREADY_DISPLAYED = 23;
    public static final int DISPLAY_AD_EXPIRED = 21;
    public static final int DISPLAY_AD_NOT_FOUND = 22;
    public static final int DISPLAY_AD_NOT_PERMITTED = 24;
    public static final int DISPLAY_AD_NOT_READY = 20;
    public static final int INNER_EXCEPTION = 2;
    public static final int INVALID_PARAMETER = 1;
    public static final int MAIN_THREAD_REQUIRED = 3;
    static final String MISSING_MMJS = "MMJS is not downloaded";
    public static final int REQUEST_ALREADY_CACHING = 13;
    public static final int REQUEST_BAD_RESPONSE = 15;
    public static final int REQUEST_IN_PROGRESS = 12;
    public static final int REQUEST_NOT_FILLED = 14;
    public static final int REQUEST_NOT_PERMITTED = 16;
    public static final int REQUEST_NO_NETWORK = 11;
    public static final int REQUEST_TIMEOUT = 10;
    public static final int UNKNOWN_ERROR = 100;
    private final int code;

    MMException(Exception e) {
        super(e);
        this.code = INNER_EXCEPTION;
    }

    MMException(String message, Exception e) {
        super(message, e);
        this.code = INNER_EXCEPTION;
    }

    MMException(int code) {
        super(getErrorCodeMessage(code));
        this.code = code;
    }

    MMException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    static String getErrorCodeMessage(int error) {
        switch (error) {
            case INVALID_PARAMETER /*1*/:
                return "An invalid parameter was given.";
            case MAIN_THREAD_REQUIRED /*3*/:
                return "Requires the main thread.";
            case REQUEST_TIMEOUT /*10*/:
                return "The request timed out.";
            case REQUEST_NO_NETWORK /*11*/:
                return "There is no network available.";
            case REQUEST_IN_PROGRESS /*12*/:
                return "A request is already in progress.";
            case REQUEST_ALREADY_CACHING /*13*/:
                return "A request is already being cached.";
            case REQUEST_NOT_FILLED /*14*/:
                return "The request was not filled by the server.";
            case REQUEST_BAD_RESPONSE /*15*/:
                return "The server replied with unknown or bad content.";
            case REQUEST_NOT_PERMITTED /*16*/:
                return "The system is not permitting a request at this time, try again later.";
            case CACHE_NOT_EMPTY /*17*/:
                return "Previously fetched ad exists in the playback queue";
            case DISPLAY_AD_NOT_READY /*20*/:
                return "There is no fetched ad to display.";
            case DISPLAY_AD_EXPIRED /*21*/:
                return "The ad to display has expired.";
            case DISPLAY_AD_NOT_FOUND /*22*/:
                return "The ad could not be found on disk.";
            case DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                return "The ad has already been displayed.";
            case DISPLAY_AD_NOT_PERMITTED /*24*/:
                return "The ad has already been displayed.";
            case AD_BROKEN_REFERENCE /*25*/:
                return "The reference to the ad view was broken.";
            case AD_NO_ACTIVITY /*26*/:
                return "The ad view does not have a parent activity.";
            case UNKNOWN_ERROR /*100*/:
                return "An unknown error occured.";
            default:
                return "No error.";
        }
    }
}
