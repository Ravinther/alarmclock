package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.google.android.gms.drive.DriveFile;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.Streams;
import com.mopub.mobileads.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdAlertReporter {
    private static final String BODY_SEPARATOR = "\n=================\n";
    private static final String DATE_FORMAT_PATTERN = "M/d/yy hh:mm:ss a z";
    private static final String EMAIL_RECIPIENT = "creative-review@mopub.com";
    private static final String EMAIL_SCHEME = "mailto:";
    private static final int IMAGE_QUALITY = 25;
    private static final String MARKUP_FILENAME = "mp_adalert_markup.html";
    private static final String PARAMETERS_FILENAME = "mp_adalert_parameters.txt";
    private static final String SCREEN_SHOT_FILENAME = "mp_adalert_screenshot.png";
    private final AdConfiguration mAdConfiguration;
    private final Context mContext;
    private final String mDateString;
    private ArrayList mEmailAttachments;
    private Intent mEmailIntent;
    private String mParameters;
    private String mResponse;
    private final View mView;

    public AdAlertReporter(Context context, View view, AdConfiguration adConfiguration) {
        this.mView = view;
        this.mContext = context;
        this.mAdConfiguration = adConfiguration;
        this.mEmailAttachments = new ArrayList();
        this.mDateString = new SimpleDateFormat(DATE_FORMAT_PATTERN).format(DateAndTime.now());
        initEmailIntent();
        Bitmap screenShot = takeScreenShot();
        String screenShotString = convertBitmapInWEBPToBase64EncodedString(screenShot);
        this.mParameters = formParameters();
        this.mResponse = getResponseString();
        addEmailSubject();
        addEmailBody(this.mParameters, this.mResponse, screenShotString);
        addTextAttachment(PARAMETERS_FILENAME, this.mParameters);
        addTextAttachment(MARKUP_FILENAME, this.mResponse);
        addImageAttachment(SCREEN_SHOT_FILENAME, screenShot);
    }

    public void send() {
        this.mEmailIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mEmailAttachments);
        Intent chooserIntent = Intent.createChooser(this.mEmailIntent, "Send Email...");
        chooserIntent.addFlags(DriveFile.MODE_READ_ONLY);
        this.mContext.startActivity(chooserIntent);
    }

    private void initEmailIntent() {
        this.mEmailIntent = new Intent("android.intent.action.SEND_MULTIPLE", Uri.parse(EMAIL_SCHEME));
        this.mEmailIntent.setType("plain/text");
        this.mEmailIntent.putExtra("android.intent.extra.EMAIL", new String[]{EMAIL_RECIPIENT});
    }

    private Bitmap takeScreenShot() {
        if (this.mView == null || this.mView.getRootView() == null) {
            return null;
        }
        View rootView = this.mView.getRootView();
        boolean wasDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
        rootView.setDrawingCacheEnabled(true);
        Bitmap drawingCache = rootView.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(drawingCache);
        rootView.setDrawingCacheEnabled(wasDrawingCacheEnabled);
        return bitmap;
    }

    private String convertBitmapInWEBPToBase64EncodedString(Bitmap bitmap) {
        String result = null;
        if (bitmap != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(CompressFormat.JPEG, IMAGE_QUALITY, byteArrayOutputStream);
                result = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Exception e) {
            }
        }
        return result;
    }

    private String formParameters() {
        StringBuilder parameters = new StringBuilder();
        if (this.mAdConfiguration != null) {
            appendKeyValue(parameters, "sdk_version", this.mAdConfiguration.getSdkVersion());
            appendKeyValue(parameters, "creative_id", this.mAdConfiguration.getDspCreativeId());
            appendKeyValue(parameters, "platform_version", Integer.toString(this.mAdConfiguration.getPlatformVersion()));
            appendKeyValue(parameters, "device_model", this.mAdConfiguration.getDeviceModel());
            appendKeyValue(parameters, "ad_unit_id", this.mAdConfiguration.getAdUnitId());
            appendKeyValue(parameters, "device_locale", this.mAdConfiguration.getDeviceLocale());
            appendKeyValue(parameters, "device_id", this.mAdConfiguration.getHashedUdid());
            appendKeyValue(parameters, "network_type", this.mAdConfiguration.getNetworkType());
            appendKeyValue(parameters, "platform", this.mAdConfiguration.getPlatform());
            appendKeyValue(parameters, "timestamp", getFormattedTimeStamp(this.mAdConfiguration.getTimeStamp()));
            appendKeyValue(parameters, "ad_type", this.mAdConfiguration.getAdType());
            appendKeyValue(parameters, "ad_size", "{" + this.mAdConfiguration.getWidth() + ", " + this.mAdConfiguration.getHeight() + "}");
        }
        return parameters.toString();
    }

    private String getResponseString() {
        return this.mAdConfiguration != null ? this.mAdConfiguration.getResponseString() : "";
    }

    private void appendKeyValue(StringBuilder parameters, String key, String value) {
        parameters.append(key);
        parameters.append(" : ");
        parameters.append(value);
        parameters.append("\n");
    }

    private void addEmailSubject() {
        this.mEmailIntent.putExtra("android.intent.extra.SUBJECT", "New creative violation report - " + this.mDateString);
    }

    private void addEmailBody(String... data) {
        StringBuilder body = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            body.append(data[i]);
            if (i != data.length - 1) {
                body.append(BODY_SEPARATOR);
            }
        }
        this.mEmailIntent.putExtra("android.intent.extra.TEXT", body.toString());
    }

    private void addImageAttachment(String fileName, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        if (fileName != null && bitmap != null) {
            try {
                fileOutputStream = this.mContext.openFileOutput(fileName, 1);
                bitmap.compress(CompressFormat.PNG, IMAGE_QUALITY, fileOutputStream);
                this.mEmailAttachments.add(Uri.fromFile(new File(this.mContext.getFilesDir() + File.separator + fileName)));
            } catch (Exception e) {
                Log.d("MoPub", "Unable to write text attachment to file: " + fileName);
            } finally {
                Streams.closeStream(fileOutputStream);
            }
        }
    }

    private void addTextAttachment(String fileName, String body) {
        FileOutputStream fileOutputStream = null;
        if (fileName != null && body != null) {
            try {
                fileOutputStream = this.mContext.openFileOutput(fileName, 1);
                fileOutputStream.write(body.getBytes());
                this.mEmailAttachments.add(Uri.fromFile(new File(this.mContext.getFilesDir() + File.separator + fileName)));
            } catch (Exception e) {
                Log.d("MoPub", "Unable to write text attachment to file: " + fileName);
            } finally {
                Streams.closeStream(fileOutputStream);
            }
        }
    }

    private String getFormattedTimeStamp(long timeStamp) {
        if (timeStamp != -1) {
            return new SimpleDateFormat(DATE_FORMAT_PATTERN).format(new Date(timeStamp));
        }
        return null;
    }

    @Deprecated
    Intent getEmailIntent() {
        return this.mEmailIntent;
    }

    @Deprecated
    ArrayList getEmailAttachments() {
        return this.mEmailAttachments;
    }

    @Deprecated
    String getParameters() {
        return this.mParameters;
    }

    @Deprecated
    String getResponse() {
        return this.mResponse;
    }
}
