package info.rmapproject.cos.share.client.model;


/**
 * SHARE's shareProperties details to reflect JSON
 * @author khanson
 *
 */
public class ShareProperties {

	/**
	 * source of data
	 */
	private String source;
	/**
	 * type of source file
	 */
	private String fileType;
	/**
	 * document ID
	 */
	private String docId;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getDocId() {
		return docId;
	}
	public void setDocId(String docId) {
		this.docId = docId;
	}
	
	
}
