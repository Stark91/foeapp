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
import stark.foe.foewebapp.model.Age;

@Slf4j
@Component
public class AgeProxy {

	@Autowired
	private FoeCustomProperties props;
	
	public Iterable<Age> getAges() {
		String baseApiUrl = props.getApiUrl();
		String getAgesUrl = baseApiUrl + "/ages";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Age>> response = restTemplate.exchange(
				getAgesUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Iterable<Age>>() {});
		
		log.debug("Get Ages call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public Age getAge(Long id) {
		String baseApiUrl = props.getApiUrl();
		String getAgeUrl = baseApiUrl + "/age/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Age> response = restTemplate.exchange(
				getAgeUrl,
				HttpMethod.GET,
				null,
				Age.class);
		
		log.debug("Get Age call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
//	public Age createAge(Age a) {
//		String baseApiUrl = props.getApiUrl();
//		String createAgeUrl = baseApiUrl + "/age";
//		
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<Age> request = new HttpEntity<Age>(a);
//		ResponseEntity<Age> response = restTemplate.exchange(
//				createAgeUrl,
//				HttpMethod.POST,
//				request,
//				Age.class);
//		
//		log.debug("Create Age call " + response.getStatusCode().toString());
//		
//		return response.getBody();
//	}
//	
//	public Age updateAge(Age a) {
//		String baseApiUrl = props.getApiUrl();
//		String updateAgeUrl = baseApiUrl + "/age/" + a.getId();
//		
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<Age> request = new HttpEntity<Age>(a);
//		ResponseEntity<Age> response = restTemplate.exchange(
//				updateAgeUrl,
//				HttpMethod.PUT,
//				request,
//				Age.class);
//		
//		log.debug("Update Age call " + response.getStatusCode().toString());
//		
//		return response.getBody();
//	}
//
//	public void deleteAge(Long id) {
//		String baseApiUrl = props.getApiUrl();
//		String deleteAgeUrl = baseApiUrl + "/age/" + id;
//		
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<Void> response = restTemplate.exchange(
//				deleteAgeUrl, 
//				HttpMethod.DELETE, 
//				null, 
//				Void.class);
//		
//		log.debug("Delete Age call " + response.getStatusCode().toString());
//	}
}
