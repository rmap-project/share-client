package info.rmapproject.cos.share.client.model;

import info.rmapproject.cos.share.client.utils.Utils;

import java.net.URI;

/**
 * SHARE Version details
 * @author khanson
 *
 */
public class Version {

	String versionId;
	URI versionOf;
	
	public String getVersionId() {
		return versionId;
	}
	public void setVersionId(String versionId) {
		versionId = Utils.setEmptyToNull(versionId);
		this.versionId = versionId;
	}
	public URI getVersionOf() {
		return versionOf;
	}
	public void setVersionOf(String versionOf) {
		this.versionOf = Utils.convertStringToUri(versionOf);
	}
		

	
}
