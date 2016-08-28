/*******************************************************************************
 * Copyright 2016 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This software was produced as part of the RMap Project (http://rmap-project.info),
 * The RMap Project was funded by the Alfred P. Sloan Foundation and is a 
 * collaboration between Data Conservancy, Portico, and IEEE.
 *******************************************************************************/
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
	
	/** The same as. */
	private List<URI> sameAs;
	
	/** The name. */
	private String name;
	
	/** The email. */
	private String email;
	
	/** The family name - usually only apply to person. */
	private String familyName;
	
	/** The given name. */
	private String givenName;
	
	/** The additional name. */
	private String additionalName;
	
	/** The affiliations. */
	@JsonProperty("affilliation")
	private List<Agent> affiliations;
	
	/**
	 * Instantiates a new agent.
	 */
	public Agent(){}

	/**
	 * Gets the same as list
	 *
	 * @return the same as list
	 */
	public List<URI> getSameAs() {
		return sameAs;
	}

	/**
	 * Sets the same as.
	 *
	 * @param sameAs the new same as
	 */
	public void setSameAs(List<String> sameAs) {
		List<URI> sameAsUris = Utils.convertStringListToUris(sameAs);
		this.sameAs = sameAsUris;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		name = Utils.setEmptyToNull(name);
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		email = Utils.setEmptyToNull(email);
		this.email = email;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public AgentType getType() {
		if (this.affiliations!=null && this.affiliations.size()>0) {
			return AgentType.PERSON; //only a person can have an affiliation
		}
		else {
			return null; //otherwise it's not clear what the type is.
		}
	}

	/**
	 * Gets the family name.
	 *
	 * @return the family name
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * Sets the family name.
	 *
	 * @param familyName the new family name
	 */
	public void setFamilyName(String familyName) {
		familyName = Utils.setEmptyToNull(familyName);
		this.familyName = familyName;
	}

	/**
	 * Gets the given name.
	 *
	 * @return the given name
	 */
	public String getGivenName() {
		return givenName;
	}

	/**
	 * Sets the given name.
	 *
	 * @param givenName the new given name
	 */
	public void setGivenName(String givenName) {
		givenName = Utils.setEmptyToNull(givenName);
		this.givenName = givenName;
	}

	/**
	 * Gets the additional name.
	 *
	 * @return the additional name
	 */
	public String getAdditionalName() {
		return additionalName;
	}

	/**
	 * Sets the additional name.
	 *
	 * @param additionalName the new additional name
	 */
	public void setAdditionalName(String additionalName) {
		additionalName = Utils.setEmptyToNull(additionalName);
		this.additionalName = additionalName;
	}

	/**
	 * Gets the affiliations.
	 *
	 * @return the affiliations
	 */
	public List<Agent> getAffiliations() {
		return affiliations;
	}

	/**
	 * Sets the affiliations.
	 *
	 * @param affiliations the new affiliations
	 */
	public void setAffiliations(List<Agent> affiliations) {
		this.affiliations = affiliations;
	}
	
}
