package stark.foe.foewebapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import stark.foe.foewebapp.config.FoeCustomProperties;
import stark.foe.foewebapp.model.GreatBuildingBoost;

@Slf4j
@Component
public class GreatBuildingBoostProxy {

	@Autowired
	private FoeCustomProperties props;
	
	public Iterable<GreatBuildingBoost> getGreatBuildingBoosts() {
		String baseApiUrl = props.getApiUrl();
		String getGreatBuildingBoostsUrl = baseApiUrl + "/greatbuildingboosts";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<GreatBuildingBoost>> response = restTemplate.exchange(
				getGreatBuildingBoostsUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Iterable<GreatBuildingBoost>>() {});
		
		log.debug("Get GreatBuildingBoosts call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public GreatBuildingBoost getGreatBuildingBoost(Long id) {
		String baseApiUrl = props.getApiUrl();
		String getGreatBuildingBoostUrl = baseApiUrl + "/greatbuildingboost/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<GreatBuildingBoost> response = restTemplate.exchange(
				getGreatBuildingBoostUrl,
				HttpMethod.GET,
				null,
				GreatBuildingBoost.class);
		
		log.debug("Get GreatBuildingBoost call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public GreatBuildingBoost createGreatBuildingBoost(GreatBuildingBoost boost) {
		String baseApiUrl = props.getApiUrl();
		String createGreatBuildingBoostUrl = baseApiUrl + "/greatbuildingboost";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<GreatBuildingBoost> request = new HttpEntity<GreatBuildingBoost>(boost);
		ResponseEntity<GreatBuildingBoost> response = restTemplate.exchange(
				createGreatBuildingBoostUrl,
				HttpMethod.POST,
				request,
				GreatBuildingBoost.class);
		
		log.debug("Create GreatBuildingBoost call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public GreatBuildingBoost updateGreatBuildingBoost(GreatBuildingBoost boost) {
		String baseApiUrl = props.getApiUrl();
		String updateGreatBuildingBoostUrl = baseApiUrl + "/greatbuildingboost/" + boost.getId();
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<GreatBuildingBoost> request = new HttpEntity<GreatBuildingBoost>(boost);
		ResponseEntity<GreatBuildingBoost> response = restTemplate.exchange(
				updateGreatBuildingBoostUrl,
				HttpMethod.PUT,
				request,
				GreatBuildingBoost.class);
		
		log.debug("Update GreatBuildingBoost call " + response.getStatusCode().toString());
		
		return response.getBody();
	}

	public void deleteGreatBuildingBoost(Long id) {
		String baseApiUrl = props.getApiUrl();
		String deleteGreatBuildingBoostUrl = baseApiUrl + "/greatbuildingboost/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteGreatBuildingBoostUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete GreatBuildingBoost call " + response.getStatusCode().toString());
	}
}
