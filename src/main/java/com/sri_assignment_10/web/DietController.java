package com.sri_assignment_10.web;

import java.net.URI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sri_assignment_10.domain.Day;
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
	public String getDayMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories, 
			@RequestParam(value = "diet", required = false) String diet,
			@RequestParam(value = "exclude", required = false) String exclude) {
//		System.out.println(numCalories + diet + exclude);
		URI uri = DietService.createUri(Integer.parseInt(numCalories), diet, exclude);
		Day res = DietService.makeRequest(uri);
		return "Hello";
	}

	@GetMapping("mealplanner/week")
	public String getWeekMeals(String numCalories, String diet, String exclusions) {
		return "mealplanner weel";

	}
}
