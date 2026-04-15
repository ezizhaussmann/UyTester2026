package org.tester.k_io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @created : 28/03/2026,15:29,sam.
 **/
public class Demo3 {
    public static void main(String[] args) {
        File file = new File("CubeTest1"+File.separator+"CubeTestResult2.doc");
        File file1 = new File("CcTest"+File.separator+"AddCustomer.txt");
        StringBuilder stringBuilder1 = new StringBuilder();
        try {
            stringBuilder1.append(FileUtils.readFileToString(file1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuilder1);
//        String filecontent=null;
//        try {
//            filecontent= FileUtils.readFileToString(file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(filecontent);
//soi
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(FileUtils.readFileToString(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuilder);
    }
}
