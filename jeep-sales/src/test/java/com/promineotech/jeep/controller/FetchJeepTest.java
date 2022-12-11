package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.promineotech.jeep.controller.support.FetchJeepTestSupport;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

class FetchJeepTest extends FetchJeepTestSupport{

	@Test
	void testThatJeepsAreReturnedWhenValidModelAndTrimAreSuplied() {
		//System.out.println(getBaseUri());
		
		
		//Given: a valid model, trim and uri
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = 
				String.format("%s?model=%s&trim=%s", 
						getBaseUri(), model, trim);
		//String.format("http://localhost:%d/jeeps?model=%s&trim=%s", 
		//		serverPort, model, trim);
		System.out.println(uri);
		
		//When: a connection is made to the UrI
		ResponseEntity<Jeep> response =
				getRestTemplate().getForEntity(uri, Jeep.class);
		
		//ResponseEntity<List<Jeep>> response = restTemplate.exchange(uri, 
		//			HttpMethod.GET, null, 
		//			new ParameterizedTypeReference<>() {});
		//Then a success(ok -200) status is returned
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
	}

}
