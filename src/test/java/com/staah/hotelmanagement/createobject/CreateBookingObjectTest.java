package com.staah.hotelmanagement.createobject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.staah.hotelmanagement.model.Hotel;

import com.staah.hotelmanagement.model.Booking;

class CreateBookingObjectTest {

	

	@Test
	void testGetActualBooking() {
		CreateBookingObject createBookingObject = Mockito.mock(CreateBookingObject.class);
        assertNotNull(createBookingObject.getActualBooking(new ArrayList<Hotel>()));
	}

}
