package stark.foe.foeapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stark.foe.foeapi.model.GreatBuilding;

@Repository
public interface GreatBuildingRepository extends CrudRepository<GreatBuilding, Long> {

	public Iterable<GreatBuilding> findByAge(Long id);

}
