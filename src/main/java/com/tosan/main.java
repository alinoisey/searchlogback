package com.tosan;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class main {
    public static void main(String[] args) {
      List listlogback = SearchFile.getlogback("D:\\searchlogstash", "logback.xml");
      ReaderFile readerFile=new ReaderFile();
      ComparePattern comparePattern=new ComparePattern();

        for (int i = 0; i < listlogback.size() ; i++) {
            System.out.println(listlogback.get(i));
            String pattern=readerFile.readerFileLogback(listlogback.get(i)+"\\"+"logback.xml");
            comparePattern.comparePattern(pattern);
        }

    }

}
