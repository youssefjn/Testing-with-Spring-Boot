package tests.welcomeController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tests.welcomeService.WelcomeService;

public class WelcomeControllerTest {
	@Test
	void shouldHello() {
		WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
		when(welcomeService.getWelcomeMessage("World")).thenReturn("Hello World!");
		WelcomeController welcomeController =  new WelcomeController(welcomeService);
		assertEquals("Hello World!", welcomeController.welcome("World"));
	}

}
