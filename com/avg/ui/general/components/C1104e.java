package com.avg.ui.general.components;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.p034b.C0952b;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.p051g.C0973b;
import com.avg.toolkit.p051g.C0974c;
import com.avg.toolkit.p051g.C0979g;
import com.avg.toolkit.zen.C1045b;
import com.avg.toolkit.zen.C1050e;
import com.avg.toolkit.zen.p054a.C1033a;
import com.avg.toolkit.zen.p054a.C1033a.C1032a;
import com.avg.toolkit.zen.p054a.C1038d;
import com.avg.toolkit.zen.p054a.C1038d.C1036a;
import com.avg.toolkit.zen.p054a.C1039e;
import com.avg.ui.general.C1091c.C1081e;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.customviews.C1157d;
import com.avg.ui.general.p043e.C0720a;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* renamed from: com.avg.ui.general.components.e */
public class C1104e extends C0720a {
    private EditText f3335a;
    private C1157d f3336d;
    private Dialog f3337e;
    private OnClickListener f3338f;

    /* renamed from: com.avg.ui.general.components.e.a */
    public interface C1097a {
        void m4676l();
    }

    /* renamed from: com.avg.ui.general.components.e.1 */
    class C11011 implements OnClickListener {
        final /* synthetic */ C1104e f3322a;

        C11011(C1104e c1104e) {
            this.f3322a = c1104e;
        }

        public void onClick(View v) {
            if (v.getId() != C1082f.buttonJoin) {
                return;
            }
            if ("".equals(this.f3322a.f3335a.getText().toString())) {
                this.f3322a.m4705a();
            } else if (C0952b.m4281a(this.f3322a.getActivity())) {
                this.f3322a.m4703u();
            } else {
                Toast.makeText(this.f3322a.getActivity(), this.f3322a.getActivity().getString(C1085i.ias_alert_dialog_message), 1).show();
            }
        }
    }

    /* renamed from: com.avg.ui.general.components.e.b */
    public static class C1103b extends Handler {
        private Context f3324a;
        private WeakReference f3325b;
        private String f3326c;
        private String f3327d;
        private String f3328e;
        private String f3329f;
        private String f3330g;
        private String f3331h;
        private String f3332i;
        private String f3333j;
        private C1045b f3334k;

        /* renamed from: com.avg.ui.general.components.e.b.1 */
        class C11021 implements C1033a {
            final /* synthetic */ C1103b f3323a;

            C11021(C1103b c1103b) {
                this.f3323a = c1103b;
            }

            public void m4691a(C1032a type, int responseCode, String JsonBody) {
                if (responseCode != 200) {
                    this.f3323a.m4694a(responseCode);
                } else if (this.f3323a.m4700b(responseCode, JsonBody)) {
                    this.f3323a.m4693a();
                } else {
                    this.f3323a.m4694a(-1);
                }
            }

            public void m4692a(C1036a type) {
            }
        }

        public C1103b(Context appContext, C1104e fragment, String pin, C1045b reportBuilder) {
            this.f3324a = appContext;
            this.f3325b = new WeakReference(fragment);
            this.f3326c = pin;
            this.f3334k = reportBuilder;
        }

        public void handleMessage(Message msg) {
            String responseJson = "";
            int responseCode = -1;
            if (msg.obj instanceof String) {
                responseJson = msg.obj;
                responseCode = msg.what;
            }
            if (responseCode != 200) {
                m4694a(responseCode);
            } else if (m4698a(responseCode, responseJson)) {
                C1104e fragment = (C1104e) this.f3325b.get();
                if (fragment != null) {
                    C1033a callback = new C11021(this);
                    if (fragment.getActivity() != null) {
                        new C1039e(this.f3324a, this.f3326c, this.f3334k, callback, "joinDeviceFragment").execute(new Void[0]);
                    } else {
                        m4694a(-1);
                    }
                }
            } else {
                m4694a(-1);
            }
        }

        private boolean m4698a(int responseCode, String JsonBody) {
            try {
                JSONObject json = new JSONObject(JsonBody);
                this.f3331h = json.getString("accountId");
                this.f3332i = json.getString("hash");
                this.f3333j = json.getString("login");
                return true;
            } catch (Exception e) {
                C0970a.m4325b("Error while trying to parse the join device response");
                return false;
            }
        }

        private boolean m4700b(int responseCode, String JsonBody) {
            try {
                JSONObject json = new JSONObject(JsonBody);
                this.f3327d = json.getString("id");
                JSONObject device = json.getJSONArray("devices").getJSONObject(0);
                this.f3329f = device.getString("token");
                this.f3328e = device.getString("id");
                this.f3330g = json.getJSONObject("cloud_data").getString(Event.INTENT_EMAIL);
                return true;
            } catch (Exception e) {
                C0970a.m4325b("Error while trying to parse the join device response");
                return false;
            }
        }

        private void m4693a() {
            C1050e.m4543b(this.f3324a, this.f3330g);
            C1050e.m4549e(this.f3324a, this.f3327d);
            C1050e.m4556h(this.f3324a, this.f3328e);
            C1050e.m4560j(this.f3324a, this.f3329f);
            C0979g.m4346a(this.f3324a, this.f3331h);
            C0979g.m4348b(this.f3324a, this.f3332i);
            C0979g.m4350c(this.f3324a, this.f3333j);
            C1038d.m4517a(this.f3324a);
            C1038d.m4521a(this.f3324a, true);
            C0974c.m4333a(this.f3324a);
            m4697a(true);
            C1104e fragment = (C1104e) this.f3325b.get();
            if (fragment != null) {
                fragment.m4708d();
                Activity activity = fragment.getActivity();
                if (activity instanceof C1097a) {
                    ((C1097a) activity).m4676l();
                }
            }
        }

        private void m4694a(int responseCode) {
            m4697a(false);
            if (responseCode == -1) {
                Toast.makeText(this.f3324a, this.f3324a.getString(C1085i.ias_alert_dialog_message), 1).show();
                return;
            }
            C1104e fragment = (C1104e) this.f3325b.get();
            if (fragment != null) {
                fragment.m4705a();
                fragment.m4708d();
            }
        }

        private void m4697a(boolean success) {
            GoogleAnalyticsWrapper.trackEvent(this.f3324a, "Drawer", "Join_button", success ? "Success" : "Error", 0);
        }
    }

    public C1104e() {
        this.f3338f = new C11011(this);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof C1095d)) {
            throw new ClassCastException(activity.toString() + " must implement ManageDevicesFragmentCallback");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View content = inflater.inflate(C1084h.join_network_layout, null);
        this.f3335a = (EditText) content.findViewById(C1082f.editTextPin);
        ((Button) content.findViewById(C1082f.buttonJoin)).setOnClickListener(this.f3338f);
        return content;
    }

    public String m4706b() {
        return "JoinNetworkFragment";
    }

    public int m4707c() {
        return C1085i.enter_invitation;
    }

    private void m4703u() {
        Context context = getActivity();
        String pin = this.f3335a.getText().toString();
        this.f3337e = new C1099a(context);
        this.f3337e.show();
        C0973b.m4331a(context.getApplicationContext(), new C1103b(context.getApplicationContext(), this, pin, ((C1095d) context).m4673k()), pin);
    }

    public void m4705a() {
        if (getActivity() != null) {
            this.f3335a.setBackgroundResource(C1081e.edit_text_red);
            if (this.f3336d == null) {
                this.f3336d = new C1157d(getActivity().getApplicationContext());
                this.f3336d.m4853a(C1085i.join_network_incorrent_pin);
            }
            this.f3336d.m4854a(this.f3335a, 3000);
        }
    }

    private void m4704v() {
        if (this.f3336d != null) {
            this.f3336d.dismiss();
            this.f3336d = null;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        m4704v();
    }

    public void m4708d() {
        try {
            if (this.f3337e != null && this.f3337e.isShowing()) {
                this.f3337e.dismiss();
            }
            this.f3337e = null;
        } catch (IllegalArgumentException e) {
        }
    }
}
