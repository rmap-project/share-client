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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * SHARE's shareProperties details to reflect JSON.
 *
 * @author khanson
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShareProperties {

	/** source of data. */
	private String source;
	
	/** type of source file. */
	private String filetype;
	
	/** document ID. */
	private String docID;
	
	/**
	 * Gets the data source.
	 *
	 * @return the data source
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * Sets the data source.
	 *
	 * @param source the new data source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Gets the filetype.
	 *
	 * @return the filetype
	 */
	public String getFiletype() {
		return filetype;
	}
	
	/**
	 * Sets the filetype.
	 *
	 * @param fileType the new filetype
	 */
	public void setFiletype(String fileType) {
		this.filetype = fileType;
	}
	
	/**
	 * Gets the doc ID.
	 *
	 * @return the doc ID
	 */
	public String getDocID() {
		return docID;
	}
	
	/**
	 * Sets the doc ID.
	 *
	 * @param docID the new doc ID
	 */
	public void setDocID(String docID) {
		this.docID = docID;
	}
	
	
}
