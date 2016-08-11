package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.C1611c.C1612a;

/* renamed from: com.google.android.gms.dynamic.h */
public final class C1621h extends C1612a {
    private Fragment Hz;

    private C1621h(Fragment fragment) {
        this.Hz = fragment;
    }

    public static C1621h m6737a(Fragment fragment) {
        return fragment != null ? new C1621h(fragment) : null;
    }

    public void m6738b(C1615d c1615d) {
        this.Hz.registerForContextMenu((View) C1618e.m6733d(c1615d));
    }

    public void m6739c(C1615d c1615d) {
        this.Hz.unregisterForContextMenu((View) C1618e.m6733d(c1615d));
    }

    public C1615d fX() {
        return C1618e.m6734h(this.Hz.getActivity());
    }

    public C1611c fY() {
        return C1621h.m6737a(this.Hz.getParentFragment());
    }

    public C1615d fZ() {
        return C1618e.m6734h(this.Hz.getResources());
    }

    public C1611c ga() {
        return C1621h.m6737a(this.Hz.getTargetFragment());
    }

    public Bundle getArguments() {
        return this.Hz.getArguments();
    }

    public int getId() {
        return this.Hz.getId();
    }

    public boolean getRetainInstance() {
        return this.Hz.getRetainInstance();
    }

    public String getTag() {
        return this.Hz.getTag();
    }

    public int getTargetRequestCode() {
        return this.Hz.getTargetRequestCode();
    }

    public boolean getUserVisibleHint() {
        return this.Hz.getUserVisibleHint();
    }

    public C1615d getView() {
        return C1618e.m6734h(this.Hz.getView());
    }

    public boolean isAdded() {
        return this.Hz.isAdded();
    }

    public boolean isDetached() {
        return this.Hz.isDetached();
    }

    public boolean isHidden() {
        return this.Hz.isHidden();
    }

    public boolean isInLayout() {
        return this.Hz.isInLayout();
    }

    public boolean isRemoving() {
        return this.Hz.isRemoving();
    }

    public boolean isResumed() {
        return this.Hz.isResumed();
    }

    public boolean isVisible() {
        return this.Hz.isVisible();
    }

    public void setHasOptionsMenu(boolean hasMenu) {
        this.Hz.setHasOptionsMenu(hasMenu);
    }

    public void setMenuVisibility(boolean menuVisible) {
        this.Hz.setMenuVisibility(menuVisible);
    }

    public void setRetainInstance(boolean retain) {
        this.Hz.setRetainInstance(retain);
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        this.Hz.setUserVisibleHint(isVisibleToUser);
    }

    public void startActivity(Intent intent) {
        this.Hz.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        this.Hz.startActivityForResult(intent, requestCode);
    }
}
