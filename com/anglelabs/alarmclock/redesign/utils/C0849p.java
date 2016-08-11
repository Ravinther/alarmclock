package com.anglelabs.alarmclock.redesign.utils;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.anglelabs.alarmclock.redesign.model.RedesignAlarm;
import com.anglelabs.alarmclock.redesign.p039d.C0694b;
import com.avg.toolkit.p049e.C0970a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Locale;

/* renamed from: com.anglelabs.alarmclock.redesign.utils.p */
public class C0849p {
    private static String f2438a;

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.p.a */
    private static class C0847a implements Runnable {
        private final long f2427a;
        private final Exception f2428b;
        private final String f2429c;
        private final C0848b f2430d;
        private final String f2431e;

        private C0847a(C0848b type, Exception ex, String message, String stackTrace) {
            this.f2427a = System.currentTimeMillis();
            this.f2428b = ex;
            this.f2429c = message;
            this.f2430d = type;
            this.f2431e = stackTrace;
        }

        public void run() {
            C0849p.m3983b(this.f2430d, this.f2428b, this.f2429c, this.f2427a, this.f2431e);
        }
    }

    /* renamed from: com.anglelabs.alarmclock.redesign.utils.p.b */
    public enum C0848b {
        DEBUG("DEBUG"),
        WARNING("WARNING"),
        ERROR("ERROR"),
        EXCEPTION("EXCEPTION");
        
        private final String f2437e;

        private C0848b(String tag) {
            this.f2437e = tag;
        }

        public String m3973a() {
            return this.f2437e;
        }
    }

    public static void m3975a(Context context) {
        StringBuilder builder = new StringBuilder();
        builder.append("Time: ").append(DateFormat.getDateInstance(3, Locale.US).format(Long.valueOf(System.currentTimeMillis())) + " " + DateFormat.getTimeInstance(2, Locale.US).format(Long.valueOf(System.currentTimeMillis()))).append("\n").append("Version: ").append("4.0.1").append("\n").append(" Free").append("").append("\n");
        C0849p.m3982b(C0848b.DEBUG, null, "APP INFO: " + builder.toString());
        Cursor cursor = C0694b.m3147b(context.getContentResolver());
        if (cursor != null) {
            try {
                C0849p.m3982b(C0848b.DEBUG, null, "----------DB SNAPSHOT: ------------");
                while (cursor.moveToNext()) {
                    C0849p.m3982b(C0848b.DEBUG, null, new RedesignAlarm(cursor).toString());
                }
            } finally {
                cursor.close();
            }
        }
    }

    public static void m3981b(Context context) {
        Exception e;
        File file;
        try {
            File logFile = new File(context.getFilesDir(), "log.txt");
            if (logFile != null) {
                try {
                    f2438a = logFile.getAbsolutePath();
                } catch (Exception e2) {
                    e = e2;
                    file = logFile;
                    C0970a.m4322a(e);
                }
            }
            file = logFile;
        } catch (Exception e3) {
            e = e3;
            C0970a.m4322a(e);
        }
    }

    private static String m3980b() {
        StringBuilder stackBuilder = new StringBuilder();
        StackTraceElement trace = Thread.currentThread().getStackTrace()[5];
        String methodName = trace.getMethodName();
        String[] classNameSplit = trace.getClassName().split("\\.");
        int lineNumber = trace.getLineNumber();
        if (methodName.trim().equals("<init>".trim())) {
            methodName = "Constructor";
        }
        stackBuilder.append(classNameSplit[classNameSplit.length - 1].replaceAll("\\$", "\\\\")).append(".").append(methodName).append("(").append(String.valueOf(lineNumber)).append(")");
        return stackBuilder.toString();
    }

    public static void m3976a(C0848b type, Exception ex, String message) {
        C0808f.m3825a(new C0847a(ex, message, C0849p.m3980b(), null));
    }

    public static File m3974a() {
        if (TextUtils.isEmpty(f2438a)) {
            return null;
        }
        return new File(f2438a);
    }

    private static void m3979a(String error) {
        C0970a.m4325b(error);
    }

    public static void m3982b(C0848b type, Exception ex, String message) {
        C0849p.m3983b(type, ex, message, System.currentTimeMillis(), C0849p.m3980b());
    }

    private static void m3983b(C0848b type, Exception ex, String message, long time, String stackTrace) {
        Exception e;
        boolean maxSizeReached;
        Throwable th;
        PrintWriter out = null;
        StringBuilder logBuilder = new StringBuilder();
        File logFile = null;
        if (TextUtils.isEmpty(f2438a)) {
            C0849p.m3979a("Log not initialize");
            return;
        }
        try {
            File logFile2 = new File(f2438a);
            if (logFile2 == null) {
                try {
                    C0849p.m3979a("Log file is null");
                } catch (Exception e2) {
                    e = e2;
                    logFile = logFile2;
                    try {
                        C0970a.m4322a(e);
                        if (out != null) {
                            out.close();
                        }
                        if (logFile == null) {
                        }
                        if (!maxSizeReached) {
                            C0849p.m3978a(logFile);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (out != null) {
                            out.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    logFile = logFile2;
                    if (out != null) {
                        out.close();
                    }
                    throw th;
                }
            }
            PrintWriter out2 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(logFile2, true)));
            try {
                logBuilder.append("Time: ").append(DateFormat.getDateInstance(3, Locale.US).format(Long.valueOf(time)) + " " + DateFormat.getTimeInstance(2, Locale.US).format(Long.valueOf(System.currentTimeMillis()))).append("\n");
                logBuilder.append("TYPE: ").append(type.m3973a()).append("\n");
                logBuilder.append("Stack Trace: ").append(stackTrace).append("\n");
                if (!TextUtils.isEmpty(message)) {
                    logBuilder.append("Message: ").append(message).append("\n");
                }
                out2.append(logBuilder.toString());
                if (ex != null) {
                    out2.append("Exception: \n");
                    ex.printStackTrace(out2);
                }
                out2.append("####################").append("\n");
                if (out2 != null) {
                    out2.close();
                    logFile = logFile2;
                    out = out2;
                } else {
                    logFile = logFile2;
                    out = out2;
                }
            } catch (Exception e3) {
                e = e3;
                logFile = logFile2;
                out = out2;
                C0970a.m4322a(e);
                if (out != null) {
                    out.close();
                }
                if (logFile == null) {
                }
                if (!maxSizeReached) {
                    C0849p.m3978a(logFile);
                }
            } catch (Throwable th4) {
                th = th4;
                logFile = logFile2;
                out = out2;
                if (out != null) {
                    out.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            C0970a.m4322a(e);
            if (out != null) {
                out.close();
            }
            if (logFile == null) {
            }
            if (!maxSizeReached) {
                C0849p.m3978a(logFile);
            }
        }
        maxSizeReached = logFile == null && logFile.exists() && logFile.length() > 50000;
        if (!maxSizeReached) {
            C0849p.m3978a(logFile);
        }
    }

    private static void m3978a(File logFile) {
        Exception e;
        Throwable th;
        File tempFile = new File(logFile.getAbsolutePath() + ".tmp");
        BufferedReader logReader = null;
        BufferedWriter logTmp = null;
        try {
            BufferedWriter logTmp2;
            BufferedReader logReader2 = new BufferedReader(new FileReader(logFile));
            try {
                logTmp2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile)));
            } catch (Exception e2) {
                e = e2;
                logReader = logReader2;
                try {
                    e.printStackTrace();
                    if (logReader != null) {
                        try {
                            logReader.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (logTmp == null) {
                        try {
                            logTmp.close();
                        } catch (IOException e4) {
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (logReader != null) {
                        try {
                            logReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (logTmp != null) {
                        try {
                            logTmp.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                logReader = logReader2;
                if (logReader != null) {
                    logReader.close();
                }
                if (logTmp != null) {
                    logTmp.close();
                }
                throw th;
            }
            try {
                logTmp2.write("Cleaning up log.\n");
                int linesSkipped = 0;
                while (true) {
                    String line = logReader2.readLine();
                    if (line == null) {
                        break;
                    } else if (linesSkipped > 100) {
                        logTmp2.append(line.trim()).append("\n");
                    } else {
                        linesSkipped++;
                    }
                }
                logTmp2.close();
                logTmp = null;
                if (!logFile.delete()) {
                    tempFile.delete();
                } else if (!tempFile.renameTo(logFile)) {
                    tempFile.delete();
                }
                if (logReader2 != null) {
                    try {
                        logReader2.close();
                    } catch (IOException e7) {
                    }
                }
                if (logTmp != null) {
                    try {
                        logTmp.close();
                        logReader = logReader2;
                        return;
                    } catch (IOException e8) {
                        logReader = logReader2;
                        return;
                    }
                }
            } catch (Exception e9) {
                e = e9;
                logTmp = logTmp2;
                logReader = logReader2;
                e.printStackTrace();
                if (logReader != null) {
                    logReader.close();
                }
                if (logTmp == null) {
                    logTmp.close();
                }
            } catch (Throwable th4) {
                th = th4;
                logTmp = logTmp2;
                logReader = logReader2;
                if (logReader != null) {
                    logReader.close();
                }
                if (logTmp != null) {
                    logTmp.close();
                }
                throw th;
            }
        } catch (Exception e10) {
            e = e10;
            e.printStackTrace();
            if (logReader != null) {
                logReader.close();
            }
            if (logTmp == null) {
                logTmp.close();
            }
        }
    }
}
