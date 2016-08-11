package com.mopub.mobileads.util.vast;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

class VastXmlManager {
    private static final String CLICK_THROUGH = "ClickThrough";
    private static final String CLICK_TRACKER = "ClickTracking";
    private static final String COMPANION = "Companion";
    private static final String COMPLETE = "complete";
    private static final String EVENT = "event";
    private static final String FIRST_QUARTILE = "firstQuartile";
    private static final String HEIGHT = "height";
    private static final String IMPRESSION_TRACKER = "Impression";
    private static final String MEDIA_FILE = "MediaFile";
    private static final String MIDPOINT = "midpoint";
    private static final String MP_IMPRESSION_TRACKER = "MP_TRACKING_URL";
    private static final String ROOT_TAG = "MPMoVideoXMLDocRoot";
    private static final String ROOT_TAG_CLOSE = "</MPMoVideoXMLDocRoot>";
    private static final String ROOT_TAG_OPEN = "<MPMoVideoXMLDocRoot>";
    private static final String START = "start";
    private static final String THIRD_QUARTILE = "thirdQuartile";
    private static final String VAST_AD_TAG = "VASTAdTagURI";
    private static final String VIDEO_TRACKER = "Tracking";
    private static final String WIDTH = "width";
    private Document mVastDoc;

    class ImageCompanionAdXmlManager {
        private static final String COMPANION_CLICK_THROUGH = "CompanionClickThrough";
        private static final String COMPANION_STATIC_RESOURCE = "StaticResource";
        private static final String CREATIVE_TYPE = "creativeType";
        private static final String CREATIVE_VIEW = "creativeView";
        private static final String TRACKING_EVENTS = "TrackingEvents";
        private final Node mCompanionNode;

        ImageCompanionAdXmlManager(Node companionNode) {
            if (companionNode == null) {
                throw new IllegalArgumentException("Companion node cannot be null");
            }
            this.mCompanionNode = companionNode;
        }

        Integer getWidth() {
            return XmlUtils.getAttributeValueAsInt(this.mCompanionNode, VastXmlManager.WIDTH);
        }

        Integer getHeight() {
            return XmlUtils.getAttributeValueAsInt(this.mCompanionNode, VastXmlManager.HEIGHT);
        }

        String getType() {
            return XmlUtils.getAttributeValue(XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, COMPANION_STATIC_RESOURCE), CREATIVE_TYPE);
        }

        String getImageUrl() {
            return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, COMPANION_STATIC_RESOURCE));
        }

        String getClickThroughUrl() {
            return XmlUtils.getNodeValue(XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, COMPANION_CLICK_THROUGH));
        }

        List getClickTrackers() {
            List companionAdClickTrackers = new ArrayList();
            Node node = XmlUtils.getFirstMatchingChildNode(this.mCompanionNode, TRACKING_EVENTS);
            if (node != null) {
                for (Node trackerNode : XmlUtils.getMatchingChildNodes(node, VastXmlManager.VIDEO_TRACKER, VastXmlManager.EVENT, Arrays.asList(new String[]{CREATIVE_VIEW}))) {
                    if (trackerNode.getFirstChild() != null) {
                        companionAdClickTrackers.add(trackerNode.getFirstChild().getNodeValue().trim());
                    }
                }
            }
            return companionAdClickTrackers;
        }
    }

    class MediaXmlManager {
        private static final String DELIVERY = "delivery";
        private static final String VIDEO_TYPE = "type";
        private final Node mMediaNode;

        MediaXmlManager(Node mediaNode) {
            if (mediaNode == null) {
                throw new IllegalArgumentException("Media node cannot be null");
            }
            this.mMediaNode = mediaNode;
        }

        String getDelivery() {
            return XmlUtils.getAttributeValue(this.mMediaNode, DELIVERY);
        }

        Integer getWidth() {
            return XmlUtils.getAttributeValueAsInt(this.mMediaNode, VastXmlManager.WIDTH);
        }

        Integer getHeight() {
            return XmlUtils.getAttributeValueAsInt(this.mMediaNode, VastXmlManager.HEIGHT);
        }

        String getType() {
            return XmlUtils.getAttributeValue(this.mMediaNode, VIDEO_TYPE);
        }

        String getMediaUrl() {
            return XmlUtils.getNodeValue(this.mMediaNode);
        }
    }

    VastXmlManager() {
    }

    void parseVastXml(String xmlString) {
        String documentString = ROOT_TAG_OPEN + xmlString.replaceFirst("<\\?.*\\?>", "") + ROOT_TAG_CLOSE;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setCoalescing(true);
        this.mVastDoc = documentBuilderFactory.newDocumentBuilder().parse(new InputSource(new StringReader(documentString)));
    }

    String getVastAdTagURI() {
        List uriWrapper = XmlUtils.getStringDataAsList(this.mVastDoc, VAST_AD_TAG);
        return uriWrapper.size() > 0 ? (String) uriWrapper.get(0) : null;
    }

    List getImpressionTrackers() {
        List impressionTrackers = XmlUtils.getStringDataAsList(this.mVastDoc, IMPRESSION_TRACKER);
        impressionTrackers.addAll(XmlUtils.getStringDataAsList(this.mVastDoc, MP_IMPRESSION_TRACKER));
        return impressionTrackers;
    }

    List getVideoStartTrackers() {
        return getVideoTrackerByAttribute(START);
    }

    List getVideoFirstQuartileTrackers() {
        return getVideoTrackerByAttribute(FIRST_QUARTILE);
    }

    List getVideoMidpointTrackers() {
        return getVideoTrackerByAttribute(MIDPOINT);
    }

    List getVideoThirdQuartileTrackers() {
        return getVideoTrackerByAttribute(THIRD_QUARTILE);
    }

    List getVideoCompleteTrackers() {
        return getVideoTrackerByAttribute(COMPLETE);
    }

    String getClickThroughUrl() {
        List clickUrlWrapper = XmlUtils.getStringDataAsList(this.mVastDoc, CLICK_THROUGH);
        return clickUrlWrapper.size() > 0 ? (String) clickUrlWrapper.get(0) : null;
    }

    List getClickTrackers() {
        return XmlUtils.getStringDataAsList(this.mVastDoc, CLICK_TRACKER);
    }

    String getMediaFileUrl() {
        List urlWrapper = XmlUtils.getStringDataAsList(this.mVastDoc, MEDIA_FILE);
        return urlWrapper.size() > 0 ? (String) urlWrapper.get(0) : null;
    }

    List getMediaXmlManagers() {
        NodeList nodes = this.mVastDoc.getElementsByTagName(MEDIA_FILE);
        List mediaXmlManagers = new ArrayList(nodes.getLength());
        for (int i = 0; i < nodes.getLength(); i++) {
            mediaXmlManagers.add(new MediaXmlManager(nodes.item(i)));
        }
        return mediaXmlManagers;
    }

    List getCompanionAdXmlManagers() {
        NodeList nodes = this.mVastDoc.getElementsByTagName(COMPANION);
        List imageCompanionAdXmlManagers = new ArrayList(nodes.getLength());
        for (int i = 0; i < nodes.getLength(); i++) {
            imageCompanionAdXmlManagers.add(new ImageCompanionAdXmlManager(nodes.item(i)));
        }
        return imageCompanionAdXmlManagers;
    }

    private List getVideoTrackerByAttribute(String attributeValue) {
        return XmlUtils.getStringDataAsList(this.mVastDoc, VIDEO_TRACKER, EVENT, attributeValue);
    }
}
