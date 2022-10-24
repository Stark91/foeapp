package stark.foe.foewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import stark.foe.foewebapp.model.GreatBuildingReward;
import stark.foe.foewebapp.repository.GreatBuildingRewardProxy;

@Data
@Service
public class GreatBuildingRewardService {

	@Autowired
	private GreatBuildingRewardProxy proxy;
	
	public GreatBuildingReward getGreatBuildingReward(final Long id) {
		return proxy.getGreatBuildingReward(id);
	}
	
	public Iterable<GreatBuildingReward> getGreatBuildingRewards() {
		return proxy.getGreatBuildingRewards();
	}
	
	public void deleteGreatBuildingReward(final Long id) {
		proxy.deleteGreatBuildingReward(id);
	}
	
	public GreatBuildingReward saveGreatBuildingReward(GreatBuildingReward greatBuildingReward) {
		GreatBuildingReward savedGreatBuildingReward;
		if(greatBuildingReward.getId() == null) {
			savedGreatBuildingReward = proxy.createGreatBuildingReward(greatBuildingReward);
		} else {
			savedGreatBuildingReward = proxy.updateGreatBuildingReward(greatBuildingReward);
		}
		return savedGreatBuildingReward;
	}
}
