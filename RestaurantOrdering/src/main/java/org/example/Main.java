package org.example;


import org.example.model.User;
import org.example.repository.BookingRepo;
import org.example.repository.HotelsRepo;
import org.example.model.Hotel;
import org.example.repository.UserRepo;
import org.example.service.BookingService;

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
        hotelsRepo.addHotel(h1);

        Hotel h2 = new Hotel();
        h2.setName("Meghna");
        h2.setAddress("Bellandur");
        h2.setFood("dossa");
        h2.setQuantity(5);
        hotelsRepo.addHotel(h2);



        bs.book(u1,h1);
        bs.book(u1,h2);
    }
}