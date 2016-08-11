package android.support.v7.internal.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p007b.p008a.C0128b;
import android.support.v4.view.C0220d;
import android.support.v4.view.C0240j.C0239e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.internal.view.menu.a */
public class C0392a implements C0128b {
    private final int f831a;
    private final int f832b;
    private final int f833c;
    private final int f834d;
    private CharSequence f835e;
    private CharSequence f836f;
    private Intent f837g;
    private char f838h;
    private char f839i;
    private Drawable f840j;
    private int f841k;
    private Context f842l;
    private OnMenuItemClickListener f843m;
    private int f844n;

    public /* synthetic */ MenuItem setActionView(int x0) {
        return m1850a(x0);
    }

    public /* synthetic */ MenuItem setActionView(View x0) {
        return m1853a(x0);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int x0) {
        return m1854b(x0);
    }

    public C0392a(Context context, int group, int id, int categoryOrder, int ordering, CharSequence title) {
        this.f841k = 0;
        this.f844n = 16;
        this.f842l = context;
        this.f831a = id;
        this.f832b = group;
        this.f833c = categoryOrder;
        this.f834d = ordering;
        this.f835e = title;
    }

    public char getAlphabeticShortcut() {
        return this.f839i;
    }

    public int getGroupId() {
        return this.f832b;
    }

    public Drawable getIcon() {
        return this.f840j;
    }

    public Intent getIntent() {
        return this.f837g;
    }

    public int getItemId() {
        return this.f831a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f838h;
    }

    public int getOrder() {
        return this.f834d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f835e;
    }

    public CharSequence getTitleCondensed() {
        return this.f836f;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f844n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f844n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f844n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f844n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char alphaChar) {
        this.f839i = alphaChar;
        return this;
    }

    public MenuItem setCheckable(boolean checkable) {
        this.f844n = (checkable ? 1 : 0) | (this.f844n & -2);
        return this;
    }

    public MenuItem setChecked(boolean checked) {
        this.f844n = (checked ? 2 : 0) | (this.f844n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean enabled) {
        this.f844n = (enabled ? 16 : 0) | (this.f844n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable icon) {
        this.f840j = icon;
        this.f841k = 0;
        return this;
    }

    public MenuItem setIcon(int iconRes) {
        this.f841k = iconRes;
        this.f840j = this.f842l.getResources().getDrawable(iconRes);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f837g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char numericChar) {
        this.f838h = numericChar;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        this.f843m = menuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.f838h = numericChar;
        this.f839i = alphaChar;
        return this;
    }

    public MenuItem setTitle(CharSequence title) {
        this.f835e = title;
        return this;
    }

    public MenuItem setTitle(int title) {
        this.f835e = this.f842l.getResources().getString(title);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence title) {
        this.f836f = title;
        return this;
    }

    public MenuItem setVisible(boolean visible) {
        this.f844n = (visible ? 0 : 8) | (this.f844n & 8);
        return this;
    }

    public void setShowAsAction(int show) {
    }

    public C0128b m1853a(View actionView) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public C0128b m1850a(int resId) {
        throw new UnsupportedOperationException();
    }

    public C0128b m1851a(C0220d actionProvider) {
        throw new UnsupportedOperationException();
    }

    public C0128b m1854b(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        throw new UnsupportedOperationException();
    }

    public C0128b m1852a(C0239e listener) {
        return this;
    }
}
