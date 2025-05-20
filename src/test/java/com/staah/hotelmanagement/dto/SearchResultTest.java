package com.staah.hotelmanagement.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchResultTest {

	@Test
	void testSearchResult() {
		SearchResult searchResult = new SearchResult("", 0);
		assertNotNull(searchResult);
	}

	@Test
	void testGetAndSetDateRange() {
		SearchResult searchResult = new SearchResult();
		searchResult.setDateRange("DateRange");
		assertEquals(searchResult.getDateRange(), "DateRange");
	}

	@Test
	void testGetAndSetAvailibilityCount() {
		SearchResult searchResult = new SearchResult();
		searchResult.setAvailibilityCount(0);
		assertEquals(searchResult.getAvailibilityCount(), 0);

	}

}
