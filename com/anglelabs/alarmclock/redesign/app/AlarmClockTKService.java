package com.anglelabs.alarmclock.redesign.app;

import com.avg.toolkit.TKService;
import com.avg.toolkit.ads.C0931c;
import com.avg.toolkit.license.C1017a;
import com.avg.ui.general.rateus.C1184b;
import java.util.Properties;

public class AlarmClockTKService extends TKService {
    protected void onCreateThreaded() {
        super.onCreateThreaded();
        addTKFeature(new C0931c(this));
    }

    protected void addExtraTKFeatures(C1017a avgFeatures, Properties properties) {
        addTKFeature(new C1184b(this));
        addTKFeature(new C0651a());
    }
}
