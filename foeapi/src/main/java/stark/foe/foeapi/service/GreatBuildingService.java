package stark.foe.foeapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import stark.foe.foeapi.model.GreatBuilding;
import stark.foe.foeapi.repository.GreatBuildingRepository;

@Data
@Service
public class GreatBuildingService {

	@Autowired
	private GreatBuildingRepository greatBuildingRepository;
	
	public Optional<GreatBuilding> getGreatBuildingById(final Long id) {
		return greatBuildingRepository.findById(id);
	}
	
	public Iterable<GreatBuilding> getGreatBuildings() {
		return greatBuildingRepository.findAll();
	}
	
	public Iterable<GreatBuilding> getGreatBuildingsByAge(final Long id) {
		return greatBuildingRepository.findByAge(id);
	}
	
	public void deleteGreatBuilding(final Long id) {
		greatBuildingRepository.deleteById(id);
	}
	
	public GreatBuilding saveGreatBuilding(GreatBuilding greatBuilding) {
		GreatBuilding savedGreatBuilding = greatBuildingRepository.save(greatBuilding);
		return savedGreatBuilding;
	}
}
