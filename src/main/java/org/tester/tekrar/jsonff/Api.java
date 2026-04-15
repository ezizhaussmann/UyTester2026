package org.tester.tekrar.jsonff;

/**
 * @created : 03/04/2026,18:31,ven.
 **/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Api {
    @JsonProperty("course title")
    private String courseTitle;
    @JsonProperty("price")
    private int price;

    // Getters
    public String getCourseTitle() { return courseTitle; }
    public int getPrice() { return price; }
}
