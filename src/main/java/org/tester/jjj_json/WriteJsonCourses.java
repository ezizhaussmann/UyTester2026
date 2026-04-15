package org.tester.jjj_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @created : 03/04/2026,17:36,ven.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WriteJsonCourses {
    public static void main(String[] args) {
        WebAutomation webAutomation = new WebAutomation("Cypress",100);
        WebAutomation webAutomation1 = new WebAutomation("Selenium",200);
        WebAutomation webAutomation2 = new WebAutomation("playWrite",300);
        List<WebAutomation> webAutomations=new ArrayList<>();
        webAutomations.add(webAutomation);
        webAutomations.add(webAutomation1);
        webAutomations.add(webAutomation2);
        Api api = new Api();
        List<Api> apis=new ArrayList<>();
        apis.add(new Api("Resr-Assured Api",150));
        apis.add(new Api("Soup-UI",50));
        Courses courses= new Courses(webAutomations,apis);

        SDETCourses sdetCourses = new SDETCourses("SDET job Training",
                "Manuel&TestAutomation","Dolqun Tarim",
                "https://www.unitedcoder.com",courses,"https://www.seleniummaster.com");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File("jsonfiles"+File.separator+"SDETCoursesvis1.json"),sdetCourses);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
