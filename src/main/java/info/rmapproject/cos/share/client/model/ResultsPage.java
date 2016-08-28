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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * SHARE API results page composed of list of results.
 *
 * @author khanson
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("results")
public class ResultsPage {
	
	/**  list of records form SHARE API - represents one page of data*. */
	@JsonProperty("results")
    private List<Record> records;
	
	/**  number of records in set*. */
	@JsonProperty("count")
	private Integer count;

    /**
     * Gets the records.
     *
     * @return the records
     */
    public List<Record> getRecords() {
        return records;
    }

    /**
     * Sets the records.
     *
     * @param records the new records
     */
    public void setRecords(List<Record> records) {
        this.records = records;
    }

	/**
	 * Gets the record count.
	 *
	 * @return the number of records
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * Sets the record count.
	 *
	 * @param count the new number of records
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
