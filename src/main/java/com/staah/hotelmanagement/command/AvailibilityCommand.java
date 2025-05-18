package com.staah.hotelmanagement.command;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.staah.hotelmanagement.createobject.CreateBookingObject;
import com.staah.hotelmanagement.createobject.CreateHotelObject;
import com.staah.hotelmanagement.model.ActualBooking;
import com.staah.hotelmanagement.model.Hotel;
import com.staah.hotelmanagement.utility.Utility;

public class AvailibilityCommand {
	File hotelFile = new File(this.getClass().getClassLoader().getResource("hotels.json").getFile());
	List<Hotel> hotelList = new ArrayList<Hotel>();
	Utility utility = new Utility();



	public int queryForAvailibility(String hotelId, String dateRange, String roomType) {
		
		ArrayList<Long> countList = new ArrayList<Long>();
		CreateBookingObject bookingObject = new CreateBookingObject();
		CreateHotelObject hotelObject = new CreateHotelObject();
		List<Hotel> hotelList = hotelObject.getHotelListFromJson();
		List<ActualBooking> actualBookingList = bookingObject.getActualBooking(hotelList);

		List<LocalDate> enquiryDates = new ArrayList<LocalDate>();
		if (dateRange.contains("-")) {
			String[] dateList = dateRange.split("-");
			enquiryDates = utility.getDaterange(dateList[0], dateList[1]);

		} else

		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate enquiryDate = LocalDate.parse(dateRange, formatter);
			enquiryDates.add(enquiryDate);
		}
		for (LocalDate date : enquiryDates) {
			countList.add(
					actualBookingList.stream().filter(abooking -> abooking.getRoomType().getCode().equals(roomType))
							.filter(abooking -> abooking.getBookingDates().contains(date)).count());
		}
		Long bookedCount = countList.stream().sorted(Comparator.reverseOrder()).findFirst().get();
		long AvailibilityCount = bookingObject.getRoomType(hotelId, roomType, hotelList).getAvailibilityCount();
		return (int) (AvailibilityCount - bookedCount);

	}

}
