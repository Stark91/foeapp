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

import stark.foe.foeapi.model.GreatBuildingBoost;
import stark.foe.foeapi.service.GreatBuildingBoostService;

@RestController
public class GreatBuildingBoostController {

	@Autowired
	private GreatBuildingBoostService greatBuildingBoostService;
	
	@PostMapping("/greatbuildingboost")
	public GreatBuildingBoost createGreatBuildingBoost(@RequestBody GreatBuildingBoost greatBuildingBoost) {
		return greatBuildingBoostService.saveGreatBuildingBoost(greatBuildingBoost);
	}
	
	@GetMapping("/greatbuildingboost/{id}")
	public GreatBuildingBoost getGreatBuildingBoost(@PathVariable("id") final Long id) {
		Optional<GreatBuildingBoost> greatBuildingBoost = greatBuildingBoostService.getGreatBuildingBoost(id);
		if(greatBuildingBoost.isPresent()) {
			return greatBuildingBoost.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/greatbuildingboosts")
	public Iterable<GreatBuildingBoost> getGreatBuildingBoosts() {
		return greatBuildingBoostService.getGreatBuildingBoosts();
	}
	
	@PutMapping("/greatbuildingboost/{id}")
	public GreatBuildingBoost updateGreatBuildingBoost(@PathVariable("id") final Long id, @RequestBody GreatBuildingBoost greatBuildingBoost) {
		Optional<GreatBuildingBoost> boost = greatBuildingBoostService.getGreatBuildingBoost(id);
		if(boost.isPresent()) {
			GreatBuildingBoost currentGreatBuildingBoost = boost.get();
			String description = greatBuildingBoost.getDescription();
			if(description != null) {
				currentGreatBuildingBoost.setDescription(description);
			}
			String image = greatBuildingBoost.getImage();
			if(image != null) {
				currentGreatBuildingBoost.setImage(image);
			}
			String name = greatBuildingBoost.getName();
			if(name != null) {
				currentGreatBuildingBoost.setImage(name);
			}
			greatBuildingBoostService.saveGreatBuildingBoost(currentGreatBuildingBoost);
			return currentGreatBuildingBoost;
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/greatbuildingboost/{id}")
	public void deleteGreatBuildingBoost(@PathVariable("id") final Long id) {
		greatBuildingBoostService.deleteGreatBuildingBoost(id);
	}
}
