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
package info.rmapproject.cos.share.client.service;

import info.rmapproject.cos.share.client.model.Record;
import info.rmapproject.cos.share.client.model.ResultsPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Retrieves API results from SHARE using parameters provided and then allows iteration over results using
 * next() method. When it reaches the end of the current list of records, it will retrieve more by incrementing the page
 * number and doing a new request.  If it runs out of records, null will be returned.
 * @author khanson
 *
 */
public class ShareApiIterator {

    /** The log. */
    protected static final Logger log = LoggerFactory.getLogger(ShareApiIterator.class);
	
	/** The API term for the size parameter. */
	private static final String SIZE_PARAM = "size";

	/** The API term for the from parameter. */
	private static final String FROM_PARAM = "from";
	
	/** The default from param value. */
	private static final Integer FROM_DEFAULT = 0;

	/** The default size param value. */
	private static final Integer SIZE_DEFAULT = 30;
	
    /** Base URL for API calls. */
    private static final String BASE_URL = "https://osf.io/api/v1/share/";
    
    /**  SHARE retrofit service*. */
	private ShareRetrofitService sharesvc = null;
	
	/**  search params*. */
	private Map<String, String> params = null;

	/** current list of records loaded corresponds to single page of results. */
	private List<Record> records = null;
	
	/** position of last record retrieve in current List<Record> records. */
	private Integer position = -1;
	
	/**  size parameter used to build list *. */
	private Integer size = SIZE_DEFAULT;	
	
	/**  size parameter used to build list *. */
	private Integer from = FROM_DEFAULT;
	
	/**
	 * Total number of records that match the query. This is irrespective of the size and from 
	 * parameters - the results span across multiple pages.
	 */
	private Integer totalRecordCount = 0;
    
	/**
	 * Initiates Retrofit service, sets defaults.
	 *
	 * @param params the params
	 * @throws Exception the exception
	 */
    public ShareApiIterator(Map<String,String> params) throws Exception{
		//create client
        ObjectMapper mapper = new ObjectMapper();
        Retrofit retrofit = new Retrofit.Builder()
			                .baseUrl(BASE_URL)
			                .addConverterFactory(JacksonConverterFactory.create(mapper))
			                .build();        
        sharesvc = retrofit.create(ShareRetrofitService.class);    	
		
		if(params.containsKey(FROM_PARAM)){
			from = Integer.parseInt(params.get(FROM_PARAM));	 
		}
		if(params.containsKey(SIZE_PARAM)){
			size = Integer.parseInt(params.get(SIZE_PARAM));	 
		}
		params.put(FROM_PARAM, from.toString());
		params.put(SIZE_PARAM, size.toString());
        this.params = params;

        loadNextBatch(); //loads first record batch into memory         
    }
    
    /**
     * Retrieves next record from the SHARE API, retrieves more records as needed
     * returns null when no more records founds.
     *
     * @return the record
     */
    public Record next() {
    	if (records==null){
    		throw new RuntimeException("Records failed to load on initiation");
    	}

    	if (!hasNext()) { //no more records in resultset 
    		log.info("No more records left to retrieve for this SHARE API query");
    		return null;  		//no more records to retrieve.
    	}
    	
        position=position+1;    		
    	
    	if (position == size){ 
    		// we have reached the last record in the current list, get more
    		position=0;
    		loadNextBatch(); //loads batch into memory
    		if (totalRecordCount==0){
    			//no records retrieved
    			throw new RuntimeException("No matching records found.");
    		}
    	}
		return records.get(position);
    }
    
    /**
     * Get new batch of Records from SHARE API - used to initiate list or get new page of results to refill list.
     */
    private void loadNextBatch() {
		if (records!=null) { //it's not the first batch request
			//increment "from" parameter
    		from = from + size;
    		params.put(FROM_PARAM, from.toString());
        }

		Integer prevRecordCount = totalRecordCount;
		
        ResultsPage results = null;
        try {
        	Call<ResultsPage> listCall = sharesvc.recordList(params);
        	Response<ResultsPage> res = listCall.execute();			
			if (!res.isSuccessful()) {
			    log.error(res.errorBody().string());
				throw new RuntimeException(res.errorBody().string());
			} else {
				results = res.body();
			}
			
		} catch (IOException e) {
    		log.error("Could not retrieve records from SHARE API");
			throw new RuntimeException("Could not retrieve records from SHARE API", e);
		}

		records = results.getRecords();
		totalRecordCount = results.getCount();
		
		if (prevRecordCount>0 && !totalRecordCount.equals(prevRecordCount)){
			log.warn("The SHARE database has been updated during this process.  Previously there were " 
						+ prevRecordCount + " records, now there are " + totalRecordCount);
		}
    }
    
    /**
     * Gets the total record count.
     *
     * @return the total record count
     */
    public Integer getTotalRecordCount(){
    	return totalRecordCount;
    }
    
    /**
     * Will return current Record list (or null if there isn't one) - lists are 30 records long by default 
     * unless a different size has been defined in the params
     * Using next() will automatically paginate, but this procedure allows you to disconnect 
     * the record list from the Iterator.
     *
     * @return the current record list
     */
   public List<Record> getCurrentRecordList(){
	   return records;
   }
    
    /**
     * Checks for next.
     *
     * @return true, if successful
     */
    public boolean hasNext(){
    	if (totalRecordCount>(from+position+1)){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
}
