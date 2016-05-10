package info.rmapproject.cos.share.client.model;

import info.rmapproject.cos.share.client.utils.Utils;

import java.net.URI;

/**
 * SHARE Award details
 * @author khanson
 *
 */
public class Award {

	URI awardIdentifier;
	String awardName;
	
	public URI getAwardIdentifier() {
		return awardIdentifier;
	}
	public void setAwardIdentifier(String awardIdentifier) {
		this.awardIdentifier = Utils.convertStringToUri(awardIdentifier);
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		awardName = Utils.setEmptyToNull(awardName);
		this.awardName = awardName;
	}
	
	
	
	
}
