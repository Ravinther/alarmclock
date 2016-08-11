package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gt;

public class SearchableField {
    public static final SearchableOrderedMetadataField GE;
    public static final SearchableMetadataField IS_PINNED;
    public static final SearchableOrderedMetadataField LAST_VIEWED_BY_ME;
    public static final SearchableMetadataField MIME_TYPE;
    public static final SearchableOrderedMetadataField MODIFIED_DATE;
    public static final SearchableCollectionMetadataField PARENTS;
    public static final SearchableMetadataField STARRED;
    public static final SearchableMetadataField TITLE;
    public static final SearchableMetadataField TRASHED;

    static {
        TITLE = gs.Go;
        MIME_TYPE = gs.Gh;
        TRASHED = gs.Gp;
        PARENTS = gs.Gk;
        GE = gt.Gw;
        STARRED = gs.Gm;
        MODIFIED_DATE = gt.Gu;
        LAST_VIEWED_BY_ME = gt.Gt;
        IS_PINNED = gs.Gc;
    }
}
