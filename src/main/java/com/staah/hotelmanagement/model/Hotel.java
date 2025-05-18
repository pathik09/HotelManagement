package com.staah.hotelmanagement.model;

import java.util.ArrayList;

public class Hotel {
	private String id;
	private String name;
	private ArrayList<RoomType> roomTypes;
	private ArrayList<Room> rooms;
	public ArrayList<RoomType> getRoomTypes() {
	return roomTypes;
}
public void setRoomTypes(ArrayList<RoomType> roomTypes) {
	this.roomTypes = roomTypes;
}
public ArrayList<Room> getRooms() {
	return rooms;
}
public void setRooms(ArrayList<Room> rooms) {
	this.rooms = rooms;
}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
