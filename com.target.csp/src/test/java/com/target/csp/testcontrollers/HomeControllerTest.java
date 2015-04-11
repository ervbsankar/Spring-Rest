package com.target.csp.testcontrollers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.target.csp.controllers.HomeController;
import com.target.csp.entities.HomeEntry;
import com.target.csp.services.HomeEntryService;

public class HomeControllerTest {

	@InjectMocks
	private HomeController home;

	@Mock
	private HomeEntryService service;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(home).build();
	}

	/*@org.junit.Test
	public void TestPost() throws Exception {
		mockMvc.perform(
				post("/home").content(
						"{\"num\":\"123456\",\"title\":\"Test Blog Entry\"}")
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print());
	}

	@org.junit.Test
	public void TestGet() throws Exception {
		mockMvc.perform(get("/")).andDo(print());
	}*/

	@Test
	public void getExistingHomeEntry() throws Exception {
		HomeEntry entry = new HomeEntry();
		entry.setNum(1L);
		entry.setTitle("Test Title");

		when(service.find(1L)).thenReturn(entry);

		mockMvc.perform(get("/rest/Home-entries/1")).andDo(print());
	}
	
	@Test
	public void getNoneExistingHomeEntry() throws Exception {
		when(service.find(1L)).thenReturn(null);

		mockMvc.perform(get("/rest/Home-entries/1"))
		.andDo(print())
		.andExpect(status().isNotFound());
	}

}
