package com.p037b.p038a;

import com.p037b.p038a.C1207h.C1208a;
import java.util.ArrayList;

/* renamed from: com.b.a.e */
class C1204e extends C1203i {
    private float f3652g;
    private float f3653h;
    private float f3654i;
    private boolean f3655j;

    public /* synthetic */ C1203i m5053b() {
        return m5050a();
    }

    public /* synthetic */ Object clone() {
        return m5050a();
    }

    public C1204e(C1208a... keyframes) {
        super(keyframes);
        this.f3655j = true;
    }

    public Object m5051a(float fraction) {
        return Float.valueOf(m5052b(fraction));
    }

    public C1204e m5050a() {
        ArrayList keyframes = this.e;
        int numKeyframes = this.e.size();
        C1208a[] newKeyframes = new C1208a[numKeyframes];
        for (int i = 0; i < numKeyframes; i++) {
            newKeyframes[i] = (C1208a) ((C1207h) keyframes.get(i)).m5070e();
        }
        return new C1204e(newKeyframes);
    }

    public float m5052b(float fraction) {
        if (this.a == 2) {
            if (this.f3655j) {
                this.f3655j = false;
                this.f3652g = ((C1208a) this.e.get(0)).m5074f();
                this.f3653h = ((C1208a) this.e.get(1)).m5074f();
                this.f3654i = this.f3653h - this.f3652g;
            }
            if (this.d != null) {
                fraction = this.d.getInterpolation(fraction);
            }
            if (this.f == null) {
                return this.f3652g + (this.f3654i * fraction);
            }
            return ((Number) this.f.m5042a(fraction, Float.valueOf(this.f3652g), Float.valueOf(this.f3653h))).floatValue();
        } else if (fraction <= 0.0f) {
            prevKeyframe = (C1208a) this.e.get(0);
            nextKeyframe = (C1208a) this.e.get(1);
            prevValue = prevKeyframe.m5074f();
            nextValue = nextKeyframe.m5074f();
            prevFraction = prevKeyframe.m5068c();
            nextFraction = nextKeyframe.m5068c();
            interpolator = nextKeyframe.m5069d();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            return this.f == null ? ((nextValue - prevValue) * intervalFraction) + prevValue : ((Number) this.f.m5042a(intervalFraction, Float.valueOf(prevValue), Float.valueOf(nextValue))).floatValue();
        } else if (fraction >= 1.0f) {
            prevKeyframe = (C1208a) this.e.get(this.a - 2);
            nextKeyframe = (C1208a) this.e.get(this.a - 1);
            prevValue = prevKeyframe.m5074f();
            nextValue = nextKeyframe.m5074f();
            prevFraction = prevKeyframe.m5068c();
            nextFraction = nextKeyframe.m5068c();
            interpolator = nextKeyframe.m5069d();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            return this.f == null ? ((nextValue - prevValue) * intervalFraction) + prevValue : ((Number) this.f.m5042a(intervalFraction, Float.valueOf(prevValue), Float.valueOf(nextValue))).floatValue();
        } else {
            prevKeyframe = (C1208a) this.e.get(0);
            int i = 1;
            while (i < this.a) {
                nextKeyframe = (C1208a) this.e.get(i);
                if (fraction < nextKeyframe.m5068c()) {
                    interpolator = nextKeyframe.m5069d();
                    if (interpolator != null) {
                        fraction = interpolator.getInterpolation(fraction);
                    }
                    intervalFraction = (fraction - prevKeyframe.m5068c()) / (nextKeyframe.m5068c() - prevKeyframe.m5068c());
                    prevValue = prevKeyframe.m5074f();
                    nextValue = nextKeyframe.m5074f();
                    return this.f == null ? ((nextValue - prevValue) * intervalFraction) + prevValue : ((Number) this.f.m5042a(intervalFraction, Float.valueOf(prevValue), Float.valueOf(nextValue))).floatValue();
                } else {
                    prevKeyframe = nextKeyframe;
                    i++;
                }
            }
            return ((Number) ((C1207h) this.e.get(this.a - 1)).m5067b()).floatValue();
        }
    }
}
