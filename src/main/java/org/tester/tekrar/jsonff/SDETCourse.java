package org.tester.tekrar.jsonff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.tester.jjj_json.Courses;

/**
 * @created : 03/04/2026,18:27,ven.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class SDETCourse {
    @JsonProperty("services")
    private String services;
    @JsonProperty("expertise")
    private String expertise;
    @JsonProperty("instructor")
    private String instructor;
    @JsonProperty("linkedIn")
    private String linkedIn;
    @JsonProperty("url")
    private String url;
    @JsonProperty("courses")
    private Courses courses;

    // Getters
    public String getServices() { return services; }
    public String getExpertise() { return expertise; }
    public String getInstructor() { return instructor; }
    public String getLinkedIn() { return linkedIn; }
    public String getUrl() { return url; }
    public Courses getCourses() { return courses; }
}
