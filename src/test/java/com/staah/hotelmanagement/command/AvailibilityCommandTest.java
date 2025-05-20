package com.staah.hotelmanagement.command;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import com.staah.hotelmanagement.createobject.*;
import com.staah.hotelmanagement.model.ActualBooking;
import com.staah.hotelmanagement.model.Hotel;

class AvailibilityCommandTest {

	@Test
	void testQueryForAvailibility() {
		AvailibilityCommand availibilityCommand = mock(AvailibilityCommand.class);
		CreateHotelObject hotelObject = mock(CreateHotelObject.class);
		when(hotelObject.getHotelListFromJson()).thenReturn(new ArrayList<Hotel>());
		CreateBookingObject bookingObject = mock(CreateBookingObject.class);
		when(bookingObject.getActualBooking(new ArrayList<Hotel>())).thenReturn(new ArrayList<ActualBooking>());
		int availibility = availibilityCommand.queryForAvailibility("H1", "20250903", "SGL");
		assertEquals(0, availibility);
	}

}
