package org.tester.tekrar.e_javaIo;

import java.io.File;

/**
 * @created : 29/03/2026,16:27,dim.
 **/
public class Demo1 {
    public static void main(String[] args) {
        file01();

    }
    public static void file01(){
        String pathSeparator= File.pathSeparator;
        System.out.println("pathSeparator = " + pathSeparator);
        String separator=File.separator;
        System.out.println("separator = " + separator);
    }
    public static void file02(){

    }
}
