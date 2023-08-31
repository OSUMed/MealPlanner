package com.sri_assignment_10.domain;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Week {
	@JsonProperty("week")
	private Map<String, Day> days;

	public Map<String, Day> getDays() {
		return days;
	}

	public void setDays(Map<String, Day> days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "Week [days=" + days + "]";
	}
	
}
