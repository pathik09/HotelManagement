package com.staah.hotelmanagement.command;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.staah.hotelmanagement.createobject.CreateBookingObject;
import com.staah.hotelmanagement.createobject.CreateHotelObject;

import com.staah.hotelmanagement.dto.SearchResult;
import com.staah.hotelmanagement.model.ActualBooking;
import com.staah.hotelmanagement.model.Hotel;
import com.staah.hotelmanagement.utility.Utility;

/**
 * 
 */
/**
 * 
 */
public class SearchCommand {
	File hotelFile = new File(this.getClass().getClassLoader().getResource("hotels.json").getFile());
	List<Hotel> hotelList = new ArrayList<Hotel>();
	Utility utility = new Utility();

	/**
	 * @param hotelId
	 * @param days
	 * @param roomType
	 * @return This method gives a result as a searchResultList as mentioned in the
	 *         requirement.
	 */
	public List<SearchResult> searchQuery(String hotelId, int days, String roomType)

	{
		CreateBookingObject bookingObject = new CreateBookingObject();
		CreateHotelObject hotelObject = new CreateHotelObject();
		List<Hotel> hotelList = hotelObject.getHotelListFromJson();// for getting hotellist from json.
		List<ActualBooking> actualBookingList = bookingObject.getActualBooking(hotelList);// for getting bookinglist
																							// from json
		List<LocalDate> enquiryDates = new ArrayList<LocalDate>();
		enquiryDates = utility.getDatesForDaysCount(days);

		List<LocalDate> bookingDates = new ArrayList<LocalDate>();
		for (ActualBooking ab : actualBookingList) {
			bookingDates.addAll(ab.getBookingDates());
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		List<SearchResult> searchResultList = new ArrayList<SearchResult>();
		Map<LocalDate, Long> frequencyBookingMap = bookingDates.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));// for getting the map of
																							// how many times the date
																							// is repeated.
		enquiryDates.stream().forEach(e -> {
			if (bookingDates.contains(e)) {
				SearchResult searchResult = new SearchResult(e.format(formatter),
						bookingObject.getRoomType(hotelId, roomType, hotelList).getAvailibilityCount()
								- frequencyBookingMap.get(e));
				searchResultList.add(searchResult);
			} else {
				SearchResult searchResult = new SearchResult(e.format(formatter),
						bookingObject.getRoomType(hotelId, roomType, hotelList).getAvailibilityCount());
				searchResultList.add(searchResult);

			}
		});// for getting the actual availibilityon the mentioned date
		AtomicInteger initialValue = new AtomicInteger(0);
		List<SearchResult> updatedSearchResultStream = new ArrayList<SearchResult>();
		IntStream.range(0, searchResultList.size()).forEach(i -> {

			if (i == searchResultList.size() - 1 || searchResultList.get(i).getAvailibilityCount() != searchResultList
					.get(i + 1).getAvailibilityCount())

			{

				SearchResult searchResult = new SearchResult(
						searchResultList.get(initialValue.get()).getDateRange() + "-"
								+ searchResultList.get(i).getDateRange(),
						searchResultList.get(i).getAvailibilityCount());
				updatedSearchResultStream.add(searchResult);
				if (i == searchResultList.size()) {

				} else {
					initialValue.set(i + 1);
				}
			}

		});// for converting the data to a desired state as required.
		updatedSearchResultStream.stream().forEach(searchResult -> {
			System.out.print("(" + searchResult.getDateRange() + "," + searchResult.getAvailibilityCount() + ")");

		});// for printing the data as per requirement.
		return searchResultList;

	}

}
