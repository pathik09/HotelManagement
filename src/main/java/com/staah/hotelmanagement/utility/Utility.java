package com.staah.hotelmanagement.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Utility {
	public List<LocalDate> getDatesBetween(LocalDate startDate, LocalDate endDate) {
		List<LocalDate> dates = new ArrayList<>();
		long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
		for (int i = 0; i <= daysBetween; i++) {
			LocalDate date = startDate.plusDays(i);
			dates.add(date);
		}
		return dates;
	}

	public List<LocalDate> getDaterange(String arrival, String departure) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate arrivalDate = LocalDate.parse(arrival, formatter);
		LocalDate departureDate = LocalDate.parse(departure, formatter);

		return getDatesBetween(arrivalDate, departureDate);

	}
	public List<LocalDate> getDatesForDaysCount(int days){
		List<LocalDate> dates = new ArrayList<>();
		LocalDate startDate = LocalDate.now();
		
		
		for (int i = 0; i <= days; i++) {
			LocalDate date = startDate.plusDays(i);
			dates.add(date);
		}
		return dates;
		
	}

}
