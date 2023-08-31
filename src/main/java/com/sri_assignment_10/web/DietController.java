package com.sri_assignment_10.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sri_assignment_10.domain.DayResponse;
import com.sri_assignment_10.domain.WeekResponse;
import com.sri_assignment_10.services.DietService;

@RestController
public class DietController {

	@Autowired
	DietService dietService;

	@GetMapping("/test")
	public String testPoint() {
		return "This is the test point";
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories,
			@RequestParam(value = "diet", required = false) String diet,
			@RequestParam(value = "exclude", required = false) String exclude) {
		URI uri = dietService.createUri(Integer.parseInt(numCalories), diet, exclude, "day");
		ResponseEntity<DayResponse> dayResponse = DietService.makeDayRequest(uri);
		return dayResponse;
	}

	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories,
			@RequestParam(value = "diet", required = false) String diet,
			@RequestParam(value = "exclude", required = false) String exclude) {
		URI uri = dietService.createUri(Integer.parseInt(numCalories), diet, exclude, "week");
		ResponseEntity<WeekResponse> weekResponse = DietService.makeWeekRequest(uri);
		return weekResponse;
	}
}
