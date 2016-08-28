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
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Holds data from a single SHARE record harvested from the SHARE API.
 * Note that anything coming in as a String will be trimmed and if the length is 0 it will be set to null
 * so that it doesn't record as an empty literal.
 * @author khanson
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("results")
public class Record {

	/** Language URL prefix. */
	private final static String LANG_URL_PREFIX = "http://www.lexvo.org/page/iso639-3/";

    /** The log. */
    private static final Logger log = LoggerFactory.getLogger(Record.class);
		
	/** The URIs list. */
	private Uris uris;
	
	/** The title. */
	private String title;
	
	/** The description. */
	private String description;
	
	/** The contributors. */
	private List <Agent> contributors;
	
	/** The publisher. */
	private Agent publisher;
	
	/** The languages. */
	private List<URI> languages;
	
	/** The sponsorships. */
	private List<Sponsorship> sponsorships;
	
	/** The SHARE properties. */
	private ShareProperties shareProperties;
	
	/** The other properties. */
	@JsonProperty("otherProperties")
	private List<OtherProperty> otherProperties;
	
	/** The version. */
	private Version version;		
	
	/* * * * * * * * * * * * * * * * * * * * 
	* These are excluded because they won't be part of DiSCO at this time, 
	* but documenting their existence for the record!
	* 
	* private Date versionDateTime;
	* 
	* private List<SHARETag> tags
	* private Date providerUpdatedDateTime
	* private Date freeToReadStartDate
	* private Date freeToReadEndDate
	* private List<SHARELicense> licenses
	* private List<String> subjects
	*/
	
	/**
	 * Instantiates a new record.
	 */
	public Record(){}

	
	/**
	 * Gets the URIs.
	 *
	 * @return the URIs
	 */
	public Uris getUris() {
		return uris;
	}


	/**
	 * Sets the URIs.
	 *
	 * @param uris the new URIs
	 */
	public void setUris(Uris uris) {
		this.uris = uris;
	}


	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		title = Utils.setEmptyToNull(title);
		this.title = title;
	}


	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		description = Utils.setEmptyToNull(description);
		this.description = description;
	}


	/**
	 * Gets the contributors.
	 *
	 * @return the contributors
	 */
	public List<Agent> getContributors() {
		return contributors;
	}


	/**
	 * Sets the contributors.
	 *
	 * @param contributors the new contributors
	 */
	public void setContributors(List<Agent> contributors) {
		this.contributors = contributors;
	}


	/**
	 * Gets the publisher.
	 *
	 * @return the publisher
	 */
	public Agent getPublisher() {
		return publisher;
	}


	/**
	 * Sets the publisher.
	 *
	 * @param publisher the new publisher
	 */
	public void setPublisher(Agent publisher) {
		this.publisher = publisher;
	}


	/**
	 * Gets the languages.
	 *
	 * @return the languages
	 */
	public List<URI> getLanguages() {
		return languages;
	}

	/**
	 * Sets the languages.
	 *
	 * @param languages the new languages
	 */
	public void setLanguages(List<String> languages) {
		if (languages!=null){
			List<URI> languageUris = new ArrayList<URI>();
			for (String language:languages){
				language = Utils.setEmptyToNull(language);
				if (language!=null){
					if (language.length()!=3){
						log.error("Language value was not in iso639-3 format: " + language + ".");
					} else {
						URI languri = Utils.convertStringToUri(language, LANG_URL_PREFIX);
						languageUris.add(languri);
					}
				}			
			}
			this.languages = languageUris;						
		}
		else {
			this.languages=null;
		}		
	}


	/**
	 * Gets the sponsorships.
	 *
	 * @return the sponsorships
	 */
	public List<Sponsorship> getSponsorships() {
		return sponsorships;
	}


	/**
	 * Sets the sponsorships.
	 *
	 * @param sponsorships the new sponsorships
	 */
	public void setSponsorships(List<Sponsorship> sponsorships) {
		this.sponsorships = sponsorships;
	}


	/**
	 * Gets the version.
	 *
	 * @return the version
	 */
	public Version getVersion() {
			return version;
		}


	/**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
	public void setVersion(Version version) {
		this.version = version;
	}


	/**
	 * Gets the other properties.
	 *
	 * @return the other properties
	 */
	public List<OtherProperty> getOtherProperties() {
		return otherProperties;
	}


	/**
	 * Sets the other properties.
	 *
	 * @param otherProperties the new other properties
	 */
	public void setOtherProperties(List<OtherProperty> otherProperties) {
		this.otherProperties = otherProperties;
	}


	/**
	 * Gets the SHARE properties.
	 *
	 * @return the SHARE properties
	 */
	public ShareProperties getShareProperties() {
		return shareProperties;
	}


	/**
	 * Sets the SHARE properties.
	 *
	 * @param shareProperties the new SHARE properties
	 */
	public void setShareProperties(ShareProperties shareProperties) {
		this.shareProperties = shareProperties;
	}
	
}
