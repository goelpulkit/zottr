package com.jagoya.notify.data.maps.enums;

/**
 * Represents the User type
 */
public enum UserType {
	ALUMNI("ALUMNI"), BUSINESS_PARTNER("BUSINESS_PARTNER"), EMPLOYEE("EMPLOYEE"), PROSPECT_STUDENT(
			"PROSPECT_STUDENT"), STUDENT("STUDENT");

	private String description;

	private UserType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
