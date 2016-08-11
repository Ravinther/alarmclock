package com.avg.toolkit.p034b;

import com.avg.toolkit.ITKSvc;
import com.mopub.mobileads.factories.HttpClientFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
import p000a.p001a.p002a.p003a.p004a.C0000a;

/* renamed from: com.avg.toolkit.b.i */
class C0960i {
    static void m4304a(XmlSerializer serializer, Object object) {
        if ((object instanceof Integer) || (object instanceof Short) || (object instanceof Byte)) {
            serializer.startTag(null, "i4").text(object.toString()).endTag(null, "i4");
        } else if (object instanceof Long) {
            serializer.startTag(null, "i8").text(object.toString()).endTag(null, "i8");
        } else if ((object instanceof Double) || (object instanceof Float)) {
            serializer.startTag(null, "double").text(object.toString()).endTag(null, "double");
        } else if (object instanceof Boolean) {
            serializer.startTag(null, "boolean").text(((Boolean) object).booleanValue() ? "1" : ITKSvc.CODEREVISION).endTag(null, "boolean");
        } else if (object instanceof String) {
            serializer.startTag(null, "string").text(object.toString()).endTag(null, "string");
        } else if ((object instanceof Date) || (object instanceof Calendar)) {
            serializer.startTag(null, "dateTime.iso8601").text(new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss", Locale.US).format(object)).endTag(null, "dateTime.iso8601");
        } else if (object instanceof byte[]) {
            serializer.startTag(null, "base64").text(new String(C0000a.m8b((byte[]) object))).endTag(null, "base64");
        } else if (object instanceof List) {
            serializer.startTag(null, "array").startTag(null, "data");
            for (Object o : (List) object) {
                serializer.startTag(null, "value");
                C0960i.m4304a(serializer, o);
                serializer.endTag(null, "value");
            }
            serializer.endTag(null, "data").endTag(null, "array");
        } else if (object instanceof Object[]) {
            serializer.startTag(null, "array").startTag(null, "data");
            Object[] objects = (Object[]) object;
            for (Object o2 : objects) {
                serializer.startTag(null, "value");
                C0960i.m4304a(serializer, o2);
                serializer.endTag(null, "value");
            }
            serializer.endTag(null, "data").endTag(null, "array");
        } else if (object instanceof Map) {
            serializer.startTag(null, "struct");
            for (Entry entry : ((Map) object).entrySet()) {
                String key = (String) entry.getKey();
                Object value = entry.getValue();
                serializer.startTag(null, "member");
                serializer.startTag(null, "name").text(key).endTag(null, "name");
                serializer.startTag(null, "value");
                C0960i.m4304a(serializer, value);
                serializer.endTag(null, "value");
                serializer.endTag(null, "member");
            }
            serializer.endTag(null, "struct");
        } else {
            throw new IOException("Cannot serialize " + object);
        }
    }

    static Object m4303a(XmlPullParser parser) {
        Object obj;
        parser.require(2, null, "value");
        parser.nextTag();
        String typeNodeName = parser.getName();
        if (!typeNodeName.equals("int")) {
            if (!typeNodeName.equals("i4")) {
                if (typeNodeName.equals("i8")) {
                    obj = Long.valueOf(Long.parseLong(parser.nextText()));
                } else {
                    if (typeNodeName.equals("double")) {
                        obj = Double.valueOf(Double.parseDouble(parser.nextText()));
                    } else {
                        if (typeNodeName.equals("boolean")) {
                            obj = parser.nextText().equals("1") ? Boolean.TRUE : Boolean.FALSE;
                        } else {
                            if (typeNodeName.equals("string")) {
                                obj = parser.nextText();
                            } else {
                                if (typeNodeName.equals("dateTime.iso8601")) {
                                    String value = parser.nextText();
                                    try {
                                        obj = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss", Locale.US).parseObject(value);
                                    } catch (ParseException e) {
                                        throw new IOException("Cannot deserialize dateTime " + value);
                                    }
                                }
                                if (typeNodeName.equals("base64")) {
                                    BufferedReader reader = new BufferedReader(new StringReader(parser.nextText()), HttpClientFactory.SOCKET_SIZE);
                                    StringBuffer sb = new StringBuffer();
                                    while (true) {
                                        String line = reader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        sb.append(line);
                                    }
                                    obj = C0000a.m7b(sb.toString());
                                } else {
                                    if (typeNodeName.equals("array")) {
                                        parser.nextTag();
                                        parser.require(2, null, "data");
                                        parser.nextTag();
                                        List list = new ArrayList();
                                        while (parser.getName().equals("value")) {
                                            list.add(C0960i.m4303a(parser));
                                            parser.nextTag();
                                        }
                                        parser.require(3, null, "data");
                                        parser.nextTag();
                                        parser.require(3, null, "array");
                                        obj = list.toArray();
                                    } else {
                                        if (typeNodeName.equals("struct")) {
                                            parser.nextTag();
                                            Map map = new HashMap();
                                            while (parser.getName().equals("member")) {
                                                String memberName = null;
                                                Object obj2 = null;
                                                while (true) {
                                                    parser.nextTag();
                                                    String name = parser.getName();
                                                    if (!name.equals("name")) {
                                                        if (!name.equals("value")) {
                                                            break;
                                                        }
                                                        obj2 = C0960i.m4303a(parser);
                                                    } else {
                                                        memberName = parser.nextText();
                                                    }
                                                }
                                                if (!(memberName == null || obj2 == null)) {
                                                    map.put(memberName, obj2);
                                                }
                                                parser.require(3, null, "member");
                                                parser.nextTag();
                                            }
                                            parser.require(3, null, "struct");
                                            Map obj3 = map;
                                        } else {
                                            throw new IOException("Cannot deserialize " + parser.getName());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                parser.nextTag();
                parser.require(3, null, "value");
                return obj;
            }
        }
        obj = Integer.valueOf(Integer.parseInt(parser.nextText()));
        parser.nextTag();
        parser.require(3, null, "value");
        return obj;
    }
}
