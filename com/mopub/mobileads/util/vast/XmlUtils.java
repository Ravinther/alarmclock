package com.mopub.mobileads.util.vast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class XmlUtils {
    private XmlUtils() {
    }

    static Node getFirstMatchingChildNode(Node node, String nodeName) {
        return getFirstMatchingChildNode(node, nodeName, null, null);
    }

    static Node getFirstMatchingChildNode(Node node, String nodeName, String attributeName, List attributeValues) {
        if (node == null || nodeName == null) {
            return null;
        }
        List nodes = getMatchingChildNodes(node, nodeName, attributeName, attributeValues);
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        return (Node) nodes.get(0);
    }

    static List getMatchingChildNodes(Node node, String nodeName, String attributeName, List attributeValues) {
        if (node == null || nodeName == null) {
            return null;
        }
        List nodes = new ArrayList();
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node childNode = nodeList.item(i);
            if (childNode.getNodeName().equals(nodeName) && nodeMatchesAttributeFilter(childNode, attributeName, attributeValues)) {
                nodes.add(childNode);
            }
        }
        return nodes;
    }

    static boolean nodeMatchesAttributeFilter(Node node, String attributeName, List attributeValues) {
        if (attributeName == null || attributeValues == null) {
            return true;
        }
        NamedNodeMap attrMap = node.getAttributes();
        if (attrMap != null) {
            Node attrNode = attrMap.getNamedItem(attributeName);
            if (attrNode != null && attributeValues.contains(attrNode.getNodeValue())) {
                return true;
            }
        }
        return false;
    }

    static String getNodeValue(Node node) {
        if (node == null || node.getFirstChild() == null || node.getFirstChild().getNodeValue() == null) {
            return null;
        }
        return node.getFirstChild().getNodeValue().trim();
    }

    static Integer getAttributeValueAsInt(Node node, String attributeName) {
        Integer num = null;
        if (!(node == null || attributeName == null)) {
            try {
                num = Integer.valueOf(Integer.parseInt(getAttributeValue(node, attributeName)));
            } catch (NumberFormatException e) {
            }
        }
        return num;
    }

    static String getAttributeValue(Node node, String attributeName) {
        if (node == null || attributeName == null) {
            return null;
        }
        Node attrNode = node.getAttributes().getNamedItem(attributeName);
        if (attrNode != null) {
            return attrNode.getNodeValue();
        }
        return null;
    }

    static List getStringDataAsList(Document vastDoc, String elementName) {
        return getStringDataAsList(vastDoc, elementName, null, null);
    }

    static List getStringDataAsList(Document vastDoc, String elementName, String attributeName, String attributeValue) {
        ArrayList results = new ArrayList();
        if (vastDoc != null) {
            NodeList nodes = vastDoc.getElementsByTagName(elementName);
            if (nodes != null) {
                for (int i = 0; i < nodes.getLength(); i++) {
                    Node node = nodes.item(i);
                    if (node != null) {
                        if (nodeMatchesAttributeFilter(node, attributeName, Arrays.asList(new String[]{attributeValue}))) {
                            String nodeValue = getNodeValue(node);
                            if (nodeValue != null) {
                                results.add(nodeValue);
                            }
                        }
                    }
                }
            }
        }
        return results;
    }
}
