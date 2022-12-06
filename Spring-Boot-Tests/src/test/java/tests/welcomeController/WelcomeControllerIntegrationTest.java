package tests.welcomeController;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import tests.welcomeService.WelcomeService;


@WebMvcTest
public class WelcomeControllerIntegrationTest {

	@Autowired private MockMvc mockMvc;


	@MockBean
	private WelcomeService welcomeService;
	@Test
	void shouldGetDefaultHelloMessage () throws Exception {
		when(welcomeService
				.getWelcomeMessage("you"))
		.thenReturn("Hello you!");
		mockMvc.perform(get("/welcome"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello you!")));
		verify(welcomeService).getWelcomeMessage("you");
	}

	@Test
	void shouldGetCustomHelloMessage () throws Exception {
		when(welcomeService
				.getWelcomeMessage("azerty"))
		.thenReturn("Hello azerty!");
		mockMvc.perform(get("/welcome?name=azerty"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello azerty!")));
		verify(welcomeService).getWelcomeMessage("azerty");
	}  



}
