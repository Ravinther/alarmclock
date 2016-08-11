package com.avg.toolkit.license.p053a;

import android.text.TextUtils;
import com.avg.toolkit.ITKSvc;
import com.avg.toolkit.license.p053a.C1010h.C1001a;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;

/* renamed from: com.avg.toolkit.license.a.d */
public class C0993d {

    /* renamed from: com.avg.toolkit.license.a.d.1 */
    static /* synthetic */ class C09921 {
        static final /* synthetic */ int[] f2979a;

        static {
            f2979a = new int[C1001a.values().length];
            try {
                f2979a[C1001a.LIC_AVG_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2979a[C1001a.LIC_AVG_9.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2979a[C1001a.LIC_AVG_10.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static String m4398a(C1001a avgVersion, String sText) {
        switch (C09921.f2979a[avgVersion.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
                return C0993d.m4405c(C0993d.m4402b(C0993d.m4399a(sText.toUpperCase().replace(" ", ""))));
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return C0993d.m4407e(C0993d.m4402b(C0993d.m4406d(C0993d.m4399a(sText.toUpperCase().replace(" ", "")))));
            default:
                return sText;
        }
    }

    public static char m4395a(C1001a avgVersion, char chr) {
        String sText = C0993d.m4398a(avgVersion, Character.toString(chr));
        if (TextUtils.isEmpty(sText)) {
            return chr;
        }
        return sText.charAt(0);
    }

    static String m4399a(String value) {
        return value.replace(ITKSvc.CODEREVISION, "O");
    }

    static String m4402b(String value) {
        return value.replace("5", "S");
    }

    static String m4405c(String value) {
        return value.replace("1", "L").replace("I", "L");
    }

    static String m4406d(String value) {
        return value.replace("1", "I");
    }

    static String m4407e(String value) {
        return value.replace("8", "B");
    }

    public static char m4396a(String[] sTexts) {
        String sText = sTexts[0];
        if (TextUtils.isEmpty(sText)) {
            throw new ArrayIndexOutOfBoundsException();
        }
        char result = sText.charAt(0);
        if (sText.length() == 1) {
            sText = "";
        } else {
            sText = sText.substring(1);
        }
        sTexts[0] = sText;
        return result;
    }

    public static void m4401a(C1001a avgVersion, String licenseNumberBase, String licenseNumberCRC, String[] retval) {
        int len = licenseNumberBase.length();
        if (len < 6) {
            throw new ArrayIndexOutOfBoundsException();
        }
        switch (C09921.f2979a[avgVersion.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
                licenseNumberCRC = licenseNumberBase.substring(len - 4, len);
                licenseNumberBase = C1016n.m4425a(licenseNumberBase, len - 4, 4);
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                licenseNumberCRC = C1016n.m4425a(licenseNumberBase.substring(len - 5, len), 3, 1);
                licenseNumberBase = C1016n.m4425a(licenseNumberBase, len - 5, 5);
                break;
        }
        retval[0] = licenseNumberBase;
        retval[1] = licenseNumberCRC;
    }

    public static void m4404b(C1001a avgVersion, String licenseNumberBase, String licenseNumberCRC, String[] retval) {
        int len = licenseNumberBase.length();
        if (len < 5) {
            throw new ArrayIndexOutOfBoundsException();
        }
        licenseNumberCRC = licenseNumberBase.substring(len - 4, len);
        switch (C09921.f2979a[avgVersion.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
                int dashPos = licenseNumberBase.indexOf("-");
                if (dashPos == -1) {
                    throw new ArrayIndexOutOfBoundsException();
                } else if (len - dashPos != 30 || licenseNumberBase.charAt(len - 6) != '-') {
                    if (licenseNumberBase.charAt(len - 5) == '-') {
                        licenseNumberBase = C1016n.m4425a(licenseNumberBase, len - 5, 5);
                        break;
                    }
                    throw new ArrayIndexOutOfBoundsException();
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                if (len != 31 || licenseNumberBase.charAt(len - 2) != '-') {
                    licenseNumberBase = C1016n.m4425a(licenseNumberBase, len - 4, 4);
                    break;
                }
                throw new ArrayIndexOutOfBoundsException();
                break;
        }
        retval[0] = licenseNumberBase;
        retval[1] = licenseNumberCRC;
    }

    static C1001a m4397a(String[] sLicenses, boolean bCutVersion) {
        C1001a version = C1001a.LIC_AVG_UNKNOWN;
        int len = sLicenses[0].length();
        if (len >= 2 && version == C1001a.LIC_AVG_UNKNOWN) {
            if (sLicenses[0].startsWith("70")) {
                version = C1001a.LIC_AVG_70;
                if (bCutVersion) {
                    sLicenses[0] = C1016n.m4425a(sLicenses[0], 0, 2);
                }
            } else if (sLicenses[0].startsWith("75")) {
                version = C1001a.LIC_AVG_75;
                if (bCutVersion) {
                    sLicenses[0] = C1016n.m4425a(sLicenses[0], 0, 2);
                }
            }
        }
        if (len < 1 || version != C1001a.LIC_AVG_UNKNOWN) {
            return version;
        }
        if (sLicenses[0].charAt(0) == '8') {
            version = C1001a.LIC_AVG_8;
            if (!bCutVersion) {
                return version;
            }
            sLicenses[0] = C1016n.m4425a(sLicenses[0], 0, 1);
            return version;
        } else if (sLicenses[0].charAt(0) == '9') {
            version = C1001a.LIC_AVG_9;
            if (!bCutVersion) {
                return version;
            }
            sLicenses[0] = C1016n.m4425a(sLicenses[0], 0, 1);
            return version;
        } else if (len == 35 || len == 31 || len == 26) {
            return C1001a.LIC_AVG_10;
        } else {
            return version;
        }
    }

    public static String m4400a(String[] sText, int len) {
        try {
            String sCut = sText[0].substring(0, len);
            sText[0] = C1016n.m4425a(sText[0], 0, len);
            return sCut;
        } catch (Exception e) {
            throw new C0988a(3);
        }
    }

    public static String m4403b(String[] sText) {
        return C0993d.m4400a(sText, sText[0].indexOf(45));
    }
}
