package org.tester.tekrar.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @created : 29/03/2026,17:36,dim.
 **/
public class Lireproperiete {
    public static String fFC(String fileN,String key){
        Properties properties = new Properties();
        System.out.println("Je cherche le fichier ici : " + new File(fileN).getAbsolutePath());
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileN);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String property = properties.getProperty(key);
        return property;
    }

}
