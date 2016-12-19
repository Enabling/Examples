package io.enco.model;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeaasDeviceRepresentation {

    private String deviceId;
    private String connectivityId;
    private String owner;
    @JsonProperty("public")
    private boolean isPublic;
    private List<String> tags;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String theDeviceId) {
        deviceId = theDeviceId;
    }

    public String getConnectivityId() {
		return connectivityId;
	}

	public void setConnectivityId(String theConnectivityId) {
		connectivityId = theConnectivityId;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean thePublic) {
		isPublic = thePublic;
	}

	public String getOwner() {
        return owner;
    }

    public void setOwner(String theOwner) {
        owner = theOwner;
    }

    public List<String> getTags() {
		List<String> aResult = Collections.emptyList();
        return tags == null ? aResult : tags;
    }

    public void setTags(List<String> theTags) {
        tags = theTags;
    }
}