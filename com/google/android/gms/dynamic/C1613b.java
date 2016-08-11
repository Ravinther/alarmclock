package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.C1611c.C1612a;

/* renamed from: com.google.android.gms.dynamic.b */
public final class C1613b extends C1612a {
    private Fragment Hv;

    private C1613b(Fragment fragment) {
        this.Hv = fragment;
    }

    public static C1613b m6727a(Fragment fragment) {
        return fragment != null ? new C1613b(fragment) : null;
    }

    public void m6728b(C1615d c1615d) {
        this.Hv.registerForContextMenu((View) C1618e.m6733d(c1615d));
    }

    public void m6729c(C1615d c1615d) {
        this.Hv.unregisterForContextMenu((View) C1618e.m6733d(c1615d));
    }

    public C1615d fX() {
        return C1618e.m6734h(this.Hv.getActivity());
    }

    public C1611c fY() {
        return C1613b.m6727a(this.Hv.getParentFragment());
    }

    public C1615d fZ() {
        return C1618e.m6734h(this.Hv.getResources());
    }

    public C1611c ga() {
        return C1613b.m6727a(this.Hv.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.Hv.getArguments();
    }

    public int getId() {
        return this.Hv.getId();
    }

    public boolean getRetainInstance() {
        return this.Hv.getRetainInstance();
    }

    public String getTag() {
        return this.Hv.getTag();
    }

    public int getTargetRequestCode() {
        return this.Hv.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Hv.getUserVisibleHint();
    }

    public C1615d getView() {
        return C1618e.m6734h(this.Hv.getView());
    }

    public boolean isAdded() {
        return this.Hv.isAdded();
    }

    public boolean isDetached() {
        return this.Hv.isDetached();
    }

    public boolean isHidden() {
        return this.Hv.isHidden();
    }

    public boolean isInLayout() {
        return this.Hv.isInLayout();
    }

    public boolean isRemoving() {
        return this.Hv.isRemoving();
    }

    public boolean isResumed() {
        return this.Hv.isResumed();
    }

    public boolean isVisible() {
        return this.Hv.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.Hv.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.Hv.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.Hv.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.Hv.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.Hv.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.Hv.startActivityForResult(intent, requestCode);
    }
}
