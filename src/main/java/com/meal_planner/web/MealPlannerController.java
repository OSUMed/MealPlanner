package com.meal_planner.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meal_planner.domain.DayResponse;
import com.meal_planner.domain.WeekResponse;
import com.meal_planner.services.MealPlannerService;

@RestController
public class MealPlannerController {

	@Autowired
	MealPlannerService mealPlannerService;

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories,
			@RequestParam(value = "diet", required = false) String diet,
			@RequestParam(value = "exclusions", required = false) String exclusions) {
		URI uri = mealPlannerService.createUri(caloriesStrToInt(numCalories), diet, exclusions, "day");
		ResponseEntity<DayResponse> dayResponse = mealPlannerService.makeDayRequest(uri);
		return dayResponse;
	}

	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam(value = "numCalories", required = false) String numCalories,
			@RequestParam(value = "diet", required = false) String diet,
			@RequestParam(value = "exclusions", required = false) String exclusions) {
		URI uri = mealPlannerService.createUri(caloriesStrToInt(numCalories), diet, exclusions, "week");
		ResponseEntity<WeekResponse> weekResponse = mealPlannerService.makeWeekRequest(uri);
		return weekResponse;
	}
	public Integer caloriesStrToInt(String numCalories) {
		Integer numCaloriesInt = null;
		if (numCalories != null) numCaloriesInt = Integer.parseInt(numCalories);
		return numCaloriesInt;
	}
}
