package com.staah.hotelmanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private String id;
	private String name;
	private List<RoomType> roomTypes;
	private List<Room> rooms;

	public List<RoomType> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<RoomType> roomType) {
		this.roomTypes = roomType;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
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
