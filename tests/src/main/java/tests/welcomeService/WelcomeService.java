package tests.welcomeService;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	public String getWelcomeMessage(String name) {
		return String.format("Hello %s!", name);


	}
}
