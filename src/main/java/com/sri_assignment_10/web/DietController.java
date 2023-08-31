package com.sri_assignment_10.web;

import java.net.URI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sri_assignment_10.services.DietService;

@RestController
public class DietController {
	@GetMapping("/test")
	public String testPoint() {
		return "This is the test point";
	}
	@GetMapping("/")
	public String hey() {
		System.out.println("Triggered root endpoint!");
		return "This is root";
	}

	@GetMapping("mealplanner/day")
	public String getDayMeals(String numCalories, String diet, String exclusions) {
		
		URI uri = DietService.createUri(Integer.parseInt(numCalories), diet, exclusions);
		String res = DietService.makeRequest(uri);
		return res;
	}

	@GetMapping("mealplanner/week")
	public String getWeekMeals(String numCalories, String diet, String exclusions) {
		return "mealplanner weel";

	}
}
