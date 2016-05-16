package info.rmapproject.cos.share.client.model;

import info.rmapproject.cos.share.client.utils.Utils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
/**
 * SHARE URI Details
 * @author khanson
 *
 */
public class Uris {
	private List<URI> providerUris;
	private List<URI> descriptorUris;
	private List<URI> objectUris;
	private List<URI> canonicalUris;
	
	public List<URI> getCanonicalUris() {
		return canonicalUris;
	}
	public void setCanonicalUri(Object uri) {
		if (uri instanceof String){
			String canonicalUri = (String) uri;
			
			canonicalUri = Utils.setEmptyToNull(canonicalUri);
			if (canonicalUri==null){
				throw new RuntimeException("Value for canonicalUri cannot be null. Record cannot be created");
			}	
			this.canonicalUris = new ArrayList<URI>();
			this.canonicalUris.add(Utils.convertStringToUri(canonicalUri));
		}
		else{
			@SuppressWarnings("unchecked")
			List<String> canonicalUriList = (List<String>) uri;
			this.canonicalUris = Utils.convertStringListToUris(canonicalUriList);
		}
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
