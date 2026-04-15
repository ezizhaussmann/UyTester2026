package org.tester.tekrar.d_io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @created : 29/03/2026,17:19,dim.
 **/
public class FileRead {
    public static void main(String[] args) {
        File file = new File("CcCreat"+File.separator+"oxygene1.doc");
//        String fileMezmun=null;
//        try {
//            fileMezmun= FileUtils.readFileToString(file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append(FileUtils.readFileToString(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(stringBuilder);
    }
}
