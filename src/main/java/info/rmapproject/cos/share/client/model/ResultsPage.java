package info.rmapproject.cos.share.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
/**
 * SHARE API results page composed of list of results
 * @author khanson
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("results")
public class ResultsPage {
	
	/** list of records form SHARE API - represents one page of data**/
	@JsonProperty("results")
    private List<Record> records;
	
	/** number of records in set**/
	@JsonProperty("count")
	private Integer count;

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}
