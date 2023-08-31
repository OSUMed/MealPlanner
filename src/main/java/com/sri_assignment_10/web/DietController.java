package com.sri_assignment_10.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return "mealplanner day";
	}

	@GetMapping("mealplanner/week")
	public String getWeekMeals(String numCalories, String diet, String exclusions) {
		return "mealplanner weel";

	}
}
