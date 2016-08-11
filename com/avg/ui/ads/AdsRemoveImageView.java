package com.avg.ui.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.avg.toolkit.ads.AdsManager.C0792a;
import com.avg.ui.general.C1091c.C1081e;
import java.util.Locale;

public class AdsRemoveImageView extends ImageView implements C0792a {
    public AdsRemoveImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        m4580a();
    }

    public AdsRemoveImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m4580a();
    }

    public AdsRemoveImageView(Context context) {
        super(context);
        m4580a();
    }

    private void m4580a() {
        if (Locale.getDefault().getLanguage().equals("en")) {
            setImageResource(C1081e.ads_remove_english);
        } else {
            setImageResource(C1081e.ads_remove_other_languages);
        }
        setVisibility(8);
    }

    public void m4581a(boolean adDisplayed) {
        setVisibility(adDisplayed ? 0 : 8);
    }
}
