package com.mopub.mobileads;

import com.mopub.mobileads.MraidView.ViewState;

class MraidStateProperty extends MraidProperty {
    private final ViewState mViewState;

    MraidStateProperty(ViewState viewState) {
        this.mViewState = viewState;
    }

    public static MraidStateProperty createWithViewState(ViewState viewState) {
        return new MraidStateProperty(viewState);
    }

    public String toJsonPair() {
        return "state: '" + this.mViewState.toString().toLowerCase() + "'";
    }
}
