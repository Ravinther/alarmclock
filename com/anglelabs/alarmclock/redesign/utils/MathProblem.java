package com.anglelabs.alarmclock.redesign.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.util.Random;

public class MathProblem implements Parcelable {
    public static final Creator CREATOR;
    private int f2093a;
    private final int f2094b;
    private int f2095c;
    private final C0788a f2096d;
    private final C0788a f2097e;

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.MathProblem.1 */
    static class C07861 implements Creator {
        C07861() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m3737a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m3738a(x0);
        }

        public MathProblem m3737a(Parcel in) {
            return new MathProblem(in);
        }

        public MathProblem[] m3738a(int size) {
            return new MathProblem[size];
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.MathProblem.2 */
    static /* synthetic */ class C07872 {
        static final /* synthetic */ int[] f2086a;

        static {
            f2086a = new int[C0788a.values().length];
            try {
                f2086a[C0788a.PLUS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2086a[C0788a.MINUS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2086a[C0788a.MULTIPLY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2086a[C0788a.DIVIDE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.MathProblem.a */
    private enum C0788a {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/");
        
        private final String f2092e;

        private C0788a(String text) {
            this.f2092e = text;
        }

        public static C0788a m3739a(int r) {
            int random = new Random().nextInt(r);
            if (random == 0) {
                return PLUS;
            }
            if (random == 1) {
                return MINUS;
            }
            if (random == 2) {
                return MULTIPLY;
            }
            return DIVIDE;
        }

        public int m3740a(int first, int second) {
            switch (C07872.f2086a[ordinal()]) {
                case Base64.NO_PADDING /*1*/:
                    return first + second;
                case Base64.NO_WRAP /*2*/:
                    return first - second;
                case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                    return first * second;
                case Base64.CRLF /*4*/:
                    return first / second;
                default:
                    return 0;
            }
        }

        public String toString() {
            return this.f2092e;
        }
    }

    public MathProblem(Parcel in) {
        this.f2093a = in.readInt();
        this.f2094b = in.readInt();
        this.f2095c = in.readInt();
        this.f2096d = C0788a.values()[in.readInt()];
        this.f2097e = C0788a.values()[in.readInt()];
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.f2093a);
        dest.writeInt(this.f2094b);
        dest.writeInt(this.f2095c);
        dest.writeInt(this.f2096d.ordinal());
        dest.writeInt(this.f2097e.ordinal());
    }

    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new C07861();
    }

    public MathProblem(int difficulty) {
        Random randomNums = new Random();
        this.f2097e = C0788a.m3739a(2);
        this.f2095c = 0;
        if (difficulty == 0) {
            this.f2096d = C0788a.m3739a(2);
            this.f2093a = randomNums.nextInt(9) + 1;
            this.f2094b = randomNums.nextInt(9) + 1;
            if (this.f2096d == C0788a.MINUS && this.f2094b >= this.f2093a) {
                this.f2093a = this.f2094b + this.f2093a;
            }
        } else if (difficulty == 1) {
            this.f2096d = C0788a.m3739a(3);
            if (this.f2096d == C0788a.MULTIPLY) {
                this.f2093a = randomNums.nextInt(5) + 1;
                this.f2094b = randomNums.nextInt(5) + 1;
                return;
            }
            this.f2093a = randomNums.nextInt(29) + 5;
            this.f2094b = randomNums.nextInt(29) + 5;
            if (this.f2096d == C0788a.MINUS && this.f2094b >= this.f2093a) {
                this.f2093a = this.f2094b + this.f2093a;
            }
        } else if (difficulty == 2) {
            this.f2096d = C0788a.m3739a(3);
            if (this.f2096d == C0788a.MULTIPLY) {
                this.f2093a = randomNums.nextInt(13) + 3;
                this.f2094b = randomNums.nextInt(8) + 3;
                return;
            }
            this.f2093a = randomNums.nextInt(69) + 5;
            this.f2094b = randomNums.nextInt(69) + 5;
            if (this.f2096d == C0788a.MINUS && this.f2094b >= this.f2093a) {
                this.f2093a = this.f2094b + this.f2093a;
            }
        } else if (difficulty == 3) {
            this.f2096d = C0788a.m3739a(4);
            if (this.f2096d == C0788a.MULTIPLY) {
                this.f2093a = randomNums.nextInt(16) + 5;
                this.f2094b = randomNums.nextInt(16) + 5;
            } else if (this.f2096d == C0788a.DIVIDE) {
                this.f2094b = randomNums.nextInt(8) + 2;
                this.f2093a = this.f2094b * (randomNums.nextInt(19) + 2);
            } else {
                this.f2093a = randomNums.nextInt(99) + 25;
                this.f2094b = randomNums.nextInt(99) + 25;
                if (this.f2096d == C0788a.MINUS && this.f2094b >= this.f2093a) {
                    this.f2093a = this.f2094b + this.f2093a;
                }
            }
            if (this.f2097e == C0788a.MINUS) {
                this.f2095c = randomNums.nextInt(this.f2096d.m3740a(this.f2093a, this.f2094b));
            } else {
                this.f2095c = randomNums.nextInt(35) + 5;
            }
        } else {
            this.f2096d = C0788a.m3739a(4);
            if (this.f2096d == C0788a.MULTIPLY) {
                this.f2093a = randomNums.nextInt(36) + 7;
                this.f2094b = randomNums.nextInt(36) + 7;
            } else if (this.f2096d == C0788a.DIVIDE) {
                this.f2094b = randomNums.nextInt(29) + 7;
                this.f2093a = this.f2094b * (randomNums.nextInt(29) + 2);
            } else {
                this.f2093a = randomNums.nextInt(795) + 125;
                this.f2094b = randomNums.nextInt(795) + 125;
                if (this.f2096d == C0788a.MINUS && this.f2094b >= this.f2093a) {
                    this.f2093a = this.f2094b + this.f2093a;
                }
            }
            if (this.f2097e == C0788a.MINUS) {
                this.f2095c = randomNums.nextInt(this.f2096d.m3740a(this.f2093a, this.f2094b));
            } else {
                this.f2095c = randomNums.nextInt(795) + 125;
            }
        }
    }

    public String toString() {
        if (this.f2095c == 0) {
            return this.f2093a + " " + this.f2096d + " " + this.f2094b + " = ";
        }
        return this.f2093a + " " + this.f2096d + " " + this.f2094b + " " + this.f2097e + " " + this.f2095c + " = ";
    }

    public String m3741a() {
        return Integer.toString(this.f2097e.m3740a(this.f2096d.m3740a(this.f2093a, this.f2094b), this.f2095c));
    }

    public boolean m3742a(String answer) {
        try {
            return Integer.toString(this.f2097e.m3740a(this.f2096d.m3740a(this.f2093a, this.f2094b), this.f2095c)).equals(answer);
        } catch (Exception e) {
            return false;
        }
    }
}
