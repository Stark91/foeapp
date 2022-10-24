package stark.foe.foewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import stark.foe.foewebapp.model.GreatBuildingBoost;
import stark.foe.foewebapp.repository.GreatBuildingBoostProxy;

@Data
@Service
public class GreatBuildingBoostService {

	@Autowired
	private GreatBuildingBoostProxy proxy;
	
	public GreatBuildingBoost getGreatBuildingBoost(final Long id) {
		return proxy.getGreatBuildingBoost(id);
	}
	
	public Iterable<GreatBuildingBoost> getGreatBuildingBoosts() {
		return proxy.getGreatBuildingBoosts();
	}
	
	public void deleteGreatBuildingBoost(final Long id) {
		proxy.deleteGreatBuildingBoost(id);
	}
	
	public GreatBuildingBoost saveGreatBuildingBoost(GreatBuildingBoost greatBuildingBoost) {
		GreatBuildingBoost savedGreatBuildingBoost;
		if(greatBuildingBoost.getId() == null) {
			savedGreatBuildingBoost = proxy.createGreatBuildingBoost(greatBuildingBoost);
		} else {
			savedGreatBuildingBoost = proxy.updateGreatBuildingBoost(greatBuildingBoost);
		}
		return savedGreatBuildingBoost;
	}
}
