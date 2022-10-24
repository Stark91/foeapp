package stark.foe.foeapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoeapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FoeapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Api started");
	}

}
