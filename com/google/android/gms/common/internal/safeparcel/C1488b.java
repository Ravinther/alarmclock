package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.games.request.GameRequest;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.b */
public class C1488b {
    private static int m6353D(Parcel parcel, int i) {
        parcel.writeInt(-65536 | i);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void m6354E(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        int i2 = dataPosition - i;
        parcel.setDataPosition(i - 4);
        parcel.writeInt(i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void m6355F(Parcel parcel, int i) {
        C1488b.m6354E(parcel, i);
    }

    public static void m6356a(Parcel parcel, int i, byte b) {
        C1488b.m6376b(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void m6357a(Parcel parcel, int i, double d) {
        C1488b.m6376b(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void m6358a(Parcel parcel, int i, float f) {
        C1488b.m6376b(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void m6359a(Parcel parcel, int i, long j) {
        C1488b.m6376b(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m6360a(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.writeBundle(bundle);
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6361a(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.writeStrongBinder(iBinder);
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6362a(Parcel parcel, int i, Parcel parcel2, boolean z) {
        if (parcel2 != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6363a(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int D = C1488b.m6353D(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6364a(Parcel parcel, int i, Boolean bool, boolean z) {
        int i2 = 0;
        if (bool != null) {
            C1488b.m6376b(parcel, i, 4);
            if (bool.booleanValue()) {
                i2 = 1;
            }
            parcel.writeInt(i2);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6365a(Parcel parcel, int i, Integer num, boolean z) {
        if (num != null) {
            C1488b.m6376b(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6366a(Parcel parcel, int i, String str, boolean z) {
        if (str != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.writeString(str);
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6367a(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.writeStringList(list);
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6368a(Parcel parcel, int i, short s) {
        C1488b.m6376b(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void m6369a(Parcel parcel, int i, boolean z) {
        C1488b.m6376b(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m6370a(Parcel parcel, int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.writeByteArray(bArr);
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6371a(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.writeIntArray(iArr);
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6372a(Parcel parcel, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        if (parcelableArr != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.writeInt(r3);
            for (Parcelable parcelable : parcelableArr) {
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C1488b.m6375a(parcel, parcelable, i2);
                }
            }
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6373a(Parcel parcel, int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.writeStringArray(strArr);
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6374a(Parcel parcel, int i, byte[][] bArr, boolean z) {
        int i2 = 0;
        if (bArr != null) {
            int D = C1488b.m6353D(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            while (i2 < length) {
                parcel.writeByteArray(bArr[i2]);
                i2++;
            }
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    private static void m6375a(Parcel parcel, Parcelable parcelable, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void m6376b(Parcel parcel, int i, int i2) {
        if (i2 >= GameRequest.TYPE_ALL) {
            parcel.writeInt(-65536 | i);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt((i2 << 16) | i);
    }

    public static void m6377b(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int D = C1488b.m6353D(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    C1488b.m6375a(parcel, parcelable, 0);
                }
            }
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static void m6378c(Parcel parcel, int i, int i2) {
        C1488b.m6376b(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m6379c(Parcel parcel, int i, List list, boolean z) {
        if (list != null) {
            int D = C1488b.m6353D(parcel, i);
            parcel.writeList(list);
            C1488b.m6354E(parcel, D);
        } else if (z) {
            C1488b.m6376b(parcel, i, 0);
        }
    }

    public static int m6380p(Parcel parcel) {
        return C1488b.m6353D(parcel, 20293);
    }
}
