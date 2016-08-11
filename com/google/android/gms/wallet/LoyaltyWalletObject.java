package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.gi;
import com.google.android.gms.internal.jo;
import com.google.android.gms.internal.ju;
import java.util.ArrayList;

public final class LoyaltyWalletObject implements SafeParcelable {
    public static final Creator CREATOR;
    String abA;
    String abB;
    String abC;
    String abD;
    String abE;
    String abF;
    String abG;
    String abH;
    ArrayList abI;
    ju abJ;
    ArrayList abK;
    String abL;
    String abM;
    ArrayList abN;
    boolean abO;
    ArrayList abP;
    ArrayList abQ;
    ArrayList abR;
    jo abS;
    String abz;
    String eC;
    int state;
    private final int xH;

    static {
        CREATOR = new C2366j();
    }

    LoyaltyWalletObject() {
        this.xH = 4;
        this.abI = gi.fs();
        this.abK = gi.fs();
        this.abN = gi.fs();
        this.abP = gi.fs();
        this.abQ = gi.fs();
        this.abR = gi.fs();
    }

    LoyaltyWalletObject(int versionCode, String id, String accountId, String issuerName, String programName, String accountName, String barcodeAlternateText, String barcodeType, String barcodeValue, String barcodeLabel, String classId, int state, ArrayList messages, ju validTimeInterval, ArrayList locations, String infoModuleDataHexFontColor, String infoModuleDataHexBackgroundColor, ArrayList infoModuleDataLabelValueRows, boolean infoModuleDataShowLastUpdateTime, ArrayList imageModuleDataMainImageUris, ArrayList textModulesData, ArrayList linksModuleDataUris, jo loyaltyPoints) {
        this.xH = versionCode;
        this.eC = id;
        this.abz = accountId;
        this.abA = issuerName;
        this.abB = programName;
        this.abC = accountName;
        this.abD = barcodeAlternateText;
        this.abE = barcodeType;
        this.abF = barcodeValue;
        this.abG = barcodeLabel;
        this.abH = classId;
        this.state = state;
        this.abI = messages;
        this.abJ = validTimeInterval;
        this.abK = locations;
        this.abL = infoModuleDataHexFontColor;
        this.abM = infoModuleDataHexBackgroundColor;
        this.abN = infoModuleDataLabelValueRows;
        this.abO = infoModuleDataShowLastUpdateTime;
        this.abP = imageModuleDataMainImageUris;
        this.abQ = textModulesData;
        this.abR = linksModuleDataUris;
        this.abS = loyaltyPoints;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountId() {
        return this.abz;
    }

    public String getAccountName() {
        return this.abC;
    }

    public String getBarcodeAlternateText() {
        return this.abD;
    }

    public String getBarcodeType() {
        return this.abE;
    }

    public String getBarcodeValue() {
        return this.abF;
    }

    public String getId() {
        return this.eC;
    }

    public String getIssuerName() {
        return this.abA;
    }

    public String getProgramName() {
        return this.abB;
    }

    public int getVersionCode() {
        return this.xH;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C2366j.m9696a(this, dest, flags);
    }
}
