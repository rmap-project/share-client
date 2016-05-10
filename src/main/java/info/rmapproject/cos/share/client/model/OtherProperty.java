package info.rmapproject.cos.share.client.model;

import info.rmapproject.cos.share.client.utils.Utils;

import java.net.URI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Other properties in SHARE
 * @author khanson
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OtherProperty {
	
	private String name;
	@JsonProperty("properties")
	private OtherPropertyValue properties;
	private String description;
	private URI uri;
	
	
	public OtherProperty(){}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public OtherPropertyValue getProperties() {
		return properties;
	}


	public void setProperties(OtherPropertyValue properties) {
		this.properties = properties;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		description = Utils.setEmptyToNull(description);
		this.description = description;
	}


	public URI getUri() {
		return uri;
	}


	public void setUri(String uri) {
		this.uri = Utils.convertStringToUri(uri);
	}

	
	
}
