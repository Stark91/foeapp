package stark.foe.foeapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stark.foe.foeapi.model.Age;

@Repository
public interface AgeRepository extends CrudRepository<Age, Long> {
	
}