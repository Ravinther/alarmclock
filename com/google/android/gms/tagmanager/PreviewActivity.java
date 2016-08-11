package com.google.android.gms.tagmanager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class PreviewActivity extends Activity {

    /* renamed from: com.google.android.gms.tagmanager.PreviewActivity.1 */
    class C22491 implements OnClickListener {
        final /* synthetic */ PreviewActivity YO;

        C22491(PreviewActivity previewActivity) {
            this.YO = previewActivity;
        }

        public void onClick(DialogInterface dialog, int which) {
        }
    }

    private void m9299b(String str, String str2, String str3) {
        AlertDialog create = new Builder(this).create();
        create.setTitle(str);
        create.setMessage(str2);
        create.setButton(-1, str3, new C22491(this));
        create.show();
    }

    public void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            bh.m9374x("Preview activity");
            Uri data = getIntent().getData();
            if (!TagManager.getInstance(this).m9306g(data)) {
                String str = "Cannot preview the app with the uri: " + data + ". Launching current version instead.";
                bh.m9376z(str);
                m9299b("Preview failure", str, "Continue");
            }
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            if (launchIntentForPackage != null) {
                bh.m9374x("Invoke the launch activity for package name: " + getPackageName());
                startActivity(launchIntentForPackage);
                return;
            }
            bh.m9374x("No launch activity found for package name: " + getPackageName());
        } catch (Exception e) {
            bh.m9373w("Calling preview threw an exception: " + e.getMessage());
        }
    }
}
