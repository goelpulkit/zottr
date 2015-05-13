package com.jagoya.notify.data.maps.enums;

/**
 * Represents the Gender type.
 */
public enum Gender {
	MALE("MALE"), FEMALE("FEMALE"), UNDEFINED("UNDEFINED");

	private String description;

	private Gender(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
