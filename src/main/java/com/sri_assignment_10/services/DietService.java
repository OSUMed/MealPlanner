package com.sri_assignment_10.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sri_assignment_10.domain.DayResponse;
import com.sri_assignment_10.domain.WeekResponse;

public class DietService {

	@Value("${API.key}")
	private static String apiKey;

	public static URI createUri(Integer numCalories, String diet, String exclude, String timeFrame) {
//		System.out.println(apiKey);
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate").queryParam("apiKey", "a69a1ebb7d3b4f28a72e33a06f21a495")
				.queryParam("timeFrame", timeFrame);

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

	public static ResponseEntity<DayResponse> makeDayRequest(URI uri) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<DayResponse> responseString = rt.getForEntity(uri, DayResponse.class);
		System.out.println("Response is " + responseString.getBody());
		return responseString;
	}
	
	public static ResponseEntity<WeekResponse> makeWeekRequest(URI uri) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<WeekResponse> responseString = rt.getForEntity(uri, WeekResponse.class);
		System.out.println("Week Response is " + responseString.getBody());
		return responseString;
	}
}
