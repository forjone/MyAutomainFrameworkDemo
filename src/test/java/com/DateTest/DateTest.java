package com.DateTest;

import BaseFramework.DateFormat;
import BaseFramework.MyFile;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by thinkpad on 2017/2/21.
 */
public class DateTest {

    public static boolean fileExists(String filePath) {
        boolean a =new File(filePath).exists();
        System.out.println(a);
        return a;
    }

    /**
     * 判断文件是否存在，没有就新建
     *
     * @param filePath 文件路径
     */
    public static void creatFile(String filePath) {
        MyFile myFile = new MyFile();
        if (!myFile.fileExists(filePath)) {
            File file = new File(filePath);
            file.mkdir();


        }

    }
    @Test
    public void test1(){
//        String dateString = DateFormat.format(DateFormat.DEFAULT_DATE_FORMAT);
//        System.out.println(dateString);
//        String path = System.getProperties().getProperty("user.dir");
//        System.out.println(path);
        DateTest.creatFile("E:\\log");
    }
}
