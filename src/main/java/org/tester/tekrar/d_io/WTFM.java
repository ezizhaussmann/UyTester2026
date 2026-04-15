package org.tester.tekrar.d_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @created : 29/03/2026,16:35,dim.
 **/
public class WTFM {
    public void wtf(String foldN,String fileN,String exte,String mezmun){
        String proP=System.getProperty("user.dir");
        String ffL=proP+ File.separator+foldN;
        File folder = new File(ffL);
        if (!folder.exists()){
            folder.mkdir();
            System.out.println(String.format("%s folder is created",foldN));
        }
        String fileLoc=ffL+File.separator+fileN+exte;
        File file = new File(fileLoc);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(mezmun);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
