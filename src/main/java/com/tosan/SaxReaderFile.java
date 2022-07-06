package com.tosan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tosan.provider.Log4jProvider;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class SaxReaderFile {
    private static Logger logger = Logger.getLogger(SaxReaderFile.class);
    public String getPattern(String path) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            File input = new File(path);
            SAXParser saxParser = saxParserFactory.newSAXParser();
            SaxReaderFileHandler standardHandler = new SaxReaderFileHandler();
            saxParser.parse(input, standardHandler);
            return standardHandler.Pattern;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


