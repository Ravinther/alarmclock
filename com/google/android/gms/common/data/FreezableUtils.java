package com.google.android.gms.common.data;

import java.util.ArrayList;

public final class FreezableUtils {
    public static ArrayList freeze(ArrayList list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Freezable) list.get(i)).freeze());
        }
        return arrayList;
    }

    public static ArrayList freeze(Freezable[] array) {
        ArrayList arrayList = new ArrayList(array.length);
        for (Freezable freeze : array) {
            arrayList.add(freeze.freeze());
        }
        return arrayList;
    }

    public static ArrayList freezeIterable(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        for (Freezable freeze : iterable) {
            arrayList.add(freeze.freeze());
        }
        return arrayList;
    }
}
