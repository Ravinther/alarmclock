package com.millennialmedia.android;

import java.util.HashMap;

class BridgeMMCalendar extends MMJSObject {
    BridgeMMCalendar() {
    }

    public MMJSResponse addEvent(HashMap parameters) {
        return MMJSResponse.responseWithError("Not supported");
    }
}
