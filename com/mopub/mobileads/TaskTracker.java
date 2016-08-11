package com.mopub.mobileads;

public class TaskTracker {
    private long mCurrentTaskId;
    private long mLastCompletedTaskId;

    public TaskTracker() {
        this.mCurrentTaskId = -1;
    }

    public long getCurrentTaskId() {
        return this.mCurrentTaskId;
    }

    public void newTaskStarted() {
        this.mCurrentTaskId++;
    }

    public void markTaskCompleted(long taskId) {
        if (taskId > this.mLastCompletedTaskId) {
            this.mLastCompletedTaskId = taskId;
        }
    }

    public boolean isMostCurrentTask(long taskId) {
        return taskId >= this.mLastCompletedTaskId;
    }
}
