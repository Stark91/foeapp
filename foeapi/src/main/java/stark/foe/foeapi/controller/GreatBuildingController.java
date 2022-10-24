package stark.foe.foeapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import stark.foe.foeapi.model.Age;
import stark.foe.foeapi.model.GreatBuilding;
//import stark.foe.foeapi.model.GreatBuildingBoost;
import stark.foe.foeapi.service.GreatBuildingService;

@RestController
public class GreatBuildingController {

	@Autowired
	private GreatBuildingService greatBuildingService;
	
	@GetMapping("/greatbuilding/{id}")
	public GreatBuilding getGreatBuildingById(@PathVariable("id") final Long id) {
		Optional<GreatBuilding> greatBuilding = greatBuildingService.getGreatBuildingById(id);
		if(greatBuilding.isPresent()) {
			return greatBuilding.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/greatbuildings")
	public Iterable<GreatBuilding> getGreatBuildings() {
		return greatBuildingService.getGreatBuildings();
	}
	
	@GetMapping("/greatbuildings/age/{id}")
	public Iterable<GreatBuilding> getGreatBuildingsByAge(@PathVariable("id") final Long id) {
		return greatBuildingService.getGreatBuildingsByAge(id);
	}
	
//	@PostMapping("/greatbuilding")
//	public GreatBuilding createGreatBuilding(@RequestBody GreatBuilding greatBuilding) {
//		return greatBuildingService.saveGreatBuilding(greatBuilding);
//	}
//	
//	@PutMapping("/greatbuilding/{id}")
//	public GreatBuilding updateGreatBuilding(@PathVariable("id") final Long id, @RequestBody GreatBuilding greatBuilding) {
//		Optional<GreatBuilding> gb = greatBuildingService.getGreatBuilding(id);
//		if(gb.isPresent()) {
//			GreatBuilding currentGreatBuilding = gb.get();
//			Age age = greatBuilding.getAge();
//			if(age != null) {
//				currentGreatBuilding.setAge(age);
//			}
//			GreatBuildingBoost boost1 = greatBuilding.getBoost1();
//			if(boost1 != null) {
//				currentGreatBuilding.setBoost1(boost1);
//			}
//			GreatBuildingBoost boost2 = greatBuilding.getBoost2();
//			if(boost2 != null) {
//				currentGreatBuilding.setBoost2(boost2);
//			}
//			String image = greatBuilding.getImage();
//			if(image != null) {
//				currentGreatBuilding.setImage(image);
//			}
//			String name = greatBuilding.getName();
//			if(name != null) {
//				currentGreatBuilding.setName(name);
//			}
//			String size = greatBuilding.getSize();
//			if(size != null) {
//				currentGreatBuilding.setSize(size);
//			}
//			return currentGreatBuilding;
//		} else {
//			return null;
//		}
//	}
//	
//	@DeleteMapping("/greatbuilding/{id}")
//	public void deleteGreatBuilding(@PathVariable("id") final Long id) {
//		greatBuildingService.deleteGreatBuilding(id);
//	}
}
