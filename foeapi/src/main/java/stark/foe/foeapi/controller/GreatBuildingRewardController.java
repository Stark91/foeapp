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
import stark.foe.foeapi.model.GreatBuildingReward;
import stark.foe.foeapi.service.GreatBuildingRewardService;

@RestController
public class GreatBuildingRewardController {

	@Autowired
	private GreatBuildingRewardService greatBuildingRewardService;
	
	@PostMapping("/greatbuildingreward")
	public GreatBuildingReward createGreatBuildingReward(@RequestBody GreatBuildingReward greatBuildingReward) {
		return greatBuildingRewardService.saveGreatBuildingReward(greatBuildingReward);
	}
	
	@GetMapping("/greatbuildingreward/{id}")
	public GreatBuildingReward getGreatBuildingReward(@PathVariable("id") final Long id) {
		Optional<GreatBuildingReward> greatBuildingReward = greatBuildingRewardService.getGreatBuildingReward(id);
		if(greatBuildingReward.isPresent()) {
			return greatBuildingReward.get();
		} else {
			return null;
		}
	}
	
	@GetMapping("/greatbuildingrewards")
	public Iterable<GreatBuildingReward> getGreatBuildingRewards() {
		return greatBuildingRewardService.getGreatBuildingRewards();
	}
	
	@PutMapping("/greatbuildingreward/{id}")
	public GreatBuildingReward updateGreatBuildingReward(@PathVariable("id") final Long id, @RequestBody GreatBuildingReward greatBuildingReward) {
		Optional<GreatBuildingReward> reward = greatBuildingRewardService.getGreatBuildingReward(id);
		if(reward.isPresent()) {
			GreatBuildingReward currentGreatBuildingReward = reward.get();
			Age age = greatBuildingReward.getAge();
			if(age != null) {
				currentGreatBuildingReward.setAge(age);
			}
			int level = greatBuildingReward.getLevel();
			if(level >= 0) {
				currentGreatBuildingReward.setLevel(level);
			}
			int total = greatBuildingReward.getTotal();
			if(total >= 0) {
				currentGreatBuildingReward.setTotal(total);
			}
			int p1 = greatBuildingReward.getP1();
			if(p1 >= 0) {
				currentGreatBuildingReward.setP1(p1);
			}
			int p2 = greatBuildingReward.getP2();
			if(p2 >= 0) {
				currentGreatBuildingReward.setP2(p2);
			}
			int p3 = greatBuildingReward.getP3();
			if(p3 >= 0) {
				currentGreatBuildingReward.setP3(p3);
			}
			int p4 = greatBuildingReward.getP4();
			if(p4 >= 0) {
				currentGreatBuildingReward.setP4(p4);
			}
			int p5 = greatBuildingReward.getP5();
			if(p5 >= 0) {
				currentGreatBuildingReward.setP5(p5);
			}
			return currentGreatBuildingReward;
		} else {
			return null;
		}
	}
	
	@DeleteMapping("/greatbuildingreward/{id}")
	public void deleteGreatBuildingReward(@PathVariable("id") final Long id) {
		greatBuildingRewardService.deleteGreatBuildingReward(id);
	}
}
