package com.mopub.mobileads;

import java.util.Map;

class MraidCommandGetResizeProperties extends MraidCommand {
    MraidCommandGetResizeProperties(Map params, MraidView view) {
        super(params, view);
    }

    void execute() {
        this.mView.fireErrorEvent(MraidJavascriptCommand.GET_RESIZE_PROPERTIES, "Unsupported action getResizeProperties.");
    }
}
