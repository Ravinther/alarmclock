package com.avg.toolkit.zen.pojo;

import java.io.Serializable;

public class RemoteAction implements Serializable {
    private static final long serialVersionUID = -5559475405791895966L;
    public String contentId;
    public String id;
    public BaseActionParams params;

    public RemoteAction(String id, String contentId) {
        this(id, contentId, null);
    }

    public RemoteAction(RemoteAction action) {
        this(action.id, action.contentId);
    }

    public RemoteAction(String id, String contentId, BaseActionParams params) {
        this.id = id;
        this.contentId = contentId;
        if (params == null) {
            params = new BaseActionParams();
        }
        this.params = params;
    }
}
