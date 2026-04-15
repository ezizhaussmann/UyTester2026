package org.tester.k_io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @created : 28/03/2026,15:06,sam.
 **/
public class WriteDemo2 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("CCLogin Test1\n");
        builder.append("CcLogin");
        builder.append("soltek saqchi ");
        File file = new File("CubeTest1"+File.separator+"CubeTestResult2.doc");
        try {
            FileUtils.writeStringToFile(file,builder.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
