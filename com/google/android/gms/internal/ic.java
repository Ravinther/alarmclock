package com.google.android.gms.internal;

import android.os.Parcel;
import com.avg.ui.general.C1091c.C1087k;
import com.google.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ga.C1912a;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.millennialmedia.android.C2513R;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMRequest;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ic extends ga implements SafeParcelable, ItemScope {
    public static final id CREATOR;
    private static final HashMap UI;
    private String HD;
    private double NX;
    private double NY;
    private String Rd;
    private final Set UJ;
    private ic UK;
    private List UL;
    private ic UM;
    private String UN;
    private String UO;
    private String UP;
    private List UQ;
    private int UR;
    private List US;
    private ic UT;
    private List UU;
    private String UV;
    private String UW;
    private ic UX;
    private String UY;
    private String UZ;
    private String VA;
    private String VB;
    private String VC;
    private String VD;
    private List Va;
    private String Vb;
    private String Vc;
    private String Vd;
    private String Ve;
    private String Vf;
    private String Vg;
    private String Vh;
    private String Vi;
    private ic Vj;
    private String Vk;
    private String Vl;
    private String Vm;
    private ic Vn;
    private ic Vo;
    private ic Vp;
    private List Vq;
    private String Vr;
    private String Vs;
    private String Vt;
    private String Vu;
    private ic Vv;
    private String Vw;
    private String Vx;
    private String Vy;
    private ic Vz;
    private String lY;
    private String mName;
    private String ro;
    private String wp;
    private final int xH;

    static {
        CREATOR = new id();
        UI = new HashMap();
        UI.put("about", C1912a.m8549a("about", 2, ic.class));
        UI.put("additionalName", C1912a.m8556k("additionalName", 3));
        UI.put("address", C1912a.m8549a("address", 4, ic.class));
        UI.put("addressCountry", C1912a.m8555j("addressCountry", 5));
        UI.put("addressLocality", C1912a.m8555j("addressLocality", 6));
        UI.put("addressRegion", C1912a.m8555j("addressRegion", 7));
        UI.put("associated_media", C1912a.m8550b("associated_media", 8, ic.class));
        UI.put("attendeeCount", C1912a.m8552g("attendeeCount", 9));
        UI.put("attendees", C1912a.m8550b("attendees", 10, ic.class));
        UI.put("audio", C1912a.m8549a("audio", 11, ic.class));
        UI.put("author", C1912a.m8550b("author", 12, ic.class));
        UI.put("bestRating", C1912a.m8555j("bestRating", 13));
        UI.put("birthDate", C1912a.m8555j("birthDate", 14));
        UI.put("byArtist", C1912a.m8549a("byArtist", 15, ic.class));
        UI.put("caption", C1912a.m8555j("caption", 16));
        UI.put("contentSize", C1912a.m8555j("contentSize", 17));
        UI.put("contentUrl", C1912a.m8555j("contentUrl", 18));
        UI.put("contributor", C1912a.m8550b("contributor", 19, ic.class));
        UI.put("dateCreated", C1912a.m8555j("dateCreated", 20));
        UI.put("dateModified", C1912a.m8555j("dateModified", 21));
        UI.put("datePublished", C1912a.m8555j("datePublished", 22));
        UI.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, C1912a.m8555j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        UI.put("duration", C1912a.m8555j("duration", 24));
        UI.put("embedUrl", C1912a.m8555j("embedUrl", 25));
        UI.put("endDate", C1912a.m8555j("endDate", 26));
        UI.put("familyName", C1912a.m8555j("familyName", 27));
        UI.put(MMRequest.KEY_GENDER, C1912a.m8555j(MMRequest.KEY_GENDER, 28));
        UI.put(Event.INTENT_MAPS, C1912a.m8549a(Event.INTENT_MAPS, 29, ic.class));
        UI.put("givenName", C1912a.m8555j("givenName", 30));
        UI.put(MMLayout.KEY_HEIGHT, C1912a.m8555j(MMLayout.KEY_HEIGHT, 31));
        UI.put("id", C1912a.m8555j("id", 32));
        UI.put("image", C1912a.m8555j("image", 33));
        UI.put("inAlbum", C1912a.m8549a("inAlbum", 34, ic.class));
        UI.put("latitude", C1912a.m8553h("latitude", 36));
        UI.put("location", C1912a.m8549a("location", 37, ic.class));
        UI.put("longitude", C1912a.m8553h("longitude", 38));
        UI.put("name", C1912a.m8555j("name", 39));
        UI.put("partOfTVSeries", C1912a.m8549a("partOfTVSeries", 40, ic.class));
        UI.put("performers", C1912a.m8550b("performers", 41, ic.class));
        UI.put("playerType", C1912a.m8555j("playerType", 42));
        UI.put("postOfficeBoxNumber", C1912a.m8555j("postOfficeBoxNumber", 43));
        UI.put("postalCode", C1912a.m8555j("postalCode", 44));
        UI.put("ratingValue", C1912a.m8555j("ratingValue", 45));
        UI.put("reviewRating", C1912a.m8549a("reviewRating", 46, ic.class));
        UI.put("startDate", C1912a.m8555j("startDate", 47));
        UI.put("streetAddress", C1912a.m8555j("streetAddress", 48));
        UI.put("text", C1912a.m8555j("text", 49));
        UI.put("thumbnail", C1912a.m8549a("thumbnail", 50, ic.class));
        UI.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, C1912a.m8555j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        UI.put("tickerSymbol", C1912a.m8555j("tickerSymbol", 52));
        UI.put("type", C1912a.m8555j("type", 53));
        UI.put(PlusShare.KEY_CALL_TO_ACTION_URL, C1912a.m8555j(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        UI.put(MMLayout.KEY_WIDTH, C1912a.m8555j(MMLayout.KEY_WIDTH, 55));
        UI.put("worstRating", C1912a.m8555j("worstRating", 56));
    }

    public ic() {
        this.xH = 1;
        this.UJ = new HashSet();
    }

    ic(Set set, int i, ic icVar, List list, ic icVar2, String str, String str2, String str3, List list2, int i2, List list3, ic icVar3, List list4, String str4, String str5, ic icVar4, String str6, String str7, String str8, List list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ic icVar5, String str18, String str19, String str20, String str21, ic icVar6, double d, ic icVar7, double d2, String str22, ic icVar8, List list6, String str23, String str24, String str25, String str26, ic icVar9, String str27, String str28, String str29, ic icVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.UJ = set;
        this.xH = i;
        this.UK = icVar;
        this.UL = list;
        this.UM = icVar2;
        this.UN = str;
        this.UO = str2;
        this.UP = str3;
        this.UQ = list2;
        this.UR = i2;
        this.US = list3;
        this.UT = icVar3;
        this.UU = list4;
        this.UV = str4;
        this.UW = str5;
        this.UX = icVar4;
        this.UY = str6;
        this.UZ = str7;
        this.lY = str8;
        this.Va = list5;
        this.Vb = str9;
        this.Vc = str10;
        this.Vd = str11;
        this.HD = str12;
        this.Ve = str13;
        this.Vf = str14;
        this.Vg = str15;
        this.Vh = str16;
        this.Vi = str17;
        this.Vj = icVar5;
        this.Vk = str18;
        this.Vl = str19;
        this.wp = str20;
        this.Vm = str21;
        this.Vn = icVar6;
        this.NX = d;
        this.Vo = icVar7;
        this.NY = d2;
        this.mName = str22;
        this.Vp = icVar8;
        this.Vq = list6;
        this.Vr = str23;
        this.Vs = str24;
        this.Vt = str25;
        this.Vu = str26;
        this.Vv = icVar9;
        this.Vw = str27;
        this.Vx = str28;
        this.Vy = str29;
        this.Vz = icVar10;
        this.VA = str30;
        this.VB = str31;
        this.Rd = str32;
        this.ro = str33;
        this.VC = str34;
        this.VD = str35;
    }

    public ic(Set set, ic icVar, List list, ic icVar2, String str, String str2, String str3, List list2, int i, List list3, ic icVar3, List list4, String str4, String str5, ic icVar4, String str6, String str7, String str8, List list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ic icVar5, String str18, String str19, String str20, String str21, ic icVar6, double d, ic icVar7, double d2, String str22, ic icVar8, List list6, String str23, String str24, String str25, String str26, ic icVar9, String str27, String str28, String str29, ic icVar10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.UJ = set;
        this.xH = 1;
        this.UK = icVar;
        this.UL = list;
        this.UM = icVar2;
        this.UN = str;
        this.UO = str2;
        this.UP = str3;
        this.UQ = list2;
        this.UR = i;
        this.US = list3;
        this.UT = icVar3;
        this.UU = list4;
        this.UV = str4;
        this.UW = str5;
        this.UX = icVar4;
        this.UY = str6;
        this.UZ = str7;
        this.lY = str8;
        this.Va = list5;
        this.Vb = str9;
        this.Vc = str10;
        this.Vd = str11;
        this.HD = str12;
        this.Ve = str13;
        this.Vf = str14;
        this.Vg = str15;
        this.Vh = str16;
        this.Vi = str17;
        this.Vj = icVar5;
        this.Vk = str18;
        this.Vl = str19;
        this.wp = str20;
        this.Vm = str21;
        this.Vn = icVar6;
        this.NX = d;
        this.Vo = icVar7;
        this.NY = d2;
        this.mName = str22;
        this.Vp = icVar8;
        this.Vq = list6;
        this.Vr = str23;
        this.Vs = str24;
        this.Vt = str25;
        this.Vu = str26;
        this.Vv = icVar9;
        this.Vw = str27;
        this.Vx = str28;
        this.Vy = str29;
        this.Vz = icVar10;
        this.VA = str30;
        this.VB = str31;
        this.Rd = str32;
        this.ro = str33;
        this.VC = str34;
        this.VD = str35;
    }

    protected boolean m8762a(C1912a c1912a) {
        return this.UJ.contains(Integer.valueOf(c1912a.ff()));
    }

    protected Object aq(String str) {
        return null;
    }

    protected boolean ar(String str) {
        return false;
    }

    protected Object m8763b(C1912a c1912a) {
        switch (c1912a.ff()) {
            case Base64.NO_WRAP /*2*/:
                return this.UK;
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                return this.UL;
            case Base64.CRLF /*4*/:
                return this.UM;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsHeaderTextAppearance /*5*/:
                return this.UN;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsBackground /*6*/:
                return this.UO;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsButtonTextAppearance /*7*/:
                return this.UP;
            case Base64.URL_SAFE /*8*/:
                return this.UQ;
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoTextColor /*9*/:
                return Integer.valueOf(this.UR);
            case C2625R.styleable.WalletFragmentStyle_maskedWalletDetailsLogoImageType /*10*/:
                return this.US;
            case C2625R.styleable.MapAttrs_uiZoomGestures /*11*/:
                return this.UT;
            case C2625R.styleable.MapAttrs_useViewLifecycle /*12*/:
                return this.UU;
            case C2625R.styleable.MapAttrs_zOrderOnTop /*13*/:
                return this.UV;
            case C2513R.styleable.MMAdView_height /*14*/:
                return this.UW;
            case C2513R.styleable.MMAdView_width /*15*/:
                return this.UX;
            case Base64.NO_CLOSE /*16*/:
                return this.UY;
            case MMException.CACHE_NOT_EMPTY /*17*/:
                return this.UZ;
            case C1087k.ActionBar_itemPadding /*18*/:
                return this.lY;
            case Encoder.LINE_GROUPS /*19*/:
                return this.Va;
            case MMException.DISPLAY_AD_NOT_READY /*20*/:
                return this.Vb;
            case MMException.DISPLAY_AD_EXPIRED /*21*/:
                return this.Vc;
            case MMException.DISPLAY_AD_NOT_FOUND /*22*/:
                return this.Vd;
            case MMException.DISPLAY_AD_ALREADY_DISPLAYED /*23*/:
                return this.HD;
            case MMException.DISPLAY_AD_NOT_PERMITTED /*24*/:
                return this.Ve;
            case MMException.AD_BROKEN_REFERENCE /*25*/:
                return this.Vf;
            case MMException.AD_NO_ACTIVITY /*26*/:
                return this.Vg;
            case 27:
                return this.Vh;
            case 28:
                return this.Vi;
            case 29:
                return this.Vj;
            case 30:
                return this.Vk;
            case 31:
                return this.Vl;
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                return this.wp;
            case 33:
                return this.Vm;
            case 34:
                return this.Vn;
            case 36:
                return Double.valueOf(this.NX);
            case 37:
                return this.Vo;
            case 38:
                return Double.valueOf(this.NY);
            case 39:
                return this.mName;
            case 40:
                return this.Vp;
            case 41:
                return this.Vq;
            case 42:
                return this.Vr;
            case 43:
                return this.Vs;
            case 44:
                return this.Vt;
            case 45:
                return this.Vu;
            case 46:
                return this.Vv;
            case 47:
                return this.Vw;
            case 48:
                return this.Vx;
            case 49:
                return this.Vy;
            case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                return this.Vz;
            case 51:
                return this.VA;
            case 52:
                return this.VB;
            case 53:
                return this.Rd;
            case 54:
                return this.ro;
            case 55:
                return this.VC;
            case 56:
                return this.VD;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c1912a.ff());
        }
    }

    public int describeContents() {
        id idVar = CREATOR;
        return 0;
    }

    public HashMap eY() {
        return UI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ic)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ic icVar = (ic) obj;
        for (C1912a c1912a : UI.values()) {
            if (m8762a(c1912a)) {
                if (!icVar.m8762a(c1912a)) {
                    return false;
                }
                if (!m8763b(c1912a).equals(icVar.m8763b(c1912a))) {
                    return false;
                }
            } else if (icVar.m8762a(c1912a)) {
                return false;
            }
        }
        return true;
    }

    public /* synthetic */ Object freeze() {
        return jq();
    }

    public ItemScope getAbout() {
        return this.UK;
    }

    public List getAdditionalName() {
        return this.UL;
    }

    public ItemScope getAddress() {
        return this.UM;
    }

    public String getAddressCountry() {
        return this.UN;
    }

    public String getAddressLocality() {
        return this.UO;
    }

    public String getAddressRegion() {
        return this.UP;
    }

    public List getAssociated_media() {
        return (ArrayList) this.UQ;
    }

    public int getAttendeeCount() {
        return this.UR;
    }

    public List getAttendees() {
        return (ArrayList) this.US;
    }

    public ItemScope getAudio() {
        return this.UT;
    }

    public List getAuthor() {
        return (ArrayList) this.UU;
    }

    public String getBestRating() {
        return this.UV;
    }

    public String getBirthDate() {
        return this.UW;
    }

    public ItemScope getByArtist() {
        return this.UX;
    }

    public String getCaption() {
        return this.UY;
    }

    public String getContentSize() {
        return this.UZ;
    }

    public String getContentUrl() {
        return this.lY;
    }

    public List getContributor() {
        return (ArrayList) this.Va;
    }

    public String getDateCreated() {
        return this.Vb;
    }

    public String getDateModified() {
        return this.Vc;
    }

    public String getDatePublished() {
        return this.Vd;
    }

    public String getDescription() {
        return this.HD;
    }

    public String getDuration() {
        return this.Ve;
    }

    public String getEmbedUrl() {
        return this.Vf;
    }

    public String getEndDate() {
        return this.Vg;
    }

    public String getFamilyName() {
        return this.Vh;
    }

    public String getGender() {
        return this.Vi;
    }

    public ItemScope getGeo() {
        return this.Vj;
    }

    public String getGivenName() {
        return this.Vk;
    }

    public String getHeight() {
        return this.Vl;
    }

    public String getId() {
        return this.wp;
    }

    public String getImage() {
        return this.Vm;
    }

    public ItemScope getInAlbum() {
        return this.Vn;
    }

    public double getLatitude() {
        return this.NX;
    }

    public ItemScope getLocation() {
        return this.Vo;
    }

    public double getLongitude() {
        return this.NY;
    }

    public String getName() {
        return this.mName;
    }

    public ItemScope getPartOfTVSeries() {
        return this.Vp;
    }

    public List getPerformers() {
        return (ArrayList) this.Vq;
    }

    public String getPlayerType() {
        return this.Vr;
    }

    public String getPostOfficeBoxNumber() {
        return this.Vs;
    }

    public String getPostalCode() {
        return this.Vt;
    }

    public String getRatingValue() {
        return this.Vu;
    }

    public ItemScope getReviewRating() {
        return this.Vv;
    }

    public String getStartDate() {
        return this.Vw;
    }

    public String getStreetAddress() {
        return this.Vx;
    }

    public String getText() {
        return this.Vy;
    }

    public ItemScope getThumbnail() {
        return this.Vz;
    }

    public String getThumbnailUrl() {
        return this.VA;
    }

    public String getTickerSymbol() {
        return this.VB;
    }

    public String getType() {
        return this.Rd;
    }

    public String getUrl() {
        return this.ro;
    }

    int getVersionCode() {
        return this.xH;
    }

    public String getWidth() {
        return this.VC;
    }

    public String getWorstRating() {
        return this.VD;
    }

    public boolean hasAbout() {
        return this.UJ.contains(Integer.valueOf(2));
    }

    public boolean hasAdditionalName() {
        return this.UJ.contains(Integer.valueOf(3));
    }

    public boolean hasAddress() {
        return this.UJ.contains(Integer.valueOf(4));
    }

    public boolean hasAddressCountry() {
        return this.UJ.contains(Integer.valueOf(5));
    }

    public boolean hasAddressLocality() {
        return this.UJ.contains(Integer.valueOf(6));
    }

    public boolean hasAddressRegion() {
        return this.UJ.contains(Integer.valueOf(7));
    }

    public boolean hasAssociated_media() {
        return this.UJ.contains(Integer.valueOf(8));
    }

    public boolean hasAttendeeCount() {
        return this.UJ.contains(Integer.valueOf(9));
    }

    public boolean hasAttendees() {
        return this.UJ.contains(Integer.valueOf(10));
    }

    public boolean hasAudio() {
        return this.UJ.contains(Integer.valueOf(11));
    }

    public boolean hasAuthor() {
        return this.UJ.contains(Integer.valueOf(12));
    }

    public boolean hasBestRating() {
        return this.UJ.contains(Integer.valueOf(13));
    }

    public boolean hasBirthDate() {
        return this.UJ.contains(Integer.valueOf(14));
    }

    public boolean hasByArtist() {
        return this.UJ.contains(Integer.valueOf(15));
    }

    public boolean hasCaption() {
        return this.UJ.contains(Integer.valueOf(16));
    }

    public boolean hasContentSize() {
        return this.UJ.contains(Integer.valueOf(17));
    }

    public boolean hasContentUrl() {
        return this.UJ.contains(Integer.valueOf(18));
    }

    public boolean hasContributor() {
        return this.UJ.contains(Integer.valueOf(19));
    }

    public boolean hasDateCreated() {
        return this.UJ.contains(Integer.valueOf(20));
    }

    public boolean hasDateModified() {
        return this.UJ.contains(Integer.valueOf(21));
    }

    public boolean hasDatePublished() {
        return this.UJ.contains(Integer.valueOf(22));
    }

    public boolean hasDescription() {
        return this.UJ.contains(Integer.valueOf(23));
    }

    public boolean hasDuration() {
        return this.UJ.contains(Integer.valueOf(24));
    }

    public boolean hasEmbedUrl() {
        return this.UJ.contains(Integer.valueOf(25));
    }

    public boolean hasEndDate() {
        return this.UJ.contains(Integer.valueOf(26));
    }

    public boolean hasFamilyName() {
        return this.UJ.contains(Integer.valueOf(27));
    }

    public boolean hasGender() {
        return this.UJ.contains(Integer.valueOf(28));
    }

    public boolean hasGeo() {
        return this.UJ.contains(Integer.valueOf(29));
    }

    public boolean hasGivenName() {
        return this.UJ.contains(Integer.valueOf(30));
    }

    public boolean hasHeight() {
        return this.UJ.contains(Integer.valueOf(31));
    }

    public boolean hasId() {
        return this.UJ.contains(Integer.valueOf(32));
    }

    public boolean hasImage() {
        return this.UJ.contains(Integer.valueOf(33));
    }

    public boolean hasInAlbum() {
        return this.UJ.contains(Integer.valueOf(34));
    }

    public boolean hasLatitude() {
        return this.UJ.contains(Integer.valueOf(36));
    }

    public boolean hasLocation() {
        return this.UJ.contains(Integer.valueOf(37));
    }

    public boolean hasLongitude() {
        return this.UJ.contains(Integer.valueOf(38));
    }

    public boolean hasName() {
        return this.UJ.contains(Integer.valueOf(39));
    }

    public boolean hasPartOfTVSeries() {
        return this.UJ.contains(Integer.valueOf(40));
    }

    public boolean hasPerformers() {
        return this.UJ.contains(Integer.valueOf(41));
    }

    public boolean hasPlayerType() {
        return this.UJ.contains(Integer.valueOf(42));
    }

    public boolean hasPostOfficeBoxNumber() {
        return this.UJ.contains(Integer.valueOf(43));
    }

    public boolean hasPostalCode() {
        return this.UJ.contains(Integer.valueOf(44));
    }

    public boolean hasRatingValue() {
        return this.UJ.contains(Integer.valueOf(45));
    }

    public boolean hasReviewRating() {
        return this.UJ.contains(Integer.valueOf(46));
    }

    public boolean hasStartDate() {
        return this.UJ.contains(Integer.valueOf(47));
    }

    public boolean hasStreetAddress() {
        return this.UJ.contains(Integer.valueOf(48));
    }

    public boolean hasText() {
        return this.UJ.contains(Integer.valueOf(49));
    }

    public boolean hasThumbnail() {
        return this.UJ.contains(Integer.valueOf(50));
    }

    public boolean hasThumbnailUrl() {
        return this.UJ.contains(Integer.valueOf(51));
    }

    public boolean hasTickerSymbol() {
        return this.UJ.contains(Integer.valueOf(52));
    }

    public boolean hasType() {
        return this.UJ.contains(Integer.valueOf(53));
    }

    public boolean hasUrl() {
        return this.UJ.contains(Integer.valueOf(54));
    }

    public boolean hasWidth() {
        return this.UJ.contains(Integer.valueOf(55));
    }

    public boolean hasWorstRating() {
        return this.UJ.contains(Integer.valueOf(56));
    }

    public int hashCode() {
        int i = 0;
        for (C1912a c1912a : UI.values()) {
            int hashCode;
            if (m8762a(c1912a)) {
                hashCode = m8763b(c1912a).hashCode() + (i + c1912a.ff());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    Set ja() {
        return this.UJ;
    }

    ic jb() {
        return this.UK;
    }

    ic jc() {
        return this.UM;
    }

    List jd() {
        return this.UQ;
    }

    List je() {
        return this.US;
    }

    ic jf() {
        return this.UT;
    }

    List jg() {
        return this.UU;
    }

    ic jh() {
        return this.UX;
    }

    List ji() {
        return this.Va;
    }

    ic jj() {
        return this.Vj;
    }

    ic jk() {
        return this.Vn;
    }

    ic jl() {
        return this.Vo;
    }

    ic jm() {
        return this.Vp;
    }

    List jn() {
        return this.Vq;
    }

    ic jo() {
        return this.Vv;
    }

    ic jp() {
        return this.Vz;
    }

    public ic jq() {
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        id idVar = CREATOR;
        id.m8764a(this, out, flags);
    }
}
