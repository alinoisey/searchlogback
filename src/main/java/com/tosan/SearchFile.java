package com.tosan;

import com.tosan.provider.Log4jProvider;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {
    private static Logger logger = Logger.getLogger(SearchFile.class);
    static List list = new ArrayList();

    public static List getlogback(String path, String filename, List blacklist) {
        Log4jProvider.getLog4j();
        File file = new File(path);
        File[] listfiles = file.listFiles();
        for (File file1 : listfiles) {
            if (file1.isDirectory()) {
                Boolean blacklistof = false;
                for (int i = 0; i < blacklist.size(); i++) {
                    if (file1.getName().equalsIgnoreCase((String) blacklist.get(i))){
                        System.out.println(file1.getName());
                        logger.info("The "+file1.getName()+" directory is one of the blacklist directories");
                        blacklistof = true;
                        break;
                    }
                }
                if (!blacklistof) {
                    getlogback(file1.getAbsolutePath(), filename, blacklist);
                } else {
                    continue;
                }
            } else {
                if (file1.getName().matches(filename)) {
                    list.add(file.getAbsolutePath() + "\\" + filename);
                }
            }
        }
        return list;
    }
}
