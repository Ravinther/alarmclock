package com.p037b.p038a;

import com.p037b.p038a.C1207h.C1209b;
import java.util.ArrayList;

/* renamed from: com.b.a.g */
class C1206g extends C1203i {
    private int f3656g;
    private int f3657h;
    private int f3658i;
    private boolean f3659j;

    public /* synthetic */ C1203i m5059b() {
        return m5056a();
    }

    public /* synthetic */ Object clone() {
        return m5056a();
    }

    public C1206g(C1209b... keyframes) {
        super(keyframes);
        this.f3659j = true;
    }

    public Object m5057a(float fraction) {
        return Integer.valueOf(m5058b(fraction));
    }

    public C1206g m5056a() {
        ArrayList keyframes = this.e;
        int numKeyframes = this.e.size();
        C1209b[] newKeyframes = new C1209b[numKeyframes];
        for (int i = 0; i < numKeyframes; i++) {
            newKeyframes[i] = (C1209b) ((C1207h) keyframes.get(i)).m5070e();
        }
        return new C1206g(newKeyframes);
    }

    public int m5058b(float fraction) {
        if (this.a == 2) {
            if (this.f3659j) {
                this.f3659j = false;
                this.f3656g = ((C1209b) this.e.get(0)).m5079f();
                this.f3657h = ((C1209b) this.e.get(1)).m5079f();
                this.f3658i = this.f3657h - this.f3656g;
            }
            if (this.d != null) {
                fraction = this.d.getInterpolation(fraction);
            }
            if (this.f == null) {
                return this.f3656g + ((int) (((float) this.f3658i) * fraction));
            }
            return ((Number) this.f.m5042a(fraction, Integer.valueOf(this.f3656g), Integer.valueOf(this.f3657h))).intValue();
        } else if (fraction <= 0.0f) {
            prevKeyframe = (C1209b) this.e.get(0);
            nextKeyframe = (C1209b) this.e.get(1);
            prevValue = prevKeyframe.m5079f();
            nextValue = nextKeyframe.m5079f();
            prevFraction = prevKeyframe.m5068c();
            nextFraction = nextKeyframe.m5068c();
            interpolator = nextKeyframe.m5069d();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            return this.f == null ? ((int) (((float) (nextValue - prevValue)) * intervalFraction)) + prevValue : ((Number) this.f.m5042a(intervalFraction, Integer.valueOf(prevValue), Integer.valueOf(nextValue))).intValue();
        } else if (fraction >= 1.0f) {
            prevKeyframe = (C1209b) this.e.get(this.a - 2);
            nextKeyframe = (C1209b) this.e.get(this.a - 1);
            prevValue = prevKeyframe.m5079f();
            nextValue = nextKeyframe.m5079f();
            prevFraction = prevKeyframe.m5068c();
            nextFraction = nextKeyframe.m5068c();
            interpolator = nextKeyframe.m5069d();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            intervalFraction = (fraction - prevFraction) / (nextFraction - prevFraction);
            return this.f == null ? ((int) (((float) (nextValue - prevValue)) * intervalFraction)) + prevValue : ((Number) this.f.m5042a(intervalFraction, Integer.valueOf(prevValue), Integer.valueOf(nextValue))).intValue();
        } else {
            prevKeyframe = (C1209b) this.e.get(0);
            int i = 1;
            while (i < this.a) {
                nextKeyframe = (C1209b) this.e.get(i);
                if (fraction < nextKeyframe.m5068c()) {
                    interpolator = nextKeyframe.m5069d();
                    if (interpolator != null) {
                        fraction = interpolator.getInterpolation(fraction);
                    }
                    intervalFraction = (fraction - prevKeyframe.m5068c()) / (nextKeyframe.m5068c() - prevKeyframe.m5068c());
                    prevValue = prevKeyframe.m5079f();
                    nextValue = nextKeyframe.m5079f();
                    return this.f == null ? ((int) (((float) (nextValue - prevValue)) * intervalFraction)) + prevValue : ((Number) this.f.m5042a(intervalFraction, Integer.valueOf(prevValue), Integer.valueOf(nextValue))).intValue();
                } else {
                    prevKeyframe = nextKeyframe;
                    i++;
                }
            }
            return ((Number) ((C1207h) this.e.get(this.a - 1)).m5067b()).intValue();
        }
    }
}
