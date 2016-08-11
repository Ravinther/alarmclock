package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.ActionMenuView.C0376a;
import android.support.v7.internal.view.menu.C0391m.C0377a;
import android.support.v7.internal.view.menu.C0397f.C0390b;
import android.support.v7.internal.widget.C0375e;
import android.support.v7.p014b.C0364a.C0356c;
import android.support.v7.p014b.C0364a.C0363j;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import java.util.Locale;

public class ActionMenuItemView extends C0375e implements C0376a, C0377a, OnClickListener, OnLongClickListener {
    private C0399h f735a;
    private CharSequence f736b;
    private Drawable f737c;
    private C0390b f738d;
    private boolean f739e;
    private boolean f740f;
    private int f741g;
    private int f742h;

    /* renamed from: android.support.v7.internal.view.menu.ActionMenuItemView.a */
    private class C0374a implements TransformationMethod {
        final /* synthetic */ ActionMenuItemView f733a;
        private Locale f734b;

        public C0374a(ActionMenuItemView actionMenuItemView) {
            this.f733a = actionMenuItemView;
            this.f734b = actionMenuItemView.getContext().getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence source, View view) {
            return source != null ? source.toString().toUpperCase(this.f734b) : null;
        }

        public void onFocusChanged(View view, CharSequence sourceText, boolean focused, int direction, Rect previouslyFocusedRect) {
        }
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f739e = context.getResources().getBoolean(C0356c.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray a = context.obtainStyledAttributes(attrs, C0363j.ActionMenuItemView, 0, 0);
        this.f741g = a.getDimensionPixelSize(0, 0);
        a.recycle();
        setOnClickListener(this);
        setOnLongClickListener(this);
        setTransformationMethod(new C0374a(this));
        this.f742h = -1;
    }

    public void setPadding(int l, int t, int r, int b) {
        this.f742h = l;
        super.setPadding(l, t, r, b);
    }

    public C0399h getItemData() {
        return this.f735a;
    }

    public void m1745a(C0399h itemData, int menuType) {
        this.f735a = itemData;
        setIcon(itemData.getIcon());
        setTitle(itemData.m1928a((C0377a) this));
        setId(itemData.getItemId());
        setVisibility(itemData.isVisible() ? 0 : 8);
        setEnabled(itemData.isEnabled());
    }

    public void onClick(View v) {
        if (this.f738d != null) {
            this.f738d.m1831a(this.f735a);
        }
    }

    public void setItemInvoker(C0390b invoker) {
        this.f738d = invoker;
    }

    public boolean m1746a() {
        return true;
    }

    public void setCheckable(boolean checkable) {
    }

    public void setChecked(boolean checked) {
    }

    public void setExpandedFormat(boolean expandedFormat) {
        if (this.f740f != expandedFormat) {
            this.f740f = expandedFormat;
            if (this.f735a != null) {
                this.f735a.m1943g();
            }
        }
    }

    private void m1744e() {
        boolean visible;
        int i = 0;
        if (TextUtils.isEmpty(this.f736b)) {
            visible = false;
        } else {
            visible = true;
        }
        if (this.f737c == null || (this.f735a.m1948l() && (this.f739e || this.f740f))) {
            i = 1;
        }
        setText(visible & i ? this.f736b : null);
    }

    public void setIcon(Drawable icon) {
        this.f737c = icon;
        setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
        m1744e();
    }

    public boolean m1747b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence title) {
        this.f736b = title;
        setContentDescription(this.f736b);
        m1744e();
    }

    public boolean m1748c() {
        return m1747b() && this.f735a.getIcon() == null;
    }

    public boolean m1749d() {
        return m1747b();
    }

    public boolean onLongClick(View v) {
        if (m1747b()) {
            return false;
        }
        int[] screenPos = new int[2];
        Rect displayFrame = new Rect();
        getLocationOnScreen(screenPos);
        getWindowVisibleDisplayFrame(displayFrame);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int midy = screenPos[1] + (height / 2);
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        Toast cheatSheet = Toast.makeText(context, this.f735a.getTitle(), 0);
        if (midy < displayFrame.height()) {
            cheatSheet.setGravity(53, (screenWidth - screenPos[0]) - (width / 2), height);
        } else {
            cheatSheet.setGravity(81, 0, height);
        }
        cheatSheet.show();
        return true;
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        boolean textVisible = m1747b();
        if (textVisible && this.f742h >= 0) {
            super.setPadding(this.f742h, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int oldMeasuredWidth = getMeasuredWidth();
        int targetWidth = widthMode == Integer.MIN_VALUE ? Math.min(widthSize, this.f741g) : this.f741g;
        if (widthMode != 1073741824 && this.f741g > 0 && oldMeasuredWidth < targetWidth) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(targetWidth, 1073741824), heightMeasureSpec);
        }
        if (!textVisible && this.f737c != null) {
            super.setPadding((getMeasuredWidth() - this.f737c.getIntrinsicWidth()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }
}
