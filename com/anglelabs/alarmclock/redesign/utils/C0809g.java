package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import com.alarmclock.xtreme.free.R;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.g */
public class C0809g {
    public static int m3826a(Context context) {
        switch (C0809g.m3828b(context)) {
            case Base64.NO_PADDING /*1*/:
                return -1;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return -2;
            default:
                return 0;
        }
    }

    public static int m3827a(Context context, int originalIndex) {
        originalIndex += C0809g.m3826a(context);
        if (originalIndex < 0) {
            originalIndex += 7;
        }
        return originalIndex % 7;
    }

    public static int m3829b(Context context, int originalIndex) {
        return (originalIndex + (C0809g.m3826a(context) * -1)) % 7;
    }

    public static int m3828b(Context context) {
        return Integer.valueOf(C0860w.m4029a(context)).intValue();
    }

    public static String[] m3830c(Context context) {
        switch (C0809g.m3828b(context)) {
            case Base64.NO_PADDING /*1*/:
                return C0809g.m3831c(context, 1);
            case Base64.NO_WRAP /*2*/:
                return context.getResources().getStringArray(R.array.days_of_week_abbreviated);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return C0809g.m3831c(context, 2);
            default:
                return context.getResources().getStringArray(R.array.days_of_week_abbreviated);
        }
    }

    private static String[] m3831c(Context context, int offset) {
        String[] originalArray = context.getResources().getStringArray(R.array.days_of_week_abbreviated);
        for (int j = 0; j < offset; j++) {
            String lastDay = originalArray[originalArray.length - 1];
            for (int i = originalArray.length - 1; i > 0; i--) {
                originalArray[i] = originalArray[i - 1];
            }
            originalArray[0] = lastDay;
        }
        return originalArray;
    }
}
