package com.staah.hotelmanagement.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class RoomTypeTest {

	@Test
	void testGetAndSetAvailibilityCount() {
		RoomType roomType= new RoomType();
		roomType.setAvailibilityCount(1);
		assertEquals(roomType.getAvailibilityCount(),1);
		
	}


	

	@Test
	void testSetAndGetCode() {
		RoomType roomType= new RoomType();
		roomType.setCode("SGL");
		assertEquals(roomType.getCode(),"SGL");
	}

	

	@Test
	void testSetAndGetDescription() {
		RoomType roomType= new RoomType();
		roomType.setDescription("Single Room");
		assertEquals(roomType.getDescription(),"Single Room");
	}

	@Test
	void testGetFeatures() {
		RoomType roomType = new RoomType();
		ArrayList<String> features = new ArrayList<String>();
		roomType.setFeatures(features);
		assertEquals(roomType.getFeatures().size(),0);
	}

	
	@Test
	void testGetAndSetAmenities() {
		RoomType roomType = new RoomType();
		ArrayList<String> amenities = new ArrayList<String>();
		roomType.setAmenities(amenities);
		assertEquals(roomType.getAmenities().size(),0);
		
	}

	

}
