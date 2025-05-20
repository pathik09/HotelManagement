package com.staah.hotelmanagement.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class HotelTest {

	@Test
	void testGetAndSetRoomTypes() {
		Hotel hotel = new Hotel();
		ArrayList<RoomType> listRoomType = new ArrayList<RoomType>();
		hotel.setRoomTypes(listRoomType);
		assertEquals(hotel.getRoomTypes().size(), 0);
	}

	@Test
	void testGetAndSetRooms() {
		Hotel hotel = new Hotel();
		ArrayList<Room> listRoom = new ArrayList<Room>();
		hotel.setRooms(listRoom);
		assertEquals(hotel.getRooms().size(), 0);
	}

	@Test
	void testGetAndSetId() {
		Hotel hotel = new Hotel();
		hotel.setId("H1");
		assertEquals(hotel.getId(), "H1");
	}

	@Test
	void testGetAndSetName() {
		Hotel hotel = new Hotel();
		hotel.setName("H1");
		assertEquals(hotel.getName(), "H1");
	}

}
