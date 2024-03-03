package org.example;

import org.example.service.ParkingLotService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //System.out.println("Hello world!");
        ParkingLotService parkingLotService = null;
        while(true){
            String ip = sc.nextLine();
            String[] arr = ip.split(" ");
            String op = arr[0];
            if(op.equals("exit"))
                return;
            else if(op.equals("create_parking_lot_of_size")){
                Integer size = Integer.parseInt(arr[1]);
                if(parkingLotService!=null){
                    System.out.println("parking lot is already instantiated");
                }
                else{
                    parkingLotService = new ParkingLotService(size);
                }
            }
            else if(op.equals("park")){
                String registrationNumber = arr[1];
                String color = arr[2];
                parkingLotService.parkCar(registrationNumber,color);
            }
            else if(op.equals("free")){
                Integer slotToBeFreed = Integer.parseInt(arr[1]);
                parkingLotService.free(slotToBeFreed);
            }
            else if(op.equals("show"))
                parkingLotService.show();
            else if(op.equals("slow_number_for_registration_number")){
                String registrationNumber = arr[1];
                parkingLotService.findSlotNumberOfCarWithRegistrationNumber(registrationNumber);
            }
            else if(op.equals("slot_numbers_of_cars_with_color")){
                String color = arr[1];
                parkingLotService.findSlotsOfCarWithColor(color);
            }
        }
    }
}