package com.tosan;

import com.tosan.provider.Log4jProvider;
import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Log4jProvider.getLog4j();
        logger.info("Main is start ");
        Properties properties = new Properties();
        try {
            Reader reader = new FileReader("C:\\Users\\DearUser\\IdeaProjects\\test\\SearchLogstashPattern\\src\\main\\resources\\config\\location.properties");
            properties.load(reader);
            logger.info("file configuration is loaded ");
        } catch (FileNotFoundException e) {
            logger.info("file config notFound ");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List blacklist = new ArrayList(Arrays.asList(properties.getProperty("BlackList").split(",")));
        SearchFile searchFile = new SearchFile();
        List listlogback = searchFile.getlogback(properties.getProperty("Address"), properties.getProperty("FileName"), blacklist);
        logger.info("list address logback file is ready ");
        SaxReaderFile saxReaderFile = new SaxReaderFile();
//        ReaderFile readerFile = new ReaderFile();
        ComparePattern comparePattern = new ComparePattern();
        for (Object list11 : listlogback) {
            logger.debug("logback file address is : " + list11.toString());
            String pattern = saxReaderFile.getPattern(list11.toString());
//                String pattern = readerFile.readerFileLogback(list11.toString());
            comparePattern.comparePattern(pattern);
        }
    }
}
