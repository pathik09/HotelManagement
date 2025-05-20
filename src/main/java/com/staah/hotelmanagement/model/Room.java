package com.staah.hotelmanagement.model;

public class Room {
	private String roomId;

	public String getRoomType() {
		return roomType;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	private String roomType;

}
