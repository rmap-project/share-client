package info.rmapproject.cos.share.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * SHARE's shareProperties details to reflect JSON
 * @author khanson
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShareProperties {

	/**
	 * source of data
	 */
	private String source;
	/**
	 * type of source file
	 */
	private String filetype;
	/**
	 * document ID
	 */
	private String docID;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String fileType) {
		this.filetype = fileType;
	}
	public String getDocID() {
		return docID;
	}
	public void setDocID(String docID) {
		this.docID = docID;
	}
	
	
}
