package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.C2008b;

public class jf implements Payments {

    /* renamed from: com.google.android.gms.internal.jf.1 */
    class C20091 extends C2008b {
        final /* synthetic */ int Nx;
        final /* synthetic */ jf acV;

        C20091(jf jfVar, int i) {
            this.acV = jfVar;
            this.Nx = i;
        }

        protected void m8855a(jg jgVar) {
            jgVar.cD(this.Nx);
            m6054a(Status.Bv);
        }
    }

    /* renamed from: com.google.android.gms.internal.jf.2 */
    class C20102 extends C2008b {
        final /* synthetic */ int Nx;
        final /* synthetic */ jf acV;
        final /* synthetic */ MaskedWalletRequest acW;

        C20102(jf jfVar, MaskedWalletRequest maskedWalletRequest, int i) {
            this.acV = jfVar;
            this.acW = maskedWalletRequest;
            this.Nx = i;
        }

        protected void m8857a(jg jgVar) {
            jgVar.m8877a(this.acW, this.Nx);
            m6054a(Status.Bv);
        }
    }

    /* renamed from: com.google.android.gms.internal.jf.3 */
    class C20113 extends C2008b {
        final /* synthetic */ int Nx;
        final /* synthetic */ jf acV;
        final /* synthetic */ FullWalletRequest acX;

        C20113(jf jfVar, FullWalletRequest fullWalletRequest, int i) {
            this.acV = jfVar;
            this.acX = fullWalletRequest;
            this.Nx = i;
        }

        protected void m8859a(jg jgVar) {
            jgVar.m8876a(this.acX, this.Nx);
            m6054a(Status.Bv);
        }
    }

    /* renamed from: com.google.android.gms.internal.jf.4 */
    class C20124 extends C2008b {
        final /* synthetic */ int Nx;
        final /* synthetic */ jf acV;
        final /* synthetic */ String acY;
        final /* synthetic */ String acZ;

        C20124(jf jfVar, String str, String str2, int i) {
            this.acV = jfVar;
            this.acY = str;
            this.acZ = str2;
            this.Nx = i;
        }

        protected void m8861a(jg jgVar) {
            jgVar.m8879d(this.acY, this.acZ, this.Nx);
            m6054a(Status.Bv);
        }
    }

    /* renamed from: com.google.android.gms.internal.jf.5 */
    class C20135 extends C2008b {
        final /* synthetic */ jf acV;
        final /* synthetic */ NotifyTransactionStatusRequest ada;

        C20135(jf jfVar, NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
            this.acV = jfVar;
            this.ada = notifyTransactionStatusRequest;
        }

        protected void m8863a(jg jgVar) {
            jgVar.m8878a(this.ada);
            m6054a(Status.Bv);
        }
    }

    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        googleApiClient.m6238a(new C20124(this, googleTransactionId, merchantTransactionId, requestCode));
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        googleApiClient.m6238a(new C20091(this, requestCode));
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        googleApiClient.m6238a(new C20113(this, request, requestCode));
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        googleApiClient.m6238a(new C20102(this, request, requestCode));
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        googleApiClient.m6238a(new C20135(this, request));
    }
}
