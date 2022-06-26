package com.tosan;

public class ComparePattern {
public Boolean comparePattern(String pattern){
    String LocalPattern="{"+"\"app_name\"" + ": " + "\"modern-define-customer\""+", "+ "\"app_version\"" + ":" + "\"${APP_VERSION}\""+", "+ "\"raw_log\"" + ": " + "\"${PATTERN}\""+"}";
    System.out.println("default pattern is : "+LocalPattern);
    if(LocalPattern.equals(pattern)){
        System.out.println("logstash pattern is ok =======================================");
        return true;
    }else{
        System.out.println("logstash pattern is not ok ===================================");
    return false;
    }
}
}
