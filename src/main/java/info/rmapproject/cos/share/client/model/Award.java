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

/**
 * SHARE Award details.
 *
 * @author khanson
 */
public class Award {

	/** The award identifier. */
	URI awardIdentifier;
	
	/** The award name. */
	String awardName;
	
	/**
	 * Gets the award identifier.
	 *
	 * @return the award identifier
	 */
	public URI getAwardIdentifier() {
		return awardIdentifier;
	}
	
	/**
	 * Sets the award identifier.
	 *
	 * @param awardIdentifier the new award identifier
	 */
	public void setAwardIdentifier(String awardIdentifier) {
		this.awardIdentifier = Utils.convertStringToUri(awardIdentifier);
	}
	
	/**
	 * Gets the award name.
	 *
	 * @return the award name
	 */
	public String getAwardName() {
		return awardName;
	}
	
	/**
	 * Sets the award name.
	 *
	 * @param awardName the new award name
	 */
	public void setAwardName(String awardName) {
		awardName = Utils.setEmptyToNull(awardName);
		this.awardName = awardName;
	}
	
	
	
	
}
