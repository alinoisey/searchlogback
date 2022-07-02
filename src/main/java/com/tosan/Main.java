package com.tosan;

import com.tosan.provider.Log4jProvider;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

public class Main {
  private static Logger logger=Logger.getLogger(Main.class);
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

        List listlogback = SearchFile.getlogback(properties.getProperty("address"), properties.getProperty("filename"));
        logger.info("list address logback file is ready ");
        ReaderFile readerFile = new ReaderFile();
        ComparePattern comparePattern = new ComparePattern();
        for (int i = 0; i < listlogback.size(); i++) {
            String pattern = readerFile.readerFileLogback(listlogback.get(i).toString());
            comparePattern.comparePattern(pattern);
        }

    }

}
