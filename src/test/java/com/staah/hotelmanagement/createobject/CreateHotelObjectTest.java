package com.staah.hotelmanagement.createobject;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CreateHotelObjectTest {

	@Test
	void testGetHotelListFromJson() {
		CreateHotelObject hotelObject = new CreateHotelObject();
		assertNotNull(hotelObject.getHotelListFromJson());
	}

	

}
