package stark.foe.foeapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import stark.foe.foeapi.model.GreatBuildingBoost;
import stark.foe.foeapi.repository.GreatBuildingBoostRepository;

@Data
@Service
public class GreatBuildingBoostService {

	@Autowired
	private GreatBuildingBoostRepository greatBuildingBoostRepository;
	
	public Optional<GreatBuildingBoost> getGreatBuildingBoost(final Long id) {
		return greatBuildingBoostRepository.findById(id);
	}
	
	public Iterable<GreatBuildingBoost> getGreatBuildingBoosts() {
		return greatBuildingBoostRepository.findAll();
	}
	
	public void deleteGreatBuildingBoost(final Long id) {
		greatBuildingBoostRepository.deleteById(id);
	}
	
	public GreatBuildingBoost saveGreatBuildingBoost(GreatBuildingBoost greatBuildingBoost) {
		GreatBuildingBoost savedGreatBuildingBoost = greatBuildingBoostRepository.save(greatBuildingBoost);
		return savedGreatBuildingBoost;
	}
}
