package by.nexer.travelassistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TravelAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelAssistantApplication.class, args);
	}

}
