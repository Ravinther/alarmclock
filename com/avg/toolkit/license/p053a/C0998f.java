package com.avg.toolkit.license.p053a;

import android.text.TextUtils;
import com.avg.toolkit.license.p053a.C1010h.C1001a;
import com.avg.toolkit.license.p053a.C1010h.C1002b;
import com.avg.toolkit.license.p053a.C1010h.C1004d;
import com.avg.toolkit.license.p053a.C1010h.C1005e;
import com.avg.toolkit.license.p053a.C1010h.C1007g;
import com.avg.toolkit.license.p053a.C1010h.C1008h;
import com.avg.toolkit.license.p053a.C1010h.C1009i;
import com.avg.toolkit.p049e.C0970a;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationStatusCodes;
import com.millennialmedia.android.MMException;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p000a.p001a.p002a.p003a.p005b.C0003a;

/* renamed from: com.avg.toolkit.license.a.f */
public class C0998f {
    static final C0996a[] f2989a;
    static final int f2990b;
    static final C0996a[] f2991c;
    static final int f2992d;
    C0997b f2993e;

    /* renamed from: com.avg.toolkit.license.a.f.1 */
    static /* synthetic */ class C09951 {
        static final /* synthetic */ int[] f2985a;

        static {
            f2985a = new int[C1001a.values().length];
            try {
                f2985a[C1001a.LIC_AVG_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2985a[C1001a.LIC_AVG_9.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2985a[C1001a.LIC_AVG_10.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.avg.toolkit.license.a.f.a */
    static class C0996a {
        public int f2986a;
        public int f2987b;
        public long f2988c;

        public C0996a(int amask, int ashift, long akey) {
            this.f2986a = amask;
            this.f2987b = ashift;
            this.f2988c = akey;
        }
    }

    /* renamed from: com.avg.toolkit.license.a.f.b */
    class C0997b {
        public C1008h m4408a(char licNumBase) {
            return C1008h.LIC_RT_COULD_NOT_VERIFY;
        }
    }

    static {
        f2989a = new C0996a[]{new C0996a(1015808, 15, 7562331041294894367L)};
        f2990b = f2989a.length;
        f2991c = new C0996a[]{new C0996a(1015808, 15, -4627673907431431335L)};
        f2992d = f2991c.length;
    }

    public void m4414a(C1014l analyzeResult, String licenseNumber, C0999g changeResult) {
        C1008h refusingTypePtr;
        int crc1;
        licenseNumber = m4411a(licenseNumber).toUpperCase();
        C1001a licVersion = C1001a.LIC_AVG_UNKNOWN;
        String[] licenseNumbers = new String[]{licenseNumber};
        licVersion = C0993d.m4397a(licenseNumbers, false);
        licenseNumber = licenseNumbers[0];
        if (licVersion == C1001a.LIC_AVG_UNKNOWN) {
            throw new C0988a(2);
        } else if (licVersion != C1001a.LIC_AVG_70 && licVersion != C1001a.LIC_AVG_75) {
            if (licenseNumber.length() < 26) {
                throw new C0988a(3);
            }
            analyzeResult.f3106b.f3093q = C0993d.m4398a(licVersion, licenseNumber);
            analyzeResult.f3107c = C1009i.LACV_NOT_GIVEN;
            analyzeResult.f3108d = C1009i.LACV_NOT_GIVEN;
            String firstPart = licenseNumber;
            String secondPart = "";
            String thirdPart = "";
            String licenseNumberBase0 = "";
            String licenseNumberBase1 = "";
            String licenseNumberBase1Original = "";
            String licenseNumber1Crc1 = "";
            String licenseNumberBase2 = "";
            String licenseNumberBase2Original = "";
            String licenseNumber2Crc1 = "";
            String licenseNumber2Crc2 = "";
            String[] strings;
            if (licVersion == C1001a.LIC_AVG_8 || licVersion == C1001a.LIC_AVG_9) {
                int len = firstPart.length();
                if (firstPart.charAt(len - 5) != '-' || len < 36) {
                    if (firstPart.charAt(len - 6) != '-' || len < 31) {
                        if (firstPart.charAt(len - 2) != '-' || len < 27) {
                            throw new C0988a(3);
                        }
                        licenseNumberBase0 = firstPart;
                    } else {
                        strings = new String[]{firstPart, secondPart};
                        C0993d.m4401a(licVersion, firstPart, secondPart, strings);
                        licenseNumberBase1 = strings[0];
                        licenseNumber1Crc1 = strings[1];
                    }
                } else {
                    String[] thirdParts = new String[]{thirdPart};
                    C0993d.m4404b(licVersion, firstPart, thirdPart, thirdParts);
                    thirdPart = thirdParts[0];
                    licenseNumberBase1 = firstPart;
                    licenseNumber1Crc1 = thirdPart;
                    String[] secondParts = new String[]{firstPart, secondPart};
                    C0993d.m4401a(licVersion, firstPart, secondPart, secondParts);
                    licenseNumberBase2 = secondParts[0];
                    licenseNumber2Crc1 = secondParts[1];
                    licenseNumber2Crc2 = thirdPart;
                }
            } else if (licVersion == C1001a.LIC_AVG_10) {
                switch (firstPart.length()) {
                    case MMException.AD_NO_ACTIVITY /*26*/:
                        licenseNumberBase0 = firstPart;
                        break;
                    case 31:
                        strings = new String[]{firstPart, secondPart};
                        C0993d.m4401a(licVersion, firstPart, secondPart, strings);
                        licenseNumberBase1 = strings[0];
                        licenseNumber1Crc1 = strings[1];
                        break;
                    case 35:
                        strings = new String[]{firstPart, thirdPart};
                        C0993d.m4404b(licVersion, firstPart, thirdPart, strings);
                        firstPart = strings[0];
                        thirdPart = strings[1];
                        licenseNumberBase1 = firstPart;
                        licenseNumber1Crc1 = thirdPart;
                        strings = new String[]{firstPart, secondPart};
                        C0993d.m4401a(licVersion, firstPart, secondPart, strings);
                        licenseNumberBase2 = strings[0];
                        licenseNumber2Crc1 = strings[1];
                        licenseNumber2Crc2 = thirdPart;
                        break;
                    default:
                        throw new C0988a(3);
                }
            }
            C1008h refusingType = C1008h.LIC_RT_VALID;
            if (changeResult.f2994a != C1008h.LIC_RT_COULD_NOT_VERIFY) {
                refusingTypePtr = changeResult.f2994a;
            } else {
                refusingTypePtr = refusingType;
            }
            int i;
            try {
                if ((licVersion == C1001a.LIC_AVG_8 || licVersion == C1001a.LIC_AVG_9 || licVersion == C1001a.LIC_AVG_10) && !(licenseNumber2Crc1.length() == 4 && licenseNumber2Crc2.length() == 4)) {
                    throw new C0988a(1);
                }
                refusingTypePtr = m4410a(licenseNumberBase2, refusingTypePtr);
                licenseNumberBase2Original = licenseNumberBase2;
                m4413a(analyzeResult.f3106b, licenseNumberBase2);
                C0993d.m4398a(licVersion, licenseNumberBase2);
                C0993d.m4398a(licVersion, licenseNumber2Crc1);
                C0993d.m4398a(licVersion, licenseNumber2Crc2);
                String licenseNumberBase2Mb = C1013k.m4424a(licenseNumberBase2);
                crc1 = C0991c.m4394a(licVersion, licenseNumber2Crc1);
                int crc2 = C0991c.m4394a(licVersion, licenseNumber2Crc2);
                analyzeResult.f3106b.f3092p = crc1;
                try {
                    analyzeResult.f3107c = C1009i.LACV_INVALID;
                    for (i = 0; i < f2990b; i++) {
                        m4415a(licenseNumberBase2Mb, crc1, f2989a[i].f2986a, f2989a[i].f2987b, f2989a[i].f2988c);
                        if (i == 0) {
                            analyzeResult.f3107c = C1009i.LACV_GENERATED;
                        }
                    }
                    analyzeResult.f3107c = C1009i.LACV_VALID;
                } catch (Exception e) {
                }
                try {
                    analyzeResult.f3108d = C1009i.LACV_INVALID;
                    for (i = 0; i < f2992d; i++) {
                        m4415a(licenseNumberBase2Mb, crc2, f2991c[i].f2986a, f2991c[i].f2987b, f2991c[i].f2988c);
                        if (i == 0) {
                            analyzeResult.f3108d = C1009i.LACV_GENERATED;
                        }
                    }
                    analyzeResult.f3108d = C1009i.LACV_VALID;
                } catch (Exception e2) {
                }
                analyzeResult.f3105a = licenseNumberBase2Original;
            } catch (C0988a e3) {
                if (e3.f2973a == 3758162951L) {
                    throw new C0988a(999);
                } else if (licenseNumber1Crc1.length() != 4) {
                    throw new C0988a(1);
                } else {
                    refusingTypePtr = m4410a(licenseNumberBase1, refusingTypePtr);
                    licenseNumberBase1Original = licenseNumberBase1;
                    m4413a(analyzeResult.f3106b, licenseNumberBase1);
                    licenseNumberBase1 = C0993d.m4398a(licVersion, licenseNumberBase1);
                    crc1 = C0991c.m4394a(licVersion, C0993d.m4398a(licVersion, licenseNumber1Crc1));
                    analyzeResult.f3106b.f3092p = crc1;
                    String licenseNumberBase1Mb = C1013k.m4424a(licenseNumberBase1);
                    try {
                        analyzeResult.f3107c = C1009i.LACV_INVALID;
                        for (i = 0; i < f2990b; i++) {
                            m4415a(licenseNumberBase1Mb, crc1, f2989a[i].f2986a, f2989a[i].f2987b, f2989a[i].f2988c);
                            if (i == 0) {
                                analyzeResult.f3107c = C1009i.LACV_GENERATED;
                            }
                        }
                        analyzeResult.f3107c = C1009i.LACV_VALID;
                    } catch (Exception e4) {
                    }
                    analyzeResult.f3105a = licenseNumberBase1Original;
                }
            } catch (C0988a ee) {
                if (ee.f2973a == 3758162951L) {
                    throw new C0988a(999);
                }
                refusingTypePtr = m4410a(licenseNumberBase0, refusingTypePtr);
                m4413a(analyzeResult.f3106b, licenseNumberBase0);
                analyzeResult.f3105a = licenseNumberBase0;
            }
        }
    }

    String m4411a(String value) {
        return value.trim();
    }

    C1008h m4410a(String licenseNumberBase, C1008h refusingType) {
        if (this.f2993e == null) {
            return C1008h.LIC_RT_VALID;
        }
        refusingType = this.f2993e.m4408a(licenseNumberBase.charAt(0));
        if (refusingType == C1008h.LIC_RT_COULD_NOT_VERIFY) {
            throw new C0988a(4);
        } else if (refusingType == C1008h.LIC_RT_VALID) {
            return refusingType;
        } else {
            throw new C0988a(3758162951L);
        }
    }

    byte[] m4417a(String licenseNumberBase, byte[] initialVector) {
        byte[] bytes = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(initialVector);
            m.update(licenseNumberBase.getBytes());
            bytes = m.digest();
        } catch (NoSuchAlgorithmException e) {
            C0970a.m4325b("noalg");
        }
        return bytes;
    }

    void m4415a(String licenseNumberBaseMb, int licenseNumberCRC, int mask, int shift, long key) {
        if (((long) ((m4417a(licenseNumberBaseMb, m4416a(key))[0] << shift) & mask)) != ((long) (licenseNumberCRC & mask))) {
            throw new C0988a(3);
        }
    }

    void m4413a(C1011i parameters, String licenseNumberBase) {
        C1015m parserState = new C1015m();
        parameters.f3077a = C0993d.m4397a(new String[]{licenseNumberBase}, false);
        String localLicenseKeyID = licenseNumberBase;
        String[] licenseNumbers = new String[]{licenseNumberBase};
        parameters.f3077a = C0993d.m4397a(licenseNumbers, true);
        licenseNumberBase = licenseNumbers[0];
        if (parameters.f3077a == C1001a.LIC_AVG_UNKNOWN) {
            throw new C0988a(3);
        }
        String[] licenseNumberBases;
        parserState.f3109a = C1010h.m4419a(parameters.f3077a, parameters.f3078b.byteValue());
        switch (C09951.f2985a[parameters.f3077a.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
                licenseNumberBases = new String[]{licenseNumberBase};
                parameters.f3079c = C0993d.m4403b(licenseNumberBases);
                licenseNumberBase = licenseNumberBases[0];
                break;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                licenseNumberBases = new String[]{licenseNumberBase};
                parameters.f3079c = C0993d.m4400a(licenseNumberBases, 1);
                licenseNumberBase = licenseNumberBases[0];
                break;
        }
        licenseNumberBase = C0993d.m4398a(parameters.f3077a, licenseNumberBase);
        localLicenseKeyID = C0993d.m4398a(parameters.f3077a, localLicenseKeyID);
        switch (C09951.f2985a[parameters.f3077a.ordinal()]) {
            case Base64.NO_PADDING /*1*/:
            case Base64.NO_WRAP /*2*/:
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                int dwShift;
                C0990b licArray = new C0990b(parameters.f3077a);
                if (parameters.f3077a == C1001a.LIC_AVG_8 || parameters.f3077a == C1001a.LIC_AVG_9) {
                    if (licenseNumberBase.length() != 26) {
                        throw new C0988a(3);
                    }
                    dwShift = 0;
                } else if (licenseNumberBase.length() != 25) {
                    throw new C0988a(3);
                } else {
                    dwShift = 1;
                }
                int i = 0;
                while (!TextUtils.isEmpty(licenseNumberBase)) {
                    if ((i + dwShift) % 5 == 0) {
                        licenseNumberBases = new String[]{licenseNumberBase};
                        if (C0993d.m4396a(licenseNumberBases) != '-') {
                            throw new C0988a(3);
                        }
                        licenseNumberBase = licenseNumberBases[0];
                    }
                    licenseNumberBases = new String[]{licenseNumberBase};
                    char currentChar = C0993d.m4396a(licenseNumberBases);
                    licenseNumberBase = licenseNumberBases[0];
                    licArray.m4386a(C0993d.m4395a(parameters.f3077a, currentChar));
                    i++;
                }
                if (licArray.m4384a() == LocationRequest.PRIORITY_NO_POWER) {
                    m4412a(parameters, parserState, licArray);
                    break;
                }
                throw new C0988a(3);
        }
        parameters.m4420a();
        parameters.f3094r = localLicenseKeyID;
    }

    void m4412a(C1011i parameters, C1015m parserState, C0990b alicArray) {
        C0990b licArray = new C0990b(parameters.f3077a);
        C1011i localParameters = new C1011i();
        localParameters.m4422a(parameters);
        licArray.m4389a(alicArray);
        m4409a(licArray);
        int number = licArray.m4390b(0, 2);
        if (number == 0 || number == 1) {
            localParameters.f3078b = Byte.valueOf((byte) number);
            number = licArray.m4390b(2, 3);
            if (number >= C0994e.f2981e) {
                throw new C0988a(999);
            }
            localParameters.f3080d = C0994e.f2980d[number].f2982a;
            localParameters.f3087k = C0994e.f2980d[number].f2983b;
            localParameters.f3090n = C0994e.f2980d[number].f2984c;
            parserState.f3111c = true;
            number = licArray.m4390b(5, 10);
            if (number > 670) {
                throw new C0988a(999);
            }
            C1007g localPredefinedProducts;
            if (number <= 100) {
                localParameters.f3096t = number;
            } else if (number > 100 && number <= 280) {
                localParameters.f3096t = ((number - 100) * 5) + 100;
            } else if (number > 280 && number <= 460) {
                localParameters.f3096t = ((number - 280) * 50) + LocationStatusCodes.GEOFENCE_NOT_AVAILABLE;
            } else if (number > 460 && number <= 640) {
                localParameters.f3096t = ((number - 460) * 500) + CustomEventBannerAdapter.DEFAULT_BANNER_TIMEOUT_DELAY;
            } else if (number > 640 && number <= 670) {
                localParameters.f3096t = ((number - 640) * 5000) + 100000;
            }
            parserState.f3114f = true;
            if (localParameters.f3080d == C1005e.LIC_LT_FREE) {
                localParameters.f3084h = C1004d.LIC_EX_UNDEFINED;
                localParameters.f3085i = 0;
                localParameters.f3086j = Long.MAX_VALUE;
            } else if (licArray.m4390b(15, 1) == 0) {
                localParameters.f3084h = C1004d.LIC_EX_VALIDITY_PERIOD;
                if (localParameters.f3078b.byteValue() == null) {
                    localParameters.f3085i = licArray.m4390b(16, 7);
                    localParameters.f3086j = Long.MAX_VALUE;
                } else if (localParameters.f3078b.byteValue() == 1) {
                    localParameters.f3085i = licArray.m4390b(16, 7);
                    if (licArray.m4390b(23, 1) == 1) {
                        localParameters.f3085i = (localParameters.f3085i * 15) + 135;
                    }
                    localParameters.f3086j = Long.MAX_VALUE;
                }
            } else {
                localParameters.f3084h = C1004d.LIC_EX_FIXED_DATE;
                localParameters.f3086j = (localParameters.f3077a == C1001a.LIC_AVG_10 ? 129067776000000000L : 128436192000000000L) + (864000000000L * ((long) licArray.m4390b(16, 12)));
                localParameters.f3085i = 0;
            }
            parserState.f3112d = true;
            localParameters.f3083g = licArray.m4390b(28, 6);
            number = licArray.m4390b(34, 9);
            switch (number) {
                case 200:
                    localPredefinedProducts = C1007g.LIC_PREP_GMS_PROTECTION;
                    break;
                case 201:
                    localPredefinedProducts = C1007g.LIC_PREP_GMS_PERFORMANCE;
                    break;
                case 251:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_BASIC_ANDROID;
                    break;
                case 256:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_ADVANCED_ANDROID;
                    break;
                case 261:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_FULL_ANDROID;
                    break;
                case 276:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_LINK_SCANNER_ANDROID;
                    break;
                case 301:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_BASIC_ANDROID_TABLET;
                    break;
                case 302:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_ADVANCED_ANDROID_TABLET;
                    break;
                case 303:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_FULL_ANDROID_TABLET;
                    break;
                case 305:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_VAULT_ANDROID;
                    break;
                case 308:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_CLEANER_ANDROID;
                    break;
                case 309:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_IMAGE_SHRINKER_ANDROID;
                    break;
                case 311:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_CONNECT_ANDROID;
                    break;
                case 312:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_TUNEUP_MINIAPP_ANDROID;
                    break;
                case 313:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_CALLMSG_BLOCKER_ANDROID;
                    break;
                case 314:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_ANTITHEFT_MINIAPP_ANDROID;
                    break;
                case 315:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_ANTIVIRUS_LIGHT_MINIAPP_ANDROID;
                    break;
                case 316:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_ALARMCLOCK_ANDROID;
                    break;
                case 323:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_UNINSTALLER_ANDROID;
                    break;
                case 325:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_TOOLKIT_DEMO_APP;
                    break;
                case 327:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_PREMIUM_BASIC_ANDROID;
                    break;
                case 328:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_PREMIUM_ADVANCED_ANDROID;
                    break;
                case 329:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_PREMIUM_FULL_ANDROID;
                    break;
                case 330:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_PREMIUM_BASIC_ANDROID_TABLET;
                    break;
                case 331:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_PREMIUM_ADVANCED_ANDROID_TABLET;
                    break;
                case 332:
                    localPredefinedProducts = C1007g.LIC_PREP_MOBILATION_PREMIUM_FULL_ANDROID_TABLET;
                    break;
                case 333:
                    localPredefinedProducts = C1007g.LIC_PREP_FAMILY_CENTER;
                    break;
                default:
                    localPredefinedProducts = C1007g.LIC_PREP_CUSTOM;
                    break;
            }
            parserState.f3113e = true;
            localParameters.m4421a(localPredefinedProducts);
            localParameters.f3082f = number;
            localParameters.f3089m = licArray.m4390b(43, 10);
            parserState.f3110b = true;
            number = licArray.m4390b(53, 7);
            localParameters.f3088l.clear();
            if (number != 0) {
                localParameters.f3088l.add(Integer.valueOf(number - 1));
            }
            number = licArray.m4390b(60, 7);
            if (number != 0) {
                localParameters.f3088l.add(Integer.valueOf(number - 1));
            }
            number = licArray.m4390b(67, 7);
            if (number != 0) {
                localParameters.f3088l.add(Integer.valueOf(number - 1));
            }
            localParameters.f3097u = licArray.m4390b(74, 28);
            localParameters.f3091o = C1002b.values()[licArray.m4390b(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY, 2)];
            localParameters.m4422a(parameters);
            return;
        }
        throw new C0988a(999);
    }

    C0990b m4409a(C0990b alicArray) {
        byte[] hash = C0003a.m34b(String.format("%c%c", new Object[]{Character.valueOf(alicArray.m4383a(14)), Character.valueOf(alicArray.m4383a(15))}));
        int hashPos = 0;
        int i = 0;
        while (i < 21) {
            if (!(i == 0 || i == 14 || i == 15)) {
                alicArray.m4388a(alicArray.m4390b(i * 5, 5) ^ (hash[hashPos] & 31), i * 5, 5);
                if (hashPos == 15) {
                    hashPos = 0;
                } else {
                    hashPos++;
                }
            }
            i++;
        }
        return alicArray;
    }

    public final byte[] m4416a(long v) {
        return new byte[]{(byte) ((int) (v >>> 56)), (byte) ((int) (v >>> 48)), (byte) ((int) (v >>> 40)), (byte) ((int) (v >>> 32)), (byte) ((int) (v >>> 24)), (byte) ((int) (v >>> 16)), (byte) ((int) (v >>> 8)), (byte) ((int) (v >>> 0))};
    }
}
