package org.example;


import org.example.model.User;
import org.example.repository.BookingRepo;
import org.example.repository.HotelsRepo;
import org.example.model.Hotel;
import org.example.repository.UserRepo;
import org.example.service.BookingService;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");
        User u1 = new User("sayak",34);
        User u2 = new User("gourav",28);
        UserRepo userRepo = new UserRepo();
        HotelsRepo hotelsRepo = new HotelsRepo();
        BookingRepo bookingRepo = new BookingRepo();

        BookingService bs = new BookingService(bookingRepo, userRepo,hotelsRepo);

        userRepo.addUser(u1);
        userRepo.addUser(u2);

        Hotel h1 = new Hotel();
        h1.setName("PNR");
        h1.setAddress("HSR");
        h1.setFood("biryani");
        h1.setQuantity(10);
        h1.setRating(4);
        hotelsRepo.addHotel(h1);

        Hotel h2 = new Hotel();
        h2.setName("Meghna");
        h2.setAddress("Bellandur");
        h2.setFood("dossa");
        h2.setQuantity(5);
        h2.setRating(5);
        hotelsRepo.addHotel(h2);


        System.out.println("hotels sorted by ratings "+printSet(hotelsRepo.getHotelAsPerRating()));
        bs.book(u1,h1);
        bs.book(u1,h2);
    }
    private static String printSet(Set<Hotel> hotels){
        String res = "";
        for(Hotel h:hotels){
            res += h.getName()+" ";
        }
        return res;
    }
}