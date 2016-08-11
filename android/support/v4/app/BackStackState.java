package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.C0068e.C0064a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator CREATOR;
    final int[] f70a;
    final int f71b;
    final int f72c;
    final String f73d;
    final int f74e;
    final int f75f;
    final CharSequence f76g;
    final int f77h;
    final CharSequence f78i;
    final ArrayList f79j;
    final ArrayList f80k;

    /* renamed from: android.support.v4.app.BackStackState.1 */
    static class C00311 implements Creator {
        C00311() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return m114a(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return m115a(x0);
        }

        public BackStackState m114a(Parcel in) {
            return new BackStackState(in);
        }

        public BackStackState[] m115a(int size) {
            return new BackStackState[size];
        }
    }

    public BackStackState(C0082j fm, C0068e bse) {
        C0064a op;
        int numRemoved = 0;
        for (op = bse.f159b; op != null; op = op.f144a) {
            if (op.f152i != null) {
                numRemoved += op.f152i.size();
            }
        }
        this.f70a = new int[((bse.f161d * 7) + numRemoved)];
        if (bse.f168k) {
            op = bse.f159b;
            int pos = 0;
            while (op != null) {
                int i = pos + 1;
                this.f70a[pos] = op.f146c;
                pos = i + 1;
                this.f70a[i] = op.f147d != null ? op.f147d.mIndex : -1;
                i = pos + 1;
                this.f70a[pos] = op.f148e;
                pos = i + 1;
                this.f70a[i] = op.f149f;
                i = pos + 1;
                this.f70a[pos] = op.f150g;
                pos = i + 1;
                this.f70a[i] = op.f151h;
                if (op.f152i != null) {
                    int N = op.f152i.size();
                    i = pos + 1;
                    this.f70a[pos] = N;
                    int i2 = 0;
                    pos = i;
                    while (i2 < N) {
                        i = pos + 1;
                        this.f70a[pos] = ((Fragment) op.f152i.get(i2)).mIndex;
                        i2++;
                        pos = i;
                    }
                    i = pos;
                } else {
                    i = pos + 1;
                    this.f70a[pos] = 0;
                }
                op = op.f144a;
                pos = i;
            }
            this.f71b = bse.f166i;
            this.f72c = bse.f167j;
            this.f73d = bse.f170m;
            this.f74e = bse.f172o;
            this.f75f = bse.f173p;
            this.f76g = bse.f174q;
            this.f77h = bse.f175r;
            this.f78i = bse.f176s;
            this.f79j = bse.f177t;
            this.f80k = bse.f178u;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel in) {
        this.f70a = in.createIntArray();
        this.f71b = in.readInt();
        this.f72c = in.readInt();
        this.f73d = in.readString();
        this.f74e = in.readInt();
        this.f75f = in.readInt();
        this.f76g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.f77h = in.readInt();
        this.f78i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.f79j = in.createStringArrayList();
        this.f80k = in.createStringArrayList();
    }

    public C0068e m116a(C0082j fm) {
        C0068e bse = new C0068e(fm);
        int pos = 0;
        int num = 0;
        while (pos < this.f70a.length) {
            C0064a op = new C0064a();
            int pos2 = pos + 1;
            op.f146c = this.f70a[pos];
            if (C0082j.f213a) {
                Log.v("FragmentManager", "Instantiate " + bse + " op #" + num + " base fragment #" + this.f70a[pos2]);
            }
            pos = pos2 + 1;
            int findex = this.f70a[pos2];
            if (findex >= 0) {
                op.f147d = (Fragment) fm.f219f.get(findex);
            } else {
                op.f147d = null;
            }
            pos2 = pos + 1;
            op.f148e = this.f70a[pos];
            pos = pos2 + 1;
            op.f149f = this.f70a[pos2];
            pos2 = pos + 1;
            op.f150g = this.f70a[pos];
            pos = pos2 + 1;
            op.f151h = this.f70a[pos2];
            pos2 = pos + 1;
            int N = this.f70a[pos];
            if (N > 0) {
                op.f152i = new ArrayList(N);
                int i = 0;
                while (i < N) {
                    if (C0082j.f213a) {
                        Log.v("FragmentManager", "Instantiate " + bse + " set remove fragment #" + this.f70a[pos2]);
                    }
                    pos = pos2 + 1;
                    op.f152i.add((Fragment) fm.f219f.get(this.f70a[pos2]));
                    i++;
                    pos2 = pos;
                }
            }
            pos = pos2;
            bse.m231a(op);
            num++;
        }
        bse.f166i = this.f71b;
        bse.f167j = this.f72c;
        bse.f170m = this.f73d;
        bse.f172o = this.f74e;
        bse.f168k = true;
        bse.f173p = this.f75f;
        bse.f174q = this.f76g;
        bse.f175r = this.f77h;
        bse.f176s = this.f78i;
        bse.f177t = this.f79j;
        bse.f178u = this.f80k;
        bse.m238b(1);
        return bse;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(this.f70a);
        dest.writeInt(this.f71b);
        dest.writeInt(this.f72c);
        dest.writeString(this.f73d);
        dest.writeInt(this.f74e);
        dest.writeInt(this.f75f);
        TextUtils.writeToParcel(this.f76g, dest, 0);
        dest.writeInt(this.f77h);
        TextUtils.writeToParcel(this.f78i, dest, 0);
        dest.writeStringList(this.f79j);
        dest.writeStringList(this.f80k);
    }

    static {
        CREATOR = new C00311();
    }
}
