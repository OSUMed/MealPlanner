package com.meal_planner.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.meal_planner.domain.DayResponse;
import com.meal_planner.domain.WeekResponse;

@Service
public class MealPlannerService {

	@Value("${API.key}")
	private String apiKey;

	@Value("${spoonacular.urls.base}")
	private String base;

	@Value("${spoonacular.urls.mealplan}")
	private String mealPlan;

	public URI createUri(Optional<Integer> numCalories, Optional<String> diet, Optional<String> exclusions, String timeFrame) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder
				.fromHttpUrl(base+mealPlan).queryParam("apiKey", apiKey)
				.queryParam("timeFrame", timeFrame);

		numCalories.ifPresent(value -> uriBuilder.queryParam("targetCalories", value));
		diet.ifPresent(value -> uriBuilder.queryParam("diet", value));
		exclusions.ifPresent(value -> uriBuilder.queryParam("exclude", value));

		URI uri = uriBuilder.build().toUri();

		return uri;
	}

	public ResponseEntity<DayResponse> makeDayRequest(URI uri) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<DayResponse> responseString = rt.getForEntity(uri, DayResponse.class);
		return responseString;
	}

	public ResponseEntity<WeekResponse> makeWeekRequest(URI uri) {
		// TODO Auto-generated method stub
		RestTemplate rt = new RestTemplate();
		ResponseEntity<WeekResponse> responseString = rt.getForEntity(uri, WeekResponse.class);
		return responseString;
	}
	
	// Generic Version for practice:
	public <T> ResponseEntity<T> makeRequest(URI uri, Class<T> responseType) {
	    RestTemplate rt = new RestTemplate();
	    ResponseEntity<T> response = rt.getForEntity(uri, responseType);
	    return response;
	}
	// Then call via:
		// ResponseEntity<WeekResponse> weekResponse = makeRequest(uri, WeekResponse.class);
		// ResponseEntity<DayResponse> dayResponse = makeRequest(uri, DayResponse.class);


}
