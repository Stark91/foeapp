package stark.foe.foeapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import stark.foe.foeapi.model.Age;
import stark.foe.foeapi.repository.AgeRepository;

@Data
@Service
public class AgeService {

	
	@Autowired
	private AgeRepository ageRepository;
	
	public Optional<Age> getAge(final Long id) {
		return ageRepository.findById(id);
	}
	
	public Iterable<Age> getAges() {
		return ageRepository.findAll();
	}
	
	public void deleteAge(final Long id) {
		ageRepository.deleteById(id);
	}
	
	public Age saveAge(Age age) {
		Age savedAge = ageRepository.save(age);
		return savedAge;
	}
}
