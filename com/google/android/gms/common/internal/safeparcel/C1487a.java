package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.request.GameRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.common.internal.safeparcel.a */
public class C1487a {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.a.a */
    public static class C1486a extends RuntimeException {
        public C1486a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static ArrayList m6315A(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(a + dataPosition);
        return createStringArrayList;
    }

    public static Parcel m6316B(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a);
        parcel.setDataPosition(a + dataPosition);
        return obtain;
    }

    public static Parcel[] m6317C(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i2] = obtain;
                parcel.setDataPosition(readInt2 + dataPosition2);
            } else {
                parcelArr[i2] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a);
        return parcelArr;
    }

    public static int m6318R(int i) {
        return GameRequest.TYPE_ALL & i;
    }

    public static int m6319a(Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (i >> 16) & GameRequest.TYPE_ALL : parcel.readInt();
    }

    public static Parcelable m6320a(Parcel parcel, int i, Creator creator) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(a + dataPosition);
        return parcelable;
    }

    private static void m6321a(Parcel parcel, int i, int i2) {
        int a = C1487a.m6319a(parcel, i);
        if (a != i2) {
            throw new C1486a("Expected size " + i2 + " got " + a + " (0x" + Integer.toHexString(a) + ")", parcel);
        }
    }

    private static void m6322a(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            throw new C1486a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
        }
    }

    public static void m6323a(Parcel parcel, int i, List list, ClassLoader classLoader) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(a + dataPosition);
        }
    }

    public static void m6324b(Parcel parcel, int i) {
        parcel.setDataPosition(C1487a.m6319a(parcel, i) + parcel.dataPosition());
    }

    public static Object[] m6325b(Parcel parcel, int i, Creator creator) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Object[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArray;
    }

    public static ArrayList m6326c(Parcel parcel, int i, Creator creator) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(a + dataPosition);
        return createTypedArrayList;
    }

    public static boolean m6327c(Parcel parcel, int i) {
        C1487a.m6321a(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean m6328d(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        if (a == 0) {
            return null;
        }
        C1487a.m6322a(parcel, i, a, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static byte m6329e(Parcel parcel, int i) {
        C1487a.m6321a(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static short m6330f(Parcel parcel, int i) {
        C1487a.m6321a(parcel, i, 4);
        return (short) parcel.readInt();
    }

    public static int m6331g(Parcel parcel, int i) {
        C1487a.m6321a(parcel, i, 4);
        return parcel.readInt();
    }

    public static Integer m6332h(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        if (a == 0) {
            return null;
        }
        C1487a.m6322a(parcel, i, a, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long m6333i(Parcel parcel, int i) {
        C1487a.m6321a(parcel, i, 8);
        return parcel.readLong();
    }

    public static BigInteger m6334j(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return new BigInteger(createByteArray);
    }

    public static float m6335k(Parcel parcel, int i) {
        C1487a.m6321a(parcel, i, 4);
        return parcel.readFloat();
    }

    public static double m6336l(Parcel parcel, int i) {
        C1487a.m6321a(parcel, i, 8);
        return parcel.readDouble();
    }

    public static BigDecimal m6337m(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(a + dataPosition);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static int m6338n(Parcel parcel) {
        return parcel.readInt();
    }

    public static String m6339n(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(a + dataPosition);
        return readString;
    }

    public static int m6340o(Parcel parcel) {
        int n = C1487a.m6338n(parcel);
        int a = C1487a.m6319a(parcel, n);
        int dataPosition = parcel.dataPosition();
        if (C1487a.m6318R(n) != 20293) {
            throw new C1486a("Expected object header. Got 0x" + Integer.toHexString(n), parcel);
        }
        n = dataPosition + a;
        if (n >= dataPosition && n <= parcel.dataSize()) {
            return n;
        }
        throw new C1486a("Size read is invalid start=" + dataPosition + " end=" + n, parcel);
    }

    public static IBinder m6341o(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(a + dataPosition);
        return readStrongBinder;
    }

    public static Bundle m6342p(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(a + dataPosition);
        return readBundle;
    }

    public static byte[] m6343q(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(a + dataPosition);
        return createByteArray;
    }

    public static byte[][] m6344r(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return (byte[][]) null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a);
        return bArr;
    }

    public static boolean[] m6345s(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(a + dataPosition);
        return createBooleanArray;
    }

    public static int[] m6346t(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(a + dataPosition);
        return createIntArray;
    }

    public static long[] m6347u(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(a + dataPosition);
        return createLongArray;
    }

    public static BigInteger[] m6348v(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            bigIntegerArr[i2] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigIntegerArr;
    }

    public static float[] m6349w(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(a + dataPosition);
        return createFloatArray;
    }

    public static double[] m6350x(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(a + dataPosition);
        return createDoubleArray;
    }

    public static BigDecimal[] m6351y(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i2] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a);
        return bigDecimalArr;
    }

    public static String[] m6352z(Parcel parcel, int i) {
        int a = C1487a.m6319a(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (a == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(a + dataPosition);
        return createStringArray;
    }
}
