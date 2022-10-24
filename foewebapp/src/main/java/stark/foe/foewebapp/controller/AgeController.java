package stark.foe.foewebapp.controller;

//import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.PathVariable;

import lombok.Data;
import stark.foe.foewebapp.model.Age;
//import stark.foe.foewebapp.model.GreatBuilding;
import stark.foe.foewebapp.service.AgeService;
import stark.foe.foewebapp.service.GreatBuildingService;

@Data
@Controller
public class AgeController {

	@Autowired
	private AgeService ageService;
	
	@Autowired
	private GreatBuildingService greatBuildingService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/ages")
	public String ages(Model model) {
		Iterable<Age> listAge = ageService.getAges();
		model.addAttribute("ages", listAge);
		return "ages";
	}
	
//	@GetMapping("/age/{id}")
//	public String age(@PathVariable("id") final Long id, Model model) {
//		Age age = ageService.getAge(id);
//		Iterable<GreatBuilding> listGreatBuilding = greatBuildingService.getGreatBuildings();
//		ArrayList<GreatBuilding> listGreatBuildingByAge = new ArrayList<>();
//		for (GreatBuilding greatBuilding : listGreatBuilding) {
//			if(greatBuilding.getAge().getId() == age.getId()) {
//				listGreatBuildingByAge.add(greatBuilding);
//			}
//		}
//		model.addAttribute("age", age);
//		model.addAttribute("greatbuildings", listGreatBuildingByAge);
//		return "age";
//	}
//	
//	@GetMapping("/createAge")
//	public String createAge(Model model) {
//		Age a = new Age();
//		model.addAttribute("age", a);
//		return "formNewAge";
//	}
//	
//	@GetMapping("/updateAge/{id}")
//	public String updateAge(@PathVariable("id") final Long id, Model model) {
//		Age a = ageService.getAge(id);		
//		model.addAttribute("age", a);	
//		return "formUpdateAge";		
//	}
//	
//	@GetMapping("/deleteAge/{id}")
//	public ModelAndView deleteAge(@PathVariable("id") final Long id) {
//		ageService.deleteAge(id);
//		return new ModelAndView("redirect:/");		
//	}
//	
//	@PostMapping("/saveAge")
//	public ModelAndView saveAge(@ModelAttribute Age age) {
//		ageService.saveAge(age);
//		return new ModelAndView("redirect:/");	
//	}
}
