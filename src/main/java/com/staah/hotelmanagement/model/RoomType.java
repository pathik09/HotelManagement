package com.staah.hotelmanagement.model;

import java.util.ArrayList;

public class RoomType {
	private String code;
	private String description;
	private ArrayList<String> features;
	private ArrayList<String> amenities;
	private long availibilityCount;



	

	public long getAvailibilityCount() {
		return availibilityCount;
	}

	public void setAvailibilityCount(long availibilityCount) {
		this.availibilityCount = availibilityCount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<String> features) {
		this.features = features;
	}

	public ArrayList<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(ArrayList<String> amenities) {
		this.amenities = amenities;
	}
	

}
