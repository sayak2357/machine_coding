package org.example.service;

import org.example.model.Hotel;
import org.example.model.User;
import org.example.repository.BookingRepo;
import org.example.repository.HotelsRepo;
import org.example.repository.UserRepo;

public class BookingService {
    private BookingRepo bookingRepo;
    private HotelsRepo hotelsRepo;
    private UserRepo userRepo;

    public BookingService(BookingRepo bookingRepo, UserRepo userRepo, HotelsRepo hotelsRepo){
        this.bookingRepo = bookingRepo;
        this.userRepo = userRepo;
        this.hotelsRepo = hotelsRepo;
    }
    public boolean book(User user, Hotel hotel){
        if(userRepo.getUser(user.getName())==null)
        {
            System.out.printf("user doesn't exist");
            return false;
        }
        if(hotelsRepo.getHotel(hotel.getName())==null)
        {
            System.out.println("hotel doesn't exist");
            return false;
        }
        if(bookingRepo.addBooking(user.getName() ,hotel.getName())) {
            System.out.println("booked successfully");
            return true;
        }
        else{
            System.out.println(user.getName()+" has already booked at "+hotel.getName());
        }
        return false;
    }

    public User getUser(String name){
        return userRepo.getUser(name);
    }
    public Hotel getHotel(String name){
        return hotelsRepo.getHotel(name);
    }
}
