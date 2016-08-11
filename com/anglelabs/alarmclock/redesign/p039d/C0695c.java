package com.anglelabs.alarmclock.redesign.p039d;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.anglelabs.alarmclock.redesign.p039d.p040a.C0691e.C0690a;
import com.anglelabs.alarmclock.redesign.utils.C0854s;
import com.anglelabs.alarmclock.redesign.utils.ac;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: com.anglelabs.alarmclock.redesign.d.c */
public class C0695c {
    private static String m3159a(String[] args) {
        boolean isFirst = true;
        if (args == null) {
            return "";
        }
        StringBuilder inSelectionBuilder = new StringBuilder();
        for (String arg : args) {
            if (isFirst) {
                isFirst = false;
            } else {
                inSelectionBuilder.append(",");
            }
            inSelectionBuilder.append("?");
        }
        return inSelectionBuilder.toString();
    }

    public static String m3157a(Uri url, String[] projectionIn, String selection, String[] selectionArgs, String sort) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("URI: ").append(url).append(" ").append("PROJECTION: ").append(projectionIn != null ? TextUtils.join(",", projectionIn) : "null").append(" ").append("SELECTION: ");
        if (selection == null) {
            selection = "null";
        }
        append = append.append(selection).append(" ").append("SELECTION_ARGS: ").append(selectionArgs != null ? TextUtils.join(",", selectionArgs) : "null").append(" ").append("SORT: ");
        if (sort == null) {
            sort = "null";
        }
        append.append(sort);
        return stringBuilder.toString();
    }

    public static String m3158a(String column, String[] args) {
        return column + " IN ( " + C0695c.m3159a(args) + " )";
    }

    public static String m3156a(SharedPreferences prefs, String ignoredItemsPrefsKey, long[] idsArray) {
        if (idsArray == null || idsArray.length <= 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        String previouslyDeleted = prefs.getString(ignoredItemsPrefsKey, "");
        builder.append(previouslyDeleted);
        if (!TextUtils.isEmpty(previouslyDeleted)) {
            builder.append(",");
        }
        builder.append(idsArray[0]);
        for (int i = 1; i < idsArray.length; i++) {
            builder.append(",").append(idsArray[i]);
        }
        return builder.toString();
    }

    public static HashSet m3160a(Context context, Cursor cursor, long playlistId) {
        return C0695c.m3161a(context, cursor, ac.m3774b(context).getString("deleted_ids_for_id_" + playlistId, ""));
    }

    public static HashSet m3161a(Context context, Cursor cursor, String deletedIds) {
        HashSet uniqueSongSet = new HashSet();
        if (cursor != null && cursor.moveToFirst()) {
            ArrayList invalidSongsIds = new ArrayList();
            do {
                int audioId = C0854s.m4004a(context, cursor.getString(cursor.getColumnIndex("title_key")));
                boolean isSongMarkedAsInvalid = false;
                boolean isMarkedAsIgnore = false;
                for (String invalidId : C0854s.m4011a(context)) {
                    if (audioId == Integer.valueOf(invalidId).intValue()) {
                        isSongMarkedAsInvalid = true;
                        break;
                    }
                }
                if (!(isSongMarkedAsInvalid || TextUtils.isEmpty(deletedIds))) {
                    for (String deletedId : deletedIds.split(",")) {
                        if (audioId == Integer.valueOf(deletedId).intValue()) {
                            isMarkedAsIgnore = true;
                            break;
                        }
                    }
                }
                if (!(isSongMarkedAsInvalid || isMarkedAsIgnore)) {
                    String uri = cursor.getString(4);
                    if (uri != null) {
                        if (C0854s.m4007a(context, Uri.parse(uri))) {
                            uniqueSongSet.add(new C0690a(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), audioId, cursor.getString(4)));
                        }
                    }
                    invalidSongsIds.add(Long.valueOf((long) audioId));
                }
            } while (cursor.moveToNext());
            if (invalidSongsIds.size() > 0) {
                C0854s.m4006a(context, (Long[]) invalidSongsIds.toArray(new Long[invalidSongsIds.size()]));
            }
        }
        return uniqueSongSet;
    }
}
