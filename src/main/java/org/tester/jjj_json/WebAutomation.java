package org.tester.jjj_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @created : 03/04/2026,17:16,ven.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebAutomation {
    @JsonProperty("course title")
    private String courseTitle;
    private int price;

    public WebAutomation() {

    }

    public WebAutomation(String courseTitle, int price) {
        this.courseTitle = courseTitle;
        this.price = price;
    }
    // Constructeur par défaut

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
