package org.tester.tekrar.jsonff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @created : 03/04/2026,18:30,ven.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class WebAutomation {
    @JsonProperty("course title")
    private String courseTitle;
    @JsonProperty("price")
    private int price;

    // Getters
    public String getCourseTitle() { return courseTitle; }
    public int getPrice() { return price; }
}
