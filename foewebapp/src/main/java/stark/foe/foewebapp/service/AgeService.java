package stark.foe.foewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import stark.foe.foewebapp.model.Age;
import stark.foe.foewebapp.repository.AgeProxy;

@Data
@Service
public class AgeService {

	@Autowired
	private AgeProxy proxy;
	
	public Age getAge(final Long id) {
		return proxy.getAge(id);
	}
	
	public Iterable<Age> getAges() {
		return proxy.getAges();
	}
	
//	public void deleteAge(final Long id) {
//		proxy.deleteAge(id);
//	}
//	
//	public Age saveAge(Age age) {
//		Age savedAge;
//		if(age.getId() == null) {
//			savedAge = proxy.createAge(age);
//		} else {
//			savedAge = proxy.updateAge(age);
//		}
//		return savedAge;
//	}
}
