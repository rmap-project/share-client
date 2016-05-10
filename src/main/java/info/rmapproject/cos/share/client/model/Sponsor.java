package info.rmapproject.cos.share.client.model;

import info.rmapproject.cos.share.client.utils.Utils;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * SHARE Sponsor details
 * @author khanson
 *
 */
public class Sponsor {

	URI sponsorIdentifier;
	String sponsorName;
	
	public URI getSponsorIdentifier() {
		return sponsorIdentifier;
	}
	public void setSponsorIdentifier(String sponsorIdentifier) {
		sponsorIdentifier = Utils.setEmptyToNull(sponsorIdentifier);
		if (sponsorIdentifier!=null){
			try {
				this.sponsorIdentifier = new URI(sponsorIdentifier);
			} catch (URISyntaxException e) {
				throw new RuntimeException("Value for sponsorIdentifier is not a valid URI.", e);
			}
		} else {
			this.sponsorIdentifier =null;
		}
	}
	public String getSponsorName() {
		return sponsorName;
	}
	public void setSponsorName(String sponsorName) {
		sponsorName = Utils.setEmptyToNull(sponsorName);
		this.sponsorName = sponsorName;
	}	
	
}
