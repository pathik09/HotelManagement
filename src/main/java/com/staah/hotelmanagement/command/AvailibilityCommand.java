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



	/**
	 * @param hotelId
	 * @param dateRange
	 * @param roomType
	 * @return this function will return the availibility for the mentioned dateRange for a particular roomtype for the particular hotel in the input
	 */
	public int queryForAvailibility(String hotelId, String dateRange, String roomType) {
		
		ArrayList<Long> countList = new ArrayList<Long>();
		CreateBookingObject bookingObject = new CreateBookingObject();
		CreateHotelObject hotelObject = new CreateHotelObject();
		List<Hotel> hotelList = hotelObject.getHotelListFromJson();//for getting hotellist from json.
		List<ActualBooking> actualBookingList = bookingObject.getActualBooking(hotelList);//to get booking list from json

		List<LocalDate> enquiryDates = new ArrayList<LocalDate>();
		if (dateRange.contains("-")) {
			String[] dateList = dateRange.split("-");
			enquiryDates = utility.getDaterange(dateList[0], dateList[1]);//get the date range if the input contains-

		} else

		{
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate enquiryDate = LocalDate.parse(dateRange, formatter);
			enquiryDates.add(enquiryDate);//no need to get date range as single date is passed.
		}
		for (LocalDate date : enquiryDates) {
			countList.add(
					actualBookingList.stream().filter(abooking -> abooking.getRoomType().getCode().equals(roomType))
							.filter(abooking -> abooking.getBookingDates().contains(date)).count());
		}//thie will give the list of availibilities for the given dates.
		Long bookedCount = countList.stream().sorted(Comparator.reverseOrder()).findFirst().get();//we have to get the minimum of the list to give as a output.
		long AvailibilityCount = bookingObject.getRoomType(hotelId, roomType, hotelList).getAvailibilityCount();//we are getting the availibility count.
		return (int) (AvailibilityCount - bookedCount);//returning the availibility count which can even be negative, as mentioned in the requirement.

	}

}
