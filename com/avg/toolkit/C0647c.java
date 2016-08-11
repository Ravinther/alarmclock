package com.avg.toolkit;

import android.os.Bundle;
import com.avg.toolkit.license.C1017a;
import java.util.List;

/* renamed from: com.avg.toolkit.c */
public interface C0647c {
    int getID();

    void onAlarm(Bundle bundle);

    void onDailyTask(C1017a c1017a);

    void onDestroy();

    void onMessage(Bundle bundle);

    void onNewLicense(C1017a c1017a);

    void onStart(boolean z);

    void setComm(List list);
}
