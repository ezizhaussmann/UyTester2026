package org.tester.k_io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @created : 28/03/2026,15:18,sam.
 **/
public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("CubeTest"+File.separator+"CubeTestResult.txt");
        try {
            FileUtils.delete(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
