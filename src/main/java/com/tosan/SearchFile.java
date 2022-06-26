package com.tosan;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchFile {
    static List list = new ArrayList();

    public static List getlogback(String path, String filename) {
        File file = new File(path);
        File[] listfiles = file.listFiles();
        for (File file1 : listfiles) {
            if (file1.isDirectory()) {
                getlogback(file1.getAbsolutePath(), filename);
            } else {
                if (file1.getName().matches(filename)) {
                    list.add(file.getAbsolutePath());
                }
            }
        }
        return list;
    }
}
