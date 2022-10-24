package stark.foe.foewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import stark.foe.foewebapp.model.GreatBuilding;
import stark.foe.foewebapp.repository.GreatBuildingProxy;

@Data
@Service
public class GreatBuildingService {

	@Autowired
	private GreatBuildingProxy proxy;
	
	public GreatBuilding getGreatBuildingById(final Long id) {
		return proxy.getGreatBuildingById(id);
	}
	
	public Iterable<GreatBuilding> getGreatBuildings() {
		return proxy.getGreatBuildings();
	}
	
	public Iterable<GreatBuilding> getGreatBuildingsByAge(final Long id) {
		return proxy.getGreatBuildingsByAge(id);
	}
	
//	public void deleteGreatBuilding(final Long id) {
//		proxy.deleteGreatBuilding(id);
//	}
//	
//	public GreatBuilding saveGreatBuilding(GreatBuilding greatBuilding) {
//		GreatBuilding savedGreatBuilding;
//		if(greatBuilding.getId() == null) {
//			savedGreatBuilding = proxy.createGreatBuilding(greatBuilding);
//		} else {
//			savedGreatBuilding = proxy.updateGreatBuilding(greatBuilding);
//		}
//		return savedGreatBuilding;
//	}
}
