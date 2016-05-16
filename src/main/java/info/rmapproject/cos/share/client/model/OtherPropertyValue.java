package info.rmapproject.cos.share.client.model;

import info.rmapproject.cos.share.client.utils.Utils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OtherPropertyValue {

	OtherPropertyType opType;
	
	//Other properties each have their own rules, so capturing them here.
	private URI doi;
	
	private List<String> formats;	
	private List<String> identifiers;
	private List<String> eisbns;
	private List<String> eissns;
	private List<String> issns;
	private List<String> isbns;
	private List<String> links;
	private List<String> relations;
	private List<String> types;	
	
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
	
	public List<String> getFormats() {
		return formats;
	}
	@JsonSetter("format")
	public void setFormat(Object format) {
		this.setFormats(format);
	}	
	@JsonSetter("formats")
	public void setFormats(Object formats) {
		if (this.formats==null){
			this.formats = new ArrayList<String>();
		}
		this.formats.addAll(this.buildList(formats));
		if (this.formats.size()>0){this.opType=OtherPropertyType.FORMATS;}
	}
	
	
		
	public List<String> getIdentifiers() {
		return this.identifiers;
	}
	public void setIdentifier(Object identifier) {
		if (this.identifiers==null){
			this.identifiers = new ArrayList<String>();
		}
		this.identifiers.addAll(this.buildList(identifier));
		if (this.identifiers.size()>0){this.opType=OtherPropertyType.IDENTIFIERS;}
	}
	
	
	public List<String> getIsbns() {
		return isbns;
	}		
	//** these all set the same isbn value... there is only one isbn getter.
	@JsonSetter("isbn")
	public void setIsbn(Object isbn) {
		if (this.isbns==null){
			this.isbns = new ArrayList<String>();
		}
		this.isbns.addAll(this.buildList(isbn));
		if (this.isbns.size()>0){this.opType=OtherPropertyType.ISBN;}
	}
	@JsonSetter("ISBN")
	public void setIsbnAlt(Object isbnAlt) {
		this.setIsbn(isbnAlt);
	}
	@JsonSetter("printIsbn")
	public void setPrintIsbn(Object printIsbn) {
		this.setIsbn(printIsbn);
	}
	
	
	
	public List<String> getEisbn() {
		return this.eisbns;
	}
	//These both set the same eisbn value - only one eisbn getter
	@JsonSetter("eisbn")
	public void setEisbns(Object eisbn) {
		if (this.eisbns==null){
			this.eisbns = new ArrayList<String>();
		}
		this.eisbns.addAll(this.buildList(eisbn));
		if (this.eisbns.size()>0){this.opType=OtherPropertyType.EISBN;}
	}
	@JsonSetter("electronicIsbn")
	public void setElectronicIsbn(Object eisbns) {
		this.setEisbns(eisbns);
	}
	
		
	public List<String> getIssns() {
		return issns;
	}
	//These both set the same issn value - only one issn getter
	@JsonSetter("issn")
	public void setIssn(Object issn) {
		if (this.issns==null){
			this.issns = new ArrayList<String>();
		}
		this.issns.addAll(this.buildList(issn));
		if (this.issns.size()>0){this.opType=OtherPropertyType.ISSN;}
	}
	@JsonSetter("ISSN")
	public void setIssnAlt(Object issnAlt) {
		this.setIssn(issnAlt);
	}
	
	
	
	public List<String> getEissns() {
		return this.eissns;
	}
	@JsonSetter("eissn")
	public void setEissns(Object eissn) {
		if (this.eissns==null){
			this.eissns = new ArrayList<String>();
		}
		this.eissns.addAll(this.buildList(eissn));
		if (this.eissns.size()>0){this.opType=OtherPropertyType.EISSN;}
	}
		
	
	
	public List<String> getLinks() {
		return links;
	}
	@JsonSetter("links")
	public void setLinks(Object links) {
		this.setLink(links);
	}	
	@JsonSetter("link")
	public void setLink(Object link) {
		if (this.links==null){
			this.links = new ArrayList<String>();
		}
		this.links.addAll(this.buildList(link));
		if (this.links.size()>0){this.opType=OtherPropertyType.LINKS;}
	}
	
	
	
	public List<String> getRelations() {
		return relations;
	}
	@JsonSetter("relation")
	public void setRelation(Object relation){
		setRelations(relation);
	}
	@JsonSetter("relations")
	public void setRelations(Object relations) {
		if (this.relations==null){
			this.relations = new ArrayList<String>();
		}
		this.relations.addAll(this.buildList(relations));
		if (this.relations.size()>0){this.opType=OtherPropertyType.RELATIONS;}
	}
		
	
	public List<String> getTypes() {
		return types;
	}
	@JsonSetter("type")
	public void setType(Object type) {
		this.setTypes(type);
	}
	@JsonSetter("types")
	public void setTypes(Object types) {
	if (this.types==null){
		this.types = new ArrayList<String>();
	}
	this.types.addAll(this.buildList(types));
	if (this.types.size()>0){this.opType=OtherPropertyType.TYPES;}
	}
	
		
	public OtherPropertyType getOtherPropertyType(){
		return this.opType;
	}	

	/**
	 * Builds string list from Object containing either a String or a List<String>. 
	 * Removes empty/null and returns as new List<String>.
	 * @param val
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<String> buildList(Object val){
		List<String> valueList = new ArrayList<String>();
		if (val!=null){
			if (val instanceof String){
				String sVal = (String) val;
				sVal = Utils.setEmptyToNull(sVal);
				if (sVal!=null){
					valueList.add(sVal);
				}
			} else {
				List<String> sVals = (List<String>) val;
				for (String sVal : sVals){
					sVal = Utils.setEmptyToNull(sVal);
					if (sVal!=null){
						valueList.add(sVal);		
					}
				}
			}
		}
		return valueList;		
	}
	
}
