package com.tosan;

import com.tosan.provider.Log4jProvider;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class ReaderFile {
private static Logger logger=Logger.getLogger(ReaderFile.class);
    public String readerFileLogback(String path) {
        Log4jProvider.getLog4j();
        try {
            if(!path.isEmpty()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = factory.newDocumentBuilder();
                Document document = db.parse(path);
                logger.info("file logback is not null");
                NodeList nodeList = document.getElementsByTagName("appender");
                NodeList nodeList10 = getAttribiute(nodeList, "class", "net.logstash.logback.appender.LogstashTcpSocketAppender");
                logger.info("logstash exist in logback file ");
                Element nodeList20 = getTag(nodeList10, "encoder");
                Element nodeList30 = getTag(nodeList20.getChildNodes(), "providers");
                Element nodeList40 = getTag(nodeList30.getChildNodes(), "pattern");
                String pattern = nodeList40.getElementsByTagName("pattern").item(0).getTextContent();
                logger.info("pattern is ready and return it ");
                return pattern;
            }
        }catch (FileNotFoundException e) {
            logger.error("Exception : file not found");
//            e.printStackTrace();
        } catch (IOException e) {
           logger.error("Exception : I/O Exception for read logback file ");
//            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            logger.error("Exception : logback file is null ");
//            e.printStackTrace();
            return null;
        }
        logger.info("logback file is null");
        return null;
    }

    public NodeList getAttribiute(NodeList nodeList, String attribiute, String attribiute2) {
        Log4jProvider.getLog4j();
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
        logger.debug("nodelist for getAttribiute ready and return and that is  "+nodeList1);
        return nodeList1;
    }

    public Element getTag(NodeList nodeList, String tag) throws IOException {
        Log4jProvider.getLog4j();
        Element element = null;
        if(nodeList!= null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element1 = (Element) node;
                    if (element1.getNodeName().equals(tag)) {
                        element = element1;
                    }
                }
            }
        }else {

            throw new IOException();

        }
        logger.debug("return element is = "+element);
        return element;
    }

}
