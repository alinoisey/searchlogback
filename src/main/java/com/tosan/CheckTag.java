package com.tosan;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;


public class CheckTag {
    public static Element getTag(NodeList nodeList, String tag) throws IOException {
        Element element = null;
        if(nodeList!= null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element1 = (Element) node;
                    if (element1.getNodeName().equals(tag)) {
//                    System.out.println(element1.getNodeName());
                        element = element1;

                    }
                }
            }
        }else {
           throw new IOException();

        }
        return element;
    }
}