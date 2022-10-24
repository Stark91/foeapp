package stark.foe.foewebapp.controller;


import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Data;
import stark.foe.foewebapp.model.ArchBoost;
import stark.foe.foewebapp.model.GreatBuilding;
import stark.foe.foewebapp.model.GreatBuildingReward;
import stark.foe.foewebapp.model.GreatBuildingRewardSecured;
import stark.foe.foewebapp.model.Level;
import stark.foe.foewebapp.model.Line;
import stark.foe.foewebapp.model.Owner;
import stark.foe.foewebapp.model.Rush;
import stark.foe.foewebapp.model.Svg;
import stark.foe.foewebapp.service.GreatBuildingRewardService;
import stark.foe.foewebapp.service.GreatBuildingService;

@Data
@Controller
public class GreatBuildingController {

	@Autowired
	private GreatBuildingService service;
	
	@Autowired
	private GreatBuildingRewardService greatBuildingRewardService;

	@GetMapping("/greatbuildings")
	public String gbs(Model model) {
		Iterable<GreatBuilding> listGreatBuilding = service.getGreatBuildings();
		model.addAttribute("greatbuildings", listGreatBuilding);
		return "gbs";
	}

	@GetMapping("/greatbuildings/age/{id}")
	public String gbsAge(@PathVariable("id") final Long id, Model model) {
		Iterable<GreatBuilding> listGreatBuilding = service.getGreatBuildings();
		ArrayList<GreatBuilding> listGreatBuildingByAge = new ArrayList<>();
		for (GreatBuilding greatBuilding : listGreatBuilding) {
			if(greatBuilding.getAge().getId() == id) {
				listGreatBuildingByAge.add(greatBuilding);
			}
		}
		model.addAttribute("greatbuildings", listGreatBuildingByAge);
		return "gbs";
	}
	
	@GetMapping("/greatbuilding/{id}/gb")
	public String gb(@PathVariable("id") final Long id, Model model) {
		GreatBuilding gb = service.getGreatBuildingById(id);
		model.addAttribute("greatbuilding", gb);		
		Svg svg = getSvgFromGreatBuilding(gb);
		model.addAttribute("svg", svg);
		model.addAttribute("lines", svg.getLines());
		return "gb";
	}
	
	@GetMapping("/greatbuilding/{id}/lvl")
	public String lvlForm(@PathVariable("id") final Long id, Model model) {
		GreatBuilding gb = service.getGreatBuildingById(id);
		model.addAttribute("greatbuilding", gb);
		
		Level level = new Level();
		level.setLevelField(1);
		level.setP1BoostField(90.0f);
		level.setP2BoostField(90.0f);
		level.setP3BoostField(90.0f);
		level.setP4BoostField(90.0f);
		level.setP5BoostField(90.0f);
		model.addAttribute("level", level);
		
		Iterable<GreatBuildingReward> rewards = greatBuildingRewardService.getGreatBuildingRewards();
		GreatBuildingReward reward = new GreatBuildingReward();
		for (GreatBuildingReward greatBuildingReward : rewards) {
			if(greatBuildingReward.getAge().getId() == gb.getAge().getId() && greatBuildingReward.getLevel() == level.getLevelField()) {
				reward = greatBuildingReward;
			}
		}
		model.addAttribute("reward", reward);
		
		GreatBuildingReward boostedReward = new GreatBuildingReward();
		boostedReward.setAge(reward.getAge());
		boostedReward.setLevel(reward.getLevel());
		boostedReward.setTotal(reward.getTotal());
		boostedReward.setP1(reward.getP1());
		boostedReward.setP2(reward.getP2());
		boostedReward.setP3(reward.getP3());
		boostedReward.setP4(reward.getP4());
		boostedReward.setP5(reward.getP5());
		setBoostedReward(boostedReward, level);
		model.addAttribute("boostedReward", boostedReward);
		
		GreatBuildingRewardSecured rewardSecured = new GreatBuildingRewardSecured();
		rewardSecured.setReward(boostedReward);
		
		ArrayList<Integer> fpToSecure = rewardSecured.getArrayFpToSecure();
		int totalToSecure = 0;
		for (Integer fp : fpToSecure) {
			totalToSecure += fp;
		}
		totalToSecure += rewardSecured.getReward().getP5();
		rewardSecured.setFpToSecure(totalToSecure);
		model.addAttribute("fpToSecure", fpToSecure);
		model.addAttribute("lvlTotal", getLevelTotalString(rewardSecured.getFpToSecure(), boostedReward.getTotal()));
		
		Svg svg = getSvgFromGreatBuilding(gb);
		model.addAttribute("svg", svg);
		model.addAttribute("lines", svg.getLines());
		return "lvl";
	}
	
	@PostMapping("/greatbuilding/{id}/lvl")
	public String lvlSubmit(@PathVariable("id") final Long id, @ModelAttribute("level") Level level, Model model) {
		GreatBuilding gb = service.getGreatBuildingById(id);
		model.addAttribute("greatbuilding", gb);
		
		Iterable<GreatBuildingReward> rewards = greatBuildingRewardService.getGreatBuildingRewards();
		GreatBuildingReward reward = new GreatBuildingReward();
		for (GreatBuildingReward greatBuildingReward : rewards) {
			if(greatBuildingReward.getAge().getId() == gb.getAge().getId() && greatBuildingReward.getLevel() == level.getLevelField()) {
				reward = greatBuildingReward;
			}
		}
		model.addAttribute("reward", reward);
		
		GreatBuildingReward boostedReward = new GreatBuildingReward();
		boostedReward.setAge(reward.getAge());
		boostedReward.setLevel(reward.getLevel());
		boostedReward.setTotal(reward.getTotal());
		boostedReward.setP1(reward.getP1());
		boostedReward.setP2(reward.getP2());
		boostedReward.setP3(reward.getP3());
		boostedReward.setP4(reward.getP4());
		boostedReward.setP5(reward.getP5());
		setBoostedReward(boostedReward, level);
		model.addAttribute("boostedReward", boostedReward);
		
		GreatBuildingRewardSecured rewardSecured = new GreatBuildingRewardSecured();
		rewardSecured.setReward(boostedReward);
		
		ArrayList<Integer> fpToSecure = rewardSecured.getArrayFpToSecure();
		int totalToSecure = 0;
		for (Integer fp : fpToSecure) {
			totalToSecure += fp;
		}
		totalToSecure += rewardSecured.getReward().getP5();
		rewardSecured.setFpToSecure(totalToSecure);
		model.addAttribute("fpToSecure", fpToSecure);
		model.addAttribute("lvlTotal", getLevelTotalString(rewardSecured.getFpToSecure(), boostedReward.getTotal()));
		
		Svg svg = getSvgFromGreatBuilding(gb);
		model.addAttribute("svg", svg);
		model.addAttribute("lines", svg.getLines());
		return "lvl";
	}
	
	@GetMapping("/greatbuilding/{id}/rush")
	public String rushForm(@PathVariable("id") final Long id, Model model) {
		GreatBuilding gb = service.getGreatBuildingById(id);
		model.addAttribute("greatbuilding", gb);
		
		Rush rush = new Rush();
		rush.setStartLevelField(0);
		rush.setEndLevelField(10);
		rush.setOwnerField(Owner.Proprietaire);
		rush.setP1BoostField(90.0f);
		rush.setP2BoostField(90.0f);
		rush.setP3BoostField(90.0f);
		rush.setP4BoostField(90.0f);
		rush.setP5BoostField(90.0f);
		model.addAttribute("rush", rush);
		
		Iterable<GreatBuildingReward> greatBuildingRewards = greatBuildingRewardService.getGreatBuildingRewards();
		ArrayList<GreatBuildingReward> rewards = new ArrayList<>();
		for (GreatBuildingReward reward : greatBuildingRewards) {
			if(reward.getAge().getId() == gb.getAge().getId()) {
				if(reward.getLevel() > rush.getStartLevelField() && reward.getLevel() <= rush.getEndLevelField()) {
					rewards.add(reward);
				}
			}
		}
		
		TreeMap<Integer, GreatBuildingRewardSecured> rewardSecuredMap = new TreeMap<>();
		int total = 0;
		for (GreatBuildingReward reward : rewards) {
			GreatBuildingReward boostedReward = new GreatBuildingReward();
			boostedReward.setAge(reward.getAge());
			boostedReward.setLevel(reward.getLevel());
			boostedReward.setTotal(reward.getTotal());
			boostedReward.setP1(reward.getP1());
			boostedReward.setP2(reward.getP2());
			boostedReward.setP3(reward.getP3());
			boostedReward.setP4(reward.getP4());
			boostedReward.setP5(reward.getP5());
			total += boostedReward.getTotal();
			setBoostedReward(boostedReward, rush);
			GreatBuildingRewardSecured rewardSecured = new GreatBuildingRewardSecured();
			rewardSecured.setReward(boostedReward);
			int totalToSecure = 0;
			for (Integer fp : rewardSecured.getArrayFpToSecure()) {
				totalToSecure += fp;
			}
			totalToSecure += rewardSecured.getReward().getP5();
			rewardSecured.setFpToSecure(totalToSecure);
			rewardSecuredMap.put(rewardSecured.getReward().getLevel(), rewardSecured);
		}
		
		model.addAttribute("rewardSecuredMap", rewardSecuredMap);

		int totalToSecure = 0;
		for (Entry<Integer, GreatBuildingRewardSecured> entry : rewardSecuredMap.entrySet()) {
			GreatBuildingRewardSecured rewardSecured = entry.getValue();
			totalToSecure += rewardSecured.getFpToSecure();
		}
		model.addAttribute("rushTotal", getRushTotalString(totalToSecure, total));
		
		return "rush";
	}

	@PostMapping("/greatbuilding/{id}/rush")
	public String rushSubmit(@PathVariable("id") final Long id, @ModelAttribute("rush") Rush rush, Model model) {
		GreatBuilding gb = service.getGreatBuildingById(id);
		model.addAttribute("greatbuilding", gb);
		
		Iterable<GreatBuildingReward> greatBuildingRewards = greatBuildingRewardService.getGreatBuildingRewards();
		ArrayList<GreatBuildingReward> rewards = new ArrayList<>();
		for (GreatBuildingReward reward : greatBuildingRewards) {
			if(reward.getAge().getId() == gb.getAge().getId()) {
				if(reward.getLevel() > rush.getStartLevelField() && reward.getLevel() <= rush.getEndLevelField()) {
					rewards.add(reward);
				}
			}
		}
		
		TreeMap<Integer, GreatBuildingRewardSecured> rewardSecuredMap = new TreeMap<>();
		int total = 0;
		for (GreatBuildingReward reward : rewards) {
			GreatBuildingReward boostedReward = new GreatBuildingReward();
			boostedReward.setAge(reward.getAge());
			boostedReward.setLevel(reward.getLevel());
			boostedReward.setTotal(reward.getTotal());
			boostedReward.setP1(reward.getP1());
			boostedReward.setP2(reward.getP2());
			boostedReward.setP3(reward.getP3());
			boostedReward.setP4(reward.getP4());
			boostedReward.setP5(reward.getP5());
			total += boostedReward.getTotal();
			setBoostedReward(boostedReward, rush);
			GreatBuildingRewardSecured rewardSecured = new GreatBuildingRewardSecured();
			rewardSecured.setReward(boostedReward);
			int totalToSecure = 0;
			for (Integer fp : rewardSecured.getArrayFpToSecure()) {
				totalToSecure += fp;
			}
			totalToSecure += rewardSecured.getReward().getP5();
			rewardSecured.setFpToSecure(totalToSecure);
			rewardSecuredMap.put(rewardSecured.getReward().getLevel(), rewardSecured);
		}
		
		model.addAttribute("rewardSecuredMap", rewardSecuredMap);

		int totalToSecure = 0;
		for (Entry<Integer, GreatBuildingRewardSecured> entry : rewardSecuredMap.entrySet()) {
			GreatBuildingRewardSecured rewardSecured = entry.getValue();
			totalToSecure += rewardSecured.getFpToSecure();
		}
		model.addAttribute("rushTotal", getRushTotalString(totalToSecure, total));
		
		return "rush";
	}
	
	private Svg getSvgFromGreatBuilding(GreatBuilding greatbuilding) {
		Svg svg = new Svg();
		Short x = greatbuilding.getX();
		Short y = greatbuilding.getY();
		svg.setX(x);
		svg.setY(y);
		Short baseWidth = 40;
		Short baseHeight = 18;
		Short width = (short) (baseWidth * (x + y + 2));
		Short height = (short) (baseHeight * (x + y + 2));
		svg.setWidth(width);
		svg.setHeight(height);
		
		ArrayList<Line> lines = new ArrayList<Line>();
		for (int i = 0; i <= x; i++) {
			Line line = new Line();
			Short x1 = (short) ((y + 1) * baseWidth + (i * baseWidth));
			Short y1 = (short) ((height - (i * baseHeight)));
			Short x2 = (short) ((y + 1) * baseWidth - ((y - i) * baseWidth));
			Short y2 = (short) (height - ((y + i) * baseHeight));
			line.setX1(x1);
			line.setY1(y1);
			line.setX2(x2);
			line.setY2(y2);
			lines.add(line);
		}
		
		for (int i = 0; i <= y; i++) {
			Line line = new Line();
			Short x1 = (short) ((y + 1) * baseWidth - (i * baseWidth));
			Short y1 = (short) (height - (i * baseHeight));
			Short x2 = (short) ((y + 1) * baseWidth + ((x - i) * baseWidth));
			Short y2 = (short) (height - ((x + i) * baseHeight));
			line.setX1(x1);
			line.setY1(y1);
			line.setX2(x2);
			line.setY2(y2);
			lines.add(line);
		}
		
		svg.setLines(lines);
		
		return svg;
	}
	
	private void setBoostedReward(GreatBuildingReward reward, ArchBoost archBoost) {
		reward.setP1((int) (Math.round(reward.getP1() * (1 + archBoost.getP1BoostField()/100))));
		reward.setP2((int) (Math.round(reward.getP2() * (1 + archBoost.getP2BoostField()/100))));
		reward.setP3((int) (Math.round(reward.getP3() * (1 + archBoost.getP3BoostField()/100))));
		reward.setP4((int) (Math.round(reward.getP4() * (1 + archBoost.getP4BoostField()/100))));
		reward.setP5((int) (Math.round(reward.getP5() * (1 + archBoost.getP5BoostField()/100))));
	}
	
	private String getLevelTotalString(float totalToSecure, int total) {
		float percent = 100 * (totalToSecure / total);
		return "(" + String.format("%.0f", totalToSecure) + " PF à poser sur un total de " + total + " PF soit " + String.format("%.2f", percent) + "%)";
	}
	
	private String getRushTotalString(float totalToSecure, int total) {
		float percent = 100 * (totalToSecure / total);
		return "(" + String.format("%.0f", totalToSecure) + " PF à poser sur un total de " + total + " PF soit " + String.format("%.2f", percent) + "%)";
	}
}
