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
//import stark.foe.foewebapp.model.GreatBuildingBoost;
//import stark.foe.foewebapp.service.GreatBuildingBoostService;

@Data
@Controller
public class GreatBuildingBoostController {

//	@Autowired
//	private GreatBuildingBoostService service;
//	//TODO revoir les url
//	@GetMapping("/")
//	public String home(Model model) {
//		Iterable<GreatBuildingBoost> listGreatBuildingBoost = service.getGreatBuildingBoosts();
//		model.addAttribute("boosts", listGreatBuildingBoost);
//		return "home";
//	}
//	
//	@GetMapping("/createGreatBuildingBoost")
//	public String createGreatBuildingBoost(Model model) {
//		GreatBuildingBoost boost = new GreatBuildingBoost();
//		model.addAttribute("boost", boost);
//		return "formNewGreatBuildingBoost";
//	}
//	
//	@GetMapping("/updateGreatBuildingBoost/{id}")
//	public String updateGreatBuildingBoost(@PathVariable("id") final Long id, Model model) {
//		GreatBuildingBoost boost = service.getGreatBuildingBoost(id);		
//		model.addAttribute("boost", boost);	
//		return "formUpdateGreatBuildingBoost";		
//	}
//	
//	@GetMapping("/deleteGreatBuildingBoost/{id}")
//	public ModelAndView deleteGreatBuildingBoost(@PathVariable("id") final Long id) {
//		service.deleteGreatBuildingBoost(id);
//		return new ModelAndView("redirect:/");		
//	}
//	
//	@PostMapping("/saveGreatBuildingBoost")
//	public ModelAndView saveGreatBuildingBoost(@ModelAttribute GreatBuildingBoost greatBuildingBoost) {
//		service.saveGreatBuildingBoost(greatBuildingBoost);
//		return new ModelAndView("redirect:/");	
//	}
}
