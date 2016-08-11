package com.avg.toolkit.zen.pojo;

import java.io.Serializable;

public class RemoteFinishedAction implements Serializable {
    public RemoteAction[] results;

    public RemoteFinishedAction(RemoteAction... remoteActions) {
        this.results = remoteActions;
    }
}
