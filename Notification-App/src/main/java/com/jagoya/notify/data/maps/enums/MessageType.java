package com.jagoya.notify.data.maps.enums;

/**
 * Represents the User type
 */
public enum MessageType {
	ALL("ALL"), ALUMNI("ALUMNI"), BUSINESS_PARTNER("BUSINESS_PARTNER"), EMPLOYEE(
			"EMPLOYEE"), PROSPECT_STUDENT("PROSPECT_STUDENT"), STUDENT(
			"STUDENT");

	private String description;

	private MessageType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
