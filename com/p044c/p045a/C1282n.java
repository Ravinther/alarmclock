package com.p044c.p045a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.c.a.n */
final class C1282n extends InputStream {
    private final InputStream f3872a;
    private long f3873b;
    private long f3874c;
    private long f3875d;
    private long f3876e;

    public C1282n(InputStream in) {
        this(in, 4096);
    }

    public C1282n(InputStream in, int size) {
        this.f3876e = -1;
        if (!in.markSupported()) {
            in = new BufferedInputStream(in, size);
        }
        this.f3872a = in;
    }

    public void mark(int readLimit) {
        this.f3876e = m5481a(readLimit);
    }

    public long m5481a(int readLimit) {
        long offsetLimit = this.f3873b + ((long) readLimit);
        if (this.f3875d < offsetLimit) {
            m5480b(offsetLimit);
        }
        return this.f3873b;
    }

    private void m5480b(long limit) {
        try {
            if (this.f3874c >= this.f3873b || this.f3873b > this.f3875d) {
                this.f3874c = this.f3873b;
                this.f3872a.mark((int) (limit - this.f3873b));
            } else {
                this.f3872a.reset();
                this.f3872a.mark((int) (limit - this.f3874c));
                m5479a(this.f3874c, this.f3873b);
            }
            this.f3875d = limit;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    public void reset() {
        m5482a(this.f3876e);
    }

    public void m5482a(long token) {
        if (this.f3873b > this.f3875d || token < this.f3874c) {
            throw new IOException("Cannot reset");
        }
        this.f3872a.reset();
        m5479a(this.f3874c, token);
        this.f3873b = token;
    }

    private void m5479a(long current, long target) {
        while (current < target) {
            long skipped = this.f3872a.skip(target - current);
            if (skipped == 0) {
                if (read() != -1) {
                    skipped = 1;
                } else {
                    return;
                }
            }
            current += skipped;
        }
    }

    public int read() {
        int result = this.f3872a.read();
        if (result != -1) {
            this.f3873b++;
        }
        return result;
    }

    public int read(byte[] buffer) {
        int count = this.f3872a.read(buffer);
        if (count != -1) {
            this.f3873b += (long) count;
        }
        return count;
    }

    public int read(byte[] buffer, int offset, int length) {
        int count = this.f3872a.read(buffer, offset, length);
        if (count != -1) {
            this.f3873b += (long) count;
        }
        return count;
    }

    public long skip(long byteCount) {
        long skipped = this.f3872a.skip(byteCount);
        this.f3873b += skipped;
        return skipped;
    }

    public int available() {
        return this.f3872a.available();
    }

    public void close() {
        this.f3872a.close();
    }

    public boolean markSupported() {
        return this.f3872a.markSupported();
    }
}
