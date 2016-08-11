package com.mopub.mobileads;

import java.util.Map;

class MraidCommandGetDefaultPosition extends MraidCommand {
    MraidCommandGetDefaultPosition(Map params, MraidView view) {
        super(params, view);
    }

    void execute() {
        this.mView.getDisplayController().getDefaultPosition();
    }
}
