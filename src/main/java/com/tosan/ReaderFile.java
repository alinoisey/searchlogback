package com.tosan;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
public class ReaderFile {
    public String readerFileLogback(String path) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = factory.newDocumentBuilder();
            Document document = db.parse(path);
            NodeList nodeList = document.getElementsByTagName("appender");
            NodeList nodeList10 = CheckAttribiute.getAttribiute(nodeList, "name", "LOGSTASH");

            Element nodeList20 = CheckTag.getTag(nodeList10, "encoder");
            Element nodeList30 = CheckTag.getTag(nodeList20.getChildNodes(), "providers");
            Element nodeList40 = CheckTag.getTag(nodeList30.getChildNodes(), "pattern");
            System.out.println(nodeList40.getElementsByTagName("pattern").item(0).getTextContent());
            String pattern = nodeList40.getElementsByTagName("pattern").item(0).getTextContent();
            return pattern;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("dar in file appender logstash   nist ya khata darad !!!!!!!!!!!!!!");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }
}
