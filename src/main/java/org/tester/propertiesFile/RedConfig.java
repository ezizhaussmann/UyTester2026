package org.tester.propertiesFile;

import java.io.FileInputStream;

/**
 * @created : 28/03/2026,15:59,sam.
 **/
public class RedConfig {
    public static void main(String[] args) {
        String s = RedFromeConfig.readFromConfig("config.properties", "username");
        System.out.println(s);


    }
}
