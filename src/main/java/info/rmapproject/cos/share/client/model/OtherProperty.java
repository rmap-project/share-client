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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Other properties in SHARE.
 *
 * @author khanson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OtherProperty {
	
	/** The property name. */
	private String name;
	
	/** The property values. */
	@JsonProperty("properties")
	private OtherPropertyValue properties;
	
	/** The property description. */
	private String description;
	
	/** The URI. */
	private URI uri;
	
	
	/**
	 * Instantiates a new other property.
	 */
	public OtherProperty(){}


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
		this.name = name;
	}


	/**
	 * Gets the properties.
	 *
	 * @return the properties
	 */
	public OtherPropertyValue getProperties() {
		return properties;
	}


	/**
	 * Sets the properties.
	 *
	 * @param properties the new properties
	 */
	public void setProperties(OtherPropertyValue properties) {
		this.properties = properties;
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
	 * Gets the URI.
	 *
	 * @return the URI
	 */
	public URI getUri() {
		return uri;
	}


	/**
	 * Sets the URI.
	 *
	 * @param uri the new URI
	 */
	public void setUri(String uri) {
		this.uri = Utils.convertStringToUri(uri);
	}

	
	
}
