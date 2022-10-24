package stark.foe.foeapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import stark.foe.foeapi.model.Age;
import stark.foe.foeapi.service.AgeService;

@RestController
public class AgeController {

	@Autowired
	private AgeService ageService;
	
	@PostMapping("/age")
	public Age createAge(@RequestBody Age age) {
		return ageService.saveAge(age);
	}
	
	@GetMapping("/age/{id}")
	public Age getAge(@PathVariable("id") final Long id) {
		Optional<Age> age = ageService.getAge(id);
		if(age.isPresent()) {
			return age.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/ages")
	public Iterable<Age> getAges() {
		return ageService.getAges();
	}
	
	@PutMapping("/age/{id}")
	public Age updateAge(@PathVariable("id") final Long id, @RequestBody Age age) {
		Optional<Age> a = ageService.getAge(id);
		if(a.isPresent()) {
			Age currentAge = a.get();
			String name = age.getName();
			if(name != null) {
				currentAge.setName(name);
			}
			ageService.saveAge(currentAge);
			return currentAge;
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/age/{id}")
	public void deleteAge(@PathVariable("id") final Long id) {
		ageService.deleteAge(id);
	}
}
