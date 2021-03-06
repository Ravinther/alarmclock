package com.mopub.common;

import com.mopub.common.util.ResponseHeader;
import com.mopub.common.util.Streams;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class DownloadResponse {
    private byte[] mBytes;
    private final long mContentLength;
    private final Header[] mHeaders;
    private final int mStatusCode;

    public DownloadResponse(HttpResponse httpResponse) {
        Throwable th;
        this.mBytes = new byte[0];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedInputStream inputStream = null;
        try {
            BufferedInputStream inputStream2 = new BufferedInputStream(httpResponse.getEntity().getContent());
            try {
                Streams.copyContent(inputStream2, outputStream);
                this.mBytes = outputStream.toByteArray();
                Streams.closeStream(inputStream2);
                Streams.closeStream(outputStream);
                this.mStatusCode = httpResponse.getStatusLine().getStatusCode();
                this.mContentLength = (long) this.mBytes.length;
                this.mHeaders = httpResponse.getAllHeaders();
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                Streams.closeStream(inputStream);
                Streams.closeStream(outputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Streams.closeStream(inputStream);
            Streams.closeStream(outputStream);
            throw th;
        }
    }

    public byte[] getByteArray() {
        return this.mBytes;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public long getContentLength() {
        return this.mContentLength;
    }

    public String getFirstHeader(ResponseHeader responseHeader) {
        for (Header header : this.mHeaders) {
            if (header.getName().equals(responseHeader.getKey())) {
                return header.getValue();
            }
        }
        return null;
    }
}
