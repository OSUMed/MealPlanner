package com.meal_planner.domain;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekResponse {
	@JsonProperty("week")
	private Map<String, DayResponse> days;

	public Map<String, DayResponse> getDays() {
		return days;
	}

	public void setDays(Map<String, DayResponse> days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "Week [days=" + days + "]";
	}

}
