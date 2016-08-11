package android.support.v7.internal.view.menu;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.internal.view.menu.C0384l.C0335a;
import android.support.v7.p014b.C0364a.C0360g;
import android.support.v7.p014b.C0364a.C0362i;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.avg.toolkit.ITKSvc;

/* renamed from: android.support.v7.internal.view.menu.g */
public class C0380g implements OnClickListener, OnDismissListener, OnKeyListener, C0335a {
    private C0397f f744a;
    C0396e f745b;
    private AlertDialog f746c;
    private C0335a f747d;

    public C0380g(C0397f menu) {
        this.f744a = menu;
    }

    public void m1753a(IBinder windowToken) {
        C0397f menu = this.f744a;
        Builder builder = new Builder(menu.m1908e());
        this.f745b = new C0396e(C0360g.abc_list_menu_item_layout, C0362i.Theme_AppCompat_CompactMenu_Dialog);
        this.f745b.m1867a((C0335a) this);
        this.f744a.m1891a(this.f745b);
        builder.setAdapter(this.f745b.m1864a(), this);
        View headerView = menu.m1918o();
        if (headerView != null) {
            builder.setCustomTitle(headerView);
        } else {
            builder.setIcon(menu.m1917n()).setTitle(menu.m1916m());
        }
        builder.setOnKeyListener(this);
        this.f746c = builder.create();
        this.f746c.setOnDismissListener(this);
        LayoutParams lp = this.f746c.getWindow().getAttributes();
        lp.type = ITKSvc.ACTION_ALARM;
        if (windowToken != null) {
            lp.token = windowToken;
        }
        lp.flags |= 131072;
        this.f746c.show();
    }

    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        if (keyCode == 82 || keyCode == 4) {
            Window win;
            View decor;
            DispatcherState ds;
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                win = this.f746c.getWindow();
                if (win != null) {
                    decor = win.getDecorView();
                    if (decor != null) {
                        ds = decor.getKeyDispatcherState();
                        if (ds != null) {
                            ds.startTracking(event, this);
                            return true;
                        }
                    }
                }
            } else if (event.getAction() == 1 && !event.isCanceled()) {
                win = this.f746c.getWindow();
                if (win != null) {
                    decor = win.getDecorView();
                    if (decor != null) {
                        ds = decor.getKeyDispatcherState();
                        if (ds != null && ds.isTracking(event)) {
                            this.f744a.m1894a(true);
                            dialog.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f744a.performShortcut(keyCode, event, 0);
    }

    public void m1752a() {
        if (this.f746c != null) {
            this.f746c.dismiss();
        }
    }

    public void onDismiss(DialogInterface dialog) {
        this.f745b.m1866a(this.f744a, true);
    }

    public void m1754a(C0397f menu, boolean allMenusAreClosing) {
        if (allMenusAreClosing || menu == this.f744a) {
            m1752a();
        }
        if (this.f747d != null) {
            this.f747d.m1523a(menu, allMenusAreClosing);
        }
    }

    public boolean m1755b(C0397f subMenu) {
        if (this.f747d != null) {
            return this.f747d.m1524b(subMenu);
        }
        return false;
    }

    public void onClick(DialogInterface dialog, int which) {
        this.f744a.m1896a((C0399h) this.f745b.m1864a().getItem(which), 0);
    }
}
