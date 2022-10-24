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
import stark.foe.foewebapp.model.GreatBuildingReward;

@Slf4j
@Component
public class GreatBuildingRewardProxy {

	@Autowired
	private FoeCustomProperties props;
	
	public Iterable<GreatBuildingReward> getGreatBuildingRewards() {
		String baseApiUrl = props.getApiUrl();
		String getGreatBuildingRewardsUrl = baseApiUrl + "/greatbuildingrewards";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<GreatBuildingReward>> response = restTemplate.exchange(
				getGreatBuildingRewardsUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Iterable<GreatBuildingReward>>() {});
		
		log.debug("Get GreatBuildingRewards call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public GreatBuildingReward getGreatBuildingReward(Long id) {
		String baseApiUrl = props.getApiUrl();
		String getGreatBuildingRewardUrl = baseApiUrl + "/greatbuildingreward/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<GreatBuildingReward> response = restTemplate.exchange(
				getGreatBuildingRewardUrl,
				HttpMethod.GET,
				null,
				GreatBuildingReward.class);
		
		log.debug("Get GreatBuildingReward call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public GreatBuildingReward createGreatBuildingReward(GreatBuildingReward reward) {
		String baseApiUrl = props.getApiUrl();
		String createGreatBuildingRewardUrl = baseApiUrl + "/greatbuildingreward";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<GreatBuildingReward> request = new HttpEntity<GreatBuildingReward>(reward);
		ResponseEntity<GreatBuildingReward> response = restTemplate.exchange(
				createGreatBuildingRewardUrl,
				HttpMethod.POST,
				request,
				GreatBuildingReward.class);
		
		log.debug("Create GreatBuildingReward call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public GreatBuildingReward updateGreatBuildingReward(GreatBuildingReward reward) {
		String baseApiUrl = props.getApiUrl();
		String updateGreatBuildingRewardUrl = baseApiUrl + "/greatbuildingreward/" + reward.getId();
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<GreatBuildingReward> request = new HttpEntity<GreatBuildingReward>(reward);
		ResponseEntity<GreatBuildingReward> response = restTemplate.exchange(
				updateGreatBuildingRewardUrl,
				HttpMethod.PUT,
				request,
				GreatBuildingReward.class);
		
		log.debug("Update GreatBuildingReward call " + response.getStatusCode().toString());
		
		return response.getBody();
	}

	public void deleteGreatBuildingReward(Long id) {
		String baseApiUrl = props.getApiUrl();
		String deleteGreatBuildingRewardUrl = baseApiUrl + "/greatbuildingreward/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteGreatBuildingRewardUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete GreatBuildingReward call " + response.getStatusCode().toString());
	}
}
