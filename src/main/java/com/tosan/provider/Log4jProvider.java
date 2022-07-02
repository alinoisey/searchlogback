package com.tosan.provider;

import org.apache.log4j.xml.DOMConfigurator;

public class Log4jProvider {
    public static void getLog4j(){
        DOMConfigurator.configure("C:\\Users\\DearUser\\IdeaProjects\\test\\SearchLogstashPattern\\src\\main\\resources\\config\\log4j.xml");
    }
}
