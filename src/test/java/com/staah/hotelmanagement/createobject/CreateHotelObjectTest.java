package com.staah.hotelmanagement.createobject;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.staah.hotelmanagement.model.Booking;

class CreateHotelObjectTest {

	@Test
	void testGetHotelListFromJson() {
		CreateHotelObject hotelObject = Mockito.mock(CreateHotelObject.class);
		Gson gson = Mockito.mock(Gson.class);
		FileReader fileReader = Mockito.mock(FileReader.class);
		TypeToken type = Mockito.mock(TypeToken.class);
		Mockito.when(gson.fromJson(fileReader, type)).thenReturn(new ArrayList<Booking>());
		assertNotNull(hotelObject.getHotelListFromJson());
	}

}
