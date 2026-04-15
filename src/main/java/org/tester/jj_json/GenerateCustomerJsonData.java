package org.tester.jj_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @created : 02/04/2026,17:11,jeu.
 **/
public class GenerateCustomerJsonData {
    public static void main(String[] args) throws IOException {
        Costumer costumer1 = new Costumer("kata","chan","kata11@gg.fr",
                "0981321457","666333","Holkeick");
        Costumer costumer2 = new Costumer("luffy","D","luffy11@gg.fr",
                "0981321458","666111","Moncorwo");
        List<Costumer> list = Arrays.asList(costumer1, costumer2);

        Customers customers = new Customers(list);

        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String s = null;
        try {
            s = objectMapper.writeValueAsString(customers);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            FileUtils.writeStringToFile(new File("jsonfiles"+File.separator+"Customers3.json"),s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        int i= (int) (Math.random()+1);
//
//        File file=new File("jsonfiles"+File.separator+"Customers"+i+".json");


//        if (i!=3){
//            FileUtils.delete(file);
//        }
//        if (file.exists()) {
//            FileUtils.forceDelete(file); // forceDelete supprime même si c'est un dossier
//        }


    }
}
