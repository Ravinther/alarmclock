package android.support.v4.p010d;

import java.io.PrintWriter;

/* renamed from: android.support.v4.d.j */
public class C0150j {
    private static final Object f375a;
    private static char[] f376b;

    static {
        f375a = new Object();
        f376b = new char[24];
    }

    private static int m572a(int amt, int suffix, boolean always, int zeropad) {
        if (amt > 99 || (always && zeropad >= 3)) {
            return suffix + 3;
        }
        if (amt > 9 || (always && zeropad >= 2)) {
            return suffix + 2;
        }
        if (always || amt > 0) {
            return suffix + 1;
        }
        return 0;
    }

    private static int m574a(char[] formatStr, int amt, char suffix, int pos, boolean always, int zeropad) {
        if (!always && amt <= 0) {
            return pos;
        }
        int startPos = pos;
        if ((always && zeropad >= 3) || amt > 99) {
            int dig = amt / 100;
            formatStr[pos] = (char) (dig + 48);
            pos++;
            amt -= dig * 100;
        }
        if ((always && zeropad >= 2) || amt > 9 || startPos != pos) {
            dig = amt / 10;
            formatStr[pos] = (char) (dig + 48);
            pos++;
            amt -= dig * 10;
        }
        formatStr[pos] = (char) (amt + 48);
        pos++;
        formatStr[pos] = suffix;
        return pos + 1;
    }

    private static int m573a(long duration, int fieldLen) {
        if (f376b.length < fieldLen) {
            f376b = new char[fieldLen];
        }
        char[] formatStr = f376b;
        if (duration == 0) {
            fieldLen--;
            while (0 < fieldLen) {
                formatStr[0] = ' ';
            }
            formatStr[0] = '0';
            return 1;
        }
        char prefix;
        if (duration > 0) {
            prefix = '+';
        } else {
            prefix = '-';
            duration = -duration;
        }
        int millis = (int) (duration % 1000);
        int seconds = (int) Math.floor((double) (duration / 1000));
        int days = 0;
        int hours = 0;
        int minutes = 0;
        if (seconds > 86400) {
            days = seconds / 86400;
            seconds -= 86400 * days;
        }
        if (seconds > 3600) {
            hours = seconds / 3600;
            seconds -= hours * 3600;
        }
        if (seconds > 60) {
            minutes = seconds / 60;
            seconds -= minutes * 60;
        }
        int pos = 0;
        if (fieldLen != 0) {
            int myLen = C0150j.m572a(days, 1, false, 0);
            myLen += C0150j.m572a(hours, 1, myLen > 0, 2);
            myLen += C0150j.m572a(minutes, 1, myLen > 0, 2);
            myLen += C0150j.m572a(seconds, 1, myLen > 0, 2);
            for (myLen += C0150j.m572a(millis, 2, true, myLen > 0 ? 3 : 0) + 1; myLen < fieldLen; myLen++) {
                formatStr[pos] = ' ';
                pos++;
            }
        }
        formatStr[pos] = prefix;
        pos++;
        int start = pos;
        boolean zeropad = fieldLen != 0;
        pos = C0150j.m574a(formatStr, days, 'd', pos, false, 0);
        pos = C0150j.m574a(formatStr, hours, 'h', pos, pos != start, zeropad ? 2 : 0);
        pos = C0150j.m574a(formatStr, minutes, 'm', pos, pos != start, zeropad ? 2 : 0);
        pos = C0150j.m574a(formatStr, seconds, 's', pos, pos != start, zeropad ? 2 : 0);
        int i = (!zeropad || pos == start) ? 0 : 3;
        pos = C0150j.m574a(formatStr, millis, 'm', pos, true, i);
        formatStr[pos] = 's';
        return pos + 1;
    }

    public static void m577a(long duration, PrintWriter pw, int fieldLen) {
        synchronized (f375a) {
            pw.print(new String(f376b, 0, C0150j.m573a(duration, fieldLen)));
        }
    }

    public static void m576a(long duration, PrintWriter pw) {
        C0150j.m577a(duration, pw, 0);
    }

    public static void m575a(long time, long now, PrintWriter pw) {
        if (time == 0) {
            pw.print("--");
        } else {
            C0150j.m577a(time - now, pw, 0);
        }
    }
}
