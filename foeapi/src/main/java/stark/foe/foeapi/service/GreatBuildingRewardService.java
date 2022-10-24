package stark.foe.foeapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import stark.foe.foeapi.model.GreatBuildingReward;
import stark.foe.foeapi.repository.GreatBuildingRewardRepository;

@Data
@Service
public class GreatBuildingRewardService {

	@Autowired
	private GreatBuildingRewardRepository greatBuildingRewardRepository;
	
	public Optional<GreatBuildingReward> getGreatBuildingReward(final Long id) {
		return greatBuildingRewardRepository.findById(id);
	}
	
	public Iterable<GreatBuildingReward> getGreatBuildingRewards() {
		return greatBuildingRewardRepository.findAll();
	}
	
	public void deleteGreatBuildingReward(final Long id) {
		greatBuildingRewardRepository.deleteById(id);
	}
	
	public GreatBuildingReward saveGreatBuildingReward(GreatBuildingReward greatBuildingReward) {
		GreatBuildingReward savedGreatBuildingReward = greatBuildingRewardRepository.save(greatBuildingReward);
		return savedGreatBuildingReward;
	}
}
