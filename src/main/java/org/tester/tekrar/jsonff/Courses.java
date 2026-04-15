package org.tester.tekrar.jsonff;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.tester.jjj_json.Api;
import org.tester.jjj_json.WebAutomation;

import java.util.List;

/**
 * @created : 03/04/2026,18:29,ven.
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Courses {
    @JsonProperty("WebAutomation")
    private List<WebAutomation> webAutomation;
    @JsonProperty("Api")
    private List<Api> api;

    // Getters
    public List<WebAutomation> getWebAutomation() { return webAutomation; }
    public List<Api> getApi() { return api; }
}