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
 * SHARE Version details.
 *
 * @author khanson
 */
public class Version {

	/** The version id. */
	String versionId;
	
	/** The version of URI. */
	URI versionOf;
	
	/**
	 * Gets the version id.
	 *
	 * @return the version id
	 */
	public String getVersionId() {
		return versionId;
	}
	
	/**
	 * Sets the version id.
	 *
	 * @param versionId the new version id
	 */
	public void setVersionId(String versionId) {
		versionId = Utils.setEmptyToNull(versionId);
		this.versionId = versionId;
	}
	
	/**
	 * Gets the version of.
	 *
	 * @return the version of
	 */
	public URI getVersionOf() {
		return versionOf;
	}
	
	/**
	 * Sets the version of.
	 *
	 * @param versionOf the new version of
	 */
	public void setVersionOf(String versionOf) {
		this.versionOf = Utils.convertStringToUri(versionOf);
	}
		

	
}
