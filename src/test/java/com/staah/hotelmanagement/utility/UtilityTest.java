package com.staah.hotelmanagement.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class UtilityTest {

	@Test
	void testGetDatesBetween() {
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.now();
		Utility utility = new Utility();
		List<LocalDate> dateList = utility.getDatesBetween(date1, date2);
		assertNotNull(dateList);

	}

	@Test
	void testGetDaterange() {
		String date1 = "20250507";
		String date2 = "20250509";
		Utility utility = new Utility();
		List<LocalDate> dateList = utility.getDaterange(date1, date2);
		assertNotNull(dateList);

	}

	@Test
	void testGetDatesForDaysCount() {
		Utility utility = new Utility();
		List<LocalDate> dateList = utility.getDatesForDaysCount(2);
		assertNotNull(dateList);

	}

}
