package com.tosan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tosan.provider.Log4jProvider;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class ComparePattern {
    private static Logger logger = Logger.getLogger(ComparePattern.class);

    public Boolean comparePattern(String pattern) {
        Log4jProvider.getLog4j();
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap hashMap;
        try {
            if (!pattern.isEmpty()) {
                String SPattern = pattern.toLowerCase();
                hashMap = objectMapper.readValue(SPattern, HashMap.class);
                if (hashMap.containsKey("app_name") & hashMap.containsKey("app_version") & hashMap.containsKey("raw_log")) {
                    logger.info("patter is ok and contains app_name,app_version,raw_log " + pattern);
                    return true;
                } else {
                    logger.info("pattern is Not ok " + pattern);
                    return false;
                }
            } else {
                logger.info("pattern is Not ok ");
                return false;
            }
        } catch (JsonProcessingException e) {
            logger.error("pattern is Not ok because pattern is No content ");
        }
        return null;
    }
}
