package com.staah.hotelmanagement.createobject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.staah.hotelmanagement.model.Hotel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.staah.hotelmanagement.model.Booking;

class CreateBookingObjectTest {

	@Test
	void testGetActualBooking() {

		CreateBookingObject createBookingObject = Mockito.mock(CreateBookingObject.class);
		Gson gson = Mockito.mock(Gson.class);
		FileReader fileReader = Mockito.mock(FileReader.class);
		TypeToken type = Mockito.mock(TypeToken.class);
		Mockito.when(gson.fromJson(fileReader, type)).thenReturn(new ArrayList<Booking>());
		assertNotNull(createBookingObject.getActualBooking(new ArrayList<Hotel>()));
	}

}
