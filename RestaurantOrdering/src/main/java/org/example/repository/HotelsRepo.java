package org.example.repository;

import org.example.model.Hotel;

import java.util.HashMap;
import java.util.Map;

public class HotelsRepo {
    private Map<String, Hotel> hotels;


    public HotelsRepo(){
        hotels = new HashMap<>();
    }

    public boolean addHotel(Hotel newHotel){
        if(hotels.containsKey(newHotel.getName()))
            return false;
        hotels.put(newHotel.getName(),newHotel);
        return true;
    }
    public Hotel getHotel(String name){
        if(!hotels.containsKey(name))
            return null;
        return hotels.get(name);
    }
}
