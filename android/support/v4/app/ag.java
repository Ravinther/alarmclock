package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.af.C0052a;
import com.google.android.gms.plus.PlusShare;

class ag {
    static Bundle m164a(C0052a remoteInput) {
        Bundle data = new Bundle();
        data.putString("resultKey", remoteInput.m153a());
        data.putCharSequence(PlusShare.KEY_CALL_TO_ACTION_LABEL, remoteInput.m154b());
        data.putCharSequenceArray("choices", remoteInput.m155c());
        data.putBoolean("allowFreeFormInput", remoteInput.m156d());
        data.putBundle("extras", remoteInput.m157e());
        return data;
    }

    static Bundle[] m165a(C0052a[] remoteInputs) {
        if (remoteInputs == null) {
            return null;
        }
        Bundle[] bundles = new Bundle[remoteInputs.length];
        for (int i = 0; i < remoteInputs.length; i++) {
            bundles[i] = m164a(remoteInputs[i]);
        }
        return bundles;
    }
}
