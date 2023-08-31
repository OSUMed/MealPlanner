package com.sri_assignment_10.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Nutrients {

	@JsonProperty("calories")
	private Double calories;

	@JsonProperty("protein")
	private Double protein;

	@JsonProperty("fat")
	private Double fat;

	@JsonProperty("carbohydrates")
	private Double carbohydrates;

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public Double getFat() {
		return fat;
	}

	public void setFat(Double fat) {
		this.fat = fat;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	@Override
	public String toString() {
		return "Nutrients [calories=" + calories + ", protein=" + protein + ", fat=" + fat + ", carbohydrates="
				+ carbohydrates + "]";
	}

}
