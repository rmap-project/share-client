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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Processes OtherPropertyValues according to their rules. Maps properties with equivalent meaning into a combined list. 
 * @author khanson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OtherPropertyValue {

	/** DOI HTTP Prefix */
	private static final String DOI_HTTP_PREFIX = "http://dx.doi.org/";
	
	/** The other property type. */
	OtherPropertyType opType;

	//Other properties each have their own rules, so capturing them here.
	/** The DOI. */
	private URI doi;
	
	/** The formats list. */
	private List<String> formats;	
	
	/** The identifiers list. */
	private List<String> identifiers;
	
	/** The eisbns list. */
	private List<String> eisbns;
	
	/** The eissns list. */
	private List<String> eissns;
	
	/** The issns list. */
	private List<String> issns;
	
	/** The isbns list. */
	private List<String> isbns;
	
	/** The links list. */
	private List<String> links;
	
	/** The relations list. */
	private List<String> relations;
	
	/** The types list. */
	private List<String> types;	

	
	/**
	 * Gets the DOI.
	 *
	 * @return the DOI
	 */
	public URI getDoi() {
		return doi;
	}
	
	/**
	 * Sets the DOI.
	 *
	 * @param doi the new DOI
	 */
	public void setDoi(String doi) {
		doi = Utils.setEmptyToNull(doi);
		if (doi!=null){
			if (doi.startsWith("10.")){
				doi = DOI_HTTP_PREFIX + doi;
			}
			this.doi = Utils.convertStringToUri(doi);
			if (this.doi!=null){this.opType=OtherPropertyType.DOI;}
		} else {
			this.doi = null;
		}
	}
	
	/**
	 * Gets the formats.
	 *
	 * @return the formats
	 */
	public List<String> getFormats() {
		return formats;
	}
	
	/**
	 * Sets the format.
	 *
	 * @param format the new format
	 */
	@JsonSetter("format")
	public void setFormat(Object format) {
		this.setFormats(format);
	}	
	
	/**
	 * Sets the formats.
	 *
	 * @param formats the new formats
	 */
	@JsonSetter("formats")
	public void setFormats(Object formats) {
		if (this.formats==null){
			this.formats = new ArrayList<String>();
		}
		this.formats.addAll(this.buildList(formats));
		if (this.formats.size()>0){this.opType=OtherPropertyType.FORMATS;}
	}
	
	
		
	/**
	 * Gets the identifiers.
	 *
	 * @return the identifiers
	 */
	public List<String> getIdentifiers() {
		return this.identifiers;
	}
	
	/**
	 * Sets the identifier.
	 *
	 * @param identifier the new identifier
	 */
	public void setIdentifier(Object identifier) {
		if (this.identifiers==null){
			this.identifiers = new ArrayList<String>();
		}
		this.identifiers.addAll(this.buildList(identifier));
		if (this.identifiers.size()>0){this.opType=OtherPropertyType.IDENTIFIERS;}
	}
	
	
	/**
	 * Gets the isbns.
	 *
	 * @return the isbns
	 */
	public List<String> getIsbns() {
		return isbns;
	}		
	
	/**
	 * Sets the isbn.
	 *
	 * @param isbn the new isbn
	 */
	//** these all set the same isbn value... there is only one isbn getter.
	@JsonSetter("isbn")
	public void setIsbn(Object isbn) {
		if (this.isbns==null){
			this.isbns = new ArrayList<String>();
		}
		this.isbns.addAll(this.buildList(isbn));
		if (this.isbns.size()>0){this.opType=OtherPropertyType.ISBN;}
	}
	
	/**
	 * Sets the ISBN alt - this is an alternative isbn property that will be funneled to lower case "isbn".
	 *
	 * @param isbnAlt the new ISBN alt
	 */
	@JsonSetter("ISBN")
	public void setIsbnAlt(Object isbnAlt) {
		this.setIsbn(isbnAlt);
	}
	
	/**
	 * Sets the prints the ISBN - this is an alternative isbn property that will be funneled to lower case "isbn".
	 *
	 * @param printIsbn the new prints the isbn
	 */
	@JsonSetter("printIsbn")
	public void setPrintIsbn(Object printIsbn) {
		this.setIsbn(printIsbn);
	}
	
	
	
	/**
	 * Gets the EISBN.
	 *
	 * @return the EISBN
	 */
	public List<String> getEisbn() {
		return this.eisbns;
	}
	
	/**
	 * Sets the EISBNs.
	 *
	 * @param eisbn the new EISBNs
	 */
	//These both set the same eisbn value - only one eisbn getter
	@JsonSetter("eisbn")
	public void setEisbns(Object eisbn) {
		if (this.eisbns==null){
			this.eisbns = new ArrayList<String>();
		}
		this.eisbns.addAll(buildList(eisbn));
		if (this.eisbns.size()>0){this.opType=OtherPropertyType.EISBN;}
	}
	
	/**
	 * Sets the electronic isbn.
	 *
	 * @param eisbns the new electronic isbn
	 */
	@JsonSetter("electronicIsbn")
	public void setElectronicIsbn(Object eisbns) {
		this.setEisbns(eisbns);
	}
	
		
	/**
	 * Gets the issns.
	 *
	 * @return the issns
	 */
	public List<String> getIssns() {
		return issns;
	}
	
	/**
	 * Sets the issn.
	 *
	 * @param issn the new issn
	 */
	//These both set the same issn value - only one issn getter
	@JsonSetter("issn")
	public void setIssn(Object issn) {
		if (issns==null){
			issns = new ArrayList<String>();
		}
		issns.addAll(buildList(issn));
		if (issns.size()>0){this.opType=OtherPropertyType.ISSN;}
	}
	
	/**
	 * Sets the ISSN alt - this is an alternative issn property that will be funneled to lower case "issn".
	 *
	 * @param issnAlt the new ISSN alt
	 */
	@JsonSetter("ISSN")
	public void setIssnAlt(Object issnAlt) {
		this.setIssn(issnAlt);
	}
	
	
	
	/**
	 * Gets the EISSN.
	 *
	 * @return the EISSN
	 */
	public List<String> getEissns() {
		return this.eissns;
	}
	
	/**
	 * Sets the EISSNs.
	 *
	 * @param eissn the new EISSNs
	 */
	@JsonSetter("eissn")
	public void setEissns(Object eissn) {
		if (this.eissns==null){
			this.eissns = new ArrayList<String>();
		}
		this.eissns.addAll(this.buildList(eissn));
		if (this.eissns.size()>0){this.opType=OtherPropertyType.EISSN;}
	}
		
	
	
	/**
	 * Gets the links.
	 *
	 * @return the links
	 */
	public List<String> getLinks() {
		return links;
	}
	
	/**
	 * Sets the links.
	 *
	 * @param links the new links
	 */
	@JsonSetter("links")
	public void setLinks(Object links) {
		this.setLink(links);
	}	
	
	/**
	 * Sets the link.
	 *
	 * @param link the new link
	 */
	@JsonSetter("link")
	public void setLink(Object link) {
		if (this.links==null){
			this.links = new ArrayList<String>();
		}
		this.links.addAll(this.buildList(link));
		if (this.links.size()>0){this.opType=OtherPropertyType.LINKS;}
	}
	
	
	
	/**
	 * Gets the relations.
	 *
	 * @return the relations
	 */
	public List<String> getRelations() {
		return relations;
	}
	
	/**
	 * Sets the relation.
	 *
	 * @param relation the new relation
	 */
	@JsonSetter("relation")
	public void setRelation(Object relation){
		setRelations(relation);
	}
	
	/**
	 * Sets the relations.
	 *
	 * @param relations the new relations
	 */
	@JsonSetter("relations")
	public void setRelations(Object relations) {
		if (this.relations==null){
			this.relations = new ArrayList<String>();
		}
		this.relations.addAll(this.buildList(relations));
		if (this.relations.size()>0){this.opType=OtherPropertyType.RELATIONS;}
	}
		
	
	/**
	 * Gets the types.
	 *
	 * @return the types
	 */
	public List<String> getTypes() {
		return types;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	@JsonSetter("type")
	public void setType(Object type) {
		this.setTypes(type);
	}
	
	/**
	 * Sets the types.
	 *
	 * @param types the new types
	 */
	@JsonSetter("types")
	public void setTypes(Object types) {
	if (this.types==null){
		this.types = new ArrayList<String>();
	}
	this.types.addAll(this.buildList(types));
	if (this.types.size()>0){this.opType=OtherPropertyType.TYPES;}
	}
	
		
	/**
	 * Gets the other property type.
	 *
	 * @return the other property type
	 */
	public OtherPropertyType getOtherPropertyType(){
		return this.opType;
	}	

	/**
	 * Builds string list from Object containing either a String or a List<String>. 
	 * Removes empty/null and returns as new List<String>.
	 *
	 * @param val the property val
	 * @return the list
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
