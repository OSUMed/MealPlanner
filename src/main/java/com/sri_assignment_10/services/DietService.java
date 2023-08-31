package com.sri_assignment_10.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class DietService {
	
	@Value("${API.key}")
	private String apiKey;
	
	public static URI createUri(Integer numCalories, String diet, String exclude) {
		
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
									  .queryParam("apiKey", apiKey)
									  .queryParam("numCalories", numCalories)
									  .queryParam("diet", diet)
									  .queryParam("exclude", exclude)
									  .build()
									  .toUri();
		return uri;
	}

	public static String makeRequest(URI uri) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> responseString = rt.getForEntity(uri, String.class);
		System.out.println(responseString.getBody());
		return "HellO";
	}
}
