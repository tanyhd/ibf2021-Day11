package nus.edu.workshop11;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop11Application {
	public static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		//created new instance to as to change and process the arg pass in
		SpringApplication app = new SpringApplication(Workshop11Application.class);
		ApplicationArguments appArgs = new DefaultApplicationArguments(args);

		String portNumber = null;

		if(appArgs.containsOption("port")) {
			if(!appArgs.getOptionValues("port").isEmpty()) {
				portNumber = appArgs.getOptionValues("port").get(0);
			} else {
				portNumber = DEFAULT_PORT;
			}
		} else if (System.getenv("PORT") != null) {
			portNumber = System.getenv("PORT");
		} else {	
			portNumber = DEFAULT_PORT;
		}

		app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		app.run(args);
	}

}
