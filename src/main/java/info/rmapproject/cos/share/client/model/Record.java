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

	private final static String LANG_URL_PREFIX = "http://www.lexvo.org/page/iso639-3/";

    private static final Logger log = LoggerFactory.getLogger(Record.class);
		
	private Uris uris;
	private String title;
	private String description;
	private List <Agent> contributors;
	private Agent publisher;
	private List<URI> languages;
	private List<Sponsorship> sponsorships;
	
	@JsonProperty("otherProperties")
	private List<OtherProperty> otherProperties;
	
	private Version version;		
	
	/* * * * * * * * * * * * * * * * * * * * 
	* These are excluded because they won't be part of DiSCO at this time, 
	* but documenting their existence for the record!
	* 
	* private Date versionDateTime;
	* 
	* private List<SHAREShareProperty> shareProperties
	* private List<SHARETag> tags
	* private Date providerUpdatedDateTime
	* private Date freeToReadStartDate
	* private Date freeToReadEndDate
	* private List<SHARELicense> licenses
	* private List<String> subjects
	*/
	
	public Record(){}

	
	public Uris getUris() {
		return uris;
	}


	public void setUris(Uris uris) {
		this.uris = uris;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		title = Utils.setEmptyToNull(title);
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		description = Utils.setEmptyToNull(description);
		this.description = description;
	}


	public List<Agent> getContributors() {
		return contributors;
	}


	public void setContributors(List<Agent> contributors) {
		this.contributors = contributors;
	}


	public Agent getPublisher() {
		return publisher;
	}


	public void setPublisher(Agent publisher) {
		this.publisher = publisher;
	}


	public List<URI> getLanguages() {
		return languages;
	}

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


	public List<Sponsorship> getSponsorships() {
		return sponsorships;
	}


	public void setSponsorships(List<Sponsorship> sponsorships) {
		this.sponsorships = sponsorships;
	}


	public Version getVersion() {
			return version;
		}


	public void setVersion(Version version) {
		this.version = version;
	}


		public List<OtherProperty> getOtherProperties() {
		return otherProperties;
	}


	public void setOtherProperties(List<OtherProperty> otherProperties) {
		this.otherProperties = otherProperties;
	}
	
}
