package org.tester.jjj_json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @created : 03/04/2026,16:59,ven.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Courses {
//    @JsonProperty("WebAutomation")

    @JsonProperty("WebAutomation")
    private List<WebAutomation> webAutomation; // Utilise la classe WebAutomation

    @JsonProperty("Api")
    private List<Api> api; // Utilise la classe Api

    public Courses() {
    }

    public Courses(List<WebAutomation> webAutomation, List<Api> api) {
        this.webAutomation = webAutomation;
        this.api = api;
    }

    public List<WebAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<WebAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    public List<Api> getApi() {
        return api;
    }

    public void setApi(List<Api> api) {
        this.api = api;
    }
}
