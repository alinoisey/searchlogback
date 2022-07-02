package com.tosan;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tosan.provider.Log4jProvider;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class ComparePattern {
    private static Logger logger=Logger.getLogger(ComparePattern.class);
public Boolean comparePattern(String pattern){
    Log4jProvider.getLog4j();
    ObjectMapper objectMapper=new ObjectMapper();
    HashMap hashMap=new HashMap();
    try {
        if(pattern!=null) {
            logger.info("pattern loaded and not null ");
            hashMap = objectMapper.readValue(pattern, HashMap.class);
          if(hashMap.containsKey("app_name")&hashMap.containsKey("app_version")&hashMap.containsKey("raw_log")){
              logger.info("patter is ok and contain app_name,app_version,raw_log ");
          }
        }else {
            logger.info("file is null ");
            return false;
        }
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
    return false;
  }
}
