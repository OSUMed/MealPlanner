package com.sri_assignment_10.web;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sri_assignment_10.domain.Day;
import com.sri_assignment_10.domain.Meal;
import com.sri_assignment_10.domain.Week;
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
	public List<Meal> getDayMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories, 
			@RequestParam(value = "diet", required = false) String diet,
			@RequestParam(value = "exclude", required = false) String exclude) {
		URI uri = DietService.createUri(Integer.parseInt(numCalories), diet, exclude, "day");
		Day day = DietService.makeDayRequest(uri);
		return day.getMeals();
	}

	@GetMapping("mealplanner/week")
	public String getWeekMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories, 
			@RequestParam(value = "diet", required = false) String diet,
			@RequestParam(value = "exclude", required = false) String exclude) {
		URI uri = DietService.createUri(Integer.parseInt(numCalories), diet, exclude, "week");
		
		Week week = DietService.makeWeekRequest(uri);
		
		
		return "Return string";
	}
}
