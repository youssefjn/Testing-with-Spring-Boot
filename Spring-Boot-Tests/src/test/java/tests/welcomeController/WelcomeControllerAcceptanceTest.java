package tests.welcomeController;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class WelcomeControllerAcceptanceTest {
	@Autowired 
	private MockMvc mockMvc;


	@Test
	void shouldGetDefaultHelloMessage () throws Exception {
		mockMvc.perform(get("/welcome"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello you!")));
	}

	@Test
	void shouldGetCustomHelloMessage () throws Exception {

		mockMvc.perform(get("/welcome?name=azerty"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("Hello azerty!")));

	}  

}
