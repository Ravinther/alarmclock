package com.avg.ui.general.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ToggleButton;
import com.avg.toolkit.p049e.C0970a;
import com.avg.ui.general.C1091c.C1080d;
import com.avg.ui.general.C1091c.C1081e;
import com.avg.ui.general.C1091c.C1086j;
import java.util.ArrayList;
import java.util.List;

public class SimpleTabWidget extends LinearLayout {
    private List f3438a;
    private ToggleButton f3439b;
    private Context f3440c;
    private C1107a f3441d;
    private OnCheckedChangeListener f3442e;

    /* renamed from: com.avg.ui.general.customviews.SimpleTabWidget.a */
    public interface C1107a {
        void m4709a(int i);
    }

    /* renamed from: com.avg.ui.general.customviews.SimpleTabWidget.1 */
    class C11311 implements OnCheckedChangeListener {
        final /* synthetic */ SimpleTabWidget f3437a;

        C11311(SimpleTabWidget simpleTabWidget) {
            this.f3437a = simpleTabWidget;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            buttonView.setTextColor(this.f3437a.getResources().getColor(C1080d.white));
            if (isChecked) {
                this.f3437a.f3439b = (ToggleButton) buttonView;
                this.f3437a.f3439b.setEnabled(false);
                this.f3437a.f3439b.setTypeface(Typeface.DEFAULT_BOLD);
                for (CompoundButton btn : this.f3437a.f3438a) {
                    if (btn != buttonView) {
                        btn.setChecked(false);
                    }
                }
                if (this.f3437a.f3441d != null) {
                    this.f3437a.f3441d.m4709a(((Integer) buttonView.getTag()).intValue());
                    return;
                }
                return;
            }
            buttonView.setTypeface(Typeface.DEFAULT);
            buttonView.setEnabled(true);
        }
    }

    public SimpleTabWidget(Context context) {
        this(context, null);
    }

    public SimpleTabWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f3442e = new C11311(this);
        this.f3440c = context;
    }

    public void setTabsTitles(String... tabTitles) {
        if (tabTitles.length == 0) {
            C0970a.m4325b("Cannot init with empty array");
        } else {
            m4795a(tabTitles);
        }
    }

    private void m4795a(String[] tabTitles) {
        this.f3438a = new ArrayList(tabTitles.length);
        LayoutParams params = new LayoutParams(0, -2, 1.0f);
        DisplayMetrics displayMetrics = this.f3440c.getResources().getDisplayMetrics();
        float widthPX = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        float hightPX = TypedValue.applyDimension(1, 20.0f, displayMetrics);
        float padding = TypedValue.applyDimension(1, 10.0f, displayMetrics);
        LayoutParams dividerParams = new LayoutParams((int) widthPX, (int) hightPX);
        dividerParams.gravity = 16;
        int i = 0;
        int size = tabTitles.length;
        for (String title : tabTitles) {
            ToggleButton btn = new ToggleButton(this.f3440c);
            btn.setBackgroundResource(C1081e.selector_tab_bg);
            btn.setPadding((int) padding, (int) padding, (int) padding, (int) padding);
            btn.setTextAppearance(this.f3440c, C1086j.TextWhiteMedium);
            btn.setLayoutParams(params);
            btn.setTextOn(title);
            btn.setTextOff(title);
            btn.setSingleLine();
            btn.setEllipsize(TruncateAt.END);
            btn.setOnCheckedChangeListener(this.f3442e);
            btn.setTag(Integer.valueOf(i));
            addView(btn);
            this.f3438a.add(btn);
            if (i != size - 1) {
                View view = new View(this.f3440c);
                view.setLayoutParams(dividerParams);
                view.setBackgroundResource(C1081e.list_divider_holo_dark);
                addView(view);
            }
            i++;
        }
        ((ToggleButton) this.f3438a.get(0)).setChecked(true);
    }

    public void setOnTabChangedListener(C1107a listener) {
        this.f3441d = listener;
    }

    public int getSelectedTab() {
        return ((Integer) this.f3439b.getTag()).intValue();
    }
}
