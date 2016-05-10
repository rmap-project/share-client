package info.rmapproject.cos.share.client.model;

/**
 * SHARE Sponsorship details
 * @author khanson
 *
 */
public class Sponsorship {

	private Sponsor sponsor;
	private Award award;
	
	public Sponsor getSponsor() {
		return sponsor;
	}
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	public Award getAward() {
		return award;
	}
	public void setAward(Award award) {
		this.award = award;
	}
	
	public boolean hasAwardInfo(){
		if (this.award!=null){
			if (award.getAwardIdentifier()!=null || award.getAwardName()!=null){
				return true;
			}
		}
		return false;
	}	
	
	public boolean hasSponsorInfo(){
		if (this.sponsor!=null){
			if (this.sponsor.getSponsorIdentifier()!=null || this.sponsor.getSponsorName()!=null){
				return true;
			}
		}
		return false;
	}
	
	
	
}
