package com.avg.ui.general.components;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.C0073g;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.avg.toolkit.ganalytics.GoogleAnalyticsWrapper;
import com.avg.toolkit.p034b.C0952b;
import com.avg.toolkit.p049e.C0970a;
import com.avg.toolkit.p051g.C0974c;
import com.avg.toolkit.p051g.C0978f;
import com.avg.toolkit.p051g.C0979g;
import com.avg.toolkit.p051g.C0980h;
import com.avg.toolkit.zen.C1045b;
import com.avg.toolkit.zen.C1050e;
import com.avg.toolkit.zen.p054a.C1033a;
import com.avg.toolkit.zen.p054a.C1033a.C1032a;
import com.avg.toolkit.zen.p054a.C1038d;
import com.avg.toolkit.zen.p054a.C1038d.C1036a;
import com.avg.toolkit.zen.p054a.C1040f;
import com.avg.ui.general.C1091c.C1081e;
import com.avg.ui.general.C1091c.C1082f;
import com.avg.ui.general.C1091c.C1084h;
import com.avg.ui.general.C1091c.C1085i;
import com.avg.ui.general.customviews.C1157d;
import com.avg.ui.general.customviews.SimpleTabWidget;
import com.avg.ui.general.customviews.SimpleTabWidget.C1107a;
import com.avg.ui.general.p043e.C0720a;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.wallet.WalletConstants;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import org.json.JSONObject;

/* renamed from: com.avg.ui.general.components.f */
public class C1113f extends C0720a {
    private View f3360a;
    private SimpleTabWidget f3361d;
    private Button f3362e;
    private TextView f3363f;
    private EditText f3364g;
    private EditText f3365h;
    private boolean f3366i;
    private Bundle f3367j;
    private C1157d f3368k;
    private C1112b f3369l;
    private OnClickListener f3370m;

    /* renamed from: com.avg.ui.general.components.f.1 */
    class C11051 implements OnClickListener {
        final /* synthetic */ C1113f f3339a;

        C11051(C1113f c1113f) {
            this.f3339a = c1113f;
        }

        public void onClick(View v) {
            C0073g activity = this.f3339a.getActivity();
            Context context = activity.getApplicationContext();
            if (v.getId() == C1082f.buttonLogin) {
                String email = this.f3339a.f3364g.getText().toString();
                String password = this.f3339a.f3365h.getText().toString();
                int position = this.f3339a.f3361d.getSelectedTab();
                boolean signup = position == 0;
                Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(email);
                if (TextUtils.isEmpty(email) || !matcher.find()) {
                    this.f3339a.m4724a(C1036a.VERIFICATION_ERROR, context, signup);
                } else if (password.length() < 6) {
                    this.f3339a.m4724a(C1036a.DATA_ERROR, context, signup);
                } else if (C0952b.m4281a(context)) {
                    C1045b reportBuilder = null;
                    if (activity instanceof C1095d) {
                        reportBuilder = ((C1095d) activity).m4673k();
                    }
                    C1111a loginCallback = new C1111a(context.getApplicationContext(), this.f3339a, email, position, signup, this.f3339a.f3367j);
                    this.f3339a.f3369l = new C1112b();
                    this.f3339a.f3369l.show(activity.m258g(), "LoginWaitDialog");
                    C0980h.m4357a(context.getApplicationContext(), new C0978f(loginCallback), email, password, signup);
                    new C1040f(context, email, password, reportBuilder, signup, loginCallback, "loginFragment").execute(new Void[0]);
                } else {
                    this.f3339a.m4724a(C1036a.CONNECTION_ERROR, context, signup);
                }
            }
        }
    }

    /* renamed from: com.avg.ui.general.components.f.2 */
    class C11062 implements OnClickListener {
        final /* synthetic */ C1113f f3340a;

        C11062(C1113f c1113f) {
            this.f3340a = c1113f;
        }

        public void onClick(View v) {
            ((C1096c) this.f3340a.getActivity()).m4675n();
            if (this.f3340a.f3366i) {
                GoogleAnalyticsWrapper.trackEvent(this.f3340a.getActivity(), "Login_screen", "MyAccout_skip_or_back", "Tap", 0);
            }
        }
    }

    /* renamed from: com.avg.ui.general.components.f.3 */
    class C11083 implements C1107a {
        final /* synthetic */ C1113f f3341a;

        C11083(C1113f c1113f) {
            this.f3341a = c1113f;
        }

        public void m4710a(int position) {
            this.f3341a.m4723a(position);
            GoogleAnalyticsWrapper.trackEvent(this.f3341a.getActivity(), "Login_screen", position == 0 ? "MyAccout_create" : "MyAccout_login", "Tap", 0);
        }
    }

    /* renamed from: com.avg.ui.general.components.f.4 */
    class C11094 implements OnCheckedChangeListener {
        final /* synthetic */ C1113f f3342a;

        C11094(C1113f c1113f) {
            this.f3342a = c1113f;
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int passwordType = 129;
            EditText b = this.f3342a.f3365h;
            if (isChecked) {
                passwordType = 1;
            }
            b.setInputType(passwordType);
            this.f3342a.f3365h.setTypeface(Typeface.DEFAULT);
            this.f3342a.f3365h.setSelection(this.f3342a.f3365h.getText().length());
            GoogleAnalyticsWrapper.trackEvent(this.f3342a.getActivity(), "Login_screen", "MyAccout_show_pass", isChecked ? "Enable" : "Disable", 0);
        }
    }

    /* renamed from: com.avg.ui.general.components.f.5 */
    class C11105 implements Runnable {
        final /* synthetic */ int f3343a;
        final /* synthetic */ C1113f f3344b;

        C11105(C1113f c1113f, int i) {
            this.f3344b = c1113f;
            this.f3343a = i;
        }

        public void run() {
            this.f3344b.f3363f.setVisibility(this.f3343a == 0 ? 8 : 0);
        }
    }

    /* renamed from: com.avg.ui.general.components.f.a */
    private static class C1111a implements C1033a {
        private Context f3345a;
        private int f3346b;
        private int f3347c;
        private String f3348d;
        private String f3349e;
        private String f3350f;
        private String f3351g;
        private String f3352h;
        private String f3353i;
        private WeakReference f3354j;
        private String f3355k;
        private int f3356l;
        private boolean f3357m;
        private Bundle f3358n;
        private C1036a f3359o;

        public C1111a(Context appContext, C1113f loginFragment, String email, int position, boolean signup, Bundle onLoginBroadcastExtra) {
            this.f3346b = 0;
            this.f3347c = 0;
            this.f3359o = C1036a.CONNECTION_ERROR;
            this.f3345a = appContext.getApplicationContext();
            this.f3354j = new WeakReference(loginFragment);
            this.f3355k = email;
            this.f3356l = position;
            this.f3357m = signup;
            this.f3358n = onLoginBroadcastExtra;
        }

        public void m4716a(C1032a type, int responseCode, String JsonBody) {
            this.f3346b++;
            if (type == C1032a.UA) {
                m4712a(responseCode, JsonBody);
            } else {
                m4714b(responseCode, JsonBody);
            }
            if (this.f3346b == 2 && this.f3347c == 2) {
                m4711a();
            } else if (this.f3346b == 2 && this.f3347c < 2) {
                m4715b(this.f3359o);
            }
        }

        private void m4712a(int responseCode, String JsonBody) {
            if (responseCode == -1) {
                C0970a.m4325b("Failed sending create UA request");
            } else if (responseCode == WalletConstants.ERROR_CODE_BUYER_ACCOUNT_ERROR || responseCode == WalletConstants.ERROR_CODE_UNSUPPORTED_API_VERSION) {
                this.f3359o = C1036a.VERIFICATION_ERROR;
            } else if (responseCode == 201 || responseCode == 200) {
                try {
                    JSONObject json = new JSONObject(JsonBody);
                    this.f3352h = json.getString("accountId");
                    this.f3353i = json.getString("hash");
                    this.f3347c++;
                } catch (Exception e) {
                    C0970a.m4325b("Error while trying to parse the UA LOGIN response");
                    this.f3359o = C1036a.DATA_ERROR;
                }
            }
        }

        private void m4714b(int responseCode, String JsonBody) {
            if (responseCode == -1) {
                C0970a.m4325b("Failed sending create UA request");
            } else if (responseCode == 401) {
                this.f3359o = C1036a.UNAUTHORIZED;
            } else if (responseCode == WalletConstants.ERROR_CODE_UNSUPPORTED_API_VERSION) {
                this.f3359o = C1036a.VERIFICATION_ERROR;
            } else if (responseCode == 200) {
                try {
                    JSONObject json = new JSONObject(JsonBody);
                    this.f3348d = json.getString("id");
                    this.f3349e = json.getString("token");
                    JSONObject device = json.getJSONArray("devices").getJSONObject(0);
                    this.f3351g = device.getString("token");
                    this.f3350f = device.getString("id");
                    this.f3347c++;
                } catch (Exception e) {
                    C0970a.m4325b("Error while trying to parse the ZEN LOGIN response");
                    this.f3359o = C1036a.DATA_ERROR;
                }
            }
        }

        private void m4711a() {
            C1050e.m4548d(this.f3345a, this.f3348d);
            C1050e.m4552f(this.f3345a, this.f3349e);
            C1050e.m4553g(this.f3345a, this.f3350f);
            C1050e.m4558i(this.f3345a, this.f3351g);
            C1050e.m4546c(this.f3345a, this.f3355k);
            C0979g.m4346a(this.f3345a, this.f3352h);
            C0979g.m4348b(this.f3345a, this.f3353i);
            C0979g.m4350c(this.f3345a, this.f3355k);
            m4713a(true, C1036a.SUCCESS);
            C1038d.m4518a(this.f3345a, this.f3358n);
            GoogleAnalyticsWrapper.trackEvent(this.f3345a, "Login_screen", this.f3356l == 0 ? "MyAccout_create_button" : "MyAccout_login_button", "Success", 0);
            C0974c.m4333a(this.f3345a);
            C1038d.m4521a(this.f3345a, true);
        }

        private void m4715b(C1036a type) {
            m4713a(false, type);
            GoogleAnalyticsWrapper.trackEvent(this.f3345a, "Login_screen", this.f3356l == 0 ? "MyAccout_create_button" : "MyAccout_login_button", "Error", 0);
        }

        private void m4713a(boolean success, C1036a type) {
            C1113f loginFragment = (C1113f) this.f3354j.get();
            if (loginFragment != null) {
                C1112b waitDialog = loginFragment.m4736a();
                if (success) {
                    waitDialog.m4718a();
                    return;
                }
                waitDialog.dismissAllowingStateLoss();
                loginFragment.m4724a(type, this.f3345a, this.f3357m);
            }
        }

        public void m4717a(C1036a type) {
        }
    }

    /* renamed from: com.avg.ui.general.components.f.b */
    private static class C1112b extends C1100b {
        public void m4718a() {
            dismissAllowingStateLoss();
            Activity activity = getActivity();
            if (activity instanceof C1096c) {
                ((C1096c) activity).m4674m();
            }
        }
    }

    public C1113f() {
        this.f3366i = false;
        this.f3367j = null;
        this.f3370m = new C11051(this);
    }

    public static C1113f m4721a(boolean canSkip, String[] bullets, boolean fromOnboarding) {
        return C1113f.m4722a(canSkip, bullets, fromOnboarding, null);
    }

    public static C1113f m4722a(boolean canSkip, String[] bullets, boolean fromOnboarding, Bundle loginBroadcastExtra) {
        C1113f fragment = new C1113f();
        Bundle bundle = new Bundle();
        bundle.putBoolean("canSkip", canSkip);
        bundle.putBoolean("fromOnboarding", fromOnboarding);
        if (bullets != null) {
            bundle.putStringArray("featuresList", bullets);
        }
        if (loginBroadcastExtra != null) {
            bundle.putBundle("login_broadcast_extra", loginBroadcastExtra);
        }
        fragment.setArguments(bundle);
        return fragment;
    }

    public C1112b m4736a() {
        return this.f3369l;
    }

    private void m4724a(C1036a type, Context context, boolean signup) {
        if (type == C1036a.VERIFICATION_ERROR) {
            m4727a(context.getString(C1085i.error_valid_mail), this.f3364g);
        } else if (type == C1036a.UNAUTHORIZED) {
            m4727a(context.getString(signup ? C1085i.error_mail_in_use : C1085i.wrong_account_credentials), this.f3364g);
        } else if (type == C1036a.CONNECTION_ERROR) {
            Toast.makeText(context.getApplicationContext(), context.getString(C1085i.ias_alert_dialog_message), 1).show();
        } else if (type == C1036a.DATA_ERROR) {
            m4727a(context.getString(C1085i.error_valid_password), this.f3365h);
        }
    }

    private void m4728a(String[] bullets) {
        TextView textViewTitle = (TextView) this.f3360a.findViewById(C1082f.textViewTitle);
        TextView textViewFeature1 = (TextView) this.f3360a.findViewById(C1082f.textViewFeature1);
        TextView textViewFeature2 = (TextView) this.f3360a.findViewById(C1082f.textViewFeature2);
        if (bullets == null || bullets.length == 0) {
            textViewTitle.setVisibility(8);
            textViewFeature1.setVisibility(8);
            textViewFeature2.setVisibility(8);
        } else if (bullets.length == 1) {
            textViewTitle.setText(Html.fromHtml(bullets[0]));
            textViewTitle.setVisibility(0);
            textViewFeature1.setVisibility(8);
            textViewFeature2.setVisibility(8);
        } else if (bullets.length == 2) {
            textViewTitle.setText(Html.fromHtml(bullets[0]));
            textViewFeature1.setText(Html.fromHtml(bullets[1]));
            textViewTitle.setVisibility(0);
            textViewFeature1.setVisibility(0);
            textViewFeature2.setVisibility(8);
        } else if (bullets.length >= 3) {
            textViewTitle.setText(Html.fromHtml(bullets[0]));
            textViewFeature1.setText(Html.fromHtml(bullets[1]));
            textViewFeature2.setText(Html.fromHtml(bullets[2]));
            textViewTitle.setVisibility(0);
            textViewFeature1.setVisibility(0);
            textViewFeature2.setVisibility(0);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            this.f3366i = bundle.getBoolean("fromOnboarding", false);
            this.f3367j = bundle.getBundle("login_broadcast_extra");
        }
        if (this.f3366i) {
            GoogleAnalyticsWrapper.trackEvent(getActivity(), "Login_screen", "MyAccout", "Viewed", 0);
        }
    }

    private String m4732d() {
        String accountName = "";
        if (getActivity().checkCallingOrSelfPermission("android.permission.GET_ACCOUNTS") != 0) {
            return accountName;
        }
        AccountManager manager = AccountManager.get(getActivity());
        if (manager == null) {
            return accountName;
        }
        Account[] accounts = manager.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
        if (accounts.length > 0) {
            return accounts[0].name;
        }
        return accountName;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.f3360a = inflater.inflate(C1084h.my_account_login_fragment, null);
        this.f3362e = (Button) this.f3360a.findViewById(C1082f.buttonLogin);
        this.f3363f = (TextView) this.f3360a.findViewById(C1082f.textViewForgotPassword);
        this.f3361d = (SimpleTabWidget) this.f3360a.findViewById(C1082f.simpleTabWidget);
        this.f3364g = (EditText) this.f3360a.findViewById(C1082f.editTextEmail);
        this.f3365h = (EditText) this.f3360a.findViewById(C1082f.editTextPassword);
        TextView skipText = (TextView) this.f3360a.findViewById(C1082f.skip_text);
        CheckBox checkBoxShowPwd = (CheckBox) this.f3360a.findViewById(C1082f.checkBoxShowPwd);
        this.f3364g.setText(m4732d());
        if (!(savedInstanceState == null || !savedInstanceState.containsKey("userMail") || savedInstanceState.getString("userMail").equals(""))) {
            this.f3364g.setText(savedInstanceState.getString("userMail"));
        }
        this.f3365h.setTypeface(Typeface.DEFAULT);
        if (!(savedInstanceState == null || !savedInstanceState.containsKey("userpwd") || savedInstanceState.getString("userpwd").equals(""))) {
            this.f3365h.setText(savedInstanceState.getString("userpwd"));
        }
        Bundle bundle = getArguments();
        boolean canSkip = false;
        String[] bullets = null;
        if (bundle != null) {
            canSkip = bundle.getBoolean("canSkip", false);
            bullets = bundle.getStringArray("featuresList");
        }
        m4728a(bullets);
        if (canSkip) {
            skipText.setVisibility(0);
            skipText.setOnClickListener(new C11062(this));
        } else {
            skipText.setVisibility(8);
        }
        this.f3363f.setMovementMethod(LinkMovementMethod.getInstance());
        this.f3363f.setText(Html.fromHtml("<a href='https://myaccount.avg.com/ww-en/my-account-lostpassword'>" + getString(C1085i.forgot_password) + "</a>"));
        this.f3362e.setOnClickListener(this.f3370m);
        this.f3361d.setTabsTitles(getString(C1085i.zen_create_account), getString(C1085i.zen_log_in));
        m4723a(0);
        this.f3361d.setOnTabChangedListener(new C11083(this));
        checkBoxShowPwd.setOnCheckedChangeListener(new C11094(this));
        return this.f3360a;
    }

    private void m4723a(int position) {
        this.f3362e.setText(position == 0 ? C1085i.zen_create_account : C1085i.zen_log_in);
        this.f3363f.setVisibility(4);
        this.f3363f.post(new C11105(this, position));
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String str = "userMail";
        String obj = (this.f3364g == null || this.f3364g.getText() == null) ? "" : this.f3364g.getText().toString();
        outState.putString(str, obj);
        str = "userpwd";
        obj = (this.f3365h == null || this.f3365h.getText() == null) ? "" : this.f3365h.getText().toString();
        outState.putString(str, obj);
        outState.putBundle("login_broadcast_extra", this.f3367j);
    }

    private void m4727a(String text, View v) {
        if (v != this.f3364g) {
            this.f3364g.setBackgroundResource(C1081e.edit_text_holo_dark);
        } else if (v != this.f3365h) {
            this.f3365h.setBackgroundResource(C1081e.edit_text_holo_dark);
        }
        this.f3368k = new C1157d(getActivity());
        this.f3368k.m4855a((CharSequence) text);
        v.setBackgroundResource(C1081e.edit_text_red);
        this.f3368k.m4854a(v, 3000);
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.f3368k != null && this.f3368k.isShowing()) {
            this.f3368k.dismiss();
            this.f3368k = null;
        }
    }

    public void onDetach() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService("input_method");
        if (imm != null) {
            imm.hideSoftInputFromWindow(this.f3364g.getWindowToken(), 2);
        }
        super.onDetach();
    }

    public void m4737a(boolean isHardwareBack) {
        super.m3358a(isHardwareBack);
    }

    public String m4738b() {
        return "LoginFragment";
    }

    public int m4739c() {
        return C1085i.zen_log_in;
    }
}
