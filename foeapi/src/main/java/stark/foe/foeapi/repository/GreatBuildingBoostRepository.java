package stark.foe.foeapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stark.foe.foeapi.model.GreatBuildingBoost;

@Repository
public interface GreatBuildingBoostRepository extends CrudRepository<GreatBuildingBoost, Long> {

}
