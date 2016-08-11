package com.p044c.p045a;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.ContactsContract.Contacts;
import com.mopub.mobileads.C2625R;
import com.mopub.mobileads.util.Base64;
import com.p044c.p045a.C1295r.C1292d;
import java.io.InputStream;

/* renamed from: com.c.a.f */
class C1269f extends C1260c {
    private static final UriMatcher f3836p;
    final Context f3837o;

    @TargetApi(14)
    /* renamed from: com.c.a.f.a */
    private static class C1268a {
        static InputStream m5436a(ContentResolver contentResolver, Uri uri) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        f3836p = new UriMatcher(-1);
        f3836p.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f3836p.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f3836p.addURI("com.android.contacts", "contacts/#/photo", 2);
        f3836p.addURI("com.android.contacts", "contacts/#", 3);
        f3836p.addURI("com.android.contacts", "display_photo/#", 4);
    }

    C1269f(Context context, C1295r picasso, C1276i dispatcher, C1266d cache, C1307x stats, C1252a action) {
        super(picasso, dispatcher, cache, stats, action);
        this.f3837o = context;
    }

    Bitmap m5439a(C1300u data) {
        InputStream inputStream = null;
        try {
            inputStream = m5438n();
            Bitmap a = m5437a(inputStream, data);
            return a;
        } finally {
            ab.m5387a(inputStream);
        }
    }

    C1292d m5440a() {
        return C1292d.DISK;
    }

    private InputStream m5438n() {
        ContentResolver contentResolver = this.f3837o.getContentResolver();
        Uri uri = m5419i().f3944c;
        switch (f3836p.match(uri)) {
            case Base64.NO_PADDING /*1*/:
                uri = Contacts.lookupContact(contentResolver, uri);
                if (uri == null) {
                    return null;
                }
                break;
            case Base64.NO_WRAP /*2*/:
            case Base64.CRLF /*4*/:
                return contentResolver.openInputStream(uri);
            case C2625R.styleable.WalletFragmentStyle_buyButtonAppearance /*3*/:
                break;
            default:
                throw new IllegalStateException("Invalid uri: " + uri);
        }
        if (VERSION.SDK_INT < 14) {
            return Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return C1268a.m5436a(contentResolver, uri);
    }

    private Bitmap m5437a(InputStream stream, C1300u data) {
        if (stream == null) {
            return null;
        }
        Options options = C1260c.m5405c(data);
        if (C1260c.m5403a(options)) {
            InputStream is = m5438n();
            try {
                BitmapFactory.decodeStream(is, null, options);
                C1260c.m5402a(data.f3947f, data.f3948g, options);
            } finally {
                ab.m5387a(is);
            }
        }
        return BitmapFactory.decodeStream(stream, null, options);
    }
}
