package com.avg.toolkit.p049e;

import android.content.Context;
import android.util.Log;
import java.io.FileOutputStream;

/* renamed from: com.avg.toolkit.e.a */
public class C0970a {
    public static String f2923a;
    public static String f2924b;
    public static boolean f2925c;
    private static boolean f2926d;
    private static int f2927e;
    private static Context f2928f;

    static {
        f2923a = "avg";
        f2924b = "avg.log";
        f2925c = false;
        f2926d = false;
        f2927e = 0;
    }

    public static void m4323a(String str) {
    }

    public static void m4325b(String str) {
        if (f2925c) {
            str = C0970a.m4326c() + ": " + str;
            Log.e(f2923a, str);
            if (f2926d) {
                C0970a.m4327c(str);
            }
        }
    }

    public static void m4321a() {
        if (f2925c) {
            String str = C0970a.m4326c() + ": bad argument";
            Log.e(f2923a, str);
            if (f2926d) {
                C0970a.m4327c(str);
            }
        }
    }

    public static void m4322a(Exception e) {
        if (f2925c) {
            String msg;
            StringBuilder builder = new StringBuilder();
            if (e != null) {
                msg = e.getMessage();
                if (msg == null) {
                    msg = "null msg";
                }
                builder.append(msg);
                builder.append('\n');
                msg = Log.getStackTraceString(e);
                if (msg == null) {
                    msg = "null StackTrace";
                }
                builder.append(msg);
            }
            msg = C0970a.m4326c() + ": " + builder.toString();
            Log.e(f2923a, msg);
            if (f2926d) {
                C0970a.m4327c(msg);
            }
        }
    }

    private static void m4327c(String line) {
        if (line != null) {
            if (f2927e > 10485760) {
                C0970a.m4324b();
                f2927e = 0;
            }
            FileOutputStream output = null;
            try {
                if (f2928f != null) {
                    output = f2928f.openFileOutput(f2924b, 32768);
                    if (output != null) {
                        output.write((line + "\n").getBytes());
                    }
                }
                if (output != null) {
                    try {
                        output.close();
                    } catch (Exception e) {
                        C0970a.m4322a(e);
                    }
                }
            } catch (Exception e2) {
                C0970a.m4322a(e2);
                if (output != null) {
                    try {
                        output.close();
                    } catch (Exception e22) {
                        C0970a.m4322a(e22);
                    }
                }
            } catch (Throwable th) {
                if (output != null) {
                    try {
                        output.close();
                    } catch (Exception e222) {
                        C0970a.m4322a(e222);
                    }
                }
            }
            f2927e += line.length();
        }
    }

    private static void m4324b() {
        if (f2928f != null) {
            f2928f.deleteFile(f2924b);
        }
    }

    private static String m4326c() {
        try {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
            String className = stackTraceElement.getClassName();
            int index1 = className.lastIndexOf(46);
            if (index1 > -1) {
                int index2 = className.lastIndexOf(46, index1 - 1);
                if (index2 > -1) {
                    int index3 = className.lastIndexOf(46, index2 - 1);
                    if (index3 > -1) {
                        className = className.substring(index3 + 1);
                    }
                }
            }
            return className + "." + stackTraceElement.getMethodName();
        } catch (Exception e) {
            return "unknown";
        }
    }
}
