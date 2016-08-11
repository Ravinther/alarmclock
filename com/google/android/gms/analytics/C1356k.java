package com.google.android.gms.analytics;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.analytics.k */
abstract class C1356k {
    Context mContext;
    C1354a sy;

    /* renamed from: com.google.android.gms.analytics.k.a */
    public interface C1354a {
        void m5948a(String str, int i);

        void m5949a(String str, String str2);

        void m5950b(String str, String str2);

        void m5951c(String str, boolean z);

        C1357j cg();
    }

    public C1356k(Context context, C1354a c1354a) {
        this.mContext = context;
        this.sy = c1354a;
    }

    private C1357j m5956a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String toLowerCase = xmlResourceParser.getName().toLowerCase();
                    String trim;
                    if (toLowerCase.equals("screenname")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            this.sy.m5949a(toLowerCase, trim);
                        }
                    } else if (toLowerCase.equals("string")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || trim == null)) {
                            this.sy.m5950b(r0, trim);
                        }
                    } else if (toLowerCase.equals("bool")) {
                        r0 = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(r0) || TextUtils.isEmpty(trim))) {
                            try {
                                this.sy.m5951c(r0, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                aa.m5913w("Error parsing bool configuration value: " + trim);
                            }
                        }
                    } else if (toLowerCase.equals("integer")) {
                        toLowerCase = xmlResourceParser.getAttributeValue(null, "name");
                        trim = xmlResourceParser.nextText().trim();
                        if (!(TextUtils.isEmpty(toLowerCase) || TextUtils.isEmpty(trim))) {
                            try {
                                this.sy.m5948a(toLowerCase, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                aa.m5913w("Error parsing int configuration value: " + trim);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            aa.m5913w("Error parsing tracker configuration file: " + e3);
        } catch (IOException e4) {
            aa.m5913w("Error parsing tracker configuration file: " + e4);
        }
        return this.sy.cg();
    }

    public C1357j m5957p(int i) {
        try {
            return m5956a(this.mContext.getResources().getXml(i));
        } catch (NotFoundException e) {
            aa.m5916z("inflate() called with unknown resourceId: " + e);
            return null;
        }
    }
}
