package stark.foe.foewebapp.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;

import lombok.Data;
//import stark.foe.foewebapp.model.GreatBuildingReward;
//import stark.foe.foewebapp.service.GreatBuildingRewardService;

@Data
@Controller
public class GreatBuildingRewardController {

//	@Autowired
//	private GreatBuildingRewardService service;
//	//TODO revoir les url
//	@GetMapping("/")
//	public String home(Model model) {
//		Iterable<GreatBuildingReward> listGreatBuildingReward = service.getGreatBuildingRewards();
//		model.addAttribute("greatbuildingrewards", listGreatBuildingReward);
//		return "home";
//	}
//	
//	@GetMapping("/createGreatBuildingReward")
//	public String createGreatBuildingReward(Model model) {
//		GreatBuildingReward reward = new GreatBuildingReward();
//		model.addAttribute("greatbuildingreward", reward);
//		return "formNewGreatBuildingReward";
//	}
//	
//	@GetMapping("/updateGreatBuildingReward/{id}")
//	public String updateGreatBuildingReward(@PathVariable("id") final Long id, Model model) {
//		GreatBuildingReward reward = service.getGreatBuildingReward(id);		
//		model.addAttribute("greatbuildingreward", reward);	
//		return "formUpdateGreatBuildingReward";		
//	}
//	
//	@GetMapping("/deleteGreatBuildingReward/{id}")
//	public ModelAndView deleteGreatBuildingReward(@PathVariable("id") final Long id) {
//		service.deleteGreatBuildingReward(id);
//		return new ModelAndView("redirect:/");		
//	}
//	
//	@PostMapping("/saveGreatBuildingReward")
//	public ModelAndView saveGreatBuildingReward(@ModelAttribute GreatBuildingReward greatBuildingReward) {
//		service.saveGreatBuildingReward(greatBuildingReward);
//		return new ModelAndView("redirect:/");	
//	}
}
