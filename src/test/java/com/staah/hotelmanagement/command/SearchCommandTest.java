package com.staah.hotelmanagement.command;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.staah.hotelmanagement.createobject.CreateBookingObject;
import com.staah.hotelmanagement.createobject.CreateHotelObject;
import com.staah.hotelmanagement.dto.SearchResult;
import com.staah.hotelmanagement.model.ActualBooking;
import com.staah.hotelmanagement.model.Hotel;

class SearchCommandTest {

	@Test
	void testSearchQuery() {
		SearchCommand searchQuery = new SearchCommand();
		CreateHotelObject hotelObject = mock(CreateHotelObject.class);
		when(hotelObject.getHotelListFromJson()).thenReturn(new ArrayList<Hotel>());
		CreateBookingObject bookingObject = mock(CreateBookingObject.class);
		when(bookingObject.getActualBooking(new ArrayList<Hotel>())).thenReturn(new ArrayList<ActualBooking>());
		List<SearchResult> searchResult = searchQuery.searchQuery("H1", 5, "SGL");
		assertNotNull(searchResult);
	}

}
