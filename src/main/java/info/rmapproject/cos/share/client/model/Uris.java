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

/**
 * SHARE URI Details.
 *
 * @author khanson
 */
public class Uris {
	
	/** The provider uris. */
	private List<URI> providerUris;
	
	/** The descriptor uris. */
	private List<URI> descriptorUris;
	
	/** The object uris. */
	private List<URI> objectUris;
	
	/** The canonical uris. */
	private List<URI> canonicalUris;
	
	/**
	 * Gets the canonical uris.
	 *
	 * @return the canonical uris
	 */
	public List<URI> getCanonicalUris() {
		return canonicalUris;
	}
	
	/**
	 * Sets the canonical uri.
	 *
	 * @param uri the new canonical uri
	 */
	public void setCanonicalUri(Object uri) {
		if (uri instanceof String){
			String canonicalUri = (String) uri;
			
			canonicalUri = Utils.setEmptyToNull(canonicalUri);
			if (canonicalUri==null){
				throw new RuntimeException("Value for canonicalUri cannot be null. Record cannot be created");
			}	
			this.canonicalUris = new ArrayList<URI>();
			this.canonicalUris.add(Utils.convertStringToUri(canonicalUri));
		}
		else{
			@SuppressWarnings("unchecked")
			List<String> canonicalUriList = (List<String>) uri;
			this.canonicalUris = Utils.convertStringListToUris(canonicalUriList);
		}
	}

	/**
	 * Gets the provider uris.
	 *
	 * @return the provider uris
	 */
	public List<URI> getProviderUris() {
		return providerUris;
	}
	
	/**
	 * Sets the provider uris.
	 *
	 * @param providerUris the new provider uris
	 */
	public void setProviderUris(List<String> providerUris) {
		this.providerUris = Utils.convertStringListToUris(providerUris);
	}
	
	/**
	 * Gets the descriptor uris.
	 *
	 * @return the descriptor uris
	 */
	public List<URI> getDescriptorUris() {
		return descriptorUris;
	}
	
	/**
	 * Sets the descriptor uris.
	 *
	 * @param descriptorUris the new descriptor uris
	 */
	public void setDescriptorUris(List<String> descriptorUris) {
		this.descriptorUris = Utils.convertStringListToUris(descriptorUris);
	}
	
	/**
	 * Gets the object uris.
	 *
	 * @return the object uris
	 */
	public List<URI> getObjectUris() {
		return objectUris;
	}
	
	/**
	 * Sets the object uris.
	 *
	 * @param objectUris the new object uris
	 */
	public void setObjectUris(List<String> objectUris) {
		this.objectUris = Utils.convertStringListToUris(objectUris);
	}
	
	
}
