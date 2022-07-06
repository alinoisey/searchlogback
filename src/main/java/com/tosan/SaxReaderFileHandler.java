package com.tosan;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
class SaxReaderFileHandler extends DefaultHandler {
    boolean isPattern = false;
    String Logstash = null;
    String Pattern = null;
    @Override
    public void startElement(String uri,
                             String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("appender")) {
            String s = attributes.getValue("class");
            if (s.equalsIgnoreCase("net.logstash.logback.appender.LogstashTcpSocketAppender")) {
                Logstash = s;
            }
        } else if (qName.equalsIgnoreCase("pattern")) {
            if (Logstash!=null){
                isPattern = true;
            }
        }
    }
    @Override
    public void endElement(String uri,
                           String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("appender")) {
            Logstash=null;
        }
    }
    @Override
    public void characters(char ch[],
                           int start, int length) throws SAXException {
        if (isPattern) {
               if (Logstash != null) {
                   Pattern = new String(ch, start, length);
                   isPattern = false;
               }
        }
    }
}
