package info.rmapproject.cos.share.client.model;

import info.rmapproject.cos.share.client.utils.Utils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OtherPropertyValue {

	OtherPropertyType opType;
	
	//Other properties each have their own rules, so capturing them here.
	private URI doi;
	
	@JsonProperty("format")
	private Object formats;
	
	private List<String> identifier;
	
	@JsonProperty("isbn")
	private Object isbn;

	@JsonProperty("electronicIsbn")
	private String eisbn;
	
	@JsonProperty("issn")
	private Object issn;
		
	private String eissn;
	
	private List<URI> links;
	
	@JsonProperty("relation")
	private List<URI> relations;
	
	@JsonProperty("type")
	private Object types;
	
	public URI getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		doi = Utils.setEmptyToNull(doi);
		if (doi!=null){
			doi = doi.replace("doi:", "https://doi.org/");
			if (doi.startsWith("10.")){
				doi = "https://doi.org/" + doi;
			}
			this.doi = Utils.convertStringToUri(doi);
			if (this.doi!=null){this.opType=OtherPropertyType.DOI;}
		} else {
			this.doi = null;
		}
	}
	public Object getFormats() {
		return formats;
	}
	public void setFormats(Object formats) {
		this.formats = formats;
		if (this.formats!=null){this.opType=OtherPropertyType.FORMATS;}
	}
	public List<String> getIdentifier() {
		return identifier;
	}
	public void setIdentifier(List<String> identifier) {
		this.identifier = identifier;
		if (this.identifier!=null){this.opType=OtherPropertyType.IDENTIFIERS;}
	}
	
	public Object getIsbn() {
		return isbn;
	}	
	
	//** these all set the same isbn value... there is only one isbn getter.
	public void setIsbn(String isbn) {
		isbn = Utils.setEmptyToNull(isbn);
		this.isbn = isbn;
		if (this.isbn!=null){this.opType=OtherPropertyType.ISBN;}
	}

	@JsonSetter("ISBN")
	public void setIsbnAlt(Object isbnAlt) {
		//isbnAlt = Utils.setEmptyToNull(isbnAlt);
		this.isbn = isbnAlt;
		if (this.isbn!=null){this.opType=OtherPropertyType.ISBN;}
	}
	
	@JsonSetter("printIsbn")
	public void setPrintIsbn(String printIsbn) {
		printIsbn = Utils.setEmptyToNull(printIsbn);
		this.isbn = printIsbn;
		if (this.isbn!=null){this.opType=OtherPropertyType.ISBN;}
	}
	
	public String getEisbn() {
		return this.eisbn;
	}
	public void setElectronicIsbn(String eisbn) {
		eisbn = Utils.setEmptyToNull(eisbn);
		this.eisbn = eisbn;
		if (this.eisbn!=null){this.opType=OtherPropertyType.EISBN;}
	}
	
	public Object getIssn() {
		return issn;
	}
	//These both set the same issn value - only one issn getter
	public void setIssn(Object issn) {
		//issn = Utils.setEmptyToNull(issn);
		this.issn = issn;
		if (this.issn!=null){this.opType=OtherPropertyType.ISSN;}
	}

	@JsonSetter("ISSN")
	public void setIssnAlt(Object issnAlt) {
		//issnAlt = Utils.setEmptyToNull(issnAlt);
		this.issn = issnAlt;
		if (this.issn!=null){this.opType=OtherPropertyType.ISSN;}

	}
	
	public String getEissn() {
		return eissn;
	}
	public void setEissn(String eissn) {
		eissn = Utils.setEmptyToNull(eissn);
		this.eissn = eissn;
		if (this.eissn!=null){this.opType=OtherPropertyType.EISSN;}

	}
	
	public List<URI> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = Utils.convertStringListToUris(links);
		if (this.links!=null){this.opType=OtherPropertyType.LINKS;}
	}	
	@JsonSetter("link")
	public void setLink(String link) {
		URI uriLink = Utils.convertStringToUri(link);
		this.addLink(uriLink);
		if (this.links!=null){this.opType=OtherPropertyType.LINKS;}
	}
	public void addLink(URI link) {
		if (this.links==null){
			this.links = new ArrayList<URI>();
		}
		if (link!=null){
			this.links.add(link);
		}
	}	
	
	public List<URI> getRelations() {
		return relations;
	}
	public void setRelations(List<String> relations) {
		this.relations = Utils.convertStringListToUris(relations);
		if (this.relations!=null){this.opType=OtherPropertyType.RELATIONS;}
	}
	
	public Object getTypes() {
		return types;
	}
	public void setType(Object types) {
		this.types = types;
		if (this.types!=null){this.opType=OtherPropertyType.TYPES;}
	}
	
	public OtherPropertyType getOtherPropertyType(){
		return this.opType;
	}
	
	
	
}
