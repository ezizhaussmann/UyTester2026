package org.tester.tekrar.d_io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @created : 29/03/2026,17:12,dim.
 **/
public class DeleteF {
    public static void main(String[] args) {
        File file = new File("Gemini1"+File.separator+"gemini2.doc");
        try {
            FileUtils.delete(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("fichier " + "Gemini1" + File.separator + "gemini2.doc est supprimer");
    }
}
