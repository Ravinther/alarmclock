package com.p037b.p038a;

import android.view.animation.Interpolator;
import com.p037b.p038a.C1207h.C1208a;
import com.p037b.p038a.C1207h.C1209b;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.b.a.i */
class C1203i {
    int f3646a;
    C1207h f3647b;
    C1207h f3648c;
    Interpolator f3649d;
    ArrayList f3650e;
    C1201m f3651f;

    public /* synthetic */ Object clone() {
        return m5049b();
    }

    public C1203i(C1207h... keyframes) {
        this.f3646a = keyframes.length;
        this.f3650e = new ArrayList();
        this.f3650e.addAll(Arrays.asList(keyframes));
        this.f3647b = (C1207h) this.f3650e.get(0);
        this.f3648c = (C1207h) this.f3650e.get(this.f3646a - 1);
        this.f3649d = this.f3648c.m5069d();
    }

    public static C1203i m5046a(int... values) {
        int numKeyframes = values.length;
        C1209b[] keyframes = new C1209b[Math.max(numKeyframes, 2)];
        if (numKeyframes == 1) {
            keyframes[0] = (C1209b) C1207h.m5060a(0.0f);
            keyframes[1] = (C1209b) C1207h.m5062a(1.0f, values[0]);
        } else {
            keyframes[0] = (C1209b) C1207h.m5062a(0.0f, values[0]);
            for (int i = 1; i < numKeyframes; i++) {
                keyframes[i] = (C1209b) C1207h.m5062a(((float) i) / ((float) (numKeyframes - 1)), values[i]);
            }
        }
        return new C1206g(keyframes);
    }

    public static C1203i m5045a(float... values) {
        int numKeyframes = values.length;
        C1208a[] keyframes = new C1208a[Math.max(numKeyframes, 2)];
        if (numKeyframes == 1) {
            keyframes[0] = (C1208a) C1207h.m5063b(0.0f);
            keyframes[1] = (C1208a) C1207h.m5061a(1.0f, values[0]);
        } else {
            keyframes[0] = (C1208a) C1207h.m5061a(0.0f, values[0]);
            for (int i = 1; i < numKeyframes; i++) {
                keyframes[i] = (C1208a) C1207h.m5061a(((float) i) / ((float) (numKeyframes - 1)), values[i]);
            }
        }
        return new C1204e(keyframes);
    }

    public void m5048a(C1201m evaluator) {
        this.f3651f = evaluator;
    }

    public C1203i m5049b() {
        ArrayList keyframes = this.f3650e;
        int numKeyframes = this.f3650e.size();
        C1207h[] newKeyframes = new C1207h[numKeyframes];
        for (int i = 0; i < numKeyframes; i++) {
            newKeyframes[i] = ((C1207h) keyframes.get(i)).m5070e();
        }
        return new C1203i(newKeyframes);
    }

    public Object m5047a(float fraction) {
        if (this.f3646a == 2) {
            if (this.f3649d != null) {
                fraction = this.f3649d.getInterpolation(fraction);
            }
            return this.f3651f.m5042a(fraction, this.f3647b.m5067b(), this.f3648c.m5067b());
        } else if (fraction <= 0.0f) {
            nextKeyframe = (C1207h) this.f3650e.get(1);
            interpolator = nextKeyframe.m5069d();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            prevFraction = this.f3647b.m5068c();
            return this.f3651f.m5042a((fraction - prevFraction) / (nextKeyframe.m5068c() - prevFraction), this.f3647b.m5067b(), nextKeyframe.m5067b());
        } else if (fraction >= 1.0f) {
            prevKeyframe = (C1207h) this.f3650e.get(this.f3646a - 2);
            interpolator = this.f3648c.m5069d();
            if (interpolator != null) {
                fraction = interpolator.getInterpolation(fraction);
            }
            prevFraction = prevKeyframe.m5068c();
            return this.f3651f.m5042a((fraction - prevFraction) / (this.f3648c.m5068c() - prevFraction), prevKeyframe.m5067b(), this.f3648c.m5067b());
        } else {
            prevKeyframe = this.f3647b;
            for (int i = 1; i < this.f3646a; i++) {
                nextKeyframe = (C1207h) this.f3650e.get(i);
                if (fraction < nextKeyframe.m5068c()) {
                    interpolator = nextKeyframe.m5069d();
                    if (interpolator != null) {
                        fraction = interpolator.getInterpolation(fraction);
                    }
                    prevFraction = prevKeyframe.m5068c();
                    return this.f3651f.m5042a((fraction - prevFraction) / (nextKeyframe.m5068c() - prevFraction), prevKeyframe.m5067b(), nextKeyframe.m5067b());
                }
                prevKeyframe = nextKeyframe;
            }
            return this.f3648c.m5067b();
        }
    }

    public String toString() {
        String returnVal = " ";
        for (int i = 0; i < this.f3646a; i++) {
            returnVal = returnVal + ((C1207h) this.f3650e.get(i)).m5067b() + "  ";
        }
        return returnVal;
    }
}
