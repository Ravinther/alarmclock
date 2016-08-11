package com.mopub.mobileads.util.vast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VastVideoConfiguration implements Serializable {
    private static final long serialVersionUID = 0;
    private String mClickThroughUrl;
    private ArrayList mClickTrackers;
    private ArrayList mCompleteTrackers;
    private String mDiskMediaFileUrl;
    private ArrayList mFirstQuartileTrackers;
    private ArrayList mImpressionTrackers;
    private ArrayList mMidpointTrackers;
    private String mNetworkMediaFileUrl;
    private ArrayList mStartTrackers;
    private ArrayList mThirdQuartileTrackers;
    private VastCompanionAd mVastCompanionAd;

    public VastVideoConfiguration() {
        this.mImpressionTrackers = new ArrayList();
        this.mStartTrackers = new ArrayList();
        this.mFirstQuartileTrackers = new ArrayList();
        this.mMidpointTrackers = new ArrayList();
        this.mThirdQuartileTrackers = new ArrayList();
        this.mCompleteTrackers = new ArrayList();
        this.mClickTrackers = new ArrayList();
    }

    public void addImpressionTrackers(List impressionTrackers) {
        this.mImpressionTrackers.addAll(impressionTrackers);
    }

    public void addStartTrackers(List startTrackers) {
        this.mStartTrackers.addAll(startTrackers);
    }

    public void addFirstQuartileTrackers(List firstQuartileTrackers) {
        this.mFirstQuartileTrackers.addAll(firstQuartileTrackers);
    }

    public void addMidpointTrackers(List midpointTrackers) {
        this.mMidpointTrackers.addAll(midpointTrackers);
    }

    public void addThirdQuartileTrackers(List thirdQuartileTrackers) {
        this.mThirdQuartileTrackers.addAll(thirdQuartileTrackers);
    }

    public void addCompleteTrackers(List completeTrackers) {
        this.mCompleteTrackers.addAll(completeTrackers);
    }

    public void addClickTrackers(List clickTrackers) {
        this.mClickTrackers.addAll(clickTrackers);
    }

    public void setClickThroughUrl(String clickThroughUrl) {
        this.mClickThroughUrl = clickThroughUrl;
    }

    public void setNetworkMediaFileUrl(String networkMediaFileUrl) {
        this.mNetworkMediaFileUrl = networkMediaFileUrl;
    }

    public void setDiskMediaFileUrl(String diskMediaFileUrl) {
        this.mDiskMediaFileUrl = diskMediaFileUrl;
    }

    public void setVastCompanionAd(VastCompanionAd vastCompanionAd) {
        this.mVastCompanionAd = vastCompanionAd;
    }

    public List getImpressionTrackers() {
        return this.mImpressionTrackers;
    }

    public List getStartTrackers() {
        return this.mStartTrackers;
    }

    public List getFirstQuartileTrackers() {
        return this.mFirstQuartileTrackers;
    }

    public List getMidpointTrackers() {
        return this.mMidpointTrackers;
    }

    public List getThirdQuartileTrackers() {
        return this.mThirdQuartileTrackers;
    }

    public List getCompleteTrackers() {
        return this.mCompleteTrackers;
    }

    public List getClickTrackers() {
        return this.mClickTrackers;
    }

    public String getClickThroughUrl() {
        return this.mClickThroughUrl;
    }

    public String getNetworkMediaFileUrl() {
        return this.mNetworkMediaFileUrl;
    }

    public String getDiskMediaFileUrl() {
        return this.mDiskMediaFileUrl;
    }

    public VastCompanionAd getVastCompanionAd() {
        return this.mVastCompanionAd;
    }
}
