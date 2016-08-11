package com.avg.ui.license.qrreader.p061a;

import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;

/* renamed from: com.avg.ui.license.qrreader.a.b */
public final class C1188b {
    private final C1187a f3590a;
    private Camera f3591b;
    private Rect f3592c;
    private Rect f3593d;

    public Rect m4993a() {
        if (this.f3592c == null) {
            if (this.f3591b == null) {
                return null;
            }
            Point screenResolution = this.f3590a.m4992b();
            int width = (screenResolution.x * 3) / 4;
            if (width < 240) {
                width = 240;
            } else if (width > 600) {
                width = 600;
            }
            int height = (screenResolution.y * 3) / 4;
            if (height < 240) {
                height = 240;
            } else if (height > 400) {
                height = 400;
            }
            int leftOffset = (screenResolution.x - width) / 2;
            int topOffset = (screenResolution.y - height) / 2;
            this.f3592c = new Rect(leftOffset, topOffset, leftOffset + width, topOffset + height);
        }
        return this.f3592c;
    }

    public Rect m4994b() {
        if (this.f3593d == null) {
            Rect framingRect = m4993a();
            if (framingRect == null) {
                return null;
            }
            Rect rect = new Rect(framingRect);
            Point cameraResolution = this.f3590a.m4991a();
            Point screenResolution = this.f3590a.m4992b();
            rect.left = (rect.left * cameraResolution.x) / screenResolution.x;
            rect.right = (rect.right * cameraResolution.x) / screenResolution.x;
            rect.top = (rect.top * cameraResolution.y) / screenResolution.y;
            rect.bottom = (rect.bottom * cameraResolution.y) / screenResolution.y;
            this.f3593d = rect;
        }
        return this.f3593d;
    }
}
