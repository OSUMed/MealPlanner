package com.sri_assignment_10.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sri_assignment_10.domain.DayResponse;
import com.sri_assignment_10.domain.WeekResponse;

@Service
public class DietService {

	@Value("${API.key}")
	private String apiKey;
	
	@Value("${spoonacular.urls.base}")
	private String base;
	
	@Value("${spoonacular.urls.mealplan}")
	private String mealPlan;

	public URI createUri(Integer numCalories, String diet, String exclusions, String timeFrame) {
		System.out.println("Api key is: " + apiKey);
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromHttpUrl(base+mealPlan).queryParam("apiKey", apiKey)
				.queryParam("timeFrame", timeFrame);

		if (numCalories != null) {
			uriBuilder.queryParam("targetCalories", numCalories);
		}

		if (diet != null) {
			uriBuilder.queryParam("diet", diet);
		}

		if (exclusions != null) {
			uriBuilder.queryParam("exclude", exclusions);
		}

		URI uri = uriBuilder.build().toUri();

		return uri;
	}

	public ResponseEntity<DayResponse> makeDayRequest(URI uri) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<DayResponse> responseString = rt.getForEntity(uri, DayResponse.class);
		System.out.println("Response is " + responseString.getBody());
		return responseString;
	}
	
	public ResponseEntity<WeekResponse> makeWeekRequest(URI uri) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<WeekResponse> responseString = rt.getForEntity(uri, WeekResponse.class);
		System.out.println("Week Response is " + responseString.getBody());
		return responseString;
	}
}
