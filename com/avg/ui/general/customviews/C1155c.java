package com.avg.ui.general.customviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.customviews.Dashboard.C1122a;
import com.avg.ui.general.customviews.DashboardListItem.C1123a;

/* renamed from: com.avg.ui.general.customviews.c */
public class C1155c extends LinearLayout {
    private C1154a f3506a;
    private DashboardListItem[] f3507b;

    /* renamed from: com.avg.ui.general.customviews.c.a */
    public interface C1154a extends C1122a {
        C1123a[] m4851b();
    }

    private void setupUi(Context context) {
        removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(context);
        if (this.f3506a.m4757a()) {
            inflater.inflate(C1084h.dashboard_landing_list_view, this);
        } else {
            inflater.inflate(C1084h.dashboard_list_view, this);
        }
        this.f3507b[0] = (DashboardListItem) findViewById(C1082f.listItem1);
        this.f3507b[1] = (DashboardListItem) findViewById(C1082f.listItem2);
        this.f3507b[2] = (DashboardListItem) findViewById(C1082f.listItem3);
        if (getChildAt(0) instanceof ScrollView) {
            getChildAt(0).setVerticalScrollBarEnabled(false);
        }
    }

    public void setConfiguration(C1154a iDashboardListConfiguration) {
        this.f3506a = iDashboardListConfiguration;
        setupUi(getContext());
        m4852a();
    }

    public void m4852a() {
        C1123a[] listItemsData = this.f3506a.m4851b();
        if (this.f3507b != null) {
            int i = listItemsData.length > this.f3507b.length ? 0 : 0;
            for (i = 0; i < this.f3507b.length; i++) {
                DashboardListItem listItem = this.f3507b[i];
                if (listItem != null) {
                    C1123a listItemData = null;
                    if (i < listItemsData.length) {
                        listItemData = listItemsData[i];
                    }
                    if (listItemData != null) {
                        listItem.setResources(listItemData);
                        listItem.setVisibility(0);
                    } else {
                        listItem.setVisibility(8);
                    }
                }
            }
        }
    }
}
