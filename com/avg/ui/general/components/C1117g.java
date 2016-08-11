package com.avg.ui.general.components;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.avg.toolkit.zen.C1050e;
import com.avg.toolkit.zen.p054a.C1033a;
import com.avg.toolkit.zen.p054a.C1033a.C1032a;
import com.avg.toolkit.zen.p054a.C1038d;
import com.avg.toolkit.zen.p054a.C1038d.C1036a;
import com.avg.toolkit.zen.p054a.C1041g;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.p043e.C0720a;

/* renamed from: com.avg.ui.general.components.g */
public class C1117g extends C0720a {
    private View f3376a;
    private OnClickListener f3377d;

    /* renamed from: com.avg.ui.general.components.g.1 */
    class C11141 implements OnClickListener {
        final /* synthetic */ C1117g f3371a;

        C11141(C1117g c1117g) {
            this.f3371a = c1117g;
        }

        public void onClick(View v) {
            if (v.getId() == C1082f.buttonLogOut) {
                this.f3371a.m4743a(this.f3371a.getActivity());
            }
        }
    }

    /* renamed from: com.avg.ui.general.components.g.2 */
    class C11162 implements C1033a {
        final /* synthetic */ Context f3374a;
        final /* synthetic */ C1117g f3375b;

        /* renamed from: com.avg.ui.general.components.g.2.1 */
        class C11151 implements Runnable {
            final /* synthetic */ Activity f3372a;
            final /* synthetic */ C11162 f3373b;

            C11151(C11162 c11162, Activity activity) {
                this.f3373b = c11162;
                this.f3372a = activity;
            }

            public void run() {
                this.f3372a.onBackPressed();
            }
        }

        C11162(C1117g c1117g, Context context) {
            this.f3375b = c1117g;
            this.f3374a = context;
        }

        public void m4741a(C1036a type) {
            C1038d.m4517a(this.f3374a);
            C1038d.m4521a(this.f3374a, false);
            Activity activity = this.f3375b.getActivity();
            if (activity != null) {
                try {
                    activity.onBackPressed();
                } catch (AndroidRuntimeException e) {
                    activity.runOnUiThread(new C11151(this, activity));
                }
            }
        }

        public void m4740a(C1032a type, int responseCode, String JsonBody) {
        }
    }

    public C1117g() {
        this.f3377d = new C11141(this);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f3376a = inflater.inflate(C1084h.manage_devices_layout, null);
        ((Button) this.f3376a.findViewById(C1082f.buttonLogOut)).setOnClickListener(this.f3377d);
        return this.f3376a;
    }

    public void onResume() {
        super.onResume();
        m4742a();
    }

    public String m4745b() {
        return "ManageDevicesFragment";
    }

    public int m4746c() {
        return C1085i.my_zen_network;
    }

    private void m4743a(Context context) {
        new C1041g(context, new C1099a(context), new C11162(this, context.getApplicationContext()), "logoutJoinedDevice").execute(new Void[0]);
    }

    private void m4742a() {
        boolean isJoined = C1050e.m4567q(getActivity().getApplicationContext());
        Context appContext = getActivity().getApplicationContext();
        ((TextView) this.f3376a.findViewById(C1082f.textViewMail)).setText(isJoined ? C1050e.m4555h(appContext) : C1050e.m4557i(appContext));
    }
}
