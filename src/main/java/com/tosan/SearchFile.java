package com.tosan;

import com.tosan.provider.Log4jProvider;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {
 private static Logger logger=Logger.getLogger(SearchFile.class);
    static List list = new ArrayList();

    public static List getlogback(String path, String filename) {
        Log4jProvider.getLog4j();
        File file = new File(path);
        File[] listfiles = file.listFiles();
        for (File file1 : listfiles) {
            if (file1.isDirectory()) {
                getlogback(file1.getAbsolutePath(), filename);
            } else {
                if (file1.getName().matches(filename)) {
                    list.add(file.getAbsolutePath()+"\\"+filename);
                }
            }
        }

        return list;
    }
}
