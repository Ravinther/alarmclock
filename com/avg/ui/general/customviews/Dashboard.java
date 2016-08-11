package com.avg.ui.general.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.avg.ui.general.C1091c.C1080d;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;

public class Dashboard extends LinearLayout {
    Context f3386a;
    Gauge f3387b;
    C1153b f3388c;
    C1155c f3389d;

    /* renamed from: com.avg.ui.general.customviews.Dashboard.a */
    public interface C1122a {

        /* renamed from: com.avg.ui.general.customviews.Dashboard.a.a */
        public enum C1121a {
            eGreen(C1080d.dashboard_text_green),
            eWhite(C1080d.dashboard_text_white),
            eGrey(C1080d.dashboard_text_grey),
            eRed(C1080d.dashboard_text_red),
            eAmber(C1080d.dashboard_text_orange);
            
            private final int f3385f;

            private C1121a(int resourceColor) {
                this.f3385f = resourceColor;
            }

            public int m4756a() {
                return this.f3385f;
            }
        }

        boolean m4757a();
    }

    public Dashboard(Context context) {
        super(context, null);
        this.f3386a = null;
        this.f3387b = null;
        this.f3388c = null;
        this.f3389d = null;
        setupUi(context);
    }

    public Dashboard(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3386a = null;
        this.f3387b = null;
        this.f3388c = null;
        this.f3389d = null;
        setupUi(context);
    }

    protected void setupUi(Context context) {
        this.f3386a = context;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1084h.dashboard_view, this);
        this.f3387b = (Gauge) findViewById(C1082f.dashboard_gauge);
    }
}
