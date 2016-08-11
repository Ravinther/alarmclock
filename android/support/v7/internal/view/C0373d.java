package android.support.v7.internal.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.p007b.p008a.C0127a;
import android.support.v4.view.C0220d;
import android.support.v4.view.C0240j;
import android.support.v7.internal.view.menu.C0399h;
import android.support.v7.internal.view.menu.C0405i;
import android.support.v7.p014b.C0364a.C0363j;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.google.android.gms.games.request.GameRequest;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v7.internal.view.d */
public class C0373d extends MenuInflater {
    private static final Class[] f727a;
    private static final Class[] f728b;
    private final Object[] f729c;
    private final Object[] f730d;
    private Context f731e;
    private Object f732f;

    /* renamed from: android.support.v7.internal.view.d.a */
    private static class C0371a implements OnMenuItemClickListener {
        private static final Class[] f698a;
        private Object f699b;
        private Method f700c;

        static {
            f698a = new Class[]{MenuItem.class};
        }

        public C0371a(Object realOwner, String methodName) {
            this.f699b = realOwner;
            Class c = realOwner.getClass();
            try {
                this.f700c = c.getMethod(methodName, f698a);
            } catch (Exception e) {
                InflateException ex = new InflateException("Couldn't resolve menu item onClick handler " + methodName + " in class " + c.getName());
                ex.initCause(e);
                throw ex;
            }
        }

        public boolean onMenuItemClick(MenuItem item) {
            try {
                if (this.f700c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f700c.invoke(this.f699b, new Object[]{item})).booleanValue();
                }
                this.f700c.invoke(this.f699b, new Object[]{item});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: android.support.v7.internal.view.d.b */
    private class C0372b {
        final /* synthetic */ C0373d f701a;
        private Menu f702b;
        private int f703c;
        private int f704d;
        private int f705e;
        private int f706f;
        private boolean f707g;
        private boolean f708h;
        private boolean f709i;
        private int f710j;
        private int f711k;
        private CharSequence f712l;
        private CharSequence f713m;
        private int f714n;
        private char f715o;
        private char f716p;
        private int f717q;
        private boolean f718r;
        private boolean f719s;
        private boolean f720t;
        private int f721u;
        private int f722v;
        private String f723w;
        private String f724x;
        private String f725y;
        private C0220d f726z;

        public C0372b(C0373d c0373d, Menu menu) {
            this.f701a = c0373d;
            this.f702b = menu;
            m1727a();
        }

        public void m1727a() {
            this.f703c = 0;
            this.f704d = 0;
            this.f705e = 0;
            this.f706f = 0;
            this.f707g = true;
            this.f708h = true;
        }

        public void m1728a(AttributeSet attrs) {
            TypedArray a = this.f701a.f731e.obtainStyledAttributes(attrs, C0363j.MenuGroup);
            this.f703c = a.getResourceId(1, 0);
            this.f704d = a.getInt(3, 0);
            this.f705e = a.getInt(4, 0);
            this.f706f = a.getInt(5, 0);
            this.f707g = a.getBoolean(2, true);
            this.f708h = a.getBoolean(0, true);
            a.recycle();
        }

        public void m1730b(AttributeSet attrs) {
            TypedArray a = this.f701a.f731e.obtainStyledAttributes(attrs, C0363j.MenuItem);
            this.f710j = a.getResourceId(2, 0);
            this.f711k = (-65536 & a.getInt(5, this.f704d)) | (GameRequest.TYPE_ALL & a.getInt(6, this.f705e));
            this.f712l = a.getText(7);
            this.f713m = a.getText(8);
            this.f714n = a.getResourceId(0, 0);
            this.f715o = m1723a(a.getString(9));
            this.f716p = m1723a(a.getString(10));
            if (a.hasValue(11)) {
                int i;
                if (a.getBoolean(11, false)) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.f717q = i;
            } else {
                this.f717q = this.f706f;
            }
            this.f718r = a.getBoolean(3, false);
            this.f719s = a.getBoolean(4, this.f707g);
            this.f720t = a.getBoolean(1, this.f708h);
            this.f721u = a.getInt(13, -1);
            this.f725y = a.getString(12);
            this.f722v = a.getResourceId(14, 0);
            this.f723w = a.getString(15);
            this.f724x = a.getString(16);
            boolean hasActionProvider = this.f724x != null;
            if (hasActionProvider && this.f722v == 0 && this.f723w == null) {
                this.f726z = (C0220d) m1725a(this.f724x, C0373d.f728b, this.f701a.f730d);
            } else {
                if (hasActionProvider) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f726z = null;
            }
            a.recycle();
            this.f709i = false;
        }

        private char m1723a(String shortcutString) {
            if (shortcutString == null) {
                return '\u0000';
            }
            return shortcutString.charAt(0);
        }

        private void m1726a(MenuItem item) {
            item.setChecked(this.f718r).setVisible(this.f719s).setEnabled(this.f720t).setCheckable(this.f717q >= 1).setTitleCondensed(this.f713m).setIcon(this.f714n).setAlphabeticShortcut(this.f715o).setNumericShortcut(this.f716p);
            if (this.f721u >= 0) {
                C0240j.m1056a(item, this.f721u);
            }
            if (this.f725y != null) {
                if (this.f701a.f731e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                item.setOnMenuItemClickListener(new C0371a(this.f701a.f732f, this.f725y));
            }
            if (item instanceof C0399h) {
                C0399h impl = (C0399h) item;
            }
            if (this.f717q >= 2) {
                if (item instanceof C0399h) {
                    ((C0399h) item).m1931a(true);
                } else if (item instanceof C0405i) {
                    ((C0405i) item).m1957a(true);
                }
            }
            boolean actionViewSpecified = false;
            if (this.f723w != null) {
                C0240j.m1054a(item, (View) m1725a(this.f723w, C0373d.f727a, this.f701a.f729c));
                actionViewSpecified = true;
            }
            if (this.f722v > 0) {
                if (actionViewSpecified) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    C0240j.m1057b(item, this.f722v);
                }
            }
            if (this.f726z != null) {
                C0240j.m1052a(item, this.f726z);
            }
        }

        public void m1729b() {
            this.f709i = true;
            m1726a(this.f702b.add(this.f703c, this.f710j, this.f711k, this.f712l));
        }

        public SubMenu m1731c() {
            this.f709i = true;
            SubMenu subMenu = this.f702b.addSubMenu(this.f703c, this.f710j, this.f711k, this.f712l);
            m1726a(subMenu.getItem());
            return subMenu;
        }

        public boolean m1732d() {
            return this.f709i;
        }

        private Object m1725a(String className, Class[] constructorSignature, Object[] arguments) {
            try {
                return this.f701a.f731e.getClassLoader().loadClass(className).getConstructor(constructorSignature).newInstance(arguments);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + className, e);
                return null;
            }
        }
    }

    static {
        f727a = new Class[]{Context.class};
        f728b = f727a;
    }

    public C0373d(Context context) {
        super(context);
        this.f731e = context;
        this.f732f = context;
        this.f729c = new Object[]{context};
        this.f730d = this.f729c;
    }

    public void inflate(int menuRes, Menu menu) {
        if (menu instanceof C0127a) {
            XmlResourceParser parser = null;
            try {
                parser = this.f731e.getResources().getLayout(menuRes);
                m1734a(parser, Xml.asAttributeSet(parser), menu);
                if (parser != null) {
                    parser.close();
                }
            } catch (XmlPullParserException e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (parser != null) {
                    parser.close();
                }
            }
        } else {
            super.inflate(menuRes, menu);
        }
    }

    private void m1734a(XmlPullParser parser, AttributeSet attrs, Menu menu) {
        C0372b menuState = new C0372b(this, menu);
        int eventType = parser.getEventType();
        boolean lookingForEndOfUnknownTag = false;
        String unknownTagName = null;
        while (eventType != 2) {
            eventType = parser.next();
            if (eventType == 1) {
                break;
            }
        }
        String tagName = parser.getName();
        if (tagName.equals("menu")) {
            eventType = parser.next();
            boolean reachedEndOfMenu = false;
            while (!reachedEndOfMenu) {
                switch (eventType) {
                    case Base64.NO_PADDING /*1*/:
                        throw new RuntimeException("Unexpected end of document");
                    case Base64.NO_WRAP /*2*/:
                        if (!lookingForEndOfUnknownTag) {
                            tagName = parser.getName();
                            if (!tagName.equals("group")) {
                                if (!tagName.equals("item")) {
                                    if (!tagName.equals("menu")) {
                                        lookingForEndOfUnknownTag = true;
                                        unknownTagName = tagName;
                                        break;
                                    }
                                    m1734a(parser, attrs, menuState.m1731c());
                                    break;
                                }
                                menuState.m1730b(attrs);
                                break;
                            }
                            menuState.m1728a(attrs);
                            break;
                        }
                        break;
                    case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                        tagName = parser.getName();
                        if (!lookingForEndOfUnknownTag || !tagName.equals(unknownTagName)) {
                            if (!tagName.equals("group")) {
                                if (!tagName.equals("item")) {
                                    if (!tagName.equals("menu")) {
                                        break;
                                    }
                                    reachedEndOfMenu = true;
                                    break;
                                } else if (!menuState.m1732d()) {
                                    if (menuState.f726z != null && menuState.f726z.m997g()) {
                                        menuState.m1731c();
                                        break;
                                    } else {
                                        menuState.m1729b();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            menuState.m1727a();
                            break;
                        }
                        lookingForEndOfUnknownTag = false;
                        unknownTagName = null;
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
            return;
        }
        throw new RuntimeException("Expecting menu, got " + tagName);
    }
}
