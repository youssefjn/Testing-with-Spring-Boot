package tests.welcomeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tests.welcomeService.WelcomeService;

@RestController
public class WelcomeController {
	@Autowired
	WelcomeService welcomeService;

	public WelcomeController(WelcomeService welcomeService) {

		this.welcomeService = welcomeService;
	}

	@GetMapping("/welcome")
	public String welcome(@RequestParam(value = "name", defaultValue = "you") String name) {
		return welcomeService.getWelcomeMessage(name);
	}
}
