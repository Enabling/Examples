package io.enco.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {

    private String name;
    @JsonProperty("given_name")
    private String givenName;
    @JsonProperty("family_name")
    private String familyName;
    private String email;

	public String getName() {
		return name;
	}
	public void setName(String theName) {
		name = theName;
	}

	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String theGivenName) {
		givenName = theGivenName;
	}

	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String theFamilyName) {
		familyName = theFamilyName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String theEmail) {
		email = theEmail;
	}

}