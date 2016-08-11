package com.avg.ui.general.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;

public class LandingDashboard extends Dashboard {
    public LandingDashboard(Context context) {
        super(context);
    }

    public LandingDashboard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void setupUi(Context context) {
        this.a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1084h.landing_dashboard_view, this);
        this.b = (Gauge) findViewById(C1082f.dashboard_gauge);
    }
}
