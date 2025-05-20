package com.staah.hotelmanagement.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookingTest {

	@Test
	void testGetAndHotelId() {
		Booking booking = new Booking();
		booking.setHotelId("H1");
		assertEquals(booking.getHotelId(), "H1");
	}

	@Test
	void testGetAndArrival() {
		Booking booking = new Booking();
		booking.setArrival("250903");
		assertEquals(booking.getArrival(), "250903");

	}

	@Test
	void testGetAndSetDeparture() {
		Booking booking = new Booking();
		booking.setDeparture("250903");
		assertEquals(booking.getDeparture(), "250903");
	}

	@Test
	void testGetAndSetRoomType() {
		Booking booking = new Booking();
		booking.setRoomType("DBL");
		assertEquals(booking.getRoomType(), "DBL");
	}

	@Test
	void testGetAndSetRoomRate() {
		Booking booking = new Booking();
		booking.setRoomRate("Standard");
		assertEquals(booking.getRoomRate(), "Standard");
	}

}
