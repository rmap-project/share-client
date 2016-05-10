package info.rmapproject.cos.share.client.model;

import info.rmapproject.cos.share.client.utils.Utils;

import java.net.URI;
import java.util.List;
/**
 * SHARE URI Details
 * @author khanson
 *
 */
public class Uris {
	private URI canonicalUri;
	private List<URI> providerUris;
	private List<URI> descriptorUris;
	private List<URI> objectUris;
	
	public URI getCanonicalUri() {
		return canonicalUri;
	}
	public void setCanonicalUri(String canonicalUri) {
		canonicalUri = Utils.setEmptyToNull(canonicalUri);
		if (canonicalUri==null){
			throw new RuntimeException("Value for canonicalUri cannot be null. Record cannot be created");
		}		
		this.canonicalUri = Utils.convertStringToUri(canonicalUri);
	}
	public List<URI> getProviderUris() {
		return providerUris;
	}
	public void setProviderUris(List<String> providerUris) {
		this.providerUris = Utils.convertStringListToUris(providerUris);
	}
	public List<URI> getDescriptorUris() {
		return descriptorUris;
	}
	public void setDescriptorUris(List<String> descriptorUris) {
		this.descriptorUris = Utils.convertStringListToUris(descriptorUris);
	}
	public List<URI> getObjectUris() {
		return objectUris;
	}
	public void setObjectUris(List<String> objectUris) {
		this.objectUris = Utils.convertStringListToUris(objectUris);
	}
	
	
}
