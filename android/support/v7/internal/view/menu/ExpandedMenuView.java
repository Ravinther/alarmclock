package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.internal.view.menu.C0397f.C0390b;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0390b, C0391m, OnItemClickListener {
    private C0397f f815a;
    private int f816b;

    public ExpandedMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnItemClickListener(this);
    }

    public void m1842a(C0397f menu) {
        this.f815a = menu;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean m1843a(C0399h item) {
        return this.f815a.m1896a((MenuItem) item, 0);
    }

    public void onItemClick(AdapterView parent, View v, int position, long id) {
        m1843a((C0399h) getAdapter().getItem(position));
    }

    public int getWindowAnimations() {
        return this.f816b;
    }
}
