package org.example.repository;

import org.example.model.Hotel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HotelsRepo {
    private Map<String, Hotel> hotels;
    private Set<Hotel> hotelAsPerRating;


    public HotelsRepo(){

        hotels = new HashMap<>();
        hotelAsPerRating = new TreeSet<>((a, b) -> b.getRating()-a.getRating() );
    }

    public boolean addHotel(Hotel newHotel){
        if(hotels.containsKey(newHotel.getName()))
            return false;
        hotels.put(newHotel.getName(),newHotel);
        hotelAsPerRating.add(newHotel);
        return true;
    }
    public Hotel getHotel(String name){
        if(!hotels.containsKey(name))
            return null;
        return hotels.get(name);
    }
    public Set<Hotel> getHotelAsPerRating(){
        return hotelAsPerRating;
    }
}
