package com.staah.hotelmanagement.createobject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.staah.hotelmanagement.model.Hotel;


public class CreateHotelObject {

	List<Hotel> hotelList = new ArrayList<Hotel>();

	File hotelFile = new File(this.getClass().getClassLoader().getResource("hotels.json").getFile());

	public List<Hotel> getHotelListFromJson() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		try {
			Gson gson = new Gson();
			FileReader reader = new FileReader(hotelFile);
			Type listType = new TypeToken<List<Hotel>>() {
			}.getType();
			hotels = gson.fromJson(reader, listType);
		} catch (FileNotFoundException e) {
			System.out.println("Hotels.json not available.");
		}
		return hotels;
	}

	public Hotel getHotelById(String hotelId, List<Hotel> hotelList) {
		return hotelList.stream().filter(h -> hotelId.equalsIgnoreCase(h.getId())).findFirst().orElse(null);

	}
	

}


