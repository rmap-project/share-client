package info.rmapproject.cos.share.client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("results")
public class RecordList {
	@JsonProperty("results")
    private List<Record> records;

    public List<Record> getRecords() {
        return records;
    }

    public void setList(List<Record> records) {
        this.records = records;
    }
}
