package stark.foe.foewebapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "stark.foe.foewebapp")
@Data
public class FoeCustomProperties {

	private String apiUrl;

	public String getApiUrl() {
		return apiUrl;
	}
	
	public void setApiUrl(String url) {
		this.apiUrl = url;
	}
}
