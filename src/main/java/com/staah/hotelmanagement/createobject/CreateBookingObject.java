package com.staah.hotelmanagement.createobject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.staah.hotelmanagement.model.ActualBooking;
import com.staah.hotelmanagement.model.Booking;
import com.staah.hotelmanagement.model.Hotel;
import com.staah.hotelmanagement.model.RoomType;
import com.staah.hotelmanagement.utility.Utility;

public class CreateBookingObject {
	File hotelFile = new File(this.getClass().getClassLoader().getResource("hotels.json").getFile());
	File bookingFile = new File(this.getClass().getClassLoader().getResource("bookings.json").getFile());
	List<ActualBooking> bookingList = new ArrayList<ActualBooking>();
	CreateHotelObject hotelObject = new CreateHotelObject();
	Utility utility = new Utility();

	public RoomType getRoomType(String hotelId, String roomRate, List<Hotel> hotelList) {
		Hotel hotel = hotelObject.getHotelById(hotelId, hotelList);
		return addAvailibilityCountToRoomType(
				hotel.getRoomTypes().stream().filter(r -> roomRate.equals(r.getCode())).findFirst().orElse(null),
				hotel);
	}

	private List<Booking> getBookingListFromJson() {
		List<Booking> bookings = new ArrayList<Booking>();
		try {
			Gson gson = new Gson();
			FileReader reader = new FileReader(bookingFile);
			Type listType = new TypeToken<List<Booking>>() {
			}.getType();

			bookings = gson.fromJson(reader, listType);
		} catch (FileNotFoundException e) {
			System.out.println("Booking.json not available");
		}
		return bookings;
	}

	private RoomType addAvailibilityCountToRoomType(RoomType roomType, Hotel hotel) {
		roomType.setAvailibilityCount(
				hotel.getRooms().stream().filter(room -> room.getRoomType().equals(roomType.getCode())).count());

		return roomType;
	}

	public List<ActualBooking> getActualBooking(List<Hotel> hotelList) {
		List<Booking> rawBookingList = getBookingListFromJson();
		return rawBookingList.stream()
				.map(rb -> new ActualBooking(hotelObject.getHotelById(rb.getHotelId(), hotelList),
						utility.getDaterange(rb.getArrival(), rb.getDeparture()),
						getRoomType(rb.getHotelId(), rb.getRoomType(), hotelList), rb.getRoomRate()))
				.toList();

	}
}
