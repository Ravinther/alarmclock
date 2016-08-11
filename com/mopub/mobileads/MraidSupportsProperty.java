package com.mopub.mobileads;

class MraidSupportsProperty extends MraidProperty {
    private boolean calendar;
    private boolean inlineVideo;
    private boolean sms;
    private boolean storePicture;
    private boolean tel;

    MraidSupportsProperty() {
    }

    public String toJsonPair() {
        return "supports: {sms: " + String.valueOf(this.sms) + ", " + "tel: " + String.valueOf(this.tel) + ", " + "calendar: " + String.valueOf(this.calendar) + ", " + "storePicture: " + String.valueOf(this.storePicture) + ", " + "inlineVideo: " + String.valueOf(this.inlineVideo) + "}";
    }

    public MraidSupportsProperty withSms(boolean value) {
        this.sms = value;
        return this;
    }

    public MraidSupportsProperty withTel(boolean value) {
        this.tel = value;
        return this;
    }

    public MraidSupportsProperty withCalendar(boolean value) {
        this.calendar = value;
        return this;
    }

    public MraidSupportsProperty withStorePicture(boolean value) {
        this.storePicture = value;
        return this;
    }

    public MraidSupportsProperty withInlineVideo(boolean value) {
        this.inlineVideo = value;
        return this;
    }
}
