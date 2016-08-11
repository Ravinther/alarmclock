package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.support.v4.app.af.C0052a;

class ae {
    static RemoteInput[] m163a(C0052a[] srcArray) {
        if (srcArray == null) {
            return null;
        }
        RemoteInput[] result = new RemoteInput[srcArray.length];
        for (int i = 0; i < srcArray.length; i++) {
            C0052a src = srcArray[i];
            result[i] = new Builder(src.m153a()).setLabel(src.m154b()).setChoices(src.m155c()).setAllowFreeFormInput(src.m156d()).addExtras(src.m157e()).build();
        }
        return result;
    }
}
