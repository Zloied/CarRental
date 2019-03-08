package com.vais;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//Test of MVC layer
@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc

public class RentalMvcTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void checkingLogInPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/login")).andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void checkingHomePage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/home")).andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void checkingRegistrationPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/registration")).andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void checkingContactPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/contacts")).andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void checkingAboutPage() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/about")).andDo(print()).andExpect(status().isOk());

	}
}
