package com.jagoya.notify.data.maps.enums;

/**
 * Represents the User type
 */
public enum Status {
	ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

	private String description;

	private Status(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
