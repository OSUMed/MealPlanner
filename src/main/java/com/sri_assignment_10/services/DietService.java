package com.sri_assignment_10.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sri_assignment_10.domain.Day;

public class DietService {

	@Value("${API.key}")
	private static String apiKey;

	public static URI createUri(Integer numCalories, String diet, String exclude) {
//		System.out.println(apiKey);
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate").queryParam("apiKey", "a69a1ebb7d3b4f28a72e33a06f21a495")
				.queryParam("timeFrame", "day");

		if (numCalories != null) {
			uriBuilder.queryParam("numCalories", numCalories);
		}

		if (diet != null) {
			uriBuilder.queryParam("diet", diet);
		}

		if (exclude != null) {
			uriBuilder.queryParam("exclude", exclude);
		}

		URI uri = uriBuilder.build().toUri();

		return uri;
	}

	public static Day makeRequest(URI uri) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Day> responseString = rt.getForEntity(uri, Day.class);
		System.out.println("Response is " + responseString.getBody());
		return responseString.getBody();
	}
}
