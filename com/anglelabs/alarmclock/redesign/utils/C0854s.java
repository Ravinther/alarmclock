package com.anglelabs.alarmclock.redesign.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.anglelabs.alarmclock.redesign.p039d.C0695c;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.Locale;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.s */
public final class C0854s {
    public static String m4005a(int milliseconds) {
        String formatOne = String.format(Locale.US, "%%0%dd", new Object[]{Integer.valueOf(1)});
        String formatTwo = String.format(Locale.US, "%%0%dd", new Object[]{Integer.valueOf(2)});
        int seconds = milliseconds / LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
        String time = String.format(formatOne, new Object[]{Integer.valueOf(seconds / 3600)});
        if (time.equals(ITKSvc.CODEREVISION) || time.equals("00")) {
            return String.format(formatOne, new Object[]{Integer.valueOf((seconds % 3600) / 60)}) + ":" + String.format(formatTwo, new Object[]{Integer.valueOf(seconds % 60)});
        }
        return time + ":" + String.format(formatTwo, new Object[]{Integer.valueOf((seconds % 3600) / 60)}) + ":" + String.format(formatTwo, new Object[]{Integer.valueOf(seconds % 60)});
    }

    public static int m4004a(Context context, String titleKey) {
        int id = -1;
        try {
            Cursor c = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "title_key=?", new String[]{titleKey}, null);
            if (c != null) {
                c.moveToFirst();
                if (!c.isAfterLast()) {
                    id = c.getInt(0);
                }
                c.close();
            }
        } catch (Exception e) {
            C0850q.m3985a(e, "ChooseSongActivity failed to get id for song");
        }
        return id;
    }

    public static boolean m4007a(Context context, Uri uri) {
        return C0854s.m4009a(uri) || C0854s.m4012b(context, uri);
    }

    public static boolean m4009a(Uri uri) {
        return C0854s.m4013b(uri) || C0854s.m4010a(uri.toString());
    }

    private static boolean m4010a(String uri) {
        if (TextUtils.isEmpty(uri) || !uri.contains(".")) {
            return false;
        }
        uri = MimeTypeMap.getSingleton().getMimeTypeFromExtension(uri.substring(uri.lastIndexOf(".") + 1));
        if (uri == null) {
            return false;
        }
        if (uri.contains("audio") || uri.contains("application")) {
            return true;
        }
        return false;
    }

    public static boolean m4012b(Context context, Uri contentUri) {
        try {
            String uriPath = C0854s.m4014c(context, contentUri);
            if (TextUtils.isEmpty(uriPath) || !C0854s.m4010a(uriPath)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            C0850q.m3984a(e);
            return false;
        }
    }

    public static String m4014c(Context context, Uri uri) {
        Cursor cursor = null;
        String path;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(path)) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return path;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (SecurityException e) {
            if (C0810h.f2127a) {
                path = C0854s.m4015d(context, uri);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e2) {
            C0970a.m4322a(e2);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        throw new Exception("cannot find a valid uri for: " + uri);
    }

    @TargetApi(19)
    private static String m4015d(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            String path = "";
            String[] column = new String[]{"_data"};
            String id = DocumentsContract.getDocumentId(uri).split(":")[1];
            cursor = context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, column, "_id =?", new String[]{id}, null);
            if (cursor != null && cursor.moveToNext()) {
                path = cursor.getString(0);
            }
            if (TextUtils.isEmpty(path)) {
                if (cursor != null) {
                    cursor.close();
                }
                throw new Exception("cannot find a valid uri for: " + uri);
            }
            if (cursor != null) {
                cursor.close();
            }
            return path;
        } catch (Exception ignored) {
            C0970a.m4322a(ignored);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static boolean m4013b(Uri uri) {
        return uri != null && uri.toString().contains("content://com.android.providers.media.documents/document/");
    }

    public static boolean m4008a(Context context, String prefsKey, long[] idsToIgnore) {
        if (idsToIgnore != null && idsToIgnore.length > 0) {
            SharedPreferences prefs = ac.m3774b(context);
            String deletedIds = C0695c.m3156a(prefs, prefsKey, idsToIgnore);
            if (!TextUtils.isEmpty(deletedIds)) {
                prefs.edit().putString(prefsKey, deletedIds).apply();
                return true;
            }
        }
        return false;
    }

    public static void m4006a(Context context, Long[] invalidIds) {
        ac.m3774b(context).edit().putString("invalid_items", TextUtils.join(",", invalidIds)).apply();
    }

    public static String[] m4011a(Context context) {
        String invalidIds = ac.m3774b(context).getString("invalid_items", "");
        if (TextUtils.isEmpty(invalidIds)) {
            return new String[0];
        }
        return invalidIds.split(",");
    }
}
