package org.example.repository;

import java.util.HashMap;
import java.util.Map;

public class BookingRepo {
    private Map<String, String> userHotelBookings;

    public BookingRepo(){
        userHotelBookings = new HashMap<>();
    }

    public boolean addBooking(String userName, String hotelName){
        if(userHotelBookings.containsKey(userName))
            return false;
        userHotelBookings.put(userName,hotelName);
        return true;
    }

}
