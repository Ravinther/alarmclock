package android.support.v4.p010d;

import android.util.Log;
import com.google.android.gms.cast.Cast;
import java.io.Writer;

/* renamed from: android.support.v4.d.d */
public class C0141d extends Writer {
    private final String f351a;
    private StringBuilder f352b;

    public C0141d(String tag) {
        this.f352b = new StringBuilder(Cast.MAX_NAMESPACE_LENGTH);
        this.f351a = tag;
    }

    public void close() {
        m549a();
    }

    public void flush() {
        m549a();
    }

    public void write(char[] buf, int offset, int count) {
        for (int i = 0; i < count; i++) {
            char c = buf[offset + i];
            if (c == '\n') {
                m549a();
            } else {
                this.f352b.append(c);
            }
        }
    }

    private void m549a() {
        if (this.f352b.length() > 0) {
            Log.d(this.f351a, this.f352b.toString());
            this.f352b.delete(0, this.f352b.length());
        }
    }
}
