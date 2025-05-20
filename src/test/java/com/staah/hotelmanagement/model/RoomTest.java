package com.staah.hotelmanagement.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void testGetAndSetRoomType() {
		Room room = new Room();
		room.setRoomType("DBL");
		assertEquals(room.getRoomType(), "DBL");
	}

	@Test
	void testGetAndSetRoomId() {
		Room room = new Room();
		room.setRoomId("101");
		assertEquals(room.getRoomId(), "101");
	}

}
