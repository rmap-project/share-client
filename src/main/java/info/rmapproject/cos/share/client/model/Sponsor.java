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
import java.net.URISyntaxException;

/**
 * SHARE Sponsor details.
 *
 * @author khanson
 */
public class Sponsor {

	/** The sponsor identifier. */
	URI sponsorIdentifier;
	
	/** The sponsor name. */
	String sponsorName;
	
	/**
	 * Gets the sponsor identifier.
	 *
	 * @return the sponsor identifier
	 */
	public URI getSponsorIdentifier() {
		return sponsorIdentifier;
	}
	
	/**
	 * Sets the sponsor identifier.
	 *
	 * @param sponsorIdentifier the new sponsor identifier
	 */
	public void setSponsorIdentifier(String sponsorIdentifier) {
		sponsorIdentifier = Utils.setEmptyToNull(sponsorIdentifier);
		if (sponsorIdentifier!=null){
			try {
				this.sponsorIdentifier = new URI(sponsorIdentifier);
			} catch (URISyntaxException e) {
				throw new RuntimeException("Value for sponsorIdentifier is not a valid URI.", e);
			}
		} else {
			this.sponsorIdentifier =null;
		}
	}
	
	/**
	 * Gets the sponsor name.
	 *
	 * @return the sponsor name
	 */
	public String getSponsorName() {
		return sponsorName;
	}
	
	/**
	 * Sets the sponsor name.
	 *
	 * @param sponsorName the new sponsor name
	 */
	public void setSponsorName(String sponsorName) {
		sponsorName = Utils.setEmptyToNull(sponsorName);
		this.sponsorName = sponsorName;
	}	
	
}
