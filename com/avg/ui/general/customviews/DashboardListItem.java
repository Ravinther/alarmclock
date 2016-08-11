package com.avg.ui.general.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.avg.ui.general.C1091c.C1081e;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1087k;
import com.avg.ui.general.customviews.Dashboard.C1122a.C1121a;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class DashboardListItem extends RelativeLayout {
    private ImageView f3396a;
    private TextView f3397b;
    private TextView f3398c;

    /* renamed from: com.avg.ui.general.customviews.DashboardListItem.a */
    public static class C1123a {
        int f3390a;
        String f3391b;
        String f3392c;
        OnClickListener f3393d;
        C1121a f3394e;
        C1121a f3395f;

        public int m4758a() {
            return this.f3390a;
        }

        public String m4759b() {
            return this.f3391b;
        }

        public C1121a m4760c() {
            return this.f3394e;
        }

        public C1121a m4761d() {
            return this.f3395f;
        }

        public String m4762e() {
            return this.f3392c;
        }

        public OnClickListener m4763f() {
            return this.f3393d;
        }
    }

    public DashboardListItem(Context context) {
        super(context);
        this.f3396a = null;
        this.f3397b = null;
        this.f3398c = null;
        m4764a(context, null);
    }

    public DashboardListItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f3396a = null;
        this.f3397b = null;
        this.f3398c = null;
        m4764a(context, attrs);
    }

    public DashboardListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3396a = null;
        this.f3397b = null;
        this.f3398c = null;
        m4764a(context, attrs);
    }

    private void m4764a(Context context, AttributeSet attrs) {
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(C1084h.dashboard_list_view_item, this);
        setBackgroundResource(C1081e.dashboard_list_item);
        this.f3396a = (ImageView) findViewById(C1082f.item_icon);
        this.f3397b = (TextView) findViewById(C1082f.item_title);
        this.f3398c = (TextView) findViewById(C1082f.item_subtitle);
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, C1087k.DashboardListItem, 0, 0);
            try {
                float titleSize = (float) a.getDimensionPixelSize(C1087k.DashboardListItem_titleSize, -1);
                if (titleSize != GroundOverlayOptions.NO_DIMENSION) {
                    this.f3397b.setTextSize(0, titleSize);
                }
                float subtitleSize = (float) a.getDimensionPixelSize(C1087k.DashboardListItem_subtitleSize, -1);
                if (subtitleSize != GroundOverlayOptions.NO_DIMENSION) {
                    this.f3398c.setTextSize(0, subtitleSize);
                }
                int padding = a.getDimensionPixelSize(C1087k.DashboardListItem_paddingVertical, -1);
                if (padding != -1) {
                    View rootView = findViewById(C1082f.root_layout);
                    if (rootView != null) {
                        MarginLayoutParams lp = (MarginLayoutParams) rootView.getLayoutParams();
                        lp.topMargin = padding;
                        lp.bottomMargin = padding;
                        rootView.setLayoutParams(lp);
                        rootView.setPadding(rootView.getPaddingLeft(), padding, getPaddingRight(), padding);
                    }
                }
                a.recycle();
            } catch (Throwable th) {
                a.recycle();
            }
        }
    }

    public void setResources(C1123a data) {
        this.f3396a.setImageResource(data.m4758a());
        this.f3397b.setText(data.m4759b());
        if (TextUtils.isEmpty(data.m4762e())) {
            this.f3398c.setVisibility(8);
        } else {
            this.f3398c.setText(data.m4762e());
        }
        if (data.m4763f() != null) {
            super.setOnClickListener(data.m4763f());
        }
        this.f3397b.setTextColor(getResources().getColor(data.m4760c().m4756a()));
        this.f3398c.setTextColor(getResources().getColor(data.m4761d().m4756a()));
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }
}
