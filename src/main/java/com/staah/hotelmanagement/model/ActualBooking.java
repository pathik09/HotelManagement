package com.staah.hotelmanagement.model;

import java.time.LocalDate;
import java.util.List;

public class ActualBooking {
	private Hotel hotel;
    private List<LocalDate> bookingDates;
	private RoomType roomType;
	private String RoomRate;
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public ActualBooking(Hotel hotel,List<LocalDate> bookingDates, RoomType roomType,
			String roomRate) {
		super();
		this.hotel = hotel;
		this.bookingDates = bookingDates;
		this.roomType = roomType;
		RoomRate = roomRate;
	}
	
	public ActualBooking() {
		// TODO Auto-generated constructor stub
	}
	public List<LocalDate> getBookingDates() {
		return bookingDates;
	}
	public void setBookingDates(List<LocalDate> bookingDates) {
		this.bookingDates = bookingDates;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public String getRoomRate() {
		return RoomRate;
	}
	public void setRoomRate(String roomRate) {
		RoomRate = roomRate;
	}
	

}
