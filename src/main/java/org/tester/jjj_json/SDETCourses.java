package org.tester.jjj_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @created : 03/04/2026,16:42,ven.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"Url", "Linkedin", "Services", "Instructor", "Courses", "Expertise"})

public class SDETCourses {
    @JsonProperty("Services")
    private String services;
    @JsonProperty("Expertise")
    private String expertise;
    @JsonProperty("Instructor")
    private String instructor;
    @JsonProperty("LinkedIn")
    private String linkedIn;
    @JsonProperty("Url")
    private String url;
    @JsonProperty("Courses")
    private Courses courses;

    public SDETCourses() {
    }

    public SDETCourses(String services, String expertise,
                       String instructor, String linkedIn, Courses courses, String url) {
        this.services = services;
        this.expertise = expertise;
        this.instructor = instructor;
        this.linkedIn = linkedIn;
        this.url = url;
        this.courses = courses;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
