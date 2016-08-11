package com.mopub.mobileads;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.plus.PlusShare;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import com.mopub.mobileads.MraidView.BaseMraidListener;
import com.mopub.mobileads.MraidView.ExpansionStyle;
import com.mopub.mobileads.MraidView.NativeCloseButtonStyle;
import com.mopub.mobileads.MraidView.PlacementType;
import com.mopub.mobileads.MraidView.ViewState;
import com.mopub.mobileads.factories.HttpClientFactory;
import com.mopub.mobileads.util.Base64;
import com.mopub.mobileads.util.HttpResponses;
import com.mopub.mobileads.util.Mraids;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

class MraidDisplayController extends MraidAbstractController {
    private static final int CLOSE_BUTTON_SIZE_DP = 50;
    private static final String[] DATE_FORMATS;
    private static final String LOGTAG = "MraidDisplayController";
    private static final int MAX_NUMBER_DAYS_IN_MONTH = 31;
    private static final long VIEWABILITY_TIMER_MILLIS = 3000;
    private FrameLayout mAdContainerLayout;
    private boolean mAdWantsCustomCloseButton;
    private ImageView mCloseButton;
    protected float mDensity;
    private RelativeLayout mExpansionLayout;
    private final ExpansionStyle mExpansionStyle;
    private Handler mHandler;
    private final NativeCloseButtonStyle mNativeCloseButtonStyle;
    private OrientationBroadcastReceiver mOrientationBroadcastReceiver;
    private final int mOriginalRequestedOrientation;
    private FrameLayout mPlaceholderView;
    private FrameLayout mRootView;
    protected int mScreenHeight;
    protected int mScreenWidth;
    private MraidView mTwoPartExpansionView;
    private int mViewIndexInParent;
    private ViewState mViewState;

    /* renamed from: com.mopub.mobileads.MraidDisplayController.1 */
    class C26141 extends BaseMraidListener {
        C26141() {
        }

        public void onClose(MraidView view, ViewState newViewState) {
            MraidDisplayController.this.close();
        }
    }

    /* renamed from: com.mopub.mobileads.MraidDisplayController.2 */
    class C26152 implements Runnable {
        final /* synthetic */ String val$message;

        C26152(String str) {
            this.val$message = str;
        }

        public void run() {
            Toast.makeText(MraidDisplayController.this.getContext(), this.val$message, 0).show();
        }
    }

    /* renamed from: com.mopub.mobileads.MraidDisplayController.3 */
    class C26173 implements Runnable {
        private MediaScannerConnection mediaScannerConnection;
        private InputStream pictureInputStream;
        private OutputStream pictureOutputStream;
        private URI uri;
        final /* synthetic */ File val$pictureStoragePath;
        final /* synthetic */ String val$uriString;

        /* renamed from: com.mopub.mobileads.MraidDisplayController.3.1 */
        class C26161 implements Runnable {
            C26161() {
            }

            public void run() {
                MraidDisplayController.this.showUserToast("Image failed to download.");
                MraidDisplayController.this.getMraidView().fireErrorEvent(MraidJavascriptCommand.STORE_PICTURE, "Error downloading and saving image file.");
                Log.d("MoPub", "Error downloading and saving image file.");
            }
        }

        C26173(String str, File file) {
            this.val$uriString = str;
            this.val$pictureStoragePath = file;
        }

        public void run() {
            try {
                this.uri = URI.create(this.val$uriString);
                HttpResponse httpResponse = HttpClientFactory.create().execute(new HttpGet(this.uri));
                this.pictureInputStream = httpResponse.getEntity().getContent();
                String redirectLocation = HttpResponses.extractHeader(httpResponse, ResponseHeader.LOCATION);
                if (redirectLocation != null) {
                    this.uri = URI.create(redirectLocation);
                }
                File pictureFile = new File(this.val$pictureStoragePath, MraidDisplayController.this.getFileNameForUriAndHttpResponse(this.uri, httpResponse));
                String pictureFileFullPath = pictureFile.toString();
                this.pictureOutputStream = new FileOutputStream(pictureFile);
                Streams.copyContent(this.pictureInputStream, this.pictureOutputStream);
                loadPictureIntoGalleryApp(pictureFileFullPath);
            } catch (Exception e) {
                MraidDisplayController.this.mHandler.post(new C26161());
            } finally {
                Streams.closeStream(this.pictureInputStream);
                Streams.closeStream(this.pictureOutputStream);
            }
        }

        private void loadPictureIntoGalleryApp(String filename) {
            MoPubMediaScannerConnectionClient mediaScannerConnectionClient = new MoPubMediaScannerConnectionClient(filename, null, null);
            this.mediaScannerConnection = new MediaScannerConnection(MraidDisplayController.this.getContext().getApplicationContext(), mediaScannerConnectionClient);
            mediaScannerConnectionClient.setMediaScannerConnection(this.mediaScannerConnection);
            this.mediaScannerConnection.connect();
        }
    }

    /* renamed from: com.mopub.mobileads.MraidDisplayController.4 */
    class C26184 implements OnClickListener {
        final /* synthetic */ String val$imageUrl;

        C26184(String str) {
            this.val$imageUrl = str;
        }

        public void onClick(DialogInterface dialog, int which) {
            MraidDisplayController.this.downloadImage(this.val$imageUrl);
        }
    }

    /* renamed from: com.mopub.mobileads.MraidDisplayController.5 */
    class C26195 implements OnTouchListener {
        C26195() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.mopub.mobileads.MraidDisplayController.6 */
    class C26206 implements View.OnClickListener {
        C26206() {
        }

        public void onClick(View v) {
            MraidDisplayController.this.close();
        }
    }

    private class MoPubMediaScannerConnectionClient implements MediaScannerConnectionClient {
        private final String mFilename;
        private MediaScannerConnection mMediaScannerConnection;
        private final String mMimeType;

        private MoPubMediaScannerConnectionClient(String filename, String mimeType) {
            this.mFilename = filename;
            this.mMimeType = mimeType;
        }

        private void setMediaScannerConnection(MediaScannerConnection connection) {
            this.mMediaScannerConnection = connection;
        }

        public void onMediaScannerConnected() {
            if (this.mMediaScannerConnection != null) {
                this.mMediaScannerConnection.scanFile(this.mFilename, this.mMimeType);
            }
        }

        public void onScanCompleted(String path, Uri uri) {
            if (this.mMediaScannerConnection != null) {
                this.mMediaScannerConnection.disconnect();
            }
        }
    }

    class OrientationBroadcastReceiver extends BroadcastReceiver {
        private Context mContext;
        private int mLastRotation;

        OrientationBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (isRegistered() && intent.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
                int orientation = MraidDisplayController.this.getDisplayRotation();
                if (orientation != this.mLastRotation) {
                    this.mLastRotation = orientation;
                    MraidDisplayController.this.onOrientationChanged(this.mLastRotation);
                }
            }
        }

        private boolean isRegistered() {
            return this.mContext != null;
        }

        public void register(Context context) {
            this.mContext = context;
            context.registerReceiver(this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }

        public void unregister() {
            this.mContext.unregisterReceiver(this);
            this.mContext = null;
        }
    }

    static {
        DATE_FORMATS = new String[]{"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};
    }

    MraidDisplayController(MraidView view, ExpansionStyle expStyle, NativeCloseButtonStyle buttonStyle) {
        int i = -1;
        super(view);
        this.mViewState = ViewState.HIDDEN;
        this.mHandler = new Handler();
        this.mOrientationBroadcastReceiver = new OrientationBroadcastReceiver();
        this.mScreenWidth = -1;
        this.mScreenHeight = -1;
        this.mExpansionStyle = expStyle;
        this.mNativeCloseButtonStyle = buttonStyle;
        Context context = getContext();
        if (context instanceof Activity) {
            i = ((Activity) context).getRequestedOrientation();
        }
        this.mOriginalRequestedOrientation = i;
        this.mAdContainerLayout = createAdContainerLayout();
        this.mExpansionLayout = createExpansionLayout();
        this.mPlaceholderView = createPlaceholderView();
        initialize();
    }

    private void initialize() {
        this.mViewState = ViewState.LOADING;
        initializeScreenMetrics();
        this.mOrientationBroadcastReceiver.register(getContext());
    }

    private void initializeScreenMetrics() {
        Context context = getContext();
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(metrics);
        this.mDensity = metrics.density;
        int statusBarHeight = 0;
        int titleBarHeight = 0;
        if (context instanceof Activity) {
            Window window = ((Activity) context).getWindow();
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            statusBarHeight = rect.top;
            titleBarHeight = window.findViewById(16908290).getTop() - statusBarHeight;
        }
        int heightPixels = (metrics.heightPixels - statusBarHeight) - titleBarHeight;
        this.mScreenWidth = (int) (((double) metrics.widthPixels) * (160.0d / ((double) metrics.densityDpi)));
        this.mScreenHeight = (int) (((double) heightPixels) * (160.0d / ((double) metrics.densityDpi)));
    }

    private int getDisplayRotation() {
        return ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getOrientation();
    }

    private void onOrientationChanged(int currentRotation) {
        initializeScreenMetrics();
        getMraidView().fireChangeEventForProperty(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
    }

    public void destroy() {
        try {
            this.mOrientationBroadcastReceiver.unregister();
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
    }

    protected void initializeJavaScriptState() {
        ArrayList properties = new ArrayList();
        properties.add(MraidScreenSizeProperty.createWithSize(this.mScreenWidth, this.mScreenHeight));
        properties.add(MraidViewableProperty.createWithViewable(getMraidView().getIsVisible()));
        getMraidView().fireChangeEventForProperties(properties);
        this.mViewState = ViewState.DEFAULT;
        getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
        initializeSupportedFunctionsProperty();
    }

    protected boolean isExpanded() {
        return this.mViewState == ViewState.EXPANDED;
    }

    protected void close() {
        if (this.mViewState == ViewState.EXPANDED) {
            resetViewToDefaultState();
            setOrientationLockEnabled(false);
            this.mViewState = ViewState.DEFAULT;
            getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
        } else if (this.mViewState == ViewState.DEFAULT) {
            getMraidView().setVisibility(4);
            this.mViewState = ViewState.HIDDEN;
            getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
        }
        if (getMraidView().getMraidListener() != null) {
            getMraidView().getMraidListener().onClose(getMraidView(), this.mViewState);
        }
    }

    private void resetViewToDefaultState() {
        setNativeCloseButtonEnabled(false);
        this.mAdContainerLayout.removeAllViewsInLayout();
        this.mExpansionLayout.removeAllViewsInLayout();
        this.mRootView.removeView(this.mExpansionLayout);
        getMraidView().requestLayout();
        ViewGroup parent = (ViewGroup) this.mPlaceholderView.getParent();
        parent.addView(getMraidView(), this.mViewIndexInParent);
        parent.removeView(this.mPlaceholderView);
        parent.invalidate();
    }

    protected void expand(String url, int width, int height, boolean shouldUseCustomClose, boolean shouldLockOrientation) {
        if (this.mExpansionStyle != ExpansionStyle.DISABLED) {
            if (url == null || URLUtil.isValidUrl(url)) {
                this.mRootView = (FrameLayout) getMraidView().getRootView().findViewById(16908290);
                useCustomClose(shouldUseCustomClose);
                setOrientationLockEnabled(shouldLockOrientation);
                swapViewWithPlaceholderView();
                View expansionContentView = getMraidView();
                if (url != null) {
                    this.mTwoPartExpansionView = new MraidView(getContext(), getMraidView().getAdConfiguration(), ExpansionStyle.DISABLED, NativeCloseButtonStyle.AD_CONTROLLED, PlacementType.INLINE);
                    this.mTwoPartExpansionView.setMraidListener(new C26141());
                    this.mTwoPartExpansionView.loadUrl(url);
                    expansionContentView = this.mTwoPartExpansionView;
                }
                expandLayouts(expansionContentView, (int) (((float) width) * this.mDensity), (int) (((float) height) * this.mDensity));
                this.mRootView.addView(this.mExpansionLayout, new LayoutParams(-1, -1));
                if (this.mNativeCloseButtonStyle == NativeCloseButtonStyle.ALWAYS_VISIBLE || !(this.mAdWantsCustomCloseButton || this.mNativeCloseButtonStyle == NativeCloseButtonStyle.ALWAYS_HIDDEN)) {
                    setNativeCloseButtonEnabled(true);
                }
                this.mViewState = ViewState.EXPANDED;
                getMraidView().fireChangeEventForProperty(MraidStateProperty.createWithViewState(this.mViewState));
                if (getMraidView().getMraidListener() != null) {
                    getMraidView().getMraidListener().onExpand(getMraidView());
                    return;
                }
                return;
            }
            getMraidView().fireErrorEvent(MraidJavascriptCommand.EXPAND, "URL passed to expand() was invalid.");
        }
    }

    protected void showUserDownloadImageAlert(String imageUrl) {
        Context context = getContext();
        if (!Mraids.isStorePictureSupported(context)) {
            getMraidView().fireErrorEvent(MraidJavascriptCommand.STORE_PICTURE, "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
            Log.d("MoPub", "Error downloading file - the device does not have an SD card mounted, or the Android permission is not granted.");
        } else if (context instanceof Activity) {
            showUserDialog(imageUrl);
        } else {
            showUserToast("Downloading image to Picture gallery...");
            downloadImage(imageUrl);
        }
    }

    private void showUserToast(String message) {
        this.mHandler.post(new C26152(message));
    }

    private void downloadImage(String uriString) {
        File pictureStoragePath = getPictureStoragePath();
        pictureStoragePath.mkdirs();
        new Thread(new C26173(uriString, pictureStoragePath)).start();
    }

    private void showUserDialog(String imageUrl) {
        new Builder(getContext()).setTitle("Save Image").setMessage("Download image to Picture gallery?").setNegativeButton("Cancel", null).setPositiveButton("Okay", new C26184(imageUrl)).setCancelable(true).show();
    }

    protected void showVideo(String videoUrl) {
        BaseVideoPlayerActivity.startMraid(getContext(), videoUrl, getMraidView().getAdConfiguration());
    }

    protected void getCurrentPosition() {
        getMraidView().fireErrorEvent(MraidJavascriptCommand.GET_CURRENT_POSITION, "Unsupported action getCurrentPosition");
    }

    protected void getDefaultPosition() {
        getMraidView().fireErrorEvent(MraidJavascriptCommand.GET_DEFAULT_POSITION, "Unsupported action getDefaultPosition");
    }

    protected void getMaxSize() {
        getMraidView().fireErrorEvent(MraidJavascriptCommand.GET_MAX_SIZE, "Unsupported action getMaxSize");
    }

    protected void getScreenSize() {
        getMraidView().fireErrorEvent(MraidJavascriptCommand.GET_SCREEN_SIZE, "Unsupported action getScreenSize");
    }

    protected void createCalendarEvent(Map params) {
        Context context = getMraidView().getContext();
        if (Mraids.isCalendarAvailable(context)) {
            try {
                Map calendarParams = translateJSParamsToAndroidCalendarEventMapping(params);
                Intent intent = new Intent("android.intent.action.INSERT").setType(Mraids.ANDROID_CALENDAR_CONTENT_TYPE);
                for (String key : calendarParams.keySet()) {
                    Object value = calendarParams.get(key);
                    if (value instanceof Long) {
                        intent.putExtra(key, ((Long) value).longValue());
                    } else if (value instanceof Integer) {
                        intent.putExtra(key, ((Integer) value).intValue());
                    } else {
                        intent.putExtra(key, (String) value);
                    }
                }
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                context.startActivity(intent);
                return;
            } catch (ActivityNotFoundException e) {
                Log.d(LOGTAG, "no calendar app installed");
                getMraidView().fireErrorEvent(MraidJavascriptCommand.CREATE_CALENDAR_EVENT, "Action is unsupported on this device - no calendar app installed");
                return;
            } catch (IllegalArgumentException iae) {
                Log.d(LOGTAG, "create calendar: invalid parameters " + iae.getMessage());
                getMraidView().fireErrorEvent(MraidJavascriptCommand.CREATE_CALENDAR_EVENT, iae.getMessage());
                return;
            } catch (Exception e2) {
                Log.d(LOGTAG, "could not create calendar event");
                getMraidView().fireErrorEvent(MraidJavascriptCommand.CREATE_CALENDAR_EVENT, "could not create calendar event");
                return;
            }
        }
        Log.d(LOGTAG, "unsupported action createCalendarEvent for devices pre-ICS");
        getMraidView().fireErrorEvent(MraidJavascriptCommand.CREATE_CALENDAR_EVENT, "Action is unsupported on this device (need Android version Ice Cream Sandwich or above)");
    }

    private Map translateJSParamsToAndroidCalendarEventMapping(Map params) {
        Map validatedParamsMapping = new HashMap();
        if (params.containsKey(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION) && params.containsKey("start")) {
            validatedParamsMapping.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, params.get(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION));
            if (!params.containsKey("start") || params.get("start") == null) {
                throw new IllegalArgumentException("Invalid calendar event: start is null.");
            }
            Date startDateTime = parseDate((String) params.get("start"));
            if (startDateTime != null) {
                validatedParamsMapping.put("beginTime", Long.valueOf(startDateTime.getTime()));
                if (params.containsKey("end") && params.get("end") != null) {
                    Date endDateTime = parseDate((String) params.get("end"));
                    if (endDateTime != null) {
                        validatedParamsMapping.put("endTime", Long.valueOf(endDateTime.getTime()));
                    } else {
                        throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
                    }
                }
                if (params.containsKey("location")) {
                    validatedParamsMapping.put("eventLocation", params.get("location"));
                }
                if (params.containsKey("summary")) {
                    validatedParamsMapping.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, params.get("summary"));
                }
                if (params.containsKey("transparency")) {
                    validatedParamsMapping.put("availability", Integer.valueOf(((String) params.get("transparency")).equals("transparent") ? 1 : 0));
                }
                validatedParamsMapping.put("rrule", parseRecurrenceRule(params));
                return validatedParamsMapping;
            }
            throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
        }
        throw new IllegalArgumentException("Missing start and description fields");
    }

    private Date parseDate(String dateTime) {
        Date result = null;
        int i = 0;
        while (i < DATE_FORMATS.length) {
            try {
                result = new SimpleDateFormat(DATE_FORMATS[i]).parse(dateTime);
                if (result != null) {
                    break;
                }
                i++;
            } catch (ParseException e) {
            }
        }
        return result;
    }

    private String parseRecurrenceRule(Map params) {
        StringBuilder rule = new StringBuilder();
        if (params.containsKey("frequency")) {
            String frequency = (String) params.get("frequency");
            int interval = -1;
            if (params.containsKey("interval")) {
                interval = Integer.parseInt((String) params.get("interval"));
            }
            if ("daily".equals(frequency)) {
                rule.append("FREQ=DAILY;");
                if (interval != -1) {
                    rule.append("INTERVAL=" + interval + ";");
                }
            } else if ("weekly".equals(frequency)) {
                rule.append("FREQ=WEEKLY;");
                if (interval != -1) {
                    rule.append("INTERVAL=" + interval + ";");
                }
                if (params.containsKey("daysInWeek")) {
                    String weekdays = translateWeekIntegersToDays((String) params.get("daysInWeek"));
                    if (weekdays == null) {
                        throw new IllegalArgumentException("invalid ");
                    }
                    rule.append("BYDAY=" + weekdays + ";");
                }
            } else if ("monthly".equals(frequency)) {
                rule.append("FREQ=MONTHLY;");
                if (interval != -1) {
                    rule.append("INTERVAL=" + interval + ";");
                }
                if (params.containsKey("daysInMonth")) {
                    String monthDays = translateMonthIntegersToDays((String) params.get("daysInMonth"));
                    if (monthDays == null) {
                        throw new IllegalArgumentException();
                    }
                    rule.append("BYMONTHDAY=" + monthDays + ";");
                }
            } else {
                throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
            }
        }
        return rule.toString();
    }

    private String translateWeekIntegersToDays(String expression) {
        StringBuilder daysResult = new StringBuilder();
        boolean[] daysAlreadyCounted = new boolean[7];
        String[] days = expression.split(",");
        for (String parseInt : days) {
            int dayNumber = Integer.parseInt(parseInt);
            if (dayNumber == 7) {
                dayNumber = 0;
            }
            if (!daysAlreadyCounted[dayNumber]) {
                daysResult.append(dayNumberToDayOfWeekString(dayNumber) + ",");
                daysAlreadyCounted[dayNumber] = true;
            }
        }
        if (days.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        }
        daysResult.deleteCharAt(daysResult.length() - 1);
        return daysResult.toString();
    }

    private String translateMonthIntegersToDays(String expression) {
        StringBuilder daysResult = new StringBuilder();
        boolean[] daysAlreadyCounted = new boolean[63];
        String[] days = expression.split(",");
        for (String parseInt : days) {
            int dayNumber = Integer.parseInt(parseInt);
            if (!daysAlreadyCounted[dayNumber + MAX_NUMBER_DAYS_IN_MONTH]) {
                daysResult.append(dayNumberToDayOfMonthString(dayNumber) + ",");
                daysAlreadyCounted[dayNumber + MAX_NUMBER_DAYS_IN_MONTH] = true;
            }
        }
        if (days.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        }
        daysResult.deleteCharAt(daysResult.length() - 1);
        return daysResult.toString();
    }

    private String dayNumberToDayOfWeekString(int number) {
        switch (number) {
            case Base64.DEFAULT /*0*/:
                return "SU";
            case Base64.NO_PADDING /*1*/:
                return "MO";
            case Base64.NO_WRAP /*2*/:
                return "TU";
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return "WE";
            case Base64.CRLF /*4*/:
                return "TH";
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return "FR";
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return "SA";
            default:
                throw new IllegalArgumentException("invalid day of week " + number);
        }
    }

    private String dayNumberToDayOfMonthString(int number) {
        if (number != 0 && number >= -31 && number <= MAX_NUMBER_DAYS_IN_MONTH) {
            return "" + number;
        }
        throw new IllegalArgumentException("invalid day of month " + number);
    }

    private void swapViewWithPlaceholderView() {
        ViewGroup parent = (ViewGroup) getMraidView().getParent();
        if (parent != null) {
            int count = parent.getChildCount();
            int index = 0;
            while (index < count && parent.getChildAt(index) != getMraidView()) {
                index++;
            }
            this.mViewIndexInParent = index;
            parent.addView(this.mPlaceholderView, index, new ViewGroup.LayoutParams(getMraidView().getWidth(), getMraidView().getHeight()));
            parent.removeView(getMraidView());
        }
    }

    private void expandLayouts(View expansionContentView, int expandWidth, int expandHeight) {
        int closeButtonSize = (int) ((50.0f * this.mDensity) + 0.5f);
        if (expandWidth < closeButtonSize) {
            expandWidth = closeButtonSize;
        }
        if (expandHeight < closeButtonSize) {
            expandHeight = closeButtonSize;
        }
        View dimmingView = new View(getContext());
        dimmingView.setBackgroundColor(0);
        dimmingView.setOnTouchListener(new C26195());
        this.mExpansionLayout.addView(dimmingView, new LayoutParams(-1, -1));
        this.mAdContainerLayout.addView(expansionContentView, new LayoutParams(-1, -1));
        LayoutParams lp = new LayoutParams(expandWidth, expandHeight);
        lp.addRule(13);
        this.mExpansionLayout.addView(this.mAdContainerLayout, lp);
    }

    private void setOrientationLockEnabled(boolean enabled) {
        try {
            Activity activity = (Activity) getContext();
            activity.setRequestedOrientation(enabled ? activity.getResources().getConfiguration().orientation : this.mOriginalRequestedOrientation);
        } catch (ClassCastException e) {
            Log.d(LOGTAG, "Unable to modify device orientation.");
        }
    }

    protected void setNativeCloseButtonEnabled(boolean enabled) {
        if (this.mRootView != null) {
            if (enabled) {
                if (this.mCloseButton == null) {
                    StateListDrawable states = new StateListDrawable();
                    states.addState(new int[]{-16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(this.mRootView.getContext()));
                    states.addState(new int[]{16842919}, Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(this.mRootView.getContext()));
                    this.mCloseButton = new ImageButton(getContext());
                    this.mCloseButton.setImageDrawable(states);
                    this.mCloseButton.setBackgroundDrawable(null);
                    this.mCloseButton.setOnClickListener(new C26206());
                }
                int buttonSize = (int) ((50.0f * this.mDensity) + 0.5f);
                this.mAdContainerLayout.addView(this.mCloseButton, new FrameLayout.LayoutParams(buttonSize, buttonSize, 5));
            } else {
                this.mAdContainerLayout.removeView(this.mCloseButton);
            }
            MraidView view = getMraidView();
            if (view.getOnCloseButtonStateChangeListener() != null) {
                view.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(view, enabled);
            }
        }
    }

    protected void useCustomClose(boolean shouldUseCustomCloseButton) {
        this.mAdWantsCustomCloseButton = shouldUseCustomCloseButton;
        MraidView view = getMraidView();
        boolean enabled = !shouldUseCustomCloseButton;
        if (view.getOnCloseButtonStateChangeListener() != null) {
            view.getOnCloseButtonStateChangeListener().onCloseButtonStateChange(view, enabled);
        }
    }

    FrameLayout createAdContainerLayout() {
        return new FrameLayout(getContext());
    }

    RelativeLayout createExpansionLayout() {
        return new RelativeLayout(getContext());
    }

    FrameLayout createPlaceholderView() {
        return new FrameLayout(getContext());
    }

    private Context getContext() {
        return getMraidView().getContext();
    }

    protected void initializeSupportedFunctionsProperty() {
        Context context = getContext();
        getMraidView().fireChangeEventForProperty(new MraidSupportsProperty().withTel(Mraids.isTelAvailable(context)).withSms(Mraids.isSmsAvailable(context)).withCalendar(Mraids.isCalendarAvailable(context)).withInlineVideo(Mraids.isInlineVideoAvailable(context)).withStorePicture(Mraids.isStorePictureSupported(context)));
    }

    private File getPictureStoragePath() {
        return new File(Environment.getExternalStorageDirectory(), "Pictures");
    }

    private String getFileNameForUriAndHttpResponse(URI uri, HttpResponse response) {
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        String filename = new File(path).getName();
        Header header = response.getFirstHeader(MraidCommandStorePicture.MIME_TYPE_HEADER);
        if (header == null) {
            return filename;
        }
        for (String field : header.getValue().split(";")) {
            if (field.contains("image/")) {
                String extension = "." + field.split("/")[1];
                if (filename.endsWith(extension)) {
                    return filename;
                }
                return filename + extension;
            }
        }
        return filename;
    }
}
