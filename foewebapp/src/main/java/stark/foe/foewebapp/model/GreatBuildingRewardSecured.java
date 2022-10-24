package stark.foe.foewebapp.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class GreatBuildingRewardSecured {

	private GreatBuildingReward reward;
	private int fpToSecure;
	
	public ArrayList<Integer> getArrayFpToSecure() {
		ArrayList<Integer> fpToSecure = new ArrayList<>();
		if(this.reward.getTotal()-2*this.reward.getP1() < 0) {
			fpToSecure.add(0);
		} else {
			fpToSecure.add(this.reward.getTotal()-2*this.reward.getP1());
		}
		
		if(this.reward.getTotal()-this.reward.getP1()-fpToSecure.get(0)-2*this.reward.getP2() < 0) {
			fpToSecure.add(0);
		} else {
			fpToSecure.add(this.reward.getTotal()-this.reward.getP1()-fpToSecure.get(0)-2*this.reward.getP2());
		}
		
		if(this.reward.getTotal()-this.reward.getP1()-fpToSecure.get(0)-this.reward.getP2()-fpToSecure.get(1)-2*this.reward.getP3() < 0) {
			fpToSecure.add(0);
		} else {
			fpToSecure.add(this.reward.getTotal()-this.reward.getP1()-fpToSecure.get(0)-this.reward.getP2()-fpToSecure.get(1)-2*this.reward.getP3());
		}
		
		if(this.reward.getTotal()-this.reward.getP1()-fpToSecure.get(0)-this.reward.getP2()-fpToSecure.get(1)-this.reward.getP3()-fpToSecure.get(2)-2*this.reward.getP4() < 0) {
			fpToSecure.add(0);
		} else {
			fpToSecure.add(this.reward.getTotal()-this.reward.getP1()-fpToSecure.get(0)-this.reward.getP2()-fpToSecure.get(1)-this.reward.getP3()-fpToSecure.get(2)-2*this.reward.getP4());
		}
		
		if(this.reward.getTotal()-this.reward.getP1()-fpToSecure.get(0)-this.reward.getP2()-fpToSecure.get(1)-this.reward.getP3()-fpToSecure.get(2)-this.reward.getP4()-fpToSecure.get(3)-2*this.reward.getP5() < 0) {
			fpToSecure.add(0);
		} else {
			fpToSecure.add(this.reward.getTotal()-this.reward.getP1()-fpToSecure.get(0)-this.reward.getP2()-fpToSecure.get(1)-this.reward.getP3()-fpToSecure.get(2)-this.reward.getP4()-fpToSecure.get(3)-2*this.reward.getP5());
		}
		
		return fpToSecure;
	}
}
