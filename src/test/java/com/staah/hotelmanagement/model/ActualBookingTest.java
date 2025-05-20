package com.staah.hotelmanagement.model;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ActualBookingTest {

	@Test
	void testGetAndSetHotel() {
		ActualBooking actualBooking = new ActualBooking();
		Hotel hotel = new Hotel();
		hotel.setId("H1");
		actualBooking.setHotel(hotel);
		assertEquals(actualBooking.getHotel().getId(), "H1");
	}

	@Test
	void testGetAndSetBookingDates() {
		ActualBooking actualBooking = new ActualBooking();
		List<LocalDate> bookingDates = new ArrayList<LocalDate>();
		actualBooking.setBookingDates(bookingDates);
		assertEquals(actualBooking.getBookingDates().size(), 0);

	}

	@Test
	void testGetAndSetRoomType() {
		ActualBooking actualBooking = new ActualBooking();
		RoomType roomType = new RoomType();
		roomType.setAvailibilityCount(1);
		actualBooking.setRoomType(roomType);
		assertEquals(actualBooking.getRoomType().getAvailibilityCount(), 1);
	}

	@Test
	void testGetAndRoomRate() {
		ActualBooking actualBooking = new ActualBooking();
		actualBooking.setRoomRate("Standard");
		assertEquals(actualBooking.getRoomRate(), "Standard");

	}

}
