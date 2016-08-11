package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gt;
import com.google.android.gms.internal.gv;
import java.util.Date;

public abstract class Metadata implements Freezable {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    protected abstract Object m6385a(MetadataField metadataField);

    public String getAlternateLink() {
        return (String) m6385a(gs.FS);
    }

    public int getContentAvailability() {
        Integer num = (Integer) m6385a(gv.Gy);
        return num == null ? 0 : num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) m6385a(gt.Gs);
    }

    public String getDescription() {
        return (String) m6385a(gs.FT);
    }

    public DriveId getDriveId() {
        return (DriveId) m6385a(gs.FR);
    }

    public String getEmbedLink() {
        return (String) m6385a(gs.FU);
    }

    public String getFileExtension() {
        return (String) m6385a(gs.FV);
    }

    public long getFileSize() {
        return ((Long) m6385a(gs.FW)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) m6385a(gt.Gt);
    }

    public String getMimeType() {
        return (String) m6385a(gs.Gh);
    }

    public Date getModifiedByMeDate() {
        return (Date) m6385a(gt.Gv);
    }

    public Date getModifiedDate() {
        return (Date) m6385a(gt.Gu);
    }

    public String getOriginalFilename() {
        return (String) m6385a(gs.Gi);
    }

    public long getQuotaBytesUsed() {
        return ((Long) m6385a(gs.Gl)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) m6385a(gt.Gw);
    }

    public String getTitle() {
        return (String) m6385a(gs.Go);
    }

    public String getWebContentLink() {
        return (String) m6385a(gs.Gq);
    }

    public String getWebViewLink() {
        return (String) m6385a(gs.Gr);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) m6385a(gs.Gb);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) m6385a(gs.FZ);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) m6385a(gv.Gz);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) m6385a(gs.Gc);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) m6385a(gs.Gd);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) m6385a(gs.Ge);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) m6385a(gs.Gm);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) m6385a(gs.Gp);
        return bool == null ? false : bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) m6385a(gs.Gg);
        return bool == null ? false : bool.booleanValue();
    }
}
