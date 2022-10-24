package stark.foe.foewebapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import stark.foe.foewebapp.config.FoeCustomProperties;
import stark.foe.foewebapp.model.GreatBuilding;

@Slf4j
@Component
public class GreatBuildingProxy {

	@Autowired
	private FoeCustomProperties props;
	
	public Iterable<GreatBuilding> getGreatBuildings() {
		String baseApiUrl = props.getApiUrl();
		String getGreatBuildingsUrl = baseApiUrl + "/greatbuildings";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<GreatBuilding>> response = restTemplate.exchange(
				getGreatBuildingsUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Iterable<GreatBuilding>>() {});
		
		log.debug("Get GreatBuildings call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Iterable<GreatBuilding> getGreatBuildingsByAge(Long id) {
		String baseApiUrl = props.getApiUrl();
		String getGreatBuildingsUrl = baseApiUrl + "/greatbuildings/age/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<GreatBuilding>> response = restTemplate.exchange(
				getGreatBuildingsUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Iterable<GreatBuilding>>() {});
		
		log.debug("Get GreatBuildings call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public GreatBuilding getGreatBuildingById(Long id) {
		String baseApiUrl = props.getApiUrl();
		String getGreatBuildingByIdUrl = baseApiUrl + "/greatbuilding/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<GreatBuilding> response = restTemplate.exchange(
				getGreatBuildingByIdUrl,
				HttpMethod.GET,
				null,
				GreatBuilding.class);
		
		log.debug("Get GreatBuilding by ID call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
//	public GreatBuilding createGreatBuilding(GreatBuilding gb) {
//		String baseApiUrl = props.getApiUrl();
//		String createGreatBuildingUrl = baseApiUrl + "/greatbuilding";
//		
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<GreatBuilding> request = new HttpEntity<GreatBuilding>(gb);
//		ResponseEntity<GreatBuilding> response = restTemplate.exchange(
//				createGreatBuildingUrl,
//				HttpMethod.POST,
//				request,
//				GreatBuilding.class);
//		
//		log.debug("Create GreatBuilding call " + response.getStatusCode().toString());
//		
//		return response.getBody();
//	}
//	
//	public GreatBuilding updateGreatBuilding(GreatBuilding gb) {
//		String baseApiUrl = props.getApiUrl();
//		String updateGreatBuildingUrl = baseApiUrl + "/greatbuilding/" + gb.getId();
//		
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<GreatBuilding> request = new HttpEntity<GreatBuilding>(gb);
//		ResponseEntity<GreatBuilding> response = restTemplate.exchange(
//				updateGreatBuildingUrl,
//				HttpMethod.PUT,
//				request,
//				GreatBuilding.class);
//		
//		log.debug("Update GreatBuilding call " + response.getStatusCode().toString());
//		
//		return response.getBody();
//	}
//
//	public void deleteGreatBuilding(Long id) {
//		String baseApiUrl = props.getApiUrl();
//		String deleteGreatBuildingUrl = baseApiUrl + "/greatbuilding/" + id;
//		
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Void> response = restTemplate.exchange(
//				deleteGreatBuildingUrl, 
//				HttpMethod.DELETE, 
//				null, 
//				Void.class);
//		
//		log.debug("Delete GreatBuilding call " + response.getStatusCode().toString());
//	}
}
