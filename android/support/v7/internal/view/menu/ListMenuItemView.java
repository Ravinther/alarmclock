package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.internal.view.menu.C0391m.C0377a;
import android.support.v7.p014b.C0364a.C0358e;
import android.support.v7.p014b.C0364a.C0360g;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView extends LinearLayout implements C0377a {
    private C0399h f817a;
    private ImageView f818b;
    private RadioButton f819c;
    private TextView f820d;
    private CheckBox f821e;
    private TextView f822f;
    private Drawable f823g;
    private int f824h;
    private Context f825i;
    private boolean f826j;
    private int f827k;
    private Context f828l;
    private LayoutInflater f829m;
    private boolean f830n;

    public ListMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        this.f828l = context;
        TypedArray a = context.obtainStyledAttributes(attrs, C0363j.MenuView, defStyle, 0);
        this.f823g = a.getDrawable(5);
        this.f824h = a.getResourceId(1, -1);
        this.f826j = a.getBoolean(7, false);
        this.f825i = context;
        a.recycle();
    }

    public ListMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f823g);
        this.f820d = (TextView) findViewById(C0358e.title);
        if (this.f824h != -1) {
            this.f820d.setTextAppearance(this.f825i, this.f824h);
        }
        this.f822f = (TextView) findViewById(C0358e.shortcut);
    }

    public void m1847a(C0399h itemData, int menuType) {
        this.f817a = itemData;
        this.f827k = menuType;
        setVisibility(itemData.isVisible() ? 0 : 8);
        setTitle(itemData.m1928a((C0377a) this));
        setCheckable(itemData.isCheckable());
        m1848a(itemData.m1941e(), itemData.m1936c());
        setIcon(itemData.getIcon());
        setEnabled(itemData.isEnabled());
    }

    public void setForceShowIcon(boolean forceShow) {
        this.f830n = forceShow;
        this.f826j = forceShow;
    }

    public void setTitle(CharSequence title) {
        if (title != null) {
            this.f820d.setText(title);
            if (this.f820d.getVisibility() != 0) {
                this.f820d.setVisibility(0);
            }
        } else if (this.f820d.getVisibility() != 8) {
            this.f820d.setVisibility(8);
        }
    }

    public C0399h getItemData() {
        return this.f817a;
    }

    public void setCheckable(boolean checkable) {
        if (checkable || this.f819c != null || this.f821e != null) {
            CompoundButton compoundButton;
            CompoundButton otherCompoundButton;
            if (this.f817a.m1942f()) {
                if (this.f819c == null) {
                    m1845c();
                }
                compoundButton = this.f819c;
                otherCompoundButton = this.f821e;
            } else {
                if (this.f821e == null) {
                    m1846d();
                }
                compoundButton = this.f821e;
                otherCompoundButton = this.f819c;
            }
            if (checkable) {
                int newVisibility;
                compoundButton.setChecked(this.f817a.isChecked());
                if (checkable) {
                    newVisibility = 0;
                } else {
                    newVisibility = 8;
                }
                if (compoundButton.getVisibility() != newVisibility) {
                    compoundButton.setVisibility(newVisibility);
                }
                if (otherCompoundButton != null && otherCompoundButton.getVisibility() != 8) {
                    otherCompoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.f821e != null) {
                this.f821e.setVisibility(8);
            }
            if (this.f819c != null) {
                this.f819c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean checked) {
        CompoundButton compoundButton;
        if (this.f817a.m1942f()) {
            if (this.f819c == null) {
                m1845c();
            }
            compoundButton = this.f819c;
        } else {
            if (this.f821e == null) {
                m1846d();
            }
            compoundButton = this.f821e;
        }
        compoundButton.setChecked(checked);
    }

    public void m1848a(boolean showShortcut, char shortcutKey) {
        int newVisibility = (showShortcut && this.f817a.m1941e()) ? 0 : 8;
        if (newVisibility == 0) {
            this.f822f.setText(this.f817a.m1938d());
        }
        if (this.f822f.getVisibility() != newVisibility) {
            this.f822f.setVisibility(newVisibility);
        }
    }

    public void setIcon(Drawable icon) {
        boolean showIcon;
        if (this.f817a.m1944h() || this.f830n) {
            showIcon = true;
        } else {
            showIcon = false;
        }
        if (!showIcon && !this.f826j) {
            return;
        }
        if (this.f818b != null || icon != null || this.f826j) {
            if (this.f818b == null) {
                m1844b();
            }
            if (icon != null || this.f826j) {
                ImageView imageView = this.f818b;
                if (!showIcon) {
                    icon = null;
                }
                imageView.setImageDrawable(icon);
                if (this.f818b.getVisibility() != 0) {
                    this.f818b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f818b.setVisibility(8);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f818b != null && this.f826j) {
            LayoutParams lp = getLayoutParams();
            LinearLayout.LayoutParams iconLp = (LinearLayout.LayoutParams) this.f818b.getLayoutParams();
            if (lp.height > 0 && iconLp.width <= 0) {
                iconLp.width = lp.height;
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void m1844b() {
        this.f818b = (ImageView) getInflater().inflate(C0360g.abc_list_menu_item_icon, this, false);
        addView(this.f818b, 0);
    }

    private void m1845c() {
        this.f819c = (RadioButton) getInflater().inflate(C0360g.abc_list_menu_item_radio, this, false);
        addView(this.f819c);
    }

    private void m1846d() {
        this.f821e = (CheckBox) getInflater().inflate(C0360g.abc_list_menu_item_checkbox, this, false);
        addView(this.f821e);
    }

    public boolean m1849a() {
        return false;
    }

    private LayoutInflater getInflater() {
        if (this.f829m == null) {
            this.f829m = LayoutInflater.from(this.f828l);
        }
        return this.f829m;
    }
}
