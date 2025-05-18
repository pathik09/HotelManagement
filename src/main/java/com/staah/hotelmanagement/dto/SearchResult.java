package com.staah.hotelmanagement.dto;

public class SearchResult {
	private String DateRange;
	private long availibilityCount;
	public SearchResult(String format, long l) {
		this.DateRange = format;
		this.availibilityCount = l;
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
	@Override
	public String toString() {
		return "SearchResult [DateRange=" + DateRange + ", availibilityCount=" + availibilityCount + "]";
	}
	

}
