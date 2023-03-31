package com.teletrac.navman.teletrac.navman;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teletrac.navman.teletrac.navman.model.Payload;

import ch.qos.logback.core.status.Status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void nocontentEndPoint() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/nocontent").content(asJsonString(new Payload()))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
				//.andExpect(status().isNoContent());
	}

	@Test
	public void echoEndPoint() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/echo").content(asJsonString(new Payload()))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));//.andExpect(status().isOK());
	}

	@Test
	public void deviceEndPoint() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/echo").content(asJsonString(new Payload()))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));//.andExpect(status().isOK());
	}

	@Test
	public void anyEndPoint() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/asd").content(asJsonString(new Payload()))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
				//.andExpect(status().isBadRequest());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
