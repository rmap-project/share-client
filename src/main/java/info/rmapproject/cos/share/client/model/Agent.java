package info.rmapproject.cos.share.client.model;

import info.rmapproject.cos.share.client.utils.Utils;

import java.net.URI;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO representing a SHARE agent - a person or organization that is a publisher, contributor or affiliation.
 * Note that this isn't split into subtypes person/org because it isn't always clear which a thing is.
 * Looking at the SHARE data, many Org names have been split to populate familyName etc. 
 * The only way to be close to sure of the agent type is if it's either side of an affiliation relationship 
 * (person affiliated with org), or if it's a publisher (org).  Those are the criteria by which a type is assigned.  
 * Otherwise type is null.
 * @author khanson
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Agent {
	
	//organization or person properties
	private List<URI> sameAs;
	private String name;
	private String email;
	
	//usually only apply to person
	private String familyName;
	private String givenName;
	private String additionalName;
	
	@JsonProperty("affilliation")
	private List<Agent> affiliations;
	
	public Agent(){}

	public List<URI> getSameAs() {
		return sameAs;
	}

	public void setSameAs(List<String> sameAs) {
		List<URI> sameAsUris = Utils.convertStringListToUris(sameAs);
		this.sameAs = sameAsUris;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = Utils.setEmptyToNull(name);
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		email = Utils.setEmptyToNull(email);
		this.email = email;
	}

	public AgentType getType() {
		if (this.affiliations!=null && this.affiliations.size()>0) {
			return AgentType.PERSON; //only a person can have an affiliation
		}
		else {
			return null; //otherwise it's not clear what the type is.
		}
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		familyName = Utils.setEmptyToNull(familyName);
		this.familyName = familyName;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		givenName = Utils.setEmptyToNull(givenName);
		this.givenName = givenName;
	}

	public String getAdditionalName() {
		return additionalName;
	}

	public void setAdditionalName(String additionalName) {
		additionalName = Utils.setEmptyToNull(additionalName);
		this.additionalName = additionalName;
	}

	public List<Agent> getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(List<Agent> affiliations) {
		this.affiliations = affiliations;
	}
	
}
