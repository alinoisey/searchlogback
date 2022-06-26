package com.tosan;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CheckAttribiute {

    public static NodeList getAttribiute(NodeList nodeList, String attribiute, String attribiute2) {
        Element element = null;
        NodeList nodeList1=null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                element = (Element) node;
                if (element.getAttribute(attribiute).equals(attribiute2)) {
                    nodeList1=element.getChildNodes();
                }
            }
        }
        return nodeList1;
    }
}
