package org.tester.k_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @created : 28/03/2026,13:32,sam.
 **/
public class DemoWrite {
    public void fileWrite(String folderName,String fileN,String extension,String contains){
        String property = System.getProperty("user.dir");
        String folderFinalLocation=property+ File.separator+folderName;
        File folder = new File(folderFinalLocation);
        if (!folder.exists()){
            folder.mkdir();
            System.out.println(String.format("%s folder is Created", folderName));
        }
        String fileLocation=folderFinalLocation+File.separator+fileN+extension;
        File file = new File(fileLocation);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(contains);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        System.out.println(property);
    }
}
