package org.tester.jjj_json;

import io.restassured.path.json.JsonPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @created : 13/04/2026,20:55,lun.
 **/
public class VerifyJsonContent {
    public static void main(String[] args) {
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("jsonfiles/SDETCourses.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        JsonPath jsonPath = new JsonPath(inputStream);
        String expertiseName= jsonPath.getString("Expertise");
        System.out.println(expertiseName);
        int price= jsonPath.getInt("Courses.WebAutomation[0].price");
        System.out.println(price);
        String coursTitle= jsonPath.getString("Courses.Api[0][\"course title\"]");
        System.out.println(coursTitle);
        String pp= jsonPath.getString("Courses.WebAutomation[2][\"course title\"]");
        System.out.println(pp);
    }
}
