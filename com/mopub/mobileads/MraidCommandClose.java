package com.mopub.mobileads;

import java.util.Map;

class MraidCommandClose extends MraidCommand {
    MraidCommandClose(Map params, MraidView view) {
        super(params, view);
    }

    void execute() {
        this.mView.getDisplayController().close();
    }
}
