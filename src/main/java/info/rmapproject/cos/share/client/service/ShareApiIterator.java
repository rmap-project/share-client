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

    protected static final Logger log = LoggerFactory.getLogger(ShareApiIterator.class);
	
	private static final String SIZE_PARAM = "size";
	private static final String FROM_PARAM = "from";
	private static final Integer FROM_DEFAULT = 1;
	private static final Integer SIZE_DEFAULT = 30;
	
    /**Base URL for API calls**/
    private static final String BASE_URL = "https://osf.io/api/v1/share/";
    
    /** SHARE retrofit service**/
	private ShareRetrofitService sharesvc = null;
	
	/** search params**/
	private Map<String, String> params = null;

	/**current list of records loaded corresponds to single page of results*/
	private List<Record> records = null;
	
	/**position of last record retrieve in current List<Record> records*/
	private Integer position = 0;
	
	/** size parameter used to build list **/
	private Integer size = SIZE_DEFAULT;	
	
	/** size parameter used to build list **/
	private Integer from = FROM_DEFAULT;
	
	/**
	 * Total number of records that match the query. This is irrespective of the size and from 
	 * parameters - the results span across multiple pages.
	 */
	private Integer totalRecordCount = 0;
    
	/** 
	 * Initiates Retrofit service, sets defaults
	 * @param params
	 * @throws Exception
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
     * returns null when no more records founds
     * @return
     * @throws Exception
     */
    public Record next() throws Exception {
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
     * @return
     * @throws Exception
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
    
    public Integer getTotalRecordCount(){
    	return totalRecordCount;
    }
    
    public boolean hasNext(){
    	if (totalRecordCount>(from+position)){
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
}
