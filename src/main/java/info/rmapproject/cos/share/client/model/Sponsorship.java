/*******************************************************************************
 * Copyright 2016 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This software was produced as part of the RMap Project (http://rmap-project.info),
 * The RMap Project was funded by the Alfred P. Sloan Foundation and is a 
 * collaboration between Data Conservancy, Portico, and IEEE.
 *******************************************************************************/
package info.rmapproject.cos.share.client.model;

/**
 * SHARE Sponsorship details.
 *
 * @author khanson
 */
public class Sponsorship {

	/** The sponsor. */
	private Sponsor sponsor;
	
	/** The award. */
	private Award award;
	
	/**
	 * Gets the sponsor.
	 *
	 * @return the sponsor
	 */
	public Sponsor getSponsor() {
		return sponsor;
	}
	
	/**
	 * Sets the sponsor.
	 *
	 * @param sponsor the new sponsor
	 */
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}
	
	/**
	 * Gets the award.
	 *
	 * @return the award
	 */
	public Award getAward() {
		return award;
	}
	
	/**
	 * Sets the award.
	 *
	 * @param award the new award
	 */
	public void setAward(Award award) {
		this.award = award;
	}
	
	/**
	 * Checks for award info.
	 *
	 * @return true, if successful
	 */
	public boolean hasAwardInfo(){
		if (award!=null){
			if (award.getAwardIdentifier()!=null 
					|| (award.getAwardName()!=null&&award.getAwardName().length()>0)){
				return true;
			}
		}
		return false;
	}	
	
	/**
	 * Checks for sponsor info.
	 *
	 * @return true, if successful
	 */
	public boolean hasSponsorInfo(){
		if (sponsor!=null){
			if (sponsor.getSponsorIdentifier()!=null 
					|| (sponsor.getSponsorName()!=null&&sponsor.getSponsorName().length()>0)){
				return true;
			}
		}
		return false;
	}
	
	
	
}
