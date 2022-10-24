package stark.foe.foeapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stark.foe.foeapi.model.GreatBuildingReward;

@Repository
public interface GreatBuildingRewardRepository extends CrudRepository<GreatBuildingReward, Long> {

}
