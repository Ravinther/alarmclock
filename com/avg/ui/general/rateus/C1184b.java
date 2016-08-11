package com.avg.ui.general.rateus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.avg.toolkit.C0647c;
import com.avg.toolkit.license.C1017a;
import com.google.android.gms.drive.DriveFile;
import java.util.List;

/* renamed from: com.avg.ui.general.rateus.b */
public class C1184b implements C0647c {
    private Context f3579a;

    public C1184b(Context context) {
        this.f3579a = context.getApplicationContext();
    }

    public int getID() {
        return 78000;
    }

    public void onStart(boolean firstTime) {
    }

    @SuppressLint({"InlinedApi"})
    public void onMessage(Bundle arguments) {
        Intent dialog = new Intent(this.f3579a.getApplicationContext(), RateAndShareDialogActivity.class);
        dialog.addFlags(DriveFile.MODE_READ_ONLY);
        dialog.addFlags(16384);
        dialog.addFlags(32768);
        this.f3579a.startActivity(dialog);
    }

    public void onAlarm(Bundle arguments) {
    }

    public void onDailyTask(C1017a avgFeatures) {
    }

    public void onNewLicense(C1017a avgFeatures) {
    }

    public void onDestroy() {
    }

    public void setComm(List commClients) {
        commClients.add(C1183a.class);
    }
}
