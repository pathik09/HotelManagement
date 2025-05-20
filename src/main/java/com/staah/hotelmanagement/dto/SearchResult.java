package com.staah.hotelmanagement.dto;

public class SearchResult {
	private String DateRange;
	private long availibilityCount;

	public SearchResult(String dateRange, long availibilityCount) {
		this.DateRange = dateRange;
		this.availibilityCount = availibilityCount;
	}

	public SearchResult() {
		// TODO Auto-generated constructor stub
	}

	public String getDateRange() {
		return DateRange;
	}

	public void setDateRange(String dateRange) {
		DateRange = dateRange;
	}

	public long getAvailibilityCount() {
		return availibilityCount;
	}

	public void setAvailibilityCount(long availibilityCount) {
		this.availibilityCount = availibilityCount;
	}

}
